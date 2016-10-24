/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.ui;

import org.eclipse.jface.action.IAction;

public class HyexpressionOutlinePageLinkWithEditorAction extends eu.hyvar.feature.expression.resource.hyexpression.ui.AbstractHyexpressionOutlinePageAction {
	
	public HyexpressionOutlinePageLinkWithEditorAction(eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
