/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.mopp;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The HymappingTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class HymappingTokenResolverFactory implements eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolverFactory {
	
	private Map<String, eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver> tokenName2TokenResolver;
	private Map<String, eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver> featureName2CollectInTokenResolver;
	private static eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver defaultResolver = new eu.hyvar.feature.mapping.resource.hymapping.analysis.HymappingDefaultTokenResolver();
	
	public HymappingTokenResolverFactory() {
		tokenName2TokenResolver = new LinkedHashMap<String, eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver>();
		featureName2CollectInTokenResolver = new LinkedHashMap<String, eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver>();
		registerTokenResolver("QUOTED_60_62", new eu.hyvar.feature.mapping.resource.hymapping.analysis.HymappingQUOTED_60_62TokenResolver());
		registerTokenResolver("QUOTED_34_34", new eu.hyvar.feature.mapping.resource.hymapping.analysis.HyexpressionQUOTED_34_34TokenResolver());
		registerTokenResolver("IDENTIFIER_TOKEN", new eu.hyvar.feature.mapping.resource.hymapping.analysis.HydatavalueIDENTIFIER_TOKENTokenResolver());
		registerTokenResolver("DATE", new eu.hyvar.feature.mapping.resource.hymapping.analysis.HydatavalueDATETokenResolver());
		registerTokenResolver("INTEGER_LITERAL", new eu.hyvar.feature.mapping.resource.hymapping.analysis.HydatavalueINTEGER_LITERALTokenResolver());
	}
	
	public eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver internalCreateResolver(Map<String, eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(Map<String, eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver> resolverMap, String key, eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
