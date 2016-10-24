/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.mopp;


public class HyexpressionResourcePostProcessor implements eu.hyvar.feature.expression.resource.hyexpression.IHyexpressionResourcePostProcessor {
	
	public void process(eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionResource resource) {
		// Set the overrideResourcePostProcessor option to false to customize resource
		// post processing.
	}
	
	public void terminate() {
		// To signal termination to the process() method, setting a boolean field is
		// recommended. Depending on the value of this field process() can stop its
		// computation. However, this is only required for computation intensive
		// post-processors.
	}
	
}
