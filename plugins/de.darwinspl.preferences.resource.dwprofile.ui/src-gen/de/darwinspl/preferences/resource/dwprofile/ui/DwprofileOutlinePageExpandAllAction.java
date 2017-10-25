/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.ui;

import org.eclipse.jface.action.IAction;

public class DwprofileOutlinePageExpandAllAction extends de.darwinspl.preferences.resource.dwprofile.ui.AbstractDwprofileOutlinePageAction {
	
	public DwprofileOutlinePageExpandAllAction(de.darwinspl.preferences.resource.dwprofile.ui.DwprofileOutlinePageTreeViewer treeViewer) {
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
