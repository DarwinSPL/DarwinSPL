package de.darwinspl.common.ecore.util;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;

import de.christophseidl.util.ecore.EcoreIOUtil;
import de.christophseidl.util.ecore.EcoreResolverUtil;
import de.darwinspl.common.eclipse.util.DwResourceUtil;

public class DwEcoreUtil {

	
	public static EObject loadAccompanyingModelInSameProject(EObject elementInOriginalResource, String... extensions) {
		if(elementInOriginalResource == null || extensions == null || extensions.length < 1) {
			return null;
		}
		
		IFile sourceFile = EcoreResolverUtil.resolveRelativeFileFromEObject(elementInOriginalResource);
		
		IFile modelFile = DwResourceUtil.findFileWithExtensionInSameProject(sourceFile, extensions);
		
		if(modelFile != null) {
			return EcoreIOUtil.loadModel(modelFile, elementInOriginalResource.eResource().getResourceSet());
		}
		
		return null;
	}
	
}
