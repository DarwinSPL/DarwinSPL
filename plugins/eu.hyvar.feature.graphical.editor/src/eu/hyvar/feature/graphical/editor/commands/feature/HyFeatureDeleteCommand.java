package eu.hyvar.feature.graphical.editor.commands.feature;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.commands.Command;

import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyParentChildConnection;

public class HyFeatureDeleteCommand extends Command{
	private HyFeatureWrapped feature;
	private HyFeatureModelWrapped model;
	
	private List<HyParentChildConnection> connections;
	
	public void setFeature(HyFeatureWrapped feature) {
		this.feature = feature;
	}

	public void setModel(HyFeatureModelWrapped model) {
		this.model = model;
	}
	
	private void removeConnections(){
		connections = new ArrayList<HyParentChildConnection>();
		connections.addAll(feature.getParentConnections(null));
		connections.addAll(feature.getChildrenConnections(null));
	
		
		for(HyParentChildConnection connection : connections){
			connection.getTarget().removeChildToParentConnection(connection);
			connection.getSource().removeParentToChildConnection(connection);
		}
	}
	
	private void removeChildren(HyFeatureWrapped parentFeature){
		for(HyParentChildConnection connection : parentFeature.getChildrenConnections(null)){
			removeChildren(connection.getTarget());
		}
		
		model.removeFeature(parentFeature);
	}

	@Override
	public void execute(){
		removeChildren(feature);	
		removeConnections();
	}
}
