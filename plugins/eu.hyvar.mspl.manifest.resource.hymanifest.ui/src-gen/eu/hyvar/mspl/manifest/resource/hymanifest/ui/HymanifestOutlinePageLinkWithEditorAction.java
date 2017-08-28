/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.ui;

import org.eclipse.jface.action.IAction;

public class HymanifestOutlinePageLinkWithEditorAction extends eu.hyvar.mspl.manifest.resource.hymanifest.ui.AbstractHymanifestOutlinePageAction {
	
	public HymanifestOutlinePageLinkWithEditorAction(eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
