package eu.hyvar.feature.graphical.editor.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import eu.hyvar.feature.graphical.base.editparts.HyFeatureEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.editor.commands.feature.HyFeatureDeleteCommand;

public class HyFeatureComponentEditPolicy extends ComponentEditPolicy {
	
	@Override
	protected Command createDeleteCommand(GroupRequest deleteRequest) {
		HyFeatureEditPart editPart = (HyFeatureEditPart)this.getHost();
		HyFeatureModelWrapped model = editPart.getEditor().getModelWrapped();
		
		HyFeatureDeleteCommand deleteCommand = new HyFeatureDeleteCommand();
		HyFeatureWrapped wrappedFeature = (HyFeatureWrapped)getHost().getModel();
		deleteCommand.setFeature(wrappedFeature);
		deleteCommand.setModel(model);
		
		return deleteCommand;
	}	
}
