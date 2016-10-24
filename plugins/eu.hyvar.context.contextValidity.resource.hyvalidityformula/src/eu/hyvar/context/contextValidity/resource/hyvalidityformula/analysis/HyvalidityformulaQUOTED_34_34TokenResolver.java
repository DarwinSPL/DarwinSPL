/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis;

import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class HyvalidityformulaQUOTED_34_34TokenResolver implements eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver {
	
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HyvalidityformulaDefaultTokenResolver defaultTokenResolver = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HyvalidityformulaDefaultTokenResolver(true);
	
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, "\"", "\"", null);
		return result;
	}
	
	public void resolve(String lexem, EStructuralFeature feature, eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, "\"", "\"", null);
	}
	
	public void setOptions(Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
