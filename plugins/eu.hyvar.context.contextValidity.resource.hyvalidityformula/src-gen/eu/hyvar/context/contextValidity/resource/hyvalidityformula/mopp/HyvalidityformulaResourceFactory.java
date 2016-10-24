/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

public class HyvalidityformulaResourceFactory implements Resource.Factory {
	
	public HyvalidityformulaResourceFactory() {
		super();
	}
	
	public Resource createResource(URI uri) {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaResource(uri);
	}
	
}
