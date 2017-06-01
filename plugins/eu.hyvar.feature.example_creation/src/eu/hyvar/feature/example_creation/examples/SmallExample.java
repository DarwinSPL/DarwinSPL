package eu.hyvar.feature.example_creation.examples;

import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.contextValidity.HyValidityModel;
import eu.hyvar.evolution.HyEvolutionFactory;
import eu.hyvar.evolution.HyName;
import eu.hyvar.evolution.factory.HyEvolutionFactoryWithIds;
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
import eu.hyvar.feature.HyRootFeature;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.impl.custom.HyFeatureFactoryWithIds;
import eu.hyvar.feature.mapping.HyMappingModel;
import eu.hyvar.preferences.HyProfile;

public class SmallExample extends HyFMExample {

	@Override
	public HyFeatureModel createExample() {
		HyFeatureFactory factory = HyFeatureFactoryWithIds.eINSTANCE;
		HyEvolutionFactory evoFactory = HyEvolutionFactoryWithIds.eINSTANCE;
		HyFeatureModel featureModel = factory.createHyFeatureModel();
		
		HyRootFeature rootFeature = factory.createHyRootFeature();
		featureModel.getRootFeature().add(rootFeature);
		
		HyFeature rootFeatureFeature = factory.createHyFeature();
		HyName rootFeatureFeatureName = evoFactory.createHyName();
		rootFeatureFeatureName.setName("TheRoot");
		rootFeatureFeature.getNames().add(rootFeatureFeatureName);
		HyFeatureType rootFeatureFeatureType = factory.createHyFeatureType();
		rootFeatureFeatureType.setType(HyFeatureTypeEnum.MANDATORY);
		rootFeatureFeature.getTypes().add(rootFeatureFeatureType);
		rootFeature.setFeature(rootFeatureFeature);
		featureModel.getFeatures().add(rootFeatureFeature);
		
		
		HyFeatureChild featureChild = factory.createHyFeatureChild();
		featureChild.setParent(rootFeatureFeature);
		
		HyGroup group = factory.createHyGroup();
		group.getChildOf().add(featureChild);
		HyGroupType groupType = factory.createHyGroupType();
		groupType.setType(HyGroupTypeEnum.AND);
		group.getTypes().add(groupType);
		featureModel.getGroups().add(group);
		
		HyGroupComposition groupComposition = factory.createHyGroupComposition();
		groupComposition.setCompositionOf(group);
		
		HyFeature subFeature1 = factory.createHyFeature();
		HyName subFeature1Name = evoFactory.createHyName();
		subFeature1Name.setName("SubFeature1");
		subFeature1.getNames().add(subFeature1Name);
		HyFeatureType subFeature1Type = factory.createHyFeatureType();
		subFeature1Type.setType(HyFeatureTypeEnum.MANDATORY);
		subFeature1.getTypes().add(subFeature1Type);
		featureModel.getFeatures().add(subFeature1);
		
		HyFeature subFeature2 = factory.createHyFeature();
		HyName subFeature2Name = evoFactory.createHyName();
		subFeature2Name.setName("SubFeature2");
		subFeature2.getNames().add(subFeature2Name);
		HyFeatureType subFeature2Type = factory.createHyFeatureType();
		subFeature2Type.setType(HyFeatureTypeEnum.OPTIONAL);
		subFeature2.getTypes().add(subFeature2Type);
		featureModel.getFeatures().add(subFeature2);
		
		groupComposition.getFeatures().add(subFeature1);
		groupComposition.getFeatures().add(subFeature2);
		
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
	public HyProfile createPreferenceModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HyConfiguration createConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

}
