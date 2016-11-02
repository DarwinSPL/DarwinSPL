package eu.hyvar.feature.graphical.editor.actions.enumeration;

import org.eclipse.gef.commands.Command;

import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.editparts.HyEnumEditPart;
import eu.hyvar.feature.graphical.editor.actions.HyCommandAction;
import eu.hyvar.feature.graphical.editor.commands.enumeration.HyFeatureAttributeEnumCreateLiteralCommand;

public class HyFeatureAttributeEnumCreateLiteralAction extends HyCommandAction{
	public static final String ATTRIBUTE_CREATE_LITERAL = "CreateLiteral";
	public static final String REQ_ATTRIBUTE_CREATE_LITERAL = "CreateLiteral";
	
	public HyFeatureAttributeEnumCreateLiteralAction(GraphicalFeatureModelEditor editor) {
		super(editor);
		
		setId(REQ_ATTRIBUTE_CREATE_LITERAL);
		
		setText("Create Literal");
	}

	@Override
	protected boolean calculateEnabled() {
		if(getSelectedObjects().size() == 0)
			return false;
		
		if(this.getSelectedObjects().get(0) instanceof HyEnumEditPart){
			return true;
		}
		
		return false;
	}
	
	@Override
	protected Command createCommand(Object acceptedModel) {
		HyEnum enumeration = (HyEnum)((HyEnumEditPart)this.getSelectedObjects().get(0)).getModel();
		
		return new HyFeatureAttributeEnumCreateLiteralCommand(enumeration, editor);
	}
}
