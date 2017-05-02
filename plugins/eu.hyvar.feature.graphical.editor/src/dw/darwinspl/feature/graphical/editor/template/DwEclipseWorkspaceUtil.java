package dw.darwinspl.feature.graphical.editor.template;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import dw.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;

public class DwEclipseWorkspaceUtil {
	private static IPath getPathWithFilenameFromCurrentOpenEditorFile(){
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();
		
		DwGraphicalFeatureModelViewer editor = (DwGraphicalFeatureModelViewer)page.getActiveEditor();
		return editor.getFile().getFullPath();
	}
	public static IPath getPathFromCurrentOpenEditorFile(){
		IPath path = getPathWithFilenameFromCurrentOpenEditorFile();
		
		return path.removeLastSegments(1);
	}
	public static String getFilenameFromCurrentOpenEditorFile(){
		IPath path = getPathWithFilenameFromCurrentOpenEditorFile().removeFileExtension();
		
		return path.segment(path.segmentCount()-1);
	}
	public static IPath createFolderInPathFromCurrentOpenEditorFile(String name){
		IPath path = getPathFromCurrentOpenEditorFile();
		path =  path.append(name);
		
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot workspaceRoot = workspace.getRoot();
		
		IFile file = workspaceRoot.getFile(path);
		File oFile = new File(file.getLocationURI());
		
		if(!oFile.mkdir()){
		}
	
		return path;
	}
	
	public static File createFileInPath(String fileName, IPath path){
		path = path.append(fileName);
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot workspaceRoot = workspace.getRoot();
		
		IFile outputFile = workspaceRoot.getFile(path);
		File file = new File(outputFile.getLocationURI());
		
		if(!file.exists())
			try {
				if(!file.createNewFile()){
					return null;
				}
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		
		return file;
	}
	
	public static void copyFile(File oldFile, File newFile) throws IOException{
	    FileChannel sourceChannel = null;
	    FileChannel destChannel = null;
	    try {
	    	if(oldFile.exists() && ! !newFile.exists()){
	    		sourceChannel = new FileInputStream(oldFile.getAbsolutePath()).getChannel();
	        	destChannel = new FileOutputStream(newFile.getAbsoluteFile()).getChannel();
	        	destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
	    	}
	       }finally{
	           sourceChannel.close();
	           destChannel.close();
	   }
	    
	}
}
