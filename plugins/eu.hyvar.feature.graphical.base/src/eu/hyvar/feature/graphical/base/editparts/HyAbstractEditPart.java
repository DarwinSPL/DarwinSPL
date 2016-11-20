package eu.hyvar.feature.graphical.base.editparts;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.model.HyEditorChangeableElement;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;

public abstract class HyAbstractEditPart extends AbstractGraphicalEditPart implements PropertyChangeListener{
	protected HyGraphicalFeatureModelViewer editor;
	protected HyFeatureModelWrapped featureModel;

	public HyFeatureModelWrapped getFeatureModel() {
		return featureModel;
	}

	public void setFeatureModel(HyFeatureModelWrapped featureModel) {
		this.featureModel = featureModel;
	}

	public HyAbstractEditPart(HyGraphicalFeatureModelViewer editor, HyFeatureModelWrapped featureModel) {
		this.editor = editor;
		this.featureModel = featureModel;
	}

	public HyGraphicalFeatureModelViewer getEditor() {
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

}
