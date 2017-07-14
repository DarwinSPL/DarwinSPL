package de.darwinspl.feature.graphical.configurator.widgets;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;

import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.feature.HyFeatureModel;


/**
 * 
 * ui implementation for enum feature model attribute criterias
 * 
 * @author Jeremias Wrensch
 *
 */
public class DwMultiEnumCriteriaComposite extends DwAbstractMultiCriteriaComposite
		implements DwCriteriaComposite {

	private CCombo dropdown;
	private List<HyEnumLiteral> literals = new ArrayList<HyEnumLiteral>();

	public DwMultiEnumCriteriaComposite(HyEnum hyEnum, String attributename, Composite parent, int style, HyFeatureModel featureModel, Date date) {
		super(attributename, parent, style, featureModel, date);

		if (hyEnum != null) {
			literals = hyEnum.getLiterals();

			String items[] = new String[literals.size()];

			for (int i = 0; i < literals.size(); i++) {
				items[i] = literals.get(i).getName();
			}

			dropdown = new CCombo(this, SWT.BORDER);
			dropdown.setItems(items);
			dropdown.select(0);
		}
	}

	public HyEnumLiteral getSelectedLiteral() {
		return literals.get(dropdown.getSelectionIndex());
	}

}
