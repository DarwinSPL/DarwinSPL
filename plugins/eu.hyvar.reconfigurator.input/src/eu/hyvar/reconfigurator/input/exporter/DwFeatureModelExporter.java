package eu.hyvar.reconfigurator.input.exporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyBooleanAttribute;
import eu.hyvar.feature.HyEnumAttribute;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.HyNumberAttribute;
import eu.hyvar.feature.HyRootFeature;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.util.HyFeatureEvolutionUtil;
import eu.hyvar.feature.util.HyFeatureModelWellFormednessException;
import eu.hyvar.feature.util.HyFeatureUtil;
import eu.hyvar.reconfigurator.input.format.Context;

public class DwFeatureModelExporter {

	private HyFeatureModel featureModel;
	
	private Map<HyFeature, String> featureReconfiguratorIdMapping;
	private Map<HyVersion, String> versionReconfiguratorIdMapping;
	private Map<HyFeatureAttribute, String> attributeReconfiguratorIdMapping;
	
	public DwFeatureModelExporter(HyFeatureModel featureModel, Map<HyFeature, String> featureReconfiguratorIdMapping, Map<HyVersion, String> versionReconfiguratorIdMapping, Map<HyFeatureAttribute, String> attributeReconfiguratorIdMapping) {
		this.featureModel = featureModel;
		this.featureReconfiguratorIdMapping = featureReconfiguratorIdMapping;
		this.versionReconfiguratorIdMapping = versionReconfiguratorIdMapping;
		this.attributeReconfiguratorIdMapping = attributeReconfiguratorIdMapping;
	}
	
	public List<String> getFeatureModelConstraints(HyFeatureModel featureModel, Date date, Context dateContext, List<Date> sortedDateList) throws HyFeatureModelWellFormednessException {
		List<String> featureModelConstraints = new ArrayList<String>();

		StringBuilder rootFeatureConstraint = new StringBuilder();

		if(date != null || featureModel.getRootFeature().size() == 1) {
			// Root feature has to be selected
			HyRootFeature rootFeature = HyEvolutionUtil.getValidTemporalElement(featureModel.getRootFeature(), date);
			rootFeatureConstraint.append(featureReconfiguratorIdMapping.get(rootFeature.getFeature()));
			rootFeatureConstraint.append(HyVarRecExporter.EQUALS);
			rootFeatureConstraint.append(1);

			featureModelConstraints.add(rootFeatureConstraint.toString());

//			featureModelConstraints.addAll(getFeatureConstraints(rootFeature.getFeature(), true, date));

			featureModelConstraints.addAll(getFeatureModelVersionConstraints(featureModel, date, dateContext, sortedDateList));
		}
		else {
			for(HyRootFeature rootFeature: featureModel.getRootFeature()) {
				rootFeatureConstraint.append(HyVarRecExporter.timedConstraint(rootFeature, dateContext, sortedDateList));
				
				rootFeatureConstraint.append(featureReconfiguratorIdMapping.get(rootFeature.getFeature()));
				rootFeatureConstraint.append(HyVarRecExporter.EQUALS);
				rootFeatureConstraint.append(1);
				
				featureModelConstraints.add(rootFeatureConstraint.toString());
				rootFeatureConstraint = new StringBuilder();
			}
		}
		
		for(HyGroup group: featureModel.getGroups()) {
			featureModelConstraints.addAll(getGroupConstraints(group, date, dateContext, sortedDateList));
		}
		
		
//		// Set value of each feature and version to 0 if it is not valid at that moment
//		if(date == null) {
//			for(Date dateToCheck: sortedDateList) {
//				
//				StringBuilder featureInvalidStringBuilder = new StringBuilder();
//
//				
//				boolean atLeastOneFeature = false;
//				
//				for(HyFeature feature: featureModel.getFeatures()) {
//					
//					if(!HyEvolutionUtil.isValid(feature, dateToCheck)) {
//						if(!atLeastOneFeature) {
//							atLeastOneFeature = true;
//							
//							featureInvalidStringBuilder.append(HyVarRecExporter.timedConstraint(dateToCheck, dateContext, sortedDateList));
//							featureInvalidStringBuilder.append(HyVarRecExporter.BRACKETS_OPEN);
//						}
//						else {
//							featureInvalidStringBuilder.append(HyVarRecExporter.AND);
//						}
//						
//						featureInvalidStringBuilder.append(featureReconfiguratorIdMapping.get(feature));
//						featureInvalidStringBuilder.append(HyVarRecExporter.EQUALS);
//						featureInvalidStringBuilder.append(0);						
//					}
//					
//					for(HyVersion version: feature.getVersions()) {
//						if(!HyEvolutionUtil.isValid(version, dateToCheck)) {
//							if(!atLeastOneFeature) {
//								atLeastOneFeature = true;
//								
//								featureInvalidStringBuilder.append(HyVarRecExporter.timedConstraint(dateToCheck, dateContext, sortedDateList));
//								featureInvalidStringBuilder.append(HyVarRecExporter.BRACKETS_OPEN);
//							}
//							else {
//								featureInvalidStringBuilder.append(HyVarRecExporter.AND);
//							}
//							
//							featureInvalidStringBuilder.append(versionReconfiguratorIdMapping.get(version));
//							featureInvalidStringBuilder.append(HyVarRecExporter.EQUALS);
//							featureInvalidStringBuilder.append(0);		
//						}
//					}
//				}
//								
//				if(atLeastOneFeature) {
//					featureInvalidStringBuilder.append(HyVarRecExporter.BRACKETS_CLOSING);
//					featureModelConstraints.add(featureInvalidStringBuilder.toString());
//				}
//			}
//		}
		
		if(date == null) {
			featureModelConstraints.addAll(getEvolutionFeatureAndVersionRestrictionConstraints(featureModel.getFeatures(), dateContext));
		}

		return featureModelConstraints;
	}
	
	public List<eu.hyvar.reconfigurator.input.format.Attribute> getExportedAttributes(Date date) {
		List<eu.hyvar.reconfigurator.input.format.Attribute> exportAttributes = new ArrayList<eu.hyvar.reconfigurator.input.format.Attribute>();

		for (HyFeature feature : HyEvolutionUtil.getValidTemporalElements(featureModel.getFeatures(), date)) {
			for (HyFeatureAttribute attribute : HyEvolutionUtil.getValidTemporalElements(feature.getAttributes(),
					date)) {
				int min = 0;
				int max = 0;

				if (attribute instanceof HyNumberAttribute) {
					HyNumberAttribute numberAttribute = (HyNumberAttribute) attribute;
					min = numberAttribute.getMin();
					max = numberAttribute.getMax();
				} else if (attribute instanceof HyBooleanAttribute) {
					min = 0;
					max = 1;
				} else if (attribute instanceof HyEnumAttribute) {
					HyEnumAttribute enumAttribute = (HyEnumAttribute) attribute;
					DomainTuple<Integer> domain = HyVarRecExporter.getEnumDomain(enumAttribute.getEnumType());
					min = domain.getMin();
					max = domain.getMax();
				}

				eu.hyvar.reconfigurator.input.format.Attribute exportAttribute = new eu.hyvar.reconfigurator.input.format.Attribute();
				exportAttribute.setId(attributeReconfiguratorIdMapping.get(attribute));
				exportAttribute.setMin(min);
				exportAttribute.setMax(max);
				exportAttribute.setFeatureId(featureReconfiguratorIdMapping.get(feature));

				exportAttributes.add(exportAttribute);
			}
		}

		return exportAttributes;
	}
	
	private List<String> getFeatureModelVersionConstraints(HyFeatureModel featureModel, Date date, Context dateContext, List<Date> sortedDateList) {
		List<String> versionConstraints = new ArrayList<String>();

		
		
		// f feature, f_1 - f_n feature versions
		// f = (f_1 + ... + f_n)
		for (HyFeature feature : HyEvolutionUtil.getValidTemporalElements(featureModel.getFeatures(), date)) {
			List<Date> relevantDates = null;
			
			boolean considerOnlyOneDate = false;
			
			if(date != null) {
				relevantDates = new ArrayList<Date>(1);
				relevantDates.add(date);
				considerOnlyOneDate = true;
			} 
			else {
				relevantDates = HyEvolutionUtil.collectDates(feature.getVersions());
			}
			
			if(relevantDates.isEmpty()) {
				considerOnlyOneDate = true;
			}
			
			
			// i = -1 before the first date, as the first date could be from a validUntil while the validSince==null
			for (int i = -1; i < relevantDates.size(); i++) {

				StringBuilder versionStringBuilder = new StringBuilder();
				
				Date relevantDate;
				
				if(i == -1) {
					relevantDate = new Date(Long.MIN_VALUE);				
				}
				else {
					relevantDate = relevantDates.get(i);
				}
				
				
				List<HyVersion> validVersions = HyEvolutionUtil.getValidTemporalElements(feature.getVersions(), relevantDate);
				if(!validVersions.isEmpty()) {
					String timedConstraint = null;
					
					if(!considerOnlyOneDate) {
						Date validSince;
						if(i!=-1) {
							validSince = null;
						}
						else {
							validSince = relevantDate;
						}
						
						Date validUntil;
						if(i<relevantDates.size()-1) {
							validUntil = relevantDates.get(i+1);
						}
						else {
							validUntil = null;
						}
						
						timedConstraint = HyVarRecExporter.timedConstraint(validSince, validUntil, dateContext, sortedDateList);
						versionStringBuilder.append(timedConstraint);
						versionStringBuilder.append(HyVarRecExporter.BRACKETS_OPEN);
						
					}
					
					versionStringBuilder.append(featureReconfiguratorIdMapping.get(feature));
					versionStringBuilder.append(HyVarRecExporter.EQUALS);
					versionStringBuilder.append(HyVarRecExporter.BRACKETS_OPEN);

					boolean first = true;
					for (HyVersion version : validVersions) {
						if (!first) {
							versionStringBuilder.append(HyVarRecExporter.ADDITION);
						} else {
							first = false;
						}

						versionStringBuilder.append(versionReconfiguratorIdMapping.get(version));
					}
					versionStringBuilder.append(HyVarRecExporter.BRACKETS_CLOSING);
					
					if(timedConstraint != null) {
						versionStringBuilder.append(HyVarRecExporter.BRACKETS_CLOSING);
					}
					
					versionConstraints.add(versionStringBuilder.toString());
				}
			}
		}

		return versionConstraints;
	}
	
	

	// TODO obsolete?
//	private List<String> getFeatureConstraints(HyFeature feature, boolean isRoot, Date date) throws HyFeatureModelWellFormednessException {
//		List<String> featureModelConstraints = new ArrayList<String>();
//
//		List<HyFeatureChild> featureChildren = HyEvolutionUtil.getValidTemporalElements(feature.getParentOf(), date);
//		for (HyFeatureChild featureChild : featureChildren) {
//			featureModelConstraints.addAll(getGroupConstraints(featureChild.getChildGroup(),
//					featureReconfiguratorIdMapping.get(feature), isRoot, date));
//		}
//
//		return featureModelConstraints;
//	}

	private List<String> getGroupConstraints(HyGroup group, Date date, Context dateContext, List<Date> sortedDateList) throws HyFeatureModelWellFormednessException {
		List<String> featureModelConstraints = new ArrayList<String>();

		StringBuilder groupConstraintsStringBuilder = new StringBuilder();

		// Need to collect all dates in which the constraints are different
		
		Set<Date> relevantDatesSet = null;
		boolean considerOnlyOneDate = false;

		// With start index = -1, we capture the date before the first evolution step.
		int startIndexToIterate = -1;
		if(date != null) {
			relevantDatesSet = new HashSet<Date>(1);
			relevantDatesSet.add(date);
			considerOnlyOneDate = true;
			startIndexToIterate = 0;
		}
		else {
			relevantDatesSet = new HashSet<Date>();
			relevantDatesSet.addAll(HyEvolutionUtil.collectDates(group.getChildOf()));
			relevantDatesSet.addAll(HyEvolutionUtil.collectDates(group.getParentOf()));
			
		}
		
		// if there was no date, every since and until was null.
		if(relevantDatesSet.size() == 0) {
			considerOnlyOneDate = true;
		}
		
		// For each date at which something changes, create seperate constraints.
		List<Date> relevantDates = new ArrayList<Date>(relevantDatesSet);
		Collections.sort(relevantDates);
		
		// i = -1 before the first date, as the first date could be from a validUntil while the validSince==null
		for (int i = startIndexToIterate; i < relevantDates.size(); i++) {
			groupConstraintsStringBuilder = new StringBuilder();
			
			Date relevantDate;
			// i==-1 represents the date before the first evolution step
			if(i == -1) {
				relevantDate = new Date(Long.MIN_VALUE);				
			}
			else {
				relevantDate = relevantDates.get(i);
			}
			
			HyFeatureChild featureChild = HyEvolutionUtil.getValidTemporalElement(group.getChildOf(), relevantDate);
			HyGroupComposition groupComposition = HyEvolutionUtil.getValidTemporalElement(group.getParentOf(), relevantDate);
			
			// May happen if the first date is a from a validSince and we use minimum date.
			if(featureChild == null || groupComposition == null) {
				continue;
			}
			
			String parentFeatureId = featureReconfiguratorIdMapping.get(featureChild.getParent());
			
			String timedConstraint = null;
			
			if(!considerOnlyOneDate) {
				Date validSince;
				if(i==-1) {
					validSince = null;
				}
				else {
					validSince = relevantDate;
				}
				
				Date validUntil;
				if(i<relevantDates.size()-1) {
					validUntil = relevantDates.get(i+1);
				}
				else {
					validUntil = null;
				}
				
				timedConstraint = HyVarRecExporter.timedConstraint(validSince, validUntil, dateContext, sortedDateList);
				groupConstraintsStringBuilder.append(timedConstraint);
				groupConstraintsStringBuilder.append(HyVarRecExporter.BRACKETS_OPEN);
				
			}
			

			List<HyFeature> validFeaturesOfGroupComposition = HyEvolutionUtil
					.getValidTemporalElements(groupComposition.getFeatures(), relevantDate);
			
			boolean parentIsRoot = HyFeatureUtil.isRootFeature(featureChild.getParent(), relevantDate);
			
			if (!parentIsRoot) {
				
				// Require parent for each child
				// groupConstraintsStringBuilder.append(TABULATOR);
				groupConstraintsStringBuilder.append(HyVarRecExporter.BRACKETS_OPEN);

				boolean first = true;
				for (HyFeature feature : validFeaturesOfGroupComposition) {
					if (!first) {
						groupConstraintsStringBuilder.append(HyVarRecExporter.OR);
					} else {
						first = false;
					}

					groupConstraintsStringBuilder.append(featureReconfiguratorIdMapping.get(feature));
					groupConstraintsStringBuilder.append(HyVarRecExporter.EQUALS);
					groupConstraintsStringBuilder.append(1);
				}
				groupConstraintsStringBuilder.append(HyVarRecExporter.BRACKETS_CLOSING);

				groupConstraintsStringBuilder.append(HyVarRecExporter.IMPLICATION);
				groupConstraintsStringBuilder.append(parentFeatureId);
				groupConstraintsStringBuilder.append(HyVarRecExporter.EQUALS);
				groupConstraintsStringBuilder.append(1);

				if(timedConstraint != null) {
					groupConstraintsStringBuilder.append(HyVarRecExporter.BRACKETS_CLOSING);
				}
				
				featureModelConstraints.add(groupConstraintsStringBuilder.toString());
				groupConstraintsStringBuilder = new StringBuilder();
			}
		}
		
		
		// --------- add constraints for AND, OR, ALTERNATIVE groups
		
		// For group type constraints, group type dates and feature type dates are relevant as well.
		
		if(date == null) {
			relevantDatesSet.addAll(HyEvolutionUtil.collectDates(group.getTypes()));
			
			for(HyGroupComposition groupComposition: group.getParentOf()) {
				for(HyFeature feature: groupComposition.getFeatures()) {
					relevantDatesSet.addAll(HyEvolutionUtil.collectDates(feature.getTypes())); 
				}
			}
			
//			for(HyFeature feature: group.getFeatureModel().getFeatures()) {
//				relevantDatesSet.addAll(HyEvolutionUtil.collectDates(feature.getTypes()));
//			}
			
			relevantDates = new ArrayList<Date>(relevantDatesSet);
			Collections.sort(relevantDates);	
			
			if(relevantDatesSet.size() == 0) {
				considerOnlyOneDate = true;
			}
			else {
				considerOnlyOneDate = false;
			}
		}
		
		// i = -1 before the first date, as the first date could be from a
		// validUntil while the validSince==null
		for (int i = startIndexToIterate; i < relevantDates.size(); i++) {
			groupConstraintsStringBuilder = new StringBuilder();

			Date relevantDate;

			if (i == -1) {
				relevantDate = new Date(Long.MIN_VALUE);
			} else {
				relevantDate = relevantDates.get(i);
			}
			
			
			HyFeatureChild featureChild = HyEvolutionUtil.getValidTemporalElement(group.getChildOf(), relevantDate);
			HyGroupComposition groupComposition = HyEvolutionUtil.getValidTemporalElement(group.getParentOf(), relevantDate);
			HyGroupType groupType = HyEvolutionUtil.getValidTemporalElement(group.getTypes(), relevantDate);
			
			// May happen if the first date is a from a validSince and we use minimum date.
			if(featureChild == null || groupComposition == null || groupType == null) {
				continue;
			}
			
			String parentFeatureId = featureReconfiguratorIdMapping.get(featureChild.getParent());
			
			String timedConstraint = null;
			
			if(!considerOnlyOneDate) {
				Date validSince;
				if(i==-1) {
					validSince = null;
				}
				else {
					validSince = relevantDate;
				}
				
				Date validUntil;
				if(i<relevantDates.size()-1) {
					validUntil = relevantDates.get(i+1);
				}
				else {
					validUntil = null;
				}
				
				timedConstraint = HyVarRecExporter.timedConstraint(validSince, validUntil, dateContext, sortedDateList);
			}
			

			
			List<HyFeature> validFeaturesOfGroupComposition = HyEvolutionUtil
					.getValidTemporalElements(groupComposition.getFeatures(), relevantDate);
			

			// check if more than one element in group
			if (validFeaturesOfGroupComposition.size() > 1) {
				switch(groupType.getType()) {
				case ALTERNATIVE:
					groupConstraintsStringBuilder.append(parentFeatureId);
					groupConstraintsStringBuilder.append(HyVarRecExporter.EQUALS);
					groupConstraintsStringBuilder.append(1);
					groupConstraintsStringBuilder.append(HyVarRecExporter.IMPLICATION);
					groupConstraintsStringBuilder.append(HyVarRecExporter.BRACKETS_OPEN);

					// The sum of all children
					boolean first = true;
					for (HyFeature childFeature : validFeaturesOfGroupComposition) {
						if (!first) {
							groupConstraintsStringBuilder.append(HyVarRecExporter.ADDITION);
						} else {
							first = false;
						}

						groupConstraintsStringBuilder.append(featureReconfiguratorIdMapping.get(childFeature));
					}

					// is equal to 1
					groupConstraintsStringBuilder.append(HyVarRecExporter.EQUALS);
					groupConstraintsStringBuilder.append(1);
					groupConstraintsStringBuilder.append(HyVarRecExporter.BRACKETS_CLOSING);
					
					break;
				case AND:
					
					// Check if only optional features are in groups -> no constraint necessary
					if(HyFeatureUtil.getNumberOfMandatoryFeatures(validFeaturesOfGroupComposition, relevantDate) == 0) {
						break;
					}
					
					groupConstraintsStringBuilder.append(parentFeatureId);
					groupConstraintsStringBuilder.append(HyVarRecExporter.EQUALS);
					groupConstraintsStringBuilder.append(1);
					groupConstraintsStringBuilder.append(HyVarRecExporter.IMPLICATION);
					groupConstraintsStringBuilder.append(HyVarRecExporter.BRACKETS_OPEN);

					boolean firstChildAnd = true;

					for (HyFeature feature : validFeaturesOfGroupComposition) {
						// Constraints for mandatory features
						if (HyFeatureUtil.isMandatory(feature, relevantDate)) {
							if (!firstChildAnd) {
								groupConstraintsStringBuilder.append(HyVarRecExporter.AND);
							} else {
								firstChildAnd = false;
							}

							groupConstraintsStringBuilder.append(featureReconfiguratorIdMapping.get(feature));
							groupConstraintsStringBuilder.append(HyVarRecExporter.EQUALS);
							groupConstraintsStringBuilder.append(1);
						}
					}
					
					groupConstraintsStringBuilder.append(HyVarRecExporter.BRACKETS_CLOSING);
					break;
				case OR:
					
					groupConstraintsStringBuilder.append(parentFeatureId);
					groupConstraintsStringBuilder.append(HyVarRecExporter.EQUALS);
					groupConstraintsStringBuilder.append(1);
					groupConstraintsStringBuilder.append(HyVarRecExporter.IMPLICATION);
					groupConstraintsStringBuilder.append(HyVarRecExporter.BRACKETS_OPEN);

					boolean firstChildOr = true;

					for (HyFeature feature : validFeaturesOfGroupComposition) {
						if (!firstChildOr) {
							groupConstraintsStringBuilder.append(HyVarRecExporter.OR);
						} else {
							firstChildOr = false;
						}

						groupConstraintsStringBuilder.append(featureReconfiguratorIdMapping.get(feature));
						groupConstraintsStringBuilder.append(HyVarRecExporter.EQUALS);
						groupConstraintsStringBuilder.append(1);
					}

					groupConstraintsStringBuilder.append(HyVarRecExporter.BRACKETS_CLOSING);
					break;
				
				}
				
				if (!groupConstraintsStringBuilder.toString().equals("")) {
					if(timedConstraint != null) {
						StringBuilder timedGroupConstraintStringBuilder = new StringBuilder(timedConstraint);
						timedGroupConstraintStringBuilder.append(HyVarRecExporter.BRACKETS_OPEN);
						timedGroupConstraintStringBuilder.append(groupConstraintsStringBuilder);
						timedGroupConstraintStringBuilder.append(HyVarRecExporter.BRACKETS_CLOSING);		
						groupConstraintsStringBuilder = timedGroupConstraintStringBuilder;
					}
					
					featureModelConstraints.add(groupConstraintsStringBuilder.toString());
				}
			}
			
			// if only one feature is available in the group composition:
			else if(!validFeaturesOfGroupComposition.isEmpty()){
				HyFeature feature = validFeaturesOfGroupComposition.get(0);
				if (HyFeatureUtil.isMandatory(feature, relevantDate)) {
					// groupConstraintsStringBuilder.append(TABULATOR);
					// Mandatory Constraint (Parent => Child)
					groupConstraintsStringBuilder.append(parentFeatureId);
					groupConstraintsStringBuilder.append(HyVarRecExporter.EQUALS);
					groupConstraintsStringBuilder.append(1);
					groupConstraintsStringBuilder.append(HyVarRecExporter.IMPLICATION);
					groupConstraintsStringBuilder.append(featureReconfiguratorIdMapping.get(feature));
					groupConstraintsStringBuilder.append(HyVarRecExporter.EQUALS);
					groupConstraintsStringBuilder.append(1);

					if(timedConstraint != null) {
						StringBuilder timedGroupConstraintStringBuilder = new StringBuilder(timedConstraint);
						timedGroupConstraintStringBuilder.append(HyVarRecExporter.BRACKETS_OPEN);
						timedGroupConstraintStringBuilder.append(groupConstraintsStringBuilder);
						timedGroupConstraintStringBuilder.append(HyVarRecExporter.BRACKETS_CLOSING);		
						groupConstraintsStringBuilder = timedGroupConstraintStringBuilder;
					}
					
					featureModelConstraints.add(groupConstraintsStringBuilder.toString());
				}
				
			}
			
			boolean parentIsRoot = HyFeatureUtil.isRootFeature(featureChild.getParent(), relevantDate);
			
			// Each feature has to appear in a constraint to be detected by
			// HyVarRec. Normally, it is not necessary to create this constraint:
			// feature -> rootFeature. But if feature has no children, it would not
			// appear in any constraint. Only necessary if validSince and validUntil
			// are null or only one date is relevant
			if(parentIsRoot && groupType.getType().equals(HyGroupTypeEnum.AND)) {
				for (HyFeature feature : validFeaturesOfGroupComposition) {
					boolean setRootOptionalConstraint = false;
					
					if(!considerOnlyOneDate) {
						if(feature.getValidSince() == null && feature.getValidUntil() == null && feature.getParentOf().isEmpty()) {
							setRootOptionalConstraint = true;
						}
					}
					else {
						if(HyEvolutionUtil.getValidTemporalElements(feature.getParentOf(), relevantDate).isEmpty()) {
							setRootOptionalConstraint = true;
						}	
						else {
							for(HyFeatureChild featureChildOfFeature: HyEvolutionUtil.getValidTemporalElements(feature.getParentOf(), relevantDate)) {
								if(HyFeatureEvolutionUtil.getFeaturesOfGroup(featureChildOfFeature.getChildGroup(), relevantDate).isEmpty()) {
									setRootOptionalConstraint = true;							
								}
							}
						}					
					}
					
					if(setRootOptionalConstraint) {
						StringBuilder optionalWithoutChildStringBuilder = new StringBuilder();
						optionalWithoutChildStringBuilder.append(featureReconfiguratorIdMapping.get(feature));
						optionalWithoutChildStringBuilder.append(HyVarRecExporter.EQUALS);
						optionalWithoutChildStringBuilder.append(1);
						optionalWithoutChildStringBuilder.append(HyVarRecExporter.IMPLICATION);
						optionalWithoutChildStringBuilder.append(parentFeatureId);
						optionalWithoutChildStringBuilder.append(HyVarRecExporter.EQUALS);
						optionalWithoutChildStringBuilder.append(1);

						if(timedConstraint != null) {
							StringBuilder timedGroupConstraintStringBuilder = new StringBuilder(timedConstraint);
							timedGroupConstraintStringBuilder.append(HyVarRecExporter.BRACKETS_OPEN);
							timedGroupConstraintStringBuilder.append(optionalWithoutChildStringBuilder);
							timedGroupConstraintStringBuilder.append(HyVarRecExporter.BRACKETS_CLOSING);		
							optionalWithoutChildStringBuilder = timedGroupConstraintStringBuilder;
						}
						
						featureModelConstraints.add(optionalWithoutChildStringBuilder.toString());							
					}
				}
			}
		}
		
		return featureModelConstraints;
	}
	
	/**
	 * Set features and versions to 0 if they are not valid at certain points in time.
	 * @param features
	 * @param dateContext
	 * @return
	 */
	protected List<String> getEvolutionFeatureAndVersionRestrictionConstraints(List<HyFeature> features, Context dateContext) {
		List<String> evolutionFeatureRestrictionConstraints = new ArrayList<String>();
		
		Set<Date> relevantDateSet = new HashSet<Date>();
		relevantDateSet.addAll(HyEvolutionUtil.collectDates(features));
		
		for(HyFeature feature: features) {
			relevantDateSet.addAll(HyEvolutionUtil.collectDates(feature.getVersions()));			
		}
		
		
		if(relevantDateSet.size() == 0) {
			return evolutionFeatureRestrictionConstraints;
		}
		
		List<Date> relevantDates = new ArrayList<Date>(relevantDateSet);
		Collections.sort(relevantDates);
		
		for(int i=-1;i<relevantDates.size();i++) {
			StringBuilder stringBuilder = new StringBuilder();
			
			Date since = null;
			Date until = null;
			
			if(i==-1) {
				since = new Date(Long.MIN_VALUE);
			}
			else {
				since = relevantDates.get(i);
			}
			
			List<HyFeature> invalidFeatures = HyEvolutionUtil.getInvalidTemporalElements(features, since);
			
			List<HyVersion> invalidVersionsOfValidFeatures = new ArrayList<HyVersion>();
			for(HyFeature feature: features) {
				if(!invalidFeatures.contains(feature)) {
					invalidVersionsOfValidFeatures.addAll(HyEvolutionUtil.getInvalidTemporalElements(feature.getVersions(), since));
				}
			}
			
			if(invalidFeatures.size() == 0 && invalidVersionsOfValidFeatures.size() == 0) {
				continue;
			}
//			
//			stringBuilder.append(HyVarRecExporter.BRACKETS_OPEN);
//			
//			if(i==-1) {
//				since = null;
//				until = relevantDates.get(i+1);
//			}
//			else if(i == relevantDates.size()-1) {
//				until = null;
//			}
//			else {
//				until = relevantDates.get(i+1);
//			}
//			
//			stringBuilder.append(HyVarRecExporter.BRACKETS_CLOSING);
			
			
			
			if(i==-1) {
				since = null;
				until = relevantDates.get(i+1);
			}
			else if(i == relevantDates.size()-1) {
				until = null;
			}
			else {
				until = relevantDates.get(i+1);
			}
			
			String timedConstraint = HyVarRecExporter.timedConstraint(since, until, dateContext, relevantDates);
			stringBuilder.append(timedConstraint);
			stringBuilder.append(HyVarRecExporter.BRACKETS_OPEN);
			
			boolean first = true;
			
			for(HyFeature feature: invalidFeatures) {
				if(!first) {
					stringBuilder.append(HyVarRecExporter.AND);
				} else {
					first = false;
				}
				
				stringBuilder.append(featureReconfiguratorIdMapping.get(feature));
				stringBuilder.append(HyVarRecExporter.EQUALS);
				stringBuilder.append(0);
			}
			
			for(HyVersion version: invalidVersionsOfValidFeatures) {
				if(!first) {
					stringBuilder.append(HyVarRecExporter.AND);
				} else {
					first = false;
				}
				
				stringBuilder.append(versionReconfiguratorIdMapping.get(version));
				stringBuilder.append(HyVarRecExporter.EQUALS);
				stringBuilder.append(0);
			}
			

			stringBuilder.append(HyVarRecExporter.BRACKETS_CLOSING);
			
			evolutionFeatureRestrictionConstraints.add(stringBuilder.toString());
		}
		
		return evolutionFeatureRestrictionConstraints;
		
	}
}
