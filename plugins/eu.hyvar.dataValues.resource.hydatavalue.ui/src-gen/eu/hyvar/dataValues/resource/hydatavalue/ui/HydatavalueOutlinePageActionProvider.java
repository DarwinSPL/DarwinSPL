/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package eu.hyvar.dataValues.resource.hydatavalue.ui;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.action.IAction;

public class HydatavalueOutlinePageActionProvider {
	
	public List<IAction> getActions(eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		List<IAction> defaultActions = new ArrayList<IAction>();
		defaultActions.add(new eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new eu.hyvar.dataValues.resource.hydatavalue.ui.HydatavalueOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
