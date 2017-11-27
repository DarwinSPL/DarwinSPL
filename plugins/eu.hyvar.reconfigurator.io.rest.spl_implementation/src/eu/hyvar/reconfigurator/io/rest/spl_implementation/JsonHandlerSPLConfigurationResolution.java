package eu.hyvar.reconfigurator.io.rest.spl_implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import de.christophseidl.util.ecore.EcoreIOUtil;
import eu.hyvar.evolution.util.HyEvolutionResolverUtil;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.HyConfigurationElement;
import eu.hyvar.feature.configuration.HyFeatureDeselected;
import eu.hyvar.feature.configuration.HyFeatureSelected;
import eu.hyvar.feature.configuration.HyVersionDeselected;
import eu.hyvar.feature.configuration.HyVersionSelected;
import eu.hyvar.mspl.manifest.HySPLImplementation;
import eu.hyvar.mspl.manifest.HySPLSignature;
import eu.hyvar.mspl.manifest.HyTimedImplementationLink;
import eu.hyvar.mspl.manifest.HyTimedImplementations;
import eu.hyvar.reconfigurator.io.rest.spl_implementation.io.raw_input_spl_configuration_converter.RawInputSPLConfigurationConverter;
import eu.hyvar.reconfigurator.io.rest.spl_implementation.io.raw_output_spl_configuration_converter.Configuration;
import eu.hyvar.reconfigurator.io.rest.spl_implementation.io.raw_output_spl_configuration_converter.RawOutputSPLConfigurationConverter;
import eu.hyvar.reconfigurator.io.rest.spl_implementation.io.raw_output_error_resolution.RawOutputError;

public class JsonHandlerSPLConfigurationResolution extends AbstractHandler {

	private String MSG_TYPE_JSON_INPUT = "translate_signature_configuration";

	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// read json contents of http request
		String msgType = "";

		RawOutputError error = new RawOutputError();
		error.setErrorString("");
		
		String jsonInput="";
		String responseString = "";
		
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();

		try {
			BufferedReader reader = request.getReader();
			StringBuilder sb = new StringBuilder();
			sb.append(reader.readLine());
			jsonInput = sb.toString();

			JsonParser parser = new JsonParser();
			JsonObject obj = parser.parse(jsonInput).getAsJsonObject();
			msgType = obj.get("msg_type").getAsString();

		} catch(Exception e) {
			error.setErrorString(error.getErrorString()+"\n Error during input parsing: "+e.toString());
		}
		
		// If the JSON have the right message type do the work
		if (msgType.equals(MSG_TYPE_JSON_INPUT)) {
			RawInputSPLConfigurationConverter rawInput = gson.fromJson(jsonInput, RawInputSPLConfigurationConverter.class);
			
			RawOutputSPLConfigurationConverter output = saveAndAnalize(rawInput, error);
			responseString = gson.toJson(output);
		} else {
			error.setErrorString(error.getErrorString()+"\n Wrong type of message, expect: "+MSG_TYPE_JSON_INPUT);
		}
		
		// If there is an error, return it instead of the output
		if(!"".equals(error.getErrorString())) {
			responseString = gson.toJson(error);
		}

		// Send the output message
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(responseString);
		response.setStatus(HttpServletResponse.SC_OK);
		baseRequest.setHandled(true);
	}


	private RawOutputSPLConfigurationConverter saveAndAnalize(RawInputSPLConfigurationConverter rawInput,
			RawOutputError error) {

		// Initialize the output and the temporary ResourseSet
		RawOutputSPLConfigurationConverter output = new RawOutputSPLConfigurationConverter();
		output.setSplId(rawInput.getSplId());
		
		ResourceSetImpl baseContext = new ResourceSetImpl();

		// Take the date-time used for the work  
		Date currentInstant = HyEvolutionResolverUtil.resolveDate(rawInput.getDate());

		// Create the temporary folder for this work
		IProgressMonitor progressMonitor = null;
		IFolder folder = null;
		try {
			folder = WorkspaceManager.getWorkspaceManager().getNewIFolder();
			progressMonitor = WorkspaceManager.getWorkspaceManager().getIProgressMonitor();
		} catch (CoreException e) {
			error.setErrorString(error.getErrorString()+"\n Error creating folder and monitor: "+e.toString());
		}


		String fileName = "";
		byte[] content = new byte[0];
		IFile ifile;
		EObject object;
		
		// Saving the Signature
		HySPLSignature signatureManifest = null;
		HyFeatureModel signature = null;

		// Instantiate the manifest of the SPL : (not necessary to maintain the file )
		fileName = rawInput.getSignatureManifest().getFilename()+".hymanifest_xmi";
		content = rawInput.getSignatureManifest().getSpecification().getBytes();
		ifile = WorkspaceUtility.saveFileContent(fileName, content, folder, progressMonitor, error);

		if(ifile!=null) {
			object = EcoreIOUtil.loadModel(ifile, baseContext);
			if (object instanceof HySPLSignature) {
				signatureManifest = (HySPLSignature) object;
			}
		} else {
			error.setErrorString(error.getErrorString()+"\n Error during saving of: "+fileName);
		}

		// Instantiate the feature model of the SPL : 
		fileName = rawInput.getSignatureFeatureModel().getFilename()+".hyfeature";
		content = rawInput.getSignatureFeatureModel().getSpecification().getBytes();
		ifile = WorkspaceUtility.saveFileContent(fileName, content, folder, progressMonitor, error);

		if(ifile!=null) {
			object = EcoreIOUtil.loadModel(ifile, baseContext);
			if (object instanceof HyFeatureModel) {
				signature = (HyFeatureModel) object;
			}
		} else {
			error.setErrorString(error.getErrorString()+"\n Error during saving of: "+fileName);
		}

		// Saving the SPL
		HySPLImplementation splManifest = null;
		HyFeatureModel spl = null;

		// Instantiate the manifest of the SPL : 
		fileName = rawInput.getSplManifest().getFilename()+".hymanifest_xmi";
		content = rawInput.getSplManifest().getSpecification().getBytes();
		ifile = WorkspaceUtility.saveFileContent(fileName, content, folder, progressMonitor, error);

		if(ifile!=null) {
			object = EcoreIOUtil.loadModel(ifile, baseContext);
			if (object instanceof HySPLImplementation) {
				splManifest = (HySPLImplementation) object;
			}
		} else {
			error.setErrorString(error.getErrorString()+"\n Error during saving of: "+fileName);
		}

		// Instantiate the feature model of the SPL : 
		fileName = rawInput.getSplFeatureModel().getFilename()+".hyfeature";
		content = rawInput.getSplFeatureModel().getSpecification().getBytes();
		ifile = WorkspaceUtility.saveFileContent(fileName, content, folder, progressMonitor, error);

		if(ifile!=null) {
			object = EcoreIOUtil.loadModel(ifile, baseContext);
			if (object instanceof HyFeatureModel) {
				spl = (HyFeatureModel) object;
			}
		} else {
			error.setErrorString(error.getErrorString()+"\n Error during saving of: "+fileName);
		}

		// Saving the Configuration
		HyConfiguration configuration = null;

		// Instantiate the Configuration : 
		fileName = rawInput.getSignatureConfiguration().getFilename()+".hyconfigurationmodel";
		content = rawInput.getSignatureConfiguration().getSpecification().getBytes();
		ifile = WorkspaceUtility.saveFileContent(fileName, content, folder, progressMonitor, error);

		if(ifile!=null) {
			object = EcoreIOUtil.loadModel(ifile, baseContext);
			if (object instanceof HyConfiguration) {
				configuration = (HyConfiguration) object;
			}
		} else {
			error.setErrorString(error.getErrorString()+"\n Error during saving of: "+fileName);
		}


		// Change the Feature Model
		configuration.setFeatureModel(spl);
		
		// Find the right implementation
		HyTimedImplementations implementation = null;
		EList<HyTimedImplementationLink> associations = new BasicEList<HyTimedImplementationLink>();
		for(HyTimedImplementations elem: splManifest.getImplementations()) {
			if( HyEvolutionUtil.isValid(elem, currentInstant) ) {
				if(signatureManifest==elem.getSignature()) {
					implementation = elem;
					associations = implementation.getAssociations();
				}
			}
		}
		if(implementation==null) {
			error.setErrorString(error.getErrorString()+"\n Error on implementation search: This SPL don't implement the signature");
		}
		
		
		// Change the link to the features (selected/deselected):		
		HyFeature newFeature;
		
		for(HyConfigurationElement element : configuration.getElements()) {
			if(element instanceof HyFeatureSelected) {
				HyFeatureSelected selected = (HyFeatureSelected) element;
				newFeature = findAssociatedFeature(selected.getSelectedFeature(), associations, currentInstant);

				if(newFeature!=null) {
					selected.setSelectedFeature(newFeature);
				} else {
					error.setErrorString(error.getErrorString()+"\n No valid selected feature for ID: "+selected.getSelectedFeature().getId());
				}
			}
			if(element instanceof HyFeatureDeselected) {
				HyFeatureDeselected deselected = (HyFeatureDeselected) element;
				newFeature = findAssociatedFeature(deselected.getSelectedFeature(), associations, currentInstant);

				if(newFeature!=null) {
					deselected.setSelectedFeature(newFeature);
				} else {
					error.setErrorString(error.getErrorString()+"\n No valid deselected feature for ID: "+deselected.getSelectedFeature().getId());
				}
			}
			
			if(element instanceof HyVersionSelected) {
				HyVersionSelected versionSelected = (HyVersionSelected) element;
				HyVersion version = versionSelected.getSelectedVersion();
				HyFeature feature = version.getFeature();
				
				newFeature = findAssociatedFeature(feature, associations, currentInstant);

				if(newFeature!=null) {
					boolean found = false;
					for( HyVersion splVersion :newFeature.getVersions()) {
						if(splVersion.getNumber().equals(version.getNumber())) {
							versionSelected.setSelectedVersion(splVersion);
							found=true;
						}
					}
					if(!found) {
						error.setErrorString(error.getErrorString()+"\n No valid version for ID: "+feature.getId());
					}
				} else {
					error.setErrorString(error.getErrorString()+"\n No valid selected feature by version for ID: "+feature.getId());
				}
			}
			if(element instanceof HyVersionDeselected) {
				HyVersionDeselected versionDeselected = (HyVersionDeselected) element;
				HyVersion version = versionDeselected.getSelectedVersion();
				HyFeature feature = version.getFeature();
				
				newFeature = findAssociatedFeature(feature, associations, currentInstant);

				if(newFeature!=null) {
					boolean found = false;
					for( HyVersion splVersion :newFeature.getVersions()) {
						if(splVersion.getNumber().equals(version.getNumber())) {
							versionDeselected.setSelectedVersion(splVersion);
							found=true;
						}
					}
					if(!found) {
						error.setErrorString(error.getErrorString()+"\n No valid deselected version for ID: "+feature.getId());
					}
				} else {
					error.setErrorString(error.getErrorString()+"\n No valid deselected feature by version for ID: "+feature.getId());
				}
			}

		}

		
		
		fileName = rawInput.getSignatureConfiguration().getFilename();
		EcoreIOUtil.saveModel(configuration);
	    
		
		Configuration config = new Configuration();
		config.setFilename(fileName);
		
		byte[] data = new byte[0];
		try {
			IFile readfile = folder.getFile(fileName+".hyconfigurationmodel");
			InputStream is = readfile.getContents();
			int length = is.available();
			int read=0;
			data = new byte[length];
			while(read<length) {
				read+=is.read(data, read, (length-read));
			}
			is.close();
		} catch (CoreException e) {
			error.setErrorString(error.getErrorString()+"\n Error when save&load configuration: "+e.getMessage());
		}
		catch (IOException e) {
			error.setErrorString(error.getErrorString()+"\n Error when save&load configuration: "+e.getMessage());
		}
		config.setSpecification(new String(data));
				
		output.setConfiguration(config);

		
		try {
			folder.delete(true, progressMonitor);
		} catch (CoreException e) {
			error.setErrorString(error.getErrorString()+"\n Error when deleting folder: "+e.getMessage());
		}
		
		return output;
	}


	private HyFeature findAssociatedFeature(HyFeature selectedFeature, EList<HyTimedImplementationLink> associations, Date currentInstant) {
		for(HyTimedImplementationLink link : associations) {
			if( HyEvolutionUtil.isValid(link, currentInstant) ) {
				if(link.getSignature()==selectedFeature) {
					return link.getLocal();
				}
			}
		}
		return null;
	}

}
