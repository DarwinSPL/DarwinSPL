package eu.hyvar.feature.graphical.editor.commands;

import org.eclipse.gef.commands.Command;

import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyParentChildConnection;

public class HyParentChildConnectionCreateCommand extends Command{
	private HyFeatureWrapped source;
	private HyFeatureWrapped target;
	private HyParentChildConnection connection;
	private HyFeatureModelWrapped featureModel;
	
	public HyFeatureModelWrapped getFeatureModel() {
		return featureModel;
	}

	public void setFeatureModel(HyFeatureModelWrapped featureModel) {
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
		
		source.addParentToChildConnection(connection);
		target.addChildToParentConnection(connection);
		
		featureModel.addConnection(connection, featureModel.getSelectedDate());	
	}

	public void setSource(HyFeatureWrapped source) {
		this.source = source;
	}

	public void setTarget(HyFeatureWrapped target) {
		this.target = target;
	}

	public void setConnection(HyParentChildConnection connection) {
		this.connection = connection;
	}
}
