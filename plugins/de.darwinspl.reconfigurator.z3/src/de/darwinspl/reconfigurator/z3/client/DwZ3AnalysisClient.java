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
import com.microsoft.z3.FuncDecl;
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
	
		
	
	public void checkFeatures(HyContextModel contextModel, HyValidityModel contextValidityModel,
			HyFeatureModel featureModel, HyConstraintModel constraintModel, HyConfiguration oldConfiguration, HyConfiguration partialConfiguration,
			DwProfile profileModels, HyContextValueModel contextValues, Date date, Date evolutionContextValueDate) {

		HashMap<String, String> cfg = new HashMap<String, String>();

//		cfg.put("combined_solver.solver2_timeout", "true");
		// cfg.put("timeout", "1");
//		cfg.put("proof", "true");
		cfg.put("auto-config", "true");
		//
		context = new Context(cfg);
		solver = context.mkSolver();

		dwZ3InputBuilder = new DwZ3InputBuilder();
		dwZ3ParserClient = new DwZ3ParserClient();

		InputForHyVarRec inputForHyVarRec = dwZ3InputBuilder.createInputForHyVarRec(contextModel,
				contextValidityModel, featureModel, constraintModel, oldConfiguration, partialConfiguration,
				profileModels, contextValues, date, evolutionContextValueDate);

		DwZ3ParserClient dwZ3ParserClient = new DwZ3ParserClient();
		


		List<String> featureIds = null;
		
		//Processing Constraints
		Expr[] z3Constraints = null;
		
		if(!(inputForHyVarRec.getConstraints() == null) && !(inputForHyVarRec.getConstraints().isEmpty())) {
            z3Constraints = dwZ3ParserClient.parseConstraints(inputForHyVarRec.getConstraints(), context);
		featureIds = dwZ3ParserClient.getFeatures();
		}
		
		
		//Processing Context Constraints
		
		Expr[] z3ContextConstraints = null;
	
		if(!(inputForHyVarRec.getContextConstraints() == null) && !(inputForHyVarRec.getContextConstraints().isEmpty())) {
			
			z3ContextConstraints =dwZ3ParserClient.parseConstraints(inputForHyVarRec.getContextConstraints(), context);
			System.out.println(inputForHyVarRec.getContextConstraints().toString());
			featureIds = dwZ3ParserClient.getFeatures();
			
		}
		
		
		

		//
		String timeContext = getTimeContext(inputForHyVarRec);
		

		//add time variable to Context if not present
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
		
		
		//fresh variables representing the selected features namefresh_var
		String freshVariable = "_" + UUID.randomUUID().toString();
		
		Set<String> optionalFeaturesKeys = inputForHyVarRec.getOptionalFeatures().keySet();
		
		
		
		
		if(optionalFeaturesKeys.isEmpty()) {
			System.out.println("nothing to check, no optional features");
			return;
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
		
//		//Adding constraint limiting time context based on the optional features to check
		for(String optionalFeature: optionalFeaturesKeys) {
			BoolExpr[] ls = new BoolExpr[2];
			int i = 0;
			for(List<Integer> evolutionBoundaries: inputForHyVarRec.getOptionalFeatures().get(optionalFeature)) {
				ls[i] = context.mkGe(context.mkIntConst(timeContext), context.mkInt(evolutionBoundaries.get(0)));
				i++;
				ls[i] = context.mkLe(context.mkIntConst(timeContext), context.mkInt(evolutionBoundaries.get(1)));
				i++;
			}
			solver.add(context.mkImplies(context.mkBoolConst(optionalFeature + freshVariable) , context.mkAnd(ls)));
			
			
		}


       solver.push();
		
		
		IntExpr[] z3Features = new IntExpr[featureIds.size()];
		
		int i=0;
		for(String featureId:featureIds) {
			z3Features[i] = context.mkIntConst(featureId);
			i++;
		}
		
//		IntExpr[] z3Attributes = new IntExpr[inputForHyVarRec.getAttributes().size()];
//		
//		i = 0;
//		for(i = 0; i<z3Attributes.length; i++) {
//			
//			z3Attributes[i] = context.mkIntConst(inputForHyVarRec.getAttributes().get(i).getId());
//			
//		}
		
	   List<IntExpr> z3ContextsList = new ArrayList<IntExpr>();
		
		i = 0;
		for(i = 0; i<inputForHyVarRec.getContexts().size(); i++) {
			
			eu.hyvar.reconfigurator.input.format.Context c = inputForHyVarRec.getContexts().get(i);
			if(!c.getId().equals(timeContext)){
				
				z3ContextsList.add(context.mkIntConst(c.getId()));
			}
	
		}
		
//
//		List<Attribute> attributes = inputForHyVarRec.getAttributes();
//		if(attributes == null) {
//			attributes = new ArrayList<Attribute>();
//		}
//		
//		IntExpr[] z3Objects = new IntExpr[featureIds.size() + inputForHyVarRec.getAttributes().size() + z3ContextsList.size()];
//		
//		for(i=0; i<featureIds.size(); i++) {
//			z3Objects[i] = context.mkIntConst(featureIds.get(i));
//			
//		}
//		for(i=featureIds.size()-1; i<inputForHyVarRec.getAttributes().size(); i++) {
//			z3Objects[i] = context.mkIntConst(attributes.get(i).getId());
//		}
//		for(i = (featureIds.size()+attributes.size()-1); i < z3Objects.length; i++) {
//			z3Objects[i] = z3ContextsList.get(i);
//		}
		
	
		
		
		
		System.out.println("Searching for dead features");
		
		
        BoolExpr[] impliesExpressions = new BoolExpr[optionalFeaturesKeys.size()];
		
		
		
		i= 0;
		for(String optF: optionalFeaturesKeys) {
			BoolExpr bc = context.mkBoolConst(optF + freshVariable);
			
			BoolExpr eq = context.mkEq(context.mkIntConst(optF), context.mkInt(1));
			impliesExpressions[i] = context.mkImplies(bc, eq);

			i++;
		}
		BoolExpr and = context.mkAnd(impliesExpressions);
		

		BoolExpr[] formulas = new BoolExpr[basicFormulas.size()];

		i = 0;
		for (Expr e : basicFormulas) {
			formulas[i] = (BoolExpr) e;
			i++;
		}

	
		BoolExpr not = context.mkNot(context.mkAnd(formulas));

		Expr b1 = context.mkImplies(and, not);
		
		BoolExpr forAll = context.mkForall(z3Features, b1, 1
				, null, null, context.mkSymbol("Q2"), context.mkSymbol("skid2"));

		System.out.println(forAll.toString());
		
		solver.add(forAll);
		
		
		
		
		Map<String, List<Expr>> deadFeatureIds = new HashMap<String, List<Expr>>();

		while (true) {
			Status s2 = solver.check();

			if (s2 == Status.SATISFIABLE) {

				Model m = solver.getModel();

				System.out.println("Size: " + optionalFeaturesKeys.size());

				String foundFeature = "";

				for (String opF : optionalFeaturesKeys) {

					
					for(FuncDecl fd: m.getFuncDecls()) {
						System.out.println(fd.toString());
					}
					
					System.out.println(m.eval(context.mkBoolConst(opF + freshVariable), true));
						if (m.getConstInterp(context.mkBoolConst(opF +freshVariable)).getBoolValue() == Z3_lbool.Z3_L_TRUE) {
						System.out.println("Found dead feature" + opF);

						for (HyFeature feature : featureModel.getFeatures()) {
							if (feature.getId().equals(opF)) {
								System.out.println("Name");
								System.out.println(feature.getNames().get(0));
							}
						}
						
						

						foundFeature = opF;
						
						
						Expr found_context = m.getConstInterp(context.mkIntConst(timeContext));
						System.out.println(found_context);
						
						if(deadFeatureIds.containsKey(foundFeature)) {
							deadFeatureIds.get(foundFeature).add(found_context);
						}else {
							List<Expr> foundContexts = new ArrayList<Expr>();
							foundContexts.add(found_context);
							deadFeatureIds.put(foundFeature, foundContexts);
						}

						solver.add(context.mkNot(context.mkAnd(context.mkBoolConst(foundFeature + freshVariable),
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
			
			BoolExpr eq = context.mkEq(context.mkIntConst(optF), context.mkInt(0));
			impliesExpressions[i] = context.mkImplies(bc, eq);

			i++;
		}
		
		
		and = context.mkAnd(impliesExpressions);
		not = context.mkNot(context.mkAnd(formulas));

		b1 = context.mkImplies(and, not);

		solver.add(context.mkForall(z3Features, b1, 1, null, null, null, null));
		
		
//		for(Entry<String, List<Expr>> deadFeature:deadFeatureIds.entrySet()) {
//			for(Expr c: deadFeature.getValue()) {
//			
//			solver.add(context.mkNot(context.mkAnd(context.mkBoolConst(deadFeature.getKey() + freshVariable), context.mkEq(context.mkIntConst(timeContext), c))));
//		
//			}
//		}
//		
			
		
		while(true) {
			
			
			Status result = solver.check();
			System.out.println(result.toString());
			if (result == Status.SATISFIABLE) {

				Model m = solver.getModel();

				System.out.println("Size: " + optionalFeaturesKeys.size());

				String foundFeature = "";

				for (String opF : optionalFeaturesKeys) {

					
				
					System.out.println(m.getConstDecls().toString());
					
					if (m.getConstInterp(context.mkBoolConst(opF +freshVariable)).getBoolValue() == Z3_lbool.Z3_L_TRUE) {
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
				System.out.println("No false optional");
				break;
			}
			
		}

	}




	private String getTimeContext(InputForHyVarRec inputForHyVarRec) {
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
		return timeContext;
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
