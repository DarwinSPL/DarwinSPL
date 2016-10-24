/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.ui;

import org.eclipse.jface.action.IAction;

public class HyexpressionOutlinePageAutoExpandAction extends eu.hyvar.feature.expression.resource.hyexpression.ui.AbstractHyexpressionOutlinePageAction {
	
	public HyexpressionOutlinePageAutoExpandAction(eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Auto expand", IAction.AS_CHECK_BOX);
		initialize("icons/auto_expand_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setAutoExpand(on);
		getTreeViewer().refresh();
	}
	
}
