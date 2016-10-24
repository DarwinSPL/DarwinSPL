/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.mopp;


public class HyconstraintsResourcePostProcessor implements eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsResourcePostProcessor {
	
	public void process(eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsResource resource) {
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
