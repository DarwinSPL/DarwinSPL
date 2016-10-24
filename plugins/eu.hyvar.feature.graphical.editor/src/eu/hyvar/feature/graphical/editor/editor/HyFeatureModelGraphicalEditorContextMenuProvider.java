package eu.hyvar.feature.graphical.editor.editor;

import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.actions.ActionFactory;

import eu.hyvar.feature.graphical.editor.actions.HyGroupEditCardinalitiesAction;
import eu.hyvar.feature.graphical.editor.actions.attribute.HyAttributeRenameAction;
import eu.hyvar.feature.graphical.editor.actions.feature.HyFeatureCreateChildAction;
import eu.hyvar.feature.graphical.editor.actions.feature.HyFeatureCreateSiblingAction;
import eu.hyvar.feature.graphical.editor.actions.feature.HyFeatureEditCardinalitiesAction;
import eu.hyvar.feature.graphical.editor.actions.feature.HyFeatureEditNamesAction;

public class HyFeatureModelGraphicalEditorContextMenuProvider extends ContextMenuProvider {
	private ActionRegistry actionRegistry;

	public HyFeatureModelGraphicalEditorContextMenuProvider(EditPartViewer viewer, final ActionRegistry actionRegistry) {
		super(viewer);

		setActionRegistry(actionRegistry);
	}

	@Override
	public void buildContextMenu(IMenuManager menu) {
		GEFActionConstants.addStandardActionGroups(menu);
		
        IAction action;
        
        action = getActionRegistry().getAction(ActionFactory.UNDO.getId());
        menu.appendToGroup(GEFActionConstants.GROUP_UNDO, action);
        action = getActionRegistry().getAction(ActionFactory.REDO.getId());
        menu.appendToGroup(GEFActionConstants.GROUP_UNDO, action);
        action = getActionRegistry().getAction(HyFeatureCreateChildAction.FEATURE_CREATE_CHILD);
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
        action = getActionRegistry().getAction(HyFeatureCreateSiblingAction.FEATURE_CREATE_SIBLING);
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
        action = getActionRegistry().getAction(HyFeatureEditCardinalitiesAction.FEATURE_EDIT_CARDINALITIES);
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
        action = getActionRegistry().getAction(HyFeatureEditNamesAction.FEATURE_EDIT_NAMES);
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);      
        action = getActionRegistry().getAction(HyGroupEditCardinalitiesAction.GROUP_EDIT_CARDINALITIES);
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, new Separator());
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);        
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, new Separator());     
        action = getActionRegistry().getAction(HyAttributeRenameAction.ATTRIBUTE_EDIT_NAMES);
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
	}

	public ActionRegistry getActionRegistry() {
		return actionRegistry;
	}
	public void setActionRegistry(ActionRegistry actionRegistry) {
		this.actionRegistry = actionRegistry;
	}

}
