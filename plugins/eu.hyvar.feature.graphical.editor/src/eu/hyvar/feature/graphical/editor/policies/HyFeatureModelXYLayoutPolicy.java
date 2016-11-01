package eu.hyvar.feature.graphical.editor.policies;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import eu.hyvar.feature.graphical.base.editparts.HyFeatureEditPart;
import eu.hyvar.feature.graphical.base.editparts.HyGroupEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.editor.commands.feature.HyFeatureChangeConstraintCommand;

public class HyFeatureModelXYLayoutPolicy extends XYLayoutEditPolicy{

	@Override 
	protected Command createChangeConstraintCommand(EditPart child, Object constraint) {
		if(child instanceof HyFeatureEditPart){
			HyFeatureChangeConstraintCommand command = new HyFeatureChangeConstraintCommand();
			command.setModel((HyFeatureWrapped) child.getModel());

			Rectangle r = (Rectangle)constraint;
			command.setPosition(r.getTopLeft());
			return command;
		}else if(child instanceof HyGroupEditPart){
			/*
			HyFeatureChangeConstraintCommand command = new HyFeatureChangeConstraintCommand();
			command.setModel(((HyGroupWrapped) child.getModel()).getParentFeature());

			Rectangle r = (Rectangle)constraint;
			command.setPosition(r.getTopLeft());
			return command;
			*/
		}else{
		}

		return null;	
	}

	@Override
	protected Command getCreateCommand(CreateRequest request) {
		System.out.println(request);
/*
		if(request.getNewObject() instanceof HyFeatureWrapped){
			HyFeatureCreateCommand command = new HyFeatureCreateCommand();
			command.setNewFeature((HyFeatureWrapped)(request.getNewObject()));

			command.setParent((HyFeatureModelWrapped)getHost().getModel());
			return command;
		}
*/
		return null;		
	}	

	@Override 
	protected EditPolicy createChildEditPolicy(EditPart child) {
		return new HyFeatureModelResizablePolicy();
	}
}
