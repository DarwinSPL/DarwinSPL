package de.darwinspl.feature.graphical.configurator.widgets;

import eu.hyvar.feature.HyFeatureAttribute;

/**
 * 
 * @author Jeremias Wrensch
 *
 * interface for criteria ui
 */
public interface DwCriteriaComposite {
	
	/**
	 * 
	 * @return true if the criteria is selected
	 */
	boolean isChecked();
	void setLabelText(String text);
	HyFeatureAttribute getAttribute();
	String getAttributeName();
	
}
