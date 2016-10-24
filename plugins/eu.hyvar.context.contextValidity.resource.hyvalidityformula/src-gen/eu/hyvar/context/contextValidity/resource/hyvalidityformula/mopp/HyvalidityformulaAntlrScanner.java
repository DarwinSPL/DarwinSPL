/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp;

import org.antlr.runtime3_4_0.ANTLRStringStream;
import org.antlr.runtime3_4_0.Lexer;
import org.antlr.runtime3_4_0.Token;

public class HyvalidityformulaAntlrScanner implements eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextScanner {
	
	private Lexer antlrLexer;
	
	public HyvalidityformulaAntlrScanner(Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextToken result = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaANTLRTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new ANTLRStringStream(text));
	}
	
}
