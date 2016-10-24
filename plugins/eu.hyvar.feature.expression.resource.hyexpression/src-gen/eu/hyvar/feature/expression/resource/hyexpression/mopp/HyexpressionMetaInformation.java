/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.mopp;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource.Factory;

public class HyexpressionMetaInformation implements eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionMetaInformation {
	
	public String getSyntaxName() {
		return "hyexpression";
	}
	
	public String getURI() {
		return "http://hyvar-project.eu/feature/expression/1.0";
	}
	
	public eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextScanner createLexer() {
		return new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionAntlrScanner(new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionLexer());
	}
	
	public eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextParser createParser(InputStream inputStream, String encoding) {
		return new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionParser().createInstance(inputStream, encoding);
	}
	
	public eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextPrinter createPrinter(OutputStream outputStream, eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTextResource resource) {
		return new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionPrinter2(outputStream, resource);
	}
	
	public EClass[] getClassesWithSyntax() {
		return new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public EClass[] getStartSymbols() {
		return new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionReferenceResolverSwitch getReferenceResolverSwitch() {
		return new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionReferenceResolverSwitch();
	}
	
	public eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolverFactory getTokenResolverFactory() {
		return new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "eu.hyvar.feature.expression/model/Expression.cs";
	}
	
	public String[] getTokenNames() {
		return eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionParser.tokenNames;
	}
	
	public eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenStyle getDefaultTokenStyle(String tokenName) {
		return new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public Collection<eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionBracketPair> getBracketPairs() {
		return new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionBracketInformationProvider().getBracketPairs();
	}
	
	public EClass[] getFoldableClasses() {
		return new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionFoldingInformationProvider().getFoldableClasses();
	}
	
	public Factory createResourceFactory() {
		return new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionResourceFactory();
	}
	
	public eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionNewFileContentProvider getNewFileContentProvider() {
		return new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		// if no resource factory registered, register delegator
		if (Factory.Registry.INSTANCE.getExtensionToFactoryMap().get(getSyntaxName()) == null) {
			Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionResourceFactoryDelegator());
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
		return "eu.hyvar.feature.expression.resource.hyexpression.ui.launchConfigurationType";
	}
	
	public eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionNameProvider createNameProvider() {
		return new eu.hyvar.feature.expression.resource.hyexpression.analysis.HyexpressionDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionAntlrTokenHelper tokenHelper = new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionAntlrTokenHelper();
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
		highlightableTokens.add(eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
