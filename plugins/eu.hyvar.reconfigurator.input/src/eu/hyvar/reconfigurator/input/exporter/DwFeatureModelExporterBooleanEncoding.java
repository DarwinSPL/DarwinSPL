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


//	@Override
//	protected String getOrRelation(String parentId, List<String> childrenIds) {
//		StringBuilder orStringBuilder = new StringBuilder(parentId);
//		
//		orStringBuilder.append(HyVarRecExporter.EQUIVALENCE);
//		
//		orStringBuilder.append(HyVarRecExporter.BRACKETS_OPEN);
//		
//		boolean first = true;
//		for(String childId: childrenIds) {
//			if(first) {
//				first = false;
//			}
//			else {
//				orStringBuilder.append(HyVarRecExporter.OR);
//			}
//			
//			orStringBuilder.append(childId);
//		}
//		
//		orStringBuilder.append(HyVarRecExporter.BRACKETS_CLOSING);
//		return orStringBuilder.toString();
//	}

	@Override
	protected String getAlternativeRelation(String parentId, List<String> childrenIds) {
		StringBuilder alternativeStringBuilder = new StringBuilder(parentId);
		
		alternativeStringBuilder.append(HyVarRecExporter.EQUIVALENCE);
		
		alternativeStringBuilder.append(HyVarRecExporter.ONE_ONLY);
		
		for(int i = 0; i < childrenIds.size(); i++) {
			if(i != 0) {
				alternativeStringBuilder.append(", ");
			}
			
			alternativeStringBuilder.append(childrenIds.get(i));
		}
		
		alternativeStringBuilder.append(HyVarRecExporter.WHITESPACE);
		alternativeStringBuilder.append(HyVarRecExporter.ARRAY_BRACKETS_CLOSING);
		
		return alternativeStringBuilder.toString();
	}


}
