package eu.hyvar.feature.graphical.editor.commands.files;

import eu.hyvar.context.information.util.HyContextInformationUtil;

public class DwCreateContextInformationCommand extends DwCreateFileCommand{

	@Override
	protected String getExtension() {
		return HyContextInformationUtil.getContextModelFileExtensionForConcreteSyntax();
	}

}
