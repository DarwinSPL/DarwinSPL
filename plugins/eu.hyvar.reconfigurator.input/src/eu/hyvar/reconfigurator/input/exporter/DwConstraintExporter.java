package eu.hyvar.reconfigurator.input.exporter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import eu.hyvar.feature.constraint.HyConstraint;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.expression.util.HyExpressionStringExporter;
import eu.hyvar.reconfigurator.input.format.Context;

public class DwConstraintExporter {

	private HyExpressionStringExporter expressionExporter;
	
	private Map<String, EObject> translationMapping;
	
	public DwConstraintExporter(HyExpressionStringExporter expressionExporter, Map<String, EObject> translationMapping) {
		this.expressionExporter = expressionExporter;
		
		this.translationMapping = translationMapping;
	}
	
	public List<String> getConstraints(HyConstraintModel constraintModel, Date date, Context dateContext, List<Date> sortedDateList) {
		List<String> constraints = new ArrayList<String>();

		if(constraintModel == null || constraintModel.getConstraints() == null) {
			return constraints;
		}
		
		for (HyConstraint constraint : constraintModel.getConstraints()) {
			
			String exportedConstraint = getConstraint(constraint, date, dateContext, sortedDateList);
			
			if(exportedConstraint != null) {
				constraints.add(exportedConstraint);
				
				translationMapping.put(exportedConstraint, constraint);
			}
			
		}

		return constraints;
	}

	private String getConstraint(HyConstraint constraint, Date date, Context dateContext, List<Date> sortedDateList) {
		return HyVarRecExporter.createTimedExpression(constraint, constraint.getRootExpression(), date, dateContext, sortedDateList, expressionExporter);
	}
}
