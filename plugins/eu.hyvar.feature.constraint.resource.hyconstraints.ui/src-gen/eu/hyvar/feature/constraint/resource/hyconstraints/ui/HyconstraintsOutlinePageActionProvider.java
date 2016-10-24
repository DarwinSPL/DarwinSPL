/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.constraint.resource.hyconstraints.ui;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.action.IAction;

public class HyconstraintsOutlinePageActionProvider {
	
	public List<IAction> getActions(eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		List<IAction> defaultActions = new ArrayList<IAction>();
		defaultActions.add(new eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
