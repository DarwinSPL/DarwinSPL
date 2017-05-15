package eu.hyvar.feature.constraint.util;

import java.util.Date;
import java.util.List;

import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.constraint.HyConstraint;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.expression.HyExpression;
import eu.hyvar.feature.expression.util.HyExpressionEvaluator;

public class HyConstraintEvaluator extends HyExpressionEvaluator {
	private List<HyFeature> selectedFeatures;
	private List<HyVersion> selectedVersions;
	
	private HyConstraint violatedConstraint;
	
	public boolean evaluate(HyConstraintModel constraintModel, List<HyFeature> selectedFeatures, Date date) {
		return evaluate(constraintModel, selectedFeatures, null, date);
	}
	
	public boolean evaluate(HyConstraintModel constraintModel, List<HyFeature> selectedFeatures, List<HyVersion> selectedVersions, Date date) {
		violatedConstraint = null;
		
		if (constraintModel == null) {
			//No constraints specified so they are satisfied.
			return true;
		}
		
		this.selectedFeatures = selectedFeatures;
		this.selectedVersions = selectedVersions;
		
		
		List<HyConstraint> constraints = HyEvolutionUtil.getValidTemporalElements(constraintModel.getConstraints(), date);
		
		for (HyConstraint constraint : constraints) {
			HyExpression rootExpression = constraint.getRootExpression();
			boolean isSatisfied = evaluateExpression(rootExpression);
			
			if (!isSatisfied) {
				violatedConstraint = constraint;
				return false;
			}
		}
		
		return true;
	}
	
	@Override
	protected boolean isFeaturePresent(HyFeature feature) {
		if (selectedFeatures == null) {
			return false;
		}
		
		return selectedFeatures.contains(feature);
	}

	@Override
	protected boolean isVersionPresent(HyVersion version) {
		if (selectedVersions == null) {
			return false;
		}
		
		return selectedVersions.contains(version);
	}

	public HyConstraint getViolatedConstraint() {
		return violatedConstraint;
	}
}
