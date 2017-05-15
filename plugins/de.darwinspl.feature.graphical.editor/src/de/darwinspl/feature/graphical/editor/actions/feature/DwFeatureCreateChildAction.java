package de.darwinspl.feature.graphical.editor.actions.feature;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.editor.commands.feature.DwFeatureCreateCommand;
import de.darwinspl.feature.graphical.editor.editor.DwGraphicalFeatureModelEditor;

public class DwFeatureCreateChildAction extends DwFeatureSelectionAction {
	public static final String FEATURE_CREATE_CHILD = "CreateChildEvolution";
	public static final String REQ_FEATURE_CREATE_CHILD = "CreateChildEvolution";
		
	public DwFeatureCreateChildAction(DwGraphicalFeatureModelEditor editor) {
		super(editor);
			
		setId(FEATURE_CREATE_CHILD);
		setText("Create Child");
		request = new Request(REQ_FEATURE_CREATE_CHILD);
	}
	
	@Override
	protected Command createCommand(Object acceptedModel) {
		DwFeatureWrapped selectedFeature = getSelectedFeature();		
		DwGraphicalFeatureModelViewer viewer = (DwGraphicalFeatureModelViewer)this.getWorkbenchPart();
		
		DwFeatureCreateCommand command = new DwFeatureCreateCommand(selectedFeature, viewer);
		return command;
	}	
}
