package de.darwinspl.feature.graphical.editor.actions;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.viewers.StructuredSelection;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;

public abstract class DwCommandAction extends SelectionAction {
	protected DwGraphicalFeatureModelViewer editor;
	
	public DwCommandAction(DwGraphicalFeatureModelViewer editor) {
		super(editor);
		
		this.editor = editor;
	}
	
	@Override
	public void run(){
		StructuredSelection selection = (StructuredSelection)this.getSelection();
		if(selection == null) {
			execute(null);
		}
		else if(selection.getFirstElement() instanceof AbstractGraphicalEditPart){
			AbstractGraphicalEditPart part = (AbstractGraphicalEditPart)selection.getFirstElement();
			execute(part.getModel());	
		}		
	}
	protected void execute(Object acceptedModel) {
		Command command = createCommand(acceptedModel);
		editor.executeCommand(command);
	}
	
	protected abstract Command createCommand(Object acceptedModel);
}
