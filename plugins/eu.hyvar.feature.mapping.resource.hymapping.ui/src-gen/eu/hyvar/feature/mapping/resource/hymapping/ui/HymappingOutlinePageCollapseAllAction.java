/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.ui;

import org.eclipse.jface.action.IAction;

public class HymappingOutlinePageCollapseAllAction extends eu.hyvar.feature.mapping.resource.hymapping.ui.AbstractHymappingOutlinePageAction {
	
	public HymappingOutlinePageCollapseAllAction(eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingOutlinePageTreeViewer treeViewer) {
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
