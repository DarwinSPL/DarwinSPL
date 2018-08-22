/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.grammar;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A HyexpressionContainmentTrace represents a specific path to a structural
 * feature by navigating over a set of a structural feature from a start class.
 * HyexpressionContainmentTraces are used during code completion to reconstruct
 * containment trees that are not created by the parser, for example, if the first
 * character of the contained object has not been typed yet.
 */
public class HyexpressionContainmentTrace {
	
	/**
	 * The class where the trace starts.
	 */
	private EClass startClass;
	
	/**
	 * The path of contained features.
	 */
	private eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContainedFeature[] path;
	
	public HyexpressionContainmentTrace(EClass startClass, eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContainedFeature[] path) {
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
	
	public eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContainedFeature[] getPath() {
		return path;
	}
	
	public String toString() {
		return (startClass == null ? "null" : startClass.getName()) + "." + eu.hyvar.feature.expression.resource.hyexpression.util.HyexpressionStringUtil.explode(path, "->");
	}
	
	public boolean contains(eu.hyvar.feature.expression.resource.hyexpression.grammar.HyexpressionRule rule) {
		if (path == null) {
			return false;
		}
		
		EClass ruleMetaclass = rule.getMetaclass();
		for (eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionContainedFeature pathElement : path) {
			EClass containerClass = pathElement.getContainerClass();
			if (containerClass == ruleMetaclass) {
				return true;
			}
		}
		
		return startClass == ruleMetaclass;
	}
	
}
