package de.darwinspl.variant_generation;

import java.util.Date;
import java.util.List;

import org.deltaecore.core.decore.DEDelta;
import org.deltaecore.core.decore.util.DEDeltaRequirementsCycleException;
import org.deltaecore.core.variant.DEVariantCreator;
import org.eclipse.core.resources.IFolder;
import org.eclipse.emf.ecore.resource.Resource;

import de.darwinspl.feature.configuration.variantgeneration.DwConfigurationEvaluator;
import de.darwinspl.solver.DwSolver;
import de.darwinspl.solver.exception.DwAttributeValueOfSelectedFeatureNotSetException;
import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.information.contextValue.HyContextValueModel;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.mapping.HyMappingModel;

public class DwConfigurationVariantCreator {

	private DEVariantCreator deltaVariantCreator;
	
	public DwConfigurationVariantCreator() {
		deltaVariantCreator = new DEVariantCreator();
	}
	
	/**
	 * 
	 * @param featureModel
	 * @param contextModel
	 * @param configuration
	 * @param mapping
	 * @param date
	 * @param solver May be null. Then, a new solver is created.
	 * @return
	 * @throws DwAttributeValueOfSelectedFeatureNotSetException
	 * @throws DEDeltaRequirementsCycleException
	 */
	public List<Resource> createVariantFromConfiguration(HyFeatureModel featureModel, HyContextModel contextModel, HyConfiguration configuration, HyContextValueModel contextValueModel,
			HyMappingModel mapping, Date date, DwSolver solver) throws DwAttributeValueOfSelectedFeatureNotSetException, DEDeltaRequirementsCycleException {
		
		List<DEDelta> deltasList = DwConfigurationEvaluator.evaluateConfiguration(featureModel, contextModel, mapping, configuration, contextValueModel, date, solver);
		
		List<Resource> resourceList = deltaVariantCreator.createVariantFromDeltas(deltasList);

		return resourceList;
		
	}

	/**
	 * 
	 * @param featureModel
	 * @param contextModel
	 * @param configuration
	 * @param mapping
	 * @param date
	 * @param variantFolder
	 * @param solver May be null. Then, a new solver is created.
	 * @throws DwAttributeValueOfSelectedFeatureNotSetException
	 * @throws DEDeltaRequirementsCycleException
	 */
	public void createAndSaveVariantFromConfiguration(HyFeatureModel featureModel, HyContextModel contextModel, HyConfiguration configuration, HyContextValueModel contextValueModel,
			HyMappingModel mapping, Date date, IFolder variantFolder, DwSolver solver) throws DwAttributeValueOfSelectedFeatureNotSetException, DEDeltaRequirementsCycleException  {

		List<DEDelta> deltasList = DwConfigurationEvaluator.evaluateConfiguration(featureModel, contextModel, mapping, configuration, contextValueModel, date, solver);
		
		deltaVariantCreator.createAndSaveVariantFromDeltas(deltasList, variantFolder);
	}
}
