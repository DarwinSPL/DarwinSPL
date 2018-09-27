package de.darwinspl.reconfigurator.z3.client;

import java.util.List;

public class DwZ3CheckFeaturesResult {
	
	List<DwZ3FeatureAnomaly> deadFeatures;
	
	
	public List<DwZ3FeatureAnomaly> getDeadFeatures() {
		return deadFeatures;
	}


	public void setDeadFeatures(List<DwZ3FeatureAnomaly> deadFeatures) {
		this.deadFeatures = deadFeatures;
	}


	public List<DwZ3FeatureAnomaly> getVoidFeatures() {
		return voidFeatures;
	}


	public void setVoidFeatures(List<DwZ3FeatureAnomaly> voidFeatures) {
		this.voidFeatures = voidFeatures;
	}


	List<DwZ3FeatureAnomaly> voidFeatures;
	
	

}
