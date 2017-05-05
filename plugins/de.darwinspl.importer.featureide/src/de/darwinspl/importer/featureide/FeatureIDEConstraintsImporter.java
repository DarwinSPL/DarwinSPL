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
import eu.hyvar.feature.expression.HyAndExpression;
import eu.hyvar.feature.expression.HyBinaryExpression;
import eu.hyvar.feature.expression.HyEquivalenceExpression;
import eu.hyvar.feature.expression.HyExpression;
import eu.hyvar.feature.expression.HyExpressionFactory;
import eu.hyvar.feature.expression.HyFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyImpliesExpression;
import eu.hyvar.feature.expression.HyNotExpression;
import eu.hyvar.feature.expression.HyOrExpression;

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
		
		
		if(node instanceof And) {
			HyAndExpression andExpression = expressionFactory.createHyAndExpression();
			
			getChildrenOfBinaryExpression(andExpression, node);
			
			expression = andExpression;
		} 
		else if(node instanceof Or) {
			HyOrExpression orExpression = expressionFactory.createHyOrExpression();
			
			getChildrenOfBinaryExpression(orExpression, node);
			
			expression = orExpression;
		}
		else if(node instanceof Implies) {
			HyImpliesExpression impliesExpression = expressionFactory.createHyImpliesExpression();
			
			getChildrenOfBinaryExpression(impliesExpression, node);
			
			expression = impliesExpression;
		}
		else if(node instanceof Equals) {
			HyEquivalenceExpression equivalenceExpression = expressionFactory.createHyEquivalenceExpression();
			
			getChildrenOfBinaryExpression(equivalenceExpression, node);
			
			expression = equivalenceExpression;
		}
		else if(node instanceof Not) {
			HyNotExpression notExpression = expressionFactory.createHyNotExpression();
			
			notExpression.setOperand(createExpression(node.getChildren()[0]));
			
			expression = notExpression;
		}
		else if(node instanceof Literal) {
			Literal literal = (Literal) node;
			
			
			if(literal.var instanceof String) {
				HyFeatureReferenceExpression featureReferenceExpression = expressionFactory.createHyFeatureReferenceExpression();
				HyFeature feature = getFeature((String)literal.var);
				featureReferenceExpression.setFeature(feature);
				
				expression = featureReferenceExpression;
			}
			else {
				System.err.println("Could not find referenced feature of literal: "+literal);
				// TODO proper error handling
			}
			
		}
		
		return expression;
	}
	
	private void getChildrenOfBinaryExpression(HyBinaryExpression binaryExpression, Node node) {
		binaryExpression.setOperand1(createExpression(node.getChildren()[0]));
		binaryExpression.setOperand2(createExpression(node.getChildren()[1]));
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
