package eu.hyvar.feature.graphical.editor.actions.group;

import org.eclipse.gef.Request;

import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;

public class HyGroupChangeGroupTypeToOrTypeAction extends HyGroupChangeGroupTypeAction {
	public static final String CHANGE_GROUP_TYPE_TO_OR = "ChangeGroupTypeToOr";
	public static final String REQ_CHANGE_GROUP_TYPE_TO_OR= "ChangeGroupTypeToOr";


	
	public HyGroupChangeGroupTypeToOrTypeAction(GraphicalFeatureModelEditor editor) {
		super(editor);
		
		setId(CHANGE_GROUP_TYPE_TO_OR);
		setText("Change type to OR");
		
		request = new Request(REQ_CHANGE_GROUP_TYPE_TO_OR);
	}
	
	public HyGroupTypeEnum getNewGroupType(){
		return HyGroupTypeEnum.OR;
	}
}
