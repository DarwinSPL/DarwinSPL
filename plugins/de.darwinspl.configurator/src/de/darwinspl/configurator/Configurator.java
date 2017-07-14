package de.darwinspl.configurator;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.util.StringContentProvider;
import org.eclipse.jetty.http.HttpHeader;

import de.darwinspl.configurator.expression.exporter.CustomHyVarRecExporter;

import org.eclipse.jetty.client.api.Request;

import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.preferences.HyPreference;
import eu.hyvar.preferences.HyProfile;
import eu.hyvar.preferences.PreferencesFactory;

/**
 * collects preferences and sends all necessary data to hyvarrec to create a configuration
 * 
 * @author Jeremias Wrensch
 *
 */
public class Configurator {

	public enum Mode {
		MIN, MAX, CUSTOM
	}

	private HyProfile profile;

	private String uri;

	private HyFeatureModel featureModel;
	private HyConstraintModel constraintModel;
	private Date date;

	/**
	 * 
	 * @param uri hyvarrec-uri
	 * @param featureModel 
	 * @param constraintModel cross-tree-constraints
	 * @param date evolution date
	 */
	public Configurator(String uri, HyFeatureModel featureModel, HyConstraintModel constraintModel, Date date) {
		PreferencesFactory preferenceFactory = PreferencesFactory.eINSTANCE;
		this.profile = preferenceFactory.createHyProfile();

		this.uri = uri;
		this.featureModel = featureModel;
		this.constraintModel = constraintModel;
		this.date = date;
	}

	/**
	 * 
	 * exports the feature model, cross-tree-constraints to hyvarrec input
	 * and sends it to hyvarrec
	 * 
	 * @return generated configuration string
	 * @throws InterruptedException
	 * @throws TimeoutException
	 * @throws ExecutionException
	 */
	public String run() throws InterruptedException, TimeoutException, ExecutionException {
		CustomHyVarRecExporter exporter = new CustomHyVarRecExporter();
		String input = exporter.export(featureModel, constraintModel, profile, date);

		System.out.println("HyVarRecInput: " + input);
		long start = System.currentTimeMillis();

		String output = sendToHyVarRec(input);

		System.out.println("HyVarRecOutput: " + output);
		System.out.println("Solution took " + (System.currentTimeMillis() - start) + "ms to be found.");
		return output;
	}

	/**
	 * adds preferences that will be used for the generation of the configuration
	 * @param preference
	 */
	public void addPreference(HyPreference preference) {
		profile.getPreferences().add(preference);
	}

	/**
	 * 
	 * sends the content to hyvarrec and returns the result
	 * 
	 * @param content hyvarrec input
	 * @return result of hyvarrec
	 * @throws InterruptedException
	 * @throws TimeoutException
	 * @throws ExecutionException
	 */
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
