package de.darwinspl.expression.generator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.deltaecore.feature.DEFeatureModel;
import org.deltaecore.feature.analysis.util.SatisfiabilityChecker;
import org.deltaecore.feature.constraint.DEConstraintModel;
import org.deltaecore.feature.expression.DEExpression;

import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.exporter.hfm_exporter.HFMConstraintModelExporter;
import eu.hyvar.feature.exporter.hfm_exporter.HFMExporter;
import eu.hyvar.feature.exporter.hfm_exporter.HFMExpressionExporter;
import eu.hyvar.feature.expression.HyAtomicExpression;
import eu.hyvar.feature.expression.HyBinaryExpression;
import eu.hyvar.feature.expression.HyExpression;
import eu.hyvar.feature.expression.HyExpressionFactory;
import eu.hyvar.feature.expression.HyFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyUnaryExpression;
import eu.hyvar.feature.util.HyFeatureEvolutionUtil;
import eu.hyvar.feature.util.HyFeatureModelWellFormednessException;

public class DarwinExpressionGenerator {

	
	protected HyFeatureModel featureModel;
	protected HyConstraintModel constraintModel;
	protected HyContextModel contextModel;
	protected HyExpressionFactory factory;
	
	protected DEFeatureModel deltaEcoreFeatureModel;
	protected DEConstraintModel deltaEcoreConstraintModel;
	
	protected HFMExpressionExporter deltaEcoreExpressionExporter;
	
	private Random rand;
	
	
	
	public DarwinExpressionGenerator(HyFeatureModel featureModel, HyContextModel contextModel, HyConstraintModel constraintModel) {		
		this.featureModel = featureModel;
		this.contextModel = contextModel;
		this.constraintModel = constraintModel;
		this.factory = HyExpressionFactory.eINSTANCE;
		
		
		
		rand = new Random();
	}
	
	// TODO include versions, attributes and contexts
	// TODO set expressions
	// TODO equals with values and so on
	
	public HyExpression generateExpression(int numberOfLiterals, boolean includeVersions, boolean includeContexts, boolean includeAttributes, HyExpression parentExpression, Date date) {
		
		boolean exported = false;
		
		if(deltaEcoreFeatureModel == null) {
			exported = true;
			
			HFMExporter deltaEcoreExporter = new HFMExporter();
			try {
				deltaEcoreFeatureModel = deltaEcoreExporter.exportFeatureModel(featureModel, date);

				deltaEcoreExpressionExporter = new HFMExpressionExporter(deltaEcoreExporter.getFeatureMapping(), deltaEcoreExporter.getVersionMapping());
				
				if(constraintModel != null) {
					HFMConstraintModelExporter constraintExporter = new HFMConstraintModelExporter(deltaEcoreExporter.getFeatureMapping(), deltaEcoreExporter.getVersionMapping());
					deltaEcoreConstraintModel = constraintExporter.exportConstraintModel(constraintModel, date);					
				}
				
			} catch (HyFeatureModelWellFormednessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		HyExpression expression = null;
		
		// TODO Will go bad if not types of according atomic expressions are not checked! Only interesting if number of literals <= 3?
		
		if(numberOfLiterals >= 2) {
			HyBinaryExpression binaryExpression = null;
			
			int binaryIndex = rand.nextInt(4);
			switch(binaryIndex) {
			case 0:
				binaryExpression = factory.createHyAndExpression();
				break;
			case 1:
				binaryExpression = factory.createHyOrExpression();
				break;
//			case 2:
//				binaryExpression = factory.createHyEquivalenceExpression();
//				break;
			case 2:
				binaryExpression = factory.createHyImpliesExpression();
				break;
			case 3:
				expression = generateUnaryExpression(numberOfLiterals, includeVersions, includeContexts, includeAttributes, date, false);
				break;
			}
			
			if(binaryExpression != null) {
				
				int leftHandLiteralNumber = (int) Math.ceil(numberOfLiterals / 2.0);
				int rightHandLiteralNumber = (int) Math.floor(numberOfLiterals / 2.0);
				
				// TODO this might take a VERY long time for bigger expressions
				do {
					binaryExpression.setOperand1(generateExpression(leftHandLiteralNumber, includeVersions, includeContexts, includeAttributes, binaryExpression, date));			
					binaryExpression.setOperand2(generateExpression(rightHandLiteralNumber, includeVersions, includeContexts, includeAttributes, binaryExpression, date));					
				} while(!checkSatisfiability(binaryExpression));
				
				expression = binaryExpression;
			}
			
			
		}
		
		else if(numberOfLiterals >= 1) {
			// TODO too probable to create unary instead of atomic?!
			if(rand.nextInt(100) >= 20) {
				expression = generateAtomicExpression(includeVersions, includeContexts, includeAttributes, date);				
			} else {
				expression = generateUnaryExpression(numberOfLiterals, includeVersions, includeContexts, includeAttributes, date, false);
			}
		}
		
		if(exported) {
			deltaEcoreFeatureModel = null;			
		}
		
		return expression;
	}
	
	protected boolean checkSatisfiability(HyExpression expression) {
		
		DEExpression deltaEcoreExpression = deltaEcoreExpressionExporter.exportExpression(expression);
		List<DEExpression> expressionList = new ArrayList<DEExpression>(1);
		expressionList.add(deltaEcoreExpression);
		
		SatisfiabilityChecker satChecker = new SatisfiabilityChecker();
		return satChecker.isExpressionSatisfiableWithFeatureModelConstraints(deltaEcoreFeatureModel, deltaEcoreConstraintModel, expressionList, null);
	}
	
	protected HyAtomicExpression generateAtomicExpression(boolean includeVersions, boolean includeContexts, boolean includeAttributes, Date date) {
		// TODO consider values. right now only features considered properly
		// TODO versions!
		
		List<HyFeature> features = HyFeatureEvolutionUtil.getFeatures(featureModel, date);
		List<HyVersion> versions = null;
		List<HyFeatureAttribute> attributes = null;
		List<HyContextualInformation> contexts = null;
		
		int randMax = HyFeatureEvolutionUtil.getFeatures(featureModel, date).size();
		
//		if(includeVersions) {
//			versions = new ArrayList<HyVersion>();
//			
//			for(HyFeature feature: features) {
//				versions.addAll(HyFeatureEvolutionUtil.getVersionsOfFeature(feature, date));
//			}
//			
//			randMax += versions.size();
//		}
//		
//		if(includeAttributes) {
//			attributes = new ArrayList<HyFeatureAttribute>();
//			
//			for(HyFeature feature: features) {
//				attributes.addAll(HyFeatureEvolutionUtil.getAttributes(feature, date));
//			}
//			
//			randMax += attributes.size();
//		}
//		
//		if(includeContexts) {
//			contexts = new ArrayList<HyContextualInformation>();
//			
//			contexts.addAll(ContextEvolutionUtil.getContextualInformation(contextModel, date));
//			
//			randMax += contexts.size();
//		}
		
		int index = rand.nextInt(randMax);
		
		HyFeature referencedFeature = features.get(index);
		
		HyFeatureReferenceExpression featureReferenceExpression = factory.createHyFeatureReferenceExpression();
		featureReferenceExpression.setFeature(referencedFeature);
		
		return featureReferenceExpression;
	}
	
	protected HyUnaryExpression generateUnaryExpression(int numberOfLiterals, boolean includeVersions, boolean includeContexts, boolean includeAttributes, Date date, boolean nestedAllowed) {
		HyUnaryExpression unaryExpression = null;
		
		// TODO negation, maximum, minimum still missing
		
		if(!nestedAllowed || rand.nextBoolean()) {
			unaryExpression = factory.createHyNotExpression();
		} else {
			unaryExpression = factory.createHyNestedExpression();
		}
		
		unaryExpression.setOperand(generateExpression(numberOfLiterals, includeVersions, includeContexts, includeAttributes, unaryExpression, date));
		
		return unaryExpression;
	}

	
	
}
