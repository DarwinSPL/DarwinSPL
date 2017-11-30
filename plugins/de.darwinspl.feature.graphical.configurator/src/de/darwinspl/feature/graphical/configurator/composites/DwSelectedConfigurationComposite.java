package de.darwinspl.feature.graphical.configurator.composites;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.dataValues.HyBooleanValue;
import eu.hyvar.dataValues.HyEnumValue;
import eu.hyvar.dataValues.HyNumberValue;
import eu.hyvar.dataValues.HyStringValue;
import eu.hyvar.dataValues.HyValue;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.configuration.HyAttributeValueAssignment;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.HyConfigurationElement;
import eu.hyvar.feature.configuration.HyFeatureSelected;
import eu.hyvar.feature.configuration.HyVersionSelected;

public class DwSelectedConfigurationComposite extends Group {
	private Text textArea;
	private Button completeButton;
	private Button saveConfigurationButton;
	private Button deriveVariantButton;
	private Button loadConfigurationButton;
	
	public DwSelectedConfigurationComposite(Composite parent) {
		super(parent, SWT.NONE);
		assemble();
		setText("Selected Configuration");
	}

	@Override
	protected void checkSubclass() {
	}

	private void assemble() {
		setLayout(new GridLayout(1, false));

		textArea = new Text(this, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
		textArea.setEditable(false);
		textArea.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		completeButton = new Button(this, SWT.PUSH);
		completeButton.setText("Automatically Select Versions");
		completeButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		saveConfigurationButton = new Button(this, SWT.PUSH);
		saveConfigurationButton.setText("Save Configuration");
		saveConfigurationButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		loadConfigurationButton = new Button(this, SWT.PUSH);
		loadConfigurationButton.setText("Load Configuration");
		loadConfigurationButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		deriveVariantButton = new Button(this, SWT.PUSH);
		deriveVariantButton.setText("Derive Variant");
		deriveVariantButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
	}
	
	public List<HyAttributeValueAssignment> getSelectedAttributesForFeature(HyFeatureSelected feature, HyConfiguration config){
		List<HyAttributeValueAssignment> attributes = new ArrayList<>();
		
		for(HyConfigurationElement element: config.getElements()){
			if(element instanceof HyAttributeValueAssignment){
				if(((HyAttributeValueAssignment) element).getAttribute().getFeature().equals(feature.getSelectedFeature())){
					attributes.add((HyAttributeValueAssignment) element);
				}
			}
		}
		
		return attributes;
		
	}
	
	public List<HyVersionSelected> getSelectedVersionForFeature(HyFeatureSelected feature, HyConfiguration config){
		List<HyVersionSelected> attributes = new ArrayList<>();
		
		for(HyConfigurationElement element: config.getElements()){
			if(element instanceof HyVersionSelected){
				if(((HyVersionSelected) element).getSelectedVersion().getFeature().equals(feature.getSelectedFeature())){
					attributes.add((HyVersionSelected) element);
				}
			}
		}
		
		return attributes;
		
	}

	public void setConfiguration(HyConfiguration configuration, Date date) {
		String text = "";

		if (configuration != null) {
			for (HyConfigurationElement element : configuration.getElements()) {
				if (element instanceof HyFeatureSelected) {
					HyFeatureSelected select = (HyFeatureSelected) element;
					HyName name = HyEvolutionUtil.getValidTemporalElement(select.getSelectedFeature().getNames(), date);

					text += name.getName() + "\n";
					
					if(!(select.getSelectedFeature().getVersions().isEmpty())){
						for(HyVersionSelected versionSelected: getSelectedVersionForFeature(select, configuration)){
							HyVersionSelected version = (HyVersionSelected) versionSelected;
							String nameVersion = version.getSelectedVersion().getNumber();

							text += "@" + nameVersion + "\n";
						}
						
					}

					if (((HyFeatureSelected) element).getSelectedFeature().getAttributes().isEmpty() != true) {
						for (HyAttributeValueAssignment attribute : getSelectedAttributesForFeature(select,
								configuration)) {

							HyAttributeValueAssignment selectAtr = (HyAttributeValueAssignment) attribute;
							HyName nameAtr = HyEvolutionUtil
									.getValidTemporalElement(selectAtr.getAttribute().getNames(), date);

							HyValue value = selectAtr.getValue();
							String stringValue;
							if (value instanceof HyNumberValue) {

								stringValue = Integer.toString(((HyNumberValue) value).getValue());
							} else if (value instanceof HyBooleanValue) {
								boolean b = ((HyBooleanValue) value).isValue();
								stringValue = Boolean.toString(b);
							} else if (value instanceof HyStringValue){
								stringValue = ((HyStringValue) value).getValue();
							}else{
								stringValue = ((HyEnumValue) value).getEnumLiteral().getName();
							}

							text += name.getName() + "." + nameAtr.getName() + " = " + stringValue + "\n";
						}
					}
					

				}

			}

		}
		textArea.setText(text);

	}
	
	public Button getCompleteButton() {
		return completeButton;
	}

	public Button getSaveConfigurationButton() {
		return saveConfigurationButton;
	}

	public Button getDeriveVariantButton() {
		return deriveVariantButton;
	}

	public Button getLoadConfigurationButton() {
		return loadConfigurationButton;
	}
	
	
}
