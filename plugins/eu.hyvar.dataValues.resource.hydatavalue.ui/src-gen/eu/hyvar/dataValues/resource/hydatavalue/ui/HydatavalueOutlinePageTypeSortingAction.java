/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.ui;

import org.eclipse.jface.action.IAction;

public class HydatavalueOutlinePageTypeSortingAction extends eu.hyvar.dataValues.resource.hydatavalue.ui.AbstractHydatavalueOutlinePageAction {
	
	public HydatavalueOutlinePageTypeSortingAction(eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Group types", IAction.AS_CHECK_BOX);
		initialize("icons/group_types_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setGroupTypes(on);
		getTreeViewer().refresh();
	}
	
}
