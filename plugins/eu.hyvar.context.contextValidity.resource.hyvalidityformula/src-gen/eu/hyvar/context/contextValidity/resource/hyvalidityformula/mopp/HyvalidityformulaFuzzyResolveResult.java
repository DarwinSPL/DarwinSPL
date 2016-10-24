/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp;

import java.util.Collection;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

/**
 * <p>
 * A FuzzyResolveResult is an implementation of the
 * IHyvalidityformulaReferenceResolveResult interface that delegates all method
 * calls to a given IHyvalidityformulaReferenceResolveResult with ReferenceType
 * EObject. It is used by reference resolver switches to collect results from
 * different reference resolvers in a type safe manner.
 * </p>
 * 
 * @param <ReferenceType> the type of the reference that is resolved
 */
public class HyvalidityformulaFuzzyResolveResult<ReferenceType extends EObject> implements eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceResolveResult<ReferenceType> {
	
	private eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceResolveResult<EObject> delegate;
	
	public HyvalidityformulaFuzzyResolveResult(eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceResolveResult<EObject> delegate) {
		this.delegate = delegate;
	}
	
	public String getErrorMessage() {
		return delegate.getErrorMessage();
	}
	
	public Collection<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaReferenceMapping<ReferenceType>> getMappings() {
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
	
	public Collection<eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaQuickFix> getQuickFixes() {
		return delegate.getQuickFixes();
	}
	
	public void addQuickFix(eu.hyvar.context.contextValidity.resource.hyvalidityformula.IHyvalidityformulaQuickFix quickFix) {
		delegate.addQuickFix(quickFix);
	}
	
}
