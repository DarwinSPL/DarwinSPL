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
import eu.hyvar.feature.HyGroupType;

public class DwParentChildConnectionReconnectCommand extends DwFeatureDeleteCommand{
	public DwParentChildConnectionReconnectCommand(DwGraphicalFeatureModelViewer viewer, EditPart host) {
		super(viewer, host);
	}

	private DwFeatureWrapped source;
	private Object target;
	private DwParentChildConnection connection;
	private DwParentChildConnection backupConnection;
	private DwParentChildConnection newConnection;
	
	private HyGroup backupGroup;

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

		backupGroup = DwEcoreUtil.copy(HyEvolutionUtil.getValidTemporalElement(oldTarget.getWrappedModelElement().getGroupMembership(), executionDate).getCompositionOf());
		backupFeature = DwEcoreUtil.copy(oldTarget.getWrappedModelElement());
		
		// only one connection valid at a timestamp
		if(!oldTarget.getParentConnections(executionDate).isEmpty()){
			DwParentChildConnection currentConnection = oldTarget.getParentConnections(executionDate).get(0);

			backupConnection = DwEcoreUtil.copy(currentConnection);

			featureModel.removeConnection(currentConnection, executionDate);
		}


		backupFeature = DwEcoreUtil.copy(oldTarget.getWrappedModelElement());


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

		DwParentChildConnection connection = (DwParentChildConnection)target;

		DwFeatureWrapped tempTargetFeature = connection.getTarget();
		HyGroupComposition composition = HyEvolutionUtil.getValidTemporalElement(tempTargetFeature.getWrappedModelElement().getGroupMembership(), date);
		HyGroup group = composition.getCompositionOf();
		DwGroupWrapped parentGroupWrapped = featureModel.findWrappedGroup(group);
		HyFeatureChild child = HyEvolutionUtil.getValidTemporalElement(group.getChildOf(), date);
		DwFeatureWrapped newTarget = featureModel.findWrappedFeature(child.getParent());
		DwFeatureWrapped oldTarget = this.connection.getTarget();

		//DwGroupWrapped oldGroup = oldTarget.getParentGroup(date);

		DwParentChildConnection newConnection = new DwParentChildConnection();
		newConnection.setModel(featureModel);
		newConnection.setTarget(oldTarget);
		newConnection.setSource(newTarget);			

		parentGroupWrapped.addChildFeature(oldTarget);


		featureModel.removeFeature(oldTarget, date);		
		featureModel.addConnection(newConnection, date, group);

		
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
		realFeature.setValidSince(backupFeature.getValidSince());
		realFeature.setValidUntil(backupFeature.getValidUntil());
		
		/*
		// undo restrictions of children
		undoRestrictHyLinearTemporalElementsToParentValidUntil((EList<HyTemporalElement>)(EList<?>)realFeature.getNames(), 
				(EList<HyTemporalElement>)(EList<?>)oldFeature.getNames());
		undoRestrictHyLinearTemporalElementsToParentValidUntil((EList<HyTemporalElement>)(EList<?>)realFeature.getAttributes(), 
				(EList<HyTemporalElement>)(EList<?>)oldFeature.getAttributes());
		undoRestrictHyLinearTemporalElementsToParentValidUntil((EList<HyTemporalElement>)(EList<?>)realFeature.getVersions(), 
				(EList<HyTemporalElement>)(EList<?>)oldFeature.getVersions());
		*/
		List<HyGroupComposition> compositionToBeDeleted = new ArrayList<>();
		for(HyGroupComposition composition : realFeature.getGroupMembership()) {
			boolean exist = false;
			for(HyGroupComposition backupComposition : backupFeature.getGroupMembership()) {
				
				if(composition.getId().equals(backupComposition.getId())){
					exist = true;
					
					HyGroup group = composition.getCompositionOf();
					HyGroup backupGroup = backupComposition.getCompositionOf();
					
					if(group.getId().equals(backupGroup.getId())){
						List<HyGroupType> groupTypesToBeDeleted = new ArrayList<>();
						for(HyGroupType groupType : group.getTypes()) {
							boolean groupTypeExist = false;
							
							for(HyGroupType backupGroupType : backupGroup.getTypes()) {
								if(groupType.getId().equals(backupGroupType.getId())) {
									groupTypeExist = true;
									groupType.setType(backupGroupType.getType());
									groupType.setValidSince(backupGroupType.getValidSince());
									groupType.setValidUntil(backupGroupType.getValidUntil());
									groupType.setSupersedingElement(backupGroupType.getSupersedingElement());
									groupType.setSupersededElement(backupGroupType.getSupersededElement());
								}
							}
							
							if(!groupTypeExist)
								groupTypesToBeDeleted.add(groupType);
						}
						
						group.getTypes().removeAll(groupTypesToBeDeleted);
						
						List<HyGroupComposition> compositionToBeDeletedFromGroup = new ArrayList<>();
						for(HyGroupComposition groupComposition : composition.getCompositionOf().getParentOf()) {
							boolean groupCompositionExist = false;
							
							for(HyGroupComposition backupGroupComposition : backupComposition.getCompositionOf().getParentOf()) {
								if(groupComposition.getId().equals(backupGroupComposition.getId())) {
									groupCompositionExist = true;		
								}
														
							}
							
							if(!groupCompositionExist) {
								compositionToBeDeletedFromGroup.add(groupComposition);
								groupComposition.getFeatures().clear();
							}
						}
						composition.getCompositionOf().getParentOf().removeAll(compositionToBeDeletedFromGroup);
					}
					
					composition.setValidSince(backupComposition.getValidSince());
					composition.setValidUntil(backupComposition.getValidUntil());
					composition.setSupersedingElement(backupComposition.getSupersedingElement());
					
					List<HyFeatureChild> childToBeDeleted = new ArrayList<>();					
					for(HyFeatureChild child : composition.getCompositionOf().getChildOf()) {
						boolean childExist = false;
						for(HyFeatureChild backupChild : backupComposition.getCompositionOf().getChildOf()) {
							if(child.getId().equals(backupChild.getId())) {
								childExist = true;
								
								child.setValidSince(backupChild.getValidSince());
								child.setValidUntil(backupChild.getValidUntil());
							}
						}	
						
						if(!childExist) {
							childToBeDeleted.add(child);
						}
					}

					composition.getCompositionOf().getChildOf().removeAll(childToBeDeleted);
				}
			}
			
			if(!exist) {
				compositionToBeDeleted.add(composition);
			}
		}
		
		realFeature.getGroupMembership().removeAll(compositionToBeDeleted);
		
		connection.setValidUntil(backupConnection.getValidUntil());
		
		viewer.refreshView();	
		/*
		HyFeature realFeature = getRealModelFeature(backupFeature);
		HyGroup realGroup = getRealModelGroup(backupGroup);
		
		HyGroup backupGroup = HyEvolutionUtil.getValidTemporalElement(backupFeature.getGroupMembership(), executionDate).getCompositionOf();
		HyGroup currentGroup = HyEvolutionUtil.getValidTemporalElement(realFeature.getGroupMembership(), executionDate).getCompositionOf();
		
		if(!backupGroup.getId().equals(currentGroup.getId())) {
			DwGroupWrapped groupWrapped = viewer.getModelWrapped().findWrappedGroup(currentGroup);
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
			
			if(realComposition != null && realComposition.getSupersedingElement() != null) {
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
		viewer.getModelWrapped().addConnection(backupConnection, executionDate, realGroup);	
		
		refreshView();
		*/
	}

	@Override
	public void execute(){
		redo();
	}
}
