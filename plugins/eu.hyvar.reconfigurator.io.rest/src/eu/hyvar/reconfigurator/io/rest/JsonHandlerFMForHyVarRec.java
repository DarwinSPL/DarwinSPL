package eu.hyvar.reconfigurator.io.rest;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import de.christophseidl.util.ecore.EcoreIOUtil;
import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.contextValidity.HyValidityModel;
import eu.hyvar.context.information.contextValue.ContextValueFactory;
import eu.hyvar.context.information.contextValue.HyContextValue;
import eu.hyvar.context.information.contextValue.HyContextValueModel;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.reconfigurator.input.exporter.HyVarRecExporter;
import eu.hyvar.reconfigurator.io.rest.context.ContextToModelMapper;
import eu.hyvar.reconfigurator.io.rest.input.raw_hyvarrec.RawInputForHyVarRec;

public class JsonHandlerFMForHyVarRec extends AbstractHandler {

	// TODO evolution!
	// TODO much duplicated code - improve!
	
	public static final String MSG_TYPE_JSON_INPUT = "raw_hyvarrec_input";
//	public static final String MSG_TYPE_JSON_HYVARREC_OUTPUT = "hyvarrec_config_plus_fm";
	
	
	private static final String PROJECT_NAME = "fmforhyvarrec";
//	private static final String HYVARREC_INPUT_FOLDER_NAME = "hyvarrec_input";

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

		if (msgType.equals(MSG_TYPE_JSON_INPUT)) {

			RawInputForHyVarRec rawInput = gson.fromJson(jsonInput, RawInputForHyVarRec.class);

			// String outputJson = loadModelsFromStrings(rawInput);
			String outputJson = loadModelsFromFiles(rawInput);

			response.setContentType("application/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write(outputJson);
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
		} 

	}
	
	private static synchronized IFolder createFolder(IProject project) throws CoreException {
		IFolder folder = null;
		while (folder == null || folder.exists()) {
			folder = project.getFolder(UUID.randomUUID().toString());
			folder.create(true, true, null);

		}

		return folder;
	}

	private String loadModelsFromFiles(RawInputForHyVarRec rawInput) {

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

		IFolder folder = null;
		try {
			folder = createFolder(project);
		} catch (CoreException e) {
			e.printStackTrace();
			return "Error when creating a new folder: "+e.getMessage();
		}

		IFile fmFile = folder.getFile(rawInput.getFeatureModel().getFilename() + ".hyfeature");
		InputStream inputStream = new ByteArrayInputStream(rawInput.getFeatureModel().getSpecification().getBytes());
		try {
			if(!fmFile.exists()) {
				fmFile.create(inputStream, true, progressMonitor);				
			} else {
				fmFile.setContents(inputStream, IFile.FORCE, progressMonitor);
			}
		} catch (CoreException e) {
			e.printStackTrace();
			return "Error when creating a new fm file: "+e.getMessage();
		}

		IFile contextFile = folder.getFile(rawInput.getContextModel().getFilename() + ".hycontextmodel");
		inputStream = new ByteArrayInputStream(rawInput.getContextModel().getSpecification().getBytes());
		try {
			if(!contextFile.exists()) {
				contextFile.create(inputStream, true, progressMonitor);				
			} else {
				 contextFile.setContents(inputStream, IFile.FORCE,
				 progressMonitor);				
			}
		} catch (CoreException e) {
			e.printStackTrace();
			return "Error when creating a new context file: "+e.getMessage();
		}

		IFile constraintFile = folder.getFile(rawInput.getConstraints().getFilename() + ".hyconstraint");
		inputStream = new ByteArrayInputStream(rawInput.getConstraints().getSpecification().getBytes());
		try {
			if(!constraintFile.exists()) {
				constraintFile.create(inputStream, true, progressMonitor);				
			} else {
				 constraintFile.setContents(inputStream, IFile.FORCE,
				 progressMonitor);				
			}
		} catch (CoreException e) {
			e.printStackTrace();
			return "Error when creating a new constraint file: "+e.getMessage();
		}

		IFile configurationFile = folder.getFile(rawInput.getConfiguration().getFilename() + ".hyconfiguration");
		inputStream = new ByteArrayInputStream(rawInput.getConfiguration().getSpecification().getBytes());
		try {
			if(!configurationFile.exists()) {
				configurationFile.create(inputStream, true, progressMonitor);				
			} else {
				 configurationFile.setContents(inputStream, IFile.FORCE,
				 progressMonitor);				
			}
		} catch (CoreException e) {
			e.printStackTrace();
			return "Error when creating a new configuration file: "+e.getMessage();
		}

		IFile validityFile = folder.getFile(rawInput.getValidityFormulas().getFilename() + ".hyvaliditymodel");
		inputStream = new ByteArrayInputStream(rawInput.getValidityFormulas().getSpecification().getBytes());
		try {
			if(!validityFile.exists()) {
				validityFile.create(inputStream, true, progressMonitor);				
			} else {
				 validityFile.setContents(inputStream, IFile.FORCE,
				 progressMonitor);				
			}
		} catch (CoreException e) {
			e.printStackTrace();
			return "Error when creating a new validity file: "+e.getMessage();
		}

		List<IFile> modelFiles = new ArrayList<IFile>();
		modelFiles.add(fmFile);
		modelFiles.add(contextFile);
		modelFiles.add(configurationFile);
		modelFiles.add(constraintFile);
		modelFiles.add(validityFile);

		List<EObject> models = EcoreIOUtil.loadModels(modelFiles);

		HyContextModel contextModel = null;
		HyFeatureModel featureModel = null;
		HyValidityModel validityModel = null;
		HyConstraintModel constraintModel = null;
		HyConfiguration configuration = null;

//		try {
//			project.close(progressMonitor);
//		} catch (CoreException e) {
//			e.printStackTrace();
//		}
		
		for (EObject eobject : models) {
			if (eobject instanceof HyContextModel) {
				contextModel = (HyContextModel) eobject;
			} else if (eobject instanceof HyFeatureModel) {
				featureModel = (HyFeatureModel) eobject;
			} else if (eobject instanceof HyValidityModel) {
				validityModel = (HyValidityModel) eobject;
			} else if (eobject instanceof HyConstraintModel) {
				constraintModel = (HyConstraintModel) eobject;
			} else if (eobject instanceof HyConfiguration) {
				configuration = (HyConfiguration) eobject;
			}
		}

		System.out.println(models);

		// TODO
		// Load context values (how to resolve to the contexts?)
		HyContextValueModel contextValueModel = ContextValueFactory.eINSTANCE.createHyContextValueModel();

		// TODO Optimistic -> error handling?
		double latitude = Double.parseDouble(rawInput.getContext().getLat());
		double longitude = Double.parseDouble(rawInput.getContext().getLng());
		HyContextValue positionValue = ContextToModelMapper.mapGPSToContextValue(latitude, longitude, contextModel);

		// TODO very optimistic.... catch null sensible like that?
		if (positionValue != null) {
			contextValueModel.getValues().add(positionValue);
		}

		
		HyVarRecExporter hyvarrecExporter = new HyVarRecExporter();
		return hyvarrecExporter.exportContextMappingModel(contextModel, validityModel, featureModel, constraintModel,
				configuration, null, contextValueModel, new Date());
	}

//	private String loadModelsFromStrings(RawInputForHyVarRec rawInput) throws IOException {
//
//		// Load feature model from input string
//		HyFeatureModel featureModel = null;
//
//		try {
//			featureModel = (HyFeatureModel) EcoreIOUtil.loadModelFromString(
//					rawInput.getFeatureModel().getSpecification(), HyFeaturePackage.eINSTANCE, "hyfeature");
//		} catch (ClassCastException cce) {
//			// TODO proper error handling. Currently optimistic.
//			cce.printStackTrace();
//		}
//
//		System.out.println(featureModel);
//
//		// Load constraint model from input string
//		HyConstraintModel constraintModel = null;
//
//		try {
//			constraintModel = (HyConstraintModel) EcoreIOUtil.loadModelFromString(
//					rawInput.getConstraints().getSpecification(), HyConstraintPackage.eINSTANCE, "hyconstraints",
//					featureModel.eResource().getResourceSet());
//		} catch (ClassCastException cce) {
//			// TODO proper error handling. Currently optimistic.
//			cce.printStackTrace();
//		}
//
//		// Load context model from input string
//		HyContextModel contextModel = null;
//		try {
//			contextModel = (HyContextModel) EcoreIOUtil.loadModelFromString(
//					rawInput.getContextModel().getSpecification(), HyContextInformationPackage.eINSTANCE,
//					"hycontextmodel", featureModel.eResource().getResourceSet());
//		} catch (ClassCastException cce) {
//			// TODO proper error handling. Currently optimistic.
//			cce.printStackTrace();
//		}
//
//		// Load validity formulas from input string
//		HyValidityModel validityModel = null;
//		try {
//			validityModel = (HyValidityModel) EcoreIOUtil.loadModelFromString(
//					rawInput.getValidityFormulas().getSpecification(), HyContextValidityPackage.eINSTANCE,
//					"hyvaliditymodel", featureModel.eResource().getResourceSet());
//		} catch (ClassCastException cce) {
//			// TODO proper error handling. Currently optimistic.
//			cce.printStackTrace();
//		}
//
//		// Load old configuration from input string
//		HyConfiguration configuration = null;
//		try {
//			configuration = (HyConfiguration) EcoreIOUtil.loadModelFromString(
//					rawInput.getConfiguration().getSpecification(), HyContextValidityPackage.eINSTANCE,
//					"hyconfiguration", featureModel.eResource().getResourceSet());
//		} catch (ClassCastException cce) {
//			// TODO proper error handling. Currently optimistic.
//			cce.printStackTrace();
//		}
//
//		// Load context values (how to resolve to the contexts?)
//		HyContextValueModel contextValueModel = ContextValueFactory.eINSTANCE.createHyContextValueModel();
//
//		// TODO Optimistic -> error handling?
//		double latitude = Double.parseDouble(rawInput.getContext().getLat());
//		double longitude = Double.parseDouble(rawInput.getContext().getLng());
//		HyContextValue positionValue = ContextToModelMapper.mapGPSToContextValue(latitude, longitude, contextModel);
//
//		// TODO very optimistic.... catch null sensible like that?
//		if (positionValue != null) {
//			contextValueModel.getValues().add(positionValue);
//		}
//
//		HyVarRecExporter hyvarrecExporter = new HyVarRecExporter();
//		return hyvarrecExporter.exportContextMappingModel(contextModel, validityModel, featureModel, constraintModel,
//				configuration, null, contextValueModel, new Date());
//	}
}
