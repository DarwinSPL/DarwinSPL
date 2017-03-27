package eu.hyvar.feature.graphical.editor.actions.enumeration;

import org.eclipse.gef.commands.Command;

import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.editparts.HyEnumEditPart;
import eu.hyvar.feature.graphical.base.editparts.HyEnumLiteralEditPart;
import eu.hyvar.feature.graphical.editor.actions.HyCommandAction;
import eu.hyvar.feature.graphical.editor.commands.enumeration.HyFeatureAttributeEnumCreateLiteralCommand;

public class HyFeatureAttributeEnumCreateLiteralAction extends HyCommandAction{
	public static final String ATTRIBUTE_CREATE_LITERAL = "CreateLiteral";
	public static final String REQ_ATTRIBUTE_CREATE_LITERAL = "CreateLiteral";
	
	public HyFeatureAttributeEnumCreateLiteralAction(DwGraphicalFeatureModelViewer editor) {
		super(editor);
		
		setId(REQ_ATTRIBUTE_CREATE_LITERAL);
		
		setText("Create Literal");
	}

	@Override
	protected boolean calculateEnabled() {
		if(getSelectedObjects().size() == 0)
			return false;
		
		if(this.getSelectedObjects().get(0) instanceof HyEnumEditPart)
			return true;
		
		if(this.getSelectedObjects().get(0) instanceof HyEnumLiteralEditPart)
			return true;
		
		return false;
	}
	
	@Override
	protected Command createCommand(Object acceptedModel) {
		HyEnum enumeration = null;
		
		if(this.getSelectedObjects().get(0) instanceof HyEnumEditPart)
			enumeration = (HyEnum)((HyEnumEditPart)this.getSelectedObjects().get(0)).getModel();
		
		if(this.getSelectedObjects().get(0) instanceof HyEnumLiteralEditPart){
			HyEnumLiteral literal = (HyEnumLiteral)((HyEnumLiteralEditPart)this.getSelectedObjects().get(0)).getModel();
			enumeration = literal.getEnum();
		}
		
		if(enumeration == null)
			return null;
		
		return new HyFeatureAttributeEnumCreateLiteralCommand(enumeration, editor);
	}
}
