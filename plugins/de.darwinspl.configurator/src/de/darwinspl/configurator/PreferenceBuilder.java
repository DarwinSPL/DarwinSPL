package de.darwinspl.configurator;

import java.util.ArrayList;
import java.util.List;

import de.darwinspl.configurator.expression.AtomicFeatureExpression;
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
		MIN,
		MAX,
		DEFAULT
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
	
	public PreferenceBuilder addCustomAttribute(String attributeName, Mode mode, int value) {
		addExpression(createCustomAttributeExpression(attributeName, mode, value));
		return this;
	}
	
	private HyExpression createCustomAttributeExpression(String attributeName,Mode mode, int value){
		HySubtractionExpression subtractionExpression = expressionFactory.createHySubtractionExpression();
		HyNumberValue numberValue = HyDataValuesFactory.eINSTANCE.createHyNumberValue();
		numberValue.setValue(value);
		HyValueExpression valueExpression = expressionFactory.createHyValueExpression();
		valueExpression.setValue(numberValue);
		
		HyIfPossibleExpression ipExpression = expressionFactory.createHyIfPossibleExpression();
		
		for(HyFeatureAttribute attribute : getAttributesByName(attributeName)) {
			if(attribute instanceof HyNumberAttribute) {
				HyNumberAttribute numberedAttribute = (HyNumberAttribute)attribute;
				int val = 0;
				if(mode == Mode.MIN) {
					val = numberedAttribute.getMin();
				} else if (mode == Mode.MAX) {
					val = numberedAttribute.getMax();
				} else if (mode == Mode.DEFAULT) {
					val = numberedAttribute.getDefault();
				}
				
				HyValueExpression valExpression = expressionFactory.createHyValueExpression();
				HyNumberValue numberVal = HyDataValuesFactory.eINSTANCE.createHyNumberValue();
				numberVal.setValue(val);
				valExpression.setValue(numberVal);
				
				AtomicFeatureExpression atomicFeatureExpression = new AtomicFeatureExpression();
				atomicFeatureExpression.setFeature(numberedAttribute.getFeature());
				
				HyMultiplicationExpression multiplicationExpression = expressionFactory.createHyMultiplicationExpression();
				multiplicationExpression.setOperand1(valExpression);
				multiplicationExpression.setOperand2(atomicFeatureExpression);
				
				ipExpression.getOperands().add(multiplicationExpression);
			}
		}
		
		
		subtractionExpression.setOperand1(ipExpression);
		subtractionExpression.setOperand2(valueExpression);
		
		HyGreaterExpression greaterExpression = expressionFactory.createHyGreaterExpression();
		greaterExpression.setOperand1(subtractionExpression);
		HyNumberValue zero  = HyDataValuesFactory.eINSTANCE.createHyNumberValue();
		zero.setValue(0);
		HyValueExpression zeroExpression = expressionFactory.createHyValueExpression();
		zeroExpression.setValue(zero);
		greaterExpression.setOperand2(zeroExpression);
		
		HyMultiplicationExpression multi = expressionFactory.createHyMultiplicationExpression();
		multi.setOperand1(subtractionExpression);
		HyNumberValue two  = HyDataValuesFactory.eINSTANCE.createHyNumberValue();
		two.setValue(2);
		HyValueExpression twoExpression = expressionFactory.createHyValueExpression();
		twoExpression.setValue(two);
		multi.setOperand2(twoExpression);
		
		HyMultiplicationExpression multi2 = expressionFactory.createHyMultiplicationExpression();
		multi2.setOperand1(greaterExpression);
		multi2.setOperand2(multi);
		
		HySubtractionExpression sub2 = expressionFactory.createHySubtractionExpression();
		sub2.setOperand1(subtractionExpression);
		sub2.setOperand2(multi2);
		
		HyLessExpression greaterExpression2 = expressionFactory.createHyLessExpression();
		greaterExpression.setOperand1(subtractionExpression);
		HyNumberValue zero2  = HyDataValuesFactory.eINSTANCE.createHyNumberValue();
		zero2.setValue(0);
		HyValueExpression zeroExpression2 = expressionFactory.createHyValueExpression();
		zeroExpression2.setValue(zero2);
		greaterExpression2.setOperand2(zeroExpression2);
		
		HyMultiplicationExpression multia = expressionFactory.createHyMultiplicationExpression();
		multia.setOperand1(subtractionExpression);
		HyNumberValue two2  = HyDataValuesFactory.eINSTANCE.createHyNumberValue();
		two2.setValue(2);
		HyValueExpression twoExpression2 = expressionFactory.createHyValueExpression();
		twoExpression2.setValue(two2);
		multia.setOperand2(twoExpression2);
		
		HyMultiplicationExpression multi22 = expressionFactory.createHyMultiplicationExpression();
		multi22.setOperand1(greaterExpression2);
		multi22.setOperand2(multia);
		
		HySubtractionExpression sub22 = expressionFactory.createHySubtractionExpression();
		sub22.setOperand1(subtractionExpression);
		sub22.setOperand2(multi22);
		
		HyAdditionExpression additionExpression = expressionFactory.createHyAdditionExpression();
		additionExpression.setOperand1(sub2);
		additionExpression.setOperand2(sub22);
		
		return additionExpression;
	}

	private HyExpression createMaxAttributeExpression(String attributeName, NumberedAttributeMode mode) {
		HyIfPossibleExpression ifPossibleExpression = expressionFactory.createHyIfPossibleExpression();

		for (HyFeatureAttribute attribute : getAttributesByName(attributeName)) {
			HyAttributeReferenceExpression attributeReferenceExpression = expressionFactory
					.createHyAttributeReferenceExpression();
			attributeReferenceExpression.setAttribute(attribute);
			attributeReferenceExpression.setFeature(attribute.getFeature());
				
			int intValue = 0;
			if(mode == NumberedAttributeMode.MIN) {
				intValue = ((HyNumberAttribute) attribute).getMin();
			} else if (mode == NumberedAttributeMode.MAX){
				intValue = ((HyNumberAttribute) attribute).getMax();
			} else if (mode == NumberedAttributeMode.DEFAULT) {
				intValue = ((HyNumberAttribute) attribute).getDefault(); 
			}
			
			HyNumberValue value = HyDataValuesFactory.eINSTANCE.createHyNumberValue();
			value.setValue(intValue);
			HyValueExpression valueExpression = expressionFactory.createHyValueExpression();
			valueExpression.setValue(value);

			AtomicFeatureExpression atomicFeatureExpression = new AtomicFeatureExpression();
			atomicFeatureExpression.setFeature(attribute.getFeature());

			HyMultiplicationExpression multiplicationExpression = expressionFactory.createHyMultiplicationExpression();
			multiplicationExpression.setOperand1(valueExpression);
			multiplicationExpression.setOperand2(atomicFeatureExpression);

			ifPossibleExpression.getOperands().add(multiplicationExpression);
		}
		return nestExpression(ifPossibleExpression);
	}

	public PreferenceBuilder addMaxAttributeExpression(String attributeName, NumberedAttributeMode mode) {
		addExpression(createMaxAttributeExpression(attributeName, mode));
		return this;
	}

	public PreferenceBuilder addMinAttributeExpression(String attributeName, NumberedAttributeMode mode) {
		addExpression(invertExpression(createMaxAttributeExpression(attributeName, mode)));
		return this;
	}

	public HyPreference build() {
		return preference;
	}
	
	public PreferenceBuilder addBooleanPreferenceExpression(String attributeName, boolean value) {
		List<HyFeatureAttribute> attributes = getAttributesByName(attributeName);
		HyIfPossibleExpression ipExpression = expressionFactory.createHyIfPossibleExpression();
		for(HyFeatureAttribute attribute : attributes) {
			if(attribute instanceof HyBooleanAttribute) {
				HyBooleanAttribute booleanAttribute = (HyBooleanAttribute) attribute;
				
				HyAttributeReferenceExpression attributeReferenceExpression = expressionFactory.createHyAttributeReferenceExpression();
				attributeReferenceExpression.setAttribute(booleanAttribute);
				attributeReferenceExpression.setFeature(booleanAttribute.getFeature());
				
				HyEqualExpression equalExpression = expressionFactory.createHyEqualExpression();
				equalExpression.setOperand1(attributeReferenceExpression);
				equalExpression.setOperand2(getValueExpression(value ? 1 : 0));
				
				ipExpression.getOperands().add(equalExpression);
			}
		}
		addExpression(ipExpression);
		return this;
	}
	
	public PreferenceBuilder addEnumPreferenceExpression(String attributeName, HyEnumLiteral enumLiteral) {
		HyIfPossibleExpression ipExpression = expressionFactory.createHyIfPossibleExpression();
		
		List<HyFeatureAttribute> attributes = getAttributesByName(attributeName);
		for(HyFeatureAttribute attribute : attributes) {
			if(attribute instanceof HyEnumAttribute) {
				HyAttributeReferenceExpression attributeReferenceExpression = expressionFactory.createHyAttributeReferenceExpression();
				attributeReferenceExpression.setAttribute(attribute);
				attributeReferenceExpression.setFeature(attribute.getFeature());
				
				HyEqualExpression equalExpression = expressionFactory.createHyEqualExpression();
				equalExpression.setOperand1(attributeReferenceExpression);
				equalExpression.setOperand2(getValueExpression(enumLiteral.getValue()));
				
				ipExpression.getOperands().add(equalExpression);
			}
		}
		
		addExpression(ipExpression);
		return this;
	}
	
	
	
	private HyValueExpression getValueExpression(int value){
		HyNumberValue numberValue = HyDataValuesFactory.eINSTANCE.createHyNumberValue();
		numberValue.setValue(value);
		HyValueExpression valueExpression = expressionFactory.createHyValueExpression();
		valueExpression.setValue(numberValue);
		return valueExpression;
	}

}
