/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.mopp;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A HyconstraintsContainedFeature represents a path element of a
 * eu.hyvar.feature.constraint.resource.hyconstraints.grammar.HyconstraintsContainm
 * entTrace
 */
public class HyconstraintsContainedFeature {
	
	/**
	 * The class to which the feature points.
	 */
	private EClass containerClass;
	
	/**
	 * The feature that points to the container class.
	 */
	private EStructuralFeature feature;
	
	public HyconstraintsContainedFeature(EClass containerClass, EStructuralFeature feature) {
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
