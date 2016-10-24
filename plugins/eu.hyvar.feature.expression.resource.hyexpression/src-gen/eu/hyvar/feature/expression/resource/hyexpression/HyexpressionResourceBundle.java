/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression;

import java.lang.reflect.Field;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * A class to hold all resources (e.g., text constants) for the resource plug-in.
 */
public class HyexpressionResourceBundle {
	
	/**
	 * The name of the main task that is shown in the progress view when the builders
	 * are running.
	 */
	public static String BUILDER_ADAPTER_TASK_NAME = "Building hyexpression file";
	
	/**
	 * The name of the main job that is shown in the progress view while updating
	 * markers for resources.
	 */
	public static String UPDATING_MARKERS_JOB_NAME = "Updating markers";
	
	/**
	 * The static initializer tries to load resources from properties files or
	 * resource bundle classes. If no properties files or resource bundle classes are
	 * available, the default values are kept.
	 */
	static {
		try {
			ResourceBundle bundle = ResourceBundle.getBundle(HyexpressionResourceBundle.class.getName(), Locale.getDefault());
			if (bundle != null) {
				Set<String> keys = bundle.keySet();
				for (String key : keys) {
					String value = bundle.getString(key);
					try {
						Field field = HyexpressionResourceBundle.class.getDeclaredField(key.toUpperCase());
						field.set(null, value);
					} catch (SecurityException e) {
						// Ignore
					} catch (NoSuchFieldException e) {
						// Ignore?
					} catch (IllegalArgumentException e) {
						// Ignore
					} catch (IllegalAccessException e) {
						// Ignore
					}
				}
			}
		} catch (MissingResourceException mre) {
			// Ignore
		}
	}
	
}
