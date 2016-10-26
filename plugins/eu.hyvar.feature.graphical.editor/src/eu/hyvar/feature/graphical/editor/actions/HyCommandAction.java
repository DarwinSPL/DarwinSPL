package eu.hyvar.feature.graphical.editor.actions;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPart;

import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;

public abstract class HyCommandAction extends SelectionAction {
	GraphicalFeatureModelEditor editor;
	
	public HyCommandAction(IWorkbenchPart part, GraphicalFeatureModelEditor editor) {
		super(part);
		
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
