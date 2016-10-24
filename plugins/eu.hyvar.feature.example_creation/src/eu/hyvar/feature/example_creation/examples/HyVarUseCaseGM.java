package eu.hyvar.feature.example_creation.examples;

import org.eclipse.core.resources.IFile;

import de.christophseidl.util.eclipse.ResourceUtil;
import de.christophseidl.util.ecore.EcoreIOUtil;
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
import eu.hyvar.feature.HyRootFeature;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.constraint.HyConstraint;
import eu.hyvar.feature.constraint.HyConstraintFactory;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.expression.HyExpressionFactory;
import eu.hyvar.feature.expression.HyFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyImpliesExpression;
import eu.hyvar.feature.mapping.HyMappingModel;
import eu.hyvar.feature.util.HyFeatureCreationUtil;
import eu.hyvar.preferences.HyPreferenceModel;

public class HyVarUseCaseGM extends HyFMExample {

	
	@Override
	public HyFeatureModel createExample() {
		
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(2015, 0, 31, 23, 59, 59);
//		Date firstDate = calendar.getTime();
//		calendar.add(Calendar.MONTH, 1);
//		Date secondDate = calendar.getTime();
//		
		HyFeatureModel featureModel = factory.createHyFeatureModel();
		
		// Root feature
		HyFeatureType carType = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.MANDATORY, null, null, null);
		HyName carName = HyFeatureCreationUtil.createName("Car", null, null, null);
		HyFeature carFeature = HyFeatureCreationUtil.createFeature(carType, carName, null, null);
		featureModel.getFeatures().add(carFeature);
		
		HyRootFeature rootFeature = HyFeatureCreationUtil.createRootFeature(carFeature, null, null, null);
		featureModel.getRootFeature().add(rootFeature);
		
		// And Group under car
		HyGroupType carAndGroupType = HyFeatureCreationUtil.createGroupType(HyGroupTypeEnum.AND, null, null, null);
		HyGroup carAndGroup = HyFeatureCreationUtil.createGroup(carAndGroupType, null, null);
		featureModel.getGroups().add(carAndGroup);
		
		HyFeatureChild carAndChild = HyFeatureCreationUtil.createFeatureChild(null, null, null);
		carAndChild.setParent(carFeature);
		carAndChild.setChildGroup(carAndGroup);
		
		HyGroupComposition carAndComposition = HyFeatureCreationUtil.createGroupComposition(null, null, null);
		carAndComposition.setCompositionOf(carAndGroup);
		
		
		// Child features of telematic box
		HyFeatureType emergencyCallCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.MANDATORY, null, null, null);
		HyName emergencyCallName = HyFeatureCreationUtil.createName("Emergency Call", null, null, null);
		HyFeature  emergencyCallFeature = HyFeatureCreationUtil.createFeature(emergencyCallCardinality, emergencyCallName, null, null);
		featureModel.getFeatures().add(emergencyCallFeature);
		
		HyFeatureType positionCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.MANDATORY, null, null, null);
		HyName positionName = HyFeatureCreationUtil.createName("Position", null, null, null);
		HyFeature positionFeature = HyFeatureCreationUtil.createFeature(positionCardinality, positionName, null, null);
		featureModel.getFeatures().add(positionFeature);
		
		HyFeatureType assistanceSystemsCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null, null, null);
		HyName assistanceSystemsName = HyFeatureCreationUtil.createName("Assistance Systems", null, null, null);
		HyFeature assistanceSystemsFeature = HyFeatureCreationUtil.createFeature(assistanceSystemsCardinality, assistanceSystemsName, null, null);
		featureModel.getFeatures().add(assistanceSystemsFeature);
		
		carAndComposition.getFeatures().add(emergencyCallFeature);
		carAndComposition.getFeatures().add(positionFeature);
		carAndComposition.getFeatures().add(assistanceSystemsFeature);
		
		
		// Or Group under Assistance Systems
		HyGroupType assistanceOrCardinality = HyFeatureCreationUtil.createGroupType(HyGroupTypeEnum.OR, null, null, null);
		HyGroup assistanceOrGroup = HyFeatureCreationUtil.createGroup(assistanceOrCardinality, null, null);
		featureModel.getGroups().add(assistanceOrGroup);
		
		HyFeatureChild assistanceOrChild = HyFeatureCreationUtil.createFeatureChild(null, null, null);
		assistanceOrChild.setChildGroup(assistanceOrGroup);
		assistanceOrChild.setParent(assistanceSystemsFeature);
		
		HyGroupComposition assistanceOrComposittion = HyFeatureCreationUtil.createGroupComposition(null, null, null);
		assistanceOrComposittion.setCompositionOf(assistanceOrGroup);
		
		// Child features of assistance or group
		HyFeatureType cruiseControlCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null, null, null);
		HyName cruiseControlName = HyFeatureCreationUtil.createName("Cruise Control", null, null, null);
		HyFeature cruiseControlFeature = HyFeatureCreationUtil.createFeature(cruiseControlCardinality, cruiseControlName, null, null);
		featureModel.getFeatures().add(cruiseControlFeature);
		
		HyVersion cruiseControlVersion = HyFeatureCreationUtil.createVersion("maxSpeed: int", null, null, null);
		cruiseControlFeature.getVersions().add(cruiseControlVersion);
		
		HyFeatureType parkingCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null, null, null);
		HyName parkingName = HyFeatureCreationUtil.createName("Parking Pilot", null, null, null);
		HyFeature parkingFeature = HyFeatureCreationUtil.createFeature(parkingCardinality, parkingName, null, null);
		featureModel.getFeatures().add(parkingFeature);
		
		assistanceOrComposittion.getFeatures().add(parkingFeature);
		assistanceOrComposittion.getFeatures().add(cruiseControlFeature);
		
		
		// Alternative Group under emergency call and group
		HyGroupType emergencyAlternativeCardinality = HyFeatureCreationUtil.createGroupType(HyGroupTypeEnum.ALTERNATIVE, null, null, null);
		HyGroup emergencyAlternativeGroup = HyFeatureCreationUtil.createGroup(emergencyAlternativeCardinality, null, null);
		featureModel.getGroups().add(emergencyAlternativeGroup);
		
		HyFeatureChild emergencyAlternativeChild = HyFeatureCreationUtil.createFeatureChild(null, null, null);
		emergencyAlternativeChild.setChildGroup(emergencyAlternativeGroup);
		emergencyAlternativeChild.setParent(emergencyCallFeature);
		
		HyGroupComposition emergencyAlternativeComposition = HyFeatureCreationUtil.createGroupComposition(null, null, null);
		emergencyAlternativeComposition.setCompositionOf(emergencyAlternativeGroup);
		
		// Child features of emergency call alternative group
		HyFeatureType eCallEuropeCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null, null, null);
		HyName eCallEuropeName = HyFeatureCreationUtil.createName("eCall Europe", null, null, null);
		HyFeature eCallEuropaFeature = HyFeatureCreationUtil.createFeature(eCallEuropeCardinality, eCallEuropeName, null, null);
		featureModel.getFeatures().add(eCallEuropaFeature);
		
		HyFeatureType eraRussiaCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null, null, null);
		HyName eraRussiaName = HyFeatureCreationUtil.createName("ERA/GLONASS Russia", null, null, null);
		HyFeature eraRussiaFeature = HyFeatureCreationUtil.createFeature(eraRussiaCardinality, eraRussiaName, null, null);
		featureModel.getFeatures().add(eraRussiaFeature);
		
		emergencyAlternativeComposition.getFeatures().add(eCallEuropaFeature);
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
			
		
		
		
		
		
		
		HyConstraintFactory constraintFactory = HyConstraintFactory.eINSTANCE;
		HyConstraintModel constraintModel = constraintFactory.createHyConstraintModel();
//		constraintModel.setFeatureModel(featureMosdel);
		
		HyExpressionFactory expressionFactory = HyExpressionFactory.eINSTANCE;
		
		HyConstraint eCallGpsConstraint = constraintFactory.createHyConstraint();
		HyImpliesExpression eCallGpsExpression = expressionFactory.createHyImpliesExpression();
		HyFeatureReferenceExpression eCallReferenceExpression = expressionFactory.createHyFeatureReferenceExpression();
		eCallReferenceExpression.setFeature(eCallEuropaFeature);
		HyFeatureReferenceExpression gpsReferenceExpression = expressionFactory.createHyFeatureReferenceExpression();
		gpsReferenceExpression.setFeature(gpsFeature);
		eCallGpsExpression.setOperand1(eCallReferenceExpression);
		eCallGpsExpression.setOperand2(gpsReferenceExpression);
		eCallGpsConstraint.setRootExpression(eCallGpsExpression);
		constraintModel.getConstraints().add(eCallGpsConstraint);
		
		HyConstraint eraGlonassConstraint = constraintFactory.createHyConstraint();
		HyImpliesExpression eraGlonassExpression = expressionFactory.createHyImpliesExpression();
		HyFeatureReferenceExpression eraReferenceExpression = expressionFactory.createHyFeatureReferenceExpression();
		eraReferenceExpression.setFeature(eraRussiaFeature);
		HyFeatureReferenceExpression glonassReferenceExpression = expressionFactory.createHyFeatureReferenceExpression();
		glonassReferenceExpression.setFeature(glonassFeature);
		eraGlonassExpression.setOperand1(eraReferenceExpression);
		eraGlonassExpression.setOperand2(glonassReferenceExpression);
		eraGlonassConstraint.setRootExpression(eraGlonassExpression);
		constraintModel.getConstraints().add(eraGlonassConstraint);
		
		
		if(constraintModel != null) {
			// TODO take folder selected in eclipse
			IFile file = ResourceUtil.getLocalFile("Example/" + "HyVarUseCases" + ".hyconstraint");
			EcoreIOUtil.saveModelAs(constraintModel, file);
		}
		
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
	public HyPreferenceModel createPreferenceModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HyConfiguration createConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

}
