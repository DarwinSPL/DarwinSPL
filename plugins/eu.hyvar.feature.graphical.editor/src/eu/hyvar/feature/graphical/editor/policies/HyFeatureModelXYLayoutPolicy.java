package eu.hyvar.feature.graphical.editor.policies;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import eu.hyvar.feature.graphical.base.editparts.HyEnumEditPart;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.editor.commands.enumeration.DwEnumChangeConstraintCommand;
import eu.hyvar.feature.graphical.editor.commands.feature.HyFeatureChangeConstraintCommand;

public class HyFeatureModelXYLayoutPolicy extends XYLayoutEditPolicy{

	/**
	 * Allow features position modifications
	 */
	@Override 
	protected Command createChangeConstraintCommand(EditPart child, Object constraint) {
		if(child instanceof HyFeatureEditPart){
			HyFeatureModelWrapped featureModelWrapped = (HyFeatureModelWrapped)this.getHost().getModel();
			
			HyFeatureChangeConstraintCommand command = new HyFeatureChangeConstraintCommand();
			command.setModel((HyFeatureWrapped) child.getModel());
			command.setDate(featureModelWrapped.getSelectedDate());

			Rectangle r = (Rectangle)constraint;
			command.setPosition(r.getTopLeft());
			return command;
		}
		
		if(child instanceof HyEnumEditPart){
			DwEnumChangeConstraintCommand command = new DwEnumChangeConstraintCommand();
			command.setEditPart((HyEnumEditPart)child);

			Rectangle r = (Rectangle)constraint;
			command.setPosition(r.getTopLeft());
			return command;	
		}

		return null;	
	}

	@Override
	protected Command getCreateCommand(CreateRequest request) {
		return null;
	}	

	
	@Override 
	protected EditPolicy createChildEditPolicy(EditPart child) {
		return new DwThemedNonResizableEditPolicy();
	}
}
