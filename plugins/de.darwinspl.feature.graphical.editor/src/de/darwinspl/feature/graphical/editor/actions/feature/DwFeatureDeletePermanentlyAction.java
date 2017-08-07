package de.darwinspl.feature.graphical.editor.actions.feature;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.StructuredSelection;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwFeatureEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwRootFeatureEditPart;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.editor.actions.DwCommandAction;
import de.darwinspl.feature.graphical.editor.commands.feature.DwFeatureDeletePermanentlyCommand;

public class DwFeatureDeletePermanentlyAction  extends DwCommandAction {
	public static final String FEATURE_DELETE_PERMANENTLY = "DeleteFeaturePermanently";
	public static final String REQ_FEATURE_DELETE_PERMANENTLY = "DeleteFeaturePermanentlyRequest";

	public DwFeatureDeletePermanentlyAction(DwGraphicalFeatureModelViewer editor) {
		super(editor);
		

		setId(FEATURE_DELETE_PERMANENTLY);
		setText("Delete Permanently");

		request = new Request(REQ_FEATURE_DELETE_PERMANENTLY);

		this.editor = editor;
	}
	
	protected Request request;

	protected DwFeatureWrapped getSelectedFeature(){
		StructuredSelection selection = (StructuredSelection)this.getSelection();
		
		if(selection.getFirstElement() instanceof DwFeatureEditPart){
			DwFeatureEditPart part = (DwFeatureEditPart)selection.getFirstElement();
			return (DwFeatureWrapped)part.getModel();		
		}
		
		if(selection.getFirstElement() instanceof DwRootFeatureEditPart){
			DwRootFeatureEditPart part = (DwRootFeatureEditPart)selection.getFirstElement();
			return (DwFeatureWrapped)part.getModel();
		}
	
		return null;
	}	
	
	protected boolean calculateEnabled() {
		if(getSelectedObjects().isEmpty())
			return false;
		
		for(Object selectedObject : getSelectedObjects()){
			if(!(selectedObject instanceof DwFeatureEditPart || selectedObject instanceof DwRootFeatureEditPart)){
				return false;
			}
		}
		
		return true;
	}

	@Override
	protected Command createCommand(Object acceptedModel) {
		DwFeatureDeletePermanentlyCommand command = new DwFeatureDeletePermanentlyCommand(editor, (EditPart)getSelectedObjects().get(0));
		command.setFeature((DwFeatureWrapped)((DwFeatureEditPart)getSelectedObjects().get(0)).getModel());
		
		return command;
	}
}