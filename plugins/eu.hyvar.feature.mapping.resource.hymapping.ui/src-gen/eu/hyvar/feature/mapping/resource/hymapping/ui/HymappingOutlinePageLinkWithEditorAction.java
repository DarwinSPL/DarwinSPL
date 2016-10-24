/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.ui;

import org.eclipse.jface.action.IAction;

public class HymappingOutlinePageLinkWithEditorAction extends eu.hyvar.feature.mapping.resource.hymapping.ui.AbstractHymappingOutlinePageAction {
	
	public HymappingOutlinePageLinkWithEditorAction(eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
