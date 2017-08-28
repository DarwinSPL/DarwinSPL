package eu.hyvar.reconfigurator.io.rest.spl_implementation;

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import eu.hyvar.reconfigurator.io.rest.spl_implementation.io.raw_output_error_resolution.RawOutputError;

public class WorkspaceUtility {

	public static IFile saveFileContent (String fileName, byte[] content, IFolder folder, IProgressMonitor progressMonitor, RawOutputError error) {
		if(fileName.startsWith("\\")||fileName.startsWith("/")) {
			fileName = fileName.substring(1);
		}
		WorkspaceUtility.createFilePath(fileName, folder, progressMonitor, error);

		IFile ifile = folder.getFile(fileName);
		ByteArrayInputStream inputStream = new ByteArrayInputStream(content);
		try {
			if(!ifile.exists()) {
				ifile.create(inputStream, true, progressMonitor);				
			} else {
				ifile.setContents(inputStream, IFile.FORCE, progressMonitor);
			}
			return ifile;
		} catch (CoreException e) {
			error.setErrorString(error.getErrorString()+"\n Error creating file ("+fileName+"): "+e.toString());
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	public static void createFilePath(String fileName, IFolder folder, IProgressMonitor progressMonitor, RawOutputError error) {

		String relativePath = "";
		try {
			String elements[] = fileName.split("/|\\\\");
			// Remove the file name (last element)
			elements[elements.length-1]="";
			
			IFolder relativeFolder;
			for(String element: elements) {
				if(!"".equals(element)) {
					relativeFolder = folder.getFolder(relativePath+element);
					if(!relativeFolder.exists()) {
						relativeFolder.create(true, true, progressMonitor);
					}
					relativePath += element+"/";
				}
			}
		} catch (CoreException e) {
			error.setErrorString(error.getErrorString()+"\n Error creating folder ("+relativePath+"): "+e.toString());
		}
	}

}
