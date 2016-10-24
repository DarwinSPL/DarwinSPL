package eu.hyvar.feature.exporter.hfm_exporter;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.deltaecore.feature.DEFeature;
import org.deltaecore.feature.DEVersion;
import org.deltaecore.feature.constraint.DEConstraint;
import org.deltaecore.feature.constraint.DEConstraintFactory;
import org.deltaecore.feature.constraint.DEConstraintModel;
import org.deltaecore.feature.expression.DEExpression;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.constraint.HyConstraint;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.constraint.util.exporter.HyConstraintModelExporter;

public class HFMConstraintModelExporter implements HyConstraintModelExporter<DEConstraintModel> {

	private Map<HyFeature, DEFeature> featureMapping;
	private Map<HyVersion, DEVersion> versionMapping;
	
	public HFMConstraintModelExporter(Map<HyFeature, DEFeature> featureMapping, Map<HyVersion, DEVersion> versionMapping) {
		this.featureMapping = featureMapping;
		this.versionMapping = versionMapping;
	}
	
	@Override
	public DEConstraintModel exportConstraintModel(HyConstraintModel constraintModel, Date date) {	
		HFMExpressionExporter expressionExporter = new HFMExpressionExporter(featureMapping, versionMapping);
		
		DEConstraintModel deConstraintModel = DEConstraintFactory.eINSTANCE.createDEConstraintModel();
		
		List<HyConstraint> validConstraints = HyEvolutionUtil.getValidTemporalElements(constraintModel.getConstraints(), date);
		
		for(HyConstraint constraint: validConstraints) {
			try {
				DEExpression rootExpression = expressionExporter.exportExpression(constraint.getRootExpression());
				
				DEConstraint deConstraint = DEConstraintFactory.eINSTANCE.createDEConstraint();
				deConstraint.setRootExpression(rootExpression);
				
				deConstraintModel.getConstraints().add(deConstraint);
			} catch (UnsupportedOperationException e) {
				e.printStackTrace();
				System.err.println("Could not translate the constraint: "+constraint+" as it contains elements not supported by DEConstraints");
			}
			
		}

		return deConstraintModel;
	}
	
	

}
