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

/**
 * 
 * This Composite represents all selected criteria and their options
 * 
 * @author Jeremias Wrensch
 *
 */
public class DwRowCriteriaComposite extends Composite {

	// list of criterias
	private List<DwAbstractCriteriaComposite> rows = new ArrayList<>();

	private List<HyFeatureAttribute> attributes;

	private HyFeatureModel featureModel;
	private Date date;

	public DwRowCriteriaComposite(List<HyFeatureAttribute> attributes, HyFeatureModel featureModel, Date date,
			Composite parent, int style) {
		super(parent, style);
		setLayout(new RowLayout(SWT.VERTICAL));

		this.featureModel = featureModel;
		this.date = date;
		this.attributes = attributes;

	}

	/**
	 * 
	 * swaps the row with the row above in the ui and in the internal
	 * representation
	 * 
	 * @param row
	 *            the row that should be moved up
	 */
	public void moveUp(DwCriteriaComposite row) {

		for (int i = 0; i < rows.size(); i++) {
			if (i > 0 && rows.get(i) == row) {
				// swap ui position
				rows.get(i).moveAbove(rows.get(i - 1));
				// swap position in rows
				Collections.swap(rows, i, i - 1);
				this.layout();
				return;
			}
		}
	}

	/**
	 * swap the row with the row below in the ui and in the internal
	 * representation
	 * 
	 * @param row
	 *            row that should be moved down
	 */
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

	/**
	 * searches for the HyEnum by its attributes name
	 * 
	 * @param attributeName
	 * @return the first found HyEnum
	 */
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

	/**
	 * adds a row for boolean criteria
	 * 
	 * @param featureModelAttributeNames
	 */
	public void addMultiBooleanCriteria(List<String> featureModelAttributeNames) {
		for (String name : featureModelAttributeNames) {
			DwAbstractCriteriaComposite configuratorWidget = new DwMultiBooleanCriteriaComposite(name, this, SWT.NONE,
					featureModel, date);
			rows.add(configuratorWidget);
		}
	}

	/**
	 * adds a row for a enum criteria
	 * 
	 * @param featureModelAttributeNames
	 */
	public void addMultiEnumCriteria(List<String> featureModelAttributeNames) {
		for (String name : featureModelAttributeNames) {
			DwAbstractCriteriaComposite configuratorWidget = new DwMultiEnumCriteriaComposite(
					findEnumByAttributeName(name), name, this, SWT.NONE, featureModel, date);
			rows.add(configuratorWidget);
		}
	}

	/**
	 * adds a row for a numbered criteria
	 * 
	 * @param featureModelAttributeNames
	 */
	public void addMultiNumberedCriteria(List<String> featureModelAttributeNames) {
		for (String name : featureModelAttributeNames) {

			DwAbstractCriteriaComposite configuratorWidget = new DwMultiNumberedCriteriaComposite(name, this, SWT.NONE,
					featureModel, date);
			rows.add(configuratorWidget);

		}
	}

	/**
	 * adds a row for the feature quantity criteria
	 */
	public void addFeatureQuantityCriteria() {
		rows.add(new DwFeatureQuantityCriteriaComposite(this, SWT.NONE, featureModel, date));
	}

	/**
	 * adds a row for a feature attribute, row type will be defined by the
	 * attributes type
	 * 
	 * @param featureAttributes
	 */
	public void addCriteria(List<HyFeatureAttribute> featureAttributes) {
		for (HyFeatureAttribute featureAttribute : featureAttributes) {

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

	public List<DwAbstractCriteriaComposite> getRows() {
		return rows;
	}

}
