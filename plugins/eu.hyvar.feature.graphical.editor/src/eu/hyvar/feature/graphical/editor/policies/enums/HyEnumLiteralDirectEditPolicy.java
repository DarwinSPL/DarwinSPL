package eu.hyvar.feature.graphical.editor.policies.enums;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;

import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.feature.graphical.base.editparts.HyEnumLiteralEditPart;
import eu.hyvar.feature.graphical.base.figures.HyEnumLiteralFigure;
import eu.hyvar.feature.graphical.editor.commands.enumeration.HyEnumLiteralRenameCommand;

public class HyEnumLiteralDirectEditPolicy extends DirectEditPolicy {

	@Override
	protected Command getDirectEditCommand(DirectEditRequest request) {
		HyEnumLiteralEditPart editPart = (HyEnumLiteralEditPart)getHost();
		HyEnumLiteralRenameCommand command = new HyEnumLiteralRenameCommand((HyEnumLiteral)editPart.getModel());
		command.setNewName((String)request.getCellEditor().getValue());
		
		return command;
	}

	@Override
	protected void showCurrentEditValue(DirectEditRequest request) {
		String value = (String) request.getCellEditor().getValue();
		HyEnumLiteralFigure figure = (HyEnumLiteralFigure)getHostFigure();
		figure.getLabel().setText(value);
	}
}
