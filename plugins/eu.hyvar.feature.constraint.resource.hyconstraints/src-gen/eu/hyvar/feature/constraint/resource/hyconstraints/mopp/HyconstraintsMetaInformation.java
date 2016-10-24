/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.mopp;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource.Factory;

public class HyconstraintsMetaInformation implements eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsMetaInformation {
	
	public String getSyntaxName() {
		return "hyconstraints";
	}
	
	public String getURI() {
		return "http://hyvar-project.eu/feature/constraint/1.0";
	}
	
	public eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextScanner createLexer() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsAntlrScanner(new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsLexer());
	}
	
	public eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextParser createParser(InputStream inputStream, String encoding) {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsParser().createInstance(inputStream, encoding);
	}
	
	public eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextPrinter createPrinter(OutputStream outputStream, eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextResource resource) {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsPrinter2(outputStream, resource);
	}
	
	public EClass[] getClassesWithSyntax() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public EClass[] getStartSymbols() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsReferenceResolverSwitch getReferenceResolverSwitch() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsReferenceResolverSwitch();
	}
	
	public eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolverFactory getTokenResolverFactory() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "eu.hyvar.feature.constraint/model/Constraint.cs";
	}
	
	public String[] getTokenNames() {
		return eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsParser.tokenNames;
	}
	
	public eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenStyle getDefaultTokenStyle(String tokenName) {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public Collection<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsBracketPair> getBracketPairs() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsBracketInformationProvider().getBracketPairs();
	}
	
	public EClass[] getFoldableClasses() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsFoldingInformationProvider().getFoldableClasses();
	}
	
	public Factory createResourceFactory() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsResourceFactory();
	}
	
	public eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsNewFileContentProvider getNewFileContentProvider() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		// if no resource factory registered, register delegator
		if (Factory.Registry.INSTANCE.getExtensionToFactoryMap().get(getSyntaxName()) == null) {
			Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsResourceFactoryDelegator());
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
		return "eu.hyvar.feature.constraint.resource.hyconstraints.ui.launchConfigurationType";
	}
	
	public eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsNameProvider createNameProvider() {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.analysis.HyconstraintsDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsAntlrTokenHelper tokenHelper = new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsAntlrTokenHelper();
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
		highlightableTokens.add(eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
