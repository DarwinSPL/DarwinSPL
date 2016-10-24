package eu.hyvar.reconfigurator.input.exporter.example;

import eu.hyvar.context.HyContextInformationFactory;
import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.HyContextualInformationEnum;
import eu.hyvar.context.contextValidity.HyAttributeValidityFormula;
import eu.hyvar.context.contextValidity.HyContextValidityFactory;
import eu.hyvar.context.contextValidity.HyFeatureValidityFormula;
import eu.hyvar.context.contextValidity.HyValidityModel;
import eu.hyvar.dataValues.HyDataValuesFactory;
import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.dataValues.HyEnumValue;
import eu.hyvar.dataValues.HyNumberValue;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.HyNumberAttribute;
import eu.hyvar.feature.HyRootFeature;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.configuration.HyAttributeValueAssignment;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.HyConfigurationFactory;
import eu.hyvar.feature.configuration.HyFeatureSelected;
import eu.hyvar.feature.constraint.HyConstraint;
import eu.hyvar.feature.constraint.HyConstraintFactory;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyAndExpression;
import eu.hyvar.feature.expression.HyAttributeReferenceExpression;
import eu.hyvar.feature.expression.HyContextInformationReferenceExpression;
import eu.hyvar.feature.expression.HyEqualExpression;
import eu.hyvar.feature.expression.HyExpressionFactory;
import eu.hyvar.feature.expression.HyFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyGreaterExpression;
import eu.hyvar.feature.expression.HyImpliesExpression;
import eu.hyvar.feature.expression.HyLessOrEqualExpression;
import eu.hyvar.feature.expression.HyNestedExpression;
import eu.hyvar.feature.expression.HyValueExpression;
import eu.hyvar.feature.util.HyFeatureCreationUtil;

public class VamosExample {

	private HyFeatureModel featureModel;
	private HyConstraintModel constraintModel;
	private HyContextModel contextModel;
	private HyValidityModel contextValidityModel;
	private HyConfiguration oldConfiguration;
	
	
	public VamosExample() {

		// ------------ create Feature Model ---------------
		HyFeatureFactory featureFactory = HyFeatureFactory.eINSTANCE;
		
		HyFeatureModel featureModel = featureFactory.createHyFeatureModel();
		this.featureModel = featureModel;
		
		HyFeatureType carCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.MANDATORY, null, null, null);
		HyName carName = HyFeatureCreationUtil.createName("Car", null, null, null);
		HyFeature carFeature = HyFeatureCreationUtil.createFeature(carCardinality, carName, null, null);
		featureModel.getFeatures().add(carFeature);
		
		HyRootFeature rootFeature = HyFeatureCreationUtil.createRootFeature(carFeature, null, null, null);
		featureModel.getRootFeature().add(rootFeature);
		
		// And Group under car
		HyGroupType carGroupCardinality = HyFeatureCreationUtil.createGroupType(HyGroupTypeEnum.AND, null, null, null);
		HyGroup carGroup = HyFeatureCreationUtil.createGroup(carGroupCardinality, null, null);
		featureModel.getGroups().add(carGroup);
		
		HyFeatureChild carChild = HyFeatureCreationUtil.createFeatureChild(null, null, null);
		carChild.setParent(carFeature);
		carChild.setChildGroup(carGroup);
		
		HyGroupComposition carGroupComposition = HyFeatureCreationUtil.createGroupComposition(null, null, null);
		carGroupComposition.setCompositionOf(carGroup);
		
		// Childs of Car
		
		HyFeatureType assistanceCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.MANDATORY, null, null, null);
		HyName assistanceName = HyFeatureCreationUtil.createName("Assistance Systems", null, null, null);
		HyFeature assistanceFeature = HyFeatureCreationUtil.createFeature(assistanceCardinality, assistanceName, null, null);
		featureModel.getFeatures().add(assistanceFeature);
		
		HyFeatureType infotainmentCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.MANDATORY, null, null, null);
		HyName infotainmentName = HyFeatureCreationUtil.createName("Infotainment System", null, null, null);
		HyFeature infotainmentFeature = HyFeatureCreationUtil.createFeature(infotainmentCardinality, infotainmentName, null, null);
		featureModel.getFeatures().add(infotainmentFeature);
		
		HyFeatureType distanceSensorsCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null, null, null);
		HyName distanceSensorsName = HyFeatureCreationUtil.createName("Distance Sensors", null, null, null);
		HyFeature distanceSensorsFeature = HyFeatureCreationUtil.createFeature(distanceSensorsCardinality, distanceSensorsName, null, null);
		featureModel.getFeatures().add(distanceSensorsFeature);
		
		
		HyFeatureType emergencyCallCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.MANDATORY, null, null, null);
		HyName emergencyCallName = HyFeatureCreationUtil.createName("Emergency Call", null, null, null);
		HyFeature  emergencyCallFeature = HyFeatureCreationUtil.createFeature(emergencyCallCardinality, emergencyCallName, null, null);
		featureModel.getFeatures().add(emergencyCallFeature);
		
		HyFeatureType positionCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.MANDATORY, null, null, null);
		HyName positionName = HyFeatureCreationUtil.createName("Positioning Service", null, null, null);
		HyFeature positionFeature = HyFeatureCreationUtil.createFeature(positionCardinality, positionName, null, null);
		featureModel.getFeatures().add(positionFeature);
		

		carGroupComposition.getFeatures().add(emergencyCallFeature);
		carGroupComposition.getFeatures().add(positionFeature);
		carGroupComposition.getFeatures().add(assistanceFeature);
		carGroupComposition.getFeatures().add(distanceSensorsFeature);
		carGroupComposition.getFeatures().add(infotainmentFeature);
		

		// Child features of emergency call alternative group

		HyGroupType emergencyAlternativeCardinality = HyFeatureCreationUtil.createGroupType(HyGroupTypeEnum.ALTERNATIVE, null, null, null);
		HyGroup emergencyAlternativeGroup = HyFeatureCreationUtil.createGroup(emergencyAlternativeCardinality, null, null);
		featureModel.getGroups().add(emergencyAlternativeGroup);
		
		HyFeatureChild emergencyAlternativeChild = HyFeatureCreationUtil.createFeatureChild(null, null, null);
		emergencyAlternativeChild.setChildGroup(emergencyAlternativeGroup);
		emergencyAlternativeChild.setParent(emergencyCallFeature);
		
		HyGroupComposition emergencyAlternativeComposition = HyFeatureCreationUtil.createGroupComposition(null, null, null);
		emergencyAlternativeComposition.setCompositionOf(emergencyAlternativeGroup);
		
		
		HyFeatureType eCallEuropeCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null, null, null);
		HyName eCallEuropeName = HyFeatureCreationUtil.createName("eCall Europe", null, null, null);
		HyFeature eCallEuropeFeature = HyFeatureCreationUtil.createFeature(eCallEuropeCardinality, eCallEuropeName, null, null);
		featureModel.getFeatures().add(eCallEuropeFeature);
		
//		HyVersion eCallEuropeV1 = HyFeatureCreationUtil.createVersion("v 1.0", null, null, null);
//		eCallEuropeFeature.getVersions().add(eCallEuropeV1);
//		HyVersion eCallEuropeV11 = HyFeatureCreationUtil.createVersion("v 1.1", null, null, eCallEuropeV1);
//		eCallEuropeFeature.getVersions().add(eCallEuropeV11);
//		HyVersion eCallEuropeV2 = HyFeatureCreationUtil.createVersion("v 2.0", null, null, eCallEuropeV11);
//		eCallEuropeFeature.getVersions().add(eCallEuropeV2);
		
		HyFeatureType eraRussiaCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null, null, null);
		HyName eraRussiaName = HyFeatureCreationUtil.createName("ERA/GLONASS Russia", null, null, null);
		HyFeature eraRussiaFeature = HyFeatureCreationUtil.createFeature(eraRussiaCardinality, eraRussiaName, null, null);
		featureModel.getFeatures().add(eraRussiaFeature);
		
//		HyVersion eraNorm54620 = HyFeatureCreationUtil.createVersion("Norm 54620", null, null, null);
//		eraRussiaFeature.getVersions().add(eraNorm54620);
//		HyVersion eraNorm54620Amendment1 = HyFeatureCreationUtil.createVersion("Norm 54620 Amendment 1", null, null, eraNorm54620);
//		eraRussiaFeature.getVersions().add(eraNorm54620Amendment1);
		
		emergencyAlternativeComposition.getFeatures().add(eCallEuropeFeature);
		emergencyAlternativeComposition.getFeatures().add(eraRussiaFeature);
		
		
		// Alternative Group under position 
		HyGroupType positionAlternativeCardinality = HyFeatureCreationUtil.createGroupType(HyGroupTypeEnum.ALTERNATIVE, null, null, null);
		HyGroup positionAlternativeGroup = HyFeatureCreationUtil.createGroup(positionAlternativeCardinality, null, null);
		featureModel.getGroups().add(positionAlternativeGroup);
		
		HyFeatureChild positionAlternativeChild = HyFeatureCreationUtil.createFeatureChild(null, null, null);
		positionAlternativeChild.setChildGroup(positionAlternativeGroup);
		positionAlternativeChild.setParent(positionFeature);
		
		HyGroupComposition positionAlternativeComposition = HyFeatureCreationUtil.createGroupComposition(null, null, null);
		positionAlternativeComposition.setCompositionOf(positionAlternativeGroup);
		
		// Child feature of position alternative group
		HyFeatureType gpsCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null, null, null);
		HyName gpsName = HyFeatureCreationUtil.createName("GPS", null, null, null);
		HyFeature gpsFeature = HyFeatureCreationUtil.createFeature(gpsCardinality, gpsName, null, null);
		featureModel.getFeatures().add(gpsFeature);
		
		HyFeatureType glonassCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null, null, null);
		HyName glonassName = HyFeatureCreationUtil.createName("GLONASS", null, null, null);
		HyFeature glonassFeature = HyFeatureCreationUtil.createFeature(glonassCardinality, glonassName, null, null);
		featureModel.getFeatures().add(glonassFeature);
		
		positionAlternativeComposition.getFeatures().add(gpsFeature);
		positionAlternativeComposition.getFeatures().add(glonassFeature);
		
		// And Group under distance sensors:
		HyGroupType distanceSensorsAndGroupCardinality = HyFeatureCreationUtil.createGroupType(HyGroupTypeEnum.AND, null, null, null);
		HyGroup distanceSensorsAndGroup = HyFeatureCreationUtil.createGroup(distanceSensorsAndGroupCardinality, null, null);
		featureModel.getGroups().add(distanceSensorsAndGroup);
				
		HyFeatureChild distanceSensorsAndChild = HyFeatureCreationUtil.createFeatureChild(null, null, null);
		distanceSensorsAndChild.setParent(distanceSensorsFeature);
		distanceSensorsAndChild.setChildGroup(distanceSensorsAndGroup);
		
		HyGroupComposition distanceSensorsAndGroupComposition = HyFeatureCreationUtil.createGroupComposition(null, null, null);
		distanceSensorsAndGroupComposition.setCompositionOf(distanceSensorsAndGroup);
		
		HyFeatureType frontDistanceSensorsCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL,  null, null, null);
		HyName frontDistanceSensorsName = HyFeatureCreationUtil.createName("Front Distance Sensors",  null, null, null);
		HyFeature frontDistanceSensorsFeature = HyFeatureCreationUtil.createFeature(frontDistanceSensorsCardinality, frontDistanceSensorsName, null, null);
		featureModel.getFeatures().add(frontDistanceSensorsFeature);
		
		HyFeatureType sideCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null, null, null);
		HyName sideName = HyFeatureCreationUtil.createName("Side Distance Sensor", null, null, null);
		HyFeature sideFeature = HyFeatureCreationUtil.createFeature(sideCardinality, sideName, null, null);
		featureModel.getFeatures().add(sideFeature);
		
		distanceSensorsAndGroupComposition.getFeatures().add(sideFeature);
		distanceSensorsAndGroupComposition.getFeatures().add(frontDistanceSensorsFeature);

		// Alternative Group under Front Distance Sensors
		HyGroupType frontDistanceSensorsAlternativeGroupCardinality = HyFeatureCreationUtil.createGroupType(HyGroupTypeEnum.ALTERNATIVE, null, null, null);
		HyGroup frontDistanceSensorsAlternativeGroup = HyFeatureCreationUtil.createGroup(frontDistanceSensorsAlternativeGroupCardinality, null, null);
		featureModel.getGroups().add(frontDistanceSensorsAlternativeGroup);
		
		HyFeatureChild frontDistanceAlternativeChild = HyFeatureCreationUtil.createFeatureChild(null, null, null);
		frontDistanceAlternativeChild.setParent(frontDistanceSensorsFeature);
		frontDistanceAlternativeChild.setChildGroup(frontDistanceSensorsAlternativeGroup);
		
		HyGroupComposition frontDistanceSensorsAlternativeGroupComposition = HyFeatureCreationUtil.createGroupComposition(null, null, null);
		frontDistanceSensorsAlternativeGroupComposition.setCompositionOf(frontDistanceSensorsAlternativeGroup);
		
		HyFeatureType slowFrontDistanceCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null, null, null);
		HyName slowFrontDistanceName = HyFeatureCreationUtil.createName("Slow Front Distance Sensor", null, null, null);
		HyFeature slowFrontDistanceFeature = HyFeatureCreationUtil.createFeature(slowFrontDistanceCardinality, slowFrontDistanceName, null, null);
		featureModel.getFeatures().add(slowFrontDistanceFeature);
		
		HyFeatureType fastFrontDistanceCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null, null, null);
		HyName fastFrontDistanceName = HyFeatureCreationUtil.createName("Fast Front Distance Sensor", null, null, null);
		HyFeature fastFrontDistanceFeature = HyFeatureCreationUtil.createFeature(fastFrontDistanceCardinality, fastFrontDistanceName, null, null);
		featureModel.getFeatures().add(fastFrontDistanceFeature);
		
		frontDistanceSensorsAlternativeGroupComposition.getFeatures().add(slowFrontDistanceFeature);
		frontDistanceSensorsAlternativeGroupComposition.getFeatures().add(fastFrontDistanceFeature);
		
		// And Group under Assistance
		HyGroupType assistanceAndGroupCardinality = HyFeatureCreationUtil.createGroupType(HyGroupTypeEnum.AND, null, null, null);
		HyGroup assistanceAndGroup = HyFeatureCreationUtil.createGroup(assistanceAndGroupCardinality, null, null);
		featureModel.getGroups().add(assistanceAndGroup);
		
		HyFeatureChild assistanceAndChild = HyFeatureCreationUtil.createFeatureChild(null, null, null);
		assistanceAndChild.setParent(assistanceFeature);
		assistanceAndChild.setChildGroup(assistanceAndGroup);
		
		HyGroupComposition assistanceAndGroupComposition = HyFeatureCreationUtil.createGroupComposition(null, null, null);
		assistanceAndGroupComposition.setCompositionOf(assistanceAndGroup);
		
		// Children of Assistance And Group
		HyFeatureType parkAssistanceCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null, null, null);
		HyName parkAssistanceName = HyFeatureCreationUtil.createName("Parking Assistance", null, null, null);
		HyFeature parkAssistanceFeature = HyFeatureCreationUtil.createFeature(parkAssistanceCardinality, parkAssistanceName, null, null);
		featureModel.getFeatures().add(parkAssistanceFeature);
		
		HyFeatureType accCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.MANDATORY, null, null, null);
		HyName accName = HyFeatureCreationUtil.createName("Adaptive Cruise Control", null, null, null);
		HyFeature accFeature = HyFeatureCreationUtil.createFeature(accCardinality, accName, null, null);
		featureModel.getFeatures().add(accFeature);
		
		assistanceAndGroupComposition.getFeatures().add(parkAssistanceFeature);
		assistanceAndGroupComposition.getFeatures().add(accFeature);
		
		
		// Create new Attribute for acc feature
		HyName accMaxSpeedAttributeName = HyFeatureCreationUtil.createName("maxSpeed", null, null, null);
		HyNumberAttribute accMaxSpeedAttribute = HyFeatureCreationUtil.createNumberAttribute(accMaxSpeedAttributeName, null, null);
		accMaxSpeedAttribute.setMin(0);
		accMaxSpeedAttribute.setMax(300);		
		accFeature.getAttributes().add(accMaxSpeedAttribute);
		
		HyVersion accVersion = HyFeatureCreationUtil.createVersion("1", null, null, null);
		accFeature.getVersions().add(accVersion);	
		
		
		
		
		
		
		// --------- create constraints --------------
		HyConstraintFactory constraintFactory = HyConstraintFactory.eINSTANCE;
		HyExpressionFactory expressionFactory = HyExpressionFactory.eINSTANCE;
		HyDataValuesFactory valueFactory = HyDataValuesFactory.eINSTANCE;
		
		HyConstraintModel constraintModel = constraintFactory.createHyConstraintModel();
//		constraintModel.setFeatureModel(featureModel);
		this.constraintModel = constraintModel;
		
		// eCallEurope -> GPS
		HyConstraint eCallGPSConstraint = constraintFactory.createHyConstraint();
		HyImpliesExpression eCallGPSExpression = expressionFactory.createHyImpliesExpression();
		
		HyAbstractFeatureReferenceExpression eCallReference = expressionFactory.createHyFeatureReferenceExpression();
		eCallReference.setFeature(eCallEuropeFeature);
		HyAbstractFeatureReferenceExpression gpsReference = expressionFactory.createHyFeatureReferenceExpression();
		gpsReference.setFeature(gpsFeature);
		
		eCallGPSExpression.setOperand1(eCallReference);
		eCallGPSExpression.setOperand2(gpsReference);
		
		eCallGPSConstraint.setRootExpression(eCallGPSExpression);
		constraintModel.getConstraints().add(eCallGPSConstraint);
		
		// ERA -> Glonass
		HyConstraint eraGlonassConstraint = constraintFactory.createHyConstraint();
		HyImpliesExpression eraGlonassExpression = expressionFactory.createHyImpliesExpression();
		
		HyAbstractFeatureReferenceExpression eraReference = expressionFactory.createHyFeatureReferenceExpression();
		eraReference.setFeature(eraRussiaFeature);
		HyAbstractFeatureReferenceExpression glonassReference = expressionFactory.createHyFeatureReferenceExpression();
		glonassReference.setFeature(glonassFeature);
		
		eraGlonassExpression.setOperand1(eraReference);
		eraGlonassExpression.setOperand2(glonassReference);
		
		eraGlonassConstraint.setRootExpression(eraGlonassExpression);
		constraintModel.getConstraints().add(eraGlonassConstraint);
		
		// Parking Assistance -> Side Distance Sensor AND Front Distance Sensors
		HyConstraint parkingSdsFdsConstraint = constraintFactory.createHyConstraint();
		HyImpliesExpression parkingSdsFdsExpression = expressionFactory.createHyImpliesExpression();
		
		HyAbstractFeatureReferenceExpression parkingReference = expressionFactory.createHyFeatureReferenceExpression();
		parkingReference.setFeature(parkAssistanceFeature);
		
		HyNestedExpression nestedSdsAndFdsExpression = expressionFactory.createHyNestedExpression();
		HyAndExpression sdsAndFdsExpression = expressionFactory.createHyAndExpression();
		
		HyAbstractFeatureReferenceExpression sdsReference = expressionFactory.createHyFeatureReferenceExpression();
		sdsReference.setFeature(sideFeature);
		
		HyAbstractFeatureReferenceExpression fdsReference = expressionFactory.createHyFeatureReferenceExpression();
		fdsReference.setFeature(frontDistanceSensorsFeature);
		
		sdsAndFdsExpression.setOperand1(sdsReference);
		sdsAndFdsExpression.setOperand2(fdsReference);
		nestedSdsAndFdsExpression.setOperand(sdsAndFdsExpression);
		
		parkingSdsFdsExpression.setOperand1(parkingReference);
		parkingSdsFdsExpression.setOperand2(nestedSdsAndFdsExpression);
		
		parkingSdsFdsConstraint.setRootExpression(parkingSdsFdsExpression);
		constraintModel.getConstraints().add(parkingSdsFdsConstraint);
		
		
		// Adaptive Cruise Control -> Front Distance Sensors
		HyConstraint accFdsConstraint = constraintFactory.createHyConstraint();
		HyImpliesExpression accFdsExpression = expressionFactory.createHyImpliesExpression();
		
		HyAbstractFeatureReferenceExpression accReference = expressionFactory.createHyFeatureReferenceExpression();
		accReference.setFeature(accFeature);
		
		HyAbstractFeatureReferenceExpression fds2Reference = expressionFactory.createHyFeatureReferenceExpression();
		fds2Reference.setFeature(frontDistanceSensorsFeature);
		
		accFdsExpression.setOperand1(accReference);
		accFdsExpression.setOperand2(fds2Reference);
		
		accFdsConstraint.setRootExpression(accFdsExpression);
		constraintModel.getConstraints().add(accFdsConstraint);
		
		
		// maxSpeed <= 180 -> Slow Front Distance Sensor
		HyConstraint maxSpeedSfdsConstraint = constraintFactory.createHyConstraint();
		
		
		HyFeatureReferenceExpression sfdsReferenceExpression = expressionFactory.createHyFeatureReferenceExpression();
		sfdsReferenceExpression.setFeature(slowFrontDistanceFeature);
		
		HyLessOrEqualExpression maxSpeedLeq180Expression = expressionFactory.createHyLessOrEqualExpression();
		HyAttributeReferenceExpression maxSpeedReference = expressionFactory.createHyAttributeReferenceExpression();
		maxSpeedReference.setAttribute(accMaxSpeedAttribute);
		HyValueExpression value180Expression = expressionFactory.createHyValueExpression();
		HyNumberValue value180 = valueFactory.createHyNumberValue();
		value180.setValue(180);
		value180Expression.setValue(value180);
		maxSpeedLeq180Expression.setOperand1(maxSpeedReference);
		maxSpeedLeq180Expression.setOperand2(value180Expression);
		
		HyImpliesExpression maxSpeedSfdsExpression = expressionFactory.createHyImpliesExpression();
		maxSpeedSfdsExpression.setOperand1(maxSpeedLeq180Expression);
		maxSpeedSfdsExpression.setOperand2(sfdsReferenceExpression);
		
		HyNestedExpression maxSpeedLeq180ImplSfdsNestedExpression = expressionFactory.createHyNestedExpression();
		maxSpeedLeq180ImplSfdsNestedExpression.setOperand(maxSpeedSfdsExpression);
		
		HyFeatureReferenceExpression accReference2 = expressionFactory.createHyFeatureReferenceExpression();
		accReference2.setFeature(accMaxSpeedAttribute.getFeature());
		
		HyImpliesExpression accImplMaxSpeedLeq180 = expressionFactory.createHyImpliesExpression();
		accImplMaxSpeedLeq180.setOperand1(accReference2);
		accImplMaxSpeedLeq180.setOperand2(maxSpeedLeq180ImplSfdsNestedExpression);
		
		maxSpeedSfdsConstraint.setRootExpression(accImplMaxSpeedLeq180);
		constraintModel.getConstraints().add(maxSpeedSfdsConstraint);
		
		
		// maxSpeed > 180 -> Fast Front Distance Sensor
		HyConstraint maxSpeedFfdsConstraint = constraintFactory.createHyConstraint();
		
		HyFeatureReferenceExpression ffdsReferenceExpression = expressionFactory.createHyFeatureReferenceExpression();
		ffdsReferenceExpression.setFeature(fastFrontDistanceFeature);
		
		HyGreaterExpression maxSpeedGreater180Expression = expressionFactory.createHyGreaterExpression();
		HyAttributeReferenceExpression maxSpeedReference2 = expressionFactory.createHyAttributeReferenceExpression();
		maxSpeedReference2.setAttribute(accMaxSpeedAttribute);
		HyValueExpression value180Expression2 = expressionFactory.createHyValueExpression();
		HyNumberValue value1802 = valueFactory.createHyNumberValue();
		value1802.setValue(180);
		value180Expression2.setValue(value1802);
		maxSpeedGreater180Expression.setOperand1(maxSpeedReference2);
		maxSpeedGreater180Expression.setOperand2(value180Expression2);
		
		HyImpliesExpression maxSpeedFfdsExpression = expressionFactory.createHyImpliesExpression();
		maxSpeedFfdsExpression.setOperand1(maxSpeedGreater180Expression);
		maxSpeedFfdsExpression.setOperand2(ffdsReferenceExpression);
		
		HyNestedExpression maxSpeedGreater180NestedExpression = expressionFactory.createHyNestedExpression();
		maxSpeedGreater180NestedExpression.setOperand(maxSpeedFfdsExpression);
		
		HyFeatureReferenceExpression accReference3 = expressionFactory.createHyFeatureReferenceExpression();
		accReference3.setFeature(accFeature);
		
		HyImpliesExpression accImplMaxSpeedGreater180 = expressionFactory.createHyImpliesExpression();
				
		accImplMaxSpeedGreater180.setOperand1(accReference3);
		accImplMaxSpeedGreater180.setOperand2(maxSpeedGreater180NestedExpression);
		
		maxSpeedFfdsConstraint.setRootExpression(accImplMaxSpeedGreater180);
		constraintModel.getConstraints().add(maxSpeedFfdsConstraint);
		
		
		
		// ------------ create context model -----------------------
		HyContextInformationFactory contextFactory = HyContextInformationFactory.eINSTANCE;
		HyContextModel contextModel = contextFactory.createHyContextModel();
		this.contextModel = contextModel;

		
		// location enum
		
		HyEnum locationEnum = valueFactory.createHyEnum();
		locationEnum.setId("Location Enum");
		
		HyEnumLiteral locationEurope = valueFactory.createHyEnumLiteral();
		locationEurope.setName("Location Europe");
		locationEurope.setValue(0);
		locationEnum.getLiterals().add(locationEurope);
		
		HyEnumLiteral locationRussia = valueFactory.createHyEnumLiteral();
		locationRussia.setName("Location Russia");
		locationRussia.setValue(1);
		locationEnum.getLiterals().add(locationRussia);
		
		contextModel.getEnums().add(locationEnum);
		
		HyContextualInformationEnum locationInfo = contextFactory.createHyContextualInformationEnum();
		locationInfo.setEnumType(locationEnum);
		locationInfo.setName("Location");
		contextModel.getContextualInformations().add(locationInfo);
		
		// road consistency enum
		HyEnum roadConsistency = valueFactory.createHyEnum();
//		HyName roadConsistencyName = HyFeatureCreationUtil.createName("Road Consistency Enum", null, null, null);
		roadConsistency.setId("Road Consistency Enum");
		
		HyEnumLiteral roadDry = valueFactory.createHyEnumLiteral();
		roadDry.setName("Dry Road");
		roadDry.setValue(0);
		roadDry.setEnum(roadConsistency);
		
		HyEnumLiteral roadWet = valueFactory.createHyEnumLiteral();
		roadWet.setName("Wet Road");
		roadWet.setValue(1);
		roadWet.setEnum(roadConsistency);
		
		HyEnumLiteral roadIcy = valueFactory.createHyEnumLiteral();
		roadIcy.setName("Icy Road");
		roadIcy.setValue(2);
		roadIcy.setEnum(roadConsistency);
		
		contextModel.getEnums().add(roadConsistency);
		
		HyContextualInformationEnum roadConsistencyInfo = contextFactory.createHyContextualInformationEnum();
		roadConsistencyInfo.setEnumType(roadConsistency);
		roadConsistencyInfo.setName("Road Consistency");
		contextModel.getContextualInformations().add(roadConsistencyInfo);
		
		
		// ----------------- create context mapping ------------
		HyContextValidityFactory contextMappingFactory = HyContextValidityFactory.eINSTANCE;
		HyValidityModel contextMappingModel = contextMappingFactory.createHyValidityModel();
		this.contextValidityModel = contextMappingModel;
//		contextMappingModel.setContextModel(contextModel);
//		contextMappingModel.setFeatureModel(featureModel);
		
		// location=europe -> eCall
		HyFeatureValidityFormula europeEcallFormula = contextMappingFactory.createHyFeatureValidityFormula();
		
		HyEqualExpression locationEuropeExpression = expressionFactory.createHyEqualExpression();
		
		HyImpliesExpression locationEuropeImpliesEcall = expressionFactory.createHyImpliesExpression();
		
		HyContextInformationReferenceExpression locationReferenceExpression = expressionFactory.createHyContextInformationReferenceExpression();
		locationReferenceExpression.setContextInformation(locationInfo);
		HyValueExpression europeValueExpression = expressionFactory.createHyValueExpression();
		HyEnumValue europeValue = valueFactory.createHyEnumValue();
		europeValue.setEnumLiteral(locationEurope);
		europeValueExpression.setValue(europeValue);
		locationEuropeExpression.setOperand1(locationReferenceExpression);
		locationEuropeExpression.setOperand2(europeValueExpression);		
		
		HyFeatureReferenceExpression eCallReferenceExpression = expressionFactory.createHyFeatureReferenceExpression();
		eCallReferenceExpression.setFeature(eCallEuropeFeature);
		
		locationEuropeImpliesEcall.setOperand1(eCallReferenceExpression);
		locationEuropeImpliesEcall.setOperand2(locationEuropeExpression);
		
		europeEcallFormula.setValidityFormula(locationEuropeImpliesEcall);
		europeEcallFormula.setFeature(eCallEuropeFeature);
		contextMappingModel.getValidityFormulas().add(europeEcallFormula);
		
		// location=russia -> era
		HyFeatureValidityFormula russiaEraFormula = contextMappingFactory.createHyFeatureValidityFormula();
		
		HyImpliesExpression locationRussiaImpliesEraExpression = expressionFactory.createHyImpliesExpression();
		
		HyEqualExpression locationRussiaExpression = expressionFactory.createHyEqualExpression();
		HyContextInformationReferenceExpression locationReferenceExpression2 = expressionFactory.createHyContextInformationReferenceExpression();
		locationReferenceExpression2.setContextInformation(locationInfo);
		HyValueExpression russiaValueExpression = expressionFactory.createHyValueExpression();
		HyEnumValue russiaValue = valueFactory.createHyEnumValue();
		russiaValue.setEnumLiteral(locationRussia);
		russiaValueExpression.setValue(russiaValue);
		locationRussiaExpression.setOperand1(locationReferenceExpression2);
		locationRussiaExpression.setOperand2(russiaValueExpression);
		
		HyFeatureReferenceExpression eraReferenceExpression = expressionFactory.createHyFeatureReferenceExpression();
		eraReferenceExpression.setFeature(eraRussiaFeature);
		
		locationRussiaImpliesEraExpression.setOperand1(eraReferenceExpression);
		locationRussiaImpliesEraExpression.setOperand2(locationRussiaExpression);
		
		russiaEraFormula.setValidityFormula(locationRussiaImpliesEraExpression);
		russiaEraFormula.setFeature(eraRussiaFeature);
		contextMappingModel.getValidityFormulas().add(russiaEraFormula);
		
		
		// maxSpeed < 160 -> Wet
		HyAttributeValidityFormula wetMaxSpeedFormula = contextMappingFactory.createHyAttributeValidityFormula();
		
		HyLessOrEqualExpression maxSpeedLess160Expression = expressionFactory.createHyLessOrEqualExpression();
		HyAttributeReferenceExpression maxSpeedReference5 = expressionFactory.createHyAttributeReferenceExpression();
		maxSpeedReference5.setAttribute(accMaxSpeedAttribute);
		HyValueExpression value160Expression = expressionFactory.createHyValueExpression();
		HyNumberValue value160 = valueFactory.createHyNumberValue();
		value160.setValue(160);
		value160Expression.setValue(value160);
		maxSpeedLess160Expression.setOperand1(maxSpeedReference5);
		maxSpeedLess160Expression.setOperand2(value160Expression);		
		
		HyEqualExpression roadWetExpression = expressionFactory.createHyEqualExpression();
		HyContextInformationReferenceExpression roadReferenceExpression2 = expressionFactory.createHyContextInformationReferenceExpression();
		roadReferenceExpression2.setContextInformation(roadConsistencyInfo);
		HyValueExpression wetValueExpression = expressionFactory.createHyValueExpression();
		HyEnumValue wetValue = valueFactory.createHyEnumValue();
		wetValue.setEnumLiteral(roadWet);
		wetValueExpression.setValue(wetValue);
		roadWetExpression.setOperand1(roadReferenceExpression2);
		roadWetExpression.setOperand2(wetValueExpression);
		
		HyImpliesExpression roadWetImplMaxSpeedLeq160 = expressionFactory.createHyImpliesExpression();
		roadWetImplMaxSpeedLeq160.setOperand1(roadWetExpression);
		roadWetImplMaxSpeedLeq160.setOperand2(maxSpeedLess160Expression);
		
//		HyNestedExpression roadWetImplMaxSpeedLeq160Nested = expressionFactory.createHyNestedExpression();
//		roadWetImplMaxSpeedLeq160Nested.setOperand(roadWetImplMaxSpeedLeq160);
//		
//		HyFeatureReferenceExpression accReference4 = expressionFactory.createHyFeatureReferenceExpression();
//		accReference4.setFeature(accFeature);
//		
//		HyImpliesExpression accImplWetMaxSpeedExpression = expressionFactory.createHyImpliesExpression();
//		accImplWetMaxSpeedExpression.setOperand1(accReference4);
//		accImplWetMaxSpeedExpression.setOperand2(roadWetImplMaxSpeedLeq160Nested);
		
		wetMaxSpeedFormula.setFeature(accFeature);
		wetMaxSpeedFormula.setAttribute(accMaxSpeedAttribute);
		wetMaxSpeedFormula.setValidityFormula(roadWetImplMaxSpeedLeq160);
		contextMappingModel.getValidityFormulas().add(wetMaxSpeedFormula);
		
		
		// location russia -> maxSpeed < 110
		HyAttributeValidityFormula russiaMaxSpeedFormula = contextMappingFactory.createHyAttributeValidityFormula();
		
		HyLessOrEqualExpression maxSpeedLess110Expression = expressionFactory.createHyLessOrEqualExpression();
		HyAttributeReferenceExpression maxSpeedReference4 = expressionFactory.createHyAttributeReferenceExpression();
		maxSpeedReference4.setAttribute(accMaxSpeedAttribute);
		HyValueExpression value110Expression = expressionFactory.createHyValueExpression();
		HyNumberValue value110 = valueFactory.createHyNumberValue();
		value110.setValue(110);
		value110Expression.setValue(value110);
		maxSpeedLess110Expression.setOperand1(maxSpeedReference4);
		maxSpeedLess110Expression.setOperand2(value110Expression);
		
		HyEqualExpression locationRussiaExpression2 = expressionFactory.createHyEqualExpression();
		HyContextInformationReferenceExpression locationReferenceExpression3 = expressionFactory.createHyContextInformationReferenceExpression();
		locationReferenceExpression3.setContextInformation(locationInfo);
		HyValueExpression russiaValueExpression2 = expressionFactory.createHyValueExpression();
		HyEnumValue russiaValue2 = valueFactory.createHyEnumValue();
		russiaValue2.setEnumLiteral(locationRussia);
		russiaValueExpression2.setValue(russiaValue2);
		locationRussiaExpression2.setOperand1(locationReferenceExpression3);
		locationRussiaExpression2.setOperand2(russiaValueExpression2);
		
		HyImpliesExpression russImplMaxSpeedLeq110 = expressionFactory.createHyImpliesExpression();
		russImplMaxSpeedLeq110.setOperand1(locationRussiaExpression2);
		russImplMaxSpeedLeq110.setOperand2(maxSpeedLess110Expression);
		
//		HyNestedExpression russImplMaxSpeedLeq110Nested = expressionFactory.createHyNestedExpression();
//		russImplMaxSpeedLeq110Nested.setOperand(russImplMaxSpeedLeq110);
		
//		HyFeatureReferenceExpression accReference5 = expressionFactory.createHyFeatureReferenceExpression();
//		accReference5.setFeature(accFeature);
		
//		HyImpliesExpression accImplRussiaMaxSpeed = expressionFactory.createHyImpliesExpression();
//		accImplRussiaMaxSpeed.setOperand1(accReference5);
//		accImplRussiaMaxSpeed.setOperand2(russImplMaxSpeedLeq110Nested);
		
		russiaMaxSpeedFormula.setFeature(accFeature);
		russiaMaxSpeedFormula.setAttribute(accMaxSpeedAttribute);
		russiaMaxSpeedFormula.setValidityFormula(russImplMaxSpeedLeq110);
		contextMappingModel.getValidityFormulas().add(russiaMaxSpeedFormula);
		
		// Icy -> maxSpeed < 100
		HyAttributeValidityFormula icyMaxSpeedFormula = contextMappingFactory.createHyAttributeValidityFormula();
		
		HyLessOrEqualExpression maxSpeedLess100Expression = expressionFactory.createHyLessOrEqualExpression();
		HyAttributeReferenceExpression maxSpeedReference3 = expressionFactory.createHyAttributeReferenceExpression();
		maxSpeedReference3.setAttribute(accMaxSpeedAttribute);
		HyValueExpression value100Expression = expressionFactory.createHyValueExpression();
		HyNumberValue value100 = valueFactory.createHyNumberValue();
		value100.setValue(100);
		value100Expression.setValue(value100);
		maxSpeedLess100Expression.setOperand1(maxSpeedReference3);
		maxSpeedLess100Expression.setOperand2(value100Expression);
		
		HyEqualExpression roadIcyExpression = expressionFactory.createHyEqualExpression();
		HyContextInformationReferenceExpression roadReferenceExpression = expressionFactory.createHyContextInformationReferenceExpression();
		roadReferenceExpression.setContextInformation(roadConsistencyInfo);
		HyValueExpression icyValueExpression = expressionFactory.createHyValueExpression();
		HyEnumValue icyValue = valueFactory.createHyEnumValue();
		icyValue.setEnumLiteral(roadIcy);
		icyValueExpression.setValue(icyValue);
		roadIcyExpression.setOperand1(roadReferenceExpression);
		roadIcyExpression.setOperand2(icyValueExpression);
		
		HyImpliesExpression icyImpliesMaxSpeed = expressionFactory.createHyImpliesExpression();
		icyImpliesMaxSpeed.setOperand1(roadIcyExpression);
		icyImpliesMaxSpeed.setOperand2(maxSpeedLess100Expression);
		
//		HyNestedExpression icyImpliesMaxSpeedNested = expressionFactory.createHyNestedExpression();
//		icyImpliesMaxSpeedNested.setOperand(icyImpliesMaxSpeed);
//		
//		HyFeatureReferenceExpression accReference6 = expressionFactory.createHyFeatureReferenceExpression();
//		accReference6.setFeature(accFeature);
//		
//		HyImpliesExpression accImplIcyMaxSpeed = expressionFactory.createHyImpliesExpression();
//		accImplIcyMaxSpeed.setOperand1(accReference6);
//		accImplIcyMaxSpeed.setOperand2(icyImpliesMaxSpeedNested);
		
		icyMaxSpeedFormula.setAttribute(accMaxSpeedAttribute);
		icyMaxSpeedFormula.setValidityFormula(icyImpliesMaxSpeed);
		contextMappingModel.getValidityFormulas().add(icyMaxSpeedFormula);
		

		
		
		
		// ------- create old configuration -------
		HyConfigurationFactory configurationFactory = HyConfigurationFactory.eINSTANCE;
		HyConfiguration oldConfig = configurationFactory.createHyConfiguration();
		this.oldConfiguration = oldConfig;
		oldConfig.setFeatureModel(featureModel);
		
		HyName configName = HyFeatureCreationUtil.createName("old Configuration", null, null, null);
		oldConfig.getNames().add(configName);
		
		HyFeatureSelected carSelected = configurationFactory.createHyFeatureSelected();
		carSelected.setSelectedFeature(carFeature);
		oldConfig.getElements().add(carSelected);		
		
		HyFeatureSelected emergencyCallSelected = configurationFactory.createHyFeatureSelected();
		emergencyCallSelected.setSelectedFeature(emergencyCallFeature);
		oldConfig.getElements().add(emergencyCallSelected);
		
		HyFeatureSelected eCallSelected = configurationFactory.createHyFeatureSelected();
		eCallSelected.setSelectedFeature(eCallEuropeFeature);
		oldConfig.getElements().add(eCallSelected);
		
		HyFeatureSelected positioningServiceSelected = configurationFactory.createHyFeatureSelected();
		positioningServiceSelected.setSelectedFeature(positionFeature);
		oldConfig.getElements().add(positioningServiceSelected);
		
		HyFeatureSelected gpsSelected = configurationFactory.createHyFeatureSelected();
		gpsSelected.setSelectedFeature(gpsFeature);
		oldConfig.getElements().add(gpsSelected);
		
		HyFeatureSelected assistanceSystemsSelected = configurationFactory.createHyFeatureSelected();
		assistanceSystemsSelected.setSelectedFeature(assistanceFeature);
		oldConfig.getElements().add(assistanceSystemsSelected);
		
		HyFeatureSelected accSelected = configurationFactory.createHyFeatureSelected();
		accSelected.setSelectedFeature(accFeature);
		oldConfig.getElements().add(accSelected);
		
		HyFeatureSelected distanceSensorsSelected = configurationFactory.createHyFeatureSelected();
		distanceSensorsSelected.setSelectedFeature(distanceSensorsFeature);
		oldConfig.getElements().add(distanceSensorsSelected);
		
		HyFeatureSelected fdsSelected = configurationFactory.createHyFeatureSelected();
		fdsSelected.setSelectedFeature(frontDistanceSensorsFeature);
		oldConfig.getElements().add(fdsSelected);
		
		HyFeatureSelected ffdsSelected = configurationFactory.createHyFeatureSelected();
		ffdsSelected.setSelectedFeature(fastFrontDistanceFeature);
		oldConfig.getElements().add(ffdsSelected);
		
		HyFeatureSelected infotainmentSelected = configurationFactory.createHyFeatureSelected();
		infotainmentSelected.setSelectedFeature(infotainmentFeature);
		oldConfig.getElements().add(infotainmentSelected);
		
		// value for maxSpeed
		HyAttributeValueAssignment maxSpeedValueAssignment = configurationFactory.createHyAttributeValueAssignment();
		maxSpeedValueAssignment.setAttribute(accMaxSpeedAttribute);
		HyNumberValue value200 = valueFactory.createHyNumberValue();
		value200.setValue(200);
		maxSpeedValueAssignment.setValue(value200);
		oldConfig.getElements().add(maxSpeedValueAssignment);
	}
	
	
	
	public HyFeatureModel getFeatureModel() {
		return featureModel;
	}

	public HyConstraintModel getConstraintModel() {
		return constraintModel;
	}

	public HyContextModel getContextModel() {
		return contextModel;
	}

	public HyValidityModel getContextValidityModel() {
		return contextValidityModel;
	}

	public HyConfiguration getOldConfiguration() {
		return oldConfiguration;
	}
	
	
	
	
	
}
