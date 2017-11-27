package eu.hyvar.reconfigurator.input.exporter.example;

import java.util.Date;

import eu.hyvar.reconfigurator.input.exporter.HyVarRecExporter;

//import eu.hyvar.context.reconfigurator_example;

public class TestVamosExample {

	public static void main(String[] args) {
		VamosExample vamosExample = new VamosExample();
		
		HyVarRecExporter jsonExporter = new HyVarRecExporter();
		jsonExporter.exportSPL(vamosExample.getContextModel(), vamosExample.getContextValidityModel(), vamosExample.getFeatureModel(), vamosExample.getConstraintModel(), vamosExample.getOldConfiguration(), null, null, new Date(), null);
	}

}
