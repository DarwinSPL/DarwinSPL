package eu.hyvar.feature.graphical.editor.actions.feature;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.ui.IWorkbenchPart;

import eu.hyvar.evolution.HyEvolutionFactory;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyParentChildConnection;
import eu.hyvar.feature.graphical.editor.commands.feature.HyFeatureCreateCommand;
import eu.hyvar.feature.graphical.editor.editor.GraphicalEvolutionFeatureModelEditor;

public class HyFeatureEvolutionCreateChildAction extends HyFeatureSelectionAction {
	public static final String FEATURE_EVOLUTION_CREATE_CHILD = "CreateChildEvolution";
	public static final String REQ_FEATURE_EVOLUTION_CREATE_CHILD = "CreateChildEvolution";
		
	public HyFeatureEvolutionCreateChildAction(IWorkbenchPart part, GraphicalFeatureModelEditor editor) {
		super(part, editor);
			
		setId(FEATURE_EVOLUTION_CREATE_CHILD);
		setText("Create Child");
		request = new Request(REQ_FEATURE_EVOLUTION_CREATE_CHILD);
	}
	
	
	/*
	@Override
	public void run(){
		
		HyFeatureWrapped selectedFeature = getSelectedFeature();		
		GraphicalEvolutionFeatureModelEditor editor = (GraphicalEvolutionFeatureModelEditor)this.getWorkbenchPart();
		HyFeatureModelWrapped featureModel = editor.getModelWrapped();

		
		// Create a new feature model and editor representation
		HyFeature feature = HyFeatureFactory.eINSTANCE.createHyFeature();
		feature.setValidSince(editor.getCurrentSelectedDate());
		HyFeatureWrapped newFeature = new HyFeatureWrapped(feature, featureModel);
		
		HyName name = HyEvolutionFactory.eINSTANCE.createHyName();
		name.setName(featureModel.getValidNewFeatureName());
		feature.getNames().add(name);

		
		HyFeatureType type = HyFeatureFactory.eINSTANCE.createHyFeatureType();
		feature.getTypes().add(type);
		
		newFeature.setWrappedModelElement(feature);
		featureModel.addFeature(newFeature);
		
		
		featureModel.createConnection(selectedFeature, newFeature);
		
		HyParentChildConnection connection = new HyParentChildConnection();
		connection.setSource(selectedFeature);
		connection.setTarget(newFeature);
		connection.setModel(featureModel);
		
		featureModel.addConnection(connection);
		
		selectedFeature.addParentToChildConnection(connection);
		newFeature.addChildToParentConnection(connection);
		
		
		
		featureModel.rearrangeFeatures();
		editor.refreshView();
		
	}
*/
	
	@Override
	protected Command createCommand(Object acceptedModel) {
		HyFeatureWrapped selectedFeature = getSelectedFeature();		
		GraphicalEvolutionFeatureModelEditor editor = (GraphicalEvolutionFeatureModelEditor)this.getWorkbenchPart();
		HyFeatureModelWrapped featureModel = editor.getModelWrapped();
		
		HyFeatureCreateCommand command = new HyFeatureCreateCommand(selectedFeature, (GraphicalFeatureModelEditor)editor);
		return command;
	}	
}
