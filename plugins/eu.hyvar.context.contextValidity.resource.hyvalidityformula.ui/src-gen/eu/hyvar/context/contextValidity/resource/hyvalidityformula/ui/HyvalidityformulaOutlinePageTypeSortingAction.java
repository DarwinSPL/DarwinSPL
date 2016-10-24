/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui;

import org.eclipse.jface.action.IAction;

public class HyvalidityformulaOutlinePageTypeSortingAction extends eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.AbstractHyvalidityformulaOutlinePageAction {
	
	public HyvalidityformulaOutlinePageTypeSortingAction(eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Group types", IAction.AS_CHECK_BOX);
		initialize("icons/group_types_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setGroupTypes(on);
		getTreeViewer().refresh();
	}
	
}
