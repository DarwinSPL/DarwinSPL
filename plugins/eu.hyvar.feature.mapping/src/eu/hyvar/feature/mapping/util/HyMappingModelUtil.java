package eu.hyvar.feature.mapping.util;

public class HyMappingModelUtil {

	private static final String MAPPING_MODEL_FILE_EXTENSION_FOR_XMI = "hymappingmodel";
	private static final String MAPPING_MODEL_FILE_EXTENSION_FOR_CONCRETE_SYNTAX = "hymapping";
	
	private static final String[] MAPPING_MODEL_FILE_EXTENSIONS = {MAPPING_MODEL_FILE_EXTENSION_FOR_XMI, MAPPING_MODEL_FILE_EXTENSION_FOR_CONCRETE_SYNTAX};
	
	public static String getMappingModelFileExtensionForXmi() {
		return MAPPING_MODEL_FILE_EXTENSION_FOR_XMI;
	}
	public static String getMappingModelFileExtensionForConcreteSyntax() {
		return MAPPING_MODEL_FILE_EXTENSION_FOR_CONCRETE_SYNTAX;
	}
	public static String[] getMappingModelFileExtensions() {
		return MAPPING_MODEL_FILE_EXTENSIONS;
	}
	
	
	
}
