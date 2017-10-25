/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.ui;

import org.eclipse.jface.action.IAction;

public class DwprofileOutlinePageCollapseAllAction extends de.darwinspl.preferences.resource.dwprofile.ui.AbstractDwprofileOutlinePageAction {
	
	public DwprofileOutlinePageCollapseAllAction(de.darwinspl.preferences.resource.dwprofile.ui.DwprofileOutlinePageTreeViewer treeViewer) {
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
