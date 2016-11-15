package eu.hyvar.feature.graphical.editor.policies.feature;

import java.util.HashSet;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.DropRequest;
import org.eclipse.gef.requests.ReconnectRequest;

import eu.hyvar.feature.graphical.base.editparts.HyFeatureEditPart;
import eu.hyvar.feature.graphical.base.editparts.HyParentChildConnectionEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyGroupWrapped;
import eu.hyvar.feature.graphical.base.model.HyParentChildConnection;
import eu.hyvar.feature.graphical.editor.commands.HyParentChildConnectionCreateCommand;
import eu.hyvar.feature.graphical.editor.commands.HyParentChildConnectionReconnectCommand;

public class HyFeatureGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy{
	
	protected HyFeatureModelWrapped featureModel;
	
	protected HashSet<HyFeatureWrapped> highlightedFeatures;
	
	public HyFeatureGraphicalNodeEditPolicy(HyFeatureModelWrapped featureModel) {
		this.featureModel = featureModel;
	}

	@Override
	protected void eraseTargetConnectionFeedback(DropRequest request) {
		EditPart part = (EditPart)getHost();
		
		if(part instanceof HyParentChildConnectionEditPart){
		}
	}
	
	@Override
	protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
		HyParentChildConnectionCreateCommand command = (HyParentChildConnectionCreateCommand)request.getStartCommand();
		command.setFeatureModel(featureModel);
		command.setTarget((HyFeatureWrapped)getHost().getModel());
		return command;
		
	
	}

	@Override
	protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
		HyFeatureModelWrapped featureModel = ((HyFeatureEditPart)getHost()).getFeatureModel();
		
		HyParentChildConnection connection = (HyParentChildConnection)request.getNewObject();
		connection.setModel(featureModel);
		
		HyParentChildConnectionCreateCommand command = new HyParentChildConnectionCreateCommand();
		command.setSource((HyFeatureWrapped)getHost().getModel());
		command.setConnection(connection);
		command.setFeatureModel(featureModel);
		
		request.setStartCommand(command);
		return command;
	}

	@Override
	protected void showTargetConnectionFeedback(DropRequest request) {

	}
	
	@Override
	protected Command getReconnectTargetCommand(ReconnectRequest request) {
		EditPart part = (EditPart)getHost();
		
		if(part instanceof HyFeatureEditPart){
			HyFeatureModelWrapped featureModel = ((HyFeatureEditPart)getHost()).getFeatureModel();
			
			HyParentChildConnectionReconnectCommand command = new HyParentChildConnectionReconnectCommand();
			
			HyParentChildConnection connection = (HyParentChildConnection)((HyParentChildConnectionEditPart)request.getConnectionEditPart()).getModel();
			command.setConnection(connection);
			
			command.setSource(connection.getSource());
			command.setTarget(request.getTarget().getModel());
			command.setFeatureModel(featureModel);
			
			
			return command;
		}else if(part instanceof HyParentChildConnectionEditPart){
			HyParentChildConnection hoveredParentChildConnection = (HyParentChildConnection)part.getModel();
			HyGroupWrapped wrappedGroup = hoveredParentChildConnection.getTarget().getParentGroup(null);
			highlightedFeatures = wrappedGroup.getFeatures();
			
			for(HyFeatureWrapped wrappedFeature : highlightedFeatures){
				wrappedFeature.getChildrenConnections(null).get(0).setHighlight(true);
			}
			
			HyParentChildConnection targetConnection = (HyParentChildConnection)part.getModel();
			HyParentChildConnection connection = (HyParentChildConnection)((HyParentChildConnectionEditPart)request.getConnectionEditPart()).getModel();
			
			HyParentChildConnectionReconnectCommand command = new HyParentChildConnectionReconnectCommand();
			
			command.setConnection(connection);
			command.setSource(connection.getTarget());
			command.setTarget(targetConnection);
			command.setFeatureModel(featureModel);
			
			return command;		
		}else{
			return null;
		}
	}

	@Override
	protected Command getReconnectSourceCommand(ReconnectRequest request) {
		EditPart part = (EditPart)getHost();
		
		if(part instanceof HyFeatureEditPart){
			HyFeatureModelWrapped featureModel = ((HyFeatureEditPart)getHost()).getFeatureModel();
			
			HyParentChildConnectionReconnectCommand command = new HyParentChildConnectionReconnectCommand();
			
			HyParentChildConnection connection = (HyParentChildConnection)((HyParentChildConnectionEditPart)request.getConnectionEditPart()).getModel();
			command.setConnection(connection);
			
			command.setSource(connection.getSource());
			command.setTarget(request.getTarget().getModel());
			command.setFeatureModel(featureModel);
			
			
			return command;
		}else if(part instanceof HyParentChildConnectionEditPart){
			HyParentChildConnection targetConnection = (HyParentChildConnection)part.getModel();
			HyParentChildConnection connection = (HyParentChildConnection)((HyParentChildConnectionEditPart)request.getConnectionEditPart()).getModel();
			HyParentChildConnectionReconnectCommand command = new HyParentChildConnectionReconnectCommand();
		
			command.setConnection(connection);
			command.setSource(connection.getSource());
			command.setTarget(targetConnection);
			command.setFeatureModel(featureModel);
			
			return command;
		}else{
			if(highlightedFeatures != null){
				for(HyFeatureWrapped wrappedFeature : highlightedFeatures){
					wrappedFeature.getChildrenConnections(null).get(0).setHighlight(false);
				}	
				
				highlightedFeatures = null;
			}
			return null;
		}
	}
}
