package dw.darwinspl.feature.graphical.editor.policies.feature;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gef.requests.ReconnectRequest;

import dw.darwinspl.feature.graphical.base.model.DwParentChildConnection;
import dw.darwinspl.feature.graphical.editor.commands.DwParentChildConnectionDeleteCommand;

public class DwParentChildConnectionEditPolicy extends ConnectionEditPolicy{

	@Override
	protected Command getDeleteCommand(GroupRequest request) {
		DwParentChildConnectionDeleteCommand command = new DwParentChildConnectionDeleteCommand();
		command.setConnection((DwParentChildConnection)getHost().getModel());
		
		return command;
	}
	
	protected void eraseConnectionMoveFeedback(ReconnectRequest request){
	}
}
