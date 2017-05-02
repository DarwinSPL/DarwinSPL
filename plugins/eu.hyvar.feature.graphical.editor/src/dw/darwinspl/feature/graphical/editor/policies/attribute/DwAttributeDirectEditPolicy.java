package dw.darwinspl.feature.graphical.editor.policies.attribute;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;

import dw.darwinspl.feature.graphical.base.editparts.DwAttributeEditPart;
import dw.darwinspl.feature.graphical.base.figures.DwAttributeFigure;
import dw.darwinspl.feature.graphical.editor.commands.attribute.DwAttributeRenameCommand;
import dw.darwinspl.feature.graphical.editor.editor.DwGraphicalFeatureModelEditor;
import eu.hyvar.feature.HyFeatureAttribute;

public class DwAttributeDirectEditPolicy extends DirectEditPolicy {

	@Override
	protected Command getDirectEditCommand(DirectEditRequest request) {
		DwAttributeEditPart editPart = (DwAttributeEditPart)getHost();
		DwAttributeRenameCommand command = new DwAttributeRenameCommand((HyFeatureAttribute)editPart.getModel(), (DwGraphicalFeatureModelEditor)editPart.getEditor());
		command.setNewName((String)request.getCellEditor().getValue());
		
		return command;
	}

	@Override
	protected void showCurrentEditValue(DirectEditRequest request) {
		String value = (String) request.getCellEditor().getValue();
		DwAttributeFigure figure = (DwAttributeFigure)getHostFigure();
		figure.getLabel().setText(value);
	}
}
