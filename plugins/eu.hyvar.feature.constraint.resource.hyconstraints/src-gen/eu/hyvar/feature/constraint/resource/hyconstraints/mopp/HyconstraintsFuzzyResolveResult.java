/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.mopp;

import java.util.Collection;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

/**
 * <p>
 * A FuzzyResolveResult is an implementation of the
 * IHyconstraintsReferenceResolveResult interface that delegates all method calls
 * to a given IHyconstraintsReferenceResolveResult with ReferenceType EObject. It
 * is used by reference resolver switches to collect results from different
 * reference resolvers in a type safe manner.
 * </p>
 * 
 * @param <ReferenceType> the type of the reference that is resolved
 */
public class HyconstraintsFuzzyResolveResult<ReferenceType extends EObject> implements eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsReferenceResolveResult<ReferenceType> {
	
	private eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsReferenceResolveResult<EObject> delegate;
	
	public HyconstraintsFuzzyResolveResult(eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsReferenceResolveResult<EObject> delegate) {
		this.delegate = delegate;
	}
	
	public String getErrorMessage() {
		return delegate.getErrorMessage();
	}
	
	public Collection<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsReferenceMapping<ReferenceType>> getMappings() {
		return null;
	}
	
	public boolean wasResolved() {
		return delegate.wasResolved();
	}
	
	public boolean wasResolvedMultiple() {
		return delegate.wasResolvedMultiple();
	}
	
	public boolean wasResolvedUniquely() {
		return delegate.wasResolvedUniquely();
	}
	
	public void setErrorMessage(String message) {
		delegate.setErrorMessage(message);
	}
	
	public void addMapping(String identifier, ReferenceType target) {
		delegate.addMapping(identifier, (EObject) target);
	}
	
	public void addMapping(String identifier, URI uri) {
		delegate.addMapping(identifier, uri);
	}
	
	public void addMapping(String identifier, ReferenceType target, String warning) {
		delegate.addMapping(identifier, (EObject) target, warning);
	}
	
	public void addMapping(String identifier, URI uri, String warning) {
		delegate.addMapping(identifier, uri, warning);
	}
	
	public Collection<eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsQuickFix> getQuickFixes() {
		return delegate.getQuickFixes();
	}
	
	public void addQuickFix(eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsQuickFix quickFix) {
		delegate.addQuickFix(quickFix);
	}
	
}
