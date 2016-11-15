package eu.hyvar.feature.graphical.editor.editparts;

import org.eclipse.gef.EditPolicy;

import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.editparts.HyVersionEditPart;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.editor.editor.GraphicalEvolutionFeatureModelEditor;
import eu.hyvar.feature.graphical.editor.policies.version.HyVersionComponentPolicy;
import eu.hyvar.feature.graphical.editor.policies.version.HyVersionSelectionHandlesPolicy;


public class HyVersionEditorEditPart extends HyVersionEditPart{

	public HyVersionEditorEditPart(GraphicalFeatureModelEditor editor, HyFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new HyVersionSelectionHandlesPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new HyVersionComponentPolicy((GraphicalEvolutionFeatureModelEditor)editor, featureModel));
	}
}