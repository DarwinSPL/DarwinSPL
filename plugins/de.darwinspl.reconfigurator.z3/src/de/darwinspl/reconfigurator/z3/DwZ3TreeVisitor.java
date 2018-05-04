package de.darwinspl.reconfigurator.z3;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.microsoft.z3.ArithExpr;
import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.IntExpr;



public class DwZ3TreeVisitor extends SpecificationGrammarBaseVisitor<DwZ3TreeVisitorValue>{
	
	private Context context;
	
	private boolean featureAsBoolean;

	List<String> contexts = new ArrayList<String>();
	List<String> features = new ArrayList<String>();
	List<String> attributes = new ArrayList<String>();
	
	public DwZ3TreeVisitor(Context context) {
		this.context = context;
		
	}
//	
//	@Override
//	protected Str defaultResult() {
//		
//		return "";
//	}
	
	@Override
	public DwZ3TreeVisitorValue visitTerminal(TerminalNode node) {
		
		DwZ3TreeVisitorValue v = new DwZ3TreeVisitorValue(node.getText());
		return v;
	}
	
	@Override
	protected DwZ3TreeVisitorValue aggregateResult(DwZ3TreeVisitorValue aggregate, DwZ3TreeVisitorValue nextResult) {
		
		return nextResult;
	}
	
	@Override
	public DwZ3TreeVisitorValue visitErrorNode(ErrorNode node) {
		Token token = node.getSymbol();
		System.err.println("Erroneous Node " + token.getText());
		return null;
		
	}
	
	@Override
	public DwZ3TreeVisitorValue visitConstraintPreference(SpecificationGrammarParser.ConstraintPreferenceContext ctx) {
		DwZ3TreeVisitorValue formula = ctx.getChild(0).accept(this);
		
		DwZ3TreeVisitorValue v = new DwZ3TreeVisitorValue("");
		if(formula.getExpr() instanceof BoolExpr) {


			
			BoolExpr if1 = context.mkIff((BoolExpr)formula.getExpr().simplify(), context.mkBool(true));
			BoolExpr if2 = context.mkIff(context.mkNot((BoolExpr) formula.getExpr().simplify()), context.mkBool(false));
			v.setExpr(context.mkAnd(if1, if2));
			
		}else {
			v.setExpr(formula.getExpr().simplify());
		}
		return v;
		
	}
	
	


	
	@Override
	public DwZ3TreeVisitorValue visitMinMaxPreference(SpecificationGrammarParser.MinMaxPreferenceContext ctx) {
		//min or max
		String op = ctx.getChild(0).accept(this).getTokenString();
		
		DwZ3TreeVisitorValue attribute = ctx.getChild(3).accept(this);
		
		DwZ3TreeVisitorValue v = new DwZ3TreeVisitorValue("");
		if(op == "min") {
			
			Expr expr = context.mkSub(context.mkInt(0), (IntExpr)attribute.getExpr());
			v.setExpr(expr.simplify());
			

		}
		else {
			v.setExpr(attribute.getExpr());
		}
		
		return v;
		
		
	}
	
	@Override
	public DwZ3TreeVisitorValue visitConstraint(SpecificationGrammarParser.ConstraintContext ctx) {
		return ctx.getChild(0).accept(this);
	}
	
	@Override
	public DwZ3TreeVisitorValue visitB_expr(SpecificationGrammarParser.B_exprContext ctx) {
		DwZ3TreeVisitorValue formula =  ctx.getChild(0).accept(this);
		
		for(int i=1; i < ctx.getChildCount(); i = i++) {
			DwZ3TreeVisitorValue op =  ctx.getChild(i).accept(this);
			DwZ3TreeVisitorValue f =  ctx.getChild(i+1).accept(this);
			
		
			if(op.getTokenString().equals("and")) {
				formula.setExpr(context.mkAnd((BoolExpr)formula.getExpr(),(BoolExpr) f.getExpr()));	
			} else if(op.getTokenString().contentEquals("or")) {
				formula.setExpr(context.mkOr((BoolExpr)formula.getExpr(),(BoolExpr) f.getExpr()));	
			}
			else if (op.getTokenString().equals("impl")) {
				formula.setExpr(context.mkImplies((BoolExpr)formula.getExpr(),(BoolExpr) f.getExpr()));	
				
			} 
			else if(op.getTokenString().equals("iff")) {
				BoolExpr expr = context.mkAnd(context.mkImplies((BoolExpr)formula.getExpr(), (BoolExpr) f.getExpr()), context.mkImplies( (BoolExpr) f.getExpr(),  (BoolExpr) formula.getExpr()));
				formula.setExpr(expr.simplify());
			} else if (op.getTokenString().equals("xor")) {
				BoolExpr expr = context.mkAnd(context.mkImplies((BoolExpr) formula.getExpr(), context.mkNot((BoolExpr) f.getExpr())), context.mkImplies(context.mkNot((BoolExpr) formula.getExpr()), (BoolExpr) f.getExpr()));
				formula.setExpr(expr.simplify());
			}
			else {
				//Todo: Throw exception
				System.out.println("Error");
			}
		}
		return formula;
	}
	
	/*
	 * b_term : (NOT)? b_factor ;
	 * 
	 * 
	 * @see SpecificationGrammarBaseVisitor#visitB_term(SpecificationGrammarParser.B_termContext)
	 */
	@Override
	public DwZ3TreeVisitorValue visitB_term(SpecificationGrammarParser.B_termContext ctx) {
		//The last element of an b_term is always a b_factor
		DwZ3TreeVisitorValue formula = ctx.getChild(ctx.getChildCount() - 1).accept(this);
		
		//if the number of childs exceeds 1 - there must be an NOT before the b_factor
		if(ctx.getChildCount()>1) {
			formula.setExpr(context.mkNot((BoolExpr) formula.getExpr()));
			return formula;
		}
		else {
			//if the b_term only consists of the b_factor - return the b_factor
			return formula;
		}
	}
	
	
	@Override
	public DwZ3TreeVisitorValue visitBFactorOneOnly(SpecificationGrammarParser.BFactorOneOnlyContext ctx) {
		List<DwZ3TreeVisitorValue> dwZ3TreeVisitorValues = new ArrayList<DwZ3TreeVisitorValue>();
				
		for(int i=2; i < ctx.getChildCount() -1; i= i+2) {
			dwZ3TreeVisitorValues.add(ctx.getChild(0).accept(this));
			
		}
		if(dwZ3TreeVisitorValues.isEmpty()) {
			DwZ3TreeVisitorValue v = new DwZ3TreeVisitorValue("");
			v.setExpr(context.mkBool(false));
			return v;
		} else if(dwZ3TreeVisitorValues.size()==1) {
			return dwZ3TreeVisitorValues.get(0);
			
		}
		BoolExpr[] a = new BoolExpr[dwZ3TreeVisitorValues.size()-1];
		int[] ia = new int[dwZ3TreeVisitorValues.size()-1];
		int i=0;
		for(DwZ3TreeVisitorValue v: dwZ3TreeVisitorValues) {
			a[i] = (BoolExpr) v.getExpr();
			ia[i] = 1;
			i++;
		}
		DwZ3TreeVisitorValue result = new DwZ3TreeVisitorValue("");
		
		
		result.setExpr(context.mkPBEq(ia, a, 1));
		
		return result;
	
	}
	
	@Override
	public DwZ3TreeVisitorValue visitRelation(SpecificationGrammarParser.RelationContext ctx) {
		DwZ3TreeVisitorValue formula = ctx.getChild(0).accept(this);
		
		for(int i=1; i<ctx.getChildCount(); i = i+2) {
			DwZ3TreeVisitorValue op =  ctx.getChild(i).accept(this);
			DwZ3TreeVisitorValue f =  ctx.getChild(i+1).accept(this);
			
			// <=
			if(op.getTokenString().equals("<=")) {
				
				Expr expr = context.mkLe((ArithExpr)formula.getExpr(),(ArithExpr) f.getExpr());
				formula.setExpr((ArithExpr) expr.simplify());
				
				
			}
			// =
			else if(op.getTokenString().equals("=")) {
				Expr expr = context.mkEq((ArithExpr)formula.getExpr(),(ArithExpr) f.getExpr());
				formula.setExpr((ArithExpr) expr.simplify());
			}
			// >=
			else if(op.getTokenString().equals(">=")) {
				Expr expr = context.mkGe((ArithExpr)formula.getExpr(),(ArithExpr) f.getExpr());
				formula.setExpr(expr.simplify());
			}
			// <
			else if(op.getTokenString().equals("<")) {
				Expr expr = context.mkLt((ArithExpr)formula.getExpr(),(ArithExpr) f.getExpr());
				formula.setExpr(expr.simplify());
				
			}
			// >
			
			else if(op.getTokenString().equals(">")) {
				Expr expr = context.mkGt((ArithExpr)formula.getExpr(),(ArithExpr) f.getExpr());
				formula.setExpr( expr.simplify());
			}
			// !=
			else if(op.getTokenString().equals("!=")) {
				//ctx.mkNot(ctx.mkEq(tup1, tup2))
				//TODO: does this really work?
				Expr expr = context.mkNot(context.mkEq((ArithExpr)formula.getExpr(),(ArithExpr) f.getExpr()));
				formula.setExpr( expr.simplify());
				
			}
			else {
				//TODO: throw Exception
			}
			
				
		}
		return formula;
	}
	
	@Override
	public DwZ3TreeVisitorValue visitExpr(SpecificationGrammarParser.ExprContext ctx) {
		DwZ3TreeVisitorValue formula = ctx.getChild(0).accept(this);
		int num = ctx.getChildCount();
		
		if(num == 1 && featureAsBoolean) {
			return formula;
			
		}
		for(int i=1; i<num; i= i+2) {
			DwZ3TreeVisitorValue op = ctx.getChild(i).accept(this);
			DwZ3TreeVisitorValue f = ctx.getChild(i +1).accept(this);
			
			if(formula.getExpr() instanceof BoolExpr) {
				//TODO: if formula
//				formula = context.mkif
			}
			if(f.getExpr() instanceof BoolExpr) {
				//TODO: if formula
			}
			if(op.getTokenString().equals("+")) {
				formula.setExpr(context.mkAdd((ArithExpr)formula.getExpr(), (ArithExpr)f.getExpr()).simplify());
				
			}
			else if(op.getTokenString().equals("-")) {
				formula.setExpr(context.mkSub((ArithExpr)formula.getExpr(), (ArithExpr)f.getExpr()).simplify());
			}
			else if (op.getTokenString().equals("*")) {
				formula.setExpr(context.mkMul((ArithExpr)formula.getExpr(), (ArithExpr)f.getExpr()).simplify());
			}
			else {
				//TODO: Raise Exception
			}
		}
		
		return formula;
	}
	
	
	@Override
	public DwZ3TreeVisitorValue visitTermInt(SpecificationGrammarParser.TermIntContext ctx) {
		DwZ3TreeVisitorValue v =  ctx.getChild(0).accept(this);
		v.setExpr(context.mkInt(v.getTokenString()));
		
		return v;
	}
	
	@Override
	public DwZ3TreeVisitorValue visitTermContext(SpecificationGrammarParser.TermContextContext ctx) {
		String id = ctx.getChild(1).accept(this).getTokenString();
		
		contexts.add(id);
		
		DwZ3TreeVisitorValue v = new DwZ3TreeVisitorValue(id);
		v.setExpr(context.mkIntConst(id));
		return v;
		
	}
	
	@Override
	public DwZ3TreeVisitorValue visitTermFeature(SpecificationGrammarParser.TermFeatureContext ctx) {
		String id = ctx.getChild(1).accept(this).getTokenString();
		
		features.add(id);
		DwZ3TreeVisitorValue v = new DwZ3TreeVisitorValue(id);
		
		if(featureAsBoolean) {
			v.setExpr(context.mkBoolConst(id));
			return v;
		}
		
		v.setExpr(context.mkIntConst(id));
		return v;
	}
	

	
	@Override
	public DwZ3TreeVisitorValue visitTermAttribute(SpecificationGrammarParser.TermAttributeContext ctx) {
		
		String id = ctx.getChild(1).accept(this).getTokenString();
		attributes.add(id);
		
		DwZ3TreeVisitorValue v = new DwZ3TreeVisitorValue(id);
		v.setExpr(context.mkIntConst(id));
		return v;
	
	}
	
	@Override
	public DwZ3TreeVisitorValue visitBoolFact(SpecificationGrammarParser.BoolFactContext ctx) {
		String fact = ctx.getChild(0).accept(this).getTokenString();
		DwZ3TreeVisitorValue v = new DwZ3TreeVisitorValue(fact);
		if(fact.equals("true")) {
			v.setExpr(context.mkBool(true).simplify());
			return v;
		}
		v.setExpr(context.mkBool(false).simplify());
		return v;
	}
	
	
	
	
	
	
	
}
