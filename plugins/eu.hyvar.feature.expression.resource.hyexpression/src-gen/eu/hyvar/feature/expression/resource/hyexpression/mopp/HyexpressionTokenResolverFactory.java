/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.mopp;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The HyexpressionTokenResolverFactory class provides access to all generated
 * token resolvers. By giving the name of a defined token, the corresponding
 * resolve can be obtained. Despite the fact that this class is called
 * TokenResolverFactory is does NOT create new token resolvers whenever a client
 * calls methods to obtain a resolver. Rather, this class maintains a map of all
 * resolvers and creates each resolver at most once.
 */
public class HyexpressionTokenResolverFactory implements eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolverFactory {
	
	private Map<String, eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver> tokenName2TokenResolver;
	private Map<String, eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver> featureName2CollectInTokenResolver;
	private static eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver defaultResolver = new eu.hyvar.feature.expression.resource.hyexpression.analysis.HyexpressionDefaultTokenResolver();
	
	public HyexpressionTokenResolverFactory() {
		tokenName2TokenResolver = new LinkedHashMap<String, eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver>();
		featureName2CollectInTokenResolver = new LinkedHashMap<String, eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver>();
		registerTokenResolver("QUOTED_34_34", new eu.hyvar.feature.expression.resource.hyexpression.analysis.HyexpressionQUOTED_34_34TokenResolver());
		registerTokenResolver("IDENTIFIER_TOKEN", new eu.hyvar.feature.expression.resource.hyexpression.analysis.HydatavalueIDENTIFIER_TOKENTokenResolver());
		registerTokenResolver("DATE", new eu.hyvar.feature.expression.resource.hyexpression.analysis.HydatavalueDATETokenResolver());
		registerTokenResolver("INTEGER_LITERAL", new eu.hyvar.feature.expression.resource.hyexpression.analysis.HydatavalueINTEGER_LITERALTokenResolver());
	}
	
	public eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver internalCreateResolver(Map<String, eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(Map<String, eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver> resolverMap, String key, eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
