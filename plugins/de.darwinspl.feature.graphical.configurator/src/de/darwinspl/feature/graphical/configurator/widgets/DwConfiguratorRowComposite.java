package de.darwinspl.feature.graphical.configurator.widgets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Layout;

import eu.hyvar.feature.HyBooleanAttribute;
import eu.hyvar.feature.HyEnumAttribute;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyNumberAttribute;

public class DwConfiguratorRowComposite extends Composite{
	
	List<DwAbstractConfiguratorWidget> rows = new ArrayList<>();
	
	public DwConfiguratorRowComposite(List<HyFeatureAttribute> attributes, Composite parent, int style) {
		super(parent, style);

		setLayout(new RowLayout(SWT.VERTICAL));
		
		for(HyFeatureAttribute attribute : attributes) {
			if(attribute instanceof HyNumberAttribute) {
				DwAbstractConfiguratorWidget configuratorWidget = new DwSingleNumberedAttributeConfiguratorComposite((HyNumberAttribute)attribute, this, SWT.NONE);
				rows.add(configuratorWidget);
			} else if (attribute instanceof HyEnumAttribute) {
				DwAbstractConfiguratorWidget configuratorWidget = new DwSingleEnumAttributeConfiguratorComposite((HyEnumAttribute)attribute, this, SWT.NONE);
				rows.add(configuratorWidget);
			} else if (attribute instanceof HyBooleanAttribute) {
				DwAbstractConfiguratorWidget configuratorWidget = new DwSingleBooleanAttributeConfiguratorComposite((HyBooleanAttribute)attribute, this, SWT.NONE);
				rows.add(configuratorWidget);
			}
		}
	}
	
	public void moveUp(DwAbstractConfiguratorWidget row) {
				
		for(int i = 0; i < rows.size(); i++) {
			if(i > 0 && rows.get(i-1) == rows.get(i)) {
				rows.get(i).moveAbove(rows.get(i-1));
				Collections.swap(rows, i, i-1);
			}
		}
		this.redraw();
		this.layout();
		this.update();
	}
	
	public void moveDown(DwAbstractConfiguratorWidget row) {
		for(int i = 0; i < rows.size(); i++) {
			if(i < rows.size() - 1 && rows.get(i+1) == rows.get(i)) {
				rows.get(i).moveAbove(rows.get(i+1));
				Collections.swap(rows, i, i+1);
			}
		}
		this.redraw();
		this.layout();
		this.update();
	}
	

}
