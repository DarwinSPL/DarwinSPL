package eu.hyvar.feature.graphical.editor.editparts;

import org.eclipse.gef.EditPolicy;

import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.editparts.HyVersionEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.editor.editor.HyGraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.editor.policies.version.HyVersionComponentPolicy;
import eu.hyvar.feature.graphical.editor.policies.version.HyVersionSelectionHandlesPolicy;


public class HyVersionEditorEditPart extends HyVersionEditPart{

	public HyVersionEditorEditPart(DwGraphicalFeatureModelViewer editor, HyFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new HyVersionSelectionHandlesPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new HyVersionComponentPolicy((HyGraphicalFeatureModelEditor)editor, featureModel));
	}
}