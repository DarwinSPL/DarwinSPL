package de.darwinspl.reconfigurator.client.hyvarrec;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import de.darwinspl.anomalies.explanations.AnomalyConstraintExplanation;
import de.darwinspl.anomaly.DwAnomaly;
import de.darwinspl.anomaly.DwDeadFeatureAnomaly;
import de.darwinspl.anomaly.DwFalseOptionalFeatureAnomaly;
import de.darwinspl.anomaly.DwVoidFeatureModelAnomaly;
import de.darwinspl.anomaly.explanation.DwAnomalyExplanation;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperation;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationConstraint;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationConstraintCreate;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationContext;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnum;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumLiteral;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationEnumLiteralCreate;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeature;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureCreate;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureGroup;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureType;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationFeatureVersion;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupFeatures;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupFeaturesAdded;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupFeaturesRemoved;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationGroupType;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationValidityFormula;
import de.darwinspl.feature.evolution.evolutionoperation.DwEvolutionOperationValidityFormulaCreate;
import de.darwinspl.feature.evolution.evolutionoperation.EvolutionOperationExplanation;
import de.darwinspl.feature.evolution.evolutionoperation.EvolutionoperationFactory;
import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.context.HyContextualInformationEnum;
import eu.hyvar.context.contextValidity.HyValidityFormula;
import eu.hyvar.context.contextValidity.HyValidityModel;
import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.dataValues.HyEnumValue;
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
import eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyAttributeReferenceExpression;
import eu.hyvar.feature.expression.HyContextInformationReferenceExpression;
import eu.hyvar.feature.expression.HyExpression;
import eu.hyvar.feature.expression.HyValueExpression;
import eu.hyvar.feature.util.HyFeatureEvolutionUtil;
import eu.hyvar.reconfigurator.input.exporter.HyVarRecExporter;

/**
 * @author Felix Franzke, Michael Nieke
 */
public class DwEvolutionOperationAnalyzer {
	
	private HyContextModel contextModel;
	private HyValidityModel contextValidityModel;
	private HyFeatureModel featureModel;
	private HyConstraintModel constraintModel;
	
//	List<DwEvolutionOperation> operationList;

	List<HyFeature> deadFeatureList = new ArrayList<HyFeature>();
	List<HyFeature> falseOptionalList = new ArrayList<HyFeature>();
	
	protected HyVarRecExporter exporter;	
	
	public void setExporter(HyVarRecExporter exporter) {
		this.exporter = exporter;
	}
	
	public HyVarRecExporter getExporter() {
		return exporter;
	}
	
	public DwEvolutionOperationAnalyzer(HyVarRecExporter usedExporter) {
		setExporter(usedExporter);
		
		featureEvolutionOperations = new HashMap<HyFeature, List<DwEvolutionOperation>>();
		groupEvolutionOperations = new HashMap<HyGroup, List<DwEvolutionOperation>>();
		constraintEvolutionOperations = new HashMap<HyConstraint, List<DwEvolutionOperation>>();
		validityFormulaEvolutionOperations = new HashMap<HyValidityFormula, List<DwEvolutionOperation>>();
		enumEvolutionOperations = new HashMap<HyEnum, List<DwEvolutionOperation>>();
		attributeEvolutionOperations = new HashMap<HyFeatureAttribute, List<DwEvolutionOperation>>();
		contextEvolutionOperations = new HashMap<HyContextualInformation, List<DwEvolutionOperation>>();
	}
	
	
	private Map<HyFeature, List<DwEvolutionOperation>> featureEvolutionOperations;
	private Map<HyGroup, List<DwEvolutionOperation>> groupEvolutionOperations;
	private Map<HyConstraint, List<DwEvolutionOperation>> constraintEvolutionOperations;
	private Map<HyValidityFormula, List<DwEvolutionOperation>> validityFormulaEvolutionOperations;
	private Map<HyEnum, List<DwEvolutionOperation>> enumEvolutionOperations;
	private Map<HyFeatureAttribute, List<DwEvolutionOperation>> attributeEvolutionOperations;
	private Map<HyContextualInformation, List<DwEvolutionOperation>> contextEvolutionOperations;
	
	/**
	 * Creates all evolution operations related to the given validity formula
	 * @param constraint
	 * @return
	 */
	protected List<DwEvolutionOperation> constructConstraintEvolutionOperations(
			HyConstraint constraint) {
		List<DwEvolutionOperation> evolutionOperations = new ArrayList<DwEvolutionOperation>();
		
		// CONSTRAINT CREATE
		DwEvolutionOperation constraintCreateOperation = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationConstraintCreate();
		constraintCreateOperation.setEvoStep(constraint.getValidSince());
		((DwEvolutionOperationConstraint) constraintCreateOperation).setConstraint(constraint);
		evolutionOperations.add(constraintCreateOperation);

		// CONSTRAINT DELETE
		if (constraint.getValidUntil() != null) {
			DwEvolutionOperation constraintDeleteOperation = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationConstraintDelete();
			constraintDeleteOperation.setEvoStep(constraint.getValidUntil());
			((DwEvolutionOperationConstraint) constraintDeleteOperation).setConstraint(constraint);
			evolutionOperations.add(constraintDeleteOperation);
		}
		
		return evolutionOperations;
	}
	
	/**
	 * Creates all evolution operations related to the given validity formula
	 * @param validityFormula
	 * @return
	 */
	protected List<DwEvolutionOperation> constructValidityFormulaEvolutionOperations(
			HyValidityFormula validityFormula) {
		List<DwEvolutionOperation> evolutionOperations = new ArrayList<DwEvolutionOperation>();

		// VALIDITY FORMULA CREATE
		DwEvolutionOperation validityFormulaCreateOperation = EvolutionoperationFactory.eINSTANCE
				.createDwEvolutionOperationValidityFormulaCreate();
		validityFormulaCreateOperation.setEvoStep(validityFormula.getValidSince());
		((DwEvolutionOperationValidityFormula) validityFormulaCreateOperation).setValidityFormula(validityFormula);
		evolutionOperations.add(validityFormulaCreateOperation);

		// VALIDITY FORMULA DELETE
		if (validityFormula.getValidUntil() != null) {
			DwEvolutionOperation validityFormulaDeleteOperation = EvolutionoperationFactory.eINSTANCE
					.createDwEvolutionOperationValidityFormulaDelete();
			validityFormulaDeleteOperation.setEvoStep(validityFormula.getValidUntil());
			((DwEvolutionOperationValidityFormula) validityFormulaDeleteOperation).setValidityFormula(validityFormula);
			evolutionOperations.add(validityFormulaDeleteOperation);
		}

		return evolutionOperations;
	}
	
	/**
	 * Creates all evolution operations related to the given context
	 * @param contextualInformation
	 * @return
	 */
	protected List<DwEvolutionOperation> constructContextEvolutionOperations(
			HyContextualInformation contextualInformation) {
		List<DwEvolutionOperation> evolutionOperations = new ArrayList<DwEvolutionOperation>();

		// CONTEXT CREATE
		DwEvolutionOperation contextCreateOperation = EvolutionoperationFactory.eINSTANCE
				.createDwEvolutionOperationContextCreate();
		contextCreateOperation.setEvoStep(contextualInformation.getValidSince());
		((DwEvolutionOperationContext) contextCreateOperation).setContext(contextualInformation);
		evolutionOperations.add(contextCreateOperation);

		// CONTEXT DELETE
		if (contextualInformation.getValidUntil() != null) {
			DwEvolutionOperation contextDeleteOperation = EvolutionoperationFactory.eINSTANCE
					.createDwEvolutionOperationContextDelete();
			contextDeleteOperation.setEvoStep(contextualInformation.getValidUntil());
			((DwEvolutionOperationContext) contextDeleteOperation).setContext(contextualInformation);
			evolutionOperations.add(contextDeleteOperation);
		}

		return evolutionOperations;
	}
	
	/**
	 * Creates all evolution operations related to the given enum
	 * @param hyEnum
	 * @return
	 */
	protected List<DwEvolutionOperation> constructEnumEvolutionOperations(HyEnum hyEnum) {
		List<DwEvolutionOperation> evolutionOperations = new ArrayList<DwEvolutionOperation>();

		// ENUM CREATE
		DwEvolutionOperation obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationEnumCreate();
		obj.setEvoStep(hyEnum.getValidSince());
		((DwEvolutionOperationEnum) obj).setEnum(hyEnum);
		evolutionOperations.add(obj);

		// ENUM DELETE
		if (hyEnum.getValidUntil() != null) {
			DwEvolutionOperation enumDeleteOperation = EvolutionoperationFactory.eINSTANCE
					.createDwEvolutionOperationEnumDelete();
			enumDeleteOperation.setEvoStep(hyEnum.getValidUntil());
			((DwEvolutionOperationEnum) enumDeleteOperation).setEnum(hyEnum);
			evolutionOperations.add(enumDeleteOperation);
		}

		for (HyEnumLiteral literal : hyEnum.getLiterals()) {
			// ENUM LITERAL CREATE
			DwEvolutionOperation enumLiteralCreateOperation = EvolutionoperationFactory.eINSTANCE
					.createDwEvolutionOperationEnumLiteralCreate();
			enumLiteralCreateOperation.setEvoStep(literal.getValidSince());
			((DwEvolutionOperationEnumLiteral) enumLiteralCreateOperation).setEnum(hyEnum);
			((DwEvolutionOperationEnumLiteral) enumLiteralCreateOperation).setLiteral(literal);
			evolutionOperations.add(enumLiteralCreateOperation);

			// ENUM LITERAL DELETE
			if (literal.getValidUntil() != null) {
				DwEvolutionOperation enumLiteralDeleteOperation = EvolutionoperationFactory.eINSTANCE
						.createDwEvolutionOperationEnumLiteralDelete();
				enumLiteralDeleteOperation.setEvoStep(literal.getValidUntil());
				((DwEvolutionOperationEnumLiteral) enumLiteralDeleteOperation).setEnum(hyEnum);
				((DwEvolutionOperationEnumLiteral) enumLiteralDeleteOperation).setLiteral(literal);
				evolutionOperations.add(enumLiteralDeleteOperation);
			}
		}

		return evolutionOperations;
	}
	
	/**
	 * Creates all evolution operations related to the given group
	 * @param group
	 * @return
	 */
	protected List<DwEvolutionOperation> constructGroupEvolutionOperations(HyGroup group) {
		List<DwEvolutionOperation> evolutionOperations = new ArrayList<DwEvolutionOperation>();

		for (HyGroupType type : group.getTypes()) {

			// GROUP TYPE
			if (type.getValidSince() != null && !type.getValidSince().equals(group.getValidSince())) { // don't
																										// interpret
																										// default as
																										// change
				HyGroupType predecessor = HyEvolutionUtil.getValidTemporalElement(group.getTypes(),
						new Date(type.getValidSince().getTime() - 1L));
				DwEvolutionOperation groupTypeOperation = EvolutionoperationFactory.eINSTANCE
						.createDwEvolutionOperationGroupType();
				groupTypeOperation.setEvoStep(type.getValidSince());
				((DwEvolutionOperationGroupType) groupTypeOperation).setGroup(group);
				((DwEvolutionOperationGroupType) groupTypeOperation).setOldType(predecessor);
				((DwEvolutionOperationGroupType) groupTypeOperation).setNewType(type);
				evolutionOperations.add(groupTypeOperation);
			}
		}
		
		for (HyGroupComposition groupComposition : group.getParentOf()) {
			if(groupComposition.getValidSince() == null) {
				continue;
			}
			HyGroupComposition predecessor = HyEvolutionUtil.getValidTemporalElement(group.getParentOf(), new Date(groupComposition.getValidSince().getTime() -1L));
			
			if (predecessor != null && groupComposition.getCompositionOf().equals(predecessor.getCompositionOf())) {
				DwEvolutionOperationGroupFeaturesAdded evolutionOperation = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationGroupFeaturesAdded();
				
				for(HyFeature feature: groupComposition.getFeatures()) {
					// only relevant for features that are newly added directly into this group composition
					if(feature.getValidSince() != null && feature.getValidSince().equals(groupComposition.getValidSince())) {
						evolutionOperation.getAffectedFeatures().add(feature);
					}
				}
				
				DwEvolutionOperationGroupFeaturesRemoved evolutionOperationRemoved = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationGroupFeaturesRemoved();
				for(HyFeature feature: predecessor.getFeatures()) {
					// only relevant for features that are removed at that date
					if(feature.getValidUntil() != null && feature.getValidUntil().equals(groupComposition.getValidSince())) {
						evolutionOperationRemoved.getAffectedFeatures().add(feature);
					}
				}
				
				if(!evolutionOperation.getAffectedFeatures().isEmpty()) {
					evolutionOperation.setEvoStep(groupComposition.getValidSince());
					evolutionOperation.setGroup(group);
					
					evolutionOperations.add(evolutionOperation);
					
				}
				
				if(!evolutionOperationRemoved.getAffectedFeatures().isEmpty()) {
					evolutionOperationRemoved.setEvoStep(groupComposition.getValidSince());
					evolutionOperationRemoved.setGroup(group);
					
					evolutionOperations.add(evolutionOperationRemoved);
				}
			}
		}
		
		
//		for (HyGroupComposition groupComposition : group.getParentOf()) {
//				HyGroupComposition predecessor = HyEvolutionUtil.getValidTemporalElement(group.getParentOf(), new Date(group.getValidSince().getTime() -1L));
//				
//				if (predecessor != null && !groupComposition.getCompositionOf().equals(predecessor.getCompositionOf())) {
//					DwEvolutionOperation featureGroupOperation = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationFeatureGroup();
//					featureGroupOperation.setEvoStep(group.getValidSince());
//					((DwEvolutionOperationFeature) featureGroupOperation).setFeature(feature);
//					((DwEvolutionOperationFeatureGroup) featureGroupOperation).setOldGroup(predecessor);
//					((DwEvolutionOperationFeatureGroup) featureGroupOperation).setNewGroup(group);
//					evolutionOperations.add(featureGroupOperation);
//				}
//			
//		}

		return evolutionOperations;
	}
	
	/**
	 * Creates all evolution operations related to the given feature.
	 * @param feature
	 * @return
	 */
	protected List<DwEvolutionOperation> constructFeatureEvolutionOperations(HyFeature feature) {
		List<DwEvolutionOperation> evolutionOperations = new ArrayList<DwEvolutionOperation>();
		
//		// FEATURE CREATE
//		if (feature.getValidSince() != null) {
//			DwEvolutionOperation featureCreateOperation = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationFeatureCreate();
//			featureCreateOperation.setEvoStep(feature.getValidSince());
//			((DwEvolutionOperationFeature) featureCreateOperation).setFeature(feature);
//			evolutionOperations.add(featureCreateOperation);			
//		}
//		
//		// FEATURE DELETE
//		if (feature.getValidUntil() != null) {
//			DwEvolutionOperation featureDeleteOperation = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationFeatureDelete();
//			featureDeleteOperation.setEvoStep(feature.getValidUntil());
//			((DwEvolutionOperationFeature) featureDeleteOperation).setFeature(feature);
//			evolutionOperations.add(featureDeleteOperation);
//		}
		
		// commented out as it seems to be irrelevant
//		// FEATURE NAME
//		for (HyName name : feature.getNames()) {
//			if (name.getValidSince() != null && !name.getValidSince().equals(feature.getValidSince())) { // don't interpret default as change						
//				HyName predecessor = HyEvolutionUtil.getValidTemporalElement(feature.getNames(), new Date(name.getValidSince().getTime() -1L));
//				obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationFeatureRename();
//				obj.setEvoStep(name.getValidSince());
//				((DwEvolutionOperationFeature) obj).setFeature(feature);
//				((DwEvolutionOperationFeatureRename) obj).setOldName(predecessor);
//				((DwEvolutionOperationFeatureRename) obj).setNewName(name);
//				operationList.add(obj);
//			}
//		}
		
		// FEATURE TYPE
		for (HyFeatureType type : feature.getTypes()) {
			if (type.getValidSince() != null && !type.getValidSince().equals(feature.getValidSince())) { // don't interpret default as change
				HyFeatureType predecessor = HyEvolutionUtil.getValidTemporalElement(feature.getTypes(), new Date(type.getValidSince().getTime() -1L));
				if (predecessor.getType() != type.getType()) {
					DwEvolutionOperation featureTypeOperation = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationFeatureType();
					featureTypeOperation.setEvoStep(type.getValidSince());
					((DwEvolutionOperationFeature) featureTypeOperation).setFeature(feature);
					((DwEvolutionOperationFeatureType) featureTypeOperation).setOldType(predecessor);
					((DwEvolutionOperationFeatureType) featureTypeOperation).setNewType(type);
					evolutionOperations.add(featureTypeOperation);
				}
			}
		}
		
		for (HyVersion version : feature.getVersions()) {
			// FEATURE VERSION CREATE
			DwEvolutionOperation versionCreateOperation = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationFeatureVersionCreate();
			versionCreateOperation.setEvoStep(version.getValidSince());
			((DwEvolutionOperationFeatureVersion) versionCreateOperation).setFeature(feature);
			((DwEvolutionOperationFeatureVersion) versionCreateOperation).setVersion(version);
			evolutionOperations.add(versionCreateOperation);

			// FEATURE VERSION DELETE
			if (version.getValidUntil() != null) {
				DwEvolutionOperation versionDeleteOperation = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationFeatureVersionDelete();
				versionDeleteOperation.setEvoStep(version.getValidUntil());
				((DwEvolutionOperationFeatureVersion) versionDeleteOperation).setFeature(feature);
				((DwEvolutionOperationFeatureVersion) versionDeleteOperation).setVersion(version);
				evolutionOperations.add(versionDeleteOperation);
			}
		}
		
		// FEATURE MOVED FROM ONE GROUP TO ANOHTER
		for (HyGroupComposition group : feature.getGroupMembership()) {
			if (group.getValidSince() != null && !group.getValidSince().equals(feature.getValidSince())) { // don't interpret default as change
				HyGroupComposition predecessor = HyEvolutionUtil.getValidTemporalElement(feature.getGroupMembership(), new Date(group.getValidSince().getTime() -1L));
				
				if (predecessor != null && !group.getCompositionOf().equals(predecessor.getCompositionOf())) {
					DwEvolutionOperation featureGroupOperation = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationFeatureGroup();
					featureGroupOperation.setEvoStep(group.getValidSince());
					((DwEvolutionOperationFeature) featureGroupOperation).setFeature(feature);
					((DwEvolutionOperationFeatureGroup) featureGroupOperation).setOldGroup(predecessor);
					((DwEvolutionOperationFeatureGroup) featureGroupOperation).setNewGroup(group);
					evolutionOperations.add(featureGroupOperation);
				}
			}
		}
		
//		for (HyFeatureAttribute attribute : feature.getAttributes()) {
//			
//			// ATTRIBUTE CREATE
//			featureCreateOperation = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationAttributeCreate();
//			featureCreateOperation.setEvoStep(attribute.getValidSince());
//			((DwEvolutionOperationAttribute) featureCreateOperation).setAttribute(attribute);
//			operationList.add(featureCreateOperation);
//
//			// ATTRIBUTE DELETE
//			if (attribute.getValidUntil() != null) {
//				featureCreateOperation = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationAttributeDelete();
//				featureCreateOperation.setEvoStep(attribute.getValidSince());
//				((DwEvolutionOperationAttribute) featureCreateOperation).setAttribute(attribute);
//				operationList.add(featureCreateOperation);
//			}
//
		// commented out as it seems to be irrelevant
//			// ATTRIBUTE RENAME 
//			for (HyName name : attribute.getNames()) {
//				if (name.getValidSince() != null && !name.getValidSince().equals(attribute.getValidSince())) { // don't interpret default as change
//					HyName predecessor = HyEvolutionUtil.getValidTemporalElement(attribute.getNames(), new Date(name.getValidSince().getTime() -1L));
//					obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationAttributeRename();
//					obj.setEvoStep(name.getValidSince());
//					((DwEvolutionOperationAttribute) obj).setAttribute(attribute);
//					((DwEvolutionOperationAttributeRename) obj).setOldName(predecessor);
//					((DwEvolutionOperationAttributeRename) obj).setNewName(name);
//					operationList.add(obj);
//				}
//			}
//		}
		return evolutionOperations;
	
	}
	
	public List<DwEvolutionOperation> createAllEvolutionOperations() {
		// TODO refactor! That's way to ineffecient. Should be calculated on demand if those elements appear in explanations. Saved in a map that serves as cache.
		List<DwEvolutionOperation> operationList = new ArrayList<DwEvolutionOperation>();
		DwEvolutionOperation obj = null;
		if (getFeatureModel() != null) {
			
			for (HyFeature feature : getFeatureModel().getFeatures()) {
//				// FEATURE CREATE
//				if(feature.getValidSince() != null) {
//					obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationFeatureCreate();
//					obj.setEvoStep(feature.getValidSince());
//					((DwEvolutionOperationFeature) obj).setFeature(feature);
//					operationList.add(obj);
//				}
//				
//				// FEATURE DELETE
//				if (feature.getValidUntil() != null) {
//					obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationFeatureDelete();
//					obj.setEvoStep(feature.getValidUntil());
//					((DwEvolutionOperationFeature) obj).setFeature(feature);
//					operationList.add(obj);
//				}
				
				// commented out as it seems to be irrelevant
//				// FEATURE NAME
//				for (HyName name : feature.getNames()) {
//					if (name.getValidSince() != null && !name.getValidSince().equals(feature.getValidSince())) { // don't interpret default as change						
//						HyName predecessor = HyEvolutionUtil.getValidTemporalElement(feature.getNames(), new Date(name.getValidSince().getTime() -1L));
//						obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationFeatureRename();
//						obj.setEvoStep(name.getValidSince());
//						((DwEvolutionOperationFeature) obj).setFeature(feature);
//						((DwEvolutionOperationFeatureRename) obj).setOldName(predecessor);
//						((DwEvolutionOperationFeatureRename) obj).setNewName(name);
//						operationList.add(obj);
//					}
//				}
				
				// FEATURE TYPE
				for (HyFeatureType type : feature.getTypes()) {
					if (type.getValidSince() != null && !type.getValidSince().equals(feature.getValidSince())) { // don't interpret default as change
						HyFeatureType predecessor = HyEvolutionUtil.getValidTemporalElement(feature.getTypes(), new Date(type.getValidSince().getTime() -1L));
						if (predecessor.getType() != type.getType()) {
							obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationFeatureType();
							obj.setEvoStep(type.getValidSince());
							((DwEvolutionOperationFeature) obj).setFeature(feature);
							((DwEvolutionOperationFeatureType) obj).setOldType(predecessor);
							((DwEvolutionOperationFeatureType) obj).setNewType(type);
							operationList.add(obj);
						}
					}
				}
				
				for (HyVersion version : feature.getVersions()) {
					// FEATURE VERSION CREATE
					obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationFeatureVersionCreate();
					obj.setEvoStep(version.getValidSince());
					((DwEvolutionOperationFeatureVersion) obj).setFeature(feature);
					((DwEvolutionOperationFeatureVersion) obj).setVersion(version);
					operationList.add(obj);

					// FEATURE VERSION DELETE
					if (version.getValidUntil() != null) {
						obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationFeatureVersionDelete();
						obj.setEvoStep(version.getValidUntil());
						((DwEvolutionOperationFeatureVersion) obj).setFeature(feature);
						((DwEvolutionOperationFeatureVersion) obj).setVersion(version);
						operationList.add(obj);
					}
				}
				
				// FEATURE MOVED FROM ONE GROUP TO ANOHTER
				for (HyGroupComposition group : feature.getGroupMembership()) {
					if (group.getValidSince() != null && !group.getValidSince().equals(feature.getValidSince())) { // don't interpret default as change
						HyGroupComposition predecessor = HyEvolutionUtil.getValidTemporalElement(feature.getGroupMembership(), new Date(group.getValidSince().getTime() -1L));
						
						if (predecessor != null && !group.getCompositionOf().equals(predecessor.getCompositionOf())) {
							DwEvolutionOperation featureGroupOperation = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationFeatureGroup();
							featureGroupOperation.setEvoStep(group.getValidSince());
							((DwEvolutionOperationFeature) featureGroupOperation).setFeature(feature);
							((DwEvolutionOperationFeatureGroup) featureGroupOperation).setOldGroup(predecessor);
							((DwEvolutionOperationFeatureGroup) featureGroupOperation).setNewGroup(group);
							operationList.add(featureGroupOperation);
						}
					}
				}
				
//				for (HyFeatureAttribute attribute : feature.getAttributes()) {
//					
//					// ATTRIBUTE CREATE
//					obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationAttributeCreate();
//					obj.setEvoStep(attribute.getValidSince());
//					((DwEvolutionOperationAttribute) obj).setAttribute(attribute);
//					operationList.add(obj);
//
//					// ATTRIBUTE DELETE
//					if (attribute.getValidUntil() != null) {
//						obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationAttributeDelete();
//						obj.setEvoStep(attribute.getValidSince());
//						((DwEvolutionOperationAttribute) obj).setAttribute(attribute);
//						operationList.add(obj);
//					}
//
//				// commented out as it seems to be irrelevant
////					// ATTRIBUTE RENAME 
////					for (HyName name : attribute.getNames()) {
////						if (name.getValidSince() != null && !name.getValidSince().equals(attribute.getValidSince())) { // don't interpret default as change
////							HyName predecessor = HyEvolutionUtil.getValidTemporalElement(attribute.getNames(), new Date(name.getValidSince().getTime() -1L));
////							obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationAttributeRename();
////							obj.setEvoStep(name.getValidSince());
////							((DwEvolutionOperationAttribute) obj).setAttribute(attribute);
////							((DwEvolutionOperationAttributeRename) obj).setOldName(predecessor);
////							((DwEvolutionOperationAttributeRename) obj).setNewName(name);
////							operationList.add(obj);
////						}
////					}
//				}
			}
			
			for (HyGroup group : getFeatureModel().getGroups()) {		
				for (HyGroupType type : group.getTypes()) {
										
					// GROUP TYPE
					if (type.getValidSince() != null && !type.getValidSince().equals(group.getValidSince())) { // don't interpret default as change
						HyGroupType predecessor = HyEvolutionUtil.getValidTemporalElement(group.getTypes(), new Date(type.getValidSince().getTime() -1L));
						obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationGroupType();
						obj.setEvoStep(type.getValidSince());
						((DwEvolutionOperationGroupType) obj).setGroup(group);
						((DwEvolutionOperationGroupType) obj).setOldType(predecessor);
						((DwEvolutionOperationGroupType) obj).setNewType(type);
						operationList.add(obj);
					}
				}

				
				for (HyGroupComposition groupComposition : group.getParentOf()) {
					if(groupComposition.getValidSince() == null) {
						continue;
					}
					HyGroupComposition predecessor = HyEvolutionUtil.getValidTemporalElement(group.getParentOf(), new Date(groupComposition.getValidSince().getTime() -1L));
					
					if (predecessor != null && groupComposition.getCompositionOf().equals(predecessor.getCompositionOf())) {
						DwEvolutionOperationGroupFeaturesAdded evolutionOperation = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationGroupFeaturesAdded();
						
						for(HyFeature feature: groupComposition.getFeatures()) {
							// only relevant for features that are newly added directly into this group composition
							if(feature.getValidSince() != null && feature.getValidSince().equals(groupComposition.getValidSince())) {
								evolutionOperation.getAffectedFeatures().add(feature);
							}
						}
						
						DwEvolutionOperationGroupFeaturesRemoved evolutionOperationRemoved = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationGroupFeaturesRemoved();
						for(HyFeature feature: predecessor.getFeatures()) {
							// only relevant for features that are removed at that date
							if(feature.getValidUntil() != null && feature.getValidUntil().equals(groupComposition.getValidSince())) {
								evolutionOperationRemoved.getAffectedFeatures().add(feature);
							}
						}
						
						if(!evolutionOperation.getAffectedFeatures().isEmpty()) {
							evolutionOperation.setEvoStep(groupComposition.getValidSince());
							evolutionOperation.setGroup(group);
							
							operationList.add(evolutionOperation);
							
						}
						
						if(!evolutionOperationRemoved.getAffectedFeatures().isEmpty()) {
							evolutionOperationRemoved.setEvoStep(groupComposition.getValidSince());
							evolutionOperationRemoved.setGroup(group);
							
							operationList.add(evolutionOperationRemoved);
						}
					}
				}
			}
		}
		
//		List<HyEnum> enumList = new ArrayList<HyEnum>();
//		if (getContextModel() != null) {
//			enumList.addAll(getContextModel().getEnums());
//		}
//		if (getFeatureModel() != null) {
//			enumList.addAll(getFeatureModel().getEnums());
//		}
//		for (HyEnum hyEnum : enumList) {
//			
//			// ENUM CREATE
//			obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationEnumCreate();
//			obj.setEvoStep(hyEnum.getValidSince());
//			((DwEvolutionOperationEnum) obj).setEnum(hyEnum);
//			operationList.add(obj);
//			
//			// ENUM DELETE
//			if (hyEnum.getValidUntil() != null) {
//				obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationEnumDelete();
//				obj.setEvoStep(hyEnum.getValidUntil());
//				((DwEvolutionOperationEnum) obj).setEnum(hyEnum);
//				operationList.add(obj);
//			}
//						
//			for (HyEnumLiteral literal : hyEnum.getLiterals()) {
//				// ENUM LITERAL CREATE
//				obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationEnumLiteralCreate();
//				obj.setEvoStep(literal.getValidSince());
//				((DwEvolutionOperationEnumLiteral) obj).setEnum(hyEnum);
//				((DwEvolutionOperationEnumLiteral) obj).setLiteral(literal);
//				operationList.add(obj);
//
//				// ENUM LITERAL DELETE
//				if (literal.getValidUntil() != null) {
//					obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationEnumLiteralDelete();
//					obj.setEvoStep(literal.getValidUntil());
//					((DwEvolutionOperationEnumLiteral) obj).setEnum(hyEnum);
//					((DwEvolutionOperationEnumLiteral) obj).setLiteral(literal);
//					operationList.add(obj);
//				}
//			}
//		}

//		if (getContextModel() != null) {
//			for (HyContextualInformation context : getContextModel().getContextualInformations()) {
//				
//				// CONTEXT CREATE
//				obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationContextCreate();
//				obj.setEvoStep(context.getValidSince());
//				((DwEvolutionOperationContext) obj).setContext(context);
//				operationList.add(obj);
//
//				// CONTEXT DELETE
//				if (context.getValidUntil() != null) {
//					obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationContextDelete();
//					obj.setEvoStep(context.getValidUntil());
//					((DwEvolutionOperationContext) obj).setContext(context);
//					operationList.add(obj);
//				}
//			}
//		}
//		
//		if (getContextValidityModel() != null) {
//			for (HyValidityFormula validityFormula : getContextValidityModel().getValidityFormulas()) {
//				
//				// VALIDITY FORMULA CREATE
//				obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationValidityFormulaCreate();
//				obj.setEvoStep(validityFormula.getValidSince());
//				((DwEvolutionOperationValidityFormula) obj).setValidityFormula(validityFormula);
//				operationList.add(obj);
//
//				// VALIDITY FORMULA DELETE
//				if (validityFormula.getValidUntil() != null) {
//					obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationValidityFormulaDelete();
//					obj.setEvoStep(validityFormula.getValidUntil());
//					((DwEvolutionOperationValidityFormula) obj).setValidityFormula(validityFormula);
//					operationList.add(obj);
//				}
//			}
//		}
//
		if (getConstraintModel() != null) {
			for (HyConstraint constraint : getConstraintModel().getConstraints()) {

				// CONSTRAINT CREATE
				obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationConstraintCreate();
				obj.setEvoStep(constraint.getValidSince());
				((DwEvolutionOperationConstraint) obj).setConstraint(constraint);
				operationList.add(obj);

				// CONSTRAINT DELETE
				if (constraint.getValidUntil() != null) {
					obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationConstraintDelete();
					obj.setEvoStep(constraint.getValidUntil());
					((DwEvolutionOperationConstraint) obj).setConstraint(constraint);
					operationList.add(obj);
				}
			}
		}
		
		return operationList;
	}
	
	public void constructEvolutionOperations() {
		featureEvolutionOperations = new HashMap<HyFeature, List<DwEvolutionOperation>>();
		groupEvolutionOperations = new HashMap<HyGroup, List<DwEvolutionOperation>>();
		constraintEvolutionOperations = new HashMap<HyConstraint, List<DwEvolutionOperation>>();
		validityFormulaEvolutionOperations = new HashMap<HyValidityFormula, List<DwEvolutionOperation>>();
		enumEvolutionOperations = new HashMap<HyEnum, List<DwEvolutionOperation>>();
		attributeEvolutionOperations = new HashMap<HyFeatureAttribute, List<DwEvolutionOperation>>();
		contextEvolutionOperations = new HashMap<HyContextualInformation, List<DwEvolutionOperation>>();
		
		
		// TODO refactor! That's way to ineffecient. Should be calculated on demand if those elements appear in explanations. Saved in a map that serves as cache.
//		operationList = new ArrayList<DwEvolutionOperation>();
//		DwEvolutionOperation obj = null;
//		if (getFeatureModel() != null) {
//			
//			for (HyFeature feature : getFeatureModel().getFeatures()) {
//				// FEATURE CREATE
//				obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationFeatureCreate();
//				obj.setEvoStep(feature.getValidSince());
//				((DwEvolutionOperationFeature) obj).setFeature(feature);
//				operationList.add(obj);
//				
//				// FEATURE DELETE
//				if (feature.getValidUntil() != null) {
//					obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationFeatureDelete();
//					obj.setEvoStep(feature.getValidUntil());
//					((DwEvolutionOperationFeature) obj).setFeature(feature);
//					operationList.add(obj);
//				}
//				
//				// commented out as it seems to be irrelevant
////				// FEATURE NAME
////				for (HyName name : feature.getNames()) {
////					if (name.getValidSince() != null && !name.getValidSince().equals(feature.getValidSince())) { // don't interpret default as change						
////						HyName predecessor = HyEvolutionUtil.getValidTemporalElement(feature.getNames(), new Date(name.getValidSince().getTime() -1L));
////						obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationFeatureRename();
////						obj.setEvoStep(name.getValidSince());
////						((DwEvolutionOperationFeature) obj).setFeature(feature);
////						((DwEvolutionOperationFeatureRename) obj).setOldName(predecessor);
////						((DwEvolutionOperationFeatureRename) obj).setNewName(name);
////						operationList.add(obj);
////					}
////				}
//				
//				// FEATURE TYPE
//				for (HyFeatureType type : feature.getTypes()) {
//					if (type.getValidSince() != null && !type.getValidSince().equals(feature.getValidSince())) { // don't interpret default as change
//						HyFeatureType predecessor = HyEvolutionUtil.getValidTemporalElement(feature.getTypes(), new Date(type.getValidSince().getTime() -1L));
//						if (predecessor.getType() != type.getType()) {
//							obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationFeatureType();
//							obj.setEvoStep(type.getValidSince());
//							((DwEvolutionOperationFeature) obj).setFeature(feature);
//							((DwEvolutionOperationFeatureType) obj).setOldType(predecessor);
//							((DwEvolutionOperationFeatureType) obj).setNewType(type);
//							operationList.add(obj);
//						}
//					}
//				}
//				
//				for (HyVersion version : feature.getVersions()) {
//					// FEATURE VERSION CREATE
//					obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationFeatureVersionCreate();
//					obj.setEvoStep(version.getValidSince());
//					((DwEvolutionOperationFeatureVersion) obj).setFeature(feature);
//					((DwEvolutionOperationFeatureVersion) obj).setVersion(version);
//					operationList.add(obj);
//
//					// FEATURE VERSION DELETE
//					if (version.getValidUntil() != null) {
//						obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationFeatureVersionDelete();
//						obj.setEvoStep(version.getValidUntil());
//						((DwEvolutionOperationFeatureVersion) obj).setFeature(feature);
//						((DwEvolutionOperationFeatureVersion) obj).setVersion(version);
//						operationList.add(obj);
//					}
//				}
//				
//				// FEATURE GROUP
//				for (HyGroupComposition group : feature.getGroupMembership()) {
//					if (group.getValidSince() != null && !group.getValidSince().equals(feature.getValidSince())) { // don't interpret default as change
//						HyGroupComposition predecessor = HyEvolutionUtil.getValidTemporalElement(feature.getGroupMembership(), new Date(group.getValidSince().getTime() -1L));
//						
//						if (predecessor != null && !group.getCompositionOf().equals(predecessor.getCompositionOf())) {
//							obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationFeatureGroup();
//							obj.setEvoStep(group.getValidSince());
//							((DwEvolutionOperationFeature) obj).setFeature(feature);
//							((DwEvolutionOperationFeatureGroup) obj).setOldGroup(predecessor);
//							((DwEvolutionOperationFeatureGroup) obj).setNewGroup(group);
//							operationList.add(obj);
//						}
//					}
//				}
//				
//				for (HyFeatureAttribute attribute : feature.getAttributes()) {
//					
//					// ATTRIBUTE CREATE
//					obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationAttributeCreate();
//					obj.setEvoStep(attribute.getValidSince());
//					((DwEvolutionOperationAttribute) obj).setAttribute(attribute);
//					operationList.add(obj);
//
//					// ATTRIBUTE DELETE
//					if (attribute.getValidUntil() != null) {
//						obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationAttributeDelete();
//						obj.setEvoStep(attribute.getValidSince());
//						((DwEvolutionOperationAttribute) obj).setAttribute(attribute);
//						operationList.add(obj);
//					}
//
//				// commented out as it seems to be irrelevant
////					// ATTRIBUTE RENAME 
////					for (HyName name : attribute.getNames()) {
////						if (name.getValidSince() != null && !name.getValidSince().equals(attribute.getValidSince())) { // don't interpret default as change
////							HyName predecessor = HyEvolutionUtil.getValidTemporalElement(attribute.getNames(), new Date(name.getValidSince().getTime() -1L));
////							obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationAttributeRename();
////							obj.setEvoStep(name.getValidSince());
////							((DwEvolutionOperationAttribute) obj).setAttribute(attribute);
////							((DwEvolutionOperationAttributeRename) obj).setOldName(predecessor);
////							((DwEvolutionOperationAttributeRename) obj).setNewName(name);
////							operationList.add(obj);
////						}
////					}
//				}
//			}
			
//			for (HyGroup group : getFeatureModel().getGroups()) {		
//				for (HyGroupType type : group.getTypes()) {
//										
//					// GROUP TYPE
//					if (type.getValidSince() != null && !type.getValidSince().equals(group.getValidSince())) { // don't interpret default as change
//						HyGroupType predecessor = HyEvolutionUtil.getValidTemporalElement(group.getTypes(), new Date(type.getValidSince().getTime() -1L));
//						obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationGroupType();
//						obj.setEvoStep(type.getValidSince());
//						((DwEvolutionOperationGroupType) obj).setGroup(group);
//						((DwEvolutionOperationGroupType) obj).setOldType(predecessor);
//						((DwEvolutionOperationGroupType) obj).setNewType(type);
//						operationList.add(obj);
//					}
//				}
//			}
//		}
		
//		List<HyEnum> enumList = new ArrayList<HyEnum>();
//		if (getContextModel() != null) {
//			enumList.addAll(getContextModel().getEnums());
//		}
//		if (getFeatureModel() != null) {
//			enumList.addAll(getFeatureModel().getEnums());
//		}
//		for (HyEnum hyEnum : enumList) {
//			
//			// ENUM CREATE
//			obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationEnumCreate();
//			obj.setEvoStep(hyEnum.getValidSince());
//			((DwEvolutionOperationEnum) obj).setEnum(hyEnum);
//			operationList.add(obj);
//			
//			// ENUM DELETE
//			if (hyEnum.getValidUntil() != null) {
//				obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationEnumDelete();
//				obj.setEvoStep(hyEnum.getValidUntil());
//				((DwEvolutionOperationEnum) obj).setEnum(hyEnum);
//				operationList.add(obj);
//			}
//						
//			for (HyEnumLiteral literal : hyEnum.getLiterals()) {
//				// ENUM LITERAL CREATE
//				obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationEnumLiteralCreate();
//				obj.setEvoStep(literal.getValidSince());
//				((DwEvolutionOperationEnumLiteral) obj).setEnum(hyEnum);
//				((DwEvolutionOperationEnumLiteral) obj).setLiteral(literal);
//				operationList.add(obj);
//
//				// ENUM LITERAL DELETE
//				if (literal.getValidUntil() != null) {
//					obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationEnumLiteralDelete();
//					obj.setEvoStep(literal.getValidUntil());
//					((DwEvolutionOperationEnumLiteral) obj).setEnum(hyEnum);
//					((DwEvolutionOperationEnumLiteral) obj).setLiteral(literal);
//					operationList.add(obj);
//				}
//			}
//		}

//		if (getContextModel() != null) {
//			for (HyContextualInformation context : getContextModel().getContextualInformations()) {
//				
//				// CONTEXT CREATE
//				obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationContextCreate();
//				obj.setEvoStep(context.getValidSince());
//				((DwEvolutionOperationContext) obj).setContext(context);
//				operationList.add(obj);
//
//				// CONTEXT DELETE
//				if (context.getValidUntil() != null) {
//					obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationContextDelete();
//					obj.setEvoStep(context.getValidUntil());
//					((DwEvolutionOperationContext) obj).setContext(context);
//					operationList.add(obj);
//				}
//			}
//		}
//		
//		if (getContextValidityModel() != null) {
//			for (HyValidityFormula validityFormula : getContextValidityModel().getValidityFormulas()) {
//				
//				// VALIDITY FORMULA CREATE
//				obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationValidityFormulaCreate();
//				obj.setEvoStep(validityFormula.getValidSince());
//				((DwEvolutionOperationValidityFormula) obj).setValidityFormula(validityFormula);
//				operationList.add(obj);
//
//				// VALIDITY FORMULA DELETE
//				if (validityFormula.getValidUntil() != null) {
//					obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationValidityFormulaDelete();
//					obj.setEvoStep(validityFormula.getValidUntil());
//					((DwEvolutionOperationValidityFormula) obj).setValidityFormula(validityFormula);
//					operationList.add(obj);
//				}
//			}
//		}
//
//		if (getConstraintModel() != null) {
//			for (HyConstraint constraint : getConstraintModel().getConstraints()) {
//
//				// CONSTRAINT CREATE
//				obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationConstraintCreate();
//				obj.setEvoStep(constraint.getValidSince());
//				((DwEvolutionOperationConstraint) obj).setConstraint(constraint);
//				operationList.add(obj);
//
//				// CONSTRAINT DELETE
//				if (constraint.getValidUntil() != null) {
//					obj = EvolutionoperationFactory.eINSTANCE.createDwEvolutionOperationConstraintDelete();
//					obj.setEvoStep(constraint.getValidUntil());
//					((DwEvolutionOperationConstraint) obj).setConstraint(constraint);
//					operationList.add(obj);
//				}
//			}
//		}
	}

	public Set<AnomalyConstraintExplanation> explainAnomaly(DwAnomalyExplanation anomalyExplanation) {		
		if (anomalyExplanation.getAnomaly() instanceof DwVoidFeatureModelAnomaly) {
			return explainVoidAnomaly(anomalyExplanation);
		} else if (anomalyExplanation.getAnomaly() instanceof DwDeadFeatureAnomaly){
			return explainDeadFeatureAnomaly(anomalyExplanation);
		} else if (anomalyExplanation.getAnomaly() instanceof DwFalseOptionalFeatureAnomaly) {
			return explainFalseOptionalFeatureAnomaly(anomalyExplanation);
		}
		return null;
	}
	
	public Set<AnomalyConstraintExplanation> explainVoidAnomaly(DwAnomalyExplanation anomalyExplanation) {		
		Set<AnomalyConstraintExplanation> constraintExplanationList = getRelatedEvolutionOperationsFromExplanation(anomalyExplanation);
		
		for (AnomalyConstraintExplanation explanation : constraintExplanationList) {
			filterRelevantVoidFeatureModelEvolutionOperation(explanation);
			
			// now we can properly explain it:
			String explanationString = explanation.explain();
			System.out.println(explanationString);
		}
		
		return constraintExplanationList;
	}

	public Set<AnomalyConstraintExplanation> explainDeadFeatureAnomaly(DwAnomalyExplanation anomalyExplanation) {
		DwDeadFeatureAnomaly anomaly = (DwDeadFeatureAnomaly) anomalyExplanation.getAnomaly();
		Date date = anomaly.getValidSince();
		
		Set<AnomalyConstraintExplanation> constraintExplanationList = new HashSet<AnomalyConstraintExplanation>();
		
		HyFeature parent = HyFeatureEvolutionUtil.getParentFeatureOfFeature(anomaly.getFeature(), date);
		// Root's parent would be null
		if (parent != null) {
			
			// check whether the parent is already dead
			if (deadFeatureList.contains(parent)) {
				// IGNORE as the parent is the one we have already handled or handle later
				String explanation = "This is a dead feature, because of its already-dead parent " + HyEvolutionUtil.getValidTemporalElement(parent.getNames(), date).getName() + "!";
				AnomalyConstraintExplanation simpleExplanation = new AnomalyConstraintExplanation();
				simpleExplanation.setDate(date);
				simpleExplanation.setTranslatedConstraint(explanation);
				constraintExplanationList.add(simpleExplanation);
				return constraintExplanationList;
			}
		}
		
		// if not: it is caused by a constraint.
		
		constraintExplanationList = getRelatedEvolutionOperationsFromExplanation(anomalyExplanation);
		
		for (AnomalyConstraintExplanation explanation : constraintExplanationList) {
			filterRelevantDeadFeatureEvolutionOperation(explanation);
		}
		
		return constraintExplanationList;
		
	}
	

	public Set<AnomalyConstraintExplanation> explainFalseOptionalFeatureAnomaly(DwAnomalyExplanation anomalyExplanation) {		
		Set<AnomalyConstraintExplanation> constraintExplanationList = getRelatedEvolutionOperationsFromExplanation(anomalyExplanation);
		
		for (AnomalyConstraintExplanation explanation : constraintExplanationList) {
			filterRelevantFalseOptionalFeatureEvolutionOperation(explanation);
		}
		
		return constraintExplanationList;
		
	}
	
	protected Set<AnomalyConstraintExplanation> getRelatedEvolutionOperationsFromExplanation(DwAnomalyExplanation anomalyExplanation) {

		Map<String, EObject> translationMapping = exporter.getTranslationMapping();

		// use only those translation mappings that are actually explanations.
		translationMapping.keySet().retainAll(anomalyExplanation.getExplanations());

		Set<AnomalyConstraintExplanation> list = new HashSet<AnomalyConstraintExplanation>();
		
		for (String constraint : translationMapping.keySet()) {
			// resolve ids to names
			String constraintString = resolveFeatureNames(constraint, anomalyExplanation.getDate());
			
			AnomalyConstraintExplanation explanation = new AnomalyConstraintExplanation();
			explanation.setAffectedObject(translationMapping.get(constraint));
			explanation.setTranslatedConstraint(constraintString);
			explanation.setDate(anomalyExplanation.getDate());
			for (DwEvolutionOperation operation : getEvolutionOperationListForObject(translationMapping.get(constraint), anomalyExplanation.getDate())) {
				EvolutionOperationExplanation opExplanation = new EvolutionOperationExplanation(operation);
				explanation.addEvolutionOperationExplanation(opExplanation);
			}
			list.add(explanation);
		}
		return list;
	}
	
	// TODO Horrible Code! please refactor!
	public List<DwEvolutionOperation> getEvolutionOperationListForObject(EObject object, Date date) {
		List<DwEvolutionOperation> opsList = new ArrayList<DwEvolutionOperation>();
		
		HyFeature feature = null;
		if (object instanceof HyFeature) {
			feature = (HyFeature) object;
		}
		
		HyFeatureAttribute attribute = null;
		if (object instanceof HyFeatureAttribute) {
			attribute = (HyFeatureAttribute) object;
		}
		
		HyContextualInformation context = null;
		if (object instanceof HyContextualInformation) {
			context = (HyContextualInformation) object;
			
			// get evolution operations from the context enum
			if (context instanceof HyContextualInformationEnum) {
				List<DwEvolutionOperation> enumOpsList = getEvolutionOperationListForObject(((HyContextualInformationEnum) context).getEnumType(), date);
				opsList.addAll(enumOpsList);
			}
		}
		
		HyEnum hyEnum = null;
		if (object instanceof HyEnum) {
			hyEnum = (HyEnum) object;
		}
		
		HyGroup group = null;
		if (object instanceof HyGroup) {
			group = (HyGroup) object;
			
			// check involved features
			HyGroupComposition oldGroupComposition = HyEvolutionUtil.getValidTemporalElement(group.getParentOf(), new Date(date.getTime() -1L));
			HyGroupComposition newGroupComposition = HyEvolutionUtil.getValidTemporalElement(group.getParentOf(), date);
			List<HyFeature> featureList = newGroupComposition.getFeatures();
			
			// get the symmetrical difference to see the group's changes
			if (oldGroupComposition != null && oldGroupComposition != newGroupComposition) {
				for (HyFeature f : oldGroupComposition.getFeatures()) {
					if (featureList.contains(f)) {
						continue;
					}
					featureList.add(f);
				}
			}
			
			for (HyFeature f : featureList) {
				opsList.addAll(getEvolutionOperationListForObject(f, date));
			}
			
			// check parent
			HyFeatureChild featureChild = HyEvolutionUtil.getValidTemporalElement(group.getChildOf(), date);
			opsList.addAll(getEvolutionOperationListForObject(featureChild.getParent(), date));
		}
		
		HyConstraint constraint = null;
		if (object instanceof HyConstraint) {
			constraint = (HyConstraint) object;
			
			// Michael Nieke: As the operations for objects appearing in constraints are not necessarily causing operations, I removed this.
//			List<EObject> objectList = getObjectsFromExpression(constraint.getRootExpression());
//			for (EObject f : objectList) {
//				opsList.addAll(getEvolutionOperationListForObject(f, date));
//			}
		}
		
		HyValidityFormula validityFormula = null;
		if (object instanceof HyValidityFormula) {
			validityFormula = (HyValidityFormula) object;

			// Michael Nieke: As the operations for objects appearing in constraints are not necessarily causing operations, I removed this.
//			List<EObject> objectList = getObjectsFromExpression(validityFormula.getValidityFormula());
//			for (EObject f : objectList) {
//				opsList.addAll(getEvolutionOperationListForObject(f, date));
//			}
		}
		
		List<DwEvolutionOperation> evolutionOperationsForObject = new ArrayList<DwEvolutionOperation>();
		
		// Evolution Operations are only constructed if relevant for the explanation. Or reused if already cached.
		if (feature != null) {
			if(featureEvolutionOperations.containsKey(feature)) {
				evolutionOperationsForObject.addAll(featureEvolutionOperations.get(feature));
			}
			else {
				List<DwEvolutionOperation> evolutionOperations = constructFeatureEvolutionOperations(feature);
				featureEvolutionOperations.put(feature, evolutionOperations);
				evolutionOperationsForObject.addAll(evolutionOperations);
			}
		} else if (group != null) {
			if(groupEvolutionOperations.containsKey(group)) {
				evolutionOperationsForObject.addAll(groupEvolutionOperations.get(group));
			}
			else {
				List<DwEvolutionOperation> evolutionOperations = constructGroupEvolutionOperations(group);
				groupEvolutionOperations.put(group, evolutionOperations);
				evolutionOperationsForObject.addAll(evolutionOperations);
			}
		} else if (constraint != null) {
			if(constraintEvolutionOperations.containsKey(constraint)) {
				evolutionOperationsForObject.addAll(constraintEvolutionOperations.get(constraint));
			}
			else {
				List<DwEvolutionOperation> evolutionOperations = constructConstraintEvolutionOperations(constraint);
				constraintEvolutionOperations.put(constraint, evolutionOperations);
				evolutionOperationsForObject.addAll(evolutionOperations);
			}
		} else if (validityFormula != null) {
			if(validityFormulaEvolutionOperations.containsKey(validityFormula)) {
				evolutionOperationsForObject.addAll(validityFormulaEvolutionOperations.get(validityFormula));
			}
			else {
				List<DwEvolutionOperation> evolutionOperations = constructValidityFormulaEvolutionOperations(validityFormula);
				validityFormulaEvolutionOperations.put(validityFormula, evolutionOperations);
				evolutionOperationsForObject.addAll(evolutionOperations);
			}
		} else if (hyEnum != null) {
			if(enumEvolutionOperations.containsKey(hyEnum)) {
				evolutionOperationsForObject.addAll(enumEvolutionOperations.get(hyEnum));
			}
			else {
				List<DwEvolutionOperation> evolutionOperations = constructEnumEvolutionOperations(hyEnum);
				enumEvolutionOperations.put(hyEnum, evolutionOperations);
				evolutionOperationsForObject.addAll(evolutionOperations);
			}
		} else if (attribute != null) {
			System.err.println("Attribute evolution operations currently not supported by explanation engine.");
//			if(attributeEvolutionOperations.containsKey(attribute)) {
//				evolutionOperationsForObject.addAll(attributeEvolutionOperations.get(attribute));
//			}
//			else {
//				List<DwEvolutionOperation> evolutionOperations = constructFeatureAttributeEvolutionOperations(attribute);
//				attributeEvolutionOperations.put(attribute, evolutionOperations);
//				evolutionOperationsForObject.addAll(evolutionOperations);
//			}
		} else if (context != null) {
			if(contextEvolutionOperations.containsKey(context)) {
				evolutionOperationsForObject.addAll(contextEvolutionOperations.get(context));
			}
			else {
				List<DwEvolutionOperation> evolutionOperations = constructContextEvolutionOperations(context);
				contextEvolutionOperations.put(context, evolutionOperations);
				evolutionOperationsForObject.addAll(evolutionOperations);
			}
		}
		
		
		for (DwEvolutionOperation operation : evolutionOperationsForObject) {
			if (operation.getEvoStep() == null || operation.getEvoStep().equals(date) || operation.getEvoStep().before(date)) {
				opsList.add(operation);
				// old code refactored due to performance problems.
//				if (feature != null) {
//					if (operation instanceof DwEvolutionOperationFeature) {
//						DwEvolutionOperationFeature opFeature = (DwEvolutionOperationFeature) operation;
//						if (opFeature.getFeature() == feature) {
//							opsList.add(opFeature);
//						}
//					}
//					else if (operation instanceof DwEvolutionOperationAttribute) {
//						DwEvolutionOperationAttribute opAttribute = (DwEvolutionOperationAttribute) operation;
//						if (opAttribute.getAttribute().getFeature().equals(feature)) {
//							opsList.add(opAttribute);
//						}
//					}
//				} else if (group != null) {
//					if (operation instanceof DwEvolutionOperationGroupType) {
//						DwEvolutionOperationGroupType opGroupType = (DwEvolutionOperationGroupType) operation;
//						if (opGroupType.getGroup().equals(group)) {
//							opsList.add(opGroupType);
//						}
//					} else if (operation instanceof DwEvolutionOperationFeatureGroup) {
//						DwEvolutionOperationFeatureGroup opFeatureGroup = (DwEvolutionOperationFeatureGroup) operation;
//						if (opFeatureGroup.getNewGroup().getCompositionOf().equals(group)) {
//							opsList.add(opFeatureGroup);
//						}
//					}
//				} else if (constraint != null) {
//					if (operation instanceof DwEvolutionOperationConstraint) {
//						DwEvolutionOperationConstraint opConstraint = (DwEvolutionOperationConstraint) operation;
//						if (opConstraint.getConstraint().equals(constraint)) {
//							opsList.add(opConstraint);
//						}
//					}
//				} else if (validityFormula != null) {
//					if (operation instanceof DwEvolutionOperationValidityFormula) {
//						DwEvolutionOperationValidityFormula opValidityFormula = (DwEvolutionOperationValidityFormula) operation;
//						if (opValidityFormula.getValidityFormula().equals(validityFormula)) {
//							opsList.add(opValidityFormula);
//						}
//					}
//				} else if (hyEnum != null) {
//					if (operation instanceof DwEvolutionOperationEnum) {
//						DwEvolutionOperationEnum opEnum = (DwEvolutionOperationEnum) operation;
//						if (opEnum.getEnum().equals(hyEnum)) {
//							opsList.add(opEnum);
//						}
//					}
//				} else if (attribute != null) {
//					if (operation instanceof DwEvolutionOperationAttribute) {
//						DwEvolutionOperationAttribute opAttribute = (DwEvolutionOperationAttribute) operation;
//						if (opAttribute.getAttribute().equals(attribute)) {
//							opsList.add(opAttribute);
//						}
//					}
//				} else if (context != null) {
//					if (operation instanceof DwEvolutionOperationContext) {
//						DwEvolutionOperationContext opContext = (DwEvolutionOperationContext) operation;
//						if (opContext.getContext().equals(context)) {
//							opsList.add(opContext);
//						}
//					}
//				}
			}
		}
		
		return opsList;
	}
	
	
	public void filterRelevantDeadFeatureEvolutionOperation(AnomalyConstraintExplanation constraintExplanation) {
		List<EvolutionOperationExplanation> list = new ArrayList<EvolutionOperationExplanation>();
		list.addAll(constraintExplanation.getEvolutionOperations());
		constraintExplanation.getEvolutionOperations().clear();
		
		for (EvolutionOperationExplanation opExplanation : list) {
			DwEvolutionOperation operation = opExplanation.getEvolutionOperation();
			if (operation instanceof DwEvolutionOperationFeatureType
					|| operation instanceof DwEvolutionOperationFeatureGroup
					|| operation instanceof DwEvolutionOperationGroupType
					|| operation instanceof DwEvolutionOperationConstraintCreate
					|| operation instanceof DwEvolutionOperationValidityFormulaCreate) {
				constraintExplanation.addEvolutionOperationExplanation(opExplanation);
			}
			else if(operation instanceof DwEvolutionOperationGroupFeatures) {
				// only relevant if group is ALTERNATIVE
				DwEvolutionOperationGroupFeatures groupFeaturesAdded = (DwEvolutionOperationGroupFeatures) operation;
				
				if(HyFeatureEvolutionUtil.getType(groupFeaturesAdded.getGroup(), groupFeaturesAdded.getEvoStep()).getType().equals(HyGroupTypeEnum.ALTERNATIVE)) {
					constraintExplanation.addEvolutionOperationExplanation(opExplanation);
				}
			}
		}
	}
	
	public void filterRelevantFalseOptionalFeatureEvolutionOperation(AnomalyConstraintExplanation constraintExplanation) {
		List<EvolutionOperationExplanation> list = new ArrayList<EvolutionOperationExplanation>();
		list.addAll(constraintExplanation.getEvolutionOperations());
		constraintExplanation.getEvolutionOperations().clear();
		
		for (EvolutionOperationExplanation opExplanation : list) {
			DwEvolutionOperation operation = opExplanation.getEvolutionOperation();
			if (operation instanceof DwEvolutionOperationFeatureType
					|| operation instanceof DwEvolutionOperationFeatureGroup
					|| operation instanceof DwEvolutionOperationGroupType
					|| operation instanceof DwEvolutionOperationConstraintCreate
					|| operation instanceof DwEvolutionOperationValidityFormulaCreate) {
				constraintExplanation.addEvolutionOperationExplanation(opExplanation);
			}
			else if(operation instanceof DwEvolutionOperationGroupFeatures) {
				// only relevant if group is ALTERNATIVE
				DwEvolutionOperationGroupFeatures groupFeaturesAdded = (DwEvolutionOperationGroupFeatures) operation;
				
				if(HyFeatureEvolutionUtil.getType(groupFeaturesAdded.getGroup(), groupFeaturesAdded.getEvoStep()).getType().equals(HyGroupTypeEnum.ALTERNATIVE)) {
					constraintExplanation.addEvolutionOperationExplanation(opExplanation);
				}
			}
		}
	}
	
	public void filterRelevantVoidFeatureModelEvolutionOperation(AnomalyConstraintExplanation constraintExplanation) {
		List<EvolutionOperationExplanation> list = new ArrayList<EvolutionOperationExplanation>();
		list.addAll(constraintExplanation.getEvolutionOperations());
		constraintExplanation.getEvolutionOperations().clear();
		
		for (EvolutionOperationExplanation opExplanation : list) {
			DwEvolutionOperation operation = opExplanation.getEvolutionOperation();
			if (operation instanceof DwEvolutionOperationFeatureType
					|| operation instanceof DwEvolutionOperationFeatureGroup
					|| operation instanceof DwEvolutionOperationGroupType
					|| operation instanceof DwEvolutionOperationConstraintCreate
					|| operation instanceof DwEvolutionOperationValidityFormulaCreate
					|| operation instanceof DwEvolutionOperationEnumLiteralCreate) {
				constraintExplanation.addEvolutionOperationExplanation(opExplanation);
			}
			else if(operation instanceof DwEvolutionOperationGroupFeatures) {
				// only relevant if group is ALTERNATIVE
				DwEvolutionOperationGroupFeatures groupFeaturesAdded = (DwEvolutionOperationGroupFeatures) operation;
				
				if(HyFeatureEvolutionUtil.getType(groupFeaturesAdded.getGroup(), groupFeaturesAdded.getEvoStep()).getType().equals(HyGroupTypeEnum.ALTERNATIVE)) {
					constraintExplanation.addEvolutionOperationExplanation(opExplanation);
				}
			}
		}
	}
	
	// ------------- UTIL -------------
	
	public String resolveFeatureNames(String encodedString, Date date) {
		List<String> list = new ArrayList<String>();
		list.add(encodedString);
		list = DwAnalysesClient.translateIdsBackToNames(list, date, exporter);
		return list.get(0);
	}
	
	
	public List<EObject> getObjectsFromExpression(HyExpression expression) {
		List<EObject> list = new ArrayList<EObject>();
		TreeIterator<EObject> it = expression.eAllContents();
		while(it.hasNext()) {
			EObject obj = it.next();
			if (obj instanceof HyAbstractFeatureReferenceExpression) {
				list.add(((HyAbstractFeatureReferenceExpression) obj).getFeature());
			}
			if (obj instanceof HyAttributeReferenceExpression) {
				list.add(((HyAttributeReferenceExpression) obj).getAttribute());
			}
			if (obj instanceof HyContextInformationReferenceExpression) {
				list.add(((HyContextInformationReferenceExpression) obj).getContextInformation());
			}
			if (obj instanceof HyValueExpression) {
				HyValueExpression valueExpression = (HyValueExpression) obj;
				if (valueExpression.getValue() instanceof HyEnumValue) {
					list.add(((HyEnumValue) valueExpression.getValue()).getEnum());
				}
			}
		}
		return list;
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
	
	public void setFeatureAnomalies(List<DwAnomaly> anomalies){
		deadFeatureList = getDeadFeatures(anomalies);
		falseOptionalList = getFalseOptionalFeatures(anomalies);
	}

}
