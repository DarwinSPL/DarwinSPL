/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.ui;

import org.eclipse.jface.action.IAction;

public class HydatavalueOutlinePageExpandAllAction extends eu.hyvar.dataValues.resource.hydatavalue.ui.AbstractHydatavalueOutlinePageAction {
	
	public HydatavalueOutlinePageExpandAllAction(eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueOutlinePageTreeViewer treeViewer) {
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
