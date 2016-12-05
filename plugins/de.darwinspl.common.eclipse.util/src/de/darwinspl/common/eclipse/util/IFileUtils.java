package de.darwinspl.common.eclipse.util;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;

public class IFileUtils {

	public static String readStringFromFile(IFile file) {
		java.io.InputStream is;
		
		String readString = "";
		
		try {
			is = file.getContents();
			byte[] b = new byte[is.available()];
			is.read(b);
			is.close();
			readString = new String(b);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return readString;
	}
	
}
