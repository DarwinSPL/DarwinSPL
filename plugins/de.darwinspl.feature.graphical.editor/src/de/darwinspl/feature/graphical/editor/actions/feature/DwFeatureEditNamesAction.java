package de.darwinspl.feature.graphical.editor.actions.feature;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwFeatureEditPart;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.editor.dialogs.DwNameDialog;
import eu.hyvar.evolution.HyName;

public class DwFeatureEditNamesAction extends SelectionAction{
	public static final String FEATURE_EDIT_NAMES = "EditNames";
	public static final String REQ_FEATURE_EDIT_NAMES = "EditNames";

	Request request;

	DwGraphicalFeatureModelViewer editor;
	public DwFeatureEditNamesAction(IWorkbenchPart part){
		super(part);
		
		editor = (DwGraphicalFeatureModelViewer)part;

		setId(FEATURE_EDIT_NAMES);
		setText("Edit Names");

		request = new Request(REQ_FEATURE_EDIT_NAMES);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void run(){
		Shell shell = this.getWorkbenchPart().getSite().getShell();

		StructuredSelection selection = (StructuredSelection)this.getSelection();
		DwFeatureEditPart part = (DwFeatureEditPart)selection.getFirstElement();
		DwFeatureWrapped model = (DwFeatureWrapped)part.getModel();
		EList<HyName> names = model.getWrappedModelElement().getNames();


		DwNameDialog dialog = new DwNameDialog(shell);

		dialog.setElement(model.getWrappedModelElement());
		dialog.setItems((EList<EObject>)(EList<?>)names);
		
		if(dialog.open() == Dialog.OK) {
		
			part.refresh();
			
		}
		
		
	}

	@Override
	protected boolean calculateEnabled() {
		if(!editor.isLastDateSelected())
			return false;
		
		return true;
	}
}