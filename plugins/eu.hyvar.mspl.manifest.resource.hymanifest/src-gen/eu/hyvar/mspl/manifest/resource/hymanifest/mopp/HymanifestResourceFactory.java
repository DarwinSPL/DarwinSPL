/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.mopp;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

public class HymanifestResourceFactory implements Resource.Factory {
	
	public HymanifestResourceFactory() {
		super();
	}
	
	public Resource createResource(URI uri) {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestResource(uri);
	}
	
}
