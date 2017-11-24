package de.darwinspl.feature.graphical.editor.commands.files;

import org.eclipse.emf.ecore.EObject;

import eu.hyvar.context.HyContextInformationFactory;
import eu.hyvar.context.information.util.HyContextInformationUtil;

public class DwCreateContextInformationCommand extends DwCreateOrOpenFileCommand{

	@Override
	protected String getExtension() {
		return HyContextInformationUtil.getContextModelFileExtensionForXmi();
	}

	@Override
	protected boolean isConcreteSyntax() {
		return false;
	}

	@Override
	protected EObject createNewModelInstance() {
		return HyContextInformationFactory.eINSTANCE.createHyContextModel();
	}

}
