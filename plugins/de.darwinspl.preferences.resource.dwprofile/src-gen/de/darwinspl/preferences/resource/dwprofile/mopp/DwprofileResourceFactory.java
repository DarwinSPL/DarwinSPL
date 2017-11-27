/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.mopp;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

public class DwprofileResourceFactory implements Resource.Factory {
	
	public DwprofileResourceFactory() {
		super();
	}
	
	public Resource createResource(URI uri) {
		return new de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileResource(uri);
	}
	
}
