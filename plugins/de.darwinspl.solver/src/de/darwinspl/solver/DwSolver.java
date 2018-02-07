package de.darwinspl.solver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.constraints.Constraint;

import de.darwinspl.solver.exception.DwAttributeValueOfSelectedFeatureNotSetException;
import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.information.contextValue.HyContextValueModel;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.constraint.HyConstraint;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.expression.HyExpression;

public class DwSolver {

	protected HyFeatureModel featureModel;
	protected HyContextModel contextModel;

	protected HyConstraintModel constraintModel;

	protected Model chocoModel;

	protected Solver solver;

	protected DwSolverModelVariableMapping featureModelMapping;

	protected Date date;
	
	protected List<Constraint> featureModelStructureAndCrossTreeConstraints;

	/**
	 * 
	 * @param featureModel
	 * @param contextModel
	 * @param date
	 * @param setFeatureModelConstraints
	 *            sets whether the structural constraints of the feature model
	 *            should be translated
	 */
	public DwSolver(HyFeatureModel featureModel, HyContextModel contextModel, Date date) {
		this.date = date;
		this.featureModelStructureAndCrossTreeConstraints = new ArrayList<Constraint>();
		
		setModels(featureModel, contextModel, date);
	}

	/**
	 * 
	 * @param featureModel
	 * @param contextModel
	 * @param date
	 * @param setFeatureModelConstraints
	 *            sets whether the structural constraints of the feature model
	 *            should be translated
	 */
	public void setModels(HyFeatureModel featureModel, HyContextModel contextModel, Date date) {
		if (featureModel == null) {
			throw new UnsupportedOperationException("Cannot proceed for null feature model");
		} else if (date == null) {
			throw new UnsupportedOperationException("Currently, a date has to be specified. Null is not supported.");
		}

		this.featureModel = featureModel;
		this.contextModel = contextModel;
		createNewChocoModel();

		this.featureModelMapping = DwSolverModelTranslation.translateModels(featureModel, contextModel, chocoModel,
				date);

		for (Constraint constraint : DwSolverModelTranslation.createFeatureModelConstraints(featureModel, chocoModel,
				featureModelMapping, date)) {
			chocoModel.post(constraint);
			featureModelStructureAndCrossTreeConstraints.add(constraint);
		}

		createNewSolver();
	}

	public void setFeatureModelConstraints() {
		for (Constraint constraint : DwSolverModelTranslation.createFeatureModelConstraints(featureModel, chocoModel,
				featureModelMapping, date)) {
			chocoModel.post(constraint);
			featureModelStructureAndCrossTreeConstraints.add(constraint);
		}
	}

	public void setConstraintModel(HyConstraintModel constraintModel, Date date) {
		if (constraintModel == null) {
			return;
			// throw new UnsupportedOperationException("Cannot proceed for null
			// constraint model");
		}

		this.constraintModel = constraintModel;

		for (HyConstraint constraint : HyEvolutionUtil.getValidTemporalElements(constraintModel.getConstraints(),
				date)) {
			Constraint expressionConstraint = DwSolverModelTranslation.createExpressionConstraint(constraint.getRootExpression(),
					chocoModel, featureModelMapping, date);
			chocoModel.post(expressionConstraint);
			featureModelStructureAndCrossTreeConstraints.add(expressionConstraint);
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

	public boolean isConfigurationValid(HyConfiguration configuration, HyContextValueModel contextValueModel)
			throws DwAttributeValueOfSelectedFeatureNotSetException {

		chocoModel.getSolver().reset();
		
		List<Constraint> postedConstraints;
		postedConstraints = DwSolverModelTranslation.createConstraintsFromConfiguration(configuration, chocoModel,
				featureModelMapping, date);
		
		if(contextValueModel != null) {
			postedConstraints.addAll(DwSolverModelTranslation.createConstraintsFromContextValidityModel(contextValueModel, chocoModel, featureModelMapping, date));			
		}

		for (Constraint postedConstraint : postedConstraints) {
			chocoModel.post(postedConstraint);
		}

		boolean configurationValid = chocoModel.getSolver().solve();

		// TODO extract methods for creating constraints for selecting versions,
		// features or setting attribute values. And for removing a list of
		// constraint

		for (Constraint postedConstraint : postedConstraints) {
			chocoModel.unpost(postedConstraint);
		}
		chocoModel.getSolver().reset();

		return configurationValid;
	}

	public boolean isExpressionSatisfied(HyExpression expression, HyConfiguration configuration, HyContextValueModel contextValueModel)
			throws DwAttributeValueOfSelectedFeatureNotSetException {

		chocoModel.getSolver().reset();
		
		List<Constraint> postedConstraints;
		postedConstraints = DwSolverModelTranslation.createConstraintsFromConfiguration(configuration, chocoModel,
				featureModelMapping, date);
		
		if(contextValueModel != null) {
			postedConstraints.addAll(DwSolverModelTranslation.createConstraintsFromContextValidityModel(contextValueModel, chocoModel, featureModelMapping, date));			
		}
		
		Constraint expressionConstraint = DwSolverModelTranslation.createExpressionConstraint(expression, chocoModel, featureModelMapping, date);
		
		for (Constraint postedConstraint : postedConstraints) {
			chocoModel.post(postedConstraint);
		}
		
		chocoModel.post(expressionConstraint);
		
		boolean expressionSatisfied = chocoModel.getSolver().solve();

		for (Constraint postedConstraint : postedConstraints) {
			chocoModel.unpost(postedConstraint);
		}
		
		chocoModel.unpost(expressionConstraint);

		return expressionSatisfied;
	}
	
	public boolean isExpressionSatisfiedWithoutFeatureModelConstraints(HyExpression expression, HyConfiguration configuration, HyContextValueModel contextValueModel) throws DwAttributeValueOfSelectedFeatureNotSetException {
		
		chocoModel.getSolver().reset();
		
		unpostConstraints(chocoModel, featureModelStructureAndCrossTreeConstraints);
		
		boolean expressionSatisfied;
		try {
			expressionSatisfied = isExpressionSatisfied(expression, configuration, contextValueModel);
		} catch (DwAttributeValueOfSelectedFeatureNotSetException e) {
//			postConstraints(chocoModel, featureModelStructureConstraints);
			throw e;
		}

		postConstraints(chocoModel, featureModelStructureAndCrossTreeConstraints);
		chocoModel.getSolver().reset();
		
		return expressionSatisfied;
	}
	
	protected static void postConstraints(Model chocoModel, List<Constraint> constraints) {
		for(Constraint constraint: constraints) {
			chocoModel.post(constraint);			
		}
	}
	
	protected static void unpostConstraints(Model chocoModel, List<Constraint> constraints) {
		for(Constraint constraint: constraints) {
			chocoModel.unpost(constraint);			
		}
	}
	
//	public void setDate(Date date) {
		// TODO!!! All constraints and feature list etc have to be updated.
//	}

}
