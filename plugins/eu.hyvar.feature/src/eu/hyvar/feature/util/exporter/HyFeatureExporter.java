package eu.hyvar.feature.util.exporter;

import java.util.Date;
import java.util.List;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyRootFeature;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.util.HyFeatureModelWellFormednessException;

public abstract class HyFeatureExporter<T> {	

	// TODO validity checks. -> new Util for a certain date
	
	/**
	 * Only containing valid elements of one point in time.
	 * @param constraintModel
	 */
	public T exportFeatureModel(HyFeatureModel featureModel, Date date) throws HyFeatureModelWellFormednessException {		
		
		HyRootFeature rootFeature = HyEvolutionUtil.getValidTemporalElement(featureModel.getRootFeature(), date);
		
		HyFeature rootFeatureFeature = rootFeature.getFeature();
		
		HyName rootFeatureName = HyEvolutionUtil.getValidTemporalElement(rootFeatureFeature.getNames(), date);
		
		HyFeatureType rootFeatureType = HyEvolutionUtil.getValidTemporalElement(rootFeatureFeature.getTypes(), date);
		
		List<HyFeatureAttribute> validFeatureAttributes = HyEvolutionUtil.getValidTemporalElements(rootFeatureFeature.getAttributes(), date);
		
		List<HyVersion> validVersions = HyEvolutionUtil.getValidTemporalElements(rootFeatureFeature.getVersions(), date);
		
		visitFeature(rootFeatureFeature, rootFeatureName, rootFeatureType, validFeatureAttributes, validVersions, true, null, date);
		
		processSubTree(rootFeatureFeature, date);
		
		return finish();
		
	}
	
	private void processSubTree(HyFeature feature, Date date) throws HyFeatureModelWellFormednessException {
		List<HyFeatureChild> featureChildren = feature.getParentOf();
		for(HyFeatureChild featureChild: featureChildren) {
			HyGroup group = featureChild.getChildGroup();
			
			HyGroupType groupType = HyEvolutionUtil.getValidTemporalElement(group.getTypes(), date);
			visitGroup(group, groupType, feature, date);
			
			HyGroupComposition groupComposition = HyEvolutionUtil.getValidTemporalElement(group.getParentOf(), date);
			
			for(HyFeature subFeature: groupComposition.getFeatures()) {
				HyName subFeatureName = HyEvolutionUtil.getValidTemporalElement(subFeature.getNames(), date);
				
				HyFeatureType subFeatureType = HyEvolutionUtil.getValidTemporalElement(subFeature.getTypes(), date);
				
				List<HyFeatureAttribute> validFeatureAttributes = HyEvolutionUtil.getValidTemporalElements(subFeature.getAttributes(), date);
				
				List<HyVersion> validVersions = HyEvolutionUtil.getValidTemporalElements(subFeature.getVersions(), date);
				
				visitFeature(subFeature, subFeatureName, subFeatureType, validFeatureAttributes, validVersions, false, group, date);
			}
			
			for(HyFeature subFeature: groupComposition.getFeatures()) {
				processSubTree(subFeature, date);
			}
		}
	}
	
//	/**
//	 * sinceNull prioritized, then untilNull, then date
//	 * @param featureModel
//	 * @param date
//	 * @param sinceNull
//	 * @param untilNull
//	 * @return
//	 * @throws HyFeatureModelWellFormednessException
//	 */
//	public T exportFeatureModel(HyFeatureModel featureModel, Date date) throws HyFeatureModelWellFormednessException {	
//		// If date is null and no dates are available, take the current date
//		// if dates is not empty, take a date one day before the first available date
////		if(date == null) {
////			Calendar calendar = Calendar.getInstance();
////			
////			List<Date> dates = HyEvolutionUtil.collectDates(featureModel);
////			if(dates.isEmpty()) {
////				date = calendar.getTime();
////			} else {
////				calendar.setTime(dates.get(0));
////				calendar.add(Calendar.DAY_OF_MONTH, -1);
////				date = calendar.getTime();
////			}
////		}
////		
////		
////		HyFeatureModel featureModelCopy = (HyFeatureModel) HyEvolutionUtil.getCopyOfValidModel(featureModel, date);
//		return exportValidFeatureModel(featureModel, date);
//	}
	
	
	/**
	 * Group possibly null if root feature
	 * @param feature
	 * @param name
	 * @param cardinality
	 * @param attributes only valid ones at @date
	 * @param versions only valid ones at @date
	 * @param group
	 * @param date
	 */
	protected abstract void visitFeature(HyFeature feature, HyName name, HyFeatureType type, List<? extends HyFeatureAttribute> validAttributes, List<HyVersion> validVersions, boolean isRoot, HyGroup group, Date date) throws HyFeatureModelWellFormednessException;
	protected abstract void visitGroup(HyGroup group, HyGroupType type, HyFeature parent, Date date) throws HyFeatureModelWellFormednessException;
	protected abstract T finish();
}
