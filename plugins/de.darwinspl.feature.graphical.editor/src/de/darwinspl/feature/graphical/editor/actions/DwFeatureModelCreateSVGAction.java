package de.darwinspl.feature.graphical.editor.actions;

import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.actions.RetargetAction;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.editor.template.svg.DwFeatureModelSVGGenerator;

/**
 * This action triggers the generation of a SVG representation of the feature model at the currently selected date
 * @author Gil Engel
 *
 */
public class DwFeatureModelCreateSVGAction extends RetargetAction{
	public static final String FEATUREMODEL_CREATE_SVG = "FeatureModelCreateSvg";
	public static final String REQ_FEATUREMODEL_CREATE_SVG = "FeatureModelCreateSvg";

	public DwFeatureModelCreateSVGAction() {
		super(FEATUREMODEL_CREATE_SVG,  "Export SVG Image");

		setEnabled(true);
	}

	/**
	 * Creates a SVG file that represents the feature model at the current selected date
	 */
	@Override
	public void runWithEvent(Event event) {
		if(this.getActivePart() instanceof DwGraphicalFeatureModelViewer){
			DwFeatureModelSVGGenerator generator = new DwFeatureModelSVGGenerator();

			generator.createFile(((DwGraphicalFeatureModelViewer)this.getActivePart()).getCurrentSelectedDate());
		}
	}

}