package eu.hyvar.feature.configuration.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import eu.hyvar.dataValues.HyBooleanValue;
import eu.hyvar.dataValues.HyEnumValue;
import eu.hyvar.dataValues.HyNumberValue;
import eu.hyvar.dataValues.HyStringValue;
import eu.hyvar.dataValues.HyValue;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyBooleanAttribute;
import eu.hyvar.feature.HyEnumAttribute;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyNumberAttribute;
import eu.hyvar.feature.HyRootFeature;
import eu.hyvar.feature.HyStringAttribute;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.configuration.HyAttributeValueAssignment;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.HyConfigurationElement;
import eu.hyvar.feature.constraint.HyConstraint;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.constraint.util.HyConstraintEvaluator;
import eu.hyvar.feature.constraint.util.HyConstraintFormatter;
import eu.hyvar.feature.constraint.util.HyConstraintIOUtil;
import eu.hyvar.feature.util.HyFeatureEvolutionUtil;

public class HyConfigurationChecker {

	private Map<EObject, String> errorMessages;

	public HyConfigurationChecker() {
		this.errorMessages = new HashMap<EObject, String>();
	}

	/**
	 * For one point in time
	 * IMPORTANT! CONSTRAINTS ARE NOT CHECKED AS CONTEXTS IN THEM CURRENTLY BREAK EVERYTHING #ContextCTC
	 * 
	 * @param configuration
	 * @return
	 */
	public boolean isValid(HyConfiguration configuration, Date date) {
		// TODO only valid features and versions. EMFValidation?-> Student?
		boolean isValid = true;

		List<HyConfigurationElement> validConfigurationElements = HyEvolutionUtil
				.getValidTemporalElements(configuration.getElements(), date);
		List<HyFeature> selectedFeatures = HyConfigurationUtil.getSelectedFeatures(validConfigurationElements);
		List<HyVersion> selectedVersions = HyConfigurationUtil.getSelectedVersions(validConfigurationElements);

		// Check if root feature is selected
		HyFeatureModel featureModel = configuration.getFeatureModel();
		HyRootFeature rootFeature = HyEvolutionUtil.getValidTemporalElement(featureModel.getRootFeature(), date);
		if (!selectedFeatures.contains(rootFeature.getFeature())) {
			isValid = false;
			addErrorMessage(rootFeature.getFeature(), "RootFeature for Date " + date + " must be selected");
		}

		for (HyFeature selectedFeature : selectedFeatures) {

			// check if parent of feature is selected
			if (!checkParentSelected(selectedFeature, date, featureModel, selectedFeatures)) {
				isValid = false;
			}

			// check if at least one feature of each alternative and or group is
			// selected
			if (!checkSubGroupsSelection(selectedFeature, date, selectedFeatures)) {
				isValid = false;
			}
		}

		List<HyFeature> selectedViaVersion = new ArrayList<HyFeature>();

		// Check if feature is selected in two different versions
		for (HyVersion version : selectedVersions) {
			if (selectedViaVersion.contains(version.getFeature())) {
				isValid = false;
				addErrorMessage(version.getFeature(), "Feature selected with multiple versions");
			} else {
				selectedViaVersion.add(version.getFeature());
			}
		}

		return isValid;
		
//		#ContextCTC
//		
//		// check cross-tree constraints
//		HyConstraintModel constraintModel = HyConstraintIOUtil.loadAccompanyingConstraintModel(featureModel);
//		if (constraintModel != null) {
//			HyConstraintEvaluator constraintEvaluator = new HyConstraintEvaluator();
//			boolean allConstraintsSatisfied = constraintEvaluator.evaluate(constraintModel, selectedFeatures,
//					selectedVersions, date);
//
//			if (!allConstraintsSatisfied) {
//
//				HyConstraint violatedConstraint = constraintEvaluator.getViolatedConstraint();
//				String formattedConstraint = HyConstraintFormatter.formatConstraint(violatedConstraint);
//				addErrorMessage(violatedConstraint, "Constraint \"" + formattedConstraint + "\" is violated.");
//
//				isValid = false;
//			}
//		}
//		
//
//		
//		// check attribute domains and right type of values
//		List<HyAttributeValueAssignment> attributeValueAssignments = HyConfigurationUtil.getAttributeValueAssignments(validConfigurationElements);
//		for(HyAttributeValueAssignment attributeValueAssignment: attributeValueAssignments) {
//			if(!checkAttributeValueAssignment(attributeValueAssignment, date)) {
//				isValid = false;
//			}
//		}
//
//		return isValid;
	}

	private boolean checkAttributeValueAssignment(HyAttributeValueAssignment attributeValueAssignment, Date date) {
		// TODO type match -> EMF Validation
		HyFeatureAttribute attribute = attributeValueAssignment.getAttribute();
		HyValue value = attributeValueAssignment.getValue();
		
		if(attribute instanceof HyNumberAttribute) {
			if(value instanceof HyNumberValue) {
				HyNumberAttribute numberAttribute = (HyNumberAttribute) attribute;
				HyNumberValue numberValue = (HyNumberValue) value;
				if(numberValue.getValue()<numberAttribute.getMin() || numberValue.getValue()>numberAttribute.getMax()) {
					addAttributeDomainViolationError(attribute, date);
					return false;
				}
			}
			else {
				addValueTypeMismatchError(attribute, date);
				return false;
			}
		} 
		else if(attribute instanceof HyEnumAttribute) {
			if(value instanceof HyEnumValue) {
				
				HyEnumAttribute enumAttribute = (HyEnumAttribute) attribute;
				HyEnumValue enumValue = (HyEnumValue) value;
				
				if(enumValue.getEnum() != enumAttribute.getEnumType()) {
					addAttributeDomainViolationError(attribute, date);
					return false;
				}
			}
			else {
				addValueTypeMismatchError(attribute, date);
				return false;
			}
		}
		else if(attribute instanceof HyBooleanAttribute) {
			if(! (value instanceof HyBooleanValue)) {
				addValueTypeMismatchError(attribute, date);
				return false;
			}
		}
		else if(attribute instanceof HyStringAttribute) {
			if(! (value instanceof HyStringValue)) {
				addValueTypeMismatchError(attribute, date);
				return false;
			}
		}
		
		return true;
	}
	
	private void addAttributeDomainViolationError(HyFeatureAttribute attribute, Date date) {
		addErrorMessage(attribute, "Value assigned to attribute "+HyEvolutionUtil.getValidTemporalElement(attribute.getNames(), date) + " does not match the attribute domain.");
	}
	
	private void addValueTypeMismatchError(HyFeatureAttribute attribute, Date date) {
		addErrorMessage(attribute, "Value assigned to attribute "+HyEvolutionUtil.getValidTemporalElement(attribute.getNames(), date) + " has the wrong type.");
	}
	
	private boolean checkParentSelected(HyFeature feature, Date date, HyFeatureModel featureModel,
			List<HyFeature> selectedFeatures) {

		if (!HyFeatureEvolutionUtil.isRootFeature(featureModel, feature, date)) {
			HyFeature parentFeature = HyFeatureEvolutionUtil.getParentFeatureOfFeature(feature, date);
			if (!selectedFeatures.contains(parentFeature)) {
				checkParentSelected(parentFeature, date, featureModel, selectedFeatures);
				addErrorMessage(parentFeature, "Feature has to be selected as feature in subtree is selected");
				return false;
			}
		}

		return true;
	}

	private boolean checkSubGroupsSelection(HyFeature feature, Date date, List<HyFeature> selectedFeatures) {
		boolean isValid = true;

		for (HyFeatureChild validFeatureChildren : HyEvolutionUtil.getValidTemporalElements(feature.getParentOf(),
				date)) {
			HyGroup childGroup = validFeatureChildren.getChildGroup();
			HyGroupComposition groupComposition = HyEvolutionUtil.getValidTemporalElement(childGroup.getParentOf(),
					date);
			if (childGroup.isAlternative(date) || childGroup.isOr(date)) {
				int selectedChildren = 0;
				for (HyFeature childFeature : groupComposition.getFeatures()) {
					if (selectedFeatures.contains(childFeature)) {
						selectedChildren++;
					}
				}

				if (selectedChildren == 0) {
					isValid = false;
					addErrorMessage(feature,
							"At least one Feature of each or and alternative subgroup has to be selected");
				} else if (selectedChildren > 1 && childGroup.isAlternative(date)) {
					isValid = false;
					addErrorMessage(feature, "Each alternative subgroup may only have exactly one feautre selected");
				}
			}
			// Check for selection of mandatory children
			else if (childGroup.isAnd(date)) {
				for (HyFeature childFeature : groupComposition.getFeatures()) {
					if (HyFeatureEvolutionUtil.isMandatory(childFeature, date)) {
						if (!selectedFeatures.contains(childFeature)) {
							addErrorMessage(childFeature,
									"Mandatory features have to be selected if parent is selected");
							isValid = false;
						}
					}
				}
			}
		}

		return isValid;
	}

	private void addErrorMessage(EObject object, String message) {
		if (errorMessages.containsKey(object)) {
			String existingMessage = errorMessages.get(object);
			existingMessage += System.lineSeparator();
			existingMessage += message;
			errorMessages.put(object, existingMessage);
		} else {
			errorMessages.put(object, message);
		}
	}

	public Map<EObject, String> getErrorMessages() {
		return errorMessages;
	}
	

}
