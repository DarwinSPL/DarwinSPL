package eu.hyvar.feature.graphical.configurator.editor;

import java.util.Date;


import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.HyConfigurationFactory;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.configurator.composites.HySelectedConfigurationComposite;
import eu.hyvar.feature.graphical.configurator.factory.HyConfiguratorEditPartFactory;
import eu.hyvar.feature.graphical.configurator.output.IHyConfigurationDerivation;

public class HyFeatureModelDeltaModuleConfiguratorEditor extends GraphicalFeatureModelEditor implements IHyConfigurationDerivation{
	private Button validateButton;
	private Button numberOfPossibleConfigurationsButton;
	private HySelectedConfigurationComposite selectedConfigurationComposite;

	HyConfiguration selectedConfiguration;
	
	IHyConfigurationDerivation configurationDerivation;
	
	public HyConfiguration getSelectedConfiguration() {
		return selectedConfiguration;
	}
	
	@Override
	public HyConfiguration getConfiguration() {
		return selectedConfiguration;
	}

	@Override
	public HyFeatureModel getFeatureModel() {
		return getFeatureModel();
	}

	@Override
	public Date getDate() {
		return getCurrentSelectedDate();
	}


	public HyFeatureModelDeltaModuleConfiguratorEditor() {
		super();
		
		selectedConfiguration = HyConfigurationFactory.eINSTANCE.createHyConfiguration();
	}

	/**
	 * Hook the evolution factory into the editor logic and override the standard edit part factory
	 */
	@Override
	public void configureGraphicalViewer() {
		super.configureGraphicalViewer();

		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setEditPartFactory(new HyConfiguratorEditPartFactory(viewer, this));
	}



	@Override
	public void createPartControl(Composite parent) {
	    Composite sash = new Composite(parent, SWT.NONE);
	    sash.setLayout(new FillLayout());
	    sash.setLayoutData(new GridData(GridData.FILL_BOTH));
	    final SashForm sashForm = new SashForm(sash, SWT.HORIZONTAL);

	    // Left sash
	    super.createEditor(sashForm);

		// Right sash
		createConfigurationPanel(sashForm);
	    sashForm.setWeights(new int[] { 4, 1});
	    
	    parent.setLayout(new GridLayout(1, false));
	    super.createSliderControl(parent);
	
	    registerListeners();
	}
	
	@Override
	public void dateChanged(Date date){
		selectedConfiguration.getElements().clear();
		setCurrentSelectedDate(date);
	}
	
	private Composite createConfigurationPanel(Composite parent) {
		Composite configurationPanel = new Composite(parent, SWT.NONE);
		configurationPanel.setLayout(new GridLayout(1, false));

		validateButton = new Button(configurationPanel, SWT.PUSH);
		validateButton.setText("Validate");
		validateButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		numberOfPossibleConfigurationsButton = new Button(configurationPanel, SWT.PUSH);
		numberOfPossibleConfigurationsButton.setText("Number of Possible Configurations");
		numberOfPossibleConfigurationsButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		numberOfPossibleConfigurationsButton.setEnabled(false);
		

		selectedConfigurationComposite = new HySelectedConfigurationComposite(configurationPanel);
		selectedConfigurationComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

	
		return configurationPanel;
	}
	
	private void registerListeners() {
		
		selectedConfiguration.eAdapters().add(new EContentAdapter() {
			@Override
			public void notifyChanged(Notification notification) {
				super.notifyChanged(notification);
				
				selectedConfigurationComposite.setConfiguration(selectedConfiguration, getCurrentSelectedDate());
			}
		});
		
		validateButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//validateFeatureModel();
			}
		});
		
		numberOfPossibleConfigurationsButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//calculateNumberOfPossibleConfigurations();
			}
		});
		
		selectedConfigurationComposite.getCompleteButton().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//autoCompleteVersions();
			}
		});
		
		selectedConfigurationComposite.getUseButton().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//useSelectedConfigurationAsRunningConfiguration();
			}
		});

		selectedConfigurationComposite.getDeriveVariantButton().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
	}
}
