package de.darwinspl.feature.graphical.editor.actions.group;

import org.eclipse.gef.Request;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.HyGroupTypeEnum;

public class DwGroupChangeGroupTypeToOrTypeAction extends DwGroupChangeGroupTypeAction {
	public static final String CHANGE_GROUP_TYPE_TO_OR = "ChangeGroupTypeToOr";
	public static final String REQ_CHANGE_GROUP_TYPE_TO_OR= "ChangeGroupTypeToOr";


	
	public DwGroupChangeGroupTypeToOrTypeAction(DwGraphicalFeatureModelViewer editor) {
		super(editor);
		
		setId(CHANGE_GROUP_TYPE_TO_OR);
		setText("Change type to OR");
		
		request = new Request(REQ_CHANGE_GROUP_TYPE_TO_OR);
	}
	
	public HyGroupTypeEnum getNewGroupType(){
		return HyGroupTypeEnum.OR;
	}
}
