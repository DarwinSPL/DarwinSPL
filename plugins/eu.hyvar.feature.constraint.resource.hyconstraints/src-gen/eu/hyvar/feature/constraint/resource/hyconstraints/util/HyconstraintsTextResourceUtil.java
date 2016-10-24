/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.util;

import java.io.File;
import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;

/**
 * Class HyconstraintsTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * eu.hyvar.feature.constraint.resource.hyconstraints.util.HyconstraintsResourceUti
 * l.
 */
public class HyconstraintsTextResourceUtil {
	
	/**
	 * Use
	 * eu.hyvar.feature.constraint.resource.hyconstraints.util.HyconstraintsResourceUti
	 * l.getResource() instead.
	 */
	@Deprecated
	public static eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsResource getResource(IFile file) {
		return new eu.hyvar.feature.constraint.resource.hyconstraints.util.HyconstraintsEclipseProxy().getResource(file);
	}
	
	/**
	 * Use
	 * eu.hyvar.feature.constraint.resource.hyconstraints.util.HyconstraintsResourceUti
	 * l.getResource() instead.
	 */
	@Deprecated
	public static eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsResource getResource(File file, Map<?,?> options) {
		return eu.hyvar.feature.constraint.resource.hyconstraints.util.HyconstraintsResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use
	 * eu.hyvar.feature.constraint.resource.hyconstraints.util.HyconstraintsResourceUti
	 * l.getResource() instead.
	 */
	@Deprecated
	public static eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsResource getResource(URI uri) {
		return eu.hyvar.feature.constraint.resource.hyconstraints.util.HyconstraintsResourceUtil.getResource(uri);
	}
	
	/**
	 * Use
	 * eu.hyvar.feature.constraint.resource.hyconstraints.util.HyconstraintsResourceUti
	 * l.getResource() instead.
	 */
	@Deprecated
	public static eu.hyvar.feature.constraint.resource.hyconstraints.mopp.HyconstraintsResource getResource(URI uri, Map<?,?> options) {
		return eu.hyvar.feature.constraint.resource.hyconstraints.util.HyconstraintsResourceUtil.getResource(uri, options);
	}
	
}
