/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource.Factory;

public class HyvalidityformulaMetaInformation implements eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaMetaInformation {
	
	public String getSyntaxName() {
		return "hyvalidityformula";
	}
	
	public String getURI() {
		return "http://hyvar-project.eu/context/validity/1.0";
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextScanner createLexer() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaAntlrScanner(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaLexer());
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextParser createParser(InputStream inputStream, String encoding) {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaParser().createInstance(inputStream, encoding);
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextPrinter createPrinter(OutputStream outputStream, eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTextResource resource) {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaPrinter2(outputStream, resource);
	}
	
	public EClass[] getClassesWithSyntax() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public EClass[] getStartSymbols() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceResolverSwitch getReferenceResolverSwitch() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaReferenceResolverSwitch();
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolverFactory getTokenResolverFactory() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "eu.hyvar.context.validity_formulas/model/ContextValidity.cs";
	}
	
	public String[] getTokenNames() {
		return eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaParser.tokenNames;
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenStyle getDefaultTokenStyle(String tokenName) {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public Collection<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaBracketPair> getBracketPairs() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaBracketInformationProvider().getBracketPairs();
	}
	
	public EClass[] getFoldableClasses() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaFoldingInformationProvider().getFoldableClasses();
	}
	
	public Factory createResourceFactory() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaResourceFactory();
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaNewFileContentProvider getNewFileContentProvider() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		// if no resource factory registered, register delegator
		if (Factory.Registry.INSTANCE.getExtensionToFactoryMap().get(getSyntaxName()) == null) {
			Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaResourceFactoryDelegator());
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
		return "eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.launchConfigurationType";
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaNameProvider createNameProvider() {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HyvalidityformulaDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaAntlrTokenHelper tokenHelper = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaAntlrTokenHelper();
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
		highlightableTokens.add(eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
