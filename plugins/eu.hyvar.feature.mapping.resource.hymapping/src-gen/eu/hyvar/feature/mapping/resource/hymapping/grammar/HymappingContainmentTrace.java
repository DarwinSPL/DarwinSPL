/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.grammar;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A HymappingContainmentTrace represents a specific path to a structural feature
 * by navigating over a set of a structural feature from a start class.
 * HymappingContainmentTraces are used during code completion to reconstruct
 * containment trees that are not created by the parser, for example, if the first
 * character of the contained object has not been typed yet.
 */
public class HymappingContainmentTrace {
	
	/**
	 * The class where the trace starts.
	 */
	private EClass startClass;
	
	/**
	 * The path of contained features.
	 */
	private eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingContainedFeature[] path;
	
	public HymappingContainmentTrace(EClass startClass, eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingContainedFeature[] path) {
		super();
		// Verify arguments
		if (startClass != null) {
			if (path.length > 0) {
				EStructuralFeature feature = path[path.length - 1].getFeature();
				if (!startClass.getEAllStructuralFeatures().contains(feature)) {
					throw new RuntimeException("Metaclass " + startClass.getName() + " must contain feature " + feature.getName());
				}
			}
		}
		this.startClass = startClass;
		this.path = path;
	}
	
	public EClass getStartClass() {
		return startClass;
	}
	
	public eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingContainedFeature[] getPath() {
		return path;
	}
	
	public String toString() {
		return (startClass == null ? "null" : startClass.getName()) + "->" + eu.hyvar.feature.mapping.resource.hymapping.util.HymappingStringUtil.explode(path, "->");
	}
	
}
