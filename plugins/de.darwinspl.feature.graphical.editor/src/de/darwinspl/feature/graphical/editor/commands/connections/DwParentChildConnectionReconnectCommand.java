package de.darwinspl.feature.graphical.editor.commands.connections;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.gef.EditPart;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.base.model.DwGroupWrapped;
import de.darwinspl.feature.graphical.base.model.DwParentChildConnection;
import de.darwinspl.feature.graphical.editor.commands.feature.DwFeatureDeleteCommand;
import de.darwinspl.feature.graphical.editor.util.DwEcoreUtil;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;

public class DwParentChildConnectionReconnectCommand extends DwFeatureDeleteCommand{
	public DwParentChildConnectionReconnectCommand(DwGraphicalFeatureModelViewer viewer, EditPart host) {
		super(viewer, host);
	}

	private DwFeatureWrapped source;
	private Object target;
	private DwParentChildConnection connection;
	private DwParentChildConnection oldConnection;
	private DwParentChildConnection newConnection;

	private HyFeature backupFeature;
	private HyGroup backupGroup;
	private HyGroupComposition backupGroupComposition;

	@Override 
	public boolean canExecute(){
		return source != null && target != null && connection != null;
	}

	public void setSource(DwFeatureWrapped source) {
		this.source = source;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public void setConnection(DwParentChildConnection connection) {
		this.connection = connection;
	}	

	private void redoForFeatureTarget(){
		DwFeatureModelWrapped featureModel = viewer.getModelWrapped();

		executionDate = featureModel.getSelectedDate();

		DwFeatureWrapped newTarget = (DwFeatureWrapped)target;
		DwFeatureWrapped oldTarget = connection.getTarget();

		backupGroupComposition = DwEcoreUtil.copy(HyEvolutionUtil.getValidTemporalElement(oldTarget.getWrappedModelElement().getGroupMembership(), executionDate));
		backupGroup = DwEcoreUtil.copy(HyEvolutionUtil.getValidTemporalElement(oldTarget.getWrappedModelElement().getGroupMembership(), executionDate).getCompositionOf());
		
		// only one connection valid at a timestamp
		if(!oldTarget.getParentConnections(executionDate).isEmpty()){
			DwParentChildConnection currentConnection = oldTarget.getParentConnections(executionDate).get(0);

			oldConnection = DwEcoreUtil.copy(currentConnection);

			featureModel.removeConnection(currentConnection, executionDate);
		}


		backupFeature = DwEcoreUtil.copy(connection.getTarget().getWrappedModelElement());


		featureModel.removeFeature(oldTarget, executionDate);

		newConnection = new DwParentChildConnection();
		newConnection.setModel(featureModel);
		newConnection.setTarget(oldTarget);
		newConnection.setSource(newTarget);
		newConnection.setValidSince(executionDate.equals(new Date(Long.MIN_VALUE)) ? null : executionDate);
		featureModel.addConnection(newConnection, executionDate, null);
	}

	private void redoForConnectionTarget(){
		DwFeatureModelWrapped featureModel = viewer.getModelWrapped();
		Date date = featureModel.getSelectedDate();
		if(date.equals(new Date(Long.MIN_VALUE)))
			date = null;


		DwParentChildConnection connection = (DwParentChildConnection)target;

		DwFeatureWrapped tempTargetFeature = connection.getTarget();
		HyGroupComposition composition = HyEvolutionUtil.getValidTemporalElement(tempTargetFeature.getWrappedModelElement().getGroupMembership(), date);
		HyGroup group = composition.getCompositionOf();
		DwGroupWrapped parentGroupWrapped = featureModel.getWrappedGroup(group);
		HyFeatureChild child = HyEvolutionUtil.getValidTemporalElement(group.getChildOf(), date);
		DwFeatureWrapped newTarget = featureModel.getWrappedFeature(child.getParent());
		DwFeatureWrapped oldTarget = this.connection.getTarget();

		//DwGroupWrapped oldGroup = oldTarget.getParentGroup(date);

		DwParentChildConnection newConnection = new DwParentChildConnection();
		newConnection.setModel(featureModel);
		newConnection.setTarget(oldTarget);
		newConnection.setSource(newTarget);			

		parentGroupWrapped.addChildFeature(oldTarget);



		featureModel.addConnection(newConnection, date, composition.getCompositionOf());

		featureModel.removeFeature(oldTarget, date);		
	}



	private void refreshView() {
		viewer.getModelWrapped().rearrangeFeatures();
		viewer.refreshView();		
	}

	@Override
	public void redo(){
		if(target instanceof DwFeatureWrapped){
			redoForFeatureTarget();
		}else{
			redoForConnectionTarget();
		}	

		refreshView();
	}

	@Override 
	public void undo(){
		HyFeature realFeature = getRealModelFeature(backupFeature);
		HyGroup realGroup = getRealModelGroup(backupGroup);
		
		HyGroup backupGroup = HyEvolutionUtil.getValidTemporalElement(backupFeature.getGroupMembership(), executionDate).getCompositionOf();
		HyGroup currentGroup = HyEvolutionUtil.getValidTemporalElement(realFeature.getGroupMembership(), executionDate).getCompositionOf();
		
		if(!backupGroup.getId().equals(currentGroup.getId())) {
			DwGroupWrapped groupWrapped = viewer.getModelWrapped().getWrappedGroup(currentGroup);
			viewer.getModelWrapped().removeGroup(groupWrapped);
			
			HyGroupComposition obsoleteComposition = null;
			for(HyGroupComposition composition : realFeature.getGroupMembership()) {
				if(composition.getCompositionOf().equals(currentGroup))
					obsoleteComposition = composition;
			}
			
			if(obsoleteComposition != null) {
				realFeature.getGroupMembership().remove(obsoleteComposition);
			}
		}	
		
		for(HyGroupComposition composition : backupFeature.getGroupMembership()) {
			HyGroupComposition realComposition = getRealModelGroupComposition(realGroup, composition);
			
			if(realComposition != null) {
				if(executionDate.equals(realComposition.getSupersedingElement().getValidSince())) {
					HyGroupComposition newComposition = (HyGroupComposition)realComposition.getSupersedingElement();
					newComposition.getFeatures().clear();
					newComposition.getCompositionOf().getParentOf().remove(newComposition);				
				}
				
				
				realComposition.setValidSince(composition.getValidSince());
				realComposition.setValidUntil(composition.getValidUntil());
				realComposition.setSupersededElement(composition.getSupersededElement());
				realComposition.setSupersedingElement(composition.getSupersedingElement());
				
			}
		}

		viewer.getModelWrapped().removeConnection(newConnection, executionDate);
		viewer.getModelWrapped().addConnection(oldConnection, executionDate, realGroup);	
		
		refreshView();
	}

	@Override
	public void execute(){
		redo();
	}
}
