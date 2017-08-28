package eu.hyvar.reconfigurator.io.rest.spl_implementation;

import java.util.UUID;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

public class WorkspaceManager {

	private String PROJECT_NAME = "SPLImplementationResolution";
	private IWorkspaceRoot workspaceRoot = null;
	private IProgressMonitor progressMonitor = null;

	public synchronized IFolder getNewIFolder() throws CoreException {
		
		if(workspaceRoot==null) {
			workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		}

		if(progressMonitor==null) {
			progressMonitor = new NullProgressMonitor();
		}

		IProject project = workspaceRoot.getProject(PROJECT_NAME);
		if (!project.exists()) {
			project.create(progressMonitor);
		}
		project.open(progressMonitor);
		project.refreshLocal(IProject.DEPTH_INFINITE, progressMonitor);

		
		IFolder folder = null;
		while(folder == null || folder.exists()) {
			folder = project.getFolder(UUID.randomUUID().toString());
		}
		
		folder.create(true, true, progressMonitor);

		return folder;
	}

	public synchronized IProgressMonitor getIProgressMonitor() throws CoreException {
		if(progressMonitor==null) {
			progressMonitor = new NullProgressMonitor();
		}
		return progressMonitor;
	}
	
	
	
	
	// Singleton instance
	static private WorkspaceManager instance = null;
	
	private WorkspaceManager() {
	}
	
	static public WorkspaceManager getWorkspaceManager() {
		if(instance==null) {
			instance = new WorkspaceManager();
		}
		return instance;
	}
	
}
