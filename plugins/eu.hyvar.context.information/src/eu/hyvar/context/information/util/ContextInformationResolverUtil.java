package eu.hyvar.context.information.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.darwinspl.common.ecore.util.DwEcoreUtil;
import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.evolution.util.HyEvolutionUtil;


public class ContextInformationResolverUtil {

	public static final String[] FILE_EXTENSIONS = {HyContextInformationUtil.getContextModelFileExtensionForXmi()};
	
	
	public static HyContextModel getAccompanyingContextModel(EObject elementInOriginalResource) {
		EObject model = DwEcoreUtil.loadAccompanyingModelInSameProject(elementInOriginalResource, FILE_EXTENSIONS);
		
		if(model != null && model instanceof HyContextModel) {
			return (HyContextModel)model;
		}
		
		return null;
		
//
//		// refactor after DeltaEcore update:
//		// IFile file = DEIOUtil.doGetAccompanyingFile(elementInOriginalResource, FILE_EXTENSIONS);
//		
//		IFile file = null;
//		if (elementInOriginalResource == null) {
//			return null;
//		}
//		
//		IFile sourceFile = EcoreResolverUtil.resolveRelativeFileFromEObject(elementInOriginalResource);
//		
//		if (sourceFile == null) {
//			return null;
//		}
//
//		for (String fileExtension : FILE_EXTENSIONS) {
//			IFile accompanyingFile = ResourceUtil.deriveFile(sourceFile, fileExtension);
//		
//			if (accompanyingFile != null && accompanyingFile.exists()) {
//				file = accompanyingFile;
//				break;
//			}
//		}
//		
////		if(file == null) {
////			
////			IContainer container = sourceFile.getParent();
////			
////			while(container != null) {
////				
////				if(container instanceof IProject) {
////					break;
////				}
////				
////			}
////			for (String fileExtension : FILE_EXTENSIONS) {
////				
////			}
////			ResourceUtil.findFirstFileWithExtension(container, 
////		}
//		
//		
//		
//		if(file != null) {
//			try {
//				if(!file.exists()) {
//					return null;
//				}
//				
//				
//				java.util.Scanner scanner = new java.util.Scanner(file.getContents()).useDelimiter("\\A");
//				
//				StringBuilder stringBuilder = new StringBuilder();
//				
//				while(scanner.hasNext()) {
//					stringBuilder.append(scanner.next());
//				}
//				
//				scanner.close();
//				
//				if(stringBuilder.toString().trim().equals("")) {
//					return null;
//				}
//			} catch (CoreException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} else {
//			return null;
//		}
//		
//		return DEIOUtil.doLoadAccompanyingModel(elementInOriginalResource, FILE_EXTENSIONS);
	}
	
	public static HyEnum resolveEnum(String identifier, HyContextModel contextModel, Date date) {
		if(identifier == null || contextModel == null) {
			return null;
		}
		
		List<HyEnum> matchingEnums = new ArrayList<HyEnum>();
		for(HyEnum hyEnum: contextModel.getEnums()) {
			if(hyEnum.getName().equals(identifier)) {
				matchingEnums.add(hyEnum);
			}
		}
		
		if(matchingEnums.size() > 1) {
			// name is not unique
			List<HyEnum> validEnumsWithEvolution = new ArrayList<HyEnum>(1);
			for(HyEnum hyEnum: matchingEnums) {
				if(HyEvolutionUtil.isValid(hyEnum, date)) {
					validEnumsWithEvolution.add(hyEnum);
				}				
			}
			matchingEnums = validEnumsWithEvolution;
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

		// Try if name is unique
		List<HyContextualInformation> matchingContextualInformation = new ArrayList<HyContextualInformation>();
		
		for(HyContextualInformation contextInfo: contextModel.getContextualInformations()) {
			if(contextInfo.getName().equals(identifier)) {
				matchingContextualInformation.add(contextInfo);
			}
		}
		
		if(matchingContextualInformation.size() > 1) {
			// name is not unique. incorporate evolution
			matchingContextualInformation.clear();
			
			for(HyContextualInformation contextInfo: HyEvolutionUtil.getValidTemporalElements(matchingContextualInformation, date)) {
				if(contextInfo.getName().equals(identifier)) {
					matchingContextualInformation.add(contextInfo);
				}
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
