/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.grammar;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public class HyexpressionContainment extends eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionTerminal {
	
	private final EClass[] allowedTypes;
	
	public HyexpressionContainment(EStructuralFeature feature, eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionCardinality cardinality, EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = eu.hyvar.feature.expression.resource.hyexpression.util.HyexpressionStringUtil.explode(allowedTypes, ", ", new eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionFunction1<String, EClass>() {
				public String execute(EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
