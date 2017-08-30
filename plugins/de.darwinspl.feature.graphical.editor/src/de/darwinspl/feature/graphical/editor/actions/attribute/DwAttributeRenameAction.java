package de.darwinspl.feature.graphical.editor.actions.attribute;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwAttributeEditPart;
import de.darwinspl.feature.graphical.editor.dialogs.DwNameDialog;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeatureAttribute;

public class DwAttributeRenameAction extends SelectionAction{
	public static final String ATTRIBUTE_EDIT_NAMES = "EditAttributeNames";
	public static final String REQ_ATTRIBUTE_EDIT_NAMES = "EditAttributeNames";

	Request request;
	
	private DwGraphicalFeatureModelViewer viewer;

	public DwAttributeRenameAction(IWorkbenchPart part){
		super(part);
		
		viewer = (DwGraphicalFeatureModelViewer)part;

		setId(ATTRIBUTE_EDIT_NAMES);
		setText("Edit Attribute Names");

		request = new Request(REQ_ATTRIBUTE_EDIT_NAMES);
	}

	@Override
	public void run(){
		Shell shell = this.getWorkbenchPart().getSite().getShell();

		StructuredSelection selection = (StructuredSelection)this.getSelection();
		DwAttributeEditPart part = (DwAttributeEditPart)selection.getFirstElement();
		HyFeatureAttribute attribute = (HyFeatureAttribute)part.getModel();
		
		EList<HyName> names = attribute.getNames();
		EList<EObject> items = new BasicEList<EObject>();

		for(int i=0; i<names.size(); i++){
			HyName name = names.get(i);
			items.add(name);
		}

		DwNameDialog dialog = new DwNameDialog(shell);
		dialog.setElement(attribute);
		dialog.setItems(items);
		dialog.open();
	}

	@Override
	protected boolean calculateEnabled() {
		if(getSelectedObjects().isEmpty())
			return false;
		
		if(!viewer.isLastDateSelected())
			return false;

		for(Object selectedObject : getSelectedObjects()){
			if(!(selectedObject instanceof DwAttributeEditPart)){
				return false;
			}
		}

		return true;
	}	
}
