package eu.hyvar.reconfigurator.input.rest.dummyclient;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

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
import eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.HyVarRecConfig;
import eu.hyvar.reconfigurator.input.rest.dummyclient.input_for_hyvarrec.InputForHyVarRec;
import eu.hyvar.reconfigurator.input.rest.dummyclient.raw_input_for_hyvarrec.Dependency;
import eu.hyvar.reconfigurator.input.rest.dummyclient.raw_input_for_hyvarrec.DependencyFeatureModel;
import eu.hyvar.reconfigurator.input.rest.dummyclient.raw_input_for_hyvarrec.DependencySignature;
import eu.hyvar.reconfigurator.input.rest.dummyclient.raw_input_for_hyvarrec.FeatureModel;
import eu.hyvar.reconfigurator.input.rest.dummyclient.raw_input_for_hyvarrec.Manifest;
import eu.hyvar.reconfigurator.input.rest.dummyclient.raw_input_for_hyvarrec.RawInputForHyVarRec;

public class FmToHyVarRecQueryThread extends Thread {


	private static final String MSG_TYPE_RAW_HYVARREC = "raw_hyvarrec_input";
	
	private static final String MSG_TYPE_HYVARREC_CONFIG_2_HYCONFIG = "hyvarrec_config_plus_fm";
	
	private static final String FILENAME = "HyVarUseCaseReview";
	
	private static final String PROJECT_NAME = "HyVarRecIO";
	
	private static final String HYVARREC_CONFIG_FOLDER_NAME = "configFolder";
	
	private enum Scenario{
		RAW_HYVARREC_2_HYVARREC, HYVARREC_CONFIG_2_HYCONFIG
	}
	

	@Override
	public void run() {
		for(int i=0; i<1;i++) {
			
		
		Scenario scenario = Scenario.RAW_HYVARREC_2_HYVARREC;
		
		HttpClient client;
		URI fm_for_hyvarrec_uri;
		
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
				return;
			}

			json = "";

			json = gson.toJson(output);
			
			System.out.println(json);
			
			client = new HttpClient();
			try {
				client.start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}

			fm_for_hyvarrec_uri = URI.create("http://localhost:8080/fm_for_hyvarrec");
//			uri = URI.create("http://hyvarfmtohyvarrec-env.eu-west-1.elasticbeanstalk.com/fm_for_hyvarrec/");


			request = client.POST(fm_for_hyvarrec_uri);
			request.header(HttpHeader.CONTENT_TYPE, "application/json");
			request.content(new StringContentProvider(json), "application/json");

			try {
				response = request.send();
			} catch (InterruptedException | TimeoutException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
			System.out.println(response);
			if(response.getStatus() != HttpServletResponse.SC_OK)
			{
				System.out.println("Could not connect to fm for hyvarrec service. Terminating");
				return;
			}
			answerString = response.getContentAsString();
			InputForHyVarRec answer = gson.fromJson(answerString, InputForHyVarRec.class);
			System.out.println("Input for HyVarRec: "+answerString);
			
			
			
			
			
			
			// send it to HyVarRec
			String hyvarrecJson = gson.toJson(answer);
			HttpClient hyvarrecClient = new HttpClient();
			try {
				hyvarrecClient.start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
			// Current HyVarRec URI
			
			
			
			
			
//			URI hyvarrecUri = URI.create("http://hyvarhyvarrec-env.eu-west-1.elasticbeanstalk.com/process");
			URI hyvarrecUri = URI.create("http://localhost:9001/process");
			
			
			
			Request hyvarrecRequest = hyvarrecClient.POST(hyvarrecUri);
			hyvarrecRequest.header(HttpHeader.CONTENT_TYPE, "application/json");
			hyvarrecRequest.content(new StringContentProvider(hyvarrecJson), "application/json");
			ContentResponse hyvarrecResponse;
			try {
				hyvarrecResponse = hyvarrecRequest.send();
			} catch (InterruptedException | TimeoutException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
			String hyvarrecAnswerString = hyvarrecResponse.getContentAsString();
			System.out.println("HyVarRec Answer: "+hyvarrecAnswerString);
			
			
			
			
			
			// send HyVarRec answer with FM again to Fm_for_hyvarrec
			
			// redirect the answer of hyvarrec again to fm_to_hyvarrec
			HyVarRecConfig outputAndFm = null;
			try {
				outputAndFm = createHyVarRecOutputAndFMFromHyVarRecAnswer(hyvarrecAnswerString);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
			
			json = gson.toJson(outputAndFm);
			
			System.out.println("FM and HyVarRec config input for fm_for_hyvarrece: "+json);
			
			client = new HttpClient();
			try {
				client.start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}

			URI fm_for_hyvarrec_uri_new_config = URI.create("http://localhost:8080/new_hyvarrec_config");
			
			
			request = client.POST(fm_for_hyvarrec_uri_new_config);
			request.header(HttpHeader.CONTENT_TYPE, "application/json");
			request.content(new StringContentProvider(json), "application/json");

			try {
				response = request.send();
			} catch (InterruptedException | TimeoutException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
			System.out.println(response);
			if(response.getStatus() != HttpServletResponse.SC_OK)
			{
				System.out.println("Could not connect to fm for hyvarrec service. Terminating");
				return;
			}
			answerString = response.getContentAsString();
		
			System.out.println("Answer configurations from fm_for_hyvarrec: "+answerString);
		}
		
		
		
		
		
		}
		return;
	}
	

	private void saveAndReadConfigFile(HyConfigurationJson config, HyVarRecConfig hyVarRecOutputAndFM) {

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
	
	private HyVarRecConfig createHyVarRecOutputAndFMFromHyVarRecAnswer(String hyVarRecAnswer) throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		HyVarRecAnswer hyvarrecAnswer = gson.fromJson(hyVarRecAnswer, HyVarRecAnswer.class);
		
		
		HyVarRecConfig hyVarRecOutputAndFM = new HyVarRecConfig();
//		eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.FeatureModel fm = new eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.FeatureModel();
		
		
		FileInputStream fileReader;
		Scanner scanner;
		
		// Read models
		
		String dateString = "2017/08/09";
		hyVarRecOutputAndFM.setDate(dateString);
		
		String spl_id = "1";
		hyVarRecOutputAndFM.setSplId(spl_id);
		
		String msg_type = "hyvarrec_config_plus_fm";
		
		File fmFile = new File(
				"D:/HyVar/Implementations/_ExampleInputOutput/M36/_initial_data/models/car/car.hyfeature");
		fileReader = new FileInputStream(fmFile);
		scanner = new Scanner(fileReader, "UTF-8");
		scanner.useDelimiter("\\A");
		String featureModelString = scanner.next();
		scanner.close();
		fileReader.close();
		
		
		File manifestFile = new File(
				"D:/HyVar/Implementations/_ExampleInputOutput/M36/_initial_data/models/car/car.hymanifest_xmi");
		fileReader = new FileInputStream(manifestFile);
		scanner = new Scanner(fileReader, "UTF-8");
		scanner.useDelimiter("\\A");
		String manifestString = scanner.next();
		scanner.close();
		fileReader.close();
		
		
		// ECU_A
		String ecuAdependencyId = "2";
		
		File ecuAdependencyFmFile = new File(
				"D:/HyVar/Implementations/_ExampleInputOutput/M36/_initial_data/models/signatures/ecuaS/ECUASignature.hyfeature");
		fileReader = new FileInputStream(ecuAdependencyFmFile);
		scanner = new Scanner(fileReader, "UTF-8");
		scanner.useDelimiter("\\A");
		String ecuAdependencyFmString = scanner.next();
		scanner.close();
		fileReader.close();
		
		File ecuAdependencySignatureFile = new File(
				"D:/HyVar/Implementations/_ExampleInputOutput/M36/_initial_data/models/signatures/ecuaS/ECUASignature.hymanifest_xmi");
		fileReader = new FileInputStream(ecuAdependencySignatureFile);
		scanner = new Scanner(fileReader, "UTF-8");
		scanner.useDelimiter("\\A");
		String ecuAdependencySignatureString = scanner.next();
		scanner.close();
		fileReader.close();
		
		// ECU_B
		String ecuBdependencyId = "3";
		
		File ecuBdependencyFmFile = new File(
				"D:/HyVar/Implementations/_ExampleInputOutput/M36/_initial_data/models/signatures/ecubS/ECUBSignature.hyfeature");
		fileReader = new FileInputStream(ecuBdependencyFmFile);
		scanner = new Scanner(fileReader, "UTF-8");
		scanner.useDelimiter("\\A");
		String ecuBdependencyFmString = scanner.next();
		scanner.close();
		fileReader.close();
		
		File ecuBdependencySignatureFile = new File(
				"D:/HyVar/Implementations/_ExampleInputOutput/M36/_initial_data/models/signatures/ecubS/ECUBSignature.hymanifest_xmi");
		fileReader = new FileInputStream(ecuBdependencySignatureFile);
		scanner = new Scanner(fileReader, "UTF-8");
		scanner.useDelimiter("\\A");
		String ecuBdependencySignatureString = scanner.next();
		scanner.close();
		fileReader.close();
		
		
		// ECU_C
		String ecuCdependencyId = "4";
		
		File ecuCdependencyFmFile = new File(
				"D:/HyVar/Implementations/_ExampleInputOutput/M36/_initial_data/models/signatures/ecucS/ECUCSignature.hyfeature");
		fileReader = new FileInputStream(ecuCdependencyFmFile);
		scanner = new Scanner(fileReader, "UTF-8");
		scanner.useDelimiter("\\A");
		String ecuCdependencyFmString = scanner.next();
		scanner.close();
		fileReader.close();
		
		File ecuCdependencySignatureFile = new File(
				"D:/HyVar/Implementations/_ExampleInputOutput/M36/_initial_data/models/signatures/ecucS/ECUCSignature.hymanifest_xmi");
		fileReader = new FileInputStream(ecuCdependencySignatureFile);
		scanner = new Scanner(fileReader, "UTF-8");
		scanner.useDelimiter("\\A");
		String ecuCdependencySignatureString = scanner.next();
		scanner.close();
		fileReader.close();
		
//		fm.setFilename(FILENAME);
//		fm.setSpecification(featureModelString);
		
//		hyVarRecOutputAndFM.setFeatureModel(fm);
		
		hyVarRecOutputAndFM.setMsgType(msg_type);
		hyVarRecOutputAndFM.setSplId(spl_id);		
		hyVarRecOutputAndFM.setDate(dateString);
		
		eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.FeatureModel fm = new eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.FeatureModel();
		fm.setFilename("car/car");
		fm.setSpecification(featureModelString);
		hyVarRecOutputAndFM.setFeatureModel(fm);
		
		eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.Manifest manifest = new eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.Manifest();
		manifest.setFilename("car/car");
		manifest.setSpecification(manifestString);
		hyVarRecOutputAndFM.setManifest(manifest);
		
		List<eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.Dependency> dependencies = new ArrayList<eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.Dependency>(3);
		hyVarRecOutputAndFM.setDependencies(dependencies);
		
		// dependencies
		
		// ECU_A
		eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.Dependency dependencyA = new eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.Dependency();
		dependencyA.setSignatureId(ecuAdependencyId);
		
		eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.DependencyFeatureModel featureModelA = new eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.DependencyFeatureModel();
		featureModelA.setFilename("signatures/ecuaS/ECUASignature");
		featureModelA.setSpecification(ecuAdependencyFmString);
		dependencyA.setDependencyFeatureModel(featureModelA);
		
		eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.DependencySignature signatureA = new eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.DependencySignature();
		signatureA.setFilename("signatures/ecuaS/ECUASignature");
		signatureA.setSpecification(ecuAdependencySignatureString);
		dependencyA.setDependencySignature(signatureA);
		
		dependencies.add(dependencyA);
		
		// ECU_B
		eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.Dependency dependencyB = new eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.Dependency();
		dependencyB.setSignatureId(ecuBdependencyId);
		
		eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.DependencyFeatureModel featureModelB = new eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.DependencyFeatureModel();
		featureModelB.setFilename("signatures/ecubS/ECUBSignature");
		featureModelB.setSpecification(ecuBdependencyFmString);
		dependencyB.setDependencyFeatureModel(featureModelB);
		
		eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.DependencySignature signatureB = new eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.DependencySignature();
		signatureB.setFilename("signatures/ecubS/ECUBSignature");
		signatureB.setSpecification(ecuBdependencySignatureString);
		dependencyB.setDependencySignature(signatureB);
		
		dependencies.add(dependencyB);
		
		// ECU_C
		eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.Dependency dependencyC = new eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.Dependency();
		dependencyC.setSignatureId(ecuCdependencyId);
		
		eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.DependencyFeatureModel featureModelC = new eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.DependencyFeatureModel();
		featureModelC.setFilename("signatures/ecucS/ECUCSignature");
		featureModelC.setSpecification(ecuCdependencyFmString);
		dependencyC.setDependencyFeatureModel(featureModelC);
		
		eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.DependencySignature signatureC = new eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.DependencySignature();
		signatureC.setFilename("signatures/ecucS/ECUCSignature");
		signatureC.setSpecification(ecuCdependencySignatureString);
		dependencyC.setDependencySignature(signatureC);
		
		dependencies.add(dependencyC);
		
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
	
	
	private RawInputForHyVarRec createRawHyVarRecOutputOfCar() throws IOException {
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
		
		String dateString = "2017/08/09";
		String spl_id = "1";
		
		String msg_type = "raw_hyvarrec_input";
		
		File fmFile = new File(
				"D:/HyVar/Implementations/_ExampleInputOutput/M36/_initial_data/models/car/car.hyfeature");
		fileReader = new FileInputStream(fmFile);
		scanner = new Scanner(fileReader, "UTF-8");
		scanner.useDelimiter("\\A");
		String featureModelString = scanner.next();
		scanner.close();
		fileReader.close();
		
		
		File manifestFile = new File(
				"D:/HyVar/Implementations/_ExampleInputOutput/M36/_initial_data/models/car/car.hymanifest_xmi");
		fileReader = new FileInputStream(manifestFile);
		scanner = new Scanner(fileReader, "UTF-8");
		scanner.useDelimiter("\\A");
		String manifestString = scanner.next();
		scanner.close();
		fileReader.close();
		
		// TODO old configuration
		
		// dependencies 
		
		
		// ECU_A
		String ecuAdependencyId = "2";
		
		File ecuAdependencyFmFile = new File(
				"D:/HyVar/Implementations/_ExampleInputOutput/M36/_initial_data/models/signatures/ecuaS/ECUASignature.hyfeature");
		fileReader = new FileInputStream(ecuAdependencyFmFile);
		scanner = new Scanner(fileReader, "UTF-8");
		scanner.useDelimiter("\\A");
		String ecuAdependencyFmString = scanner.next();
		scanner.close();
		fileReader.close();
		
		File ecuAdependencySignatureFile = new File(
				"D:/HyVar/Implementations/_ExampleInputOutput/M36/_initial_data/models/signatures/ecuaS/ECUASignature.hymanifest_xmi");
		fileReader = new FileInputStream(ecuAdependencySignatureFile);
		scanner = new Scanner(fileReader, "UTF-8");
		scanner.useDelimiter("\\A");
		String ecuAdependencySignatureString = scanner.next();
		scanner.close();
		fileReader.close();
		
		// ECU_B
		String ecuBdependencyId = "3";
		
		File ecuBdependencyFmFile = new File(
				"D:/HyVar/Implementations/_ExampleInputOutput/M36/_initial_data/models/signatures/ecubS/ECUBSignature.hyfeature");
		fileReader = new FileInputStream(ecuBdependencyFmFile);
		scanner = new Scanner(fileReader, "UTF-8");
		scanner.useDelimiter("\\A");
		String ecuBdependencyFmString = scanner.next();
		scanner.close();
		fileReader.close();
		
		File ecuBdependencySignatureFile = new File(
				"D:/HyVar/Implementations/_ExampleInputOutput/M36/_initial_data/models/signatures/ecubS/ECUBSignature.hymanifest_xmi");
		fileReader = new FileInputStream(ecuBdependencySignatureFile);
		scanner = new Scanner(fileReader, "UTF-8");
		scanner.useDelimiter("\\A");
		String ecuBdependencySignatureString = scanner.next();
		scanner.close();
		fileReader.close();
		
		
		// ECU_C
		String ecuCdependencyId = "4";
		
		File ecuCdependencyFmFile = new File(
				"D:/HyVar/Implementations/_ExampleInputOutput/M36/_initial_data/models/signatures/ecucS/ECUCSignature.hyfeature");
		fileReader = new FileInputStream(ecuCdependencyFmFile);
		scanner = new Scanner(fileReader, "UTF-8");
		scanner.useDelimiter("\\A");
		String ecuCdependencyFmString = scanner.next();
		scanner.close();
		fileReader.close();
		
		File ecuCdependencySignatureFile = new File(
				"D:/HyVar/Implementations/_ExampleInputOutput/M36/_initial_data/models/signatures/ecucS/ECUCSignature.hymanifest_xmi");
		fileReader = new FileInputStream(ecuCdependencySignatureFile);
		scanner = new Scanner(fileReader, "UTF-8");
		scanner.useDelimiter("\\A");
		String ecuCdependencySignatureString = scanner.next();
		scanner.close();
		fileReader.close();

		
		
		
		//TODO  Read configuration
//		File configFile = new File(
//				"D:/HyVar/Implementations/_ExampleInputOutput/_Initial Data/models/"+FILENAME+".hyconfigurationmodel");
//		fileReader = new FileInputStream(configFile);
//		scanner = new Scanner(fileReader, "UTF-8");
//		scanner.useDelimiter("\\A");
//		String configString = scanner.next();
//		scanner.close();
//		fileReader.close();


		// Read constraint model
//		File constraintsFile = new File(
//				"D:/HyVar/Implementations/_ExampleInputOutput/_Initial Data/models/"+FILENAME+".hyconstraint");
//		fileReader = new FileInputStream(constraintsFile);
//		scanner = new Scanner(fileReader, "UTF-8");
//		scanner.useDelimiter("\\A");
//		String constraintString = scanner.next();
//		scanner.close();
//		fileReader.close();
//
//
//
//		// Read context model
//		File contextFile = new File(
//				"D:/HyVar/Implementations/_ExampleInputOutput/_Initial Data/models/"+FILENAME+".hycontextmodel");
//		fileReader = new FileInputStream(contextFile);
//		scanner = new Scanner(fileReader, "UTF-8");
//		scanner.useDelimiter("\\A");
//		String contextString = scanner.next();
//		scanner.close();
//		fileReader.close();
//
//
//		// Read validity model
//		File validityFormulaFile = new File(
//				"D:/HyVar/Implementations/_ExampleInputOutput/_Initial Data/models/"+FILENAME+".hyvaliditymodel");
//		fileReader = new FileInputStream(validityFormulaFile);
//		scanner = new Scanner(fileReader, "UTF-8");
//		scanner.useDelimiter("\\A");
//		String validityFormulaString = scanner.next();
//		scanner.close();
//		fileReader.close();

		// Fill input
		rawInput.setMsgType(msg_type);
		rawInput.setSplId(spl_id);		
		rawInput.setDate(dateString);
		
		FeatureModel fm = new FeatureModel();
		fm.setFilename("car/car");
		fm.setSpecification(featureModelString);
		rawInput.setFeatureModel(fm);
		
		Manifest manifest = new Manifest();
		manifest.setFilename("car/car");
		manifest.setSpecification(manifestString);
		rawInput.setManifest(manifest);
		
		List<Dependency> dependencies = new ArrayList<Dependency>(3);
		rawInput.setDependencies(dependencies);
		
		// dependencies
		
		// ECU_A
		Dependency dependencyA = new Dependency();
		dependencyA.setSignatureId(ecuAdependencyId);
		
		DependencyFeatureModel featureModelA = new DependencyFeatureModel();
		featureModelA.setFilename("signatures/ecuaS/ECUASignature");
		featureModelA.setSpecification(ecuAdependencyFmString);
		dependencyA.setDependencyFeatureModel(featureModelA);
		
		DependencySignature signatureA = new DependencySignature();
		signatureA.setFilename("signatures/ecuaS/ECUASignature");
		signatureA.setSpecification(ecuAdependencySignatureString);
		dependencyA.setDependencySignature(signatureA);
		
		dependencies.add(dependencyA);
		
		// ECU_B
		Dependency dependencyB = new Dependency();
		dependencyB.setSignatureId(ecuBdependencyId);
		
		DependencyFeatureModel featureModelB = new DependencyFeatureModel();
		featureModelB.setFilename("signatures/ecubS/ECUBSignature");
		featureModelB.setSpecification(ecuBdependencyFmString);
		dependencyB.setDependencyFeatureModel(featureModelB);
		
		DependencySignature signatureB = new DependencySignature();
		signatureB.setFilename("signatures/ecubS/ECUBSignature");
		signatureB.setSpecification(ecuBdependencySignatureString);
		dependencyB.setDependencySignature(signatureB);
		
		dependencies.add(dependencyB);
		
		// ECU_C
		Dependency dependencyC = new Dependency();
		dependencyC.setSignatureId(ecuCdependencyId);
		
		DependencyFeatureModel featureModelC = new DependencyFeatureModel();
		featureModelC.setFilename("signatures/ecucS/ECUCSignature");
		featureModelC.setSpecification(ecuCdependencyFmString);
		dependencyC.setDependencyFeatureModel(featureModelC);
		
		DependencySignature signatureC = new DependencySignature();
		signatureC.setFilename("signatures/ecucS/ECUCSignature");
		signatureC.setSpecification(ecuCdependencySignatureString);
		dependencyC.setDependencySignature(signatureC);
		
		dependencies.add(dependencyC);
		
		return rawInput;
	}

	private RawInputForHyVarRec createRawHyVarRecOutput() throws IOException {
		
		return createRawHyVarRecOutputOfCar();
		
		
		
//		return rawInput;
	}
	
}
