package de.darwinspl.feature.evolution.editoroperation;

import org.eclipse.emf.ecore.EObject;

import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureChild;

public class EditorOperationExplanation {
	
	private DwEditorOperation editorOperation;
	
	public EditorOperationExplanation(DwEditorOperation editorOperation) {
		this.editorOperation = editorOperation;
	}
	
	public String explain() {
		if (editorOperation instanceof DwEditorOperationFeatureType) {
			DwEditorOperationFeatureType featureType = (DwEditorOperationFeatureType) editorOperation;
			return explain(featureType);
		}
		else if (editorOperation instanceof DwEditorOperationFeatureGroup) {
			DwEditorOperationFeatureGroup featureGroup = (DwEditorOperationFeatureGroup) editorOperation;
			return explain(featureGroup);
		}
		else if (editorOperation instanceof DwEditorOperationGroupType) {
			DwEditorOperationGroupType groupType = (DwEditorOperationGroupType) editorOperation;
			return explain(groupType);
		}
		else if (editorOperation instanceof DwEditorOperationAttributeMinMax) {
			DwEditorOperationAttributeMinMax attributeMinMax = (DwEditorOperationAttributeMinMax) editorOperation;
			return explain(attributeMinMax);
		}
		else if (editorOperation instanceof DwEditorOperationConstraintCreate) {
			DwEditorOperationConstraintCreate constraint = (DwEditorOperationConstraintCreate) editorOperation;
			return explain(constraint);
		}
		else if (editorOperation instanceof DwEditorOperationValidityFormulaCreate) {
			DwEditorOperationValidityFormulaCreate validityFormula = (DwEditorOperationValidityFormulaCreate) editorOperation;
			return explain(validityFormula);
		}
		return null;
	}

	private String explain(DwEditorOperationFeatureType featureTypeOperation) {
		String featureName = HyEvolutionUtil.getValidTemporalElement(featureTypeOperation.getFeature().getNames(), featureTypeOperation.getEvoStep()).getName();
		String oldName = featureTypeOperation.getOldType().getType().getName();
		String newName = featureTypeOperation.getNewType().getType().getName();
		return "FeatureType of " + featureName + " changed from " + oldName +  " to " + newName + " in " + featureTypeOperation.getEvoStep();
	}
	
	private String explain(DwEditorOperationFeatureGroup featureGroupOperation) {
		String featureName = HyEvolutionUtil.getValidTemporalElement(featureGroupOperation.getFeature().getNames(), featureGroupOperation.getEvoStep()).getName();
		HyFeatureChild oldParentFeatureChild = HyEvolutionUtil.getValidTemporalElement(featureGroupOperation.getOldGroup().getCompositionOf().getChildOf(), featureGroupOperation.getEvoStep());
		String oldParentFeatureName = HyEvolutionUtil.getValidTemporalElement(oldParentFeatureChild.getParent().getNames(), featureGroupOperation.getEvoStep()).getName();
		HyFeatureChild newParentFeatureChild = HyEvolutionUtil.getValidTemporalElement(featureGroupOperation.getNewGroup().getCompositionOf().getChildOf(), featureGroupOperation.getEvoStep());
		String newParentFeatureName = HyEvolutionUtil.getValidTemporalElement(newParentFeatureChild.getParent().getNames(), featureGroupOperation.getEvoStep()).getName();
		return "Feature " + featureName + " moved from parent " + oldParentFeatureName + " to " + newParentFeatureName + " in " + featureGroupOperation.getEvoStep();
	}
	
	private String explain(DwEditorOperationGroupType groupTypeOperation) {
		HyFeatureChild groupChild = HyEvolutionUtil.getValidTemporalElement(groupTypeOperation.getGroup().getChildOf(), groupTypeOperation.getEvoStep());
		String parentFeatureName = HyEvolutionUtil.getValidTemporalElement(groupChild.getParent().getNames(), groupTypeOperation.getEvoStep()).getName();
		String oldGroupType = groupTypeOperation.getOldType().getType().getName();
		String newGroupType = groupTypeOperation.getNewType().getType().getName();
		return "GroupType beneath parent " + parentFeatureName + " changed from " + oldGroupType + " to " + newGroupType + " in " + groupTypeOperation.getEvoStep();
	}
	
	private String explain(DwEditorOperationAttributeMinMax attributeMinMaxOperation) {
		String attributeName = HyEvolutionUtil.getValidTemporalElement(attributeMinMaxOperation.getAttribute().getNames(), attributeMinMaxOperation.getEvoStep()).getName();
		return "Attribute of " + attributeName + " changed " + attributeMinMaxOperation.getType().getName() + " from " + attributeMinMaxOperation.getOldMinMax() + " to " + attributeMinMaxOperation.getNewMinMax() + " in " + attributeMinMaxOperation.getEvoStep();
	}
	
	private String explain(DwEditorOperationConstraintCreate constraintOperation) {
		return "Constraint created in " + constraintOperation.getEvoStep();
	}
	
	private String explain(DwEditorOperationValidityFormulaCreate validityFormulaOperation) {
		return "ValidityFormula created in " + validityFormulaOperation.getEvoStep();
	}
	
	public DwEditorOperation getEditorOperation() {
		return editorOperation;
	}

}
