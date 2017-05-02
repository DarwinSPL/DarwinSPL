package dw.darwinspl.feature.graphical.editor.editparts;

import org.eclipse.draw2d.Label;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.jface.viewers.TextCellEditor;

import dw.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import dw.darwinspl.feature.graphical.base.editparts.DwEnumLiteralEditPart;
import dw.darwinspl.feature.graphical.base.figures.DwEnumLiteralFigure;
import dw.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import dw.darwinspl.feature.graphical.editor.locators.DwFeatureCellEditorLocator;
import dw.darwinspl.feature.graphical.editor.managers.DwFeatureDirectEditManager;
import dw.darwinspl.feature.graphical.editor.policies.enums.DwEnumLiteralDirectEditPolicy;

public class DwEnumLiteralEditorEditPart extends DwEnumLiteralEditPart{

	public DwEnumLiteralEditorEditPart(DwGraphicalFeatureModelViewer editor, DwFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}

	@Override
	protected void createEditPolicies(){
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new DwEnumLiteralDirectEditPolicy());

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
		Label label = ((DwEnumLiteralFigure)getFigure()).getLabel();
		DwFeatureDirectEditManager manager = new DwFeatureDirectEditManager(this, TextCellEditor.class, new DwFeatureCellEditorLocator(label), label);
		manager.show();
	} 
}
