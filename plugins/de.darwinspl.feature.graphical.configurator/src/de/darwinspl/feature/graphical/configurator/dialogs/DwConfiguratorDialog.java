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
import de.darwinspl.feature.graphical.configurator.widgets.ConfiguratorMode;
import de.darwinspl.feature.graphical.configurator.widgets.DwAbstractConfiguratorWidget;
import de.darwinspl.feature.graphical.configurator.widgets.DwConfiguratorRowComposite;
import de.darwinspl.feature.graphical.configurator.widgets.DwFeatureQuantityConfiguratorComposite;
import de.darwinspl.feature.graphical.configurator.widgets.DwMultiBooleanAttributeConfiguratorComposite;
import de.darwinspl.feature.graphical.configurator.widgets.DwMultiEnumAttributeConfiguratorComposite;
import de.darwinspl.feature.graphical.configurator.widgets.DwMultiNumberedAttributeConfiguratorComposite;
import de.darwinspl.feature.graphical.configurator.widgets.DwSingleBooleanAttributeConfiguratorComposite;
import de.darwinspl.feature.graphical.configurator.widgets.DwSingleEnumAttributeConfiguratorComposite;
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

	private DwConfiguratorRowComposite comp;

	private HyConfiguration configuration;

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

		for (DwAbstractConfiguratorWidget row : comp.getRows()) {
			if (row.isChecked()) {
				builder =  new PreferenceBuilder(featureModel);
				if (row instanceof DwMultiNumberedAttributeConfiguratorComposite) {
					DwMultiNumberedAttributeConfiguratorComposite multiNumberComp = (DwMultiNumberedAttributeConfiguratorComposite)row;
					if(multiNumberComp.getSelectedMode() == ConfiguratorMode.MIN) {
						builder.addMinAttributeExpression(multiNumberComp.getAttributeName(), multiNumberComp.getSelectedValue());
					} else if(multiNumberComp.getSelectedMode() == ConfiguratorMode.MAX) {
						builder.addMaxAttributeExpression(multiNumberComp.getAttributeName(), multiNumberComp.getSelectedValue());
					} else if(multiNumberComp.getSelectedMode() == ConfiguratorMode.CUSTOM) {
						//TODO: custom value
					}
				} else if (row instanceof DwMultiEnumAttributeConfiguratorComposite) {
					DwMultiEnumAttributeConfiguratorComposite multiEnumComp = (DwMultiEnumAttributeConfiguratorComposite)row;
					builder.addEnumPreferenceExpression(multiEnumComp.getAttributeName(), multiEnumComp.getSelectedLiteral());
				} else if (row instanceof DwMultiBooleanAttributeConfiguratorComposite) {
					DwMultiBooleanAttributeConfiguratorComposite multiBoolComp = (DwMultiBooleanAttributeConfiguratorComposite)row;
					builder.addBooleanPreferenceExpression(multiBoolComp.getAttributeName(), multiBoolComp.isTrue());
				} else if (row instanceof DwSingleNumberedAttributeConfiguratorComposite) {

				} else if (row instanceof DwSingleEnumAttributeConfiguratorComposite) {

				} else if (row instanceof DwSingleBooleanAttributeConfiguratorComposite) {

				} else if (row instanceof DwFeatureQuantityConfiguratorComposite) {
					DwFeatureQuantityConfiguratorComposite featureQuantityComp = (DwFeatureQuantityConfiguratorComposite)row;
					if(featureQuantityComp.getSelection() == DwFeatureQuantityConfiguratorComposite.MIN) {
						builder.addMinFeatures();
					} else if(featureQuantityComp.getSelection() == DwFeatureQuantityConfiguratorComposite.MAX) {
						builder.addMaxFeatures();
					}
				}
				configurator.addPreference(builder.build());
			}
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

		comp = new DwConfiguratorRowComposite(attributes, composite, SWT.NONE);


		return composite;
	}

}
