/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.mopp;


public class HydatavalueResourcePostProcessor implements eu.hyvar.dataValues.resource.hydatavalue.IHydatavalueResourcePostProcessor {
	
	public void process(eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueResource resource) {
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
