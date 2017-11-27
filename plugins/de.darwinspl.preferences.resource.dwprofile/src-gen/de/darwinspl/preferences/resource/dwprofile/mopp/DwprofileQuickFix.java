/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.mopp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

public abstract class DwprofileQuickFix implements de.darwinspl.preferences.resource.dwprofile.IDwprofileQuickFix {
	
	private String displayString;
	private String imageKey;
	private Resource resource;
	private Collection<EObject> contextObjects;
	
	public DwprofileQuickFix(String displayString, String imageKey, EObject contextObject) {
		this(displayString, imageKey, Collections.singleton(contextObject), contextObject.eResource());
	}
	
	public DwprofileQuickFix(String displayString, String imageKey, Collection<EObject> contextObjects) {
		this(displayString, imageKey, contextObjects, contextObjects.iterator().next().eResource());
	}
	
	public DwprofileQuickFix(String displayString, String imageKey, Collection<EObject> contextObjects, Resource resource) {
		super();
		if (displayString == null) {
			throw new IllegalArgumentException("displayString must not be null.");
		}
		if (contextObjects == null) {
			throw new IllegalArgumentException("contextObjects must not be null.");
		}
		if (contextObjects.isEmpty()) {
			throw new IllegalArgumentException("contextObjects must not be empty.");
		}
		this.displayString = displayString;
		this.imageKey = imageKey;
		this.contextObjects = contextObjects;
		this.resource = resource;
	}
	
	public String apply(String currentText) {
		applyChanges();
		try {
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			getResource().save(output, null);
			return output.toString();
		} catch (IOException e) {
			new de.darwinspl.preferences.resource.dwprofile.util.DwprofileRuntimeUtil().logError("Exception while applying quick fix", e);
		}
		return null;
	}
	
	public abstract void applyChanges();
	
	public Resource getResource() {
		return resource;
	}
	
	public String getDisplayString() {
		return displayString;
	}
	
	public String getImageKey() {
		return imageKey;
	}
	
	public Collection<EObject> getContextObjects() {
		return contextObjects;
	}
	
	public String getContextAsString() {
		StringBuilder result = new StringBuilder();
		result.append(getType());
		result.append(",");
		for (EObject contextObject : contextObjects) {
			result.append(EcoreUtil.getURI(contextObject));
			result.append(",");
		}
		return result.toString();
	}
	
	private String getType() {
		return this.getClass().getName();
	}
	
}
