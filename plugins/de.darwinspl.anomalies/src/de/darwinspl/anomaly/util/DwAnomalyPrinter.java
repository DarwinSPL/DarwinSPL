package de.darwinspl.anomaly.util;

import java.util.Date;

import de.darwinspl.anomaly.DwDeadFeatureAnomaly;
import de.darwinspl.anomaly.DwFalseOptionalFeatureAnomaly;
import de.darwinspl.anomaly.DwFeatureAnomaly;
import eu.hyvar.evolution.HyName;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;

public class DwAnomalyPrinter {

	private static final String DEAD_ANOMALY_TYPE = "dead";
	private static final String FALSE_OPTIONAL_ANOMALY_TYPE = "false-optional";
	private static final String UNKNOWN_ANOMALY_TYPE = "unknown";
	
	public static final String printFeatureAnomaly(DwFeatureAnomaly anomaly) {
		if(anomaly == null) {
			return "null";
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		
		Date since = anomaly.getValidSince();
		Date until = anomaly.getValidUntil();
		
		HyFeature feature = anomaly.getFeature();
		
		if(feature != null) {
			String featureName = "";
			
			if(since == null) {
				HyName hyName = feature.getNames().get(0);
				featureName = hyName.getName()+" (name at date "+hyName.getValidSince()+")";
			}
			else {
				HyName hyName = HyEvolutionUtil.getValidTemporalElement(feature.getNames(), since);
				if(hyName != null) {
					featureName = hyName.getName();
					featureName = featureName + " (name at date "+since.toString()+")";
				}
			}
			
			stringBuilder.append("Feature ");
			stringBuilder.append(featureName);
			stringBuilder.append(" (with ID ");
			stringBuilder.append(feature.getId());
			stringBuilder.append(")");
			stringBuilder.append(" is ");
			
			if(anomaly instanceof DwDeadFeatureAnomaly) {
				stringBuilder.append(DEAD_ANOMALY_TYPE);				
			}
			else if(anomaly instanceof DwFalseOptionalFeatureAnomaly) {
				stringBuilder.append(FALSE_OPTIONAL_ANOMALY_TYPE);	
			}
			else {
				stringBuilder.append(UNKNOWN_ANOMALY_TYPE);	
			}
			
			String sinceString = dateToString(since);
			String untilString = dateToString(until);
			
			stringBuilder.append(" from ");
			stringBuilder.append(sinceString);
			stringBuilder.append(" until ");
			stringBuilder.append(untilString);
		}
		
		return stringBuilder.toString();
	}
	

	
	private static String dateToString(Date date) {
		if(date == null) {
			return "eternity";
		}
		else {
			return date.toString();
		}
	}
	
}
