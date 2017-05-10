/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.ui;

import org.eclipse.jface.action.IAction;

public class HymanifestOutlinePageCollapseAllAction extends eu.hyvar.mspl.manifest.resource.hymanifest.ui.AbstractHymanifestOutlinePageAction {
	
	public HymanifestOutlinePageCollapseAllAction(eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestOutlinePageTreeViewer treeViewer) {
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
