/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.mopp;

import org.antlr.runtime3_4_0.ANTLRStringStream;
import org.antlr.runtime3_4_0.Lexer;
import org.antlr.runtime3_4_0.Token;

public class HymanifestAntlrScanner implements eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextScanner {
	
	private Lexer antlrLexer;
	
	public HymanifestAntlrScanner(Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextToken result = new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestANTLRTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new ANTLRStringStream(text));
	}
	
}
