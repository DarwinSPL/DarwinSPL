/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.util;


/**
 * Utility class that provides a method to cast objects to type parameterized
 * classes without a warning.
 */
public class HycontextinformationCastUtil {
	
	@SuppressWarnings("unchecked")
	public static <T> T cast(Object temp) {
		return (T) temp;
	}
}
