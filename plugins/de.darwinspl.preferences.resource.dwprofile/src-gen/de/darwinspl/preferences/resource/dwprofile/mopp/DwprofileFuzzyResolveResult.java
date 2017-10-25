/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.mopp;

import java.util.Collection;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

/**
 * <p>
 * A FuzzyResolveResult is an implementation of the
 * IDwprofileReferenceResolveResult interface that delegates all method calls to a
 * given IDwprofileReferenceResolveResult with ReferenceType EObject. It is used
 * by reference resolver switches to collect results from different reference
 * resolvers in a type safe manner.
 * </p>
 * 
 * @param <ReferenceType> the type of the reference that is resolved
 */
public class DwprofileFuzzyResolveResult<ReferenceType extends EObject> implements de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolveResult<ReferenceType> {
	
	private de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolveResult<EObject> delegate;
	
	public DwprofileFuzzyResolveResult(de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolveResult<EObject> delegate) {
		this.delegate = delegate;
	}
	
	public String getErrorMessage() {
		return delegate.getErrorMessage();
	}
	
	public Collection<de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceMapping<ReferenceType>> getMappings() {
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
	
	public Collection<de.darwinspl.preferences.resource.dwprofile.IDwprofileQuickFix> getQuickFixes() {
		return delegate.getQuickFixes();
	}
	
	public void addQuickFix(de.darwinspl.preferences.resource.dwprofile.IDwprofileQuickFix quickFix) {
		delegate.addQuickFix(quickFix);
	}
	
}
