package eu.hyvar.reconfigurator.input.exporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

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
import de.darwinspl.preferences.DwProfile;
import eu.hyvar.reconfigurator.input.format.Attribute;
import eu.hyvar.reconfigurator.input.format.AttributeValue;
import eu.hyvar.reconfigurator.input.format.Configuration;
import eu.hyvar.reconfigurator.input.format.Context;
import eu.hyvar.reconfigurator.input.format.ContextValue;
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
	
	public static final String EVOLUTION_CONTEXT_ID = "context[_evolution-context]";

//	private HyExpressionStringExporter expressionExporter;

	private Map<HyFeature, String> featureReconfiguratorIdMapping;
	private Map<HyVersion, String> versionReconfiguratorIdMapping;
	private Map<HyContextualInformation, String> contextReconfiguratorIdMapping;
	private Map<HyFeatureAttribute, String> attributeReconfiguratorIdMapping;

	private ReconfiguratorIdMapping reconfiguratorIdMapping;

	public HyVarRecExporter() {
		
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
			DwProfile profileModel, HyContextValueModel contextValue, Date date) {
		return exportSPL(contextModel, contextValidityModel, featureModel, constraintModel, oldConfiguration, null, profileModel, contextValue, date);
	}
	
	public String exportSPL(HyContextModel contextModel, HyValidityModel contextValidityModel,
			HyFeatureModel featureModel, HyConstraintModel constraintModel, HyConfiguration oldConfiguration, HyConfiguration partialConfiguration,
			DwProfile profileModel, HyContextValueModel contextValue, Date date) {
		
		List<HyContextModel> contextModels = new ArrayList<HyContextModel>();
		contextModels.add(contextModel);
		
		List<HyValidityModel> contextValidityModels = new ArrayList<HyValidityModel>();
		contextValidityModels.add(contextValidityModel);
		
		
		List<HyFeatureModel> featureModels = new ArrayList<HyFeatureModel>();
		featureModels.add(featureModel);
		
		List<HyConstraintModel> constraintModels = new ArrayList<HyConstraintModel>();
		constraintModels.add(constraintModel);
		

		List<DwProfile> profileModels = new ArrayList<DwProfile>();
		profileModels.add(profileModel);
		
		List<HyContextValueModel> contextValues = new ArrayList<HyContextValueModel>();
		contextValues.add(contextValue);
		
		return exportSPL(contextModels, contextValidityModels, featureModels, constraintModels, oldConfiguration, partialConfiguration, profileModels, contextValues, date);
	}
	
	public String exportSPL(List<HyContextModel> contextModels, List<HyValidityModel> contextValidityModels,
			List<HyFeatureModel> featureModels, List<HyConstraintModel> constraintModels, HyConfiguration oldConfiguration, HyConfiguration partialConfiguration,
			List<DwProfile> profileModels, List<HyContextValueModel> contextValues, Date date) {

		// TODO incorporate MSPL stuff

		if (featureModels == null || featureModels.isEmpty()) {
			return null;
		}

		// Create mappings from model elements to IDs
		reconfiguratorIdMapping = new ReconfiguratorIdMapping(featureModels, contextModels);

		featureReconfiguratorIdMapping = reconfiguratorIdMapping.getFeatureIdMapping();
		versionReconfiguratorIdMapping = reconfiguratorIdMapping.getVersionIdMapping();
		contextReconfiguratorIdMapping = reconfiguratorIdMapping.getContextIdMapping();
		attributeReconfiguratorIdMapping = reconfiguratorIdMapping.getAttributeIdMapping();

		Map<HyFeatureModel, DwFeatureModelExporter> featureModelExporters = new HashMap<HyFeatureModel, DwFeatureModelExporter>(featureModels.size());
		for(HyFeatureModel featureModel: featureModels) {
			featureModelExporters.put(featureModel, new DwFeatureModelExporter(featureModel, featureReconfiguratorIdMapping,
				versionReconfiguratorIdMapping, attributeReconfiguratorIdMapping));
		}

		DwConfigurationExporter configurationExporter = new DwConfigurationExporter(featureReconfiguratorIdMapping,
				versionReconfiguratorIdMapping, contextReconfiguratorIdMapping, attributeReconfiguratorIdMapping);
		
		DwContextExporter contextExporter =new DwContextExporter(contextReconfiguratorIdMapping);

		HyExpressionStringExporter expressionExporter = new HyExpressionStringExporter(reconfiguratorIdMapping.getFeatureIdMapping(),
				reconfiguratorIdMapping.getVersionIdMapping(), reconfiguratorIdMapping.getAttributeIdMapping(),
				reconfiguratorIdMapping.getContextIdMapping(), BooleanRepresentationOption.TRUEFALSE,
				FeatureSelectionRepresentationOption.ONEZERO, VersionRepresentation.AS_ONEZERO_FEATURES, true, true);

		DwConstraintExporter constraintExporter = new DwConstraintExporter(expressionExporter);
		DwPreferenceExporter preferenceExporter = new DwPreferenceExporter(expressionExporter);
		DwValidityFormulaExporter validityFormulaExporter = new DwValidityFormulaExporter(expressionExporter);

		InputForHyVarRec input = new InputForHyVarRec();
		initializeEmptyHyVarRecInput(input);

		// gson = new Gson();
		gson = new GsonBuilder().disableHtmlEscaping().create();

		// collect attributes
		input.setAttributes(new ArrayList<Attribute>());
		for(DwFeatureModelExporter featureModelExporter: featureModelExporters.values()) {
			input.getAttributes().addAll(featureModelExporter.getExportedAttributes(date));			
		}
		
		// collect contexts
		input.setContexts(new ArrayList<Context>());
		for(HyContextModel contextModel: contextModels) {
			input.getContexts().addAll(contextExporter.getExportedContexts(contextModel, date));
		}

		// get old configurations
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
			List<EObject> allModels = new ArrayList<EObject>();
			allModels.addAll(featureModels);
			allModels.addAll(constraintModels);
			allModels.addAll(contextModels);
			allModels.addAll(contextValidityModels);
			allModels.addAll(profileModels);
			sortedDateList = getSortedListOfDates(allModels);

			dateContext = new Context();
//			String id = CONTEXT_ATOM;
//			id += EVOLUTION_CONTEXT_ID;
//			id += ARRAY_BRACKETS_CLOSING;
			dateContext.setId(EVOLUTION_CONTEXT_ID);
			dateContext.setMin(-1);
			dateContext.setMax(sortedDateList.size()-1);

			input.getContexts().add(dateContext);

			// Simone: patch to initialize the context value
			ContextValue initDateContext = new ContextValue();
			initDateContext.setId(EVOLUTION_CONTEXT_ID);
			initDateContext.setValue(-1);
			input.getConfiguration().getContextValues().add(initDateContext);
			
		}
		// -----

		try {
			for(HyFeatureModel featureModel: featureModelExporters.keySet()) {
				input.getConstraints().addAll(featureModelExporters.get(featureModel).getFeatureModelConstraints(featureModel, date, dateContext, sortedDateList));
			}
		} catch (HyFeatureModelWellFormednessException e) {
			System.err.println("Could not create constraints of FM, as FM is not well-formed");
			e.printStackTrace();
			return null;
		}

		if (constraintModels != null) {
			for(HyConstraintModel constraintModel: constraintModels) {
				input.getConstraints()
				.addAll(constraintExporter.getConstraints(constraintModel, date, dateContext, sortedDateList));
				
			}
		}

		if (contextValidityModels != null) {
			for(HyValidityModel contextValidityModel: contextValidityModels) {
				input.getConstraints().addAll(validityFormulaExporter.getContextValidityFormulas(contextValidityModel, date,
						dateContext, sortedDateList));				
			}
		}

		if (profileModels != null) {
			for(DwProfile profile: profileModels) {
				input.setPreferences(preferenceExporter.getPreferences(profile, date, dateContext, sortedDateList));				
			}
		}

		return gson.toJson(input);
	}
	
	public static List<Date> getSortedListOfDatesOfDateContext(List<HyFeatureModel> featureModels, List <HyConstraintModel> constraintModels, List<HyContextModel> contextModels, List<HyValidityModel> validityModels, List<DwProfile> profiles) {
		List<EObject> allModels = new ArrayList<EObject>();
		allModels.addAll(featureModels);
		allModels.addAll(constraintModels);
		allModels.addAll(contextModels);
		allModels.addAll(validityModels);
		allModels.addAll(profiles);
		return getSortedListOfDates(allModels);
	}
	
	public static List<Date> getSortedListOfDates(List<EObject> eObjects) {
		List<Date> sortedDateList = null;
		Set<Date> dateSet = null;
		dateSet = new HashSet<Date>();
		
		for(EObject eObject: eObjects) {
			dateSet.addAll(HyEvolutionUtil.collectDates(eObject));
		}
		
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

	/**
	 * Creates a constraint which is like (evolutionContext >= since and evolutionContext < until) impl
	 * @param validSince
	 * @param validUntil
	 * @param dateContext
	 * @param sortedDateList
	 * @return
	 */
	public static String timedConstraint(Date validSince, Date validUntil, Context dateContext,
			List<Date> sortedDateList) {
		StringBuilder timedConstraint = new StringBuilder();

		boolean validSinceNull = true;
		boolean validUntilNull = true;

		if (validSince != null) {
			validSinceNull = false;

			timedConstraint.append(BRACKETS_OPEN);
			timedConstraint.append(dateContext.getId());

			int dateContextValue = getDateContextValueForDate(sortedDateList, validSince);

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

			timedConstraint.append(dateContext.getId());

			int dateContextValue = getDateContextValueForDate(sortedDateList, validUntil);

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
		timedConstraint.append(dateContext.getId());

		timedConstraint.append(EQUALS);

		timedConstraint.append(getDateContextValueForDate(sortedDateList, date));

		timedConstraint.append(BRACKETS_CLOSING);
		timedConstraint.append(IMPLICATION);

		return timedConstraint.toString();
	}

	public static String createTimedExpression(HyTemporalElement baseElement, HyExpression expression, Date date,
			Context dateContext, List<Date> sortedDateList, HyExpressionStringExporter expressionExporter) {
		StringBuilder expressionStringBuilder = new StringBuilder();

		boolean timedConstraint = false;
		
		if (date != null) {
			if (!HyEvolutionUtil.isValid(baseElement, date)) {
				return null;
			}
		} else {
			timedConstraint = true;
			expressionStringBuilder.append(timedConstraint(baseElement, dateContext, sortedDateList));
			expressionStringBuilder.append(BRACKETS_OPEN);
		}

		expressionStringBuilder.append(expressionExporter.exportExpressionToString(expression));

		if(timedConstraint) {
			expressionStringBuilder.append(BRACKETS_CLOSING);			
		}

		return expressionStringBuilder.toString();
	}

	protected static int getDateContextValueForDate(List<Date> dateList, Date date) {
		for (int i = 0; i < dateList.size(); i++) {
			if (dateList.get(i).equals(date)) {
				return i;
			}
		}

		return -1;
	}

	public Map<HyFeature, String> getFeatureReconfiguratorIdMapping() {
		return featureReconfiguratorIdMapping;
	}

	public Map<HyVersion, String> getVersionReconfiguratorIdMapping() {
		return versionReconfiguratorIdMapping;
	}

	public Map<HyContextualInformation, String> getContextReconfiguratorIdMapping() {
		return contextReconfiguratorIdMapping;
	}

	public Map<HyFeatureAttribute, String> getAttributeReconfiguratorIdMapping() {
		return attributeReconfiguratorIdMapping;
	}

	public ReconfiguratorIdMapping getReconfiguratorIdMapping() {
		return reconfiguratorIdMapping;
	}
	
	

}