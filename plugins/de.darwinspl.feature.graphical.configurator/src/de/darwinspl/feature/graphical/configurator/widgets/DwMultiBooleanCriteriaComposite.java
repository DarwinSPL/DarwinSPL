package de.darwinspl.feature.graphical.configurator.widgets;

import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import eu.hyvar.feature.HyFeatureModel;

public class DwMultiBooleanCriteriaComposite extends DwAbstractMultiCriteriaComposite implements DwCriteriaComposite {

	Button booleanCheckbox;
	
	public DwMultiBooleanCriteriaComposite(String attributename, Composite parent, int style, HyFeatureModel featureModel, Date date) {
		super(attributename, parent, style, featureModel, date);
		
		booleanCheckbox = new Button(this, SWT.CHECK);
		booleanCheckbox.setText("True");
	}
	
	public boolean isTrue() {
		return booleanCheckbox.getSelection();
	}

}
