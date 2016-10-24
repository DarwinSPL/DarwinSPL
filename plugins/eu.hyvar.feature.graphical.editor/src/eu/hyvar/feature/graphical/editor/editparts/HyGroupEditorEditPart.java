package eu.hyvar.feature.graphical.editor.editparts;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;

import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.editparts.HyGroupEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;

public class HyGroupEditorEditPart extends HyGroupEditPart {
	public HyGroupEditorEditPart(GraphicalFeatureModelEditor editor, HyFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, null);
		installEditPolicy(EditPolicy.NODE_ROLE, null);
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new	NonResizableEditPolicy());
	}
}
