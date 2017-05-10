package eu.hyvar.feature.analyses;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

public class DwFeatureModelAnalysesMarker {
	private List<EObject> affectedObjects;
	private String message;
	private MarkerTypeEnum markerType;

	public DwFeatureModelAnalysesMarker(List<EObject> affectedObjects, String message, MarkerTypeEnum markerType) {
		this.affectedObjects = affectedObjects;
		this.message = message;
		this.markerType = markerType;
	}

	public enum MarkerTypeEnum {
		WARNING, ERROR
	}

	public List<EObject> getAffectedObjects() {
		return affectedObjects;
	}

	public String getMessage() {
		return message;
	}

	public MarkerTypeEnum getMarkerType() {
		return markerType;
	}
	
	
}
