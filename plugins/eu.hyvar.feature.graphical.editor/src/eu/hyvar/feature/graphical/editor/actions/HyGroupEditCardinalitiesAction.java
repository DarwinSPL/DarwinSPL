package eu.hyvar.feature.graphical.editor.actions;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;

import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.graphical.base.editparts.HyGroupEditPart;
import eu.hyvar.feature.graphical.base.editparts.HyParentChildConnectionEditPart;
import eu.hyvar.feature.graphical.base.model.HyEditorChangeableElement;
import eu.hyvar.feature.graphical.base.model.HyGroupWrapped;
import eu.hyvar.feature.graphical.base.model.HyParentChildConnection;
import eu.hyvar.feature.graphical.editor.dialogs.HyGroupTypeDialog;
import eu.hyvar.feature.graphical.editor.editor.GraphicalEvolutionFeatureModelEditor;


public class HyGroupEditCardinalitiesAction extends SelectionAction{
	public static final String GROUP_EDIT_CARDINALITIES = "EditGroupCardinalities";
	public static final String REQ_GROUP_EDIT_CARDINALITIES = "EditGroupCardinalities";

	Request request;
	
	public HyGroupEditCardinalitiesAction(IWorkbenchPart part){
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
		
		GraphicalEvolutionFeatureModelEditor editor = (GraphicalEvolutionFeatureModelEditor)this.getWorkbenchPart();

		
		EList<HyGroupType> types = null;
		HyEditorChangeableElement element = null;
		
		if(selectedObject instanceof HyParentChildConnectionEditPart){
			HyParentChildConnectionEditPart part = (HyParentChildConnectionEditPart)selectedObject;
			HyParentChildConnection	 model = (HyParentChildConnection)part.getModel();
			
			types = model.getTarget().getParentGroup(editor.getCurrentSelectedDate()).getGroup().getTypes();
			element = model.getTarget().getParentGroup(editor.getCurrentSelectedDate());
		}else if(selectedObject instanceof HyGroupEditPart){
			HyGroupEditPart editPart = (HyGroupEditPart)selectedObject;
			element = ((HyGroupWrapped)editPart.getModel());
			types = ((HyGroup)element.getWrappedModelElement()).getTypes();
		}
		
		
		EList<EObject> items = new BasicEList<EObject>();
		for(int i=0; i<types.size(); i++){
			HyGroupType type = types.get(i);
			items.add(type);
		}		
		
		HyGroupTypeDialog dialog = new HyGroupTypeDialog(shell);
		dialog.setItems(items);
		
		
		dialog.setElement(element);
		dialog.open();	
	}

	@Override
	protected boolean calculateEnabled() {
		if(getSelectedObjects().isEmpty())
			return false;
		
		for(Object selectedObject : getSelectedObjects()){
			if(!((selectedObject instanceof HyParentChildConnectionEditPart) || 
				 (selectedObject instanceof HyGroupEditPart))){
				return false;
			}
		}
		
		return true;
	}	
}