/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.ui;

import org.eclipse.jface.action.IAction;

public class HycontextinformationOutlinePageLexicalSortingAction extends eu.hyvar.context.resource.hycontextinformation.ui.AbstractHycontextinformationOutlinePageAction {
	
	public HycontextinformationOutlinePageLexicalSortingAction(eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Sort alphabetically", IAction.AS_CHECK_BOX);
		initialize("icons/sort_lexically_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setSortLexically(on);
		getTreeViewer().refresh();
	}
	
}
