/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.util;


/**
 * Utility class that provides a method to cast objects to type parameterized
 * classes without a warning.
 */
public class HyvalidityformulaCastUtil {
	
	@SuppressWarnings("unchecked")
	public static <T> T cast(Object temp) {
		return (T) temp;
	}
}
