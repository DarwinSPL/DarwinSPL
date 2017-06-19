package de.darwinspl.io.ui.commands;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
//import org.eclipse.swt.widgets.Display;
//import org.eclipse.swt.widgets.Shell;

import de.christophseidl.util.eclipse.ResourceUtil;
import de.christophseidl.util.eclipse.ui.SelectionUtil;
import de.darwinspl.importer.FeatureModelConstraintsTuple;
import de.darwinspl.importer.splot.SplotFeatureModelAndConstraintsImporter;
import eu.hyvar.reconfigurator.input.exporter.HyVarRecExporter;

public class SplotToHyVarRecTranslator extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		
		List<IResource> resources = SelectionUtil.getSelectedResources();
		
		IFolder folder = null;
		
		for(IResource resource: resources) {
			if(resource instanceof IFolder) {
				folder = (IFolder) resource;
				break;
			}
		}
		
		if(folder == null ) {
			return null;
		}
		
		try {
			IResource[] members = folder.members();

			for(int i = 0; i<members.length;i++) {
				IResource member = members[i];
				if(member instanceof IFile) {
					
					IFile ifile = (IFile) member;
					
					String extension = ifile.getFileExtension();
					
					if(!extension.equals("xml")) {
						continue;
					}
					
					SplotFeatureModelAndConstraintsImporter importer = new SplotFeatureModelAndConstraintsImporter();
					FeatureModelConstraintsTuple tuple = importer.importFeatureModel(ifile);
					
					HyVarRecExporter hyvarrecExporter = new HyVarRecExporter();

//					Display display = Display.getDefault();
//				    Shell shell = display.getActiveShell();
					
					String hyVarRecString = hyvarrecExporter.exportSPL(null, null, tuple.getFeatureModel(),
							tuple.getConstraintModel(), null, null, null, new Date());

					String baseFileName = ResourceUtil.getBaseFilename(ifile) + "_HyVarRecOutput";
					
					IFile hyVarRecOutputFile = ResourceUtil.getFileInSameContainer(ifile,baseFileName+".json");
					
					if(hyVarRecOutputFile.exists()) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
						
						Date date = new Date();
						hyVarRecOutputFile = ResourceUtil.getFileInSameContainer(ifile,baseFileName+"_"+dateFormat.format(date)+".json");
					}
					
					int counter = 1;
					while(hyVarRecOutputFile.exists()) {
						hyVarRecOutputFile = ResourceUtil.getFileInSameContainer(ifile,baseFileName+"_"+counter+".json");
						counter++;
					}
					

					InputStream source = new ByteArrayInputStream(hyVarRecString.getBytes());
					try {
						hyVarRecOutputFile.create(source, IResource.FORCE, null);
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		return null;
	}

}
