package eu.hyvar.feature.graphical.editor.editparts;

import org.eclipse.draw2d.Label;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.jface.viewers.TextCellEditor;

import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.editparts.HyEnumLiteralEditPart;
import eu.hyvar.feature.graphical.base.figures.HyEnumLiteralFigure;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.editor.locators.HyFeatureCellEditorLocator;
import eu.hyvar.feature.graphical.editor.managers.HyFeatureDirectEditManager;
import eu.hyvar.feature.graphical.editor.policies.enums.HyEnumLiteralDirectEditPolicy;

public class HyEnumLiteralEditorEditPart extends HyEnumLiteralEditPart{

	public HyEnumLiteralEditorEditPart(HyGraphicalFeatureModelViewer editor, HyFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}

	@Override
	protected void createEditPolicies(){
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new HyEnumLiteralDirectEditPolicy());

	}

	/**
	 * This method is used to enable direct name editing in the feature
	 */
	@Override 
	public void performRequest(Request req) {
		if(req.getType() == RequestConstants.REQ_OPEN){
			performDirectEditing();	
		}
	}

	private void performDirectEditing() {		
		Label label = ((HyEnumLiteralFigure)getFigure()).getLabel();
		HyFeatureDirectEditManager manager = new HyFeatureDirectEditManager(this, TextCellEditor.class, new HyFeatureCellEditorLocator(label), label);
		manager.show();
	} 
}
