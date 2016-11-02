package eu.hyvar.feature.graphical.base.util;

import java.util.Date;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;

public class HyFeatureUtil {
	/**
	 * Checks if feature has no modifier therefore is child of a "or" or "alternative" group
	 * @param date
	 * @return true if feature  is child of a "or" or "alternative" group, false otherwise
	 */
	public static boolean isWithoutModifier(HyFeature feature, Date date){
		HyGroupComposition composition = HyEvolutionUtil.getValidTemporalElement(feature.getGroupMembership(), date);
		if(composition == null) return false;
		//if(HyEvolutionUtil.getValidTemporalElements(composition.getFeatures(), date).size() <= 1)
		//	return false;
				
		HyGroupType type = HyEvolutionUtil.getValidTemporalElement(composition.getCompositionOf().getTypes(), date);

		if(type.getType() == HyGroupTypeEnum.AND){
			return false;
		}

		return true;
	}
	public static boolean isWithModifier(HyFeature feature, Date date){
		return !isWithoutModifier(feature, date);
	}
}
