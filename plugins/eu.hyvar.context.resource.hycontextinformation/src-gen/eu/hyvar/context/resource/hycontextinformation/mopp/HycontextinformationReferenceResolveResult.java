/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.mopp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.common.util.URI;

/**
 * <p>
 * A basic implementation of the
 * eu.hyvar.context.resource.hycontextinformation.IHycontextinformationReferenceRes
 * olveResult interface that collects mappings in a list.
 * </p>
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class HycontextinformationReferenceResolveResult<ReferenceType> implements eu.hyvar.context.resource.hycontextinformation.IHycontextinformationReferenceResolveResult<ReferenceType> {
	
	private Collection<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	private Set<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationQuickFix> quickFixes;
	
	public HycontextinformationReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public Collection<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationQuickFix> getQuickFixes() {
		if (quickFixes == null) {
			quickFixes = new LinkedHashSet<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationQuickFix>();
		}
		return Collections.unmodifiableSet(quickFixes);
	}
	
	public void addQuickFix(eu.hyvar.context.resource.hycontextinformation.IHycontextinformationQuickFix quickFix) {
		if (quickFixes == null) {
			quickFixes = new LinkedHashSet<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationQuickFix>();
		}
		quickFixes.add(quickFix);
	}
	
	public Collection<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationReferenceMapping<ReferenceType>> getMappings() {
		return mappings;
	}
	
	public boolean wasResolved() {
		return mappings != null;
	}
	
	public boolean wasResolvedMultiple() {
		return mappings != null && mappings.size() > 1;
	}
	
	public boolean wasResolvedUniquely() {
		return mappings != null && mappings.size() == 1;
	}
	
	public void setErrorMessage(String message) {
		errorMessage = message;
	}
	
	public void addMapping(String identifier, ReferenceType target) {
		if (!resolveFuzzy && target == null) {
			throw new IllegalArgumentException("Mapping references to null is only allowed for fuzzy resolution.");
		}
		addMapping(identifier, target, null);
	}
	
	public void addMapping(String identifier, ReferenceType target, String warning) {
		if (mappings == null) {
			mappings = new ArrayList<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, URI uri, String warning) {
		if (mappings == null) {
			mappings = new ArrayList<eu.hyvar.context.resource.hycontextinformation.IHycontextinformationReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationURIMapping<ReferenceType>(identifier, uri, warning));
	}
}
