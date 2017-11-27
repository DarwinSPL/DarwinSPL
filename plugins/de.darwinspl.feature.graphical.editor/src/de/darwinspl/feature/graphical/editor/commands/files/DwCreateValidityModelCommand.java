package de.darwinspl.feature.graphical.editor.commands.files;

import org.eclipse.emf.ecore.EObject;

import eu.hyvar.context.contextValidity.HyContextValidityFactory;
import eu.hyvar.context.contextValidity.util.HyValidityModelUtil;

public class DwCreateValidityModelCommand extends DwCreateOrOpenFileCommand{

	@Override
	protected String getExtension() {
		return HyValidityModelUtil.getValidityModelFileExtensionForConcreteSyntax();
	}

	@Override
	protected boolean isConcreteSyntax() {
		return true;
	}

	@Override
	protected EObject createNewModelInstance() {
		return HyContextValidityFactory.eINSTANCE.createHyValidityModel();
	}

}