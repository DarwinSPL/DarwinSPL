package eu.hyvar.feature.graphical.editor.actions.attribute;


import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.StructuredSelection;

import eu.hyvar.feature.HyNumberAttribute;
import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.editparts.HyAttributeEditPart;
import eu.hyvar.feature.graphical.editor.actions.HyCommandAction;
import eu.hyvar.feature.graphical.editor.commands.attribute.HyNumberAttributeSetNumberRangeCommand;
import eu.hyvar.feature.graphical.editor.editor.HyGraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.editor.editparts.HyAttributeEditorEditPart;

public class HyNumberAttributeSetNumberRangeAction  extends HyCommandAction{
	public static final String ATTRIBUTE_EDIT_MIN_AND_MAX = "EditNumberAttributeMinAndMax";
	public static final String REQ_ATTRIBUTE_EDIT_MIN_AND_MAX = "EditNumberAttributeMinAndMax";

	Request request;

	public HyNumberAttributeSetNumberRangeAction(DwGraphicalFeatureModelViewer editor){
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
			if(!(selectedObject instanceof HyAttributeEditPart)){
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
		
		HyGraphicalFeatureModelEditor editor = (HyGraphicalFeatureModelEditor)this.getWorkbenchPart();
		
		HyAttributeEditorEditPart editPart = (HyAttributeEditorEditPart)selection.getFirstElement();
		HyNumberAttributeSetNumberRangeCommand command = new HyNumberAttributeSetNumberRangeCommand((HyNumberAttribute)editPart.getModel(), editor);
		return command;
	}
}