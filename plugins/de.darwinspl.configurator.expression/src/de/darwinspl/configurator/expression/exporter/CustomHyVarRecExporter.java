package de.darwinspl.configurator.expression.exporter;

import eu.hyvar.feature.expression.util.HyExpressionStringExporter;
import eu.hyvar.feature.expression.util.HyExpressionStringExporter.BooleanRepresentationOption;
import eu.hyvar.feature.expression.util.HyExpressionStringExporter.FeatureSelectionRepresentationOption;
import eu.hyvar.feature.expression.util.HyExpressionStringExporter.VersionRepresentation;
import eu.hyvar.reconfigurator.input.exporter.HyVarRecExporter;

public class CustomHyVarRecExporter extends HyVarRecExporter {

	public CustomHyVarRecExporter() {
	}
	
	@Override
	protected HyExpressionStringExporter getHyExpressionStringExporter() {
		return new CustomExpressionStringExporter(reconfiguratorIdMapping.getFeatureIdMapping(),
					reconfiguratorIdMapping.getVersionIdMapping(), reconfiguratorIdMapping.getAttributeIdMapping(),
					reconfiguratorIdMapping.getContextIdMapping(), BooleanRepresentationOption.ONEZERO,
					FeatureSelectionRepresentationOption.ONEZERO, VersionRepresentation.AS_ONEZERO_FEATURES, true, true);
		}

	
	
}
