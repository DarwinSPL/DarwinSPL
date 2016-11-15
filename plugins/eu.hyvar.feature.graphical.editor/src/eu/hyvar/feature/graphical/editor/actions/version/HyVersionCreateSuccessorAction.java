package eu.hyvar.feature.graphical.editor.actions.version;

import org.eclipse.gef.Request;
import org.eclipse.gef.ui.actions.SelectionAction;

import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureEditPart;
import eu.hyvar.feature.graphical.base.editparts.HyVersionEditPart;

public class HyVersionCreateSuccessorAction extends SelectionAction{
	public static final String FEATURE_CREATE_SUCCESSOR_VERSION = "AddSuccessorVersion";
	public static final String REQ_FEATURE_CREATE_SUCCESSOR_VERSION = "AddSuccessorVersion";

	Request request;

	GraphicalFeatureModelEditor editor;

	public HyVersionCreateSuccessorAction(GraphicalFeatureModelEditor editor){
		super(editor);

		setId(FEATURE_CREATE_SUCCESSOR_VERSION);
		setText("Create Successor Version");

		request = new Request(REQ_FEATURE_CREATE_SUCCESSOR_VERSION);

		this.editor = editor;
	}

	@Override
	public void run(){
		for(Object o : getSelectedObjects()){

			if(o instanceof HyVersionEditPart){
				
				HyVersionEditPart p = (HyVersionEditPart)o;
				HyVersion model = (HyVersion)p.getModel();
				HyVersion version = HyFeatureFactory.eINSTANCE.createHyVersion();
				version.setValidSince(editor.getCurrentSelectedDate());

				version.setNumber("C"+model.getSupersedingVersions().size());

				model.getSupersedingVersions().add(version);
				version.setSupersededVersion(model);
				
				model.getFeature().getVersions().add(version);
				version.setFeature(model.getFeature());
				
				((HyFeatureEditPart)p.getParent()).refreshVisuals();
			}
		}
		
		editor.getModelWrapped().rearrangeFeatures();
		editor.refreshView();
	}

	@Override
	protected boolean calculateEnabled() {
		
		if(getSelectedObjects().isEmpty())
			return false;

		for(Object selectedObject : getSelectedObjects()){
			if(!(selectedObject instanceof HyVersionEditPart)){
				return false;
			}
		}

		return true;
	}	
}