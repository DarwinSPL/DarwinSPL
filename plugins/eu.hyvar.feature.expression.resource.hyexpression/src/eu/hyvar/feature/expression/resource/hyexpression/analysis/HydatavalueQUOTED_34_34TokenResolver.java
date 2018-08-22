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

public class HydatavalueQUOTED_34_34TokenResolver implements eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolver {
	
	private eu.hyvar.dataValues.resource.hydatavalue.analysis.HydatavalueQUOTED_34_34TokenResolver importedResolver = new eu.hyvar.dataValues.resource.hydatavalue.analysis.HydatavalueQUOTED_34_34TokenResolver();
	
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		String result = importedResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(String lexem, EStructuralFeature feature, final eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionTokenResolveResult result) {
		importedResolver.resolve(lexem, feature, new eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult() {
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
