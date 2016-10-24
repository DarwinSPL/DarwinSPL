/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public class HyvalidityformulaContainment extends eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaTerminal {
	
	private final EClass[] allowedTypes;
	
	public HyvalidityformulaContainment(EStructuralFeature feature, eu.hyvar.context.contextValidity.resource.hyvalidityformula.grammar.HyvalidityformulaCardinality cardinality, EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = eu.hyvar.context.contextValidity.resource.hyvalidityformula.util.HyvalidityformulaStringUtil.explode(allowedTypes, ", ", new eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaFunction1<String, EClass>() {
				public String execute(EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
