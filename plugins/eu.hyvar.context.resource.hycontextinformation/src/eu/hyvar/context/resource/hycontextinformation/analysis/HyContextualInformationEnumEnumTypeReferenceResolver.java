/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.analysis;

import java.util.Map;
import org.eclipse.emf.ecore.EReference;

public class HyContextualInformationEnumEnumTypeReferenceResolver implements eu.hyvar.context.resource.hycontextinformation.IHycontextinformationReferenceResolver<eu.hyvar.context.HyContextualInformationEnum, eu.hyvar.dataValues.HyEnum> {
	
	private eu.hyvar.context.resource.hycontextinformation.analysis.HycontextinformationDefaultResolverDelegate<eu.hyvar.context.HyContextualInformationEnum, eu.hyvar.dataValues.HyEnum> delegate = new eu.hyvar.context.resource.hycontextinformation.analysis.HycontextinformationDefaultResolverDelegate<eu.hyvar.context.HyContextualInformationEnum, eu.hyvar.dataValues.HyEnum>();
	
	public void resolve(String identifier, eu.hyvar.context.HyContextualInformationEnum container, EReference reference, int position, boolean resolveFuzzy, final eu.hyvar.context.resource.hycontextinformation.IHycontextinformationReferenceResolveResult<eu.hyvar.dataValues.HyEnum> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(eu.hyvar.dataValues.HyEnum element, eu.hyvar.context.HyContextualInformationEnum container, EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
