package de.darwinspl.feature.analyses;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.deltaecore.feature.DEFeature;
import org.deltaecore.feature.DEFeatureModel;
import org.deltaecore.feature.analysis.util.FeatureModelConverter;
import org.deltaecore.feature.constraint.DEConstraintModel;
import org.deltaecore.feature.expression.DEExpression;

import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.HyConfigurationElement;
import eu.hyvar.feature.configuration.HyFeatureDeselected;
import eu.hyvar.feature.configuration.HyFeatureSelected;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.exporter.hfm_exporter.HFMConstraintModelExporter;
import eu.hyvar.feature.exporter.hfm_exporter.HFMExporter;
import eu.hyvar.feature.exporter.hfm_exporter.HFMExpressionExporter;
import eu.hyvar.feature.expression.HyExpression;
import eu.hyvar.feature.expression.HyExpressionFactory;
import eu.hyvar.feature.expression.HyFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyNotExpression;
import eu.hyvar.feature.util.HyFeatureModelWellFormednessException;
import solver.constraints.Constraint;

public class DwSatisfiabilityChecker extends FeatureModelConverter{
	
//	private SatisfiabilityChecker satChecker;
	
	
	public DwSatisfiabilityChecker() {
//		satChecker = new SatisfiabilityChecker();
//		featureModelConverter = new FeatureModelConverter();
		
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
		
		return isExpressionSatisfiableWithFeatureModelConstraints(deFeatureModel, deConstraintModel, deExpressions, dePartialFeatureSelection);
	}
	
	public boolean isExpressionSatisfiable(HyFeatureModel featureModel, List<HyExpression> expressions, List<HyFeature> partialFeatureSelection, Date date) throws HyFeatureModelWellFormednessException {
		return isExpressionSatisfiableWithFeatureModelConstraints(featureModel, null, expressions, partialFeatureSelection, date);
	}
	
	/**
	 * Checks if the feature selection of a partial configuration makes it still possible to create a valid configuration using that partial configuration
	 * @param partialConfiguration
	 * @param constraintModel possibly null
	 * @param date
	 * @return
	 */
	public boolean isSatisfiable(HyConfiguration partialConfiguration, HyConstraintModel constraintModel, Date date) {
		HyFeatureModel featureModel = partialConfiguration.getFeatureModel();
		
//		DwSatisfiabilityChecker satChecker = new DwSatisfiabilityChecker();
		
		List<HyFeature> partialFeatureSelection = new ArrayList<HyFeature>();
		
		HyExpressionFactory expressionFactory = HyExpressionFactory.eINSTANCE;
		List<HyExpression> deselectedExpressions = new ArrayList<HyExpression>();
		
		for(HyConfigurationElement configEle: HyEvolutionUtil.getValidTemporalElements(partialConfiguration.getElements(), date) ) {
			if(configEle instanceof HyFeatureSelected) {
				partialFeatureSelection.add(((HyFeatureSelected) configEle).getSelectedFeature());
			}
			else if(configEle instanceof HyFeatureDeselected) {
				HyNotExpression notExpression = expressionFactory.createHyNotExpression();
				HyFeatureReferenceExpression featureReference = expressionFactory.createHyFeatureReferenceExpression();
				featureReference.setFeature(((HyFeatureDeselected) configEle).getSelectedFeature());
				notExpression.setOperand(featureReference);
				deselectedExpressions.add(notExpression);
			}
		}
		
		
		
		try {
			return isExpressionSatisfiableWithFeatureModelConstraints(featureModel, constraintModel, deselectedExpressions, partialFeatureSelection, date);
		} catch (HyFeatureModelWellFormednessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean isExpressionSatisfiableWithFeatureModelConstraints(DEFeatureModel featureModel, DEConstraintModel constraintModel, List<DEExpression> expressions, List<DEFeature> partialFeatureSelection) {
		if(featureModel == null) {
			return false;
		}
		
		createSolver();
		
		convertFeatureModel(featureModel, constraintModel, getSolver());
		
		encodeExpressionsAndFeatureSelection(expressions, partialFeatureSelection);
		
		return getSolver().findSolution();
	}
	
	public boolean isExpressionSatisfiable(DEFeatureModel featureModel, List<DEExpression> expressions, List<DEFeature> partialFeatureSelection) {
		if(featureModel == null) {
			return false;
		}
		
		createSolver();
		
		convertFeatureModel(featureModel);
		
		encodeExpressionsAndFeatureSelection(expressions, partialFeatureSelection);
		
		return getSolver().findSolution();
	}
	
	protected void encodeExpressionsAndFeatureSelection(List<DEExpression> expressions, List<DEFeature> partialFeatureSelection) {
		if(expressions != null) {
			for(DEExpression expression: expressions) {
				getSolver().post(expression(expression));
			}			
		}
		
		if(partialFeatureSelection != null) {
			for(DEFeature feature: partialFeatureSelection) {
				encodeFeatureSelection(feature);
			}
		}
	}

	
	protected void encodeFeatureSelection(DEFeature feature) {
		Constraint<?,?> constraint = getFeatureVariableEncoding().selected(feature);
		getSolver().post(constraint);
	}
	
}
