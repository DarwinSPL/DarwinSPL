/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.util;

import java.io.File;
import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;

/**
 * Class HymappingTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * eu.hyvar.feature.mapping.resource.hymapping.util.HymappingResourceUtil.
 */
public class HymappingTextResourceUtil {
	
	/**
	 * Use
	 * eu.hyvar.feature.mapping.resource.hymapping.util.HymappingResourceUtil.getResour
	 * ce() instead.
	 */
	@Deprecated
	public static eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingResource getResource(IFile file) {
		return new eu.hyvar.feature.mapping.resource.hymapping.util.HymappingEclipseProxy().getResource(file);
	}
	
	/**
	 * Use
	 * eu.hyvar.feature.mapping.resource.hymapping.util.HymappingResourceUtil.getResour
	 * ce() instead.
	 */
	@Deprecated
	public static eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingResource getResource(File file, Map<?,?> options) {
		return eu.hyvar.feature.mapping.resource.hymapping.util.HymappingResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use
	 * eu.hyvar.feature.mapping.resource.hymapping.util.HymappingResourceUtil.getResour
	 * ce() instead.
	 */
	@Deprecated
	public static eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingResource getResource(URI uri) {
		return eu.hyvar.feature.mapping.resource.hymapping.util.HymappingResourceUtil.getResource(uri);
	}
	
	/**
	 * Use
	 * eu.hyvar.feature.mapping.resource.hymapping.util.HymappingResourceUtil.getResour
	 * ce() instead.
	 */
	@Deprecated
	public static eu.hyvar.feature.mapping.resource.hymapping.mopp.HymappingResource getResource(URI uri, Map<?,?> options) {
		return eu.hyvar.feature.mapping.resource.hymapping.util.HymappingResourceUtil.getResource(uri, options);
	}
	
}
