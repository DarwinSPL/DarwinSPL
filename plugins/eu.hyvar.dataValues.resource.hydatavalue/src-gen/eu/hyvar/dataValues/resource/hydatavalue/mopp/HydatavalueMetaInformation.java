/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.mopp;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource.Factory;

public class HydatavalueMetaInformation implements eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueMetaInformation {
	
	public String getSyntaxName() {
		return "hydatavalue";
	}
	
	public String getURI() {
		return "http://hyvar-project.eu/feature/dataValues/1.0";
	}
	
	public eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextScanner createLexer() {
		return new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueAntlrScanner(new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueLexer());
	}
	
	public eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextParser createParser(InputStream inputStream, String encoding) {
		return new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueParser().createInstance(inputStream, encoding);
	}
	
	public eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextPrinter createPrinter(OutputStream outputStream, eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTextResource resource) {
		return new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavaluePrinter2(outputStream, resource);
	}
	
	public EClass[] getClassesWithSyntax() {
		return new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public EClass[] getStartSymbols() {
		return new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueReferenceResolverSwitch getReferenceResolverSwitch() {
		return new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueReferenceResolverSwitch();
	}
	
	public eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolverFactory getTokenResolverFactory() {
		return new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "eu.hyvar.feature.data/model/DataValues.cs";
	}
	
	public String[] getTokenNames() {
		return eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueParser.tokenNames;
	}
	
	public eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenStyle getDefaultTokenStyle(String tokenName) {
		return new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public Collection<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueBracketPair> getBracketPairs() {
		return new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueBracketInformationProvider().getBracketPairs();
	}
	
	public EClass[] getFoldableClasses() {
		return new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueFoldingInformationProvider().getFoldableClasses();
	}
	
	public Factory createResourceFactory() {
		return new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueResourceFactory();
	}
	
	public eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueNewFileContentProvider getNewFileContentProvider() {
		return new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		// if no resource factory registered, register delegator
		if (Factory.Registry.INSTANCE.getExtensionToFactoryMap().get(getSyntaxName()) == null) {
			Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueResourceFactoryDelegator());
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
		return "eu.hyvar.dataValues.resource.hydatavalue.ui.launchConfigurationType";
	}
	
	public eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueNameProvider createNameProvider() {
		return new eu.hyvar.dataValues.resource.hydatavalue.analysis.HydatavalueDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueAntlrTokenHelper tokenHelper = new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueAntlrTokenHelper();
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
		highlightableTokens.add(eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
