/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.ui;

import org.eclipse.jface.action.IAction;

public class HycontextinformationOutlinePageExpandAllAction extends eu.hyvar.context.resource.hycontextinformation.ui.AbstractHycontextinformationOutlinePageAction {
	
	public HycontextinformationOutlinePageExpandAllAction(eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationOutlinePageTreeViewer treeViewer) {
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
