/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.ui;

import org.eclipse.jface.action.IAction;

public class HymappingOutlinePageLexicalSortingAction extends eu.hyvar.feature.mapping.resource.hymapping.ui.AbstractHymappingOutlinePageAction {
	
	public HymappingOutlinePageLexicalSortingAction(eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Sort alphabetically", IAction.AS_CHECK_BOX);
		initialize("icons/sort_lexically_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setSortLexically(on);
		getTreeViewer().refresh();
	}
	
}
