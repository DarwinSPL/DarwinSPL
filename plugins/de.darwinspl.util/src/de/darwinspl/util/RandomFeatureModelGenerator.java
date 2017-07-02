package de.darwinspl.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import eu.hyvar.dataValues.HyDataValuesFactory;
import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyBooleanAttribute;
import eu.hyvar.feature.HyEnumAttribute;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
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
import eu.hyvar.feature.HyStringAttribute;
import eu.hyvar.feature.util.HyFeatureCreationUtil;

public class RandomFeatureModelGenerator {

	private HyFeatureModel featureModel;

	private int maxSizeOfGroups;
	private int numberOfFeatures;
	private int numberOfFeatureAttributes;
	private int numberOfFeatureModelAttributes;

	private Date validSince;
	private Date validUntil;

	private List<HyFeature> features = new ArrayList<HyFeature>();

	private int featureNr = 0;
	private int attributeNr = 0;
	private int enumNr = 0;

	protected RandomFeatureModelGenerator(int numberOfFeatures, int maxSizeOfGroups, int numberOfFeatureAttributes,
			int numberOfFeatureModelAttributes) {
		this.maxSizeOfGroups = maxSizeOfGroups;
		this.numberOfFeatures = numberOfFeatures;
		this.numberOfFeatureAttributes = numberOfFeatureAttributes;
		this.numberOfFeatureModelAttributes = numberOfFeatureModelAttributes;

		HyFeatureFactory featureFactory = HyFeatureFactory.eINSTANCE;
		featureModel = featureFactory.createHyFeatureModel();
	}

	public HyFeatureModel generate() {

		HyName rootName = HyFeatureCreationUtil.createName("root", validSince, validUntil, null);
		HyFeatureType rootType = HyFeatureCreationUtil.createFeatureType(HyFeatureTypeEnum.MANDATORY, validSince,
				validUntil, null);
		HyFeature rootFeature = HyFeatureCreationUtil.createFeature(rootType, rootName, validSince, validUntil);
		HyRootFeature root = HyFeatureCreationUtil.createRootFeature(rootFeature, validSince, validUntil, null);
		featureModel.getFeatures().add(rootFeature);
		featureModel.getRootFeature().add(root);
		features.add(rootFeature);

		for (int i = 0; i < features.size() && features.size() < numberOfFeatures; i++) {
			addChildren(features.get(i));
		}

		RandomAttributeGenerator attributeGenerator = new RandomAttributeGenerator(featureModel, numberOfFeatureAttributes, numberOfFeatureModelAttributes, validSince, validUntil);
		featureModel = attributeGenerator.generateAttributes();

		return featureModel;
	}

	private void addChildren(HyFeature parent) {
		HyGroupType groupType = HyFeatureCreationUtil.createGroupType(HyGroupTypeEnum.get(new Random().nextInt(3)),
				validSince, validUntil, null);
		HyGroup group = HyFeatureCreationUtil.createGroup(groupType, validSince, validUntil);
		featureModel.getGroups().add(group);

		HyFeatureChild child = HyFeatureCreationUtil.createFeatureChild(validSince, validUntil, null);
		child.setParent(parent);
		child.setChildGroup(group);

		HyGroupComposition groupComposition = HyFeatureCreationUtil.createGroupComposition(validSince, validUntil,
				null);
		groupComposition.setCompositionOf(group);

		int numberOfChildren = new Random().nextInt(maxSizeOfGroups) + 1;

		for (int i = 0; i < numberOfChildren; i++) {
			if (featureNr < numberOfFeatures) {
				HyFeature feature = createFeature();
				featureModel.getFeatures().add(feature);
				groupComposition.getFeatures().add(feature);
				features.add(feature);
			}
		}
	}

	private HyFeature createFeature() {
		HyName name = HyFeatureCreationUtil.createName("feature " + featureNr++, validSince, validUntil, null);
		HyFeatureType featureType = HyFeatureCreationUtil
				.createFeatureType(HyFeatureTypeEnum.get(new Random().nextInt(2)), validSince, validUntil, null);
		HyFeature feature = HyFeatureCreationUtil.createFeature(featureType, name, validSince, validUntil);

		return feature;
	}

}
