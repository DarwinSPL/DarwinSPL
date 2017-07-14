package de.darwinspl.configurator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.darwinspl.configurator.expression.AtomicFeatureExpression;
import eu.hyvar.dataValues.HyDataValuesFactory;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.dataValues.HyNumberValue;
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
import eu.hyvar.feature.util.HyFeatureEvolutionUtil;
import eu.hyvar.preferences.HyPreference;
import eu.hyvar.preferences.PreferencesFactory;

/**
 * 
 * @author Jeremias Wrensch
 * 
 * Provides methods to encode optimizationproblems in hyexpression as preferences.
 *
 */
public class PreferenceBuilder {

	public enum Mode {
		MIN, MAX
	}

	private HyFeatureModel featureModel;

	private HyExpressionFactory expressionFactory;
	private HyExpression preferenceExpression;

	private Date date;

	/**
	 * 
	 * @param featureModel: 
	 * @param date: date of evolution
	 */
	public PreferenceBuilder(HyFeatureModel featureModel, Date date) {
		this.featureModel = featureModel;
		this.date = date;
		this.expressionFactory = HyExpressionFactory.eINSTANCE;
	}

	/**
	 * extends expression by adding the another
	 * 
	 * @param expression
	 */
	private void addExpression(HyExpression expression) {
		if (preferenceExpression == null) {
			preferenceExpression = expression;
		} else {
			HyAdditionExpression additionExpression = expressionFactory.createHyAdditionExpression();
			additionExpression.setOperand1(preferenceExpression);
			additionExpression.setOperand2(expression);
			preferenceExpression = additionExpression;

		}
	}

	/**
	 * Basically performs a conversion on the given expression
	 * 
	 * @param expression that should be inverted
	 * @return inverted expression
	 */
	private HyExpression invertExpression(HyExpression expression) {
		// (0 - (expression))
		return nestExpression(sub(value(0), nestExpression(expression)));
	}

	/**
	 * adds brackets to expression
	 * @param expression
	 * @return expression in brackets
	 */
	private HyNestedExpression nestExpression(HyExpression expression) {
		if (expression instanceof HyNestedExpression) {
			return (HyNestedExpression) expression;
		} else {
			HyNestedExpression nestedExpression = expressionFactory.createHyNestedExpression();
			nestedExpression.setOperand(expression);
			return nestedExpression;
		}
	}

	/**
	 * 
	 * creates expression that represents the optimizationproblem of maximizing the number of features
	 * 
	 * @param selectedFeatures: only selected features will be considered 
	 * @return
	 */
	private HyExpression createMaxFeaturesExpression(List<HyFeature> selectedFeatures) {
		HyIfPossibleExpression ipExpression = expressionFactory.createHyIfPossibleExpression();

		// preferences to select the most features
		for (HyFeature feature : featureModel.getFeatures()) {
			if (selectedFeatures.contains(feature)) {
				ipExpression.getOperands().add(feature(feature));
			}
		}
		return nestExpression(ipExpression);
	}

	/**
	 * creates an expression for maximizing the number of features and adds it to the global expression
	 * 
	 * @param selectedFeatures: only selected features will be considered  
	 * @return
	 */
	public PreferenceBuilder addMaxFeatures(List<HyFeature> selectedFeatures) {
		addExpression(createMaxFeaturesExpression(selectedFeatures));
		return this;
	}

	/**
	 * creates and inverts a maxFeatureExpression to create expression that represents the minimization for the number of feature.
	 * 
	 * @param selectedFeatures: only selected features will be considered 
	 * @return preferenceBuilder
	 */
	public PreferenceBuilder addMinFeatures(List<HyFeature> selectedFeatures) {
		addExpression(invertExpression(createMaxFeaturesExpression(selectedFeatures)));
		return this;
	}

	/**
	 * Returns all attributes of the feature model indentified by the name
	 * @param attributeName name of the attribute
	 * @return List of attributes with the given name
	 */
	private List<HyFeatureAttribute> getAttributesByName(String attributeName) {
		if (attributeName == null)
			return new ArrayList<HyFeatureAttribute>();
		List<HyFeatureAttribute> attributes = new ArrayList<HyFeatureAttribute>();
		for (HyFeature feature : featureModel.getFeatures()) {
			for (HyFeatureAttribute attribute : feature.getAttributes()) {
				if (attributeName.equals(HyFeatureEvolutionUtil.getName(attribute.getNames(), date).getName())) {
					attributes.add(attribute);
				}

			}
		}
		return attributes;
	}

	/**
	 * adds expression that represents the optimizing problem of optimizing against a certain value
	 * 
	 * @param attributeName feature-model-attribute name
	 * @param selectedFeatures 
	 * @param value desired value
	 * @return
	 */
	public PreferenceBuilder addCustomNumberedAttributeExpression(String attributeName, List<HyFeature> selectedFeatures, int value) {
		addExpression(createCustomValueExpression(attributeName, selectedFeatures, value));
		return this;
	}

	/**
	 * adds expression that represents the optimizing problem of optimizing against a certain value
	 * 
	 * @param attribute
	 * @param value
	 * @return
	 */
	public PreferenceBuilder addSingleCustomAttribute(HyNumberAttribute attribute, int value) {

		// f
		HyFeature feature = attribute.getFeature();
		HyMultiplicationExpression f1 = mul(feature(feature), attribute(attribute));
		HyMultiplicationExpression f2 = mul(feature(feature), attribute(attribute));
		HyMultiplicationExpression f3 = mul(feature(feature), attribute(attribute));
		HyMultiplicationExpression f4 = mul(feature(feature), attribute(attribute));
		
		// c
		HyExpression c1 = value(value);
		HyExpression c2 = value(value);
		HyExpression c3 = value(value);
		HyExpression c4 = value(value);
		
		// ((f > c) * (f - c) + (f < c) * (c - f))
		addExpression(add(mul(gt(f1, c1), sub(c2, f2)), mul(lt(f3, c3), sub(f4, c4))));
		
		return this;
	}

	/**
	 * 
	 * @param attributeName name of the feature model attribute
	 * @param selectedFeatures only selected features will be considered 
	 * @param useDefaultValue should the default value of the attribute be used
	 * @return
	 */
	private HyExpression createMaxMultiNumberedAttributeExpression(String attributeName, List<HyFeature> selectedFeatures,
			boolean useDefaultValue) {
		HyIfPossibleExpression ifPossibleExpression = expressionFactory.createHyIfPossibleExpression();

		for (HyFeatureAttribute attribute : getAttributesByName(attributeName)) {
			if (attribute instanceof HyNumberAttribute && selectedFeatures.contains(attribute.getFeature())) {
				ifPossibleExpression.getOperands().add(
						createMaxNumberedAttributeExpression((HyNumberAttribute) attribute, useDefaultValue));
			}
		}
		return nestExpression(ifPossibleExpression);
	}

	/**
	 * 
	 * @param attributeName name of the feature model attribute
	 * @param selectedFeatures only selected features will be considered 
	 * @param useDefault should the default value of the attribute be used
	 * @return
	 */
	public PreferenceBuilder addMaxMultiNumberedAttributeExpression(String attributeName, List<HyFeature> selectedFeatures,
			boolean useDefault) {
		addExpression(createMaxMultiNumberedAttributeExpression(attributeName, selectedFeatures, useDefault));
		return this;
	}

	/**
	 * 
	 * @param attributeName name of the feature model attribute
	 * @param selectedFeatures only selected features will be considered 
	 * @param useDefault should the default value of the attribute be used
	 * @return
	 */
	public PreferenceBuilder addMinAttributeExpression(String attributeName, List<HyFeature> selectedFeatures,
			boolean useDefault) {
		addExpression(invertExpression(createMaxMultiNumberedAttributeExpression(attributeName, selectedFeatures, useDefault)));
		return this;
	}

	/**
	 * creates a preference out of the created expression
	 * @return the created preference
	 */
	public HyPreference build() {
		HyPreference preference = PreferencesFactory.eINSTANCE.createHyPreference();
		preference.setRootExpression(preferenceExpression);
		return preference;
	}
	
	/**
	 * 
	 * @param attributeName name of the feature model attribute
	 * @param selectedFeatures only selected features will be considered 
	 * @param useDefault should the default value of the attribute be used
	 * @return
	 */
	public PreferenceBuilder addBooleanPreferenceExpression(String attributeName, List<HyFeature> selectedFeatures,
			boolean value) {
		List<HyFeatureAttribute> attributes = getAttributesByName(attributeName);
		HyIfPossibleExpression ipExpression = expressionFactory.createHyIfPossibleExpression();
		for (HyFeatureAttribute attribute : attributes) {
			if (attribute instanceof HyBooleanAttribute && selectedFeatures.contains(attribute.getFeature())) {
				ipExpression.getOperands().add(createBooleanAttributeExpression(attribute, value));
			}
		}
		addExpression(ipExpression);
		return this;
	}

	/**
	 * 
	 * @param selectedFeatures only selected features will be considered 
	 * @param useDefault should the default value of the attribute be used
	 * @param enumLiteral
	 * @return
	 */
	public PreferenceBuilder addEnumPreferenceExpression(String attributeName, List<HyFeature> selectedFeatures,
			HyEnumLiteral enumLiteral) {
		HyIfPossibleExpression ipExpression = expressionFactory.createHyIfPossibleExpression();
		List<HyFeatureAttribute> attributes = getAttributesByName(attributeName);
		for (HyFeatureAttribute attribute : attributes) {
			if (attribute instanceof HyEnumAttribute && selectedFeatures.contains(attribute.getFeature())) {
				ipExpression.getOperands()
						.add(createEnumAttributeExpression((HyEnumAttribute) attribute, enumLiteral));
			}
		}

		addExpression(ipExpression);
		return this;
	}


	/**
	 * 
	 * creates expression that represents the optimization problem of maximizing a single numbered attribute
	 * 
	 * @param attribute that should be optimized
	 * @param useDefaultValue should the default value of the attribute be used
	 * @return
	 */
	private HyExpression createMaxNumberedAttributeExpression(HyNumberAttribute attribute,
			boolean useDefaultValue) {
		HyAtomicExpression atomicExpression;
		if (useDefaultValue) {
			atomicExpression = value(((HyNumberAttribute) attribute).getDefault());
		} else {
			atomicExpression = attribute(attribute);
		}

		// attribute * feature
		return mul(atomicExpression, feature(attribute.getFeature()));
	}

	/**
	 * 
	 * 
	 * @param attribute
	 * @param useDefaultValue should the default value of the attribute be used
	 * @return
	 */
	public PreferenceBuilder addSingleNumberedAttributeMaximumExpression(HyNumberAttribute attribute,
			boolean useDefaultValue) {
		addExpression(createMaxNumberedAttributeExpression(attribute, useDefaultValue));
		return this;
	}

	/**
	 * 
	 * @param attribute
	 * @param useDefaultValue should the default value of the attribute be used
	 * @return
	 */
	public PreferenceBuilder addSingleNumberedAttributeMinimumExpression(HyNumberAttribute attribute,
			boolean useDefaultValue) {
		addExpression(createMaxNumberedAttributeExpression(attribute, useDefaultValue));
		return this;
	}

	/**
	 * 
	 * @param attribute
	 * @param literal
	 * @return
	 */
	public PreferenceBuilder addSingleEnumAttributeExpression(HyEnumAttribute attribute, HyEnumLiteral literal) {
		addExpression(createEnumAttributeExpression(attribute, literal));
		return this;
	}

	/**
	 * 
	 * @param attribute
	 * @param literal
	 * @return
	 */
	private HyExpression createEnumAttributeExpression(HyEnumAttribute attribute, HyEnumLiteral literal) {
		// (attribute = literal) * feature
		return mul(eq(attribute(attribute), value(literal.getValue())), feature(attribute.getFeature()));
	}

	/**
	 * 
	 * @param attribute
	 * @param value
	 * @return
	 */
	public PreferenceBuilder addSingleBooleanExpression(HyFeatureAttribute attribute, boolean value) {
		addExpression(createBooleanAttributeExpression(attribute, value));
		return this;
	}

	/**
	 * 
	 * @param attribute
	 * @param value
	 * @return
	 */
	private HyExpression createBooleanAttributeExpression(HyFeatureAttribute attribute, boolean value) {
		// convert true to 1 and 0 to false
		int convertedValue;
		if(value) {
			convertedValue = 1;
		} else {
			convertedValue = 0;
		}
		// (attribute = value) * feature
		return mul(eq(attribute(attribute), value(convertedValue)), feature(attribute.getFeature()));
	}

	/**
	 * 
	 * @param attributeName name of the feature model attribute
	 * @param selectedFeatures only selected features will be considered 
	 * @param value
	 * @return
	 */
	private HyExpression createCustomValueExpression(String attributeName, List<HyFeature> selectedFeatures,
			int value) {
		List<HyFeatureAttribute> attributes = getAttributesByName(attributeName);

		// fa
		HyExpression fa1 = createNumberedAttributeSumExpression(attributes, selectedFeatures);
		HyExpression fa2 = createNumberedAttributeSumExpression(attributes, selectedFeatures);
		HyExpression fa3 = createNumberedAttributeSumExpression(attributes, selectedFeatures);
		HyExpression fa4 = createNumberedAttributeSumExpression(attributes, selectedFeatures);

		// c
		HyExpression c1 = value(value);
		HyExpression c2 = value(value);
		HyExpression c3 = value(value);
		HyExpression c4 = value(value);

		// (fa > c) * (fa - c) + (fa < c) * (c - fa)
		return add(mul(gt(fa1, c1), sub(c2, fa2)), mul(lt(fa3, c3), sub(fa4, c4)));

	}

	/**
	 * helper method to create a AtomicFeatureExpression
	 * 
	 * @param feature
	 * @return
	 */
	private AtomicFeatureExpression feature(HyFeature feature) {
		AtomicFeatureExpression atomicFeatureExpression = new AtomicFeatureExpression();
		atomicFeatureExpression.setFeature(feature);
		return atomicFeatureExpression;
	}

	/**
	 * helper method to create a HyAttribbuteReferenceExpression
	 * 
	 * @param attribute
	 * @return
	 */
	private HyAttributeReferenceExpression attribute(HyFeatureAttribute attribute) {
		HyAttributeReferenceExpression attributeReferenceExpression = expressionFactory
				.createHyAttributeReferenceExpression();
		attributeReferenceExpression.setAttribute(attribute);
		attributeReferenceExpression.setFeature(attribute.getFeature());
		return attributeReferenceExpression;
	}

	/**
	 * helper method to create a HyAdditionExpression
	 * 
	 * @param operand1
	 * @param operand2
	 * @return
	 */
	private HyAdditionExpression add(HyExpression operand1, HyExpression operand2) {
		HyAdditionExpression additionExpression = expressionFactory.createHyAdditionExpression();
		additionExpression.setOperand1(operand1);
		additionExpression.setOperand2(operand2);
		return additionExpression;
	}

	/**
	 * helper method to create a HySubtractionExpression
	 *  
	 * @param operand1
	 * @param operand2
	 * @return
	 */
	private HySubtractionExpression sub(HyExpression operand1, HyExpression operand2) {
		HySubtractionExpression subtractionExpression = expressionFactory.createHySubtractionExpression();
		subtractionExpression.setOperand1(operand1);
		subtractionExpression.setOperand2(operand2);
		return subtractionExpression;
	}

	/**
	 * helper method to create a HyMultiplicationExpression
	 * 
	 * @param operand1
	 * @param operand2
	 * @return
	 */
	private HyMultiplicationExpression mul(HyExpression operand1, HyExpression operand2) {
		HyMultiplicationExpression multiplicationExpression = expressionFactory.createHyMultiplicationExpression();
		multiplicationExpression.setOperand1(operand1);
		multiplicationExpression.setOperand2(operand2);
		return multiplicationExpression;
	}

	/**
	 * helper method to create a HyGreaterExpression
	 * 
	 * @param operand1
	 * @param operand2
	 * @return
	 */
	private HyGreaterExpression gt(HyExpression operand1, HyExpression operand2) {
		HyGreaterExpression greaterExpression = expressionFactory.createHyGreaterExpression();
		greaterExpression.setOperand1(operand1);
		greaterExpression.setOperand2(operand2);
		return greaterExpression;
	}

	/**
	 * helper method to create a HyLessExpression
	 * 
	 * @param operand1
	 * @param operand2
	 * @return
	 */
	private HyLessExpression lt(HyExpression operand1, HyExpression operand2) {
		HyLessExpression lessExpression = expressionFactory.createHyLessExpression();
		lessExpression.setOperand1(operand1);
		lessExpression.setOperand2(operand2);
		return lessExpression;
	}

	/**
	 * helper method to create a HyEqualExpression
	 * @param operand1
	 * @param operand2
	 * @return
	 */
	private HyEqualExpression eq(HyExpression operand1, HyExpression operand2) {
		HyEqualExpression equalExpression = expressionFactory.createHyEqualExpression();
		equalExpression.setOperand1(operand1);
		equalExpression.setOperand2(operand2);
		return equalExpression;
	}

	/**
	 * 
	 * @param attribute
	 * @return
	 */
	private HyExpression createFeatureAndAttributeMultiplication(HyFeatureAttribute attribute) {
		HyExpression attributeExpression = attribute(attribute);
		HyExpression featureExpression = feature(attribute.getFeature());

		return mul(attributeExpression, featureExpression);
	}
	
	/**
	 * helper method to create a hyValueExpression
	 * @param value
	 * @return
	 */
	private HyValueExpression value(int value) {
		HyNumberValue numberValue = HyDataValuesFactory.eINSTANCE.createHyNumberValue();
		numberValue.setValue(value);
		HyValueExpression valueExpression = expressionFactory.createHyValueExpression();
		valueExpression.setValue(numberValue);
		return valueExpression;
	}

	private HyExpression createNumberedAttributeSumExpression(List<HyFeatureAttribute> attributes,
			List<HyFeature> selectedFeatures) {
		HyFeatureAttribute lastAttribute = null;
		HyAdditionExpression addExp = null;
		boolean first = true;
		for (HyFeatureAttribute attribute : attributes) {
			if (attribute instanceof HyNumberAttribute && selectedFeatures.contains(attribute.getFeature())) {
				if (lastAttribute != null) {
					if (first) {
						first = false;

						addExp = add(createFeatureAndAttributeMultiplication(lastAttribute),
								createFeatureAndAttributeMultiplication(attribute));
					} else {
						addExp = add(addExp, createFeatureAndAttributeMultiplication(attribute));
					}
				}
				lastAttribute = attribute;
			}
		}

		return addExp;

	}

}
