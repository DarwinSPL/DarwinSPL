package eu.hyvar.feature.exporter.hfm_exporter.ui;

import java.util.ArrayList;
import java.util.List;

import org.deltaecore.feature.DEFeatureModel;
import org.deltaecore.feature.configuration.DEConfiguration;
import org.deltaecore.feature.constraint.DEConstraintModel;
import org.deltaecore.feature.mapping.DEMappingModel;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import de.christophseidl.util.eclipse.ResourceUtil;
import de.christophseidl.util.eclipse.ui.SelectionUtil;
import de.christophseidl.util.ecore.EcoreIOUtil;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.util.HyConfigurationUtil;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.constraint.util.HyConstraintUtil;
import eu.hyvar.feature.exporter.hfm_exporter.util.HyVarToDeltaEcoreModelExporter;
import eu.hyvar.feature.mapping.HyMappingModel;
import eu.hyvar.feature.mapping.util.HyMappingModelUtil;
import eu.hyvar.feature.util.HyFeatureModelWellFormednessException;
import eu.hyvar.feature.util.HyFeatureUtil;

public class ExportToHFMCommandHandler extends AbstractHandler {
	
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		IFile featureModelFile = SelectionUtil.getFirstSelectedIFileWithExtension(HyFeatureUtil.getFeatureModelFileExtensionForXmi());
		
		List<IFile> modelFiles = new ArrayList<IFile>();
		if(featureModelFile == null || !featureModelFile.exists()) {
			// Error
			return null;
		} else {
			modelFiles.add(featureModelFile);			
		}
		
		
//		IFile configurationFile = null;
//		IFile constraintModelFile = null;
//		IFile mappingFile = null;
		
//		IContainer parentContainer = featureModelFile.getParent();
//		IFolder parentFolder = null;
//		if(parentContainer instanceof IFolder) {
//			parentFolder = (IFolder) parentContainer;
//			String filename = featureModelFile.getName();
//			filename = filename.substring(0, filename.length()-featureModelFile.getFileExtension().length());
			
		IFile constraintModelFile = ResourceUtil.deriveFile(featureModelFile, HyConstraintUtil.getConstraintModelFileExtensionForXmi());
		IFile mappingFile = ResourceUtil.deriveFile(featureModelFile, HyMappingModelUtil.getMappingModelFileExtensionForConcreteSyntax());
		IFile configurationFile = ResourceUtil.deriveFile(featureModelFile, HyConfigurationUtil.getConfigurationModelFileExtensionForXmi());
		
//		}
		
		
		if(constraintModelFile != null && constraintModelFile.exists()) {
			modelFiles.add(constraintModelFile);
		}
		
		if(configurationFile != null && configurationFile.exists()) {
			modelFiles.add(configurationFile);
		}
		
		if(mappingFile != null && mappingFile.exists()) {
			modelFiles.add(mappingFile);
		}
		
		List<EObject> models = EcoreIOUtil.loadModels(modelFiles);
		
		HyFeatureModel featureModel = null;
		HyConstraintModel constraintModel = null;
		HyConfiguration configuration = null;
		HyMappingModel mappingModel = null;
		
		for(EObject object: models) {
			if(object instanceof HyFeatureModel) {
				featureModel = (HyFeatureModel) object;
			}
			else if(object instanceof HyConstraintModel) {
				constraintModel = (HyConstraintModel) object;
			}
			else if(object instanceof HyConfiguration) {
				configuration = (HyConfiguration) object;
			}
			else if(object instanceof HyMappingModel) {
				mappingModel = (HyMappingModel) object;
			}
		}
		
		
		try {
			List<EObject> deltaEcoreModels = HyVarToDeltaEcoreModelExporter.translateModels(featureModel, constraintModel, configuration, mappingModel, null);
			
			
			for(EObject object: deltaEcoreModels) {
				if(object instanceof DEFeatureModel) {
					IFile deFeatureModelFile = ResourceUtil.deriveFile(featureModelFile, "defeaturemodel");
					EcoreIOUtil.saveModelAs((DEFeatureModel) object, deFeatureModelFile);
				}
				else if(object instanceof DEConstraintModel) {
//					IFile deConstraintModelFile = ResourceUtil.deriveFile(featureModelFile, "constraints_plain");
					IFile deConstraintModelFile = ResourceUtil.deriveFile(featureModelFile, "deconstraints");
					EcoreIOUtil.saveModelAs((DEConstraintModel) object, deConstraintModelFile);
				}
				else if(object instanceof DEConfiguration) {
					IFile deConfigurationFile = ResourceUtil.deriveFile(featureModelFile, "deconfiguration");
//					IFile deConfigurationFile = ResourceUtil.deriveFile(featureModelFile, "configuration");
					EcoreIOUtil.saveModelAs((DEConfiguration) object, deConfigurationFile);
				}
				else if(object instanceof DEMappingModel) {
					IFile deMappingFile = ResourceUtil.deriveFile(featureModelFile, "demapping");
					EcoreIOUtil.saveModelAs((DEMappingModel) object, deMappingFile);
				}
			}
			
		} catch (final HyFeatureModelWellFormednessException e1) {
			PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
			    public void run() {
				    Shell activeShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				    final String PID = "HFM Exporter Plugin";
				    MultiStatus info = new MultiStatus(PID, 1, e1.getMessage(), null);
				    ErrorDialog.openError(activeShell, "HyFM not well formed!", null, info);
				}
			});
			e1.printStackTrace();
		}
		
//		HFMExporter exporter = new HFMExporter();
//		try {
//			// TODO date abfragen
//			DEFeatureModel exportedFeatureModel = (DEFeatureModel) exporter.exportValidFeatureModel(featureModel);
//			IFile exportedFile = ResourceUtil.deriveFile(featureModelFile, "feature");
//			EcoreIOUtil.saveModelAs(exportedFeatureModel, exportedFile);
//		} catch(final HyFeatureModelWellFormednessException e) {
//			PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
//			    public void run() {
//				    Shell activeShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
//				    final String PID = "HFM Exporter Plugin";
//				    MultiStatus info = new MultiStatus(PID, 1, e.getMessage(), null);
//				    ErrorDialog.openError(activeShell, "HyFM not well formed!", null, info);
//				}
//			});
//			e.printStackTrace();
//		}

		//DEBUG SAVE
//		CarAssistanceExampleExportToHFM example = new CarAssistanceExampleExportToHFM();
//		EObject model = example.createExample();
//		
//		IFile file = ResourceUtil.getLocalFile("Example/Example.hyfeature");
//		EcoreIOUtil.saveModelAs(model, file);
		
		return null;
	}

}
