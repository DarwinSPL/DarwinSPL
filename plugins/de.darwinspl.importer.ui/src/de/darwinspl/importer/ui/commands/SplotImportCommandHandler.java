package de.darwinspl.importer.ui.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;

import de.christophseidl.util.eclipse.ResourceUtil;
import de.christophseidl.util.eclipse.ui.JFaceUtil;
import de.christophseidl.util.eclipse.ui.SelectionUtil;
import de.christophseidl.util.ecore.EcoreIOUtil;
import de.darwinspl.importer.FeatureModelConstraintsTuple;
import de.darwinspl.importer.splot.SplotFeatureModelAndConstraintsImporter;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.constraint.util.HyConstraintUtil;
import eu.hyvar.feature.util.HyFeatureUtil;

/**
 * With code from Christoph Seidl (www.deltaecore.org)
 * 
 * @author mnieke
 *
 */
public class SplotImportCommandHandler extends AbstractHandler {
	private static final String splotFeatureModelFileExtension = "xml";

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IFile selectedFile = SelectionUtil.getFirstActiveIFileWithExtension(splotFeatureModelFileExtension);

		if (selectedFile == null || !selectedFile.exists()) {
			JFaceUtil.alertError("No SPLOT feature model with extension ." + splotFeatureModelFileExtension
					+ " specified for import.");
			// TODO: Error
			return null;
		}

		SplotFeatureModelAndConstraintsImporter importer = new SplotFeatureModelAndConstraintsImporter();
		FeatureModelConstraintsTuple tuple = importer.importFeatureModel(selectedFile);

		// Save the DarwinSPL feature model
		HyFeatureModel featureModel = tuple.getFeatureModel();

		String featureModelFileExtension = HyFeatureUtil.getFeatureModelFileExtensionForXmi();
		IFile featureModelFile = ResourceUtil.deriveFile(selectedFile, featureModelFileExtension);
		EcoreIOUtil.saveModelAs(featureModel, featureModelFile);

		String message = "Feature model saved to " + featureModelFile.getFullPath();

		// Save the DarwinSPL constraint model (if any)
		HyConstraintModel constraintModel = tuple.getConstraintModel();

		if (constraintModel != null) {
			String constraintModelFileExtension = HyConstraintUtil.getConstraintModelFileExtensionForXmi();
			IFile constraintModelFile = ResourceUtil.deriveFile(selectedFile, constraintModelFileExtension);
			EcoreIOUtil.saveModelAs(constraintModel, constraintModelFile);

			message += " and constraint model saved to " + constraintModelFile.getFullPath();
		}

		message += ".";

		JFaceUtil.alertInformation(message);

		return null;
	}

}
