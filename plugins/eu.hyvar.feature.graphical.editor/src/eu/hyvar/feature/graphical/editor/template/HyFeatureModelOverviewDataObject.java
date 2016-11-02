package eu.hyvar.feature.graphical.editor.template;

import java.util.Date;
import java.util.List;

public class HyFeatureModelOverviewDataObject {

    private Date date;
    private List<HyFeatureModelOverviewChangeDataObject> changes;

    public HyFeatureModelOverviewDataObject(Date date, List<HyFeatureModelOverviewChangeDataObject> changes) {
    	this.date = date;
    	
    	this.changes = changes;
    }

	public Date getDate() {
		return date;
	}

	public List<HyFeatureModelOverviewChangeDataObject> getChanges() {
		return changes;
	}
}
