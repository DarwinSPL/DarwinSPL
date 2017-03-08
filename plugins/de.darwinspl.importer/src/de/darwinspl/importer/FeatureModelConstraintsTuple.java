package de.darwinspl.importer;

import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.constraint.HyConstraintModel;

public class FeatureModelConstraintsTuple {

	private HyFeatureModel featureModel;
	private HyConstraintModel constraintModel;
	
	
	public FeatureModelConstraintsTuple() {
		
	}
	
	public FeatureModelConstraintsTuple(HyFeatureModel featureModel, HyConstraintModel constraintModel) {
		setFeatureModel(featureModel);
		setConstraintModel(constraintModel);
	}

	public HyFeatureModel getFeatureModel() {
		return featureModel;
	}

	public void setFeatureModel(HyFeatureModel featureModel) {
		this.featureModel = featureModel;
	}

	public HyConstraintModel getConstraintModel() {
		return constraintModel;
	}

	public void setConstraintModel(HyConstraintModel constraintModel) {
		this.constraintModel = constraintModel;
	}
	
	
}
