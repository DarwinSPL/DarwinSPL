package de.darwinspl.feature.graphical.editor.commands.feature;


import java.util.Date;

import org.eclipse.draw2d.geometry.Point;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.base.model.DwParentChildConnection;
import de.darwinspl.feature.graphical.editor.commands.DwFeatureModelEditorCommand;
import eu.hyvar.evolution.HyEvolutionFactory;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureType;

public class DwFeatureCreateCommand extends DwFeatureModelEditorCommand {
	private DwFeatureWrapped parent;
	private DwFeatureWrapped newFeature;
	
	private DwParentChildConnection connection;
	private Date date;
	
	public DwFeatureCreateCommand(DwFeatureWrapped parent, DwGraphicalFeatureModelViewer viewer){
		super(viewer);
		
		this.parent = parent;
	}

	/**
	 * Undo creating a new feature
	 */
	@Override
	public void undo() {
		
		DwFeatureModelWrapped featureModel = viewer.getModelWrapped();
		featureModel.removeConnection(connection, date);
		
		//featureModel.getModel().getFeatures().remove(newFeature.getWrappedModelElement());
		featureModel.removeFeature(newFeature, date);
		featureModel.removeFeature(newFeature);
		
		featureModel.rearrangeFeatures();
		viewer.refreshView();
	}

	@Override
	public void redo() {
		DwFeatureModelWrapped featureModel = viewer.getModelWrapped();
		date = viewer.getCurrentSelectedDate();
		
		// Create a new feature model and editor representation
		HyFeature feature = HyFeatureFactory.eINSTANCE.createHyFeature();
		feature.setValidSince(DwFeatureModelWrapped.getCorrectModelDate(date));
		newFeature = new DwFeatureWrapped(feature, featureModel);
		newFeature.addPosition(new Point(0, 0), date, false);
		
		HyName name = HyEvolutionFactory.eINSTANCE.createHyName();
		name.setName(featureModel.getValidNewFeatureName());
		name.setValidSince(DwFeatureModelWrapped.getCorrectModelDate(date));
		feature.getNames().add(name);

		HyFeatureType type = HyFeatureFactory.eINSTANCE.createHyFeatureType();
		type.setValidSince(DwFeatureModelWrapped.getCorrectModelDate(date));
		feature.getTypes().add(type);
		
		connection = new DwParentChildConnection();
		connection.setSource(parent);
		connection.setTarget(newFeature);
		connection.setValidSince(DwFeatureModelWrapped.getCorrectModelDate(date));
		connection.setModel(featureModel);
		
		featureModel.addConnection(connection, featureModel.getSelectedDate(), null);
		
		newFeature.setWrappedModelElement(feature);
		featureModel.addFeature(newFeature);
		
		// hide new feature if parent feature is in collapsed mode
		if(parent.isHideChildren()){
			newFeature.setVisible(false, date);
		}
		
		featureModel.rearrangeFeatures();
		viewer.refreshView();	
	}	
	
	@Override 
	public void execute(){
		redo();
	}
	
	@Override
	public boolean canExecute() {
		return viewer.isLastDateSelected();
	}
}
