package de.darwinspl.feature.graphical.configurator.dialogs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
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
import eu.hyvar.feature.HyBooleanAttribute;
import eu.hyvar.feature.HyEnumAttribute;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyNumberAttribute;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.constraint.HyConstraintModel;
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
		return true;
	}

	@Override
	protected void okPressed() {

		String output = null;

		Configurator configurator = new Configurator(uri, featureModel, constraintModel, date);
		PreferenceBuilder builder;

		for (DwAbstractConfiguratorWidget row : comp.getRows()) {
			if (row.isChecked()) {
				builder = new PreferenceBuilder(featureModel, date);
				if (row instanceof DwMultiNumberedAttributeConfiguratorComposite) {
					DwMultiNumberedAttributeConfiguratorComposite multiNumberComp = (DwMultiNumberedAttributeConfiguratorComposite) row;
					if (multiNumberComp.getSelectedMode() == ConfiguratorMode.MIN) {
						builder.addMinAttributeExpression(multiNumberComp.getAttributeName(),
								multiNumberComp.getSelectedFeatures(), multiNumberComp.useDefaultValue());
					} else if (multiNumberComp.getSelectedMode() == ConfiguratorMode.MAX) {
						builder.addMaxAttributeExpression(multiNumberComp.getAttributeName(),
								multiNumberComp.getSelectedFeatures(), multiNumberComp.useDefaultValue());
					} else if (multiNumberComp.getSelectedMode() == ConfiguratorMode.CUSTOM) {
						builder.addCustomAttribute(multiNumberComp.getAttributeName(),
								multiNumberComp.getSelectedFeatures(), multiNumberComp.getCustomValue());
					}
				} else if (row instanceof DwMultiEnumAttributeConfiguratorComposite) {
					DwMultiEnumAttributeConfiguratorComposite multiEnumComp = (DwMultiEnumAttributeConfiguratorComposite) row;
					builder.addEnumPreferenceExpression(multiEnumComp.getAttributeName(),
							multiEnumComp.getSelectedFeatures(), multiEnumComp.getSelectedLiteral());
				} else if (row instanceof DwMultiBooleanAttributeConfiguratorComposite) {
					DwMultiBooleanAttributeConfiguratorComposite multiBoolComp = (DwMultiBooleanAttributeConfiguratorComposite) row;
					builder.addBooleanPreferenceExpression(multiBoolComp.getAttributeName(),
							multiBoolComp.getSelectedFeatures(), multiBoolComp.isTrue());
				} else if (row instanceof DwSingleNumberedAttributeConfiguratorComposite) {
					DwSingleNumberedAttributeConfiguratorComposite singleNumberComp = (DwSingleNumberedAttributeConfiguratorComposite) row;
					if (singleNumberComp.getSelectedMode() == ConfiguratorMode.MIN) {
						builder.addSingleNumberedAttributeMinimumExpression(
								(HyNumberAttribute) singleNumberComp.getAttribute(),
								singleNumberComp.useDefaultValue());
					} else if (singleNumberComp.getSelectedMode() == ConfiguratorMode.MAX) {
						builder.addSingleNumberedAttributeMaximumExpression(
								(HyNumberAttribute) singleNumberComp.getAttribute(),
								singleNumberComp.useDefaultValue());
					} else if (singleNumberComp.getSelectedMode() == ConfiguratorMode.CUSTOM) {
						builder.addSingleCustomAttribute((HyNumberAttribute) singleNumberComp.getAttribute(),
								singleNumberComp.getCustomValue());
					}
				} else if (row instanceof DwSingleEnumAttributeConfiguratorComposite) {
					DwSingleEnumAttributeConfiguratorComposite singleEnumComp = (DwSingleEnumAttributeConfiguratorComposite) row;
					builder.addSingleEnumAttributeExpression((HyEnumAttribute) singleEnumComp.getAttribute(),
							singleEnumComp.getSelectedEnumLiteral());
				} else if (row instanceof DwSingleBooleanAttributeConfiguratorComposite) {
					DwSingleBooleanAttributeConfiguratorComposite singleBoolComp = (DwSingleBooleanAttributeConfiguratorComposite) row;
					builder.addSingleBooleanExpression((HyBooleanAttribute) singleBoolComp.getAttribute(),
							singleBoolComp.isTrue());
				} else if (row instanceof DwFeatureQuantityConfiguratorComposite) {
					DwFeatureQuantityConfiguratorComposite featureQuantityComp = (DwFeatureQuantityConfiguratorComposite) row;
					if (featureQuantityComp.getSelection() == DwFeatureQuantityConfiguratorComposite.MIN) {
						builder.addMinFeatures(featureQuantityComp.getSelectedFeatures());
					} else if (featureQuantityComp.getSelection() == DwFeatureQuantityConfiguratorComposite.MAX) {
						builder.addMaxFeatures(featureQuantityComp.getSelectedFeatures());
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

		composite.setLayout(new RowLayout(SWT.VERTICAL));

		comp = new DwConfiguratorRowComposite(attributes, featureModel, date, composite, SWT.NONE);

		Button add = new Button(composite, SWT.NONE);
		add.setText("Add");
		add.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				DwConfiguratorSelectionDialog dialog = new DwConfiguratorSelectionDialog(getShell(), attributes, date);
				if (dialog.open() == Dialog.OK) {
					comp.addNumberedFeatureModelAttributes(dialog.getSelectedNumberedAttributeNames());
					comp.addEnumFeatureModelAttributes(dialog.getSelectedEnumAttributeNames());
					comp.addBooleanFeatureModelAttributes(dialog.getSelectedBooleanAttributeNames());
					comp.addFeatureAttributes(dialog.getSelectedFeatureAttributes());
					comp.layout();
					composite.layout();
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});

		return composite;
	}

	@Override
	protected Point getInitialSize() {
		return new Point(800, 480);
	}

}
