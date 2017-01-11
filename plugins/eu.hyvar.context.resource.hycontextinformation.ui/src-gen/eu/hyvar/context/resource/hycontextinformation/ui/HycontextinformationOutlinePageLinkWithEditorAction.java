/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.ui;

import org.eclipse.jface.action.IAction;

public class HycontextinformationOutlinePageLinkWithEditorAction extends eu.hyvar.context.resource.hycontextinformation.ui.AbstractHycontextinformationOutlinePageAction {
	
	public HycontextinformationOutlinePageLinkWithEditorAction(eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
