package dw.darwinspl.feature.graphical.editor.actions.feature;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;

import dw.darwinspl.feature.graphical.base.editparts.DwFeatureEditPart;
import dw.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import dw.darwinspl.feature.graphical.editor.dialogs.DwNameDialog;
import eu.hyvar.evolution.HyName;

public class DwFeatureEditNamesAction extends SelectionAction{
	public static final String FEATURE_EDIT_NAMES = "EditNames";
	public static final String REQ_FEATURE_EDIT_NAMES = "EditNames";

	Request request;

	public DwFeatureEditNamesAction(IWorkbenchPart part){
		super(part);

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
		dialog.open();
	}

	@Override
	protected boolean calculateEnabled() {
		if(getSelectedObjects().isEmpty())
			return false;

		for(Object selectedObject : getSelectedObjects()){
			if(!(selectedObject instanceof DwFeatureEditPart)){
				return false;
			}
		}

		return true;
	}	
}