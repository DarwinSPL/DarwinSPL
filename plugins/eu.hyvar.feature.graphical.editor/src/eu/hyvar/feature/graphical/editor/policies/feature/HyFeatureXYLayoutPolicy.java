package eu.hyvar.feature.graphical.editor.policies.feature;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import eu.hyvar.feature.graphical.editor.policies.HyFeatureModelResizablePolicy;

public class HyFeatureXYLayoutPolicy extends XYLayoutEditPolicy{

	@Override
	protected Command getCreateCommand(CreateRequest request) {
		return null;
	}

	@Override
	protected Command getMoveChildrenCommand(Request request) {
		return null; 
	}

	@Override 
	protected EditPolicy createChildEditPolicy(EditPart child) {
		return new HyFeatureModelResizablePolicy();
	}
}
