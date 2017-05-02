package dw.darwinspl.feature.graphical.editor.editparts;

import org.eclipse.gef.EditPolicy;

import dw.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import dw.darwinspl.feature.graphical.base.editparts.DwVersionEditPart;
import dw.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import dw.darwinspl.feature.graphical.editor.editor.DwGraphicalFeatureModelEditor;
import dw.darwinspl.feature.graphical.editor.policies.version.DwVersionComponentPolicy;
import dw.darwinspl.feature.graphical.editor.policies.version.DwVersionSelectionHandlesPolicy;


public class DwVersionEditorEditPart extends DwVersionEditPart{

	public DwVersionEditorEditPart(DwGraphicalFeatureModelViewer editor, DwFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new DwVersionSelectionHandlesPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new DwVersionComponentPolicy((DwGraphicalFeatureModelEditor)editor, featureModel));
	}
}