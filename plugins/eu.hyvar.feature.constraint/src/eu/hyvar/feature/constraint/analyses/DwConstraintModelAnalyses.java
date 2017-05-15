package eu.hyvar.feature.constraint.analyses;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.constraint.HyConstraint;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.constraint.analyses.DwConstraintModelAnalysesMarker.MarkerTypeEnum;
import eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyAtomicExpression;
import eu.hyvar.feature.expression.HyAttributeReferenceExpression;
import eu.hyvar.feature.expression.HyBinaryExpression;
import eu.hyvar.feature.expression.HyExpression;
import eu.hyvar.feature.expression.HyRelativeVersionRestriction;
import eu.hyvar.feature.expression.HyUnaryExpression;
import eu.hyvar.feature.expression.HyVersionRangeRestriction;

public class DwConstraintModelAnalyses {

	private static final String ERROR_MESSAGE_REFERENCE_VALIDITY_CONSISTENCY_FEATURE = "Constraint's validity is exceeding referenced feature's validity";
	private static final String ERROR_MESSAGE_REFERENCE_VALIDITY_CONSISTENCY_VERSION = "Constraint's validity is exceeding referenced version's validity";
	private static final String ERROR_MESSAGE_REFERENCE_VALIDITY_CONSISTENCY_ATTRIBUTE = "Constraint's validity is exceeding referenced attribute's validity";
	
	public static List<DwConstraintModelAnalysesMarker> checkConstraintModelValidity(HyConstraintModel constraintModel) {
		List<DwConstraintModelAnalysesMarker> markerList = new ArrayList<DwConstraintModelAnalysesMarker>();
		
		
		return markerList;
	}
	
	public static List<DwConstraintModelAnalysesMarker> checkReferenceValidityConsistency(HyConstraintModel constraintModel) {
		List<DwConstraintModelAnalysesMarker> markerList = new ArrayList<DwConstraintModelAnalysesMarker>();
		
		
		for(HyConstraint constraint: constraintModel.getConstraints()) {
			markerList.addAll(checkReferenceValidityConsistencyForExpression(constraint.getRootExpression(), constraint));
		}
		
		return markerList;
	}
	
	private static List<DwConstraintModelAnalysesMarker> checkReferenceValidityConsistencyForExpression(HyExpression expression, HyConstraint constraint) {
		List<DwConstraintModelAnalysesMarker> markerList = new ArrayList<DwConstraintModelAnalysesMarker>();

		if(expression instanceof HyAtomicExpression) {
			if(expression instanceof HyAbstractFeatureReferenceExpression) {
				HyAbstractFeatureReferenceExpression featureReference = (HyAbstractFeatureReferenceExpression) expression;
				
				HyFeature feature = featureReference.getFeature();
				if(feature == null) {
					return markerList;
				}
				
				if(!HyEvolutionUtil.isWithinValidityOf(constraint, feature)) {
					List<EObject> affectedObjects = new ArrayList<EObject>(1);
					affectedObjects.add(featureReference);
					markerList.add(new DwConstraintModelAnalysesMarker(affectedObjects, ERROR_MESSAGE_REFERENCE_VALIDITY_CONSISTENCY_FEATURE, MarkerTypeEnum.ERROR));
				}
				
				if(featureReference.getVersionRestriction()!=null) {
					if(featureReference.getVersionRestriction() instanceof HyVersionRangeRestriction) {
						HyVersionRangeRestriction versionRangeRestriction = (HyVersionRangeRestriction) featureReference.getVersionRestriction();
						HyVersion lowerVersion = versionRangeRestriction.getLowerVersion();
						HyVersion upperVersion = versionRangeRestriction.getUpperVersion();
						
						if((lowerVersion != null && !HyEvolutionUtil.isWithinValidityOf(constraint, lowerVersion)) || (upperVersion != null && !HyEvolutionUtil.isWithinValidityOf(constraint, upperVersion))) {
							List<EObject> affectedObjects = new ArrayList<EObject>(1);
							affectedObjects.add(featureReference);
							markerList.add(new DwConstraintModelAnalysesMarker(affectedObjects, ERROR_MESSAGE_REFERENCE_VALIDITY_CONSISTENCY_VERSION, MarkerTypeEnum.ERROR));
						}
					}
					else if(featureReference.getVersionRestriction() instanceof HyRelativeVersionRestriction) {
						HyRelativeVersionRestriction relativeVersionRestriction = (HyRelativeVersionRestriction) featureReference.getVersionRestriction();
						HyVersion version = relativeVersionRestriction.getVersion();
						
						if(version != null && !HyEvolutionUtil.isWithinValidityOf(constraint, version)) {
							List<EObject> affectedObjects = new ArrayList<EObject>(1);
							affectedObjects.add(featureReference);
							markerList.add(new DwConstraintModelAnalysesMarker(affectedObjects, ERROR_MESSAGE_REFERENCE_VALIDITY_CONSISTENCY_VERSION, MarkerTypeEnum.ERROR));
						}
					}
				}
			}
			else if(expression instanceof HyAttributeReferenceExpression) {
				HyAttributeReferenceExpression attributeReference = (HyAttributeReferenceExpression) expression;
				
				HyFeature feature = attributeReference.getFeature();
				HyFeatureAttribute attribute = attributeReference.getAttribute();
				
				if(feature != null && !HyEvolutionUtil.isWithinValidityOf(constraint, feature)) {
					List<EObject> affectedObjects = new ArrayList<EObject>(1);
					affectedObjects.add(attributeReference);
					markerList.add(new DwConstraintModelAnalysesMarker(affectedObjects, ERROR_MESSAGE_REFERENCE_VALIDITY_CONSISTENCY_FEATURE, MarkerTypeEnum.ERROR));
				}
				
				if(attribute != null && !HyEvolutionUtil.isWithinValidityOf(constraint, attribute)) {
					List<EObject> affectedObjects = new ArrayList<EObject>(1);
					affectedObjects.add(attributeReference);
					markerList.add(new DwConstraintModelAnalysesMarker(affectedObjects, ERROR_MESSAGE_REFERENCE_VALIDITY_CONSISTENCY_ATTRIBUTE, MarkerTypeEnum.ERROR));
				}
			}
			
		} 
		else if(expression instanceof HyBinaryExpression) {
			HyBinaryExpression binaryExpression = (HyBinaryExpression) expression;
			markerList.addAll(checkReferenceValidityConsistencyForExpression(binaryExpression.getOperand1(), constraint));
			markerList.addAll(checkReferenceValidityConsistencyForExpression(binaryExpression.getOperand2(), constraint));
		}
		else if(expression instanceof HyUnaryExpression) {
			HyUnaryExpression unaryExpression = (HyUnaryExpression) expression;
			markerList.addAll(checkReferenceValidityConsistencyForExpression(unaryExpression.getOperand(), constraint));
		}
		
		return markerList;
	}
	
	
	
}
