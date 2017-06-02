package eu.hyvar.context.contextValidity.analyses;

import java.util.ArrayList;
import java.util.List;

import de.darwinspl.common.analyses.DwAnalyses;
import de.darwinspl.common.analyses.DwAnalysesMarker;
import eu.hyvar.context.contextValidity.HyAttributeValidityFormula;
import eu.hyvar.context.contextValidity.HyFeatureValidityFormula;
import eu.hyvar.context.contextValidity.HyValidityFormula;
import eu.hyvar.context.contextValidity.HyValidityModel;
import eu.hyvar.evolution.HyTemporalElement;

public class DwValidityModelAnalyses {
	
	public static List<DwAnalysesMarker> checkValidityModelValidity(HyValidityModel validityModel) {
		List<DwAnalysesMarker> markerList = new ArrayList<DwAnalysesMarker>();
		
		markerList.addAll(checkReferenceValidityConsistency(validityModel));
		
		return markerList;
	}
	
	public static List<DwAnalysesMarker> checkReferenceValidityConsistency(HyValidityModel validityModel) {
		List<DwAnalysesMarker> markerList = new ArrayList<DwAnalysesMarker>();
		
		
		for(HyValidityFormula validityFormula: validityModel.getValidityFormulas()) {
			markerList.addAll(checkReferenceValidityConsistencyForValidityFormula(validityFormula));
		}
		
		return markerList;
	}
	
	public static List<DwAnalysesMarker> checkReferenceValidityConsistencyForValidityFormula(HyValidityFormula validityFormula) {
		List<DwAnalysesMarker> markerList = new ArrayList<DwAnalysesMarker>();
		
		HyTemporalElement referencedFeatureOrFeatureAttribute = null;
		
		if(validityFormula instanceof HyFeatureValidityFormula) {
			referencedFeatureOrFeatureAttribute = ((HyFeatureValidityFormula) validityFormula).getFeature();
		} else if(validityFormula instanceof HyAttributeValidityFormula) {
			referencedFeatureOrFeatureAttribute = ((HyAttributeValidityFormula) validityFormula).getAttribute();
		}
		
		DwAnalysesMarker referencedElementMarker = DwAnalyses.checkReferenceValidityConsistencyForReferencedElement(referencedFeatureOrFeatureAttribute, null, validityFormula);
		
		if(referencedElementMarker != null) {
			markerList.add(referencedElementMarker);			
		}
		
		markerList.addAll(DwAnalyses.checkReferenceValidityConsistencyForExpression(validityFormula.getValidityFormula(), validityFormula));
		
		return markerList;
	}
}
