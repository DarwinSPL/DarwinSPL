package de.darwinspl.feature.graphical.editor.actions.attribute;

import org.eclipse.gef.Request;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPart;

import de.darwinspl.feature.graphical.base.editparts.DwAttributeEditPart;
import de.darwinspl.feature.graphical.editor.dialogs.DwEditAttributeDefaultDialog;
import eu.hyvar.feature.HyNumberAttribute;

public class DwAttributeEditDefaultAction extends SelectionAction {

	public static final String ATTRIBUTE_EDIT_DEFAULT = "EditAttributeDefault";
	public static final String REQ_ATTRIBUTE_EDIT_DEFAULT = "EditAttributeDefault";
	private static final String ATTRIBUTE_EDIT_DEFAULT_TEXT = "Edit Attribute Default";
	
	Request request;
	
	public DwAttributeEditDefaultAction(IWorkbenchPart part) {
		super(part);
		
		this.setId(ATTRIBUTE_EDIT_DEFAULT);
		this.setText(ATTRIBUTE_EDIT_DEFAULT_TEXT);
		this.request = new Request(REQ_ATTRIBUTE_EDIT_DEFAULT);
		
	}
	
	

	@Override
	public void run() {
		StructuredSelection selection = (StructuredSelection)this.getSelection();
		DwAttributeEditPart part = (DwAttributeEditPart)selection.getFirstElement();
		HyNumberAttribute attribute = (HyNumberAttribute)part.getModel();
		DwEditAttributeDefaultDialog dialog = new DwEditAttributeDefaultDialog(this.getWorkbenchPart().getSite().getShell(), attribute);
		
		if(dialog.open() == Dialog.OK) {
			attribute.setDefault(dialog.getDefaultValue());
		}
	}



	@Override
	protected boolean calculateEnabled() {
		if(getSelectedObjects().isEmpty())
			return false;

		for(Object selectedObject : getSelectedObjects()){
			if(!(selectedObject instanceof DwAttributeEditPart)){
				return false;
			}
		}

		return true;
	}

}
