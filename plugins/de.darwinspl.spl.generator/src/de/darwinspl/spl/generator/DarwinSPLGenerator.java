package de.darwinspl.spl.generator;

import java.io.File;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import org.deltaecore.feature.DEFeatureModel;
import org.deltaecore.feature.generator.DEFeatureModelGenerator;

import de.christophseidl.util.eclipse.ResourceUtil;
import de.christophseidl.util.ecore.EcoreIOUtil;
import de.darwinspl.configuration.generator.DarwinConfigurationGenerator;
import de.darwinspl.feature.evolution.generator.FeatureModelEvolutionGenerator;
import de.darwinspl.importer.deltaecore.DeltaEcoreFeatureModelImporter;
import de.darwinspl.mapping.generator.DarwinMappingGenerator;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.mapping.HyMappingModel;

public class DarwinSPLGenerator {

	// TODO constraints?!
	
	
	
	public ArtifactWrapper generateWithEvolution(Map<Date, Integer> evolutionStepsPerDate) {
		ArtifactWrapper wrapper = generateWithoutEvolution();
		FeatureModelEvolutionGenerator evoGenerator = new FeatureModelEvolutionGenerator();
		
		for(Entry<Date, Integer> entry: evolutionStepsPerDate.entrySet()) {
			wrapper.getEvoOps().putAll(evoGenerator.generateEvolutionOfFeatureModel(wrapper.getFeatureModel(), entry.getValue(), entry.getKey()));			
		}
		
		return wrapper;
	}
	
	public ArtifactWrapper generateWithoutEvolution() {
		ArtifactWrapper wrapper = new ArtifactWrapper();
		
		DEFeatureModelGenerator fmGenerator = new DEFeatureModelGenerator();
		DEFeatureModel generatedDEFM = fmGenerator.generateFeatureModel();
		
		DeltaEcoreFeatureModelImporter deltaEcoreImporter = new DeltaEcoreFeatureModelImporter();
		HyFeatureModel generatedFeatureModel = deltaEcoreImporter.importFeatureModel(generatedDEFM);
		wrapper.setFeatureModel(generatedFeatureModel);
		
		
		DarwinConfigurationGenerator configurationGenerator = new DarwinConfigurationGenerator();
		int configurationCount = 20;
		for(int i=0;i<configurationCount;i++) {
			wrapper.getConfigurations().add(configurationGenerator.generateConfiguration(generatedFeatureModel, null, null));
		}
		
		DarwinMappingGenerator mappingGenerator = new DarwinMappingGenerator(generatedFeatureModel, null, null);
		
		// TODO sensible amount of mappings?
		// for each feature one mapping
		int sensibleAmountOfMappings = generatedFeatureModel.getFeatures().size();
		// for half of the features glue code
		sensibleAmountOfMappings += generatedFeatureModel.getFeatures().size() / 2;
		
		sensibleAmountOfMappings = 2;
		
		// TODO sensible amount of features per application condition?
		int sensibleAmountOfFeaturesInApplicationConditions = Math.min(3, generatedFeatureModel.getFeatures().size());
		
		HyMappingModel mappingModel = mappingGenerator.generateMappingModel(sensibleAmountOfMappings, sensibleAmountOfFeaturesInApplicationConditions, null);
		wrapper.setMappingModel(mappingModel);
		
		File folder = new File("D:\\workspaces\\HyVarRuntimeRuntime\\Vamos17\\generated\\");
		
		EcoreIOUtil.saveModelAs(generatedFeatureModel, ResourceUtil.fileToFile(new File(folder, "FeatureModel.hyfeaturemodel")));
		EcoreIOUtil.saveModelAs(mappingModel, ResourceUtil.fileToFile(new File(folder, "FeatureModel.hymapping")));
		
		return wrapper;
	}
	
}
