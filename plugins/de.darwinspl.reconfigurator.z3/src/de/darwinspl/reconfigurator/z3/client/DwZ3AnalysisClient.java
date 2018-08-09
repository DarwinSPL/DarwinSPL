package de.darwinspl.reconfigurator.z3.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.UUID;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
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
 * Client to analyse feature model using Z3 solver 
 * 
 *
 */
public class DwZ3AnalysisClient {
	
	

	
		


	public void checkFeatures(InputForHyVarRec inputForHyVarRec, HyFeatureModel featureModel,  Boolean featuresAsBoolean) {
		
		System.out.println("In check feature");
		List<String> optionals = new ArrayList<String>();
				
				for(String opf: inputForHyVarRec.getOptional_features().keySet()) {
					optionals.add(opf);
					System.out.println(opf);
				}
		
		startZ3FeatureAnalysis(inputForHyVarRec.getConstraints(), optionals);
		
		return;

	}




	private String getTimeContext(InputForHyVarRec inputForHyVarRec) {
		String timeContext = inputForHyVarRec.getTime_context();

		if (timeContext == null || timeContext == "") {

			timeContext = "_" + UUID.randomUUID().toString();

			List<Integer> l = new ArrayList<Integer>();
			l.add(0);
			l.add(0);

			//TODO: Z3 - check if really working correctly
			for (Entry<String, List<List<Integer>>> entry : inputForHyVarRec.getOptional_features().entrySet()) {

				entry.getValue().add(l);

			}
		}
		return timeContext;
	}
	
	
	
	
	private List<Expr> getBasicFormulaList(List<String> featureIds, List<Attribute> attributes,
			List<eu.hyvar.reconfigurator.input.format.Context> contexts, Expr[] z3Constraints, boolean featuresAsBoolean, Context context) {
		
		
		
		
            System.out.println("5. Building the FM formula.");		
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
		for(String f: stringFeatures) {
			featureNames[i] = ctx.mkSymbol(f);
			features[i] = (BoolExpr) ctx.mkConst(featureNames[i], ctx.getBoolSort());
			
			if(stringOptionals.contains(f)){
				System.out.println(f);
				optionalFeaturesWithoutNameChange[j] = features[i];
				j++;
			}
			i++;
			
		}
		
		
		
		BoolExpr[] optionalFeatures = new BoolExpr[optionalFeaturesWithoutNameChange.length];
		
		i=0;
		for(BoolExpr opF: optionalFeaturesWithoutNameChange) {
			BoolExpr feature = ctx.mkBoolConst(opF + "_v");
			optionalFeatures[i] = feature;
			i++;
			
		}
       
        
        solver.add(ctx.mkAtLeast(optionalFeatures, 1));
        solver.add(ctx.mkAtMost(optionalFeatures, 1));
        
        System.out.println(solver.check());

  
       solver.push();

        
        List<String> deadFeatures = searchForDeadFeatures(ctx, solver, features, optionalFeaturesWithoutNameChange, constraints,  optionalFeaturesWithoutNameChange);
        
        solver.pop();
        
       searchForVoidFeatures(ctx, solver, features, optionalFeaturesWithoutNameChange, constraints, optionalFeaturesWithoutNameChange, deadFeatures);
	}


	private List<String> searchForDeadFeatures(Context ctx, Solver solver, BoolExpr[] features, BoolExpr[] optionalFeaturesWithoutNameChange, BoolExpr[] constraints, BoolExpr[] optionalFeatures) {
		
		List<String> deadFeatures = new ArrayList<String>();
		
        BoolExpr forAll = buildForAllFormula(ctx, constraints, features, optionalFeaturesWithoutNameChange);
        
        System.out.println(forAll.toString());

        
        solver.add(forAll);
		
		while(true) {
			Status status = solver.check();
			
			if(status.equals(Status.SATISFIABLE)) {
				
				Model model = solver.getModel();
				
				for(BoolExpr feature:optionalFeatures) {
					
					
					
					
					if(model.eval(ctx.mkBoolConst(feature + "_v"), true).getBoolValue().equals(Z3_lbool.Z3_L_TRUE)) {
						System.out.println("Found dead Feature: " + feature);
						
						deadFeatures.add(feature.getSExpr());
						solver.add(ctx.mkNot(ctx.mkBoolConst(feature + "_v")));
						break;
					}
				}
				
				
			}else if(status.equals(Status.UNSATISFIABLE)) {
				
				System.out.println("No dead features anymore");
				break;
				
			}
			else {
				System.out.println("Status unknown.");
				break;
			}
			
			
		}
		
		return deadFeatures;
		

	}


	private BoolExpr buildForAllFormula(Context ctx, BoolExpr[] constraints, BoolExpr[] features,
			BoolExpr[] optionalFeatures) {
		
		
		BoolExpr and = ctx.mkAnd(constraints);
        
        BoolExpr not = ctx.mkNot(and);
        
        
        BoolExpr[] innerImplies = new BoolExpr[optionalFeatures.length];
        
        int i = 0;
        for(BoolExpr opF: optionalFeatures) {
        	 innerImplies[i] = ctx.mkImplies(ctx.mkBoolConst(opF + "_v"), opF);
        	 i++;
        }
        

        BoolExpr innerImpliesAnd = ctx.mkAnd(innerImplies);
        
        
        BoolExpr implies = ctx.mkImplies(innerImpliesAnd, not);
        
        BoolExpr forAll = ctx.mkForall(features, implies, 1, null, null, ctx.mkSymbol("Q1"), ctx.mkSymbol("skid1"));
		return forAll;
	}

	

	private BoolExpr buildForAllFormulaFalsePositive(Context ctx, BoolExpr[] constraints, BoolExpr[] features,
			BoolExpr[] optionalFeatures) {
		
		
		BoolExpr and = ctx.mkAnd(constraints);
        
        BoolExpr not = ctx.mkNot(and);
        
        
        BoolExpr[] innerImplies = new BoolExpr[optionalFeatures.length];
        
        int i = 0;
        for(BoolExpr opF: optionalFeatures) {
        	 innerImplies[i] = ctx.mkImplies(ctx.mkBoolConst(opF + "_v"), ctx.mkNot(opF));
        	 i++;
        }
        

        BoolExpr innerImpliesAnd = ctx.mkAnd(innerImplies);
        
        
        BoolExpr implies = ctx.mkImplies(innerImpliesAnd, not);
        
        BoolExpr forAll = ctx.mkForall(features, implies, 1, null, null, ctx.mkSymbol("Q1"), ctx.mkSymbol("skid1"));
		return forAll;
	}
	
private  List<String> searchForVoidFeatures(Context ctx, Solver solver, BoolExpr[] features, BoolExpr[] optionalFeaturesWithoutNameChange, BoolExpr[] constraints, BoolExpr[] optionalFeatures, List<String> deadFeatures) {
		
	List<String> falseOptionalFeature = new ArrayList<String>();
	
        BoolExpr forAll = buildForAllFormulaFalsePositive(ctx, constraints, features, optionalFeaturesWithoutNameChange);
        
        
        
        System.out.println(forAll.toString());

        
        solver.add(forAll);
        
        for(String deadFeature: deadFeatures) {
        	solver.add(ctx.mkNot(ctx.mkBoolConst(deadFeature + "_v")));
        }
        
		
		while(true) {
			Status status = solver.check();
			
			if(status.equals(Status.SATISFIABLE)) {
				
				Model model = solver.getModel();
				
				for(BoolExpr feature:optionalFeatures) {
					
					
					
					
					if(model.eval(ctx.mkBoolConst(feature + "_v"), true).getBoolValue().equals(Z3_lbool.Z3_L_TRUE)) {
						System.out.println("Found dead False Optional: " + feature);
						
						falseOptionalFeature.add(feature.getSExpr());
						
						solver.add(ctx.mkNot(ctx.mkBoolConst(feature + "_v")));
						
						break;
					}
				}
				
				
			}else if(status.equals(Status.UNSATISFIABLE)) {
				
				System.out.println("No false optional features anymore");
				break;
				
			}
			else {
				System.out.println("Status unknown.");
				break;
			}
			
			
		}
		
		return falseOptionalFeature;

	}
	
	
	
}
