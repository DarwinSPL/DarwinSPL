package de.darwinspl.feature.graphical.configurator.dialogs;

import java.util.ArrayList;
import java.util.Date;
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

import de.darwinspl.configurator.Configurator;
import eu.hyvar.evolution.HyName;
import eu.hyvar.evolution.HyNamedElement;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.expression.HyAttributeReferenceExpression;

public class DwConfiguratorDialog extends Dialog {

	private List<String> attributes = new ArrayList<>();
	private HyFeatureModel featureModel;
	private HyConstraintModel constraintModel;
	private Date date;
	private String uri;
	
	private Table table;
	
	private TableColumn colAttributeName;
	private TableColumn colAttributeDefaultValue;
	private TableColumn colAttributeMinMax;

	public DwConfiguratorDialog(Shell parentShell, HyFeatureModel featureModel, HyConstraintModel constraintModel, Date date, String uri) {
		super(parentShell);

		this.featureModel = featureModel;
		this.constraintModel = constraintModel;
		this.date = date;
		this.uri = uri;
		
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
	protected void okPressed() {
		
		for(int i = 0; i < table.getItemCount(); i++) {
			TableItem item = table.getItem(i);
			
			if(item.getChecked()) {
				for(HyFeature feature : featureModel.getFeatures()) {
					for(HyFeatureAttribute attribute : feature.getAttributes()) {
						for (HyName name : attribute.getNames()) {
							if(name.getName().equals(attributes.get(i))) {
								
							}
						}
					}
				}
			}
		}
		
		Configurator configurator = new Configurator();
		configurator.optimizeAttributes(uri, featureModel, constraintModel, date);
		
		super.okPressed();
	}



	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);

		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		table = new Table(composite, SWT.CHECK | SWT.SINGLE);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		colAttributeName = new TableColumn(table, SWT.LEFT);
		colAttributeDefaultValue = new TableColumn(table, SWT.LEFT);
		colAttributeMinMax = new TableColumn(table, SWT.LEFT);
		
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
