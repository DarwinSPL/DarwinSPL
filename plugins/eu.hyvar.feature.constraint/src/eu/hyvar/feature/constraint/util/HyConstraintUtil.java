package eu.hyvar.feature.constraint.util;

import java.util.ArrayList;
import java.util.List;

import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.expression.HyBooleanValueExpression;
import eu.hyvar.feature.expression.HyExpression;
import eu.hyvar.feature.expression.HyExpressionFactory;
import eu.hyvar.feature.expression.HyNotExpression;
import eu.hyvar.feature.expression.HyRelativeVersionRestriction;
import eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator;
import eu.hyvar.feature.expression.HyVersionRangeRestriction;
import eu.hyvar.feature.expression.HyVersionRestriction;

public class HyConstraintUtil {
	
//	public static HyConstraintModel getCopyOfValidConstraintModelElement(HyConstraintModel constraintModel, Date date) {
//		HyConstraintModel newConstraintModel = HyConstraintFactory.eINSTANCE.createHyConstraintModel();
//		newConstraintModel.setFeatureModel(HyFeatureEvolutionUtil.getCopyOfValidModel(constraintModel.getFeatureModel(), date));
//		return newConstraintModel;
//	}
	
	
	public static final String CONSTRAINT_MODEL_FILE_EXTENSION_FOR_XMI = "hyconstraint";
	public static final String CONSTRAINT_MODEL_FILE_EXTENSION_FOR_CONCRETE_SYNTAX = "hyconstraints";
	
	public static HyNotExpression negate(HyExpression expression) {
		HyNotExpression notExpression = HyExpressionFactory.eINSTANCE.createHyNotExpression();
		notExpression.setOperand(expression);
		return notExpression;
	}
	
	public static HyBooleanValueExpression createBooleanValueExpression(boolean value) {
		HyBooleanValueExpression booleanValueExpression = HyExpressionFactory.eINSTANCE.createHyBooleanValueExpression();
		
		booleanValueExpression.setValue(value);
		
		return booleanValueExpression;
	}
	
	public static Boolean getBooleanValue(HyExpression expression) {
		if (expression instanceof HyBooleanValueExpression) {
			HyBooleanValueExpression booleanValueExpression = (HyBooleanValueExpression) expression;
			
			return booleanValueExpression.isValue();
		}

		return null;
	}

	
	public static boolean versionSatisfiesVersionRestriction(HyVersion version, HyVersionRestriction versionRestriction) {
		List<HyVersion> versionsSatisfyingVersionRestriction = getVersionsSatisfyingVersionRestriction(versionRestriction);
		
		return versionsSatisfyingVersionRestriction.contains(version);
	}
	
	
	public static List<HyVersion> getVersionsSatisfyingVersionRestriction(HyVersionRestriction versionRestriction) {
		if (versionRestriction instanceof HyVersionRangeRestriction) {
			HyVersionRangeRestriction versionRangeRestriction = (HyVersionRangeRestriction) versionRestriction;
			
			return getVersionsSatisfyingVersionRangeRestriction(versionRangeRestriction);
		}
		
		if (versionRestriction instanceof HyRelativeVersionRestriction) {
			HyRelativeVersionRestriction relativeVersionRestriction = (HyRelativeVersionRestriction) versionRestriction;
			
			return getVersionsSatisfyingRelativeVersionRestriction(relativeVersionRestriction);
		}
		
		throw new UnsupportedOperationException("Don't know how to handle " + versionRestriction.getClass().getSimpleName() + ".");
	}
	
	protected static List<HyVersion> getVersionsSatisfyingVersionRangeRestriction(HyVersionRangeRestriction versionRangeRestriction) {
		List<HyVersion> versions = new ArrayList<HyVersion>();
		
		HyVersion lowerVersion = versionRangeRestriction.getLowerVersion();
		HyVersion upperVersion = versionRangeRestriction.getUpperVersion();
		
		boolean lowerIsIncluded = versionRangeRestriction.isLowerIncluded();
		boolean upperIsIncluded = versionRangeRestriction.isUpperIncluded();
		
		if (upperIsIncluded) {
			versions.add(upperVersion);
		}
		
		HyVersion version = upperVersion.getSupersededVersion();
		
		while (version != null && version != lowerVersion) {
			versions.add(0, version);
			
			version = version.getSupersededVersion();
		}
		
		if (lowerIsIncluded) {
			versions.add(0, lowerVersion);
		}
		
		return versions;
	}
	
	protected static List<HyVersion> getVersionsSatisfyingRelativeVersionRestriction(HyRelativeVersionRestriction relativeVersionRestriction) {
		List<HyVersion> versions = new ArrayList<HyVersion>();
		
		HyRelativeVersionRestrictionOperator operator = relativeVersionRestriction.getOperator();
		HyVersion version = relativeVersionRestriction.getVersion();
		
		if (operator == HyRelativeVersionRestrictionOperator.EQUAL || operator == HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL || 
				operator == HyRelativeVersionRestrictionOperator.LESS_THAN_OR_EQUAL || operator == HyRelativeVersionRestrictionOperator.GREATER_THAN_OR_EQUAL) {
			versions.add(version);
		}
		
		if (operator == HyRelativeVersionRestrictionOperator.LESS_THAN || operator == HyRelativeVersionRestrictionOperator.LESS_THAN_OR_EQUAL) {
			versions.addAll(collectAllSupersededVersions(version));
		}

		if (operator == HyRelativeVersionRestrictionOperator.GREATER_THAN || operator == HyRelativeVersionRestrictionOperator.GREATER_THAN_OR_EQUAL) {
			versions.addAll(collectAllSupersedingVersions(version));
		}
		
		return versions;
	}
	
	protected static List<HyVersion> collectAllSupersededVersions(HyVersion version) {
		List<HyVersion> allSupersededVersions = new ArrayList<HyVersion>();
		
		version = version.getSupersededVersion();
		
		while (version != null) {
			allSupersededVersions.add(0, version);
			
			version = version.getSupersededVersion();
		}
		
		return allSupersededVersions;
	}
	
	protected static List<HyVersion> collectAllSupersedingVersions(HyVersion version) {
		List<HyVersion> allSupersedingVersions = new ArrayList<HyVersion>();
		doCollectAllSupersedingVersions(version, allSupersedingVersions);
		return allSupersedingVersions;
	}
	
	protected static void doCollectAllSupersedingVersions(HyVersion version, List<HyVersion> allSupersedingVersions) {
		List<HyVersion> supersedingVersions = version.getSupersedingVersions();
		
		for (HyVersion supersedingVersion : supersedingVersions) {
			if (!allSupersedingVersions.contains(supersedingVersion)) {
				allSupersedingVersions.add(supersedingVersion);
			}
			
			doCollectAllSupersedingVersions(supersedingVersion, allSupersedingVersions);
		}
	}

	public static String getConstraintModelFileExtensionForXmi() {
		return CONSTRAINT_MODEL_FILE_EXTENSION_FOR_XMI;
	}

	public static String getConstraintModelFileExtensionForConcreteSyntax() {
		return CONSTRAINT_MODEL_FILE_EXTENSION_FOR_CONCRETE_SYNTAX;
	}

	
}
