/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.mopp;

import java.util.Collection;
import org.eclipse.emf.common.util.URI;

/**
 * <p>
 * An implementation of the ResolveResult interface that delegates all method
 * calls to another ResolveResult. Client may subclass this class to easily create
 * custom ResolveResults.
 * </p>
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class HycontextinformationDelegatingResolveResult<ReferenceType> implements eu.hyvar.context.resource.hycontextinformation.IHycontextinformationReferenceResolveResult<ReferenceType> {
	
	private eu.hyvar.context.resource.hycontextinformation.IHycontextinformationReferenceResolveResult<ReferenceType> delegate;
	
	public HycontextinformationDelegatingResolveResult(eu.hyvar.context.resource.hycontextinformation.IHycontextinformationReferenceResolveResult<ReferenceType> delegate) {
		this.delegate = delegate;
	}
	
	public String getErrorMessage() {
		return delegate.getErrorMessage();
	}
	
	public Collection<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationReferenceMapping<ReferenceType>> getMappings() {
		return delegate.getMappings();
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
		delegate.addMapping(identifier, target);
	}
	
	public void addMapping(String identifier, URI uri) {
		delegate.addMapping(identifier, uri);
	}
	
	public void addMapping(String identifier, ReferenceType target, String warning) {
		delegate.addMapping(identifier, target, warning);
	}
	
	public void addMapping(String identifier, URI uri, String warning) {
		delegate.addMapping(identifier, uri, warning);
	}
	
	public Collection<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationQuickFix> getQuickFixes() {
		return delegate.getQuickFixes();
	}
	
	public void addQuickFix(eu.hyvar.context.resource.hycontextinformation.IHycontextinformationQuickFix quickFix) {
		delegate.addQuickFix(quickFix);
	}
	
}
