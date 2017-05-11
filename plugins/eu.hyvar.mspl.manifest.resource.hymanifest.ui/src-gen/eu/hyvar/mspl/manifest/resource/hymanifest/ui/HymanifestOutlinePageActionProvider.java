/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.mspl.manifest.resource.hymanifest.ui;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.action.IAction;

public class HymanifestOutlinePageActionProvider {
	
	public List<IAction> getActions(eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		List<IAction> defaultActions = new ArrayList<IAction>();
		defaultActions.add(new eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new eu.hyvar.mspl.manifest.resource.hymanifest.ui.HymanifestOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
