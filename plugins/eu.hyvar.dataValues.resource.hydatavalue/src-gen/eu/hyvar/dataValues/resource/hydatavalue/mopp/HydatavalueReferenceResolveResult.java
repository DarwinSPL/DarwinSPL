/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.mopp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.common.util.URI;

/**
 * <p>
 * A basic implementation of the
 * eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueReferenceResolveResult
 * interface that collects mappings in a list.
 * </p>
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class HydatavalueReferenceResolveResult<ReferenceType> implements eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueReferenceResolveResult<ReferenceType> {
	
	private Collection<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	private Set<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueQuickFix> quickFixes;
	
	public HydatavalueReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public Collection<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueQuickFix> getQuickFixes() {
		if (quickFixes == null) {
			quickFixes = new LinkedHashSet<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueQuickFix>();
		}
		return Collections.unmodifiableSet(quickFixes);
	}
	
	public void addQuickFix(eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueQuickFix quickFix) {
		if (quickFixes == null) {
			quickFixes = new LinkedHashSet<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueQuickFix>();
		}
		quickFixes.add(quickFix);
	}
	
	public Collection<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueReferenceMapping<ReferenceType>> getMappings() {
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
			mappings = new ArrayList<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, URI uri, String warning) {
		if (mappings == null) {
			mappings = new ArrayList<eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueURIMapping<ReferenceType>(identifier, uri, warning));
	}
}
