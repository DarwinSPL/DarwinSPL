/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.util;

import java.io.File;
import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;

/**
 * Class HyexpressionTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * eu.hyvar.feature.expression.resource.hyexpression.util.HyexpressionResourceUtil.
 */
public class HyexpressionTextResourceUtil {
	
	/**
	 * Use
	 * eu.hyvar.feature.expression.resource.hyexpression.util.HyexpressionResourceUtil.
	 * getResource() instead.
	 */
	@Deprecated
	public static eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionResource getResource(IFile file) {
		return new eu.hyvar.feature.expression.resource.hyexpression.util.HyexpressionEclipseProxy().getResource(file);
	}
	
	/**
	 * Use
	 * eu.hyvar.feature.expression.resource.hyexpression.util.HyexpressionResourceUtil.
	 * getResource() instead.
	 */
	@Deprecated
	public static eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionResource getResource(File file, Map<?,?> options) {
		return eu.hyvar.feature.expression.resource.hyexpression.util.HyexpressionResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use
	 * eu.hyvar.feature.expression.resource.hyexpression.util.HyexpressionResourceUtil.
	 * getResource() instead.
	 */
	@Deprecated
	public static eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionResource getResource(URI uri) {
		return eu.hyvar.feature.expression.resource.hyexpression.util.HyexpressionResourceUtil.getResource(uri);
	}
	
	/**
	 * Use
	 * eu.hyvar.feature.expression.resource.hyexpression.util.HyexpressionResourceUtil.
	 * getResource() instead.
	 */
	@Deprecated
	public static eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionResource getResource(URI uri, Map<?,?> options) {
		return eu.hyvar.feature.expression.resource.hyexpression.util.HyexpressionResourceUtil.getResource(uri, options);
	}
	
}
