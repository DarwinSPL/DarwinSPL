package de.darwinspl.importer.deltaecore;

import java.util.List;
import java.util.Map;

import org.deltaecore.feature.DEFeature;
import org.deltaecore.feature.DEFeatureModel;
import org.deltaecore.feature.DEVersion;
import org.deltaecore.feature.constraint.DEConstraint;
import org.deltaecore.feature.constraint.DEConstraintModel;
import org.deltaecore.feature.expression.DEAbstractFeatureReferenceExpression;
import org.deltaecore.feature.expression.DEAndExpression;
import org.deltaecore.feature.expression.DEAtomicExpression;
import org.deltaecore.feature.expression.DEBinaryExpression;
import org.deltaecore.feature.expression.DEBooleanValueExpression;
import org.deltaecore.feature.expression.DEConditionalFeatureReferenceExpression;
import org.deltaecore.feature.expression.DEEquivalenceExpression;
import org.deltaecore.feature.expression.DEExpression;
import org.deltaecore.feature.expression.DEFeatureReferenceExpression;
import org.deltaecore.feature.expression.DEImpliesExpression;
import org.deltaecore.feature.expression.DENestedExpression;
import org.deltaecore.feature.expression.DENotExpression;
import org.deltaecore.feature.expression.DEOrExpression;
import org.deltaecore.feature.expression.DERelativeVersionRestriction;
import org.deltaecore.feature.expression.DEUnaryExpression;
import org.deltaecore.feature.expression.DEVersionRangeRestriction;
import org.deltaecore.feature.expression.DEVersionRestriction;

import de.darwinspl.importer.DarwinSPLConstraintsImporter;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.constraint.HyConstraint;
import eu.hyvar.feature.constraint.HyConstraintFactory;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.expression.HyAbstractFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyAtomicExpression;
import eu.hyvar.feature.expression.HyBinaryExpression;
import eu.hyvar.feature.expression.HyBooleanValueExpression;
import eu.hyvar.feature.expression.HyExpression;
import eu.hyvar.feature.expression.HyExpressionFactory;
import eu.hyvar.feature.expression.HyRelativeVersionRestriction;
import eu.hyvar.feature.expression.HyRelativeVersionRestrictionOperator;
import eu.hyvar.feature.expression.HyUnaryExpression;
import eu.hyvar.feature.expression.HyVersionRangeRestriction;
import eu.hyvar.feature.expression.HyVersionRestriction;

public class DeltaEcoreConstraintsImporter implements DarwinSPLConstraintsImporter<DEFeatureModel, DEFeature, DEConstraintModel> {

	protected HyConstraintFactory constraintFactory;
	protected HyExpressionFactory expressionFactory;
	protected Map<DEVersion, HyVersion> versionMapping;
	protected Map<DEFeature, HyFeature> featureMapping;
	
	public DeltaEcoreConstraintsImporter(Map<DEVersion, HyVersion> versionMapping) {
		this.versionMapping = versionMapping;
		constraintFactory = HyConstraintFactory.eINSTANCE;
		expressionFactory = HyExpressionFactory.eINSTANCE;
	}
	
	@Override
	public HyConstraintModel importConstraints(HyFeatureModel featureModel, Map<DEFeature, HyFeature> featureMapping,
			DEFeatureModel originalFeatureModel, List<DEConstraintModel> constraints) {

		this.featureMapping = featureMapping;
		
		HyConstraintModel dwConstraintModel = constraintFactory.createHyConstraintModel();
		
		for(DEConstraintModel constraintModel: constraints) {
			for(DEConstraint deConstraint: constraintModel.getConstraints()) {
				HyConstraint dwConstraint = constraintFactory.createHyConstraint();
				
				dwConstraint.setRootExpression(translateExpression(deConstraint.getRootExpression()));
				
				dwConstraintModel.getConstraints().add(dwConstraint);
			}
		}
		
		
		return dwConstraintModel;
	}
	
	protected HyExpression translateExpression(DEExpression expression) {
		HyExpression dwExpression = null;
		
		if(expression instanceof DEAtomicExpression) {
			dwExpression = translateAtomicExpression((DEAtomicExpression)expression);
		}
		else if(expression instanceof DEBinaryExpression) {
			dwExpression = translateBinaryExpression((DEBinaryExpression)expression);
			
		}
		else if(expression instanceof DEUnaryExpression) {
			dwExpression = translateUnaryExpression((DEUnaryExpression)expression);
			
		}
			
		return dwExpression;
	}
	
	protected HyUnaryExpression translateUnaryExpression(DEUnaryExpression expression) {
		HyUnaryExpression dwUnaryExpression = null;
		
		if(expression instanceof DENestedExpression) {
			dwUnaryExpression = expressionFactory.createHyNestedExpression();
		}
		else if(expression instanceof DENotExpression) {
			dwUnaryExpression = expressionFactory.createHyNotExpression();
		}
		
		dwUnaryExpression.setOperand(translateExpression(expression.getOperand()));
		
		return dwUnaryExpression;
	}
	
	
	protected HyBinaryExpression translateBinaryExpression(DEBinaryExpression expression) {
		HyBinaryExpression dwBinaryExpression = null;
		
		if(expression instanceof DEAndExpression) {
			dwBinaryExpression = expressionFactory.createHyAndExpression();
		}
		else if(expression instanceof DEOrExpression) {
			dwBinaryExpression = expressionFactory.createHyOrExpression();
		}
		else if(expression instanceof DEEquivalenceExpression) {
			dwBinaryExpression = expressionFactory.createHyEquivalenceExpression();
		}
		else if(expression instanceof DEImpliesExpression) {
			dwBinaryExpression = expressionFactory.createHyImpliesExpression();
		}
		
		dwBinaryExpression.setOperand1(translateExpression(expression.getOperand1()));
		dwBinaryExpression.setOperand2(translateExpression(expression.getOperand2()));
		
		return dwBinaryExpression;		
	}
	
	
	protected HyAtomicExpression translateAtomicExpression(DEAtomicExpression expression) {
		HyAtomicExpression atomicExpression = null;
		
		if(expression instanceof DEBooleanValueExpression) {
			DEBooleanValueExpression booleanValueExpression = (DEBooleanValueExpression) expression;
			HyBooleanValueExpression dwBooleanValueExpression = expressionFactory.createHyBooleanValueExpression();
			dwBooleanValueExpression.setValue(booleanValueExpression.isValue());
			
			atomicExpression = dwBooleanValueExpression;
		}
		else if(expression instanceof DEAbstractFeatureReferenceExpression) {
			DEAbstractFeatureReferenceExpression deAbstractFeatureReferenceExpression = (DEAbstractFeatureReferenceExpression) expression;
			
			HyAbstractFeatureReferenceExpression dwAbstractFeatureReferenceExpression = null;
			
			if(deAbstractFeatureReferenceExpression instanceof DEFeatureReferenceExpression) {
				dwAbstractFeatureReferenceExpression = expressionFactory.createHyFeatureReferenceExpression();
			}
			else if(deAbstractFeatureReferenceExpression instanceof DEConditionalFeatureReferenceExpression) {
				dwAbstractFeatureReferenceExpression = expressionFactory.createHyConditionalFeatureReferenceExpression();
			}
			
			dwAbstractFeatureReferenceExpression.setFeature(featureMapping.get(deAbstractFeatureReferenceExpression.getFeature()));
			dwAbstractFeatureReferenceExpression.setVersionRestriction(translateVersionRestriction(deAbstractFeatureReferenceExpression.getVersionRestriction()));
			
			atomicExpression = dwAbstractFeatureReferenceExpression;
		}
		
		
		return atomicExpression;
	}
	
	protected HyVersionRestriction translateVersionRestriction(DEVersionRestriction versionRestriction) {
		HyVersionRestriction dwVersionRestriction = null;
		
		if(versionRestriction instanceof DEVersionRangeRestriction) {
			DEVersionRangeRestriction deVersionRangeRestriction = (DEVersionRangeRestriction) versionRestriction;
			
			HyVersionRangeRestriction dwVersionRangeRestriction = expressionFactory.createHyVersionRangeRestriction();
			dwVersionRangeRestriction.setLowerIncluded(deVersionRangeRestriction.isLowerIncluded());
			dwVersionRangeRestriction.setUpperIncluded(deVersionRangeRestriction.isUpperIncluded());
			
			dwVersionRangeRestriction.setLowerVersion(versionMapping.get(deVersionRangeRestriction.getLowerVersion()));
			dwVersionRangeRestriction.setUpperVersion(versionMapping.get(deVersionRangeRestriction.getUpperVersion()));
			
			dwVersionRestriction = dwVersionRangeRestriction;
		}
		else if(versionRestriction instanceof DERelativeVersionRestriction) {
			DERelativeVersionRestriction deRelativeVersionRestriction = (DERelativeVersionRestriction) versionRestriction;
			
			HyRelativeVersionRestriction dwRelativeVersionRestriction = expressionFactory.createHyRelativeVersionRestriction();
			
			dwRelativeVersionRestriction.setVersion(versionMapping.get(deRelativeVersionRestriction.getVersion()));
			
			switch(deRelativeVersionRestriction.getOperator()) {
			case EQUAL:
				dwRelativeVersionRestriction.setOperator(HyRelativeVersionRestrictionOperator.EQUAL);
				break;
			case GREATER_THAN:
				dwRelativeVersionRestriction.setOperator(HyRelativeVersionRestrictionOperator.GREATER_THAN);
				break;
			case GREATER_THAN_OR_EQUAL:
				dwRelativeVersionRestriction.setOperator(HyRelativeVersionRestrictionOperator.GREATER_THAN_OR_EQUAL);
				break;
			case IMPLICIT_EQUAL:
				dwRelativeVersionRestriction.setOperator(HyRelativeVersionRestrictionOperator.IMPLICIT_EQUAL);
				break;
			case LESS_THAN:
				dwRelativeVersionRestriction.setOperator(HyRelativeVersionRestrictionOperator.LESS_THAN);
				break;
			case LESS_THAN_OR_EQUAL:
				dwRelativeVersionRestriction.setOperator(HyRelativeVersionRestrictionOperator.LESS_THAN_OR_EQUAL);
				break;
			default:
				dwRelativeVersionRestriction.setOperator(HyRelativeVersionRestrictionOperator.EQUAL);
				break;
			
			}
			
			dwVersionRestriction = dwRelativeVersionRestriction;
		}
		
		return dwVersionRestriction;
	}

}
