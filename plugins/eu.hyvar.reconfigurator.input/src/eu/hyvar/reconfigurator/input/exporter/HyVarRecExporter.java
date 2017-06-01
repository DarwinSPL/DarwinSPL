package eu.hyvar.reconfigurator.input.exporter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.context.HyContextualInformationBoolean;
import eu.hyvar.context.HyContextualInformationEnum;
import eu.hyvar.context.HyContextualInformationNumber;
import eu.hyvar.context.contextValidity.HyAttributeValidityFormula;
import eu.hyvar.context.contextValidity.HyFeatureValidityFormula;
import eu.hyvar.context.contextValidity.HyValidityFormula;
import eu.hyvar.context.contextValidity.HyValidityModel;
import eu.hyvar.context.information.contextValue.HyContextValue;
import eu.hyvar.context.information.contextValue.HyContextValueModel;
import eu.hyvar.dataValues.HyBooleanValue;
import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.dataValues.HyEnumValue;
import eu.hyvar.dataValues.HyNumberValue;
import eu.hyvar.dataValues.HyValue;
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
import eu.hyvar.feature.configuration.HyAttributeValueAssignment;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.HyConfigurationElement;
import eu.hyvar.feature.configuration.HyFeatureSelected;
import eu.hyvar.feature.configuration.HyVersionSelected;
import eu.hyvar.feature.constraint.HyConstraint;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.expression.HyExpressionFactory;
import eu.hyvar.feature.expression.HyFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyImpliesExpression;
import eu.hyvar.feature.expression.util.HyExpressionStringExporter;
import eu.hyvar.feature.expression.util.HyExpressionStringExporter.BooleanRepresentationOption;
import eu.hyvar.feature.expression.util.HyExpressionStringExporter.FeatureSelectionRepresentationOption;
import eu.hyvar.feature.expression.util.HyExpressionStringExporter.VersionRepresentation;
import eu.hyvar.feature.util.HyFeatureModelWellFormednessException;
import eu.hyvar.feature.util.HyFeatureUtil;
import eu.hyvar.preferences.HyPreference;
import eu.hyvar.preferences.HyProfile;
import eu.hyvar.reconfigurator.input.format.Attribute;
import eu.hyvar.reconfigurator.input.format.AttributeValue;
import eu.hyvar.reconfigurator.input.format.Configuration;
import eu.hyvar.reconfigurator.input.format.Context;
import eu.hyvar.reconfigurator.input.format.InputForHyVarRec;

public class HyVarRecExporter {

	private Gson gson;

	// private static final String NEW_LINE ="\n";
	// private static final String TABULATOR = "\t";
	//
	// private static final String FEATURE_NUM = "FEATURE_NUM";
	// private static final String ATTRIBUTES_NUM = "ATTRIBUTES_NUM";
	// private static final String CONTEXT_NUM = "CONTEXT_NUM";
	// private static final String DOMAIN_ATTRIBUTES = "DOMAIN_ATTRIBUTES";
	// private static final String DOMAIN_CONTEXT = "DOMAIN_CONTEXT";
	// private static final String INITIAL_FEATURES = "INITIAL_FEATURES";
	// private static final String INITIAL_ATTRIBUTES = "INITIAL_ATTRIBUTES";
	// private static final String LIST_SEPARATOR = " , ";

	private static final String FEATURE_ATOM = "feature[";
	private static final String VERSION_ATOM = "feature[";
	private static final String ATTRIBUTE_ATOM = "attribute[";
	private static final String CONTEXT_ATOM = "context[";

	private static final String EQUALS = " = ";
	private static final String NOT_EQUALS = " != ";
	private static final String GREATER = " > ";
	private static final String LESS = " < ";
	private static final String GEQ = " >= ";
	private static final String LEQ = " <= ";

	private static final String IMPLICATION = " impl ";
	private static final String OR = " or ";
	private static final String XOR = " xor ";
	private static final String AND = " and ";
	private static final String NOT = " not ";

	private static final String MAX = "max";
	private static final String MIN = "min";

	private static final String NEGATION = " - ";
	private static final String ADDITION = " + ";
	private static final String SUBTRACTION = " - ";
	private static final String MULTIPLICATION = " * ";

	private static final String TRUE = "true";
	private static final String FALSE = "false";

	private static final String ARRAY_BRACKETS_OPEN = "[";
	private static final String ARRAY_BRACKETS_CLOSING = "]";

	private static final String BRACKETS_OPEN = "(";
	private static final String BRACKETS_CLOSING = ")";

	private static final String WHITESPACE = " ";

	private HyExpressionStringExporter expressionExporter;

	private Map<HyFeature, String> featureReconfiguratorIdMapping;
	private Map<HyVersion, String> versionReconfiguratorIdMapping;
	private Map<HyContextualInformation, String> contextReconfiguratorIdMapping;
	private Map<HyFeatureAttribute, String> attributeReconfiguratorIdMapping;

	private ReconfiguratorIdMapping reconfiguratorIdMapping;

	public HyVarRecExporter() {
		// featureReconfiguratorIdMapping = new HashMap<HyFeature, String>();
		// versionReconfiguratorIdMapping = new HashMap<HyVersion, String>();
		// contextReconfiguratorIdMapping = new HashMap<HyContextualInformation,
		// String>();
		// attributeReconfiguratorIdMapping = new HashMap<HyFeatureAttribute,
		// String>();
		// expressionExporter = null;
	}
	
	private static void initializeEmptyHyVarRecInput(InputForHyVarRec input) {
		if(input == null) {
			return;
		}
		
		input.setAttributes(new ArrayList<Attribute>());
		
		Configuration emptyConfig = new Configuration();
		emptyConfig.setAttributeValues(new ArrayList<AttributeValue>());
		input.setConfiguration(emptyConfig);
		
		input.setConstraints(new ArrayList<String>());
		
		input.setContexts(new ArrayList<Context>());
		
		input.setPreferences(new ArrayList<String>());
	}

	public String exportContextMappingModel(HyContextModel contextModel, HyValidityModel contextValidityModel,
			HyFeatureModel featureModel, HyConstraintModel constraintModel, HyConfiguration oldConfiguration,
			HyProfile preferenceModel, HyContextValueModel contextValues, Date date) {

		// FIXME check for invalidities

		if (featureModel == null) {
			return null;
		}

		reconfiguratorIdMapping = new ReconfiguratorIdMapping(featureModel, contextModel);

		featureReconfiguratorIdMapping = reconfiguratorIdMapping.getFeatureIdMapping();
		versionReconfiguratorIdMapping = reconfiguratorIdMapping.getVersionIdMapping();
		contextReconfiguratorIdMapping = reconfiguratorIdMapping.getContextIdMapping();
		attributeReconfiguratorIdMapping = reconfiguratorIdMapping.getAttributeIdMapping();

		expressionExporter = new HyExpressionStringExporter(reconfiguratorIdMapping.getFeatureIdMapping(),
				reconfiguratorIdMapping.getVersionIdMapping(), reconfiguratorIdMapping.getAttributeIdMapping(),
				reconfiguratorIdMapping.getContextIdMapping(), BooleanRepresentationOption.ONEZERO,
				FeatureSelectionRepresentationOption.ONEZERO, VersionRepresentation.AS_ONEZERO_FEATURES, true, true);

		InputForHyVarRec input = new InputForHyVarRec();
		initializeEmptyHyVarRecInput(input);

		// gson = new Gson();
		gson = new GsonBuilder().disableHtmlEscaping().create();

		input.setAttributes(getExportedAttributes(featureModel, date));
		if(contextModel != null) {
			input.setContexts(getExportedContexts(contextModel, date));			
		}
		if(oldConfiguration != null) {
			input.setConfiguration(getExportedConfiguration(oldConfiguration, contextValues));			
		}

		try {
			input.setConstraints(getFeatureModelConstraints(featureModel, date));
		} catch (HyFeatureModelWellFormednessException e) {
			System.err.println("Could not create constraints of FM, as FM is not well-formed");
			e.printStackTrace();
			return null;
		}

		if (constraintModel != null) {
			input.getConstraints().addAll(getConstraints(constraintModel, date));
		}

		if (contextValidityModel != null) {
			input.getConstraints().addAll(getContextValidityFormulas(contextValidityModel, date));
		}

		if (preferenceModel != null) {
			input.setPreferences(getPreferences(preferenceModel, date));
		}


		// File output. Not necessary for HyVar in the end. Only for Isola Paper
//		BufferedWriter writer = null;
//		try {
//			// create a temporary file
//			File inputForHyVarRecJsonFile = new File("InputForHyVarRec.json");
//
//			// This will output the full path where the file will be written
//			// to...
//			System.out.println(inputForHyVarRecJsonFile.getCanonicalPath());
//			System.out.println(gson.toJson(input));
//
//			writer = new BufferedWriter(new FileWriter(inputForHyVarRecJsonFile));
//			writer.write(gson.toJson(input));
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				// Close the writer regardless of what happens.
//				writer.close();
//			} catch (IOException e) {
//			}
//		}

		// DEBUG output

//		try {
//			// create a temporary file
//			File debugFile = new File("Debug.log");
//
//			StringBuilder sb = new StringBuilder();
//
//			for (HyFeature feature : featureReconfiguratorIdMapping.keySet()) {
//
//				sb.append(featureReconfiguratorIdMapping.get(feature));
//				sb.append(" : ");
//				sb.append(HyEvolutionUtil.getValidTemporalElement(feature.getNames(), date).getName());
//				sb.append(System.lineSeparator());
//
//				for (HyFeatureAttribute attribute : feature.getAttributes()) {
//
//					sb.append(attributeReconfiguratorIdMapping.get(attribute));
//					sb.append(" : ");
//					sb.append(HyEvolutionUtil.getValidTemporalElement(attribute.getNames(), date).getName());
//					sb.append(System.lineSeparator());
//
//					if (attribute instanceof HyEnumAttribute) {
//						for (HyEnumLiteral literal : ((HyEnumAttribute) attribute).getEnumType().getLiterals()) {
//							sb.append(literal.getValue());
//							sb.append(" : ");
//							sb.append(literal.getName());
//							sb.append(System.lineSeparator());
//						}
//					}
//				}
//				
//				for(HyVersion version: feature.getVersions()) {
//					sb.append(versionReconfiguratorIdMapping.get(version));
//					sb.append(" : ");
//					sb.append(version.getNumber());
//					sb.append(System.lineSeparator());
//				}
//			}
//
//			for (HyContextualInformation context : contextModel.getContextualInformations()) {
//				sb.append(contextReconfiguratorIdMapping.get(context));
//				sb.append(" : ");
//				sb.append(context.getName());
//				sb.append(System.lineSeparator());
//
//				if (context instanceof HyContextualInformationEnum) {
//					for (HyEnumLiteral literal : ((HyContextualInformationEnum) context).getEnumType().getLiterals()) {
//						sb.append(literal.getValue());
//						sb.append(" : ");
//						sb.append(literal.getName());
//						sb.append(System.lineSeparator());
//					}
//				}
//			}
//
//			writer = new BufferedWriter(new FileWriter(debugFile));
//			writer.write(sb.toString());
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				// Close the writer regardless of what happens.
//				writer.close();
//			} catch (IOException e) {
//			}
//		}

		return gson.toJson(input);
	}

	private eu.hyvar.reconfigurator.input.format.Configuration getExportedConfiguration(
			HyConfiguration oldConfiguration, HyContextValueModel contextValueModel) {
		eu.hyvar.reconfigurator.input.format.Configuration exportedConfiguration = new eu.hyvar.reconfigurator.input.format.Configuration();

		if (oldConfiguration != null) {
			exportedConfiguration.setSelectedFeatures(getSelectedFeatureIds(oldConfiguration));
			exportedConfiguration.setAttributeValues(getFeatureAttributeValues(oldConfiguration));
		}

		if (contextValueModel != null) {
			exportedConfiguration.setContextValues(getContextValues(contextValueModel));
		}

		return exportedConfiguration;
	}

	private List<eu.hyvar.reconfigurator.input.format.ContextValue> getContextValues(
			HyContextValueModel contextValueModel) {
		List<eu.hyvar.reconfigurator.input.format.ContextValue> exportedContextValues = new ArrayList<eu.hyvar.reconfigurator.input.format.ContextValue>();

		for (HyContextValue contextValue : contextValueModel.getValues()) {
			eu.hyvar.reconfigurator.input.format.ContextValue exportedContextValue = new eu.hyvar.reconfigurator.input.format.ContextValue();

			exportedContextValue.setId(contextReconfiguratorIdMapping.get(contextValue.getContext()));
			exportedContextValue.setValue(exportValue(contextValue.getValue()));

			exportedContextValues.add(exportedContextValue);
		}

		return exportedContextValues;
	}

	private Integer exportValue(HyValue value) {
		if (value instanceof HyNumberValue) {
			return ((HyNumberValue) value).getValue();
		} else if (value instanceof HyBooleanValue) {
			if (((HyBooleanValue) value).isValue()) {
				return 1;
			} else {
				return 0;
			}
		} else if (value instanceof HyEnumValue) {
			HyEnumValue enumValue = (HyEnumValue) value;
			return enumValue.getEnumLiteral().getValue();
		}

		return 0;
	}

	private List<String> getSelectedFeatureIds(HyConfiguration oldConfiguration) {
		List<String> initialFeatureIds = new ArrayList<String>();

		for (HyConfigurationElement configurationElement : oldConfiguration.getElements()) {
			if (configurationElement instanceof HyFeatureSelected) {
				// Add selected features

				initialFeatureIds.add(featureReconfiguratorIdMapping
						.get(((HyFeatureSelected) configurationElement).getSelectedFeature()));

			} else if (configurationElement instanceof HyVersionSelected) {
				initialFeatureIds.add(versionReconfiguratorIdMapping
						.get(((HyVersionSelected) configurationElement).getSelectedVersion()));
			}
		}

		return initialFeatureIds;
	}

	/**
	 * TODO working?
	 * 
	 * @param oldConfiguration
	 * @return Map where key is attribute[attributeID] and value is value
	 *         assignment
	 */
	private List<eu.hyvar.reconfigurator.input.format.AttributeValue> getFeatureAttributeValues(
			HyConfiguration oldConfiguration) {
		List<eu.hyvar.reconfigurator.input.format.AttributeValue> exportedAttributeValues = new ArrayList<eu.hyvar.reconfigurator.input.format.AttributeValue>();

		// Check if configuration element is attribute value
		for (HyConfigurationElement configEle : oldConfiguration.getElements()) {
			if (configEle instanceof HyAttributeValueAssignment) {
				HyAttributeValueAssignment hyAttributeValueAssignment = (HyAttributeValueAssignment) configEle;
				// Fill the map with the attribute and the corresponding value
				Integer intValue = 0;
				HyValue value = hyAttributeValueAssignment.getValue();
				HyFeatureAttribute attribute = hyAttributeValueAssignment.getAttribute();

				if (value == null) {
					// default values
					if (attribute instanceof HyNumberAttribute) {
						intValue = ((HyNumberAttribute) attribute).getDefault();
					} else if (attribute instanceof HyEnumAttribute) {
						HyEnumAttribute enumAttribute = (HyEnumAttribute) attribute;
						intValue = enumAttribute.getDefault().getValue();
					} else if (attribute instanceof HyBooleanAttribute) {
						if (((HyBooleanAttribute) attribute).isDefault()) {
							intValue = 1;
						} else {
							intValue = 0;
						}
					} else {
						intValue = 0;
						System.err.println("Unsupported Attribute Type");
					}
				} else {
					if (value instanceof HyNumberValue) {
						intValue = ((HyNumberValue) value).getValue();
					} else if (value instanceof HyEnumValue) {
						intValue = ((HyEnumValue) value).getEnumLiteral().getValue();
					} else if (value instanceof HyBooleanValue) {
						if (((HyBooleanValue) value).isValue()) {
							intValue = 1;
						} else {
							intValue = 0;
						}
					} else {
						intValue = 0;
						System.err.println("Unsupported HyValue");
					}
				}

				eu.hyvar.reconfigurator.input.format.AttributeValue exportedAttributeValue = new eu.hyvar.reconfigurator.input.format.AttributeValue();
				exportedAttributeValue.setId(attributeReconfiguratorIdMapping.get(attribute));
				exportedAttributeValue.setValue(intValue);

				exportedAttributeValues.add(exportedAttributeValue);
			}
		}

		return exportedAttributeValues;
	}

	private List<eu.hyvar.reconfigurator.input.format.Attribute> getExportedAttributes(HyFeatureModel featureModel,
			Date date) {
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
					DomainTuple<Integer> domain = getEnumDomain(enumAttribute.getEnumType());
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

	private List<eu.hyvar.reconfigurator.input.format.Context> getExportedContexts(HyContextModel contextModel,
			Date date) {
		List<eu.hyvar.reconfigurator.input.format.Context> exportedContexts = new ArrayList<eu.hyvar.reconfigurator.input.format.Context>();

		for (HyContextualInformation context : HyEvolutionUtil
				.getValidTemporalElements(contextModel.getContextualInformations(), date)) {

			int min = 0;
			int max = 0;

			if (context instanceof HyContextualInformationBoolean) {
				min = 0;
				max = 1;
			} else if (context instanceof HyContextualInformationNumber) {
				HyContextualInformationNumber numberContext = (HyContextualInformationNumber) context;

				min = numberContext.getMin();
				max = numberContext.getMax();
			} else if (context instanceof HyContextualInformationEnum) {
				HyContextualInformationEnum enumContext = (HyContextualInformationEnum) context;
				DomainTuple<Integer> domain = getEnumDomain(enumContext.getEnumType());
				min = domain.getMin();
				max = domain.getMax();
			}

			eu.hyvar.reconfigurator.input.format.Context exportedContext = new eu.hyvar.reconfigurator.input.format.Context();
			exportedContext.setId(contextReconfiguratorIdMapping.get(context));
			exportedContext.setMin(min);
			exportedContext.setMax(max);

			exportedContexts.add(exportedContext);
		}

		return exportedContexts;
	}

	private DomainTuple<Integer> getEnumDomain(HyEnum hyEnum) {

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		// Assuming that enumValues are consistent
		for (HyEnumLiteral enumLiteral : hyEnum.getLiterals()) {
			int value = enumLiteral.getValue();
			if (value < min) {
				min = value;
			}
			if (value > max) {
				max = value;
			}
		}

		DomainTuple<Integer> domain = new DomainTuple<Integer>();
		domain.setMax(max);
		domain.setMin(min);
		return domain;
	}

	private List<String> getFeatureModelConstraints(HyFeatureModel featureModel, Date date) throws HyFeatureModelWellFormednessException {
		List<String> featureModelConstraints = new ArrayList<String>();

		StringBuilder rootFeatureConstraint = new StringBuilder();

		// Root feature has to be selected
		HyRootFeature rootFeature = HyEvolutionUtil.getValidTemporalElement(featureModel.getRootFeature(), date);
		rootFeatureConstraint.append(featureReconfiguratorIdMapping.get(rootFeature.getFeature()));
		rootFeatureConstraint.append(EQUALS);
		rootFeatureConstraint.append(1);

		featureModelConstraints.add(rootFeatureConstraint.toString());

		featureModelConstraints.addAll(getFeatureConstraints(rootFeature.getFeature(), true, date));

		featureModelConstraints.addAll(getFeatureModelVersionConstraints(featureModel, date));

		return featureModelConstraints;
	}

	private List<String> getFeatureModelVersionConstraints(HyFeatureModel featureModel, Date date) {
		List<String> versionConstraints = new ArrayList<String>();

		// f feature, f_1 - f_n feature versions
		// f = (f_1 + ... + f_n)
		for (HyFeature feature : HyEvolutionUtil.getValidTemporalElements(featureModel.getFeatures(), date)) {
			List<HyVersion> versions = HyEvolutionUtil.getValidTemporalElements(feature.getVersions(), date);
			if (!versions.isEmpty()) {
				StringBuilder versionStringBuilder = new StringBuilder();

				versionStringBuilder.append(featureReconfiguratorIdMapping.get(feature));
				versionStringBuilder.append(EQUALS);
				versionStringBuilder.append(BRACKETS_OPEN);

				boolean first = true;
				for (HyVersion version : versions) {
					if (!first) {
						versionStringBuilder.append(ADDITION);
					} else {
						first = false;
					}

					versionStringBuilder.append(versionReconfiguratorIdMapping.get(version));
				}
				versionStringBuilder.append(BRACKETS_CLOSING);
				versionConstraints.add(versionStringBuilder.toString());
			}
		}

		return versionConstraints;
	}

	private List<String> getFeatureConstraints(HyFeature feature, boolean isRoot, Date date) throws HyFeatureModelWellFormednessException {
		List<String> featureModelConstraints = new ArrayList<String>();

		List<HyFeatureChild> featureChildren = HyEvolutionUtil.getValidTemporalElements(feature.getParentOf(), date);
		for (HyFeatureChild featureChild : featureChildren) {
			featureModelConstraints.addAll(getGroupConstraints(featureChild.getChildGroup(),
					featureReconfiguratorIdMapping.get(feature), isRoot, date));
		}

		return featureModelConstraints;
	}

	private List<String> getGroupConstraints(HyGroup group, String parentFeatureId, boolean parentIsRoot, Date date) throws HyFeatureModelWellFormednessException {
		List<String> featureModelConstraints = new ArrayList<String>();

		StringBuilder groupConstraintsStringBuilder = new StringBuilder();

		HyGroupComposition groupComposition = HyEvolutionUtil.getValidTemporalElement(group.getParentOf(), date);
		List<HyFeature> validFeaturesOfGroupComposition = HyEvolutionUtil
				.getValidTemporalElements(groupComposition.getFeatures(), date);

		if (!parentIsRoot) {
			// Require parent for each child
			// groupConstraintsStringBuilder.append(TABULATOR);
			groupConstraintsStringBuilder.append(BRACKETS_OPEN);

			boolean first = true;
			for (HyFeature feature : validFeaturesOfGroupComposition) {
				if (!first) {
					groupConstraintsStringBuilder.append(OR);
				} else {
					first = false;
				}

				groupConstraintsStringBuilder.append(featureReconfiguratorIdMapping.get(feature));
				groupConstraintsStringBuilder.append(EQUALS);
				groupConstraintsStringBuilder.append(1);
			}
			groupConstraintsStringBuilder.append(BRACKETS_CLOSING);

			groupConstraintsStringBuilder.append(IMPLICATION);
			groupConstraintsStringBuilder.append(parentFeatureId);
			groupConstraintsStringBuilder.append(EQUALS);
			groupConstraintsStringBuilder.append(1);

			featureModelConstraints.add(groupConstraintsStringBuilder.toString());
			groupConstraintsStringBuilder = new StringBuilder();
		}

		// Check Type of group and set according constraints

		HyGroupType groupType = HyEvolutionUtil.getValidTemporalElement(group.getTypes(), date);

		// check if more than one element in group
		if (validFeaturesOfGroupComposition.size() > 1) {
			switch(groupType.getType()) {
			case ALTERNATIVE:
				groupConstraintsStringBuilder.append(parentFeatureId);
				groupConstraintsStringBuilder.append(EQUALS);
				groupConstraintsStringBuilder.append(1);
				groupConstraintsStringBuilder.append(IMPLICATION);
				groupConstraintsStringBuilder.append(BRACKETS_OPEN);

				// The sum of all children
				boolean first = true;
				for (HyFeature childFeature : validFeaturesOfGroupComposition) {
					if (!first) {
						groupConstraintsStringBuilder.append(ADDITION);
					} else {
						first = false;
					}

					groupConstraintsStringBuilder.append(featureReconfiguratorIdMapping.get(childFeature));
				}

				// is equal to 1
				groupConstraintsStringBuilder.append(EQUALS);
				groupConstraintsStringBuilder.append(1);
				groupConstraintsStringBuilder.append(BRACKETS_CLOSING);
				
				break;
			case AND:
				
				// Check if only optional features are in groups -> no constraint necessary
				if(HyFeatureUtil.getNumberOfMandatoryFeatures(validFeaturesOfGroupComposition, date) == 0) {
					break;
				}
				
				groupConstraintsStringBuilder.append(parentFeatureId);
				groupConstraintsStringBuilder.append(EQUALS);
				groupConstraintsStringBuilder.append(1);
				groupConstraintsStringBuilder.append(IMPLICATION);
				groupConstraintsStringBuilder.append(BRACKETS_OPEN);

				boolean firstChildAnd = true;

				for (HyFeature feature : validFeaturesOfGroupComposition) {
					// Constraints for mandatory features
					if (HyFeatureUtil.isMandatory(feature, date)) {
						if (!firstChildAnd) {
							groupConstraintsStringBuilder.append(AND);
						} else {
							firstChildAnd = false;
						}

						groupConstraintsStringBuilder.append(featureReconfiguratorIdMapping.get(feature));
						groupConstraintsStringBuilder.append(EQUALS);
						groupConstraintsStringBuilder.append(1);
					}
				}
				
				groupConstraintsStringBuilder.append(BRACKETS_CLOSING);
				break;
			case OR:
				
				groupConstraintsStringBuilder.append(parentFeatureId);
				groupConstraintsStringBuilder.append(EQUALS);
				groupConstraintsStringBuilder.append(1);
				groupConstraintsStringBuilder.append(IMPLICATION);
				groupConstraintsStringBuilder.append(BRACKETS_OPEN);

				boolean firstChildOr = true;

				for (HyFeature feature : validFeaturesOfGroupComposition) {
					if (!firstChildOr) {
						groupConstraintsStringBuilder.append(OR);
					} else {
						firstChildOr = false;
					}

					groupConstraintsStringBuilder.append(featureReconfiguratorIdMapping.get(feature));
					groupConstraintsStringBuilder.append(EQUALS);
					groupConstraintsStringBuilder.append(1);
				}

				groupConstraintsStringBuilder.append(BRACKETS_CLOSING);
				break;
			
			}
			
			if (!groupConstraintsStringBuilder.toString().equals("")) {
				featureModelConstraints.add(groupConstraintsStringBuilder.toString());
				groupConstraintsStringBuilder = new StringBuilder();
			}
		} 
		else {
			for (HyFeature feature : validFeaturesOfGroupComposition) {
				if (HyFeatureUtil.isMandatory(feature, date)) {
					// groupConstraintsStringBuilder.append(TABULATOR);
					// Mandatory Constraint (Parent => Child)
					groupConstraintsStringBuilder.append(parentFeatureId);
					groupConstraintsStringBuilder.append(EQUALS);
					groupConstraintsStringBuilder.append(1);
					groupConstraintsStringBuilder.append(IMPLICATION);
					groupConstraintsStringBuilder.append(featureReconfiguratorIdMapping.get(feature));
					groupConstraintsStringBuilder.append(EQUALS);
					groupConstraintsStringBuilder.append(1);

					featureModelConstraints.add(groupConstraintsStringBuilder.toString());
					groupConstraintsStringBuilder = new StringBuilder();
				}
			}
		}

		for (HyFeature feature : validFeaturesOfGroupComposition) {
			featureModelConstraints.addAll(getFeatureConstraints(feature, false, date));
		}

		return featureModelConstraints;
	}

	private List<String> getConstraints(HyConstraintModel constraintModel, Date date) {
		List<String> constraints = new ArrayList<String>();

		for (HyConstraint constraint : HyEvolutionUtil.getValidTemporalElements(constraintModel.getConstraints(),
				date)) {
			constraints.add(getConstraint(constraint));
		}

		return constraints;
	}

	private String getConstraint(HyConstraint constraint) {

		return expressionExporter.exportExpressionToString(constraint.getRootExpression());
	}

	private List<String> getPreferences(HyProfile preferenceModel, Date date) {
		List<String> preferences = new ArrayList<String>();

		for (HyPreference preference : HyEvolutionUtil.getValidTemporalElements(preferenceModel.getPreferences(),
				date)) {
			preferences.add(getPreference(preference));
		}

		return preferences;
	}

	private String getPreference(HyPreference preference) {
		return expressionExporter.exportExpressionToString(preference.getRootExpression());
	}

	private List<String> getContextValidityFormulas(HyValidityModel validityModel, Date date) {
		List<String> validityFormulas = new ArrayList<String>();

		for (HyValidityFormula contextMapping : HyEvolutionUtil
				.getValidTemporalElements(validityModel.getValidityFormulas(), date)) {
			validityFormulas.add(getValidityFormulaAsConstraint(contextMapping));
		}

		return validityFormulas;
	}

	private String getValidityFormulaAsConstraint(HyValidityFormula contextMapping) {
		StringBuilder contextMappingString = new StringBuilder();

		if (contextMapping instanceof HyFeatureValidityFormula) {
			HyFeatureValidityFormula featureValidityFormula = (HyFeatureValidityFormula) contextMapping;
			HyImpliesExpression featureImpliesValidityFormulaExpression = HyExpressionFactory.eINSTANCE
					.createHyImpliesExpression();

			HyFeatureReferenceExpression featureReferenceExpression = HyExpressionFactory.eINSTANCE
					.createHyFeatureReferenceExpression();
			featureReferenceExpression.setFeature(featureValidityFormula.getFeature());

			featureImpliesValidityFormulaExpression.setOperand1(featureReferenceExpression);
			featureImpliesValidityFormulaExpression
					.setOperand2(EcoreUtil.copy(featureValidityFormula.getValidityFormula()));

			contextMappingString
					.append(expressionExporter.exportExpressionToString(featureImpliesValidityFormulaExpression));
		} else if (contextMapping instanceof HyAttributeValidityFormula) {
			HyAttributeValidityFormula attributeValidityFormula = (HyAttributeValidityFormula) contextMapping;
			HyImpliesExpression featureImpliesValidityFormulaExpression = HyExpressionFactory.eINSTANCE
					.createHyImpliesExpression();

			HyFeatureReferenceExpression featureReferenceExpression = HyExpressionFactory.eINSTANCE
					.createHyFeatureReferenceExpression();
			featureReferenceExpression.setFeature(attributeValidityFormula.getAttribute().getFeature());

			featureImpliesValidityFormulaExpression.setOperand1(featureReferenceExpression);
			featureImpliesValidityFormulaExpression
					.setOperand2(EcoreUtil.copy(attributeValidityFormula.getValidityFormula()));

			contextMappingString
					.append(expressionExporter.exportExpressionToString(featureImpliesValidityFormulaExpression));
		}

		// contextMappingString.append(expressionExporter.exportExpressionToString(contextMapping.getValidityFormula()));

		return contextMappingString.toString();
	}

}