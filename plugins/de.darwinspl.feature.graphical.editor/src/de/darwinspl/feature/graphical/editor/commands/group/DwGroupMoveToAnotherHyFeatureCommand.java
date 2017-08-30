package de.darwinspl.feature.graphical.editor.commands.group;

import java.util.Date;

import org.eclipse.gef.commands.Command;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.base.model.DwGroupWrapped;
import de.darwinspl.feature.graphical.base.model.DwParentChildConnection;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyGroup;

public class DwGroupMoveToAnotherHyFeatureCommand extends Command{
	DwGroupWrapped groupWrapped;
	DwFeatureModelWrapped featureModelWrapped;
	DwFeatureWrapped newParentFeatureWrapped;
	DwFeatureWrapped oldParentFeatureWrapped;
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
	
	private void moveToNewParentFeature(DwFeatureWrapped newParent){
		Date date = featureModelWrapped.getSelectedDate();
		
		HyGroup group = groupWrapped.getWrappedModelElement();
		HyFeatureChild oldParentFeatureChild = HyEvolutionUtil.getValidTemporalElement(group.getChildOf(), date);
		
		// save old parent feature for undo
		//oldParentFeatureWrapped = viewer.getModelWrapped().getWrappedFeature(oldParentFeatureChild.getParent());
		
		HyFeatureChild featureChild = HyFeatureFactory.eINSTANCE.createHyFeatureChild();
		featureChild.setValidSince(date);
		
		
		newParent.getWrappedModelElement().getParentOf().add(featureChild);
		featureChild.setChildGroup(group);
		group.getChildOf().add(featureChild);
		
		if(date.equals(new Date(Long.MIN_VALUE))){
			group.getChildOf().remove(oldParentFeatureChild);
			oldParentFeatureChild.getParent().getParentOf().remove(oldParentFeatureChild);
		}else{
			oldParentFeatureChild.setValidUntil(date);
		}
		
		
		
		
	
		// remove all old connections
		for(DwFeatureWrapped featureWrapped : groupWrapped.getFeaturesWrapped(date)){
			for(DwParentChildConnection connection : featureWrapped.getParentConnections(date)){
				featureModelWrapped.removeConnection(connection, date);
			}
		}
		
		// add new connections
		for(DwFeatureWrapped featureWrapped : groupWrapped.getFeaturesWrapped(date)){
			DwParentChildConnection connection = new DwParentChildConnection();
			connection.setModel(featureModelWrapped);
			connection.setSource(newParent);
			connection.setTarget(featureWrapped);
			connection.setValidSince(date);
			
			//featureModelWrapped.addConnection(connection, date, group);
			
			featureWrapped.addOrUpdateChildToParentConnection(connection);
			newParent.addOrUpdateParentToChildConnection(connection);
		}		
	}
	@Override
	public void redo(){
		moveToNewParentFeature(newParentFeatureWrapped);
		
		featureModelWrapped.rearrangeFeatures();
		viewer.refreshView();
	}
	
	@Override
	public void undo(){
		//moveToNewParentFeature(oldParentFeatureWrapped);
	
		//featureModelWrapped.rearrangeFeatures();
		//viewer.refreshView();
	}
	
	@Override
	public boolean canExecute() {
		return viewer.isLastDateSelected();
	}
}
