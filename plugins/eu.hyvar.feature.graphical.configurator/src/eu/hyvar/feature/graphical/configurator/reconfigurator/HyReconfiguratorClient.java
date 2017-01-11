package eu.hyvar.feature.graphical.configurator.reconfigurator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import javax.servlet.http.HttpServletResponse;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.util.StringContentProvider;
import org.eclipse.jetty.http.HttpHeader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.contextValidity.HyValidityModel;
import eu.hyvar.context.information.contextValue.HyContextValueModel;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.preferences.HyPreferenceModel;
import eu.hyvar.reconfigurator.input.exporter.HyVarRecExporter;
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
import eu.hyvar.reconfigurator.output.translation.HyVarRecOutputTranslator;
import eu.hyvar.reconfigurator.output.translation.format.OutputOfHyVarRec;

public class HyReconfiguratorClient {
	private static final String MSG_TYPE_RAW_HYVARREC = "raw_hyvarrec_input";

	private static final String MSG_TYPE_HYVARREC_CONFIG_2_HYCONFIG = "hyvarrec_config_plus_fm";

	private static final String FILENAME = "HyVarUseCaseReview";

	HttpClient client;
	URI uri;

	GsonBuilder builder = new GsonBuilder();
	Gson gson = builder.create();

	String json = "";

	Request request;

	ContentResponse response;
	String answerString;
	
	public HyConfiguration reconfigure(HyContextModel contextModel, HyValidityModel contextValidityModel,
			HyFeatureModel featureModel, HyConstraintModel constraintModel, HyConfiguration oldConfiguration,
			HyPreferenceModel preferenceModel, HyContextValueModel contextValues, Date date) {
		
		HyVarRecExporter exporter = new HyVarRecExporter();
		String messageForHyVarRec = exporter.exportContextMappingModel(contextModel, contextValidityModel, featureModel, constraintModel, oldConfiguration, preferenceModel, contextValues, date);
		
		
//		InputForHyVarRec answer = gson.fromJson(answerString, InputForHyVarRec.class);
//		System.out.println("Input for HyVarRec: "+answerString);
//
//		// send it to HyVarRec
//		String hyvarrecJson = gson.toJson(answer);
		HttpClient hyvarrecClient = new HttpClient();
		try {
			hyvarrecClient.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		// Current HyVarRec URI. TODO should be configurable
		URI hyvarrecUri = URI.create("http://hyvarhyvarrec-env.eu-west-1.elasticbeanstalk.com/process");
		Request hyvarrecRequest = hyvarrecClient.POST(hyvarrecUri);
		hyvarrecRequest.header(HttpHeader.CONTENT_TYPE, "application/json");
		hyvarrecRequest.content(new StringContentProvider(messageForHyVarRec), "application/json");
		ContentResponse hyvarrecResponse;
		String hyvarrecAnswerString = "";
		try {
			hyvarrecResponse = hyvarrecRequest.send();
			hyvarrecAnswerString = hyvarrecResponse.getContentAsString();
		} catch (InterruptedException | TimeoutException | ExecutionException e) {
			e.printStackTrace();
			return null;
		}

		// Only for Debug
		System.out.println("HyVarRec Answer: "+hyvarrecAnswerString);
		
		OutputOfHyVarRec hyvarrecAnswer = gson.fromJson(hyvarrecAnswerString, OutputOfHyVarRec.class);
//		hyvarrecAnswer.get
		
		HyConfiguration configuration = HyVarRecOutputTranslator.translateConfiguration(featureModel, hyvarrecAnswer);
		
		return configuration;
	}

	public boolean start(URI uri, IPath path){
		RawInputForHyVarRec output = null;	
		try {
			output = createRawHyVarRecOutput(path);			
		} catch(IOException e) {
			e.printStackTrace();
			return false;
		}

		client = new HttpClient();
		try {
			client.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.uri = uri;


		json = "";
		json = gson.toJson(output);
		System.out.println(json);

		request = client.POST(uri);
		request.header(HttpHeader.CONTENT_TYPE, "application/json");
		request.content(new StringContentProvider(json), "application/json");

		try {
			response = request.send();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		System.out.println(response);
		if(response.getStatus() != HttpServletResponse.SC_OK)
		{
			System.err.println("Could not connect to fm for hyvarrec service. Terminating");
			return false;
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
			return false;
		}
		// Current HyVarRec URI
		URI hyvarrecUri = URI.create("http://hyvarhyvarrec-env.eu-west-1.elasticbeanstalk.com/process");
		Request hyvarrecRequest = hyvarrecClient.POST(hyvarrecUri);
		hyvarrecRequest.header(HttpHeader.CONTENT_TYPE, "application/json");
		hyvarrecRequest.content(new StringContentProvider(hyvarrecJson), "application/json");
		ContentResponse hyvarrecResponse;
		String hyvarrecAnswerString = "";
		try {
			hyvarrecResponse = hyvarrecRequest.send();
			hyvarrecAnswerString = hyvarrecResponse.getContentAsString();
		} catch (InterruptedException | TimeoutException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		System.out.println("HyVarRec Answer: "+hyvarrecAnswerString);

		
		// redirect the answer of hyvarrec again to fm_to_hyvarrec
		OutputOfHyVarRecAndFm outputAndFm = null;
		try {
			outputAndFm = createHyVarRecOutputAndFMFromHyVarRecAnswer(path, hyvarrecAnswerString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}


		HttpClient configClient = new HttpClient();
		try {
			configClient.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

		URI configUri = URI.create("http://localhost:8080/new_hyvarrec_config");
		String configString = gson.toJson(outputAndFm);

		System.out.println(configString);

		Request configRequest = configClient.POST(configUri);
		configRequest.header(HttpHeader.CONTENT_TYPE, "application/json");
		configRequest.content(new StringContentProvider(configString), "application/json");

		ContentResponse configResponse = null;
		try {
			configResponse = configRequest.send();
		} catch (InterruptedException | TimeoutException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(configResponse.getStatus() != HttpServletResponse.SC_OK)
		{
			System.err.println("Could not connect to fm to hyvarrec service. Terminating");
			return false;
		}
		System.out.println(configResponse);
		answerString = configResponse.getContentAsString();
		HyConfigurationJson hyvarConfig = gson.fromJson(answerString, HyConfigurationJson.class);
		System.out.println("HyConfig answer: "+answerString);

		PrintWriter printWriter;
		try {
			File fmFile = new File(getURIForFile(path, "hyconfigurationmodel"));
			printWriter = new PrintWriter(fmFile);
			printWriter.write(hyvarConfig.getConfiguration().getSpecification());
			printWriter.flush();
			printWriter.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	private URI getURIForFile(IPath path, String extension){
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();

		IPath tempPath = ((IPath)path.clone()).addFileExtension(extension);
		IFile file = workspaceRoot.getFile(tempPath);

		URI uri = file.getLocationURI();

		if(file.isLinked()){
			uri = file.getRawLocationURI();
		}

		return uri;
	}

	private RawInputForHyVarRec createRawHyVarRecOutput(IPath path) throws IOException {

		RawInputForHyVarRec rawInput = new RawInputForHyVarRec();


		FileInputStream fileReader;
		Scanner scanner;

		String fileName = path.lastSegment();
		

		// Read Feature Model
		File fmFile = new File(getURIForFile(path, "hyfeature"));
		fileReader = new FileInputStream(fmFile);
		scanner = new Scanner(fileReader, "UTF-8");
		scanner.useDelimiter("\\A");
		String featureModelString = scanner.next();
		scanner.close();
		fileReader.close();

		// Read configuration
		File configFile = new File(getURIForFile(path, "hyconfigurationmodel"));
		fileReader = new FileInputStream(configFile);
		scanner = new Scanner(fileReader, "UTF-8");
		scanner.useDelimiter("\\A");
		String configString = scanner.next();
		scanner.close();
		fileReader.close();


		// Read constraint model
		File constraintsFile = new File(getURIForFile(path, "hyconstraint"));
		String constraintString = "";
		if(constraintsFile.exists() && !constraintsFile.isDirectory()){
			fileReader = new FileInputStream(constraintsFile);
			scanner = new Scanner(fileReader, "UTF-8");
			scanner.useDelimiter("\\A");
			constraintString = scanner.next();
			scanner.close();
			fileReader.close();
		}


		// Read context model
		File contextFile = new File(getURIForFile(path, "hycontextmodel"));
		String contextString = "";
		if(contextFile.exists() && !contextFile.isDirectory()){
			fileReader = new FileInputStream(contextFile);
			scanner = new Scanner(fileReader, "UTF-8");
			scanner.useDelimiter("\\A");
			contextString = scanner.next();
			scanner.close();
			fileReader.close();
		}


		// Read validity model
		File validityFormulaFile = new File(getURIForFile(path, "hyvaliditymodel"));
		String validityFormulaString = "";
		if(validityFormulaFile.exists() && !validityFormulaFile.isDirectory()){
			fileReader = new FileInputStream(validityFormulaFile);
			scanner = new Scanner(fileReader, "UTF-8");
			scanner.useDelimiter("\\A");
			validityFormulaString = scanner.next();
			scanner.close();
			fileReader.close();
		}

		// Fill input
		rawInput.setMsgType(MSG_TYPE_RAW_HYVARREC);

		Configuration config = new Configuration();
		config.setFilename(fileName);
		config.setSpecification(configString);
		rawInput.setConfiguration(config);

		Constraints constr = new Constraints();
		constr.setFilename(fileName);
		constr.setSpecification(constraintString);
		rawInput.setConstraints(constr);

		ContextModel contextModel = new ContextModel();
		contextModel.setFilename(fileName);
		contextModel.setSpecification(contextString);
		rawInput.setContextModel(contextModel);

		FeatureModel fm = new FeatureModel();
		fm.setFilename(fileName);
		fm.setSpecification(featureModelString);
		rawInput.setFeatureModel(fm);

		ValidityFormulas vali = new ValidityFormulas();
		vali.setFilename(fileName);
		vali.setSpecification(validityFormulaString);
		rawInput.setValidityFormulas(vali);

		Context context = new Context();
		context.setLat("1.1");
		context.setLng("1.9");

		rawInput.setContext(context);


		return rawInput;
	}

	private OutputOfHyVarRecAndFm createHyVarRecOutputAndFMFromHyVarRecAnswer(IPath path, String hyVarRecAnswer) throws IOException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		HyVarRecAnswer hyvarrecAnswer = gson.fromJson(hyVarRecAnswer, HyVarRecAnswer.class);


		OutputOfHyVarRecAndFm hyVarRecOutputAndFM = new OutputOfHyVarRecAndFm();
		eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.FeatureModel fm = new eu.hyvar.reconfigurator.input.rest.dummyclient.hyvarrec_config.FeatureModel();


		FileInputStream fileReader;
		Scanner scanner;

		// Read Feature Model
		File fmFile = new File(getURIForFile(path, "hyfeature"));
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
}
