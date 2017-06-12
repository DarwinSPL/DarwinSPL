package de.darwinspl.configurator;

import java.util.ArrayList;
import java.util.List;

import de.darwinspl.configurator.expression.AtomicFeatureExpression;
import de.darwinspl.configurator.expression.AttributeSumExpression;
import eu.hyvar.dataValues.HyDataValuesFactory;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.dataValues.HyNumberValue;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyBooleanAttribute;
import eu.hyvar.feature.HyEnumAttribute;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyNumberAttribute;
import eu.hyvar.feature.expression.HyAdditionExpression;
import eu.hyvar.feature.expression.HyAtomicExpression;
import eu.hyvar.feature.expression.HyAttributeReferenceExpression;
import eu.hyvar.feature.expression.HyEqualExpression;
import eu.hyvar.feature.expression.HyExpression;
import eu.hyvar.feature.expression.HyExpressionFactory;
import eu.hyvar.feature.expression.HyGreaterExpression;
import eu.hyvar.feature.expression.HyIfPossibleExpression;
import eu.hyvar.feature.expression.HyLessExpression;
import eu.hyvar.feature.expression.HyMultiplicationExpression;
import eu.hyvar.feature.expression.HyNestedExpression;
import eu.hyvar.feature.expression.HySubtractionExpression;
import eu.hyvar.feature.expression.HyValueExpression;
import eu.hyvar.preferences.HyPreference;
import eu.hyvar.preferences.PreferencesFactory;

public class PreferenceBuilder {

	public enum Mode {
		MIN, MAX
	}

	private HyFeatureModel featureModel;

	private HyExpressionFactory expressionFactory;
	private HyPreference preference;

	public PreferenceBuilder(HyFeatureModel featureModel) {
		this.featureModel = featureModel;

		this.expressionFactory = HyExpressionFactory.eINSTANCE;
		this.preference = PreferencesFactory.eINSTANCE.createHyPreference();

	}

	private boolean rootExressionExist() {
		return preference.getRootExpression() != null;
	}

	private void addExpression(HyExpression expression) {
		if (rootExressionExist()) {
			HyExpression root = preference.getRootExpression();
			HyAdditionExpression additionExpression = expressionFactory.createHyAdditionExpression();
			additionExpression.setOperand1(root);
			additionExpression.setOperand2(expression);
			preference.setRootExpression(additionExpression);

		} else {
			preference.setRootExpression(expression);
		}
	}

	private HyExpression invertExpression(HyExpression expression) {
		HyNestedExpression nestedExpression = nestExpression(expression);

		HyValueExpression valueExpression = expressionFactory.createHyValueExpression();
		HyDataValuesFactory dataValuesFactory = HyDataValuesFactory.eINSTANCE;
		HyNumberValue value = dataValuesFactory.createHyNumberValue();
		value.setValue(0);
		valueExpression.setValue(value);

		HySubtractionExpression subtractionExpression = expressionFactory.createHySubtractionExpression();
		subtractionExpression.setOperand1(valueExpression);
		subtractionExpression.setOperand2(nestedExpression);

		return nestExpression(subtractionExpression);
	}

	private HyNestedExpression nestExpression(HyExpression expression) {
		if (expression instanceof HyNestedExpression) {
			return (HyNestedExpression) expression;
		} else {
			HyNestedExpression nestedExpression = expressionFactory.createHyNestedExpression();
			nestedExpression.setOperand(expression);
			return nestedExpression;
		}
	}

	private HyExpression createMaxFeaturesExpression() {
		HyIfPossibleExpression ipExpression = expressionFactory.createHyIfPossibleExpression();

		// preferences to select the most features
		for (HyFeature feature : featureModel.getFeatures()) {

			AtomicFeatureExpression referenceExpression = new AtomicFeatureExpression();
			referenceExpression.setFeature(feature);

			ipExpression.getOperands().add(referenceExpression);

		}
		return nestExpression(ipExpression);
	}

	public PreferenceBuilder addMaxFeatures() {
		addExpression(createMaxFeaturesExpression());
		return this;
	}

	public PreferenceBuilder addMinFeatures() {
		addExpression(invertExpression(createMaxFeaturesExpression()));
		return this;
	}

	private List<HyFeatureAttribute> getAttributesByName(String attributeName) {
		if (attributeName == null)
			return new ArrayList<HyFeatureAttribute>();
		List<HyFeatureAttribute> attributes = new ArrayList<HyFeatureAttribute>();
		for (HyFeature feature : featureModel.getFeatures()) {
			for (HyFeatureAttribute attribute : feature.getAttributes()) {
				for (HyName name : attribute.getNames()) {
					if (attributeName.equals(name.getName())) {
						attributes.add(attribute);
					}
				}
			}
		}
		return attributes;
	}

	public PreferenceBuilder addCustomAttribute(String attributeName, int value) {
		// addExpression(createCustomAttributeExpression(attributeName, value));
		addExpression(createCustomValueExpression(attributeName, value));
		return this;
	}

	public PreferenceBuilder addSingleCustomAttribute(HyNumberAttribute attribute, int value) {

		HyAttributeReferenceExpression attributeReferenceExpression = expressionFactory
				.createHyAttributeReferenceExpression();
		attributeReferenceExpression.setAttribute(attribute);
		attributeReferenceExpression.setFeature(attribute.getFeature());

		HyEqualExpression equalExpression = expressionFactory.createHyEqualExpression();
		equalExpression.setOperand1(attributeReferenceExpression);
		equalExpression.setOperand2(getValueExpression(value));

		AtomicFeatureExpression featureExpression = new AtomicFeatureExpression();
		featureExpression.setFeature(attribute.getFeature());

		HyMultiplicationExpression multiplicationExpression = expressionFactory.createHyMultiplicationExpression();
		multiplicationExpression.setOperand1(featureExpression);
		multiplicationExpression.setOperand2(equalExpression);

		addExpression(multiplicationExpression);
		return this;
	}

	// private HyExpression createCustomAttributeExpression(String
	// attributeName, int value) {
	//
	// HyIfPossibleExpression ipExpression =
	// expressionFactory.createHyIfPossibleExpression();
	//
	// for (HyFeatureAttribute attribute : getAttributesByName(attributeName)) {
	// if (attribute instanceof HyNumberAttribute) {
	// HyAttributeReferenceExpression attributeReferenceExpression =
	// expressionFactory
	// .createHyAttributeReferenceExpression();
	// attributeReferenceExpression.setAttribute(attribute);
	// attributeReferenceExpression.setFeature(attribute.getFeature());
	//
	// AtomicFeatureExpression featureExpression = new
	// AtomicFeatureExpression();
	// featureExpression.setFeature(attribute.getFeature());
	//
	// HyMultiplicationExpression multiplicationExpression = expressionFactory
	// .createHyMultiplicationExpression();
	// multiplicationExpression.setOperand1(attributeReferenceExpression);
	// multiplicationExpression.setOperand2(featureExpression);
	//
	// ipExpression.getOperands().add(multiplicationExpression);
	// }
	// }
	//
	// HyEqualExpression equalExpression =
	// expressionFactory.createHyEqualExpression();
	// equalExpression.setOperand1(getValueExpression(value));
	// equalExpression.setOperand2(ipExpression);
	//
	// return equalExpression;
	// }

	private HyExpression createNumberedAttributeExpression(String attributeName, boolean useDefaultValue) {
		HyIfPossibleExpression ifPossibleExpression = expressionFactory.createHyIfPossibleExpression();

		for (HyFeatureAttribute attribute : getAttributesByName(attributeName)) {
			if (attribute instanceof HyNumberAttribute) {
				ifPossibleExpression.getOperands().add(
						createSingleNumberedMaximumAttributeExpression((HyNumberAttribute) attribute, useDefaultValue));
			}
		}
		return nestExpression(ifPossibleExpression);
	}

	public PreferenceBuilder addMaxAttributeExpression(String attributeName, boolean useDefault) {
		addExpression(createNumberedAttributeExpression(attributeName, useDefault));
		return this;
	}

	public PreferenceBuilder addMinAttributeExpression(String attributeName, boolean useDefault) {
		addExpression(invertExpression(createNumberedAttributeExpression(attributeName, useDefault)));
		return this;
	}

	public HyPreference build() {
		return preference;
	}

	public PreferenceBuilder addBooleanPreferenceExpression(String attributeName, boolean value) {
		List<HyFeatureAttribute> attributes = getAttributesByName(attributeName);
		HyIfPossibleExpression ipExpression = expressionFactory.createHyIfPossibleExpression();
		for (HyFeatureAttribute attribute : attributes) {
			if (attribute instanceof HyBooleanAttribute) {
				HyBooleanAttribute booleanAttribute = (HyBooleanAttribute) attribute;

				HyAttributeReferenceExpression attributeReferenceExpression = expressionFactory
						.createHyAttributeReferenceExpression();
				attributeReferenceExpression.setAttribute(booleanAttribute);
				attributeReferenceExpression.setFeature(booleanAttribute.getFeature());

				HyEqualExpression equalExpression = expressionFactory.createHyEqualExpression();
				equalExpression.setOperand1(attributeReferenceExpression);
				equalExpression.setOperand2(getValueExpression(value ? 1 : 0));

				AtomicFeatureExpression featureExpression = new AtomicFeatureExpression();
				featureExpression.setFeature(attribute.getFeature());

				HyMultiplicationExpression multiplicationExpression = expressionFactory
						.createHyMultiplicationExpression();
				multiplicationExpression.setOperand1(equalExpression);
				multiplicationExpression.setOperand2(featureExpression);

				ipExpression.getOperands().add(multiplicationExpression);
			}
		}
		addExpression(ipExpression);
		return this;
	}

	public PreferenceBuilder addEnumPreferenceExpression(String attributeName, HyEnumLiteral enumLiteral) {
		HyIfPossibleExpression ipExpression = expressionFactory.createHyIfPossibleExpression();

		List<HyFeatureAttribute> attributes = getAttributesByName(attributeName);
		for (HyFeatureAttribute attribute : attributes) {
			if (attribute instanceof HyEnumAttribute) {
				HyAttributeReferenceExpression attributeReferenceExpression = expressionFactory
						.createHyAttributeReferenceExpression();
				attributeReferenceExpression.setAttribute(attribute);
				attributeReferenceExpression.setFeature(attribute.getFeature());

				HyEqualExpression equalExpression = expressionFactory.createHyEqualExpression();
				equalExpression.setOperand1(attributeReferenceExpression);
				equalExpression.setOperand2(getValueExpression(enumLiteral.getValue()));

				AtomicFeatureExpression featureExpression = new AtomicFeatureExpression();
				featureExpression.setFeature(attribute.getFeature());

				HyMultiplicationExpression multiplicationExpression = expressionFactory
						.createHyMultiplicationExpression();
				multiplicationExpression.setOperand1(equalExpression);
				multiplicationExpression.setOperand2(featureExpression);

				ipExpression.getOperands().add(multiplicationExpression);
			}
		}

		addExpression(ipExpression);
		return this;
	}

	private HyValueExpression getValueExpression(int value) {
		HyNumberValue numberValue = HyDataValuesFactory.eINSTANCE.createHyNumberValue();
		numberValue.setValue(value);
		HyValueExpression valueExpression = expressionFactory.createHyValueExpression();
		valueExpression.setValue(numberValue);
		return valueExpression;
	}

	private HyExpression createSingleNumberedMaximumAttributeExpression(HyNumberAttribute attribute,
			boolean useDefaultValue) {
		HyAtomicExpression atomicExpression;
		if (useDefaultValue) {
			atomicExpression = getValueExpression(((HyNumberAttribute) attribute).getDefault());
		} else {
			atomicExpression = createAttributeReferenceExpression(attribute);
		}

		AtomicFeatureExpression atomicFeatureExpression = createFeatureExpression(attribute.getFeature());

		HyMultiplicationExpression multiplicationExpression = createMultiplicationExpression(atomicExpression,
				atomicFeatureExpression);

		return multiplicationExpression;
	}

	public PreferenceBuilder addSingleNumberedAttributeMaximumExpression(HyNumberAttribute attribute,
			boolean useDefaultValue) {
		addExpression(createSingleNumberedMaximumAttributeExpression(attribute, useDefaultValue));
		return this;
	}

	public PreferenceBuilder addSingleNumberedAttributeMinimumExpression(HyNumberAttribute attribute,
			boolean useDefaultValue) {
		addExpression(createSingleNumberedMaximumAttributeExpression(attribute, useDefaultValue));
		return this;
	}

	public PreferenceBuilder addSingleEnumAttributeExpression(HyEnumAttribute attribute, HyEnumLiteral literal) {
		HyAttributeReferenceExpression attributeReferenceExpression = expressionFactory
				.createHyAttributeReferenceExpression();
		attributeReferenceExpression.setAttribute(attribute);
		attributeReferenceExpression.setFeature(attribute.getFeature());

		HyEqualExpression equalExpression = expressionFactory.createHyEqualExpression();
		equalExpression.setOperand1(attributeReferenceExpression);
		equalExpression.setOperand2(getValueExpression(literal.getValue()));

		AtomicFeatureExpression featureExpression = new AtomicFeatureExpression();
		featureExpression.setFeature(attribute.getFeature());

		HyMultiplicationExpression multiplicationExpression = expressionFactory.createHyMultiplicationExpression();
		multiplicationExpression.setOperand1(equalExpression);
		multiplicationExpression.setOperand2(featureExpression);

		addExpression(multiplicationExpression);
		return this;
	}

	public PreferenceBuilder addSingleBooleanExpression(HyFeatureAttribute attribute, boolean value) {
		HyAttributeReferenceExpression attributeReferenceExpression = expressionFactory
				.createHyAttributeReferenceExpression();
		attributeReferenceExpression.setAttribute(attribute);
		attributeReferenceExpression.setFeature(attribute.getFeature());

		HyEqualExpression equalExpression = expressionFactory.createHyEqualExpression();
		equalExpression.setOperand1(attributeReferenceExpression);
		equalExpression.setOperand2(getValueExpression(value ? 1 : 0));

		AtomicFeatureExpression featureExpression = new AtomicFeatureExpression();
		featureExpression.setFeature(attribute.getFeature());

		HyMultiplicationExpression multiplicationExpression = expressionFactory.createHyMultiplicationExpression();
		multiplicationExpression.setOperand1(equalExpression);
		multiplicationExpression.setOperand2(featureExpression);

		addExpression(multiplicationExpression);
		return this;
	}

	private HyExpression createCustomValueExpression(String attributeName, int value) {
		List<HyFeatureAttribute> attributes = getAttributesByName(attributeName);

		// fa
		HyExpression attributeSum = createNumberedAttributeSumExpression(attributes);

		// c
		HyExpression valueExpression = getValueExpression(value);

		// LEFT SIDE

		// fa - c
		attributeSum = createNumberedAttributeSumExpression(attributes);

		HyExpression diff = createSubtractionExpression(attributeSum, valueExpression);

		// (fa - c) * 2
		HyExpression multExp = createMultiplicationExpression(diff, getValueExpression(2));

		// fa > c
		attributeSum = createNumberedAttributeSumExpression(attributes);
		valueExpression = getValueExpression(value);
		HyExpression greaterExp = createGreaterExpression(attributeSum, valueExpression);

		// (fa > c) * (fa - c) * 2
		HyExpression multExp2 = createMultiplicationExpression(greaterExp, multExp);

		// fa - ((fa > c) * (fa - c) * 2)
		attributeSum = createNumberedAttributeSumExpression(attributes);
		HyExpression sub1 = createSubtractionExpression(attributeSum, multExp2);

		// RIGHT SIDE

		// c - fa
		attributeSum = createNumberedAttributeSumExpression(attributes);
		valueExpression = getValueExpression(value);
		HyExpression diffRight = createSubtractionExpression(valueExpression, attributeSum);

		// (c - fa) * 2
		HyExpression multExpRight = createMultiplicationExpression(diffRight, getValueExpression(2));

		// fa < c
		attributeSum = createNumberedAttributeSumExpression(attributes);
		valueExpression = getValueExpression(value);
		HyExpression lessExp = createLessExpression(attributeSum, valueExpression);

		// (fa > c) * (fa - c) * 2
		HyExpression multExp2Right = createMultiplicationExpression(lessExp, multExpRight);

		// fa - ((fa < c) * (c - fa) * 2)
		attributeSum = createNumberedAttributeSumExpression(attributes);
		HyExpression sub2 = createSubtractionExpression(attributeSum, multExp2Right);

		// fa - (fa > value) * (fa - value) * 2
		// + fa - (fa < value) * (value - fa) * 2
		return createAdditionExpression(sub1, sub2);
	}

	private AtomicFeatureExpression createFeatureExpression(HyFeature feature) {
		AtomicFeatureExpression atomicFeatureExpression = new AtomicFeatureExpression();
		atomicFeatureExpression.setFeature(feature);
		return atomicFeatureExpression;
	}

	private HyAttributeReferenceExpression createAttributeReferenceExpression(HyFeatureAttribute attribute) {
		HyAttributeReferenceExpression attributeReferenceExpression = expressionFactory
				.createHyAttributeReferenceExpression();
		attributeReferenceExpression.setAttribute(attribute);
		attributeReferenceExpression.setFeature(attribute.getFeature());
		return attributeReferenceExpression;
	}

	private HyAdditionExpression createAdditionExpression(HyExpression operand1, HyExpression operand2) {
		HyAdditionExpression additionExpression = expressionFactory.createHyAdditionExpression();
		additionExpression.setOperand1(operand1);
		additionExpression.setOperand2(operand2);
		return additionExpression;
	}

	private HySubtractionExpression createSubtractionExpression(HyExpression operand1, HyExpression operand2) {
		HySubtractionExpression subtractionExpression = expressionFactory.createHySubtractionExpression();
		subtractionExpression.setOperand1(operand1);
		subtractionExpression.setOperand2(operand2);
		return subtractionExpression;
	}

	private HyMultiplicationExpression createMultiplicationExpression(HyExpression operand1, HyExpression operand2) {
		HyMultiplicationExpression multiplicationExpression = expressionFactory.createHyMultiplicationExpression();
		multiplicationExpression.setOperand1(operand1);
		multiplicationExpression.setOperand2(operand2);
		return multiplicationExpression;
	}

	private HyGreaterExpression createGreaterExpression(HyExpression operand1, HyExpression operand2) {
		HyGreaterExpression greaterExpression = expressionFactory.createHyGreaterExpression();
		greaterExpression.setOperand1(operand1);
		greaterExpression.setOperand2(operand2);
		return greaterExpression;
	}

	private HyLessExpression createLessExpression(HyExpression operand1, HyExpression operand2) {
		HyLessExpression lessExpression = expressionFactory.createHyLessExpression();
		lessExpression.setOperand1(operand1);
		lessExpression.setOperand2(operand2);
		return lessExpression;
	}

	private HyExpression createNumberedAttributeSumExpression(List<HyFeatureAttribute> attributes) {
		HyFeatureAttribute lastAttribute = null;
		HyAdditionExpression addExp = null;
		boolean first = true;
		for (HyFeatureAttribute attribute : attributes) {

			if (lastAttribute != null) {
				if (first) {
					first = false;
					addExp = createAdditionExpression(createAttributeReferenceExpression(lastAttribute),createAttributeReferenceExpression(attribute));
				} else {
					addExp = createAdditionExpression(addExp, createAttributeReferenceExpression(attribute));
				}
			}
			lastAttribute = attribute;
		}

		return addExp;

	}

}
