package eu.hyvar.feature.graphical.editor.commands.feature;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;

import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;

public class HyFeatureChangeConstraintCommand extends Command{
	private Point oldPosition;
	private Point position;
	private HyFeatureWrapped model;
	
	@Override 
	public void execute(){
		if(oldPosition == null)
			oldPosition = model.getPosition(null);
		
		model.setPosition(position);
	}
	
	@Override 
	public void undo(){
		model.setPosition(oldPosition);
	}
	
	@Override
	public void redo(){
		model.setPosition(position);
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public void setModel(HyFeatureWrapped model) {
		this.model = model;
	}
	
}
