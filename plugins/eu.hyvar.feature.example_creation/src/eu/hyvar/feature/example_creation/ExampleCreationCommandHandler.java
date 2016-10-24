package eu.hyvar.feature.example_creation;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import eu.hyvar.feature.example_creation.examples.CarAssistanceExample;
import eu.hyvar.feature.example_creation.examples.HyFMExample;
import eu.hyvar.feature.example_creation.examples.HyVarUseCaseGM;
import eu.hyvar.feature.example_creation.examples.HyVarUseCaseOne;
import eu.hyvar.feature.example_creation.examples.HyVarUseCases;
import eu.hyvar.feature.example_creation.examples.IsolaExample;
import eu.hyvar.feature.example_creation.examples.SmallEvolutionExample;
import eu.hyvar.feature.example_creation.examples.VamosReconfExample;
import eu.hyvar.feature.example_creation.wizard.ExampleSelectionWizard;

public class ExampleCreationCommandHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// IFile featureModelFile =
		// SelectionUtil.getFirstSelectedIFileWithExtension("hyfeature");
		//
		// if (featureModelFile == null) {
		// //TODO: Error
		// return null;
		// }
		//
		// HyFeatureModel featureModel =
		// EcoreIOUtil.loadModel(featureModelFile);
		//
		// try {
		// DEFeatureModel exportedFeatureModel = (DEFeatureModel)
		// exporter.exportValidFeatureModel(featureModel);
		// IFile exportedFile = ResourceUtil.deriveFile(featureModelFile,
		// "feature");
		// EcoreIOUtil.saveModelAs(exportedFeatureModel, exportedFile);
		// } catch(HyFeatureModelWellFormednessException e) {
		// PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
		// public void run() {
		// Shell activeShell =
		// PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		// final String PID = "HFM Exporter Plugin";
		// MultiStatus info = new MultiStatus(PID, 1, e.getMessage(), null);
		// ErrorDialog.openError(activeShell, "HyFM not well formed!", null,
		// info);
		// }
		// });
		// e.printStackTrace();
		// }

		Map<String, Class<? extends HyFMExample>> availableExamples = new HashMap<String, Class<? extends HyFMExample>>();
		availableExamples.put("VaMoS Example", CarAssistanceExample.class);
		availableExamples.put("VaMoS Reconf Example", VamosReconfExample.class);
		availableExamples.put("HyVar Use Cases", HyVarUseCases.class);
		availableExamples.put("HyVar GM", HyVarUseCaseGM.class);
		
		availableExamples.put("Isola Example", IsolaExample.class);

		availableExamples.put("HyVarUseCaseReview", HyVarUseCaseOne.class);
		
		availableExamples.put("Small Evolution Example", SmallEvolutionExample.class);
		
		ExampleSelectionWizard exampleSelectionWizard = new ExampleSelectionWizard(availableExamples);

		Shell activeShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

		WizardDialog wizardDialog = new WizardDialog(activeShell, exampleSelectionWizard);
		wizardDialog.open();
		
		
		return null;
	}

}