package eu.hyvar.feature.analyses;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import eu.hyvar.evolution.HyNamedElement;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.analyses.DwFeatureModelAnalysesMarker.MarkerTypeEnum;
import eu.hyvar.feature.util.HyFeatureEvolutionUtil;

public class DwFeatureModelAnalyses {

	public static List<DwFeatureModelAnalysesMarker> checkFeatureModelValidity(HyFeatureModel featureModel) {
		List<DwFeatureModelAnalysesMarker> markerList = new ArrayList<DwFeatureModelAnalysesMarker>();
		
		markerList.addAll(checkForNameUniqueness(featureModel));
		
		return markerList;
	}
	
	public static List<DwFeatureModelAnalysesMarker> checkForNameUniqueness(HyFeatureModel featureModel) {
		List<DwFeatureModelAnalysesMarker> markerList = new ArrayList<DwFeatureModelAnalysesMarker>();
		
		Map<String, List<EObject>> nameMap;
		List<String> doubledNames;
		
		List<Date> dates = HyEvolutionUtil.collectDates(featureModel);
		
		for(Date date: dates) {
			nameMap = new HashMap<String, List<EObject>>();
			doubledNames = new ArrayList<String>();
			
			for(HyFeature feature: HyFeatureEvolutionUtil.getFeatures(featureModel, date)) {
				collectNames(feature, nameMap, doubledNames, date);
				for(HyFeatureAttribute attribute: HyFeatureEvolutionUtil.getAttributes(feature, date)) {
					collectNames(attribute, nameMap, doubledNames, date);
				}
			}
			
			for(String doubledName: doubledNames) {
				String errorMessage = "Multiple elements with the same name at date "+date.toString();
				markerList.add(new DwFeatureModelAnalysesMarker(nameMap.get(doubledName), errorMessage, MarkerTypeEnum.ERROR));
			}
		}
		
		if(dates.isEmpty()) {
			nameMap = new HashMap<String, List<EObject>>();
			doubledNames = new ArrayList<String>();
			
			for(HyFeature feature: featureModel.getFeatures()) {
				collectNames(feature, nameMap, doubledNames, null);
				for(HyFeatureAttribute attribute: HyFeatureEvolutionUtil.getAttributes(feature, null)) {
					collectNames(attribute, nameMap, doubledNames, null);
				}
			}
			
			for(String doubledName: doubledNames) {
				String errorMessage = "Multiple elements with the same name at one point in time";
				markerList.add(new DwFeatureModelAnalysesMarker(nameMap.get(doubledName), errorMessage, MarkerTypeEnum.ERROR));
			}
		}
		
		return markerList;
	}
	
	private static void collectNames(HyNamedElement namedElement, Map<String, List<EObject>> nameMap, List<String> doubledNames, Date date) {
		String name = HyFeatureEvolutionUtil.getName(namedElement.getNames(), date).getName();
		if(nameMap.containsKey(name)) {
			nameMap.get(name).add(namedElement);
			doubledNames.add(name);
		}
		else {
			List<EObject> elementList = new ArrayList<EObject>(1);
			elementList.add(namedElement);
			nameMap.put(name, elementList);
		}
		
	}
	
}
