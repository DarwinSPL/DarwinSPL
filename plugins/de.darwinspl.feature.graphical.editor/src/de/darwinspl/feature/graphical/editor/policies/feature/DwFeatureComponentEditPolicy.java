package de.darwinspl.feature.graphical.editor.policies.feature;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwFeatureEditPart;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.editor.commands.feature.DwFeatureDeleteCommand;

public class DwFeatureComponentEditPolicy extends ComponentEditPolicy {
	
	@Override
	protected Command createDeleteCommand(GroupRequest deleteRequest) {
		DwFeatureEditPart editPart = (DwFeatureEditPart)getHost();
		
		DwFeatureDeleteCommand deleteCommand = new DwFeatureDeleteCommand((DwGraphicalFeatureModelViewer)editPart.getEditor(), getHost());
		DwFeatureWrapped wrappedFeature = (DwFeatureWrapped)getHost().getModel();
		deleteCommand.setFeature(wrappedFeature);
		
		return deleteCommand;
	}	
}
