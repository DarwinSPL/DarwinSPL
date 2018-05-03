package de.darwinspl.common.analyses;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

public class DwAnalysesMarker {
	private List<EObject> affectedExpressions;
	private List<EObject> affectedObjects;
	private String message;
	private MarkerTypeEnum markerType;

	public DwAnalysesMarker(List<EObject> affectedExpressions, List<EObject> affectedObjects, String message, MarkerTypeEnum markerType) {
		this.affectedObjects = affectedObjects;
		this.affectedExpressions = affectedExpressions;
		this.message = message;
		this.markerType = markerType;
	}

	public enum MarkerTypeEnum {
		WARNING, ERROR
	}

	public List<EObject> getAffectedExpressions() {
		return affectedExpressions;
	}

	public String getMessage() {
		return message;
	}

	public MarkerTypeEnum getMarkerType() {
		return markerType;
	}

	public List<EObject> getAffectedObjects() {
		return affectedObjects;
	}
}
