/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.grammar;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public class DwprofileContainment extends de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileTerminal {
	
	private final EClass[] allowedTypes;
	
	public DwprofileContainment(EStructuralFeature feature, de.darwinspl.preferences.resource.dwprofile.grammar.DwprofileCardinality cardinality, EClass[] allowedTypes, int mandatoryOccurencesAfter) {
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
			typeRestrictions = de.darwinspl.preferences.resource.dwprofile.util.DwprofileStringUtil.explode(allowedTypes, ", ", new de.darwinspl.preferences.resource.dwprofile.IDwprofileFunction1<String, EClass>() {
				public String execute(EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
