package eu.hyvar.feature.example_creation.examples;

import java.util.Calendar;
import java.util.Date;

import org.eclipse.core.resources.IFile;

import de.christophseidl.util.eclipse.ResourceUtil;
import de.christophseidl.util.ecore.EcoreIOUtil;
import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.contextValidity.HyValidityModel;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.HyRootFeature;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.constraint.HyConstraint;
import eu.hyvar.feature.constraint.HyConstraintFactory;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.expression.HyExpressionFactory;
import eu.hyvar.feature.expression.HyFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyImpliesExpression;
import eu.hyvar.feature.mapping.HyMappingModel;
import eu.hyvar.feature.util.HyFeatureCreationUtil;
import de.darwinspl.preferences.DwProfile;

public class HyVarUseCases extends HyFMExample {

	
	@Override
	public HyFeatureModel createExample() {
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(2015, 0, 31, 23, 59, 59);
		Date firstDate = calendar.getTime();
		calendar.add(Calendar.MONTH, 1);
		Date secondDate = calendar.getTime();
		
		HyFeatureModel featureModel = factory.createHyFeatureModel();
		
		// Root feature
		HyFeatureType telematicBoxCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.MANDATORY, null, null, null);
		HyName telematicBoxName = HyFeatureCreationUtil.createName("Telematic Box", null, null, null);
		HyFeature telematicBoxFeature = HyFeatureCreationUtil.createFeature(telematicBoxCardinality, telematicBoxName, null, null);
		featureModel.getFeatures().add(telematicBoxFeature);
		
		HyRootFeature rootFeature = HyFeatureCreationUtil.createRootFeature(telematicBoxFeature, null, null, null);
		featureModel.getRootFeature().add(rootFeature);
		
		// And Group under telematic box
		HyGroupType telematicAndGroupCardinality = HyFeatureCreationUtil.createGroupType(HyGroupTypeEnum.AND, null, null, null);
		HyGroup telematicAndGroup = HyFeatureCreationUtil.createGroup(telematicAndGroupCardinality, null, null);
		featureModel.getGroups().add(telematicAndGroup);
		
		HyFeatureChild telematicAndChild = HyFeatureCreationUtil.createFeatureChild(null, null, null);
		telematicAndChild.setParent(telematicBoxFeature);
		telematicAndChild.setChildGroup(telematicAndGroup);
		
		HyGroupComposition telematicAndComposition = HyFeatureCreationUtil.createGroupComposition(null, firstDate, null);
		telematicAndComposition.setCompositionOf(telematicAndGroup);
		
		
		// Child features of telematic box
		HyFeatureType emergencyCallCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.MANDATORY, null, null, null);
		HyName emergencyCallName = HyFeatureCreationUtil.createName("Emergency Call", null, null, null);
		HyFeature  emergencyCallFeature = HyFeatureCreationUtil.createFeature(emergencyCallCardinality, emergencyCallName, null, null);
		featureModel.getFeatures().add(emergencyCallFeature);
		
		HyFeatureType positionCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.MANDATORY, null, null, null);
		HyName positionName = HyFeatureCreationUtil.createName("Position", null, null, null);
		HyFeature positionFeature = HyFeatureCreationUtil.createFeature(positionCardinality, positionName, null, null);
		featureModel.getFeatures().add(positionFeature);
		
		telematicAndComposition.getFeatures().add(emergencyCallFeature);
		telematicAndComposition.getFeatures().add(positionFeature);
		
		
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
		
//		HyVersion eCallEuropeV1 = HyFeatureCreationUtil.createVersion("v 1.0", null, null, null);
//		eCallEuropaFeature.getVersions().add(eCallEuropeV1);
//		HyVersion eCallEuropeV11 = HyFeatureCreationUtil.createVersion("v 1.1", null, null, eCallEuropeV1);
//		eCallEuropaFeature.getVersions().add(eCallEuropeV11);
//		HyVersion eCallEuropeV2 = HyFeatureCreationUtil.createVersion("v 2.0", null, null, eCallEuropeV11);
//		eCallEuropaFeature.getVersions().add(eCallEuropeV2);
		
		HyFeatureType eraRussiaCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, null, null, null);
		HyName eraRussiaName = HyFeatureCreationUtil.createName("ERA/GLONASS Russia", null, null, null);
		HyFeature eraRussiaFeature = HyFeatureCreationUtil.createFeature(eraRussiaCardinality, eraRussiaName, null, null);
		featureModel.getFeatures().add(eraRussiaFeature);
		
//		HyVersion eraNorm54620 = HyFeatureCreationUtil.createVersion("Norm 54620", null, null, null);
//		eraRussiaFeature.getVersions().add(eraNorm54620);
//		HyVersion eraNorm54620Amendment1 = HyFeatureCreationUtil.createVersion("Norm 54620 Amendment 1", null, null, eraNorm54620);
//		eraRussiaFeature.getVersions().add(eraNorm54620Amendment1);
		
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
			
		
		
		// Evolution step 1
		
		HyGroupComposition telematicAndCompositionEvo1 = HyFeatureCreationUtil.createGroupComposition(firstDate, null, telematicAndComposition);
		telematicAndCompositionEvo1.setCompositionOf(telematicAndGroup);
		
		// New Child of and group
		HyFeatureType servicesCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, firstDate, null, null);
		HyName servicesName = HyFeatureCreationUtil.createName("Services", firstDate, null, null);
		HyFeature servicesFeature= HyFeatureCreationUtil.createFeature(servicesCardinality, servicesName, firstDate, null);
		featureModel.getFeatures().add(servicesFeature);
		
		telematicAndCompositionEvo1.getFeatures().add(servicesFeature);
		telematicAndCompositionEvo1.getFeatures().add(emergencyCallFeature);
		telematicAndCompositionEvo1.getFeatures().add(positionFeature);
		
		// New Or Group under Services
		HyGroupType servicesOrGroupCardinality = HyFeatureCreationUtil.createGroupType(HyGroupTypeEnum.OR, firstDate, null, null);
		HyGroup servicesOrGroup = HyFeatureCreationUtil.createGroup(servicesOrGroupCardinality, firstDate, null);
		featureModel.getGroups().add(servicesOrGroup);
		
		HyFeatureChild servicesOrFeatureChild = HyFeatureCreationUtil.createFeatureChild(firstDate, null, null);
		servicesOrFeatureChild.setChildGroup(servicesOrGroup);
		servicesOrFeatureChild.setParent(servicesFeature);
		
		HyGroupComposition servicesOrComposition = HyFeatureCreationUtil.createGroupComposition(firstDate, secondDate, null);
		servicesOrComposition.setCompositionOf(servicesOrGroup);
		
		// Add Child features in services or group
		
		
		HyFeatureType phoneCallsCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, firstDate, null, null);
		HyName phoneCallsName = HyFeatureCreationUtil.createName("Phone Calls", firstDate, null, null);
		HyFeature phoneCallsFeature = HyFeatureCreationUtil.createFeature(phoneCallsCardinality, phoneCallsName, firstDate, null);
		featureModel.getFeatures().add(phoneCallsFeature);
		
		HyFeatureType ipConnectivityCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, firstDate, null, null);
		HyName ipConnectivitiyName = HyFeatureCreationUtil.createName("IP Connectivity", firstDate, null, null);
		HyFeature ipConnectivityFeature = HyFeatureCreationUtil.createFeature(ipConnectivityCardinality, ipConnectivitiyName, firstDate, null);
		featureModel.getFeatures().add(ipConnectivityFeature);
		
//		HyVersion ipConnectivityVersionV4 = HyFeatureCreationUtil.createVersion("IPv4", firstDate, null, null);
//		ipConnectivityFeature.getVersions().add(ipConnectivityVersionV4);
//		HyVersion ipConnectivityVersionV6 = HyFeatureCreationUtil.createVersion("IPv6", firstDate, null, ipConnectivityVersionV4);
//		ipConnectivityFeature.getVersions().add(ipConnectivityVersionV6);
		
		HyName ipConnectivityTrafficLimitName = HyFeatureCreationUtil.createName("Traffic Limit", firstDate, null, null);
		HyFeatureAttribute ipConnectivityTrafficLimitAttribute = HyFeatureCreationUtil.createNumberAttribute(ipConnectivityTrafficLimitName, firstDate, null);
		ipConnectivityFeature.getAttributes().add(ipConnectivityTrafficLimitAttribute);
		
		
		servicesOrComposition.getFeatures().add(phoneCallsFeature);
		servicesOrComposition.getFeatures().add(ipConnectivityFeature);
		
		
		// second evolution step
		HyFeatureType fleetManagementCardinality = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.OPTIONAL, secondDate, null, null);
		HyName fleetManagementName = HyFeatureCreationUtil.createName("Fleet Management", secondDate, null, null);
		HyFeature fleetManagementFeature = HyFeatureCreationUtil.createFeature(fleetManagementCardinality, fleetManagementName, firstDate, null);
		featureModel.getFeatures().add(fleetManagementFeature);
		
		HyGroupComposition servicesOrComposition2 = HyFeatureCreationUtil.createGroupComposition(secondDate, null, servicesOrComposition);
		servicesOrComposition2.setCompositionOf(servicesOrGroup);

		servicesOrComposition2.getFeatures().add(fleetManagementFeature);
		servicesOrComposition2.getFeatures().add(phoneCallsFeature);
		servicesOrComposition2.getFeatures().add(ipConnectivityFeature);
		
		
		
		
		
		HyConstraintFactory constraintFactory = HyConstraintFactory.eINSTANCE;
		HyConstraintModel constraintModel = constraintFactory.createHyConstraintModel();
//		constraintModel.setFeatureModel(featureModel);
		
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
		
		
//		if(constraintModel != null) {
//			// TODO take folder selected in eclipse
//			IFile file = ResourceUtil.getLocalFile("Example/" + "HyVarUseCases" + ".hyconstraint");
//			EcoreIOUtil.saveModelAs(constraintModel, file);
//		}
		
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
