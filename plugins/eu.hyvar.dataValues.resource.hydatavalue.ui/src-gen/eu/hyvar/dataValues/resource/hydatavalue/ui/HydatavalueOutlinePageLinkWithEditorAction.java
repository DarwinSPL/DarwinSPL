/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.ui;

import org.eclipse.jface.action.IAction;

public class HydatavalueOutlinePageLinkWithEditorAction extends eu.hyvar.dataValues.resource.hydatavalue.ui.AbstractHydatavalueOutlinePageAction {
	
	public HydatavalueOutlinePageLinkWithEditorAction(eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
