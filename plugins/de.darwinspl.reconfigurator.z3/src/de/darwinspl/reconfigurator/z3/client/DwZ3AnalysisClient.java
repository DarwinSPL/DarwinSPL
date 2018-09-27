package de.darwinspl.reconfigurator.z3.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.UUID;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.IntExpr;
import com.microsoft.z3.Model;
import com.microsoft.z3.Solver;
import com.microsoft.z3.Status;
import com.microsoft.z3.Symbol;
import com.microsoft.z3.enumerations.Z3_lbool;

import de.darwinspl.reconfigurator.z3.DwZ3ParserClient;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.reconfigurator.input.format.Attribute;
import eu.hyvar.reconfigurator.input.format.InputForHyVarRec;

/**
 * 
 * @author Anna-Liisa
 * 
 * 
 * Client to analyse feature model using Z3 solver
 * 
 *
 */
public class DwZ3AnalysisClient {

	private InputForHyVarRec inputForHyVarRec;

	public void checkFeatures(InputForHyVarRec input, HyFeatureModel featureModel, Boolean featuresAsBoolean) {

		inputForHyVarRec = input;

		checkFeaturesWithEvolution(featureModel, featuresAsBoolean);

	}

	public void checkFeaturesWithEvolution(HyFeatureModel featureModel, Boolean featuresAsBoolean) {

		List<String> optionals = new ArrayList<String>();

		for (String opf : inputForHyVarRec.getOptional_features().keySet()) {
			optionals.add(opf);

		}

		String timeContext = getTimeContext(inputForHyVarRec);
		startZ3FeatureAnalysisWithEvolutionAttributesAndContexts(featureModel, inputForHyVarRec, optionals, timeContext);

		return;

	}

	private String getTimeContext(InputForHyVarRec inputForHyVarRec) {
		String timeContext = inputForHyVarRec.getTime_context();

		if (timeContext == null || timeContext == "") {

			timeContext = "_" + UUID.randomUUID().toString();

			List<Integer> l = new ArrayList<Integer>();
			l.add(0);
			l.add(0);

			for (Entry<String, List<List<Integer>>> entry : inputForHyVarRec.getOptional_features().entrySet()) {

				entry.getValue().add(l);

			}
		}
		return timeContext;
	}

	private List<Expr> getBasicFormulaList(List<String> featureIds, List<Attribute> attributes,
			List<eu.hyvar.reconfigurator.input.format.Context> contexts, Expr[] z3Constraints,
			boolean featuresAsBoolean, Context context) {

	
		List<Expr> formulas = new ArrayList<Expr>();

		if (!featuresAsBoolean) {

			for (String feature : featureIds) {

				formulas.add(context.mkLe(context.mkInt(0), context.mkIntConst(feature)));
				formulas.add(context.mkLe(context.mkIntConst(feature), context.mkInt(1)));
			}

		}

		for (Attribute attribute : attributes) {
			
			String aId = attribute.getId();
			aId = aId.replace("attribute[", "");
			
			aId  = aId.substring(0, aId.length()-1);
			

			formulas.add(context.mkLe(context.mkInt(attribute.getMin()), context.mkIntConst(aId)));
			formulas.add(context.mkLe(context.mkIntConst(aId), context.mkInt(attribute.getMax())));

		}

		for (eu.hyvar.reconfigurator.input.format.Context c : contexts) {

			String name = c.getId();
			name = name.replace("context[", "");

			name = name.substring(0, name.length() - 1);

			formulas.add(context.mkLe(context.mkInt(c.getMin()), context.mkIntConst(name)));
			formulas.add(context.mkLe(context.mkIntConst(name), context.mkInt(c.getMax())));

		}

		for (Expr expr : z3Constraints) {
			formulas.add(expr);
		}

		return formulas;

	}

	private DwZ3CheckFeaturesResult startZ3FeatureAnalysisWithEvolutionAttributesAndContexts(HyFeatureModel featureModel, InputForHyVarRec inputForHyVarRec,
			List<String> stringOptionals, String timeContext) {
		HashMap<String, String> cfg = new HashMap<String, String>();
		Context ctx = new Context(cfg);

		Solver solver = ctx.mkSolver();

		DwZ3ParserClient dwZ3ParserClient2 = new DwZ3ParserClient();

		BoolExpr[] constraints = (BoolExpr[]) dwZ3ParserClient2.parseConstraints(inputForHyVarRec.getConstraints(), ctx,
				true);

		boolean isTimeContextInContexts = false;
		eu.hyvar.reconfigurator.input.format.Context timeContextInContexts = null;

		List<eu.hyvar.reconfigurator.input.format.Context> inputContexts = inputForHyVarRec.getContexts();

		for (eu.hyvar.reconfigurator.input.format.Context c : inputContexts) {
			if (c.getId().equals("context[" + timeContext + "]")) {
				isTimeContextInContexts = true;
				timeContextInContexts = c;

			}
		}

		if (isTimeContextInContexts) {

			String name = timeContextInContexts.getId();
			name = name.replace("context[", "");

			name = name.substring(0, name.length() - 1);

			solver.add(ctx.mkLe(ctx.mkInt(timeContextInContexts.getMin()), ctx.mkIntConst(name)));
			solver.add(ctx.mkLe(ctx.mkIntConst(name), ctx.mkInt(timeContextInContexts.getMax())));

		} else {
			solver.add(ctx.mkLe(ctx.mkInt(-1), ctx.mkIntConst(timeContext)));
			solver.add(ctx.mkLe(ctx.mkIntConst(timeContext), ctx.mkInt(0)));
		}

		List<String> stringFeatures = dwZ3ParserClient2.getFeatures();
		BoolExpr[] optionalFeaturesWithoutNameChange = new BoolExpr[stringOptionals.size()];

		BoolExpr[] features = new BoolExpr[stringFeatures.size()];
		Symbol[] featureNames = new Symbol[stringFeatures.size()];

		int i = 0;
		int j = 0;
		for (String f : stringFeatures) {
			featureNames[i] = ctx.mkSymbol(f);
			features[i] = (BoolExpr) ctx.mkConst(featureNames[i], ctx.getBoolSort());

			if (stringOptionals.contains(f)) {

				optionalFeaturesWithoutNameChange[j] = features[i];
				j++;
			}
			i++;

		}

		Expr[] testFor = getTextForZ3Object(ctx, inputContexts, features, isTimeContextInContexts,
				timeContextInContexts, inputForHyVarRec.getAttributes());

		List<Expr> formulasList = getBasicFormulaList(stringFeatures, inputForHyVarRec.getAttributes(), inputContexts,
				constraints, true, ctx);

		BoolExpr[] formulas = null;

		if (isTimeContextInContexts) {
			formulas = new BoolExpr[formulasList.size()];

			int k = 0;
			for (Expr e : formulasList) {
				formulas[k] = (BoolExpr) e;
				k++;
			}
		} else {
			formulas = new BoolExpr[formulasList.size() + 2];

			int k = 0;
			for (Expr e : formulasList) {
				formulas[k] = (BoolExpr) e;
				k++;
			}

			formulas[k] = ctx.mkLe(ctx.mkInt(0), ctx.mkIntConst(timeContext));
			k++;
			formulas[k] = ctx.mkLe(ctx.mkIntConst(timeContext), ctx.mkInt(0));

		}

		

		BoolExpr[] optionalFeatures = new BoolExpr[optionalFeaturesWithoutNameChange.length];

		i = 0;
		for (BoolExpr opF : optionalFeaturesWithoutNameChange) {
			BoolExpr feature = ctx.mkBoolConst(opF + "_v");
			optionalFeatures[i] = feature;
			i++;

		}

		solver.add(ctx.mkAtLeast(optionalFeatures, 1));
		solver.add(ctx.mkAtMost(optionalFeatures, 1));

		

		for (Entry<String, List<List<Integer>>> entry : inputForHyVarRec.getOptional_features().entrySet()) {

			BoolExpr[] ls = new BoolExpr[entry.getValue().size() * 2];

			int g = 0;

			for (List<Integer> k : entry.getValue()) {
				ls[g] = ctx.mkGe(ctx.mkIntConst(timeContext), ctx.mkInt(k.get(0)));
				g++;
				ls[g] = ctx.mkLe(ctx.mkIntConst(timeContext), ctx.mkInt(k.get(1)));
				g++;
			}

			solver.add(ctx.mkImplies(ctx.mkBoolConst(entry.getKey() + "_v"), ctx.mkAnd(ls)));

		}

		solver.push();

		List<DwZ3FeatureAnomaly> deadFeatures = searchForDeadFeaturesEvolution(featureModel, ctx, solver, testFor,
				optionalFeaturesWithoutNameChange, formulas, optionalFeaturesWithoutNameChange, timeContext);

		solver.pop();

		List<DwZ3FeatureAnomaly> voidFeatures = searchForVoidFeatureEvolution(featureModel, ctx, solver, testFor,
				optionalFeaturesWithoutNameChange, formulas, optionalFeaturesWithoutNameChange, timeContext);
	
		
		for(DwZ3FeatureAnomaly df: deadFeatures) {
			System.err.println("Found DeadFeature: " + df.getFeature().getNames().get(0).getName()+ ": For time: " + df.getFoundContexts().toString());
		}
		for(DwZ3FeatureAnomaly df: voidFeatures) {
			System.err.println("Found VoidFeature: " +  df.getFeature().getNames().get(0).getName() + ": For time: " + df.getFoundContexts().toString());
		}
		
		DwZ3CheckFeaturesResult result = new DwZ3CheckFeaturesResult();
		result.setDeadFeatures(deadFeatures);
		result.setVoidFeatures(voidFeatures);
		
		return result;
	
	}

	private Expr[] getTextForZ3Object(Context ctx, List<eu.hyvar.reconfigurator.input.format.Context> inputContexts,
			BoolExpr[] features, boolean isTimeContextInContexts,
			eu.hyvar.reconfigurator.input.format.Context timeContextInContexts, List<Attribute> inputAttributes) {

		int i;
		int size = 0;
		int sizeAttributes = 0;
		
		if(inputAttributes!=null && inputAttributes.size() != 0) {
			sizeAttributes = inputAttributes.size();
		}

		if (isTimeContextInContexts) {
			size = inputContexts.size() - 1;
		} else {
			size = inputContexts.size();
		}

		Expr[] testFor = null;

		if (size > 1) {
			IntExpr[] contexts = new IntExpr[size];

			Symbol[] contextNames = new Symbol[size];

			i = 0;

			for (eu.hyvar.reconfigurator.input.format.Context f : inputContexts) {
				if (!isTimeContextInContexts || !f.getId().equals(timeContextInContexts.getId())) {

					String name = f.getId();
					name = name.replace("context[", "");

					name = name.substring(0, name.length() - 1);

					contextNames[i] = ctx.mkSymbol(name);
					contexts[i] = (IntExpr) ctx.mkConst(contextNames[i], ctx.getIntSort());

					i++;
				}

			}

			i = 0;

			testFor = new Expr[(size + features.length)+ sizeAttributes];

			for (Expr f : features) {
				testFor[i] = f;
				i++;
			}
			for (Expr f : contexts) {
				testFor[i] = f;
				i++;
			}
			
			if(sizeAttributes != 0) {
				for(Attribute attribute: inputAttributes) {
					String aId = attribute.getId();
					aId = aId.replace("attribute[", "");
					
					aId  = aId.substring(0, aId.length()-1);
					testFor[i] = ctx.mkConst(ctx.mkSymbol(aId), ctx.getIntSort());
					i++;
				}
				}

		} else {

			i = 0;
			testFor = new Expr[features.length + size+ sizeAttributes];
			for (Expr f : features) {
				testFor[i] = f;
				i++;
			}
			for (eu.hyvar.reconfigurator.input.format.Context c : inputContexts) {

				if (!isTimeContextInContexts || !c.getId().equals(timeContextInContexts.getId())) {
					String name = c.getId();
					name = name.replace("context[", "");

					name = name.substring(0, name.length() - 1);
					testFor[i] = ctx.mkConst(ctx.mkSymbol(name), ctx.getIntSort());
					i++;
				}

			}
			if(sizeAttributes != 0) {
			for(Attribute attribute: inputAttributes) {
				String aId = attribute.getId();
				aId = aId.replace("attribute[", "");
				
				aId  = aId.substring(0, aId.length()-1);
				testFor[i] = ctx.mkConst(ctx.mkSymbol(aId), ctx.getIntSort());
				i++;
			}
			}

		}
		return testFor;
	}

	private List<DwZ3FeatureAnomaly> searchForDeadFeaturesEvolution(HyFeatureModel featureModel, Context ctx, Solver solver, Expr[] testFor,
			BoolExpr[] optionalFeaturesWithoutNameChange, BoolExpr[] constraints, BoolExpr[] optionalFeatures,
			String timeContext) {

		List<DwZ3FeatureAnomaly> deadFeatures = new ArrayList<DwZ3FeatureAnomaly>();

		BoolExpr forAll = buildForAllFormulaDeadFeatures(ctx, constraints, testFor, optionalFeaturesWithoutNameChange);

//		System.out.println(forAll.toString());

		solver.add(forAll);

		while (true) {
			Status status = solver.check();

			if (status.equals(Status.SATISFIABLE)) {

				Model model = solver.getModel();

				for (BoolExpr feature : optionalFeatures) {

					if (model.eval(ctx.mkBoolConst(feature + "_v"), true).getBoolValue().equals(Z3_lbool.Z3_L_TRUE)) {

						IntExpr foundContext = (IntExpr) model.getConstInterp(ctx.mkIntConst(timeContext));

//						System.err.println("Found dead Feature: " + feature + " for time: " + foundContext);

						int fou = (int) Integer.valueOf(foundContext.toString());

						boolean containedInDeadFeatureList = false;

						for (DwZ3FeatureAnomaly deadFeature : deadFeatures) {

							if (deadFeature.getId().equals(feature.getSExpr())) {
								deadFeature.addContext(fou);
								containedInDeadFeatureList = true;
							}

						}
						if (!containedInDeadFeatureList) {
							

							DwZ3FeatureAnomaly foundFeature = new DwZ3FeatureAnomaly(feature.getSExpr());
							foundFeature.addContext(fou);
							
							for(HyFeature f: featureModel.getFeatures()) {
								if(f.getId().equals(foundFeature.getId())) {
									foundFeature.setFeature(f);
								}
							}
							
							
							deadFeatures.add(foundFeature);

						}

						BoolExpr f = ctx.mkNot(ctx.mkAnd(ctx.mkBoolConst(feature + "_v"),
								ctx.mkEq(ctx.mkIntConst(timeContext), ctx.mkInt(fou))));

						solver.add(f);

						break;
					}
				}

			} else if (status.equals(Status.UNSATISFIABLE)) {
//
//				System.out.println("No dead features anymore");
				break;

			} else {
//				System.out.println("Status unknown.");
				break;
			}

		}

		return deadFeatures;

	}

	private List<DwZ3FeatureAnomaly> searchForVoidFeatureEvolution(HyFeatureModel featureModel,Context ctx, Solver solver, Expr[] testFor,
			BoolExpr[] optionalFeaturesWithoutNameChange, BoolExpr[] constraints, BoolExpr[] optionalFeatures,
			String timeContext) {

		List<DwZ3FeatureAnomaly> deadFeatures = new ArrayList<DwZ3FeatureAnomaly>();

		BoolExpr forAll = buildForAllFormulaFalsePositives(ctx, constraints, testFor,
				optionalFeaturesWithoutNameChange);

//		System.out.println(forAll.toString());

		solver.add(forAll);

		while (true) {
			Status status = solver.check();

			if (status.equals(Status.SATISFIABLE)) {

				Model model = solver.getModel();

				for (BoolExpr feature : optionalFeatures) {

					if (model.eval(ctx.mkBoolConst(feature + "_v"), true).getBoolValue().equals(Z3_lbool.Z3_L_TRUE)) {

						IntExpr foundContext = (IntExpr) model.getConstInterp(ctx.mkIntConst(timeContext));

//						System.err.println("Found false positive Feature: " + feature + " for time: " + foundContext);

						int fou = (int) Integer.valueOf(foundContext.toString());

						boolean containedInDeadFeatureList = false;

						for (DwZ3FeatureAnomaly deadFeature : deadFeatures) {

							if (deadFeature.getId().equals(feature.getSExpr())) {
								deadFeature.addContext(fou);
								containedInDeadFeatureList = true;
							}

						}
						if (!containedInDeadFeatureList) {

							DwZ3FeatureAnomaly foundFeature = new DwZ3FeatureAnomaly(feature.getSExpr());
							foundFeature.addContext(fou);
							
							
							for(HyFeature f: featureModel.getFeatures()) {
								if(f.getId().equals(foundFeature.getId())) {
									foundFeature.setFeature(f);
								}
							}
							
							deadFeatures.add(foundFeature);

						}

						BoolExpr f = ctx.mkNot(ctx.mkAnd(ctx.mkBoolConst(feature + "_v"),
								ctx.mkEq(ctx.mkIntConst(timeContext), ctx.mkInt(fou))));

						solver.add(f);

						break;
					}
				}

			} else if (status.equals(Status.UNSATISFIABLE)) {

//				System.out.println("No dead features anymore");
				break;

			} else {
//				System.out.println("Status unknown.");
				break;
			}

		}

		return deadFeatures;

	}	


	private BoolExpr buildForAllFormulaDeadFeatures(Context ctx, BoolExpr[] constraints, Expr[] testFor,
			BoolExpr[] optionalFeatures) {

		BoolExpr and = ctx.mkAnd(constraints);

		BoolExpr not = ctx.mkNot(and);

		BoolExpr[] innerImplies = new BoolExpr[optionalFeatures.length];

		int i = 0;
		for (BoolExpr opF : optionalFeatures) {
			innerImplies[i] = ctx.mkImplies(ctx.mkBoolConst(opF + "_v"), opF);
			i++;
		}

		BoolExpr innerImpliesAnd = ctx.mkAnd(innerImplies);

		BoolExpr implies = ctx.mkImplies(innerImpliesAnd, not);

		BoolExpr forAll = ctx.mkForall(testFor, implies, 1, null, null, ctx.mkSymbol("Q1"), ctx.mkSymbol("skid1"));
		return forAll;
	}

	private BoolExpr buildForAllFormulaFalsePositives(Context ctx, BoolExpr[] constraints, Expr[] features,
			BoolExpr[] optionalFeatures) {

		BoolExpr and = ctx.mkAnd(constraints);

		BoolExpr not = ctx.mkNot(and);

		BoolExpr[] innerImplies = new BoolExpr[optionalFeatures.length];

		int i = 0;
		for (BoolExpr opF : optionalFeatures) {
			innerImplies[i] = ctx.mkImplies(ctx.mkBoolConst(opF + "_v"), ctx.mkNot(opF));
			i++;
		}

		BoolExpr innerImpliesAnd = ctx.mkAnd(innerImplies);

		BoolExpr implies = ctx.mkImplies(innerImpliesAnd, not);

		BoolExpr forAll = ctx.mkForall(features, implies, 1, null, null, ctx.mkSymbol("Q1"), ctx.mkSymbol("skid1"));
		return forAll;
	}


}
