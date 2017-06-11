package de.darwinspl.configurator.expression.exporter;

import java.util.Map;

import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.expression.util.HyExpressionStringExporter;
import eu.hyvar.feature.expression.util.HyExpressionStringExporter.BooleanRepresentationOption;
import eu.hyvar.feature.expression.util.HyExpressionStringExporter.FeatureSelectionRepresentationOption;
import eu.hyvar.feature.expression.util.HyExpressionStringExporter.VersionRepresentation;
import eu.hyvar.reconfigurator.input.exporter.HyVarRecExporter;

public class CustomHyVarRecExpressionExporter extends HyVarRecExporter {

	public CustomHyVarRecExpressionExporter() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected HyExpressionStringExporter createHyExpressionStringExporter(Map<HyFeature, String> featureIdMapping,
			Map<HyVersion, String> versionIdMapping, Map<HyFeatureAttribute, String> attributeIdMapping,
			Map<HyContextualInformation, String> contextIdMapping,
			BooleanRepresentationOption booleanRepresentationOption,
			FeatureSelectionRepresentationOption featureSelectionRepresentationOption,
			VersionRepresentation versionRepresentation, boolean resolveSetExpression, boolean enumsAsIntValues) {
		// TODO Auto-generated method stub
		return new ExpressionStringExporter(featureIdMapping, versionIdMapping, attributeIdMapping, contextIdMapping, booleanRepresentationOption, featureSelectionRepresentationOption, versionRepresentation, resolveSetExpression, enumsAsIntValues);
	}

	
	
}
