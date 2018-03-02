package eu.hyvar.context.contextValidity.util;

import org.eclipse.emf.ecore.EObject;

import de.darwinspl.common.ecore.util.DwEcoreUtil;
import eu.hyvar.context.contextValidity.HyValidityModel;

public class HyValidityModelUtil {
	
	private static final String VALIDITY_MODEL_FILE_EXTENSION_FOR_XMI = "hyvalidityformula_xmi";
	private static final String VALIDITY_MODEL_FILE_EXTENSION_FOR_CONCRETE_SYNTAX = "hyvalidityformula";
	
	public static final String[] FILE_EXTENSIONS = {VALIDITY_MODEL_FILE_EXTENSION_FOR_XMI, VALIDITY_MODEL_FILE_EXTENSION_FOR_CONCRETE_SYNTAX};
	
	public static String getValidityModelFileExtensionForXmi() {
		return VALIDITY_MODEL_FILE_EXTENSION_FOR_XMI;
	}
	public static String getValidityModelFileExtensionForConcreteSyntax() {
		return VALIDITY_MODEL_FILE_EXTENSION_FOR_CONCRETE_SYNTAX;
	}
	
	public static HyValidityModel getAccompanyingValidityModel(EObject elementInOriginalResource) {
		EObject model = DwEcoreUtil.loadAccompanyingModelInSameProject(elementInOriginalResource, FILE_EXTENSIONS);
		
		if(model != null && model instanceof HyValidityModel) {
			return (HyValidityModel) model;
		}
		
		return null;
	}
	

}
