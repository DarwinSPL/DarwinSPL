/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui;

import org.eclipse.jface.action.IAction;

public class HyvalidityformulaOutlinePageLinkWithEditorAction extends eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.AbstractHyvalidityformulaOutlinePageAction {
	
	public HyvalidityformulaOutlinePageLinkWithEditorAction(eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
