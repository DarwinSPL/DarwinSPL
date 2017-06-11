package de.darwinspl.feature.graphical.configurator.widgets;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;

import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;

public class DwMultiEnumAttributeConfiguratorComposite extends DwAbstractConfiguratorWidget
		implements DwConfiguratorWidget {

	private CCombo dropdown;
	private List<HyEnumLiteral> literals = new ArrayList<HyEnumLiteral>();

	public DwMultiEnumAttributeConfiguratorComposite(HyEnum hyEnum, String attributename, Composite parent, int style) {
		super(attributename, parent, style);

		if (hyEnum != null) {
			literals = hyEnum.getLiterals();

			String items[] = new String[literals.size()];

			for (int i = 0; i < literals.size(); i++) {
				items[i] = literals.get(i).getName();
			}

			dropdown = new CCombo(this, SWT.NONE);
			dropdown.setItems(items);
			dropdown.select(0);
		}
	}

	public HyEnumLiteral getSelectedLiteral() {
		return literals.get(dropdown.getSelectionIndex());
	}

}
