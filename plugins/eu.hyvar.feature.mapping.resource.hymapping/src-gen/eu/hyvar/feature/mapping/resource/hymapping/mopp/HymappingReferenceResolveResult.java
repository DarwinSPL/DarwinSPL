/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.mopp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.common.util.URI;

/**
 * <p>
 * A basic implementation of the
 * eu.hyvar.feature.mapping.resource.hymapping.IHymappingReferenceResolveResult
 * interface that collects mappings in a list.
 * </p>
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class HymappingReferenceResolveResult<ReferenceType> implements eu.hyvar.feature.mapping.resource.hymapping.IHymappingReferenceResolveResult<ReferenceType> {
	
	private Collection<eu.hyvar.feature.mapping.resource.hymapping.IHymappingReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	private Set<eu.hyvar.feature.mapping.resource.hymapping.IHymappingQuickFix> quickFixes;
	
	public HymappingReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public Collection<eu.hyvar.feature.mapping.resource.hymapping.IHymappingQuickFix> getQuickFixes() {
		if (quickFixes == null) {
			quickFixes = new LinkedHashSet<eu.hyvar.feature.mapping.resource.hymapping.IHymappingQuickFix>();
		}
		return Collections.unmodifiableSet(quickFixes);
	}
	
	public void addQuickFix(eu.hyvar.feature.mapping.resource.hymapping.IHymappingQuickFix quickFix) {
		if (quickFixes == null) {
			quickFixes = new LinkedHashSet<eu.hyvar.feature.mapping.resource.hymapping.IHymappingQuickFix>();
		}
		quickFixes.add(quickFix);
	}
	
	public Collection<eu.hyvar.feature.mapping.resource.hymapping.IHymappingReferenceMapping<ReferenceType>> getMappings() {
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
			mappings = new ArrayList<eu.hyvar.feature.mapping.resource.hymapping.IHymappingReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, URI uri, String warning) {
		if (mappings == null) {
			mappings = new ArrayList<eu.hyvar.feature.mapping.resource.hymapping.IHymappingReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingURIMapping<ReferenceType>(identifier, uri, warning));
	}
}
