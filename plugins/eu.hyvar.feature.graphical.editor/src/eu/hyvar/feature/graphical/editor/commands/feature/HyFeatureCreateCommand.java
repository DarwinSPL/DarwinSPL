package eu.hyvar.feature.graphical.editor.commands.feature;


import java.util.Date;

import org.eclipse.draw2d.geometry.Point;

import eu.hyvar.evolution.HyEvolutionFactory;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyParentChildConnection;
import eu.hyvar.feature.graphical.editor.commands.DwFeatureModelEditorCommand;

public class HyFeatureCreateCommand extends DwFeatureModelEditorCommand {
	private HyFeatureWrapped parent;
	private HyFeatureWrapped newFeature;
	
	private HyParentChildConnection connection;
	private Date date;
	
	public HyFeatureCreateCommand(HyFeatureWrapped parent, DwGraphicalFeatureModelViewer viewer){
		super(viewer);
		
		this.parent = parent;
	}

	/**
	 * Undo creating a new feature
	 */
	@Override
	public void undo() {
		
		HyFeatureModelWrapped featureModel = viewer.getModelWrapped();
		featureModel.removeConnection(connection, date);
		
		featureModel.getModel().getFeatures().remove(newFeature.getWrappedModelElement());
		
		featureModel.rearrangeFeatures();
		viewer.refreshView();
	}

	@Override
	public void redo() {
		HyFeatureModelWrapped featureModel = viewer.getModelWrapped();
		date = viewer.getCurrentSelectedDate();
		if(date.equals(new Date(Long.MIN_VALUE))){
			date = null;
		}		
		
		
		// Create a new feature model and editor representation
		HyFeature feature = HyFeatureFactory.eINSTANCE.createHyFeature();
		feature.setValidSince(date);
		newFeature = new HyFeatureWrapped(feature, featureModel);
		newFeature.addPosition(new Point(0, 0), date, false);
		
		HyName name = HyEvolutionFactory.eINSTANCE.createHyName();
		name.setName(featureModel.getValidNewFeatureName());
		name.setValidSince(date);
		feature.getNames().add(name);

		HyFeatureType type = HyFeatureFactory.eINSTANCE.createHyFeatureType();
		feature.getTypes().add(type);
		
		connection = new HyParentChildConnection();
		connection.setSource(parent);
		connection.setTarget(newFeature);
		connection.setModel(featureModel);
		
		featureModel.addConnection(connection, featureModel.getSelectedDate(), null);
		
		parent.addParentToChildConnection(connection);
		newFeature.addChildToParentConnection(connection);
		
		newFeature.setWrappedModelElement(feature);
		featureModel.addFeature(newFeature);
		
		featureModel.rearrangeFeatures();
		viewer.refreshView();	
	}	
	
	@Override 
	public void execute(){
		redo();
	}
}
