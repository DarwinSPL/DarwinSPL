package eu.hyvar.feature.mapping.util;

import java.util.Date;

import eu.hyvar.feature.mapping.HyMappingModel;

public interface HyMappingExporter<T> {

//	/**
//	 * sinceNull prioritized, then untilNull, then date
//	 * @param featureModel
//	 * @param date
//	 * @param sinceNull
//	 * @param untilNull
//	 * @return
//	 * @throws HyFeatureModelWellFormednessException
//	 */
//	public T exportMappingModel(HyMappingModel mappingModel, Date date) {	
//		
//		// If date is null and no dates are available, take the current date
//		// if dates is not empty, take a date one day before the first available date
//		if(date == null) {
//			Calendar calendar = Calendar.getInstance();
//			
//			List<Date> dates = HyEvolutionUtil.collectDates(mappingModel);
//			if(dates.isEmpty()) {
//				date = calendar.getTime();
//			} else {
//				calendar.setTime(dates.get(0));
//				calendar.add(Calendar.DAY_OF_MONTH, -1);
//				date = calendar.getTime();
//			}
//		}
//		
//		HyMappingModel mappingModelCopy = HyEvolutionUtil.getCopyOfValidModel(mappingModel, date);
//		
//		return exportValidMappingModel(mappingModelCopy);
//	}
	
	public abstract T exportMappingModel(HyMappingModel mappingModel, Date date);
	
}
