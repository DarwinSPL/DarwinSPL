package de.darwinspl.anomaly.impl.custom;

import de.darwinspl.anomaly.impl.DwDeadFeatureAnomalyImpl;
import de.darwinspl.anomaly.util.DwAnomalyPrinter;

public class DwDeadFeatureAnomalyCustom extends DwDeadFeatureAnomalyImpl {
	
	@Override
	public String toString() {
		return DwAnomalyPrinter.printFeatureAnomaly(this);
	}

}
