package de.darwinspl.feature.graphical.editor.editparts;

import org.eclipse.gef.EditPolicy;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwVersionEditPart;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.editor.editor.DwGraphicalFeatureModelEditor;
import de.darwinspl.feature.graphical.editor.policies.version.DwVersionComponentPolicy;
import de.darwinspl.feature.graphical.editor.policies.version.DwVersionSelectionHandlesPolicy;


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