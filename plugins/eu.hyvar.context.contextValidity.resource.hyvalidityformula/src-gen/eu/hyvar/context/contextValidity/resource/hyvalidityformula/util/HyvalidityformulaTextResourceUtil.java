/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.util;

import java.io.File;
import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;

/**
 * Class HyvalidityformulaTextResourceUtil can be used to perform common tasks on
 * text resources, such as loading and saving resources, as well as, checking them
 * for errors. This class is deprecated and has been replaced by
 * eu.hyvar.context.contextValidity.resource.hyvalidityformula.util.Hyvalidityformu
 * laResourceUtil.
 */
public class HyvalidityformulaTextResourceUtil {
	
	/**
	 * Use
	 * eu.hyvar.context.contextValidity.resource.hyvalidityformula.util.Hyvalidityformu
	 * laResourceUtil.getResource() instead.
	 */
	@Deprecated
	public static eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaResource getResource(IFile file) {
		return new eu.hyvar.context.contextValidity.resource.hyvalidityformula.util.HyvalidityformulaEclipseProxy().getResource(file);
	}
	
	/**
	 * Use
	 * eu.hyvar.context.contextValidity.resource.hyvalidityformula.util.Hyvalidityformu
	 * laResourceUtil.getResource() instead.
	 */
	@Deprecated
	public static eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaResource getResource(File file, Map<?,?> options) {
		return eu.hyvar.context.contextValidity.resource.hyvalidityformula.util.HyvalidityformulaResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use
	 * eu.hyvar.context.contextValidity.resource.hyvalidityformula.util.Hyvalidityformu
	 * laResourceUtil.getResource() instead.
	 */
	@Deprecated
	public static eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaResource getResource(URI uri) {
		return eu.hyvar.context.contextValidity.resource.hyvalidityformula.util.HyvalidityformulaResourceUtil.getResource(uri);
	}
	
	/**
	 * Use
	 * eu.hyvar.context.contextValidity.resource.hyvalidityformula.util.Hyvalidityformu
	 * laResourceUtil.getResource() instead.
	 */
	@Deprecated
	public static eu.hyvar.context.contextValidity.resource.hyvalidityformula.mopp.HyvalidityformulaResource getResource(URI uri, Map<?,?> options) {
		return eu.hyvar.context.contextValidity.resource.hyvalidityformula.util.HyvalidityformulaResourceUtil.getResource(uri, options);
	}
	
}
