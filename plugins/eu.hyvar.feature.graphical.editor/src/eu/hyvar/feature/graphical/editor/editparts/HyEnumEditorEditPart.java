package eu.hyvar.feature.graphical.editor.editparts;

import org.eclipse.draw2d.Label;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.jface.viewers.TextCellEditor;

import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.editparts.HyEnumEditPart;
import eu.hyvar.feature.graphical.base.figures.HyEnumFigure;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.editor.locators.HyFeatureCellEditorLocator;
import eu.hyvar.feature.graphical.editor.managers.HyFeatureDirectEditManager;
import eu.hyvar.feature.graphical.editor.policies.HyEnumComponentEditPolicy;
import eu.hyvar.feature.graphical.editor.policies.HyEnumDirectEditPolicy;
public class HyEnumEditorEditPart extends HyEnumEditPart{

	public HyEnumEditorEditPart(GraphicalFeatureModelEditor editor, HyFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}

	@Override
	protected void createEditPolicies(){
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new HyEnumComponentEditPolicy(featureModel, editor));
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new HyEnumDirectEditPolicy());
		
	}
	
	/**
	 * This method is used to enable direct name editing in the feature
	 */
	@Override 
	public void performRequest(Request req) {
		if(req.getType() == RequestConstants.REQ_DIRECT_EDIT) {
			
		}
		if(req.getType() == RequestConstants.REQ_OPEN){

				performDirectEditing();
			
		}
	}

	private void performDirectEditing() {		
		Label label = ((HyEnumFigure)getFigure()).getLabel();
		HyFeatureDirectEditManager manager = new HyFeatureDirectEditManager(this, TextCellEditor.class, new HyFeatureCellEditorLocator(label), label);
		manager.show();
	}   
}
