/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.ui;

import org.eclipse.jface.action.IAction;

public class HyconstraintsOutlinePageCollapseAllAction extends eu.hyvar.feature.constraint.resource.hyconstraints.ui.AbstractHyconstraintsOutlinePageAction {
	
	public HyconstraintsOutlinePageCollapseAllAction(eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsOutlinePageTreeViewer treeViewer) {
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
