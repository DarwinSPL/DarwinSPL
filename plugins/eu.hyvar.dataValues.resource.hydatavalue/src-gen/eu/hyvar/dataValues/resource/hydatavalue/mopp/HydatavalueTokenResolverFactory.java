/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.mopp;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The HydatavalueTokenResolverFactory class provides access to all generated
 * token resolvers. By giving the name of a defined token, the corresponding
 * resolve can be obtained. Despite the fact that this class is called
 * TokenResolverFactory is does NOT create new token resolvers whenever a client
 * calls methods to obtain a resolver. Rather, this class maintains a map of all
 * resolvers and creates each resolver at most once.
 */
public class HydatavalueTokenResolverFactory implements eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolverFactory {
	
	private Map<String, eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver> tokenName2TokenResolver;
	private Map<String, eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver> featureName2CollectInTokenResolver;
	private static eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver defaultResolver = new eu.hyvar.dataValues.resource.hydatavalue.analysis.HydatavalueDefaultTokenResolver();
	
	public HydatavalueTokenResolverFactory() {
		tokenName2TokenResolver = new LinkedHashMap<String, eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver>();
		featureName2CollectInTokenResolver = new LinkedHashMap<String, eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver>();
		registerTokenResolver("IDENTIFIER_TOKEN", new eu.hyvar.dataValues.resource.hydatavalue.analysis.HydatavalueIDENTIFIER_TOKENTokenResolver());
		registerTokenResolver("DATE", new eu.hyvar.dataValues.resource.hydatavalue.analysis.HydatavalueDATETokenResolver());
		registerTokenResolver("INTEGER_LITERAL", new eu.hyvar.dataValues.resource.hydatavalue.analysis.HydatavalueINTEGER_LITERALTokenResolver());
	}
	
	public eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver internalCreateResolver(Map<String, eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(Map<String, eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver> resolverMap, String key, eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
