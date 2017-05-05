package de.darwinspl.feature.evolution.basic.operations;

import java.util.Date;
import java.util.List;

import de.darwinspl.feature.evolution.complex.operations.ComplexOperation;
import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.util.HyFeatureEvolutionUtil;

public class UngroupFeature extends ComplexOperation {

	protected HyFeature feature;
	
	public UngroupFeature(HyFeature feature, Date timestamp) {
		this.feature = feature;
		this.timestamp = timestamp;
	}
	
	@Override
	public void execute() {
		HyFeature parent = HyFeatureEvolutionUtil.getParentFeatureOfFeature(feature, timestamp);
		
		HyGroup targetGroup = null;
		
		List<HyFeatureChild> featureChildren = HyEvolutionUtil.getValidTemporalElements(parent.getParentOf(), timestamp);
		for(HyFeatureChild featureChild: featureChildren) {
			if(HyFeatureEvolutionUtil.isAnd(featureChild.getChildGroup(), timestamp)) {
				targetGroup = featureChild.getChildGroup();
				break;
			}
		}
		
		Move moveOperation = new Move(feature, parent, targetGroup, timestamp, feature.getFeatureModel());
		
		moveOperation.execute();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}
	
	// TODO getter and setter for necessary information.
	
}
