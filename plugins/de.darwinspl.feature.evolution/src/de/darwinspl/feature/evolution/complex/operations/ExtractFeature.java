package de.darwinspl.feature.evolution.complex.operations;

import java.util.Date;

import de.darwinspl.feature.evolution.basic.operations.AddFeatureWithGroup;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.util.HyFeatureEvolutionUtil;

public class ExtractFeature extends ComplexOperation {

	
	protected HyFeature sourceFeature;
	protected String extractedFeatureName;
	protected HyFeatureTypeEnum extractedFeatureType;
	
	protected HyFeature extractedFeature;
	
	/**
	 * 
	 * @param sourceFeature may not be null
	 * @param extractedFeatureName may be null
	 * @param extractedFeatureType may be null
	 * @param timestamp may not be null
	 */
	public ExtractFeature(HyFeature sourceFeature, String extractedFeatureName, HyFeatureTypeEnum extractedFeatureType, Date timestamp) {
		this.sourceFeature = sourceFeature;
		this.extractedFeatureName = extractedFeatureName;
		this.extractedFeatureType = extractedFeatureType;
		this.timestamp = timestamp;
	}
	
	@Override
	public void execute() {
		if(sourceFeature == null || timestamp == null) {
			return;
		}
		
		if(extractedFeatureName == null) {
			HyName sourceFeatureName = HyFeatureEvolutionUtil.getName(sourceFeature.getNames(), timestamp);
			extractedFeatureName = sourceFeatureName.getName()+"_extracted";
		}
		
		if(extractedFeatureType == null) {
			extractedFeatureType = HyFeatureTypeEnum.OPTIONAL;
		}
		
		HyFeature parent = HyFeatureEvolutionUtil.getParentFeatureOfFeature(sourceFeature, timestamp);
		
		AddFeatureWithGroup addFeatureWithGroup = new AddFeatureWithGroup(extractedFeatureName, extractedFeatureType, parent, timestamp, sourceFeature.getFeatureModel());
		addFeatureWithGroup.execute();
		extractedFeature = addFeatureWithGroup.getFeature();
		
		addToComposition(addFeatureWithGroup);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

}
