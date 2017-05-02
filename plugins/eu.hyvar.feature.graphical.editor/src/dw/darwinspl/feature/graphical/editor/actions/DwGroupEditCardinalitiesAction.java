package dw.darwinspl.feature.graphical.editor.actions;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;

import dw.darwinspl.feature.graphical.base.editparts.DwGroupEditPart;
import dw.darwinspl.feature.graphical.base.editparts.DwParentChildConnectionEditPart;
import dw.darwinspl.feature.graphical.base.model.DwEditorChangeableElement;
import dw.darwinspl.feature.graphical.base.model.DwGroupWrapped;
import dw.darwinspl.feature.graphical.base.model.DwParentChildConnection;
import dw.darwinspl.feature.graphical.editor.dialogs.DwGroupTypeDialog;
import dw.darwinspl.feature.graphical.editor.editor.DwGraphicalFeatureModelEditor;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupType;

// TODO not needed any longer
public class DwGroupEditCardinalitiesAction extends SelectionAction{
	public static final String GROUP_EDIT_CARDINALITIES = "EditGroupCardinalities";
	public static final String REQ_GROUP_EDIT_CARDINALITIES = "EditGroupCardinalities";

	Request request;
	
	public DwGroupEditCardinalitiesAction(IWorkbenchPart part){
		super(part);
		
		setId(GROUP_EDIT_CARDINALITIES);
		setText("Edit Group Cardinalities");
		
		request = new Request(REQ_GROUP_EDIT_CARDINALITIES);
	}
	
	@Override
	public void run(){
		Shell shell = this.getWorkbenchPart().getSite().getShell();
		
		StructuredSelection selection = (StructuredSelection)this.getSelection();
		Object selectedObject = selection.getFirstElement();
		
		DwGraphicalFeatureModelEditor editor = (DwGraphicalFeatureModelEditor)this.getWorkbenchPart();

		
		EList<HyGroupType> types = null;
		DwEditorChangeableElement element = null;
		
		if(selectedObject instanceof DwParentChildConnectionEditPart){
			DwParentChildConnectionEditPart part = (DwParentChildConnectionEditPart)selectedObject;
			DwParentChildConnection	 model = (DwParentChildConnection)part.getModel();
			
			types = model.getTarget().getParentGroup(editor.getCurrentSelectedDate()).getWrappedModelElement().getTypes();
			element = model.getTarget().getParentGroup(editor.getCurrentSelectedDate());
		}else if(selectedObject instanceof DwGroupEditPart){
			DwGroupEditPart editPart = (DwGroupEditPart)selectedObject;
			element = ((DwGroupWrapped)editPart.getModel());
			types = ((HyGroup)element.getWrappedModelElement()).getTypes();
		}
		
		
		EList<EObject> items = new BasicEList<EObject>();
		for(int i=0; i<types.size(); i++){
			HyGroupType type = types.get(i);
			items.add(type);
		}		
		
		DwGroupTypeDialog dialog = new DwGroupTypeDialog(shell);
		dialog.setItems(items);
		
		
		dialog.setElement(element);
		dialog.open();	
	}

	@Override
	protected boolean calculateEnabled() {
		if(getSelectedObjects().isEmpty())
			return false;
		
		for(Object selectedObject : getSelectedObjects()){
			if(!((selectedObject instanceof DwParentChildConnectionEditPart) || 
				 (selectedObject instanceof DwGroupEditPart))){
				return false;
			}
		}
		
		return true;
	}	
}