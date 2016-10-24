package eu.hyvar.feature.graphical.editor.actions.feature;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;

import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.editor.dialogs.NameDialog;

public class HyFeatureEditNamesAction extends SelectionAction{
	public static final String FEATURE_EDIT_NAMES = "EditNames";
	public static final String REQ_FEATURE_EDIT_NAMES = "EditNames";

	Request request;

	public HyFeatureEditNamesAction(IWorkbenchPart part){
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
		HyFeatureEditPart part = (HyFeatureEditPart)selection.getFirstElement();
		HyFeatureWrapped model = (HyFeatureWrapped)part.getModel();
		EList<HyName> names = model.getWrappedModelElement().getNames();


		NameDialog dialog = new NameDialog(shell);

		dialog.setElement(model.getWrappedModelElement());
		dialog.setItems((EList<EObject>)(EList<?>)names);
		dialog.open();
	}

	@Override
	protected boolean calculateEnabled() {
		if(getSelectedObjects().isEmpty())
			return false;

		for(Object selectedObject : getSelectedObjects()){
			if(!(selectedObject instanceof HyFeatureEditPart)){
				return false;
			}
		}

		return true;
	}	
}