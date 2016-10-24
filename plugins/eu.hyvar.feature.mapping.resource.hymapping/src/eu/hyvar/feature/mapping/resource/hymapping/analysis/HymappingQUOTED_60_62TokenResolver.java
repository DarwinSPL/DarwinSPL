/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.analysis;

import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class HymappingQUOTED_60_62TokenResolver implements eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolver {
	
	private eu.hyvar.feature.mapping.resource.hymapping.analysis.HymappingDefaultTokenResolver defaultTokenResolver = new eu.hyvar.feature.mapping.resource.hymapping.analysis.HymappingDefaultTokenResolver(true);
	
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, "<", ">", null);
		return result;
	}
	
	public void resolve(String lexem, EStructuralFeature feature, eu.hyvar.feature.mapping.resource.hymapping.IHymappingTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, "<", ">", null);
	}
	
	public void setOptions(Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
