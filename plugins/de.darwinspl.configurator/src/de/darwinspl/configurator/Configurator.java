package de.darwinspl.configurator;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.util.StringContentProvider;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jface.dialogs.MessageDialog;

import de.darwinspl.configurator.expression.exporter.CustomHyVarRecExporter;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.preferences.HyPreference;
import eu.hyvar.preferences.HyProfile;
import eu.hyvar.preferences.PreferencesFactory;

public class Configurator {

	public enum Mode {
		MIN, MAX, CUSTOM
	}

	private HyProfile profile;

	private String uri;

	private HyFeatureModel featureModel;
	private HyConstraintModel constraintModel;
	private Date date;

	public Configurator(String uri, HyFeatureModel featureModel, HyConstraintModel constraintModel, Date date) {
		PreferencesFactory preferenceFactory = PreferencesFactory.eINSTANCE;
		this.profile = preferenceFactory.createHyProfile();

		this.uri = uri;
		this.featureModel = featureModel;
		this.constraintModel = constraintModel;
		this.date = date;
	}

	public String run() throws InterruptedException, TimeoutException, ExecutionException {
		CustomHyVarRecExporter exporter = new CustomHyVarRecExporter();
		String input = exporter.exportContextMappingModel(null, null, featureModel, constraintModel, null, profile,
				null, date);

		System.out.println("HyVarRecInput: " + input);
		long start = System.currentTimeMillis();

		String output = sendToHyVarRec(input);

		System.out.println("HyVarRecOutput: " + output);
		System.out.println("Solution took " + (System.currentTimeMillis() - start) + "ms to be found.");
		return output;
	}

	public void addPreference(HyPreference preference) {
		profile.getPreferences().add(preference);
	}

	private String sendToHyVarRec(String content) throws InterruptedException, TimeoutException, ExecutionException {
		HttpClient client = new HttpClient();
		try {
			client.start();
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		// send hyvarrec request
		Request hyvarrecRequest = client.POST(uri);
		hyvarrecRequest.header(HttpHeader.CONTENT_TYPE, "application/json");
		hyvarrecRequest.content(new StringContentProvider(content), "application/json");

		ContentResponse response = hyvarrecRequest.send();

		return response.getContentAsString();

	}

}
