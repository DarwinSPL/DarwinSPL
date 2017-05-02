package dw.darwinspl.feature.graphical.base.editparts;

import java.util.Date;

import org.eclipse.draw2d.IFigure;

import dw.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import dw.darwinspl.feature.graphical.base.figures.DwRootFeatureFigure;
import dw.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import dw.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.evolution.HyName;

public class DwRootFeatureEditPart extends DwFeatureEditPart{

	public DwRootFeatureEditPart(DwGraphicalFeatureModelViewer editor, DwFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}

	@Override
	protected IFigure createFigure() {	
		return new DwRootFeatureFigure(editor, (DwFeatureWrapped)getModel());
	}
	
	/**
	 * Make sure that root features don't have modifiers
	 */
	@Override
	protected boolean hasModifier(DwFeatureWrapped feature){
		return false;
	}
	
	@Override
	public void refresh(){
		super.refresh();
	}
	
	

	@Override
	public void refreshVisuals(){
		super.refreshVisuals();
		
		DwGraphicalFeatureModelViewer editor = (DwGraphicalFeatureModelViewer)this.editor;
		Date date = editor.getCurrentSelectedDate();
		
		DwRootFeatureFigure figure = (DwRootFeatureFigure)getFigure();
		DwFeatureWrapped wrappedFeature = (DwFeatureWrapped)this.getModel();
		// find a valid name for the feature
		for(HyName name : wrappedFeature.getWrappedModelElement().getNames()){
			if(HyEvolutionUtil.isValid(name, date)){
				figure.setText(name.getName());
			}
		}
	}
}
