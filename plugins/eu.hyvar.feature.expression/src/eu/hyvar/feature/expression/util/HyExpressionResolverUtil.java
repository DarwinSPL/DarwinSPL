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
//	private final static String FEATUREMODEL_EDITOR_EXTENSIONPOINT_ID = "eu.hyvar.feature.expression.FeatureModelEditor";

	public static HyFeature resolveFeature(String identifier, EObject elementFromAccompanyingResource) {
		if (elementFromAccompanyingResource == null) {
			return null;
		}
		
		HyFeatureModel featureModel = HyFeatureResolverUtil
				.getAccompanyingFeatureModel(elementFromAccompanyingResource);

		return resolveFeatureFromFeatureModel(identifier, featureModel);
	}
	
	public static HyFeature resolveFeatureFromFeatureModel(String identifier, HyFeatureModel featureModel) {
		if (identifier == null) {
			return null;
		}
		
		identifier = removeQuotationMarks(identifier);
		
		Tuple<String, Date> identifierAndDate = IdentifierWithDateUtil.getIdentifierAndDate(identifier);
		if (identifierAndDate.getSecondEntry() == null) {
			identifierAndDate.setSecondEntry(new Date());
		}

		try {
			return HyFeatureResolverUtil.resolveFeature(identifierAndDate.getFirstEntry(), featureModel,
					identifierAndDate.getSecondEntry());
		} catch (HyFeatureModelWellFormednessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static String removeQuotationMarks(String identifier) {
		if (identifier.startsWith("\"") && identifier.endsWith("\"")) {
			return identifier.substring(1, identifier.length() - 1);
		}
		return identifier;
	}
	
	public static HyVersion resolveVersion(String identifier, HyVersionRestriction container) {
		HyFeature feature = null;
		
		HyAbstractFeatureReferenceExpression featureReference = container.getRestrictedFeatureReferenceExpression();
		if(featureReference != null) {
			feature = featureReference.getFeature();			
		}
		
		
		if(identifier == null || feature == null) {
			return null;
		}
		
		identifier = removeQuotationMarks(identifier);
		
		Tuple<String, Date> identifierAndDate = IdentifierWithDateUtil.getIdentifierAndDate(identifier);
		if (identifierAndDate.getSecondEntry() == null) {
			identifierAndDate.setSecondEntry(new Date());
		}
		

		try {
			return HyFeatureResolverUtil.resolveVersion(identifierAndDate.getFirstEntry(), feature, identifierAndDate.getSecondEntry());
		} catch (HyFeatureModelWellFormednessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public static HyFeatureAttribute resolveFeatureAttribute(String identifier, EObject elementFromAccompanyingResource,
			HyFeature containingFeature) {
		// HyFeatureModel featureModel =
		// HyFeatureResolverUtil.getAccompanyingFeatureModel(elementFromAccompanyingResource);

		if (identifier == null || containingFeature == null) {
			return null;
		}
		
		identifier = removeQuotationMarks(identifier);

		Tuple<String, Date> identifierAndDate = IdentifierWithDateUtil.getIdentifierAndDate(identifier);
		if (identifierAndDate.getSecondEntry() == null) {
			identifierAndDate.setSecondEntry(new Date());
		}

		try {
			return HyFeatureResolverUtil.resolveFeatureAttribute(identifierAndDate.getFirstEntry(), containingFeature,
					identifierAndDate.getSecondEntry());
		} catch (HyFeatureModelWellFormednessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static HyEnum resolveEnum(String identifier, EObject elementFromAccompanyingResource) {

		HyEnum resolved = null;

		if (identifier == null) {
			return null;
		}
		
		identifier = removeQuotationMarks(identifier);
		// TODO: Ambiguity between Enums in FM and ContextModel
		// TODO evolution

		HyContextModel contextModel = ContextInformationResolverUtil
				.getAccompanyingContextModel(elementFromAccompanyingResource);

		if (contextModel != null) {
			resolved = ContextInformationResolverUtil.resolveEnum(identifier, contextModel, new Date());
		}

		if (resolved == null) {
			HyFeatureModel featureModel = HyFeatureResolverUtil
					.getAccompanyingFeatureModel(elementFromAccompanyingResource);

			if (featureModel != null) {
				resolved = HyFeatureResolverUtil.resolveEnum(identifier, featureModel, new Date());
			}
		}

		return resolved;
	}

	public static String deresolveEnum(HyEnum hyEnum) {
		if (hyEnum == null) {
			return "";
		}
		return ContextInformationResolverUtil.deresolveEnum(hyEnum);
	}

	public static HyContextualInformation resolveContextualInformation(String identifier,
			EObject elementFromAccompanyingResource) {

		if (identifier == null) {
			return null;
		}

		HyContextModel contextModel = ContextInformationResolverUtil
				.getAccompanyingContextModel(elementFromAccompanyingResource);

		if (contextModel == null) {
			return null;
		}

		Tuple<String, Date> identifierAndDate = IdentifierWithDateUtil.getIdentifierAndDate(identifier);
		if (identifierAndDate.getSecondEntry() == null) {
			identifierAndDate.setSecondEntry(new Date());
		}

		return ContextInformationResolverUtil.resolveContextualInformation(identifierAndDate.getFirstEntry(),
				contextModel, identifierAndDate.getSecondEntry());

	}

	public static String deresolveContextualInformation(HyContextualInformation contextInfo) {
		if (contextInfo == null) {
			return "";
		}
		return contextInfo.getId();
	}
	
}
