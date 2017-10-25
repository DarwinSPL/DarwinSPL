package eu.hyvar.feature.example_creation.examples;

import java.util.Calendar;
import java.util.Date;

import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.contextValidity.HyValidityModel;
import eu.hyvar.evolution.HyEvolutionFactory;
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
import eu.hyvar.feature.HyRootFeature;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.mapping.HyMappingModel;
import de.darwinspl.preferences.DwProfile;

public class SmallEvolutionExample extends HyFMExample {

	@Override
	public HyFeatureModel createExample() {
		HyFeatureModel featureModel = HyFeatureFactory.eINSTANCE.createHyFeatureModel();
		
		HyFeature featureRoot = HyFeatureFactory.eINSTANCE.createHyFeature();
		HyName featureRootName = HyEvolutionFactory.eINSTANCE.createHyName();
		featureRootName.setName("Root");
		featureRoot.getNames().add(featureRootName);
		HyFeatureType featureRootCardinality = HyFeatureFactory.eINSTANCE.createHyFeatureType();
		featureRootCardinality.setType(HyFeatureTypeEnum.MANDATORY);
		featureRoot.getTypes().add(featureRootCardinality);
		
		HyRootFeature rootFeature = HyFeatureFactory.eINSTANCE.createHyRootFeature();
		rootFeature.setFeature(featureRoot);
		featureModel.getRootFeature().add(rootFeature);
		
		HyGroup rootGroup = HyFeatureFactory.eINSTANCE.createHyGroup();
		HyFeatureChild rootChild = HyFeatureFactory.eINSTANCE.createHyFeatureChild();
		rootChild.setChildGroup(rootGroup);
		rootChild.setParent(featureRoot);
		
		HyGroupType rootGroupCardinality = HyFeatureFactory.eINSTANCE.createHyGroupType();
		rootGroupCardinality.setType(HyGroupTypeEnum.AND);
		rootGroup.getTypes().add(rootGroupCardinality);

		HyGroupComposition rootGroupCompo = HyFeatureFactory.eINSTANCE.createHyGroupComposition();
		rootGroupCompo.setCompositionOf(rootGroup);
		
		HyFeature featureOne = HyFeatureFactory.eINSTANCE.createHyFeature();
		HyName featureOneName1 = HyEvolutionFactory.eINSTANCE.createHyName();
		featureOneName1.setName("FeatureOne");

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2016);
		calendar.set(Calendar.MONTH, Calendar.AUGUST);
		calendar.set(Calendar.DAY_OF_MONTH, 17);
		Date evolutionDate = calendar.getTime();
		
		featureOneName1.setValidUntil(evolutionDate);
		
		HyName featureOneName2 = HyEvolutionFactory.eINSTANCE.createHyName();
		featureOneName2.setName("Feature1");
		
		featureOneName2.setValidSince(evolutionDate);
		
		featureOne.getNames().add(featureOneName1);
		featureOne.getNames().add(featureOneName2);
		
		HyFeatureType featureOneCardinality = HyFeatureFactory.eINSTANCE.createHyFeatureType();
		featureOneCardinality.setType(HyFeatureTypeEnum.OPTIONAL);
		featureOne.getTypes().add(featureOneCardinality);
		
		rootGroupCompo.getFeatures().add(featureOne);
		
		featureModel.getFeatures().add(featureOne);
		featureModel.getFeatures().add(featureRoot);
		featureModel.getGroups().add(rootGroup);
		
		
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
