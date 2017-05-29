package de.darwinspl.feature.graphical.configurator.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureModel;

public class DwConfiguratorDialog extends Dialog {

	List<String> attributes = new ArrayList<>();

	public DwConfiguratorDialog(Shell parentShell, HyFeatureModel featureModel) {
		super(parentShell);

		for (HyFeature feature : featureModel.getFeatures()) {
			for (HyFeatureAttribute attribute : feature.getAttributes()) {
				for (HyName name : attribute.getNames()) {
					if (!attributes.contains(name.getName()))
						attributes.add(name.getName());
				}
			}
		}
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);

		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Table table = new Table(composite, SWT.CHECK | SWT.SINGLE);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn colAttributeName = new TableColumn(table, SWT.LEFT);
		TableColumn colAttributeDefaultValue = new TableColumn(table, SWT.LEFT);
		TableColumn colAttributeMinMax = new TableColumn(table, SWT.LEFT);
		
		colAttributeName.setText("Attributes");
		colAttributeDefaultValue.setText("Default Value");
		colAttributeMinMax.setText("Min or Max");
		
		colAttributeName.setWidth(100);
		colAttributeDefaultValue.setWidth(100);
		colAttributeMinMax.setWidth(100);
		
		for (String attribute : attributes) {
			
			// fill attribute names
			TableEditor editor = new TableEditor(table);
			Text text = new Text(table, SWT.NONE);
			text.setText(attribute);
			text.setEditable(false);
			editor.grabHorizontal = true;
			TableItem item = new TableItem(table, SWT.NONE);
			editor.setEditor(text, item, 0);
			
			// fill default values
			// TODO: verify input
			editor = new TableEditor(table);
			text = new Text(table, SWT.NONE);
			text.setText("0");
			text.setEditable(true);
			editor.grabHorizontal = true;
			editor.setEditor(text, item, 1);
			
			// min max selection
			editor = new TableEditor(table);
			CCombo dropdown = new CCombo(table, SWT.NONE);
			dropdown.setItems(new String[]{"MIN", "MAX"});
			dropdown.select(0);
			editor.grabHorizontal = true;
			editor.setEditor(dropdown, item, 2);
			
			
		}

		colAttributeName.pack();
		table.pack();
		composite.pack();

		return composite;
	}

}
