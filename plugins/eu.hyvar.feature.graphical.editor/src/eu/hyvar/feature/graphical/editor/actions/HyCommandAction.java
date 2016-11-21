package eu.hyvar.feature.graphical.editor.actions;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.viewers.StructuredSelection;

import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;

public abstract class HyCommandAction extends SelectionAction {
	protected HyGraphicalFeatureModelViewer editor;
	
	public HyCommandAction(HyGraphicalFeatureModelViewer editor) {
		super(editor);
		
		this.editor = editor;
	}
	
	@Override
	public void run(){
		StructuredSelection selection = (StructuredSelection)this.getSelection();
		if(selection.getFirstElement() instanceof AbstractGraphicalEditPart){
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
