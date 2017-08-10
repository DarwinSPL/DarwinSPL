package eu.hyvar.reconfigurator.io.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import de.christophseidl.util.ecore.EcoreIOUtil;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.util.HyConfigurationUtil;
import eu.hyvar.feature.util.HyFeatureUtil;
import eu.hyvar.reconfigurator.io.rest.input.hyvarrec_config.HyVarRecConfig;
import eu.hyvar.reconfigurator.io.rest.output.configurations.NewConfigurations;
import eu.hyvar.reconfigurator.io.rest.output.configurations.SignatureConfiguration;
import eu.hyvar.reconfigurator.io.rest.output.configurations.SignatureConfigurationModel;
import eu.hyvar.reconfigurator.output.translation.HyVarRecOutputTranslator;

public class JsonHandlerNewHyVarRecConfig extends AbstractHandler {

	// TODO much duplicated code - improve!

	// public static final String MSG_TYPE_JSON_INPUT = "raw_hyvarrec_input";
	public static final String MSG_TYPE_JSON_HYVARREC_OUTPUT = "hyvarrec_config_plus_fm";

	public static final String MSG_TYPE_JSON_HYCONFIG_OUTPUT = "configuration";

	private static final String PROJECT_NAME = "fmforhyvarrec";
	// private static final String HYVARREC_CONFIG_FOLDER_NAME =
	// "hyvarrec_config";

	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// read json contents of http request
		BufferedReader reader = request.getReader();
		StringBuilder sb = new StringBuilder();
		sb.append(reader.readLine());
		String jsonInput = sb.toString();

		JsonParser parser = new JsonParser();
		JsonObject obj = parser.parse(jsonInput).getAsJsonObject();
		String msgType = obj.get("msg_type").getAsString();

		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();

		if (msgType.equals(MSG_TYPE_JSON_HYVARREC_OUTPUT)) {

			// OutputOfHyVarRecAndFm hyvarrecConfig = gson.fromJson(jsonInput,
			// OutputOfHyVarRecAndFm.class);
			// String outputJson = createConfigJson(hyvarrecConfig);

			HyVarRecConfig hyVarRecConfig = gson.fromJson(jsonInput, HyVarRecConfig.class);

			String outputJson = createConfigJson(hyVarRecConfig);

			response.setContentType("application/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write(outputJson);
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
		}

	}

	private String createConfigJson(HyVarRecConfig hyVarRecConfig) {
		NewConfigurations newConfigurations = new NewConfigurations();
		newConfigurations.setSplId(hyVarRecConfig.getSplId());
		newConfigurations.setMsgType(MSG_TYPE_JSON_HYCONFIG_OUTPUT);
		newConfigurations.setSignatureConfigurations(new ArrayList<SignatureConfiguration>());

		Map<String, Integer> attributeValues = new HashMap<String, Integer>();

		for (eu.hyvar.reconfigurator.io.rest.input.hyvarrec_config.Attribute attributeValue : hyVarRecConfig
				.getAttributes()) {
			attributeValues.put(attributeValue.getId(), attributeValue.getValue());
		}

		IProgressMonitor progressMonitor = new NullProgressMonitor();
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = workspaceRoot.getProject(PROJECT_NAME);

		try {
			if (!project.exists()) {
				project.create(progressMonitor);
			}
			if (!project.isOpen()) {
				project.open(progressMonitor);
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}

		IFolder folder = null;
		while (folder == null || folder.exists()) {
			folder = project.getFolder(UUID.randomUUID().toString());
		}

		try {
			folder.create(true, true, progressMonitor);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		IFile fmFile = FileWriterUtility.writeFileWithContent(hyVarRecConfig.getFeatureModel().getFilename(),
				HyFeatureUtil.getFeatureModelFileExtensionForXmi(), hyVarRecConfig.getFeatureModel().getSpecification(),
				folder);

		HyFeatureModel featureModel = EcoreIOUtil.loadModel(fmFile);
		HyConfiguration configuration = HyVarRecOutputTranslator.translateConfiguration(featureModel,
				hyVarRecConfig.getFeatures(), attributeValues);

		eu.hyvar.reconfigurator.io.rest.output.configurations.Configuration configurationJson = new eu.hyvar.reconfigurator.io.rest.output.configurations.Configuration();
		configurationJson.setFilename(hyVarRecConfig.getFeatureModel().getFilename());
		configurationJson.setSpecification(
				readConfigurationFileContent(configuration, hyVarRecConfig.getFeatureModel().getFilename(), folder));

		newConfigurations.setConfiguration(configurationJson);

		for (eu.hyvar.reconfigurator.io.rest.input.hyvarrec_config.Dependency dependency : hyVarRecConfig
				.getDependencies()) {

			IFile dependencyFmFile = FileWriterUtility.writeFileWithContent(
					dependency.getDependencyFeatureModel().getFilename(),
					HyFeatureUtil.getFeatureModelFileExtensionForXmi(),
					dependency.getDependencyFeatureModel().getSpecification(), folder);

			HyFeatureModel dependencyFeatureModel = EcoreIOUtil.loadModel(dependencyFmFile);

			HyConfiguration dependencyConfiguration = HyVarRecOutputTranslator
					.translateConfiguration(dependencyFeatureModel, hyVarRecConfig.getFeatures(), attributeValues);

			SignatureConfiguration signatureConfiguration = new SignatureConfiguration();
			signatureConfiguration.setSignatureId(dependency.getSignatureId());

			SignatureConfigurationModel signatureConfigurationModel = new SignatureConfigurationModel();
			signatureConfigurationModel.setFilename(dependency.getDependencyFeatureModel().getFilename());
			signatureConfigurationModel.setSpecification(readConfigurationFileContent(dependencyConfiguration,
					dependency.getDependencyFeatureModel().getFilename(), folder));

			signatureConfiguration.setSignatureConfigurationModel(signatureConfigurationModel);

			newConfigurations.getSignatureConfigurations().add(signatureConfiguration);
		}

		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();

		try {
			folder.delete(true, progressMonitor);
			project.close(progressMonitor);
		} catch (CoreException e) {
			e.printStackTrace();
			return "Error when deleting folder: " + e.getMessage();
		}

		return gson.toJson(newConfigurations);

	}

	/**
	 * 
	 * @param configuration
	 * @param filename
	 * @param openedFolder
	 * @return may be null
	 */
	private String readConfigurationFileContent(HyConfiguration configuration, String filename, IFolder openedFolder) {
		IFile configFile = openedFolder
				.getFile(filename + "." + HyConfigurationUtil.getConfigurationModelFileExtensionForXmi());

		EcoreIOUtil.saveModelAs(configuration, configFile);

		// read file contents as String
		try {
			Scanner scanner;
			scanner = new Scanner(configFile.getContents(), "UTF-8");
			scanner.useDelimiter("\\A");
			String configString = scanner.next();
			// System.out.println(dependencyConfigString);
			scanner.close();

			return configString;

		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// @Deprecated
	// private String createConfigJson(OutputOfHyVarRecAndFm hyvarrecConfig) {
	//
	// IProgressMonitor progressMonitor = new NullProgressMonitor();
	// IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
	// IProject project = workspaceRoot.getProject(PROJECT_NAME);
	//
	// try {
	// if (!project.exists()) {
	// project.create(progressMonitor);
	// }
	// if(!project.isOpen()) {
	// project.open(progressMonitor);
	// }
	// } catch (CoreException e) {
	// e.printStackTrace();
	// }
	//
	// IFolder folder = null;
	// while(folder == null || folder.exists()) {
	// folder = project.getFolder(UUID.randomUUID().toString());
	//
	// try {
	// folder.create(true, true, progressMonitor);
	// } catch (CoreException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// IFile fmFile =
	// folder.getFile(hyvarrecConfig.getFeatureModel().getFilename() +
	// ".hyfeature");
	// InputStream inputStream = new
	// ByteArrayInputStream(hyvarrecConfig.getFeatureModel().getSpecification().getBytes());
	// try {
	// if(!fmFile.exists()) {
	// fmFile.create(inputStream, true, progressMonitor);
	// } else {
	// fmFile.setContents(inputStream, IFile.FORCE, progressMonitor);
	// }
	// } catch (CoreException e) {
	// e.printStackTrace();
	// }
	//
	//
	//
	// HyFeatureModel featureModel = EcoreIOUtil.loadModel(fmFile);
	//
	// OutputOfHyVarRec hyVarRecOutput = new OutputOfHyVarRec();
	// hyVarRecOutput.setFeatures(hyvarrecConfig.getFeatures());
	//
	// List<eu.hyvar.reconfigurator.output.translation.format.Attribute>
	// newAttributeValues = new
	// ArrayList<eu.hyvar.reconfigurator.output.translation.format.Attribute>();
	//
	// if(hyvarrecConfig.getAttributes() != null) {
	// for(eu.hyvar.reconfigurator.io.rest.input.hyvarrec_config_and_fm.Attribute
	// attributeValue : hyvarrecConfig.getAttributes()) {
	// eu.hyvar.reconfigurator.output.translation.format.Attribute
	// newAttributeValue = new
	// eu.hyvar.reconfigurator.output.translation.format.Attribute();
	// newAttributeValue.setId(attributeValue.getId());
	// newAttributeValue.setValue(attributeValue.getValue());
	// newAttributeValues.add(newAttributeValue);
	// }
	// }
	//
	// hyVarRecOutput.setAttributes(newAttributeValues);
	//
	// HyConfiguration configuration =
	// HyVarRecOutputTranslator.translateConfiguration(featureModel,
	// hyVarRecOutput);
	//
	// IFile configFile =
	// folder.getFile(hyvarrecConfig.getFeatureModel().getFilename() +
	// ".hyconfiguration");
	//
	// EcoreIOUtil.saveModelAs(configuration, configFile);
	//
	// try {
	// Scanner scanner;
	// scanner = new Scanner(configFile.getContents(), "UTF-8");
	// scanner.useDelimiter("\\A");
	// String configString = scanner.next();
	// System.out.println(configString);
	// scanner.close();
	//
	// HyConfigurationJson hyConfigJson = new HyConfigurationJson();
	// hyConfigJson.setMsgType(MSG_TYPE_JSON_HYCONFIG_OUTPUT);
	// Configuration config = new Configuration();
	// config.setSpecification(configString);
	// config.setFilename(hyvarrecConfig.getFeatureModel().getFilename());
	// hyConfigJson.setConfiguration(config);
	//
	// GsonBuilder builder = new GsonBuilder();
	// Gson gson = builder.create();
	//
	// try {
	// project.close(progressMonitor);
	// } catch (CoreException e) {
	// e.printStackTrace();
	// }
	//
	// return gson.toJson(hyConfigJson);
	//
	// } catch (CoreException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// try {
	// project.close(progressMonitor);
	// } catch (CoreException e) {
	// e.printStackTrace();
	// }
	//
	// // TODO
	// return "";
	// }

}
