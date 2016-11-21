package eu.hyvar.feature.graphical.base.editparts;


import java.util.Date;

import org.deltaecore.feature.graphical.base.editor.DEGraphicalEditor;
import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyVersion;
import eu.hyvar.feature.graphical.base.deltaecore.wrapper.layouter.version.HyVersionLayouterManager;
import eu.hyvar.feature.graphical.base.deltaecore.wrapper.layouter.version.HyVersionTreeLayouter;
import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.figures.HyVersionFigure;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;

public class HyVersionEditPart extends HyAbstractEditPart{

	public HyVersionEditPart(HyGraphicalFeatureModelViewer editor, HyFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}

	@Override
	protected IFigure createFigure() {
		return new HyVersionFigure((HyVersion)getModel());
	}

	@Override
	protected void createEditPolicies() {
	}

	@Override
	public void refreshVisuals(){
		
		DEGraphicalEditorTheme theme = DEGraphicalEditor.getTheme();
		Date date = ((HyGraphicalFeatureModelViewer)editor).getCurrentSelectedDate();

		HyVersionFigure figure = (HyVersionFigure)getFigure();
		HyVersion model = (HyVersion)getModel();
		
		

		figure.setVisible(HyEvolutionUtil.isValid(model, date));
		((HyVersionFigure)getFigure()).update();

		int offset = 0;
		if(this.getSelected() == SELECTED_PRIMARY){
			offset = theme.getLineWidth();
		}

		HyVersionTreeLayouter versionTreeLayouter = HyVersionLayouterManager.getLayouter(model.getFeature(), date);
		if(versionTreeLayouter != null){
			Rectangle bounds = versionTreeLayouter.getBounds(model);
			bounds.setX(bounds.x - offset);
			bounds.setY(bounds.y - offset);
			bounds.setWidth(bounds.width+offset*2);
			bounds.setHeight(bounds.height+offset*2);
			
			HyFeatureEditPart parent = (HyFeatureEditPart)getParent();
			parent.setLayoutConstraint(this, figure, bounds);	
		}
	}
}