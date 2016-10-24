/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.mopp;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource.Factory;

public class HymappingMetaInformation implements eu.hyvar.feature.mapping.resource.hymapping.IHymappingMetaInformation {
	
	public String getSyntaxName() {
		return "hymapping";
	}
	
	public String getURI() {
		return "http://hyvar-project.eu/feature/mapping/1.0";
	}
	
	public eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextScanner createLexer() {
		return new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingAntlrScanner(new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingLexer());
	}
	
	public eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextParser createParser(InputStream inputStream, String encoding) {
		return new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingParser().createInstance(inputStream, encoding);
	}
	
	public eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextPrinter createPrinter(OutputStream outputStream, eu.hyvar.feature.mapping.resource.hymapping.IHymappingTextResource resource) {
		return new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingPrinter2(outputStream, resource);
	}
	
	public EClass[] getClassesWithSyntax() {
		return new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public EClass[] getStartSymbols() {
		return new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public eu.hyvar.feature.mapping.resource.hymapping.IHymappingReferenceResolverSwitch getReferenceResolverSwitch() {
		return new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingReferenceResolverSwitch();
	}
	
	public eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolverFactory getTokenResolverFactory() {
		return new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "eu.hyvar.feature.mapping/model/Mapping.cs";
	}
	
	public String[] getTokenNames() {
		return eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingParser.tokenNames;
	}
	
	public eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenStyle getDefaultTokenStyle(String tokenName) {
		return new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public Collection<eu.hyvar.feature.mapping.resource.hymapping.IHymappingBracketPair> getBracketPairs() {
		return new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingBracketInformationProvider().getBracketPairs();
	}
	
	public EClass[] getFoldableClasses() {
		return new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingFoldingInformationProvider().getFoldableClasses();
	}
	
	public Factory createResourceFactory() {
		return new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingResourceFactory();
	}
	
	public eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingNewFileContentProvider getNewFileContentProvider() {
		return new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		// if no resource factory registered, register delegator
		if (Factory.Registry.INSTANCE.getExtensionToFactoryMap().get(getSyntaxName()) == null) {
			Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingResourceFactoryDelegator());
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
		return "eu.hyvar.feature.mapping.resource.hymapping.ui.launchConfigurationType";
	}
	
	public eu.hyvar.feature.mapping.resource.hymapping.IHymappingNameProvider createNameProvider() {
		return new eu.hyvar.feature.mapping.resource.hymapping.analysis.HymappingDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingAntlrTokenHelper tokenHelper = new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingAntlrTokenHelper();
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
		highlightableTokens.add(eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
