/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.grammar;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public class HyconstraintsContainment extends eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsTerminal {
	
	private final EClass[] allowedTypes;
	
	public HyconstraintsContainment(EStructuralFeature feature, eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsCardinality cardinality, EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = eu.hyvar.feature.constraint.resource.hyconstraints.util.HyconstraintsStringUtil.explode(allowedTypes, ", ", new eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsFunction1<String, EClass>() {
				public String execute(EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
