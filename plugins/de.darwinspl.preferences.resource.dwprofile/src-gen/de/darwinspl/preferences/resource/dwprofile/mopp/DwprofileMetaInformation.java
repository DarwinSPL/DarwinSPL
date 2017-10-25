/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.mopp;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource.Factory;

public class DwprofileMetaInformation implements de.darwinspl.preferences.resource.dwprofile.IDwprofileMetaInformation {
	
	public String getSyntaxName() {
		return "dwprofile";
	}
	
	public String getURI() {
		return "http://darwinspl.de/feature/preferences/1.0";
	}
	
	public de.darwinspl.preferences.resource.dwprofile.IDwprofileTextScanner createLexer() {
		return new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileAntlrScanner(new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileLexer());
	}
	
	public de.darwinspl.preferences.resource.dwprofile.IDwprofileTextParser createParser(InputStream inputStream, String encoding) {
		return new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileParser().createInstance(inputStream, encoding);
	}
	
	public de.darwinspl.preferences.resource.dwprofile.IDwprofileTextPrinter createPrinter(OutputStream outputStream, de.darwinspl.preferences.resource.dwprofile.IDwprofileTextResource resource) {
		return new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofilePrinter2(outputStream, resource);
	}
	
	public EClass[] getClassesWithSyntax() {
		return new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public EClass[] getStartSymbols() {
		return new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolverSwitch getReferenceResolverSwitch() {
		return new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileReferenceResolverSwitch();
	}
	
	public de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolverFactory getTokenResolverFactory() {
		return new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "de.darwinspl.preferences/model/Preferences.cs";
	}
	
	public String[] getTokenNames() {
		return de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileParser.tokenNames;
	}
	
	public de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenStyle getDefaultTokenStyle(String tokenName) {
		return new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public Collection<de.darwinspl.preferences.resource.dwprofile.IDwprofileBracketPair> getBracketPairs() {
		return new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileBracketInformationProvider().getBracketPairs();
	}
	
	public EClass[] getFoldableClasses() {
		return new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileFoldingInformationProvider().getFoldableClasses();
	}
	
	public Factory createResourceFactory() {
		return new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileResourceFactory();
	}
	
	public de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileNewFileContentProvider getNewFileContentProvider() {
		return new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		// if no resource factory registered, register delegator
		if (Factory.Registry.INSTANCE.getExtensionToFactoryMap().get(getSyntaxName()) == null) {
			Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileResourceFactoryDelegator());
		}
	}
	
	/**
	 * Returns the key of the option that can be used to register a preprocessor that
	 * is used as a pipe when loading resources. This key is language-specific. To
	 * register one preprocessor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getInputStreamPreprocessorProviderOptionKey() {
		return getSyntaxName() + "_" + "INPUT_STREAM_PREPROCESSOR_PROVIDER";
	}
	
	/**
	 * Returns the key of the option that can be used to register a post-processors
	 * that are invoked after loading resources. This key is language-specific. To
	 * register one post-processor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getResourcePostProcessorProviderOptionKey() {
		return getSyntaxName() + "_" + "RESOURCE_POSTPROCESSOR_PROVIDER";
	}
	
	public String getLaunchConfigurationType() {
		return "de.darwinspl.preferences.resource.dwprofile.ui.launchConfigurationType";
	}
	
	public de.darwinspl.preferences.resource.dwprofile.IDwprofileNameProvider createNameProvider() {
		return new de.darwinspl.preferences.resource.dwprofile.analysis.DwprofileDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileAntlrTokenHelper tokenHelper = new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileAntlrTokenHelper();
		List<String> highlightableTokens = new ArrayList<String>();
		String[] parserTokenNames = getTokenNames();
		for (int i = 0; i < parserTokenNames.length; i++) {
			// If ANTLR is used we need to normalize the token names
			if (!tokenHelper.canBeUsedForSyntaxHighlighting(i)) {
				continue;
			}
			String tokenName = tokenHelper.getTokenName(parserTokenNames, i);
			if (tokenName == null) {
				continue;
			}
			highlightableTokens.add(tokenName);
		}
		highlightableTokens.add(de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
