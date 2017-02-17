package eu.hyvar.feature.impl.custom;

import java.util.Date;

import eu.hyvar.feature.impl.HyGroupImpl;
import eu.hyvar.feature.util.HyFeatureEvolutionUtil;

public class HyGroupImplCustom extends HyGroupImpl {
	
	protected HyGroupImplCustom() {
		super();
	}
	
	@Override
	public boolean isAlternative(final Date date) {
		return HyFeatureEvolutionUtil.isAlternative(this, date);
	}

	@Override
	public boolean isOr(final Date date) {
		return HyFeatureEvolutionUtil.isOr(this, date);
	}

	@Override
	public boolean isAnd(final Date date) {
		return HyFeatureEvolutionUtil.isAnd(this, date);
	}
}
