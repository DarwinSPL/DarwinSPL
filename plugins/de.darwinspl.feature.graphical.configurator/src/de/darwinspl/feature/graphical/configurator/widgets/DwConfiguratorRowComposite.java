package de.darwinspl.feature.graphical.configurator.widgets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;

import eu.hyvar.dataValues.HyEnum;
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
	
	private List<HyFeatureAttribute> attributes;
	private List<HyFeatureAttribute> featureAttributes = new ArrayList<>();

	public DwConfiguratorRowComposite(List<HyFeatureAttribute> attributes, Composite parent, int style) {
		super(parent, style);
		setLayout(new RowLayout(SWT.VERTICAL));

		this.attributes = attributes;
		
		DwAbstractConfiguratorWidget configuratorWidget = new DwFeatureQuantityConfiguratorComposite(this, SWT.NONE);
		rows.add(configuratorWidget);

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
	
	public void addBooleanFeatureModelAttributes(List<String> featureModelAttributeNames) {
		for(String name : featureModelAttributeNames) {
			if(!booleanAttributeNames.contains(name)) {
				booleanAttributeNames.add(name);
				DwAbstractConfiguratorWidget configuratorWidget = new DwMultiBooleanAttributeConfiguratorComposite(name, this, SWT.NONE);
				rows.add(configuratorWidget);
			}
		}
	}
	
	public void addEnumFeatureModelAttributes(List<String> featureModelAttributeNames) {
		for(String name : featureModelAttributeNames) {
			if(!enumAttributeNames.contains(name)) {
				enumAttributeNames.add(name);
				DwAbstractConfiguratorWidget configuratorWidget = new DwMultiEnumAttributeConfiguratorComposite(findEnumByAttributeName(name), name, this, SWT.NONE);
				rows.add(configuratorWidget);
			}
		}
	}
	
	private HyEnum findEnumByAttributeName(String attributeName) {
		for (HyFeatureAttribute attribute : attributes) {
			if (attribute instanceof HyEnumAttribute) {
				for (HyName name : attribute.getNames()) {
					if(name.getName().equals(attributeName)) {
						return ((HyEnumAttribute)attribute).getEnumType();
					}
				}
			}
		}
		return null;
	}
	
	public void addNumberedFeatureModelAttributes(List<String> featureModelAttributeNames) {
		for(String name : featureModelAttributeNames) {
			if(!numberedAttributeNames.contains(name)) {
				numberedAttributeNames.add(name);
				DwAbstractConfiguratorWidget configuratorWidget = new DwMultiNumberedAttributeConfiguratorComposite(name, this, SWT.NONE);
				rows.add(configuratorWidget);
			}
		}
	}

	public void addFeatureAttributes(List<HyFeatureAttribute> featureAttributes) {
		for(HyFeatureAttribute featureAttribute : featureAttributes) {
			if(!this.featureAttributes.contains(featureAttribute)) {
				this.featureAttributes.add(featureAttribute);
				
				if (featureAttribute instanceof HyNumberAttribute) {
					DwAbstractConfiguratorWidget configuratorWidget = new DwSingleNumberedAttributeConfiguratorComposite((HyNumberAttribute) featureAttribute,
							this, SWT.NONE);
					rows.add(configuratorWidget);
				} else if (featureAttribute instanceof HyEnumAttribute) {
					DwAbstractConfiguratorWidget configuratorWidget = new DwSingleEnumAttributeConfiguratorComposite((HyEnumAttribute) featureAttribute, this,
							SWT.NONE);
					rows.add(configuratorWidget);
				} else if (featureAttribute instanceof HyBooleanAttribute) {
					DwAbstractConfiguratorWidget configuratorWidget = new DwSingleBooleanAttributeConfiguratorComposite((HyBooleanAttribute) featureAttribute,
							this, SWT.NONE);
					rows.add(configuratorWidget);
				}
				
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
