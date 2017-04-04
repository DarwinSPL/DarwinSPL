package eu.hyvar.feature.graphical.base.editparts;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.evolution.HyTemporalElement;
import eu.hyvar.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.model.HyEditorChangeableElement;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;

public abstract class HyAbstractEditPart extends AbstractGraphicalEditPart implements PropertyChangeListener{
	protected DwGraphicalFeatureModelViewer editor;
	protected HyFeatureModelWrapped featureModel;

	public HyFeatureModelWrapped getFeatureModel() {
		return featureModel;
	}

	public void setFeatureModel(HyFeatureModelWrapped featureModel) {
		this.featureModel = featureModel;
	}

	public HyAbstractEditPart(DwGraphicalFeatureModelViewer editor, HyFeatureModelWrapped featureModel) {
		this.editor = editor;
		this.featureModel = featureModel;
	}

	public DwGraphicalFeatureModelViewer getEditor() {
		return editor;
	}


	public void activate() {
		super.activate();
		if(getModel() instanceof HyEditorChangeableElement){
			
			HyEditorChangeableElement propertyAwareObject = (HyEditorChangeableElement) getModel();
			propertyAwareObject.addPropertyChangeListener(this);
		}
	}


	public void deactivate() {
		super.deactivate();
		if(getModel() instanceof HyEditorChangeableElement){
			
			HyEditorChangeableElement propertyAwareObject = (HyEditorChangeableElement) getModel();
			propertyAwareObject.removePropertyChangeListener(this);
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
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
		if(model instanceof HyEditorChangeableElement){
			model = ((HyEditorChangeableElement)model).getWrappedModelElement();
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
			
			parent.setLayoutConstraint(this, figure, constraint);
		}
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		
		refreshVisibility();
	}
}
