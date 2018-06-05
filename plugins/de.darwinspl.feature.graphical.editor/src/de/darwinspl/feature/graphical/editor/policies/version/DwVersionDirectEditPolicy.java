package de.darwinspl.feature.graphical.editor.policies.version;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwVersionEditPart;
import de.darwinspl.feature.graphical.base.figures.DwVersionFigure;
import de.darwinspl.feature.graphical.editor.commands.version.DwVersionRenameCommand;
import eu.hyvar.feature.HyVersion;

public class DwVersionDirectEditPolicy extends DirectEditPolicy {

	@Override
	protected Command getDirectEditCommand(DirectEditRequest request) {
		DwVersionEditPart editPart = (DwVersionEditPart)getHost();
		DwVersionRenameCommand command = new DwVersionRenameCommand((HyVersion)editPart.getModel(), (DwGraphicalFeatureModelViewer)editPart.getEditor());
		command.setNewNumber((String)request.getCellEditor().getValue());
		
		
		return command;
	}

	@Override
	protected void showCurrentEditValue(DirectEditRequest request) {
		String value = (String) request.getCellEditor().getValue();
		DwVersionFigure figure = (DwVersionFigure)getHostFigure();
		figure.getLabel().setText(value);
	}
	
}
