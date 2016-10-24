/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.ui;

import org.eclipse.jface.action.IAction;

public class HycontextinformationOutlinePageAutoExpandAction extends eu.hyvar.context.resource.hycontextinformation.ui.AbstractHycontextinformationOutlinePageAction {
	
	public HycontextinformationOutlinePageAutoExpandAction(eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Auto expand", IAction.AS_CHECK_BOX);
		initialize("icons/auto_expand_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setAutoExpand(on);
		getTreeViewer().refresh();
	}
	
}
