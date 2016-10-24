/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.mopp;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

public class HyexpressionResourceFactory implements Resource.Factory {
	
	public HyexpressionResourceFactory() {
		super();
	}
	
	public Resource createResource(URI uri) {
		return new eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionResource(uri);
	}
	
}
