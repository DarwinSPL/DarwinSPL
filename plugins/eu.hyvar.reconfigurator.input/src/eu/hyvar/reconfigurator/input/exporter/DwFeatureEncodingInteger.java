package eu.hyvar.reconfigurator.input.exporter;

public class DwFeatureEncodingInteger implements DwFeatureEncoding {

	@Override
	public String getFeatureDeselected(String featureId) {
		StringBuilder featureSelectionStringBuilder = new StringBuilder(getFeatureSelection(featureId));
		featureSelectionStringBuilder.append(0);
		return featureSelectionStringBuilder.toString();
	}
	
	private String getFeatureSelection(String featureId) {
		StringBuilder featureSelectionStringBuilder = new StringBuilder(featureId);
		featureSelectionStringBuilder.append(HyVarRecExporter.EQUALS);
		return featureSelectionStringBuilder.toString();
	}
	


	@Override
	public String getFeatureSelected(String featureId) {
		StringBuilder featureSelectionStringBuilder = new StringBuilder(getFeatureSelection(featureId));
		featureSelectionStringBuilder.append(1);
		return featureSelectionStringBuilder.toString();
	}
}
