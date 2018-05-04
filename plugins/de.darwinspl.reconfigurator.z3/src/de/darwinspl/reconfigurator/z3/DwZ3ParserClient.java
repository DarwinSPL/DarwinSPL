package de.darwinspl.reconfigurator.z3;



import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;


/**
 * Client 
 * 
 * 
 * @author Anna-Liisa
 *
 */
public class DwZ3ParserClient  {

	public static void main(String[] args) {
		

	
		CharStream stream = new ANTLRInputStream("feature[abbb] > 10");
		SpecificationGrammarLexer lexer = new SpecificationGrammarLexer(stream);
	
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		
		SpecificationGrammarParser parser = new SpecificationGrammarParser(tokenStream);
		
		ParseTree tree = parser.constraint();
		Context ctx = new Context();
		
		DwZ3TreeVisitor visitor = new DwZ3TreeVisitor(ctx);
		
		DwZ3TreeVisitorValue dwZ3TreeVisitorValue = visitor.visit(tree);
		Expr[] expressions = dwZ3TreeVisitorValue.getExpr().getArgs();
		for(Expr e: expressions) {
			System.out.println(e.toString());
			
		}
		System.out.println(expressions.toString());
		System.out.println(dwZ3TreeVisitorValue.getExpr().toString());

		
	}
	
	
 
	
	public DwZ3TreeVisitorValue parseConstraint(String constraint) {
		
		CharStream stream = new ANTLRInputStream(constraint);
		SpecificationGrammarLexer lexer = new SpecificationGrammarLexer(stream);
	
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		
		SpecificationGrammarParser parser = new SpecificationGrammarParser(tokenStream);
		
		ParseTree tree = parser.constraint();
		Context ctx = new Context();
		
		DwZ3TreeVisitor visitor = new DwZ3TreeVisitor(ctx);
		
		DwZ3TreeVisitorValue dwZ3TreeVisitorValue = visitor.visit(tree);
		
		return dwZ3TreeVisitorValue;
		
		
	}
	
}
