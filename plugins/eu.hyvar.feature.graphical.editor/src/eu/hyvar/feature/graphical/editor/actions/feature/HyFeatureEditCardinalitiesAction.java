package eu.hyvar.feature.graphical.editor.actions.feature;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;

import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.editor.dialogs.HyFeatureTypeDialog;

public class HyFeatureEditCardinalitiesAction extends SelectionAction{
	public static final String FEATURE_EDIT_CARDINALITIES = "EditCardinalities";
	public static final String REQ_FEATURE_EDIT_CARDINALITIES = "EditCardinalities";

	Request request;
	
	public HyFeatureEditCardinalitiesAction(IWorkbenchPart part){
		super(part);
		
		setId(FEATURE_EDIT_CARDINALITIES);
		setText("Edit Cardinalities");
		
		request = new Request(REQ_FEATURE_EDIT_CARDINALITIES);
	}
	
	@Override
	public void run(){
		Shell shell = this.getWorkbenchPart().getSite().getShell();
		
		StructuredSelection selection = (StructuredSelection)this.getSelection();
		HyFeatureEditPart part = (HyFeatureEditPart)selection.getFirstElement();
		HyFeatureWrapped model = (HyFeatureWrapped)part.getModel();
		
		EList<HyFeatureType> cardinalities = model.getWrappedModelElement().getTypes();
		EList<EObject> items = new BasicEList<EObject>();
		for(int i=0; i<cardinalities.size(); i++){
			HyFeatureType cardinality = cardinalities.get(i);
			items.add(cardinality);
		}		
		
		
		
		HyFeatureTypeDialog dialog = new HyFeatureTypeDialog(shell);
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
		
		for(Object selectedObject : getSelectedObjects()){
			if(!(selectedObject instanceof HyFeatureEditPart)){
				return false;
			}
		}
		
		return true;
	}	
}