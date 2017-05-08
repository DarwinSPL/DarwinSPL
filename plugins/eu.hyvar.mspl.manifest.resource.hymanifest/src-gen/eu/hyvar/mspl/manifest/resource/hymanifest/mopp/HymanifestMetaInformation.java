/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.mopp;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource.Factory;

public class HymanifestMetaInformation implements eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestMetaInformation {
	
	public String getSyntaxName() {
		return "hymanifest";
	}
	
	public String getURI() {
		return "http://hyvar-project.eu/mspl/manifest/1.0";
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextScanner createLexer() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestAntlrScanner(new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestLexer());
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextParser createParser(InputStream inputStream, String encoding) {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestParser().createInstance(inputStream, encoding);
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextPrinter createPrinter(OutputStream outputStream, eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextResource resource) {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestPrinter2(outputStream, resource);
	}
	
	public EClass[] getClassesWithSyntax() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public EClass[] getStartSymbols() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolverSwitch getReferenceResolverSwitch() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestReferenceResolverSwitch();
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolverFactory getTokenResolverFactory() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "eu.hyvar.mspl.manifest/model/Manifest.cs";
	}
	
	public String[] getTokenNames() {
		return eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestParser.tokenNames;
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenStyle getDefaultTokenStyle(String tokenName) {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public Collection<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestBracketPair> getBracketPairs() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestBracketInformationProvider().getBracketPairs();
	}
	
	public EClass[] getFoldableClasses() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestFoldingInformationProvider().getFoldableClasses();
	}
	
	public Factory createResourceFactory() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestResourceFactory();
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestNewFileContentProvider getNewFileContentProvider() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		// if no resource factory registered, register delegator
		if (Factory.Registry.INSTANCE.getExtensionToFactoryMap().get(getSyntaxName()) == null) {
			Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestResourceFactoryDelegator());
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
		return "eu.hyvar.mspl.manifest.resource.hymanifest.ui.launchConfigurationType";
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestNameProvider createNameProvider() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HymanifestDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestAntlrTokenHelper tokenHelper = new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestAntlrTokenHelper();
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
		highlightableTokens.add(eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
