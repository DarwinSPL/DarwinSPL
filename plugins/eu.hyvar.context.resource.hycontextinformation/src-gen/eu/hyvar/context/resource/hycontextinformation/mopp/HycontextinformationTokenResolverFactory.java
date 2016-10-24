/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.mopp;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The HycontextinformationTokenResolverFactory class provides access to all
 * generated token resolvers. By giving the name of a defined token, the
 * corresponding resolve can be obtained. Despite the fact that this class is
 * called TokenResolverFactory is does NOT create new token resolvers whenever a
 * client calls methods to obtain a resolver. Rather, this class maintains a map
 * of all resolvers and creates each resolver at most once.
 */
public class HycontextinformationTokenResolverFactory implements eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolverFactory {
	
	private Map<String, eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver> tokenName2TokenResolver;
	private Map<String, eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver> featureName2CollectInTokenResolver;
	private static eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver defaultResolver = new eu.hyvar.context.resource.hycontextinformation.analysis.HycontextinformationDefaultTokenResolver();
	
	public HycontextinformationTokenResolverFactory() {
		tokenName2TokenResolver = new LinkedHashMap<String, eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver>();
		featureName2CollectInTokenResolver = new LinkedHashMap<String, eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver>();
		registerTokenResolver("IDENTIFIER_TOKEN", new eu.hyvar.context.resource.hycontextinformation.analysis.HydatavalueIDENTIFIER_TOKENTokenResolver());
		registerTokenResolver("DATE", new eu.hyvar.context.resource.hycontextinformation.analysis.HydatavalueDATETokenResolver());
		registerTokenResolver("INTEGER_LITERAL", new eu.hyvar.context.resource.hycontextinformation.analysis.HydatavalueINTEGER_LITERALTokenResolver());
	}
	
	public eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver internalCreateResolver(Map<String, eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(Map<String, eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver> resolverMap, String key, eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
