package de.darwinspl.configurator;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.util.StringContentProvider;
import org.eclipse.jetty.http.HttpHeader;

import de.darwinspl.configurator.expression.AtomicFeatureExpression;
import eu.hyvar.dataValues.HyDataValuesFactory;
import eu.hyvar.dataValues.HyNumberValue;
import eu.hyvar.dataValues.HyValue;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.expression.HyAttributeReferenceExpression;
import eu.hyvar.feature.expression.HyExpressionFactory;
import eu.hyvar.feature.expression.HyFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyIfPossibleExpression;
import eu.hyvar.feature.expression.HyMaximumExpression;
import eu.hyvar.feature.expression.HyNegationExpression;
import eu.hyvar.feature.expression.HyNestedExpression;
import eu.hyvar.feature.expression.HySubtractionExpression;
import eu.hyvar.feature.expression.HyValueExpression;
import eu.hyvar.preferences.HyPreference;
import eu.hyvar.preferences.HyPreferenceModel;
import eu.hyvar.preferences.PreferencesFactory;
import eu.hyvar.reconfigurator.input.exporter.HyVarRecExporter;

public class Configurator {

	private HyPreferenceModel preferenceModel;
	private PreferencesFactory preferenceFactory;
	private HyExpressionFactory expressionFactory;
	
	private String uri;
	
	private HyFeatureModel featureModel;
	private HyConstraintModel constraintModel;
	private Date date;
	
	public Configurator(String uri, HyFeatureModel featureModel, HyConstraintModel constraintModel, Date date) {
		 this.preferenceFactory = PreferencesFactory.eINSTANCE;
		 this.preferenceModel = preferenceFactory.createHyPreferenceModel();
		 this.preferenceModel.setFeatureModel(featureModel);
		 
		 this.expressionFactory = HyExpressionFactory.eINSTANCE;
		 
		 this.uri = uri;
		 this.featureModel = featureModel;
		 this.constraintModel = constraintModel;
		 this.date = date;	 
	}
	
	public String run(){
		HyVarRecExporter exporter = new HyVarRecExporter();
		String input = exporter.exportContextMappingModel(null, null, featureModel, constraintModel, null,
				preferenceModel, null, date);
		
		String output = sendToHyVarRec(input);
		
		System.out.println("HyVarRecInput: " + input);
		System.out.println("HyVarRecOutput: " + output );
		return output;
	}

	public void addMaxFeaturesPreference() {

		HyIfPossibleExpression ipExpression = expressionFactory.createHyIfPossibleExpression();

		// preferences to select the most features
		for (HyFeature feature : featureModel.getFeatures()) {

			AtomicFeatureExpression referenceExpression = new AtomicFeatureExpression();
			referenceExpression.setFeature(feature);

			ipExpression.getOperands().add(referenceExpression);

		}
		HyPreference preference = preferenceFactory.createHyPreference();
		preference.setRootExpression(ipExpression);
		preferenceModel.getPreferences().add(preference);

	}

	public void addMinFeaturesPreference() {

		HyIfPossibleExpression ipExpression = expressionFactory.createHyIfPossibleExpression();

		// preferences to select the most features
		for (HyFeature feature : featureModel.getFeatures()) {

			AtomicFeatureExpression referenceExpression = new AtomicFeatureExpression();
			referenceExpression.setFeature(feature);

			ipExpression.getOperands().add(referenceExpression);

		}
		HyNestedExpression nestedExpression = expressionFactory.createHyNestedExpression();
		nestedExpression.setOperand(ipExpression);
		
		HyValueExpression valueExpression = expressionFactory.createHyValueExpression();
		HyDataValuesFactory dataValuesFactory = HyDataValuesFactory.eINSTANCE;
		HyNumberValue value =  dataValuesFactory.createHyNumberValue();
		value.setValue(0);
		valueExpression.setValue(value);
				
		HySubtractionExpression subtractionExpression = expressionFactory.createHySubtractionExpression();
		subtractionExpression.setOperand1(valueExpression);
		subtractionExpression.setOperand2(nestedExpression);
		
		HyPreference preference = preferenceFactory.createHyPreference();
		preference.setRootExpression(subtractionExpression);
		preferenceModel.getPreferences().add(preference);

	}

	public void addAttributeOptimizationPreference() {

		for(HyFeature feature : featureModel.getFeatures()){
			for(HyFeatureAttribute attribute : feature.getAttributes()){
				HyAttributeReferenceExpression expression = expressionFactory.createHyAttributeReferenceExpression();
				expression.setAttribute(attribute);
				expression.setFeature(feature);
				
				HyMaximumExpression maxExpression = expressionFactory.createHyMaximumExpression();
				maxExpression.setOperand(expression);
				
				HyPreference preference = preferenceFactory.createHyPreference();
				preference.setRootExpression(maxExpression);
				
				preferenceModel.getPreferences().add(preference);
			}
		}
	}

	private String sendToHyVarRec(String content) {
		HttpClient client = new HttpClient();
		try {
			client.start();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		// send hyvarrec request
		Request hyvarrecRequest = client.POST(uri);
		hyvarrecRequest.header(HttpHeader.CONTENT_TYPE, "application/json");
		hyvarrecRequest.content(new StringContentProvider(content), "application/json");
		try {
			ContentResponse response = hyvarrecRequest.send();

			return response.getContentAsString();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (TimeoutException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return null;
	}

}
