package de.darwinspl.feature.graphical.editor.commands.files;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import de.darwinspl.feature.graphical.editor.editor.DwGraphicalFeatureModelEditor;

public abstract class DwCreateFileCommand extends AbstractHandler {
	protected IEditorPart getActiveEditor(){
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
	}
	
	@Override
	public boolean isEnabled() {
		return (getActiveEditor() instanceof DwGraphicalFeatureModelEditor);	
	}

	protected abstract String getExtension();
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		String fileExtension = getExtension();
		
		DwGraphicalFeatureModelEditor editor = (DwGraphicalFeatureModelEditor)getActiveEditor();
		
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot workspaceRoot = workspace.getRoot();
		
		IFile file = workspaceRoot.getFile(editor.getPathToEditorRelatedFileWithFileExtension(fileExtension));
		
		if(!file.exists()){
			InputStream source = new ByteArrayInputStream("".getBytes());
			try {
				file.create(source, IResource.NONE, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
			
			editor.openEditorForFileExtension(fileExtension);
		}
		
		return null;
	}

}
