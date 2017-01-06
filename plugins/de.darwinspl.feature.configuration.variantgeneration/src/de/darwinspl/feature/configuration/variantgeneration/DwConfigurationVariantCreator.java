package de.darwinspl.feature.configuration.variantgeneration;

import java.util.Date;
import java.util.List;

import org.deltaecore.core.decore.util.DEDeltaRequirementsCycleException;
import org.deltaecore.feature.DEFeatureModel;
import org.deltaecore.feature.configuration.DEConfiguration;
import org.deltaecore.interpretation.requirements.DEDeltaAbstractDeltasInInputException;
import org.deltaecore.interpretation.variant.DEConfigurationVariantCreator;
import org.eclipse.core.resources.IFolder;
import org.eclipse.emf.ecore.resource.Resource;

import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.exporter.hfm_exporter.HFMConfigurationExporter;
import eu.hyvar.feature.exporter.hfm_exporter.HFMExporter;
import eu.hyvar.feature.util.HyFeatureModelWellFormednessException;

public class DwConfigurationVariantCreator extends DEConfigurationVariantCreator {

	public List<Resource> createVariantFromConfiguration(HyFeatureModel featureModel, HyConfiguration configuration, Date date) throws DEDeltaAbstractDeltasInInputException, DEDeltaRequirementsCycleException, HyFeatureModelWellFormednessException {
		FeatureModelConfigurationTuple deltaEcoreModels = exportToDeltaEcoreModels(featureModel, configuration, date);
		
		return super.createVariantFromConfiguration(deltaEcoreModels.getConfiguration());
	}

	public void createAndSaveVariantFromConfiguration(HyFeatureModel featureModel, HyConfiguration configuration, Date date,
			IFolder variantFolder) throws DEDeltaAbstractDeltasInInputException, DEDeltaRequirementsCycleException,
			HyFeatureModelWellFormednessException {

		FeatureModelConfigurationTuple deltaEcoreModels = exportToDeltaEcoreModels(featureModel, configuration, date);

		super.createAndSaveVariantFromConfiguration(deltaEcoreModels.getConfiguration(), variantFolder);
	}

	private FeatureModelConfigurationTuple exportToDeltaEcoreModels(HyFeatureModel featureModel,
			HyConfiguration configuration, Date date) throws HyFeatureModelWellFormednessException {
		FeatureModelConfigurationTuple tuple = new FeatureModelConfigurationTuple();

		HFMExporter exporter = new HFMExporter();

		DEFeatureModel deFeatureModel = exporter.exportFeatureModel(featureModel, date);

		HFMConfigurationExporter configurationExporter = new HFMConfigurationExporter(exporter.getFeatureMapping(),
				exporter.getVersionMapping(), featureModel, deFeatureModel);
		DEConfiguration deConfiguration = configurationExporter.exportConfiguration(configuration, date);

		tuple.setConfiguration(deConfiguration);
		tuple.setFeatureModel(deFeatureModel);

		return tuple;

	}

	private class FeatureModelConfigurationTuple {
		private DEFeatureModel featureModel;
		private DEConfiguration configuration;

		@SuppressWarnings("unused")
		public DEFeatureModel getFeatureModel() {
			return featureModel;
		}

		public void setFeatureModel(DEFeatureModel featureModel) {
			this.featureModel = featureModel;
		}

		public DEConfiguration getConfiguration() {
			return configuration;
		}

		public void setConfiguration(DEConfiguration configuration) {
			this.configuration = configuration;
		}
	}
}
