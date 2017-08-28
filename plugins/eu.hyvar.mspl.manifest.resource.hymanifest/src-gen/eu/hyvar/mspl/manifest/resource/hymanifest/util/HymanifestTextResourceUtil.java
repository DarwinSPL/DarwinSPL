/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.util;

import java.io.File;
import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;

/**
 * Class HymanifestTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * eu.hyvar.mspl.manifest.resource.hymanifest.util.HymanifestResourceUtil.
 */
public class HymanifestTextResourceUtil {
	
	/**
	 * Use
	 * eu.hyvar.mspl.manifest.resource.hymanifest.util.HymanifestResourceUtil.getResour
	 * ce() instead.
	 */
	@Deprecated
	public static eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestResource getResource(IFile file) {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.util.HymanifestEclipseProxy().getResource(file);
	}
	
	/**
	 * Use
	 * eu.hyvar.mspl.manifest.resource.hymanifest.util.HymanifestResourceUtil.getResour
	 * ce() instead.
	 */
	@Deprecated
	public static eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestResource getResource(File file, Map<?,?> options) {
		return eu.hyvar.mspl.manifest.resource.hymanifest.util.HymanifestResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use
	 * eu.hyvar.mspl.manifest.resource.hymanifest.util.HymanifestResourceUtil.getResour
	 * ce() instead.
	 */
	@Deprecated
	public static eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestResource getResource(URI uri) {
		return eu.hyvar.mspl.manifest.resource.hymanifest.util.HymanifestResourceUtil.getResource(uri);
	}
	
	/**
	 * Use
	 * eu.hyvar.mspl.manifest.resource.hymanifest.util.HymanifestResourceUtil.getResour
	 * ce() instead.
	 */
	@Deprecated
	public static eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestResource getResource(URI uri, Map<?,?> options) {
		return eu.hyvar.mspl.manifest.resource.hymanifest.util.HymanifestResourceUtil.getResource(uri, options);
	}
	
}
