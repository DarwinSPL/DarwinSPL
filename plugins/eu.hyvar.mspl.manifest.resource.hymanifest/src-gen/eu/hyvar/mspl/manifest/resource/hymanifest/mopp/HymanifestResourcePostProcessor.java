/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.mopp;


public class HymanifestResourcePostProcessor implements eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestResourcePostProcessor {
	
	public void process(eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestResource resource) {
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
