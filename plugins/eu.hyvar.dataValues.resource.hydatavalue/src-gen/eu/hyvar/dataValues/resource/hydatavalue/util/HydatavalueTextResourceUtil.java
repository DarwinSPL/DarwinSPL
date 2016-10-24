/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.util;

import java.io.File;
import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;

/**
 * Class HydatavalueTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * eu.hyvar.dataValues.resource.hydatavalue.util.HydatavalueResourceUtil.
 */
public class HydatavalueTextResourceUtil {
	
	/**
	 * Use
	 * eu.hyvar.dataValues.resource.hydatavalue.util.HydatavalueResourceUtil.getResourc
	 * e() instead.
	 */
	@Deprecated
	public static eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueResource getResource(IFile file) {
		return new eu.hyvar.dataValues.resource.hydatavalue.util.HydatavalueEclipseProxy().getResource(file);
	}
	
	/**
	 * Use
	 * eu.hyvar.dataValues.resource.hydatavalue.util.HydatavalueResourceUtil.getResourc
	 * e() instead.
	 */
	@Deprecated
	public static eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueResource getResource(File file, Map<?,?> options) {
		return eu.hyvar.dataValues.resource.hydatavalue.util.HydatavalueResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use
	 * eu.hyvar.dataValues.resource.hydatavalue.util.HydatavalueResourceUtil.getResourc
	 * e() instead.
	 */
	@Deprecated
	public static eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueResource getResource(URI uri) {
		return eu.hyvar.dataValues.resource.hydatavalue.util.HydatavalueResourceUtil.getResource(uri);
	}
	
	/**
	 * Use
	 * eu.hyvar.dataValues.resource.hydatavalue.util.HydatavalueResourceUtil.getResourc
	 * e() instead.
	 */
	@Deprecated
	public static eu.hyvar.dataValues.resource.hydatavalue.mopp.HydatavalueResource getResource(URI uri, Map<?,?> options) {
		return eu.hyvar.dataValues.resource.hydatavalue.util.HydatavalueResourceUtil.getResource(uri, options);
	}
	
}
