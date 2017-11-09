package de.darwinspl.solver;

import java.util.Date;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.constraints.Constraint;
import org.chocosolver.util.ESat;

import eu.hyvar.context.HyContextModel;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.constraint.HyConstraint;
import eu.hyvar.feature.constraint.HyConstraintModel;

public class DwSolver {

	protected HyFeatureModel featureModel;
	protected HyContextModel contextModel;

	protected HyConstraintModel constraintModel;

	protected Model chocoModel;

	protected Solver solver;

	protected DwSolverModelVariableMapping featureModelMapping;

	public DwSolver(HyFeatureModel featureModel, HyContextModel contextModel, Date date) {
		setModels(featureModel, contextModel, date);
	}

	public void setModels(HyFeatureModel featureModel, HyContextModel contextModel, Date date) {
		if (featureModel == null) {
			throw new UnsupportedOperationException("Cannot proceed for null feature model");
		} else if (date == null) {
			throw new UnsupportedOperationException("Currently, a date has to be specified. Null is not supported.");
		}

		this.featureModel = featureModel;
		this.contextModel = contextModel;
		createNewChocoModel();

		this.featureModelMapping = DwSolverModelTranslation.translateModels(featureModel, contextModel, chocoModel, date);

		for(Constraint constraint: DwSolverModelTranslation.createFeatureModelConstraints(featureModel, chocoModel, featureModelMapping, date)) {
			chocoModel.post(constraint);
		}
		
		createNewSolver();
	}

	public void setConstraintModel(HyConstraintModel constraintModel, Date date) {
		if (constraintModel == null) {
			return;
//			throw new UnsupportedOperationException("Cannot proceed for null constraint model");
		}

		this.constraintModel = constraintModel;

		for (HyConstraint constraint : HyEvolutionUtil.getValidTemporalElements(constraintModel.getConstraints(),
				date)) {
			chocoModel
					.post(DwSolverModelTranslation.createExpressionConstraint(constraint.getRootExpression(), chocoModel, featureModelMapping, date));
		}
	}

	protected void createNewChocoModel() {
		this.chocoModel = new Model();
	}

	protected void createNewSolver() {
		this.solver = chocoModel.getSolver();
	}


	public boolean isSatisfiable() {
		boolean solveValue = solver.solve();
		return solveValue;
	}
}
