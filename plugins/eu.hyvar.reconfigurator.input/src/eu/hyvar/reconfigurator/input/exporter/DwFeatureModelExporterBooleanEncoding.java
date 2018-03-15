package eu.hyvar.reconfigurator.input.exporter;

import java.util.ArrayList;
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
	protected List<String> getAlternativeRelation(String parentId, List<String> childrenIds) {
		List<String> alternativeConstraints = new ArrayList<String>(2);
		
		// Constraint: (child_0 or ... or child_n) impl parent
		StringBuilder alternativeChildrenRequireParent = new StringBuilder();
		
		// Constraint: parent iff onlyone[child_0,...,child_n]
		StringBuilder alternativeOnlyOneStringBuilder = new StringBuilder(parentId);
		
		alternativeOnlyOneStringBuilder.append(HyVarRecExporter.EQUIVALENCE);
		
		alternativeOnlyOneStringBuilder.append(HyVarRecExporter.ONE_ONLY);
		
		for(int i = 0; i < childrenIds.size(); i++) {
			if(i != 0) {
				alternativeOnlyOneStringBuilder.append(", ");
				alternativeChildrenRequireParent.append(HyVarRecExporter.OR);
			} 
			else if(i==0 && childrenIds.size() > 1) {
				alternativeChildrenRequireParent.append(HyVarRecExporter.BRACKETS_OPEN);
			}
			
			alternativeOnlyOneStringBuilder.append(childrenIds.get(i));
			alternativeChildrenRequireParent.append(childrenIds.get(i));
		}
		
		alternativeOnlyOneStringBuilder.append(HyVarRecExporter.WHITESPACE);
		alternativeOnlyOneStringBuilder.append(HyVarRecExporter.ARRAY_BRACKETS_CLOSING);
		alternativeConstraints.add(alternativeOnlyOneStringBuilder.toString());
		
		alternativeChildrenRequireParent.append(HyVarRecExporter.BRACKETS_CLOSING);
		alternativeChildrenRequireParent.append(HyVarRecExporter.IMPLICATION);
		alternativeChildrenRequireParent.append(parentId);
		alternativeConstraints.add(alternativeChildrenRequireParent.toString());
		
		
		return alternativeConstraints;
	}


}
