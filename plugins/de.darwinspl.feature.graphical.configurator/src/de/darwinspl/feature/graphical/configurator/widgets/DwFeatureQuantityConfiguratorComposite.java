package de.darwinspl.feature.graphical.configurator.widgets;

import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;

import eu.hyvar.feature.HyFeatureModel;

public class DwFeatureQuantityConfiguratorComposite extends DwAbstractMultiConfiguratorWidget implements DwConfiguratorWidget {

	private CCombo dropdown;
	
	public final static int MIN = 0;
	public final static int MAX = 1;
	
	public DwFeatureQuantityConfiguratorComposite(Composite parent, int style, HyFeatureModel featureModel, Date date) {
		super(parent, style, featureModel, date);
		
		String items[] = new String[2];
		items[MIN] = "Min";
		items[MAX] = "Max";
		
		dropdown = new CCombo(this, SWT.DROP_DOWN);
		dropdown.setItems(items);
		dropdown.select(0);
		
		setLabelText("Feature Quantity");
		
	}
	
	public int getSelection() {
		return dropdown.getSelectionIndex();
	}

}
