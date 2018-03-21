package de.darwinspl.feature.evolution.editoroperation;

import java.util.Date;

import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureChild;

public class EditorOperationExplanation {
	
	private DwEditorOperation editorOperation;
	
	public EditorOperationExplanation(DwEditorOperation editorOperation) {
		this.editorOperation = editorOperation;
	}
	
	public String explain() {
		if (editorOperation instanceof DwEditorOperationFeatureCreate) {
			DwEditorOperationFeatureCreate featureOperation = (DwEditorOperationFeatureCreate) editorOperation;
			return explain(featureOperation);
		}
		else if (editorOperation instanceof DwEditorOperationFeatureDelete) {
			DwEditorOperationFeatureDelete featureOperation = (DwEditorOperationFeatureDelete) editorOperation;
			return explain(featureOperation);
		}
		else if (editorOperation instanceof DwEditorOperationFeatureRename) {
			DwEditorOperationFeatureRename featureOperation = (DwEditorOperationFeatureRename) editorOperation;
			return explain(featureOperation);
		}
		else if (editorOperation instanceof DwEditorOperationFeatureType) {
			DwEditorOperationFeatureType featureType = (DwEditorOperationFeatureType) editorOperation;
			return explain(featureType);
		}
		else if (editorOperation instanceof DwEditorOperationFeatureGroup) {
			DwEditorOperationFeatureGroup featureGroup = (DwEditorOperationFeatureGroup) editorOperation;
			return explain(featureGroup);
		}
		else if (editorOperation instanceof DwEditorOperationFeatureVersionCreate) {
			DwEditorOperationFeatureVersionCreate featureOperation = (DwEditorOperationFeatureVersionCreate) editorOperation;
			return explain(featureOperation);
		}
		else if (editorOperation instanceof DwEditorOperationFeatureVersionDelete) {
			DwEditorOperationFeatureVersionDelete featureOperation = (DwEditorOperationFeatureVersionDelete) editorOperation;
			return explain(featureOperation);
		}
		else if (editorOperation instanceof DwEditorOperationGroupType) {
			DwEditorOperationGroupType groupType = (DwEditorOperationGroupType) editorOperation;
			return explain(groupType);
		}
		else if (editorOperation instanceof DwEditorOperationAttributeCreate) {
			DwEditorOperationAttributeCreate attributeOperation = (DwEditorOperationAttributeCreate) editorOperation;
			return explain(attributeOperation);
		}
		else if (editorOperation instanceof DwEditorOperationAttributeDelete) {
			DwEditorOperationAttributeDelete attributeOperation = (DwEditorOperationAttributeDelete) editorOperation;
			return explain(attributeOperation);
		}
		else if (editorOperation instanceof DwEditorOperationAttributeRename) {
			DwEditorOperationAttributeRename attributeOperation = (DwEditorOperationAttributeRename) editorOperation;
			return explain(attributeOperation);
		}
		else if (editorOperation instanceof DwEditorOperationAttributeMinMax) {
			DwEditorOperationAttributeMinMax attributeMinMax = (DwEditorOperationAttributeMinMax) editorOperation;
			return explain(attributeMinMax);
		}
		else if (editorOperation instanceof DwEditorOperationAttributeEnum) {
			DwEditorOperationAttributeEnum attributeOperation = (DwEditorOperationAttributeEnum) editorOperation;
			return explain(attributeOperation);
		}
		else if (editorOperation instanceof DwEditorOperationEnumCreate) {
			DwEditorOperationEnumCreate enumOperation = (DwEditorOperationEnumCreate) editorOperation;
			return explain(enumOperation);
		}
		else if (editorOperation instanceof DwEditorOperationEnumDelete) {
			DwEditorOperationEnumDelete enumOperation = (DwEditorOperationEnumDelete) editorOperation;
			return explain(enumOperation);
		}
		else if (editorOperation instanceof DwEditorOperationEnumLiteralCreate) {
			DwEditorOperationEnumLiteralCreate enumOperation = (DwEditorOperationEnumLiteralCreate) editorOperation;
			return explain(enumOperation);
		}
		else if (editorOperation instanceof DwEditorOperationEnumLiteralDelete) {
			DwEditorOperationEnumLiteralDelete enumOperation = (DwEditorOperationEnumLiteralDelete) editorOperation;
			return explain(enumOperation);
		}
		else if (editorOperation instanceof DwEditorOperationConstraintCreate) {
			DwEditorOperationConstraintCreate constraint = (DwEditorOperationConstraintCreate) editorOperation;
			return explain(constraint);
		}
		else if (editorOperation instanceof DwEditorOperationConstraintDelete) {
			DwEditorOperationConstraintDelete constraint = (DwEditorOperationConstraintDelete) editorOperation;
			return explain(constraint);
		}
		else if (editorOperation instanceof DwEditorOperationContextCreate) {
			DwEditorOperationContextCreate context = (DwEditorOperationContextCreate) editorOperation;
			return explain(context);
		}
		else if (editorOperation instanceof DwEditorOperationContextDelete) {
			DwEditorOperationContextDelete context = (DwEditorOperationContextDelete) editorOperation;
			return explain(context);
		}
		else if (editorOperation instanceof DwEditorOperationValidityFormulaCreate) {
			DwEditorOperationValidityFormulaCreate validityFormula = (DwEditorOperationValidityFormulaCreate) editorOperation;
			return explain(validityFormula);
		}
		else if (editorOperation instanceof DwEditorOperationValidityFormulaDelete) {
			DwEditorOperationValidityFormulaDelete validityFormula = (DwEditorOperationValidityFormulaDelete) editorOperation;
			return explain(validityFormula);
		}
		return null;
	}

	private String explain(DwEditorOperationFeatureCreate featureOperation) {
		String featureName = HyEvolutionUtil.getValidTemporalElement(featureOperation.getFeature().getNames(), featureOperation.getEvoStep()).getName();
		String date = featureOperation.getEvoStep() == null ? "eternity" : featureOperation.getEvoStep().toString();
		return "Feature " + featureName + " was created on " + date;
	}

	private String explain(DwEditorOperationFeatureDelete featureOperation) {
		String featureName = HyEvolutionUtil.getValidTemporalElement(featureOperation.getFeature().getNames(), featureOperation.getEvoStep()).getName();
		return "Feature " + featureName + " was deleted on " + featureOperation.getEvoStep().toString();
	}

	private String explain(DwEditorOperationFeatureRename featureOperation) {
		String oldName = featureOperation.getOldName().getName();
		String newName = featureOperation.getNewName().getName();
		return "Feature " + oldName + " was renamed to " +  newName + " on " + featureOperation.getEvoStep();
	}

	private String explain(DwEditorOperationFeatureType featureTypeOperation) {
		String featureName = HyEvolutionUtil.getValidTemporalElement(featureTypeOperation.getFeature().getNames(), featureTypeOperation.getEvoStep()).getName();
		String oldName = featureTypeOperation.getOldType().getType().getName();
		String newName = featureTypeOperation.getNewType().getType().getName();
		return "FeatureType of " + featureName + " changed from " + oldName +  " to " + newName + " on " + featureTypeOperation.getEvoStep();
	}
	
	private String explain(DwEditorOperationFeatureGroup featureGroupOperation) {
		String featureName = HyEvolutionUtil.getValidTemporalElement(featureGroupOperation.getFeature().getNames(), featureGroupOperation.getEvoStep()).getName();
		HyFeatureChild oldParentFeatureChild = HyEvolutionUtil.getValidTemporalElement(featureGroupOperation.getOldGroup().getCompositionOf().getChildOf(), new Date(featureGroupOperation.getEvoStep().getTime() -1L));
		String oldParentFeatureName = HyEvolutionUtil.getValidTemporalElement(oldParentFeatureChild.getParent().getNames(), new Date(featureGroupOperation.getEvoStep().getTime() -1L)).getName();
		HyFeatureChild newParentFeatureChild = HyEvolutionUtil.getValidTemporalElement(featureGroupOperation.getNewGroup().getCompositionOf().getChildOf(), featureGroupOperation.getEvoStep());
		String newParentFeatureName = HyEvolutionUtil.getValidTemporalElement(newParentFeatureChild.getParent().getNames(), featureGroupOperation.getEvoStep()).getName();
		return "Feature " + featureName + " moved from parent " + oldParentFeatureName + " to " + newParentFeatureName + " on " + featureGroupOperation.getEvoStep();
	}

	private String explain(DwEditorOperationFeatureVersionCreate featureOperation) {
		String featureName = HyEvolutionUtil.getValidTemporalElement(featureOperation.getFeature().getNames(), featureOperation.getEvoStep()).getName();
		String versionNumber = featureOperation.getVersion().getNumber();
		String date = featureOperation.getEvoStep() == null ? "eternity" : featureOperation.getEvoStep().toString();
		return "Version " + versionNumber + " of " + featureName + " was created on " + date;
	}

	private String explain(DwEditorOperationFeatureVersionDelete featureOperation) {
		String featureName = HyEvolutionUtil.getValidTemporalElement(featureOperation.getFeature().getNames(), featureOperation.getEvoStep()).getName();
		String versionNumber = featureOperation.getVersion().getNumber();
		return "Version " + versionNumber + " of " + featureName + " was deleted on " + featureOperation.getEvoStep();
	}
	
	private String explain(DwEditorOperationGroupType groupTypeOperation) {
		HyFeatureChild groupChild = HyEvolutionUtil.getValidTemporalElement(groupTypeOperation.getGroup().getChildOf(), groupTypeOperation.getEvoStep());
		String parentFeatureName = HyEvolutionUtil.getValidTemporalElement(groupChild.getParent().getNames(), groupTypeOperation.getEvoStep()).getName();
		String oldGroupType = groupTypeOperation.getOldType().getType().getName();
		String newGroupType = groupTypeOperation.getNewType().getType().getName();
		return "GroupType beneath parent " + parentFeatureName + " changed from " + oldGroupType + " to " + newGroupType + " on " + groupTypeOperation.getEvoStep();
	}
	
	private String explain(DwEditorOperationAttributeCreate attributeOperation) {
		String attributeName = HyEvolutionUtil.getValidTemporalElement(attributeOperation.getAttribute().getNames(), attributeOperation.getEvoStep()).getName();
		String date = attributeOperation.getEvoStep() == null ? "eternity" : attributeOperation.getEvoStep().toString();
		return "Attribute " + attributeName + " was created on " + date;
	}
	
	private String explain(DwEditorOperationAttributeDelete attributeOperation) {
		String attributeName = HyEvolutionUtil.getValidTemporalElement(attributeOperation.getAttribute().getNames(), attributeOperation.getEvoStep()).getName();
		return "Attribute " + attributeName + " was deleted on " + attributeOperation.getEvoStep();
	}
	
	private String explain(DwEditorOperationAttributeRename attributeOperation) {
		String oldName = attributeOperation.getOldName().getName();
		String newName = attributeOperation.getNewName().getName();
		return "Attribute " + oldName + " renamed to " + newName + " on " + attributeOperation.getEvoStep();
	}
	
	private String explain(DwEditorOperationAttributeMinMax attributeMinMaxOperation) {
		String attributeName = HyEvolutionUtil.getValidTemporalElement(attributeMinMaxOperation.getAttribute().getNames(), attributeMinMaxOperation.getEvoStep()).getName();
		return "Attribute " + attributeName + " changed " + attributeMinMaxOperation.getType().getName() + " from " + attributeMinMaxOperation.getOldMinMax() + " to " + attributeMinMaxOperation.getNewMinMax() + " on " + attributeMinMaxOperation.getEvoStep();
	}
	
	private String explain(DwEditorOperationAttributeEnum attributeOperation) {
		String attributeName = HyEvolutionUtil.getValidTemporalElement(attributeOperation.getAttribute().getNames(), attributeOperation.getEvoStep()).getName();
		String oldEnumName = attributeOperation.getOldEnum().getName();
		String newEnumName = attributeOperation.getNewEnum().getName();
		return "Attribute " + attributeName + " changed the enum from " + oldEnumName + " to " + newEnumName +  " on " + attributeOperation.getEvoStep();
	}
	
	private String explain(DwEditorOperationEnumCreate enumOperation) {
		String enumName = enumOperation.getEnum().getName();
		String date = enumOperation.getEvoStep() == null ? "eternity" : enumOperation.getEvoStep().toString();
		return "Enum " + enumName + " was created on " + date;
	}
	
	private String explain(DwEditorOperationEnumDelete enumOperation) {
		String enumName = enumOperation.getEnum().getName();
		String date = enumOperation.getEvoStep() == null ? "eternity" : enumOperation.getEvoStep().toString();
		return "Enum " + enumName + " was deleted on " + date;
	}
	
	private String explain(DwEditorOperationEnumLiteralCreate enumOperation) {
		String enumName = enumOperation.getEnum().getName();
		String literalName = enumOperation.getLiteral().getName();
		String date = enumOperation.getEvoStep() == null ? "eternity" : enumOperation.getEvoStep().toString();
		return "EnumLiteral " + literalName + " was created for Enum " + enumName + " on " + date;
	}
	
	private String explain(DwEditorOperationEnumLiteralDelete enumOperation) {
		String enumName = enumOperation.getEnum().getName();
		String literalName = enumOperation.getLiteral().getName();
		String date = enumOperation.getEvoStep() == null ? "eternity" : enumOperation.getEvoStep().toString();
		return "EnumLiteral " + literalName + " of Enum " + enumName + " was deleted on " + date;
	}
	
	private String explain(DwEditorOperationConstraintCreate constraintOperation) {
		String date = constraintOperation.getEvoStep() == null ? "eternity" : constraintOperation.getEvoStep().toString();
		return "Constraint created on " + date;
	}
	
	private String explain(DwEditorOperationConstraintDelete constraintOperation) {
		String date = constraintOperation.getEvoStep() == null ? "eternity" : constraintOperation.getEvoStep().toString();
		return "Constraint deleted on " + date;
	}
	
	private String explain(DwEditorOperationContextCreate contextOperation) {
		String contextName = contextOperation.getContext().getName();
		String date = contextOperation.getEvoStep() == null ? "eternity" : contextOperation.getEvoStep().toString();
		return "Context " + contextName + " was created on " + date;
	}
	
	private String explain(DwEditorOperationContextDelete contextOperation) {
		String contextName = contextOperation.getContext().getName();
		String date = contextOperation.getEvoStep() == null ? "eternity" : contextOperation.getEvoStep().toString();
		return "Context " + contextName + " was deleted on " + date;
	}
	
	private String explain(DwEditorOperationValidityFormulaCreate validityFormulaOperation) {
		String date = validityFormulaOperation.getEvoStep() == null ? "eternity" : validityFormulaOperation.getEvoStep().toString();
		return "ValidityFormula created on " + date;
	}
	
	private String explain(DwEditorOperationValidityFormulaDelete validityFormulaOperation) {
		String date = validityFormulaOperation.getEvoStep() == null ? "eternity" : validityFormulaOperation.getEvoStep().toString();
		return "ValidityFormula deleted on " + date;
	}
	
	public DwEditorOperation getEditorOperation() {
		return editorOperation;
	}

}
