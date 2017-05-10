package eu.hyvar.feature.graphical.editor.actions.group;

import org.eclipse.gef.Request;

import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;

public class HyGroupChangeGroupTypeToAndTypeAction extends HyGroupChangeGroupTypeAction {
	public static final String CHANGE_GROUP_TYPE_TO_AND = "ChangeGroupTypeToAnd";
	public static final String REQ_CHANGE_GROUP_TYPE_TO_AND = "ChangeGroupTypeToAnd";


	
	public HyGroupChangeGroupTypeToAndTypeAction(DwGraphicalFeatureModelViewer editor) {
		super(editor);
		
		setId(CHANGE_GROUP_TYPE_TO_AND);
		setText("Change type to AND");
		
		request = new Request(REQ_CHANGE_GROUP_TYPE_TO_AND);
	}
	
	public HyGroupTypeEnum getNewGroupType(){
		return HyGroupTypeEnum.AND;
	}
}
