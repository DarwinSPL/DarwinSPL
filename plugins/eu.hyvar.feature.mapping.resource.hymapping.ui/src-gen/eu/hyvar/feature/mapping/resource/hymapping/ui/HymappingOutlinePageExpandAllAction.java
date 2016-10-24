/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.ui;

import org.eclipse.jface.action.IAction;

public class HymappingOutlinePageExpandAllAction extends eu.hyvar.feature.mapping.resource.hymapping.ui.AbstractHymappingOutlinePageAction {
	
	public HymappingOutlinePageExpandAllAction(eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingOutlinePageTreeViewer treeViewer) {
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
