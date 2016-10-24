/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.action.IAction;

public class HyvalidityformulaOutlinePageActionProvider {
	
	public List<IAction> getActions(eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		List<IAction> defaultActions = new ArrayList<IAction>();
		defaultActions.add(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new eu.hyvar.context.contextValidity.resource.hyvalidityformula.ui.HyvalidityformulaOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
