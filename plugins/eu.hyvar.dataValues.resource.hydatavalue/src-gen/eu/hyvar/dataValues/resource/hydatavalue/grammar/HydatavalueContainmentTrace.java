/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.grammar;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A HydatavalueContainmentTrace represents a specific path to a structural
 * feature by navigating over a set of a structural feature from a start class.
 * HydatavalueContainmentTraces are used during code completion to reconstruct
 * containment trees that are not created by the parser, for example, if the first
 * character of the contained object has not been typed yet.
 */
public class HydatavalueContainmentTrace {
	
	/**
	 * The class where the trace starts.
	 */
	private EClass startClass;
	
	/**
	 * The path of contained features.
	 */
	private eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueContainedFeature[] path;
	
	public HydatavalueContainmentTrace(EClass startClass, eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueContainedFeature[] path) {
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
	
	public eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueContainedFeature[] getPath() {
		return path;
	}
	
	public String toString() {
		return (startClass == null ? "null" : startClass.getName()) + "." + eu.hyvar.dataValues.resource.hydatavalue.util.HydatavalueStringUtil.explode(path, "->");
	}
	
	public boolean contains(eu.hyvar.dataValues.resource.hydatavalue.grammar.HydatavalueRule rule) {
		if (path == null) {
			return false;
		}
		
		EClass ruleMetaclass = rule.getMetaclass();
		for (eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueContainedFeature pathElement : path) {
			EClass containerClass = pathElement.getContainerClass();
			if (containerClass == ruleMetaclass) {
				return true;
			}
		}
		
		return startClass == ruleMetaclass;
	}
	
}
