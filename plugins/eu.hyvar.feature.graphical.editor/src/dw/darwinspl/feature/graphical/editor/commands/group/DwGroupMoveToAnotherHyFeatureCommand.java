package dw.darwinspl.feature.graphical.editor.commands.group;

import java.util.Date;

import org.eclipse.gef.commands.Command;

import dw.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import dw.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import dw.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import dw.darwinspl.feature.graphical.base.model.DwGroupWrapped;
import dw.darwinspl.feature.graphical.base.model.DwParentChildConnection;
import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyGroup;

public class DwGroupMoveToAnotherHyFeatureCommand extends Command{
	DwGroupWrapped groupWrapped;
	DwFeatureModelWrapped featureModelWrapped;
	DwFeatureWrapped newParentFeatureWrapped;
	DwGraphicalFeatureModelViewer viewer;
	public DwGroupMoveToAnotherHyFeatureCommand(DwGroupWrapped group, 
												DwFeatureWrapped newParentFeatureWrapped, 
												DwFeatureModelWrapped featureModelWrapped,
												DwGraphicalFeatureModelViewer viewer){
		this.groupWrapped = group;
		this.featureModelWrapped = featureModelWrapped;
		this.newParentFeatureWrapped = newParentFeatureWrapped;
		this.viewer = viewer;
	}

	@Override
	public void execute(){
		redo();
	}
	
	@Override
	public void redo(){
		Date date = featureModelWrapped.getSelectedDate();
		if(date.equals(new Date(Long.MIN_VALUE)))
			date = null;
				
		HyGroup group = groupWrapped.getWrappedModelElement();
		HyFeatureChild oldParentFeatureChild = HyEvolutionUtil.getValidTemporalElement(group.getChildOf(), date);
		
		
		HyFeatureChild featureChild = HyFeatureFactory.eINSTANCE.createHyFeatureChild();
		featureChild.setValidSince(date);
		
		
		newParentFeatureWrapped.getWrappedModelElement().getParentOf().add(featureChild);
		featureChild.setChildGroup(group);
		group.getChildOf().add(featureChild);
		
		if(date == null){
			group.getChildOf().remove(oldParentFeatureChild);
			oldParentFeatureChild.getParent().getParentOf().remove(oldParentFeatureChild);
		}else{
			oldParentFeatureChild.setValidUntil(date);
		}
		
		
		
		
	
		// remove all old connections
		for(DwFeatureWrapped featureWrapped : groupWrapped.getFeaturesWrapped(date)){
			for(DwParentChildConnection connection : featureWrapped.getParentConnections(date)){
				connection.getSource().removeParentToChildConnection(connection);
				connection.getTarget().removeChildToParentConnection(connection);
			}
		}
		
		// add new connections
		for(DwFeatureWrapped featureWrapped : groupWrapped.getFeaturesWrapped(date)){
			DwParentChildConnection connection = new DwParentChildConnection();
			connection.setModel(featureModelWrapped);
			connection.setSource(newParentFeatureWrapped);
			connection.setTarget(featureWrapped);
			
			featureModelWrapped.addConnection(connection, date, group);
			
			featureWrapped.addChildToParentConnection(connection);
			newParentFeatureWrapped.addParentToChildConnection(connection);
		}
		
		
		

		featureModelWrapped.rearrangeFeatures();
		viewer.refreshView();
	}
	
	@Override
	public void undo(){
		
	}
}
