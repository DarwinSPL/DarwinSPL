/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.ui;

import org.eclipse.jface.action.IAction;

public class HyconstraintsOutlinePageLinkWithEditorAction extends eu.hyvar.feature.constraint.resource.hyconstraints.ui.AbstractHyconstraintsOutlinePageAction {
	
	public HyconstraintsOutlinePageLinkWithEditorAction(eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
