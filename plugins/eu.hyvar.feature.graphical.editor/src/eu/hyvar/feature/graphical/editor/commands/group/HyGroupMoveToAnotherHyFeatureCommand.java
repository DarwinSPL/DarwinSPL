package eu.hyvar.feature.graphical.editor.commands.group;

import java.util.Date;

import org.eclipse.gef.commands.Command;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyGroupWrapped;
import eu.hyvar.feature.graphical.base.model.HyParentChildConnection;

public class HyGroupMoveToAnotherHyFeatureCommand extends Command{
	HyGroupWrapped groupWrapped;
	HyFeatureModelWrapped featureModelWrapped;
	HyFeatureWrapped newParentFeatureWrapped;
	HyGraphicalFeatureModelViewer viewer;
	public HyGroupMoveToAnotherHyFeatureCommand(HyGroupWrapped group, 
												HyFeatureWrapped newParentFeatureWrapped, 
												HyFeatureModelWrapped featureModelWrapped,
												HyGraphicalFeatureModelViewer viewer){
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
		
		
		oldParentFeatureChild.setValidUntil(date);
		
		//groupWrapped.setParentFeature(newParentFeatureWrapped);
	
		// remove all old connections
		for(HyFeatureWrapped featureWrapped : groupWrapped.getFeaturesWrapped(date)){
			for(HyParentChildConnection connection : featureWrapped.getParentConnections(date)){
				connection.getSource().removeParentToChildConnection(connection);
				connection.getTarget().removeChildToParentConnection(connection);
			}
		}
		
		// add new connections
		for(HyFeatureWrapped featureWrapped : groupWrapped.getFeaturesWrapped(date)){
			HyParentChildConnection connection = new HyParentChildConnection();
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
