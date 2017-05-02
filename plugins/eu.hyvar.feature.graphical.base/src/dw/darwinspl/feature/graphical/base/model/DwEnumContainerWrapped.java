package dw.darwinspl.feature.graphical.base.model;

import org.eclipse.emf.ecore.EObject;

public class DwEnumContainerWrapped extends DwEditorChangeableElement{
	public enum EditorAlignment{
		LeftTop,
		LeftBottom,
		RightTop,
		RightBottom,		
		Custum
	}
	
	private EditorAlignment alignment = EditorAlignment.RightTop;
	
	public EditorAlignment getAlignment() {
		return alignment;
	}

	public void setAlignment(EditorAlignment alignment) {
		this.alignment = alignment;
	}

	public DwEnumContainerWrapped(EObject wrappedModelElement) {
		super(wrappedModelElement);
	}

	@Override
	public void notifyProperyChange(String property, Object oldValue, Object newValue) {
		listeners.firePropertyChange(PROPERTY_POSITION, oldValue, newValue);
	} 
}
