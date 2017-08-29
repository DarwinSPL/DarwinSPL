package de.darwinspl.feature.graphical.configurator.composites;

import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.HyConfigurationElement;
import eu.hyvar.feature.configuration.HyFeatureSelected;
import eu.hyvar.feature.configuration.HyVersionSelected;

public class DwSelectedConfigurationComposite extends Group {
	private Text textArea;
	private Button completeButton;
	private Button saveConfigurationButton;
	private Button deriveVariantButton;
	
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
		
		deriveVariantButton = new Button(this, SWT.PUSH);
		deriveVariantButton.setText("Derive Variant");
		deriveVariantButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
	}

	public void setConfiguration(HyConfiguration configuration, Date date) {
		String text = "";

		if (configuration != null) {
			for(HyConfigurationElement element : configuration.getElements()){
				if(element instanceof HyFeatureSelected){
					HyFeatureSelected select = (HyFeatureSelected)element;
					HyName name = HyEvolutionUtil.getValidTemporalElement(select.getSelectedFeature().getNames(), date);
					
					text += name.getName() + "\n";
				}
				if(element instanceof HyVersionSelected){
					HyVersionSelected select = (HyVersionSelected)element;
					String name = select.getSelectedVersion().getNumber();
					
					text += "@"+name + "\n";
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
}
