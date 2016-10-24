package eu.hyvar.feature.expression.util;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;
//import org.eclipse.ui.IEditorPart;
//import org.eclipse.ui.IEditorReference;
//import org.eclipse.ui.IWorkbench;
//import org.eclipse.ui.IWorkbenchPage;
//import org.eclipse.ui.IWorkbenchWindow;
//import org.eclipse.ui.PlatformUI;

import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.context.information.util.ContextInformationResolverUtil;
import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.data.util.IdentifierWithDateUtil;
import eu.hyvar.feature.data.util.Tuple;
import eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyVersionRestriction;
import eu.hyvar.feature.util.HyFeatureModelWellFormednessException;
import eu.hyvar.feature.util.HyFeatureResolverUtil;


public class HyExpressionResolverUtil {
	private final static String FEATUREMODEL_EDITOR_EXTENSIONPOINT_ID = "eu.hyvar.feature.expression.FeatureModelEditor";
	
	public static HyFeature resolveFeature(String identifier, EObject elementFromAccompanyingResource) {	
		HyFeatureModel featureModel = HyFeatureResolverUtil.getAccompanyingFeatureModel(elementFromAccompanyingResource);	

		if (identifier == null) {
			return null;
		}
		
		Tuple<String, Date> identifierAndDate = IdentifierWithDateUtil.getIdentifierAndDate(identifier);
		if(identifierAndDate.getSecondEntry() == null) {
			identifierAndDate.setSecondEntry(new Date());
		}
		
		
		try {
			return HyFeatureResolverUtil.resolveFeature(identifierAndDate.getFirstEntry(), featureModel, identifierAndDate.getSecondEntry());
		} catch (HyFeatureModelWellFormednessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static HyVersion resolveVersion(String identifier, HyVersionRestriction container) {
		// TODO?
		
		HyAbstractFeatureReferenceExpression featureReference = container.getRestrictedFeatureReferenceExpression();
		HyFeature feature = featureReference.getFeature();
		
		return HyFeatureResolverUtil.resolveVersion(identifier, feature);
	}
	
	
	public static HyFeatureAttribute resolveFeatureAttribute(String identifier, EObject elementFromAccompanyingResource, HyFeature containingFeature) {
//		HyFeatureModel featureModel = HyFeatureResolverUtil.getAccompanyingFeatureModel(elementFromAccompanyingResource);

		if (identifier == null || containingFeature == null) {
			return null;
		}
		
		Tuple<String, Date> identifierAndDate = IdentifierWithDateUtil.getIdentifierAndDate(identifier);
		if(identifierAndDate.getSecondEntry() == null) {
			identifierAndDate.setSecondEntry(new Date());
		}
		
		try {
			return HyFeatureResolverUtil.resolveFeatureAttribute(identifierAndDate.getFirstEntry(), containingFeature, identifierAndDate.getSecondEntry());
		} catch (HyFeatureModelWellFormednessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static HyEnum resolveEnum(String identifier, EObject elementFromAccompanyingResource) {
		
		
		if (identifier == null) {
			return null;
		}
		
		HyContextModel contextModel = ContextInformationResolverUtil.getAccompanyingContextModel(elementFromAccompanyingResource);
		
		if(contextModel == null) {
			return null;
		}
		
		// TODO incorporate evolution!
//		try {
			return ContextInformationResolverUtil.resolveEnum(identifier, contextModel, new Date());
//		} catch (HyFeatureModelWellFormednessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
		
//		return null;
	}
	
	
	public static String deresolveEnum(HyEnum hyEnum) {
		if(hyEnum == null) {
			return "";
		}
		return ContextInformationResolverUtil.deresolveEnum(hyEnum);
	}
	
	public static HyContextualInformation resolveContextualInformation(String identifier, EObject elementFromAccompanyingResource) {
		
		if (identifier == null) {
			return null;
		}
		
		HyContextModel contextModel = ContextInformationResolverUtil.getAccompanyingContextModel(elementFromAccompanyingResource);
		
		if(contextModel == null) {
			return null;
		}
		
		Tuple<String, Date> identifierAndDate = IdentifierWithDateUtil.getIdentifierAndDate(identifier);
		if(identifierAndDate.getSecondEntry() == null) {
			identifierAndDate.setSecondEntry(new Date());
		}
		
		return ContextInformationResolverUtil.resolveContextualInformation(identifierAndDate.getFirstEntry(), contextModel, identifierAndDate.getSecondEntry());
		
	}
	
	public static String deresolveContextualInformation(HyContextualInformation contextInfo) {
		if(contextInfo == null) {
			return "";
		}
		return contextInfo.getId();
	}
	
}