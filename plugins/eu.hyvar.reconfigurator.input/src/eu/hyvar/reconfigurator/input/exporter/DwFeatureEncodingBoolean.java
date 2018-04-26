package eu.hyvar.reconfigurator.input.exporter;

public class DwFeatureEncodingBoolean implements DwFeatureEncoding {

	@Override
	public String getFeatureSelected(String featureId) {
		return featureId;
	}

	@Override
	public String getFeatureDeselected(String featureId) {
		StringBuilder deselectedStringBuilder = new StringBuilder(HyVarRecExporter.NOT);
		deselectedStringBuilder.append(featureId);
		return deselectedStringBuilder.toString();
	}

}
