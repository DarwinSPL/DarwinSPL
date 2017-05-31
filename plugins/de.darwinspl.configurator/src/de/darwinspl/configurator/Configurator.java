package de.darwinspl.configurator;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyNumberAttribute;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.expression.HyAttributeReferenceExpression;
import eu.hyvar.feature.expression.HyExpressionFactory;
import eu.hyvar.feature.expression.HyIfPossibleExpression;
import eu.hyvar.feature.expression.HyMultiplicationExpression;
import eu.hyvar.feature.expression.HyNestedExpression;
import eu.hyvar.feature.expression.HySubtractionExpression;
import eu.hyvar.feature.expression.HyValueExpression;
import eu.hyvar.preferences.HyPreference;
import eu.hyvar.preferences.HyPreferenceModel;
import eu.hyvar.preferences.PreferencesFactory;
import eu.hyvar.reconfigurator.input.exporter.HyVarRecExporter;

public class Configurator {

	public enum Mode {
		MIN, MAX, CUSTOM
	}

	private HyPreferenceModel preferenceModel;

	private String uri;

	private HyFeatureModel featureModel;
	private HyConstraintModel constraintModel;
	private Date date;

	public Configurator(String uri, HyFeatureModel featureModel, HyConstraintModel constraintModel, Date date) {
		PreferencesFactory preferenceFactory = PreferencesFactory.eINSTANCE;
		this.preferenceModel = preferenceFactory.createHyPreferenceModel();

		this.uri = uri;
		this.featureModel = featureModel;
		this.constraintModel = constraintModel;
		this.date = date;
	}

	public String run() {
		HyVarRecExporter exporter = new HyVarRecExporter();
		String input = exporter.exportContextMappingModel(null, null, featureModel, constraintModel, null,
				preferenceModel, null, date);

		String output = sendToHyVarRec(input);

		System.out.println("HyVarRecInput: " + input);
		System.out.println("HyVarRecOutput: " + output);
		return output;
	}

	public void addPreference(HyPreference preference) {
		preferenceModel.getPreferences().add(preference);
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
