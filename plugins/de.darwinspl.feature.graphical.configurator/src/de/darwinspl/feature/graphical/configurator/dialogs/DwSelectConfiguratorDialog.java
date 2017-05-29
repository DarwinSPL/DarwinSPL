package de.darwinspl.feature.graphical.configurator.dialogs;

import java.util.Date;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import de.darwinspl.configurator.Configurator;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.constraint.HyConstraintModel;

public class DwSelectConfiguratorDialog extends Dialog {

	private CCombo dropdown;
	private HyFeatureModel featureModel;
	private HyConstraintModel constraintModel;
	private Date date;
	private String uri;
	
	public DwSelectConfiguratorDialog(Shell parentShell, HyFeatureModel featureModel, HyConstraintModel constraintModel, Date date, String uri) {
		super(parentShell);
		
		this.featureModel = featureModel;
		this.constraintModel = constraintModel;
		this.date = date;
		this.uri = uri;
		
	}

	@Override
	protected void okPressed() {
		int selection = dropdown.getSelectionIndex();
		
		Configurator configurator = new Configurator();
		
		if(selection == 0) {
			configurator.minFeatures(uri, featureModel, constraintModel, date);
		} else if(selection == 1){
			configurator.maxFeatures(uri, featureModel, constraintModel, date);
		} else if(selection == 2){
			
		}
		
		super.okPressed();
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
