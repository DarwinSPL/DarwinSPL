package de.darwinspl.feature.graphical.base.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.ecore.EObject;


public class DwEditorChangeableElement extends DwEvolutionaryPositionElement{

	public final static String PROPERTY_HAS_MARKER = "PropertyHasMarker";
	public final static String PROPERTY_POSITION = "PropertyPosition";
	public static final String PROPERTY_CARDINALITY = "PropertyCardinality";
	protected EObject wrappedModelElement;

	protected PropertyChangeSupport listeners;

	protected Dimension size;


	public EObject getWrappedModelElement() {
		return wrappedModelElement;
	}
	public void setWrappedModelElement(EObject wrappedModelElement) {
		this.wrappedModelElement = wrappedModelElement;
	}


	public DwEditorChangeableElement(EObject wrappedModelElement){
		this.wrappedModelElement = wrappedModelElement;

		//positions.add(new DwTemporalPosition());

		listeners = new PropertyChangeSupport(this);
	}
	public void addPropertyChangeListener(PropertyChangeListener listener){
		listeners.addPropertyChangeListener(listener);
	}
	public void removePropertyChangeListener(PropertyChangeListener listener){
		listeners.removePropertyChangeListener(listener);
	}

	public PropertyChangeSupport getListeners() {
		return listeners;
	}
	public void setListeners(PropertyChangeSupport listeners) {
		this.listeners = listeners;
	}

	@Override
	public void notifyProperyChange(String property, Object oldValue, Object newValue) {
		listeners.firePropertyChange(property, oldValue, newValue);
	}
}
