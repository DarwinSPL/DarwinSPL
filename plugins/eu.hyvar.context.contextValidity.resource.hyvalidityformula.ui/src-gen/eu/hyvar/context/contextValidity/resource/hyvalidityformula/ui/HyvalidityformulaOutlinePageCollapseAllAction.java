/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui;

import org.eclipse.jface.action.IAction;

public class HyvalidityformulaOutlinePageCollapseAllAction extends eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.AbstractHyvalidityformulaOutlinePageAction {
	
	public HyvalidityformulaOutlinePageCollapseAllAction(eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Collapse all", IAction.AS_PUSH_BUTTON);
		initialize("icons/collapse_all_icon.gif");
	}
	
	public void runInternal(boolean on) {
		if (on) {
			getTreeViewer().collapseAll();
		}
	}
	
	public boolean keepState() {
		return false;
	}
	
}
