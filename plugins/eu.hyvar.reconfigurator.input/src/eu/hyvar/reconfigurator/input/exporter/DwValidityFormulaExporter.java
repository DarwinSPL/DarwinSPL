package eu.hyvar.reconfigurator.input.exporter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.hyvar.context.contextValidity.HyAttributeValidityFormula;
import eu.hyvar.context.contextValidity.HyFeatureValidityFormula;
import eu.hyvar.context.contextValidity.HyValidityFormula;
import eu.hyvar.context.contextValidity.HyValidityModel;
import eu.hyvar.feature.expression.HyExpression;
import eu.hyvar.feature.expression.HyExpressionFactory;
import eu.hyvar.feature.expression.HyFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyImpliesExpression;
import eu.hyvar.feature.expression.util.HyExpressionStringExporter;
import eu.hyvar.reconfigurator.input.format.Context;

public class DwValidityFormulaExporter {

	private HyExpressionStringExporter expressionExporter;

	private Map<EObject, List<String>> translationMapping;
	
	public DwValidityFormulaExporter(HyExpressionStringExporter expressionExporter, Map<EObject, List<String>> translationMapping) {
		this.expressionExporter = expressionExporter;
		
		this.translationMapping = translationMapping;
	}
	
	public List<String> getContextValidityFormulas(HyValidityModel validityModel, Date date, Context dateContext, List<Date> sortedDateList) {
		List<String> validityFormulas = new ArrayList<String>();

		if(validityModel == null || validityModel.getValidityFormulas() == null) {
			return validityFormulas;
		}
		
		for (HyValidityFormula validityFormula :validityModel.getValidityFormulas()) {
			
			String validityFormulaConstraint = getValidityFormulaAsConstraint(validityFormula, date, dateContext, sortedDateList);
			
			if(validityFormulaConstraint != null) {
				validityFormulas.add(validityFormulaConstraint);
				
				translationMapping.put(validityFormula, new ArrayList<String>());
				translationMapping.get(validityFormula).add(validityFormulaConstraint);
			}
			
		}

		return validityFormulas;
	}

	private String getValidityFormulaAsConstraint(HyValidityFormula validityFormula, Date date, Context dateContext, List<Date> sortedDateList) {
		
		HyExpression expression = null;

		if (validityFormula instanceof HyFeatureValidityFormula) {
			HyFeatureValidityFormula featureValidityFormula = (HyFeatureValidityFormula) validityFormula;
			HyImpliesExpression featureImpliesValidityFormulaExpression = HyExpressionFactory.eINSTANCE
					.createHyImpliesExpression();

			HyFeatureReferenceExpression featureReferenceExpression = HyExpressionFactory.eINSTANCE
					.createHyFeatureReferenceExpression();
			featureReferenceExpression.setFeature(featureValidityFormula.getFeature());

			featureImpliesValidityFormulaExpression.setOperand1(featureReferenceExpression);
			featureImpliesValidityFormulaExpression
					.setOperand2(EcoreUtil.copy(featureValidityFormula.getValidityFormula()));

			expression = featureImpliesValidityFormulaExpression;
		} else if (validityFormula instanceof HyAttributeValidityFormula) {
			HyAttributeValidityFormula attributeValidityFormula = (HyAttributeValidityFormula) validityFormula;
			HyImpliesExpression featureImpliesValidityFormulaExpression = HyExpressionFactory.eINSTANCE
					.createHyImpliesExpression();

			HyFeatureReferenceExpression featureReferenceExpression = HyExpressionFactory.eINSTANCE
					.createHyFeatureReferenceExpression();
			featureReferenceExpression.setFeature(attributeValidityFormula.getAttribute().getFeature());

			featureImpliesValidityFormulaExpression.setOperand1(featureReferenceExpression);
			featureImpliesValidityFormulaExpression
					.setOperand2(EcoreUtil.copy(attributeValidityFormula.getValidityFormula()));

			expression = featureImpliesValidityFormulaExpression;
		}


		return HyVarRecExporter.createTimedExpression(validityFormula, expression, date, dateContext, sortedDateList, expressionExporter);
	}
}
