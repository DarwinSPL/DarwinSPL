package eu.hyvar.feature.example_creation.examples;

import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.contextValidity.HyValidityModel;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
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
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.mapping.HyMappingModel;
import eu.hyvar.feature.util.HyFeatureCreationUtil;
import de.darwinspl.preferences.DwProfile;

public class VamosReconfExample extends HyFMExample {

	@Override
	public HyFeatureModel createExample() {
		HyFeatureModel featureModel = factory.createHyFeatureModel();
		
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
		
		// Childs of Assistance And Group
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
		
		
		return featureModel;
	}

	@Override
	public HyMappingModel createMappingModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HyConstraintModel createConstraintModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HyContextModel createContextModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HyValidityModel createValidityModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DwProfile createPreferenceModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HyConfiguration createConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

}
