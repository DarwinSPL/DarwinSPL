package dw.darwinspl.feature.graphical.editor.actions;

import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.actions.RetargetAction;

import dw.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import dw.darwinspl.feature.graphical.editor.template.DwFeatureModelOverviewGenerator;

/**
 * GEF action that is used to trigger the process to create an overview file that contains all evolutionary steps in the model
 * @author Gil Engel
 *
 */
public class DwFeatureModelCreateOverviewAction extends RetargetAction{
	public static final String FEATUREMODEL_CREATE_OVERVIEW = "FeatureModelCreateOverview";
	public static final String REQ_FEATUREMODEL_CREATE_OVERVIEW = "FeatureModelCreateOverview";

	public DwFeatureModelCreateOverviewAction() {
		super(FEATUREMODEL_CREATE_OVERVIEW,  "Create Evolution Overview");

		setEnabled(true);
	}

	@Override
	public void runWithEvent(Event event) {
		if(this.getActivePart() instanceof DwGraphicalFeatureModelViewer){

			DwFeatureModelOverviewGenerator generator = new DwFeatureModelOverviewGenerator();
			generator.createOverviewFile(null, null);
		}
	}
}