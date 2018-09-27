package de.darwinspl.reconfigurator.z3.client;

import java.util.ArrayList;
import java.util.List;

import eu.hyvar.feature.HyFeature;

public class DwZ3FeatureAnomaly {
	
	private String id;
	
	private HyFeature feature;
	
	private List<Integer> foundContexts;
	
	
	public DwZ3FeatureAnomaly(String id) {
		this.id = id;
		this.foundContexts = new ArrayList<Integer>();
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public List<Integer> getFoundContexts() {
		return foundContexts;
	}


	public void setFoundContexts(List<Integer> foundContexts) {
		this.foundContexts = foundContexts;
	}
	
	
	public void addContext(int context) {
		foundContexts.add(context);
	}


	public HyFeature getFeature() {
		return feature;
	}


	public void setFeature(HyFeature feature) {
		this.feature = feature;
	}

}
