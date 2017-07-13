package de.darwinspl.feature.graphical.editor.policies;

import java.util.Date;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import de.darwinspl.feature.graphical.base.editparts.DwEnumContainerEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwFeatureEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwGroupEditPart;
import de.darwinspl.feature.graphical.base.model.DwEvolutionaryPositionElement;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.editor.commands.DwEnumContainerMoveCommand;
import de.darwinspl.feature.graphical.editor.commands.DwMoveCommand;

public class DwFeatureModelXYLayoutPolicy extends XYLayoutEditPolicy{

	/**
	 * Allow feature and enum container position modifications
	 */
	@Override 
	protected Command createChangeConstraintCommand(EditPart child, Object constraint) {

		DwFeatureModelWrapped featureModelWrapped = (DwFeatureModelWrapped)this.getHost().getModel();

		DwMoveCommand moveCommand = null;
		if(child instanceof DwFeatureEditPart){
			moveCommand = new DwMoveCommand();			
			moveCommand.setModel((DwEvolutionaryPositionElement)child.getModel());
		}
		
		if(child instanceof DwGroupEditPart){
			moveCommand = new DwMoveCommand();			
			moveCommand.setModel((DwEvolutionaryPositionElement)child.getModel());
		}
		
		if(child instanceof DwEnumContainerEditPart){
			moveCommand = new DwEnumContainerMoveCommand();			
			moveCommand.setModel((DwEvolutionaryPositionElement)child.getModel());
		}
		
		if(moveCommand != null){
			Rectangle r = (Rectangle)constraint;
			moveCommand.setPosition(r.getTopLeft());
			
			Date date = featureModelWrapped.getSelectedDate();
			moveCommand.setDate(date);
		}
		
		return moveCommand;	
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
