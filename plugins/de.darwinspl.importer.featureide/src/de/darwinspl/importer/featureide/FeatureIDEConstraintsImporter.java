package de.darwinspl.importer.featureide;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.prop4j.And;
import org.prop4j.Equals;
import org.prop4j.Implies;
import org.prop4j.Literal;
import org.prop4j.Node;
import org.prop4j.Not;
import org.prop4j.Or;

import de.ovgu.featureide.fm.core.base.IConstraint;
import de.ovgu.featureide.fm.core.base.IFeature;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.constraint.HyConstraint;
import eu.hyvar.feature.constraint.HyConstraintFactory;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.expression.HyBinaryExpression;
import eu.hyvar.feature.expression.HyExpression;
import eu.hyvar.feature.expression.HyExpressionFactory;
import eu.hyvar.feature.expression.HyFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyNotExpression;

public class FeatureIDEConstraintsImporter {

	protected HyConstraintFactory constraintFactory;
	protected HyExpressionFactory expressionFactory;
	
	protected Map<IFeature, HyFeature> featureMap;
	
	public HyConstraintModel importConstraints(List<IConstraint> featureIDEconstraints, HyFeatureModel featureModel, Map<IFeature, HyFeature> featureMap) {
		
		this.featureMap = featureMap;
		
		constraintFactory = HyConstraintFactory.eINSTANCE;
		expressionFactory = HyExpressionFactory.eINSTANCE;
		
		HyConstraintModel constraintModel = constraintFactory.createHyConstraintModel();
		
		for(IConstraint constraint: featureIDEconstraints) {
			HyConstraint newConstraint = constraintFactory.createHyConstraint();
			
			newConstraint.setRootExpression(createExpression(constraint.getNode()));
			
			constraintModel.getConstraints().add(newConstraint);
		}
		
		return constraintModel;
	}
	
	private HyExpression createExpression(Node node) {
		HyExpression expression = null;
		
		if(node instanceof Not) {
				HyNotExpression notExpression = expressionFactory.createHyNotExpression();
				
				notExpression.setOperand(createExpression(node.getChildren()[0]));
				
				expression = notExpression;	
		}
		else if(node instanceof Literal) {
			Literal literal = (Literal) node;
			
			
			if(literal.var instanceof String) {
				HyFeatureReferenceExpression featureReferenceExpression = expressionFactory.createHyFeatureReferenceExpression();
				HyFeature feature = getFeature((String)literal.var);
				
				if(feature == null) {
					System.err.println("Could not find referenced feature of "+(String)literal.var);
				}
				
				featureReferenceExpression.setFeature(feature);
				
				expression = featureReferenceExpression;
			}
			else {
				System.err.println("Could not find referenced feature of literal: "+literal);
				// TODO proper error handling
			}
			
			// strange possible behavior of Nodes
			if(!literal.positive) {
				HyNotExpression notExpression = expressionFactory.createHyNotExpression();
				
				notExpression.setOperand(expression);
				
				expression = notExpression;
				System.out.println("Strange Behavior");
			}
			
			
			
		}
		else {
			HyBinaryExpression binaryExpression = null;
			if(node instanceof And) {
				binaryExpression = expressionFactory.createHyAndExpression();
			} 
			else if(node instanceof Or) {
				binaryExpression = expressionFactory.createHyOrExpression();
			}
			else if(node instanceof Implies) {
				binaryExpression = expressionFactory.createHyImpliesExpression();
			}
			else if(node instanceof Equals) {
				binaryExpression = expressionFactory.createHyEquivalenceExpression();
			}
			else {
				System.err.println("Unknown node type!");
			}
			
			HyExpression operand1 = createExpression(node.getChildren()[0]);
			HyExpression operand2 = createExpression(node.getChildren()[1]);
			
			if(operand1 == null || operand2 == null) {
				System.err.println("Operands were null!");
				return null;
			}
			
			binaryExpression.setOperand1(operand1);
			binaryExpression.setOperand2(operand2);
			
			expression = binaryExpression;
		}
		
		
		
		return expression;
	}
	
	private HyFeature getFeature(String featureName) {
		for(Entry<IFeature, HyFeature> entry: featureMap.entrySet()) {
			if(entry.getKey().getName().equals(featureName)) {
				return entry.getValue();
			}
		}
		
		return null;
	}
	
}
