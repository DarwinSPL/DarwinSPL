/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.grammar;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public class HymappingContainment extends eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingTerminal {
	
	private final EClass[] allowedTypes;
	
	public HymappingContainment(EStructuralFeature feature, eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingCardinality cardinality, EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	@Override
	public boolean hasContainment(EClass metaclass) {
		for (EClass allowedType : allowedTypes) {
			if (allowedType == metaclass) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = eu.hyvar.feature.mapping.resource.hymapping.util.HymappingStringUtil.explode(allowedTypes, ", ", new eu.hyvar.feature.mapping.resource.hymapping.IHymappingFunction1<String, EClass>() {
				public String execute(EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
