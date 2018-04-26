package eu.hyvar.reconfigurator.input.exporter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyVersion;

public class DwFeatureModelExporterIntegerEncoding extends DwFeatureModelExporter {

	public DwFeatureModelExporterIntegerEncoding(HyFeatureModel featureModel,
			Map<HyFeature, String> featureReconfiguratorIdMapping,
			Map<HyVersion, String> versionReconfiguratorIdMapping,
			Map<HyFeatureAttribute, String> attributeReconfiguratorIdMapping) {
		super(featureModel, featureReconfiguratorIdMapping, versionReconfiguratorIdMapping, attributeReconfiguratorIdMapping);
		
		this.featureEndocing = new DwFeatureEncodingInteger();
	}

//	@Override
//	protected String getOrRelation(String parentId, List<String> childrenIds) {
//		StringBuilder orStringBuilder = new StringBuilder(featureEndocing.getFeatureSelected(parentId));
//
//		orStringBuilder.append(HyVarRecExporter.IMPLICATION);
//		orStringBuilder.append(HyVarRecExporter.BRACKETS_OPEN);
//
//		boolean firstChildOr = true;
//
//		for (String childId : childrenIds) {
//			if (!firstChildOr) {
//				orStringBuilder.append(HyVarRecExporter.OR);
//			} else {
//				firstChildOr = false;
//			}
//
//			featureEndocing.getFeatureSelected(childId);
//		}
//
//		orStringBuilder.append(HyVarRecExporter.BRACKETS_CLOSING);
//		
//		return orStringBuilder.toString();
//	}

	@Override
	protected List<String> getAlternativeRelation(String parentId, List<String> childrenIds) {

		StringBuilder alternativeStringBuilder = new StringBuilder();
		
//		if(childrenIds.size() > 1) {			
//			alternativeStringBuilder.append(HyVarRecExporter.BRACKETS_OPEN);
//			alternativeStringBuilder.append(featureEndocing.getFeatureSelected(parentId));
//			alternativeStringBuilder.append(HyVarRecExporter.BRACKETS_CLOSING);
//		}
//		else {
		alternativeStringBuilder.append(parentId);
//		}
		

		alternativeStringBuilder.append(HyVarRecExporter.EQUALS);
		alternativeStringBuilder.append(HyVarRecExporter.BRACKETS_OPEN);

		// The sum of all children
		boolean first = true;
		for (String childFeatureId : childrenIds) {
			if (!first) {
				alternativeStringBuilder.append(HyVarRecExporter.ADDITION);
			} else {
				first = false;
			}
			
			alternativeStringBuilder.append(childFeatureId);				
		}

		// is equal to 1
//		alternativeStringBuilder.append(HyVarRecExporter.EQUALS);
//		alternativeStringBuilder.append(1);
		alternativeStringBuilder.append(HyVarRecExporter.BRACKETS_CLOSING);
		
		List<String> alternativeConstraints = new ArrayList<String>(1);
		alternativeConstraints.add(alternativeStringBuilder.toString());
		return alternativeConstraints;
	}


	
	

}
