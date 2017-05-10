/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.ui;

import org.eclipse.jface.action.IAction;

public class HymanifestOutlinePageExpandAllAction extends eu.hyvar.mspl.manifest.resource.hymanifest.ui.AbstractHymanifestOutlinePageAction {
	
	public HymanifestOutlinePageExpandAllAction(eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestOutlinePageTreeViewer treeViewer) {
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
