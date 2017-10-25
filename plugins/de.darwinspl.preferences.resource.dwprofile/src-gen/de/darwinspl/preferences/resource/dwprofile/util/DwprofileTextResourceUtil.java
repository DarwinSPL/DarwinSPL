/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.util;

import java.io.File;
import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;

/**
 * Class DwprofileTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * de.darwinspl.preferences.resource.dwprofile.util.DwprofileResourceUtil.
 */
public class DwprofileTextResourceUtil {
	
	/**
	 * Use
	 * de.darwinspl.preferences.resource.dwprofile.util.DwprofileResourceUtil.getResour
	 * ce() instead.
	 */
	@Deprecated
	public static de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileResource getResource(IFile file) {
		return new de.darwinspl.preferences.resource.dwprofile.util.DwprofileEclipseProxy().getResource(file);
	}
	
	/**
	 * Use
	 * de.darwinspl.preferences.resource.dwprofile.util.DwprofileResourceUtil.getResour
	 * ce() instead.
	 */
	@Deprecated
	public static de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileResource getResource(File file, Map<?,?> options) {
		return de.darwinspl.preferences.resource.dwprofile.util.DwprofileResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use
	 * de.darwinspl.preferences.resource.dwprofile.util.DwprofileResourceUtil.getResour
	 * ce() instead.
	 */
	@Deprecated
	public static de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileResource getResource(URI uri) {
		return de.darwinspl.preferences.resource.dwprofile.util.DwprofileResourceUtil.getResource(uri);
	}
	
	/**
	 * Use
	 * de.darwinspl.preferences.resource.dwprofile.util.DwprofileResourceUtil.getResour
	 * ce() instead.
	 */
	@Deprecated
	public static de.darwinspl.preferences.resource.dwprofile.mopp.DwprofileResource getResource(URI uri, Map<?,?> options) {
		return de.darwinspl.preferences.resource.dwprofile.util.DwprofileResourceUtil.getResource(uri, options);
	}
	
}
