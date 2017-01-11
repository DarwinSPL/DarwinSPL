/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.util;

import java.io.File;
import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;

/**
 * Class HycontextinformationTextResourceUtil can be used to perform common tasks
 * on text resources, such as loading and saving resources, as well as, checking
 * them for errors. This class is deprecated and has been replaced by
 * eu.hyvar.context.resource.hycontextinformation.util.HycontextinformationResource
 * Util.
 */
public class HycontextinformationTextResourceUtil {
	
	/**
	 * Use
	 * eu.hyvar.context.resource.hycontextinformation.util.HycontextinformationResource
	 * Util.getResource() instead.
	 */
	@Deprecated
	public static eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationResource getResource(IFile file) {
		return new eu.hyvar.context.resource.hycontextinformation.util.HycontextinformationEclipseProxy().getResource(file);
	}
	
	/**
	 * Use
	 * eu.hyvar.context.resource.hycontextinformation.util.HycontextinformationResource
	 * Util.getResource() instead.
	 */
	@Deprecated
	public static eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationResource getResource(File file, Map<?,?> options) {
		return eu.hyvar.context.resource.hycontextinformation.util.HycontextinformationResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use
	 * eu.hyvar.context.resource.hycontextinformation.util.HycontextinformationResource
	 * Util.getResource() instead.
	 */
	@Deprecated
	public static eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationResource getResource(URI uri) {
		return eu.hyvar.context.resource.hycontextinformation.util.HycontextinformationResourceUtil.getResource(uri);
	}
	
	/**
	 * Use
	 * eu.hyvar.context.resource.hycontextinformation.util.HycontextinformationResource
	 * Util.getResource() instead.
	 */
	@Deprecated
	public static eu.hyvar.context.resource.hycontextinformation.mopp.HycontextinformationResource getResource(URI uri, Map<?,?> options) {
		return eu.hyvar.context.resource.hycontextinformation.util.HycontextinformationResourceUtil.getResource(uri, options);
	}
	
}
