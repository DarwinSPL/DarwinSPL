package eu.hyvar.feature.graphical.editor.actions;

import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.actions.RetargetAction;

import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.editor.template.svg.HyFeatureModelSVGGenerator;

/**
 * This action triggers the generation of a SVG representation of the feature model at the currently selected date
 * @author Gil Engel
 *
 */
public class HyFeatureModelCreateSVGAction extends RetargetAction{
	public static final String FEATUREMODEL_CREATE_SVG = "FeatureModelCreateSvg";
	public static final String REQ_FEATUREMODEL_CREATE_SVG = "FeatureModelCreateSvg";

	public HyFeatureModelCreateSVGAction() {
		super(FEATUREMODEL_CREATE_SVG,  "Export SVG Image");

		setEnabled(true);
	}

	/**
	 * Creates a SVG file that represents the feature model at the current selected date
	 */
	@Override
	public void runWithEvent(Event event) {
		if(this.getActivePart() instanceof DwGraphicalFeatureModelViewer){
			HyFeatureModelSVGGenerator generator = new HyFeatureModelSVGGenerator();

			generator.createFile(((DwGraphicalFeatureModelViewer)this.getActivePart()).getCurrentSelectedDate());
		}
	}

}