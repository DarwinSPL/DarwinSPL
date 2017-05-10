package eu.hyvar.feature.graphical.editor.policies.feature;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.editor.commands.feature.HyFeatureDeleteCommand;

public class HyFeatureComponentEditPolicy extends ComponentEditPolicy {
	
	@Override
	protected Command createDeleteCommand(GroupRequest deleteRequest) {
		HyFeatureEditPart editPart = (HyFeatureEditPart)getHost();
		
		HyFeatureDeleteCommand deleteCommand = new HyFeatureDeleteCommand((DwGraphicalFeatureModelViewer)editPart.getEditor(), getHost());
		HyFeatureWrapped wrappedFeature = (HyFeatureWrapped)getHost().getModel();
		deleteCommand.setFeature(wrappedFeature);
		
		return deleteCommand;
	}	
}
