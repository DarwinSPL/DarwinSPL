package eu.hyvar.feature.graphical.editor.commands;


import java.util.Date;

import org.eclipse.gef.commands.Command;

import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyGroupWrapped;
import eu.hyvar.feature.graphical.base.model.HyParentChildConnection;

public class HyParentChildConnectionReconnectCommand extends Command{
	private HyFeatureWrapped source;
	private Object target;
	private HyParentChildConnection connection;
	private HyFeatureModelWrapped featureModel;

	private DwGraphicalFeatureModelViewer editor;
	public HyParentChildConnectionReconnectCommand(DwGraphicalFeatureModelViewer editor){
		this.editor = editor;
	}


	public HyFeatureModelWrapped getFeatureModel() {
		return featureModel;
	}

	public void setFeatureModel(HyFeatureModelWrapped featureModel) {
		this.featureModel = featureModel;
	}

	@Override 
	public boolean canExecute(){
		return source != null && target != null && connection != null;
	}

	public void setSource(HyFeatureWrapped source) {
		this.source = source;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public void setConnection(HyParentChildConnection connection) {
		this.connection = connection;
	}	

	private void redoForFeatureTarget(){
		Date date = featureModel.getSelectedDate();
		if(date.equals(new Date(Long.MIN_VALUE)))
			date = null;

		
		HyFeatureWrapped newTarget = (HyFeatureWrapped)target;
		HyFeatureWrapped oldTarget = connection.getTarget();

		HyGroupWrapped oldGroup = oldTarget.getParentGroup(date);
		HyParentChildConnection newConnection = new HyParentChildConnection();
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

		
		HyParentChildConnection connection = (HyParentChildConnection)target;

		HyFeatureWrapped tempTargetFeature = connection.getTarget();
		HyGroupComposition composition = HyEvolutionUtil.getValidTemporalElement(tempTargetFeature.getWrappedModelElement().getGroupMembership(), date);
		HyGroup group = composition.getCompositionOf();
		HyGroupWrapped parentGroupWrapped = featureModel.getWrappedGroup(group);
		HyFeatureChild child = HyEvolutionUtil.getValidTemporalElement(group.getChildOf(), date);
		HyFeatureWrapped newTarget = featureModel.getWrappedFeature(child.getParent());
		HyFeatureWrapped oldTarget = this.connection.getTarget();
		
		HyGroupWrapped oldGroup = oldTarget.getParentGroup(date);
		
		HyParentChildConnection newConnection = new HyParentChildConnection();
		newConnection.setModel(featureModel);
		newConnection.setTarget(oldTarget);
		newConnection.setSource(newTarget);			
		
		parentGroupWrapped.addChildFeature(oldTarget);
		
		
		
		featureModel.addConnection(newConnection, date, composition.getCompositionOf());
		
		featureModel.removeFeature(oldTarget, date);		
	}

	@Override
	public void redo(){
		if(target instanceof HyFeatureWrapped){
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
