package de.darwinspl.feature.constraint.generator;

import java.util.Random;

import de.darwinspl.expression.generator.DarwinExpressionGenerator;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.constraint.HyConstraint;
import eu.hyvar.feature.constraint.HyConstraintFactory;
import eu.hyvar.feature.constraint.HyConstraintModel;

public class DarwinConstraintGenerator {

	protected HyFeatureModel featureModel;
	
	protected HyConstraintFactory factory;

	protected DarwinExpressionGenerator expressionGenerator;
	
	private Random rand;
	
	public DarwinConstraintGenerator(HyFeatureModel featureModel) {
		this.featureModel = featureModel;
		this.factory = HyConstraintFactory.eINSTANCE;
		
		this.rand = new Random();
	}
	
	// TODO include attributes and versions
	public HyConstraintModel generateConstraintModel(int numberOfConstraints, int maximumNumberOfLiterals, boolean satisfiable) {
		HyConstraintModel constraintModel = factory.createHyConstraintModel();
		
		expressionGenerator = new DarwinExpressionGenerator(featureModel, null, constraintModel);
		
		for(int i = 0;i<numberOfConstraints;i++) {
			HyConstraint constraint = factory.createHyConstraint();
			
			constraint.setRootExpression(expressionGenerator.generateExpression(rand.nextInt(maximumNumberOfLiterals)+1, false, false, false, satisfiable, null, null));
			
			constraintModel.getConstraints().add(constraint);
		}
		
		return constraintModel;
	}
	
}
