package eu.hyvar.feature.graphical.base.parts;

import java.util.Date;
import java.util.List;

import org.eclipse.draw2d.IFigure;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.figures.HyRootFeatureFigure;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyParentChildConnection;

public class HyRootFeatureEditPart extends HyFeatureEditPart{

	public HyRootFeatureEditPart(GraphicalFeatureModelEditor editor, HyFeatureModelWrapped featureModel) {
		super(editor, featureModel);
	}

	@Override
	protected IFigure createFigure() {	
		return new HyRootFeatureFigure(editor, (HyFeatureWrapped)getModel());
	}
	
	/**
	 * Make sure that root features don't have modifiers
	 */
	@Override
	protected boolean hasModifier(HyFeatureWrapped feature){
		return false;
	}
	
	@Override
	public void refresh(){
		super.refresh();
	}
	
	

	@Override
	public void refreshVisuals(){
		super.refreshVisuals();
		
		GraphicalFeatureModelEditor editor = (GraphicalFeatureModelEditor)this.editor;
		Date date = editor.getCurrentSelectedDate();
		
		HyRootFeatureFigure figure = (HyRootFeatureFigure)getFigure();
		HyFeatureWrapped wrappedFeature = (HyFeatureWrapped)this.getModel();
		// find a valid name for the feature
		for(HyName name : wrappedFeature.getWrappedModelElement().getNames()){
			if(HyEvolutionUtil.isValid(name, date)){
				figure.setText(name.getName());
			}
		}
	}
	
	@Override 
	protected List<HyParentChildConnection> getModelSourceConnections() {
		HyFeatureWrapped model = (HyFeatureWrapped)getModel();

		GraphicalFeatureModelEditor editor = (GraphicalFeatureModelEditor)this.editor;
		Date date = editor.getCurrentSelectedDate();
		return model.getChildrenConnections(date);
	}

	@Override 
	protected List<HyParentChildConnection> getModelTargetConnections() {
		HyFeatureWrapped model = (HyFeatureWrapped)getModel();

		GraphicalFeatureModelEditor editor = (GraphicalFeatureModelEditor)this.editor;
		Date date = editor.getCurrentSelectedDate();
		return model.getParentConnections(date);
	}
}
