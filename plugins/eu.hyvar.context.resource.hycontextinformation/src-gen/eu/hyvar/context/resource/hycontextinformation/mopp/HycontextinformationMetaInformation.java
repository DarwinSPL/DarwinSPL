/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.mopp;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource.Factory;

public class HycontextinformationMetaInformation implements eu.hyvar.context.resource.hycontextinformation.IHycontextinformationMetaInformation {
	
	public String getSyntaxName() {
		return "hycontextinformation";
	}
	
	public String getURI() {
		return "http://hyvar-project.eu/feature/context/1.0";
	}
	
	public eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextScanner createLexer() {
		return new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationAntlrScanner(new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationLexer());
	}
	
	public eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextParser createParser(InputStream inputStream, String encoding) {
		return new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationParser().createInstance(inputStream, encoding);
	}
	
	public eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextPrinter createPrinter(OutputStream outputStream, eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTextResource resource) {
		return new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationPrinter2(outputStream, resource);
	}
	
	public EClass[] getClassesWithSyntax() {
		return new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public EClass[] getStartSymbols() {
		return new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public eu.hyvar.context.resource.hycontextinformation.IHycontextinformationReferenceResolverSwitch getReferenceResolverSwitch() {
		return new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationReferenceResolverSwitch();
	}
	
	public eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolverFactory getTokenResolverFactory() {
		return new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "eu.hyvar.context.information/model/ContextInformation.cs";
	}
	
	public String[] getTokenNames() {
		return eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationParser.tokenNames;
	}
	
	public eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenStyle getDefaultTokenStyle(String tokenName) {
		return new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public Collection<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationBracketPair> getBracketPairs() {
		return new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationBracketInformationProvider().getBracketPairs();
	}
	
	public EClass[] getFoldableClasses() {
		return new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationFoldingInformationProvider().getFoldableClasses();
	}
	
	public Factory createResourceFactory() {
		return new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationResourceFactory();
	}
	
	public eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationNewFileContentProvider getNewFileContentProvider() {
		return new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		// if no resource factory registered, register delegator
		if (Factory.Registry.INSTANCE.getExtensionToFactoryMap().get(getSyntaxName()) == null) {
			Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationResourceFactoryDelegator());
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
		return "eu.hyvar.context.resource.hycontextinformation.ui.launchConfigurationType";
	}
	
	public eu.hyvar.context.resource.hycontextinformation.IHycontextinformationNameProvider createNameProvider() {
		return new eu.hyvar.context.resource.hycontextinformation.analysis.HycontextinformationDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationAntlrTokenHelper tokenHelper = new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationAntlrTokenHelper();
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
		highlightableTokens.add(eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
