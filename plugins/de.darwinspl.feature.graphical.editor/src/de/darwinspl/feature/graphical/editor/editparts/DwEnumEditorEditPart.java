package de.darwinspl.feature.graphical.editor.editparts;

import org.eclipse.draw2d.Label;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.jface.viewers.TextCellEditor;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwEnumEditPart;
import de.darwinspl.feature.graphical.base.figures.DwEnumFigure;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.editor.locators.DwFeatureCellEditorLocator;
import de.darwinspl.feature.graphical.editor.managers.DwFeatureDirectEditManager;
import de.darwinspl.feature.graphical.editor.policies.enums.DwEnumComponentEditPolicy;
import de.darwinspl.feature.graphical.editor.policies.enums.DwEnumDirectEditPolicy;
public class DwEnumEditorEditPart extends DwEnumEditPart{

	public DwEnumEditorEditPart(DwGraphicalFeatureModelViewer editor, DwFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}

	@Override
	protected void createEditPolicies(){
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new DwEnumComponentEditPolicy(featureModel, editor));
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new DwEnumDirectEditPolicy());
		
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
		Label label = ((DwEnumFigure)getFigure()).getLabel();
		DwFeatureDirectEditManager manager = new DwFeatureDirectEditManager(this, TextCellEditor.class, new DwFeatureCellEditorLocator(label), label);
		manager.show();
	}   
}
