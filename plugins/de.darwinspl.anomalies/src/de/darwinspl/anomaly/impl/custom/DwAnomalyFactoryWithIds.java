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
		DwFalseOptionalFeatureAnomalyCustom dwFalseOptionalFeatureAnomaly = new DwFalseOptionalFeatureAnomalyCustom();
		dwFalseOptionalFeatureAnomaly.createId();
		return dwFalseOptionalFeatureAnomaly;
	}
	
	public DwDeadFeatureAnomaly createDwDeadFeatureAnomaly() {
		DwDeadFeatureAnomalyCustom dwDeadFeatureAnomaly = new DwDeadFeatureAnomalyCustom();
		dwDeadFeatureAnomaly.createId();
		return dwDeadFeatureAnomaly;
	}
	
}
