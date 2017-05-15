package de.darwinspl.feature.graphical.base.editparts;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.figures.DwAttributeFigure;
import de.darwinspl.feature.graphical.base.model.DwEditorChangeableElement;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.evolution.HyTemporalElement;
import eu.hyvar.feature.HyFeatureAttribute;

public abstract class DwAbstractEditPart extends AbstractGraphicalEditPart implements PropertyChangeListener{
	protected DwGraphicalFeatureModelViewer editor;
	protected DwFeatureModelWrapped featureModel;

	public DwFeatureModelWrapped getFeatureModel() {
		return featureModel;
	}

	public void setFeatureModel(DwFeatureModelWrapped featureModel) {
		this.featureModel = featureModel;
	}

	public DwAbstractEditPart(DwGraphicalFeatureModelViewer editor, DwFeatureModelWrapped featureModel) {
		this.editor = editor;
		this.featureModel = featureModel;
	}

	public DwGraphicalFeatureModelViewer getEditor() {
		return editor;
	}


	public void activate() {
		if(!isActive()){
			if(getModel() instanceof DwEditorChangeableElement){
				
				DwEditorChangeableElement propertyAwareObject = (DwEditorChangeableElement) getModel();
				propertyAwareObject.addPropertyChangeListener(this);
			}
		}
		
		super.activate();
	}


	public void deactivate() {
		if(isActive()) {
			if(getModel() instanceof DwEditorChangeableElement){
				
				DwEditorChangeableElement propertyAwareObject = (DwEditorChangeableElement) getModel();
				propertyAwareObject.removePropertyChangeListener(this);
			}
		}
		
		super.deactivate();
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		DwAttributeFigure figure = (DwAttributeFigure)getFigure();
		HyFeatureAttribute attribute = (HyFeatureAttribute)getModel();
		
		boolean hasMarker = featureModel.hasMarkerForElement(attribute);

		if(hasMarker){
			figure.setTooltipVisible(true);
			figure.setTooltipText(featureModel.getMarkerForElement(attribute).getMessage());

		}else{
			figure.setTooltipVisible(false);
		}
	}

	/**
	 * Specifies constraint that the figure needs to be displayed properly.
	 * @return the desired size of the figure
	 */
	protected abstract Rectangle getFigureConstraint();
	
	/**
	 * Sets the figure to visible if the model is visible to the current date or hides it if not.
	 */
	protected void refreshVisibility(){
		Object model = getModel();
		if(model instanceof DwEditorChangeableElement){
			model = ((DwEditorChangeableElement)model).getWrappedModelElement();
		}
		
		if(model instanceof HyTemporalElement){
			HyTemporalElement temporalModel = (HyTemporalElement)model;
			AbstractGraphicalEditPart parent = (AbstractGraphicalEditPart)getParent();
			
			Rectangle constraint = null;
			if(HyEvolutionUtil.isValid(temporalModel, featureModel.getSelectedDate())){
				figure.setVisible(true);	
				constraint = getFigureConstraint();	
			}else{			
				figure.setVisible(false);	
				constraint = getFigureConstraint().setSize(0, 0);
			}	
			
			if(parent != null)
			parent.setLayoutConstraint(this, figure, constraint);
		}
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		
		refreshVisibility();
	}
}
