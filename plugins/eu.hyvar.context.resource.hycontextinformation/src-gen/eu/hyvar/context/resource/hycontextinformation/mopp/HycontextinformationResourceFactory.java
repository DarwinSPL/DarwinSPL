/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.mopp;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

public class HycontextinformationResourceFactory implements Resource.Factory {
	
	public HycontextinformationResourceFactory() {
		super();
	}
	
	public Resource createResource(URI uri) {
		return new eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationResource(uri);
	}
	
}
