package de.darwinspl.feature.graphical.editor.actions.feature;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwFeatureEditPart;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.editor.dialogs.DwFeatureTypeDialog;
import eu.hyvar.feature.HyFeatureType;

public class DwFeatureEditCardinalitiesAction extends SelectionAction{
	public static final String FEATURE_EDIT_CARDINALITIES = "EditCardinalities";
	public static final String REQ_FEATURE_EDIT_CARDINALITIES = "EditCardinalities";

	Request request;
	
	DwGraphicalFeatureModelViewer editor;
	
	public DwFeatureEditCardinalitiesAction(IWorkbenchPart part){
		super(part);
		editor = (DwGraphicalFeatureModelViewer)part;
		
		setId(FEATURE_EDIT_CARDINALITIES);
		setText("Edit Cardinalities");
		
		request = new Request(REQ_FEATURE_EDIT_CARDINALITIES);
	}
	
	@Override
	public void run(){
		Shell shell = this.getWorkbenchPart().getSite().getShell();
		
		StructuredSelection selection = (StructuredSelection)this.getSelection();
		DwFeatureEditPart part = (DwFeatureEditPart)selection.getFirstElement();
		DwFeatureWrapped model = (DwFeatureWrapped)part.getModel();
		
		EList<HyFeatureType> cardinalities = model.getWrappedModelElement().getTypes();
		EList<EObject> items = new BasicEList<EObject>();
		for(int i=0; i<cardinalities.size(); i++){
			HyFeatureType cardinality = cardinalities.get(i);
			items.add(cardinality);
		}		
		
		
		
		DwFeatureTypeDialog dialog = new DwFeatureTypeDialog(shell);
		dialog.setItems(items);
	
		try {
			dialog.setElement(model);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dialog.open();	
	}

	@Override
	protected boolean calculateEnabled() {
		if(getSelectedObjects().isEmpty())
			return false;
		
		if(!editor.isLastDateSelected())
			return false;
		
		for(Object selectedObject : getSelectedObjects()){
			if(!(selectedObject instanceof DwFeatureEditPart)){
				return false;
			}
		}
		
		return true;
	}	
}