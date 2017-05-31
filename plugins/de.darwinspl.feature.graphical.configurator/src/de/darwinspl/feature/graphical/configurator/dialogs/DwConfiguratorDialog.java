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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.darwinspl.configurator.Configurator;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.reconfigurator.output.translation.HyVarRecOutputTranslator;
import eu.hyvar.reconfigurator.output.translation.format.OutputOfHyVarRec;

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
	
	private HyConfiguration configuration;
	
	private CCombo dropdown;

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
	
	public HyConfiguration openWithConfigurationResult(){
		open();
		return configuration;
	}

	@Override
	protected void okPressed() {
		
		String output = null;
		
		Configurator configurator = new Configurator(uri, featureModel, constraintModel, date);

		
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
		
		configurator.addAttributeOptimizationPreference(attributes);
		
		if(dropdown.getSelectionIndex() == 0) {
			configurator.addMaxFeaturesPreference();
		} else if(dropdown.getSelectionIndex() == 1) {
			configurator.addMinFeaturesPreference();
		}
		
		output = configurator.run();
		
		if(output != null) {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();
			OutputOfHyVarRec outputOfHyVarRec  = gson.fromJson(output, OutputOfHyVarRec.class);
			configuration = HyVarRecOutputTranslator.translateConfiguration(featureModel, outputOfHyVarRec, date);
		}
		
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

		
		dropdown = new CCombo(composite, SWT.NONE);
		dropdown.setItems(new String[]{"Max. Features", "Min. Features", "None"});
		dropdown.select(2);
		
		
		colAttributeDefaultValue.pack();
		colAttributeMinMax.pack();
		colAttributeName.pack();
		table.pack();
		composite.pack();

		return composite;
	}

}
