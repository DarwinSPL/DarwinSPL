/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.mopp;

import org.antlr.runtime3_4_0.ANTLRStringStream;
import org.antlr.runtime3_4_0.Lexer;
import org.antlr.runtime3_4_0.Token;

public class HyconstraintsAntlrScanner implements eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextScanner {
	
	private Lexer antlrLexer;
	
	public HyconstraintsAntlrScanner(Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextToken result = new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsANTLRTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new ANTLRStringStream(text));
	}
	
}
