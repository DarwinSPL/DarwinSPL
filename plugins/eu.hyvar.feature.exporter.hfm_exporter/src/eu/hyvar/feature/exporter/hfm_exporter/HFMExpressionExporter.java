package eu.hyvar.feature.exporter.hfm_exporter;

import java.util.Map;

import org.deltaecore.feature.DEFeature;
import org.deltaecore.feature.DEVersion;
import org.deltaecore.feature.expression.DEAbstractFeatureReferenceExpression;
import org.deltaecore.feature.expression.DEAtomicExpression;
import org.deltaecore.feature.expression.DEBinaryExpression;
import org.deltaecore.feature.expression.DEBooleanValueExpression;
import org.deltaecore.feature.expression.DEExpression;
import org.deltaecore.feature.expression.DEExpressionFactory;
import org.deltaecore.feature.expression.DERelativeVersionRestriction;
import org.deltaecore.feature.expression.DERelativeVersionRestrictionOperator;
import org.deltaecore.feature.expression.DEUnaryExpression;
import org.deltaecore.feature.expression.DEVersionRangeRestriction;
import org.deltaecore.feature.expression.DEVersionRestriction;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression;
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
import eu.hyvar.feature.expression.HyUnaryExpression;
import eu.hyvar.feature.expression.HyVersionRangeRestriction;
import eu.hyvar.feature.expression.HyVersionRestriction;
import eu.hyvar.feature.expression.util.HyExpressionExporter;

public class HFMExpressionExporter implements HyExpressionExporter<DEExpression> {

	private Map<HyFeature, DEFeature> featureMapping;
	private Map<HyVersion, DEVersion> versionMapping;

	public HFMExpressionExporter(Map<HyFeature, DEFeature> featureMapping, Map<HyVersion, DEVersion> versionMapping) {
		this.featureMapping = featureMapping;
		this.versionMapping = versionMapping;
	}
	
	public DEExpression exportExpression(HyExpression expression) throws UnsupportedOperationException {
		DEExpression deExpression = null;
		
		if(expression instanceof HyBinaryExpression) {
			deExpression = translateBinaryExpression((HyBinaryExpression) expression);
		} else if(expression instanceof HyUnaryExpression) {
			deExpression = translateUnaryExpression((HyUnaryExpression) expression);
		} else if(expression instanceof HyAtomicExpression) {
			deExpression = translateAtomicExpression((HyAtomicExpression) expression);
		} else {
			throw new UnsupportedOperationException("Can not translate expression: "+expression+ " to DeltaEcore expression");
		}
		
		return deExpression;
	}
	
	private DEBinaryExpression translateBinaryExpression(HyBinaryExpression expression) throws UnsupportedOperationException {
		DEBinaryExpression deExpression = null;
		
		if(expression instanceof HyAndExpression) {
			deExpression = DEExpressionFactory.eINSTANCE.createDEAndExpression();
		} else if(expression instanceof HyOrExpression) {
			deExpression = DEExpressionFactory.eINSTANCE.createDEOrExpression();
		} else if(expression instanceof HyEquivalenceExpression) {
			deExpression = DEExpressionFactory.eINSTANCE.createDEEquivalenceExpression();
		} else if(expression instanceof HyImpliesExpression) {
			deExpression = DEExpressionFactory.eINSTANCE.createDEImpliesExpression();
		} else {
			throw new UnsupportedOperationException("Can not translate expression: "+expression+ " to DeltaEcore expression");
		}
		
		
		deExpression.setOperand1(exportExpression(expression.getOperand1()));
		deExpression.setOperand2(exportExpression(expression.getOperand2()));
		
		return deExpression;
	}
	
	private DEUnaryExpression translateUnaryExpression(HyUnaryExpression expression) throws UnsupportedOperationException{
		DEUnaryExpression deExpression = null;
		
		if(expression instanceof HyNotExpression) {
			deExpression = DEExpressionFactory.eINSTANCE.createDENotExpression();
		} else if(expression instanceof HyNestedExpression) {
			deExpression = DEExpressionFactory.eINSTANCE.createDENestedExpression();
		} else {
			throw new UnsupportedOperationException("Can not translate expression: "+expression+ " to DeltaEcore expression");
		}
		
		deExpression.setOperand(exportExpression(expression.getOperand()));
		
		return deExpression;
	}
	
	private DEAtomicExpression translateAtomicExpression(HyAtomicExpression expression) throws UnsupportedOperationException {
		DEAtomicExpression deExpression = null;
		
		if(expression instanceof HyAbstractFeatureReferenceExpression) {
			deExpression = translateAbstractFeatureReferenceExpression((HyAbstractFeatureReferenceExpression) expression);
		} else if(expression instanceof HyBooleanValueExpression) {
			DEBooleanValueExpression booleanValueExpression = DEExpressionFactory.eINSTANCE.createDEBooleanValueExpression();
			booleanValueExpression.setValue(((HyBooleanValueExpression)expression).isValue());
			deExpression = booleanValueExpression;
		} else {
			throw new UnsupportedOperationException("Can not translate expression: "+expression+ " to DeltaEcore expression");
		}
		
		return deExpression;
	}
	
	private DEAbstractFeatureReferenceExpression translateAbstractFeatureReferenceExpression(HyAbstractFeatureReferenceExpression expression) {
		DEAbstractFeatureReferenceExpression deExpression = null;
		
		if(expression instanceof HyFeatureReferenceExpression) {
			deExpression = DEExpressionFactory.eINSTANCE.createDEFeatureReferenceExpression();
		} else if(expression instanceof HyConditionalFeatureReferenceExpression) {
			deExpression = DEExpressionFactory.eINSTANCE.createDEConditionalFeatureReferenceExpression();
		}
		
		if(expression.getFeature() != null) {
			DEFeature feature = featureMapping.get(expression.getFeature());
			if(feature == null) {
				System.err.println("Could not get mapped feature for "+expression.getFeature()+ " while translating expression");				
			}
			deExpression.setFeature(feature);
			
			if(expression.getVersionRestriction() != null) {
				DEVersionRestriction versionRestriction = translateVersionRestriction(expression.getVersionRestriction());
				if(versionRestriction != null) {
					versionRestriction.setRestrictedFeatureReferenceExpression(deExpression);
				}
				deExpression.setVersionRestriction(versionRestriction);
			}
		}
		
		return deExpression;
	}
	
	private DEVersionRestriction translateVersionRestriction(HyVersionRestriction restriction) {
		DEVersionRestriction deRestriction = null;
		
		
		if(restriction instanceof HyVersionRangeRestriction) {
			deRestriction = translateVersionRangeRestriction((HyVersionRangeRestriction) restriction);
		} else if(restriction instanceof HyRelativeVersionRestriction) {
			deRestriction = translateRelativeVersionRestriction((HyRelativeVersionRestriction) restriction);
		}
		
		return deRestriction;
	}
	
	private DEVersionRangeRestriction translateVersionRangeRestriction(HyVersionRangeRestriction restriction) {
		
		DEVersionRangeRestriction deRestriction = DEExpressionFactory.eINSTANCE.createDEVersionRangeRestriction();
		
		deRestriction.setLowerIncluded(restriction.isLowerIncluded());
		deRestriction.setUpperIncluded(restriction.isUpperIncluded());
		if(restriction.getLowerVersion() != null) {
			DEVersion lowerVersion = versionMapping.get(restriction.getLowerVersion());
			if(lowerVersion == null) {
				System.err.println("Could not get mapped version for "+restriction.getLowerVersion()+" while translating expression");
			}
			deRestriction.setLowerVersion(lowerVersion);
		}
		
		if(restriction.getUpperVersion() != null) {
			DEVersion upperVersion = versionMapping.get(restriction.getUpperVersion());
			if(upperVersion == null) {
				System.err.println("Could not get mapped version for "+restriction.getUpperVersion()+" while translating expression");
			}
			deRestriction.setLowerVersion(upperVersion);
		}
		
		return deRestriction;
	}
	
	private DERelativeVersionRestriction translateRelativeVersionRestriction(HyRelativeVersionRestriction restriction) {
		DERelativeVersionRestriction deRestriction = DEExpressionFactory.eINSTANCE.createDERelativeVersionRestriction();
		
		if(restriction.getVersion() != null) {
			DEVersion deVersion = versionMapping.get(restriction.getVersion());
			if(deVersion == null) {
				System.err.println("Could not get mapped version for "+restriction.getVersion()+" while translating expression");
			}
			
			deRestriction.setVersion(deVersion);
		}
		
		switch(restriction.getOperator()) {
		case EQUAL:
			deRestriction.setOperator(DERelativeVersionRestrictionOperator.EQUAL);
			break;
		case GREATER_THAN:
			deRestriction.setOperator(DERelativeVersionRestrictionOperator.GREATER_THAN);
			break;
		case GREATER_THAN_OR_EQUAL:
			deRestriction.setOperator(DERelativeVersionRestrictionOperator.GREATER_THAN_OR_EQUAL);
			break;
		case IMPLICIT_EQUAL:
			deRestriction.setOperator(DERelativeVersionRestrictionOperator.IMPLICIT_EQUAL);
			break;
		case LESS_THAN:
			deRestriction.setOperator(DERelativeVersionRestrictionOperator.LESS_THAN);
			break;
		case LESS_THAN_OR_EQUAL:
			deRestriction.setOperator(DERelativeVersionRestrictionOperator.LESS_THAN_OR_EQUAL);
			break;
		default:
			deRestriction.setOperator(DERelativeVersionRestrictionOperator.EQUAL);
			break;
		
		}
		
		return deRestriction;
	}

}
