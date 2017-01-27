/**
 * 
 */
package de.darwinspl.feature.evolution.tests;

import java.util.Calendar;
import java.util.Date;

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
import eu.hyvar.feature.util.HyFeatureCreationUtil;

/**
 *
 */
public abstract class TestCases {


	protected static HyFeature infotainmentFeature;
	protected static HyGroup frontDistanceSensorsAlternativeGroup;
	
	protected static Calendar calendar = Calendar.getInstance();
	protected static Date timestamp;
	
	public static HyFeatureModel createExample() {

		HyFeatureFactory factory = HyFeatureFactory.eINSTANCE;

		Calendar calendar = Calendar.getInstance();
		calendar.set(2015, 0, 31, 23, 59, 59);
		Date firstDate = calendar.getTime();

		HyFeatureModel featureModel = factory.createHyFeatureModel();

		HyFeatureType carType = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.MANDATORY, null, null, null);
		HyName carName = HyFeatureCreationUtil.createName("Car", null, null, null);
		HyFeature carFeature = HyFeatureCreationUtil.createFeature(carType, carName, null, null);
		featureModel.getFeatures().add(carFeature);

		HyRootFeature rootFeature = HyFeatureCreationUtil.createRootFeature(carFeature, null, null, null);
		featureModel.getRootFeature().add(rootFeature);

		// And Group under car
		HyGroupType carGroupType = HyFeatureCreationUtil.createGroupType(HyGroupTypeEnum.AND, null, null, null);
		HyGroup carGroup = HyFeatureCreationUtil.createGroup(carGroupType, null, null);
		featureModel.getGroups().add(carGroup);

		HyFeatureChild carChild = HyFeatureCreationUtil.createFeatureChild(null, null, null);
		carChild.setParent(carFeature);
		carChild.setChildGroup(carGroup);

		HyGroupComposition carGroupComposition = HyFeatureCreationUtil.createGroupComposition(null, firstDate, null);
		carGroupComposition.setCompositionOf(carGroup);

		// Childs of Car

		HyFeatureType assistanceType = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null, null,
				null);
		HyName assistanceName = HyFeatureCreationUtil.createName("Assistance Systems", null, null, null);
		HyFeature assistanceFeature = HyFeatureCreationUtil.createFeature(assistanceType, assistanceName, null, null);
		featureModel.getFeatures().add(assistanceFeature);

		HyFeatureType infotainmentType = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.MANDATORY, null,
				null, null);
		HyName infotainmentName = HyFeatureCreationUtil.createName("Infotainment System", null, null, null);
		infotainmentFeature = HyFeatureCreationUtil.createFeature(infotainmentType, infotainmentName, null, null);
		featureModel.getFeatures().add(infotainmentFeature);

		carGroupComposition.getFeatures().add(assistanceFeature);
		carGroupComposition.getFeatures().add(infotainmentFeature);

		// And Group under Assistance
		HyGroupType assistanceAndGroupType = HyFeatureCreationUtil.createGroupType(HyGroupTypeEnum.AND, null, null,
				null);
		HyGroup assistanceAndGroup = HyFeatureCreationUtil.createGroup(assistanceAndGroupType, null, null);
		featureModel.getGroups().add(assistanceAndGroup);

		HyFeatureChild assistanceAndChild = HyFeatureCreationUtil.createFeatureChild(null, null, null);
		assistanceAndChild.setParent(assistanceFeature);
		assistanceAndChild.setChildGroup(assistanceAndGroup);

		HyGroupComposition assistanceAndGroupComposition = HyFeatureCreationUtil.createGroupComposition(null, firstDate,
				null);
		assistanceAndGroupComposition.setCompositionOf(assistanceAndGroup);

		// Childs of Assistance And Group
		HyFeatureType parkAssistanceType = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null,
				null, null);
		HyName parkAssistanceName = HyFeatureCreationUtil.createName("Parking Assistance", null, null, null);
		HyFeature parkAssistanceFeature = HyFeatureCreationUtil.createFeature(parkAssistanceType, parkAssistanceName,
				null, null);
		featureModel.getFeatures().add(parkAssistanceFeature);

		HyFeatureType frontDistanceType = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null,
				null, null);
		HyName frontDistanceName = HyFeatureCreationUtil.createName("Front Distance Sensor", null, firstDate, null);
		HyFeature frontDistanceFeature = HyFeatureCreationUtil.createFeature(frontDistanceType, frontDistanceName, null,
				null);
		featureModel.getFeatures().add(frontDistanceFeature);

		HyFeatureType accType = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null, null, null);
		HyName accName = HyFeatureCreationUtil.createName("Adaptive Cruise Control", null, null, null);
		HyFeature accFeature = HyFeatureCreationUtil.createFeature(accType, accName, null, null);
		featureModel.getFeatures().add(accFeature);

		assistanceAndGroupComposition.getFeatures().add(parkAssistanceFeature);
		assistanceAndGroupComposition.getFeatures().add(frontDistanceFeature);
		assistanceAndGroupComposition.getFeatures().add(accFeature);

		// And Group under Park Assistance
		HyGroupType parkAssistanceAndGroupType = HyFeatureCreationUtil.createGroupType(HyGroupTypeEnum.AND, null,
				firstDate, null);
		HyGroup parkAssistanceAndGroup = HyFeatureCreationUtil.createGroup(parkAssistanceAndGroupType, null, firstDate);
		featureModel.getGroups().add(parkAssistanceAndGroup);

		HyFeatureChild parkAssistanceAndChild = HyFeatureCreationUtil.createFeatureChild(null, firstDate, null);
		parkAssistanceAndChild.setParent(parkAssistanceFeature);
		parkAssistanceAndChild.setChildGroup(parkAssistanceAndGroup);

		HyGroupComposition parkAssistanceAndGroupComposition = HyFeatureCreationUtil.createGroupComposition(null,
				firstDate, null);
		parkAssistanceAndGroupComposition.setCompositionOf(parkAssistanceAndGroup);

		// Childs of Park Assistance And Group
		HyFeatureType sideType = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.MANDATORY, null, firstDate,
				null);
		HyName sideName = HyFeatureCreationUtil.createName("Side Distance Sensor", null, null, null);
		HyFeature sideFeature = HyFeatureCreationUtil.createFeature(sideType, sideName, null, null);
		featureModel.getFeatures().add(sideFeature);

		parkAssistanceAndGroupComposition.getFeatures().add(sideFeature);

		// And Group under Infotainment
		HyGroupType infotainmentAndGroupType = HyFeatureCreationUtil.createGroupType(HyGroupTypeEnum.AND, null,
				firstDate, null);
		HyGroup infotainmentAndGroup = HyFeatureCreationUtil.createGroup(infotainmentAndGroupType, null, firstDate);
		featureModel.getGroups().add(infotainmentAndGroup);

		HyFeatureChild infotainmentAssistanceAndChild = HyFeatureCreationUtil.createFeatureChild(null, firstDate, null);
		infotainmentAssistanceAndChild.setParent(infotainmentFeature);
		infotainmentAssistanceAndChild.setChildGroup(infotainmentAndGroup);

		HyGroupComposition infotainmentAndGroupComposition = HyFeatureCreationUtil.createGroupComposition(null,
				firstDate, null);
		infotainmentAndGroupComposition.setCompositionOf(infotainmentAndGroup);

		// Childs of infotainment and group
		HyFeatureType consumptionType = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null,
				firstDate, null);
		HyName consumptionName = HyFeatureCreationUtil.createName("Consumption Indicator", null, firstDate, null);
		HyFeature consumptionFeature = HyFeatureCreationUtil.createFeature(consumptionType, consumptionName, null,
				firstDate);
		featureModel.getFeatures().add(consumptionFeature);

		infotainmentAndGroupComposition.getFeatures().add(consumptionFeature);
		// Print at initial Date
		// featureExporter.exportFeatureModel(constraintModel, initialDate);

		// Evolution 1

		HyGroupComposition carEvo1GroupComposition = HyFeatureCreationUtil.createGroupComposition(firstDate, null,
				carGroupComposition);
		carEvo1GroupComposition.setCompositionOf(carGroup);

		// New Childs of Car
		HyFeatureType distanceSensorsType = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL,
				firstDate, null, null);
		HyName distanceSensorsName = HyFeatureCreationUtil.createName("Distance Sensors", firstDate, null, null);
		HyFeature distanceSensorsFeature = HyFeatureCreationUtil.createFeature(distanceSensorsType, distanceSensorsName,
				null, null);
		featureModel.getFeatures().add(distanceSensorsFeature);

		carEvo1GroupComposition.getFeatures().add(assistanceFeature);
		carEvo1GroupComposition.getFeatures().add(distanceSensorsFeature);
		carEvo1GroupComposition.getFeatures().add(infotainmentFeature);

		// And Group under distance sensors:
		HyGroupType distanceSensorsAndGroupCardinality = HyFeatureCreationUtil.createGroupType(HyGroupTypeEnum.AND,
				firstDate, null, null);
		HyGroup distanceSensorsAndGroup = HyFeatureCreationUtil.createGroup(distanceSensorsAndGroupCardinality,
				firstDate, null);
		featureModel.getGroups().add(distanceSensorsAndGroup);

		HyFeatureChild distanceSensorsAndChild = HyFeatureCreationUtil.createFeatureChild(firstDate, null, null);
		distanceSensorsAndChild.setParent(distanceSensorsFeature);
		distanceSensorsAndChild.setChildGroup(distanceSensorsAndGroup);

		HyGroupComposition distanceSensorsAndGroupComposition = HyFeatureCreationUtil.createGroupComposition(firstDate,
				null, null);
		distanceSensorsAndGroupComposition.setCompositionOf(distanceSensorsAndGroup);

		// Childs under and distance group
		HyFeatureType sideEvo1Type = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, firstDate,
				null, sideType);
		sideFeature.getTypes().add(sideEvo1Type);

		HyFeatureType frontDistanceSensorsType = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL,
				firstDate, null, null);
		HyName frontDistanceSensorsName = HyFeatureCreationUtil.createName("Front Distance Sensors", firstDate, null,
				null);
		HyFeature frontDistanceSensorsFeature = HyFeatureCreationUtil.createFeature(frontDistanceSensorsType,
				frontDistanceSensorsName, firstDate, null);
		featureModel.getFeatures().add(frontDistanceSensorsFeature);

		distanceSensorsAndGroupComposition.getFeatures().add(sideFeature);
		distanceSensorsAndGroupComposition.getFeatures().add(frontDistanceSensorsFeature);

		// Alternative Group under front distance sensors
		HyGroupType frontDistanceSensorsAlternativeGroupType = HyFeatureCreationUtil
				.createGroupType(HyGroupTypeEnum.ALTERNATIVE, firstDate, null, null);
		frontDistanceSensorsAlternativeGroup = HyFeatureCreationUtil
				.createGroup(frontDistanceSensorsAlternativeGroupType, firstDate, null);
		featureModel.getGroups().add(frontDistanceSensorsAlternativeGroup);

		HyFeatureChild frontDistanceAlternativeChild = HyFeatureCreationUtil.createFeatureChild(firstDate, null, null);
		frontDistanceAlternativeChild.setParent(frontDistanceSensorsFeature);
		frontDistanceAlternativeChild.setChildGroup(frontDistanceSensorsAlternativeGroup);

		HyGroupComposition frontDistanceSensorsAlternativeGroupComposition = HyFeatureCreationUtil
				.createGroupComposition(firstDate, null, null);
		frontDistanceSensorsAlternativeGroupComposition.setCompositionOf(frontDistanceSensorsAlternativeGroup);

		// Childs in alternative group under distance sensors:
		// HyCardinality frontDistanceEvo1Cardinality =
		// HyFeatureCreationUtil.createCardinality(0, 1, firstEvoDate, null,
		// frontDistanceCardinality);
		HyName frontDistanceEvo1Name = HyFeatureCreationUtil.createName("Slow Front Distance Sensor", firstDate, null,
				frontDistanceName);
		// frontDistanceFeature.getCardinality().add(frontDistanceEvo1Cardinality);
		frontDistanceFeature.getNames().add(frontDistanceEvo1Name);

		HyFeatureType fastFrontDistanceType = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL,
				firstDate, null, null);
		HyName fastFrontDistanceName = HyFeatureCreationUtil.createName("Fast Front Distance Sensor", firstDate, null,
				null);
		HyFeature fastFrontDistanceFeature = HyFeatureCreationUtil.createFeature(fastFrontDistanceType,
				fastFrontDistanceName, firstDate, null);
		featureModel.getFeatures().add(fastFrontDistanceFeature);

		frontDistanceSensorsAlternativeGroupComposition.getFeatures().add(fastFrontDistanceFeature);
		frontDistanceSensorsAlternativeGroupComposition.getFeatures().add(frontDistanceFeature);

		// Update and group under assistance
		HyGroupComposition assistanceAndGroupCompositionEvo1 = HyFeatureCreationUtil.createGroupComposition(firstDate,
				null, assistanceAndGroupComposition);
		assistanceAndGroupCompositionEvo1.setCompositionOf(assistanceAndGroup);

		assistanceAndGroupCompositionEvo1.getFeatures().add(parkAssistanceFeature);
		assistanceAndGroupCompositionEvo1.getFeatures().add(accFeature);

		// Create new Attribute for acc feature
		HyName accMaxSpeedAttributeName = HyFeatureCreationUtil.createName("maxSpeed", firstDate, null, null);
		HyNumberAttribute accMaxSpeedAttribute = HyFeatureCreationUtil.createNumberAttribute(accMaxSpeedAttributeName,
				firstDate, null);
		accFeature.getAttributes().add(accMaxSpeedAttribute);

		HyVersion accVersion = HyFeatureCreationUtil.createVersion("1", firstDate, null, null);
		accFeature.getVersions().add(accVersion);

		// secons evolution step

		calendar.add(Calendar.DAY_OF_MONTH, 1);
		Date secondDate = calendar.getTime();
		HyGroupType infotainmentSecondAndGroupType = HyFeatureCreationUtil.createGroupType(HyGroupTypeEnum.AND,
				secondDate, null, null);
		HyGroup infotainmentSecondAndGroup = HyFeatureCreationUtil.createGroup(infotainmentSecondAndGroupType,
				secondDate, null);
		featureModel.getGroups().add(infotainmentSecondAndGroup);

		HyFeatureChild infotainmentSecondAndChild = HyFeatureCreationUtil.createFeatureChild(secondDate, null, null);
		infotainmentSecondAndGroup.getChildOf().add(infotainmentSecondAndChild);
		infotainmentFeature.getParentOf().add(infotainmentSecondAndChild);

		HyGroupComposition groupComposition = HyFeatureCreationUtil.createGroupComposition(secondDate, null, null);
		groupComposition.setCompositionOf(infotainmentSecondAndGroup);

		HyFeatureType androidConnectorType = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL,
				secondDate, null, null);
		HyName androidConnectorName = HyFeatureCreationUtil.createName("Android Connection", secondDate, null, null);
		HyFeature androidConnectorFeature = HyFeatureCreationUtil.createFeature(androidConnectorType,
				androidConnectorName, secondDate, null);
		featureModel.getFeatures().add(androidConnectorFeature);

		groupComposition.getFeatures().add(androidConnectorFeature);

		// TODO attributes and constraints
		// Date date = new Date(2015,0,31,23,59,59);
		// HyFeatureModel validFeatureModel =
		// (HyFeatureModel)HyEvolutionUtil.getCopyOfValidModel(featureModel,
		// date);

		return featureModel;

	}
}

