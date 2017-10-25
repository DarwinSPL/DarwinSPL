package eu.hyvar.feature.example_creation.examples;

import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.hyvar.context.HyContextInformationFactory;
import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.HyContextualInformationEnum;
import eu.hyvar.context.HyContextualInformationNumber;
import eu.hyvar.context.contextValidity.HyAttributeValidityFormula;
import eu.hyvar.context.contextValidity.HyContextValidityFactory;
import eu.hyvar.context.contextValidity.HyFeatureValidityFormula;
import eu.hyvar.context.contextValidity.HyValidityModel;
import eu.hyvar.dataValues.HyBooleanValue;
import eu.hyvar.dataValues.HyDataValuesFactory;
import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.dataValues.HyEnumValue;
import eu.hyvar.dataValues.HyNumberValue;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyBooleanAttribute;
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
import eu.hyvar.feature.configuration.HyVersionSelected;
import eu.hyvar.feature.constraint.HyConstraint;
import eu.hyvar.feature.constraint.HyConstraintFactory;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.expression.HyAttributeReferenceExpression;
import eu.hyvar.feature.expression.HyContextInformationReferenceExpression;
import eu.hyvar.feature.expression.HyEqualExpression;
import eu.hyvar.feature.expression.HyExpressionFactory;
import eu.hyvar.feature.expression.HyFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyGreaterOrEqualExpression;
import eu.hyvar.feature.expression.HyIfPossibleExpression;
import eu.hyvar.feature.expression.HyImpliesExpression;
import eu.hyvar.feature.expression.HyLessExpression;
import eu.hyvar.feature.expression.HyLessOrEqualExpression;
import eu.hyvar.feature.expression.HyMaximumExpression;
import eu.hyvar.feature.expression.HyNestedExpression;
import eu.hyvar.feature.expression.HyRelativeVersionRestriction;
import eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator;
import eu.hyvar.feature.expression.HyValueExpression;
import eu.hyvar.feature.mapping.HyMappingModel;
import eu.hyvar.feature.util.HyFeatureCreationUtil;
import de.darwinspl.preferences.DwPreference;
import de.darwinspl.preferences.DwProfile;
import de.darwinspl.preferences.PreferencesFactory;

public class IsolaExample extends HyFMExample {

	@Override
	public HyFeatureModel createExample() {

//		ProfileEnum profile = ProfileEnum.ECO;
		
		// ------------ create Feature Model ---------------
		HyFeatureFactory featureFactory = HyFeatureFactory.eINSTANCE;

		HyFeatureModel featureModel = featureFactory.createHyFeatureModel();

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

		// Children of Car

		HyFeatureType engineCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.MANDATORY, null, null, null);
		HyName engineName = HyFeatureCreationUtil.createName("Engine Profile", null, null, null);
		HyFeature engineFeature = HyFeatureCreationUtil.createFeature(engineCardinality, engineName, null, null);
		featureModel.getFeatures().add(engineFeature);

		HyFeatureType gearCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.MANDATORY, null, null, null);
		HyName gearName = HyFeatureCreationUtil.createName("Gear Shift", null, null, null);
		HyFeature gearFeature = HyFeatureCreationUtil.createFeature(gearCardinality, gearName, null, null);
		featureModel.getFeatures().add(gearFeature);

		HyFeatureType cruiseControlCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null, null, null);
		HyName cruiseControlName = HyFeatureCreationUtil.createName("Cruise Control", null, null, null);
		HyFeature cruiseControlFeature = HyFeatureCreationUtil.createFeature(cruiseControlCardinality,
				cruiseControlName, null, null);
		featureModel.getFeatures().add(cruiseControlFeature);

		HyFeatureType laneAssistCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null, null, null);
		HyName laneAssistName = HyFeatureCreationUtil.createName("Lane Assist", null, null, null);
		HyFeature laneAssistFeature = HyFeatureCreationUtil.createFeature(laneAssistCardinality, laneAssistName, null,
				null);
		featureModel.getFeatures().add(laneAssistFeature);

		HyFeatureType parkingSpotDetectorCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null, null, null);
		HyName parkingSpotDetectorName = HyFeatureCreationUtil.createName("Parking Spot Detector", null, null, null);
		HyFeature parkingSpotDetectorFeature = HyFeatureCreationUtil.createFeature(parkingSpotDetectorCardinality,
				parkingSpotDetectorName, null, null);
		featureModel.getFeatures().add(parkingSpotDetectorFeature);

		HyFeatureType headsUpCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null, null, null);
		HyName headsUpName = HyFeatureCreationUtil.createName("Heads Up Display", null, null, null);
		HyFeature headsUpFeature = HyFeatureCreationUtil.createFeature(headsUpCardinality, headsUpName, null, null);
		featureModel.getFeatures().add(headsUpFeature);

		HyFeatureType ambientLightingCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null, null, null);
		HyName ambientLightingName = HyFeatureCreationUtil.createName("Ambient Lighting", null, null, null);
		HyFeature ambientLightingFeature = HyFeatureCreationUtil.createFeature(ambientLightingCardinality,
				ambientLightingName, null, null);
		featureModel.getFeatures().add(ambientLightingFeature);

		carGroupComposition.getFeatures().add(engineFeature);
		carGroupComposition.getFeatures().add(gearFeature);
		carGroupComposition.getFeatures().add(cruiseControlFeature);
		carGroupComposition.getFeatures().add(laneAssistFeature);
		carGroupComposition.getFeatures().add(parkingSpotDetectorFeature);
		carGroupComposition.getFeatures().add(headsUpFeature);
		carGroupComposition.getFeatures().add(ambientLightingFeature);

		// Versions of features
		HyVersion laneAssistV10 = HyFeatureCreationUtil.createVersion("1.0", null, null, null);
		laneAssistFeature.getVersions().add(laneAssistV10);
		HyVersion laneAssistV20 = HyFeatureCreationUtil.createVersion("2.0", null, null, laneAssistV10);
		laneAssistFeature.getVersions().add(laneAssistV20);

		HyVersion headsUp10 = HyFeatureCreationUtil.createVersion("1.0", null, null, null);
		headsUpFeature.getVersions().add(headsUp10);
		HyVersion headsUp11 = HyFeatureCreationUtil.createVersion("1.1", null, null, headsUp10);
		headsUpFeature.getVersions().add(headsUp11);
		HyVersion headsUp20 = HyFeatureCreationUtil.createVersion("2.0", null, null, headsUp11);
		headsUpFeature.getVersions().add(headsUp20);
		// HyVersion headsUp30 = HyFeatureCreationUtil.createVersion("3.0",
		// null, null, headsUp20);
		// headsUpFeature.getVersions().add(headsUp30);
		
		// Attribute of HUD
		HyName nightModeName = HyFeatureCreationUtil.createName("nightMode", null, null, null);
		HyBooleanAttribute nightMode = HyFeatureCreationUtil.createBooleanAttribute(null, null, nightModeName);
		nightMode.setDefault(false);
		nightMode.setFeature(headsUpFeature);

		// Attribute of Cruise Control
		HyName maxSpeedName = HyFeatureCreationUtil.createName("maxSpeed", null, null, null);
		HyNumberAttribute maxSpeedAttribute = HyFeatureCreationUtil.createNumberAttribute(maxSpeedName, null, null);
		maxSpeedAttribute.setFeature(cruiseControlFeature);
		maxSpeedAttribute.setMin(0);
		maxSpeedAttribute.setMax(300);

		// Alternative Group under engine profile
		HyGroupType engineGroupCardinality = HyFeatureCreationUtil.createGroupType(HyGroupTypeEnum.ALTERNATIVE, null, null, null);
		HyGroup engineGroup = HyFeatureCreationUtil.createGroup(engineGroupCardinality, null, null);
		featureModel.getGroups().add(engineGroup);

		HyFeatureChild engineChild = HyFeatureCreationUtil.createFeatureChild(null, null, null);
		engineChild.setParent(engineFeature);
		engineChild.setChildGroup(engineGroup);

		HyGroupComposition engineGroupComposition = HyFeatureCreationUtil.createGroupComposition(null, null, null);
		engineGroupComposition.setCompositionOf(engineGroup);

		// Children of engine profile

		HyFeatureType conservativeCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null, null, null);
		HyName conservativeName = HyFeatureCreationUtil.createName("Conservative", null, null, null);
		HyFeature conservativeFeature = HyFeatureCreationUtil.createFeature(conservativeCardinality, conservativeName,
				null, null);
		featureModel.getFeatures().add(conservativeFeature);

		HyFeatureType neutralCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null, null, null);
		HyName neutralName = HyFeatureCreationUtil.createName("Neutral", null, null, null);
		HyFeature neutralFeature = HyFeatureCreationUtil.createFeature(neutralCardinality, neutralName, null, null);
		featureModel.getFeatures().add(neutralFeature);

		HyFeatureType progressiveCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null, null, null);
		HyName progressiveName = HyFeatureCreationUtil.createName("Progressive", null, null, null);
		HyFeature progressiveFeature = HyFeatureCreationUtil.createFeature(progressiveCardinality, progressiveName,
				null, null);
		featureModel.getFeatures().add(progressiveFeature);

		engineGroupComposition.getFeatures().add(conservativeFeature);
		engineGroupComposition.getFeatures().add(neutralFeature);
		engineGroupComposition.getFeatures().add(progressiveFeature);

		// Alternative Group under gear
		HyGroupType gearGroupCardinality = HyFeatureCreationUtil.createGroupType(HyGroupTypeEnum.ALTERNATIVE, null, null, null);
		HyGroup gearGroup = HyFeatureCreationUtil.createGroup(gearGroupCardinality, null, null);
		featureModel.getGroups().add(gearGroup);

		HyFeatureChild gearChild = HyFeatureCreationUtil.createFeatureChild(null, null, null);
		gearChild.setParent(gearFeature);
		gearChild.setChildGroup(gearGroup);

		HyGroupComposition gearGroupComposition = HyFeatureCreationUtil.createGroupComposition(null, null, null);
		gearGroupComposition.setCompositionOf(gearGroup);

		// Children of gear
		HyFeatureType manualCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null, null, null);
		HyName manualName = HyFeatureCreationUtil.createName("Manual", null, null, null);
		HyFeature manualFeature = HyFeatureCreationUtil.createFeature(manualCardinality, manualName, null, null);
		featureModel.getFeatures().add(manualFeature);

		HyFeatureType automaticCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null, null, null);
		HyName automaticName = HyFeatureCreationUtil.createName("Automatic", null, null, null);
		HyFeature automaticFeature = HyFeatureCreationUtil.createFeature(automaticCardinality, automaticName, null,
				null);
		featureModel.getFeatures().add(automaticFeature);

		gearGroupComposition.getFeatures().add(manualFeature);
		gearGroupComposition.getFeatures().add(automaticFeature);

		// Alternative Group under ambient lighting
		HyGroupType ambientLightingGroupCardinality = HyFeatureCreationUtil.createGroupType(HyGroupTypeEnum.ALTERNATIVE, null, null, null);
		HyGroup ambientLightingGroup = HyFeatureCreationUtil.createGroup(ambientLightingGroupCardinality, null, null);
		featureModel.getGroups().add(ambientLightingGroup);

		HyFeatureChild ambientLightingChild = HyFeatureCreationUtil.createFeatureChild(null, null, null);
		ambientLightingChild.setParent(ambientLightingFeature);
		ambientLightingChild.setChildGroup(ambientLightingGroup);

		HyGroupComposition ambientLightingGroupComposition = HyFeatureCreationUtil.createGroupComposition(null, null,
				null);
		ambientLightingGroupComposition.setCompositionOf(ambientLightingGroup);

		// Children of Ambient lighting
		HyFeatureType greenCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null, null, null);
		HyName greenName = HyFeatureCreationUtil.createName("Green", null, null, null);
		HyFeature greenFeature = HyFeatureCreationUtil.createFeature(greenCardinality, greenName, null, null);
		featureModel.getFeatures().add(greenFeature);

		HyFeatureType whiteCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null, null, null);
		HyName whiteName = HyFeatureCreationUtil.createName("White", null, null, null);
		HyFeature whiteFeature = HyFeatureCreationUtil.createFeature(whiteCardinality, whiteName, null, null);
		featureModel.getFeatures().add(whiteFeature);

		HyFeatureType redCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null, null, null);
		HyName redName = HyFeatureCreationUtil.createName("Red", null, null, null);
		HyFeature redFeature = HyFeatureCreationUtil.createFeature(redCardinality, redName, null, null);
		featureModel.getFeatures().add(redFeature);

		ambientLightingGroupComposition.getFeatures().add(greenFeature);
		ambientLightingGroupComposition.getFeatures().add(whiteFeature);
		ambientLightingGroupComposition.getFeatures().add(redFeature);

		// --------- create constraints --------------
		HyConstraintFactory constraintFactory = HyConstraintFactory.eINSTANCE;
		HyExpressionFactory expressionFactory = HyExpressionFactory.eINSTANCE;
		HyDataValuesFactory valueFactory = HyDataValuesFactory.eINSTANCE;
		HyConstraintModel constraintModel = constraintFactory.createHyConstraintModel();
//		constraintModel.setFeatureModel(featureModel);
		this.constraintModel = constraintModel;

		// Conservative -> Automatic
		HyConstraint conservativeAutomaticConstraint = constraintFactory.createHyConstraint();
		HyImpliesExpression conservativeAutomaticExpression = expressionFactory.createHyImpliesExpression();

		HyFeatureReferenceExpression conservativeReference = expressionFactory.createHyFeatureReferenceExpression();
		conservativeReference.setFeature(conservativeFeature);
		HyFeatureReferenceExpression automaticReference = expressionFactory.createHyFeatureReferenceExpression();
		automaticReference.setFeature(automaticFeature);

		conservativeAutomaticExpression.setOperand1(conservativeReference);
		conservativeAutomaticExpression.setOperand2(automaticReference);

		conservativeAutomaticConstraint.setRootExpression(conservativeAutomaticExpression);

		constraintModel.getConstraints().add(conservativeAutomaticConstraint);

		// Parking Spot Detector -> HeadsUpDisplay[>=2.0]
		HyConstraint parkingSpotHeadsUpConstraint = constraintFactory.createHyConstraint();
		HyImpliesExpression parkingSpotHeadsUpExpression = expressionFactory.createHyImpliesExpression();

		HyFeatureReferenceExpression headsUpBigger20Reference = expressionFactory.createHyFeatureReferenceExpression();
		headsUpBigger20Reference.setFeature(headsUpFeature);
		HyRelativeVersionRestriction hudBigger20 = expressionFactory.createHyRelativeVersionRestriction();
		hudBigger20.setOperator(HyRelativeVersionRestrictionOperator.GREATER_THAN_OR_EQUAL);
		hudBigger20.setVersion(headsUp20);
		hudBigger20.setRestrictedFeatureReferenceExpression(headsUpBigger20Reference);

		HyFeatureReferenceExpression parkingSpotReference = expressionFactory.createHyFeatureReferenceExpression();
		parkingSpotReference.setFeature(parkingSpotDetectorFeature);

		parkingSpotHeadsUpExpression.setOperand1(parkingSpotReference);
		parkingSpotHeadsUpExpression.setOperand2(headsUpBigger20Reference);

		parkingSpotHeadsUpConstraint.setRootExpression(parkingSpotHeadsUpExpression);
		constraintModel.getConstraints().add(parkingSpotHeadsUpConstraint);

		// laneAssist[>=2.0] -> HUD[>=2.0]
		HyConstraint laneAssistHeadsUpConstraint = constraintFactory.createHyConstraint();
		HyImpliesExpression laneAssistHeadsUpExpression = expressionFactory.createHyImpliesExpression();

		HyFeatureReferenceExpression laneAssistGEQV2Reference = expressionFactory.createHyFeatureReferenceExpression();
		laneAssistGEQV2Reference.setFeature(laneAssistFeature);
		HyRelativeVersionRestriction laneAssistBigger20 = expressionFactory.createHyRelativeVersionRestriction();
		laneAssistBigger20.setOperator(HyRelativeVersionRestrictionOperator.GREATER_THAN_OR_EQUAL);
		laneAssistBigger20.setRestrictedFeatureReferenceExpression(laneAssistGEQV2Reference);
		laneAssistBigger20.setVersion(laneAssistV20);

		laneAssistHeadsUpExpression.setOperand1(laneAssistGEQV2Reference);
		laneAssistHeadsUpExpression.setOperand2(EcoreUtil.copy(headsUpBigger20Reference));

		laneAssistHeadsUpConstraint.setRootExpression(laneAssistHeadsUpExpression);

		constraintModel.getConstraints().add(laneAssistHeadsUpConstraint);

		// ------------ create context model -----------------------
		HyContextInformationFactory contextFactory = HyContextInformationFactory.eINSTANCE;
		HyContextModel contextModel = contextFactory.createHyContextModel();
		this.contextModel = contextModel;

		// location enum		
		HyEnum weatherEnum = valueFactory.createHyEnum();
		weatherEnum.setId("WeatherEnum");
		contextModel.getEnums().add(weatherEnum);
		
		HyEnumLiteral sunnyLiteral = valueFactory.createHyEnumLiteral();
		sunnyLiteral.setName("Sunny");
		sunnyLiteral.setValue(0);
		weatherEnum.getLiterals().add(sunnyLiteral);
		
		HyEnumLiteral rainyLiteral = valueFactory.createHyEnumLiteral();
		rainyLiteral.setName("Rainy");
		rainyLiteral.setValue(1);
		weatherEnum.getLiterals().add(rainyLiteral);
		
		HyContextualInformationEnum weather = contextFactory.createHyContextualInformationEnum();
		weather.setEnumType(weatherEnum);
		weather.setName("Weather");
		
		contextModel.getContextualInformations().add(weather);

		// Pollution level
		HyContextualInformationNumber pollutionLevel = contextFactory.createHyContextualInformationNumber();
		pollutionLevel.setName("Pollution Level");
		pollutionLevel.setMin(0);
		pollutionLevel.setMax(100);
		contextModel.getContextualInformations().add(pollutionLevel);
		
		// #passengers
		HyContextualInformationNumber numberOfPassengers = contextFactory.createHyContextualInformationNumber();
		numberOfPassengers.setName("Number of Passengers");
		numberOfPassengers.setMin(0);
		numberOfPassengers.setMax(10);
		contextModel.getContextualInformations().add(numberOfPassengers);
		
		// Hour of the day
		HyContextualInformationNumber hourOfDay = contextFactory.createHyContextualInformationNumber();
		hourOfDay.setName("Hour of the Day");
		hourOfDay.setMin(0);
		hourOfDay.setMax(23);
		contextModel.getContextualInformations().add(hourOfDay);

		// ----------------- create context mapping ------------
		HyContextValidityFactory contextMappingFactory = HyContextValidityFactory.eINSTANCE;
		HyValidityModel contextMappingModel = contextMappingFactory.createHyValidityModel();
		this.contextValidityModel = contextMappingModel;
//		contextMappingModel.setContextModel(contextModel);
//		contextMappingModel.setFeatureModel(featureModel);

//		// Corfu -> maxSpeed <= 120
//		HyAttributeValidityFormula corfuMaxSpeed = contextMappingFactory.createHyAttributeValidityFormula();
//
//		HyLessOrEqualExpression maxSpeedLEQ120Expression = expressionFactory.createHyLessOrEqualExpression();
//		HyAttributeReferenceExpression maxSpeedReference = expressionFactory.createHyAttributeReferenceExpression();
//		maxSpeedReference.setAttribute(maxSpeedAttribute);
//		HyValueExpression value120Expression = expressionFactory.createHyValueExpression();
//		HyNumberValue value120 = valueFactory.createHyNumberValue();
//		value120.setValue(120);
//		value120Expression.setValue(value120);
//		maxSpeedLEQ120Expression.setOperand1(maxSpeedReference);
//		maxSpeedLEQ120Expression.setOperand2(value120Expression);
//
//		HyEqualExpression locationCorfuExpression = expressionFactory.createHyEqualExpression();
//		HyContextInformationReferenceExpression locationReferenceExpression = expressionFactory
//				.createHyContextInformationReferenceExpression();
//		locationReferenceExpression.setContextInformation(locationInfo);
//		HyValueExpression corfuValueExpression = expressionFactory.createHyValueExpression();
//		HyEnumValue corfuValue = valueFactory.createHyEnumValue();
//		corfuValue.setEnumLiteral(locationCorfu);
//		corfuValueExpression.setValue(corfuValue);
//		locationCorfuExpression.setOperand1(locationReferenceExpression);
//		locationCorfuExpression.setOperand2(corfuValueExpression);
//
//		HyImpliesExpression corfuImpliesMaxSpeed = expressionFactory.createHyImpliesExpression();
//		corfuImpliesMaxSpeed.setOperand1(locationCorfuExpression);
//		corfuImpliesMaxSpeed.setOperand2(maxSpeedLEQ120Expression);
//
//		HyNestedExpression corfuMaxSpeedNested = expressionFactory.createHyNestedExpression();
//		corfuMaxSpeedNested.setOperand(corfuImpliesMaxSpeed);
//
//		HyFeatureReferenceExpression cruiseControlReference = expressionFactory.createHyFeatureReferenceExpression();
//		cruiseControlReference.setFeature(cruiseControlFeature);
//
//		HyImpliesExpression cruiseControlCorfuMaxSpeedExpression = expressionFactory.createHyImpliesExpression();
//		cruiseControlCorfuMaxSpeedExpression.setOperand1(cruiseControlReference);
//		cruiseControlCorfuMaxSpeedExpression.setOperand2(corfuMaxSpeedNested);
//
//		corfuMaxSpeed.setAttribute(maxSpeedAttribute);
//		corfuMaxSpeed.setValidityFormula(cruiseControlCorfuMaxSpeedExpression);
//		contextMappingModel.getValidityFormulas().add(corfuMaxSpeed);

		// Rainy -> maxSpeed <= 80
		HyAttributeValidityFormula rainyMaxSpeed = contextMappingFactory.createHyAttributeValidityFormula();

		HyLessOrEqualExpression maxSpeedLEQ80Expression = expressionFactory.createHyLessOrEqualExpression();
		HyValueExpression value80Expression = expressionFactory.createHyValueExpression();
		HyNumberValue value80 = valueFactory.createHyNumberValue();
		value80.setValue(80);
		value80Expression.setValue(value80);
		HyAttributeReferenceExpression maxSpeedReference = expressionFactory.createHyAttributeReferenceExpression();
		maxSpeedReference.setAttribute(maxSpeedAttribute);
		maxSpeedLEQ80Expression.setOperand1(maxSpeedReference);
		maxSpeedLEQ80Expression.setOperand2(value80Expression);

		HyEqualExpression weatherRainyExpression = expressionFactory.createHyEqualExpression();
		HyContextInformationReferenceExpression weatherReferenceExpression = expressionFactory
				.createHyContextInformationReferenceExpression();
		weatherReferenceExpression.setContextInformation(weather);
		HyValueExpression rainyExpression = expressionFactory.createHyValueExpression();
		HyEnumValue rainyValue = valueFactory.createHyEnumValue();
		rainyValue.setEnumLiteral(rainyLiteral);
		rainyExpression.setValue(rainyValue);
		weatherRainyExpression.setOperand1(weatherReferenceExpression);
		weatherRainyExpression.setOperand2(rainyExpression);

		HyImpliesExpression rainyImpliesMaxSpeed = expressionFactory.createHyImpliesExpression();
		rainyImpliesMaxSpeed.setOperand1(weatherRainyExpression);
		rainyImpliesMaxSpeed.setOperand2(maxSpeedLEQ80Expression);

//		HyNestedExpression rainyMaxSpeedNested = expressionFactory.createHyNestedExpression();
//		rainyMaxSpeedNested.setOperand(rainyImpliesMaxSpeed);
//
//		HyImpliesExpression cruiseControlRainyMaxSpeedExpression = expressionFactory.createHyImpliesExpression();
		HyFeatureReferenceExpression cruiseControlReference = expressionFactory.createHyFeatureReferenceExpression();
		cruiseControlReference.setFeature(cruiseControlFeature);
//		cruiseControlRainyMaxSpeedExpression.setOperand1(cruiseControlReference);
//		cruiseControlRainyMaxSpeedExpression.setOperand2(rainyMaxSpeedNested);

		rainyMaxSpeed.setFeature(cruiseControlFeature);
		rainyMaxSpeed.setAttribute(maxSpeedAttribute);
		rainyMaxSpeed.setValidityFormula(rainyImpliesMaxSpeed);
		contextMappingModel.getValidityFormulas().add(rainyMaxSpeed);

		// Pollution >= 50 -> Eco (Conservative, Green, Automatic) (Opposite has
		// to be modeled! Validity (e.g., Progressive -> Pollution < 50)
		// (Neutral, Progressive, White, Red, Manual)

		// Pollution < 50
		HyLessExpression pollutionLess50Expression = expressionFactory.createHyLessExpression();
		HyContextInformationReferenceExpression pollutionReference = expressionFactory
				.createHyContextInformationReferenceExpression();
		pollutionReference.setContextInformation(pollutionLevel);
		HyNumberValue value50 = valueFactory.createHyNumberValue();
		value50.setValue(50);
		HyValueExpression value50Expression = expressionFactory.createHyValueExpression();
		value50Expression.setValue(value50);
		pollutionLess50Expression.setOperand1(pollutionReference);
		pollutionLess50Expression.setOperand2(value50Expression);

		// Neutral -> Pollution<50
		HyFeatureValidityFormula neutralPollutionFormula = contextMappingFactory.createHyFeatureValidityFormula();
		HyFeatureReferenceExpression neutralReference = expressionFactory.createHyFeatureReferenceExpression();
		neutralReference.setFeature(neutralFeature);
//		
//		HyImpliesExpression neutralImpliesPollution = expressionFactory.createHyImpliesExpression();
//		neutralImpliesPollution.setOperand1(neutralReference);
//		neutralImpliesPollution.setOperand2(EcoreUtil.copy(pollutionLess50Expression));
		
		neutralPollutionFormula.setValidityFormula(pollutionLess50Expression);
		neutralPollutionFormula.setFeature(neutralFeature);
		contextMappingModel.getValidityFormulas().add(neutralPollutionFormula);

		// Progressive -> Pollution<50
		HyFeatureValidityFormula progressivePollutionFormula = contextMappingFactory.createHyFeatureValidityFormula();
		HyFeatureReferenceExpression progressiveReference = expressionFactory.createHyFeatureReferenceExpression();
		progressiveReference.setFeature(progressiveFeature);
//		HyImpliesExpression progressiveImpliesPollution = expressionFactory.createHyImpliesExpression();
//		progressiveImpliesPollution.setOperand1(progressiveReference);
//		progressiveImpliesPollution.setOperand2(EcoreUtil.copy(pollutionLess50Expression));
		
		progressivePollutionFormula.setValidityFormula(EcoreUtil.copy(pollutionLess50Expression));
		progressivePollutionFormula.setFeature(progressiveFeature);
		contextMappingModel.getValidityFormulas().add(progressivePollutionFormula);

		// White -> Pollution<50
		HyFeatureValidityFormula whitePollutionFormula = contextMappingFactory.createHyFeatureValidityFormula();
		HyFeatureReferenceExpression whiteReference = expressionFactory.createHyFeatureReferenceExpression();
		whiteReference.setFeature(whiteFeature);
//		HyImpliesExpression whiteImpliesPollution = expressionFactory.createHyImpliesExpression();
//		whiteImpliesPollution.setOperand1(whiteReference);
//		whiteImpliesPollution.setOperand2(EcoreUtil.copy(pollutionLess50Expression));
		
		whitePollutionFormula.setValidityFormula(EcoreUtil.copy(pollutionLess50Expression));
		whitePollutionFormula.setFeature(whiteFeature);
		contextMappingModel.getValidityFormulas().add(whitePollutionFormula);

		// Red -> Pollution<50
		HyFeatureValidityFormula redPollutionFormula = contextMappingFactory.createHyFeatureValidityFormula();
		HyFeatureReferenceExpression redReference = expressionFactory.createHyFeatureReferenceExpression();
		redReference.setFeature(redFeature);
//		HyImpliesExpression redImpliesPollution = expressionFactory.createHyImpliesExpression();
//		redImpliesPollution.setOperand1(redReference);
//		redImpliesPollution.setOperand2(EcoreUtil.copy(pollutionLess50Expression));
		
		redPollutionFormula.setValidityFormula(EcoreUtil.copy(pollutionLess50Expression));
		redPollutionFormula.setFeature(redFeature);
		contextMappingModel.getValidityFormulas().add(redPollutionFormula);

		// Manual -> Pollution<50
		HyFeatureValidityFormula manualPollutionFormula = contextMappingFactory.createHyFeatureValidityFormula();
		
		HyFeatureReferenceExpression manualReference = expressionFactory.createHyFeatureReferenceExpression();
		manualReference.setFeature(manualFeature);
//		HyImpliesExpression manualImpliesPollution = expressionFactory.createHyImpliesExpression();
//		manualImpliesPollution.setOperand1(manualReference);
//		manualImpliesPollution.setOperand2(EcoreUtil.copy(pollutionLess50Expression));
		
		manualPollutionFormula.setValidityFormula(EcoreUtil.copy(pollutionLess50Expression));
		manualPollutionFormula.setFeature(manualFeature);
		contextMappingModel.getValidityFormulas().add(manualPollutionFormula);
		
		// Time >= 18 -> nightMode = true
		HyAttributeValidityFormula hourOfTheDayNightMode = contextMappingFactory.createHyAttributeValidityFormula();

		HyContextInformationReferenceExpression hourOfTheDayReference = expressionFactory.createHyContextInformationReferenceExpression();
		hourOfTheDayReference.setContextInformation(hourOfDay);		
		HyValueExpression value18Expression = expressionFactory.createHyValueExpression();
		HyNumberValue value18 = valueFactory.createHyNumberValue();
		value18.setValue(18);
		value18Expression.setValue(value18);
		HyGreaterOrEqualExpression hourOfTheDayGEQ18Expression = expressionFactory.createHyGreaterOrEqualExpression();
		hourOfTheDayGEQ18Expression.setOperand1(hourOfTheDayReference);
		hourOfTheDayGEQ18Expression.setOperand2(value18Expression);
		
		HyEqualExpression nightModeTrueExpression = expressionFactory.createHyEqualExpression();
		HyValueExpression valueTrueExpression = expressionFactory.createHyValueExpression();
		HyBooleanValue valueTrue = valueFactory.createHyBooleanValue();
		valueTrue.setValue(true);
		valueTrueExpression.setValue(valueTrue);
		HyAttributeReferenceExpression nightModeReference = expressionFactory.createHyAttributeReferenceExpression();
		nightModeReference.setAttribute(nightMode);
		nightModeTrueExpression.setOperand1(nightModeReference);
		nightModeTrueExpression.setOperand2(valueTrueExpression);
		
		HyImpliesExpression hourOfTheDayImpliesNightModeExpression = expressionFactory.createHyImpliesExpression();
		hourOfTheDayImpliesNightModeExpression.setOperand1(hourOfTheDayGEQ18Expression);
		hourOfTheDayImpliesNightModeExpression.setOperand2(nightModeTrueExpression);
		
//		HyNestedExpression hOTDImpliesNightModeNested = expressionFactory.createHyNestedExpression();
//		hOTDImpliesNightModeNested.setOperand(hourOfTheDayImpliesNightModeExpression);
//		
//		HyImpliesExpression hudHourNightModeExpression = expressionFactory.createHyImpliesExpression();
		HyFeatureReferenceExpression hudReference = expressionFactory.createHyFeatureReferenceExpression();
		hudReference.setFeature(headsUpFeature);
//		hudHourNightModeExpression.setOperand1(hudReference);
//		hudHourNightModeExpression.setOperand2(hOTDImpliesNightModeNested);

		hourOfTheDayNightMode.setAttribute(nightMode);
		hourOfTheDayNightMode.setValidityFormula(hourOfTheDayImpliesNightModeExpression);
		contextMappingModel.getValidityFormulas().add(hourOfTheDayNightMode);

		// ------- create preferences --------
		PreferencesFactory preferenceFactory = PreferencesFactory.eINSTANCE;
		DwProfile preferenceModel = preferenceFactory.createDwProfile();
		this.preferenceModel = preferenceModel;
		preferenceModel.setContextModel(contextModel);
		preferenceModel.setFeatureModel(featureModel);
		
//		switch(profile) {
//		case SPORTY:
//			// # passengers >= 2 -> ifPossibe(Comfort)   Comfort = Neutral, Automatic, White
//			DwPreference passengersComfortPreference = preferenceFactory.createDwPreference();
//			HyGreaterOrEqualExpression passengersGEQ2Expression = expressionFactory.createHyGreaterOrEqualExpression();
//			HyContextInformationReferenceExpression passengersReference = expressionFactory.createHyContextInformationReferenceExpression();
//			passengersReference.setContextInformation(numberOfPassengers);
//			HyValueExpression valueTwoExpression = expressionFactory.createHyValueExpression();
//			HyNumberValue valueTwo = valueFactory.createHyNumberValue();
//			valueTwo.setValue(2);
//			valueTwoExpression.setValue(valueTwo);
//			passengersGEQ2Expression.setOperand1(passengersReference);
//			passengersGEQ2Expression.setOperand2(valueTwoExpression);
//			
////			HyNestedExpression passengersGEQ2Nested = expressionFactory.createHyNestedExpression();
////			passengersGEQ2Nested.setOperand(passengersGEQ2Expression);
//			
//			HyIfPossibleExpression ifPossibleComfortExpression = expressionFactory.createHyIfPossibleExpression();
//			ifPossibleComfortExpression.getOperands().add(EcoreUtil.copy(neutralReference));
//			ifPossibleComfortExpression.getOperands().add(EcoreUtil.copy(automaticReference));
//			ifPossibleComfortExpression.getOperands().add(EcoreUtil.copy(whiteReference));
////			HyNestedExpression ifPossibleComfortNested = expressionFactory.createHyNestedExpression();
////			ifPossibleComfortNested.setOperand(ifPossibleComfortExpression);
//			
//			HyImpliesExpression passengersComfortExpression = expressionFactory.createHyImpliesExpression();
//			passengersComfortExpression.setOperand1(passengersGEQ2Expression);
//			passengersComfortExpression.setOperand2(ifPossibleComfortExpression);
//			
//			passengersComfortPreference.setRootExpression(passengersComfortExpression);
//			preferenceModel.getPreferences().add(passengersComfortPreference);
//			
//			// # passengers >= 2 -> Cruise Control
//			DwPreference passengersCruiseControlPreference = preferenceFactory.createDwPreference();
//			HyGreaterOrEqualExpression passengersGEQ2Expression2 = EcoreUtil.copy(passengersGEQ2Expression);
//			HyImpliesExpression passengersCruiseControlExpression = expressionFactory.createHyImpliesExpression();
//			passengersCruiseControlExpression.setOperand1(passengersGEQ2Expression2);
//			passengersCruiseControlExpression.setOperand2(EcoreUtil.copy(cruiseControlReference));
//			
//			passengersCruiseControlPreference.setRootExpression(passengersCruiseControlExpression);
//			preferenceModel.getPreferences().add(passengersCruiseControlPreference);
//			
//			
//			
//			// Automatic
//			DwPreference automaticPreference = preferenceFactory.createDwPreference();
//			automaticPreference.setRootExpression(EcoreUtil.copy(automaticReference));
//			preferenceModel.getPreferences().add(automaticPreference);
//
//			// ifPossible(Sport) (Progressive, Red, Manual)
//			DwPreference ifPossibleSportPreference = preferenceFactory.createDwPreference();
//			HyIfPossibleExpression ifPossibleSportExpression = expressionFactory.createHyIfPossibleExpression();
//			ifPossibleSportExpression.getOperands().add(EcoreUtil.copy(progressiveReference));
//			ifPossibleSportExpression.getOperands().add(EcoreUtil.copy(redReference));
//			ifPossibleSportExpression.getOperands().add(EcoreUtil.copy(manualReference));
//			ifPossibleSportPreference.setRootExpression(ifPossibleSportExpression);
//			preferenceModel.getPreferences().add(ifPossibleSportPreference);
//
//			// HUD <= 1.1
//			DwPreference hudLess11Preference = preferenceFactory.createDwPreference();
//			HyFeatureReferenceExpression headsUpLess11Reference = expressionFactory.createHyFeatureReferenceExpression();
//			headsUpLess11Reference.setFeature(headsUpFeature);
//			HyRelativeVersionRestriction hudLess11 = expressionFactory.createHyRelativeVersionRestriction();
//			hudLess11.setOperator(HyRelativeVersionRestrictionOperator.LESS_THAN_OR_EQUAL);
//			hudLess11.setVersion(headsUp11);
//			hudLess11.setRestrictedFeatureReferenceExpression(headsUpLess11Reference);
//			hudLess11Preference.setRootExpression(headsUpLess11Reference);
//			
//			preferenceModel.getPreferences().add(hudLess11Preference);
//			
//			// max(maxSpeed)
//			DwPreference maxMaxSpeedPreference = preferenceFactory.createDwPreference();
//			HyMaximumExpression maxMaxSpeed = expressionFactory.createHyMaximumExpression();
//			maxMaxSpeed.setOperand(EcoreUtil.copy(maxSpeedReference));
//			maxMaxSpeedPreference.setRootExpression(maxMaxSpeed);
//			preferenceModel.getPreferences().add(maxMaxSpeedPreference);
//			
//			// Cruise Control -> Lane Assist
//			DwPreference cruiseControlLaneAssistPreference = preferenceFactory.createDwPreference();
//			HyImpliesExpression cruiseControlLaneAssist = expressionFactory.createHyImpliesExpression();
//			HyFeatureReferenceExpression laneAssistReference = expressionFactory.createHyFeatureReferenceExpression();
//			laneAssistReference.setFeature(laneAssistFeature);
//			cruiseControlLaneAssist.setOperand1(EcoreUtil.copy(cruiseControlReference));
//			cruiseControlLaneAssist.setOperand2(laneAssistReference);
//			cruiseControlLaneAssistPreference.setRootExpression(cruiseControlLaneAssist);
//			preferenceModel.getPreferences().add(cruiseControlLaneAssistPreference);
//
//			// !Lane Assist
//			DwPreference notLaneAssistPreference = preferenceFactory.createDwPreference();
//			HyNotExpression notLaneAssist = expressionFactory.createHyNotExpression();
//			notLaneAssist.setOperand(EcoreUtil.copy(laneAssistReference));
//			notLaneAssistPreference.setRootExpression(notLaneAssist);
//			preferenceModel.getPreferences().add(notLaneAssistPreference);
//		
//			break;
			
//		case ECO:
			// Time >= 16 -> nightMode = true
			DwPreference hourOfTheDay16NightModePreference =  preferenceFactory.createDwPreference();
				
			HyValueExpression value16Expression = expressionFactory.createHyValueExpression();
			HyNumberValue value16 = valueFactory.createHyNumberValue();
			value16.setValue(16);
			value16Expression.setValue(value16);
			HyGreaterOrEqualExpression hourOfTheDayGEQ16Expression = expressionFactory.createHyGreaterOrEqualExpression();
			hourOfTheDayGEQ16Expression.setOperand1(EcoreUtil.copy(hourOfTheDayReference));
			hourOfTheDayGEQ16Expression.setOperand2(value16Expression);
						
			HyImpliesExpression hourOfTheDay16ImpliesNightModeExpression = expressionFactory.createHyImpliesExpression();
			hourOfTheDay16ImpliesNightModeExpression.setOperand1(hourOfTheDayGEQ16Expression);
			hourOfTheDay16ImpliesNightModeExpression.setOperand2(EcoreUtil.copy(nightModeTrueExpression));
			
			HyNestedExpression hOTD16ImpliesNightModeNested = expressionFactory.createHyNestedExpression();
			hOTD16ImpliesNightModeNested.setOperand(hourOfTheDay16ImpliesNightModeExpression);
			
			HyImpliesExpression hudHour16NightModeExpression = expressionFactory.createHyImpliesExpression();
			hudHour16NightModeExpression.setOperand1(EcoreUtil.copy(hudReference));
			hudHour16NightModeExpression.setOperand2(hOTD16ImpliesNightModeNested);
			hourOfTheDay16NightModePreference.setRootExpression(hudHour16NightModeExpression);
			preferenceModel.getPreferences().add(hourOfTheDay16NightModePreference);
			
			// ifPossible(Eco)  Conservative, Automatic, Green
			DwPreference ifPossibleEcoPreference = preferenceFactory.createDwPreference();
			HyIfPossibleExpression ifPossibleEcoExpression = expressionFactory.createHyIfPossibleExpression();
			ifPossibleEcoExpression.getOperands().add(EcoreUtil.copy(conservativeReference));
			ifPossibleEcoExpression.getOperands().add(EcoreUtil.copy(automaticReference));
			HyFeatureReferenceExpression greenReference = expressionFactory.createHyFeatureReferenceExpression();
			greenReference.setFeature(greenFeature);
			ifPossibleEcoExpression.getOperands().add(greenReference);			
			ifPossibleEcoPreference.setRootExpression(ifPossibleEcoExpression);
			preferenceModel.getPreferences().add(ifPossibleEcoPreference);
			
			// Parking Spot detector
			DwPreference parkingSpotPreference = preferenceFactory.createDwPreference();
			parkingSpotPreference.setRootExpression(EcoreUtil.copy(parkingSpotReference));
			preferenceModel.getPreferences().add(parkingSpotPreference);
			
			// HUD[>=2.0]
			DwPreference hudBigger20Preference = preferenceFactory.createDwPreference();
			hudBigger20Preference.setRootExpression(EcoreUtil.copy(headsUpBigger20Reference));
			preferenceModel.getPreferences().add(hudBigger20Preference);
			
			// Cruise Control
			DwPreference cruiseControlPreference = preferenceFactory.createDwPreference();
			cruiseControlPreference.setRootExpression(EcoreUtil.copy(cruiseControlReference));
			preferenceModel.getPreferences().add(cruiseControlPreference);
			
			// Lane Assist [>=2.0]
			DwPreference laneAssistGreater20Preference = preferenceFactory.createDwPreference();
			HyFeatureReferenceExpression laneAssistGreater20Reference = expressionFactory.createHyFeatureReferenceExpression();
			laneAssistGreater20Reference.setFeature(laneAssistFeature);
			HyRelativeVersionRestriction laneAssistGreater20 = expressionFactory.createHyRelativeVersionRestriction();
			laneAssistGreater20.setOperator(HyRelativeVersionRestrictionOperator.GREATER_THAN_OR_EQUAL);
			laneAssistGreater20.setVersion(laneAssistV20);
			laneAssistGreater20.setRestrictedFeatureReferenceExpression(laneAssistGreater20Reference);
			laneAssistGreater20Preference.setRootExpression(laneAssistGreater20Reference);
			preferenceModel.getPreferences().add(laneAssistGreater20Preference);
			
			// Lane Assist
			DwPreference laneAssistPreference = preferenceFactory.createDwPreference();
			HyFeatureReferenceExpression laneAssistReference3 = expressionFactory.createHyFeatureReferenceExpression();
			laneAssistReference3.setFeature(laneAssistFeature);
			laneAssistPreference.setRootExpression(EcoreUtil.copy(laneAssistReference3));
			preferenceModel.getPreferences().add(laneAssistPreference);
			
			// max(maxSpeed)
			DwPreference maxMaxSpeedPreference2 = preferenceFactory.createDwPreference();
			HyMaximumExpression maxMaxSpeed2 = expressionFactory.createHyMaximumExpression();
			maxMaxSpeed2.setOperand(EcoreUtil.copy(maxSpeedReference));
			maxMaxSpeedPreference2.setRootExpression(maxMaxSpeed2);
			preferenceModel.getPreferences().add(maxMaxSpeedPreference2);

//			break;
		
//		}
		

		

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

		HyFeatureSelected engineSelected = configurationFactory.createHyFeatureSelected();
		engineSelected.setSelectedFeature(engineFeature);
		oldConfig.getElements().add(engineSelected);

		HyFeatureSelected progressiveSelected = configurationFactory.createHyFeatureSelected();
		progressiveSelected.setSelectedFeature(progressiveFeature);
		oldConfig.getElements().add(progressiveSelected);

		HyFeatureSelected gearSelected = configurationFactory.createHyFeatureSelected();
		gearSelected.setSelectedFeature(gearFeature);
		oldConfig.getElements().add(gearSelected);

		HyFeatureSelected automaticSelected = configurationFactory.createHyFeatureSelected();
		automaticSelected.setSelectedFeature(automaticFeature);
		oldConfig.getElements().add(automaticSelected);

		HyFeatureSelected ambientLightingSelected = configurationFactory.createHyFeatureSelected();
		ambientLightingSelected.setSelectedFeature(ambientLightingFeature);
		oldConfig.getElements().add(ambientLightingSelected);

		HyFeatureSelected redSelected = configurationFactory.createHyFeatureSelected();
		redSelected.setSelectedFeature(redFeature);
		oldConfig.getElements().add(redSelected);
		
		HyFeatureSelected headsUpSelected = configurationFactory.createHyFeatureSelected();
		headsUpSelected.setSelectedFeature(headsUpFeature);
		oldConfig.getElements().add(headsUpSelected);
		
		HyVersionSelected headsUp11Selected = configurationFactory.createHyVersionSelected();
		headsUp11Selected.setSelectedVersion(headsUp11);
		oldConfig.getElements().add(headsUp11Selected);

		// value for maxSpeed
//		HyAttributeValueAssignment maxSpeedValueAssignment = configurationFactory.createHyAttributeValueAssignment();
//		maxSpeedValueAssignment.setAttribute(maxSpeedAttribute);
//		HyNumberValue value300 = valueFactory.createHyNumberValue();
//		value300.setValue(300);
//		maxSpeedValueAssignment.setValue(value300);
//		oldConfig.getElements().add(maxSpeedValueAssignment);
		
		// value for nightmode
		HyAttributeValueAssignment nightModeValueAssignment = configurationFactory.createHyAttributeValueAssignment();
		nightModeValueAssignment.setAttribute(nightMode);
		HyBooleanValue valueFalse = valueFactory.createHyBooleanValue();
		valueFalse.setValue(false);
		nightModeValueAssignment.setValue(valueFalse);
		oldConfig.getElements().add(nightModeValueAssignment);
		
		
		return featureModel;
	}

	
	
	@Override
	public HyMappingModel createMappingModel() {
		// TODO Auto-generated method stub
		return null;
	}

	
	private HyConstraintModel constraintModel;
	
	@Override
	public HyConstraintModel createConstraintModel() {
		return constraintModel;
	}

	private HyContextModel contextModel;
	
	@Override
	public HyContextModel createContextModel() {
		return contextModel;
	}

	private HyValidityModel contextValidityModel;
	
	@Override
	public HyValidityModel createValidityModel() {
		return contextValidityModel;
	}

	private DwProfile preferenceModel;
	
	@Override
	public DwProfile createPreferenceModel() {
		return preferenceModel;
	}

	private HyConfiguration oldConfiguration;
	
	@Override
	public HyConfiguration createConfiguration() {
		return oldConfiguration;
	}

}
