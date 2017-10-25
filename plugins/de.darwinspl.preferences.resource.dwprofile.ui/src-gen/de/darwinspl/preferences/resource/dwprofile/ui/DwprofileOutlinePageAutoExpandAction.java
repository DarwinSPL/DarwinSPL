/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.ui;

import org.eclipse.jface.action.IAction;

public class DwprofileOutlinePageAutoExpandAction extends de.darwinspl.preferences.resource.dwprofile.ui.AbstractDwprofileOutlinePageAction {
	
	public DwprofileOutlinePageAutoExpandAction(de.darwinspl.preferences.resource.dwprofile.ui.DwprofileOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Auto expand", IAction.AS_CHECK_BOX);
		initialize("icons/auto_expand_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setAutoExpand(on);
		getTreeViewer().refresh();
	}
	
}
