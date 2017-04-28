package eu.hyvar.feature.expression.util;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyBinaryExpression;
import eu.hyvar.feature.expression.HyExpression;
import eu.hyvar.feature.expression.HyUnaryExpression;

public class DarwinExpressionUtil {

	public static boolean containsFeature(HyExpression expression, HyFeature feature) {
		if(expression instanceof HyAbstractFeatureReferenceExpression) {
			if(((HyAbstractFeatureReferenceExpression) expression).getFeature() == feature) {
				return true;
			}
		}
		else if(expression instanceof HyUnaryExpression) {
			return containsFeature(((HyUnaryExpression) expression).getOperand(), feature);
		}
		else if(expression instanceof HyBinaryExpression) {
			HyBinaryExpression binaryExpression = (HyBinaryExpression) expression;
			if(containsFeature(binaryExpression.getOperand1(), feature)) {
				return true;
			}
			
			if(containsFeature(binaryExpression.getOperand2(), feature)) {
				return true;
			}
		}
		
		return false;
	}
	
}
