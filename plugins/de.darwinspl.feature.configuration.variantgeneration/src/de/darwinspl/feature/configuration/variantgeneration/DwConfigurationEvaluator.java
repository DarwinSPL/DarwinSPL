package de.darwinspl.feature.configuration.variantgeneration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.deltaecore.core.decore.DEDelta;
import org.deltaecore.core.decore.DEDeltaInvokation;

import de.darwinspl.solver.DwSolver;
import de.darwinspl.solver.exception.DwAttributeValueOfSelectedFeatureNotSetException;
import eu.hyvar.context.HyContextModel;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.mapping.HyMapping;
import eu.hyvar.feature.mapping.HyMappingModel;

public class DwConfigurationEvaluator {

	public static List<DEDelta> evaluateConfiguration(HyFeatureModel featureModel, HyContextModel contextModel, HyMappingModel mappingModel, HyConfiguration configuration, Date date, DwSolver solver) throws DwAttributeValueOfSelectedFeatureNotSetException {
		
		List<DEDelta> deltas = new ArrayList<DEDelta>();
		
		if(solver == null) {
			solver = new DwSolver(featureModel, contextModel, date);			
		}
		
		for(HyMapping mapping: mappingModel.getMappings()) {
			if(!HyEvolutionUtil.isValid(mapping, date)) {
				continue;
			}
			
			if(solver.isExpressionSatisfiedWithoutFeatureModelConstraints(mapping.getExpression(), configuration)) {
				for(DEDeltaInvokation deltaInvokation: mapping.getDeltaInvokations()) {
					deltas.add(deltaInvokation.getDelta());
				}
			}
		}
		
		return deltas;
	}
	
}