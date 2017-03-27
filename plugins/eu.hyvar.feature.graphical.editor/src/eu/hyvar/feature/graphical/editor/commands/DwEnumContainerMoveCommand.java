package eu.hyvar.feature.graphical.editor.commands;

import eu.hyvar.feature.graphical.base.model.DwEnumContainerWrapped;
import eu.hyvar.feature.graphical.base.model.DwEnumContainerWrapped.EditorAlignment;

public class DwEnumContainerMoveCommand extends DwMoveCommand {
	private EditorAlignment oldAlignment;
	
	@Override 
	public void undo(){
		DwEnumContainerWrapped model = (DwEnumContainerWrapped)this.model;
		model.setAlignment(oldAlignment);		
		model.addPosition(oldPosition.getPosition(), date, true);
	}
	
	@Override
	public void redo(){
		if(oldPosition == null)
			oldPosition = model.getPosition(date);
		
		DwEnumContainerWrapped model = (DwEnumContainerWrapped)this.model;
		oldAlignment = model.getAlignment();
		model.setAlignment(EditorAlignment.Custum);
		model.addPosition(newPosition, date, true);
	}

}
