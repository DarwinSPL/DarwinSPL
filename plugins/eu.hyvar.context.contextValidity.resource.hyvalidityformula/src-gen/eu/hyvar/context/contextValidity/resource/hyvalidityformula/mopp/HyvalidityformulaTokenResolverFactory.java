/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The HyvalidityformulaTokenResolverFactory class provides access to all
 * generated token resolvers. By giving the name of a defined token, the
 * corresponding resolve can be obtained. Despite the fact that this class is
 * called TokenResolverFactory is does NOT create new token resolvers whenever a
 * client calls methods to obtain a resolver. Rather, this class maintains a map
 * of all resolvers and creates each resolver at most once.
 */
public class HyvalidityformulaTokenResolverFactory implements eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolverFactory {
	
	private Map<String, eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver> tokenName2TokenResolver;
	private Map<String, eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver> featureName2CollectInTokenResolver;
	private static eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver defaultResolver = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HyvalidityformulaDefaultTokenResolver();
	
	public HyvalidityformulaTokenResolverFactory() {
		tokenName2TokenResolver = new LinkedHashMap<String, eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver>();
		featureName2CollectInTokenResolver = new LinkedHashMap<String, eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver>();
		registerTokenResolver("QUOTED_34_34", new eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HyvalidityformulaQUOTED_34_34TokenResolver());
		registerTokenResolver("IDENTIFIER_TOKEN", new eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HydatavalueIDENTIFIER_TOKENTokenResolver());
		registerTokenResolver("DATE", new eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HydatavalueDATETokenResolver());
		registerTokenResolver("INTEGER_LITERAL", new eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HydatavalueINTEGER_LITERALTokenResolver());
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver internalCreateResolver(Map<String, eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(Map<String, eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver> resolverMap, String key, eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
