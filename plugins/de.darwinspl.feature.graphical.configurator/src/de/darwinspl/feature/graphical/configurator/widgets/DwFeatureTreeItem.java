package de.darwinspl.feature.graphical.configurator.widgets;

import java.util.Date;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.util.HyFeatureEvolutionUtil;

public class DwFeatureTreeItem extends TreeItem{

	private HyFeature feature;
	
	public DwFeatureTreeItem(HyFeature feature, Date date, Tree parent, int style) {
		super(parent, style);
		this.feature = feature;
		this.setText(HyFeatureEvolutionUtil.getName(feature.getNames(), date).getName());
	}
	
	public DwFeatureTreeItem(HyFeature feature, Date date, TreeItem parentItem, int style) {
		super(parentItem, style);
		this.feature = feature;
		this.setText(HyFeatureEvolutionUtil.getName(feature.getNames(), date).getName());
	}
	
	public HyFeature getFeature() {
		return feature;
	}

	@Override
	protected void checkSubclass() {
		// dont check it :)
	}
	
	

}
