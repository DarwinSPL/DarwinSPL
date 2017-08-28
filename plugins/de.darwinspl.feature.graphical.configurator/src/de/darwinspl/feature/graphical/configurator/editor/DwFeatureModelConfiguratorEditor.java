package de.darwinspl.feature.graphical.configurator.editor;

import java.io.IOException;
import java.nio.channels.UnresolvedAddressException;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import de.christophseidl.util.ecore.EcoreIOUtil;
import de.darwinspl.feature.graphical.configurator.composites.DwSelectedConfigurationComposite;
import de.darwinspl.feature.graphical.configurator.dialogs.DwContextInformationDialog;
import de.darwinspl.feature.graphical.configurator.dialogs.DwInvalidContextInfoDialog;
import de.darwinspl.feature.graphical.configurator.dialogs.DwRESTServerSelectDialog;
import de.darwinspl.feature.graphical.configurator.editor.listeners.DwDeriveVariantListener;
import de.darwinspl.feature.graphical.configurator.factory.DwConfiguratorEditorEditPartFactory;
import de.darwinspl.feature.graphical.configurator.viewer.DwFeatureModelConfiguratorViewer;
import de.darwinspl.reconfigurator.client.hyvarrec.DwAnalysesClient;
import de.darwinspl.reconfigurator.client.hyvarrec.DwAnalysesClient.DwContextValueEvolutionWrapper;
import eu.hyvar.context.HyContextInformationFactory;
import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.HyContextualInformationBoolean;
import eu.hyvar.context.HyContextualInformationEnum;
import eu.hyvar.context.HyContextualInformationNumber;
import eu.hyvar.context.contextValidity.HyValidityModel;
import eu.hyvar.context.contextValidity.util.HyValidityModelUtil;
import eu.hyvar.context.information.contextValue.ContextValueFactory;
import eu.hyvar.context.information.contextValue.HyContextValue;
import eu.hyvar.context.information.contextValue.HyContextValueModel;
import eu.hyvar.context.information.util.HyContextInformationUtil;
import eu.hyvar.dataValues.HyBooleanValue;
import eu.hyvar.dataValues.HyDataValuesFactory;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.dataValues.HyEnumValue;
import eu.hyvar.dataValues.HyNumberValue;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.util.HyConfigurationUtil;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.constraint.util.HyConstraintUtil;

public class DwFeatureModelConfiguratorEditor extends DwFeatureModelConfiguratorViewer {
	
	private Button validateWithEvolutionButton;
	
	private Button validateContextButton;
	
	private Button explainButton;
	
//	private Button numberOfPossibleConfigurationsButton;
	private Button simulateButton;
	private DwSelectedConfigurationComposite selectedConfigurationComposite;

	protected HyConfiguration suggestedConfiguration;
	
	private static final String DEFAULT_HYVARREC_URI = "http://hyvarhyvarrec-env.eu-west-1.elasticbeanstalk.com/";

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);

		// load an existing configuration model
		if(this.modelFileExists(HyConfigurationUtil.getConfigurationModelFileExtensionForXmi())) {
			selectedConfiguration = this.loadConfigurationModel();
		}
		else {
			selectedConfiguration.setFeatureModel(this.modelWrapped.getModel());			
		}
	}

	/**
	 * Hook the evolution factory into the editor logic and override the standard edit part factory
	 */
	@Override
	public void configureGraphicalViewer() {
		super.configureGraphicalViewer();

		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setEditPartFactory(new DwConfiguratorEditorEditPartFactory(viewer, this));
	}

	private boolean modelFileExists(String extension){
		IPath path = ((IPath)getFile().getFullPath().clone()).removeFileExtension().addFileExtension(extension);

		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();

		IFile file = workspaceRoot.getFile(path);

		return file.exists();		
	}



	
	protected void openConfigurationViewer(String name){
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
		IWorkbenchPage workbenchPage = workbenchWindow.getActivePage();

		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();

		IFile file = workspaceRoot.getFile(Path.fromOSString(name));

		workbench.getDisplay().syncExec(new Runnable(){

			@Override
			public void run() {
				IEditorDescriptor desc = PlatformUI.getWorkbench().
						getEditorRegistry().getDefaultEditor(name);



				try {
					workbenchPage.openEditor(new FileEditorInput(file), desc.getId());
				} catch (PartInitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}			
		});
	}

	private void saveConfigurationIntoFeatureModelFolder(){
		IPath path = ((IPath)getFile().getFullPath().clone()).removeFileExtension().addFileExtension(HyConfigurationUtil.getConfigurationModelFileExtensionForXmi());
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();

		EcoreIOUtil.saveModelAs(selectedConfiguration, workspaceRoot.getFile(path));		
	}

	private HyContextModel loadContextInformationModel(){
		return (HyContextModel) EcoreIOUtil.loadAccompanyingModel(modelWrapped.getModel(), HyContextInformationUtil.getContextModelFileExtensionForConcreteSyntax());
	}

	private HyConfiguration loadConfigurationModel(){
		return (HyConfiguration) EcoreIOUtil.loadAccompanyingModel(modelWrapped.getModel(), HyConfigurationUtil.getConfigurationModelFileExtensionForXmi());
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

	protected Composite createConfigurationPanel(Composite parent) {
		Composite configurationPanel = new Composite(parent, SWT.NONE);
		configurationPanel.setLayout(new GridLayout(1, false));

		
		validateWithEvolutionButton = new Button(configurationPanel, SWT.PUSH);
		validateWithEvolutionButton.setText("Evolution Anomalies");
		validateWithEvolutionButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		validateContextButton = new Button(configurationPanel, SWT.PUSH);
		validateContextButton.setText("Detect Anomalies");
		validateContextButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		explainButton = new Button(configurationPanel, SWT.PUSH);
		explainButton.setText("Explain Anomalies");
		explainButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		simulateButton = new Button(configurationPanel, SWT.PUSH);
		simulateButton.setText("Simulate Reconfiguration");
		simulateButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));


//		numberOfPossibleConfigurationsButton = new Button(configurationPanel, SWT.PUSH);
//		numberOfPossibleConfigurationsButton.setText("Number of Possible Configurations");
//		numberOfPossibleConfigurationsButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
//		numberOfPossibleConfigurationsButton.setEnabled(false);


		selectedConfigurationComposite = new DwSelectedConfigurationComposite(configurationPanel);
		selectedConfigurationComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));


		return configurationPanel;
	}

	private String getURI(){
		DwRESTServerSelectDialog dialog = new DwRESTServerSelectDialog(getEditorSite().getShell(), DEFAULT_HYVARREC_URI);
		int result = dialog.open();
		if(result == Dialog.OK){
			return dialog.getUri();
		}
		else {
			return null;
		}

//		return DEFAULT_HYVARREC_URI;
	}

	protected void registerListeners() {

		super.registerControlListeners();
		
		ButtonListener buttonListener = new ButtonListener();
		
		selectedConfiguration.eAdapters().add(new EContentAdapter() {
			@Override
			public void notifyChanged(Notification notification) {
				super.notifyChanged(notification);

				selectedConfigurationComposite.setConfiguration(selectedConfiguration, getCurrentSelectedDate());
			}
		});

		validateWithEvolutionButton.addSelectionListener(buttonListener);
		
		validateContextButton.addSelectionListener(buttonListener);
		explainButton.addSelectionListener(buttonListener);

		simulateButton.addSelectionListener(buttonListener);

//		numberOfPossibleConfigurationsButton.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				//calculateNumberOfPossibleConfigurations();
//			}
//		});

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

		selectedConfigurationComposite.getDeriveVariantButton().addSelectionListener(new DwDeriveVariantListener(this));
	}

	private static HyContextValueModel createContextValueModel(DwContextInformationDialog dialog) {
		HyContextValueModel contextValueModel = ContextValueFactory.eINSTANCE.createHyContextValueModel();
		
		fillContextValueModelWithBooleanValues(contextValueModel, dialog.getBooleanValueMap());
		
		fillContextValueModelWithEnumValues(contextValueModel, dialog.getEnumValueMap());

		fillContextValueModelWithNumberValues(contextValueModel, dialog.getNumberValueMap());
		
		return contextValueModel;
	}
	
	private static void fillContextValueModelWithBooleanValues(HyContextValueModel contextValueModel, Map<HyContextualInformationBoolean, Boolean> map) {
		for(Entry<HyContextualInformationBoolean, Boolean> entry: map.entrySet()) {
			HyContextValue contextValue = ContextValueFactory.eINSTANCE.createHyContextValue();
			contextValue.setContext(entry.getKey());
			
			HyBooleanValue value = HyDataValuesFactory.eINSTANCE.createHyBooleanValue();
			value.setValue(entry.getValue().booleanValue());
			
			contextValue.setValue(value);
			contextValueModel.getValues().add(contextValue);
		}
	}
	
	private static void fillContextValueModelWithEnumValues(HyContextValueModel contextValueModel, Map<HyContextualInformationEnum, String> map) {
		for(Entry<HyContextualInformationEnum, String> entry: map.entrySet()) {
			HyContextValue contextValue = ContextValueFactory.eINSTANCE.createHyContextValue();
			contextValue.setContext(entry.getKey());
			
			HyEnumValue value = HyDataValuesFactory.eINSTANCE.createHyEnumValue();
			value.setEnum(entry.getKey().getEnumType());
			
			for(HyEnumLiteral literal: entry.getKey().getEnumType().getLiterals()) {
				if(literal.getName().equals(entry.getValue())) {
					value.setEnumLiteral(literal);
					break;
				}
			}
			
			contextValue.setValue(value);
			contextValueModel.getValues().add(contextValue);
		}
	}
		
	private static void fillContextValueModelWithNumberValues(HyContextValueModel contextValueModel, Map<HyContextualInformationNumber, Integer> map) {
		
		for(Entry<HyContextualInformationNumber, Integer> entry: map.entrySet()) {
			HyContextValue contextValue = ContextValueFactory.eINSTANCE.createHyContextValue();
			contextValue.setContext(entry.getKey());
			
			HyNumberValue value = HyDataValuesFactory.eINSTANCE.createHyNumberValue();
			
			value.setValue(entry.getValue());
			
			contextValue.setValue(value);
			contextValueModel.getValues().add(contextValue);
		}
	}
	
	
	@Override
	protected void setInput(IEditorInput input) {
		super.setInput(input);
		selectedConfiguration.setFeatureModel(getFeatureModel());
	}
	
	protected class ButtonListener extends SelectionAdapter {
		
		@Override
		public void widgetSelected(SelectionEvent e) {
			HyContextModel contextModel = null;
			HyContextValueModel contextValueModel = null;
			
			
			if(modelFileExists(HyContextInformationUtil.getContextModelFileExtensionForConcreteSyntax())){
				contextModel = loadContextInformationModel();

				// only show the dialog if context information are available
				if(contextModel == null) {
					contextModel = HyContextInformationFactory.eINSTANCE.createHyContextModel();
				}
				
				if(contextModel != null && (e.getSource() == simulateButton || e.getSource() == explainButton)){
					DwContextInformationDialog dialog = new DwContextInformationDialog(getEditorSite().getShell(), contextModel, getDate());
					if(dialog.open() == Window.CANCEL){
						return;
					} 
					else {
						contextValueModel =  createContextValueModel(dialog);
					}
				}
			}
			else {
				MessageDialog.openError(getShell(), "No context model", "Reconfiguration not possible as no context information file exists.");
				return;
			}
			
//			if(modelFileExists(HyContextInformationUtil.getContextModelFileExtensionForConcreteSyntax())){
//				contextModel = loadContextInformationModel();
//
//				// only show the dialog if context information are available
//				if(contextModel == null) {
//					contextModel = HyContextInformationFactory.eINSTANCE.createHyContextModel();
//				}
//				
//				if(contextModel != null && e.getSource() == simulateButton){
//					HyContextInformationDialog dialog = new HyContextInformationDialog(getEditorSite().getShell(), contextModel, getDate());
//					if(dialog.open() == Window.CANCEL){
//						return;
//					} 
//					else {
//						contextValueModel = createContextValueModel(dialog);
//					}
//				}
//			}
//			else {
//				// TODO inform user that no context model exists
//				return;
//			}

			if(contextValueModel == null) {
				contextValueModel = ContextValueFactory.eINSTANCE.createHyContextValueModel();;
			}
			
			HyValidityModel validityModel = null;
			if(modelFileExists(HyValidityModelUtil.getValidityModelFileExtensionForConcreteSyntax())){
				validityModel = EcoreIOUtil.loadAccompanyingModel(modelWrapped.getModel(), HyValidityModelUtil.getValidityModelFileExtensionForConcreteSyntax());
			}

			HyConstraintModel constraintModel = null;
			if(modelFileExists(HyConstraintUtil.getConstraintModelFileExtensionForConcreteSyntax())){
				constraintModel = EcoreIOUtil.loadAccompanyingModel(modelWrapped.getModel(), HyConstraintUtil.getConstraintModelFileExtensionForConcreteSyntax());
			}

//			HyPreferenceModel preferenceModel = null;
//			if(modelFileExists(HyPreferenceModelUtil.getPreferenceModelFileExtensionForConcreteSyntax())){
//				preferenceModel = EcoreIOUtil.loadAccompanyingModel(modelWrapped.getModel(), HyPreferenceModelUtil.getPreferenceModelFileExtensionForConcreteSyntax());
//			}

			//
//			if(modelFileExists(ContextInformationUtil.getContextValueModelFileExtensionForXmi())){
//				// TODO type check? other models, too?
//				contextValueModel = EcoreIOUtil.loadAccompanyingModel(modelWrapped.getModel(), ContextInformationUtil.getContextValueModelFileExtensionForXmi());
//			}

			saveConfigurationIntoFeatureModelFolder();

			// allow to change the server uri
			String uri = getURI();
			
			if(uri == null) {
				return;
			}


			DwAnalysesClient client = new DwAnalysesClient();

			
			
			
			try {
				if (e.getSource() == validateContextButton) {
					HyContextValueModel notSatisfiableContextValues;
					notSatisfiableContextValues = client.validateFeatureModelWithContext(uri, contextModel,
							validityModel, modelWrapped.getModel(), constraintModel, selectedConfiguration, null,
							contextValueModel, modelWrapped.getSelectedDate()).getContextValueModel();
					DwInvalidContextInfoDialog contextInfoDialog = new DwInvalidContextInfoDialog(
							getEditorSite().getShell(), notSatisfiableContextValues);
					contextInfoDialog.open();
				} else if (e.getSource() == simulateButton) {
					HyConfiguration configuration;
					configuration = client.reconfigure(uri, contextModel, validityModel, modelWrapped.getModel(),
							constraintModel, selectedConfiguration, null, contextValueModel,
							modelWrapped.getSelectedDate());
					if (configuration != null) {
						String fileName = getFile().getFullPath().removeFileExtension().lastSegment();

						String name = getFile().getFullPath().removeFileExtension().removeLastSegments(1)
								.append(fileName + "_Result")
								.addFileExtension(HyConfigurationUtil.getConfigurationModelFileExtensionForXmi())
								.toString();

						// create a new resource for the result configuration
						ResourceSet resSet = new ResourceSetImpl();
						Resource resource = resSet.createResource(URI.createURI(name));
						resource.getContents().add(configuration);

						try {
							resource.save(Collections.EMPTY_MAP);
						} catch (IOException e2) {
							e2.printStackTrace();
						}

						// Show the result within a new viewer
						openConfigurationViewer(name);
					}

				} else if (e.getSource() == explainButton) {
					client.validateFeatureModel(uri, contextModel, validityModel, modelWrapped.getModel(),
							constraintModel, selectedConfiguration, null, contextValueModel,
							modelWrapped.getSelectedDate());
				} else if (e.getSource() == validateWithEvolutionButton) {
					// Show date
					
					DwContextValueEvolutionWrapper notSatisfiableContextValues = client.validateFeatureModelWithContext(uri,
							contextModel, validityModel, modelWrapped.getModel(), constraintModel,
							selectedConfiguration, null, contextValueModel, null);
					
					DwInvalidContextInfoDialog contextInfoDialog = new DwInvalidContextInfoDialog(
							getEditorSite().getShell(), notSatisfiableContextValues);
					
					contextInfoDialog.open();
				}
			} catch (UnresolvedAddressException | TimeoutException | InterruptedException | ExecutionException e1) {
				MessageDialog dialog = new MessageDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Unresolvable Server Adress", null,
						"The adress '"+uri.toString()+"' could not be resolved or had a timeout. No configuration was generated.", MessageDialog.ERROR, new String[] { "Ok" }, 0);
				dialog.open();
			}
		}
	}
}