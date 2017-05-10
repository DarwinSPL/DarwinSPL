package eu.hyvar.feature.graphical.editor.actions;

import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.actions.RetargetAction;

import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.editor.template.HyFeatureModelOverviewGenerator;

/**
 * GEF action that is used to trigger the process to create an overview file that contains all evolutionary steps in the model
 * @author Gil Engel
 *
 */
public class HyFeatureModelCreateOverviewAction extends RetargetAction{
	public static final String FEATUREMODEL_CREATE_OVERVIEW = "FeatureModelCreateOverview";
	public static final String REQ_FEATUREMODEL_CREATE_OVERVIEW = "FeatureModelCreateOverview";

	public HyFeatureModelCreateOverviewAction() {
		super(FEATUREMODEL_CREATE_OVERVIEW,  "Create Evolution Overview");

		setEnabled(true);
	}

	@Override
	public void runWithEvent(Event event) {
		if(this.getActivePart() instanceof DwGraphicalFeatureModelViewer){

			HyFeatureModelOverviewGenerator generator = new HyFeatureModelOverviewGenerator();
			generator.createOverviewFile(null, null);
		}
	}
}