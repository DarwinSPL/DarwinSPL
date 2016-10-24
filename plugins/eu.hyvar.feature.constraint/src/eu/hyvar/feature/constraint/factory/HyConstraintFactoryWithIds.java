package eu.hyvar.feature.constraint.factory;

import eu.hyvar.feature.constraint.HyConstraint;
import eu.hyvar.feature.constraint.impl.HyConstraintFactoryImpl;

public class HyConstraintFactoryWithIds extends HyConstraintFactoryImpl {

	@Override
	public HyConstraint createHyConstraint() {
		HyConstraint hyConstraint = super.createHyConstraint();
		hyConstraint.createId();
		return hyConstraint;
	}
}
