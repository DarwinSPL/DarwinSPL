package eu.hyvar.feature.graphical.editor.actions;

import org.eclipse.gef.Request;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;

import eu.hyvar.evolution.HyTemporalElement;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.graphical.base.editparts.HyAttributeEditPart;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureEditPart;
import eu.hyvar.feature.graphical.base.editparts.HyGroupEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyGroupWrapped;
import eu.hyvar.feature.graphical.editor.dialogs.ValidityDialog;
import eu.hyvar.feature.graphical.editor.editparts.HyVersionEditorEditPart;

public class HyLinearTemporalElementChangeValidityAction extends SelectionAction{
	public static final String FEATURE_CHANGE_VALIDITY = "FeatureChangeValidity";
	public static final String REQ_FEATURE_CHANGE_VALIDITY = "FeatureChangeValidity";

	Request request;

	public HyLinearTemporalElementChangeValidityAction(IWorkbenchPart part){
		super(part);

		setId(FEATURE_CHANGE_VALIDITY);
		setText("Change Element Validity");

		request = new Request(REQ_FEATURE_CHANGE_VALIDITY);
	}

	@Override
	public void run(){
		Shell shell = this.getWorkbenchPart().getSite().getShell();

		StructuredSelection selection = (StructuredSelection)this.getSelection();
		Object selectedElement = selection.getFirstElement();
		HyTemporalElement model = null;
		if(selectedElement instanceof HyFeatureEditPart){
			HyFeatureEditPart editPart = (HyFeatureEditPart)selectedElement;
			model = (HyTemporalElement)((HyFeatureWrapped)editPart.getModel()).getWrappedModelElement();
		}
		if(selectedElement instanceof HyGroupEditPart){
			HyGroupEditPart editPart = (HyGroupEditPart)selectedElement;
			model = (HyTemporalElement)((HyGroupWrapped)editPart.getModel()).getWrappedModelElement();
		}
		if(selectedElement instanceof HyVersionEditorEditPart){
			HyVersionEditorEditPart editPart = (HyVersionEditorEditPart)selectedElement;
			model = (HyTemporalElement)((HyVersion)editPart.getModel());
		}
		if(selectedElement instanceof HyAttributeEditPart){
			HyAttributeEditPart editPart = (HyAttributeEditPart)selectedElement;
			model = (HyTemporalElement)((HyFeatureAttribute)editPart.getModel());			
		}
		ValidityDialog dialog = new ValidityDialog(shell);
		dialog.setElement(model);
		dialog.open();
	}

	@Override
	protected boolean calculateEnabled() {
		if(getSelectedObjects().isEmpty())
			return false;

		for(Object selectedObject : getSelectedObjects()){
			if(!((selectedObject instanceof HyFeatureEditPart) || 
				 (selectedObject instanceof HyGroupEditPart) ||
				 (selectedObject instanceof HyAttributeEditPart) || 
				 (selectedObject instanceof HyVersionEditorEditPart))){
				return false;
			}
		}

		return true;
	}	
}
