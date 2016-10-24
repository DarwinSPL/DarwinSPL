/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.mopp;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

public class HyconstraintsResourceFactory implements Resource.Factory {
	
	public HyconstraintsResourceFactory() {
		super();
	}
	
	public Resource createResource(URI uri) {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsResource(uri);
	}
	
}
