/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.analysis;

import java.util.Map;
import org.eclipse.emf.ecore.EReference;

public class DEDeltaInvokationDeltaReferenceResolver implements eu.hyvar.feature.mapping.resource.hymapping.IHymappingReferenceResolver<org.deltaecore.core.decore.DEDeltaInvokation, org.deltaecore.core.decore.DEDelta> {
	
	private eu.hyvar.feature.mapping.resource.hymapping.analysis.HymappingDefaultResolverDelegate<org.deltaecore.core.decore.DEDeltaInvokation, org.deltaecore.core.decore.DEDelta> delegate = new eu.hyvar.feature.mapping.resource.hymapping.analysis.HymappingDefaultResolverDelegate<org.deltaecore.core.decore.DEDeltaInvokation, org.deltaecore.core.decore.DEDelta>();
	
	public void resolve(String identifier, org.deltaecore.core.decore.DEDeltaInvokation container, EReference reference, int position, boolean resolveFuzzy, final eu.hyvar.feature.mapping.resource.hymapping.IHymappingReferenceResolveResult<org.deltaecore.core.decore.DEDelta> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.deltaecore.core.decore.DEDelta element, org.deltaecore.core.decore.DEDeltaInvokation container, EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
