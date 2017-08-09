package eu.hyvar.reconfigurator.io.rest.spl_implementation;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
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
import eu.hyvar.mspl.manifest.HySPLImplementation;
import eu.hyvar.mspl.manifest.HySPLSignature;
import eu.hyvar.mspl.manifest.HyTimedImplementations;
import eu.hyvar.reconfigurator.io.rest.spl_implementation.io.raw_input_spl_implementation_resolution.*;
import eu.hyvar.reconfigurator.io.rest.spl_implementation.io.raw_output_error_resolution.RawOutputError;
import eu.hyvar.reconfigurator.io.rest.spl_implementation.io.raw_output_spl_implementation_resolution.RawOutputSPLImplementationResolution;

public class JsonHandlerSPLImplementationResolution extends AbstractHandler {

	private String MSG_TYPE_JSON_INPUT = "implementation_selection";

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
			RawInputSPLImplementationResolution rawInput = gson.fromJson(jsonInput, RawInputSPLImplementationResolution.class);
			
			RawOutputSPLImplementationResolution output = saveAndAnalize(rawInput, error);
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

	
	
	private RawOutputSPLImplementationResolution saveAndAnalize(RawInputSPLImplementationResolution rawInput, RawOutputError error) {

		// Initialize the output and the temporary ResourseSet
		RawOutputSPLImplementationResolution output = new RawOutputSPLImplementationResolution();
		output.setSplId("");
		
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
		
		// Saving the Signature to be implemented
		HySPLSignature signatureToImplement = null;

		// Instantiate the Signature to be implemented: 
		fileName = rawInput.getSplSignature().getSignatureModel().getFilename();
		content = rawInput.getSplSignature().getSignatureModel().getSpecification().getBytes();
		ifile = WorkspaceUtility.saveFileContent(fileName, content, folder, progressMonitor, error);

		if(ifile!=null) {
			object = EcoreIOUtil.loadModel(ifile, baseContext);
			if (object instanceof HySPLSignature) {
				signatureToImplement = (HySPLSignature) object;
			}
		} else {
			error.setErrorString(error.getErrorString()+"\n Error during saving of: "+fileName);
		}

		
		
		// Save and check the implementation
		HySPLImplementation modelToCheck = null;
		EList<HyTimedImplementations> elems;

		List<SplImplementation> implementations = rawInput.getSplImplementations();
		for (SplImplementation implementation: implementations) {
			elems = ECollections.emptyEList();

			// Save the implementation
			fileName = implementation.getSignatureModel().getFilename();
			content = implementation.getSignatureModel().getSpecification().getBytes();
			ifile = WorkspaceUtility.saveFileContent(fileName, content, folder, progressMonitor, error);

			
			if(ifile!=null) {
				// Check if is a valid HySPLImplementation
				object = EcoreIOUtil.loadModel(ifile, baseContext);
				if (object instanceof HySPLImplementation) {
					modelToCheck = (HySPLImplementation) object;
					elems = modelToCheck.getImplementations();
				}
				
				// Check if is a valid implementation for the Signature in instance "currentInstant"
				for(HyTimedImplementations elem: elems) {
					if( HyEvolutionUtil.isValid(elem, currentInstant) ) {
						if(signatureToImplement==elem.getSignature()) {
							output.setSplId(implementation.getSignatureId());
							try {
								folder.delete(true, progressMonitor);
							} catch (CoreException e) {
								error.setErrorString(error.getErrorString()+"\n Error when deleting folder: "+e.getMessage());
							}
							return output;
						}
					}
				}
			} else {
				error.setErrorString(error.getErrorString()+"\n Error during saving of: "+fileName);
			}
		}

		try {
			folder.delete(true, progressMonitor);
		} catch (CoreException e) {
			error.setErrorString(error.getErrorString()+"\n Error when deleting folder: "+e.getMessage());
		}
		
		return output;
	}

}
