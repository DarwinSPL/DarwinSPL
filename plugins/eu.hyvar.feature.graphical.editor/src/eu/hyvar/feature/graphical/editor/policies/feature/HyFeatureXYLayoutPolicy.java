package eu.hyvar.feature.graphical.editor.policies.feature;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;

import eu.hyvar.feature.graphical.base.editparts.HyAbstractEditPart;
import eu.hyvar.feature.graphical.base.editparts.HyGroupEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyGroupWrapped;
import eu.hyvar.feature.graphical.editor.commands.group.HyGroupMoveToAnotherHyFeatureCommand;
import eu.hyvar.feature.graphical.editor.policies.DwThemedNonResizableEditPolicy;

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
		return new DwThemedNonResizableEditPolicy();
	}
	
	/**
	 * Allow drag of groups to features to allow rearrange of groups
	 */
	@Override
	protected Command createAddCommand(ChangeBoundsRequest request,
			EditPart child, Object constraint) {
		if(child instanceof HyGroupEditPart){
			
			HyAbstractEditPart host = (HyAbstractEditPart)getHost();
			return new HyGroupMoveToAnotherHyFeatureCommand((HyGroupWrapped)((HyGroupEditPart)child).getModel(), 
					(HyFeatureWrapped)host.getModel(),
					host.getFeatureModel(),
					host.getEditor());
		}else{
			return null;
		}
	}
	
}
