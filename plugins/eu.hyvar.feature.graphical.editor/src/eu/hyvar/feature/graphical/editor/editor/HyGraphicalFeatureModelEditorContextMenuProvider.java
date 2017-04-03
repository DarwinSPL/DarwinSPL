package eu.hyvar.feature.graphical.editor.editor;

import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.actions.ActionFactory;

import eu.hyvar.feature.graphical.editor.actions.HyLinearTemporalElementChangeValidityAction;
import eu.hyvar.feature.graphical.editor.actions.attribute.HyAttributeCreateBooleanAction;
import eu.hyvar.feature.graphical.editor.actions.attribute.HyAttributeCreateEnumAction;
import eu.hyvar.feature.graphical.editor.actions.attribute.HyAttributeCreateNumberAction;
import eu.hyvar.feature.graphical.editor.actions.attribute.HyAttributeCreateStringAction;
import eu.hyvar.feature.graphical.editor.actions.attribute.HyAttributeRenameAction;
import eu.hyvar.feature.graphical.editor.actions.attribute.HyNumberAttributeSetNumberRangeAction;
import eu.hyvar.feature.graphical.editor.actions.enumeration.HyFeatureAttributeEnumCreateEnumAction;
import eu.hyvar.feature.graphical.editor.actions.enumeration.HyFeatureAttributeEnumCreateLiteralAction;
import eu.hyvar.feature.graphical.editor.actions.feature.DwSetFeatureLinkAction;
import eu.hyvar.feature.graphical.editor.actions.feature.HyFeatureChangeTypeAction;
import eu.hyvar.feature.graphical.editor.actions.feature.HyFeatureCreateSiblingAction;
import eu.hyvar.feature.graphical.editor.actions.feature.HyFeatureEditNamesAction;
import eu.hyvar.feature.graphical.editor.actions.feature.HyFeatureEvolutionCreateChildAction;
import eu.hyvar.feature.graphical.editor.actions.group.HyGroupChangeGroupTypeToAlternativeTypeAction;
import eu.hyvar.feature.graphical.editor.actions.group.HyGroupChangeGroupTypeToAndTypeAction;
import eu.hyvar.feature.graphical.editor.actions.group.HyGroupChangeGroupTypeToOrTypeAction;
import eu.hyvar.feature.graphical.editor.actions.version.HyVersionCreateSuccessorAction;
import eu.hyvar.feature.graphical.editor.actions.version.HyVersionCreateVersionAction;

public class HyGraphicalFeatureModelEditorContextMenuProvider extends ContextMenuProvider	{
	private ActionRegistry actionRegistry;

	public HyGraphicalFeatureModelEditorContextMenuProvider(EditPartViewer viewer, final ActionRegistry actionRegistry) {
		super(viewer);

		setActionRegistry(actionRegistry);
	}

	@Override
	public void buildContextMenu(IMenuManager menu) {
		GEFActionConstants.addStandardActionGroups(menu);
		
        IAction action;
        
        // Basic operations: undo, redo, delete
        action = getActionRegistry().getAction(ActionFactory.UNDO.getId());
        menu.appendToGroup(GEFActionConstants.GROUP_UNDO, action);
        action = getActionRegistry().getAction(ActionFactory.REDO.getId());
        menu.appendToGroup(GEFActionConstants.GROUP_UNDO, action);
        action = getActionRegistry().getAction(ActionFactory.DELETE.getId());
        menu.appendToGroup(GEFActionConstants.GROUP_UNDO, action);
        
 
        // Feature actions: create child, create sibling
        action = getActionRegistry().getAction(HyFeatureEvolutionCreateChildAction.FEATURE_EVOLUTION_CREATE_CHILD);
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
        action = getActionRegistry().getAction(HyFeatureCreateSiblingAction.FEATURE_CREATE_SIBLING);
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);       
        action = getActionRegistry().getAction(HyFeatureEditNamesAction.FEATURE_EDIT_NAMES);
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);      
        action = getActionRegistry().getAction(HyFeatureChangeTypeAction.FEATURE_CHANGE_TYPE);
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);      
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, new Separator());
        
        

        action = getActionRegistry().getAction(HyGroupChangeGroupTypeToAlternativeTypeAction.CHANGE_GROUP_TYPE_TO_ALTERNATIVE);
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
        action = getActionRegistry().getAction(HyGroupChangeGroupTypeToAndTypeAction.CHANGE_GROUP_TYPE_TO_AND);
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
        action = getActionRegistry().getAction(HyGroupChangeGroupTypeToOrTypeAction.CHANGE_GROUP_TYPE_TO_OR);
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
        
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, new Separator());
        
        action = getActionRegistry().getAction(HyLinearTemporalElementChangeValidityAction.FEATURE_CHANGE_VALIDITY);
        
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, new Separator());
        action = getActionRegistry().getAction(HyVersionCreateVersionAction.FEATURE_ADD_VERSION);
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
        action = getActionRegistry().getAction(HyVersionCreateSuccessorAction.FEATURE_CREATE_SUCCESSOR_VERSION);
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);         
        
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, new Separator());
        action = getActionRegistry().getAction(HyAttributeCreateNumberAction.FEATURE_ADD_NUMBER_ATTRIBUTE);     
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
        action = getActionRegistry().getAction(HyAttributeCreateBooleanAction.FEATURE_ADD_BOOLEAN_ATTRIBUTE);     
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
        action = getActionRegistry().getAction(HyAttributeCreateStringAction.FEATURE_ADD_STRING_ATTRIBUTE);     
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);      
        action = getActionRegistry().getAction(HyAttributeCreateEnumAction.FEATURE_ADD_ENUM_ATTRIBUTE);     
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);    


        action = getActionRegistry().getAction(HyAttributeRenameAction.ATTRIBUTE_EDIT_NAMES);
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
        
        action = getActionRegistry().getAction(HyNumberAttributeSetNumberRangeAction.ATTRIBUTE_EDIT_MIN_AND_MAX);     
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);    
        
        action = getActionRegistry().getAction(HyFeatureAttributeEnumCreateLiteralAction.ATTRIBUTE_CREATE_LITERAL);
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
        
        action = getActionRegistry().getAction(HyFeatureAttributeEnumCreateEnumAction.ATTRIBUTE_CREATE_ENUM);
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
        
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, new Separator());
        action = getActionRegistry().getAction(HyLinearTemporalElementChangeValidityAction.FEATURE_CHANGE_VALIDITY);
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
        
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, new Separator());
        action = getActionRegistry().getAction(DwSetFeatureLinkAction.ID);
        menu.appendToGroup(GEFActionConstants.GROUP_EDIT, action);
	}
	
	public ActionRegistry getActionRegistry() {
		return actionRegistry;
	}
	public void setActionRegistry(ActionRegistry actionRegistry) {
		this.actionRegistry = actionRegistry;
	}

}
