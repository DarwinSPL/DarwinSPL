package de.darwinspl.feature.configuration.variantgeneration;

import java.util.Date;
import java.util.List;

import org.deltaecore.core.decore.util.DEDeltaRequirementsCycleException;
import org.deltaecore.feature.DEFeatureModel;
import org.deltaecore.feature.configuration.DEConfiguration;
import org.deltaecore.feature.mapping.DEMappingModel;
import org.deltaecore.interpretation.requirements.DEDeltaAbstractDeltasInInputException;
import org.deltaecore.interpretation.variant.DEConfigurationVariantCreator;
import org.eclipse.core.resources.IFolder;
import org.eclipse.emf.ecore.resource.Resource;

import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.exporter.hfm_exporter.HFMConfigurationExporter;
import eu.hyvar.feature.exporter.hfm_exporter.HFMExporter;
import eu.hyvar.feature.exporter.hfm_exporter.HFMMappingExporter;
import eu.hyvar.feature.mapping.HyMappingModel;
import eu.hyvar.feature.util.HyFeatureModelWellFormednessException;

public class DwConfigurationVariantCreator extends DEConfigurationVariantCreator {

	public List<Resource> createVariantFromConfiguration(HyFeatureModel featureModel, HyConfiguration configuration,
			HyMappingModel mapping, Date date) throws DEDeltaAbstractDeltasInInputException,
			DEDeltaRequirementsCycleException, HyFeatureModelWellFormednessException {

		try {
			FeatureModelConfigurationMappingTriple deltaEcoreModels = exportToDeltaEcoreModels(featureModel,
					configuration, mapping, date);

			List<Resource> resourceList = super.createVariantFromConfiguration(deltaEcoreModels.getConfiguration(),
					deltaEcoreModels.getMapping());

			// deleteModels(deltaEcoreModels);

			return resourceList;
		} catch (HyFeatureModelWellFormednessException e) {
			throw e;
		}
	}

	public void createAndSaveVariantFromConfiguration(HyFeatureModel featureModel, HyConfiguration configuration,
			HyMappingModel mapping, Date date, IFolder variantFolder) throws DEDeltaAbstractDeltasInInputException,
			DEDeltaRequirementsCycleException, HyFeatureModelWellFormednessException {

		try {
			FeatureModelConfigurationMappingTriple deltaEcoreModels = exportToDeltaEcoreModels(featureModel,
					configuration, mapping, date);
			super.createAndSaveVariantFromConfiguration(deltaEcoreModels.getConfiguration(),
					deltaEcoreModels.getMapping(), variantFolder);
		} catch (HyFeatureModelWellFormednessException e) {
			throw e;
		}

		// deleteModels(deltaEcoreModels);
	}

	private FeatureModelConfigurationMappingTriple exportToDeltaEcoreModels(HyFeatureModel featureModel,
			HyConfiguration configuration, HyMappingModel mapping, Date date)
			throws HyFeatureModelWellFormednessException {
		FeatureModelConfigurationMappingTriple triple = new FeatureModelConfigurationMappingTriple();

		HFMExporter exporter = new HFMExporter();

		DEFeatureModel deFeatureModel = exporter.exportFeatureModel(featureModel, date);

		HFMConfigurationExporter configurationExporter = new HFMConfigurationExporter(exporter.getFeatureMapping(),
				exporter.getVersionMapping(), featureModel, deFeatureModel);
		DEConfiguration deConfiguration = configurationExporter.exportConfiguration(configuration, date);

		HFMMappingExporter mappingExporter = new HFMMappingExporter(exporter.getFeatureMapping(),
				exporter.getVersionMapping());
		DEMappingModel deMapping = mappingExporter.exportMappingModel(mapping, date);

		triple.setConfiguration(deConfiguration);
		triple.setFeatureModel(deFeatureModel);
		triple.setMapping(deMapping);

		return triple;
		// return saveModelsAndLoadThemAgain(triple, featureModel);
	}

//	private FeatureModelConfigurationMappingTriple saveModelsAndLoadThemAgain(
//			FeatureModelConfigurationMappingTriple triple, HyFeatureModel featureModelInSameFolder) {
//		IFile featureModelFile = EcoreIOUtil.getFile(featureModelInSameFolder);
//
//		IFile deFeatureModelFile = ResourceUtil.getFileInSameContainer(featureModelFile,
//				ResourceUtil.getBaseFilename(featureModelFile) + "." + DEFeatureIOUtil.FILE_EXTENSIONS[0]);
//		IFile deConfigurationFile = ResourceUtil.getFileInSameContainer(featureModelFile,
//				ResourceUtil.getBaseFilename(featureModelFile) + "." + DEConfigurationIOUtil.FILE_EXTENSIONS[0]);
//		IFile deMappingFile = ResourceUtil.getFileInSameContainer(featureModelFile,
//				ResourceUtil.getBaseFilename(featureModelFile) + "." + DEMappingIOUtil.FILE_EXTENSIONS[0]);
//
//		EcoreIOUtil.saveModelAs(triple.getFeatureModel(), deFeatureModelFile);
//		EcoreIOUtil.saveModelAs(triple.getConfiguration(), deConfigurationFile);
//		EcoreIOUtil.saveModelAs(triple.getMapping(), deMappingFile);
//
//		List<IFile> fileListToLoad = new ArrayList<IFile>();
//		fileListToLoad.add(deFeatureModelFile);
//		fileListToLoad.add(deConfigurationFile);
//		fileListToLoad.add(deMappingFile);
//
//		List<EObject> loadedModels = EcoreIOUtil.loadModels(fileListToLoad);
//
//		FeatureModelConfigurationMappingTriple newTriple = new FeatureModelConfigurationMappingTriple();
//
//		for (EObject object : loadedModels) {
//			if (object instanceof DEFeatureModel) {
//				newTriple.setFeatureModel((DEFeatureModel) object);
//			} else if (object instanceof DEConfiguration) {
//				newTriple.setConfiguration((DEConfiguration) object);
//			} else if (object instanceof DEMappingModel) {
//				newTriple.setMapping((DEMappingModel) object);
//			}
//		}
//
//		return newTriple;
//	}
//
//	private void deleteModels(FeatureModelConfigurationMappingTriple triple) {
//		IProgressMonitor progressMonitor = new NullProgressMonitor();
//		try {
//			EcoreIOUtil.getFile(triple.getFeatureModel()).delete(IResource.FORCE, progressMonitor);
//			EcoreIOUtil.getFile(triple.getConfiguration()).delete(IResource.FORCE, progressMonitor);
//			EcoreIOUtil.getFile(triple.getMapping()).delete(IResource.FORCE, progressMonitor);
//		} catch (CoreException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	private class FeatureModelConfigurationMappingTriple {
		private DEFeatureModel featureModel;
		private DEConfiguration configuration;
		private DEMappingModel mapping;

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

		public DEMappingModel getMapping() {
			return mapping;
		}

		public void setMapping(DEMappingModel mapping) {
			this.mapping = mapping;
		}

	}
}
