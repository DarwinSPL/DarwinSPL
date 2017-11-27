package de.darwinspl.feature.configuration.variantgeneration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.deltaecore.core.decore.DEDelta;
import org.deltaecore.core.decore.DEDeltaInvokation;

import de.darwinspl.solver.DwSolver;
import de.darwinspl.solver.exception.DwAttributeValueOfSelectedFeatureNotSetException;
import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.information.contextValue.HyContextValueModel;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.mapping.HyMapping;
import eu.hyvar.feature.mapping.HyMappingModel;

public class DwConfigurationEvaluator {

	public static List<DEDelta> evaluateConfiguration(HyFeatureModel featureModel, HyContextModel contextModel, HyMappingModel mappingModel, HyConfiguration configuration, HyContextValueModel contextValueModel, Date date, DwSolver solver) throws DwAttributeValueOfSelectedFeatureNotSetException {
		List<DEDelta> deltas = new ArrayList<DEDelta>();
		List<DEDeltaInvokation> deltaInvocations = evaluateConfigurationToDeltaInvocations(featureModel, contextModel, mappingModel, configuration, contextValueModel, date, solver);
		
		if(deltaInvocations != null) {
			for(DEDeltaInvokation deltaInvocation: deltaInvocations) {
				deltas.add(deltaInvocation.getDelta());
			}
		}
		
		return deltas;
	}
	
	public static List<DEDeltaInvokation> evaluateConfigurationToDeltaInvocations(HyFeatureModel featureModel, HyContextModel contextModel, HyMappingModel mappingModel, HyConfiguration configuration, HyContextValueModel contextValueModel, Date date, DwSolver solver) throws DwAttributeValueOfSelectedFeatureNotSetException {
		List<DEDeltaInvokation> deltaInvocations = new ArrayList<DEDeltaInvokation>();
		
		if(solver == null) {
			solver = new DwSolver(featureModel, contextModel, date);			
		}
		
		for(HyMapping mapping: mappingModel.getMappings()) {
			if(!HyEvolutionUtil.isValid(mapping, date)) {
				continue;
			}
			
			if(solver.isExpressionSatisfiedWithoutFeatureModelConstraints(mapping.getExpression(), configuration, contextValueModel)) {
				for(DEDeltaInvokation deltaInvokation: mapping.getDeltaInvokations()) {
					deltaInvocations.add(deltaInvokation);
				}
			}
		}
		
		return deltaInvocations;
	}
	
}
