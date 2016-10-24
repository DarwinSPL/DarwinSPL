/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.analysis;

import java.util.Date;
import java.util.Map;
import org.eclipse.emf.ecore.EReference;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.expression.util.HyExpressionResolverUtil;
import eu.hyvar.feature.util.HyFeatureResolverUtil;

public class HyAttributeReferenceExpressionFeatureReferenceResolver implements eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionReferenceResolver<eu.hyvar.feature.expression.HyAttributeReferenceExpression, eu.hyvar.feature.HyFeature> {
	
	
	public void resolve(String identifier, eu.hyvar.feature.expression.HyAttributeReferenceExpression container, EReference reference, int position, boolean resolveFuzzy, final eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionReferenceResolveResult<eu.hyvar.feature.HyFeature> result) {
		HyFeature feature = HyExpressionResolverUtil.resolveFeature(identifier, container);
		
		if(feature != null) {
			result.addMapping(identifier, feature);
		}
	}
	
	public String deResolve(eu.hyvar.feature.HyFeature element, eu.hyvar.feature.expression.HyAttributeReferenceExpression container, EReference reference) {
		return HyFeatureResolverUtil.deresolveFeature(element, new Date());
	}
	
	public void setOptions(Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
