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
		IFile file = openedFolder.getFile(fileName + "." + fileExtension);
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
