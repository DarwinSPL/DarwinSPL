/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.mopp;

import org.eclipse.emf.ecore.EAttribute;

/**
 * This class provides sets of values for attributes. It is used by the code
 * completion processor.
 */
public class HymappingAttributeValueProvider {
	
	public Object[] getDefaultValues(EAttribute attribute) {
		String typeName = attribute.getEType().getName();
		if ("EString".equals(typeName)) {
			return new Object[] {"some" + eu.hyvar.feature.mapping.resource.hymapping.util.HymappingStringUtil.capitalize(attribute.getName())};
		}
		if ("EBoolean".equals(typeName)) {
			return new Object[] {Boolean.TRUE, Boolean.FALSE};
		}
		return new Object[] {attribute.getDefaultValue()};
	}
	
}
