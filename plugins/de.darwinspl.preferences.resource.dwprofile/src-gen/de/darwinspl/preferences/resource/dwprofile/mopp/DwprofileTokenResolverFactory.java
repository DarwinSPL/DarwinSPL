/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.mopp;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The DwprofileTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class DwprofileTokenResolverFactory implements de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolverFactory {
	
	private Map<String, de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver> tokenName2TokenResolver;
	private Map<String, de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver> featureName2CollectInTokenResolver;
	private static de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver defaultResolver = new de.darwinspl.preferences.resource.dwprofile.analysis.DwprofileDefaultTokenResolver();
	
	public DwprofileTokenResolverFactory() {
		tokenName2TokenResolver = new LinkedHashMap<String, de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver>();
		featureName2CollectInTokenResolver = new LinkedHashMap<String, de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver>();
		registerTokenResolver("QUOTED_34_34", new de.darwinspl.preferences.resource.dwprofile.analysis.HyexpressionQUOTED_34_34TokenResolver());
		registerTokenResolver("IDENTIFIER_TOKEN", new de.darwinspl.preferences.resource.dwprofile.analysis.HydatavalueIDENTIFIER_TOKENTokenResolver());
		registerTokenResolver("DATE", new de.darwinspl.preferences.resource.dwprofile.analysis.HydatavalueDATETokenResolver());
		registerTokenResolver("INTEGER_LITERAL", new de.darwinspl.preferences.resource.dwprofile.analysis.HydatavalueINTEGER_LITERALTokenResolver());
	}
	
	public de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver internalCreateResolver(Map<String, de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(Map<String, de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver> resolverMap, String key, de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
