/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.analysis;

import java.util.Date;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import eu.hyvar.evolution.util.HyEvolutionResolverUtil;

public class HydatavalueDATETokenResolver implements eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolver {
	
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		if(value instanceof Date) {
			Date date = (Date) value;
			return HyEvolutionResolverUtil.deresolveDate(date);
		}
		return null;
	}
	
	public void resolve(String lexem, EStructuralFeature feature, eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueTokenResolveResult result) {
		result.setResolvedToken(HyEvolutionResolverUtil.resolveDate(lexem));
	}
	
	public void setOptions(Map<?,?> options) {
		// Do Nothing
	}
	
}
