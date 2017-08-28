package eu.hyvar.reconfigurator.io.rest.spl_implementation;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import eu.hyvar.reconfigurator.io.rest.spl_implementation.io.raw_input_spl_configuration_converter.RawInputSPLConfigurationConverter;
import eu.hyvar.reconfigurator.io.rest.spl_implementation.io.raw_input_spl_configuration_converter.SignatureConfiguration;
import eu.hyvar.reconfigurator.io.rest.spl_implementation.io.raw_input_spl_configuration_converter.SignatureFeatureModel;
import eu.hyvar.reconfigurator.io.rest.spl_implementation.io.raw_input_spl_configuration_converter.SignatureManifest;
import eu.hyvar.reconfigurator.io.rest.spl_implementation.io.raw_input_spl_configuration_converter.SplFeatureModel;
import eu.hyvar.reconfigurator.io.rest.spl_implementation.io.raw_input_spl_configuration_converter.SplManifest;


public class CreateHandlerConfigurationResolutionInput extends AbstractHandler {

	private String PROJECT_NAME = "UniTo-Test";

	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String outputJson = createJson();
		PrintWriter out = response.getWriter();
		out.write(outputJson);
		response.setStatus(HttpServletResponse.SC_OK);
		baseRequest.setHandled(true);
	}

	

	private String createJson() {
		String response = "";
		
		IProgressMonitor progressMonitor = new NullProgressMonitor();
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = workspaceRoot.getProject(PROJECT_NAME);

		try {
			if (!project.exists()) {
				project.create(progressMonitor);
			}
			project.open(progressMonitor);
			project.refreshLocal(IProject.DEPTH_INFINITE, progressMonitor);
		} catch (CoreException e) {
			e.printStackTrace();
		}

		IFolder folder = null;
		String workFolderName = "extractInput2";
		while(folder == null ) {
			response += "check="+workFolderName+"\n\n";
			folder = project.getFolder(workFolderName);
			workFolderName = UUID.randomUUID().toString();
		}
		
		if(!folder.exists()) {
			try {
				folder.create(true, true, progressMonitor);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}

		try {
		
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();
			String filename = "";
			IFile readfile;
			InputStream is;
			byte[] data;
			int read, length;
	
			RawInputSPLConfigurationConverter input = new RawInputSPLConfigurationConverter();
			
			input.setDate("2017/06/27T10:25:00");
			
			
			filename = "signatures/ecuaS/ECUASignature.hymanifest_xmi";
			input.setSignatureId(filename);
			
			
			filename = "signatures/ecuaS/ECUASignature.hymanifest_xmi";
			SignatureManifest signatureManifest = new SignatureManifest();
			signatureManifest.setFilename(filename);
			readfile = folder.getFile(filename);
			is = readfile.getContents();
			length = is.available();
			read=0;
			data = new byte[length];
			while(read<length) {
				read+=is.read(data, read, (length-read));
			}
			signatureManifest.setSpecification(new String(data));
			input.setSignatureManifest(signatureManifest);

			
			filename = "signatures/ecuaS/ECUASignature.hyfeature";
			SignatureFeatureModel signatureFeatureModel = new SignatureFeatureModel();
			signatureFeatureModel.setFilename(filename);
			readfile = folder.getFile(filename);
			is = readfile.getContents();
			length = is.available();
			read=0;
			data = new byte[length];
			while(read<length) {
				read+=is.read(data, read, (length-read));
			}
			signatureFeatureModel.setSpecification(new String(data));
			input.setSignatureFeatureModel(signatureFeatureModel);
			
			
			

			
			filename = "ecua/ecua.hymanifest_xmi";
			input.setSplId(filename);
			
			
			filename = "ecua/ecua.hymanifest_xmi";
			SplManifest splManifest = new SplManifest();
			splManifest.setFilename(filename);
			readfile = folder.getFile(filename);
			is = readfile.getContents();
			length = is.available();
			read=0;
			data = new byte[length];
			while(read<length) {
				read+=is.read(data, read, (length-read));
			}
			splManifest.setSpecification(new String(data));
			input.setSplManifest(splManifest);

			
			filename = "ecua/ecua.hyfeature";
			SplFeatureModel splFeatureModel = new SplFeatureModel();
			splFeatureModel.setFilename(filename);
			readfile = folder.getFile(filename);
			is = readfile.getContents();
			length = is.available();
			read=0;
			data = new byte[length];
			while(read<length) {
				read+=is.read(data, read, (length-read));
			}
			splFeatureModel.setSpecification(new String(data));			
			input.setSplFeatureModel(splFeatureModel);
			
			
			
			
			filename = "configuration/startConfig.hyconfigurationmodel";
			SignatureConfiguration signatureConfiguration = new SignatureConfiguration();
			signatureConfiguration.setFilename(filename);
			readfile = folder.getFile(filename);
			is = readfile.getContents();
			length = is.available();
			read=0;
			data = new byte[length];
			while(read<length) {
				read+=is.read(data, read, (length-read));
			}
			signatureConfiguration.setSpecification(new String(data));			
			input.setSignatureConfiguration(signatureConfiguration);
			
			
			
			response = gson.toJson(input);
			
			// Save output file
			filename = "input_ConfigurationResolution.txt";
			IFile outfile = folder.getFile(filename);

			is = new ByteArrayInputStream(response.getBytes());
			if(!outfile.exists()) {
				outfile.create(is, true, progressMonitor);				
			} else {
				outfile.setContents(is, IFile.FORCE,
				 progressMonitor);				
			}
			
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			project.close(progressMonitor);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		return response;
	}
	
}
