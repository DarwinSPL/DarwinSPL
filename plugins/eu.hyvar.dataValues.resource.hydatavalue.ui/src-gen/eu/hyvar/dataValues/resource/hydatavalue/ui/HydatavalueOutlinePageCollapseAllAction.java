/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.ui;

import org.eclipse.jface.action.IAction;

public class HydatavalueOutlinePageCollapseAllAction extends eu.hyvar.dataValues.resource.hydatavalue.ui.AbstractHydatavalueOutlinePageAction {
	
	public HydatavalueOutlinePageCollapseAllAction(eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueOutlinePageTreeViewer treeViewer) {
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
