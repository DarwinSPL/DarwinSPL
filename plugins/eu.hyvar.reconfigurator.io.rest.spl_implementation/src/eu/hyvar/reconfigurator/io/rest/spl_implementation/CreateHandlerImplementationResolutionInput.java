package eu.hyvar.reconfigurator.io.rest.spl_implementation;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import eu.hyvar.reconfigurator.io.rest.spl_implementation.io.raw_input_spl_implementation_resolution.*;

public class CreateHandlerImplementationResolutionInput extends AbstractHandler {

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
		String workFolderName = "extractInput4";
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
	
			RawInputSPLImplementationResolution input = new RawInputSPLImplementationResolution();
			
			input.setDate("2017/06/27T10:25:00");
			
			SplSignature signature = new SplSignature();
			
			filename = "CAR/signatures/ecucS/ECUCSignature";
			signature.setSignatureId(filename);
			
			filename = "CAR/signatures/ecucS/ECUCSignature";
			SignatureModel sm = new SignatureModel();
			sm.setFilename(filename);
			readfile = folder.getFile(filename+".hymanifest_xmi");
			is = readfile.getContents();
			length = is.available();
			read=0;
			data = new byte[length];
			while(read<length) {
				read+=is.read(data, read, (length-read));
			}
			sm.setSpecification(new String(data));
			signature.setSignatureModel(sm);

			input.setSplSignature(signature);
			
			List<SplImplementation> implementationList = new ArrayList<SplImplementation>();
			SignatureModel_ sm_;
			SplImplementation implementation;
			
			
			// Impl 2
			implementation = new SplImplementation();
			
			filename = "ECU_C/ecuc";
			implementation.setSignatureId(filename);
			
			filename = "ECU_C/ecuc";
			sm_ = new SignatureModel_();
			sm_.setFilename(filename);
			readfile = folder.getFile(filename+".hymanifest_xmi");
			is = readfile.getContents();
			length = is.available();
			read=0;
			data = new byte[length];
			while(read<length) {
				read+=is.read(data, read, (length-read));
			}
			sm_.setSpecification(new String(data));
			implementation.setSignatureModel(sm_);
			
			implementationList.add(implementation);
			

			input.setSplImplementations(implementationList);
			
			response = gson.toJson(input);
			
			// Save output file
			filename = "input_ImplementationResolution.txt";
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
