/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui;

import org.eclipse.jface.action.IAction;

public class HyvalidityformulaOutlinePageLexicalSortingAction extends eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.AbstractHyvalidityformulaOutlinePageAction {
	
	public HyvalidityformulaOutlinePageLexicalSortingAction(eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Sort alphabetically", IAction.AS_CHECK_BOX);
		initialize("icons/sort_lexically_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setSortLexically(on);
		getTreeViewer().refresh();
	}
	
}
