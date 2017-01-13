package eu.hyvar.feature.graphical.editor.actions.version;

import java.util.Date;

import org.eclipse.gef.Request;
import org.eclipse.gef.ui.actions.SelectionAction;

import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureEditPart;
import eu.hyvar.feature.graphical.base.editparts.HyVersionEditPart;
import eu.hyvar.feature.graphical.editor.commands.version.HyVersionCreateSuccessorCommand;

public class HyVersionCreateSuccessorAction extends SelectionAction{
	public static final String FEATURE_CREATE_SUCCESSOR_VERSION = "AddSuccessorVersion";
	public static final String REQ_FEATURE_CREATE_SUCCESSOR_VERSION = "AddSuccessorVersion";

	Request request;

	HyGraphicalFeatureModelViewer editor;

	public HyVersionCreateSuccessorAction(HyGraphicalFeatureModelViewer editor){
		super(editor);

		setId(FEATURE_CREATE_SUCCESSOR_VERSION);
		setText("Create Successor Version");

		request = new Request(REQ_FEATURE_CREATE_SUCCESSOR_VERSION);

		this.editor = editor;
	}

	@Override
	public void run(){
		Date date = editor.getCurrentSelectedDate();
		if(date.equals(new Date(Long.MIN_VALUE)))
			date = null;		
		
		for(Object o : getSelectedObjects()){
			if(o instanceof HyVersionEditPart){
				HyVersionEditPart editPart = (HyVersionEditPart)o;

				HyVersionCreateSuccessorCommand command = new HyVersionCreateSuccessorCommand((HyVersion)editPart.getModel(), editor);
				editor.executeCommand(command);
		
				((HyFeatureEditPart)editPart.getParent()).refreshVisuals();
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