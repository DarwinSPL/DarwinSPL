package de.darwinspl.feature.graphical.configurator.dialogs;

import java.util.Date;

import javax.print.attribute.standard.MediaSize.Other;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.darwinspl.configurator.Configurator;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.reconfigurator.output.translation.HyVarRecOutputTranslator;
import eu.hyvar.reconfigurator.output.translation.format.OutputOfHyVarRec;

public class DwSelectConfiguratorDialog extends Dialog {

	private CCombo dropdown;
	
	private Shell parentShell;
	private HyFeatureModel featureModel;
	private HyConstraintModel constraintModel;
	private Date date;
	private String uri;
	
	private HyConfiguration configuration;
	
	public DwSelectConfiguratorDialog(Shell parentShell, HyFeatureModel featureModel, HyConstraintModel constraintModel, Date date, String uri) {
		super(parentShell);
		
		this.parentShell = parentShell;
		this.featureModel = featureModel;
		this.constraintModel = constraintModel;
		this.date = date;
		this.uri = uri;
		
	}

	@Override
	protected void okPressed() {
		int selection = dropdown.getSelectionIndex();
		
		Configurator configurator = new Configurator();
		
		String output = null;
		
		if(selection == 0) {
			output = configurator.minFeatures(uri, featureModel, constraintModel, date);
		} else if(selection == 1){
			output = configurator.maxFeatures(uri, featureModel, constraintModel, date);
		} else if(selection == 2){
			DwConfiguratorDialog configuratorDialog = new DwConfiguratorDialog(parentShell, featureModel, constraintModel, date, uri);
			configuratorDialog.open();
		}
		
		if(output != null) {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();
			OutputOfHyVarRec outputOfHyVarRec  = gson.fromJson(output, OutputOfHyVarRec.class);
			configuration = HyVarRecOutputTranslator.translateConfiguration(featureModel, outputOfHyVarRec, date);
		}
		
		super.okPressed();
	}
	
	public HyConfiguration openWithAnswer() {
		this.open();
		return configuration;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		// TODO Auto-generated method stub
		Composite composite = (Composite) super.createDialogArea(parent);
		
		dropdown = new CCombo(composite, SWT.NONE);
		dropdown.setItems(new String[]{"Min. Features", "Max. Features", "Attribute Optimization"});
		dropdown.select(0);
		
		return composite;
	}

	
}
