/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.mopp;

import org.antlr.runtime3_4_0.ANTLRStringStream;
import org.antlr.runtime3_4_0.Lexer;
import org.antlr.runtime3_4_0.Token;

public class DwprofileAntlrScanner implements de.darwinspl.preferences.resource.dwprofile.IDwprofileTextScanner {
	
	private Lexer antlrLexer;
	
	public DwprofileAntlrScanner(Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public de.darwinspl.preferences.resource.dwprofile.IDwprofileTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		de.darwinspl.preferences.resource.dwprofile.IDwprofileTextToken result = new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileANTLRTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new ANTLRStringStream(text));
	}
	
}
