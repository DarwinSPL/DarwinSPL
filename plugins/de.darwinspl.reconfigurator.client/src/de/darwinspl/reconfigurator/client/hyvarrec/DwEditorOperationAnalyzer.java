package de.darwinspl.reconfigurator.client.hyvarrec;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.darwinspl.anomaly.DwAnomaly;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperation;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationConstraint;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationContext;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationEnum;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationEnumLiteral;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationFeature;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationFeatureGroup;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationFeatureRename;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationFeatureType;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationGroupType;
import de.darwinspl.feature.evolution.editoroperation.EditoroperationFactory;
import de.darwinspl.reconfigurator.client.hyvarrec.format.HyVarRecExplainAnswer;
import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.context.contextValidity.HyValidityFormula;
import eu.hyvar.context.contextValidity.HyValidityModel;
import eu.hyvar.context.information.contextValue.HyContextValueModel;
import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.constraint.HyConstraint;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.reconfigurator.input.exporter.HyVarRecExporter;

public class DwEditorOperationAnalyzer {
	
	private HyContextModel contextModel;
	private HyValidityModel contextValidityModel;
	private HyFeatureModel featureModel;
	private HyConstraintModel constraintModel;
	private HyContextValueModel contextValues;
	private Date date;
	private Date evolutionContextValueDate;
	
	List<DwEditorOperation> operationList;
	
	private DwAnalysesClient client;
	
	public DwEditorOperationAnalyzer(DwAnalysesClient client) {
		this.client = client;
	}
	
	public void constructEditorOperations() {
		operationList = new ArrayList<DwEditorOperation>();
		DwEditorOperation obj = null;
		if (getFeatureModel() != null) {
			for(HyFeature feature : getFeatureModel().getFeatures()) {
				// => create EditorOperationFeatureCreate
				obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationFeatureCreate();
				obj.setEvoStep(feature.getValidSince());
				((DwEditorOperationFeature) obj).setFeature(feature);
				operationList.add(obj);
				
				if (feature.getValidUntil() != null) {
					// => create EditorOperationFeatureDelete
					obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationFeatureDelete();
					obj.setEvoStep(feature.getValidUntil());
					((DwEditorOperationFeature) obj).setFeature(feature);
					operationList.add(obj);
				}
				
				for (HyName name : feature.getNames()) {
					if (name.getValidSince() != feature.getValidSince()) { // don't interpret default as change
						// => create EditorOperationFeatureRename
						HyName predecessor = (HyName) name.getSupersededElement();
						obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationFeatureRename();
						obj.setEvoStep(feature.getValidSince());
						((DwEditorOperationFeature) obj).setFeature(feature);
						((DwEditorOperationFeatureRename) obj).setOldName(predecessor);
						((DwEditorOperationFeatureRename) obj).setNewName(name);
						operationList.add(obj);
					}
				}
				
				for (HyFeatureType type : feature.getTypes()) {
					if (type.getValidSince() != feature.getValidSince()) { // don't interpret default as change
						HyFeatureType predecessor = (HyFeatureType) type.getSupersededElement();
						// => create EditorOperationFeatureType
						obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationFeatureType();
						obj.setEvoStep(feature.getValidSince());
						((DwEditorOperationFeature) obj).setFeature(feature);
						((DwEditorOperationFeatureType) obj).setOldType(predecessor);
						((DwEditorOperationFeatureType) obj).setNewType(type);
						operationList.add(obj);
					}
				}
				
				for (HyVersion version : feature.getVersions()) {
					// => create editorOperationFeatureVersionCreate
					// => create editorOperationFeatureVersionDelete
					// => create editorOperationFeatureVersionRename
				}
				
				for (HyGroupComposition group : feature.getGroupMembership()) {
					if (group.getValidSince() != feature.getValidSince()) { // don't interpret default as change
						HyGroupComposition predecessor = (HyGroupComposition) group.getSupersededElement();
						// => create editorOperationFeatureGroup
						obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationFeatureGroup();
						obj.setEvoStep(feature.getValidSince());
						((DwEditorOperationFeature) obj).setFeature(feature);
						((DwEditorOperationFeatureGroup) obj).setOldGroup(predecessor);
						((DwEditorOperationFeatureGroup) obj).setNewGroup(group);
						operationList.add(obj);
					}
				}
			}
			
			// lookup group type changes
			for (HyGroup group : getFeatureModel().getGroups()) {				
				for (HyGroupType type : group.getTypes()) {
					if (type.getValidSince() != group.getValidSince()) { // don't interpret default as change
						HyGroupType predecessor = (HyGroupType) type.getSupersededElement();
						// => create editorOperationGroup type change
						obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationGroupType();
						obj.setEvoStep(type.getValidSince());
						((DwEditorOperationGroupType) obj).setGroup(group);
						((DwEditorOperationGroupType) obj).setOldType(predecessor);
						((DwEditorOperationGroupType) obj).setNewType(type);
						operationList.add(obj);
					}
				}
			}
		}
		
		// TODO: cannot detect name changes for enums
		List<HyEnum> enumList = new ArrayList<HyEnum>();
		if (getContextModel() != null) {
			enumList.addAll(getContextModel().getEnums());
		}
		if (getFeatureModel() != null) {
			enumList.addAll(getFeatureModel().getEnums());
		}
		for (HyEnum hyEnum : enumList) {
			obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationEnumCreate();
			obj.setEvoStep(hyEnum.getValidSince());
			((DwEditorOperationEnum) obj).setEnum(hyEnum);
			operationList.add(obj);
			
			if (hyEnum.getValidUntil() != null) {
				// => create EditorOperationFeatureDelete
				obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationEnumDelete();
				obj.setEvoStep(hyEnum.getValidUntil());
				((DwEditorOperationEnum) obj).setEnum(hyEnum);
				operationList.add(obj);
			}
						
			for (HyEnumLiteral literal : hyEnum.getLiterals()) {
				obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationEnumLiteralCreate();
				obj.setEvoStep(literal.getValidSince());
				((DwEditorOperationEnumLiteral) obj).setEnum(hyEnum);
				((DwEditorOperationEnumLiteral) obj).setLiteral(literal);
				operationList.add(obj);
				
				if (literal.getValidUntil() != null) {
					// => create EditorOperationFeatureDelete
					obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationEnumLiteralDelete();
					obj.setEvoStep(literal.getValidUntil());
					((DwEditorOperationEnumLiteral) obj).setEnum(hyEnum);
					((DwEditorOperationEnumLiteral) obj).setLiteral(literal);
					operationList.add(obj);
				}
			}
		}

		if (getContextModel() != null) {
			for (HyContextualInformation context : getContextModel().getContextualInformations()) {
				// => create editorOperationContextCreate
				obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationContextCreate();
				obj.setEvoStep(context.getValidSince());
				((DwEditorOperationContext) obj).setContext(context);
				operationList.add(obj);
				
				if (context.getValidUntil() != null) {
					// => create editorOperationContextDelete
					obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationContextDelete();
					obj.setEvoStep(context.getValidUntil());
					((DwEditorOperationContext) obj).setContext(context);
					operationList.add(obj);
				}
			}
		}
		
		// TODO: incompatible validityFormula in metamodel
		if (getContextValidityModel() != null) {
			for (HyValidityFormula validityFormula : getContextValidityModel().getValidityFormulas()) {
				// => create editorOperationValidityFormulaCreate
				obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationValidityFormulaCreate();
				obj.setEvoStep(validityFormula.getValidSince());
	//			((DwEditorOperationValidityFormula) obj).setValidityFormula(validityFormula);
				operationList.add(obj);
				
				if (validityFormula.getValidUntil() != null) {
					// => create editorOperationValidityFormulaDelete
					obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationValidityFormulaDelete();
					obj.setEvoStep(validityFormula.getValidUntil());
	//				((DwEditorOperationValidityFormula) obj).setValidityFormula(validityFormula);
					operationList.add(obj);
				}
			}
		}

		if (getConstraintModel() != null) {
			for (HyConstraint constraint : getConstraintModel().getConstraints()) {
				// => create editorOperationConstraintCreate
				obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationConstraintCreate();
				obj.setEvoStep(constraint.getValidSince());
				((DwEditorOperationConstraint) obj).setConstraint(constraint);
				operationList.add(obj);
				
				if (constraint.getValidUntil() != null) {
					// => create editorOperationConstraintDelete
					obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationConstraintDelete();
					obj.setEvoStep(constraint.getValidUntil());
					((DwEditorOperationConstraint) obj).setConstraint(constraint);
					operationList.add(obj);
				}
			}
		}
	}
	
	public List<String> processVoidAnomaly(HyVarRecExplainAnswer hyVarRecAnswer, HyVarRecExporter exporter) {
		// TODO
		
		// Possible ideas:
		// 1. - do something like DwEditorOperation.getConstraint() with the affected constraints it might result in
		//    - check whether such constraint occurs in the answer
		//    - check whether certain conditions are fulfilled for a given anomaly
		
		// 2. - 
		return client.translateIdsBackToNames(hyVarRecAnswer.getConstraints(), date, exporter);
	}
	
	public void processFeatureAnomaly(List<DwAnomaly> anomalies) {
		// TODO
		
		
	}
	

	public HyContextModel getContextModel() {
		return contextModel;
	}

	public void setContextModel(HyContextModel contextModel) {
		this.contextModel = contextModel;
	}

	public HyValidityModel getContextValidityModel() {
		return contextValidityModel;
	}

	public void setContextValidityModel(HyValidityModel contextValidityModel) {
		this.contextValidityModel = contextValidityModel;
	}

	public HyFeatureModel getFeatureModel() {
		return featureModel;
	}

	public void setFeatureModel(HyFeatureModel featureModel) {
		this.featureModel = featureModel;
	}

	public HyConstraintModel getConstraintModel() {
		return constraintModel;
	}

	public void setConstraintModel(HyConstraintModel constraintModel) {
		this.constraintModel = constraintModel;
	}

	public HyContextValueModel getContextValues() {
		return contextValues;
	}

	public void setContextValues(HyContextValueModel contextValues) {
		this.contextValues = contextValues;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getEvolutionContextValueDate() {
		return evolutionContextValueDate;
	}

	public void setEvolutionContextValueDate(Date evolutionContextValueDate) {
		this.evolutionContextValueDate = evolutionContextValueDate;
	}

}
