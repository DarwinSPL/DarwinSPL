package eu.hyvar.feature.exporter.hfm_exporter;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.deltaecore.feature.DEFeature;
import org.deltaecore.feature.DEVersion;
import org.deltaecore.suite.mapping.DEMapping;
import org.deltaecore.suite.mapping.DEMappingFactory;
import org.deltaecore.suite.mapping.DEMappingModel;
import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.mapping.HyMapping;
import eu.hyvar.feature.mapping.HyMappingModel;
import eu.hyvar.feature.mapping.util.HyMappingExporter;

public class HFMMappingExporter implements HyMappingExporter<DEMappingModel>{


	private Map<HyFeature, DEFeature> featureMapping;
	private Map<HyVersion, DEVersion> versionMapping;
	
	public HFMMappingExporter(Map<HyFeature, DEFeature> featureMapping, Map<HyVersion, DEVersion> versionMapping) {
		this.featureMapping = featureMapping;
		this.versionMapping = versionMapping;
	}

	@Override
	public DEMappingModel exportMappingModel(HyMappingModel mappingModel, Date date) {
		HFMExpressionExporter expressionExporter = new HFMExpressionExporter(featureMapping, versionMapping);
		
		DEMappingModel deMappingModel = DEMappingFactory.eINSTANCE.createDEMappingModel();
		
		List<HyMapping> validMappings = HyEvolutionUtil.getValidTemporalElements(mappingModel.getMappings(), date);
		
		for(HyMapping mapping: validMappings) {
			DEMapping deMapping = DEMappingFactory.eINSTANCE.createDEMapping();
			try {
				deMapping.setExpression(expressionExporter.exportExpression(mapping.getExpression()));
				deMapping.getDeltaInvokations().addAll(EcoreUtil.copyAll(mapping.getDeltaInvokations()));
			}
			catch(UnsupportedOperationException e) {
				System.err.println("Could not translate expression of mapping!");
				e.printStackTrace();
			}
			deMappingModel.getMappings().add(deMapping);
		}
		
		return deMappingModel;
	}
}
