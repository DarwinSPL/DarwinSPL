package de.darwinspl.feature.graphical.configurator.widgets;

import eu.hyvar.feature.HyFeatureAttribute;

public interface DwCriteriaComposite {

	boolean isChecked();
	void setLabelText(String text);
	HyFeatureAttribute getAttribute();
	String getAttributeName();
	
}
