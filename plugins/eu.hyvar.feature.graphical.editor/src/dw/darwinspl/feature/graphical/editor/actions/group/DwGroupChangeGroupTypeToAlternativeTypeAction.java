package dw.darwinspl.feature.graphical.editor.actions.group;

import org.eclipse.gef.Request;

import dw.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.HyGroupTypeEnum;

public class DwGroupChangeGroupTypeToAlternativeTypeAction extends DwGroupChangeGroupTypeAction{
	public static final String CHANGE_GROUP_TYPE_TO_ALTERNATIVE = "ChangeGroupTypeToAlternative";
	public static final String REQ_CHANGE_GROUP_TYPE_TO_ALTERNATIVE= "ChangeGroupTypeToAlternative";

	

	
	public DwGroupChangeGroupTypeToAlternativeTypeAction(DwGraphicalFeatureModelViewer editor) {
		super(editor);
		
		setId(CHANGE_GROUP_TYPE_TO_ALTERNATIVE);
		setText("Change type to ALTERNATIVE");
		
		request = new Request(REQ_CHANGE_GROUP_TYPE_TO_ALTERNATIVE);
	}
	
	public HyGroupTypeEnum getNewGroupType(){
		return HyGroupTypeEnum.ALTERNATIVE;
	}
}
