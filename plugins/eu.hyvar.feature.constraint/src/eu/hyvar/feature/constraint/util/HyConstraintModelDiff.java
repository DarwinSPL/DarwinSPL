package eu.hyvar.feature.constraint.util;

import java.util.ArrayList;
import java.util.List;

import eu.hyvar.feature.constraint.HyConstraint;
import eu.hyvar.feature.constraint.HyConstraintModel;

public class HyConstraintModelDiff {


	private HyConstraintModel originConstraintModel;
	private HyConstraintModel evolvedConstraintModel;
	
	private List<HyConstraint> newConstraints;
	private List<HyConstraint> removedConstraints;
	
	
	public HyConstraintModelDiff() {
		newConstraints = new ArrayList<HyConstraint>();
		removedConstraints = new ArrayList<HyConstraint>();
	}
	
	public HyConstraintModel getOriginConstraintModel() {
		return originConstraintModel;
	}
	public void setOriginConstraintModel(HyConstraintModel originConstraintModel) {
		this.originConstraintModel = originConstraintModel;
	}
	public HyConstraintModel getEvolvedConstraintModel() {
		return evolvedConstraintModel;
	}
	public void setEvolvedConstraintModel(HyConstraintModel evolvedConstraintModel) {
		this.evolvedConstraintModel = evolvedConstraintModel;
	}
	public List<HyConstraint> getNewConstraints() {
		return newConstraints;
	}
	public void setNewConstraints(List<HyConstraint> newConstraints) {
		this.newConstraints = newConstraints;
	}
	public List<HyConstraint> getRemovedConstraints() {
		return removedConstraints;
	}
	public void setRemovedConstraints(List<HyConstraint> removedConstraints) {
		this.removedConstraints = removedConstraints;
	}
	
	
}
