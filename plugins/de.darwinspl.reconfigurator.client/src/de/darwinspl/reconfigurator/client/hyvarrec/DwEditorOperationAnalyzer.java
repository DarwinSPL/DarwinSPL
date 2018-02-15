package de.darwinspl.reconfigurator.client.hyvarrec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

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
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationFeature;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationFeatureGroup;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationFeatureRename;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationFeatureType;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationGroupType;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationValidityFormulaCreate;
import de.darwinspl.feature.evolution.editoroperation.DwEditorOperationValidityFormulaDelete;
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
import eu.hyvar.feature.HyRootFeature;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.constraint.HyConstraint;
import eu.hyvar.feature.constraint.HyConstraintModel;

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

	// TODO
	public void explainAnomaly(DwAnomalyExplanation anomalyExplanation) {		
		if (anomalyExplanation.getAnomaly() instanceof DwVoidFeatureModelAnomaly) {
//			DwVoidFeatureModelAnomaly voidFeatureAnomaly = (DwVoidFeatureModelAnomaly) anomaly;
		} else if (anomalyExplanation.getAnomaly() instanceof DwDeadFeatureAnomaly){
			explainDeadFeatureAnomaly(anomalyExplanation);
		} else if (anomalyExplanation.getAnomaly() instanceof DwFalseOptionalFeatureAnomaly) {
//			DwFalseOptionalFeatureAnomaly falseOptionalFeatureAnomaly = (DwFalseOptionalFeatureAnomaly) anomaly;
		}
		
	}
	
	public void explainVoidAnomaly(DwAnomalyExplanation anomalyExplanation) {
		// TODO
		
		// Possible ideas:
		// 1. - do something like DwEditorOperation.getConstraint() with the affected constraints it might result in
		//    - check whether such constraint occurs in the answer
		//    - check whether certain conditions are fulfilled for a given anomaly
		
	}

	public void explainDeadFeatureAnomaly(DwAnomalyExplanation anomalyExplanation) {
		DwDeadFeatureAnomaly anomaly = (DwDeadFeatureAnomaly) anomalyExplanation.getAnomaly();
		Date date = anomaly.getValidSince();
		HyFeature parent = getFeatureParent(anomaly.getFeature(), date);
		// Root's parent would be null
		if (parent != null) {
			
			// check whether the parent is already dead		
			if (deadFeatureList.contains(parent)) {
				// IGNORE as the parent is the one we have already handled or handle later
				System.out.println("Feature " + anomaly.getFeature().getId() + " is a dead feature, because of its already-dead parent!");
				return;
			}
			
			// check whether it's the result of the false-optional group
			HyGroup featureGroup = getFeatureGroup(anomaly.getFeature(), date);
			for (HyGroupType groupType : featureGroup.getTypes()) {
				// check whether this is the groupType of the anomaly
				if (!isElementValid(groupType, date)) {
					continue;
				}
				
				if (groupType.getType() == HyGroupTypeEnum.ALTERNATIVE) {
					
					// iterate through the other alternate group members to check whether one is false optional
					
					HyGroupComposition groupComp = getFeatureGroupComposition(featureGroup, date);
					for (HyFeature otherFeature : groupComp.getFeatures()) {
						if (falseOptionalList.contains(otherFeature)) {
							System.out.println("Feature " + anomaly.getFeature().getId() + " is a dead feature, because it's in an ALTERNATIVE group with the false-optional feature " + otherFeature.getId());

							// now we know that this feature is only considered a dead-feature because of the false-optional feature
							// do we have an explanation here for the cause of _why_ it is false optional (which is the root of this)
							// or do we simply wait/forward to the false-optional explanation?
							
							return;
						}
					}
				}
			}
		}
		
		// if not: it is caused by a constraint.
		
		Set<DwEditorOperation> opList = getRelatedEditorOperationsFromExplanation(anomalyExplanation);
		evaluateDeadFeatureEditorOperations(opList);
		
	}
	
	// TODO: use Map<DwEditorOperation, EObject> for connection???
	protected Set<DwEditorOperation> getRelatedEditorOperationsFromExplanation(DwAnomalyExplanation anomalyExplanation) {

		System.out.println(">TRANSLATION MAPPING:");
		System.out.println(Arrays.toString(client.exporter.getTranslationMapping().entrySet().toArray()));
		
		
		/*
		 * Possible EObjects in translationMapping:
		 * feature: mandatory (aka parent=1 -> feature=1) // special case???
		 * constraint: constraint
		 * group: grouptype condition (parent=1 -> f1 alt/and/or f2 ... = 1)
		 * validityformula: validityformula
		 * groupcomposition: parent connection (f1 or f2 ... -> parent)
		 * rootfeature: rootfeature = 1
		 * 
		 * what's missing: contradicting translation of "anomalyfeature = 1"
		 * 
		 */
		Map<EObject, String> translationMapping = client.exporter.getTranslationMapping();

		// use only those translationmappings that are actually explanations.
		translationMapping.values().retainAll(anomalyExplanation.getExplanations());

		System.out.println(Arrays.toString(client.exporter.getTranslationMapping().entrySet().toArray()));
		

		Set<DwEditorOperation> opsList = new HashSet<DwEditorOperation>();
		
		for (EObject obj : translationMapping.keySet()) {
			// resolve ids to names
			String explanation = resolveFeatureName(translationMapping.get(obj), anomalyExplanation.getDate());
								
			if (obj instanceof HyRootFeature) {
				HyRootFeature rootFeature = (HyRootFeature) obj;
				String rootFeatureName = HyEvolutionUtil.getValidTemporalElement(rootFeature.getFeature().getNames(), anomalyExplanation.getDate()).getName();
				System.out.println(explanation + " -> " + rootFeatureName + " is root feature.");
				opsList.addAll(getEditorOperationListForObject(rootFeature, anomalyExplanation.getDate()));
			}
			else if (obj instanceof HyFeature) {
				HyFeature feature = (HyFeature) obj;
				String featureName = HyEvolutionUtil.getValidTemporalElement(feature.getNames(), anomalyExplanation.getDate()).getName();
				System.out.println(explanation + " -> " + featureName + " is mandatory.");
				// TODO: check whether this is related to changing the feature type
				opsList.addAll(getEditorOperationListForObject(feature, anomalyExplanation.getDate()));
			}
			else if (obj instanceof HyConstraint) {
				HyConstraint constraint = (HyConstraint) obj;
				System.out.println(explanation + " -> constraint");
				// TODO: check whether a constraint might have caused the anomaly
				opsList.addAll(getEditorOperationListForObject(constraint, anomalyExplanation.getDate()));
			}
			else if (obj instanceof HyValidityFormula) {
				HyValidityFormula validityFormula = (HyValidityFormula) obj;
				System.out.println(explanation + " -> validity formula");
				// TODO: check whether a validityformula might have caused the anomaly
				opsList.addAll(getEditorOperationListForObject(validityFormula, anomalyExplanation.getDate()));
			}
			else if (obj instanceof HyGroup) {
				HyGroup group = (HyGroup) obj;
				System.out.println(explanation + " -> this is a group.");
				
//				HyGroupComposition groupComposition = HyEvolutionUtil.getValidTemporalElement(group.getParentOf(), anomalyExplanation.getDate());
				
				// TODO: check whether this is related to moving a feature to the group, or changing the group type
				
				opsList.addAll(getEditorOperationListForObject(group, anomalyExplanation.getDate()));
				
				// check parent modifications
				HyFeatureChild featureChild = HyEvolutionUtil.getValidTemporalElement(group.getChildOf(), anomalyExplanation.getDate());
				opsList.addAll(getEditorOperationListForObject(featureChild.getParent(), anomalyExplanation.getDate()));
//				System.out.println(Arrays.toString(opsList.toArray()));
				
			}
			else if (obj instanceof HyGroupComposition) {
				HyGroupComposition groupComposition = (HyGroupComposition) obj;
				System.out.println(explanation + " -> this is a group to parent relation.");
				// TODO: check whether this is related to moving a feature to the group, or changing the group type
				
				HyGroup group = groupComposition.getCompositionOf();
				opsList.addAll(getEditorOperationListForObject(group, anomalyExplanation.getDate()));
//				System.out.println(Arrays.toString(opsList.toArray()));
			}
			
			// TODO: figure out what happened to changes that are not related to these constraint!
			// example: grouptype change mandatory->optional (won't give you a constraint, except the parent iirc)
			// generally: check occurring anomalies cases.
		}
		return opsList;
	}
	

	protected void evaluateDeadFeatureEditorOperations(Set<DwEditorOperation> opsList) {
		/*
		 * Relevant EditorOperations for Dead Feature Anomaly:
		 * FeatureType
		 * FeatureGroup
		 * GroupType
		 * AttributeMinMax
		 * ConstraintCreate
		 * ValidityFormulaCreate
		 * 
		 */
		for (DwEditorOperation operation : opsList) {
			if (operation instanceof DwEditorOperationFeatureType) {
				DwEditorOperationFeatureType featureType = (DwEditorOperationFeatureType) operation;
				String featureName = HyEvolutionUtil.getValidTemporalElement(featureType.getFeature().getNames(), operation.getEvoStep()).getName();
				String oldName = featureType.getOldType().getType().getName();
				String newName = featureType.getNewType().getType().getName();
				System.out.println("-> FeatureType of " + featureName + " changed from " + oldName +  " to " + newName + " in " + operation.getEvoStep());
			}
			else if (operation instanceof DwEditorOperationFeatureGroup) {
				DwEditorOperationFeatureGroup featureGroup = (DwEditorOperationFeatureGroup) operation;
				String featureName = HyEvolutionUtil.getValidTemporalElement(featureGroup.getFeature().getNames(), operation.getEvoStep()).getName();
				HyFeatureChild oldParentFeatureChild = HyEvolutionUtil.getValidTemporalElement(featureGroup.getOldGroup().getCompositionOf().getChildOf(), operation.getEvoStep());
				String oldParentFeatureName = HyEvolutionUtil.getValidTemporalElement(oldParentFeatureChild.getParent().getNames(), operation.getEvoStep()).getName();
				HyFeatureChild newParentFeatureChild = HyEvolutionUtil.getValidTemporalElement(featureGroup.getNewGroup().getCompositionOf().getChildOf(), operation.getEvoStep());
				String newParentFeatureName = HyEvolutionUtil.getValidTemporalElement(newParentFeatureChild.getParent().getNames(), operation.getEvoStep()).getName();
				System.out.println("-> Feature " + featureName + " moved from parent " + oldParentFeatureName + " to " + newParentFeatureName + " in " + operation.getEvoStep());
			}
			else if (operation instanceof DwEditorOperationGroupType) {
				DwEditorOperationGroupType groupType = (DwEditorOperationGroupType) operation;
				HyFeatureChild groupChild = HyEvolutionUtil.getValidTemporalElement(groupType.getGroup().getChildOf(), operation.getEvoStep());
				String parentFeatureName = HyEvolutionUtil.getValidTemporalElement(groupChild.getParent().getNames(), operation.getEvoStep()).getName();
				String oldGroupType = groupType.getOldType().getType().getName();
				String newGroupType = groupType.getNewType().getType().getName();
				System.out.println("-> GroupType beneath parent " + parentFeatureName + " changed from " + oldGroupType + " to " + newGroupType + " in " + operation.getEvoStep());
			}
			else if (operation instanceof DwEditorOperationAttributeMinMax) { // TODO: cannot be detected!!!
				DwEditorOperationAttributeMinMax attributeMinMax = (DwEditorOperationAttributeMinMax) operation;
				String attributeName = HyEvolutionUtil.getValidTemporalElement(attributeMinMax.getAttribute().getNames(), operation.getEvoStep()).getName();
				System.out.println("-> Attribute of " + attributeName + " changed " + attributeMinMax.getType().getName() + " from " + attributeMinMax.getOldMinMax() + " to " + attributeMinMax.getNewMinMax() + " in " + operation.getEvoStep());
			}
			else if (operation instanceof DwEditorOperationConstraintCreate) {
				DwEditorOperationConstraintCreate constraint = (DwEditorOperationConstraintCreate) operation;
				System.out.println("-> Constraint created in " + operation.getEvoStep()); // TODO: display constraint
			}
			else if (operation instanceof DwEditorOperationValidityFormulaCreate) {
				DwEditorOperationValidityFormulaCreate validityFormula = (DwEditorOperationValidityFormulaCreate) operation;
				System.out.println("-> ValidityFormula created in " + operation.getEvoStep()); // TODO: display validityformula
			}
		}
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
			
			HyGroupComposition groupComposition = HyEvolutionUtil.getValidTemporalElement(group.getParentOf(), date);
			for (HyFeature f : groupComposition.getFeatures()) {
				opsList.addAll(getEditorOperationListForObject(f, date));
			}
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
	
	
	// ------------- UTIL -------------
	
	public String resolveFeatureName(String encodedString, Date date) {
		List<String> list = new ArrayList<String>();
		list.add(encodedString);
		list = client.translateIdsBackToNames(list, date, client.exporter);
		return list.get(0);
	}
	
	public HyFeature getFeatureParent(HyFeature feature, Date date) {		
		for (HyGroupComposition groupComp : feature.getGroupMembership()) {			
			if (isElementValid(groupComp, date)) {				
				for (HyFeatureChild featureChild : groupComp.getCompositionOf().getChildOf()) {					
					if (isElementValid(featureChild, date)) {
						return featureChild.getParent();
					}
				}
			}
		}		
		return null;
	}
	
	public HyGroup getFeatureGroup(HyFeature feature, Date date) {		
		for (HyGroupComposition groupComp : feature.getGroupMembership()) {			
			if (isElementValid(groupComp, date)) {
				return groupComp.getCompositionOf();
			}			
		}		
		return null;
	}
	
	public HyGroupComposition getFeatureGroupComposition(HyGroup group, Date date) {
		for (HyGroupComposition groupComp : group.getParentOf()) {			
			if (isElementValid(groupComp, date)) {
				return groupComp;
			}			
		}		
		return null;
	}
	
	public HyFeatureType getFeatureType(HyFeature feature, Date date) {		
		for (HyFeatureType featureType : feature.getTypes()) {			
			if (isElementValid(featureType, date)) {
				return featureType;
			}			
		}		
		return null;
	}
	
	public boolean isElementValid(HyTemporalElement element, Date date) {
		if ((element.getValidSince() == null || element.getValidSince().compareTo(date) <= 0) &&
			(element.getValidUntil() == null || element.getValidUntil().compareTo(date) > 0)) {
			return true;
		}
		return false;
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
