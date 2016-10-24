/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.analysis;

import java.util.Map;

import org.eclipse.emf.ecore.EReference;

import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.feature.expression.util.HyExpressionResolverUtil;

public class HyContextInformationReferenceExpressionContextInformationReferenceResolver implements eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionReferenceResolver<eu.hyvar.feature.expression.HyContextInformationReferenceExpression, eu.hyvar.context.HyContextualInformation> {
	
	
	public void resolve(String identifier, eu.hyvar.feature.expression.HyContextInformationReferenceExpression container, EReference reference, int position, boolean resolveFuzzy, final eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionReferenceResolveResult<eu.hyvar.context.HyContextualInformation> result) {
		// TODO incorporate evolution
		
		HyContextualInformation contextInfo = HyExpressionResolverUtil.resolveContextualInformation(identifier, container);
		
		if(contextInfo != null) {
			result.addMapping(identifier, contextInfo);
		}
	}
	
	public String deResolve(eu.hyvar.context.HyContextualInformation element, eu.hyvar.feature.expression.HyContextInformationReferenceExpression container, EReference reference) {
		return HyExpressionResolverUtil.deresolveContextualInformation(element);
	}
	
	public void setOptions(Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
