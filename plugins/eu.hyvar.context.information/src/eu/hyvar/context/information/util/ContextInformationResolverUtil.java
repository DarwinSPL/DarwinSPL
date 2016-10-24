package eu.hyvar.context.information.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.deltaecore.util.DEIOUtil;
import org.eclipse.emf.ecore.EObject;

import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.dataValues.HyEnum;


public class ContextInformationResolverUtil {

	public static final String[] FILE_EXTENSIONS = {"hycontextinformation"};
	
	// TODO incorporate evolution
	
	public static HyContextModel getAccompanyingContextModel(EObject elementInOriginalResource) {
//		String[] models = new String[1];
//		models[0] = "hyfeature";
		return DEIOUtil.doLoadAccompanyingModel(elementInOriginalResource, FILE_EXTENSIONS);
	}
	
	public static HyEnum resolveEnum(String identifier, HyContextModel contextModel, Date date) {
		if(identifier == null || contextModel == null) {
			return null;
		}
		
		// TODO incorporate Evolution
		List<HyEnum> matchingEnums = new ArrayList<HyEnum>();
		for(HyEnum hyEnum: contextModel.getEnums()) {
			if(hyEnum.getName().equals(identifier)) {
				matchingEnums.add(hyEnum);
			}
		}
		
		if(matchingEnums.size() > 1) {
			// TODO error: more than one valid element
		} else if(matchingEnums.size() == 1) {
			return matchingEnums.get(0);
		}
		
		return null;
	}
	
	public static String deresolveEnum(HyEnum hyEnum) {
		return hyEnum.getId();
	}
	
	public static HyContextualInformation resolveContextualInformation(String identifier, HyContextModel contextModel, Date date) {
		if(identifier == null || contextModel == null) {
			return null;
		}
		
		// TODO incorporate Evolution
		List<HyContextualInformation> matchingContextualInformation = new ArrayList<HyContextualInformation>();
		for(HyContextualInformation contextInfo: contextModel.getContextualInformations()) {
			if(contextInfo.getName().equals(identifier)) {
				matchingContextualInformation.add(contextInfo);
			}
		}
		
		if(matchingContextualInformation.size() > 1) {
			// TODO error: more than one valid element
		} else if(matchingContextualInformation.size() == 1) {
			return matchingContextualInformation.get(0);
		}
		
		return null;
	}
	
	public static String deresolveContextualInformation(HyContextualInformation contextInfo) {
		return contextInfo.getId();
	}
	
}
