package eu.hyvar.feature.graphical.base.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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
	protected List<DwTemporalPosition> positions = new LinkedList<DwTemporalPosition>();
	
	
	protected Dimension size;
	
	public DwTemporalPosition getPosition(Date date) {
		if(date == null)
			return positions.get(0);
		
		for(DwTemporalPosition position : positions){

			Date since = position.getValidSince();
			Date until = position.getValidUntil();
			
			if(since == null && until == null)
				return position;
			else if(since == null && until != null){
				if(date.before(until))
					return position;
			}else if(since != null && until == null){
				if(date.after(since) || date.equals(since))
					return position;
			}else if(since != null && until != null){
				if((date.after(since) || date.equals(since)) && date.before(until)){
					return position;
				}
			}
		}
		
		return null;
	}
	
	/*
	public void setPosition(DwTemporalPosition position) {
		setPosition(position, true);
	}
	*/	
	

	public void addPosition(Point point, Date date, boolean firePropertyChange){
		DwTemporalPosition predecessor;
		if(date != null && date.equals(new Date(Long.MIN_VALUE))){
			date = null;
			
			predecessor = getPosition(date);
			positions.remove(predecessor);
			predecessor = null;
		}else{
			predecessor = getPosition(date);
			predecessor.setValidUntil(date);
		}
		
		
		DwTemporalPosition successor = new DwTemporalPosition(date, null, point);
		int preIndex = positions.indexOf(predecessor);
		
		System.out.println("successor "+successor.getPosition()+ "  "+successor.getValidSince() 
		 +"   "+successor.getValidUntil());
		
		if(preIndex != -1)
			positions.add(positions.indexOf(predecessor), successor);
		else
			positions.add(successor);
		
		if(firePropertyChange)
			listeners.firePropertyChange(PROPERTY_POSITION, predecessor, successor);
	}
	/*
	public void setPosition(DwTemporalPosition position, boolean firePropertyChange) {
		DwTemporalPosition old = this.position;
		this.position = position;

		if(firePropertyChange)
			listeners.firePropertyChange(PROPERTY_POSITION, old, position);
	}	
	*/
	
	public EObject getWrappedModelElement() {
		return wrappedModelElement;
	}
	public void setWrappedModelElement(EObject wrappedModelElement) {
		this.wrappedModelElement = wrappedModelElement;
	}
	
	
	public HyEditorChangeableElement(EObject wrappedModelElement){
		this.wrappedModelElement = wrappedModelElement;
		
		positions.add(new DwTemporalPosition(null, null, new Point(0, 0)));
		
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
