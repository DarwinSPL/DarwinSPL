package eu.hyvar.feature.constraint.util;

import org.deltaecore.util.DEIOUtil;
import org.eclipse.emf.ecore.EObject;

import eu.hyvar.feature.constraint.HyConstraintModel;

public class HyConstraintIOUtil {
	
	public static HyConstraintModel loadAccompanyingConstraintModel(EObject elementInSourceResource) {
		String[] FILE_EXTENSIONS = {HyConstraintUtil.CONSTRAINT_MODEL_FILE_EXTENSION_FOR_CONCRETE_SYNTAX, HyConstraintUtil.CONSTRAINT_MODEL_FILE_EXTENSION_FOR_XMI};
		return DEIOUtil.doLoadAccompanyingModel(elementInSourceResource, FILE_EXTENSIONS);
	}
}
