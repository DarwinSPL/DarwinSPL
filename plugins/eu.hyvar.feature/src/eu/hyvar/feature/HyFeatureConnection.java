package eu.hyvar.feature;

import eu.hyvar.feature.HyFeature;

public class HyFeatureConnection {
	private HyFeature startFeature;
	private HyFeature endFeature;

	public HyFeatureConnection(HyFeature startFeature, HyFeature endFeature) {
		this.startFeature = startFeature;
		this.endFeature = endFeature;
	}

	public HyFeature getStartFeature() {
		return startFeature;
	}

	public HyFeature getEndFeature() {
		return endFeature;
	}
}
