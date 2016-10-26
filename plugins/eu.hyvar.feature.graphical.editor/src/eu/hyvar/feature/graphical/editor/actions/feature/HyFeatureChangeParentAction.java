package eu.hyvar.feature.graphical.editor.actions.feature;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.editor.dialogs.ParentChangeDialog;

public class HyFeatureChangeParentAction extends HyFeatureSelectionAction {
	public static final String FEATURE__CHANGE_PARENT = "ChangeParent";
	public static final String REQ_FEATURE__CHANGE_PARENT = "ChangeParent";
	
	public HyFeatureChangeParentAction(IWorkbenchPart part, GraphicalFeatureModelEditor editor) {
		super(part, editor);
		
		setId(FEATURE__CHANGE_PARENT);
		setText("Change Parent Feature/Group");
		request = new Request(REQ_FEATURE__CHANGE_PARENT);
	}
	
	@Override
	public void run(){
		
		Shell shell = this.getWorkbenchPart().getSite().getShell();

		StructuredSelection selection = (StructuredSelection)this.getSelection();
		HyFeatureEditPart part = (HyFeatureEditPart)selection.getFirstElement();
		HyFeatureWrapped model = (HyFeatureWrapped)part.getModel();
		HyFeature feature = model.getWrappedModelElement();
		GraphicalFeatureModelEditor editor = (GraphicalFeatureModelEditor)this.getWorkbenchPart().getSite().getWorkbenchWindow().getActivePage().getActiveEditor();
		
		//HyFeatureAttribute attribute = (HyFeatureAttribute)part.getModel();
		
		//EList<HyName> names = attribute.getNames();
		EList<EObject> items = new BasicEList<EObject>();
		List<HyFeature> features = new ArrayList<HyFeature>();
		
		for(HyGroupComposition composition : feature.getGroupMembership()){
			HyGroup group = composition.getCompositionOf();
			for(HyFeatureChild child : group.getChildOf()){
				items.add(child.getParent().getNames().get(0));
			}
		}
		for(HyFeature modelFeature : editor.getModelWrapped().getModel().getFeatures()){
			features.add(modelFeature);
		}
		
		
		

		ParentChangeDialog dialog = new ParentChangeDialog(shell);
		dialog.setElement(part.getModel());
		dialog.setFeatureModel(editor.getModelWrapped());
		dialog.setItems(items);
		dialog.setFeatures(features);
		dialog.open();
		
	}

	@Override
	protected Command createCommand(Object acceptedModel) {
		// TODO Auto-generated method stub
		return null;
	}
}
