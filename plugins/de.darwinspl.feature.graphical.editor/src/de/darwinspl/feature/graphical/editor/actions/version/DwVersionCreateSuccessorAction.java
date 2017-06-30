package de.darwinspl.feature.graphical.editor.actions.version;

import java.util.Date;

import org.eclipse.gef.Request;
import org.eclipse.gef.ui.actions.SelectionAction;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwFeatureEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwVersionEditPart;
import de.darwinspl.feature.graphical.editor.commands.version.DwVersionCreateSuccessorCommand;
import eu.hyvar.feature.HyVersion;

public class DwVersionCreateSuccessorAction extends SelectionAction{
	public static final String FEATURE_CREATE_SUCCESSOR_VERSION = "AddSuccessorVersion";
	public static final String REQ_FEATURE_CREATE_SUCCESSOR_VERSION = "AddSuccessorVersion";

	Request request;

	DwGraphicalFeatureModelViewer editor;

	public DwVersionCreateSuccessorAction(DwGraphicalFeatureModelViewer editor){
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
			if(o instanceof DwVersionEditPart){
				DwVersionEditPart editPart = (DwVersionEditPart)o;

				DwVersionCreateSuccessorCommand command = new DwVersionCreateSuccessorCommand((HyVersion)editPart.getModel(), editor);
				editor.executeCommand(command);
		
				((DwFeatureEditPart)editPart.getParent()).refreshVisuals();
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
			if(!(selectedObject instanceof DwVersionEditPart)){
				return false;
			}
		}

		return true;
	}	
}