package de.darwinspl.feature.graphical.editor.commands;

import org.eclipse.gef.commands.Command;

import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.base.model.DwParentChildConnection;

public class DwParentChildConnectionDeleteCommand extends Command {
	private DwParentChildConnection connection;
	private DwFeatureWrapped source;
	private DwFeatureWrapped target;
	private DwFeatureModelWrapped model;
	
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
	
	public void setConnection(final DwParentChildConnection connection){
		this.connection = connection;
	}
}
