package eu.hyvar.feature.graphical.configurator.editor.listeners;

import java.util.Date;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;

import de.darwinspl.feature.configuration.variantgeneration.DwConfigurationVariantCreator;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.graphical.configurator.composites.DwVariantComposite;
import eu.hyvar.feature.graphical.configurator.dialogs.DwVariantDerivationDialog;
import eu.hyvar.feature.graphical.configurator.editor.HyFeatureModelDeltaModuleConfiguratorEditor;

public class DwDeriveVariantListener extends SelectionAdapter {

	private HyFeatureModelDeltaModuleConfiguratorEditor configurator;

	public DwDeriveVariantListener(HyFeatureModelDeltaModuleConfiguratorEditor configurator) {
		super();
		this.configurator = configurator;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		HyConfiguration configuration = configurator.getConfiguration();
		HyFeatureModel featureModel = configurator.getFeatureModel();

		DwConfigurationVariantCreator variantCreator = new DwConfigurationVariantCreator();

		Shell shell = configurator.getShell();

		Date date = configurator.getCurrentSelectedDate();

		try {
			DwVariantDerivationDialog dialog = new DwVariantDerivationDialog(shell);
			int result = dialog.open();

			if (result == Dialog.OK) {
				DwVariantComposite variantComposite = dialog.getVariantComposite();
				IFolder variantFolder = variantComposite.getFolder();

				variantCreator.createAndSaveVariantFromConfiguration(featureModel, configuration, date, variantFolder);

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
