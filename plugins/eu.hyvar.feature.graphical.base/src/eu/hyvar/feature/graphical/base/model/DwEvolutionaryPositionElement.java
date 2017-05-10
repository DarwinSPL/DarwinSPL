package eu.hyvar.feature.graphical.base.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;

public abstract class DwEvolutionaryPositionElement implements DwPropertyChanged{
	public final static String PROPERTY_POSITION = "PropertyPosition";
	
	/*
	 * Position needed to allow repositioning by the user
	 */
	protected List<DwTemporalPosition> positions = new ArrayList<DwTemporalPosition>();
	
	public List<DwTemporalPosition> getPositions(){
		return positions;
	}

	public DwTemporalPosition getFirstPosition(){
		for(DwTemporalPosition position : positions){
			if(position.getPredecessor() == null)
				return position;
		}

		return null;
	}

	public DwTemporalPosition getPosition(Date date) {
		if(date == null)
			return positions.isEmpty() ? null : positions.get(0);

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

	public void addPosition(Point point, Date date, boolean firePropertyChange){
		DwTemporalPosition currentPosition = getPosition(date);
		if(currentPosition == null){
			positions.add(new DwTemporalPosition(null, null, null, null, point));
			return;
		}

		if(date != null && date.equals(new Date(Long.MIN_VALUE))){
			// just change the position
			currentPosition.setPosition(point);

			if(firePropertyChange)
				notifyProperyChange(PROPERTY_POSITION, null, currentPosition);
		}else{ 
			DwTemporalPosition successor = currentPosition.getSuccessor();
			
			if(date.equals(currentPosition.getValidSince())){
				DwTemporalPosition predecessor = currentPosition.getPredecessor();
				if(predecessor != null){
					positions.remove(currentPosition);
					currentPosition = predecessor;
				}else{
					currentPosition = null;
				}
			}
			
			DwTemporalPosition newPosition = new DwTemporalPosition();
			newPosition.setPosition(point);
			newPosition.setValidSince(date);
			
			if(currentPosition != null){
				newPosition.setPredecessor(currentPosition);
				currentPosition.setSuccessor(newPosition);
				currentPosition.setValidUntil(date);
			}

			if(successor != null){	
				newPosition.setSuccessor(successor);
				newPosition.setValidUntil(successor.getValidSince());
				successor.setPredecessor(newPosition);	
			}

			positions.add(newPosition);

			if(firePropertyChange)
				notifyProperyChange(PROPERTY_POSITION, null, currentPosition);
		}
	}

}
