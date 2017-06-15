/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.mopp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.common.util.URI;

/**
 * <p>
 * A basic implementation of the
 * eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolveResult
 * interface that collects mappings in a list.
 * </p>
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class HymanifestReferenceResolveResult<ReferenceType> implements eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceResolveResult<ReferenceType> {
	
	private Collection<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	private Set<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestQuickFix> quickFixes;
	
	public HymanifestReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public Collection<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestQuickFix> getQuickFixes() {
		if (quickFixes == null) {
			quickFixes = new LinkedHashSet<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestQuickFix>();
		}
		return Collections.unmodifiableSet(quickFixes);
	}
	
	public void addQuickFix(eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestQuickFix quickFix) {
		if (quickFixes == null) {
			quickFixes = new LinkedHashSet<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestQuickFix>();
		}
		quickFixes.add(quickFix);
	}
	
	public Collection<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceMapping<ReferenceType>> getMappings() {
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
			mappings = new ArrayList<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, URI uri, String warning) {
		if (mappings == null) {
			mappings = new ArrayList<eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestURIMapping<ReferenceType>(identifier, uri, warning));
	}
}
