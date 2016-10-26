package eu.hyvar.feature.graphical.base.editparts;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.model.HyEditorChangeableElement;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;

public abstract class HyAbstractEditPart extends AbstractGraphicalEditPart implements PropertyChangeListener{
	protected GraphicalFeatureModelEditor editor;
	protected HyFeatureModelWrapped featureModel;

	public HyFeatureModelWrapped getFeatureModel() {
		return featureModel;
	}

	public void setFeatureModel(HyFeatureModelWrapped featureModel) {
		this.featureModel = featureModel;
	}

	public HyAbstractEditPart(GraphicalFeatureModelEditor editor, HyFeatureModelWrapped featureModel) {
		this.editor = editor;
		this.featureModel = featureModel;
	}

	public GraphicalFeatureModelEditor getEditor() {
		return editor;
	}

	/**
	 * @see org.eclipse.gef.EditPart#activate()
	 */
	public void activate() {
		if(getModel() instanceof HyEditorChangeableElement){
			super.activate();
			HyEditorChangeableElement propertyAwareObject = (HyEditorChangeableElement) getModel();
			propertyAwareObject.addPropertyChangeListener(this);
		}
	}

	/**
	 * @see org.eclipse.gef.EditPart#deactivate()
	 */
	public void deactivate() {
		if(getModel() instanceof HyEditorChangeableElement){
			super.deactivate();
			HyEditorChangeableElement propertyAwareObject = (HyEditorChangeableElement) getModel();
			propertyAwareObject.removePropertyChangeListener(this);
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		//System.out.println(evt);

	}

}
