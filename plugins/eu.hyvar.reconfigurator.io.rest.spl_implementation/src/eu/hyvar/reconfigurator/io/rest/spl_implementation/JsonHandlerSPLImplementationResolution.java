package eu.hyvar.reconfigurator.io.rest.spl_implementation;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
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
import eu.hyvar.reconfigurator.io.rest.spl_implementation.io.raw_output_spl_implementation_resolution.RawOutputError;
import eu.hyvar.reconfigurator.io.rest.spl_implementation.io.raw_output_spl_implementation_resolution.RawOutputSPLImplementationResolution;

public class JsonHandlerSPLImplementationResolution extends AbstractHandler {

	private String MSG_TYPE_JSON_INPUT = "implementation_selection";
	private boolean DEVEL = true;

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
			error.setErrorString(error.getErrorString()+"\nError during input parsing: "+e.toString());
		}
		

		if (msgType.equals(MSG_TYPE_JSON_INPUT)) {
			RawInputSPLImplementationResolution rawInput = gson.fromJson(jsonInput, RawInputSPLImplementationResolution.class);
			
			RawOutputSPLImplementationResolution output = saveAndAnalize(rawInput, error);
			responseString = gson.toJson(output);
		} else {
			error.setErrorString(error.getErrorString()+"\nWrong type of message, expect: "+MSG_TYPE_JSON_INPUT);
		}
		
		if(!"".equals(error.getErrorString())) {
			responseString = gson.toJson(error);
		}
			
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(responseString);
		response.setStatus(HttpServletResponse.SC_OK);
		baseRequest.setHandled(true);
	}

	private RawOutputSPLImplementationResolution saveAndAnalize(RawInputSPLImplementationResolution rawInput, RawOutputError error) {
		
		RawOutputSPLImplementationResolution output = new RawOutputSPLImplementationResolution();
		output.setSplId("");
		
		ResourceSetImpl baseContext = new ResourceSetImpl();

		Date currentInstant = HyEvolutionResolverUtil.resolveDate(rawInput.getDate());

		
		IProgressMonitor progressMonitor = null;
		IFolder folder = null;
		try {
			folder = WorkspaceManager.getWorkspaceManager().getNewIFolder();
			progressMonitor = WorkspaceManager.getWorkspaceManager().getIProgressMonitor();
		} catch (CoreException e) {
			error.setErrorString(error.getErrorString()+"\nError creating folder and monitor: "+e.toString());
		}


		String fileName = "";
		IFile ifile;
		InputStream inputStream;
		EObject object;
		
		// Saving the Signature to be implemented
		HySPLSignature signatureToImplement = null;

		fileName = rawInput.getSplSignature().getFeatureModel().getFilename();
		if(fileName.startsWith("\\")||fileName.startsWith("/")) {
			fileName = fileName.substring(1);
		}
		createFilePath(fileName, folder, progressMonitor, error);

		ifile = folder.getFile(fileName);
		inputStream = new ByteArrayInputStream(rawInput.getSplSignature().getFeatureModel().getSpecification().getBytes());
		try {
			if(!ifile.exists()) {
				ifile.create(inputStream, true, progressMonitor);				
			} else {
				ifile.setContents(inputStream, IFile.FORCE, progressMonitor);
			}
		} catch (CoreException e) {
			error.setErrorString(error.getErrorString()+"\nError creating file ("+fileName+"): "+e.toString());
			e.printStackTrace();
		}
		
		fileName = rawInput.getSplSignature().getSignatureModel().getFilename();
		if(fileName.startsWith("\\")||fileName.startsWith("/")) {
			fileName = fileName.substring(1);
		}
		createFilePath(fileName, folder, progressMonitor, error);

		ifile = folder.getFile(fileName);
		inputStream = new ByteArrayInputStream(rawInput.getSplSignature().getSignatureModel().getSpecification().getBytes());
		try {
			if(!ifile.exists()) {
				ifile.create(inputStream, true, progressMonitor);				
			} else {
				ifile.setContents(inputStream, IFile.FORCE, progressMonitor);
			}
		} catch (CoreException e) {
			error.setErrorString(error.getErrorString()+"\nError creating file ("+fileName+"): "+e.toString());
			e.printStackTrace();
		}
				
		object = EcoreIOUtil.loadModel(ifile, baseContext);
		if (object instanceof HySPLSignature) {
			signatureToImplement = (HySPLSignature) object;
		}

		
		
		// Save and check the implementation
		HySPLImplementation modelToCheck = null;

		List<SplImplementation> implementations = rawInput.getSplImplementations();
		for (SplImplementation implementation: implementations) {
			modelToCheck = null;

			// Save the implementation
			fileName = implementation.getFeatureModel().getFilename();
			if(fileName.startsWith("\\")||fileName.startsWith("/")) {
				fileName = fileName.substring(1);
			}
			createFilePath(fileName, folder, progressMonitor, error);

			ifile = folder.getFile(fileName);
			inputStream = new ByteArrayInputStream(implementation.getFeatureModel().getSpecification().getBytes());
			try {
				if(!ifile.exists()) {
					ifile.create(inputStream, true, progressMonitor);				
				} else {
					ifile.setContents(inputStream, IFile.FORCE, progressMonitor);
				}
			} catch (CoreException e) {
				error.setErrorString(error.getErrorString()+"\nError creating file ("+fileName+"): "+e.toString());
				e.printStackTrace();
			}
			
			fileName = implementation.getSignatureModel().getFilename();
			if(fileName.startsWith("\\")||fileName.startsWith("/")) {
				fileName = fileName.substring(1);
			}
			createFilePath(fileName, folder, progressMonitor, error);

			ifile = folder.getFile(fileName);
			inputStream = new ByteArrayInputStream(implementation.getSignatureModel().getSpecification().getBytes());
			try {
				if(!ifile.exists()) {
					ifile.create(inputStream, true, progressMonitor);				
				} else {
					ifile.setContents(inputStream, IFile.FORCE, progressMonitor);
				}
			} catch (CoreException e) {
				error.setErrorString(error.getErrorString()+"\nError creating file ("+fileName+"): "+e.toString());
				e.printStackTrace();
			}
			
			
			// Check if is a valid implementation
			object = EcoreIOUtil.loadModel(ifile, baseContext);
			if (object instanceof HySPLImplementation) {
				modelToCheck = (HySPLImplementation) object;
			}
			
			EList<HyTimedImplementations> elems = modelToCheck.getImplementations();
			for(HyTimedImplementations elem: elems) {
				if( HyEvolutionUtil.isValid(elem, currentInstant) ) {
					if(signatureToImplement==elem.getSignature()) {
						output.setSplId(implementation.getSignatureId());
						try {
							if(!DEVEL) {
								folder.delete(true, progressMonitor);
							}
						} catch (CoreException e) {
							error.setErrorString(error.getErrorString()+"\nError when deleting folder: "+e.getMessage());
						}
						return output;
					}
				}
			}
		}

		try {
			if(!DEVEL) {
				folder.delete(true, progressMonitor);
			}
		} catch (CoreException e) {
			error.setErrorString(error.getErrorString()+"\nError when deleting folder: "+e.getMessage());
		}
		
		return output;
	}


	private void createFilePath(String fileName, IFolder folder, IProgressMonitor progressMonitor, RawOutputError error) {

		String relativePath = "";
		try {
			String elements[] = fileName.split("/|\\\\");
			// Remove the file name (last element)
			elements[elements.length-1]="";
			
			IFolder relativeFolder;
			for(String element: elements) {
				if(!"".equals(element)) {
					relativeFolder = folder.getFolder(relativePath+element);
					if(!relativeFolder.exists()) {
						relativeFolder.create(true, true, progressMonitor);
					}
					relativePath += element+"/";
				}
			}
		} catch (CoreException e) {
			error.setErrorString(error.getErrorString()+"\nError creating folder ("+relativePath+"): "+e.toString());
		}
	}


}
