package eu.hyvar.reconfigurator.input.rest.dummyclient;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpServletResponse;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.util.StringContentProvider;
import org.eclipse.jetty.http.HttpHeader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.christophseidl.util.ecore.EcoreIOUtil;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.reconfigurator.input.rest.dummyclient.hyconfig.HyConfigurationJson;
import eu.hyvar.reconfigurator.input.rest.dummyclient.hyvar_rec_answer.HyVarRecAnswer;
import eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.OutputOfHyVarRecAndFm;
import eu.hyvar.reconfigurator.input.rest.dummyclient.input_for_hyvarrec.InputForHyVarRec;
import eu.hyvar.reconfigurator.input.rest.dummyclient.output.Configuration;
import eu.hyvar.reconfigurator.input.rest.dummyclient.output.Constraints;
import eu.hyvar.reconfigurator.input.rest.dummyclient.output.Context;
import eu.hyvar.reconfigurator.input.rest.dummyclient.output.ContextModel;
import eu.hyvar.reconfigurator.input.rest.dummyclient.output.FeatureModel;
import eu.hyvar.reconfigurator.input.rest.dummyclient.output.RawInputForHyVarRec;
import eu.hyvar.reconfigurator.input.rest.dummyclient.output.ValidityFormulas;

public class Application implements IApplication {

	private static final String MSG_TYPE_RAW_HYVARREC = "raw_hyvarrec_input";
	
	private static final String MSG_TYPE_HYVARREC_CONFIG_2_HYCONFIG = "hyvarrec_config_plus_fm";
	
	private static final String FILENAME = "HyVarUseCaseReview";
	
	private static final String PROJECT_NAME = "HyVarRecIO";
	
	private static final String HYVARREC_CONFIG_FOLDER_NAME = "configFolder";
	
	private enum Scenario{
		RAW_HYVARREC_2_HYVARREC, HYVARREC_CONFIG_2_HYCONFIG
	}

	@Override
	public Object start(IApplicationContext context) throws Exception {
		
		Scenario scenario = Scenario.RAW_HYVARREC_2_HYVARREC;
		
		HttpClient client;
		URI uri;
		
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		
		String json = "";
		
		Request request;
		
		ContentResponse response;
		String answerString;
		
		switch(scenario) {
//		case HYVARREC_CONFIG_2_HYCONFIG:
//			
//			OutputOfHyVarRecAndFm hyVarRecOutputAndFM;
//			
//			try {
//				hyVarRecOutputAndFM = createHyVarRecOutputAndFM();
//			} catch (IOException e) {
//				e.printStackTrace();
//				return IApplication.EXIT_OK;
//			}
//			
//			client = new HttpClient();
//			client.start();
//			
//
//
//
////			uri = URI.create("http://192.168.99.100:8080/new_hyvarrec_config");
//			uri = URI.create("http://127.0.0.1:8080/new_hyvarrec_config");
//	
//
//			json = gson.toJson(hyVarRecOutputAndFM);
//			
//			System.out.println(json);
//
//			request = client.POST(uri);
//			request.header(HttpHeader.CONTENT_TYPE, "application/json");
//			request.content(new StringContentProvider(json), "application/json");
//
//			response = request.send();
//			System.out.println(response);
//			answerString = response.getContentAsString();
//			HyConfigurationJson config = gson.fromJson(answerString, HyConfigurationJson.class);
//			System.out.println("HyConfig answer: "+answerString);
//			
//			// Write to file and read
//			saveAndReadConfigFile(config, hyVarRecOutputAndFM);
//			
//			
//			break;
		
		case RAW_HYVARREC_2_HYVARREC:
			
			RawInputForHyVarRec output;	
			try {
				output = createRawHyVarRecOutput();			
			} catch(IOException e) {
				e.printStackTrace();
				return IApplication.EXIT_OK;
			}

			client = new HttpClient();
			client.start();

			uri = URI.create("http://localhost:8080/fm_for_hyvarrec");
//			uri = URI.create("http://192.168.99.100:8081/fm_for_hyvarrec");
//			uri = URI.create("http://hyvarfmtohyvarrec-env.eu-west-1.elasticbeanstalk.com/fm_for_hyvarrec");

			
			json = "";

			json = gson.toJson(output);
			
			System.out.println(json);

			request = client.POST(uri);
			request.header(HttpHeader.CONTENT_TYPE, "application/json");
			request.content(new StringContentProvider(json), "application/json");

			response = request.send();
			System.out.println(response);
			if(response.getStatus() != HttpServletResponse.SC_OK)
			{
				System.out.println("Could not connect to fm for hyvarrec service. Terminating");
				return IApplication.EXIT_OK;
			}
			answerString = response.getContentAsString();
			InputForHyVarRec answer = gson.fromJson(answerString, InputForHyVarRec.class);
			System.out.println("Input for HyVarRec: "+answerString);
			
			// send it to HyVarRec
			String hyvarrecJson = gson.toJson(answer);
			HttpClient hyvarrecClient = new HttpClient();
			hyvarrecClient.start();
			URI hyvarrecUri = URI.create("http://hyvarhyvarrec-env.eu-west-1.elasticbeanstalk.com/process");
			Request hyvarrecRequest = hyvarrecClient.POST(hyvarrecUri);
			hyvarrecRequest.header(HttpHeader.CONTENT_TYPE, "application/json");
			hyvarrecRequest.content(new StringContentProvider(hyvarrecJson), "application/json");
			ContentResponse hyvarrecResponse = hyvarrecRequest.send();
			String hyvarrecAnswerString = hyvarrecResponse.getContentAsString();
			System.out.println("HyVarRec Answer: "+hyvarrecAnswerString);
			
			
			// redirect the answer of hyvarrec again to fm_to_hyvarrec
			OutputOfHyVarRecAndFm outputAndFm = createHyVarRecOutputAndFMFromHyVarRecAnswer(hyvarrecAnswerString);
			

			HttpClient configClient = new HttpClient();
			configClient.start();

			URI configUri = URI.create("http://localhost:8080/new_hyvarrec_config");
//			URI configUri = URI.create("http://192.168.99.100:8081/new_hyvarrec_config");
//			URI configUri = URI.create("http://hyvarfmtohyvarrec-env.eu-west-1.elasticbeanstalk.com/new_hyvarrec_config");
	

			String configString = gson.toJson(outputAndFm);
			
			System.out.println(configString);

			Request configRequest = configClient.POST(configUri);
			configRequest.header(HttpHeader.CONTENT_TYPE, "application/json");
			configRequest.content(new StringContentProvider(configString), "application/json");

			ContentResponse configResponse = configRequest.send();
			if(configResponse.getStatus() != HttpServletResponse.SC_OK)
			{
				System.out.println("Could not connect to fm to hyvarrec service. Terminating");
				return IApplication.EXIT_OK;
			}
			System.out.println(configResponse);
			answerString = configResponse.getContentAsString();
			HyConfigurationJson hyvarConfig = gson.fromJson(answerString, HyConfigurationJson.class);
			System.out.println("HyConfig answer: "+answerString);
			
			PrintWriter printWriter = new PrintWriter("D:/HyVar/Implementations/_ExampleInputOutput/_Initial Data/models/HyVarUseCaseReview.hyconfigurationmodel");
			printWriter.write(hyvarConfig.getConfiguration().getSpecification());
			printWriter.flush();
			printWriter.close();
			
			break;
		
		}
		
		
		
		
		

		return IApplication.EXIT_OK;
	}
	

	private void saveAndReadConfigFile(HyConfigurationJson config, OutputOfHyVarRecAndFm hyVarRecOutputAndFM) {

		IProgressMonitor progressMonitor = new NullProgressMonitor();
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = workspaceRoot.getProject(PROJECT_NAME);
		
		try {
			if (!project.exists()) {
				project.create(progressMonitor);
			}
			project.open(progressMonitor);
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
		
		IFile configFile = folder.getFile(config.getConfiguration().getFilename() + ".hyconfiguration");
		InputStream inputStream = new ByteArrayInputStream(config.getConfiguration().getSpecification().getBytes());
		try {
			configFile.create(inputStream, true, progressMonitor);
			// fmFile.setContents(inputStream, IFile.FORCE, progressMonitor);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		
		IFile fmFile = folder.getFile(hyVarRecOutputAndFM.getFeatureModel().getFilename() + ".hyfeature");
		inputStream = new ByteArrayInputStream(hyVarRecOutputAndFM.getFeatureModel().getSpecification().getBytes());
		try {
			fmFile.create(inputStream, true, progressMonitor);
			// fmFile.setContents(inputStream, IFile.FORCE, progressMonitor);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		List<IFile> modelFiles = new ArrayList<IFile>();
		modelFiles.add(fmFile);
		modelFiles.add(configFile);
		
		List<EObject> models = EcoreIOUtil.loadModels(modelFiles);
		
		for(EObject eObject : models) {
			if(eObject instanceof HyFeatureModel) {
				System.out.println("Feature Model available");
			} else if(eObject instanceof HyConfiguration) {
				System.out.println("Configuration available");
			}
		}
		
	}
	
	private OutputOfHyVarRecAndFm createHyVarRecOutputAndFMFromHyVarRecAnswer(String hyVarRecAnswer) throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		HyVarRecAnswer hyvarrecAnswer = gson.fromJson(hyVarRecAnswer, HyVarRecAnswer.class);
		
		
		OutputOfHyVarRecAndFm hyVarRecOutputAndFM = new OutputOfHyVarRecAndFm();
		eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.FeatureModel fm = new eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.FeatureModel();
		
		
		FileInputStream fileReader;
		Scanner scanner;
		
		// Read Feature Model
		File fmFile = new File(
				"D:/HyVar/Implementations/_ExampleInputOutput/_Initial Data/models/"+FILENAME+".hyfeature");
		fileReader = new FileInputStream(fmFile);
		scanner = new Scanner(fileReader, "UTF-8");
		scanner.useDelimiter("\\A");
		String featureModelString = scanner.next();
		scanner.close();
		fileReader.close();
		
		fm.setFilename(FILENAME);
		fm.setSpecification(featureModelString);
		
		hyVarRecOutputAndFM.setFeatureModel(fm);
		
		hyVarRecOutputAndFM.setMsgType(MSG_TYPE_HYVARREC_CONFIG_2_HYCONFIG);
		
		hyVarRecOutputAndFM.setFeatures(hyvarrecAnswer.getFeatures());
		List<eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.Attribute> newAttributes = new ArrayList<eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.Attribute>();
		if(hyvarrecAnswer.getAttributes()!=null) {
			for(eu.hyvar.reconfigurator.input.rest.dummyclient.hyvar_rec_answer.Attribute attribute: hyvarrecAnswer.getAttributes()) {
				eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.Attribute newAttribute = new eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.Attribute();
				newAttribute.setId(attribute.getId());
				newAttribute.setValue(attribute.getValue());
			}
		}
		hyVarRecOutputAndFM.setAttributes(newAttributes);			
		
		return hyVarRecOutputAndFM;
	}
	
//	private OutputOfHyVarRecAndFm createHyVarRecOutputAndFM() throws IOException {
//
//		OutputOfHyVarRecAndFm hyVarRecOutputAndFM = new OutputOfHyVarRecAndFm();
//		eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.FeatureModel fm = new eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.FeatureModel();
//		
//		
//		FileInputStream fileReader;
//		Scanner scanner;
//
//		
//		// Read Feature Model
//		File fmFile = new File(
//				"D:/HyVar/Implementations/_ExampleInputOutput/_Initial Data/models/HyVarUseCaseReview.hyfeature");
//		fileReader = new FileInputStream(fmFile);
//		scanner = new Scanner(fileReader, "UTF-8");
//		scanner.useDelimiter("\\A");
//		String featureModelString = scanner.next();
//		scanner.close();
//		fileReader.close();
//		
//		fm.setFilename(FILENAME);
//		fm.setSpecification(featureModelString);
//		
//		hyVarRecOutputAndFM.setFeatureModel(fm);
//		
//		hyVarRecOutputAndFM.setMsgType(MSG_TYPE_HYVARREC_CONFIG_2_HYCONFIG);
//		
//		 //{"selectedFeatures": [1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1], "optimality": 1, "attributeValues": null}
//		
//		List<Integer> featureSelection = new ArrayList<Integer>();
//		featureSelection.add(1);
//		featureSelection.add(1);
//		featureSelection.add(1);
//		featureSelection.add(1);
//		featureSelection.add(1);
//		featureSelection.add(0);
//		featureSelection.add(1);
//		featureSelection.add(1);
//		featureSelection.add(0);
//		featureSelection.add(1);
//		featureSelection.add(1);
////		featureSelection.add(0);
////		featureSelection.add(0);
////		featureSelection.add(0);
////		featureSelection.add(1);
////		featureSelection.add(0);
////		featureSelection.add(1);
////		featureSelection.add(0);
////		featureSelection.add(1);
////		featureSelection.add(0);
////		featureSelection.add(0);
////		featureSelection.add(1);
////		featureSelection.add(0);
////		featureSelection.add(1);
////		featureSelection.add(0);
////		featureSelection.add(0);
////		featureSelection.add(1);
//		
//		hyVarRecOutputAndFM.setSelectedFeatures(featureSelection);
//		
//		// TODO test enum, boolean, int?
////		List<Integer> attributeValueAssignment = new ArrayList<Integer>();
////		attributeValueAssignment.add(200);
////		attributeValueAssignment.add(1);
//		
////		hyVarRecOutputAndFM.setAttributeValues(attributeValueAssignment);
//		
//		return hyVarRecOutputAndFM;
//	}
	

	private RawInputForHyVarRec createRawHyVarRecOutput() throws IOException {

		RawInputForHyVarRec rawInput = new RawInputForHyVarRec();


		FileInputStream fileReader;
		Scanner scanner;


		// Read from one json file
//		GsonBuilder gsonBuilder = new GsonBuilder();
//		Gson gson = gsonBuilder.create();
//		File rawHyVarRecInputFile = new File("D:/workspaces/HyVar/eu.hyvar.reconfigurator.input.rest.dummyclient/testdata/notWorking20160825/input_61_fails-1.json");
//		fileReader = new FileInputStream(rawHyVarRecInputFile);
//		scanner = new Scanner(fileReader, "UTF-8");
//		scanner.useDelimiter("\\A");
//		String rawHyVarRecString = scanner.next();
//		scanner.close();
//		rawInput = gson.fromJson(rawHyVarRecString, RawInputForHyVarRec.class);
		
		
		
//		Read from Model Files
		// Read Feature Model
		File fmFile = new File(
				"D:/HyVar/Implementations/_ExampleInputOutput/_Initial Data/models/"+FILENAME+".hyfeature");
		fileReader = new FileInputStream(fmFile);
		scanner = new Scanner(fileReader, "UTF-8");
		scanner.useDelimiter("\\A");
		String featureModelString = scanner.next();
		scanner.close();
		fileReader.close();

		// Read configuration
		File configFile = new File(
				"D:/HyVar/Implementations/_ExampleInputOutput/_Initial Data/models/"+FILENAME+".hyconfigurationmodel");
		fileReader = new FileInputStream(configFile);
		scanner = new Scanner(fileReader, "UTF-8");
		scanner.useDelimiter("\\A");
		String configString = scanner.next();
		scanner.close();
		fileReader.close();


		// Read constraint model
		File constraintsFile = new File(
				"D:/HyVar/Implementations/_ExampleInputOutput/_Initial Data/models/"+FILENAME+".hyconstraint");
		fileReader = new FileInputStream(constraintsFile);
		scanner = new Scanner(fileReader, "UTF-8");
		scanner.useDelimiter("\\A");
		String constraintString = scanner.next();
		scanner.close();
		fileReader.close();



		// Read context model
		File contextFile = new File(
				"D:/HyVar/Implementations/_ExampleInputOutput/_Initial Data/models/"+FILENAME+".hycontextmodel");
		fileReader = new FileInputStream(contextFile);
		scanner = new Scanner(fileReader, "UTF-8");
		scanner.useDelimiter("\\A");
		String contextString = scanner.next();
		scanner.close();
		fileReader.close();


		// Read validity model
		File validityFormulaFile = new File(
				"D:/HyVar/Implementations/_ExampleInputOutput/_Initial Data/models/"+FILENAME+".hyvaliditymodel");
		fileReader = new FileInputStream(validityFormulaFile);
		scanner = new Scanner(fileReader, "UTF-8");
		scanner.useDelimiter("\\A");
		String validityFormulaString = scanner.next();
		scanner.close();
		fileReader.close();

		// Fill input
		rawInput.setMsgType(MSG_TYPE_RAW_HYVARREC);
		
		Configuration config = new Configuration();
		config.setFilename(FILENAME);
		config.setSpecification(configString);
		rawInput.setConfiguration(config);
		
		Constraints constr = new Constraints();
		constr.setFilename(FILENAME);
		constr.setSpecification(constraintString);
		rawInput.setConstraints(constr);
		
		ContextModel contextModel = new ContextModel();
		contextModel.setFilename(FILENAME);
		contextModel.setSpecification(contextString);
		rawInput.setContextModel(contextModel);
		
		FeatureModel fm = new FeatureModel();
		fm.setFilename(FILENAME);
		fm.setSpecification(featureModelString);
		rawInput.setFeatureModel(fm);
		
		ValidityFormulas vali = new ValidityFormulas();
		vali.setFilename(FILENAME);
		vali.setSpecification(validityFormulaString);
		rawInput.setValidityFormulas(vali);
		
		Context context = new Context();
		context.setLat("1.1");
		context.setLng("1.9");
		
		rawInput.setContext(context);
		
		
		return rawInput;
	}

	@Override
	public void stop() {
		// Nothing to do
	}

}
