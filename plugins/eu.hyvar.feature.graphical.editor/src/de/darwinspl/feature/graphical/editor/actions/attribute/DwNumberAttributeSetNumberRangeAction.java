package de.darwinspl.feature.graphical.editor.actions.attribute;


import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.StructuredSelection;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwAttributeEditPart;
import de.darwinspl.feature.graphical.editor.actions.DwCommandAction;
import de.darwinspl.feature.graphical.editor.commands.attribute.DwNumberAttributeSetNumberRangeCommand;
import de.darwinspl.feature.graphical.editor.editor.DwGraphicalFeatureModelEditor;
import de.darwinspl.feature.graphical.editor.editparts.DwAttributeEditorEditPart;
import eu.hyvar.feature.HyNumberAttribute;

public class DwNumberAttributeSetNumberRangeAction  extends DwCommandAction{
	public static final String ATTRIBUTE_EDIT_MIN_AND_MAX = "EditNumberAttributeMinAndMax";
	public static final String REQ_ATTRIBUTE_EDIT_MIN_AND_MAX = "EditNumberAttributeMinAndMax";

	Request request;

	public DwNumberAttributeSetNumberRangeAction(DwGraphicalFeatureModelViewer editor){
		super(editor);

		setId(ATTRIBUTE_EDIT_MIN_AND_MAX);
		setText("Edit Attribute Minimum and Maximum");

		request = new Request(REQ_ATTRIBUTE_EDIT_MIN_AND_MAX);
	}

	@Override
	protected boolean calculateEnabled() {
		if(getSelectedObjects().isEmpty())
			return false;

		for(Object selectedObject : getSelectedObjects()){
			if(!(selectedObject instanceof DwAttributeEditPart)){
				return false;
			}else{
				if(!(((EditPart)selectedObject).getModel() instanceof HyNumberAttribute)){
					return false;
				}
			}
		}

		return true;
	}	
	
	@Override
	protected Command createCommand(Object acceptedModel) {
		StructuredSelection selection = (StructuredSelection)this.getSelection();
		
		DwGraphicalFeatureModelEditor editor = (DwGraphicalFeatureModelEditor)this.getWorkbenchPart();
		
		DwAttributeEditorEditPart editPart = (DwAttributeEditorEditPart)selection.getFirstElement();
		DwNumberAttributeSetNumberRangeCommand command = new DwNumberAttributeSetNumberRangeCommand((HyNumberAttribute)editPart.getModel(), editor);
		return command;
	}
}