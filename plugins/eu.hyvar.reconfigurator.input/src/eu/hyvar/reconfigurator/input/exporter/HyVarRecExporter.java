package eu.hyvar.reconfigurator.input.exporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.context.contextValidity.HyValidityModel;
import eu.hyvar.context.information.contextValue.HyContextValueModel;
import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.evolution.HyTemporalElement;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.expression.HyExpression;
import eu.hyvar.feature.expression.util.HyExpressionStringExporter;
import eu.hyvar.feature.expression.util.HyExpressionStringExporter.BooleanRepresentationOption;
import eu.hyvar.feature.expression.util.HyExpressionStringExporter.FeatureSelectionRepresentationOption;
import eu.hyvar.feature.expression.util.HyExpressionStringExporter.VersionRepresentation;
import eu.hyvar.feature.util.HyFeatureModelWellFormednessException;
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

	public static final String FEATURE_ATOM = "feature[";
	public static final String VERSION_ATOM = "feature[";
	public static final String ATTRIBUTE_ATOM = "attribute[";
	public static final String CONTEXT_ATOM = "context[";

	public static final String EQUALS = " = ";
	public static final String NOT_EQUALS = " != ";
	public static final String GREATER = " > ";
	public static final String LESS = " < ";
	public static final String GEQ = " >= ";
	public static final String LEQ = " <= ";

	public static final String IMPLICATION = " impl ";
	public static final String OR = " or ";
	public static final String XOR = " xor ";
	public static final String AND = " and ";
	public static final String NOT = " not ";

	public static final String MAX = "max";
	public static final String MIN = "min";

	public static final String NEGATION = " - ";
	public static final String ADDITION = " + ";
	public static final String SUBTRACTION = " - ";
	public static final String MULTIPLICATION = " * ";

	public static final String TRUE = "true";
	public static final String FALSE = "false";

	public static final String ARRAY_BRACKETS_OPEN = "[";
	public static final String ARRAY_BRACKETS_CLOSING = "]";

	public static final String BRACKETS_OPEN = "(";
	public static final String BRACKETS_CLOSING = ")";

	public static final String WHITESPACE = " ";
	
	public static final String EVOLUTION_CONTEXT_ID = "_evolution-context";

	private HyExpressionStringExporter expressionExporter;

	private Map<HyFeature, String> featureReconfiguratorIdMapping;
	private Map<HyVersion, String> versionReconfiguratorIdMapping;
	private Map<HyContextualInformation, String> contextReconfiguratorIdMapping;
	private Map<HyFeatureAttribute, String> attributeReconfiguratorIdMapping;

	private ReconfiguratorIdMapping reconfiguratorIdMapping;

	private DwFeatureModelExporter featureModelExporter;
	private DwConfigurationExporter configurationExporter;
	private DwConstraintExporter constraintExporter;
	private DwPreferenceExporter preferenceExporter;
	private DwValidityFormulaExporter validityFormulaExporter;
	private DwContextExporter contextExporter;

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
		if (input == null) {
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

	public String exportSPL(HyContextModel contextModel, HyValidityModel contextValidityModel,
			HyFeatureModel featureModel, HyConstraintModel constraintModel, HyConfiguration oldConfiguration,
			HyProfile preferenceModel, HyContextValueModel contextValues, Date date) {

		// TODO incorporate MSPL stuff

		if (featureModel == null) {
			return null;
		}

		// Create mappings from model elements to IDs
		reconfiguratorIdMapping = new ReconfiguratorIdMapping(featureModel, contextModel);

		featureReconfiguratorIdMapping = reconfiguratorIdMapping.getFeatureIdMapping();
		versionReconfiguratorIdMapping = reconfiguratorIdMapping.getVersionIdMapping();
		contextReconfiguratorIdMapping = reconfiguratorIdMapping.getContextIdMapping();
		attributeReconfiguratorIdMapping = reconfiguratorIdMapping.getAttributeIdMapping();

		featureModelExporter = new DwFeatureModelExporter(featureModel, featureReconfiguratorIdMapping,
				versionReconfiguratorIdMapping, attributeReconfiguratorIdMapping);
		configurationExporter = new DwConfigurationExporter(featureReconfiguratorIdMapping,
				versionReconfiguratorIdMapping, contextReconfiguratorIdMapping, attributeReconfiguratorIdMapping);
		contextExporter = new DwContextExporter(contextReconfiguratorIdMapping);

		expressionExporter = new HyExpressionStringExporter(reconfiguratorIdMapping.getFeatureIdMapping(),
				reconfiguratorIdMapping.getVersionIdMapping(), reconfiguratorIdMapping.getAttributeIdMapping(),
				reconfiguratorIdMapping.getContextIdMapping(), BooleanRepresentationOption.ONEZERO,
				FeatureSelectionRepresentationOption.ONEZERO, VersionRepresentation.AS_ONEZERO_FEATURES, true, true);

		constraintExporter = new DwConstraintExporter(expressionExporter);
		preferenceExporter = new DwPreferenceExporter(expressionExporter);
		validityFormulaExporter = new DwValidityFormulaExporter(expressionExporter);

		InputForHyVarRec input = new InputForHyVarRec();
		initializeEmptyHyVarRecInput(input);

		// gson = new Gson();
		gson = new GsonBuilder().disableHtmlEscaping().create();

		input.setAttributes(featureModelExporter.getExportedAttributes(date));
		if (contextModel != null) {
			input.setContexts(contextExporter.getExportedContexts(contextModel, date));
		}
		if (oldConfiguration != null) {
			input.setConfiguration(configurationExporter.getExportedConfiguration(oldConfiguration, contextValues));
		}

		input.setConstraints(new ArrayList<String>());

		// Encode evolution as context: 0 is before the first date,
		// sortedDateList.size() is after the last date. 0 is min and max if
		// there is no date.
		Context dateContext = null;
		List<Date> sortedDateList = null;
		if (date == null) {
			sortedDateList = getSortedListOfDates(featureModel, contextModel, constraintModel, contextValidityModel, preferenceModel);

			dateContext = new Context();
			dateContext.setId(EVOLUTION_CONTEXT_ID);
			dateContext.setMin(0);
			dateContext.setMax(sortedDateList.size());

			input.getContexts().add(dateContext);
		}
		// -----

		try {
			input.getConstraints().addAll(
					featureModelExporter.getFeatureModelConstraints(featureModel, date, dateContext, sortedDateList));
		} catch (HyFeatureModelWellFormednessException e) {
			System.err.println("Could not create constraints of FM, as FM is not well-formed");
			e.printStackTrace();
			return null;
		}

		if (constraintModel != null) {
			input.getConstraints()
					.addAll(constraintExporter.getConstraints(constraintModel, date, dateContext, sortedDateList));
		}

		if (contextValidityModel != null) {
			input.getConstraints().addAll(validityFormulaExporter.getContextValidityFormulas(contextValidityModel, date,
					dateContext, sortedDateList));
		}

		if (preferenceModel != null) {
			input.setPreferences(preferenceExporter.getPreferences(preferenceModel, date, dateContext, sortedDateList));
		}

		return gson.toJson(input);
	}
	
	public static List<Date> getSortedListOfDates(HyFeatureModel featureModel, HyContextModel contextModel, HyConstraintModel constraintModel, HyValidityModel contextValidityModel, HyProfile profile) {
		List<Date> sortedDateList = null;
		Set<Date> dateSet = null;
		dateSet = new HashSet<Date>();
		dateSet.addAll(HyEvolutionUtil.collectDates(featureModel));
		dateSet.addAll(HyEvolutionUtil.collectDates(contextModel));
		dateSet.addAll(HyEvolutionUtil.collectDates(profile));
		dateSet.addAll(HyEvolutionUtil.collectDates(constraintModel));
		dateSet.addAll(HyEvolutionUtil.collectDates(contextValidityModel));

		sortedDateList = new ArrayList<Date>(dateSet.size());
		sortedDateList.addAll(dateSet);
		Collections.sort(sortedDateList);
		
		return sortedDateList;
	}

	public static DomainTuple<Integer> getEnumDomain(HyEnum hyEnum) {

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

	public static String timedConstraint(Date validSince, Date validUntil, Context dateContext,
			List<Date> sortedDateList) {
		StringBuilder timedConstraint = new StringBuilder();

		boolean validSinceNull = true;
		boolean validUntilNull = true;

		if (validSince != null) {
			validSinceNull = false;

			timedConstraint.append(BRACKETS_OPEN);
			timedConstraint.append(ReconfiguratorIdMapping.CONTEXT_ATOM);
			timedConstraint.append(dateContext.getId());
			timedConstraint.append(ReconfiguratorIdMapping.ARRAY_BRACKETS_CLOSING);

			int dateContextValue = getPositionOfEqualDateInList(sortedDateList, validSince);

			timedConstraint.append(GEQ);
			timedConstraint.append(dateContextValue);
		}

		if (validUntil != null) {
			validUntilNull = false;

			if (!validSinceNull) {
				timedConstraint.append(AND);
			} else {
				timedConstraint.append(BRACKETS_OPEN);
			}

			timedConstraint.append(ReconfiguratorIdMapping.CONTEXT_ATOM);
			timedConstraint.append(dateContext.getId());
			timedConstraint.append(ReconfiguratorIdMapping.ARRAY_BRACKETS_CLOSING);

			int dateContextValue = getPositionOfEqualDateInList(sortedDateList, validUntil);

			timedConstraint.append(LESS);
			timedConstraint.append(dateContextValue);
		}

		if (!validSinceNull || !validUntilNull) {
			timedConstraint.append(BRACKETS_CLOSING);
			timedConstraint.append(IMPLICATION);
		}

		return timedConstraint.toString();
	}

	public static String timedConstraint(HyTemporalElement evolvedElement, Context dateContext,
			List<Date> sortedDateList) {
		return timedConstraint(evolvedElement.getValidSince(), evolvedElement.getValidUntil(), dateContext,
				sortedDateList);
	}

	public static String timedConstraint(Date date, Context dateContext, List<Date> sortedDateList) {
		StringBuilder timedConstraint = new StringBuilder();

		timedConstraint.append(BRACKETS_OPEN);
		timedConstraint.append(ReconfiguratorIdMapping.CONTEXT_ATOM);
		timedConstraint.append(dateContext.getId());
		timedConstraint.append(ReconfiguratorIdMapping.ARRAY_BRACKETS_CLOSING);

		timedConstraint.append(EQUALS);

		timedConstraint.append(getPositionOfEqualDateInList(sortedDateList, date));

		timedConstraint.append(BRACKETS_CLOSING);
		timedConstraint.append(IMPLICATION);

		return timedConstraint.toString();
	}

	public static String createTimedExpression(HyTemporalElement baseElement, HyExpression expression, Date date,
			Context dateContext, List<Date> sortedDateList, HyExpressionStringExporter expressionExporter) {
		StringBuilder expressionStringBuilder = new StringBuilder();

		if (date != null) {
			if (!HyEvolutionUtil.isValid(baseElement, date)) {
				return null;
			}
		} else {
			expressionStringBuilder.append(timedConstraint(baseElement, dateContext, sortedDateList));
		}

		expressionStringBuilder.append(expressionExporter.exportExpressionToString(expression));

		return expressionStringBuilder.toString();
	}

	protected static int getPositionOfEqualDateInList(List<Date> dateList, Date date) {
		for (int i = 0; i < dateList.size(); i++) {
			if (dateList.get(i).equals(date)) {
				return i;
			}
		}

		return -1;
	}

}