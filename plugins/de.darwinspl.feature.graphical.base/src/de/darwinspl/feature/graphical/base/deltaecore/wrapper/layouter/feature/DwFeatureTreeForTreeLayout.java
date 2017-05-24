package de.darwinspl.feature.graphical.base.deltaecore.wrapper.layouter.feature;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.abego.treelayout.util.AbstractTreeForTreeLayout;

import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.base.model.DwParentChildConnection;

public class DwFeatureTreeForTreeLayout extends AbstractTreeForTreeLayout<DwFeatureWrapped> {
	private Date date;
	
	public DwFeatureTreeForTreeLayout(DwFeatureWrapped root, Date date) {
		super(root);

		this.date = (date != null) ? date : new Date();	
	}


	@Override
	public DwFeatureWrapped getParent(DwFeatureWrapped node) {
		return node.getParentFeature(date);
	}
	
	@Override
	public List<DwFeatureWrapped> getChildrenList(DwFeatureWrapped feature) {
		ArrayList<DwFeatureWrapped> children = new ArrayList<DwFeatureWrapped>();

		for(DwParentChildConnection connection : feature.getChildrenConnections(date)){
			children.add(connection.getTarget());
		}
		
		return children;
	}
}
