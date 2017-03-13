package eu.hyvar.feature.graphical.editor.actions.enumeration;

import org.eclipse.gef.commands.Command;

import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.editor.actions.HyCommandAction;
import eu.hyvar.feature.graphical.editor.commands.enumeration.HyFeatureAttributeEnumCreateEnumCommand;
import eu.hyvar.feature.graphical.editor.editparts.HyFeatureModelEditorEditPart;

public class HyFeatureAttributeEnumCreateEnumAction extends HyCommandAction{
	public static final String ATTRIBUTE_CREATE_ENUM = "CreateEnum";
	public static final String REQ_ATTRIBUTE_CREATE_ENUM = "CreateEnum";
	
	public HyFeatureAttributeEnumCreateEnumAction(DwGraphicalFeatureModelViewer editor) {
		super(editor);
		
		setId(REQ_ATTRIBUTE_CREATE_ENUM);
		setText("Create Enumeration");
	}

	@Override
	protected boolean calculateEnabled() {
		if(this.getSelectedObjects().size() == 0)
			return false;
		
		if(this.getSelectedObjects().get(0) instanceof HyFeatureModelEditorEditPart){
			return true;
		}
		
		return false;
	}

	@Override
	protected Command createCommand(Object acceptedModel) {
		return new HyFeatureAttributeEnumCreateEnumCommand(editor);
	}
}
