package eu.hyvar.feature.expression.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import eu.hyvar.feature.expression.HyAndExpression;
import eu.hyvar.feature.expression.HyAtomicExpression;
import eu.hyvar.feature.expression.HyBinaryExpression;
import eu.hyvar.feature.expression.HyBooleanValueExpression;
import eu.hyvar.feature.expression.HyConditionalFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyEquivalenceExpression;
import eu.hyvar.feature.expression.HyExpression;
import eu.hyvar.feature.expression.HyFeatureReferenceExpression;
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


// Needs extension for contexts and attributes! #ContextCTC
public abstract class HyExpressionEvaluator {
	protected boolean evaluateExpression(HyExpression expression) {
		if (expression instanceof HyBinaryExpression) {
			HyBinaryExpression binaryExpression = (HyBinaryExpression) expression;
			return evaluateBinaryExpression(binaryExpression);
		}
		
		if (expression instanceof HyUnaryExpression) {
			HyUnaryExpression unaryExpression = (HyUnaryExpression) expression;
			return evaluateUnaryExpression(unaryExpression);
		}
		
		if (expression instanceof HyAtomicExpression) {
			HyAtomicExpression atomicExpression = (HyAtomicExpression) expression;
			return evaluateAtomicExpression(atomicExpression);
		}
		
		return true;
	}

	protected boolean evaluateBinaryExpression(HyBinaryExpression binaryExpression) {
		HyExpression operand1 = binaryExpression.getOperand1();
		HyExpression operand2 = binaryExpression.getOperand2();
		
		boolean operand1Result = evaluateExpression(operand1);
		boolean operand2Result = evaluateExpression(operand2);
		
		if (binaryExpression instanceof HyAndExpression) {
			return operand1Result && operand2Result;
		}
		
		if (binaryExpression instanceof HyOrExpression) {
			return operand1Result || operand2Result;
		}
		
		if (binaryExpression instanceof HyImpliesExpression) {
			//A -> B = !A || B
			return !operand1Result || operand2Result;
		}
		
		if (binaryExpression instanceof HyEquivalenceExpression) {
			//A <-> B = (A && B) || (!A && !B)
			return (operand1Result && operand2Result) || (!operand1Result && !operand2Result);
		}
		// Needs extension for contexts and attributes! #ContextCTC ... <=, <, >, >=, = .....
		throw new UnsupportedOperationException(binaryExpression.getClass().getCanonicalName());
	}
	
	protected boolean evaluateUnaryExpression(HyUnaryExpression unaryExpression) {
		HyExpression operand = unaryExpression.getOperand();
		boolean operandResult = evaluateExpression(operand);
		
		if (unaryExpression instanceof HyNotExpression) {
			return !operandResult;
		}
		
		if (unaryExpression instanceof HyNestedExpression) {
			//Just forward result.
			return operandResult;
		}
		
		throw new UnsupportedOperationException(unaryExpression.getClass().getCanonicalName());
	}
	
	protected boolean evaluateAtomicExpression(HyAtomicExpression atomicExpression) {
		if (atomicExpression instanceof HyBooleanValueExpression) {
			HyBooleanValueExpression booleanValueExpression = (HyBooleanValueExpression) atomicExpression;
			
			return booleanValueExpression.isValue();
		}
		
		if (atomicExpression instanceof HyFeatureReferenceExpression) {
			HyFeatureReferenceExpression featureReferenceExpression = (HyFeatureReferenceExpression) atomicExpression;

			HyFeature feature = featureReferenceExpression.getFeature();
			
			if (!isFeaturePresent(feature)) {
				return false;
			}
			
			HyVersionRestriction versionRestriction = featureReferenceExpression.getVersionRestriction();
			return evaluateVersionRestriction(versionRestriction);
		}
		
		if (atomicExpression instanceof HyConditionalFeatureReferenceExpression) {
			HyConditionalFeatureReferenceExpression conditionalFeatureReferenceExpression = (HyConditionalFeatureReferenceExpression) atomicExpression;
			
			HyFeature feature = conditionalFeatureReferenceExpression.getFeature();
			
			if (!isFeaturePresent(feature)) {
				return true;
			}
			
			HyVersionRestriction versionRestriction = conditionalFeatureReferenceExpression.getVersionRestriction();
			return evaluateVersionRestriction(versionRestriction);
		}
		// // Needs extension for contexts and attributes! #ContextCTC
		// TODO Attribute stuff!
		
		throw new UnsupportedOperationException(atomicExpression.getClass().getCanonicalName());
	}
	
	protected boolean evaluateVersionRestriction(HyVersionRestriction versionRestriction) {
		if (versionRestriction == null) {
			//No restriction, no need to satisfy anything.
			return true;
		}
		
		if (versionRestriction instanceof HyVersionRangeRestriction) {
			HyVersionRangeRestriction versionRangeRestriction = (HyVersionRangeRestriction) versionRestriction;
			
			HyVersion lowerVersion = versionRangeRestriction.getLowerVersion();
			HyVersion upperVersion = versionRangeRestriction.getUpperVersion();

			HyVersion currentVersion = upperVersion;

			while(currentVersion != null) {
				if (isVersionPresent(currentVersion)) {
					return true;
				}
				
				if (currentVersion == lowerVersion) {
					break;
				}
				
				currentVersion = (HyVersion)currentVersion.getSupersededVersion();
			}
			
			return false;
		}
		
		if (versionRestriction instanceof HyRelativeVersionRestriction) {
			HyRelativeVersionRestriction relativeVersionRestriction = (HyRelativeVersionRestriction) versionRestriction;
			
			//Naive implementation that _will_ cause problems with scalability. Take care!
			List<HyVersion> satisfyingVersions = getSatisfyingVersions(relativeVersionRestriction);
			
			for (HyVersion satisfyingVersion : satisfyingVersions) {
				if (isVersionPresent(satisfyingVersion)) {
					return true;
				}
			}
			
			return false;
		}
		
		throw new UnsupportedOperationException(versionRestriction.getClass().getCanonicalName());
	}
	
	protected List<HyVersion> getSatisfyingVersions(HyRelativeVersionRestriction relativeVersionRestriction) {
//		// TODO
//		
//		return new ArrayList<HyVersion>();
		HyRelativeVersionRestrictionOperator operator = relativeVersionRestriction.getOperator();
		HyVersion version = relativeVersionRestriction.getVersion();
		
		return doGetSatisfyingVersions(operator, version);
	}
	
	protected List<HyVersion> doGetSatisfyingVersions(HyRelativeVersionRestrictionOperator operator, HyVersion version) {
		if (operator == HyRelativeVersionRestrictionOperator.LESS_THAN) {
			List<HyVersion> satisfyingVersions = new ArrayList<HyVersion>();
			HyVersion currentVersion = version;
			
			while(currentVersion != null) {
				satisfyingVersions.add(currentVersion);
				
				currentVersion = (HyVersion)currentVersion.getSupersededVersion();
			}
			
			return satisfyingVersions;
		}
		
		if (operator == HyRelativeVersionRestrictionOperator.LESS_THAN_OR_EQUAL) {
			List<HyVersion> satisfyingVersions = doGetSatisfyingVersions(HyRelativeVersionRestrictionOperator.LESS_THAN, version);
			satisfyingVersions.add(version);
			return satisfyingVersions;
		}
		
		if (operator == HyRelativeVersionRestrictionOperator.EQUAL || operator == HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL) {
			return Collections.singletonList(version);
		}
		
		if (operator == HyRelativeVersionRestrictionOperator.GREATER_THAN_OR_EQUAL) {
			List<HyVersion> satisfyingVersions = doGetSatisfyingVersions(HyRelativeVersionRestrictionOperator.GREATER_THAN, version);
			satisfyingVersions.add(version);
			return satisfyingVersions;
		}
		
		if (operator == HyRelativeVersionRestrictionOperator.GREATER_THAN) {
			List<HyVersion> satisfyingVersions = new ArrayList<HyVersion>();
			
			List<HyVersion> supersedingVersions = version.getSupersedingVersions();
			satisfyingVersions.addAll(supersedingVersions);
			
			for (HyVersion supersedingVersion : supersedingVersions) {
				List<HyVersion> furtherSupersedingVersions = doGetSatisfyingVersions(HyRelativeVersionRestrictionOperator.GREATER_THAN, supersedingVersion);
				
				satisfyingVersions.addAll(furtherSupersedingVersions);
			}
			
			return satisfyingVersions;
		}
		
		throw new UnsupportedOperationException(operator.getClass().getCanonicalName());
	}
	
	protected abstract boolean isFeaturePresent(HyFeature feature);
	protected abstract boolean isVersionPresent(HyVersion version);
}
