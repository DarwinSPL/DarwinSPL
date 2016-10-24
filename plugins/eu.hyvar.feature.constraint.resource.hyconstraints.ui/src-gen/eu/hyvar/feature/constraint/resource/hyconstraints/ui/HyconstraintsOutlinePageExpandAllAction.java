/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.ui;

import org.eclipse.jface.action.IAction;

public class HyconstraintsOutlinePageExpandAllAction extends eu.hyvar.feature.constraint.resource.hyconstraints.ui.AbstractHyconstraintsOutlinePageAction {
	
	public HyconstraintsOutlinePageExpandAllAction(eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsOutlinePageTreeViewer treeViewer) {
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
