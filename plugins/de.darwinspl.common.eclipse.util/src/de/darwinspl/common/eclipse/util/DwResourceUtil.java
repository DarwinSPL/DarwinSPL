package de.darwinspl.common.eclipse.util;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;

import de.christophseidl.util.eclipse.ResourceUtil;

public class DwResourceUtil {

	/**
	 * Searches for a file with @extensions in the same project as the
	 * sourceFile. Starts with the same base name in the same folder and then
	 * goes levels up until the project folder and searches in all sub folders.
	 * Skips empty files.
	 * 
	 * @param sourceFile
	 * @param extensions
	 * @return may be null if no file was found
	 */
	public static IFile findFileWithExtensionInSameProject(IFile sourceFile, String... extensions) {
		if (sourceFile == null || extensions == null || extensions.length <= 0) {
			return null;
		}

		for (String extension : extensions) {
			IFile file = ResourceUtil.deriveFile(sourceFile, extension);

			if (!checkWhetherFileIsEmpty(file)) {
				return file;
			}
		}

		IContainer container = sourceFile.getParent();

		while (container != null) {

			IFile file = null;

			for (String extension : extensions) {
				file = ResourceUtil.findFirstFileWithExtension(container, extension);
				if (!checkWhetherFileIsEmpty(file)) {
					return file;
				}
			}

			// Repeat only if container is not a project
			if (container instanceof IProject) {
				return null;
			}

			container = container.getParent();
		}

		return null;
	}

	public static boolean checkWhetherFileIsEmpty(IFile file) {
		if (file == null || !file.exists()) {
			return true;
		}

		try {
			java.util.Scanner scanner = new java.util.Scanner(file.getContents());
			java.util.Scanner scannerDelemiter = scanner.useDelimiter("\\A");
			
			StringBuilder stringBuilder = new StringBuilder();

			while (scannerDelemiter.hasNext()) {
				stringBuilder.append(scannerDelemiter.next());
			}

			scannerDelemiter.close();
			scanner.close();

			if (!stringBuilder.toString().trim().equals("")) {
				return false;
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

}
