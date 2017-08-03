package de.darwinspl.feature.graphical.editor.commands.connections;

import org.eclipse.gef.commands.Command;

import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.base.model.DwParentChildConnection;

public class DwParentChildConnectionCreateCommand extends Command{
	private DwFeatureWrapped source;
	private DwFeatureWrapped target;
	private DwParentChildConnection connection;
	private DwFeatureModelWrapped featureModel;
	
	public DwFeatureModelWrapped getFeatureModel() {
		return featureModel;
	}

	public void setFeatureModel(DwFeatureModelWrapped featureModel) {
		this.featureModel = featureModel;
	}

	@Override 
	public boolean canExecute(){
		return source != null && target != null && connection != null;
	}
	
	@Override
	public void execute(){
		connection.setSource(source);
		connection.setTarget(target);
		connection.setModel(featureModel);
		
		source.addOrUpdateParentToChildConnection(connection);
		target.addOrUpdateChildToParentConnection(connection);
		
		featureModel.addConnection(connection, featureModel.getSelectedDate(), null);	
	}

	public void setSource(DwFeatureWrapped source) {
		this.source = source;
	}

	public void setTarget(DwFeatureWrapped target) {
		this.target = target;
	}

	public void setConnection(DwParentChildConnection connection) {
		this.connection = connection;
	}
}
