package de.darwinspl.reconfigurator.client.hyvarrec;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.darwinspl.anomaly.DwAnomaly;
import de.darwinspl.anomaly.DwDeadFeatureAnomaly;
import de.darwinspl.anomaly.DwFalseOptionalFeatureAnomaly;
import de.darwinspl.anomaly.DwVoidFeatureModelAnomaly;
import de.darwinspl.anomaly.explanation.DwAnomalyExplanation;
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
import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.context.contextValidity.HyValidityFormula;
import eu.hyvar.context.contextValidity.HyValidityModel;
import eu.hyvar.dataValues.HyDataValuesFactory;
import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.dataValues.HyNumberValue;
import eu.hyvar.evolution.HyName;
import eu.hyvar.evolution.HyTemporalElement;
import eu.hyvar.feature.HyFeature;
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
import eu.hyvar.feature.expression.HyEqualExpression;
import eu.hyvar.feature.expression.HyExpression;
import eu.hyvar.feature.expression.HyExpressionFactory;
import eu.hyvar.feature.expression.HyFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyImpliesExpression;
import eu.hyvar.feature.expression.HyValueExpression;
import eu.hyvar.reconfigurator.input.exporter.HyVarRecExporter;

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
		
		// TODO: search the constraints for this cause		
		
		// possible cases:
		// 1. Mandatory     impl !Feature
		// 2. FalseOptional impl !Feature  		=> tell that the causing feature is actually itself an anomaly (possible that we need to fix that one rather than this)
		// 3. Feature		impl !Mandatory		=> would cause a VoidFeatureAnomaly, so the feature has to be dead
		// 4. Feature		impl !FalseOptional => same as 3, explanations as 2
				
		for (String constraint : anomalyExplanation.getExplanations()) {
			
			System.out.println(constraint);
			
			
			/*
			 * 
			    "feature[_03647428-60be-4985-b409-63e215b73b49] = 1",
			    "feature[_a7da77ac-6c86-4d53-91f3-0f86ce0b59c3] = 1 impl feature[_03647428-60be-4985-b409-63e215b73b49] = 1",
			    "((feature[_03647428-60be-4985-b409-63e215b73b49] = 1 impl feature[_a7da77ac-6c86-4d53-91f3-0f86ce0b59c3] = 0))",
			    "feature[_a7da77ac-6c86-4d53-91f3-0f86ce0b59c3] = 1"
			 * 
			 * 
			 */

			// TODO: have a general translation of String => HyConstraints???
			
			HyExpression expression = getExpressionFromString(constraint);
			
			
		}
	}
	protected HyExpression getExpressionFromString(String constraint) {
		HyExpression expression = null;
		StringBuilder stringBuilder = new StringBuilder(constraint);
		while (stringBuilder.length() > 0) {
			// TODO: figure out what to do with brackets
//			if (stringBuilder.toString().startsWith(HyVarRecExporter.BRACKETS_OPEN)) {
//				stringBuilder.delete(0, 1);
//			}
			if (stringBuilder.toString().startsWith(HyVarRecExporter.BRACKETS_CLOSING)) {
				stringBuilder.delete(0, 1);
			} else {
				expression = resolveExpressionFromString(stringBuilder, expression);
			}
		}
		return expression;
	}
	
	protected HyExpression resolveExpressionFromString(StringBuilder constraint, HyExpression leftExpression) {

		// TODO: check whether this is the right usage for brackets
		if (constraint.toString().startsWith(HyVarRecExporter.BRACKETS_OPEN)) {
			constraint.delete(0, 1);
			leftExpression = resolveExpressionFromString(constraint, null);
		}
		if (constraint.toString().startsWith(HyVarRecExporter.BRACKETS_CLOSING)) {
			constraint.delete(0, 1);
		}

		if (constraint.toString().startsWith(HyVarRecExporter.FEATURE_ATOM)) {
			for (HyFeature feature : client.exporter.getFeatureReconfiguratorIdMapping().keySet()) {
				String featureString = client.exporter.getFeatureReconfiguratorIdMapping().get(feature);
				if (constraint.toString().startsWith(featureString)) {
					HyFeatureReferenceExpression featureReference = HyExpressionFactory.eINSTANCE.createHyFeatureReferenceExpression();
					featureReference.setFeature(feature);
					constraint.delete(0, featureString.length());
					return featureReference;
				}
			}
		}
		else if (constraint.toString().startsWith(HyVarRecExporter.EQUALS)) {
			HyEqualExpression expression = HyExpressionFactory.eINSTANCE.createHyEqualExpression();
			expression.setOperand1(leftExpression);
			constraint.delete(0, HyVarRecExporter.EQUALS.length());
			expression.setOperand2(resolveExpressionFromString(constraint, null));
			return expression;
		}
		else if (constraint.toString().startsWith(HyVarRecExporter.IMPLICATION)) {
			HyImpliesExpression expression = HyExpressionFactory.eINSTANCE.createHyImpliesExpression();
			expression.setOperand1(leftExpression);
			constraint.delete(0, HyVarRecExporter.IMPLICATION.length());
			expression.setOperand2(resolveExpressionFromString(constraint, null));
			return expression;
		}
		else if (constraint.toString().startsWith("0")) {
			// TODO: FIX ME FML
			HyNumberValue value = HyDataValuesFactory.eINSTANCE.createHyNumberValue();
			value.setValue(Integer.valueOf("0"));
			HyValueExpression valueExpression = HyExpressionFactory.eINSTANCE.createHyValueExpression();
			valueExpression.setValue(value);
			constraint.delete(0, 1);
			return valueExpression;
		}
		else if (constraint.toString().startsWith("1")) {
			// TODO: FIX ME FML
			HyNumberValue value = HyDataValuesFactory.eINSTANCE.createHyNumberValue();
			value.setValue(Integer.valueOf("1"));
			HyValueExpression valueExpression = HyExpressionFactory.eINSTANCE.createHyValueExpression();
			valueExpression.setValue(value);
			constraint.delete(0, 1);
			return valueExpression;
		}
		return null;
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
	
	
	
	// ------------- UTIL -------------
	
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
	
	public boolean isElementValid(HyTemporalElement element, Date date) {
		if ((element.getValidSince() == null || element.getValidSince().compareTo(date) <= 0) &&
			(element.getValidUntil() == null || element.getValidUntil().compareTo(date) > 0)) {
			return true;
		}
		return false;
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
