package de.darwinspl.common.analyses;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.darwinspl.common.analyses.DwAnalysesMarker.MarkerTypeEnum;
import eu.hyvar.evolution.HyTemporalElement;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyAtomicExpression;
import eu.hyvar.feature.expression.HyAttributeReferenceExpression;
import eu.hyvar.feature.expression.HyBinaryExpression;
import eu.hyvar.feature.expression.HyExpression;
import eu.hyvar.feature.expression.HyRelativeVersionRestriction;
import eu.hyvar.feature.expression.HyUnaryExpression;
import eu.hyvar.feature.expression.HyVersionRangeRestriction;

public class DwAnalyses {


	private static final String ERROR_MESSAGE_REFERENCE_VALIDITY_CONSISTENCY_FEATURE = "Element validity is exceeding referenced feature validity";
	private static final String ERROR_MESSAGE_REFERENCE_VALIDITY_CONSISTENCY_VERSION = "Element validity is exceeding referenced version validity";
	private static final String ERROR_MESSAGE_REFERENCE_VALIDITY_CONSISTENCY_ATTRIBUTE = "Element validity is exceeding referenced attribute validity";
	private static final String ERROR_MESSAGE_REFERENCE_VALIDITY_CONSISTENCY_ELEMENT = "Element validity is exceeding referenced element validity";
	
	public static DwAnalysesMarker checkReferenceValidityConsistencyForReferencedElement(HyTemporalElement referencedElement, HyExpression affectedExpression, HyTemporalElement containingElement) {
		if(referencedElement == null) {
			return null;
		}
		
		if(!HyEvolutionUtil.isWithinValidityOf(containingElement, referencedElement)) {
			List<HyExpression> affectedExpressions = new ArrayList<HyExpression>(1);
			if(affectedExpression != null) {
				affectedExpressions.add(affectedExpression);				
			}
			
			List<EObject> affectedObjects = new ArrayList<EObject>(1);
			affectedObjects.add(referencedElement);
			
			String message;
			
			if(referencedElement instanceof HyFeature) {
				message = ERROR_MESSAGE_REFERENCE_VALIDITY_CONSISTENCY_FEATURE;
			}
			else if(referencedElement instanceof HyFeatureAttribute) {
				message = ERROR_MESSAGE_REFERENCE_VALIDITY_CONSISTENCY_ATTRIBUTE;
			}
			else if(referencedElement instanceof HyVersion) {
				message = ERROR_MESSAGE_REFERENCE_VALIDITY_CONSISTENCY_VERSION;
			}
			else {
				message = ERROR_MESSAGE_REFERENCE_VALIDITY_CONSISTENCY_ELEMENT;
			}
			
			return new DwAnalysesMarker(affectedExpressions, affectedObjects, message, MarkerTypeEnum.ERROR);
		}
		
		return null;
	}
	
	public static List<DwAnalysesMarker> checkReferenceValidityConsistencyForExpression(HyExpression expression, HyTemporalElement containingElement) {
		List<DwAnalysesMarker> markerList = new ArrayList<DwAnalysesMarker>();
		
		if(expression instanceof HyAtomicExpression) {
			if(expression instanceof HyAbstractFeatureReferenceExpression) {
				HyAbstractFeatureReferenceExpression featureReference = (HyAbstractFeatureReferenceExpression) expression;
				
				HyFeature feature = featureReference.getFeature();
				if(feature == null) {
					return markerList;
				}
				
				DwAnalysesMarker featureReferenceMarker = DwAnalyses.checkReferenceValidityConsistencyForReferencedElement(feature, featureReference, containingElement);
				if(featureReferenceMarker != null) {
					markerList.add(featureReferenceMarker);
				}
				
				if(featureReference.getVersionRestriction()!=null) {
					if(featureReference.getVersionRestriction() instanceof HyVersionRangeRestriction) {
						HyVersionRangeRestriction versionRangeRestriction = (HyVersionRangeRestriction) featureReference.getVersionRestriction();
						HyVersion lowerVersion = versionRangeRestriction.getLowerVersion();
						HyVersion upperVersion = versionRangeRestriction.getUpperVersion();
						
						if(lowerVersion != null) {
							
							DwAnalysesMarker versionReferenceMarker = DwAnalyses.checkReferenceValidityConsistencyForReferencedElement(lowerVersion, featureReference, containingElement);
							if(versionReferenceMarker != null) {
								markerList.add(versionReferenceMarker);
							}
							
						} else if(upperVersion != null) {
							DwAnalysesMarker versionReferenceMarker = DwAnalyses.checkReferenceValidityConsistencyForReferencedElement(upperVersion, featureReference, containingElement);
							if(versionReferenceMarker != null) {
								markerList.add(versionReferenceMarker);
							}
						}
					}
					
					else if(featureReference.getVersionRestriction() instanceof HyRelativeVersionRestriction) {
						HyRelativeVersionRestriction relativeVersionRestriction = (HyRelativeVersionRestriction) featureReference.getVersionRestriction();
						HyVersion version = relativeVersionRestriction.getVersion();
						
						if(version != null) {
							DwAnalysesMarker versionReferenceMarker = DwAnalyses.checkReferenceValidityConsistencyForReferencedElement(version, featureReference, containingElement);
							if(versionReferenceMarker != null) {
								markerList.add(versionReferenceMarker);
							}
						}
					}
				}
			}
			else if(expression instanceof HyAttributeReferenceExpression) {
				HyAttributeReferenceExpression attributeReference = (HyAttributeReferenceExpression) expression;
				
				HyFeature feature = attributeReference.getFeature();
				HyFeatureAttribute attribute = attributeReference.getAttribute();
				
				if(feature != null) {
					DwAnalysesMarker featureReferenceMarker = DwAnalyses.checkReferenceValidityConsistencyForReferencedElement(feature, attributeReference, containingElement);
					if(featureReferenceMarker != null) {
						markerList.add(featureReferenceMarker);
					}
				}
				
				if(attribute != null) {
					DwAnalysesMarker attributeReferenceMarker = DwAnalyses.checkReferenceValidityConsistencyForReferencedElement(attribute, attributeReference, containingElement);
					if(attributeReferenceMarker != null) {
						markerList.add(attributeReferenceMarker);
					}
				}
			}
			
		} 
		else if(expression instanceof HyBinaryExpression) {
			HyBinaryExpression binaryExpression = (HyBinaryExpression) expression;
			markerList.addAll(checkReferenceValidityConsistencyForExpression(binaryExpression.getOperand1(), containingElement));
			markerList.addAll(checkReferenceValidityConsistencyForExpression(binaryExpression.getOperand2(), containingElement));
		}
		else if(expression instanceof HyUnaryExpression) {
			HyUnaryExpression unaryExpression = (HyUnaryExpression) expression;
			markerList.addAll(checkReferenceValidityConsistencyForExpression(unaryExpression.getOperand(), containingElement));
		}
		
		return markerList;
	}
	
}
