package de.darwinspl.feature.graphical.editor.actions.enumeration;

import org.eclipse.gef.commands.Command;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwEnumEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwEnumLiteralEditPart;
import de.darwinspl.feature.graphical.editor.actions.DwCommandAction;
import de.darwinspl.feature.graphical.editor.commands.enumeration.DwFeatureAttributeEnumCreateLiteralCommand;
import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;

public class DwFeatureAttributeEnumCreateLiteralAction extends DwCommandAction{
	public static final String ATTRIBUTE_CREATE_LITERAL = "CreateLiteral";
	public static final String REQ_ATTRIBUTE_CREATE_LITERAL = "CreateLiteral";
	
	public DwFeatureAttributeEnumCreateLiteralAction(DwGraphicalFeatureModelViewer editor) {
		super(editor);
		
		setId(REQ_ATTRIBUTE_CREATE_LITERAL);
		
		setText("Create Literal");
	}

	@Override
	protected boolean calculateEnabled() {
		if(getSelectedObjects().size() == 0)
			return false;
		
		if(this.getSelectedObjects().get(0) instanceof DwEnumEditPart)
			return true;
		
		if(this.getSelectedObjects().get(0) instanceof DwEnumLiteralEditPart)
			return true;
		
		return false;
	}
	
	@Override
	protected Command createCommand(Object acceptedModel) {
		HyEnum enumeration = null;
		
		if(this.getSelectedObjects().get(0) instanceof DwEnumEditPart) {
			enumeration = (HyEnum)((DwEnumEditPart)this.getSelectedObjects().get(0)).getModel();			
		}
		
		if(this.getSelectedObjects().get(0) instanceof DwEnumLiteralEditPart){
			HyEnumLiteral literal = (HyEnumLiteral)((DwEnumLiteralEditPart)this.getSelectedObjects().get(0)).getModel();
			enumeration = literal.getEnum();
		}
		
		if(enumeration == null) {
			return null;			
		}
		
		return new DwFeatureAttributeEnumCreateLiteralCommand(enumeration, editor);
	}
}
