package eu.hyvar.feature.impl.custom;

import java.util.Date;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.impl.HyGroupImpl;

public class HyGroupImplCustom extends HyGroupImpl {
	
	protected HyGroupImplCustom() {
		super();
	}
	
	@Override
	public boolean isAlternative(final Date date) {
		HyGroupType type = HyEvolutionUtil.getValidTemporalElement(getTypes(), date);
		if(type.getType() == HyGroupTypeEnum.ALTERNATIVE) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isOr(final Date date) {
		HyGroupType type = HyEvolutionUtil.getValidTemporalElement(getTypes(), date);
		if(type.getType() == HyGroupTypeEnum.OR) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isAnd(final Date date) {
		HyGroupType type = HyEvolutionUtil.getValidTemporalElement(getTypes(), date);
		if(type.getType() == HyGroupTypeEnum.AND) {
			return true;
		} else {
			return false;
		}
	}
}
