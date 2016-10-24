/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.ui;

import org.eclipse.jface.action.IAction;

public class HyexpressionOutlinePageLexicalSortingAction extends eu.hyvar.feature.expression.resource.hyexpression.ui.AbstractHyexpressionOutlinePageAction {
	
	public HyexpressionOutlinePageLexicalSortingAction(eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Sort alphabetically", IAction.AS_CHECK_BOX);
		initialize("icons/sort_lexically_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setSortLexically(on);
		getTreeViewer().refresh();
	}
	
}
