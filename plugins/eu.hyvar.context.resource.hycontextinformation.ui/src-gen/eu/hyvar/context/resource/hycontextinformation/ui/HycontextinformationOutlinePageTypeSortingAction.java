/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.ui;

import org.eclipse.jface.action.IAction;

public class HycontextinformationOutlinePageTypeSortingAction extends eu.hyvar.context.resource.hycontextinformation.ui.AbstractHycontextinformationOutlinePageAction {
	
	public HycontextinformationOutlinePageTypeSortingAction(eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Group types", IAction.AS_CHECK_BOX);
		initialize("icons/group_types_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setGroupTypes(on);
		getTreeViewer().refresh();
	}
	
}
