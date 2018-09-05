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
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.reconfigurator.input.format.Attribute;
import eu.hyvar.reconfigurator.input.format.InputForHyVarRec;

/**
 * 
 * @author Anna-Liisa
 * 
 * 
 *         Client to analyse feature model using Z3 solver
 * 
 *
 */
public class DwZ3AnalysisClient {

	private InputForHyVarRec inputForHyVarRec;

	public void checkFeatures(InputForHyVarRec input, HyFeatureModel featureModel, Boolean featuresAsBoolean) {

		inputForHyVarRec = input;

		checkFeaturesWithEvolution(featureModel, featuresAsBoolean);
		// return;
		// System.out.println("In check feature");
		//
		// List<String> optionals = new ArrayList<String>();
		//
		// for(String opf: inputForHyVarRec.getOptional_features().keySet()) {
		// optionals.add(opf);
		// System.out.println(opf);
		// }
		//
		// startZ3FeatureAnalysis(inputForHyVarRec.getConstraints(), optionals);
		//
		// return;

	}

	public void checkFeaturesWithEvolution(HyFeatureModel featureModel, Boolean featuresAsBoolean) {

		System.out.println("In check feature");
		List<String> optionals = new ArrayList<String>();

		for (String opf : inputForHyVarRec.getOptional_features().keySet()) {
			optionals.add(opf);
			System.out.println(opf);
		}

		String timeContext = getTimeContext(inputForHyVarRec);
		startZ3FeatureAnalysisWithEvolutionAttributesAndContexts(inputForHyVarRec, optionals, timeContext);

		return;

	}

	private String getTimeContext(InputForHyVarRec inputForHyVarRec) {
		String timeContext = inputForHyVarRec.getTime_context();

		if (timeContext == null || timeContext == "") {

			timeContext = "_" + UUID.randomUUID().toString();

			List<Integer> l = new ArrayList<Integer>();
			l.add(0);
			l.add(0);

			// TODO: Z3 - check if really working correctly
			for (Entry<String, List<List<Integer>>> entry : inputForHyVarRec.getOptional_features().entrySet()) {

				entry.getValue().add(l);

			}
		}
		return timeContext;
	}

	private List<Expr> getBasicFormulaList(List<String> featureIds, List<Attribute> attributes,
			List<eu.hyvar.reconfigurator.input.format.Context> contexts, Expr[] z3Constraints,
			boolean featuresAsBoolean, Context context) {

		System.out.println("5. Building the FM formula.");
		List<Expr> formulas = new ArrayList<Expr>();

		if (!featuresAsBoolean) {

			for (String feature : featureIds) {

				formulas.add(context.mkLe(context.mkInt(0), context.mkIntConst(feature)));
				formulas.add(context.mkLe(context.mkIntConst(feature), context.mkInt(1)));
			}

		}

		for (Attribute attribute : attributes) {

			formulas.add(context.mkLe(context.mkInt(attribute.getMin()), context.mkIntConst(attribute.getId())));
			formulas.add(context.mkLe(context.mkIntConst(attribute.getId()), context.mkInt(attribute.getMax())));

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

	private void startZ3FeatureAnalysisWithEvolutionAttributesAndContexts(InputForHyVarRec inputForHyVarRec,
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


		if(isTimeContextInContexts) {
			
			String name = timeContextInContexts.getId();
			name = name.replace("context[", "");

			name = name.substring(0, name.length() - 1);
			
			
			solver.add(ctx.mkLe(ctx.mkInt(timeContextInContexts.getMin()), ctx.mkIntConst(name)));
			solver.add(ctx.mkGe(ctx.mkIntConst(name), ctx.mkInt(timeContextInContexts.getMax())));
		
		}else {
			solver.add(ctx.mkLe(ctx.mkInt(0), ctx.mkIntConst(timeContext)));
			solver.add(ctx.mkGe(ctx.mkIntConst(timeContext), ctx.mkInt(0)));
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

		

		Expr[] testFor = getTextForZ3Object(ctx, inputContexts, features, isTimeContextInContexts, timeContextInContexts);

		List<Expr> formulasList = getBasicFormulaList(stringFeatures, inputForHyVarRec.getAttributes(), inputContexts,
				constraints, true, ctx);

		BoolExpr[] formulas = null;

		if(isTimeContextInContexts) {
		formulas = new BoolExpr[formulasList.size()];

		int k = 0;
		for (Expr e : formulasList) {
			formulas[k] = (BoolExpr) e;
			k++;
		}}else {
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

		System.out.println(solver.check());

		solver.push();

		List<String> deadFeatures = searchForDeadFeaturesEvolution(ctx, solver, testFor,
				optionalFeaturesWithoutNameChange, formulas, optionalFeaturesWithoutNameChange, timeContext);

		solver.pop();

		// searchForVoidFeaturesEvolution(ctx, solver, features,
		// optionalFeaturesWithoutNameChange, formulas,
		// optionalFeaturesWithoutNameChange, deadFeatures);
	}

	private Expr[] getTextForZ3Object(Context ctx, List<eu.hyvar.reconfigurator.input.format.Context> inputContexts,
			BoolExpr[] features, boolean isTimeContextInContexts, eu.hyvar.reconfigurator.input.format.Context timeContextInContexts) {
		
		System.err.println("Is time context in context: " + isTimeContextInContexts);
		int i;
		int size = 0;
		if(isTimeContextInContexts) {
			size = inputContexts.size() -1;
		}else {
			size = inputContexts.size();
		}
		
		
		Expr[] testFor = null;

		if (size > 1) {
			IntExpr[] contexts = new IntExpr[size];

			Symbol[] contextNames = new Symbol[size];

			i = 0;


			for (eu.hyvar.reconfigurator.input.format.Context f : inputContexts) {
				if(!isTimeContextInContexts || !f.getId().equals(timeContextInContexts.getId())) {

				String name = f.getId();
				name = name.replace("context[", "");

				name = name.substring(0, name.length() - 1);

				contextNames[i] = ctx.mkSymbol(name);
				contexts[i] = (IntExpr) ctx.mkConst(contextNames[i], ctx.getIntSort());

				i++;
				}
				
			}

			i = 0;

			testFor = new Expr[(contexts.length + features.length)];

			for (Expr f : features) {
				testFor[i] = f;
				i++;
			}
			for (Expr f : contexts) {
				testFor[i] = f;
				i++;
			}

		} else {

			i = 0;
			testFor = new Expr[1 + features.length];
			for (Expr f : features) {
				testFor[i] = f;
				i++;
			}
			for (eu.hyvar.reconfigurator.input.format.Context c : inputContexts) {
				
				if(!isTimeContextInContexts || !c.getId().equals(timeContextInContexts.getId())) {
				String name = c.getId();
				name = name.replace("context[", "");

				name = name.substring(0, name.length() - 1);
				testFor[i] = ctx.mkConst(ctx.mkSymbol(name), ctx.getIntSort());
				}
				
			}

		}
		return testFor;
	}

	private List<String> searchForDeadFeaturesEvolution(Context ctx, Solver solver, Expr[] testFor,
			BoolExpr[] optionalFeaturesWithoutNameChange, BoolExpr[] constraints, BoolExpr[] optionalFeatures,
			String timeContext) {

		List<String> deadFeatures = new ArrayList<String>();

		BoolExpr forAll = buildForAllFormula(ctx, constraints, testFor, optionalFeaturesWithoutNameChange);

		System.out.println(forAll.toString());

		solver.add(forAll);

		while (true) {
			Status status = solver.check();

			if (status.equals(Status.SATISFIABLE)) {

				Model model = solver.getModel();

				for (BoolExpr feature : optionalFeatures) {

					if (model.eval(ctx.mkBoolConst(feature + "_v"), true).getBoolValue().equals(Z3_lbool.Z3_L_TRUE)) {
						System.out.println("Found dead Feature: " + feature);

						IntExpr foundContext = (IntExpr) model.getConstInterp(ctx.mkIntConst(timeContext));

												
//						System.out.println(foundContextValue);
						System.err.println(foundContext);

//						deadFeatures.add(feature.getSExpr());

						// solver.add(ctx.mkNot(ctx.mkAnd(ctx.mkBoolConst(feature + "_v"),
						// ctx.mkEq(ctx.mkIntConst(timeContext), ctx.mkInt(foundContextValue)))));

						solver.add(ctx.mkNot(ctx.mkBoolConst(feature + "_v")));
						break;
					}
				}

			} else if (status.equals(Status.UNSATISFIABLE)) {

				System.out.println("No dead features anymore");
				break;

			} else {
				System.out.println("Status unknown.");
				break;
			}

		}

		return deadFeatures;

	}

	private void startZ3FeatureAnalysis(List<String> list, List<String> stringOptionals) {
		HashMap<String, String> cfg = new HashMap<String, String>();
		Context ctx = new Context(cfg);

		Solver solver = ctx.mkSolver();

		DwZ3ParserClient dwZ3ParserClient2 = new DwZ3ParserClient();

		BoolExpr[] constraints = (BoolExpr[]) dwZ3ParserClient2.parseConstraints(list, ctx, true);
		List<String> stringFeatures = dwZ3ParserClient2.getFeatures();

		BoolExpr[] features = new BoolExpr[stringFeatures.size()];
		Symbol[] featureNames = new Symbol[stringFeatures.size()];

		BoolExpr[] optionalFeaturesWithoutNameChange = new BoolExpr[stringOptionals.size()];

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

		BoolExpr[] optionalFeatures = new BoolExpr[optionalFeaturesWithoutNameChange.length];

		i = 0;
		for (BoolExpr opF : optionalFeaturesWithoutNameChange) {
			BoolExpr feature = ctx.mkBoolConst(opF + "_v");
			optionalFeatures[i] = feature;
			i++;

		}

		solver.add(ctx.mkAtLeast(optionalFeatures, 1));
		solver.add(ctx.mkAtMost(optionalFeatures, 1));

		System.out.println(solver.check());

		solver.push();

		List<String> deadFeatures = searchForDeadFeatures(ctx, solver, features, optionalFeaturesWithoutNameChange,
				constraints, optionalFeaturesWithoutNameChange);

		solver.pop();

		searchForVoidFeatures(ctx, solver, features, optionalFeaturesWithoutNameChange, constraints,
				optionalFeaturesWithoutNameChange, deadFeatures);
	}

	private List<String> searchForDeadFeatures(Context ctx, Solver solver, BoolExpr[] features,
			BoolExpr[] optionalFeaturesWithoutNameChange, BoolExpr[] constraints, BoolExpr[] optionalFeatures) {

		List<String> deadFeatures = new ArrayList<String>();

		BoolExpr forAll = buildForAllFormula(ctx, constraints, features, optionalFeaturesWithoutNameChange);

		System.out.println(forAll.toString());

		solver.add(forAll);

		while (true) {
			Status status = solver.check();

			if (status.equals(Status.SATISFIABLE)) {

				Model model = solver.getModel();

				for (BoolExpr feature : optionalFeatures) {

					if (model.eval(ctx.mkBoolConst(feature + "_v"), true).getBoolValue().equals(Z3_lbool.Z3_L_TRUE)) {
						System.out.println("Found dead Feature: " + feature);

						deadFeatures.add(feature.getSExpr());
						solver.add(ctx.mkNot(ctx.mkBoolConst(feature + "_v")));
						break;
					}
				}

			} else if (status.equals(Status.UNSATISFIABLE)) {

				System.out.println("No dead features anymore");
				break;

			} else {
				System.out.println("Status unknown.");
				break;
			}

		}

		return deadFeatures;

	}

	private BoolExpr buildForAllFormula(Context ctx, BoolExpr[] constraints, Expr[] testFor,
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

	private BoolExpr buildForAllFormulaFalsePositive(Context ctx, BoolExpr[] constraints, BoolExpr[] features,
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

	private List<String> searchForVoidFeatures(Context ctx, Solver solver, BoolExpr[] features,
			BoolExpr[] optionalFeaturesWithoutNameChange, BoolExpr[] constraints, BoolExpr[] optionalFeatures,
			List<String> deadFeatures) {

		List<String> falseOptionalFeature = new ArrayList<String>();

		BoolExpr forAll = buildForAllFormulaFalsePositive(ctx, constraints, features,
				optionalFeaturesWithoutNameChange);

		System.out.println(forAll.toString());

		solver.add(forAll);

		for (String deadFeature : deadFeatures) {
			solver.add(ctx.mkNot(ctx.mkBoolConst(deadFeature + "_v")));
		}

		while (true) {
			Status status = solver.check();

			if (status.equals(Status.SATISFIABLE)) {

				Model model = solver.getModel();

				for (BoolExpr feature : optionalFeatures) {

					if (model.eval(ctx.mkBoolConst(feature + "_v"), true).getBoolValue().equals(Z3_lbool.Z3_L_TRUE)) {
						System.out.println("Found dead False Optional: " + feature);

						falseOptionalFeature.add(feature.getSExpr());

						solver.add(ctx.mkNot(ctx.mkBoolConst(feature + "_v")));

						break;
					}
				}

			} else if (status.equals(Status.UNSATISFIABLE)) {

				System.out.println("No false optional features anymore");
				break;

			} else {
				System.out.println("Status unknown.");
				break;
			}

		}

		return falseOptionalFeature;

	}

}
