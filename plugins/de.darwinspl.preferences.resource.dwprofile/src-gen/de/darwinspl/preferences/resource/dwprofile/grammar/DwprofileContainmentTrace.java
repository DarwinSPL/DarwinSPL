/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.grammar;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A DwprofileContainmentTrace represents a specific path to a structural feature
 * by navigating over a set of a structural feature from a start class.
 * DwprofileContainmentTraces are used during code completion to reconstruct
 * containment trees that are not created by the parser, for example, if the first
 * character of the contained object has not been typed yet.
 */
public class DwprofileContainmentTrace {
	
	/**
	 * The class where the trace starts.
	 */
	private EClass startClass;
	
	/**
	 * The path of contained features.
	 */
	private de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContainedFeature[] path;
	
	public DwprofileContainmentTrace(EClass startClass, de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContainedFeature[] path) {
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
	
	public de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileContainedFeature[] getPath() {
		return path;
	}
	
	public String toString() {
		return (startClass == null ? "null" : startClass.getName()) + "->" + de.darwinspl.preferences.resource.dwprofile.util.DwprofileStringUtil.explode(path, "->");
	}
	
}
