package de.darwinspl.anomaly.impl.custom;

import de.darwinspl.anomaly.DwDeadFeatureAnomaly;
import de.darwinspl.anomaly.DwFalseOptionalFeatureAnomaly;
import de.darwinspl.anomaly.DwVoidFeatureModelAnomaly;
import de.darwinspl.anomaly.impl.DwAnomalyFactoryImpl;

public class DwAnomalyFactoryWithIds extends DwAnomalyFactoryImpl {

	public DwVoidFeatureModelAnomaly createDwVoidFeatureModelAnomaly() {
		DwVoidFeatureModelAnomaly dwVoidFeatureModelAnomaly = super.createDwVoidFeatureModelAnomaly();
		dwVoidFeatureModelAnomaly.createId();
		return dwVoidFeatureModelAnomaly;
	}

	public DwFalseOptionalFeatureAnomaly createDwFalseOptionalFeatureAnomaly() {
		DwFalseOptionalFeatureAnomaly dwFalseOptionalFeatureAnomaly = super.createDwFalseOptionalFeatureAnomaly();
		dwFalseOptionalFeatureAnomaly.createId();
		return dwFalseOptionalFeatureAnomaly;
	}
	
	public DwDeadFeatureAnomaly createDwDeadFeatureAnomaly() {
		DwDeadFeatureAnomaly dwDeadFeatureAnomaly = super.createDwDeadFeatureAnomaly();
		dwDeadFeatureAnomaly.createId();
		return dwDeadFeatureAnomaly;
	}
	
}
