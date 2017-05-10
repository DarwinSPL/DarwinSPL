package de.darwinspl.feature.graphical.editor.policies.feature;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;

import de.darwinspl.feature.graphical.base.editparts.DwAbstractEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwGroupEditPart;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.base.model.DwGroupWrapped;
import de.darwinspl.feature.graphical.editor.commands.group.DwGroupMoveToAnotherHyFeatureCommand;
import de.darwinspl.feature.graphical.editor.policies.DwThemedNonResizableEditPolicy;

public class DwFeatureXYLayoutPolicy extends XYLayoutEditPolicy{

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
		return new DwThemedNonResizableEditPolicy();
	}
	
	/**
	 * Allow drag of groups to features to allow rearrange of groups
	 */
	@Override
	protected Command createAddCommand(ChangeBoundsRequest request,
			EditPart child, Object constraint) {
		if(child instanceof DwGroupEditPart){
			
			DwAbstractEditPart host = (DwAbstractEditPart)getHost();
			return new DwGroupMoveToAnotherHyFeatureCommand((DwGroupWrapped)((DwGroupEditPart)child).getModel(), 
					(DwFeatureWrapped)host.getModel(),
					host.getFeatureModel(),
					host.getEditor());
		}else{
			return null;
		}
	}
	
}
