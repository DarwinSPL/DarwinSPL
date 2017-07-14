package de.darwinspl.feature.graphical.configurator.widgets;

import java.util.Date;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.util.HyFeatureEvolutionUtil;

/**
 * 
 * TreeItem with attribute representation
 * 
 * @author Jeremias Wrensch
 *
 */
public class DwAttributeTreeItem extends TreeItem {
	
	private HyFeatureAttribute attribute;

	public DwAttributeTreeItem(HyFeatureAttribute attribute, Date date,Tree parent, int style) {
		super(parent, style);
		
		init(attribute, date);
	}
	
	private void init(HyFeatureAttribute attribute, Date date) {
		this.attribute = attribute;
		String attributeName = HyFeatureEvolutionUtil.getName(attribute.getNames(), date).getName();
		String featureName = HyFeatureEvolutionUtil.getName(attribute.getFeature().getNames(), date).getName();
		this.setText(featureName + ": " + attributeName);
		
	}

	public DwAttributeTreeItem(HyFeatureAttribute attribute, Date date, TreeItem parent, int style) {
		super(parent, style);
		init(attribute, date);
	}

	@Override
	protected void checkSubclass() {
		// dont check :)
	}
	
	public HyFeatureAttribute getAttribute(){
		return attribute;
	}
	
	

}
