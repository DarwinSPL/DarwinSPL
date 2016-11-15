package eu.hyvar.feature.graphical.editor.policies.feature;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;

import eu.hyvar.feature.graphical.base.editparts.HyFeatureEditPart;
import eu.hyvar.feature.graphical.base.figures.HyFeatureFigure;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.editor.commands.feature.HyFeatureEvolutionRenameCommand;
import eu.hyvar.feature.graphical.editor.editor.GraphicalEvolutionFeatureModelEditor;

public class HyFeatureDirectEditPolicy extends DirectEditPolicy {

	@Override
	protected Command getDirectEditCommand(DirectEditRequest request) {
		HyFeatureEditPart editPart = (HyFeatureEditPart)getHost();
		HyFeatureEvolutionRenameCommand command = new HyFeatureEvolutionRenameCommand((HyFeatureWrapped)editPart.getModel(), (GraphicalEvolutionFeatureModelEditor)editPart.getEditor());
		command.setNewName((String)request.getCellEditor().getValue());
		
		return command;
	}

	@Override
	protected void showCurrentEditValue(DirectEditRequest request) {
		String value = (String) request.getCellEditor().getValue();
		HyFeatureFigure figure = (HyFeatureFigure)getHostFigure();
		figure.getLabel().setText(value);
	}
}
