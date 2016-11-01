package eu.hyvar.feature.graphical.editor.commands;


import org.eclipse.gef.commands.Command;

import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyParentChildConnection;

public class HyParentChildConnectionReconnectCommand extends Command{
	protected HyFeatureWrapped source;
	protected Object target;
	protected HyParentChildConnection connection;
	protected HyFeatureModelWrapped featureModel;
	
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
	
	
	@Override
	public void execute(){
		/*
		HyFeatureWrapped changedConnectionSource = connection.getSource();
		HyFeatureWrapped changedConnectionTarget = connection.getTarget();
		
		if(target instanceof HyFeatureWrapped){
			
			changedConnectionSource.removeParentToChildConnection(connection);
			
			featureModel.removeConnection(connection, new Date());
			connection.setTarget(changedConnectionTarget);
			connection.setSource((HyFeatureWrapped) target);
			
			((HyFeatureWrapped)target).addParentToChildConnection(connection);
			
			
			featureModel.addConnection(connection, featureModel.getSelectedDate());
			featureModel.rearrangeFeatures();	
			
			
			// show cardinality if it was hidden before
			if(changedConnectionTarget.isWithoutModifier(null)){
				HyCardinality cardinality = changedConnectionTarget.getCardinality(0);
				cardinality.setMinCardinality(0);
				cardinality.setMaxCardinality(0);
				
				changedConnectionTarget.setCardinailtyAtIndex(cardinality, 0);
			}
			
		}
		
		if(target instanceof HyParentChildConnection){
			
			featureModel.removeConnection(connection, new Date());
			
			((HyParentChildConnection) target).setHighlight(true);

			HyFeatureWrapped newConnectionSource = ((HyParentChildConnection) target).getSource();
			HyFeatureWrapped newConnectionTarget = ((HyParentChildConnection) target).getTarget();
			
			//changedConnectionTarget.removeParentGroup();
			
			newConnectionTarget.getParentGroup(null).addChildFeature(changedConnectionTarget);
					
			
			changedConnectionSource.removeParentToChildConnection(connection);
			
			
			// only for readability, not necessary
			connection.setTarget(changedConnectionTarget);
			connection.setSource(newConnectionSource);
			newConnectionSource.addParentToChildConnection(connection);
			
			HyGroupWrapped group = newConnectionTarget.getParentGroup(null);
			// hide modifier
			if(!group.isAnd(null)){
				
				HyCardinality cardinality = changedConnectionTarget.getCardinality(0);
				cardinality.setMinCardinality(0);
				cardinality.setMaxCardinality(1);
				
				changedConnectionTarget.setCardinailtyAtIndex(cardinality, 0);
				
			}else{
				
				if(changedConnectionTarget.isWithoutModifier(null)){
					HyCardinality cardinality = changedConnectionTarget.getCardinality(0);
					cardinality.setMinCardinality(0);
					cardinality.setMaxCardinality(0);
					changedConnectionTarget.setCardinality(cardinality);
				}
				
			}
			
		}
		*/
	}
}
