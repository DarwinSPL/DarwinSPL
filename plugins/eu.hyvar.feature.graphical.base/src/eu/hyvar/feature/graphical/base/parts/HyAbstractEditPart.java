package eu.hyvar.feature.graphical.base.parts;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
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
	
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {	
		System.out.println("HyAbstractEditPart "+arg0.toString());
	}
}
