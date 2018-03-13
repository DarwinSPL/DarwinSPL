package eu.hyvar.reconfigurator.input.exporter;

import java.util.List;
import java.util.Map;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyVersion;

public class DwFeatureModelExporterBooleanEncoding extends DwFeatureModelExporter {

	public DwFeatureModelExporterBooleanEncoding(HyFeatureModel featureModel,
			Map<HyFeature, String> featureReconfiguratorIdMapping,
			Map<HyVersion, String> versionReconfiguratorIdMapping,
			Map<HyFeatureAttribute, String> attributeReconfiguratorIdMapping) {
		super(featureModel, featureReconfiguratorIdMapping, versionReconfiguratorIdMapping, attributeReconfiguratorIdMapping);
		
		this.featureEndocing = new DwFeatureEncodingBoolean();
	}


	@Override
	protected String getOrRelation(String parentId, List<String> childrenIds) {
		StringBuilder orStringBuilder = new StringBuilder(parentId);
		
		orStringBuilder.append(HyVarRecExporter.IMPLICATION);
		
		orStringBuilder.append(HyVarRecExporter.BRACKETS_OPEN);
		
		boolean first = true;
		for(String childId: childrenIds) {
			if(first) {
				first = false;
			}
			else {
				orStringBuilder.append(HyVarRecExporter.OR);
			}
			
			orStringBuilder.append(childId);
		}
		
		orStringBuilder.append(HyVarRecExporter.BRACKETS_CLOSING);
		return orStringBuilder.toString();
	}

	@Override
	protected String getAlternativeRelation(String parentId, List<String> childrenIds) {
		StringBuilder alternativeStringBuilder = new StringBuilder(parentId);
		
		alternativeStringBuilder.append(HyVarRecExporter.IMPLICATION);
		
		alternativeStringBuilder.append(HyVarRecExporter.BRACKETS_OPEN);
		
		for(int i = 0; i < childrenIds.size(); i++) {
			if(i != 0) {
				alternativeStringBuilder.append(HyVarRecExporter.OR);
			}
			
			alternativeStringBuilder.append(childrenIds.get(i));
			
			for(int j = 0; j < childrenIds.size(); j++) {
				if(j==i) {
					continue;
				}
				alternativeStringBuilder.append(HyVarRecExporter.AND);
				
				alternativeStringBuilder.append(featureEndocing.getFeatureDeselected(childrenIds.get(j)));
			}
		}
		

		alternativeStringBuilder.append(HyVarRecExporter.BRACKETS_CLOSING);
		
		return alternativeStringBuilder.toString();
	}


}
