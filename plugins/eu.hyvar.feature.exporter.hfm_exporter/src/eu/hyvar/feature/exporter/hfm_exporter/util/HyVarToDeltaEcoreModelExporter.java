package eu.hyvar.feature.exporter.hfm_exporter.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.deltaecore.feature.DEFeature;
import org.deltaecore.feature.DEFeatureModel;
import org.deltaecore.feature.DEVersion;
import org.deltaecore.feature.configuration.DEConfiguration;
import org.deltaecore.feature.constraint.DEConstraintModel;
import org.deltaecore.feature.mapping.DEMappingModel;
import org.eclipse.emf.ecore.EObject;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.exporter.hfm_exporter.HFMConfigurationExporter;
import eu.hyvar.feature.exporter.hfm_exporter.HFMConstraintModelExporter;
import eu.hyvar.feature.exporter.hfm_exporter.HFMExporter;
import eu.hyvar.feature.exporter.hfm_exporter.HFMMappingExporter;
import eu.hyvar.feature.mapping.HyMappingModel;
import eu.hyvar.feature.util.HyFeatureModelWellFormednessException;

public class HyVarToDeltaEcoreModelExporter {

	public static List<EObject> translateModels(HyFeatureModel featureModel, HyConstraintModel constraintModel, HyConfiguration configuration, HyMappingModel mapping, Date date) throws HyFeatureModelWellFormednessException {
		if(featureModel == null) {
			return null;
		}
		
		List<EObject> deltaEcoreModels = new ArrayList<EObject>();
		
		HFMExporter hfmExporter = new HFMExporter();
		DEFeatureModel deFeatureModel = hfmExporter.exportFeatureModel(featureModel, date);
		Map<HyFeature, DEFeature> featureMapping = hfmExporter.getFeatureMapping();
		Map<HyVersion, DEVersion> versionMapping = hfmExporter.getVersionMapping();
		deltaEcoreModels.add(deFeatureModel);

		if(configuration != null) {
			HFMConfigurationExporter hfmConfigExporter = new HFMConfigurationExporter(featureMapping, versionMapping, featureModel, deFeatureModel);
			DEConfiguration deConfiguration = hfmConfigExporter.exportConfiguration(configuration, date);
			deltaEcoreModels.add(deConfiguration);
		}
		
		if(mapping != null) {
			HFMMappingExporter hfmMappingExporter = new HFMMappingExporter(featureMapping, versionMapping);
			DEMappingModel deMappingModel = hfmMappingExporter.exportMappingModel(mapping, date);			
			deltaEcoreModels.add(deMappingModel);
		}
		
		if(constraintModel != null) {
			HFMConstraintModelExporter constraintExporter = new HFMConstraintModelExporter(featureMapping, versionMapping);
			DEConstraintModel deConstraintModel = constraintExporter.exportConstraintModel(constraintModel, date);
			deltaEcoreModels.add(deConstraintModel);			
		}
		
		
		return deltaEcoreModels;
	}
	
}
