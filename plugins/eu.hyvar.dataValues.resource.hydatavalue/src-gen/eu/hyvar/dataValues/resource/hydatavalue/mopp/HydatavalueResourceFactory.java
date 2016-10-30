/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.mopp;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

public class HydatavalueResourceFactory implements Resource.Factory {
	
	public HydatavalueResourceFactory() {
		super();
	}
	
	public Resource createResource(URI uri) {
		return new eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueResource(uri);
	}
	
}
