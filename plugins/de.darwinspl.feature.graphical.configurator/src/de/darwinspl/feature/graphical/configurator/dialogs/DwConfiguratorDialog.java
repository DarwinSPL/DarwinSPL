package de.darwinspl.feature.graphical.configurator.dialogs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
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
import de.darwinspl.configurator.PreferenceBuilder;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.preferences.HyPreference;
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
	private TableColumn colAttributeMax;
	private TableColumn colAttributeMin;
	private TableColumn colAttributeCustom;

	private HyConfiguration configuration;

	private CCombo dropdown;

	public DwConfiguratorDialog(Shell parentShell, HyFeatureModel featureModel, HyConstraintModel constraintModel,
			Date date, String uri) {
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

	public HyConfiguration openWithConfigurationResult() {
		open();
		return configuration;
	}

	@Override
	protected void okPressed() {

		String output = null;

		Configurator configurator = new Configurator(uri, featureModel, constraintModel, date);
		PreferenceBuilder builder = new PreferenceBuilder(featureModel);

		for (int i = 0; i < table.getItemCount(); i++) {
			TableItem item = table.getItem(i);

			if (item.getChecked()) {
				builder.addMinAttributeExpression(attributes.get(i), PreferenceBuilder.Mode.MIN);
			}
		}

		configurator.addPreference(builder.build());

		if (dropdown.getSelectionIndex() == 0) {
			builder = new PreferenceBuilder(featureModel);
			HyPreference preference = builder.addMaxFeatures().build();
			configurator.addPreference(preference);
		} else if (dropdown.getSelectionIndex() == 1) {
			builder = new PreferenceBuilder(featureModel);
			HyPreference preference = builder.addMinFeatures().build();
			configurator.addPreference(preference);
		}

		output = configurator.run();

		if (output != null) {
			Gson gson = new GsonBuilder().create();
			OutputOfHyVarRec outputOfHyVarRec = gson.fromJson(output, OutputOfHyVarRec.class);
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
		colAttributeMin = new TableColumn(table, SWT.LEFT);
		colAttributeMax = new TableColumn(table, SWT.LEFT);
		colAttributeCustom = new TableColumn(table, SWT.LEFT);

		colAttributeName.setText("Attributes");
		colAttributeMin.setText("Min");
		colAttributeMax.setText("Max");
		colAttributeCustom.setText("Custom");

		colAttributeName.setWidth(100);
		colAttributeMin.setWidth(100);
		colAttributeMax.setWidth(100);
		colAttributeCustom.setWidth(100);

		for (String attribute : attributes) {

			// fill attribute names
			TableEditor editor = new TableEditor(table);
			Text text = new Text(table, SWT.NONE);
			text.setText(attribute);
			text.setEditable(false);
			editor.grabHorizontal = true;
			TableItem item = new TableItem(table, SWT.NONE);
			editor.setEditor(text, item, 0);

			editor = new TableEditor(table);
			Button btn = new Button(table, SWT.CHECK);
			btn.setText("MIN");
			editor.setEditor(btn, item, 1);

			// min selection
			editor = new TableEditor(table);
			btn = new Button(table, SWT.CHECK);
			btn.setText("MAX");
			editor.setEditor(btn, item, 2);

			editor = new TableEditor(table);
			btn = new Button(table, SWT.CHECK);
			btn.setText("CUSTOM");
			editor.setEditor(btn, item, 3);

		}

		dropdown = new CCombo(composite, SWT.NONE);
		dropdown.setItems(new String[] { "Max. Features", "Min. Features", "None" });
		dropdown.select(2);

		// composite.pack();

		return composite;
	}

}
