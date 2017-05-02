package dw.darwinspl.feature.graphical.editor.commands.files;

import eu.hyvar.context.contextValidity.util.HyValidityModelUtil;

public class DwCreateValidityModelCommand extends DwCreateFileCommand{

	@Override
	protected String getExtension() {
		return HyValidityModelUtil.getValidityModelFileExtensionForConcreteSyntax();
	}

}
