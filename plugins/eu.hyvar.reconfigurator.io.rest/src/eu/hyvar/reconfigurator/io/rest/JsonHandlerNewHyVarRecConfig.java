package eu.hyvar.reconfigurator.io.rest;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
import eu.hyvar.reconfigurator.io.rest.hyconfiguration.Configuration;
import eu.hyvar.reconfigurator.io.rest.hyconfiguration.HyConfigurationJson;
import eu.hyvar.reconfigurator.io.rest.input.hyvarrec_config_and_fm.AttributeValue;
import eu.hyvar.reconfigurator.io.rest.input.hyvarrec_config_and_fm.OutputOfHyVarRecAndFm;
import eu.hyvar.reconfigurator.output.translation.HyVarRecOutputTranslator;
import eu.hyvar.reconfigurator.output.translation.format.OutputOfHyVarRec;

public class JsonHandlerNewHyVarRecConfig extends AbstractHandler {

	// TODO much duplicated code - improve!
	
	public static final String MSG_TYPE_JSON_INPUT = "raw_hyvarrec_input";
	public static final String MSG_TYPE_JSON_HYVARREC_OUTPUT = "hyvarrec_config_plus_fm";
	
	public static final String MSG_TYPE_JSON_HYCONFIG_OUTPUT = "hyconfig";
	
	private static final String PROJECT_NAME = "fmforhyvarrec";
	private static final String HYVARREC_CONFIG_FOLDER_NAME = "hyvarrec_config";

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
		
		if(msgType.equals(MSG_TYPE_JSON_HYVARREC_OUTPUT)) {
			
			OutputOfHyVarRecAndFm hyvarrecConfig = gson.fromJson(jsonInput, OutputOfHyVarRecAndFm.class);
			
			String outputJson = createConfigJson(hyvarrecConfig);

			response.setContentType("application/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write(outputJson);
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
		}

	}

	private String createConfigJson(OutputOfHyVarRecAndFm hyvarrecConfig) {
		
		IProgressMonitor progressMonitor = new NullProgressMonitor();
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = workspaceRoot.getProject(PROJECT_NAME);
		
		try {
			if (!project.exists()) {
				project.create(progressMonitor);
			}
			if(!project.isOpen()) {
				project.open(progressMonitor);				
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}

		IFolder folder = project.getFolder(HYVARREC_CONFIG_FOLDER_NAME);
		if (!folder.exists()) {
			try {
				folder.create(true, true, progressMonitor);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		
		IFile fmFile = folder.getFile(hyvarrecConfig.getFeatureModel().getFilename() + ".hyfeature");
		InputStream inputStream = new ByteArrayInputStream(hyvarrecConfig.getFeatureModel().getSpecification().getBytes());
		try {
			if(!fmFile.exists()) {
				fmFile.create(inputStream, true, progressMonitor);				
			} else {
				 fmFile.setContents(inputStream, IFile.FORCE, progressMonitor);				
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		
		
		HyFeatureModel featureModel = EcoreIOUtil.loadModel(fmFile);
		
		OutputOfHyVarRec hyVarRecOutput = new OutputOfHyVarRec();
		hyVarRecOutput.setSelectedFeatures(hyvarrecConfig.getSelectedFeatures());
		
		List<eu.hyvar.reconfigurator.output.translation.format.AttributeValue> newAttributeValues = new ArrayList<eu.hyvar.reconfigurator.output.translation.format.AttributeValue>();
		
		for(AttributeValue attributeValue : hyvarrecConfig.getAttributeValues()) {
			eu.hyvar.reconfigurator.output.translation.format.AttributeValue newAttributeValue = new eu.hyvar.reconfigurator.output.translation.format.AttributeValue();
			newAttributeValue.setId(attributeValue.getId());
			newAttributeValue.setValue(attributeValue.getValue());
			newAttributeValues.add(newAttributeValue);
		}
		
		hyVarRecOutput.setAttributeValues(newAttributeValues);
			
		HyConfiguration configuration = HyVarRecOutputTranslator.translateConfiguration(featureModel, hyVarRecOutput);
		
		IFile configFile = folder.getFile(hyvarrecConfig.getFeatureModel().getFilename() + ".hyconfiguration");
		
		EcoreIOUtil.saveModelAs(configuration, configFile);
		
		try {
			Scanner scanner;
			scanner = new Scanner(configFile.getContents(), "UTF-8");
			scanner.useDelimiter("\\A");
			String configString = scanner.next();
			System.out.println(configString);
			scanner.close();
			
			HyConfigurationJson hyConfigJson = new HyConfigurationJson();
			hyConfigJson.setMsgType(MSG_TYPE_JSON_HYCONFIG_OUTPUT);
			Configuration config = new Configuration();
			config.setSpecification(configString);
			config.setFilename(hyvarrecConfig.getFeatureModel().getFilename());
			hyConfigJson.setConfiguration(config);
			
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();
			
			try {
				project.close(progressMonitor);
			} catch (CoreException e) {
				e.printStackTrace();
			}
			
			return gson.toJson(hyConfigJson);
			
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			project.close(progressMonitor);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		// TODO
		return "";
	}
	
}
