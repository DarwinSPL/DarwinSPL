package eu.hyvar.reconfigurator.input.exporter.example;

import java.util.Date;

import eu.hyvar.reconfigurator.input.exporter.ContextConstraintExporterJson;
import eu.hyvar.reconfigurator.input.exporter.example.IsolaExample.ProfileEnum;

public class TestIsolaExample {
	
	public static void main(String[] args) {
		
		// load existing model
		
		// create new Model:		
		IsolaExample isolaExample = new IsolaExample(ProfileEnum.ECO);
		
		ContextConstraintExporterJson jsonExporter = new ContextConstraintExporterJson();
		jsonExporter.exportContextMappingModel(isolaExample.getContextModel(), isolaExample.getContextValidityModel(), isolaExample.getFeatureModel(), isolaExample.getConstraintModel(), isolaExample.getOldConfiguration(), isolaExample.getPreferenceModel(), null, new Date());
	}
	
	public static void save(IsolaExample isolaExample) {
		
	}
	
}
