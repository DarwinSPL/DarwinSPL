package eu.hyvar.feature.graphical.editor.policies.feature;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ReconnectRequest;

import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureEditPart;
import eu.hyvar.feature.graphical.base.editparts.HyParentChildConnectionEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyGroupWrapped;
import eu.hyvar.feature.graphical.base.model.HyParentChildConnection;
import eu.hyvar.feature.graphical.editor.commands.HyParentChildConnectionReconnectCommand;

public class HyFeatureEvolutionGraphicalNodeEditPolicy extends HyFeatureGraphicalNodeEditPolicy {
	private HyGraphicalFeatureModelViewer editor;
	public HyFeatureEvolutionGraphicalNodeEditPolicy(HyFeatureModelWrapped featureModel, HyGraphicalFeatureModelViewer editor) {
		super(editor, featureModel);
		
		this.editor = editor;
	}

	
	@Override
	protected Command getReconnectTargetCommand(ReconnectRequest request) {
		EditPart part = (EditPart)getHost();
		
		if(part instanceof HyFeatureEditPart){
			HyFeatureModelWrapped featureModel = (HyFeatureModelWrapped)((HyFeatureEditPart)getHost()).getFeatureModel();
			
			HyParentChildConnectionReconnectCommand command = new HyParentChildConnectionReconnectCommand(editor);
			
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
			
			HyParentChildConnectionReconnectCommand command = new HyParentChildConnectionReconnectCommand(editor);
			
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
			
			HyParentChildConnectionReconnectCommand command = new HyParentChildConnectionReconnectCommand(editor);
			
			HyParentChildConnection con = (HyParentChildConnection)((HyParentChildConnectionEditPart)request.getConnectionEditPart()).getModel();
			//HyParentChildConnection connection = con.clone();
			command.setConnection(con);
			
			command.setSource(con.getSource());
			command.setTarget(request.getTarget().getModel());
			command.setFeatureModel(featureModel);
			
			
			return command;
		}else if(part instanceof HyParentChildConnectionEditPart){
			HyParentChildConnection targetConnection = (HyParentChildConnection)part.getModel();
			HyParentChildConnection connection = (HyParentChildConnection)((HyParentChildConnectionEditPart)request.getConnectionEditPart()).getModel();
			HyParentChildConnectionReconnectCommand command = new HyParentChildConnectionReconnectCommand(editor);
		
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
