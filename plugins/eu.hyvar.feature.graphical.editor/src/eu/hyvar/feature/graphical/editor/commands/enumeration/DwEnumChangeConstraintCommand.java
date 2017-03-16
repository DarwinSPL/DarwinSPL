package eu.hyvar.feature.graphical.editor.commands.enumeration;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;

import eu.hyvar.feature.graphical.base.editparts.HyEnumEditPart;

public class DwEnumChangeConstraintCommand extends Command{
	private Point oldPosition;
	private Point newPosition;
	
	private HyEnumEditPart editPart;

	@Override 
	public void execute(){
		redo();
	}

	@Override 
	public void undo(){
	}

	@Override
	public void redo(){
		if(oldPosition == null)
			oldPosition = editPart.getPosition();

		editPart.setPosition(newPosition);
	}

	public void setPosition(Point position) {
		this.newPosition = position;
	}
	
	public void setEditPart(HyEnumEditPart editPart){
		this.editPart = editPart;
	}
}
