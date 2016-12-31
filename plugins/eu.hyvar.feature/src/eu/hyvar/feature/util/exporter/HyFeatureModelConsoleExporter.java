package eu.hyvar.feature.util.exporter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyBooleanAttribute;
import eu.hyvar.feature.HyEnumAttribute;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyNumberAttribute;
import eu.hyvar.feature.HyStringAttribute;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.util.HyFeatureModelWellFormednessException;
import eu.hyvar.feature.util.HyFeatureUtil;

public class HyFeatureModelConsoleExporter extends HyFeatureExporter<String> {

	private StringBuilder output;
	private static final String endl = "\n";
	
	public HyFeatureModelConsoleExporter() {
		output = new StringBuilder("Feature Model:");
		output.append(endl);
	}
	

	@Override
	protected void visitFeature(HyFeature feature, HyName name, HyFeatureType featureType,
			List<? extends HyFeatureAttribute> attributes, List<HyVersion> versions, boolean isRoot, HyGroup group, Date date)  throws HyFeatureModelWellFormednessException {
		if(isRoot) {
			output.append("Root Feature: ");
		} else {
			output.append(" ");
			if(HyFeatureUtil.isOptional(feature, date)) {
				output.append("(optional) ");
			} else if(HyFeatureUtil.isMandatory(feature, date)) {
				output.append("(mandatory) ");
			}
		}
		
		output.append(name.getName());
		
		if(!attributes.isEmpty()) {
			output.append(" with Attributes: ");
			boolean firstAttribute = true;
			for(HyFeatureAttribute attribute: attributes) {
				if(firstAttribute) {
					firstAttribute = false;
				} else {
					output.append(" , ");
				}
				
				
				if(attribute.getNames().size()!=1) {
					List<String> names = new ArrayList<String>();
					for(HyName attributeName: (List<HyName>)attribute.getNames()) {
						names.add(attributeName.getName());
					}
					throw new HyFeatureModelWellFormednessException("An Attribute", "Attribute Names", attribute.getNames().size(), names);
				}
				output.append(((HyName) attribute.getNames().get(0)).getName());
				output.append(":");
				
				
				if(attribute instanceof HyNumberAttribute) {
					output.append("Number");
				} else if(attribute instanceof HyStringAttribute) {
					output.append("String");
				} else if(attribute instanceof HyBooleanAttribute) {
					output.append("Boolean");
				} else if(attribute instanceof HyEnumAttribute) {
					HyEnum hyEnum = ((HyEnumAttribute)attribute).getEnumType();
//					if(hyEnum.getNames().size()!=1) {
//						List<String> names = new ArrayList<String>();
//						for(HyName enumName: hyEnum.getNames()) {
//							names.add(enumName.getName());
//						}
//						throw new HyFeatureModelWellFormednessException("An Enum", "Enum Names", hyEnum.getNames().size(), names);
//					}
					output.append(hyEnum.getId());
				}
			}
		}
		
		if(!versions.isEmpty()) {
			output.append(" in Versions: ");
			
			boolean firstVersion = true;
			for(HyVersion version: versions) {
				if(firstVersion) {
					firstVersion = false;
				} else {
					output.append(" , ");
				}
				
				output.append(version.getNumber());
			}
		}
		
//		if(group==null) {
//			output.append(endl);			
//		}
	}

	@Override
	protected void visitGroup(HyGroup group, HyGroupType groupType, HyFeature parent, Date date) throws HyFeatureModelWellFormednessException {
		output.append(endl);
		
		if(HyFeatureUtil.isAnd(group, date)) {
			output.append("And Group");
		} else if(HyFeatureUtil.isOr(group, date)) {
			output.append("Or Group");
		} else if(HyFeatureUtil.isAlternative(group, date)) {
			output.append("Alternative Group");
		}
		
		if(parent.getNames().size()!=1) {
			List<String> names = new ArrayList<String>();
			for(HyName name: parent.getNames()) {
				names.add(name.getName());
			}
			throw new HyFeatureModelWellFormednessException("A Feature", "Feature Names", parent.getNames().size(), names);
		}
		output.append(" with Parent ");
		output.append(((HyName) parent.getNames().get(0)).getName());

		output.append(" containing Children:");
		
//		if(group.getParentOf().size()!=1) {
//			throw new HyFeatureModelWellFormednessException(group.getParentOf(), "Group composition", group.getParentOf().size());
//		}
//		
//		for(HyFeature feature: group.getParentOf().get(0).getFeatures()) {
//			
//		}
		
	}

	@Override
	protected String finish() {
		return output.toString();
	}


}
