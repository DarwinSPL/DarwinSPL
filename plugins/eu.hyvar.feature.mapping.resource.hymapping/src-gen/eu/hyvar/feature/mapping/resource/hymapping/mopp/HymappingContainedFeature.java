/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.mopp;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A HymappingContainedFeature represents a path element of a
 * eu.hyvar.feature.mapping.resource.hymapping.grammar.HymappingContainmentTrace
 */
public class HymappingContainedFeature {
	
	/**
	 * The class to which the feature points.
	 */
	private EClass containerClass;
	
	/**
	 * The feature that points to the container class.
	 */
	private EStructuralFeature feature;
	
	public HymappingContainedFeature(EClass containerClass, EStructuralFeature feature) {
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
