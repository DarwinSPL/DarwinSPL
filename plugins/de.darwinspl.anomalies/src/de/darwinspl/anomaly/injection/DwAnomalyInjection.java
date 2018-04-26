package de.darwinspl.anomaly.injection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import de.darwinspl.anomaly.DwAnomaly;
import de.darwinspl.anomaly.DwDeadFeatureAnomaly;
import de.darwinspl.anomaly.DwFalseOptionalFeatureAnomaly;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.util.HyFeatureEvolutionUtil;
import eu.hyvar.feature.util.HyFeatureUtil;

/**
 * @deprecated
 * @author windo
 *
 */
public class DwAnomalyInjection {

	// WARNING! Not working!
	
	private enum FalseOptionalOperation {FeatureType, FeatureGroup, GroupType};
	
	private Date date;
	
	public DwAnomalyInjection() {
		date = new Date();
	}
	
	
	/**
	 * Creates a new evolution step with the anomalies
	 * @param featureModel
	 * @param constraintModel
	 * @param numberOfAnomalies
	 * @return
	 */
	public List<DwAnomalyInjected> injectAnomalies(HyFeatureModel featureModel, HyConstraintModel constraintModel, int numberOfAnomalies) {
		
//		Set<Date> dateSet = new HashSet<Date>();
//		dateSet.addAll(HyEvolutionUtil.collectDates(featureModel));
//		dateSet.addAll(HyEvolutionUtil.collectDates(constraintModel));
//		
//		List<Date> dates = new ArrayList<Date>(dateSet.size());
//		dates.addAll(dateSet);
//		Collections.sort(dates);
		
		List<HyFeature> optionalFeatures = HyFeatureEvolutionUtil.getFeatures(featureModel, new Date(), HyFeatureTypeEnum.OPTIONAL);
		if(optionalFeatures.size() < numberOfAnomalies) {
			numberOfAnomalies = optionalFeatures.size();
		}
		
		List<DwAnomalyInjected> anomalies = new ArrayList<DwAnomalyInjected>(numberOfAnomalies);
		
		Set<Integer> indexes = new HashSet<Integer>(numberOfAnomalies);
		
		Random rand = new Random();
		for(int i = 0; i < numberOfAnomalies; i++) {
			int index = rand.nextInt(optionalFeatures.size());
			
			if(!indexes.contains(index)) {
				indexes.add(index);
			}
		}
		
		for(Integer index: indexes) {
			DwAnomalyInjected anomaly;
			
			if(rand.nextBoolean()) {
				anomaly = createDeadFeatureAnomaly(featureModel, constraintModel, optionalFeatures.get(index));
			}
			else {
				anomaly = createFalseOptionalFeatureAnomaly(featureModel, constraintModel, optionalFeatures.get(index));
			}
			
			anomalies.add(anomaly);
		}
		
		return anomalies;
	}
	
	private DwAnomalyInjected createDeadFeatureAnomaly(HyFeatureModel featureModel, HyConstraintModel constraintModel, HyFeature feature) {

		// possible dead feature operations
//		private enum DeadFeatureOperation {FeatureType, FeatureGroup, GroupType};

		
		DwAnomalyInjected anomaly;
		
		boolean groupTypePossible = false;
		
		HyGroupComposition groupComposition = HyEvolutionUtil.getValidTemporalElement(feature.getGroupMembership(), date);
		if(groupComposition != null) {
			HyGroup group = groupComposition.getCompositionOf();
			if(group != null) {
				HyGroupType groupType = HyFeatureEvolutionUtil.getType(group, date);
				if(groupType != null && !groupType.getType().equals(HyGroupTypeEnum.ALTERNATIVE)) {
					groupTypePossible = true;
				}
			}
		}
		
		Random rand = new Random();
		int max = 2;
		if(groupTypePossible) {
			max++;
		}
		
		int opId = rand.nextInt(max);
		
		switch(opId) {
		case 0:
			// Feature Type
			List<HyFeature> optionalFeatures = HyFeatureEvolutionUtil.getFeatures(featureModel, new Date(), HyFeatureTypeEnum.OPTIONAL);
			HyFeature featureToChangeType = null;
			
			if(optionalFeatures.size() <= 1) {
				return null;
			}
			
			while(featureToChangeType == null || featureToChangeType==feature) {
				int index = rand.nextInt(optionalFeatures.size());
				featureToChangeType = optionalFeatures.get(index);
			}
			break;
		case 1:
			// Feature Group
			break;
		case 2:
			// 
			break;
		default:
			anomaly = null;
			break;
		}
		
		// TODO
		return null;
	}
	
	private DwAnomalyInjected createFalseOptionalFeatureAnomaly(HyFeatureModel featureModel, HyConstraintModel constraintModel, HyFeature feature) {
		return null;
	}
	
}
