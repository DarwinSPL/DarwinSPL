/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.analysis;

import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class HyexpressionQUOTED_34_34TokenResolver implements de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolver {
	
	private eu.hyvar.feature.expression.resource.hyexpression.analysis.HyexpressionQUOTED_34_34TokenResolver importedResolver = new eu.hyvar.feature.expression.resource.hyexpression.analysis.HyexpressionQUOTED_34_34TokenResolver();
	
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		String result = importedResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(String lexem, EStructuralFeature feature, final de.darwinspl.preferences.resource.dwprofile.IDwprofileTokenResolveResult result) {
		importedResolver.resolve(lexem, feature, new eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult() {
			public String getErrorMessage() {
				return result.getErrorMessage();
			}
			
			public Object getResolvedToken() {
				return result.getResolvedToken();
			}
			
			public void setErrorMessage(String message) {
				result.setErrorMessage(message);
			}
			
			public void setResolvedToken(Object resolvedToken) {
				result.setResolvedToken(resolvedToken);
			}
			
		});
	}
	
	public void setOptions(Map<?,?> options) {
		importedResolver.setOptions(options);
	}
	
}
