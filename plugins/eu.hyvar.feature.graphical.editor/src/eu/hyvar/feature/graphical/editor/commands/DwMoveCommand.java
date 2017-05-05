package eu.hyvar.feature.graphical.editor.commands;

import java.util.Date;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;

import eu.hyvar.feature.graphical.base.model.DwEvolutionaryPositionElement;
import eu.hyvar.feature.graphical.base.model.DwTemporalPosition;

public class DwMoveCommand extends Command {
	protected DwEvolutionaryPositionElement model;
	
	protected DwTemporalPosition oldPosition;
	protected Point newPosition;
	protected Date date;
	
	@Override 
	public void execute(){
		redo();
	}
	
	@Override 
	public void undo(){
		model.addPosition(oldPosition.getPosition(), date, true);
	}
	
	@Override
	public void redo(){
		if(oldPosition == null)
			oldPosition = model.getPosition(date);
		
		model.addPosition(newPosition, date, true);
	}

	public void setPosition(Point position) {
		this.newPosition = position;
	}

	public void setModel(DwEvolutionaryPositionElement model) {
		this.model = model;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
