package de.darwinspl.feature.graphical.editor.commands.connections;


import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.EditPart;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.base.model.DwGroupWrapped;
import de.darwinspl.feature.graphical.base.model.DwParentChildConnection;
import de.darwinspl.feature.graphical.editor.commands.feature.DwAbstractFeatureDeleteCommand;
import de.darwinspl.feature.graphical.editor.commands.feature.DwFeatureDeleteCommand;
import de.darwinspl.feature.graphical.editor.util.DwEcoreUtil;
import eu.hyvar.evolution.HyTemporalElement;
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
		
		// only one connection valid at a timestamp
		if(!oldTarget.getParentConnections(executionDate).isEmpty()){
			DwParentChildConnection currentConnection = oldTarget.getParentConnections(executionDate).get(0);
			
			oldConnection = DwEcoreUtil.copy(currentConnection);
			
			currentConnection.setValidUntil(executionDate);	
		}
		
		
		oldFeature = DwEcoreUtil.copy(connection.getTarget().getWrappedModelElement());
		
		featureModel.removeFeature(oldTarget, executionDate);
		
		newConnection = new DwParentChildConnection();
		newConnection.setModel(featureModel);
		newConnection.setTarget(oldTarget);
		newConnection.setSource(newTarget);
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

	@Override
	public void redo(){
		if(target instanceof DwFeatureWrapped){
			redoForFeatureTarget();
		}else{
			redoForConnectionTarget();
		}	
		
		viewer.getModelWrapped().rearrangeFeatures();
		viewer.refreshView();
	}
	
	@Override 
	public void undo(){
		HyFeature realFeature = getRealModelFeature(oldFeature);
	
		DwFeatureModelWrapped featureModel = viewer.getModelWrapped();
		featureModel.removeConnection(newConnection, executionDate);
		
		
		
		

		// remove the splitted composition from the feature model
		for(HyGroupComposition composition : realFeature.getGroupMembership()){
			// the last composition where the feature is part of
			if(composition.getValidUntil().equals(executionDate)){
				composition.getCompositionOf().getParentOf().remove(composition.getSupersedingElement());
				
				HyGroupComposition newAddedComposition = (HyGroupComposition)composition.getSupersedingElement();
				newAddedComposition.getFeatures().clear();
				
				composition.setValidUntil(null);
				composition.getFeatures().add(realFeature);
				
				composition.setSupersedingElement(null);
				
				break;
			}
		}	
		
		featureModel.addConnection(oldConnection, executionDate, oldConnection.getTarget().getGroupMembership(executionDate).getCompositionOf());
		
	}

	@Override
	public void execute(){
		redo();
	}
}
