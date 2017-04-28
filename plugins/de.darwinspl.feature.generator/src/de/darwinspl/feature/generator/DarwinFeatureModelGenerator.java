package de.darwinspl.feature.generator;

import java.util.Map;

import org.deltaecore.feature.DEFeatureModel;

import de.darwinspl.feature.generator.DEFeatureModelGeneratorConfigurable.OptionsEnum;
import de.darwinspl.importer.deltaecore.DeltaEcoreFeatureModelImporter;
import eu.hyvar.feature.HyFeatureModel;

public class DarwinFeatureModelGenerator {

	
	public HyFeatureModel generateFeatureModel() {
		DEFeatureModelGeneratorConfigurable fmGenerator = new DEFeatureModelGeneratorConfigurable();
		DEFeatureModel generatedDEFM = fmGenerator.generateFeatureModel();
		
		DeltaEcoreFeatureModelImporter deltaEcoreImporter = new DeltaEcoreFeatureModelImporter();
		HyFeatureModel generatedFeatureModel = deltaEcoreImporter.importFeatureModel(generatedDEFM);
		
		return generatedFeatureModel;
	}
	
	public HyFeatureModel generateFeatureModel(Map<OptionsEnum, Double> optionsMap) {
		DEFeatureModelGeneratorConfigurable fmGenerator = new DEFeatureModelGeneratorConfigurable();
		DEFeatureModel generatedDEFM = fmGenerator.generateFeatureModel(optionsMap);
		
		DeltaEcoreFeatureModelImporter deltaEcoreImporter = new DeltaEcoreFeatureModelImporter();
		HyFeatureModel generatedFeatureModel = deltaEcoreImporter.importFeatureModel(generatedDEFM);
		
		return generatedFeatureModel;
	}
	
}
