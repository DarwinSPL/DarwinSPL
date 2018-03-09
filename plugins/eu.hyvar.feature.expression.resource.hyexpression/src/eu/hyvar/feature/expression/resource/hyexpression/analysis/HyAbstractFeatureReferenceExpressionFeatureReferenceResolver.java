/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.analysis;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import eu.hyvar.evolution.HyTemporalElement;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.expression.util.HyExpressionResolverUtil;
import eu.hyvar.feature.util.HyFeatureResolverUtil;

public class HyAbstractFeatureReferenceExpressionFeatureReferenceResolver implements eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionReferenceResolver<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature> {
	
//	private eu.hyvar.feature.expression.resource.hyexpression.analysis.HyexpressionDefaultResolverDelegate<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature> delegate = new eu.hyvar.feature.expression.resource.hyexpression.analysis.HyexpressionDefaultResolverDelegate<eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression, eu.hyvar.feature.HyFeature>();
	
	public void resolve(String identifier, eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression container, EReference reference, int position, boolean resolveFuzzy, final eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionReferenceResolveResult<eu.hyvar.feature.HyFeature> result) {
		HyFeature feature = HyExpressionResolverUtil.resolveFeature(identifier, container);
		
		if(feature != null) {
			result.addMapping(identifier, feature);
		}
	}
	
	public String deResolve(eu.hyvar.feature.HyFeature element, eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression container, EReference reference) {
		EObject eContainer = container.eContainer();
		while(! (eContainer instanceof HyTemporalElement)) {
			eContainer = eContainer.eContainer();
			if(eContainer == null) {
				break;
			}
		}
		
		if(eContainer == null) {
			return "Could not find containing constraint for timestamp";
		}
		
		HyTemporalElement constraint = (HyTemporalElement) eContainer;
		
		return HyFeatureResolverUtil.deresolveFeature(element, constraint.getValidSince());
	}
	
	public void setOptions(Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
