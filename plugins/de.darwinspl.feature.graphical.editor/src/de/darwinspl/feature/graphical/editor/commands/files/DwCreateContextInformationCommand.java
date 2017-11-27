package de.darwinspl.feature.graphical.editor.commands.files;

import eu.hyvar.context.information.util.HyContextInformationUtil;

public class DwCreateContextInformationCommand extends DwCreateOrOpenFileCommand{

	@Override
	protected String getExtension() {
		return HyContextInformationUtil.getContextModelFileExtensionForXmi();
	}

}
