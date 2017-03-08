package de.darwinspl.expression.generator;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.deltaecore.feature.DEFeatureModel;

import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.exporter.hfm_exporter.HFMExporter;
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
	protected HyContextModel contextModel;
	protected HyExpressionFactory factory;
	
	protected DEFeatureModel deltaEcoreFeatureModel;
	protected HFMExporter deltaEcoreExporter;
	
	
	private Random rand;
	
	public DarwinExpressionGenerator(HyFeatureModel featureModel, HyContextModel contextModel) {		
		this.featureModel = featureModel;
		this.contextModel = contextModel;
		this.factory = HyExpressionFactory.eINSTANCE;
		
		
		
		rand = new Random();
	}
	
	// TODO include versions, attributes and contexts
	// TODO set expressions
	// TODO equals with values and so on
	
	public HyExpression generateExpression(int numberOfLiterals, boolean includeVersions, boolean includeContexts, boolean includeAttributes, Date date) {
		
		boolean exported = false;
		
		if(deltaEcoreFeatureModel == null) {
			exported = true;
			
			deltaEcoreExporter = new HFMExporter();
			try {
				deltaEcoreFeatureModel = deltaEcoreExporter.exportFeatureModel(featureModel, date);
			} catch (HyFeatureModelWellFormednessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		HyExpression expression = null;
		
		// TODO Will go bad if not types of according atomic expressions are not checked! Only interesting if nOL <= 3?
		
		if(numberOfLiterals >= 2) {
			HyBinaryExpression binaryExpression = null;
			
			int binaryIndex = rand.nextInt(5);
			switch(binaryIndex) {
			case 0:
				binaryExpression = factory.createHyAndExpression();
				break;
			case 1:
				binaryExpression = factory.createHyOrExpression();
				break;
			case 2:
				binaryExpression = factory.createHyEquivalenceExpression();
				break;
			case 3:
				binaryExpression = factory.createHyImpliesExpression();
				break;
			case 4:
				expression = generateUnaryExpression(numberOfLiterals, includeVersions, includeContexts, includeAttributes, date, false);
				break;
			}
			
			if(binaryExpression != null) {
				
				int leftHandLiteralNumber = (new Double(Math.ceil(numberOfLiterals / 2.0))).intValue();
				int rightHandLiteralNumber = (new Double(Math.floor(numberOfLiterals / 2.0))).intValue();
				
				// TODO this might take a VERY long time for bigger expressions
				while(!checkSatisfiability(binaryExpression)) {
					binaryExpression.setOperand1(generateExpression(leftHandLiteralNumber, includeVersions, includeContexts, includeAttributes, date));			
					binaryExpression.setOperand2(generateExpression(rightHandLiteralNumber, includeVersions, includeContexts, includeAttributes, date));					
				}
				
				expression = binaryExpression;
			}
			
			
		}
		
		else if(numberOfLiterals >= 1) {
			// TODO too probable to create unary instead of atomic?!
			if(rand.nextBoolean()) {
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
		// TODO
		// FIXME
		return true;
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
		
		unaryExpression.setOperand(generateExpression(numberOfLiterals, includeVersions, includeContexts, includeAttributes, date));
		
		return unaryExpression;
	}

	
	
}
