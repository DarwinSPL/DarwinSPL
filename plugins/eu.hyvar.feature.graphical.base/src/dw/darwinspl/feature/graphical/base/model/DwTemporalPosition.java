package dw.darwinspl.feature.graphical.base.model;

import java.util.Date;
import org.eclipse.draw2d.geometry.Point;

public class DwTemporalPosition {
	Date validSince;
	Date validUntil;
	
	DwTemporalPosition predecessor;
	DwTemporalPosition successor;
	
	Point position;

	public Date getValidSince() {
		return validSince;
	}

	public void setValidSince(Date validSince) {
		this.validSince = validSince;
	}

	public Date getValidUntil() {
		return validUntil;
	}

	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public DwTemporalPosition getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(DwTemporalPosition predecessor) {
		this.predecessor = predecessor;
	}

	public DwTemporalPosition getSuccessor() {
		return successor;
	}

	public void setSuccessor(DwTemporalPosition successor) {
		this.successor = successor;
	}

	public DwTemporalPosition(){
		position = new Point(0, 0);
	}
	
	public DwTemporalPosition(Date validSince, Date validUntil, DwTemporalPosition predecessor,
			DwTemporalPosition successor, Point position) {
		super();
		this.validSince = validSince;
		this.validUntil = validUntil;
		this.predecessor = predecessor;
		this.successor = successor;
		this.position = position;
	}
}
