package eu.hyvar.reconfigurator.io.rest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;

public class FileWriterUtility {

	/**
	 * 
	 * @param fileName
	 * @param fileExtension without dot.
	 * @param fileContent
	 * @param openedFolder
	 * @return
	 */
	public static IFile writeFileWithContent(String fileName, String fileExtension, String fileContent, IFolder openedFolder) {
		String[] folders = fileName.split("/");
		
		IFolder lastFolder = openedFolder;
		
		for(int i = 0; i<folders.length-1;i++) {
			IFolder folder = lastFolder.getFolder(folders[i]);
			
			if(!folder.exists()) {
				try {
					folder.create(true, true, null);
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			lastFolder = folder;
		}
		
		IFile file = lastFolder.getFile(folders[folders.length-1] + "." + fileExtension);
		InputStream inputStream = new ByteArrayInputStream(fileContent.getBytes());
		try {
			if(!file.exists()) {
				file.create(inputStream, true, null);				
			} else {
				 file.setContents(inputStream, IFile.FORCE, null);				
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		return file;
	}
	
}
