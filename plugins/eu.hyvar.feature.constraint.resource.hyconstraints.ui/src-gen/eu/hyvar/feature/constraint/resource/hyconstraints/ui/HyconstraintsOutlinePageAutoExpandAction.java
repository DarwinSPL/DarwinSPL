/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.ui;

import org.eclipse.jface.action.IAction;

public class HyconstraintsOutlinePageAutoExpandAction extends eu.hyvar.feature.constraint.resource.hyconstraints.ui.AbstractHyconstraintsOutlinePageAction {
	
	public HyconstraintsOutlinePageAutoExpandAction(eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Auto expand", IAction.AS_CHECK_BOX);
		initialize("icons/auto_expand_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setAutoExpand(on);
		getTreeViewer().refresh();
	}
	
}
