package de.darwinspl.reconfigurator.z3.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.EList;

import java.util.UUID;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.IntExpr;
import com.microsoft.z3.Model;
import com.microsoft.z3.Solver;
import com.microsoft.z3.Status;
import com.microsoft.z3.enumerations.Z3_lbool;

import de.darwinspl.preferences.DwProfile;
import de.darwinspl.reconfigurator.z3.DwZ3ParserClient;
import de.darwinspl.reconfigurator.z3.client.format.DwZ3InputBuilder;
import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.context.contextValidity.HyValidityModel;
import eu.hyvar.context.information.contextValue.HyContextValueModel;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.reconfigurator.input.format.Attribute;
import eu.hyvar.reconfigurator.input.format.InputForHyVarRec;

public class DwZ3AnalysisClient {
	
	
	
	private DwZ3ParserClient dwZ3ParserClient;
	
	
	private DwZ3InputBuilder dwZ3InputBuilder;
	
	
	private Context context;
	
	private Solver solver;
	
	
	public static void main(String[] args) {
		HashMap<String, String> cfg = new HashMap<String, String>();
	       
//		cfg.put("combined_solver.solver2_timeout", "true");
//		cfg.put("timeout", "1");
//		cfg.put("proof", "true");
//        cfg.put("auto-config", "false");
//		
		Context context = new Context(cfg);
		Solver solver = context.mkSolver();
		

		String freshVariable = "ab";
		
		List<String> constraints = new ArrayList<String>();
		
		constraints.add("feature[R] = 1 impl feature[B] = 1");
		constraints.add("feature[C] = 1 impl feature[B] = 1");
		constraints.add("feature[R] = 1 impl feature[C] = 0");
		constraints.add("feature[B] = 1 impl feature[R] = 1");
		
		
		DwZ3ParserClient dwZ3ParserClient = new DwZ3ParserClient();
		
		
		
		Expr[] formulas = dwZ3ParserClient.parseConstraints(constraints, context);
		
		for(String f: dwZ3ParserClient.getFeatures()) {
			System.out.println(f);
		}
		
		
		
		List<String> optionalFeaturesKey = new ArrayList<String>();
		optionalFeaturesKey.add("B");
		optionalFeaturesKey.add("C");
		

		Expr[] features = new Expr[3];
		features[0] = context.mkIntConst("R");
		features[1] = context.mkIntConst("B");
		features[2] = context.mkIntConst("C");
	
		
	
		
		BoolExpr[] pbEqBooleans = new BoolExpr[2];
		int[] pbEqInts = new int[2];
		
		pbEqInts[0] = 1;
		pbEqInts[1] = 1;

		
		pbEqBooleans[0] = context.mkBoolConst(optionalFeaturesKey.get(0) + freshVariable);
		pbEqBooleans[1] = context.mkBoolConst(optionalFeaturesKey.get(1) + freshVariable);
		
		
		solver.add(context.mkPBEq(pbEqInts, pbEqBooleans, 1));
		
		solver.push();
		
		
		BoolExpr[] impliesExpressions = new BoolExpr[optionalFeaturesKey.size()];
		
		BoolExpr eq = null;
		
		int i= 0;
		for(String optF: optionalFeaturesKey) {
			BoolExpr bc = context.mkBoolConst(optF + freshVariable);
			
			eq = context.mkEq(context.mkIntConst(optF), context.mkInt(1));
			impliesExpressions[i] = context.mkImplies(bc, eq);
			
			i++;		
		}
		
		
		BoolExpr and = context.mkAnd(impliesExpressions);
		BoolExpr not = context.mkNot(context.mkAnd((BoolExpr[]) formulas));
		
		Expr b1 = context.mkImplies(and,  not );
		
		
	
		solver.add(context.mkForall(features, b1, 1,  null, null, null, null));
		
		
		Status s2 = solver.check();
		
	
		while(s2 == Status.SATISFIABLE) {
			
			Model m  = solver.getModel();
			
			for(String opF:optionalFeaturesKey) {
				

				
				if(m.eval(context.mkBoolConst(opF + freshVariable), true).getBoolValue()== Z3_lbool.Z3_L_TRUE) {
					System.out.println("Found dead feature" + opF);
				}
				
			}
			System.out.println(m.toString());
			return;
			
		}
		
		
//		System.out.println(s2.toString());
		
		
//		solver.pop();
//		
//
//		
//		
//		BoolExpr[] impliesExpressions2  = new BoolExpr[3];
//		
//	    i= 0;
//		for(String optF: optionalFeaturesKey) {
//			impliesExpressions2[i] = context.mkImplies(context.mkBoolConst(optF + freshVariable), context.mkEq(context.mkIntConst(optF), context.mkInt(0)));
//			i++;		
//		}
//		
//		
//		Expr b2 = context.mkImplies(context.mkAnd(impliesExpressions2),  context.mkNot(context.mkAnd((BoolExpr[]) formulas)));
//		solver.add(context.mkForall(features, b2, 1, null, null, null, null));
////		
//		
//		
//		System.out.println(s2.toString());
//		

		
	
	
	}
	
	
	
	
	public void checkFeatures(HyContextModel contextModel, HyValidityModel contextValidityModel,
			HyFeatureModel featureModel, HyConstraintModel constraintModel, HyConfiguration oldConfiguration, HyConfiguration partialConfiguration,
			DwProfile profileModels, HyContextValueModel contextValues, Date date, Date evolutionContextValueDate) {

		HashMap<String, String> cfg = new HashMap<String, String>();

		// cfg.put("combined_solver.solver2_timeout", "true");
		// cfg.put("timeout", "1");
		// cfg.put("proof", "true");
		// cfg.put("auto-config", "false");
		//
		context = new Context(cfg);
		solver = context.mkSolver();

		dwZ3InputBuilder = new DwZ3InputBuilder();
		dwZ3ParserClient = new DwZ3ParserClient();

		InputForHyVarRec inputForHyVarRec = dwZ3InputBuilder.createInputForHyVarRec(contextModel,
				contextValidityModel, featureModel, constraintModel, oldConfiguration, partialConfiguration,
				profileModels, contextValues, date, evolutionContextValueDate);

		DwZ3ParserClient dwZ3ParserClient = new DwZ3ParserClient();
		
		System.out.println("constrint: "+ inputForHyVarRec.getConstraints());

		Expr[] z3Constraints = dwZ3ParserClient.parseConstraints(inputForHyVarRec.getConstraints(), context);

		List<String> featureIds = dwZ3ParserClient.getFeatures();

		// TODO: in einzelne methode auslagern
		String timeContext = inputForHyVarRec.getTimeContext();

		if (timeContext == null || timeContext == "") {

			timeContext = "_" + UUID.randomUUID().toString();

			List<Integer> l = new ArrayList<Integer>();
			l.add(0);
			l.add(0);

			for (Entry<String, List<List<Integer>>> entry : inputForHyVarRec.getOptionalFeatures().entrySet()) {

				entry.getValue().add(l);

			}
		}
		

		
		
		if(!inputForHyVarRec.getContexts().contains(timeContext)) {
			
			eu.hyvar.reconfigurator.input.format.Context contextTime = new eu.hyvar.reconfigurator.input.format.Context();
			contextTime.setId(timeContext);
			contextTime.setMin(0);
			contextTime.setMax(0);
			inputForHyVarRec.getContexts().add(contextTime);
			
		}
		
		
		for(eu.hyvar.reconfigurator.input.format.Context c: inputForHyVarRec.getContexts()) {
			
			if(c.getId().equals(timeContext)) {
				solver.add(context.mkLe(context.mkInt(c.getMin()), context.mkIntConst(c.getId())));
				solver.add(context.mkLe(context.mkIntConst(c.getId()), context.mkInt(c.getMax())));
			}
			
		}
		
		
		List<Expr> basicFormulas = getBasicFormulaList(featureIds, inputForHyVarRec.getAttributes(), inputForHyVarRec.getContexts(), z3Constraints, false);
		
		
		
		String freshVariable = UUID.randomUUID().toString();
		
		Set<String> optionalFeaturesKeys = inputForHyVarRec.getOptionalFeatures().keySet();
		
		if(optionalFeaturesKeys.isEmpty()) {
			System.out.println("nothing to check, no optional features");
			
		}
		
		
		else if(optionalFeaturesKeys.size() == 1) {
			
			for(Entry<String, List<List<Integer>>> oF: inputForHyVarRec.getOptionalFeatures().entrySet()) {
				solver.add(context.mkBoolConst(oF.getKey()+freshVariable));
			}
			
				
		}
		else {
			
			
			BoolExpr[] pbEqBooleans = new BoolExpr[optionalFeaturesKeys.size()];
			int[] pbEqInts = new int[optionalFeaturesKeys.size()];
			
			for(int i=0; i<pbEqInts.length-1; i++) {
				pbEqInts[i] = 1;
			}
			
			int i= 0;
            for(String optionalFeature: optionalFeaturesKeys) {
				pbEqBooleans[i] = context.mkBoolConst(optionalFeature + freshVariable);
				i++;
			}
	
			solver.add(context.mkPBEq(pbEqInts, pbEqBooleans, 1));
	
		}
		
		
		//TODO: noch umsetzten
//		for i in opt_features_ls:
//	        ls = []
//	        for k in optional_features[i]:
//	            ls.append(z3.Int(time_context) >= k[0])
//	            ls.append(z3.Int(time_context) <= k[1])
//	        solver.add(z3.Implies(z3.Bool(i + fresh_var),z3.And(ls)))

		solver.push();
		
		
		IntExpr[] z3Features = new IntExpr[featureIds.size()];
		
		int i=0;
		for(String featureId:featureIds) {
			z3Features[i] = context.mkIntConst(featureId);
			i++;
		}
		
		
		System.out.println("Searching for dead features");
		
		
        BoolExpr[] impliesExpressions = new BoolExpr[optionalFeaturesKeys.size()];
		
		BoolExpr eq = null;
		
		i= 0;
		for(String optF: optionalFeaturesKeys) {
			BoolExpr bc = context.mkBoolConst(optF + freshVariable);
			
			eq = context.mkEq(context.mkIntConst(optF), context.mkInt(1));
			impliesExpressions[i] = context.mkImplies(bc, eq);

			i++;
		}

		BoolExpr[] formulas = new BoolExpr[basicFormulas.size()];

		i = 0;
		for (Expr e : basicFormulas) {
			formulas[i] = (BoolExpr) e;
			i++;
		}

		BoolExpr and = context.mkAnd(impliesExpressions);
		BoolExpr not = context.mkNot(context.mkAnd(formulas));

		Expr b1 = context.mkImplies(and, not);

		solver.add(context.mkForall(z3Features, b1, 1, null, null, null, null));
		
		
		Map<String, List<Expr>> deadFeatureIds = new HashMap<String, List<Expr>>();

		while (true) {
			Status s2 = solver.check();

			if (s2 == Status.SATISFIABLE) {

				Model m = solver.getModel();

				System.out.println("Size: " + optionalFeaturesKeys.size());

				String foundFeature = "";

				for (String opF : featureIds) {

					
				
					if (m.eval(context.mkBoolConst(opF + freshVariable), true).getBoolValue() == Z3_lbool.Z3_L_TRUE) {
						System.out.println("Found dead feature" + opF);

						for (HyFeature feature : featureModel.getFeatures()) {
							if (feature.getId().equals(opF)) {
								System.out.println("Name");
								System.out.println(feature.getNames().get(0));
							}
						}
						
						

						foundFeature = opF;
						
						
						Expr found_context = m.getConstInterp(context.mkIntConst(timeContext));
						
						if(deadFeatureIds.containsKey(foundFeature)) {
							deadFeatureIds.get(foundFeature).add(found_context);
						}else {
							List<Expr> foundContexts = new ArrayList<Expr>();
							foundContexts.add(found_context);
							deadFeatureIds.put(foundFeature, foundContexts);
						}

						solver.add(context.mkNot(context.mkAnd(context.mkBoolConst(opF + freshVariable),
								context.mkEq(context.mkIntConst(timeContext), found_context))));

					}

				}
			}
			else if(s2 == Status.UNSATISFIABLE) {
				System.out.println("No dead features more");
				break;
			}

		}
		
		
		solver.pop();
		
		
		i= 0;
		for(String optF: optionalFeaturesKeys) {
			BoolExpr bc = context.mkBoolConst(optF + freshVariable);
			
			eq = context.mkEq(context.mkIntConst(optF), context.mkInt(0));
			impliesExpressions[i] = context.mkImplies(bc, eq);

			i++;
		}
		
		
		and = context.mkAnd(impliesExpressions);
		not = context.mkNot(context.mkAnd(formulas));

		b1 = context.mkImplies(and, not);

		solver.add(context.mkForall(z3Features, b1, 1, null, null, null, null));
		
		
		for(Entry<String, List<Expr>> deadFeature:deadFeatureIds.entrySet()) {
			for(Expr c: deadFeature.getValue()) {
			
			solver.add(context.mkNot(context.mkAnd(context.mkBoolConst(deadFeature.getKey() + freshVariable), context.mkEq(context.mkIntConst(timeContext), c))));
		
			}
		}
		
		
		
		
		while(true) {
			
			
			Status result = solver.check();
			
			if (result == Status.SATISFIABLE) {

				Model m = solver.getModel();

				System.out.println("Size: " + optionalFeaturesKeys.size());

				String foundFeature = "";

				for (String opF : featureIds) {

					
				
					if (m.eval(context.mkBoolConst(opF + freshVariable), true).getBoolValue() == Z3_lbool.Z3_L_TRUE) {
						System.out.println("False optional" + opF);

						for (HyFeature feature : featureModel.getFeatures()) {
							if (feature.getId().equals(opF)) {
								System.out.println("Name");
								System.out.println(feature.getNames().get(0));
							}
						}
						
						

						foundFeature = opF;
						
						
						Expr found_context = m.getConstInterp(context.mkIntConst(timeContext));
						
						if(deadFeatureIds.containsKey(foundFeature)) {
							deadFeatureIds.get(foundFeature).add(found_context);
						}else {
							List<Expr> foundContexts = new ArrayList<Expr>();
							foundContexts.add(found_context);
							deadFeatureIds.put(foundFeature, foundContexts);
						}

						solver.add(context.mkNot(context.mkAnd(context.mkBoolConst(opF + freshVariable),
								context.mkEq(context.mkIntConst(timeContext), found_context))));

					}

				}
			}
			else if(result == Status.UNSATISFIABLE) {
				System.out.println("No dead features more");
				break;
			}
			
		}

	}
	
	 private List<Expr> getBasicFormulaList(List<String> featureIds, List<Attribute> attributes,
			List<eu.hyvar.reconfigurator.input.format.Context> contexts, Expr[] z3Constraints, boolean featuresAsBoolean) {
		
			List<Expr> formulas = new ArrayList<Expr>();
			

			if(!featuresAsBoolean) {
				
				for(String feature: featureIds) {
					
					formulas.add(context.mkLe(context.mkInt(0), context.mkIntConst(feature)));
					formulas.add(context.mkLe(context.mkIntConst(feature), context.mkInt(1)));
				}
				
			}
			
			for(Attribute attribute: attributes) {
				
				formulas.add(context.mkLe(context.mkInt(attribute.getMin()), context.mkIntConst(attribute.getId())));
				formulas.add(context.mkLe(context.mkIntConst(attribute.getId()), context.mkInt(attribute.getMax())));
				
			}
			
			
			for(eu.hyvar.reconfigurator.input.format.Context c: contexts) {
				
				formulas.add(context.mkLe(context.mkInt(c.getMin()), context.mkIntConst(c.getId())));
				formulas.add(context.mkLe(context.mkIntConst(c.getId()), context.mkInt(c.getMax())));
				
				
			}
			
			
			for(Expr expr: z3Constraints) {
				formulas.add(expr);
			}
			
		    return formulas;
			
			
			
			
		}
	        
	
	
//	private String getTimeContext(String timeContext, Map<String, List<List<Integer>>> map) {
//		
//		if(timeContext == null || timeContext == "") {
//		    
//			timeContext = "_" + UUID.randomUUID();
//			
//	
//			List<Integer> l = new ArrayList<Integer>();
//			l.add(0);
//			l.add(0);
//			
//			for(Entry<String, List<List<Integer>>> entry: map.entrySet()) {
//				
//				entry.getValue().add(l);
//				
//			}
//		
//		
//		}
//	}
	
	
}
