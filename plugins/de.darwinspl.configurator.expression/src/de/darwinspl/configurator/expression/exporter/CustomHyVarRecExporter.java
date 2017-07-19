package de.darwinspl.configurator.expression.exporter;

import java.util.Date;

import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.expression.util.HyExpressionStringExporter;
import eu.hyvar.feature.expression.util.HyExpressionStringExporter.BooleanRepresentationOption;
import eu.hyvar.feature.expression.util.HyExpressionStringExporter.FeatureSelectionRepresentationOption;
import eu.hyvar.feature.expression.util.HyExpressionStringExporter.VersionRepresentation;
import eu.hyvar.preferences.HyProfile;
import eu.hyvar.reconfigurator.input.exporter.HyVarRecExporter;

/**
 * 
 * Adds the use of the HyExpressionStringExporter class to support the AtomicFeatureExpression
 * 
 * @author Jeremias Wrensch
 *
 */
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

	/**
	 * exports the input into hyvarrec format
	 * @param featureModel
	 * @param constraintModel
	 * @param profile
	 * @param date
	 * @return
	 */
	public String export(HyFeatureModel featureModel, HyConstraintModel constraintModel,
			HyProfile profile, Date date) {
		return super.exportContextMappingModel(null, null, featureModel, constraintModel, null, profile,
				null, date);
	}


}
