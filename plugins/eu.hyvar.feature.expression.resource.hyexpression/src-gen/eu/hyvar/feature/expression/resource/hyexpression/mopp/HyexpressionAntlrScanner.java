/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.mopp;

import org.antlr.runtime3_4_0.ANTLRStringStream;
import org.antlr.runtime3_4_0.Lexer;
import org.antlr.runtime3_4_0.Token;

public class HyexpressionAntlrScanner implements eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextScanner {
	
	private Lexer antlrLexer;
	
	public HyexpressionAntlrScanner(Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextToken result = new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionANTLRTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new ANTLRStringStream(text));
	}
	
}
