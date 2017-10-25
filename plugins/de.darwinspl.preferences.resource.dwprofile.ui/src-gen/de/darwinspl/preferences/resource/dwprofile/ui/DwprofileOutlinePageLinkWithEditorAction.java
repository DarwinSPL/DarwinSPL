/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.ui;

import org.eclipse.jface.action.IAction;

public class DwprofileOutlinePageLinkWithEditorAction extends de.darwinspl.preferences.resource.dwprofile.ui.AbstractDwprofileOutlinePageAction {
	
	public DwprofileOutlinePageLinkWithEditorAction(de.darwinspl.preferences.resource.dwprofile.ui.DwprofileOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
