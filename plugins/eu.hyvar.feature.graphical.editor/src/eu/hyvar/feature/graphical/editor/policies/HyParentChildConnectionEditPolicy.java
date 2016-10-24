package eu.hyvar.feature.graphical.editor.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gef.requests.ReconnectRequest;

import eu.hyvar.feature.graphical.base.model.HyParentChildConnection;
import eu.hyvar.feature.graphical.editor.commands.HyParentChildConnectionDeleteCommand;

public class HyParentChildConnectionEditPolicy extends ConnectionEditPolicy{

	@Override
	protected Command getDeleteCommand(GroupRequest request) {
		HyParentChildConnectionDeleteCommand command = new HyParentChildConnectionDeleteCommand();
		command.setConnection((HyParentChildConnection)getHost().getModel());
		
		return command;
	}
	
	protected void eraseConnectionMoveFeedback(ReconnectRequest request){
	}
}
