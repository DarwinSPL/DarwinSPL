/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.mopp;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The HymanifestTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class HymanifestTokenResolverFactory implements eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolverFactory {
	
	private Map<String, eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver> tokenName2TokenResolver;
	private Map<String, eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver> featureName2CollectInTokenResolver;
	private static eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver defaultResolver = new eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HymanifestDefaultTokenResolver();
	
	public HymanifestTokenResolverFactory() {
		tokenName2TokenResolver = new LinkedHashMap<String, eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver>();
		featureName2CollectInTokenResolver = new LinkedHashMap<String, eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver>();
		registerTokenResolver("QUOTED_34_34", new eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HymanifestQUOTED_34_34TokenResolver());
		registerTokenResolver("QUOTED_60_62", new eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HymanifestQUOTED_60_62TokenResolver());
		registerTokenResolver("IDENTIFIER_TOKEN", new eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HydatavalueIDENTIFIER_TOKENTokenResolver());
		registerTokenResolver("DATE", new eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HydatavalueDATETokenResolver());
		registerTokenResolver("INTEGER_LITERAL", new eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HydatavalueINTEGER_LITERALTokenResolver());
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver internalCreateResolver(Map<String, eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(Map<String, eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver> resolverMap, String key, eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
