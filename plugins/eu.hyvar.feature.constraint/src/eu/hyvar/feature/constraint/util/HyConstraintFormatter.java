package eu.hyvar.feature.constraint.util;

import java.util.List;

import eu.hyvar.feature.constraint.HyConstraint;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyAndExpression;
import eu.hyvar.feature.expression.HyAtomicExpression;
import eu.hyvar.feature.expression.HyBinaryExpression;
import eu.hyvar.feature.expression.HyBooleanValueExpression;
import eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyEquivalenceExpression;
import eu.hyvar.feature.expression.HyExpression;
import eu.hyvar.feature.expression.HyImpliesExpression;
import eu.hyvar.feature.expression.HyNestedExpression;
import eu.hyvar.feature.expression.HyNotExpression;
import eu.hyvar.feature.expression.HyOrExpression;
import eu.hyvar.feature.expression.HyRelativeVersionRestriction;
import eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator;
import eu.hyvar.feature.expression.HyUnaryExpression;
import eu.hyvar.feature.expression.HyVersionRangeRestriction;
import eu.hyvar.feature.expression.HyVersionRestriction;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyVersion;

//NOTE: printing might not adequately reflect operator precedence, introduce verbose parentheses if necessary
public class HyConstraintFormatter {
	private static final String endl = "\n";
	
	@Deprecated
	public static String formatConstraintModel(HyConstraintModel constraintModel) {
		if (constraintModel == null) {
			return "";
		}
		
		String output = "";
		
		List<HyConstraint> constraints = constraintModel.getConstraints();
		
		for (HyConstraint constraint : constraints) {
			output += formatConstraint(constraint) + endl;
		}
		
		return output;
	}

	public static String formatConstraint(HyConstraint constraint) {
		String output = "";
		
		HyExpression rootExpression = constraint.getRootExpression();
		output += formatExpression(rootExpression);
		
		return output;
	}
	
	//TODO: This could be lifted as it applies to expressions in general.
	public static String formatExpression(HyExpression expression) {
		if (expression instanceof HyAtomicExpression) {
			if (expression instanceof HyBooleanValueExpression) {
				HyBooleanValueExpression booleanValueExpression = (HyBooleanValueExpression) expression;
				boolean value = booleanValueExpression.isValue();
				
				return value ? "true" : "false";
			}
			
			if (expression instanceof HyAbstractFeatureReferenceExpression) {
				HyAbstractFeatureReferenceExpression abstractFeatureReferenceExpression = (HyAbstractFeatureReferenceExpression) expression;
				
				HyFeature feature = abstractFeatureReferenceExpression.getFeature();
				HyVersionRestriction versionRestriction = abstractFeatureReferenceExpression.getVersionRestriction();
				
				String output = "";
				
				if (expression instanceof HyConditionalFeatureReferenceExpression) {
					output += "?";
				}
				
				output += feature.getNames();
				
				if (versionRestriction != null) {
					if (versionRestriction instanceof HyVersionRangeRestriction) {
						HyVersionRangeRestriction versionRangeRestriction = (HyVersionRangeRestriction) versionRestriction;
						
						HyVersion lowerVersion = versionRangeRestriction.getLowerVersion();
						HyVersion upperVersion = versionRangeRestriction.getUpperVersion();
						
						boolean isLowerIncluded = versionRangeRestriction.isLowerIncluded();
						boolean isUpperIncluded = versionRangeRestriction.isLowerIncluded();
						
						output += " [";
						
						if (!isLowerIncluded) {
							output += "^";
						}
						
						output += lowerVersion.getNumber();
						output += " - ";
						
						if (!isUpperIncluded) {
							output += "^";
						}
						
						output += upperVersion.getNumber();
						output += "]";
					} else if (versionRestriction instanceof HyRelativeVersionRestriction) {
						HyRelativeVersionRestriction relativeVersionRestriction = (HyRelativeVersionRestriction) versionRestriction;
						HyRelativeVersionRestrictionOperator operator = relativeVersionRestriction.getOperator();
						HyVersion version = relativeVersionRestriction.getVersion();
						
						output += " [";

						switch(operator.getValue()) {
							case HyRelativeVersionRestrictionOperator.LESS_THAN_VALUE:
								output += "< ";
								break;
							case HyRelativeVersionRestrictionOperator.LESS_THAN_OR_EQUAL_VALUE:
								output += "<= ";
								break;
							case HyRelativeVersionRestrictionOperator.EQUAL_VALUE:
								output += "= ";
								break;
							case HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL_VALUE:
								break;
							case HyRelativeVersionRestrictionOperator.GREATER_THAN_OR_EQUAL_VALUE:
								output += ">= ";
								break;
							case HyRelativeVersionRestrictionOperator.GREATER_THAN_VALUE:
								output += "> ";
								break;
							default:
								throw new UnsupportedOperationException("Unable to format relative version restriction operator " + operator);
						}
						
						output += version.getNumber();
						output += "]";
					}
				}
				
				return output;
			}
		}
		
		if (expression instanceof HyUnaryExpression) {
			HyUnaryExpression unaryExpression = (HyUnaryExpression) expression;
			HyExpression operand = unaryExpression.getOperand();
			
			String output = "{";
			
			if (unaryExpression instanceof HyNotExpression) {
				output += "!";
			} else if (unaryExpression instanceof HyNestedExpression) {
				output += "(";
			}
			
			output += formatExpression(operand);
			
			if (unaryExpression instanceof HyNestedExpression) {
				output += ")";
			}
			
			output += "}";
			
			return output;
		}
		
		if (expression instanceof HyBinaryExpression) {
			HyBinaryExpression binaryExpression = (HyBinaryExpression) expression;
			
			HyExpression operand1 = binaryExpression.getOperand1();
			HyExpression operand2 = binaryExpression.getOperand2();
			
			String output = "{";
			
			output += formatExpression(operand1);
			
			if (expression instanceof HyAndExpression) {
				output += " && ";
			} else if (expression instanceof HyOrExpression) {
				output += " || ";
			} else if (expression instanceof HyImpliesExpression) {
				output += " -> ";
			} else if (expression instanceof HyEquivalenceExpression) {
				output += " <-> ";
			}
			
			output += formatExpression(operand2);
			
			output += "}";
			
			return output;
		}
		
		throw new UnsupportedOperationException("Unable to format expression of type " + expression.getClass() + ".");
	}
}
