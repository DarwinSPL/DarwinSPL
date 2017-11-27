/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.mopp;


public class DwprofileResourcePostProcessor implements de.darwinspl.preferences.resource.dwprofile.IDwprofileResourcePostProcessor {
	
	public void process(de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileResource resource) {
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
