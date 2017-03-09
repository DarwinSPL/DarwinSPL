package de.darwinspl.mapping.generator;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.deltaecore.core.decore.DEDelta;

import de.darwinspl.expression.generator.DarwinExpressionGenerator;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.mapping.HyMapping;
import eu.hyvar.feature.mapping.HyMappingModel;
import eu.hyvar.feature.mapping.MappingFactory;

public class DarwinMappingGenerator {

	// TODO currently only application condition is generated
	
	protected HyFeatureModel featureModel;
	protected List<DEDelta> deltas;
	
	protected MappingFactory factory;
	
	private Random rand;
	
	protected DarwinExpressionGenerator expressionGenerator;
	
	/**
	 * 
	 * @param featureModel
	 * @param deltas may be empty or null
	 */
	public DarwinMappingGenerator(HyFeatureModel featureModel, HyConstraintModel constraintModel, List<DEDelta> deltas) {
		this.featureModel = featureModel;
		this.deltas = deltas;
		
		this.factory = MappingFactory.eINSTANCE;
		
		this.rand = new Random();
		
		expressionGenerator = new DarwinExpressionGenerator(featureModel, null, constraintModel);
	}
	
	public HyMapping generateMapping(int maximumAmountOfFeaturesInApplicationCondition, Date date) {
		HyMapping mapping = factory.createHyMapping();
		// TODO until?
		mapping.setValidSince(date);
		
		int amountOfFeaturesInApplicationCondition = rand.nextInt(maximumAmountOfFeaturesInApplicationCondition)+1;
		
		// TODO versions, attributes?
		mapping.setExpression(expressionGenerator.generateExpression(amountOfFeaturesInApplicationCondition, false, false, false, null, date));
		
		return mapping;
	}
	
	public HyMappingModel generateMappingModel(int amountOfMappings, int maximumAmountOfFeaturesInApplicationCondition, Date date) {
		HyMappingModel mappingModel = factory.createHyMappingModel();
		
		for(int i=0;i<amountOfMappings;i++) {
			mappingModel.getMappings().add(generateMapping(maximumAmountOfFeaturesInApplicationCondition, date));
		}
		
		return mappingModel;
	}
	
}
