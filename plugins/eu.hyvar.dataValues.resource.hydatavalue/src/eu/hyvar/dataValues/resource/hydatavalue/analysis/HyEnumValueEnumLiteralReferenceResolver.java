/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.analysis;

import java.util.Map;

import org.eclipse.emf.ecore.EReference;

import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.feature.data.util.DataValuesResolverUtil;

public class HyEnumValueEnumLiteralReferenceResolver implements eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueReferenceResolver<eu.hyvar.dataValues.HyEnumValue, eu.hyvar.dataValues.HyEnumLiteral> {
	
	public void resolve(String identifier, eu.hyvar.dataValues.HyEnumValue container, EReference reference, int position, boolean resolveFuzzy, final eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueReferenceResolveResult<eu.hyvar.dataValues.HyEnumLiteral> result) {
		HyEnum containingEnum = container.getEnum();
		if(containingEnum != null) {
			HyEnumLiteral literal = DataValuesResolverUtil.resolveEnumLiteral(identifier, containingEnum);
			if(literal != null) {
				result.addMapping(identifier, literal);				
			}
		}
		
	}
	
	public String deResolve(eu.hyvar.dataValues.HyEnumLiteral element, eu.hyvar.dataValues.HyEnumValue container, EReference reference) {
		return DataValuesResolverUtil.deresolveEnumLiteral(container.getEnumLiteral());
	}
	
	public void setOptions(Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
