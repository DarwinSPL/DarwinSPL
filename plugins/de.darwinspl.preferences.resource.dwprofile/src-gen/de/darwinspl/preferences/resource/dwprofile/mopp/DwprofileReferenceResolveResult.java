/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.mopp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.common.util.URI;

/**
 * <p>
 * A basic implementation of the
 * de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolveResult
 * interface that collects mappings in a list.
 * </p>
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class DwprofileReferenceResolveResult<ReferenceType> implements de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceResolveResult<ReferenceType> {
	
	private Collection<de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	private Set<de.darwinspl.preferences.resource.dwprofile.IDwprofileQuickFix> quickFixes;
	
	public DwprofileReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public Collection<de.darwinspl.preferences.resource.dwprofile.IDwprofileQuickFix> getQuickFixes() {
		if (quickFixes == null) {
			quickFixes = new LinkedHashSet<de.darwinspl.preferences.resource.dwprofile.IDwprofileQuickFix>();
		}
		return Collections.unmodifiableSet(quickFixes);
	}
	
	public void addQuickFix(de.darwinspl.preferences.resource.dwprofile.IDwprofileQuickFix quickFix) {
		if (quickFixes == null) {
			quickFixes = new LinkedHashSet<de.darwinspl.preferences.resource.dwprofile.IDwprofileQuickFix>();
		}
		quickFixes.add(quickFix);
	}
	
	public Collection<de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceMapping<ReferenceType>> getMappings() {
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
			mappings = new ArrayList<de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, URI uri, String warning) {
		if (mappings == null) {
			mappings = new ArrayList<de.darwinspl.preferences.resource.dwprofile.IDwprofileReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileURIMapping<ReferenceType>(identifier, uri, warning));
	}
}
