/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui;

import org.eclipse.jface.action.IAction;

public class HyvalidityformulaOutlinePageExpandAllAction extends eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.AbstractHyvalidityformulaOutlinePageAction {
	
	public HyvalidityformulaOutlinePageExpandAllAction(eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Expand all", IAction.AS_PUSH_BUTTON);
		initialize("icons/expand_all_icon.gif");
	}
	
	public void runInternal(boolean on) {
		if (on) {
			getTreeViewer().expandAll();
		}
	}
	
	public boolean keepState() {
		return false;
	}
	
}
