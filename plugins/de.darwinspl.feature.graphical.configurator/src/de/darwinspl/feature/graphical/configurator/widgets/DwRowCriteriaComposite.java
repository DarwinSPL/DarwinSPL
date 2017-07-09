package de.darwinspl.feature.graphical.configurator.widgets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;

import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyBooleanAttribute;
import eu.hyvar.feature.HyEnumAttribute;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyNumberAttribute;

public class DwRowCriteriaComposite extends Composite {

	private List<DwAbstractCriteriaComposite> rows = new ArrayList<>();

	private List<String> numberedAttributeNames = new ArrayList<String>();
	private List<String> booleanAttributeNames = new ArrayList<String>();
	private List<String> enumAttributeNames = new ArrayList<String>();

	private List<HyFeatureAttribute> attributes;
	private List<HyFeatureAttribute> featureAttributes = new ArrayList<>();

	private HyFeatureModel featureModel;
	private Date date;

	public DwRowCriteriaComposite(List<HyFeatureAttribute> attributes, HyFeatureModel featureModel, Date date,
			Composite parent, int style) {
		super(parent, style);
		setLayout(new RowLayout(SWT.VERTICAL));

		this.featureModel = featureModel;
		this.date = date;
		this.attributes = attributes;

		DwAbstractCriteriaComposite configuratorWidget = new DwFeatureQuantityCriteriaComposite(this, SWT.NONE, featureModel, date);
		rows.add(configuratorWidget);

	}

	public void moveUp(DwCriteriaComposite row) {

		for (int i = 0; i < rows.size(); i++) {
			if (i > 0 && rows.get(i) == row) {
				rows.get(i).moveAbove(rows.get(i - 1));
				Collections.swap(rows, i, i - 1);
				this.layout();
				return;
			}
		}
	}
	
	public void moveDown(DwAbstractCriteriaComposite row) {
		for (int i = 0; i < rows.size(); i++) {
			if (i < rows.size() - 1 && rows.get(i) == row) {
				rows.get(i).moveBelow(rows.get(i + 1));
				Collections.swap(rows, i, i + 1);
				this.layout();
				return;
			}
		}
	}

	private HyEnum findEnumByAttributeName(String attributeName) {
		for (HyFeatureAttribute attribute : attributes) {
			if (attribute instanceof HyEnumAttribute) {
				for (HyName name : attribute.getNames()) {
					if (name.getName().equals(attributeName)) {
						return ((HyEnumAttribute) attribute).getEnumType();
					}
				}
			}
		}
		return null;
	}
	
	public void addMultiBooleanCriteria(List<String> featureModelAttributeNames) {
		for (String name : featureModelAttributeNames) {
			if (!booleanAttributeNames.contains(name)) {
				booleanAttributeNames.add(name);
				DwAbstractCriteriaComposite configuratorWidget = new DwMultiBooleanCriteriaComposite(name,
						this, SWT.NONE, featureModel, date);
				rows.add(configuratorWidget);
			}
		}
	}

	public void addMultiEnumCriteria(List<String> featureModelAttributeNames) {
		for (String name : featureModelAttributeNames) {
			if (!enumAttributeNames.contains(name)) {
				enumAttributeNames.add(name);
				DwAbstractCriteriaComposite configuratorWidget = new DwMultiEnumCriteriaComposite(
						findEnumByAttributeName(name), name, this, SWT.NONE, featureModel, date);
				rows.add(configuratorWidget);
			}
		}
	}

	public void addMultiNumberedCriteria(List<String> featureModelAttributeNames) {
		for (String name : featureModelAttributeNames) {
			if (!numberedAttributeNames.contains(name)) {
				numberedAttributeNames.add(name);
				DwAbstractCriteriaComposite configuratorWidget = new DwMultiNumberedCriteriaComposite(
						name, this, SWT.NONE, featureModel, date);
				rows.add(configuratorWidget);
			}
		}
	}

	public void addCriteria(List<HyFeatureAttribute> featureAttributes) {
		for (HyFeatureAttribute featureAttribute : featureAttributes) {
			if (!this.featureAttributes.contains(featureAttribute)) {
				this.featureAttributes.add(featureAttribute);

				if (featureAttribute instanceof HyNumberAttribute) {
					DwAbstractCriteriaComposite configuratorWidget = new DwNumberedCriteriaComposite(
							(HyNumberAttribute) featureAttribute, this, SWT.NONE);
					rows.add(configuratorWidget);
				} else if (featureAttribute instanceof HyEnumAttribute) {
					DwAbstractCriteriaComposite configuratorWidget = new DwEnumCriteriaComposite(
							(HyEnumAttribute) featureAttribute, this, SWT.NONE);
					rows.add(configuratorWidget);
				} else if (featureAttribute instanceof HyBooleanAttribute) {
					DwAbstractCriteriaComposite configuratorWidget = new DwBooleanCriteriaComposite(
							(HyBooleanAttribute) featureAttribute, this, SWT.NONE);
					rows.add(configuratorWidget);
				}

			}
		}
	}

	

	public List<DwAbstractCriteriaComposite> getRows() {
		return rows;
	}

}
