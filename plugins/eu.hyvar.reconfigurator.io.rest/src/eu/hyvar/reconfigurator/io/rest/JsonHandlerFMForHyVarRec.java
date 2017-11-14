package eu.hyvar.reconfigurator.io.rest;

import java.io.BufferedReader;
import java.io.IOException;
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
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import de.christophseidl.util.ecore.EcoreIOUtil;
import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.contextValidity.HyValidityModel;
import eu.hyvar.context.contextValidity.util.HyValidityModelUtil;
import eu.hyvar.context.information.contextValue.ContextValueFactory;
import eu.hyvar.context.information.contextValue.HyContextValue;
import eu.hyvar.context.information.contextValue.HyContextValueModel;
import eu.hyvar.context.information.util.HyContextInformationUtil;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.util.HyConfigurationUtil;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.constraint.util.HyConstraintUtil;
import eu.hyvar.feature.util.HyFeatureUtil;
import eu.hyvar.mspl.manifest.HyManifest;
import eu.hyvar.mspl.util.HyManifestResolverUtil;
import eu.hyvar.reconfigurator.input.exporter.HyVarRecExporter;
import eu.hyvar.reconfigurator.io.rest.context.ContextToModelMapper;
import eu.hyvar.reconfigurator.io.rest.input.raw_input_for_hyvarrec.Dependency;
import eu.hyvar.reconfigurator.io.rest.input.raw_input_for_hyvarrec.RawInputForHyVarRec;

public class JsonHandlerFMForHyVarRec extends AbstractHandler {

	// TODO evolution!
	// TODO much duplicated code - improve!
	
	public static final String MSG_TYPE_JSON_INPUT = "raw_hyvarrec_input";
//	public static final String MSG_TYPE_JSON_HYVARREC_OUTPUT = "hyvarrec_config_plus_fm";
	
	
	private static final String PROJECT_NAME = "fmforhyvarrec";
//	private static final String HYVARREC_INPUT_FOLDER_NAME = "hyvarrec_input";

	
	// TODO make it cleaner -> split into more methods
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

	private String loadModelsFromFiles(RawInputForHyVarRec rawInput) {
		if(rawInput == null) {
			return null;
		}
		
		if(rawInput.getFeatureModel() == null) {
			return null;
		}
		
		Date date = DateParser.getDate(rawInput.getDate());

		IProgressMonitor progressMonitor = new NullProgressMonitor();
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();//
		IProject project = workspaceRoot.getProject(PROJECT_NAME);

		try {
			if (!project.exists()) {
				project.create(progressMonitor);
			}
			project.open(progressMonitor);
		} catch (CoreException e) {
			e.printStackTrace();
		}

		// Files which don't contain dependencies 
		List<IFile> featureModelFiles = new ArrayList<IFile>();
		List<IFile> contextModelFiles = new ArrayList<IFile>();
		
		// Files which contain dependencies
		List<IFile> manifestFiles = new ArrayList<IFile>();
		List<IFile> constraintModelFiles = new ArrayList<IFile>();
		List<IFile> validityModelFiles = new ArrayList<IFile>();
		
		List<HyFeatureModel> featureModels = new ArrayList<HyFeatureModel>();
		List<HyContextModel> contextModels = new ArrayList<HyContextModel>();
		List<HyManifest> manifestModels = new ArrayList<HyManifest>();
		List<HyConstraintModel> constraintModels = new ArrayList<HyConstraintModel>();
		List<HyValidityModel> validityModels = new ArrayList<HyValidityModel>();
		
		IFolder folder = null;
		while(folder == null || folder.exists()) {
			folder = project.getFolder(UUID.randomUUID().toString());
		}

		try {
			folder.create(true, true, progressMonitor);
		} catch (CoreException e) {
			e.printStackTrace();
		}

		IFile manifestFile = FileWriterUtility.writeFileWithContent(
				rawInput.getManifest().getFilename(),
				HyManifestResolverUtil.getManifestModelFileExtensionForXmi(),
				rawInput.getManifest().getSpecification(), folder);

		manifestFiles.add(manifestFile);
		
		IFile fmFile = FileWriterUtility.writeFileWithContent(
				rawInput.getFeatureModel().getFilename(),
				HyFeatureUtil.getFeatureModelFileExtensionForXmi(),
				rawInput.getFeatureModel().getSpecification(), folder);

		featureModelFiles.add(fmFile);

		IFile contextFile = null;
		if(rawInput.getContextModel() != null) {
			contextFile = FileWriterUtility.writeFileWithContent(
					rawInput.getContextModel().getFilename(),
					HyContextInformationUtil.getContextModelFileExtensionForXmi(),
					rawInput.getContextModel().getSpecification(), folder);
			
			contextModelFiles.add(contextFile);			
		}
		
		IFile constraintFile = null;
		if(rawInput.getConstraints() != null) {
			constraintFile = FileWriterUtility.writeFileWithContent(
					rawInput.getConstraints().getFilename(),
					HyConstraintUtil.getConstraintModelFileExtensionForXmi(),
					rawInput.getConstraints().getSpecification(), folder);
			
			constraintModelFiles.add(constraintFile);			
		}
		
		IFile configurationFile = null;
		if(rawInput.getOldConfiguration() != null) {
			configurationFile = FileWriterUtility.writeFileWithContent(
					rawInput.getOldConfiguration().getFilename(),
					HyConfigurationUtil.getConfigurationModelFileExtensionForXmi(),
					rawInput.getOldConfiguration().getSpecification(), folder);			
		}

		IFile partialConfigurationFile = null;
		if(rawInput.getPartialConfiguration() != null) {
			partialConfigurationFile = FileWriterUtility.writeFileWithContent(
					rawInput.getPartialConfiguration().getFilename(),
					HyConfigurationUtil.getConfigurationModelFileExtensionForXmi(),
					rawInput.getPartialConfiguration().getSpecification(), folder);			
		}

		IFile validityFile = null;
		if(rawInput.getValidityFormulas() != null) {
			validityFile = FileWriterUtility.writeFileWithContent(
					rawInput.getValidityFormulas().getFilename(),
					HyValidityModelUtil.getValidityModelFileExtensionForXmi(),
					rawInput.getValidityFormulas().getSpecification(), folder);
			
			validityModelFiles.add(validityFile);
		}


		
//		HyFeatureModel featureModel = EcoreIOUtil.loadModel(fmFile);
//		ResourceSet resourceSet = featureModel.eResource().getResourceSet();
//		
//		List<IFile> modelFiles = new ArrayList<IFile>();
//		modelFiles.add(fmFile);
//		modelFiles.add(contextFile);
//		modelFiles.add(configurationFile);
//		modelFiles.add(constraintFile);
//		modelFiles.add(validityFile);
//
//		List<EObject> models = EcoreIOUtil.loadModels(modelFiles);
//
//		HyContextModel contextModel = null;
//		HyValidityModel validityModel = null;
//		HyConstraintModel constraintModel = null;
//		HyConfiguration configuration = null;
//
//		try {
//			project.close(progressMonitor);
//		} catch (CoreException e) {
//			e.printStackTrace();
//		}
//		
//		for (EObject eobject : models) {
//			if (eobject instanceof HyContextModel) {
//				contextModel = (HyContextModel) eobject;
//			} else if (eobject instanceof HyFeatureModel) {
//				featureModel = (HyFeatureModel) eobject;
//			} else if (eobject instanceof HyValidityModel) {
//				validityModel = (HyValidityModel) eobject;
//			} else if (eobject instanceof HyConstraintModel) {
//				constraintModel = (HyConstraintModel) eobject;
//			} else if (eobject instanceof HyConfiguration) {
//				configuration = (HyConfiguration) eobject;
//			}
//		}
//		
//
//		validityModels.add(validityModel);
		
		if (rawInput.getDependencies() != null) {
			for (Dependency dependency : rawInput.getDependencies()) {
				IFile dependencyManifestFile = FileWriterUtility.writeFileWithContent(
						dependency.getDependencySignature().getFilename(),
						HyManifestResolverUtil.getManifestModelFileExtensionForXmi(),
						dependency.getDependencySignature().getSpecification(), folder);

				manifestFiles.add(dependencyManifestFile);

				IFile dependencyFmFile = FileWriterUtility.writeFileWithContent(
						dependency.getDependencyFeatureModel().getFilename(),
						HyFeatureUtil.getFeatureModelFileExtensionForXmi(),
						dependency.getDependencyFeatureModel().getSpecification(), folder);

				featureModelFiles.add(dependencyFmFile);

				if (dependency.getDependencyContextModel() != null
						&& dependency.getDependencyContextModel().getSpecification() != null
						&& !dependency.getDependencyContextModel().getSpecification().equals("")) {
					IFile dependencyContextFile = FileWriterUtility.writeFileWithContent(
							dependency.getDependencyContextModel().getFilename(),
							HyContextInformationUtil.getContextModelFileExtensionForXmi(),
							dependency.getDependencyContextModel().getSpecification(), folder);

					contextModelFiles.add(dependencyContextFile);
				}

				if (dependency.getDependencyConstraints() != null
						&& dependency.getDependencyConstraints().getSpecification() != null
						&& !dependency.getDependencyConstraints().getSpecification().equals("")) {
					IFile dependencyConstraintFile = FileWriterUtility.writeFileWithContent(
							dependency.getDependencyConstraints().getFilename(),
							HyConstraintUtil.getConstraintModelFileExtensionForXmi(),
							dependency.getDependencyConstraints().getSpecification(), folder);

					constraintModelFiles.add(dependencyConstraintFile);
				}

				if (dependency.getDependencyValidityFormulas() != null
						&& dependency.getDependencyValidityFormulas().getSpecification() != null
						&& !dependency.getDependencyValidityFormulas().getSpecification().equals("")) {
					IFile dependencyValidityFile = FileWriterUtility.writeFileWithContent(
							dependency.getDependencyValidityFormulas().getFilename(),
							HyValidityModelUtil.getValidityModelFileExtensionForXmi(),
							dependency.getDependencyValidityFormulas().getSpecification(), folder);

					validityModelFiles.add(dependencyValidityFile);
				}
			}

		}

		
		// load all models from files
		
		// first load independent models
		for(EObject loadedModel: EcoreIOUtil.loadModels(featureModelFiles)) {
			if(loadedModel instanceof HyFeatureModel) {
				featureModels.add((HyFeatureModel)loadedModel);
			}
		}
		
		ResourceSet resourceSet = featureModels.get(0).eResource().getResourceSet();
		
		HyContextModel contextModelImpl = null;
		
		for(IFile contextModelFile: contextModelFiles) {
			HyContextModel contextModel = EcoreIOUtil.loadModel(contextModelFile, resourceSet);
			if(contextModelFile == contextFile) {
				contextModelImpl = contextModel;
			}
			contextModels.add(contextModel);
		}
		
		// load dependent models
		for(EObject loadedModel: EcoreIOUtil.loadModels(manifestFiles, resourceSet, null, false)) {
			if(loadedModel instanceof HyManifest) {
				manifestModels.add((HyManifest)loadedModel);
			}
		}
		
		for(EObject loadedModel: EcoreIOUtil.loadModels(constraintModelFiles, resourceSet, null, false)) {
			if(loadedModel instanceof HyConstraintModel) {
				constraintModels.add((HyConstraintModel)loadedModel);
			}
		}

		for(EObject loadedModel: EcoreIOUtil.loadModels(validityModelFiles, resourceSet, null, false)) {
			if(loadedModel instanceof HyValidityModel) {
				validityModels.add((HyValidityModel)loadedModel);
			}
		}

		HyConfiguration configuration = null;
		if(rawInput.getOldConfiguration() != null && rawInput.getOldConfiguration().getSpecification() != null && !rawInput.getOldConfiguration().getSpecification().equals("")) {
			configuration = EcoreIOUtil.loadModel(configurationFile, resourceSet);			
		}
		
		HyConfiguration partialConfiguration = null;
		if(rawInput.getPartialConfiguration() != null && rawInput.getPartialConfiguration().getSpecification() != null && !rawInput.getPartialConfiguration().getSpecification().equals("")) {
			partialConfiguration = EcoreIOUtil.loadModel(partialConfigurationFile, resourceSet);			
		}
		
		// Load context values (how to resolve to the contexts?)
		// This is very HyVar specific
		HyContextValueModel contextValueModel = ContextValueFactory.eINSTANCE.createHyContextValueModel();

		// TODO Optimistic -> error handling?
		if(rawInput.getContext() != null) {
			double latitude = Double.parseDouble(rawInput.getContext().getLat());
			double longitude = Double.parseDouble(rawInput.getContext().getLong());
			HyContextValue positionValue = ContextToModelMapper.mapGPSToContextValue(latitude, longitude, contextModelImpl);			
			// TODO very optimistic.... catch null sensible like that?
			if (positionValue != null) {
				contextValueModel.getValues().add(positionValue);
			}
		}

		
		List<HyContextValueModel> contextValueModels = new ArrayList<HyContextValueModel>(1);
		contextValueModels.add(contextValueModel);

		
		HyVarRecExporter hyvarrecExporter = new HyVarRecExporter();
		String answer = hyvarrecExporter.exportSPL(contextModels, validityModels, featureModels, constraintModels,
				configuration, partialConfiguration, null, contextValueModels, date, null);
		
		try {
			folder.delete(true, progressMonitor);
		} catch (CoreException e) {
			e.printStackTrace();
			return "Error when deleting folder: "+e.getMessage();
		}
		
		return answer;
	}
}
