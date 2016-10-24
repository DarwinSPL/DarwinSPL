/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.mopp;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

public class HymappingResourceFactory implements Resource.Factory {
	
	public HymappingResourceFactory() {
		super();
	}
	
	public Resource createResource(URI uri) {
		return new eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingResource(uri);
	}
	
}
