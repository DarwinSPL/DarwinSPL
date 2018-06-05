package de.darwinspl.reconfigurator.client.hyvarrec;

import java.net.URI;
import java.nio.channels.UnresolvedAddressException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.AuthenticationStore;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.util.BasicAuthentication;
import org.eclipse.jetty.client.util.StringContentProvider;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.util.ssl.SslContextFactory;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.darwinspl.anomalies.explanations.AnomalyConstraintExplanation;
import de.darwinspl.anomaly.DwAnomaly;
import de.darwinspl.anomaly.DwAnomalyFactory;
import de.darwinspl.anomaly.DwDeadFeatureAnomaly;
import de.darwinspl.anomaly.DwFalseOptionalFeatureAnomaly;
import de.darwinspl.anomaly.DwFeatureAnomaly;
import de.darwinspl.anomaly.DwVoidFeatureModelAnomaly;
import de.darwinspl.anomaly.explanation.DwAnomalyExplanation;
import de.darwinspl.anomaly.explanation.DwAnomalyExplanationFactory;
import de.darwinspl.preferences.DwProfile;
import de.darwinspl.reconfigurator.client.hyvarrec.format.HyVarRecExplainAnswer;
import de.darwinspl.reconfigurator.client.hyvarrec.format.check_features.HyVarRecCheckFeaturesAnswer;
import de.darwinspl.reconfigurator.client.hyvarrec.format.context.HyVarRecValidateAnswer;
import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.context.HyContextualInformationBoolean;
import eu.hyvar.context.HyContextualInformationEnum;
import eu.hyvar.context.HyContextualInformationNumber;
import eu.hyvar.context.contextValidity.HyValidityModel;
import eu.hyvar.context.information.contextValue.ContextValueFactory;
import eu.hyvar.context.information.contextValue.HyContextValue;
import eu.hyvar.context.information.contextValue.HyContextValueModel;
import eu.hyvar.dataValues.HyBooleanValue;
import eu.hyvar.dataValues.HyDataValuesFactory;
import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.dataValues.HyEnumValue;
import eu.hyvar.dataValues.HyNumberValue;
import eu.hyvar.dataValues.HyValue;
import eu.hyvar.evolution.HyName;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.reconfigurator.input.exporter.HyVarRecExporter;
import eu.hyvar.reconfigurator.input.format.InputForHyVarRec;
import eu.hyvar.reconfigurator.output.translation.HyVarRecOutputTranslator;
import eu.hyvar.reconfigurator.output.translation.format.OutputOfHyVarRec;

/**
 * 
 * @author Felix Franzke
 *
 */
public class DwAnalysesClient {

//	private static final String MSG_TYPE_RAW_HYVARREC = "raw_hyvarrec_input";
//
//	private static final String MSG_TYPE_HYVARREC_CONFIG_2_HYCONFIG = "hyvarrec_config_plus_fm";

	protected static final String RECONFIGURATION_URI = "process";
	protected static final String VALIDATE_CONTEXT_URI = "validate";
	protected static final String VALIDATE_FM_URI = "explain";
	protected static final String CHECK_FEATURES_URI = "check_features";
	
	public static final String DEFAULT_URI = "https://www.isf.cs.tu-bs.de/hyvarrec/";
	
	protected static final String CONTEXT_VALID = "valid";
	
	protected HyVarRecExporter exporter;
	
	protected Gson gson;
	
	protected GsonBuilder gsonBuilder;

	public DwAnalysesClient() {
		gsonBuilder = new GsonBuilder();
		gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
		gson = gsonBuilder.disableHtmlEscaping().create();
		exporter = new HyVarRecExporter();
	}
	
	
	
	public static URI createUriWithPath(String originalUri, String processAddress) {
		if(!originalUri.endsWith("/")) {
			originalUri = originalUri + "/";
		}
		
		originalUri = originalUri + processAddress;
		
		return URI.create(originalUri);
	}
	
	public String createHyVarRecMessage(HyContextModel contextModel, HyValidityModel contextValidityModel, HyFeatureModel featureModel, HyConstraintModel constraintModel, HyConfiguration oldConfiguration, DwProfile preferenceModel, HyContextValueModel contextValues, Date date, Date evolutionContextValueDate) {
		
		String messageForHyVarRec = exporter.exportSPL(contextModel, contextValidityModel, featureModel, constraintModel, oldConfiguration, preferenceModel, contextValues, date, evolutionContextValueDate);
		return messageForHyVarRec;
	}
	
	
	/**
	 * 
	 * @param uriString
	 * @param contextModel
	 * @param contextValidityModel
	 * @param featureModel
	 * @param constraintModel
	 * @param oldConfiguration
	 * @param preferenceModel
	 * @param anomaly
	 * @param evolutionOperationAnalyzer
	 * @return
	 * @throws TimeoutException
	 * @throws InterruptedException
	 * @throws ExecutionException
	 * @throws UnresolvedAddressException
	 */
	public List<AnomalyConstraintExplanation> explainAnomaly(String uriString, String webserviceUsername, String webservicePassword, HyContextModel contextModel, HyValidityModel contextValidityModel,
			HyFeatureModel featureModel, HyConstraintModel constraintModel, DwAnomaly anomaly, DwEvolutionOperationAnalyzer evolutionOperationAnalyzer)
			throws TimeoutException, InterruptedException, ExecutionException, UnresolvedAddressException {
		
		HyContextValueModel contextValueModel = null;
		String additionalAnomalyConstraint = null;
		
		if(anomaly instanceof DwVoidFeatureModelAnomaly) {
			contextValueModel = ((DwVoidFeatureModelAnomaly) anomaly).getContextValueModel();
		}
		else {
			// Create constraint enforcing the anomaly to cause a void feature model anomaly -> unsatisfiable constraints are the explanation for anomaly.
			additionalAnomalyConstraint = "feature[";
			additionalAnomalyConstraint = additionalAnomalyConstraint + ((DwFeatureAnomaly)anomaly).getFeature().getId();
			additionalAnomalyConstraint = additionalAnomalyConstraint + "] = ";
			
			if(anomaly instanceof DwFalseOptionalFeatureAnomaly) {
				additionalAnomalyConstraint = additionalAnomalyConstraint + "0";
			}
			else if(anomaly instanceof DwDeadFeatureAnomaly) {
				additionalAnomalyConstraint = additionalAnomalyConstraint + "1";
			}
		}
		
		
		// If the anomaly.getValidSince == null, we cannot use the null date as parameter. Otherwise, evolution-aware analysis is triggered which isn't working for explain service
		Date date = anomaly.getValidSince();
		if(date == null) {
			List<Date> dates = HyEvolutionUtil.collectDates(featureModel);
			if(contextModel != null) {
				dates.addAll(HyEvolutionUtil.collectDates(contextModel));				
			}
			if(contextValidityModel != null) {
				dates.addAll(HyEvolutionUtil.collectDates(contextValidityModel));				
			}
			if(constraintModel != null) {
				dates.addAll(HyEvolutionUtil.collectDates(constraintModel));
			}
			// If dates is empty, null can be used, as the exporter won't use evolution-encoding since no evolution exists.
			if(!dates.isEmpty()) {
//				Collections.sort(dates);
				// select a date before the first evolution step, as there is the cause.
//				date = dates.get(0);
//				Calendar calendar = Calendar.getInstance();
//				calendar.setTime(date);
//				calendar.add(Calendar.DAY_OF_MONTH, -1);
//				date = calendar.getTime();
				date = anomaly.getValidSince();
			}			
		}
		
		
		InputForHyVarRec inputForHyVarRec = exporter.createInputForHyVarRec(contextModel, contextValidityModel, featureModel, constraintModel, null, null, contextValueModel, date, date);
		URI uri = createUriWithPath(uriString, VALIDATE_FM_URI);
		
		if(additionalAnomalyConstraint != null) {
			inputForHyVarRec.getConstraints().add(additionalAnomalyConstraint);
		}
		
		String messageForHyVarRec = gson.toJson(inputForHyVarRec);
		
		System.err.println("MessageForHyVarRec: " + messageForHyVarRec);
		
		String hyvarrecAnswerString = sendMessageToHyVarRec(messageForHyVarRec, uri, webserviceUsername, webservicePassword);
		
		HyVarRecExplainAnswer hyVarRecAnswer = gson.fromJson(hyvarrecAnswerString, HyVarRecExplainAnswer.class);
		
		if(hyVarRecAnswer.getResult().equals("sat")) {
			return null;
		}else if(hyVarRecAnswer.getResult().equals("unsat")) {
			// TODO here a more sophisticated explanation engine could be possible.
			DwAnomalyExplanation anomalyExplanation = DwAnomalyExplanationFactory.eINSTANCE.createDwAnomalyExplanation();
			anomalyExplanation.setAnomaly(anomaly);
			anomalyExplanation.setDate(anomaly.getValidSince());
			
			List<String> parsedConstraints = translateIdsBackToNames(hyVarRecAnswer.getConstraints(), anomaly.getValidSince(), getExporter());
			
			if(parsedConstraints == null) {
				parsedConstraints = hyVarRecAnswer.getConstraints();
			}
			
			// use ids instead of names
			anomalyExplanation.getExplanations().addAll(hyVarRecAnswer.getConstraints());
			

			// run EvolutionOperationAnalyzer
			if (evolutionOperationAnalyzer == null) { // only override if not actually given.
				evolutionOperationAnalyzer = new DwEvolutionOperationAnalyzer(getExporter());
			}
			else {
				evolutionOperationAnalyzer.setExporter(getExporter());
			}
			evolutionOperationAnalyzer.setContextModel(contextModel);
			evolutionOperationAnalyzer.setContextValidityModel(contextValidityModel);
			evolutionOperationAnalyzer.setFeatureModel(featureModel);
			evolutionOperationAnalyzer.setConstraintModel(constraintModel);
			evolutionOperationAnalyzer.constructEvolutionOperations();
			
			List<AnomalyConstraintExplanation> anomalyExplanationList = evolutionOperationAnalyzer.explainAnomaly(anomalyExplanation);
			
			
			return anomalyExplanationList;
		}
		
		return null;
	}
	
	/**
	 * False optional and dead features
	 * @param uriString
	 * @param contextModel
	 * @param contextValidityModel
	 * @param featureModel
	 * @param constraintModel
	 * @param contextValues
	 * @param date
	 * @return
	 * @throws TimeoutException
	 * @throws InterruptedException
	 * @throws ExecutionException
	 * @throws UnresolvedAddressException
	 */
	public List<DwAnomaly> checkFeatures(String uriString, String webserviceUsername, String webservicePassword, HyContextModel contextModel, HyValidityModel contextValidityModel,
			HyFeatureModel featureModel, HyConstraintModel constraintModel, HyContextValueModel contextValues, Date date) throws TimeoutException, InterruptedException, ExecutionException, UnresolvedAddressException {
		String messageForHyVarRec = createHyVarRecMessage(contextModel, contextValidityModel, featureModel, constraintModel, null, null, contextValues, date, null);
		System.err.println(messageForHyVarRec);

		
		URI uri = createUriWithPath(uriString, CHECK_FEATURES_URI);
		
		String hyvarrecAnswerString = sendMessageToHyVarRec(messageForHyVarRec, uri, webserviceUsername, webservicePassword);
		System.err.println(hyvarrecAnswerString);
		
		HyVarRecCheckFeaturesAnswer hyVarRecAnswer = gson.fromJson(hyvarrecAnswerString, HyVarRecCheckFeaturesAnswer.class);
		
		List<DwAnomaly> anomalies = DwAnomalyTranslation.translateAnomalies(hyVarRecAnswer, exporter.getFeatureReconfiguratorIdMapping(), exporter.getSortedDateList());
		
		return anomalies;
	}
	
	public static List<String> translateIdsBackToNames(List<String> constraints, Date date, HyVarRecExporter hyVarRecExporter) {
		if(hyVarRecExporter == null || constraints == null) {
			return null;
		}
		
		// TODO dramatically not performant! More sophisticated implementation necessary!
		
		Map<String, String> replacementsMap = new HashMap<String, String>();
		
		for(Entry<HyFeatureAttribute, String> entry: hyVarRecExporter.getAttributeReconfiguratorIdMapping().entrySet()) {
			HyFeatureAttribute attribute = entry.getKey();
			HyFeature feature = attribute.getFeature();
			
			HyName attributeName = HyEvolutionUtil.getValidTemporalElement(attribute.getNames(), date);
			if(attributeName == null) {
				continue;
			}
			String attributeNameString = attributeName.getName();
			if(attributeNameString == null) {
				continue;
			}
			
			HyName featureName = HyEvolutionUtil.getValidTemporalElement(feature.getNames(), date);
			if(featureName == null) {
				continue;
			}
			String featureNameString = featureName.getName();
			if(featureNameString == null) {
				continue;
			}
			
			StringBuilder sb = new StringBuilder(featureNameString);
			sb.append(".");
			sb.append(attributeNameString);
			
			replacementsMap.put(entry.getValue(), sb.toString());
		}
		
		for(Entry<HyContextualInformation, String> entry: hyVarRecExporter.getContextReconfiguratorIdMapping().entrySet()) {
			String contextName = entry.getKey().getName();
			contextName = "context:"+contextName;
			replacementsMap.put(entry.getValue(), contextName);
		}
		
		for(Entry<HyFeature, String> entry: hyVarRecExporter.getFeatureReconfiguratorIdMapping().entrySet()) {
			HyName featureName = HyEvolutionUtil.getValidTemporalElement(entry.getKey().getNames(), date);
			if(featureName == null) {
				continue;
			}
			String featureNameString = featureName.getName();
			if(featureNameString == null) {
				continue;
			}
			
			replacementsMap.put(entry.getValue(), featureNameString);
		}
		
		for(Entry<HyVersion, String> entry: hyVarRecExporter.getVersionReconfiguratorIdMapping().entrySet()) {
			String versionNumber = entry.getKey().getNumber();
			
			HyFeature feature = entry.getKey().getFeature();
			
			HyName featureName = HyEvolutionUtil.getValidTemporalElement(feature.getNames(), date);
			if(featureName == null) {
				continue;
			}
			String featureNameString = featureName.getName();
			if(featureNameString == null) {
				continue;
			}
			
			StringBuilder sb = new StringBuilder(featureNameString);
			sb.append("(");
			sb.append(versionNumber);
			sb.append(")");
			
			replacementsMap.put(entry.getValue(), sb.toString());
		}
		
		// TODO context / Enum / boolean values are all Integers in the constraints -> need to be translated back
		
		List<String> translatedConstraints = new ArrayList<String>(constraints.size());
		
		for(String constraint: constraints) {
			String translatedConstraint = constraint;
			for(Entry<String, String> entry: replacementsMap.entrySet()) {
				translatedConstraint = translatedConstraint.replace(entry.getKey(), entry.getValue());
			}
			
			translatedConstraints.add(translatedConstraint);
		}
		
		return translatedConstraints;
	}
	
	
	/**
	 * 
	 * @param uriString
	 * @param contextModel
	 * @param contextValidityModel
	 * @param featureModel
	 * @param constraintModel
	 * @param oldConfiguration
	 * @param profile
	 * @param contextValues
	 * @param date
	 * @return Void feature model anomaly with context values. Null if no anomaly
	 */
	public DwVoidFeatureModelAnomaly validateFeatureModelWithContext(String uriString, String webserviceUsername, String webservicePassword, HyContextModel contextModel, HyValidityModel contextValidityModel,
			HyFeatureModel featureModel, HyConstraintModel constraintModel, HyConfiguration oldConfiguration,
			DwProfile profile, HyContextValueModel contextValues, Date date) throws TimeoutException, InterruptedException, ExecutionException, UnresolvedAddressException, HyVarRecNoSolutionException {
		
		String messageForHyVarRec = createHyVarRecMessage(contextModel, contextValidityModel, featureModel, constraintModel, oldConfiguration, profile, contextValues, date, null);
		URI uri = createUriWithPath(uriString, VALIDATE_CONTEXT_URI);
		
		String hyvarrecAnswerString = sendMessageToHyVarRec(messageForHyVarRec, uri, webserviceUsername, webservicePassword);
		
		if(hyvarrecAnswerString.startsWith("{\"no_solution")) {
			throw new HyVarRecNoSolutionException("HyVarRec returned could not find any solution.\n Message for HyVarRec:\n"+messageForHyVarRec+"\n Answer from HyVarRec:\n"+hyvarrecAnswerString);
		}
		
		HyVarRecValidateAnswer hyVarRecAnswer = gson.fromJson(hyvarrecAnswerString, HyVarRecValidateAnswer.class);
		
		
		
		if(hyVarRecAnswer.getResult().equals(CONTEXT_VALID)) {
			return null;
		}
		
		
		DwVoidFeatureModelAnomaly voidFeatureAnomaly = DwAnomalyFactory.eINSTANCE.createDwVoidFeatureModelAnomaly();
		
		
		
		HyContextValueModel contextValueModel = ContextValueFactory.eINSTANCE.createHyContextValueModel();
		voidFeatureAnomaly.setContextValueModel(contextValueModel);
		
		if(hyVarRecAnswer.getContexts() != null) {
			// TODO inconsistency. In the requests for HyVarRec it's always written context[id] and in the answer its just id
			String evolutionId = HyVarRecExporter.EVOLUTION_CONTEXT_ID;
			
			if(HyVarRecExporter.EVOLUTION_CONTEXT_ID.startsWith(HyVarRecExporter.CONTEXT_ATOM)) {
				
				evolutionId = evolutionId.substring(HyVarRecExporter.CONTEXT_ATOM.length());
				evolutionId = evolutionId.substring(0, evolutionId.length()-1);
			}
			
			for(de.darwinspl.reconfigurator.client.hyvarrec.format.context.Context context: hyVarRecAnswer.getContexts()) {
				String contextId = context.getId();
				int value = context.getValue();
				
				
				
				if(contextId.equals(evolutionId)) {
					Date anomalyDate = getDateOutOfEvolutionContext(context, value, contextModel, contextValidityModel, featureModel, constraintModel, profile);
					voidFeatureAnomaly.setValidSince(anomalyDate);
					continue;
				}
				
				for(HyContextualInformation contextInfo: contextModel.getContextualInformations()) {
					if(contextInfo.getId().equals(contextId)) {
						HyContextValue contextValue = ContextValueFactory.eINSTANCE.createHyContextValue();
						contextValue.setContext(contextInfo);
						
						HyValue hyValue = null;
						
						if(contextInfo instanceof HyContextualInformationNumber) {
							HyNumberValue numberValue = HyDataValuesFactory.eINSTANCE.createHyNumberValue();
							numberValue.setValue(value);
							hyValue = numberValue;
						}
						else if(contextInfo instanceof HyContextualInformationBoolean) {
							HyBooleanValue booleanValue = HyDataValuesFactory.eINSTANCE.createHyBooleanValue();
							if(value == 1) {
								booleanValue.setValue(true);
							}
							else if(value == 0){
								booleanValue.setValue(false);
							}
							else {
								continue;
							}
							hyValue = booleanValue;
						}
						else if(contextInfo instanceof HyContextualInformationEnum) {
							HyEnumValue enumValue = null;
							
							HyContextualInformationEnum enumContex = (HyContextualInformationEnum) contextInfo;
							HyEnum hyEnum = enumContex.getEnumType();
							for(HyEnumLiteral literal: hyEnum.getLiterals()) {
								if(literal.getValue() == value) {
									enumValue = HyDataValuesFactory.eINSTANCE.createHyEnumValue();
									enumValue.setEnum(hyEnum);
									enumValue.setEnumLiteral(literal);
									break;
								}
							}
							
							if(enumValue == null) {
								continue;
							}
							
							hyValue = enumValue;
						}
						
						contextValue.setValue(hyValue);
						contextValueModel.getValues().add(contextValue);
						break;
					}
				}
			}
		}
		
		return voidFeatureAnomaly;
	}
	
	private Date getDateOutOfEvolutionContext(de.darwinspl.reconfigurator.client.hyvarrec.format.context.Context dateContext, int valueForDateContext, HyContextModel contextModel, HyValidityModel contextValidityModel,
			HyFeatureModel featureModel, HyConstraintModel constraintModel, DwProfile profile) {
		List<HyFeatureModel> featureModels = new ArrayList<HyFeatureModel>(1);
		featureModels.add(featureModel);
		
		List<HyConstraintModel> constraintModels = new ArrayList<HyConstraintModel>(1);
		constraintModels.add(constraintModel);
		
		List<HyContextModel> contextModels = new ArrayList<HyContextModel>(1);
		contextModels.add(contextModel);
		
		List<HyValidityModel> validityModels = new ArrayList<HyValidityModel>(1);
		validityModels.add(contextValidityModel);
		
		List<DwProfile> profiles = new ArrayList<DwProfile>(1);
		profiles.add(profile);
		
		List<Date> sortedDateList = HyVarRecExporter.getSortedListOfDatesOfDateContext(featureModels, constraintModels, contextModels, validityModels, profiles);
		
		if(valueForDateContext == -1) {
			if(sortedDateList.isEmpty()) {
				return null;
			}
			else {
				Calendar cal = new GregorianCalendar();
				cal.setTime(sortedDateList.get(0));
				cal.add(Calendar.DAY_OF_MONTH, -1);
				return cal.getTime();				
			}
		}
		
		return sortedDateList.get(valueForDateContext);
	}
	
	public String sendMessageToHyVarRec(String message, URI uri, String username, String password) throws UnresolvedAddressException, ExecutionException, InterruptedException, TimeoutException {
		
		HttpClient hyvarrecClient = new HttpClient(new SslContextFactory(true));
		
		if(username != null && password != null) {
			AuthenticationStore auth = hyvarrecClient.getAuthenticationStore();
			auth.addAuthenticationResult(new BasicAuthentication.BasicResult(uri, username, password));			
		}
		
		try {
			hyvarrecClient.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		Request hyvarrecRequest = hyvarrecClient.POST(uri);
		hyvarrecRequest.header(HttpHeader.CONTENT_TYPE, "application/json");
		hyvarrecRequest.content(new StringContentProvider(message), "application/json");
		ContentResponse hyvarrecResponse;
		String hyvarrecAnswerString = "";
		hyvarrecResponse = hyvarrecRequest.send();
		hyvarrecAnswerString = hyvarrecResponse.getContentAsString();

		// Only for Debug
		System.err.println("HyVarRec Answer: "+hyvarrecAnswerString);
		
		return hyvarrecAnswerString;
	}
	
	/**
	 * 
	 * @param uriString
	 * @param contextModel
	 * @param contextValidityModel
	 * @param featureModel
	 * @param constraintModel
	 * @param oldConfiguration
	 * @param preferenceModel
	 * @param contextValues
	 * @param date
	 * @return reconfigured configuration
	 */
	public HyConfiguration reconfigure(String uriString, String webserviceUsername, String webservicePassword, HyContextModel contextModel, HyValidityModel contextValidityModel,
			HyFeatureModel featureModel, HyConstraintModel constraintModel, HyConfiguration oldConfiguration,
			DwProfile preferenceModel, HyContextValueModel contextValues, Date date) throws TimeoutException, InterruptedException, ExecutionException, UnresolvedAddressException {
		
		String messageForHyVarRec = createHyVarRecMessage(contextModel, contextValidityModel, featureModel, constraintModel, oldConfiguration, preferenceModel, contextValues, date, null);
		
		URI uri = createUriWithPath(uriString, RECONFIGURATION_URI);
		
		String hyvarrecAnswerString = sendMessageToHyVarRec(messageForHyVarRec, uri, webserviceUsername, webservicePassword);
		
		OutputOfHyVarRec hyvarrecAnswer = gson.fromJson(hyvarrecAnswerString, OutputOfHyVarRec.class);
		
		Map<String, Integer> attributeValues = new HashMap<String, Integer>();
		
		if(hyvarrecAnswer.getAttributes() != null) {
			for(eu.hyvar.reconfigurator.output.translation.format.Attribute attributeValue: hyvarrecAnswer.getAttributes()) {
				attributeValues.put(attributeValue.getId(), attributeValue.getValue());
			}			
		}
		
		HyConfiguration configuration = HyVarRecOutputTranslator.translateConfiguration(featureModel, hyvarrecAnswer.getFeatures(), attributeValues, date);
		
		return configuration;
	}
	
	
	public class DwContextValueEvolutionWrapper {
		
		private HyContextValueModel contextValueModel;
		private Date date;
		
		public HyContextValueModel getContextValueModel() {
			return contextValueModel;
		}
		
		public void setContextValueModel(HyContextValueModel contextValueModel) {
			this.contextValueModel = contextValueModel;
		}
		
		public Date getDate() {
			return date;
		}
		
		public void setDate(Date date) {
			this.date = date;
		}
		
		
	}
	
	public HyVarRecExporter getExporter () {
		return exporter;
	}
}
