package de.darwinspl.anomaly.injection;

import de.darwinspl.anomaly.DwAnomaly;

public class DwAnomalyInjected {

	private DwAnomaly anomaly;
	private String performedOperation;
	public DwAnomaly getAnomaly() {
		return anomaly;
	}
	public void setAnomaly(DwAnomaly anomaly) {
		this.anomaly = anomaly;
	}
	public String getPerformedOperation() {
		return performedOperation;
	}
	public void setPerformedOperation(String performedOperation) {
		this.performedOperation = performedOperation;
	}	
	
	
	
}
