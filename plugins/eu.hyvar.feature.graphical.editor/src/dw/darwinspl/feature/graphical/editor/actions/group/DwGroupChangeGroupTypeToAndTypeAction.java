package dw.darwinspl.feature.graphical.editor.actions.group;

import org.eclipse.gef.Request;

import dw.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.HyGroupTypeEnum;

public class DwGroupChangeGroupTypeToAndTypeAction extends DwGroupChangeGroupTypeAction {
	public static final String CHANGE_GROUP_TYPE_TO_AND = "ChangeGroupTypeToAnd";
	public static final String REQ_CHANGE_GROUP_TYPE_TO_AND = "ChangeGroupTypeToAnd";


	
	public DwGroupChangeGroupTypeToAndTypeAction(DwGraphicalFeatureModelViewer editor) {
		super(editor);
		
		setId(CHANGE_GROUP_TYPE_TO_AND);
		setText("Change type to AND");
		
		request = new Request(REQ_CHANGE_GROUP_TYPE_TO_AND);
	}
	
	public HyGroupTypeEnum getNewGroupType(){
		return HyGroupTypeEnum.AND;
	}
}
