package de.darwinspl.util;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.ui.handlers.HandlerUtil;

import de.christophseidl.util.eclipse.ui.SelectionUtil;
import de.christophseidl.util.ecore.EcoreIOUtil;
import eu.hyvar.feature.HyFeatureModel;

public class RandomAttributeGeneratorCommandHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IFile file = SelectionUtil.getFirstActiveIFileWithExtension("hyfeature");
		HyFeatureModel featureModel = (HyFeatureModel)EcoreIOUtil.loadModel(file);
		
		RandomAttributeGeneratorDialog dialog = new RandomAttributeGeneratorDialog(HandlerUtil.getActiveWorkbenchWindow(event).getShell());
		if(dialog.open() != Dialog.OK) {
			return null;
		}
		
		RandomAttributeGenerator generator = new RandomAttributeGenerator(featureModel, null, null);
		featureModel = generator.generateAttributes(dialog.getType());
		
		EcoreIOUtil.saveModelAs(featureModel, file);
		return null;
	}

}
