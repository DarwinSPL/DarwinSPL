/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.analysis;

import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class HydatavalueINTEGER_LITERALTokenResolver implements eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver {
	
	private eu.hyvar.dataValues.resource.hydatavalue.analysis.HydatavalueDefaultTokenResolver defaultTokenResolver = new eu.hyvar.dataValues.resource.hydatavalue.analysis.HydatavalueDefaultTokenResolver(true);
	
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, null, null, null);
		return result;
	}
	
	public void resolve(String lexem, EStructuralFeature feature, eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, null, null, null);
	}
	
	public void setOptions(Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
