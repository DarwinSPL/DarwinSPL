/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.mopp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public class HymanifestNewFileContentProvider {
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestMetaInformation getMetaInformation() {
		return new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestMetaInformation();
	}
	
	public String getNewFileContent(String newFileName) {
		return getExampleContent(new EClass[] {
			eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLImplementation(),
			eu.hyvar.mspl.manifest.ManifestPackage.eINSTANCE.getHySPLSignature(),
		}, getMetaInformation().getClassesWithSyntax(), newFileName);
	}
	
	protected String getExampleContent(EClass[] startClasses, EClass[] allClassesWithSyntax, String newFileName) {
		String content = "";
		for (EClass next : startClasses) {
			content = getExampleContent(next, allClassesWithSyntax, newFileName);
			if (content.trim().length() > 0) {
				break;
			}
		}
		return content;
	}
	
	protected String getExampleContent(EClass eClass, EClass[] allClassesWithSyntax, String newFileName) {
		// create a minimal model
		EObject root = new eu.hyvar.mspl.manifest.resource.hymanifest.util.HymanifestMinimalModelHelper().getMinimalModel(eClass, allClassesWithSyntax, newFileName);
		if (root == null) {
			// could not create a minimal model. returning an empty document is the best we
			// can do.
			return "";
		}
		// use printer to get text for model
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextPrinter printer = getPrinter(buffer);
		try {
			printer.print(root);
		} catch (IOException e) {
			new eu.hyvar.mspl.manifest.resource.hymanifest.util.HymanifestRuntimeUtil().logError("Exception while generating example content.", e);
		}
		return buffer.toString();
	}
	
	public eu.hyvar.mspl.manifest.resource.hymanifest.IHymanifestTextPrinter getPrinter(OutputStream outputStream) {
		return getMetaInformation().createPrinter(outputStream, new eu.hyvar.mspl.manifest.resource.hymanifest.mopp.HymanifestResource());
	}
	
}
