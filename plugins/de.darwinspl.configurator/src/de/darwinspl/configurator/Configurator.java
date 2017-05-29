package de.darwinspl.configurator;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.util.StringContentProvider;
import org.eclipse.jetty.http.HttpHeader;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.expression.HyExpressionFactory;
import eu.hyvar.feature.expression.HyFeatureReferenceExpression;
import eu.hyvar.feature.expression.HyIfPossibleExpression;
import eu.hyvar.feature.expression.HyNegationExpression;
import eu.hyvar.preferences.HyPreference;
import eu.hyvar.preferences.HyPreferenceModel;
import eu.hyvar.preferences.PreferencesFactory;
import eu.hyvar.reconfigurator.input.exporter.HyVarRecExporter;

public class Configurator {
	
	public Configurator(){
	}
	
	public void maxFeatures(String uri, HyFeatureModel featureModel, HyConstraintModel constraintModel, Date date) {
		
		//create preference model
		PreferencesFactory preferenceFactory = PreferencesFactory.eINSTANCE;
		HyPreferenceModel preferenceModel = preferenceFactory.createHyPreferenceModel();

		HyExpressionFactory expressionFactory = HyExpressionFactory.eINSTANCE;

		preferenceModel.setFeatureModel(featureModel);
		
	/* APPROACH 1
		
		for(HyFeature feature : featureModel.getFeatures()) {
				HyFeatureReferenceExpression featureExpression = expressionFactory.createHyFeatureReferenceExpression();
				featureExpression.setFeature(feature);
				
				//HyNegationExpression negationExpression = expressionFactory.createHyNegationExpression();
				//negationExpression.setOperand(featureExpression);
				
				HyPreference preference = preferenceFactory.createHyPreference();
				preference.setRootExpression(featureExpression);
				preferenceModel.getPreferences().add(preference);
					
		}

	*/
	/* APPROACH 2 */
		
		HyIfPossibleExpression ipExpression = expressionFactory.createHyIfPossibleExpression();

		// preferences to select the most features
		for (HyFeature feature : featureModel.getFeatures()) {
			
			HyFeatureReferenceExpression referenceExpression = expressionFactory
					.createHyFeatureReferenceExpression();
			referenceExpression.setFeature(feature);

			ipExpression.getOperands().add(referenceExpression);	

		}
		HyPreference preference = preferenceFactory.createHyPreference();
		preference.setRootExpression(ipExpression);
		preferenceModel.getPreferences().add(preference);
	

	/*	APPROACH 3 
	  
	  	HyFeature lastFeature = null;
		
		for(HyFeature feature : featureModel.getFeatures()) {
			if(lastFeature != null) {
				HyFeatureReferenceExpression featureExpression = expressionFactory.createHyFeatureReferenceExpression();
				HyFeatureReferenceExpression lastFeatureExpression = expressionFactory.createHyFeatureReferenceExpression();
				
				featureExpression.setFeature(feature);
				lastFeatureExpression.setFeature(lastFeature);
				
				HyAndExpression andExpression = expressionFactory.createHyAndExpression();
				andExpression.setOperand1(lastFeatureExpression);
				andExpression.setOperand2(featureExpression);
				
				HyPreference preference = preferenceFactory.createHyPreference();
				preference.setRootExpression(andExpression);
				preferenceModel.getPreferences().add(preference);
				
			}
			lastFeature = feature;	
		}

*/
		// export to hyvar
		HyVarRecExporter exporter = new HyVarRecExporter();
		String hyvarrec = exporter.exportContextMappingModel(null, null, featureModel, constraintModel, null,
				preferenceModel, null, date);

		System.out.println("HyVarRecInput: " + hyvarrec);
		System.out.println("HyVarRecOutput: " + sendToHyVarRec(hyvarrec, uri));
		
	//	DwConfiguratorDialog dialog = new DwConfiguratorDialog(getEditorSite().getShell(), featureModel);
	//	dialog.open();

	
	}
	
public void minFeatures(String uri, HyFeatureModel featureModel, HyConstraintModel constraintModel, Date date) {
		
		//create preference model
		PreferencesFactory preferenceFactory = PreferencesFactory.eINSTANCE;
		HyPreferenceModel preferenceModel = preferenceFactory.createHyPreferenceModel();

		HyExpressionFactory expressionFactory = HyExpressionFactory.eINSTANCE;

		preferenceModel.setFeatureModel(featureModel);
		
		HyIfPossibleExpression ipExpression = expressionFactory.createHyIfPossibleExpression();

		// preferences to select the most features
		for (HyFeature feature : featureModel.getFeatures()) {
			
			HyFeatureReferenceExpression referenceExpression = expressionFactory
					.createHyFeatureReferenceExpression();
			referenceExpression.setFeature(feature);

			HyNegationExpression negationExpression = expressionFactory.createHyNegationExpression();
			negationExpression.setOperand(referenceExpression);
			
			ipExpression.getOperands().add(negationExpression);	

		}
		HyPreference preference = preferenceFactory.createHyPreference();
		preference.setRootExpression(ipExpression);
		preferenceModel.getPreferences().add(preference);
	

		// export to hyvar
		HyVarRecExporter exporter = new HyVarRecExporter();
		String hyvarrec = exporter.exportContextMappingModel(null, null, featureModel, constraintModel, null,
				preferenceModel, null, date);

		System.out.println("HyVarRecInput: " + hyvarrec);
		System.out.println("HyVarRecOutput: " + sendToHyVarRec(hyvarrec, uri));
	}
	
	
	private String sendToHyVarRec(String content, String uri) {
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
