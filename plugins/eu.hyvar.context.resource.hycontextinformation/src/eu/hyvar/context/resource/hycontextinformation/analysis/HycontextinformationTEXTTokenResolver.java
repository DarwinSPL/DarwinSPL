/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.analysis;

import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class HycontextinformationTEXTTokenResolver implements eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver {
	
	private eu.hyvar.context.resource.hycontextinformation.analysis.HycontextinformationDefaultTokenResolver defaultTokenResolver = new eu.hyvar.context.resource.hycontextinformation.analysis.HycontextinformationDefaultTokenResolver(true);
	
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, null, null, null);
		return result;
	}
	
	public void resolve(String lexem, EStructuralFeature feature, eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, null, null, null);
	}
	
	public void setOptions(Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
