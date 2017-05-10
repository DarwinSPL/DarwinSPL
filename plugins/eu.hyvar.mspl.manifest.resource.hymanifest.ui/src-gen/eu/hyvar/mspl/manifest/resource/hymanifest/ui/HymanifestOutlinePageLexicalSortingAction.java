/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.ui;

import org.eclipse.jface.action.IAction;

public class HymanifestOutlinePageLexicalSortingAction extends eu.hyvar.mspl.manifest.resource.hymanifest.ui.AbstractHymanifestOutlinePageAction {
	
	public HymanifestOutlinePageLexicalSortingAction(eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Sort alphabetically", IAction.AS_CHECK_BOX);
		initialize("icons/sort_lexically_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setSortLexically(on);
		getTreeViewer().refresh();
	}
	
}
