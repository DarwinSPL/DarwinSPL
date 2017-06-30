package de.darwinspl.feature.graphical.configurator.analyses;

import java.net.URI;
import java.nio.channels.UnresolvedAddressException;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.util.StringContentProvider;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.darwinspl.feature.graphical.configurator.analyses.io.format.HyVarRecExplainAnswer;
import de.darwinspl.feature.graphical.configurator.analyses.io.format.context.HyVarRecValidateAnswer;
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
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.preferences.HyProfile;
import eu.hyvar.reconfigurator.input.exporter.HyVarRecExporter;
import eu.hyvar.reconfigurator.output.translation.HyVarRecOutputTranslator;
import eu.hyvar.reconfigurator.output.translation.format.OutputOfHyVarRec;

public class AnalysesClient {

//	private static final String MSG_TYPE_RAW_HYVARREC = "raw_hyvarrec_input";
//
//	private static final String MSG_TYPE_HYVARREC_CONFIG_2_HYCONFIG = "hyvarrec_config_plus_fm";

	protected static final String RECONFIGURATION_URI = "process";
	protected static final String VALIDATE_CONTEXT_URI = "validate";
	protected static final String VALIDATE_FM_URI = "explain";
	
	
	protected static final String CONTEXT_VALID = "valid";
	
	HttpClient client;
	URI uri;

	GsonBuilder builder = new GsonBuilder();
	Gson gson = builder.create();

	String json = "";

	Request request;

	ContentResponse response;
	String answerString;
	
	protected URI createUriWithPath(String originalUri, String processAddress) {
		if(!originalUri.endsWith("/")) {
			originalUri = originalUri + "/";
		}
		
		originalUri = originalUri + processAddress;
		
		return URI.create(originalUri);
	}
	
	protected String createHyVarRecMessage(HyContextModel contextModel, HyValidityModel contextValidityModel, HyFeatureModel featureModel, HyConstraintModel constraintModel, HyConfiguration oldConfiguration, HyProfile preferenceModel, HyContextValueModel contextValues, Date date) {
		HyVarRecExporter exporter = new HyVarRecExporter();
		String messageForHyVarRec = exporter.exportContextMappingModel(contextModel, contextValidityModel, featureModel, constraintModel, oldConfiguration, preferenceModel, contextValues, date);
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
	 * @param contextValues
	 * @param date
	 * @return if the fm is satisfiable
	 */
	public boolean validateFeatureModel(String uriString, HyContextModel contextModel, HyValidityModel contextValidityModel,
			HyFeatureModel featureModel, HyConstraintModel constraintModel, HyConfiguration oldConfiguration,
			HyProfile preferenceModel, HyContextValueModel contextValues, Date date) {
		
		String messageForHyVarRec = createHyVarRecMessage(contextModel, contextValidityModel, featureModel, constraintModel, oldConfiguration, preferenceModel, contextValues, date);
		URI uri = createUriWithPath(uriString, VALIDATE_FM_URI);
		
		String hyvarrecAnswerString = sendMessageToHyVarRec(messageForHyVarRec, uri);
		
		HyVarRecExplainAnswer hyVarRecAnswer = gson.fromJson(hyvarrecAnswerString, HyVarRecExplainAnswer.class);
		// TODO do something with the answer
		
		if(hyVarRecAnswer.getResult().equals("sat")) {
			return true;
		}else if(hyVarRecAnswer.getResult().equals("unsat")) {
			return false;
		}
		
		return false;
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
	 * @return Context values for which the model is not satisfiable. Null if satisfiable
	 */
	public HyContextValueModel validateFeatureModelWithContext(String uriString, HyContextModel contextModel, HyValidityModel contextValidityModel,
			HyFeatureModel featureModel, HyConstraintModel constraintModel, HyConfiguration oldConfiguration,
			HyProfile preferenceModel, HyContextValueModel contextValues, Date date) {
		
		String messageForHyVarRec = createHyVarRecMessage(contextModel, contextValidityModel, featureModel, constraintModel, oldConfiguration, preferenceModel, contextValues, date);
		URI uri = createUriWithPath(uriString, VALIDATE_CONTEXT_URI);
		
		String hyvarrecAnswerString = sendMessageToHyVarRec(messageForHyVarRec, uri);
		
		HyVarRecValidateAnswer hyVarRecAnswer = gson.fromJson(hyvarrecAnswerString, HyVarRecValidateAnswer.class);
		
		if(hyVarRecAnswer.getResult().equals(CONTEXT_VALID)) {
			return null;
		}
		
		HyContextValueModel contextValueModel = ContextValueFactory.eINSTANCE.createHyContextValueModel();
		
		if(hyVarRecAnswer.getContexts() != null) {
			for(de.darwinspl.feature.graphical.configurator.analyses.io.format.context.Context context: hyVarRecAnswer.getContexts()) {
				String contextId = context.getId();
				int value = context.getValue();
				
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
		
		return contextValueModel;
	}
	
	
	
	protected String sendMessageToHyVarRec(String message, URI uri) {
		HttpClient hyvarrecClient = new HttpClient();
		try {
			hyvarrecClient.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		URI hyvarrecUri = uri;
		Request hyvarrecRequest = hyvarrecClient.POST(hyvarrecUri);
		hyvarrecRequest.header(HttpHeader.CONTENT_TYPE, "application/json");
		hyvarrecRequest.content(new StringContentProvider(message), "application/json");
		ContentResponse hyvarrecResponse;
		String hyvarrecAnswerString = "";
		try {
			hyvarrecResponse = hyvarrecRequest.send();
			hyvarrecAnswerString = hyvarrecResponse.getContentAsString();
		} catch (UnresolvedAddressException | ExecutionException e){
			MessageDialog dialog = new MessageDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Unresolvable Server Adress", null,
					"The adress '"+uri.toString()+"' could not be resolved. No configuration was generated.", MessageDialog.ERROR, new String[] { "Ok" }, 0);
			dialog.open();
			
			return null;
		} catch (InterruptedException | TimeoutException e) {
			//e.printStackTrace();
			return null;
		} 

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
	public HyConfiguration reconfigure(String uriString, HyContextModel contextModel, HyValidityModel contextValidityModel,
			HyFeatureModel featureModel, HyConstraintModel constraintModel, HyConfiguration oldConfiguration,
			HyProfile preferenceModel, HyContextValueModel contextValues, Date date) {
		
		String messageForHyVarRec = createHyVarRecMessage(contextModel, contextValidityModel, featureModel, constraintModel, oldConfiguration, preferenceModel, contextValues, date);
		
		
//		InputForHyVarRec answer = gson.fromJson(answerString, InputForHyVarRec.class);
//		System.out.println("Input for HyVarRec: "+answerString);
//
//		// send it to HyVarRec
//		String hyvarrecJson = gson.toJson(answer);
		
//		String uriString = uri.toString();
//		if(uriString.endsWith(arg0))
//		System.out.println(uriString);
		
		URI uri = createUriWithPath(uriString, RECONFIGURATION_URI);
		
		String hyvarrecAnswerString = sendMessageToHyVarRec(messageForHyVarRec, uri);
		
		OutputOfHyVarRec hyvarrecAnswer = gson.fromJson(hyvarrecAnswerString, OutputOfHyVarRec.class);
//		hyvarrecAnswer.get
		
		HyConfiguration configuration = HyVarRecOutputTranslator.translateConfiguration(featureModel, hyvarrecAnswer, date);
		
		return configuration;
	}
	
}