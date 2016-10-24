/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.expression.resource.hyexpression.ui;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.action.IAction;

public class HyexpressionOutlinePageActionProvider {
	
	public List<IAction> getActions(eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		List<IAction> defaultActions = new ArrayList<IAction>();
		defaultActions.add(new eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new eu.hyvar.feature.expression.resource.hyexpression.ui.HyexpressionOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
