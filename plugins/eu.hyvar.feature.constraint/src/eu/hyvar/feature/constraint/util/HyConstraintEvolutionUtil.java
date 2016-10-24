package eu.hyvar.feature.constraint.util;

import java.util.Date;
import java.util.List;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.constraint.HyConstraint;
import eu.hyvar.feature.constraint.HyConstraintModel;

public class HyConstraintEvolutionUtil {

	@SuppressWarnings("unchecked")
	public static List<HyConstraint> getValidConstraints(HyConstraintModel constraintModel, Date date) {
		return (List<HyConstraint>)(List<?>)HyEvolutionUtil.getValidTemporalElements(constraintModel.getConstraints(), date);
	}
}
