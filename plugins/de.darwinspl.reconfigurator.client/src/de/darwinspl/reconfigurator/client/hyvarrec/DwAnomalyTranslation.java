package de.darwinspl.reconfigurator.client.hyvarrec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import de.darwinspl.anomaly.DwAnomaly;
import de.darwinspl.anomaly.DwAnomalyFactory;
import de.darwinspl.anomaly.DwDeadFeatureAnomaly;
import de.darwinspl.anomaly.DwFalseOptionalFeatureAnomaly;
import de.darwinspl.anomaly.DwFeatureAnomaly;
import de.darwinspl.reconfigurator.client.hyvarrec.format.check_features.HyVarRecCheckFeaturesAnswer;
import eu.hyvar.feature.HyFeature;

public class DwAnomalyTranslation {

	private static List<DwAnomaly> translateAnomaly(Map<?, ?> hyVarRecAnomalyMap, Map<HyFeature, String> featureIdMapping,
			List<Date> sortedEvolutionStepDateList, Class<?> anomalyClass) {

		List<DwAnomaly> anomalies = new ArrayList<DwAnomaly>();

		for (Object keyObject : hyVarRecAnomalyMap.keySet()) {

			Object valueObject = hyVarRecAnomalyMap.get(keyObject);

			HyFeature anomalyFeature = null;
			if (keyObject instanceof String) {

				String featureId = (String) keyObject;

				for (HyFeature feature : featureIdMapping.keySet()) {
					if (featureId.equals(feature.getId())) {
						// This is the feature of the anomaly
						anomalyFeature = feature;
						break;
					}
				}

				if (anomalyFeature == null) {
					// TODO throw exception
					System.err.println("No feature could be matched to dead feature");
					continue;
				}
			}

			if (valueObject != null && valueObject instanceof List<?>) {
				List<?> valueList = (List<?>) valueObject;

				if (valueList.isEmpty()) {
					continue;
				}

				List<Integer> evolutionStepList = new ArrayList<Integer>();

				for (Object value : valueList) {
					if (value instanceof Double) {
						Double _double = (Double) value;
						int evolutionStep = _double.intValue();

						evolutionStepList.add(evolutionStep);
					}
				}

				Collections.sort(evolutionStepList);

				int intervalStart = 0;
				int intervalEnd = 0;
				boolean newInterval = true;

				for (int i = 0; i < evolutionStepList.size(); i++) {
					int step = evolutionStepList.get(i);

					if (newInterval) {
						newInterval = false;
						intervalStart = step;
						intervalEnd = step;
					} else {
						// if this step is connected with the step before
						if (step == (intervalEnd + 1)) {
							intervalEnd = step;
						}
						// if not, an anomaly with the interval of the step before has to be created and
						// a new interval is started
						else {
							// Create anomaly with the interval of the step before
							anomalies.add(createFeatureAnomaly(anomalyFeature, intervalStart, intervalEnd, sortedEvolutionStepDateList, anomalyClass));

							// set start and end to step
							intervalStart = step;
							intervalEnd = step;
						}
					}

					if (i == evolutionStepList.size() - 1) {
						// Create anomaly with the interval of the step before
						anomalies.add(createFeatureAnomaly(anomalyFeature, intervalStart, intervalEnd, sortedEvolutionStepDateList, anomalyClass));
					}
				}
			}
		}

		return anomalies;
	}
	
	private static DwFeatureAnomaly createFeatureAnomaly(HyFeature anomalyFeature, int intervalStart, int intervalEnd, List<Date> sortedEvolutionStepDateList, Class<?> anomalyClass) {
		DwFeatureAnomaly anomaly = null;
		
		if(anomalyClass.equals(DwDeadFeatureAnomaly.class)) {
			anomaly = DwAnomalyFactory.eINSTANCE
					.createDwDeadFeatureAnomaly();
		}
		else if(anomalyClass.equals(DwFalseOptionalFeatureAnomaly.class)) {
			anomaly = DwAnomalyFactory.eINSTANCE
					.createDwFalseOptionalFeatureAnomaly();
		}
		anomaly.setFeature(anomalyFeature);

		if (intervalStart == -1) {
			anomaly.setValidSince(null);
		} else {
			anomaly.setValidSince(sortedEvolutionStepDateList.get(intervalStart));
		}

		// Interval End means that the anomaly is valid at that point in time. As valid
		// Until implies that the anomaly isn't valid at that anymore, this has to be
		// transferred
		if (sortedEvolutionStepDateList.size() > intervalEnd + 1) {
			anomaly.setValidUntil(sortedEvolutionStepDateList.get(intervalEnd + 1));
		} else {
			anomaly.setValidUntil(null);
		}
		
		return anomaly;
	}

	public static List<DwAnomaly> translateAnomalies(HyVarRecCheckFeaturesAnswer hyVarRecAnswer,
			Map<HyFeature, String> featureIdMapping, List<Date> sortedEvolutionStepDateList) {
		List<DwAnomaly> anomalies = new ArrayList<DwAnomaly>();

		if (hyVarRecAnswer != null) {
			if (hyVarRecAnswer.getDeadFeatures() != null) {
				if (hyVarRecAnswer.getDeadFeatures() instanceof Map<?, ?>) {
					anomalies.addAll(translateAnomaly((Map<?, ?>) hyVarRecAnswer.getDeadFeatures(), featureIdMapping,
							sortedEvolutionStepDateList, DwDeadFeatureAnomaly.class));
				}
			}

			if (hyVarRecAnswer.getFalseOptionals() != null) {
				if (hyVarRecAnswer.getFalseOptionals() instanceof Map<?, ?>) {
					anomalies.addAll(translateAnomaly((Map<?, ?>) hyVarRecAnswer.getFalseOptionals(), featureIdMapping,
							sortedEvolutionStepDateList, DwFalseOptionalFeatureAnomaly.class));
				}
			}
		}

		return anomalies;
	}

}
