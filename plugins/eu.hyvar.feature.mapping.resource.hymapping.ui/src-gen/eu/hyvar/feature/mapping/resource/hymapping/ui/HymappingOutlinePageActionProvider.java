/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.feature.mapping.resource.hymapping.ui;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.action.IAction;

public class HymappingOutlinePageActionProvider {
	
	public List<IAction> getActions(eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		List<IAction> defaultActions = new ArrayList<IAction>();
		defaultActions.add(new eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new eu.hyvar.feature.mapping.resource.hymapping.ui.HymappingOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
