package eu.hyvar.feature.graphical.base.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;

public class HyEditorChangeableElement{
	public final static String PROPERTY_POSITION = "PropertyPosition";
	public static final String PROPERTY_CARDINALITY = "PropertyCardinality";
	protected EObject wrappedModelElement;
	
	protected PropertyChangeSupport listeners;
	
	/*
	 * Position needed for allow repositioning by the user
	 */
	protected Point position;
	
	protected Dimension size;
	
	public Point getPosition(Date date) {
		return position;
	}
	public void setPosition(Point position) {
		Point old = this.position;
		this.position = position;

		listeners.firePropertyChange(PROPERTY_POSITION, old, position);
	}	
	
	public EObject getWrappedModelElement() {
		return wrappedModelElement;
	}
	public void setWrappedModelElement(EObject wrappedModelElement) {
		this.wrappedModelElement = wrappedModelElement;
	}
	
	
	public HyEditorChangeableElement(EObject wrappedModelElement){
		this.wrappedModelElement = wrappedModelElement;
		
		position = new Point(0, 0);
		
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
}
