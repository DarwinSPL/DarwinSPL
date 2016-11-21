package eu.hyvar.feature.impl.custom;

import java.util.Date;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.impl.HyFeatureImpl;

public class HyFeatureImplCustom extends HyFeatureImpl {

	protected HyFeatureImplCustom() {
		super();
	}
	
	@Override
	public boolean isMandatory(final Date date) {
		HyFeatureType type = HyEvolutionUtil.getValidTemporalElement(getTypes(), date);
		if(type.getType() == HyFeatureTypeEnum.MANDATORY) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean isOptional(final Date date) {
		HyFeatureType type = HyEvolutionUtil.getValidTemporalElement(getTypes(), date);
		if(type.getType() == HyFeatureTypeEnum.OPTIONAL) {
			return true;
		} else {
			return false;
		}
	}
	
}
