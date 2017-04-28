package eu.hyvar.feature.exporter.hfm_exporter.rest.dummyclient;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.deltaecore.feature.DEFeatureModel;
import org.deltaecore.feature.configuration.DEConfiguration;
import org.deltaecore.suite.mapping.DEMappingModel;
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
import de.darwinspl.common.util.FileUtil;
import eu.hyvar.feature.exporter.hfm_exporter.rest.dummyclient.answer.DeltaEcoreAnswer;
import eu.hyvar.feature.exporter.hfm_exporter.rest.dummyclient.output.Configuration;
import eu.hyvar.feature.exporter.hfm_exporter.rest.dummyclient.output.FeatureModel;
import eu.hyvar.feature.exporter.hfm_exporter.rest.dummyclient.output.HyVarOutput;
import eu.hyvar.feature.exporter.hfm_exporter.rest.dummyclient.output.Mapping;

public class Application implements IApplication {

	private static final String MSG_TYPE_OUTPUT = "hyvar2deltaecore";
	private static final String MSG_TYPE_ANSWER = "variantgen_spl";

	private static final String FILENAME = "HyVarUseCaseReview";

	private static final String PROJECT_NAME = "hyvar_to_deltaecore_answer";

	private static final String DELTAECORE_FOLDER = "deltaecore_models";
//
//	private enum Scenario {
//		RAW_HYVARREC_2_HYVARREC, HYVARREC_CONFIG_2_HYCONFIG
//	}

	@Override
	public Object start(IApplicationContext context) throws Exception {

		// Scenario scenario = Scenario.HYVARREC_CONFIG_2_HYCONFIG;

		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();

//		String json = gson.toJson(createOutput());
		
		File jsonFile = new File("D:\\HyVar\\Implementations\\_ExampleInputOutput\\Input 10.1\\input_10_1.txt");
		String json = FileUtil.readFileContent(jsonFile);

		FileWriter out = new FileWriter("D:/repositories/DarwinSPL/plugins/eu.hyvar.feature.exporter.hfm_exporter.rest.dummyclient/models/output.json");
		out.write(json);
		out.flush();
		out.close();
		
		Request request;

		ContentResponse response;

		String answerString;

		HttpClient client = new HttpClient();
		client.start();

//		URI uri = URI.create("http://192.168.99.100:8081/hyvar_to_deltaecore");
		URI uri = URI.create("http://localhost:8080/hyvar_to_deltaecore");
//		URI uri = URI.create("http://hyvar-hyvartodeltaecode-env.eu-west-1.elasticbeanstalk.com:80/hyvar_to_deltaecore");
		

//		System.out.println(json);

		request = client.POST(uri);
		request.header(HttpHeader.CONTENT_TYPE, "application/json");
		request.content(new StringContentProvider(json), "application/json");

		response = request.send();
		System.out.println(response);
		answerString = response.getContentAsString();
		DeltaEcoreAnswer deltaEcoreAnswer = gson.fromJson(answerString, DeltaEcoreAnswer.class);
		System.out.println("DeltaEcore answer: " + answerString);

		// TODO try to parse answer
		System.out.println("Try to parse answer. Result " + parseDeltaEcoreAnswer(deltaEcoreAnswer));
		

		FileWriter out2 = new FileWriter("D:/repositories/DarwinSPL/plugins/eu.hyvar.feature.exporter.hfm_exporter.rest.dummyclient/models/answer.json");
		out2.write(answerString);
		out2.flush();
		out2.close();

		// Write to file and read
		return IApplication.EXIT_OK;
	}

	
	private HyVarOutput createOutput() {

		FileInputStream fileReader;
		Scanner scanner;

		try {
			HyVarOutput hyVarOutput = new HyVarOutput();
			
			// Read Feature Model
			File fmFile = new File("D:/HyVar/Implementations/_ExampleInputOutput/_Initial Data/models/"
					+ FILENAME + ".hyfeature");
			fileReader = new FileInputStream(fmFile);
			scanner = new Scanner(fileReader, "UTF-8");
			scanner.useDelimiter("\\A");
			String featureModelString = scanner.next();
			scanner.close();
			fileReader.close();
			FeatureModel featureModelJson = new FeatureModel();
			featureModelJson.setFilename(FILENAME);
			featureModelJson.setSpecification(featureModelString);
			hyVarOutput.setFeatureModel(featureModelJson);
			

			
			// Read Configuration
			File configFile = new File("D:/HyVar/Implementations/_ExampleInputOutput/_Initial Data/models/"
					+ FILENAME + ".hyconfigurationmodel");
			fileReader = new FileInputStream(configFile);
			scanner = new Scanner(fileReader, "UTF-8");
			scanner.useDelimiter("\\A");
			String configurationString = scanner.next();
			scanner.close();
			fileReader.close();
			Configuration configurationJson = new Configuration();
			configurationJson.setFilename(FILENAME);
			configurationJson.setSpecification(configurationString);
			hyVarOutput.setConfiguration(configurationJson);
			
			// Read Mapping
			File mappingFile = new File("D:/HyVar/Implementations/_ExampleInputOutput/_Initial Data/models/"
					+ FILENAME + ".hymappingmodel");
			fileReader = new FileInputStream(mappingFile);
			scanner = new Scanner(fileReader, "UTF-8");
			scanner.useDelimiter("\\A");
			String mappingString = scanner.next();
			scanner.close();
			fileReader.close();
			Mapping mappingJson = new Mapping();
			mappingJson.setFilename(FILENAME);
			mappingJson.setSpecification(mappingString);
			hyVarOutput.setMapping(mappingJson);

			hyVarOutput.setMsgType(MSG_TYPE_OUTPUT);
			
			
			return hyVarOutput;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	private boolean parseDeltaEcoreAnswer(DeltaEcoreAnswer deltaEcoreAnswer) {
		
		if(!deltaEcoreAnswer.getMsgType().equals(MSG_TYPE_ANSWER)) {
			return false;
		}
		
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
		
		IFolder folder = project.getFolder(DELTAECORE_FOLDER);
		if (!folder.exists()) {
			try {
				folder.create(true, true, progressMonitor);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		
		IFile fmFile = folder.getFile(deltaEcoreAnswer.getFeatureModel().getName() + ".defeature");
		InputStream inputStream = new ByteArrayInputStream(deltaEcoreAnswer.getFeatureModel().getContent().getBytes());
		try {
			if(!fmFile.exists()) {
				fmFile.create(inputStream, true, progressMonitor);				
			} else {
				fmFile.setContents(inputStream, IFile.FORCE, progressMonitor);
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}

		IFile configurationFile = folder.getFile(deltaEcoreAnswer.getConfiguration().getName() + ".deconfiguration");
		inputStream = new ByteArrayInputStream(deltaEcoreAnswer.getConfiguration().getContent().getBytes());
		try {
			if(!configurationFile.exists()) {
				configurationFile.create(inputStream, true, progressMonitor);				
			} else {
				 configurationFile.setContents(inputStream, IFile.FORCE,
				 progressMonitor);				
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		IFile mappingFile = folder.getFile(deltaEcoreAnswer.getMapping().getName() + ".demapping");
		inputStream = new ByteArrayInputStream(deltaEcoreAnswer.getMapping().getContent().getBytes());
		try {
			if(!mappingFile.exists()) {
				mappingFile.create(inputStream, true, progressMonitor);				
			} else {
				mappingFile.setContents(inputStream, IFile.FORCE,
				 progressMonitor);				
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}

		try {
			folder.refreshLocal(IFolder.DEPTH_INFINITE, progressMonitor);
		} catch (CoreException e1) {
			e1.printStackTrace();
		}
		
		List<IFile> modelFiles = new ArrayList<IFile>();
		modelFiles.add(fmFile);
		modelFiles.add(configurationFile);
		modelFiles.add(mappingFile);
		
		List<EObject> deltaEcoreModels = EcoreIOUtil.loadModels(modelFiles);
		
		int loadedModels = 0;
		for(EObject eObject: deltaEcoreModels) {
			if(eObject instanceof DEFeatureModel) {
				loadedModels++;
			} else if(eObject instanceof DEConfiguration) {
				loadedModels++;
			} else if(eObject instanceof DEMappingModel) {
				loadedModels++;
			}
		}
		// TODO check if loaded correctly
		
		return loadedModels==3;
	}

	@Override
	public void stop() {
		// Nothing to do
	}

}
