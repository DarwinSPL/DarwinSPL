package dw.darwinspl.feature.graphical.editor.policies.feature;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;

import dw.darwinspl.feature.graphical.base.editparts.DwFeatureEditPart;
import dw.darwinspl.feature.graphical.base.figures.DwFeatureFigure;
import dw.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import dw.darwinspl.feature.graphical.editor.commands.feature.DwFeatureRenameCommand;
import dw.darwinspl.feature.graphical.editor.editor.DwGraphicalFeatureModelEditor;

public class DwFeatureDirectEditPolicy extends DirectEditPolicy {

	@Override
	protected Command getDirectEditCommand(DirectEditRequest request) {
		DwFeatureEditPart editPart = (DwFeatureEditPart)getHost();
		DwFeatureRenameCommand command = new DwFeatureRenameCommand((DwFeatureWrapped)editPart.getModel(), (DwGraphicalFeatureModelEditor)editPart.getEditor());
		command.setNewName((String)request.getCellEditor().getValue());
		
		return command;
	}

	@Override
	protected void showCurrentEditValue(DirectEditRequest request) {
		String value = (String) request.getCellEditor().getValue();
		DwFeatureFigure figure = (DwFeatureFigure)getHostFigure();
		figure.getLabel().setText(value);
	}
}
