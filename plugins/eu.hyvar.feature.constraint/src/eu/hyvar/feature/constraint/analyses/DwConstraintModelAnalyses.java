package eu.hyvar.feature.constraint.analyses;

import java.util.ArrayList;
import java.util.List;

import de.darwinspl.common.analyses.DwAnalyses;
import de.darwinspl.common.analyses.DwAnalysesMarker;
import eu.hyvar.feature.constraint.HyConstraint;
import eu.hyvar.feature.constraint.HyConstraintModel;

public class DwConstraintModelAnalyses {
	
	public static List<DwAnalysesMarker> checkConstraintModelValidity(HyConstraintModel constraintModel) {
		List<DwAnalysesMarker> markerList = new ArrayList<DwAnalysesMarker>();
		
		markerList.addAll(checkReferenceValidityConsistency(constraintModel));
		
		return markerList;
	}
	
	public static List<DwAnalysesMarker> checkReferenceValidityConsistency(HyConstraintModel constraintModel) {
		List<DwAnalysesMarker> markerList = new ArrayList<DwAnalysesMarker>();
		
		
		for(HyConstraint constraint: constraintModel.getConstraints()) {
			markerList.addAll(DwAnalyses.checkReferenceValidityConsistencyForExpression(constraint.getRootExpression(), constraint));
		}
		
		return markerList;
	}
	
	

	
	
	
}
