package de.darwinspl.feature.graphical.configurator.dialogs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
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
import de.darwinspl.feature.graphical.configurator.widgets.DwAbstractCriteriaComposite;
import de.darwinspl.feature.graphical.configurator.widgets.DwRowCriteriaComposite;
import de.darwinspl.feature.graphical.configurator.widgets.DwFeatureQuantityCriteriaComposite;
import de.darwinspl.feature.graphical.configurator.widgets.DwMultiBooleanCriteriaComposite;
import de.darwinspl.feature.graphical.configurator.widgets.DwMultiEnumCriteriaComposite;
import de.darwinspl.feature.graphical.configurator.widgets.DwMultiNumberedCriteriaComposite;
import de.darwinspl.feature.graphical.configurator.widgets.DwBooleanCriteriaComposite;
import de.darwinspl.feature.graphical.configurator.widgets.DwEnumCriteriaComposite;
import de.darwinspl.feature.graphical.configurator.widgets.DwNumberedCriteriaComposite;
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

public class DwCriteriaOverviewDialog extends Dialog {

	private List<HyFeatureAttribute> attributes = new ArrayList<>();
	private HyFeatureModel featureModel;
	private HyConstraintModel constraintModel;
	private Date date;
	private String uri;

	private DwRowCriteriaComposite comp;

	private HyConfiguration configuration;

	public DwCriteriaOverviewDialog(Shell parentShell, HyFeatureModel featureModel, HyConstraintModel constraintModel,
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
	
	public HyConfiguration getConfiguration() {
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

		for (DwAbstractCriteriaComposite row : comp.getRows()) {
			if (row.isChecked()) {
				builder = new PreferenceBuilder(featureModel, date);
				if (row instanceof DwMultiNumberedCriteriaComposite) {
					DwMultiNumberedCriteriaComposite multiNumberComp = (DwMultiNumberedCriteriaComposite) row;
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
				} else if (row instanceof DwMultiEnumCriteriaComposite) {
					DwMultiEnumCriteriaComposite multiEnumComp = (DwMultiEnumCriteriaComposite) row;
					builder.addEnumPreferenceExpression(multiEnumComp.getAttributeName(),
							multiEnumComp.getSelectedFeatures(), multiEnumComp.getSelectedLiteral());
				} else if (row instanceof DwMultiBooleanCriteriaComposite) {
					DwMultiBooleanCriteriaComposite multiBoolComp = (DwMultiBooleanCriteriaComposite) row;
					builder.addBooleanPreferenceExpression(multiBoolComp.getAttributeName(),
							multiBoolComp.getSelectedFeatures(), multiBoolComp.isTrue());
				} else if (row instanceof DwNumberedCriteriaComposite) {
					DwNumberedCriteriaComposite singleNumberComp = (DwNumberedCriteriaComposite) row;
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
				} else if (row instanceof DwEnumCriteriaComposite) {
					DwEnumCriteriaComposite singleEnumComp = (DwEnumCriteriaComposite) row;
					builder.addSingleEnumAttributeExpression((HyEnumAttribute) singleEnumComp.getAttribute(),
							singleEnumComp.getSelectedEnumLiteral());
				} else if (row instanceof DwBooleanCriteriaComposite) {
					DwBooleanCriteriaComposite singleBoolComp = (DwBooleanCriteriaComposite) row;
					builder.addSingleBooleanExpression((HyBooleanAttribute) singleBoolComp.getAttribute(),
							singleBoolComp.isTrue());
				} else if (row instanceof DwFeatureQuantityCriteriaComposite) {
					DwFeatureQuantityCriteriaComposite featureQuantityComp = (DwFeatureQuantityCriteriaComposite) row;
					if (featureQuantityComp.getSelection() == DwFeatureQuantityCriteriaComposite.MIN) {
						builder.addMinFeatures(featureQuantityComp.getSelectedFeatures());
					} else if (featureQuantityComp.getSelection() == DwFeatureQuantityCriteriaComposite.MAX) {
						builder.addMaxFeatures(featureQuantityComp.getSelectedFeatures());
					}
				}
				configurator.addPreference(builder.build());
			}
		}

		try {
			output = configurator.run();
		} catch (InterruptedException | TimeoutException | ExecutionException e) {
			MessageDialog.openError(getShell(), "Connection Failed", "Connection to HyVarRec instance failed!");
			e.printStackTrace();
		}

		if (output != null) {
			Gson gson = new GsonBuilder().create();
			OutputOfHyVarRec outputOfHyVarRec = gson.fromJson(output, OutputOfHyVarRec.class);
			if(outputOfHyVarRec.getFeatures() == null || outputOfHyVarRec.getFeatures().isEmpty()) {
				MessageDialog.openWarning(getShell(), "No Solution!", "No solution found!");
			} else {
				configuration = HyVarRecOutputTranslator.translateConfiguration(featureModel, outputOfHyVarRec, date);
			}
		}

		super.okPressed();
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);

		composite.setLayout(new RowLayout(SWT.VERTICAL));

		comp = new DwRowCriteriaComposite(attributes, featureModel, date, composite, SWT.NONE);

		Button add = new Button(composite, SWT.NONE);
		add.setText("Add");
		add.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				DwCriteriaSelectionDialog dialog = new DwCriteriaSelectionDialog(getShell(), attributes, date);
				if (dialog.open() == Dialog.OK) {
					comp.addMultiNumberedCriteria(dialog.getSelectedNumberedAttributeNames());
					comp.addMultiEnumCriteria(dialog.getSelectedEnumAttributeNames());
					comp.addMultiBooleanCriteria(dialog.getSelectedBooleanAttributeNames());
					comp.addCriteria(dialog.getSelectedFeatureAttributes());
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
