package eu.hyvar.feature.graphical.editor.commands.feature;

import java.util.Date;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;

import eu.hyvar.feature.graphical.base.model.DwTemporalPosition;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;

public class HyFeatureChangeConstraintCommand extends Command{
	private DwTemporalPosition oldPosition;
	private Point newPointPosition;
	private HyFeatureWrapped model;
	private Date date;
	
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
		
		model.addPosition(newPointPosition, date, true);
	}

	public void setPosition(Point position) {
		this.newPointPosition = position;
	}

	public void setModel(HyFeatureWrapped model) {
		this.model = model;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
