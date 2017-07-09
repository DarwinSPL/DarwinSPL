package de.darwinspl.feature.graphical.configurator.widgets;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;

import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.feature.HyEnumAttribute;

public class DwEnumCriteriaComposite  extends DwAbstractCriteriaComposite implements DwCriteriaComposite{

	private CCombo dropdown;
	private HyEnumAttribute attribute;
	
	public DwEnumCriteriaComposite(HyEnumAttribute attribute, Composite parent, int style) {
		super(attribute, parent, style);
		
		this.attribute = attribute;
		
		dropdown = new CCombo(this, SWT.DROP_DOWN);
		List<HyEnumLiteral> literals =  attribute.getEnumType().getLiterals();
		String[] items = new String[literals.size()];
		for(int i = 0; i < literals.size(); i++) {
			items[i] = literals.get(i).getName();
		}
		
		dropdown.setItems(items);
		dropdown.select(0);
	}
	
	public HyEnumLiteral getSelectedEnumLiteral() {
		return attribute.getEnumType().getLiterals().get(dropdown.getSelectionIndex());
	}

}
