package de.darwinspl.reconfigurator.client.hyvarrec;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import de.darwinspl.anomalies.explanations.AnomalyConstraintExplanation;
import de.darwinspl.anomaly.DwAnomaly;
import de.darwinspl.anomaly.DwDeadFeatureAnomaly;
import de.darwinspl.anomaly.DwFalseOptionalFeatureAnomaly;
import de.darwinspl.anomaly.DwVoidFeatureModelAnomaly;
import de.darwinspl.anomaly.explanation.DwAnomalyExplanation;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperation;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationAttribute;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationAttributeRename;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationConstraint;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationConstraintCreate;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationConstraintDelete;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationContext;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationEnum;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationEnumLiteral;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationEnumLiteralCreate;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationFeature;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationFeatureGroup;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationFeatureRename;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationFeatureType;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationFeatureVersion;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationGroupType;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationValidityFormulaCreate;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationValidityFormulaDelete;
import de.darwinspl.feature.evolution.editoroperation.EditorOperationExplanation;
import de.darwinspl.feature.evolution.editoroperation.EditoroperationFactory;
import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.context.contextValidity.HyValidityFormula;
import eu.hyvar.context.contextValidity.HyValidityModel;
import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.evolution.HyName;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.constraint.HyConstraint;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.util.HyFeatureEvolutionUtil;

public class DwEditorOperationAnalyzer {
	
	private HyContextModel contextModel;
	private HyValidityModel contextValidityModel;
	private HyFeatureModel featureModel;
	private HyConstraintModel constraintModel;
	private Date date;
	
	List<DwEditorOperation> operationList;

	List<HyFeature> deadFeatureList = new ArrayList<HyFeature>();
	List<HyFeature> falseOptionalList = new ArrayList<HyFeature>();
	
	private DwAnalysesClient client;
	
	public DwEditorOperationAnalyzer(DwAnalysesClient client) {
		this.client = client;
	}
	
	public void constructEditorOperations() {
		operationList = new ArrayList<DwEditorOperation>();
		DwEditorOperation obj = null;
		if (getFeatureModel() != null) {
			
			for(HyFeature feature : getFeatureModel().getFeatures()) {
				// FEATURE CREATE
				obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationFeatureCreate();
				obj.setEvoStep(feature.getValidSince());
				((DwEditorOperationFeature) obj).setFeature(feature);
				operationList.add(obj);
				
				// FEATURE DELETE
				if (feature.getValidUntil() != null) {
					obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationFeatureDelete();
					obj.setEvoStep(feature.getValidUntil());
					((DwEditorOperationFeature) obj).setFeature(feature);
					operationList.add(obj);
				}
				
				// FEATURE NAME
				for (HyName name : feature.getNames()) {
					if (name.getValidSince() != null && !name.getValidSince().equals(feature.getValidSince())) { // don't interpret default as change
						HyName predecessor = HyEvolutionUtil.getValidTemporalElement(feature.getNames(), new Date(name.getValidSince().getTime() -1L));
						obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationFeatureRename();
						obj.setEvoStep(name.getValidSince());
						((DwEditorOperationFeature) obj).setFeature(feature);
						((DwEditorOperationFeatureRename) obj).setOldName(predecessor);
						((DwEditorOperationFeatureRename) obj).setNewName(name);
						operationList.add(obj);
					}
				}
				
				// FEATURE TYPE
				for (HyFeatureType type : feature.getTypes()) {
					if (type.getValidSince() != null && !type.getValidSince().equals(feature.getValidSince())) { // don't interpret default as change
						HyFeatureType predecessor = HyEvolutionUtil.getValidTemporalElement(feature.getTypes(), new Date(type.getValidSince().getTime() -1L));
						obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationFeatureType();
						obj.setEvoStep(type.getValidSince());
						((DwEditorOperationFeature) obj).setFeature(feature);
						((DwEditorOperationFeatureType) obj).setOldType(predecessor);
						((DwEditorOperationFeatureType) obj).setNewType(type);
						operationList.add(obj);
					}
				}
				
				for (HyVersion version : feature.getVersions()) {
					// FEATURE CREATE
					obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationFeatureVersionCreate();
					obj.setEvoStep(feature.getValidSince());
					((DwEditorOperationFeatureVersion) obj).setFeature(feature);
					((DwEditorOperationFeatureVersion) obj).setVersion(version);
					operationList.add(obj);

					// FEATURE CREATE
					if (version.getValidUntil() != null) {
						obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationFeatureVersionDelete();
						obj.setEvoStep(feature.getValidSince());
						((DwEditorOperationFeatureVersion) obj).setFeature(feature);
						((DwEditorOperationFeatureVersion) obj).setVersion(version);
						operationList.add(obj);
					}

					// TODO editorOperationFeatureVersionRename DOESNT EXIST
				}
				
				// FEATURE GROUP
				for (HyGroupComposition group : feature.getGroupMembership()) {
					if (group.getValidSince() != null && !group.getValidSince().equals(feature.getValidSince())) { // don't interpret default as change
						HyGroupComposition predecessor = HyEvolutionUtil.getValidTemporalElement(feature.getGroupMembership(), new Date(group.getValidSince().getTime() -1L));
						if (!group.getCompositionOf().equals(predecessor.getCompositionOf())) {
							// TODO: only recognize group changes or group composition changes too?
							obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationFeatureGroup();
							obj.setEvoStep(group.getValidSince());
							((DwEditorOperationFeature) obj).setFeature(feature);
							((DwEditorOperationFeatureGroup) obj).setOldGroup(predecessor);
							((DwEditorOperationFeatureGroup) obj).setNewGroup(group);
							operationList.add(obj);
						}
					}
				}
				
				
				for (HyFeatureAttribute attribute : feature.getAttributes()) {
					
					// ATTRIBUTE CREATE
					obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationAttributeCreate();
					obj.setEvoStep(attribute.getValidSince());
					((DwEditorOperationAttribute) obj).setAttribute(attribute);
					operationList.add(obj);

					// ATTRIBUTE DELETE
					if (attribute.getValidUntil() != null) {
						obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationAttributeDelete();
						obj.setEvoStep(attribute.getValidSince());
						((DwEditorOperationAttribute) obj).setAttribute(attribute);
						operationList.add(obj);
					}

					// ATTRIBUTE RENAME
					for (HyName name : attribute.getNames()) {
						if (name.getValidSince() != null && !name.getValidSince().equals(attribute.getValidSince())) { // don't interpret default as change
							HyName predecessor = HyEvolutionUtil.getValidTemporalElement(attribute.getNames(), new Date(name.getValidSince().getTime() -1L));
							obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationAttributeRename();
							obj.setEvoStep(name.getValidSince());
							((DwEditorOperationAttribute) obj).setAttribute(attribute);
							((DwEditorOperationAttributeRename) obj).setOldName(predecessor);
							((DwEditorOperationAttributeRename) obj).setNewName(name);
							operationList.add(obj);
						}
					}
					// TODO editorOperationAttributeEnum DOESNT EXIST
					// TODO editorOperationAttributeMinMax DOESNT EXIST
				}
			}
			
			for (HyGroup group : getFeatureModel().getGroups()) {		
				for (HyGroupType type : group.getTypes()) {
										
					// GROUP TYPE
					if (type.getValidSince() != null && !type.getValidSince().equals(group.getValidSince())) { // don't interpret default as change
						HyGroupType predecessor = HyEvolutionUtil.getValidTemporalElement(group.getTypes(), new Date(type.getValidSince().getTime() -1L));
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
		
		List<HyEnum> enumList = new ArrayList<HyEnum>();
		if (getContextModel() != null) {
			enumList.addAll(getContextModel().getEnums());
		}
		if (getFeatureModel() != null) {
			enumList.addAll(getFeatureModel().getEnums());
		}
		for (HyEnum hyEnum : enumList) {
			
			// ENUM CREATE
			obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationEnumCreate();
			obj.setEvoStep(hyEnum.getValidSince());
			((DwEditorOperationEnum) obj).setEnum(hyEnum);
			operationList.add(obj);
			
			// ENUM DELETE
			if (hyEnum.getValidUntil() != null) {
				// => create EditorOperationFeatureDelete
				obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationEnumDelete();
				obj.setEvoStep(hyEnum.getValidUntil());
				((DwEditorOperationEnum) obj).setEnum(hyEnum);
				operationList.add(obj);
			}
			// TODO editorOperationEnumRename DOESNT EXIST
						
			for (HyEnumLiteral literal : hyEnum.getLiterals()) {
				// ENUM LITERAL CREATE
				obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationEnumLiteralCreate();
				obj.setEvoStep(literal.getValidSince());
				((DwEditorOperationEnumLiteral) obj).setEnum(hyEnum);
				((DwEditorOperationEnumLiteral) obj).setLiteral(literal);
				operationList.add(obj);

				// ENUM LITERAL DELETE
				if (literal.getValidUntil() != null) {
					obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationEnumLiteralDelete();
					obj.setEvoStep(literal.getValidUntil());
					((DwEditorOperationEnumLiteral) obj).setEnum(hyEnum);
					((DwEditorOperationEnumLiteral) obj).setLiteral(literal);
					operationList.add(obj);
				}
				// TODO editorOperationEnumLiteralRename DOESNT EXIST
			}
		}

		if (getContextModel() != null) {
			for (HyContextualInformation context : getContextModel().getContextualInformations()) {
				
				// CONTEXT CREATE
				obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationContextCreate();
				obj.setEvoStep(context.getValidSince());
				((DwEditorOperationContext) obj).setContext(context);
				operationList.add(obj);

				// CONTEXT DELETE
				if (context.getValidUntil() != null) {
					obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationContextDelete();
					obj.setEvoStep(context.getValidUntil());
					((DwEditorOperationContext) obj).setContext(context);
					operationList.add(obj);
				}
			}
		}
		
		// TODO: incompatible validityFormula in metamodel -> !MESSAGE Both 'de.darwinspl.feature.evolution.editoroperation' and 'eu.hyvar.context.validity_formulas' register a package for 'http://hyvar-project.eu/context/validity/1.0'
		if (getContextValidityModel() != null) {
			for (HyValidityFormula validityFormula : getContextValidityModel().getValidityFormulas()) {
				
				// VALIDITY FORMULA CREATE
				obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationValidityFormulaCreate();
				obj.setEvoStep(validityFormula.getValidSince());
	//			((DwEditorOperationValidityFormula) obj).setValidityFormula(validityFormula);
				operationList.add(obj);

				// VALIDITY FORMULA DELETE
				if (validityFormula.getValidUntil() != null) {
					obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationValidityFormulaDelete();
					obj.setEvoStep(validityFormula.getValidUntil());
	//				((DwEditorOperationValidityFormula) obj).setValidityFormula(validityFormula);
					operationList.add(obj);
				}
			}
		}

		if (getConstraintModel() != null) {
			for (HyConstraint constraint : getConstraintModel().getConstraints()) {

				// CONSTRAINT CREATE
				obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationConstraintCreate();
				obj.setEvoStep(constraint.getValidSince());
				((DwEditorOperationConstraint) obj).setConstraint(constraint);
				operationList.add(obj);

				// CONSTRAINT DELETE
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

	public List<AnomalyConstraintExplanation> explainAnomaly(DwAnomalyExplanation anomalyExplanation) {		
		if (anomalyExplanation.getAnomaly() instanceof DwVoidFeatureModelAnomaly) {
			return explainVoidAnomaly(anomalyExplanation);
		} else if (anomalyExplanation.getAnomaly() instanceof DwDeadFeatureAnomaly){
			return explainDeadFeatureAnomaly(anomalyExplanation);
		} else if (anomalyExplanation.getAnomaly() instanceof DwFalseOptionalFeatureAnomaly) {
			return explainFalseOptionalFeatureAnomaly(anomalyExplanation);
		}
		return null;
	}
	
	public List<AnomalyConstraintExplanation> explainVoidAnomaly(DwAnomalyExplanation anomalyExplanation) {		
		List<AnomalyConstraintExplanation> constraintExplanationList = getRelatedEditorOperationsFromExplanation(anomalyExplanation);
		
		for (AnomalyConstraintExplanation explanation : constraintExplanationList) {
			filterRelevantVoidFeatureModelEditorOperation(explanation);
			
			// now we can properly explain it:
			String explanationString = explanation.explain();
			System.out.println(explanationString);
		}
		
		return constraintExplanationList;
	}

	public List<AnomalyConstraintExplanation> explainDeadFeatureAnomaly(DwAnomalyExplanation anomalyExplanation) {
		DwDeadFeatureAnomaly anomaly = (DwDeadFeatureAnomaly) anomalyExplanation.getAnomaly();
		Date date = anomaly.getValidSince();
		
		List<AnomalyConstraintExplanation> constraintExplanationList = new ArrayList<AnomalyConstraintExplanation>();
		
		HyFeature parent = HyFeatureEvolutionUtil.getParentFeatureOfFeature(anomaly.getFeature(), date);
		// Root's parent would be null
		if (parent != null) {
			
			// check whether the parent is already dead		
			if (deadFeatureList.contains(parent)) {
				// IGNORE as the parent is the one we have already handled or handle later
				String explanation = "This is a dead feature, because of its already-dead parent " + HyEvolutionUtil.getValidTemporalElement(parent.getNames(), date).getName() + "!";
				AnomalyConstraintExplanation simpleExplanation = new AnomalyConstraintExplanation();
				simpleExplanation.setDate(date);
				simpleExplanation.setStringReference(explanation);
				constraintExplanationList.add(simpleExplanation);
				return constraintExplanationList;
			}
			
			// check whether it's the result of the false-optional group
			HyGroup featureGroup = HyFeatureEvolutionUtil.getParentGroupOfFeature(anomaly.getFeature(), date);
			for (HyGroupType groupType : featureGroup.getTypes()) {
				// check whether this is the groupType of the anomaly
				if (!HyEvolutionUtil.isValid(groupType, date)) {
					continue;
				}
				
				if (groupType.getType() == HyGroupTypeEnum.ALTERNATIVE) {
					
					// iterate through the other alternate group members to check whether one is false optional
					
					HyGroupComposition groupComp = HyFeatureEvolutionUtil.getGroupComposition(featureGroup, date);
					for (HyFeature otherFeature : groupComp.getFeatures()) {
						if (falseOptionalList.contains(otherFeature)) {
							String explanation = "This is a dead feature, because it's in an ALTERNATIVE group with the false-optional feature " + HyEvolutionUtil.getValidTemporalElement(otherFeature.getNames(), date).getName();

							// now we know that this feature is only considered a dead-feature because of the false-optional feature
							// do we have an explanation here for the cause of _why_ it is false optional (which is the root of this)
							// or do we simply wait/forward to the false-optional explanation?							

							AnomalyConstraintExplanation simpleExplanation = new AnomalyConstraintExplanation();
							simpleExplanation.setDate(date);
							simpleExplanation.setStringReference(explanation);
							constraintExplanationList.add(simpleExplanation);
							return constraintExplanationList;
						}
					}
				}
			}
		}
		
		// if not: it is caused by a constraint.
		
		constraintExplanationList = getRelatedEditorOperationsFromExplanation(anomalyExplanation);
		
		for (AnomalyConstraintExplanation explanation : constraintExplanationList) {
			filterRelevantDeadFeatureEditorOperation(explanation);
			
			// now we can properly explain it:
			String explanationString = explanation.explain();
			System.out.println(explanationString);
		}
		
		return constraintExplanationList;
		
	}
	

	public List<AnomalyConstraintExplanation> explainFalseOptionalFeatureAnomaly(DwAnomalyExplanation anomalyExplanation) {		
		List<AnomalyConstraintExplanation> constraintExplanationList = getRelatedEditorOperationsFromExplanation(anomalyExplanation);
		
		for (AnomalyConstraintExplanation explanation : constraintExplanationList) {
			filterRelevantFalseOptionalFeatureEditorOperation(explanation);
			
			// now we can properly explain it:
			String explanationString = explanation.explain();
			System.out.println(explanationString);
		}
		
		return constraintExplanationList;
		
	}
	
	protected List<AnomalyConstraintExplanation> getRelatedEditorOperationsFromExplanation(DwAnomalyExplanation anomalyExplanation) {

		Map<String, EObject> translationMapping = client.exporter.getTranslationMapping();

		// use only those translationmappings that are actually explanations.
		translationMapping.keySet().retainAll(anomalyExplanation.getExplanations());
		

		List<AnomalyConstraintExplanation> list = new ArrayList<AnomalyConstraintExplanation>();
		
		for (String constraint : translationMapping.keySet()) {
			// resolve ids to names
			String constraintString = resolveFeatureNames(constraint, anomalyExplanation.getDate());
			
			AnomalyConstraintExplanation explanation = new AnomalyConstraintExplanation();
			explanation.setObjReference(translationMapping.get(constraint));
			explanation.setStringReference(constraintString);
			explanation.setDate(anomalyExplanation.getDate());
			for (DwEditorOperation operation : getEditorOperationListForObject(translationMapping.get(constraint), anomalyExplanation.getDate())) {
				EditorOperationExplanation opExplanation = new EditorOperationExplanation(operation);
				explanation.addEvolutionEditorOperations(opExplanation);
			}
			list.add(explanation);
		}
		return list;
	}
	
	public List<DwEditorOperation> getEditorOperationListForObject(EObject object, Date date) {
		List<DwEditorOperation> opsList = new ArrayList<DwEditorOperation>();
		
		HyFeature feature = null;
		if (object instanceof HyFeature) {
			feature = (HyFeature) object;
		}
		
		HyGroup group = null;
		if (object instanceof HyGroup) {
			group = (HyGroup) object;
			
			// check involved features
			HyGroupComposition groupComposition = HyEvolutionUtil.getValidTemporalElement(group.getParentOf(), date);
			for (HyFeature f : groupComposition.getFeatures()) {
				opsList.addAll(getEditorOperationListForObject(f, date));
			}
			
			// check parent
			HyFeatureChild featureChild = HyEvolutionUtil.getValidTemporalElement(group.getChildOf(), date);
			opsList.addAll(getEditorOperationListForObject(featureChild.getParent(), date));
		}
		
		HyConstraint constraint = null;
		if (object instanceof HyConstraint) {
			constraint = (HyConstraint) object;
			
			// TODO: get involved features + groups and out of it
			// Do i have to? because those features will be represented in other constraints as well, won't they?
		}
		
		HyValidityFormula validityFormula = null;
		if (object instanceof HyValidityFormula) {
			validityFormula = (HyValidityFormula) object;
			
			// TODO: get involved features + groups and out of it
			// Do i have to? because those features will be represented in other constraints as well, won't they?
		}
		
		for (DwEditorOperation operation : operationList) {
			if (operation.getEvoStep() == null || operation.getEvoStep().equals(date) || operation.getEvoStep().before(date)) {
				if (feature != null) {
					if (operation instanceof DwEditorOperationFeature) {
						DwEditorOperationFeature opFeature = (DwEditorOperationFeature) operation;
						if (opFeature.getFeature() == feature) {
							opsList.add(opFeature);
						}
					}
					else if (operation instanceof DwEditorOperationAttribute) {
						DwEditorOperationAttribute opAttribute = (DwEditorOperationAttribute) operation;
						if (opAttribute.getAttribute().getFeature().equals(feature)) {
							opsList.add(opAttribute);
						}
					}
				} else if (group != null) {
					if (operation instanceof DwEditorOperationGroupType) {
						DwEditorOperationGroupType opGroupType = (DwEditorOperationGroupType) operation;
						if (opGroupType.getGroup().equals(group)) {
							opsList.add(opGroupType);
						}
					} else if (operation instanceof DwEditorOperationFeatureGroup) {
						DwEditorOperationFeatureGroup opFeatureGroup = (DwEditorOperationFeatureGroup) operation;
						if (opFeatureGroup.getNewGroup().getCompositionOf().equals(group)) {
							opsList.add(opFeatureGroup);
						}
					}
				} else if (constraint != null) {
					if (operation instanceof DwEditorOperationConstraintCreate) {
						DwEditorOperationConstraintCreate opConstraintCreate = (DwEditorOperationConstraintCreate) operation;
						if (opConstraintCreate.getConstraint().equals(constraint)) {
							opsList.add(opConstraintCreate);
						}
					} else if (operation instanceof DwEditorOperationConstraintDelete) {
						DwEditorOperationConstraintDelete opConstraintDelete = (DwEditorOperationConstraintDelete) operation;
						if (opConstraintDelete.getConstraint().equals(constraint)) {
							opsList.add(opConstraintDelete);
						}
					}
				} else if (validityFormula != null) {
					if (operation instanceof DwEditorOperationValidityFormulaCreate) {
						DwEditorOperationValidityFormulaCreate opValidityFormulaCreate = (DwEditorOperationValidityFormulaCreate) operation;
						if (opValidityFormulaCreate.getValidityFormula().equals(validityFormula)) {
							opsList.add(opValidityFormulaCreate);
						}
					} else if (operation instanceof DwEditorOperationValidityFormulaDelete) {
						DwEditorOperationValidityFormulaDelete opValidityFormulaDelete = (DwEditorOperationValidityFormulaDelete) operation;
						if (opValidityFormulaDelete.getValidityFormula().equals(validityFormula)) {
							opsList.add(opValidityFormulaDelete);
						}
					}
				}
			}
		}
		
		return opsList;
	}
	
	
	public void filterRelevantDeadFeatureEditorOperation(AnomalyConstraintExplanation constraintExplanation) {
		List<EditorOperationExplanation> list = new ArrayList<EditorOperationExplanation>();
		
		for (EditorOperationExplanation opExplanation : constraintExplanation.getEvolutionEditorOperations()) {
			DwEditorOperation operation = opExplanation.getEditorOperation();
			if (operation instanceof DwEditorOperationFeatureType
					|| operation instanceof DwEditorOperationFeatureGroup
					|| operation instanceof DwEditorOperationGroupType
					|| operation instanceof DwEditorOperationConstraintCreate
					|| operation instanceof DwEditorOperationValidityFormulaCreate) {
				if (opExplanation.getEditorOperation().getEvoStep() != null
						&& opExplanation.getEditorOperation().getEvoStep().equals(constraintExplanation.getDate())) {
							constraintExplanation.addCausingEditorOperations(opExplanation);
							list.add(opExplanation);
					}
			}
		}
		constraintExplanation.getEvolutionEditorOperations().removeAll(list);
	}
	
	public void filterRelevantFalseOptionalFeatureEditorOperation(AnomalyConstraintExplanation constraintExplanation) {
		List<EditorOperationExplanation> list = new ArrayList<EditorOperationExplanation>();
		
		for (EditorOperationExplanation opExplanation : constraintExplanation.getEvolutionEditorOperations()) {
			DwEditorOperation operation = opExplanation.getEditorOperation();
			if (operation instanceof DwEditorOperationFeatureType
					|| operation instanceof DwEditorOperationFeatureGroup
					|| operation instanceof DwEditorOperationGroupType
					|| operation instanceof DwEditorOperationConstraintCreate
					|| operation instanceof DwEditorOperationValidityFormulaCreate) {
				if (opExplanation.getEditorOperation().getEvoStep() != null
					&& opExplanation.getEditorOperation().getEvoStep().equals(constraintExplanation.getDate())) {
						constraintExplanation.addCausingEditorOperations(opExplanation);
						list.add(opExplanation);
				}
			}
		}
		// Only keep relevant explanations
		constraintExplanation.getEvolutionEditorOperations().removeAll(list);
	}
	
	public void filterRelevantVoidFeatureModelEditorOperation(AnomalyConstraintExplanation constraintExplanation) {
		List<EditorOperationExplanation> list = new ArrayList<EditorOperationExplanation>();
		
		for (EditorOperationExplanation opExplanation : constraintExplanation.getEvolutionEditorOperations()) {
			DwEditorOperation operation = opExplanation.getEditorOperation();
			if (operation instanceof DwEditorOperationFeatureType
					|| operation instanceof DwEditorOperationFeatureGroup
					|| operation instanceof DwEditorOperationGroupType
					|| operation instanceof DwEditorOperationConstraintCreate
					|| operation instanceof DwEditorOperationValidityFormulaCreate
					|| operation instanceof DwEditorOperationEnumLiteralCreate) {
				constraintExplanation.addCausingEditorOperations(opExplanation);
				list.add(opExplanation);
			}
		}
		// Only keep relevant explanations
		constraintExplanation.getEvolutionEditorOperations().removeAll(list);
	}
	
	// ------------- UTIL -------------
	
	public String resolveFeatureNames(String encodedString, Date date) {
		List<String> list = new ArrayList<String>();
		list.add(encodedString);
		list = client.translateIdsBackToNames(list, date, client.exporter);
		return list.get(0);
	}
	
	protected List<HyFeature> getDeadFeatures(List<DwAnomaly> anomalies) {
		List<HyFeature> deadFeatures = new ArrayList<HyFeature>();
		for (DwAnomaly anomaly : anomalies) {
			if (anomaly instanceof DwDeadFeatureAnomaly) {
				deadFeatures.add(((DwDeadFeatureAnomaly) anomaly).getFeature());
			}
		}
		return deadFeatures;
	}
	
	protected List<HyFeature> getFalseOptionalFeatures(List<DwAnomaly> anomalies) {
		List<HyFeature> falseOptionalFeatures = new ArrayList<HyFeature>();
		for (DwAnomaly anomaly : anomalies) {
			if (anomaly instanceof DwFalseOptionalFeatureAnomaly) {
				falseOptionalFeatures.add(((DwFalseOptionalFeatureAnomaly) anomaly).getFeature());
			}
		}
		return falseOptionalFeatures;
	}
	
	
	// ------------ GET/SET ------------

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setFeatureAnomalies(List<DwAnomaly> anomalies){
		deadFeatureList = getDeadFeatures(anomalies);
		falseOptionalList = getFalseOptionalFeatures(anomalies);
	}

}
