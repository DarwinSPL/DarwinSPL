package eu.hyvar.feature.graphical.editor.commands;

import org.eclipse.gef.commands.Command;

import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyParentChildConnection;

public class HyParentChildConnectionDeleteCommand extends Command {
	private HyParentChildConnection connection;
	private HyFeatureWrapped source;
	private HyFeatureWrapped target;
	private HyFeatureModelWrapped model;
	
	@Override
	public boolean canExecute(){
		return connection != null;
	}
	
	@Override
	public void execute(){
		source = connection.getSource();
		target = connection.getTarget();
		
		connection.setSource(null);
		connection.setTarget(null);
		connection.setModel(null);
	}
	
	@Override
	public void undo(){
		connection.setSource(source);
		connection.setTarget(target);
		connection.setModel(model);
	}
	
	public void setConnection(final HyParentChildConnection connection){
		this.connection = connection;
	}
}
