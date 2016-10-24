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
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.expression.util.HyExpressionResolverUtil;
import eu.hyvar.feature.util.HyFeatureResolverUtil;

public class HyAttributeReferenceExpressionAttributeReferenceResolver implements eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionReferenceResolver<eu.hyvar.feature.expression.HyAttributeReferenceExpression, eu.hyvar.feature.HyFeatureAttribute> {
	
	
	public void resolve(String identifier, eu.hyvar.feature.expression.HyAttributeReferenceExpression container, EReference reference, int position, boolean resolveFuzzy, final eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionReferenceResolveResult<eu.hyvar.feature.HyFeatureAttribute> result) {
		HyFeature feature = container.getFeature();
		
		if(feature != null) {
			HyFeatureAttribute attribute = HyExpressionResolverUtil.resolveFeatureAttribute(identifier, container, feature);
			
			if(attribute != null) {
				result.addMapping(identifier, attribute);
			}			
		}
	}
	
	public String deResolve(eu.hyvar.feature.HyFeatureAttribute element, eu.hyvar.feature.expression.HyAttributeReferenceExpression container, EReference reference) {
		return HyFeatureResolverUtil.deresolveFeatureAttribute(element, new Date());
	}
	
	public void setOptions(Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
