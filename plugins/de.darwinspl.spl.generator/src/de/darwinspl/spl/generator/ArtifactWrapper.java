package de.darwinspl.spl.generator;

import java.util.List;
import java.util.Map;

import de.darwinspl.evolution.guidance.EvolutionOperationType;
import de.darwinspl.feature.evolution.invoker.EvolutionOperation;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.mapping.HyMappingModel;

public class ArtifactWrapper {

	protected HyFeatureModel featureModel;
	protected HyMappingModel mappingModel;
	protected List<HyConfiguration> configurations;
	protected Map<EvolutionOperation, EvolutionOperationType> evoOps;
	protected HyConstraintModel constraintModel;
	
	
	public HyFeatureModel getFeatureModel() {
		return featureModel;
	}
	public void setFeatureModel(HyFeatureModel featureModel) {
		this.featureModel = featureModel;
	}
	public HyMappingModel getMappingModel() {
		return mappingModel;
	}
	public void setMappingModel(HyMappingModel mappingModel) {
		this.mappingModel = mappingModel;
	}
	public List<HyConfiguration> getConfigurations() {
		return configurations;
	}
	public void setConfigurations(List<HyConfiguration> configurations) {
		this.configurations = configurations;
	}
	public HyConstraintModel getConstraintModel() {
		return constraintModel;
	}
	public void setConstraintModel(HyConstraintModel constraintModel) {
		this.constraintModel = constraintModel;
	}
	public Map<EvolutionOperation, EvolutionOperationType> getEvoOps() {
		return evoOps;
	}
	public void setEvoOps(Map<EvolutionOperation, EvolutionOperationType> evoOps) {
		this.evoOps = evoOps;
	}
	
	
	
}
