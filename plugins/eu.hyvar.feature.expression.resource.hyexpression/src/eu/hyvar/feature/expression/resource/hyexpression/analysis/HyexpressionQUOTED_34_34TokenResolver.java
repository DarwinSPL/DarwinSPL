/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.analysis;

import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class HyexpressionQUOTED_34_34TokenResolver implements eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver {
	
	private eu.hyvar.feature.expression.resource.hyexpression.analysis.HyexpressionDefaultTokenResolver defaultTokenResolver = new eu.hyvar.feature.expression.resource.hyexpression.analysis.HyexpressionDefaultTokenResolver(true);
	
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, "\"", "\"", null);
		return result;
	}
	
	public void resolve(String lexem, EStructuralFeature feature, eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, "\"", "\"", null);
	}
	
	public void setOptions(Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
