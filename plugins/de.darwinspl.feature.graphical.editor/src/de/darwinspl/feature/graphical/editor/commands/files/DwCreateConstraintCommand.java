package de.darwinspl.feature.graphical.editor.commands.files;

import org.eclipse.emf.ecore.EObject;

import eu.hyvar.feature.constraint.HyConstraintFactory;
import eu.hyvar.feature.constraint.util.HyConstraintUtil;

public class DwCreateConstraintCommand extends DwCreateOrOpenFileCommand{

	@Override
	protected String getExtension() {
		return HyConstraintUtil.getConstraintModelFileExtensionForConcreteSyntax();
	}

	@Override
	protected boolean isConcreteSyntax() {
		return true;
	}

	@Override
	protected EObject createNewModelInstance() {
		return HyConstraintFactory.eINSTANCE.createHyConstraintModel();
	}
	
}
