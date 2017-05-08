/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.analysis;

import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class HymanifestQUOTED_60_62TokenResolver implements eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolver {
	
	private eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HymanifestDefaultTokenResolver defaultTokenResolver = new eu.hyvar.mspl.manifest.resource.hymanifest.analysis.HymanifestDefaultTokenResolver(true);
	
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, "<", ">", null);
		return result;
	}
	
	public void resolve(String lexem, EStructuralFeature feature, eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, "<", ">", null);
	}
	
	public void setOptions(Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
