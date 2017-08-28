package de.darwinspl.feature.graphical.editor.commands.files;

import eu.hyvar.feature.constraint.util.HyConstraintUtil;

public class DwCreateConstraintCommand extends DwCreateOrOpenFileCommand{

	@Override
	protected String getExtension() {
		return HyConstraintUtil.getConstraintModelFileExtensionForConcreteSyntax();
	}
	
}
