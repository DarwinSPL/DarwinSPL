package eu.hyvar.feature.graphical.configurator.editor.listeners;

import java.util.Date;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;

import de.christophseidl.util.ecore.EcoreIOUtil;
import de.darwinspl.feature.configuration.variantgeneration.DwConfigurationVariantCreator;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.graphical.configurator.composites.DwVariantComposite;
import eu.hyvar.feature.graphical.configurator.dialogs.DwVariantDerivationDialog;
import eu.hyvar.feature.graphical.configurator.editor.HyFeatureModelConfiguratorEditor;
import eu.hyvar.feature.mapping.HyMappingModel;
import eu.hyvar.feature.mapping.util.HyMappingModelUtil;

public class DwDeriveVariantListener extends SelectionAdapter {

	private HyFeatureModelConfiguratorEditor configurator;

	public DwDeriveVariantListener(HyFeatureModelConfiguratorEditor configurator) {
		super();
		this.configurator = configurator;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		Shell shell = configurator.getShell();
		
		
		HyConfiguration configuration = configurator.getConfiguration();
		HyFeatureModel featureModel = configurator.getFeatureModel();
		EcoreIOUtil.getFile(featureModel);		
		
		EObject loadedObject = EcoreIOUtil.loadAccompanyingModel(featureModel, HyMappingModelUtil.getMappingModelFileExtensionForConcreteSyntax(), HyMappingModelUtil.getMappingModelFileExtensionForXmi());			
		
		if(loadedObject == null || !(loadedObject instanceof HyMappingModel)) {
			MessageDialog.openInformation(shell, "Could not find Mapping Model", "No Mapping Model with file extension "+HyMappingModelUtil.getMappingModelFileExtensionForConcreteSyntax()+" or "+ HyMappingModelUtil.getMappingModelFileExtensionForXmi()+" found!");
			return;
		}
		
		
		HyMappingModel mapping = (HyMappingModel) loadedObject;

		DwConfigurationVariantCreator variantCreator = new DwConfigurationVariantCreator();


		Date date = configurator.getCurrentSelectedDate();

		try {
			DwVariantDerivationDialog dialog = new DwVariantDerivationDialog(shell);
			int result = dialog.open();

			if (result == Dialog.OK) {
				DwVariantComposite variantComposite = dialog.getVariantComposite();
				IFolder variantFolder = variantComposite.getFolder();

				variantCreator.createAndSaveVariantFromConfiguration(featureModel, configuration, mapping, date, variantFolder);

				IPath variantFolderPath = variantFolder.getFullPath();
				MessageDialog.openInformation(shell, "Variant Creation Completed",
						"Variant successfully created in \"" + variantFolderPath.toOSString() + "\".");
			}

		} catch (Exception ex) {
			// Debug
			ex.printStackTrace();

			String message = "Variant could not be derived:\n\n" + ex.getMessage();
			MessageDialog.openError(shell, "Error", message);
		}

	}

}
