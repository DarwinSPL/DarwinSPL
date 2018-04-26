package de.darwinspl.feature.evolution.evolutionoperation;

import java.util.Date;

import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperation;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationAttributeCreate;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationAttributeDelete;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationAttributeRename;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationConstraintCreate;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationConstraintDelete;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationContextCreate;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationContextDelete;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumCreate;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumDelete;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumLiteralCreate;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumLiteralDelete;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureCreate;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureDelete;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureGroup;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureRename;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureType;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureVersionCreate;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureVersionDelete;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupType;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationValidityFormulaCreate;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationValidityFormulaDelete;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureChild;

/**
 * 
 * @author Felix Franzke
 */
public class EvolutionOperationExplanation {
	
	private DwEvolutionOperation evolutionOperation;
	
	public EvolutionOperationExplanation(DwEvolutionOperation evolutionOperation) {
		this.evolutionOperation = evolutionOperation;
	}
	
	public String explain() {
		if (evolutionOperation instanceof DwEvolutionOperationFeatureCreate) {
			DwEvolutionOperationFeatureCreate featureOperation = (DwEvolutionOperationFeatureCreate) evolutionOperation;
			return explain(featureOperation);
		}
		else if (evolutionOperation instanceof DwEvolutionOperationFeatureDelete) {
			DwEvolutionOperationFeatureDelete featureOperation = (DwEvolutionOperationFeatureDelete) evolutionOperation;
			return explain(featureOperation);
		}
		else if (evolutionOperation instanceof DwEvolutionOperationFeatureRename) {
			DwEvolutionOperationFeatureRename featureOperation = (DwEvolutionOperationFeatureRename) evolutionOperation;
			return explain(featureOperation);
		}
		else if (evolutionOperation instanceof DwEvolutionOperationFeatureType) {
			DwEvolutionOperationFeatureType featureType = (DwEvolutionOperationFeatureType) evolutionOperation;
			return explain(featureType);
		}
		else if (evolutionOperation instanceof DwEvolutionOperationFeatureGroup) {
			DwEvolutionOperationFeatureGroup featureGroup = (DwEvolutionOperationFeatureGroup) evolutionOperation;
			return explain(featureGroup);
		}
		else if (evolutionOperation instanceof DwEvolutionOperationFeatureVersionCreate) {
			DwEvolutionOperationFeatureVersionCreate featureOperation = (DwEvolutionOperationFeatureVersionCreate) evolutionOperation;
			return explain(featureOperation);
		}
		else if (evolutionOperation instanceof DwEvolutionOperationFeatureVersionDelete) {
			DwEvolutionOperationFeatureVersionDelete featureOperation = (DwEvolutionOperationFeatureVersionDelete) evolutionOperation;
			return explain(featureOperation);
		}
		else if (evolutionOperation instanceof DwEvolutionOperationGroupType) {
			DwEvolutionOperationGroupType groupType = (DwEvolutionOperationGroupType) evolutionOperation;
			return explain(groupType);
		}
		else if (evolutionOperation instanceof DwEvolutionOperationAttributeCreate) {
			DwEvolutionOperationAttributeCreate attributeOperation = (DwEvolutionOperationAttributeCreate) evolutionOperation;
			return explain(attributeOperation);
		}
		else if (evolutionOperation instanceof DwEvolutionOperationAttributeDelete) {
			DwEvolutionOperationAttributeDelete attributeOperation = (DwEvolutionOperationAttributeDelete) evolutionOperation;
			return explain(attributeOperation);
		}
		else if (evolutionOperation instanceof DwEvolutionOperationAttributeRename) {
			DwEvolutionOperationAttributeRename attributeOperation = (DwEvolutionOperationAttributeRename) evolutionOperation;
			return explain(attributeOperation);
		}
		else if (evolutionOperation instanceof DwEvolutionOperationEnumCreate) {
			DwEvolutionOperationEnumCreate enumOperation = (DwEvolutionOperationEnumCreate) evolutionOperation;
			return explain(enumOperation);
		}
		else if (evolutionOperation instanceof DwEvolutionOperationEnumDelete) {
			DwEvolutionOperationEnumDelete enumOperation = (DwEvolutionOperationEnumDelete) evolutionOperation;
			return explain(enumOperation);
		}
		else if (evolutionOperation instanceof DwEvolutionOperationEnumLiteralCreate) {
			DwEvolutionOperationEnumLiteralCreate enumOperation = (DwEvolutionOperationEnumLiteralCreate) evolutionOperation;
			return explain(enumOperation);
		}
		else if (evolutionOperation instanceof DwEvolutionOperationEnumLiteralDelete) {
			DwEvolutionOperationEnumLiteralDelete enumOperation = (DwEvolutionOperationEnumLiteralDelete) evolutionOperation;
			return explain(enumOperation);
		}
		else if (evolutionOperation instanceof DwEvolutionOperationConstraintCreate) {
			DwEvolutionOperationConstraintCreate constraint = (DwEvolutionOperationConstraintCreate) evolutionOperation;
			return explain(constraint);
		}
		else if (evolutionOperation instanceof DwEvolutionOperationConstraintDelete) {
			DwEvolutionOperationConstraintDelete constraint = (DwEvolutionOperationConstraintDelete) evolutionOperation;
			return explain(constraint);
		}
		else if (evolutionOperation instanceof DwEvolutionOperationContextCreate) {
			DwEvolutionOperationContextCreate context = (DwEvolutionOperationContextCreate) evolutionOperation;
			return explain(context);
		}
		else if (evolutionOperation instanceof DwEvolutionOperationContextDelete) {
			DwEvolutionOperationContextDelete context = (DwEvolutionOperationContextDelete) evolutionOperation;
			return explain(context);
		}
		else if (evolutionOperation instanceof DwEvolutionOperationValidityFormulaCreate) {
			DwEvolutionOperationValidityFormulaCreate validityFormula = (DwEvolutionOperationValidityFormulaCreate) evolutionOperation;
			return explain(validityFormula);
		}
		else if (evolutionOperation instanceof DwEvolutionOperationValidityFormulaDelete) {
			DwEvolutionOperationValidityFormulaDelete validityFormula = (DwEvolutionOperationValidityFormulaDelete) evolutionOperation;
			return explain(validityFormula);
		}
		return null;
	}

	private String explain(DwEvolutionOperationFeatureCreate featureOperation) {
		String featureName = HyEvolutionUtil.getValidTemporalElement(featureOperation.getFeature().getNames(), featureOperation.getEvoStep()).getName();
		String date = featureOperation.getEvoStep() == null ? "eternity" : featureOperation.getEvoStep().toString();
		return "Feature " + featureName + " was created on " + date;
	}

	private String explain(DwEvolutionOperationFeatureDelete featureOperation) {
		String featureName = HyEvolutionUtil.getValidTemporalElement(featureOperation.getFeature().getNames(), featureOperation.getEvoStep()).getName();
		return "Feature " + featureName + " was deleted on " + featureOperation.getEvoStep().toString();
	}

	private String explain(DwEvolutionOperationFeatureRename featureOperation) {
		String oldName = featureOperation.getOldName().getName();
		String newName = featureOperation.getNewName().getName();
		return "Feature " + oldName + " was renamed to " +  newName + " on " + featureOperation.getEvoStep();
	}

	private String explain(DwEvolutionOperationFeatureType featureTypeOperation) {
		String featureName = HyEvolutionUtil.getValidTemporalElement(featureTypeOperation.getFeature().getNames(), featureTypeOperation.getEvoStep()).getName();
		String oldName = featureTypeOperation.getOldType().getType().getName();
		String newName = featureTypeOperation.getNewType().getType().getName();
		return "FeatureType of " + featureName + " changed from " + oldName +  " to " + newName + " on " + featureTypeOperation.getEvoStep();
	}
	
	private String explain(DwEvolutionOperationFeatureGroup featureGroupOperation) {
		String featureName = HyEvolutionUtil.getValidTemporalElement(featureGroupOperation.getFeature().getNames(), featureGroupOperation.getEvoStep()).getName();
		HyFeatureChild oldParentFeatureChild = HyEvolutionUtil.getValidTemporalElement(featureGroupOperation.getOldGroup().getCompositionOf().getChildOf(), new Date(featureGroupOperation.getEvoStep().getTime() -1L));
		String oldParentFeatureName = HyEvolutionUtil.getValidTemporalElement(oldParentFeatureChild.getParent().getNames(), new Date(featureGroupOperation.getEvoStep().getTime() -1L)).getName();
		HyFeatureChild newParentFeatureChild = HyEvolutionUtil.getValidTemporalElement(featureGroupOperation.getNewGroup().getCompositionOf().getChildOf(), featureGroupOperation.getEvoStep());
		String newParentFeatureName = HyEvolutionUtil.getValidTemporalElement(newParentFeatureChild.getParent().getNames(), featureGroupOperation.getEvoStep()).getName();
		return "Feature " + featureName + " moved from parent " + oldParentFeatureName + " to " + newParentFeatureName + " on " + featureGroupOperation.getEvoStep();
	}

	private String explain(DwEvolutionOperationFeatureVersionCreate featureOperation) {
		String featureName = HyEvolutionUtil.getValidTemporalElement(featureOperation.getFeature().getNames(), featureOperation.getEvoStep()).getName();
		String versionNumber = featureOperation.getVersion().getNumber();
		String date = featureOperation.getEvoStep() == null ? "eternity" : featureOperation.getEvoStep().toString();
		return "Version " + versionNumber + " of " + featureName + " was created on " + date;
	}

	private String explain(DwEvolutionOperationFeatureVersionDelete featureOperation) {
		String featureName = HyEvolutionUtil.getValidTemporalElement(featureOperation.getFeature().getNames(), featureOperation.getEvoStep()).getName();
		String versionNumber = featureOperation.getVersion().getNumber();
		return "Version " + versionNumber + " of " + featureName + " was deleted on " + featureOperation.getEvoStep();
	}
	
	private String explain(DwEvolutionOperationGroupType groupTypeOperation) {
		HyFeatureChild groupChild = HyEvolutionUtil.getValidTemporalElement(groupTypeOperation.getGroup().getChildOf(), groupTypeOperation.getEvoStep());
		String parentFeatureName = HyEvolutionUtil.getValidTemporalElement(groupChild.getParent().getNames(), groupTypeOperation.getEvoStep()).getName();
		String oldGroupType = groupTypeOperation.getOldType().getType().getName();
		String newGroupType = groupTypeOperation.getNewType().getType().getName();
		return "GroupType beneath parent " + parentFeatureName + " changed from " + oldGroupType + " to " + newGroupType + " on " + groupTypeOperation.getEvoStep();
	}
	
	private String explain(DwEvolutionOperationAttributeCreate attributeOperation) {
		String attributeName = HyEvolutionUtil.getValidTemporalElement(attributeOperation.getAttribute().getNames(), attributeOperation.getEvoStep()).getName();
		String date = attributeOperation.getEvoStep() == null ? "eternity" : attributeOperation.getEvoStep().toString();
		return "Attribute " + attributeName + " was created on " + date;
	}
	
	private String explain(DwEvolutionOperationAttributeDelete attributeOperation) {
		String attributeName = HyEvolutionUtil.getValidTemporalElement(attributeOperation.getAttribute().getNames(), attributeOperation.getEvoStep()).getName();
		return "Attribute " + attributeName + " was deleted on " + attributeOperation.getEvoStep();
	}
	
	private String explain(DwEvolutionOperationAttributeRename attributeOperation) {
		String oldName = attributeOperation.getOldName().getName();
		String newName = attributeOperation.getNewName().getName();
		return "Attribute " + oldName + " renamed to " + newName + " on " + attributeOperation.getEvoStep();
	}
	
	private String explain(DwEvolutionOperationEnumCreate enumOperation) {
		String enumName = enumOperation.getEnum().getName();
		String date = enumOperation.getEvoStep() == null ? "eternity" : enumOperation.getEvoStep().toString();
		return "Enum " + enumName + " was created on " + date;
	}
	
	private String explain(DwEvolutionOperationEnumDelete enumOperation) {
		String enumName = enumOperation.getEnum().getName();
		String date = enumOperation.getEvoStep() == null ? "eternity" : enumOperation.getEvoStep().toString();
		return "Enum " + enumName + " was deleted on " + date;
	}
	
	private String explain(DwEvolutionOperationEnumLiteralCreate enumOperation) {
		String enumName = enumOperation.getEnum().getName();
		String literalName = enumOperation.getLiteral().getName();
		String date = enumOperation.getEvoStep() == null ? "eternity" : enumOperation.getEvoStep().toString();
		return "EnumLiteral " + literalName + " was created for Enum " + enumName + " on " + date;
	}
	
	private String explain(DwEvolutionOperationEnumLiteralDelete enumOperation) {
		String enumName = enumOperation.getEnum().getName();
		String literalName = enumOperation.getLiteral().getName();
		String date = enumOperation.getEvoStep() == null ? "eternity" : enumOperation.getEvoStep().toString();
		return "EnumLiteral " + literalName + " of Enum " + enumName + " was deleted on " + date;
	}
	
	private String explain(DwEvolutionOperationConstraintCreate constraintOperation) {
		String date = constraintOperation.getEvoStep() == null ? "eternity" : constraintOperation.getEvoStep().toString();
		return "Constraint created on " + date;
	}
	
	private String explain(DwEvolutionOperationConstraintDelete constraintOperation) {
		String date = constraintOperation.getEvoStep() == null ? "eternity" : constraintOperation.getEvoStep().toString();
		return "Constraint deleted on " + date;
	}
	
	private String explain(DwEvolutionOperationContextCreate contextOperation) {
		String contextName = contextOperation.getContext().getName();
		String date = contextOperation.getEvoStep() == null ? "eternity" : contextOperation.getEvoStep().toString();
		return "Context " + contextName + " was created on " + date;
	}
	
	private String explain(DwEvolutionOperationContextDelete contextOperation) {
		String contextName = contextOperation.getContext().getName();
		String date = contextOperation.getEvoStep() == null ? "eternity" : contextOperation.getEvoStep().toString();
		return "Context " + contextName + " was deleted on " + date;
	}
	
	private String explain(DwEvolutionOperationValidityFormulaCreate validityFormulaOperation) {
		String date = validityFormulaOperation.getEvoStep() == null ? "eternity" : validityFormulaOperation.getEvoStep().toString();
		return "ValidityFormula created on " + date;
	}
	
	private String explain(DwEvolutionOperationValidityFormulaDelete validityFormulaOperation) {
		String date = validityFormulaOperation.getEvoStep() == null ? "eternity" : validityFormulaOperation.getEvoStep().toString();
		return "ValidityFormula deleted on " + date;
	}
	
	public DwEvolutionOperation getEvolutionOperation() {
		return evolutionOperation;
	}

}
