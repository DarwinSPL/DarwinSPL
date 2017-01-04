package eu.hyvar.feature.graphical.editor.actions;

import org.eclipse.gef.Request;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.actions.RetargetAction;

import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.editor.template.svg.HyFeatureModelSVGGenerator;

public class HyFeatureModelCreateSVGAction extends RetargetAction{
	public static final String FEATUREMODEL_CREATE_SVG = "FeatureModelCreateSvg";
	public static final String REQ_FEATUREMODEL_CREATE_SVG = "FeatureModelCreateSvg";

	protected Request request;


	public HyFeatureModelCreateSVGAction() {
		super(FEATUREMODEL_CREATE_SVG,  "Export SVG Image");


		setEnabled(true);
	}


	@Override
	public void runWithEvent(Event event) {
		if(this.getActivePart() instanceof HyGraphicalFeatureModelViewer){
			HyFeatureModelSVGGenerator generator = new HyFeatureModelSVGGenerator();

			generator.createFile(((HyGraphicalFeatureModelViewer)this.getActivePart()).getCurrentSelectedDate());
		}
	}

}