/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.ui;

import org.eclipse.jface.action.IAction;

public class HyconstraintsOutlinePageLexicalSortingAction extends eu.hyvar.feature.constraint.resource.hyconstraints.ui.AbstractHyconstraintsOutlinePageAction {
	
	public HyconstraintsOutlinePageLexicalSortingAction(eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Sort alphabetically", IAction.AS_CHECK_BOX);
		initialize("icons/sort_lexically_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setSortLexically(on);
		getTreeViewer().refresh();
	}
	
}
