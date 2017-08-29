package de.darwinspl.feature.graphical.editor.policies.feature;

import java.util.HashSet;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.DropRequest;
import org.eclipse.gef.requests.ReconnectRequest;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwFeatureEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwParentChildConnectionEditPart;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.base.model.DwGroupWrapped;
import de.darwinspl.feature.graphical.base.model.DwParentChildConnection;
import de.darwinspl.feature.graphical.editor.commands.connections.DwParentChildConnectionCreateCommand;
import de.darwinspl.feature.graphical.editor.commands.connections.DwParentChildConnectionReconnectCommand;

public class DwFeatureGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy{
	private DwGraphicalFeatureModelViewer editor;
	protected DwFeatureModelWrapped featureModel;
	
	protected HashSet<DwFeatureWrapped> highlightedFeatures;
	
	public DwFeatureGraphicalNodeEditPolicy(DwGraphicalFeatureModelViewer editor, DwFeatureModelWrapped featureModel) {
		this.featureModel = featureModel;
		this.editor = editor;
	}

	@Override
	protected void eraseTargetConnectionFeedback(DropRequest request) {
		EditPart part = (EditPart)getHost();
		
		if(part instanceof DwParentChildConnectionEditPart){
		}
	}
	
	@Override
	protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
		DwParentChildConnectionCreateCommand command = (DwParentChildConnectionCreateCommand)request.getStartCommand();
		command.setFeatureModel(featureModel);
		command.setTarget((DwFeatureWrapped)getHost().getModel());
		return command;
		
	
	}

	@Override
	protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
		DwFeatureModelWrapped featureModel = ((DwFeatureEditPart)getHost()).getFeatureModel();
		
		DwParentChildConnection connection = (DwParentChildConnection)request.getNewObject();
		connection.setModel(featureModel);
		
		DwParentChildConnectionCreateCommand command = new DwParentChildConnectionCreateCommand();
		command.setSource((DwFeatureWrapped)getHost().getModel());
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
		
		if(part instanceof DwFeatureEditPart){
			DwParentChildConnectionReconnectCommand command = new DwParentChildConnectionReconnectCommand(editor, part);
			
			DwParentChildConnection connection = (DwParentChildConnection)((DwParentChildConnectionEditPart)request.getConnectionEditPart()).getModel();
			command.setConnection(connection);
			command.setSource(connection.getSource());
			command.setTarget(request.getTarget().getModel());
			
			return command;
		}else if(part instanceof DwParentChildConnectionEditPart){
			DwParentChildConnection hoveredParentChildConnection = (DwParentChildConnection)part.getModel();
			DwGroupWrapped wrappedGroup = hoveredParentChildConnection.getTarget().getParentGroup(null);
			highlightedFeatures = wrappedGroup.getFeatures();
			
			for(DwFeatureWrapped wrappedFeature : highlightedFeatures){
				wrappedFeature.getChildrenConnections(null).get(0).setHighlight(true);
			}
			
			DwParentChildConnection targetConnection = (DwParentChildConnection)part.getModel();
			DwParentChildConnection connection = (DwParentChildConnection)((DwParentChildConnectionEditPart)request.getConnectionEditPart()).getModel();
			
			DwParentChildConnectionReconnectCommand command = new DwParentChildConnectionReconnectCommand(editor, part);
			
			command.setConnection(connection);
			command.setSource(connection.getTarget());
			command.setTarget(targetConnection);
			
			return command;		
		}else{
			return null;
		}
	}
	
	

	@Override
	protected Command getReconnectSourceCommand(ReconnectRequest request) {
		EditPart part = (EditPart)getHost();
		
		if(part instanceof DwFeatureEditPart){
			DwParentChildConnectionReconnectCommand command = new DwParentChildConnectionReconnectCommand(editor, part);
			
			DwParentChildConnection con = (DwParentChildConnection)((DwParentChildConnectionEditPart)request.getConnectionEditPart()).getModel();
			//HyParentChildConnection connection = con.clone();
			command.setConnection(con);
			
			command.setSource(con.getSource());
			command.setTarget(request.getTarget().getModel());
			
			
			return command;
		}else if(part instanceof DwParentChildConnectionEditPart){
			DwParentChildConnection targetConnection = (DwParentChildConnection)part.getModel();
			DwParentChildConnection connection = (DwParentChildConnection)((DwParentChildConnectionEditPart)request.getConnectionEditPart()).getModel();
			DwParentChildConnectionReconnectCommand command = new DwParentChildConnectionReconnectCommand(editor, part);
		
			command.setConnection(connection);
			command.setSource(connection.getSource());
			command.setTarget(targetConnection);
			
			return command;
		}else{
			if(highlightedFeatures != null){
				for(DwFeatureWrapped wrappedFeature : highlightedFeatures){
					wrappedFeature.getChildrenConnections(null).get(0).setHighlight(false);
				}	
				
				highlightedFeatures = null;
			}
			return null;
		}
	}
}
