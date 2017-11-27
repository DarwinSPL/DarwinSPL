/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.darwinspl.preferences.resource.dwprofile.ui;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.action.IAction;

public class DwprofileOutlinePageActionProvider {
	
	public List<IAction> getActions(de.darwinspl.preferences.resource.dwprofile.ui.DwprofileOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		List<IAction> defaultActions = new ArrayList<IAction>();
		defaultActions.add(new de.darwinspl.preferences.resource.dwprofile.ui.DwprofileOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new de.darwinspl.preferences.resource.dwprofile.ui.DwprofileOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new de.darwinspl.preferences.resource.dwprofile.ui.DwprofileOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new de.darwinspl.preferences.resource.dwprofile.ui.DwprofileOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new de.darwinspl.preferences.resource.dwprofile.ui.DwprofileOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new de.darwinspl.preferences.resource.dwprofile.ui.DwprofileOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
