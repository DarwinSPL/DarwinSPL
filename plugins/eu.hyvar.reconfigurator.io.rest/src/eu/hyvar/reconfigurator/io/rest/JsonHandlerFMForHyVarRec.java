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
		Date date = DateParser.getDate(rawInput.getDate());

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
		while(folder == null || folder.exists()) {
			folder = project.getFolder(UUID.randomUUID().toString());
			
			try {
				folder.create(true, true, progressMonitor);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}

		IFile manifestFile = folder.getFile(rawInput.getManifest().getFilename() + "." + HyManifestResolverUtil.FILE_EXTENSION_FOR_XMI);
		InputStream inputStream = new ByteArrayInputStream(rawInput.getManifest().getSpecification().getBytes());
		try {
			if(!manifestFile.exists()) {
				manifestFile.create(inputStream, true, progressMonitor);				
			} else {
				manifestFile.setContents(inputStream, IFile.FORCE, progressMonitor);
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		
		IFile fmFile = folder.getFile(rawInput.getFeatureModel().getFilename() + "." + HyFeatureUtil.getFeatureModelFileExtensionForXmi());
		inputStream = new ByteArrayInputStream(rawInput.getFeatureModel().getSpecification().getBytes());
		try {
			if(!fmFile.exists()) {
				fmFile.create(inputStream, true, progressMonitor);				
			} else {
				fmFile.setContents(inputStream, IFile.FORCE, progressMonitor);
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}

		IFile contextFile = folder.getFile(rawInput.getContextModel().getFilename() + "." + HyContextInformationUtil.getContextModelFileExtensionForXmi());
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
		}

		IFile constraintFile = folder.getFile(rawInput.getConstraints().getFilename() + "." + HyConstraintUtil.getConstraintModelFileExtensionForXmi());
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
		}

		IFile configurationFile = folder.getFile(rawInput.getOldConfiguration().getFilename() + HyConfigurationUtil.getConfigurationModelFileExtensionForXmi());
		inputStream = new ByteArrayInputStream(rawInput.getOldConfiguration().getSpecification().getBytes());
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

		IFile validityFile = folder.getFile(rawInput.getValidityFormulas().getFilename() + HyValidityModelUtil.getValidityModelFileExtensionForXmi());
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

		try {
			project.close(progressMonitor);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
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
		
		for(Dependency dependency: rawInput.getDependencies()) {
			IFile dependencyManifestFile = folder.getFile(dependency.getSignature().getFilename() + "." + HyManifestResolverUtil.FILE_EXTENSION_FOR_XMI);
			inputStream = new ByteArrayInputStream(dependency.getSignature().getSpecification().getBytes());
			try {
				if(!dependencyManifestFile.exists()) {
					dependencyManifestFile.create(inputStream, true, progressMonitor);				
				} else {
					dependencyManifestFile.setContents(inputStream, IFile.FORCE, progressMonitor);
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
			
			
			IFile dependencyFmFile = folder.getFile(dependency.getFeatureModel().getFilename() + "." + HyFeatureUtil.getFeatureModelFileExtensionForXmi());
			inputStream = new ByteArrayInputStream(dependency.getFeatureModel().getSpecification().getBytes());
			try {
				if(!dependencyFmFile.exists()) {
					dependencyFmFile.create(inputStream, true, progressMonitor);				
				} else {
					dependencyFmFile.setContents(inputStream, IFile.FORCE, progressMonitor);
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}

			IFile dependencyContextFile = folder.getFile(dependency.getContextModel().getFilename() + "." + HyContextInformationUtil.getContextModelFileExtensionForXmi());
			inputStream = new ByteArrayInputStream(dependency.getContextModel().getSpecification().getBytes());
			try {
				if(!dependencyContextFile.exists()) {
					dependencyContextFile.create(inputStream, true, progressMonitor);				
				} else {
					 dependencyContextFile.setContents(inputStream, IFile.FORCE,
					 progressMonitor);				
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}

			IFile dependencyConstraintFile = folder.getFile(dependency.getConstraints().getFilename() + "." + HyConstraintUtil.getConstraintModelFileExtensionForXmi());
			inputStream = new ByteArrayInputStream(dependency.getConstraints().getSpecification().getBytes());
			try {
				if(!dependencyConstraintFile.exists()) {
					dependencyConstraintFile.create(inputStream, true, progressMonitor);				
				} else {
					 dependencyConstraintFile.setContents(inputStream, IFile.FORCE,
					 progressMonitor);				
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}

			IFile dependencyValidityFile = folder.getFile(dependency.getValidityFormulas().getFilename() + HyValidityModelUtil.getValidityModelFileExtensionForXmi());
			inputStream = new ByteArrayInputStream(dependency.getValidityFormulas().getSpecification().getBytes());
			try {
				if(!dependencyValidityFile.exists()) {
					dependencyValidityFile.create(inputStream, true, progressMonitor);				
				} else {
					 dependencyValidityFile.setContents(inputStream, IFile.FORCE,
					 progressMonitor);				
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
			// TODO load dependency models. Adapt hyvarrec exporter to be able to take dependencies. Also needs to consider validity formulas and ctcs of dependencies.
			
		}

		// TODO how to deal with multiple context models?!
		
		// Load context values (how to resolve to the contexts?)
		// This is very HyVar specific
		HyContextValueModel contextValueModel = ContextValueFactory.eINSTANCE.createHyContextValueModel();

		// TODO Optimistic -> error handling?
		double latitude = Double.parseDouble(rawInput.getContext().getLat());
		double longitude = Double.parseDouble(rawInput.getContext().getLong());
		HyContextValue positionValue = ContextToModelMapper.mapGPSToContextValue(latitude, longitude, contextModel);

		// TODO very optimistic.... catch null sensible like that?
		if (positionValue != null) {
			contextValueModel.getValues().add(positionValue);
		}

		
		HyVarRecExporter hyvarrecExporter = new HyVarRecExporter();
		String answer = hyvarrecExporter.exportSPL(contextModel, validityModel, featureModel, constraintModel,
				configuration, null, contextValueModel, date);
		
		try {
			folder.delete(true, progressMonitor);
		} catch (CoreException e) {
			e.printStackTrace();
			return "Error when deleting folder: "+e.getMessage();
		}
		
		return answer;
	}
}
