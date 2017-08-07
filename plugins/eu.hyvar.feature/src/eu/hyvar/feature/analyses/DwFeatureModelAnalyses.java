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
		
//		Map<String, List<EObject>> nameMap = new HashMap<String, List<EObject>>();
		List<String> doubledNames = new ArrayList<String>();
		
		List<Date> dates = HyEvolutionUtil.collectDates(featureModel);
		
		if(dates == null || dates.isEmpty()) {
			markerList.addAll(computeDoubledNames(doubledNames, featureModel, null));
		}
		else {
			for(Date date: dates) {
				markerList.addAll(computeDoubledNames(doubledNames, featureModel, date));
			}
		}
		
//		for(Date date: dates) {
//			nameMap = new HashMap<String, List<EObject>>();
//			doubledNames = new ArrayList<String>();
//			
//			for(HyFeature feature: HyFeatureEvolutionUtil.getFeatures(featureModel, date)) {
//				collectNames(feature, nameMap, doubledNames, date);
//				for(HyFeatureAttribute attribute: HyFeatureEvolutionUtil.getAttributes(feature, date)) {
//					collectNames(attribute, nameMap, doubledNames, date);
//				}
//			}
//			
//			for(String doubledName: doubledNames) {
//				String errorMessage = "Multiple elements with the same name at date "+date.toString();
//				markerList.add(new DwFeatureModelAnalysesMarker(nameMap.get(doubledName), errorMessage, MarkerTypeEnum.ERROR));
//			}
//		}
//		
//		if(dates.isEmpty()) {
//			nameMap = new HashMap<String, List<EObject>>();
//			doubledNames = new ArrayList<String>();
//			
//			for(HyFeature feature: featureModel.getFeatures()) {
//				collectNames(feature, nameMap, doubledNames, null);
//				
//				List<String> doubledAttributeNames = new ArrayList<String>();
//				Map<String, List<EObject>> attributeNameMap = new HashMap<String, List<EObject>>();
//				
//				for(HyFeatureAttribute attribute: HyFeatureEvolutionUtil.getAttributes(feature, null)) {
//					collectNames(attribute, attributeNameMap, doubledAttributeNames, null);
//				}
//				
//				for(String doubledAttributeName: doubledAttributeNames) {
//					String errorMessage = "Multiple attributes with the same name at one point in time";
//					markerList.add(new DwFeatureModelAnalysesMarker(attributeNameMap.get(doubledAttributeName), errorMessage, MarkerTypeEnum.ERROR));
//				}
//			}
//			
//			for(String doubledName: doubledNames) {
//				String errorMessage = "Multiple features with the same name at one point in time";
//				markerList.add(new DwFeatureModelAnalysesMarker(nameMap.get(doubledName), errorMessage, MarkerTypeEnum.ERROR));
//			}
//		}
		
		return markerList;
	}
	
	private static List<DwFeatureModelAnalysesMarker> computeDoubledNames(List<String> doubledFeatureNames, HyFeatureModel featureModel, Date date) {
		List<DwFeatureModelAnalysesMarker> markerList = new ArrayList<DwFeatureModelAnalysesMarker>();
		
		Map<String, List<EObject>> featureNameMap = new HashMap<String, List<EObject>>();
		
		for(HyFeature feature: featureModel.getFeatures()) {
			collectNames(feature, featureNameMap, doubledFeatureNames, date);
			
			List<String> doubledAttributeNames = new ArrayList<String>();
			Map<String, List<EObject>> attributeNameMap = new HashMap<String, List<EObject>>();
			
			for(HyFeatureAttribute attribute: HyFeatureEvolutionUtil.getAttributes(feature, date)) {
				collectNames(attribute, attributeNameMap, doubledAttributeNames, date);
			}
			
			for(String doubledAttributeName: doubledAttributeNames) {
				String errorMessage = "Multiple attributes with the same name at one point in time";
				markerList.add(new DwFeatureModelAnalysesMarker(attributeNameMap.get(doubledAttributeName), errorMessage, MarkerTypeEnum.ERROR));
			}
		}
		
		for(String doubledName: doubledFeatureNames) {
			String errorMessage = "Multiple features with the same name at one point in time";
			markerList.add(new DwFeatureModelAnalysesMarker(featureNameMap.get(doubledName), errorMessage, MarkerTypeEnum.ERROR));
		}
		
		return markerList;
	}
	
	private static void collectNames(HyNamedElement namedElement, Map<String, List<EObject>> nameMap, List<String> doubledNames, Date date) {
		if(namedElement == null || namedElement.getNames() == null || HyFeatureEvolutionUtil.getName(namedElement.getNames(), date) == null) {
			return;
		}
		
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
