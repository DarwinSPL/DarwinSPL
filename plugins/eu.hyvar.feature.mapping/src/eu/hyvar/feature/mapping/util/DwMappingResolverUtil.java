package eu.hyvar.feature.mapping.util;

import org.eclipse.emf.ecore.EObject;

import de.darwinspl.common.ecore.util.DwEcoreUtil;
import eu.hyvar.feature.mapping.HyMappingModel;

public class DwMappingResolverUtil {

	public static HyMappingModel getAccompanyingContextModel(EObject elementInOriginalResource) {

		EObject model = DwEcoreUtil.loadAccompanyingModelInSameProject(elementInOriginalResource, HyMappingModelUtil.getMappingModelFileExtensions());
		
		if(model != null && model instanceof HyMappingModel) {
			return (HyMappingModel)model;
		}
		
		return null;
	}
}
