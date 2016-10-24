package eu.hyvar.feature.graphical.editor.editparts;

import org.eclipse.draw2d.Label;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.jface.viewers.TextCellEditor;

import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureEditPart;
import eu.hyvar.feature.graphical.base.figures.HyFeatureFigure;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.editor.editor.GraphicalEvolutionFeatureModelEditor;
import eu.hyvar.feature.graphical.editor.locators.HyFeatureCellEditorLocator;
import eu.hyvar.feature.graphical.editor.managers.HyFeatureDirectEditManager;
import eu.hyvar.feature.graphical.editor.policies.HyFeatureComponentEditPolicy;
import eu.hyvar.feature.graphical.editor.policies.HyFeatureDirectEditPolicy;
import eu.hyvar.feature.graphical.editor.policies.HyFeatureComponentPolicy;
import eu.hyvar.feature.graphical.editor.policies.HyFeatureEvolutionGraphicalNodeEditPolicy;
import eu.hyvar.feature.graphical.editor.policies.HyFeatureGraphicalNodeEditPolicy;

public class HyFeatureEditorEditPart extends HyFeatureEditPart{
	public HyFeatureEditorEditPart(GraphicalFeatureModelEditor editor, HyFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}

	@Override
	protected void createEditPolicies(){
		installEditPolicy(EditPolicy.NODE_ROLE, null);
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new HyFeatureComponentEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new HyFeatureGraphicalNodeEditPolicy(featureModel));
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new HyFeatureEvolutionGraphicalNodeEditPolicy(featureModel, (GraphicalEvolutionFeatureModelEditor)editor));
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new HyFeatureComponentPolicy(featureModel, (GraphicalEvolutionFeatureModelEditor)editor));
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new HyFeatureDirectEditPolicy());
	}
	
	/**
	 * This method is used to enable direct name editing in the feature
	 */
	@Override public void performRequest(Request req) {
		if(req.getType() == RequestConstants.REQ_DIRECT_EDIT) {
			performDirectEditing();
		}
	}

	private void performDirectEditing() {		
		Label label = ((HyFeatureFigure)getFigure()).getLabel();
		HyFeatureDirectEditManager manager = new HyFeatureDirectEditManager(this, TextCellEditor.class, new HyFeatureCellEditorLocator(label), label);
		manager.show();
	}   
}
