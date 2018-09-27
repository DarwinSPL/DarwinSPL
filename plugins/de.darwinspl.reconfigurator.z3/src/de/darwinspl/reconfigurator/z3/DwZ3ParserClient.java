package de.darwinspl.reconfigurator.z3;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.TestRig;
import org.antlr.v4.runtime.tree.ParseTree;

import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
import com.microsoft.z3.Solver;
import com.microsoft.z3.Status;


/**
 * Client 
 * 
 * 
 * @author Anna-Liisa
 *
 */
public class DwZ3ParserClient  {
	
	
	
	private List<String> features = new ArrayList<String>();
	

	
		
		

	
	
 
	public Expr[] parseConstraints(List<String> constraints, Context context, Boolean featuresAsBoolean) {
		
		Expr[] expr = new BoolExpr[constraints.size()];
		
		int i = 0;
		for(String c: constraints) {
			try {
				
				
			expr[i] = parseConstraint(c, context, featuresAsBoolean).getExpr();
			
			i++;
			} catch (ArrayStoreException e) {
				e.printStackTrace();
				
			}
		}
		
		return expr;

	}
	
	
	public DwZ3TreeVisitorValue parseConstraint(String constraint, Context context, Boolean featuresAsBoolean) {
		
		CharStream stream = new ANTLRInputStream(constraint);
		SpecificationGrammarLexer lexer = new SpecificationGrammarLexer(stream);
	
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		
		SpecificationGrammarParser parser = new SpecificationGrammarParser(tokenStream);
		
		ParseTree tree = parser.constraint();
	
		
		DwZ3TreeVisitor visitor = new DwZ3TreeVisitor(context, featuresAsBoolean);
		

		
		DwZ3TreeVisitorValue dwZ3TreeVisitorValue = visitor.visit(tree);
		
		updateFeatures(visitor.getFeatures());
		

	
		
		
		
		
		return dwZ3TreeVisitorValue;
		
		
	}
	
	
	public List<String> getFeatures(){
		return this.features;
	}
	
	public void updateFeatures(List<String> features) {
		//TODO: Z3 - Does this really nead to be done for each feature?
		for(String newF: features) {
			
			if(!this.features.contains(newF)) {
				this.features.add(newF);
			}
			
		}
	}
	
	
	
	
}