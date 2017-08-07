package de.darwinspl.feature.graphical.editor.commands.files;

import eu.hyvar.context.contextValidity.util.HyValidityModelUtil;

public class DwCreateValidityModelCommand extends DwCreateOrOpenFileCommand{

	@Override
	protected String getExtension() {
		return HyValidityModelUtil.getValidityModelFileExtensionForConcreteSyntax();
	}

}
