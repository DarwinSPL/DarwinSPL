/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.mopp;

import org.antlr.runtime3_4_0.ANTLRStringStream;
import org.antlr.runtime3_4_0.Lexer;
import org.antlr.runtime3_4_0.Token;

public class HydatavalueAntlrScanner implements eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextScanner {
	
	private Lexer antlrLexer;
	
	public HydatavalueAntlrScanner(Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextToken result = new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueANTLRTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new ANTLRStringStream(text));
	}
	
}
