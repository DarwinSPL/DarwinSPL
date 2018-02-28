package de.darwinspl.importer;

import de.darwinspl.common.util.Tuple;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.constraint.HyConstraintModel;

public class FeatureModelConstraintsTuple extends Tuple<HyFeatureModel, HyConstraintModel> {

	public FeatureModelConstraintsTuple(HyFeatureModel x, HyConstraintModel y) {
		super(x, y);
	}

//	private HyFeatureModel featureModel;
//	private HyConstraintModel constraintModel;
	
	
//	public FeatureModelConstraintsTuple() {
//		
//	}
	
//	public FeatureModelConstraintsTuple(HyFeatureModel featureModel, HyConstraintModel constraintModel) {
//		setFeatureModel(featureModel);
//		setConstraintModel(constraintModel);
//	}
//
	public HyFeatureModel getFeatureModel() {
		return x;
	}
//
//	public void setFeatureModel(HyFeatureModel featureModel) {
//		this.featureModel = featureModel;
//	}
//
	public HyConstraintModel getConstraintModel() {
		return y;
	}
//
//	public void setConstraintModel(HyConstraintModel constraintModel) {
//		this.constraintModel = constraintModel;
//	}
	
	
}
