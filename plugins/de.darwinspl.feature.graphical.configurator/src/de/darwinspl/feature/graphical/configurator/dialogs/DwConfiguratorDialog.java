package de.darwinspl.feature.graphical.configurator.dialogs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.darwinspl.configurator.Configurator;
import de.darwinspl.configurator.PreferenceBuilder;
import de.darwinspl.feature.graphical.configurator.widgets.DwAbstractConfiguratorWidget;
import de.darwinspl.feature.graphical.configurator.widgets.DwConfiguratorRowComposite;
import de.darwinspl.feature.graphical.configurator.widgets.DwSingleNumberedAttributeConfiguratorComposite;
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

	private List<HyFeatureAttribute> attributes = new ArrayList<>();
	private HyFeatureModel featureModel;
	private HyConstraintModel constraintModel;
	private Date date;
	private String uri;


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
			attributes.addAll(feature.getAttributes());
		}
	}

	public HyConfiguration openWithConfigurationResult() {
		open();
		return configuration;
	}
	
	

	@Override
	protected boolean isResizable() {
		// TODO Auto-generated method stub
		return true;
	}

	
	
	@Override
	protected void okPressed() {

		String output = null;

		Configurator configurator = new Configurator(uri, featureModel, constraintModel, date);
		PreferenceBuilder builder = new PreferenceBuilder(featureModel);
		
		boolean expressionAdded = false;
//		for (int i = 0; i < table.getItemCount(); i++) {
//			TableItem item = table.getItem(i);
//
//			if (item.getChecked()) {
//				if(((Button)item.getData(MIN)).getSelection()) {
//					builder.addMinAttributeExpression(attributes.get(i), PreferenceBuilder.Mode.MIN);
//				} else if(((Button)item.getData(MAX)).getSelection()) {
//					builder.addMaxAttributeExpression(attributes.get(i), PreferenceBuilder.Mode.MIN);
//				} else  if(((Button)item.getData(CUSTOM)).getSelection()) {
//					builder.addMinAttributeExpression(attributes.get(i), PreferenceBuilder.Mode.MIN);
//				}
//				builder.addCustomAttribute(attributes.get(i), PreferenceBuilder.Mode.MIN, 50);
//				expressionAdded = true;
//			}
//		}

		if(expressionAdded) configurator.addPreference(builder.build());

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
	

		composite.setLayout(new FillLayout(SWT.VERTICAL));
		
		DwConfiguratorRowComposite comp = new DwConfiguratorRowComposite(attributes, composite, SWT.NONE);

//
//		dropdown = new CCombo(composite, SWT.NONE);
//		dropdown.setItems(new String[] { "Max. Features", "Min. Features", "None" });
//		dropdown.select(2);
//
//		table.pack();
		// composite.pack();

		return composite;
	}

	
	
}
