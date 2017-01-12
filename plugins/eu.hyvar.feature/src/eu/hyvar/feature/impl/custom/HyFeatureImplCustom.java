package eu.hyvar.feature.impl.custom;

import java.util.Date;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.impl.HyFeatureImpl;
import eu.hyvar.feature.util.HyFeatureEvolutionUtil;

public class HyFeatureImplCustom extends HyFeatureImpl {

	protected HyFeatureImplCustom() {
		super();
	}
	
	@Override
	public boolean isMandatory(final Date date) {
		return HyFeatureEvolutionUtil.isMandatory(this, date);
	}
	
	@Override
	public boolean isOptional(final Date date) {
		return HyFeatureEvolutionUtil.isOptional(this, date);
	}
	
}
