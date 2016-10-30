package eu.hyvar.feature.graphical.editor.actions.group;

import org.eclipse.gef.Request;

import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;

public class HyGroupChangeGroupTypeToAlternativeTypeAction extends HyGroupChangeGroupTypeAction{
	public static final String CHANGE_GROUP_TYPE_TO_ALTERNATIVE = "ChangeGroupTypeToAlternative";
	public static final String REQ_CHANGE_GROUP_TYPE_TO_ALTERNATIVE= "ChangeGroupTypeToAlternative";

	

	
	public HyGroupChangeGroupTypeToAlternativeTypeAction(GraphicalFeatureModelEditor editor) {
		super(editor);
		
		setId(CHANGE_GROUP_TYPE_TO_ALTERNATIVE);
		setText("Change type to ALTERNATIVE");
		
		request = new Request(REQ_CHANGE_GROUP_TYPE_TO_ALTERNATIVE);
	}
	
	public HyGroupTypeEnum getNewGroupType(){
		return HyGroupTypeEnum.ALTERNATIVE;
	}
}
