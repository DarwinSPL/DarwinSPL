package eu.hyvar.feature.graphical.editor.actions.feature;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;

import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.editor.commands.feature.HyFeatureCreateCommand;
import eu.hyvar.feature.graphical.editor.editor.HyGraphicalFeatureModelEditor;

public class HyFeatureCreateChildAction extends HyFeatureSelectionAction {
	public static final String FEATURE_CREATE_CHILD = "CreateChildEvolution";
	public static final String REQ_FEATURE_CREATE_CHILD = "CreateChildEvolution";
		
	public HyFeatureCreateChildAction(HyGraphicalFeatureModelEditor editor) {
		super(editor);
			
		setId(FEATURE_CREATE_CHILD);
		setText("Create Child");
		request = new Request(REQ_FEATURE_CREATE_CHILD);
	}
	
	@Override
	protected Command createCommand(Object acceptedModel) {
		HyFeatureWrapped selectedFeature = getSelectedFeature();		
		HyGraphicalFeatureModelEditor editor = (HyGraphicalFeatureModelEditor)this.getWorkbenchPart();
		
		HyFeatureCreateCommand command = new HyFeatureCreateCommand(selectedFeature, (HyGraphicalFeatureModelViewer)editor);
		return command;
	}	
}
