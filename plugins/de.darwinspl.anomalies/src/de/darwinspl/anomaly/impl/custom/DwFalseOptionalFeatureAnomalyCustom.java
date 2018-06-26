package de.darwinspl.anomaly.impl.custom;

import de.darwinspl.anomaly.impl.DwFalseOptionalFeatureAnomalyImpl;
import de.darwinspl.anomaly.util.DwAnomalyPrinter;

public class DwFalseOptionalFeatureAnomalyCustom extends DwFalseOptionalFeatureAnomalyImpl {

	@Override
	public String toString() {
		return DwAnomalyPrinter.printFeatureAnomaly(this);
	}
	
}
