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

public class HydatavalueDATETokenResolver implements eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolver {
	
	private eu.hyvar.dataValues.resource.hydatavalue.analysis.HydatavalueDATETokenResolver importedResolver = new eu.hyvar.dataValues.resource.hydatavalue.analysis.HydatavalueDATETokenResolver();
	
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		String result = importedResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(String lexem, EStructuralFeature feature, final eu.hyvar.context.resource.hycontextinformation.IHycontextinformationTokenResolveResult result) {
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
