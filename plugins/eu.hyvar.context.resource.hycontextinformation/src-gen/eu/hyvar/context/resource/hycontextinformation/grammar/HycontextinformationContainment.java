/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.grammar;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public class HycontextinformationContainment extends eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationTerminal {
	
	private final EClass[] allowedTypes;
	
	public HycontextinformationContainment(EStructuralFeature feature, eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationCardinality cardinality, EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = eu.hyvar.context.resource.hycontextinformation.util.HycontextinformationStringUtil.explode(allowedTypes, ", ", new eu.hyvar.context.resource.hycontextinformation.IHycontextinformationFunction1<String, EClass>() {
				public String execute(EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
