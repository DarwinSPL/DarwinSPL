package eu.hyvar.feature.graphical.editor.actions.feature;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;

import eu.hyvar.evolution.HyEvolutionFactory;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyParentChildConnection;

public class HyFeatureCreateSiblingAction extends HyFeatureSelectionAction{
	public static final String FEATURE_CREATE_SIBLING = "CreateSibling";
	public static final String REQ_FEATURE_CREATE_SIBLING = "CreateSibling";

	Request request;
	
	public HyFeatureCreateSiblingAction(GraphicalFeatureModelEditor editor){
		super(editor);
		
		setId(FEATURE_CREATE_SIBLING);
		setText("Create Sibling");
		
		request = new Request(REQ_FEATURE_CREATE_SIBLING);
	}
	
	@Override
	public void run(){
		HyFeatureWrapped selectedFeature = getSelectedFeature();
		selectedFeature = selectedFeature.getChildrenConnections(null).get(0).getSource();
		
		Point position = selectedFeature.getPosition(null);
		
		GraphicalFeatureModelEditor editor = (GraphicalFeatureModelEditor)this.getWorkbenchPart();
		HyFeatureModelWrapped featureModel = editor.getModelWrapped();
		
		// Create a new feature model and editor representation
		HyFeature feature = HyFeatureFactory.eINSTANCE.createHyFeature();		
		HyFeatureWrapped newFeature = new HyFeatureWrapped(feature, featureModel);
		
		HyName name = HyEvolutionFactory.eINSTANCE.createHyName();
		name.setName(featureModel.getValidNewFeatureName());
		feature.getNames().add(name);
		
		HyFeatureType type = HyFeatureFactory.eINSTANCE.createHyFeatureType();
		feature.getTypes().add(type);
		
		newFeature.setPosition(new Point(position.x, position.y+100));
		newFeature.setWrappedModelElement(feature);
		featureModel.addFeature(newFeature);
		
		
		HyParentChildConnection connection = new HyParentChildConnection();
		connection.setSource(selectedFeature);
		connection.setTarget(newFeature);
		connection.setModel(featureModel);
		
		selectedFeature.addParentToChildConnection(connection);
		newFeature.addChildToParentConnection(connection);
		
		featureModel.addConnection(connection, featureModel.getSelectedDate());		
		featureModel.rearrangeFeatures();
		
		//editor.setDirty(true);
	}

	@Override
	protected boolean calculateEnabled() {
		if(getSelectedObjects().isEmpty())
			return false;
		
		for(Object selectedObject : getSelectedObjects()){
			if(!(selectedObject instanceof HyFeatureEditPart)){
				return false;
			}
		}
		
		return true;
	}

	@Override
	protected Command createCommand(Object acceptedModel) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
