package de.darwinspl.feature.graphical.editor.template;

import java.util.Date;
import java.util.List;

public class DwFeatureModelOverviewDataObject {

    private Date date;
    private List<DwFeatureModelOverviewChangeDataObject> changes;

    public DwFeatureModelOverviewDataObject(Date date, List<DwFeatureModelOverviewChangeDataObject> changes) {
    	this.date = date;
    	
    	this.changes = changes;
    }

	public Date getDate() {
		return date;
	}

	public List<DwFeatureModelOverviewChangeDataObject> getChanges() {
		return changes;
	}
}
