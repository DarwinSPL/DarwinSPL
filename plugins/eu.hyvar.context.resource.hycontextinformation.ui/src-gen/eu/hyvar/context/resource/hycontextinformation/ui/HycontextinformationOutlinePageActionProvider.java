/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.resource.hycontextinformation.ui;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.action.IAction;

public class HycontextinformationOutlinePageActionProvider {
	
	public List<IAction> getActions(eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		List<IAction> defaultActions = new ArrayList<IAction>();
		defaultActions.add(new eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new eu.hyvar.context.resource.hycontextinformation.ui.HycontextinformationOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
