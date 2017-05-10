package de.darwinspl.feature.graphical.editor.commands;


import java.util.Date;

import org.eclipse.gef.commands.Command;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.base.model.DwGroupWrapped;
import de.darwinspl.feature.graphical.base.model.DwParentChildConnection;
import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;

public class DwParentChildConnectionReconnectCommand extends Command{
	private DwFeatureWrapped source;
	private Object target;
	private DwParentChildConnection connection;
	private DwFeatureModelWrapped featureModel;

	private DwGraphicalFeatureModelViewer editor;
	public DwParentChildConnectionReconnectCommand(DwGraphicalFeatureModelViewer editor){
		this.editor = editor;
	}


	public DwFeatureModelWrapped getFeatureModel() {
		return featureModel;
	}

	public void setFeatureModel(DwFeatureModelWrapped featureModel) {
		this.featureModel = featureModel;
	}

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
		Date date = featureModel.getSelectedDate();
		if(date.equals(new Date(Long.MIN_VALUE)))
			date = null;

		
		DwFeatureWrapped newTarget = (DwFeatureWrapped)target;
		DwFeatureWrapped oldTarget = connection.getTarget();

		//DwGroupWrapped oldGroup = oldTarget.getParentGroup(date);
		DwParentChildConnection newConnection = new DwParentChildConnection();
		newConnection.setModel(featureModel);
		newConnection.setTarget(oldTarget);
		newConnection.setSource(newTarget);
		featureModel.addConnection(newConnection, date, null);

		featureModel.removeFeature(oldTarget, date);		
	}
	
	private void redoForConnectionTarget(){
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
		
		editor.getModelWrapped().rearrangeFeatures();
		editor.refreshView();
	}

	@Override
	public void execute(){
		redo();
	}
}
