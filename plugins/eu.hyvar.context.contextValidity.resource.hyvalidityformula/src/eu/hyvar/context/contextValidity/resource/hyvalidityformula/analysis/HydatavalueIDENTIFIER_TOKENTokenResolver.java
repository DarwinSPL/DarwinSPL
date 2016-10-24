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

public class HydatavalueIDENTIFIER_TOKENTokenResolver implements eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolver {
	
	private eu.hyvar.dataValues.resource.hydatavalue.analysis.HydatavalueIDENTIFIER_TOKENTokenResolver importedResolver = new eu.hyvar.dataValues.resource.hydatavalue.analysis.HydatavalueIDENTIFIER_TOKENTokenResolver();
	
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		String result = importedResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(String lexem, EStructuralFeature feature, final eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaTokenResolveResult result) {
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
