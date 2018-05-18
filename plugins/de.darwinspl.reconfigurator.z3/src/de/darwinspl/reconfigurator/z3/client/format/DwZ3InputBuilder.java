package de.darwinspl.reconfigurator.z3.client.format;

import de.darwinspl.preferences.DwProfile;
import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.contextValidity.HyValidityModel;
import eu.hyvar.context.information.contextValue.HyContextValueModel;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.reconfigurator.input.exporter.HyVarRecExporter;
import eu.hyvar.reconfigurator.input.format.InputForHyVarRec;
import java.util.Date;
import java.util.List;

public class DwZ3InputBuilder {
	
	
private HyVarRecExporter exporter;
	
	
	public InputForHyVarRec createInputForHyVarRec(HyContextModel contextModels, HyValidityModel contextValidityModels,
			HyFeatureModel featureModels, HyConstraintModel constraintModels, HyConfiguration oldConfiguration, HyConfiguration partialConfiguration,
			DwProfile profileModels, HyContextValueModel contextValues, Date date, Date evolutionContextValueDate) {
		
		
		HyVarRecExporter exporter = new HyVarRecExporter();
		
		 InputForHyVarRec input = exporter.createInputForHyVarRec(contextModels, contextValidityModels, featureModels, constraintModels, oldConfiguration, partialConfiguration, profileModels, contextValues, date, evolutionContextValueDate);
		
		return input;
		
	}

}
