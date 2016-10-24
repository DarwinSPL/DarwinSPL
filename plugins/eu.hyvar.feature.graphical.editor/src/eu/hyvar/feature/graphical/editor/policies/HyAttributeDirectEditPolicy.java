package eu.hyvar.feature.graphical.editor.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;

import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.graphical.base.editparts.HyAttributeEditPart;
import eu.hyvar.feature.graphical.base.figures.HyAttributeFigure;
import eu.hyvar.feature.graphical.editor.commands.attribute.HyAttributeRenameCommand;
import eu.hyvar.feature.graphical.editor.editor.GraphicalEvolutionFeatureModelEditor;

public class HyAttributeDirectEditPolicy extends DirectEditPolicy {

	@Override
	protected Command getDirectEditCommand(DirectEditRequest request) {
		HyAttributeEditPart editPart = (HyAttributeEditPart)getHost();
		HyAttributeRenameCommand command = new HyAttributeRenameCommand((HyFeatureAttribute)editPart.getModel(), (GraphicalEvolutionFeatureModelEditor)editPart.getEditor());
		command.setNewName((String)request.getCellEditor().getValue());
		
		return command;
	}

	@Override
	protected void showCurrentEditValue(DirectEditRequest request) {
		String value = (String) request.getCellEditor().getValue();
		HyAttributeFigure figure = (HyAttributeFigure)getHostFigure();
		figure.getLabel().setText(value);
	}
}
