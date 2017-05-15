package de.darwinspl.feature.graphical.editor.actions;

import org.eclipse.gef.Request;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;

import de.darwinspl.feature.graphical.base.editparts.DwAttributeEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwEnumEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwEnumLiteralEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwFeatureEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwGroupEditPart;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.base.model.DwGroupWrapped;
import de.darwinspl.feature.graphical.editor.dialogs.DwValidityDialog;
import de.darwinspl.feature.graphical.editor.editparts.DwVersionEditorEditPart;
import eu.hyvar.evolution.HyTemporalElement;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyVersion;

public class DwLinearTemporalElementChangeValidityAction extends SelectionAction{
	public static final String FEATURE_CHANGE_VALIDITY = "FeatureChangeValidity";
	public static final String REQ_FEATURE_CHANGE_VALIDITY = "FeatureChangeValidity";

	Request request;

	public DwLinearTemporalElementChangeValidityAction(IWorkbenchPart part){
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
		
		if(selectedElement instanceof DwFeatureEditPart){
			DwFeatureEditPart editPart = (DwFeatureEditPart)selectedElement;
			model = (HyTemporalElement)((DwFeatureWrapped)editPart.getModel()).getWrappedModelElement();
		}
		if(selectedElement instanceof DwGroupEditPart){
			DwGroupEditPart editPart = (DwGroupEditPart)selectedElement;
			model = (HyTemporalElement)((DwGroupWrapped)editPart.getModel()).getWrappedModelElement();
		}
		if(selectedElement instanceof DwVersionEditorEditPart){
			DwVersionEditorEditPart editPart = (DwVersionEditorEditPart)selectedElement;
			model = (HyTemporalElement)((HyVersion)editPart.getModel());
		}
		if(selectedElement instanceof DwAttributeEditPart){
			DwAttributeEditPart editPart = (DwAttributeEditPart)selectedElement;
			model = (HyTemporalElement)((HyFeatureAttribute)editPart.getModel());			
		}
		if(selectedElement instanceof DwEnumEditPart){
			DwEnumEditPart editPart = (DwEnumEditPart)selectedElement;
			model = (HyTemporalElement)editPart.getModel();
		}
		if(selectedElement instanceof DwEnumLiteralEditPart){
			DwEnumLiteralEditPart editPart = (DwEnumLiteralEditPart)selectedElement;
			model = (HyTemporalElement)editPart.getModel();
		}
		
		DwValidityDialog dialog = new DwValidityDialog(shell);
		dialog.setElement(model);
		dialog.open();
	}

	@Override
	protected boolean calculateEnabled() {
		if(getSelectedObjects().isEmpty())
			return false;

		for(Object selectedObject : getSelectedObjects()){
			if(!((selectedObject instanceof DwFeatureEditPart) 			|| 
				 (selectedObject instanceof DwGroupEditPart) 	 		||
				 (selectedObject instanceof DwAttributeEditPart) 		|| 
				 (selectedObject instanceof DwVersionEditorEditPart)	||
				 (selectedObject instanceof DwEnumEditPart)				||
				 (selectedObject instanceof DwEnumLiteralEditPart))){
				return false;
			}
		}

		return true;
	}	
}
