/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.grammar;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A HycontextinformationContainmentTrace represents a specific path to a
 * structural feature by navigating over a set of a structural feature from a
 * start class. HycontextinformationContainmentTraces are used during code
 * completion to reconstruct containment trees that are not created by the parser,
 * for example, if the first character of the contained object has not been typed
 * yet.
 */
public class HycontextinformationContainmentTrace {
	
	/**
	 * The class where the trace starts.
	 */
	private EClass startClass;
	
	/**
	 * The path of contained features.
	 */
	private eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationContainedFeature[] path;
	
	public HycontextinformationContainmentTrace(EClass startClass, eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationContainedFeature[] path) {
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
	
	public eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationContainedFeature[] getPath() {
		return path;
	}
	
	public String toString() {
		return (startClass == null ? "null" : startClass.getName()) + "->" + eu.hyvar.context.resource.hycontextinformation.util.HycontextinformationStringUtil.explode(path, "->");
	}
	
}
