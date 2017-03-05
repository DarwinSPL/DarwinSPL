package eu.hyvar.feature.graphical.base.model;

import java.util.Date;
import org.eclipse.draw2d.geometry.Point;

public class DwTemporalPosition {
	Date validSince;
	Date validUntil;
	
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

	public DwTemporalPosition(Date validSince, Date validUntil, Point position) {
		super();
		this.validSince = validSince;
		this.validUntil = validUntil;
		this.position = position;
	}
}
