/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.ui;

import org.eclipse.core.filebuffers.IAnnotationModelFactory;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.text.source.IAnnotationModel;

public class HycontextinformationAnnotationModelFactory implements IAnnotationModelFactory {
	
	public IAnnotationModel createAnnotationModel(IPath location) {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IResource resource = root.findMember(location);
		return new eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationAnnotationModel(resource);
	}
	
}
