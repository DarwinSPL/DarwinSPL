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
import eu.hyvar.feature.HyNumberAttribute;
import eu.hyvar.feature.HyRootFeature;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.util.HyFeatureModelWellFormednessException;
import eu.hyvar.feature.util.HyFeatureUtil;
import eu.hyvar.reconfigurator.input.exporter.HyVarRecExporter.FeatureEncoding;
import eu.hyvar.reconfigurator.input.format.Context;

public abstract class DwFeatureModelExporter {

	private Map<HyFeatureAttribute, String> attributeReconfiguratorIdMapping;

	protected DwFeatureEncoding featureEndocing;

	private HyFeatureModel featureModel;

	private Map<HyFeature, String> featureReconfiguratorIdMapping;
	private Map<HyVersion, String> versionReconfiguratorIdMapping;

	public DwFeatureModelExporter(HyFeatureModel featureModel, Map<HyFeature, String> featureReconfiguratorIdMapping,
			Map<HyVersion, String> versionReconfiguratorIdMapping,
			Map<HyFeatureAttribute, String> attributeReconfiguratorIdMapping) {
		this.featureModel = featureModel;
		this.featureReconfiguratorIdMapping = featureReconfiguratorIdMapping;
		this.versionReconfiguratorIdMapping = versionReconfiguratorIdMapping;
		this.attributeReconfiguratorIdMapping = attributeReconfiguratorIdMapping;
	}

	protected abstract List<String> getAlternativeRelation(String parentId, List<String> childrenIds);

	/**
	 * Set features and versions to 0 if they are not valid at certain points in
	 * time.
	 * 
	 * @param features
	 * @param dateContext
	 * @return
	 */
	protected List<String> getEvolutionFeatureAndVersionRestrictionConstraints(List<HyFeature> features,
			Context dateContext) {
		List<String> evolutionFeatureRestrictionConstraints = new ArrayList<String>();

		Set<Date> relevantDateSet = new HashSet<Date>();
		relevantDateSet.addAll(HyEvolutionUtil.collectDates(features));

		for (HyFeature feature : features) {
			relevantDateSet.addAll(HyEvolutionUtil.collectDates(feature.getVersions()));
		}

		if (relevantDateSet.size() == 0) {
			return evolutionFeatureRestrictionConstraints;
		}

		List<Date> relevantDates = new ArrayList<Date>(relevantDateSet);
		Collections.sort(relevantDates);

		for (int i = -1; i < relevantDates.size(); i++) {
			StringBuilder stringBuilder = new StringBuilder();

			Date since = null;
			Date until = null;

			if (i == -1) {
				since = new Date(Long.MIN_VALUE);
			} else {
				since = relevantDates.get(i);
			}

			List<HyFeature> invalidFeatures = HyEvolutionUtil.getInvalidTemporalElements(features, since);

			List<HyVersion> invalidVersionsOfValidFeatures = new ArrayList<HyVersion>();
			for (HyFeature feature : features) {
				if (!invalidFeatures.contains(feature)) {
					invalidVersionsOfValidFeatures
							.addAll(HyEvolutionUtil.getInvalidTemporalElements(feature.getVersions(), since));
				}
			}

			if (invalidFeatures.size() == 0 && invalidVersionsOfValidFeatures.size() == 0) {
				continue;
			}

			if (i == -1) {
				since = null;
				until = relevantDates.get(i + 1);
			} else if (i == relevantDates.size() - 1) {
				until = null;
			} else {
				until = relevantDates.get(i + 1);
			}

			String timedConstraint = HyVarRecExporter.timedConstraint(since, until, dateContext, relevantDates);
			stringBuilder.append(timedConstraint);
			stringBuilder.append(HyVarRecExporter.BRACKETS_OPEN);

			boolean first = true;

			for (HyFeature feature : invalidFeatures) {
				if (!first) {
					stringBuilder.append(HyVarRecExporter.AND);
				} else {
					first = false;
				}

				stringBuilder.append(featureEndocing.getFeatureDeselected(featureReconfiguratorIdMapping.get(feature)));
			}

			for (HyVersion version : invalidVersionsOfValidFeatures) {
				if (!first) {
					stringBuilder.append(HyVarRecExporter.AND);
				} else {
					first = false;
				}

				stringBuilder.append(featureEndocing.getFeatureDeselected(versionReconfiguratorIdMapping.get(version)));
			}

			stringBuilder.append(HyVarRecExporter.BRACKETS_CLOSING);

			evolutionFeatureRestrictionConstraints.add(stringBuilder.toString());
		}

		return evolutionFeatureRestrictionConstraints;

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

	public List<String> getFeatureModelConstraints(HyFeatureModel featureModel, Date date, Context dateContext,
			List<Date> sortedDateList) throws HyFeatureModelWellFormednessException {
		List<String> featureModelConstraints = new ArrayList<String>();

		StringBuilder rootFeatureConstraint = new StringBuilder();

		if (date != null || featureModel.getRootFeature().size() == 1) {
			// Root feature has to be selected
			HyRootFeature rootFeature = HyEvolutionUtil.getValidTemporalElement(featureModel.getRootFeature(), date);
			rootFeatureConstraint.append(
					featureEndocing.getFeatureSelected(featureReconfiguratorIdMapping.get(rootFeature.getFeature())));
			featureModelConstraints.add(rootFeatureConstraint.toString());

			featureModelConstraints
					.addAll(getFeatureModelVersionConstraints(featureModel, date, dateContext, sortedDateList));

		} else {
			for (HyRootFeature rootFeature : featureModel.getRootFeature()) {
				rootFeatureConstraint
						.append(HyVarRecExporter.timedConstraint(rootFeature, dateContext, sortedDateList));

				rootFeatureConstraint.append(featureEndocing
						.getFeatureSelected(featureReconfiguratorIdMapping.get(rootFeature.getFeature())));

				featureModelConstraints.add(rootFeatureConstraint.toString());
				rootFeatureConstraint = new StringBuilder();
			}
		}

		for (HyGroup group : featureModel.getGroups()) {
			featureModelConstraints.addAll(getGroupConstraints(group, date, dateContext, sortedDateList));
		}

		if (date == null) {
			featureModelConstraints.addAll(
					getEvolutionFeatureAndVersionRestrictionConstraints(featureModel.getFeatures(), dateContext));
		}

		return featureModelConstraints;
	}

	private List<String> getFeatureModelVersionConstraints(HyFeatureModel featureModel, Date date, Context dateContext,
			List<Date> sortedDateList) {
		List<String> versionConstraints = new ArrayList<String>();

		// f feature, f_1 - f_n feature versions
		// f = (f_1 + ... + f_n)
		for (HyFeature feature : HyEvolutionUtil.getValidTemporalElements(featureModel.getFeatures(), date)) {
			List<Date> relevantDates = null;

			boolean considerOnlyOneDate = false;

			if (date != null) {
				relevantDates = new ArrayList<Date>(1);
				relevantDates.add(date);
				considerOnlyOneDate = true;
			} else {
				relevantDates = HyEvolutionUtil.collectDates(feature.getVersions());
			}

			if (relevantDates.isEmpty()) {
				considerOnlyOneDate = true;
			}

			// i = -1 before the first date, as the first date could be from a validUntil
			// while the validSince==null
			for (int i = -1; i < relevantDates.size(); i++) {

				StringBuilder versionStringBuilder = new StringBuilder();

				Date relevantDate;

				if (i == -1) {
					relevantDate = new Date(Long.MIN_VALUE);
				} else {
					relevantDate = relevantDates.get(i);
				}

				List<HyVersion> validVersions = HyEvolutionUtil.getValidTemporalElements(feature.getVersions(),
						relevantDate);
				if (!validVersions.isEmpty()) {
					String timedConstraint = null;

					if (!considerOnlyOneDate) {
						Date validSince;
						if (i != -1) {
							validSince = null;
						} else {
							validSince = relevantDate;
						}

						Date validUntil;
						if (i < relevantDates.size() - 1) {
							validUntil = relevantDates.get(i + 1);
						} else {
							validUntil = null;
						}

						timedConstraint = HyVarRecExporter.timedConstraint(validSince, validUntil, dateContext,
								sortedDateList);
						versionStringBuilder.append(timedConstraint);
						versionStringBuilder.append(HyVarRecExporter.BRACKETS_OPEN);

					}

					List<String> versionIds = new ArrayList<String>(validVersions.size());
					for (HyVersion version : validVersions) {
						versionIds.add(versionReconfiguratorIdMapping.get(version));
					}

					versionStringBuilder
							.append(getAlternativeRelation(featureReconfiguratorIdMapping.get(feature), versionIds));

					if (timedConstraint != null) {
						versionStringBuilder.append(HyVarRecExporter.BRACKETS_CLOSING);
					}

					versionConstraints.add(versionStringBuilder.toString());
				}
			}
		}

		return versionConstraints;
	}

	private List<String> getGroupConstraints(HyGroup group, Date date, Context dateContext, List<Date> sortedDateList)
			throws HyFeatureModelWellFormednessException {
		
		// TODO debugging code
		if(featureEndocing instanceof DwFeatureEncodingInteger)
		if(group.getId().equals("_79bac950-394a-4c75-9737-0b3fc7628d87") || group.getId().equals("_95c90063-9f66-4785-a0ad-574e2659b0b5") || group.getId().equals("_c66b60ea-4aa6-4422-bf38-292bfa921b30") || group.getId().equals("_07fed24a-c6fc-41b3-8aca-ad553767b0e0")) {
			System.out.println("Culprit group!");
		}
		
		List<String> featureModelConstraints = new ArrayList<String>();

		StringBuilder groupConstraintsStringBuilder = new StringBuilder();

		// Need to collect all dates in which the constraints are different

		Set<Date> relevantDatesSet = null;
		boolean considerOnlyOneDate = false;

		// With start index = -1, we capture the date before the first evolution step.
		int startIndexToIterate = -1;
		if (date != null) {
			relevantDatesSet = new HashSet<Date>(1);
			relevantDatesSet.add(date);
			considerOnlyOneDate = true;
			startIndexToIterate = 0;
		} else {
			relevantDatesSet = new HashSet<Date>();
			relevantDatesSet.addAll(HyEvolutionUtil.collectDates(group.getChildOf()));
			relevantDatesSet.addAll(HyEvolutionUtil.collectDates(group.getParentOf()));

		}

		// if there was no date, every since and until was null.
		if (relevantDatesSet.size() == 0) {
			considerOnlyOneDate = true;
		}

		// For each date at which something changes, create seperate constraints.
		List<Date> relevantDates = new ArrayList<Date>(relevantDatesSet);
		Collections.sort(relevantDates);

		// --------- add constraints for AND, OR, ALTERNATIVE groups

		// For group type constraints, group type dates and feature type dates are
		// relevant as well.

		if (date == null) {
			relevantDatesSet.addAll(HyEvolutionUtil.collectDates(group.getTypes()));

			for (HyGroupComposition groupComposition : group.getParentOf()) {
				for (HyFeature feature : groupComposition.getFeatures()) {
					relevantDatesSet.addAll(HyEvolutionUtil.collectDates(feature.getTypes()));
				}
			}

			relevantDates = new ArrayList<Date>(relevantDatesSet);
			Collections.sort(relevantDates);

			if (relevantDatesSet.size() == 0) {
				considerOnlyOneDate = true;
			} else {
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
			HyGroupComposition groupComposition = HyEvolutionUtil.getValidTemporalElement(group.getParentOf(),
					relevantDate);
			HyGroupType groupType = HyEvolutionUtil.getValidTemporalElement(group.getTypes(), relevantDate);

			// May happen if the first date is a from a validSince and we use minimum date.
			if (featureChild == null || groupComposition == null || groupType == null) {
				continue;
			}

			String parentFeatureId = featureReconfiguratorIdMapping.get(featureChild.getParent());

			String timedConstraint = null;

			if (!considerOnlyOneDate) {
				Date validSince;
				if (i == -1) {
					validSince = null;
				} else {
					validSince = relevantDate;
				}

				Date validUntil;
				if (i < relevantDates.size() - 1) {
					validUntil = relevantDates.get(i + 1);
				} else {
					validUntil = null;
				}

				timedConstraint = HyVarRecExporter.timedConstraint(validSince, validUntil, dateContext, sortedDateList);
			}

			List<HyFeature> validFeaturesOfGroupComposition = HyEvolutionUtil
					.getValidTemporalElements(groupComposition.getFeatures(), relevantDate);

			// check if more than one element in group

			List<String> childrenIds = new ArrayList<String>(validFeaturesOfGroupComposition.size());
			for (HyFeature childFeature : validFeaturesOfGroupComposition) {
				childrenIds.add(featureReconfiguratorIdMapping.get(childFeature));
			}

			switch (groupType.getType()) {
			case ALTERNATIVE:

				List<String> alternativeConstraints = getAlternativeRelation(parentFeatureId, childrenIds);

				for (String alternativeConstraint : alternativeConstraints) {
					groupConstraintsStringBuilder.append(alternativeConstraint);
					
					if (timedConstraint != null) {
						StringBuilder timedGroupConstraintStringBuilder = new StringBuilder(timedConstraint);
						timedGroupConstraintStringBuilder.append(HyVarRecExporter.BRACKETS_OPEN);
						timedGroupConstraintStringBuilder.append(groupConstraintsStringBuilder);
						timedGroupConstraintStringBuilder.append(HyVarRecExporter.BRACKETS_CLOSING);
						groupConstraintsStringBuilder = timedGroupConstraintStringBuilder;
					}
					
					featureModelConstraints.add(groupConstraintsStringBuilder.toString());
					
					groupConstraintsStringBuilder = new StringBuilder();
				}
				break;

			case AND:

				List<List<HyFeature>> splittedFeatures = HyFeatureUtil
						.splitFeaturesIntoMandatoryAndOptional(validFeaturesOfGroupComposition, relevantDate);
				List<HyFeature> mandatoryFeatures = splittedFeatures.get(0);
				List<HyFeature> optionalFeatures = splittedFeatures.get(1);

				// for all mandaotry feautres say: parent <-> (mand1 and mand2 ...)
				if (!mandatoryFeatures.isEmpty()) {
					groupConstraintsStringBuilder.append(featureEndocing.getFeatureSelected(parentFeatureId));

					groupConstraintsStringBuilder.append(HyVarRecExporter.EQUIVALENCE);

					if (mandatoryFeatures.size() > 1) {
						groupConstraintsStringBuilder.append(HyVarRecExporter.BRACKETS_OPEN);
					}

					boolean firstChildAnd = true;

					for (HyFeature mandatoryFeature : mandatoryFeatures) {
						// Constraints for mandatory features
						if (!firstChildAnd) {
							groupConstraintsStringBuilder.append(HyVarRecExporter.AND);
						} else {
							firstChildAnd = false;
						}

						groupConstraintsStringBuilder.append(featureEndocing
								.getFeatureSelected(featureReconfiguratorIdMapping.get(mandatoryFeature)));
					}

					if (mandatoryFeatures.size() > 1) {
						groupConstraintsStringBuilder.append(HyVarRecExporter.BRACKETS_CLOSING);
					}

					if (timedConstraint != null) {
						StringBuilder timedGroupConstraintStringBuilder = new StringBuilder(timedConstraint);
						timedGroupConstraintStringBuilder.append(HyVarRecExporter.BRACKETS_OPEN);
						timedGroupConstraintStringBuilder.append(groupConstraintsStringBuilder);
						timedGroupConstraintStringBuilder.append(HyVarRecExporter.BRACKETS_CLOSING);
						groupConstraintsStringBuilder = timedGroupConstraintStringBuilder;
					}

					featureModelConstraints.add(groupConstraintsStringBuilder.toString());
					
					if(groupConstraintsStringBuilder.toString().startsWith("feature[_b8ad13a0-942d-4b5e-b342-ce532c45d595]) impl feature[_9f51cd08-3c94-4e5d-a212-2c2e6a6fa5b3]")) {
						System.err.println("Here is the bug!");
					}

					groupConstraintsStringBuilder = new StringBuilder();
				}

				// For all optional features, say (opt1 or opt2...) -> parent
				if (!optionalFeatures.isEmpty()) {

					if (optionalFeatures.size() > 1) {
						groupConstraintsStringBuilder.append(HyVarRecExporter.BRACKETS_OPEN);
					}

					boolean firstChildAnd = true;
					for (HyFeature optionalFeature : optionalFeatures) {
						// Constraints for mandatory features
						if (!firstChildAnd) {
							groupConstraintsStringBuilder.append(HyVarRecExporter.OR);
						} else {
							firstChildAnd = false;
						}

						groupConstraintsStringBuilder.append(featureEndocing
								.getFeatureSelected(featureReconfiguratorIdMapping.get(optionalFeature)));
					}

					if (optionalFeatures.size() > 1) {
						groupConstraintsStringBuilder.append(HyVarRecExporter.BRACKETS_CLOSING);
					}

					groupConstraintsStringBuilder.append(HyVarRecExporter.IMPLICATION);

					groupConstraintsStringBuilder.append(featureEndocing.getFeatureSelected(parentFeatureId));

					if (timedConstraint != null) {
						StringBuilder timedGroupConstraintStringBuilder = new StringBuilder(timedConstraint);
						timedGroupConstraintStringBuilder.append(HyVarRecExporter.BRACKETS_OPEN);
						timedGroupConstraintStringBuilder.append(groupConstraintsStringBuilder);
						timedGroupConstraintStringBuilder.append(HyVarRecExporter.BRACKETS_CLOSING);
						groupConstraintsStringBuilder = timedGroupConstraintStringBuilder;
					}

					featureModelConstraints.add(groupConstraintsStringBuilder.toString());

					groupConstraintsStringBuilder = new StringBuilder();
				}

				break;
			case OR:

				groupConstraintsStringBuilder.append(getOrRelation(parentFeatureId, childrenIds));
				if (timedConstraint != null) {
					StringBuilder timedGroupConstraintStringBuilder = new StringBuilder(timedConstraint);
					timedGroupConstraintStringBuilder.append(HyVarRecExporter.BRACKETS_OPEN);
					timedGroupConstraintStringBuilder.append(groupConstraintsStringBuilder);
					timedGroupConstraintStringBuilder.append(HyVarRecExporter.BRACKETS_CLOSING);
					groupConstraintsStringBuilder = timedGroupConstraintStringBuilder;
				}

				featureModelConstraints.add(groupConstraintsStringBuilder.toString());
				
				groupConstraintsStringBuilder = new StringBuilder();
				
				break;

			}

		}

		return featureModelConstraints;
	}

	protected String getOrRelation(String parentId, List<String> childrenIds) {
		StringBuilder orStringBuilder = new StringBuilder(parentId);

		orStringBuilder.append(HyVarRecExporter.EQUIVALENCE);

		orStringBuilder.append(HyVarRecExporter.BRACKETS_OPEN);

		boolean first = true;
		for (String childId : childrenIds) {
			if (first) {
				first = false;
			} else {
				orStringBuilder.append(HyVarRecExporter.OR);
			}

			orStringBuilder.append(childId);
		}

		orStringBuilder.append(HyVarRecExporter.BRACKETS_CLOSING);
		return orStringBuilder.toString();
	}
}
