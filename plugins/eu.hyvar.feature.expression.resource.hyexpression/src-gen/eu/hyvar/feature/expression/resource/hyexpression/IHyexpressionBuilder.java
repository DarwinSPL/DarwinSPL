/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;

/**
 * An interface for builders that can be used to perform operations when resources
 * are changed and saved. This is an abstraction over the Eclipse builder API that
 * is specifically designed for building resources that contain EMF models.
 */
public interface IHyexpressionBuilder {
	
	/**
	 * Check whether building the resource with the given URI is needed.This method
	 * allows to excluded resource from the build process before these are actually
	 * loaded. If this method returns false, the build() method will not be invoked
	 * for the resource located at the given URI.
	 */
	public boolean isBuildingNeeded(URI uri);
	
	/**
	 * Builds the given resource.
	 */
	public IStatus build(eu.hyvar.feature.expression.resource.hyexpression.mopp.HyexpressionResource resource, IProgressMonitor monitor);
	
	/**
	 * Handles the deletion of the given resource.
	 */
	public IStatus handleDeletion(URI uri, IProgressMonitor monitor);
	
}
