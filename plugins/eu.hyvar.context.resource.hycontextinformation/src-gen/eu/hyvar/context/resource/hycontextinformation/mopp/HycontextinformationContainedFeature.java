/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.mopp;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A HycontextinformationContainedFeature represents a path element of a
 * eu.hyvar.context.resource.hycontextinformation.grammar.HycontextinformationConta
 * inmentTrace
 */
public class HycontextinformationContainedFeature {
	
	/**
	 * The class to which the feature points.
	 */
	private EClass containerClass;
	
	/**
	 * The feature that points to the container class.
	 */
	private EStructuralFeature feature;
	
	public HycontextinformationContainedFeature(EClass containerClass, EStructuralFeature feature) {
		super();
		this.containerClass = containerClass;
		this.feature = feature;
	}
	
	public EClass getContainerClass() {
		return containerClass;
	}
	
	public EStructuralFeature getFeature() {
		return feature;
	}
	
	public String toString() {
		return (feature == null ? "null" : feature.getName()) + "->" + (containerClass == null ? "null" : containerClass.getName());
	}
	
}
