/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.mopp;

import org.antlr.runtime3_4_0.ANTLRStringStream;
import org.antlr.runtime3_4_0.Lexer;
import org.antlr.runtime3_4_0.Token;

public class HymappingAntlrScanner implements eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextScanner {
	
	private Lexer antlrLexer;
	
	public HymappingAntlrScanner(Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextToken result = new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingANTLRTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new ANTLRStringStream(text));
	}
	
}
