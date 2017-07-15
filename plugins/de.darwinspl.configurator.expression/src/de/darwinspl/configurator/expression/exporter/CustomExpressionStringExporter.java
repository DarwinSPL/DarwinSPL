package de.darwinspl.configurator.expression.exporter;

import java.util.Map;

import de.darwinspl.configurator.expression.AtomicFeatureExpression;
import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.expression.HyAtomicExpression;
import eu.hyvar.feature.expression.util.HyExpressionStringExporter;

/**
 * 
 * Adds Handling of the AtomFeatureExpression
 * 
 * @author Jeremias Wrensch
 *
 */
public class CustomExpressionStringExporter extends HyExpressionStringExporter{

	public CustomExpressionStringExporter(Map<HyFeature, String> featureIdMapping, Map<HyVersion, String> versionIdMapping,
			Map<HyFeatureAttribute, String> attributeIdMapping, Map<HyContextualInformation, String> contextIdMapping,
			BooleanRepresentationOption booleanRepresentationOption,
			FeatureSelectionRepresentationOption featureSelectionRepresentationOption,
			VersionRepresentation versionRepresentation, boolean resolveSetExpression, boolean enumsAsIntValues) {
		super(featureIdMapping, versionIdMapping, attributeIdMapping, contextIdMapping, booleanRepresentationOption,
				featureSelectionRepresentationOption, versionRepresentation, resolveSetExpression, enumsAsIntValues);
	}

	@Override
	protected String handleAtomicExpression(HyAtomicExpression atomicExpression, boolean negated) {
		if(atomicExpression instanceof AtomicFeatureExpression) {
			return featureIdMapping.get(((AtomicFeatureExpression) atomicExpression).getFeature());
		} else {
			return super.handleAtomicExpression(atomicExpression, negated);
		}
	}
	
}
