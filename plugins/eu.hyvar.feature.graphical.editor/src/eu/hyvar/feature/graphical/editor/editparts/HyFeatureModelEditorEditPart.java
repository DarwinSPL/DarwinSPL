package eu.hyvar.feature.graphical.editor.editparts;

import org.eclipse.gef.EditPolicy;

import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureModelEditPart;
import eu.hyvar.feature.graphical.editor.policies.HyFeatureModelXYLayoutPolicy;

public class HyFeatureModelEditorEditPart extends HyFeatureModelEditPart{
	public HyFeatureModelEditorEditPart(GraphicalFeatureModelEditor editor) {
		super(editor);
	}

	@Override
	protected void createEditPolicies() {
		super.createEditPolicies();
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new HyFeatureModelXYLayoutPolicy());
	}
}
