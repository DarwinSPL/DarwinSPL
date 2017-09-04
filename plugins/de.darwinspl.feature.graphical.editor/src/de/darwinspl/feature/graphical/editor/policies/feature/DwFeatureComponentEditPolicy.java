package de.darwinspl.feature.graphical.editor.policies.feature;

import java.util.Date;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwFeatureEditPart;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.editor.commands.feature.DwFeatureDeleteCommand;
import de.darwinspl.feature.graphical.editor.commands.feature.DwFeatureDeletePermanentlyCommand;

public class DwFeatureComponentEditPolicy extends ComponentEditPolicy {
	
	@Override
	protected Command createDeleteCommand(GroupRequest deleteRequest) {
		
		DwFeatureEditPart editPart = (DwFeatureEditPart)getHost();
		DwGraphicalFeatureModelViewer viewer = (DwGraphicalFeatureModelViewer)editPart.getEditor();
		DwFeatureWrapped wrappedFeature = (DwFeatureWrapped)getHost().getModel();
		
		if(!viewer.isLastDateSelected())
			return null;
		
		Command deleteCommand = null;
		if(viewer.getCurrentSelectedDate().equals(new Date(Long.MIN_VALUE))){
			deleteCommand = new DwFeatureDeletePermanentlyCommand(viewer, getHost());
			
			((DwFeatureDeletePermanentlyCommand)deleteCommand).setFeature(wrappedFeature);
		}else{
			deleteCommand = new DwFeatureDeleteCommand(viewer, getHost());
			
			((DwFeatureDeleteCommand)deleteCommand).setFeature(wrappedFeature);			
		}

		return deleteCommand;
	}	
}
