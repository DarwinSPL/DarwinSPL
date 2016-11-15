package eu.hyvar.feature.graphical.editor.policies.enums;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;

import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.feature.graphical.base.editparts.HyEnumEditPart;
import eu.hyvar.feature.graphical.base.figures.HyEnumFigure;
import eu.hyvar.feature.graphical.editor.commands.enumeration.HyEnumRenameCommand;

public class HyEnumDirectEditPolicy extends DirectEditPolicy {

	@Override
	protected Command getDirectEditCommand(DirectEditRequest request) {
		HyEnumEditPart editPart = (HyEnumEditPart)getHost();
		HyEnumRenameCommand command = new HyEnumRenameCommand((HyEnum)editPart.getModel());
		command.setNewName((String)request.getCellEditor().getValue());
		
		return command;
	}

	@Override
	protected void showCurrentEditValue(DirectEditRequest request) {
		String value = (String) request.getCellEditor().getValue();
		HyEnumFigure figure = (HyEnumFigure)getHostFigure();
		figure.getLabel().setText(value);
	}
}
