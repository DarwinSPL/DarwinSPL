package de.darwinspl.util;

import java.util.Date;
import java.util.Random;

import eu.hyvar.dataValues.HyDataValuesFactory;
import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyBooleanAttribute;
import eu.hyvar.feature.HyEnumAttribute;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyNumberAttribute;
import eu.hyvar.feature.util.HyFeatureCreationUtil;

public class RandomAttributeGenerator {

	protected enum Type {
		ENUM, BOOLEAN, NUMBERED
	}

	private HyFeatureModel featureModel;
	private Date validSince;
	private Date validUntil;

	private int attributeNr = 0;
	private int enumNr = 0;

	public RandomAttributeGenerator(HyFeatureModel featureModel, Date validSince, Date validUntil) {
		this.featureModel = featureModel;
		this.validSince = validSince;
		this.validUntil = validUntil;
	}

	public HyFeatureModel generateAttributes(Type type) {

		HyFeatureAttribute attribute = createRandomAttribute(null, type);
		for (HyFeature feature : featureModel.getFeatures()) {
			feature.getAttributes().add(cloneAttribute(attribute));
		}

		return featureModel;
	}

	private HyFeatureAttribute cloneAttribute(HyFeatureAttribute attribute) {
		HyFeatureAttribute clone = null;
		if (attribute instanceof HyNumberAttribute) {
			clone = HyFeatureFactory.eINSTANCE.createHyNumberAttribute();
			((HyNumberAttribute) clone).setMin(((HyNumberAttribute) attribute).getMin());
			((HyNumberAttribute) clone).setMax(((HyNumberAttribute) attribute).getMax());
			((HyNumberAttribute) clone).setDefault(((HyNumberAttribute) attribute).getDefault());
		} else if (attribute instanceof HyEnumAttribute) {
			clone = HyFeatureFactory.eINSTANCE.createHyEnumAttribute();
			((HyEnumAttribute) clone).setEnumType(((HyEnumAttribute) attribute).getEnumType());
		} else if (attribute instanceof HyBooleanAttribute) {
			clone = HyFeatureFactory.eINSTANCE.createHyBooleanAttribute();
		}

		HyName name = HyFeatureCreationUtil.createName(attribute.getNames().get(0).getName(), validSince, validUntil,
				null);
		clone.getNames().add(name);
		return clone;
	}

	private HyFeatureAttribute createRandomAttribute(HyFeature feature, Type type) {
		HyFeatureAttribute attribute = null;
		HyName name = HyFeatureCreationUtil.createName("attribute " + attributeNr++, validSince, validUntil, null);
		switch (type) {
		case BOOLEAN:
			attribute = HyFeatureCreationUtil.createBooleanAttribute(validSince, validUntil, name);
			break;
		case ENUM:
			attribute = HyFeatureCreationUtil.createEnumAttribute(validSince, validUntil, name);
			HyEnum hyEnum = createHyEnum();
			featureModel.getEnums().add(hyEnum);
			((HyEnumAttribute) attribute).setEnumType(hyEnum);
			break;
		case NUMBERED:
		default:
			attribute = HyFeatureCreationUtil.createNumberAttribute(name, validSince, validUntil);

			int min = new Random().nextInt(1000);
			int max = new Random().nextInt(1000) + min;
			int def = new Random().nextInt(max - min + 1) + min;

			((HyNumberAttribute) attribute).setMin(min);
			((HyNumberAttribute) attribute).setMax(max);
			((HyNumberAttribute) attribute).setDefault(def);

			break;
		}
		attribute.setFeature(feature);
		assert (attribute != null);
		return attribute;
	}

	private HyEnum createHyEnum() {
		HyEnum hyEnum = HyDataValuesFactory.eINSTANCE.createHyEnum();
		hyEnum.setValidSince(validSince);
		hyEnum.setValidUntil(validUntil);
		hyEnum.setName("Enum " + ++enumNr);

		HyEnumLiteral lit1 = HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
		HyEnumLiteral lit2 = HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();
		HyEnumLiteral lit3 = HyDataValuesFactory.eINSTANCE.createHyEnumLiteral();

		lit1.setEnum(hyEnum);
		lit1.setName("Enum " + enumNr + " lit 1");
		lit1.setValidSince(validSince);
		lit1.setValidUntil(validUntil);

		lit2.setEnum(hyEnum);
		lit2.setName("Enum " + enumNr + " lit 2");
		lit2.setValidSince(validSince);
		lit2.setValidUntil(validUntil);

		lit3.setEnum(hyEnum);
		lit3.setName("Enum " + enumNr + " lit 3");
		lit3.setValidSince(validSince);
		lit3.setValidUntil(validUntil);

		return hyEnum;
	}

}
