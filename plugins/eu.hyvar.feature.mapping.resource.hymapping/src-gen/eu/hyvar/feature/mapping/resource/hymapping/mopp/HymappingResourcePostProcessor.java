/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.mopp;


public class HymappingResourcePostProcessor implements eu.hyvar.feature.mapping.resource.hymapping.IHymappingResourcePostProcessor {
	
	public void process(eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingResource resource) {
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
