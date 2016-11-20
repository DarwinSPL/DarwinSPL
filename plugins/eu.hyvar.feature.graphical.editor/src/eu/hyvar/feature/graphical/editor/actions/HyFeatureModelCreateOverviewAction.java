package eu.hyvar.feature.graphical.editor.actions;

import org.eclipse.gef.Request;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.actions.RetargetAction;

import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.editor.template.HyFeatureModelOverviewGenerator;


public class HyFeatureModelCreateOverviewAction extends RetargetAction{
	public static final String FEATUREMODEL_CREATE_OVERVIEW = "FeatureModelCreateOverview";
	public static final String REQ_FEATUREMODEL_CREATE_OVERVIEW = "FeatureModelCreateOverview";

	protected Request request;


	public HyFeatureModelCreateOverviewAction() {
		super(FEATUREMODEL_CREATE_OVERVIEW,  "Create Overview");


		setEnabled(true);
	}


	@Override
	public void runWithEvent(Event event) {
		if(this.getActivePart() instanceof HyGraphicalFeatureModelViewer){

			HyFeatureModelOverviewGenerator generator = new HyFeatureModelOverviewGenerator();


			generator.createOverviewFile(null, null);


		}
	}

}