package de.darwinspl.feature.graphical.configurator.editor.listeners;

import java.util.Date;

import org.deltaecore.core.decore.util.DEDeltaRequirementsCycleException;
import org.eclipse.core.resources.IFolder;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;

import de.darwinspl.feature.graphical.configurator.dialogs.DwContextInformationDialog;
import de.darwinspl.feature.graphical.configurator.dialogs.DwVariantDerivationDialog;
import de.darwinspl.feature.graphical.configurator.editor.DwFeatureModelConfiguratorEditor;
import de.darwinspl.solver.DwSolver;
import de.darwinspl.solver.exception.DwAttributeValueOfSelectedFeatureNotSetException;
import de.darwinspl.variant_generation.DwConfigurationVariantCreator;
import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.information.contextValue.HyContextValueModel;
import eu.hyvar.context.information.util.ContextInformationResolverUtil;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.mapping.HyMappingModel;
import eu.hyvar.feature.mapping.util.DwMappingResolverUtil;
import eu.hyvar.feature.mapping.util.HyMappingModelUtil;

public class DwDeriveVariantListener extends SelectionAdapter {

	private DwFeatureModelConfiguratorEditor configurator;
//	private IFolder tempDeltaEcoreFolder;

	public DwDeriveVariantListener(DwFeatureModelConfiguratorEditor configurator) {
		super();
		this.configurator = configurator;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		Shell shell = configurator.getShell();
		
		
		HyConfiguration configuration = configurator.getConfiguration();
		HyFeatureModel featureModel = configurator.getFeatureModel();
		
		// TODO make context value popup
		
		HyMappingModel mapping = DwMappingResolverUtil.getAccompanyingContextModel(featureModel);
		if(mapping == null) {
			MessageDialog.openInformation(shell, "Could not find Mapping Model", "No Mapping Model with file extension "+HyMappingModelUtil.getMappingModelFileExtensionForConcreteSyntax()+" or "+ HyMappingModelUtil.getMappingModelFileExtensionForXmi()+" found!");
			return;
		}



		Date date = configurator.getCurrentSelectedDate();

		
		final String failureMessageTitle = "Variant Generation Failed!";
		
		HyContextModel contextModel = ContextInformationResolverUtil.getAccompanyingContextModel(featureModel);
		
		HyContextValueModel contextValueModel = null;
		
		if(contextModel != null) {
			DwContextInformationDialog contextValueDialog = new DwContextInformationDialog(shell, contextModel, date);
			int contextValueDialogAnswer = contextValueDialog.open();
			
			switch(contextValueDialogAnswer) {
			case IDialogConstants.OK_ID:
				contextValueModel = contextValueDialog.getContextValueModel();
				break;
			case IDialogConstants.CANCEL_ID:
				return;
			case IDialogConstants.DESELECT_ALL_ID:
				contextValueModel = null;
				break;
			default:
				contextValueModel = null;
				break;
			}			
		}
		
		DwSolver solver = new DwSolver(featureModel, contextModel, date);
		
		try {
			if(!solver.isConfigurationValid(configuration, contextValueModel)) {
				MessageDialog.openInformation(shell, failureMessageTitle, failureMessageTitle + " Configuration is not valid!");
				return;
			}
		} catch (DwAttributeValueOfSelectedFeatureNotSetException e1) {
			MessageDialog.openInformation(shell, failureMessageTitle, failureMessageTitle + e1.getMessage());
			return;
		}
		
		// TODO this is currently not supporting any other variant generators than DeltaEcore deltas.
		DwVariantDerivationDialog variantDerivationDialog = new DwVariantDerivationDialog(shell);
		
		int result = variantDerivationDialog.open();
		
		if (result == Dialog.OK) {
			
			IFolder variantFolder = variantDerivationDialog.getVariantComposite().getFolder();
			
			if (variantFolder == null) {
				MessageDialog.openError(shell, failureMessageTitle, "No variant folder selected!");
				return;
			}
			
			DwConfigurationVariantCreator variantCreator = new DwConfigurationVariantCreator();
			try {
				variantCreator.createAndSaveVariantFromConfiguration(featureModel, contextModel, configuration, contextValueModel, mapping, date, variantFolder, solver);
			} catch (DwAttributeValueOfSelectedFeatureNotSetException e1) {
				MessageDialog.openInformation(shell, failureMessageTitle, failureMessageTitle + e1.getMessage());
				return;
			} catch (DEDeltaRequirementsCycleException e1) {
				e1.printStackTrace();
				MessageDialog.openInformation(shell, failureMessageTitle, failureMessageTitle + e1.getMessage());
				return;
			}
		}
	}
		// TODO Validate selected configuration
//		ValidateConfigurationResult validateConfigurationResult = doValidateConfiguration();
		
//		if (!validateConfigurationResult.getIsValid()) {
//			MessageDialog.openError(shell, failureMessageTitle, "The configuration is invalid: " + validateConfigurationResult.getErrorMessage());
//			return;
//		}
		
//		try {
//			
//			DEGenerateVariantDialog dialog = new DEGenerateVariantDialog(shell);
//			int result = dialog.open();
//			
//			if (result == Dialog.OK) {
//				DEVariantGeneratorsComposite generatorsComposite = dialog.getGeneratorsComposite();
//				DEVariantGenerator variantGenerator = generatorsComposite.getVariantGenerator();
//				
//				if (variantGenerator == null) {
//					MessageDialog.openError(shell, failureMessageTitle, "No variant generator selected!");
//					return;
//				}
//				
//				DEVariantComposite variantComposite = dialog.getVariantComposite();
//				IFolder variantFolder = variantComposite.getFolder();
//				
//				if (variantFolder == null) {
//					MessageDialog.openError(shell, failureMessageTitle, "No variant folder selected!");
//					return;
//				}
//				
//				
//				List<EObject> deltaEcoreModels = getDeltaEcoreModels(featureModel, configuration, mapping, date);
//				
//				DEConfiguration deConfiguration = null;
//				
//				for(EObject eObject : deltaEcoreModels) {
//					if(eObject instanceof DEConfiguration) {
//						deConfiguration = (DEConfiguration) eObject;
//						break;
//					}
//				}
//				
//				if(deConfiguration == null) {
//					throw new Exception("Could not translate configuration");
//				}
//				
//				variantGenerator.createAndSaveVariantFromConfiguration(deConfiguration, variantFolder);
//				
//				// clean temporary files
//				for(EObject eObject : deltaEcoreModels) {
//					eObject.eResource().delete(null);
//				}
//				tempDeltaEcoreFolder.delete(true, null);
//				
//				
//				// Output message
//				IPath variantFolderPath = variantFolder.getFullPath();
//				MessageDialog.openInformation(shell, "Variant Generation Completed", "Variant successfully generated in \"" + variantFolderPath.toOSString() + "\".");
//			}
//			
//		} catch(Exception ex) {
//			//Debug
//			ex.printStackTrace();
//			
//			String message = "Variant could not be generated:\n\n" + ex.getMessage();
//			MessageDialog.openError(shell, failureMessageTitle, message);
//		}
//
//	}
//	
//	private List<EObject> getDeltaEcoreModels(HyFeatureModel featureModel, HyConfiguration configuration, HyMappingModel mapping, Date date) {
//		List<EObject> deltaEcoreModels = new ArrayList<EObject>(3);
//		
//		HFMExporter hfmExporter = new HFMExporter();
//		DEFeatureModel deFeatureModel;
//		try {
//			deFeatureModel = hfmExporter.exportFeatureModel(featureModel, date);
//			HFMConfigurationExporter configurationExporter = new HFMConfigurationExporter(hfmExporter.getFeatureMapping(), hfmExporter.getVersionMapping(), featureModel, deFeatureModel);
//			DEConfiguration deConfiguration = configurationExporter.exportConfiguration(configuration, date);
//			
//			
//			HFMMappingExporter mappingExporter = new HFMMappingExporter(hfmExporter.getFeatureMapping(), hfmExporter.getVersionMapping());
//			DEMappingModel deMapping = mappingExporter.exportMappingModel(mapping, date);
//			
//			saveTemporaryDeltaEcoreFiles(EcoreIOUtil.getFile(featureModel.eResource()).getProject(), featureModel.eResource().getResourceSet(), deFeatureModel, deMapping, deConfiguration);
//			
//			deltaEcoreModels.add(deConfiguration);
//			deltaEcoreModels.add(deMapping);
//			deltaEcoreModels.add(deFeatureModel);
//			
//			return deltaEcoreModels;
//		} catch (HyFeatureModelWellFormednessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return deltaEcoreModels;
//		
//	}
//	
//	
//	private void saveTemporaryDeltaEcoreFiles(IProject p, ResourceSet resourceSet, DEFeatureModel featureModel, DEMappingModel mapping, DEConfiguration configuration) {
////		URI uriWithoutExtension = uri.trimFileExtension();
//		
//		if(!p.isOpen()) {
//			try {
//				p.open(null);
//			} catch (CoreException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		tempDeltaEcoreFolder = p.getFolder(".tempDeltaEcoreFiles");
//		
//		String baseFileName = "tempDeltaEcoreModel";
//		
//		IFile featureModelFile = tempDeltaEcoreFolder.getFile(baseFileName+"."+DEFeatureIOUtil.getDefaultFileExtension());
//		IFile mappingFile = tempDeltaEcoreFolder.getFile(baseFileName+"."+DEMappingIOUtil.getCurrentFileExtension());
//		IFile configurationFile = tempDeltaEcoreFolder.getFile(baseFileName+"."+DEConfigurationIOUtil.getCurrentFileExtension());
//		
//		EcoreIOUtil.saveModelAs(featureModel, featureModelFile, resourceSet);
//		EcoreIOUtil.saveModelAs(mapping, mappingFile, resourceSet);
//		EcoreIOUtil.saveModelAs(configuration, configurationFile, resourceSet);
//	}

}
