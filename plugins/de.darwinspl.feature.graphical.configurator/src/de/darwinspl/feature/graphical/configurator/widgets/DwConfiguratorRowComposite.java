package de.darwinspl.feature.graphical.configurator.widgets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyBooleanAttribute;
import eu.hyvar.feature.HyEnumAttribute;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyNumberAttribute;

public class DwConfiguratorRowComposite extends Composite {

	private List<DwAbstractConfiguratorWidget> rows = new ArrayList<>();

	private List<String> numberedAttributeNames = new ArrayList<String>();
	private List<String> booleanAttributeNames = new ArrayList<String>();
	private List<String> enumAttributeNames = new ArrayList<String>();

	public DwConfiguratorRowComposite(List<HyFeatureAttribute> attributes, Composite parent, int style) {
		super(parent, style);
		setLayout(new RowLayout(SWT.VERTICAL));

		DwAbstractConfiguratorWidget configuratorWidget = new DwFeatureQuantityConfiguratorComposite(this, SWT.NONE);
		rows.add(configuratorWidget);

		for (HyFeatureAttribute attribute : attributes) {
			for (HyName hyName : attribute.getNames()) {
				String name = hyName.getName();
				if (attribute instanceof HyNumberAttribute && !numberedAttributeNames.contains(name)) {
					numberedAttributeNames.add(name);
					configuratorWidget = new DwMultiNumberedAttributeConfiguratorComposite(name, this, SWT.NONE);
					rows.add(configuratorWidget);
				} else if (attribute instanceof HyBooleanAttribute && !booleanAttributeNames.contains(name)) {
					booleanAttributeNames.add(name);
					configuratorWidget = new DwMultiBooleanAttributeConfiguratorComposite(name, this, SWT.NONE);
					rows.add(configuratorWidget);
				} else if (attribute instanceof HyEnumAttribute && !enumAttributeNames.contains(name)) {
					enumAttributeNames.add(name);
					configuratorWidget = new DwMultiEnumAttributeConfiguratorComposite(
							((HyEnumAttribute) attribute).getEnumType(), name, this, SWT.NONE);
					rows.add(configuratorWidget);
				}
			}
		}

		for (HyFeatureAttribute attribute : attributes) {

			if (attribute instanceof HyNumberAttribute) {
				configuratorWidget = new DwSingleNumberedAttributeConfiguratorComposite((HyNumberAttribute) attribute,
						this, SWT.NONE);
				rows.add(configuratorWidget);
			} else if (attribute instanceof HyEnumAttribute) {
				configuratorWidget = new DwSingleEnumAttributeConfiguratorComposite((HyEnumAttribute) attribute, this,
						SWT.NONE);
				rows.add(configuratorWidget);
			} else if (attribute instanceof HyBooleanAttribute) {
				configuratorWidget = new DwSingleBooleanAttributeConfiguratorComposite((HyBooleanAttribute) attribute,
						this, SWT.NONE);
				rows.add(configuratorWidget);
			}
		}
	}

	public void moveUp(DwAbstractConfiguratorWidget row) {

		for (int i = 0; i < rows.size(); i++) {
			if (i > 0 && rows.get(i) == row) {
				rows.get(i).moveAbove(rows.get(i - 1));
				Collections.swap(rows, i, i - 1);
				this.layout();
				return;
			}
		}

	}

	public void moveDown(DwAbstractConfiguratorWidget row) {
		for (int i = 0; i < rows.size(); i++) {
			if (i < rows.size() - 1 && rows.get(i) == row) {
				rows.get(i).moveBelow(rows.get(i + 1));
				Collections.swap(rows, i, i + 1);
				this.layout();
				return;
			}
		}
		
	}

	public List<DwAbstractConfiguratorWidget> getRows() {
		return rows;
	}

}
