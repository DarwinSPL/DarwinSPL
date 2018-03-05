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
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationAttributeCreate;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationAttributeDelete;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationAttributeMinMax;
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
import eu.hyvar.evolution.HyTemporalElement;
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
import eu.hyvar.feature.HyNumberAttribute;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.constraint.HyConstraint;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.util.HyFeatureEvolutionUtil;

public class DwEditorOperationAnalyzer {
	
	private HyContextModel contextModel;
	private HyValidityModel contextValidityModel;
	private HyFeatureModel featureModel;
	private HyConstraintModel constraintModel;
//	private HyContextValueModel contextValues;
	private Date date;
//	private Date evolutionContextValueDate;
	
	List<DwEditorOperation> operationList;

	List<HyFeature> deadFeatureList;
	List<HyFeature> falseOptionalList;
	
	private DwAnalysesClient client;
	
	public DwEditorOperationAnalyzer(DwAnalysesClient client) {
		this.client = client;
	}
	
	// TODO: attribute changes missing
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
						obj.setEvoStep(name.getValidSince());
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
						obj.setEvoStep(type.getValidSince());
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
						obj.setEvoStep(group.getValidSince());
						((DwEditorOperationFeature) obj).setFeature(feature);
						((DwEditorOperationFeatureGroup) obj).setOldGroup(predecessor);
						((DwEditorOperationFeatureGroup) obj).setNewGroup(group);
						operationList.add(obj);
					}
				}
				for (HyFeatureAttribute attribute : feature.getAttributes()) {

					obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationAttributeCreate();
					obj.setEvoStep(attribute.getValidSince());
					((DwEditorOperationAttributeCreate) obj).setAttribute(attribute);
					operationList.add(obj);
					
					if (attribute.getValidUntil() != null) {
						obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationAttributeDelete();
						obj.setEvoStep(attribute.getValidSince());
						((DwEditorOperationAttributeDelete) obj).setAttribute(attribute);
						operationList.add(obj);
					}

					for (HyName name : attribute.getNames()) {
						if (name.getValidSince() != attribute.getValidSince()) { // don't interpret default as change
							HyName predecessor = (HyName) name.getSupersededElement();
							obj = EditoroperationFactory.eINSTANCE.createDwEditorOperationAttributeRename();
							obj.setEvoStep(name.getValidSince());
							((DwEditorOperationAttribute) obj).setAttribute(attribute);
							((DwEditorOperationAttributeRename) obj).setOldName(predecessor);
							((DwEditorOperationAttributeRename) obj).setNewName(name);
							operationList.add(obj);
						}
					}
					
					if (attribute instanceof HyNumberAttribute) {
						HyNumberAttribute numberAttribute = (HyNumberAttribute) attribute;
						// TODO: can't detect min/max change.
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
		DwVoidFeatureModelAnomaly anomaly = (DwVoidFeatureModelAnomaly) anomalyExplanation.getAnomaly();
		Date date = anomaly.getValidSince();
		
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
				String explanation = "This is a dead feature, because of its already-dead parent " + HyFeatureEvolutionUtil.getName(parent.getNames(), date) + "!";
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
							String explanation = "This is a dead feature, because it's in an ALTERNATIVE group with the false-optional feature " + HyFeatureEvolutionUtil.getName(otherFeature.getNames(), date);

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
		DwFalseOptionalFeatureAnomaly anomaly = (DwFalseOptionalFeatureAnomaly) anomalyExplanation.getAnomaly();
		Date date = anomaly.getValidSince();
		
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
				explanation.getEditorOperationExplanations().add(opExplanation);
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
		}
		
		HyValidityFormula validityFormula = null;
		if (object instanceof HyValidityFormula) {
			validityFormula = (HyValidityFormula) object;
			
			// TODO: get involved features + groups and out of it
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
		
		for (EditorOperationExplanation opExplanation : constraintExplanation.getEditorOperationExplanations()) {
			DwEditorOperation operation = opExplanation.getEditorOperation();
			if (operation instanceof DwEditorOperationFeatureType
					|| operation instanceof DwEditorOperationFeatureGroup
					|| operation instanceof DwEditorOperationGroupType
					|| operation instanceof DwEditorOperationAttributeMinMax // TODO: cannot detect
					|| operation instanceof DwEditorOperationConstraintCreate
					|| operation instanceof DwEditorOperationValidityFormulaCreate) {
					list.add(opExplanation);
				}
		}
		// Only keep relevant explanations
		constraintExplanation.getEditorOperationExplanations().retainAll(list);
	}
	
	public void filterRelevantFalseOptionalFeatureEditorOperation(AnomalyConstraintExplanation constraintExplanation) {
		List<EditorOperationExplanation> list = new ArrayList<EditorOperationExplanation>();
		
		for (EditorOperationExplanation opExplanation : constraintExplanation.getEditorOperationExplanations()) {
			DwEditorOperation operation = opExplanation.getEditorOperation();
			if (operation instanceof DwEditorOperationFeatureType
					|| operation instanceof DwEditorOperationFeatureGroup
					|| operation instanceof DwEditorOperationGroupType
					|| operation instanceof DwEditorOperationAttributeMinMax // TODO: cannot detect
					|| operation instanceof DwEditorOperationConstraintCreate
					|| operation instanceof DwEditorOperationValidityFormulaCreate) {
					list.add(opExplanation);
				}
		}
		// Only keep relevant explanations
		constraintExplanation.getEditorOperationExplanations().retainAll(list);
	}
	
	public void filterRelevantVoidFeatureModelEditorOperation(AnomalyConstraintExplanation constraintExplanation) {
		List<EditorOperationExplanation> list = new ArrayList<EditorOperationExplanation>();
		
		for (EditorOperationExplanation opExplanation : constraintExplanation.getEditorOperationExplanations()) {
			DwEditorOperation operation = opExplanation.getEditorOperation();
			if (operation instanceof DwEditorOperationFeatureType
					|| operation instanceof DwEditorOperationFeatureGroup
					|| operation instanceof DwEditorOperationGroupType
					|| operation instanceof DwEditorOperationConstraintCreate
					|| operation instanceof DwEditorOperationValidityFormulaCreate
					|| operation instanceof DwEditorOperationEnumLiteralCreate) {
					list.add(opExplanation);
				}
		}
		// Only keep relevant explanations
		constraintExplanation.getEditorOperationExplanations().retainAll(list);
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

//	public HyContextValueModel getContextValues() {
//		return contextValues;
//	}
//
//	public void setContextValues(HyContextValueModel contextValues) {
//		this.contextValues = contextValues;
//	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

//	public Date getEvolutionContextValueDate() {
//		return evolutionContextValueDate;
//	}
//
//	public void setEvolutionContextValueDate(Date evolutionContextValueDate) {
//		this.evolutionContextValueDate = evolutionContextValueDate;
//	}
	
	public void setFeatureAnomalies(List<DwAnomaly> anomalies){
		deadFeatureList = getDeadFeatures(anomalies);
		falseOptionalList = getFalseOptionalFeatures(anomalies);
	}

}
