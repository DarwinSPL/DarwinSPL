package de.darwinspl.feature.analyses;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.deltaecore.feature.DEFeature;
import org.deltaecore.feature.DEFeatureModel;
import org.deltaecore.feature.analysis.util.SatisfiabilityChecker;
import org.deltaecore.feature.constraint.DEConstraintModel;
import org.deltaecore.feature.expression.DEExpression;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.exporter.hfm_exporter.HFMConstraintModelExporter;
import eu.hyvar.feature.exporter.hfm_exporter.HFMExporter;
import eu.hyvar.feature.exporter.hfm_exporter.HFMExpressionExporter;
import eu.hyvar.feature.expression.HyExpression;
import eu.hyvar.feature.util.HyFeatureModelWellFormednessException;

public class DwSatisfiabilityChecker {
	
	private SatisfiabilityChecker satChecker;
	
	public DwSatisfiabilityChecker() {
		satChecker = new SatisfiabilityChecker();
	}

	public boolean isExpressionSatisfiableWithFeatureModelConstraints(HyFeatureModel featureModel, HyConstraintModel constraintModel, List<HyExpression> expressions, List<HyFeature> partialFeatureSelection, Date date) throws HyFeatureModelWellFormednessException {
		
		if(featureModel == null) {
			return false;
		}
		
		HFMExporter fmExporter = new HFMExporter();
		DEFeatureModel deFeatureModel = fmExporter.exportFeatureModel(featureModel, date);
		
		DEConstraintModel deConstraintModel = null;
		
		if(constraintModel != null) {
			HFMConstraintModelExporter constraintModelExporter = new HFMConstraintModelExporter(fmExporter.getFeatureMapping(), fmExporter.getVersionMapping());
			deConstraintModel = constraintModelExporter.exportConstraintModel(constraintModel, date);			
		}
		
		
		List<DEExpression> deExpressions = new ArrayList<DEExpression>();;
		if(expressions != null) {
			HFMExpressionExporter expressionExporter = new HFMExpressionExporter(fmExporter.getFeatureMapping(), fmExporter.getVersionMapping());
			for(HyExpression expression: expressions) {
				deExpressions.add(expressionExporter.exportExpression(expression));
			}			
		}
		
		List<DEFeature> dePartialFeatureSelection = new ArrayList<DEFeature>();
		
		if(partialFeatureSelection != null) {
			for(HyFeature feature: partialFeatureSelection) {
				dePartialFeatureSelection.add(fmExporter.getFeatureMapping().get(feature));
			}
		}
		
		return satChecker.isExpressionSatisfiableWithFeatureModelConstraints(deFeatureModel, deConstraintModel, deExpressions, dePartialFeatureSelection);
	}
	
	public boolean isExpressionSatisfiable(HyFeatureModel featureModel, List<HyExpression> expressions, List<HyFeature> partialFeatureSelection, Date date) throws HyFeatureModelWellFormednessException {
		return isExpressionSatisfiableWithFeatureModelConstraints(featureModel, null, expressions, partialFeatureSelection, date);
	}
	
}
