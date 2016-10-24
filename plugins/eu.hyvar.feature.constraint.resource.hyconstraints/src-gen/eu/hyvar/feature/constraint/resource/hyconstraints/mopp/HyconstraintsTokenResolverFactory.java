/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.mopp;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The HyconstraintsTokenResolverFactory class provides access to all generated
 * token resolvers. By giving the name of a defined token, the corresponding
 * resolve can be obtained. Despite the fact that this class is called
 * TokenResolverFactory is does NOT create new token resolvers whenever a client
 * calls methods to obtain a resolver. Rather, this class maintains a map of all
 * resolvers and creates each resolver at most once.
 */
public class HyconstraintsTokenResolverFactory implements eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolverFactory {
	
	private Map<String, eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver> tokenName2TokenResolver;
	private Map<String, eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver> featureName2CollectInTokenResolver;
	private static eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver defaultResolver = new eu.hyvar.feature.constraint.resource.hyconstraints.analysis.HyconstraintsDefaultTokenResolver();
	
	public HyconstraintsTokenResolverFactory() {
		tokenName2TokenResolver = new LinkedHashMap<String, eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver>();
		featureName2CollectInTokenResolver = new LinkedHashMap<String, eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver>();
		registerTokenResolver("QUOTED_34_34", new eu.hyvar.feature.constraint.resource.hyconstraints.analysis.HyexpressionQUOTED_34_34TokenResolver());
		registerTokenResolver("IDENTIFIER_TOKEN", new eu.hyvar.feature.constraint.resource.hyconstraints.analysis.HydatavalueIDENTIFIER_TOKENTokenResolver());
		registerTokenResolver("DATE", new eu.hyvar.feature.constraint.resource.hyconstraints.analysis.HydatavalueDATETokenResolver());
		registerTokenResolver("INTEGER_LITERAL", new eu.hyvar.feature.constraint.resource.hyconstraints.analysis.HydatavalueINTEGER_LITERALTokenResolver());
	}
	
	public eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver internalCreateResolver(Map<String, eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(Map<String, eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver> resolverMap, String key, eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
