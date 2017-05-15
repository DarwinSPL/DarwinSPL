package de.darwinspl.feature.graphical.editor.actions.enumeration;

import org.eclipse.gef.commands.Command;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwEnumEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwEnumLiteralEditPart;
import de.darwinspl.feature.graphical.editor.actions.DwCommandAction;
import de.darwinspl.feature.graphical.editor.commands.enumeration.DwFeatureAttributeEnumCreateEnumCommand;
import de.darwinspl.feature.graphical.editor.editparts.DwFeatureModelEditorEditPart;

public class DwFeatureAttributeEnumCreateEnumAction extends DwCommandAction{
	public static final String ATTRIBUTE_CREATE_ENUM = "CreateEnum";
	public static final String REQ_ATTRIBUTE_CREATE_ENUM = "CreateEnum";
	
	public DwFeatureAttributeEnumCreateEnumAction(DwGraphicalFeatureModelViewer editor) {
		super(editor);
		
		setId(REQ_ATTRIBUTE_CREATE_ENUM);
		setText("Create Enumeration");
	}

	@Override
	protected boolean calculateEnabled() {
		if(this.getSelectedObjects().size() == 0)
			return false;
		
		if(this.getSelectedObjects().get(0) instanceof DwFeatureModelEditorEditPart)
			return true;		
		
		if(this.getSelectedObjects().get(0) instanceof DwEnumEditPart)
			return true;
		
		if(this.getSelectedObjects().get(0) instanceof DwEnumLiteralEditPart)
			return true;
		
		return false;
	}

	@Override
	protected Command createCommand(Object acceptedModel) {
		return new DwFeatureAttributeEnumCreateEnumCommand(editor);
	}
}
