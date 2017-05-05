package de.darwinspl.feature.evolution.basic.operations;

import java.util.Date;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.util.HyFeatureEvolutionUtil;

public class GroupFeature extends MoveFeature {

	public GroupFeature(HyFeature feature, HyGroup targetGroup, Date timestamp) {
		super(feature, targetGroup, timestamp);
	}
	
	@Override
	public void execute() {
		
		HyGroup parentGroup = HyFeatureEvolutionUtil.getParentGroupOfFeature(feature, timestamp);
		
		if(!HyFeatureEvolutionUtil.isAnd(parentGroup, timestamp)) {
			// TODO error
			return;
		}		
		else if(HyFeatureEvolutionUtil.isAnd(targetGroup, timestamp)) {
			// TODO Error!
			return;
		} else {
			super.execute();
		}
	}
	
}
