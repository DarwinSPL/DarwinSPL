/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.util;


/**
 * Utility class that provides a method to cast objects to type parameterized
 * classes without a warning.
 */
public class HyconstraintsCastUtil {
	
	@SuppressWarnings("unchecked")
	public static <T> T cast(Object temp) {
		return (T) temp;
	}
}
