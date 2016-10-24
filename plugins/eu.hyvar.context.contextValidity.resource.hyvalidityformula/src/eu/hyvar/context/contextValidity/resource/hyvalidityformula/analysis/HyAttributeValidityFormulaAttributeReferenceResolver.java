/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis;

import java.util.Date;
import java.util.Map;

import org.eclipse.emf.ecore.EReference;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.expression.util.HyExpressionResolverUtil;
import eu.hyvar.feature.util.HyFeatureResolverUtil;

public class HyAttributeValidityFormulaAttributeReferenceResolver implements eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceResolver<eu.hyvar.context.contextValidity.HyAttributeValidityFormula, eu.hyvar.feature.HyFeatureAttribute> {
	
//	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HyvalidityformulaDefaultResolverDelegate<eu.hyvar.context.contextValidity.HyAttributeValidityFormula, eu.hyvar.feature.HyFeatureAttribute> delegate = new eu.hyvar.context.contextValidity.resource.hyvalidityformula.analysis.HyvalidityformulaDefaultResolverDelegate<eu.hyvar.context.contextValidity.HyAttributeValidityFormula, eu.hyvar.feature.HyFeatureAttribute>();
	
	public void resolve(String identifier, eu.hyvar.context.contextValidity.HyAttributeValidityFormula container, EReference reference, int position, boolean resolveFuzzy, final eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceResolveResult<eu.hyvar.feature.HyFeatureAttribute> result) {
		HyFeature feature = container.getFeature();
		
		if(feature != null) {
			HyFeatureAttribute attribute = HyExpressionResolverUtil.resolveFeatureAttribute(identifier, container, feature);
			
			if(attribute != null) {
				result.addMapping(identifier, attribute);
			}			
		}
		
	}
	
	// TODO incorporate evolution!
	public String deResolve(eu.hyvar.feature.HyFeatureAttribute element, eu.hyvar.context.contextValidity.HyAttributeValidityFormula container, EReference reference) {
		return HyFeatureResolverUtil.deresolveFeatureAttribute(element, new Date());
	}
	
	public void setOptions(Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
