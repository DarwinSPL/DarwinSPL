/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.mopp;

import org.antlr.runtime3_4_0.ANTLRStringStream;
import org.antlr.runtime3_4_0.Lexer;
import org.antlr.runtime3_4_0.Token;

public class HycontextinformationAntlrScanner implements eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextScanner {
	
	private Lexer antlrLexer;
	
	public HycontextinformationAntlrScanner(Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextToken result = new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationANTLRTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new ANTLRStringStream(text));
	}
	
}
