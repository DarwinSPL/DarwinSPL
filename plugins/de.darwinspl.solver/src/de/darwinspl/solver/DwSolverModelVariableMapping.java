package de.darwinspl.solver;

import java.util.HashMap;
import java.util.Map;

import org.chocosolver.solver.variables.BoolVar;
import org.chocosolver.solver.variables.IntVar;

import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyVersion;

public class DwSolverModelVariableMapping {

	private Map<HyFeature, BoolVar> featureVariableMapping;
	private Map<HyVersion, BoolVar> versionVariableMapping;
	private Map<HyFeatureAttribute, IntVar> attributeVariableMapping;
	private Map<HyContextualInformation, IntVar> contextVariableMapping;
//	private Map<Date, IntVar> dateVariableMapping;
	
	public DwSolverModelVariableMapping() {
		featureVariableMapping = new HashMap<HyFeature, BoolVar>();
		versionVariableMapping = new HashMap<HyVersion, BoolVar>();
		attributeVariableMapping = new HashMap<HyFeatureAttribute, IntVar>();
		contextVariableMapping = new HashMap<HyContextualInformation, IntVar>();
	}

	public Map<HyFeature, BoolVar> getFeatureVariableMapping() {
		return featureVariableMapping;
	}

	public void setFeatureVariableMapping(Map<HyFeature, BoolVar> featureVariableMapping) {
		this.featureVariableMapping = featureVariableMapping;
	}

	public Map<HyVersion, BoolVar> getVersionVariableMapping() {
		return versionVariableMapping;
	}

	public void setVersionVariableMapping(Map<HyVersion, BoolVar> versionVariableMapping) {
		this.versionVariableMapping = versionVariableMapping;
	}

	public Map<HyFeatureAttribute, IntVar> getAttributeVariableMapping() {
		return attributeVariableMapping;
	}

	public void setAttributeVariableMapping(Map<HyFeatureAttribute, IntVar> attributeVariableMapping) {
		this.attributeVariableMapping = attributeVariableMapping;
	}

	public Map<HyContextualInformation, IntVar> getContextVariableMapping() {
		return contextVariableMapping;
	}

	public void setContextVariableMapping(Map<HyContextualInformation, IntVar> contextVariableMapping) {
		this.contextVariableMapping = contextVariableMapping;
	}

//	public Map<Date, IntVar> getDateVariableMapping() {
//		return dateVariableMapping;
//	}
//
//	public void setDateVariableMapping(Map<Date, IntVar> dateVariableMapping) {
//		this.dateVariableMapping = dateVariableMapping;
//	}
	
	
	
}
