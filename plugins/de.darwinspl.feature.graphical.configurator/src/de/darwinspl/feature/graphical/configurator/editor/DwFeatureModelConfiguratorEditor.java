package de.darwinspl.feature.graphical.configurator.editor;

import java.io.IOException;
import java.nio.channels.UnresolvedAddressException;
import java.util.Collections;
import java.util.List;
import java.util.Set;
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
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
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
import de.darwinspl.anomalies.explanations.AnomalyConstraintExplanation;
import de.darwinspl.anomaly.DwAnomaly;
import de.darwinspl.anomaly.DwVoidFeatureModelAnomaly;
import de.darwinspl.feature.graphical.configurator.composites.DwSelectedConfigurationComposite;
import de.darwinspl.feature.graphical.configurator.dialogs.DwAnomalyExplanationDialog;
import de.darwinspl.feature.graphical.configurator.dialogs.DwContextInformationDialog;
import de.darwinspl.feature.graphical.configurator.dialogs.DwInvalidContextInfoDialog;
import de.darwinspl.feature.graphical.configurator.dialogs.DwRESTServerSelectDialog;
import de.darwinspl.feature.graphical.configurator.dialogs.HyVarRecUriAndCredentials;
import de.darwinspl.feature.graphical.configurator.editor.listeners.DwDeriveVariantListener;
import de.darwinspl.feature.graphical.configurator.editor.listeners.DwLoadConfigurationListener;
import de.darwinspl.feature.graphical.configurator.editor.listeners.DwSaveConfigurationListener;
import de.darwinspl.feature.graphical.configurator.factory.DwConfiguratorEditorEditPartFactory;
import de.darwinspl.feature.graphical.configurator.viewer.DwFeatureModelConfiguratorViewer;
import de.darwinspl.preferences.DwProfile;
import de.darwinspl.preferences.util.custom.DwPreferenceModelUtil;
import de.darwinspl.reconfigurator.client.hyvarrec.DwAnalysesClient;
import de.darwinspl.reconfigurator.client.hyvarrec.DwEvolutionOperationAnalyzer;
import de.darwinspl.reconfigurator.client.hyvarrec.HyVarRecNoSolutionException;
import de.darwinspl.solver.DwSolver;
import de.darwinspl.solver.exception.DwAttributeValueOfSelectedFeatureNotSetException;
import eu.hyvar.context.HyContextInformationFactory;
import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.contextValidity.HyValidityModel;
import eu.hyvar.context.contextValidity.util.HyValidityModelUtil;
import eu.hyvar.context.information.contextValue.ContextValueFactory;
import eu.hyvar.context.information.contextValue.HyContextValueModel;
import eu.hyvar.context.information.util.HyContextInformationUtil;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.util.HyConfigurationUtil;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.constraint.util.HyConstraintUtil;

/**
 * 
 * @author Felix Franzke
 *
 */
public class DwFeatureModelConfiguratorEditor extends DwFeatureModelConfiguratorViewer {
	
	private Button validateWithEvolutionButton;
	
	private Button validateContextButton;
	
	private Button detectFeatureAnomaliesButton;
	
	private Button explainButton;
	
	private Button explainWithEvolutionButton;
	
	private Button checkSatisfiabilityButton;
	private Button checkConfigurationValidity;
	
	
//	private Button numberOfPossibleConfigurationsButton;
	private Button simulateButton;
	private DwSelectedConfigurationComposite selectedConfigurationComposite;

	protected HyConfiguration suggestedConfiguration;
	
	private static final String DEFAULT_HYVARREC_URI = "https://www.isf.cs.tu-bs.de/hyvarrec/";
	public static String SAVED_SERVER_URI = "https://www.isf.cs.tu-bs.de/hyvarrec/";
	public static String USERNAME = null;
	public static String PASSWORD = null;
	public static Boolean HTTT_AUTHENTICATION_ENABLED = null;

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
		return (HyContextModel) EcoreIOUtil.loadAccompanyingModel(modelWrapped.getModel(), HyContextInformationUtil.getContextModelFileExtensionForXmi());
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
		validateWithEvolutionButton.setText("Evolution Void Feature Model");
		validateWithEvolutionButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		explainWithEvolutionButton = new Button(configurationPanel, SWT.PUSH);
		explainWithEvolutionButton.setText("Explain Evolution Void Feature Model");
		explainWithEvolutionButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		validateContextButton = new Button(configurationPanel, SWT.PUSH);
		validateContextButton.setText("Detect Void Feature Model");
		validateContextButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		explainButton = new Button(configurationPanel, SWT.PUSH);
		explainButton.setText("Explain Void Feature Model");
		explainButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		detectFeatureAnomaliesButton = new Button(configurationPanel, SWT.PUSH);
		detectFeatureAnomaliesButton.setText("Detect Feature Anomalies");
		detectFeatureAnomaliesButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		simulateButton = new Button(configurationPanel, SWT.PUSH);
		simulateButton.setText("Simulate Reconfiguration");
		simulateButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		
		checkSatisfiabilityButton = new Button(configurationPanel, SWT.PUSH);
		checkSatisfiabilityButton.setText("Check Satisfiability");
		checkSatisfiabilityButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		checkConfigurationValidity = new Button(configurationPanel, SWT.PUSH);
		checkConfigurationValidity.setText("Check Configuration Validity");
		checkConfigurationValidity.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
//		numberOfPossibleConfigurationsButton = new Button(configurationPanel, SWT.PUSH);
//		numberOfPossibleConfigurationsButton.setText("Number of Possible Configurations");
//		numberOfPossibleConfigurationsButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
//		numberOfPossibleConfigurationsButton.setEnabled(false);


		selectedConfigurationComposite = new DwSelectedConfigurationComposite(configurationPanel);
		selectedConfigurationComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));


		return configurationPanel;
	}

	private HyVarRecUriAndCredentials getHyVarRecUriAndCredentials() {

		DwRESTServerSelectDialog dialog = new DwRESTServerSelectDialog(getEditorSite().getShell(), SAVED_SERVER_URI, HTTT_AUTHENTICATION_ENABLED, USERNAME, PASSWORD);
		int result = dialog.open();
		if(result == Dialog.OK){
			HyVarRecUriAndCredentials hyVarRecUriAndCredentials = new HyVarRecUriAndCredentials();
			hyVarRecUriAndCredentials.setUri(dialog.getUri());
			
			SAVED_SERVER_URI =dialog.getUri();
			
			String username = dialog.getUserName();
			Boolean httpAuthEnabled = dialog.getHttpAuthentificationEnabled();
			HTTT_AUTHENTICATION_ENABLED = httpAuthEnabled;
			if(username != null && !username.equals("") && httpAuthEnabled) {
				hyVarRecUriAndCredentials.setUsername(username);
				USERNAME = username;
				
			}
			else {
				hyVarRecUriAndCredentials.setUsername(null);
			}
			
			String password = dialog.getPassword();
			if(password != null && !password.equals("") && httpAuthEnabled) {
				hyVarRecUriAndCredentials.setPassword(password);
				PASSWORD = password;
			}
			else {
				hyVarRecUriAndCredentials.setPassword(null);
			}
			
			return hyVarRecUriAndCredentials;
		}
		else {
			return null;
		}
	}

	protected void registerListeners() {

		super.registerControlListeners();
		
		HyVarRecButtonListener hyVarRecButtonListener = new HyVarRecButtonListener();
		ButtonListener buttonListener = new ButtonListener();
		
		selectedConfiguration.eAdapters().add(new EContentAdapter() {
			@Override
			public void notifyChanged(Notification notification) {
				super.notifyChanged(notification);

				selectedConfigurationComposite.setConfiguration(selectedConfiguration, getCurrentSelectedDate());
			}
		});

		validateWithEvolutionButton.addSelectionListener(hyVarRecButtonListener);
		explainWithEvolutionButton.addSelectionListener(hyVarRecButtonListener);
		
		validateContextButton.addSelectionListener(hyVarRecButtonListener);
		explainButton.addSelectionListener(hyVarRecButtonListener);

		simulateButton.addSelectionListener(hyVarRecButtonListener);

		detectFeatureAnomaliesButton.addSelectionListener(hyVarRecButtonListener);
		
		checkSatisfiabilityButton.addSelectionListener(buttonListener);
		checkConfigurationValidity.addSelectionListener(buttonListener);
		

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

		selectedConfigurationComposite.getSaveConfigurationButton().addSelectionListener(new DwSaveConfigurationListener(this));
		
		selectedConfigurationComposite.getLoadConfigurationButton().addSelectionListener(new DwLoadConfigurationListener(this));

		selectedConfigurationComposite.getDeriveVariantButton().addSelectionListener(new DwDeriveVariantListener(this));
	}
	
	
	@Override
	protected void setInput(IEditorInput input) {
		super.setInput(input);
		selectedConfiguration.setFeatureModel(getFeatureModel());
	}
	
	public void setConfiguration(HyConfiguration configuration) {
//		HyConfiguration newConfiguration = EcoreUtil.copy(configuration);
		this.selectedConfiguration = configuration;
		refreshView();
		
//		while(!selectedConfiguration.getElements().isEmpty()) {
//		}
	}
	
	protected class ButtonListener extends SelectionAdapter {
		@Override
		public void widgetSelected(SelectionEvent e) {
			HyContextModel contextModel = null;
			
			if(modelFileExists(HyContextInformationUtil.getContextModelFileExtensionForXmi())){
				contextModel = loadContextInformationModel();
				
				if(contextModel == null) {
					contextModel = HyContextInformationFactory.eINSTANCE.createHyContextModel();
				}
			}
			else {
				contextModel = HyContextInformationFactory.eINSTANCE.createHyContextModel();
			}
			
			HyConstraintModel constraintModel = null;
			if(modelFileExists(HyConstraintUtil.getConstraintModelFileExtensionForConcreteSyntax())){
				constraintModel = EcoreIOUtil.loadAccompanyingModel(modelWrapped.getModel(), HyConstraintUtil.getConstraintModelFileExtensionForConcreteSyntax());
			}
			else if(modelFileExists(HyConstraintUtil.getConstraintModelFileExtensionForXmi())){
				constraintModel = EcoreIOUtil.loadAccompanyingModel(modelWrapped.getModel(), HyConstraintUtil.getConstraintModelFileExtensionForXmi());
			}
			
			saveConfigurationIntoFeatureModelFolder();
			
			if(e.getSource() == checkSatisfiabilityButton) {
				// TODO check if any of those models is null
				DwSolver solver = new DwSolver(modelWrapped.getModel(), contextModel, modelWrapped.getSelectedDate());
				solver.setConstraintModel(constraintModel, modelWrapped.getSelectedDate());
				
				boolean sat = solver.isSatisfiable();
				
				MessageDialog dialog = new MessageDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Model satisfiability", null,
						"Model satisfiability: "+sat, MessageDialog.INFORMATION, new String[] { "Ok" }, 0);
				dialog.open();
			}
			else if(e.getSource() == checkConfigurationValidity) {
				HyContextValueModel contextValueModel = null;
				
				DwContextInformationDialog contextValueDialog = new DwContextInformationDialog(getEditorSite().getShell(), contextModel, getDate());
				switch(contextValueDialog.open()) {
				case IDialogConstants.CANCEL_ID:
					return;
				case IDialogConstants.OK_ID:
					contextValueModel = contextValueDialog.getContextValueModel();
					break;
				case IDialogConstants.DESELECT_ALL_ID:
					contextValueModel = null;
					break;
				default:
					contextValueModel = null;
					break;
				}
				
				
				DwSolver solver = new DwSolver(modelWrapped.getModel(), contextModel, modelWrapped.getSelectedDate());
				solver.setConstraintModel(constraintModel, modelWrapped.getSelectedDate());
				
				boolean validity = false;
				try {
					validity = solver.isConfigurationValid(selectedConfiguration, contextValueModel);
				} catch (DwAttributeValueOfSelectedFeatureNotSetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				MessageDialog dialog = new MessageDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Configuration validity", null,
						"Configuration validity: "+validity, MessageDialog.INFORMATION, new String[] { "Ok" }, 0);
				dialog.open();
			}
		}
	}
	
	protected class HyVarRecButtonListener extends SelectionAdapter {
		
		@Override
		public void widgetSelected(SelectionEvent e) {
			HyContextModel contextModel = null;
			HyContextValueModel contextValueModel = null;
			
			
			if(modelFileExists(HyContextInformationUtil.getContextModelFileExtensionForXmi())){
				contextModel = loadContextInformationModel();

				// only show the dialog if context information are available
				if(contextModel == null) {
					contextModel = HyContextInformationFactory.eINSTANCE.createHyContextModel();
				}
				
				if(contextModel != null && (e.getSource() == simulateButton || e.getSource() == explainButton || e.getSource() == explainWithEvolutionButton)){
					DwContextInformationDialog dialog = new DwContextInformationDialog(getEditorSite().getShell(), contextModel, getDate());
					switch(dialog.open()) {
					case IDialogConstants.CANCEL_ID:
						return;
					case IDialogConstants.OK_ID:
						contextValueModel = dialog.getContextValueModel();
						break;
					case IDialogConstants.DESELECT_ALL_ID:
						contextValueModel = null;
						break;
					default:
						contextValueModel = null;
						break;
					}
				}
			}
			else {
				contextModel = HyContextInformationFactory.eINSTANCE.createHyContextModel();
//				MessageDialog.openError(getShell(), "No context model", "Reconfiguration not possible as no context information file exists.");
//				return;
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
			else if(modelFileExists(HyValidityModelUtil.getValidityModelFileExtensionForXmi())) {
				validityModel = EcoreIOUtil.loadAccompanyingModel(modelWrapped.getModel(), HyValidityModelUtil.getValidityModelFileExtensionForXmi());
			}

			HyConstraintModel constraintModel = null;
			if(modelFileExists(HyConstraintUtil.getConstraintModelFileExtensionForConcreteSyntax())){
				constraintModel = EcoreIOUtil.loadAccompanyingModel(modelWrapped.getModel(), HyConstraintUtil.getConstraintModelFileExtensionForConcreteSyntax());
			}
			else if(modelFileExists(HyConstraintUtil.getConstraintModelFileExtensionForXmi())){
				constraintModel = EcoreIOUtil.loadAccompanyingModel(modelWrapped.getModel(), HyConstraintUtil.getConstraintModelFileExtensionForXmi());
			}

			DwProfile profile = null;
			if(modelFileExists(DwPreferenceModelUtil.getPreferenceModelFileExtensionForConcreteSyntax())){
				profile = EcoreIOUtil.loadAccompanyingModel(modelWrapped.getModel(), DwPreferenceModelUtil.getPreferenceModelFileExtensionForConcreteSyntax());
			}
			else if(modelFileExists(DwPreferenceModelUtil.getPreferenceModelFileExtensionForXmi())){
				profile = EcoreIOUtil.loadAccompanyingModel(modelWrapped.getModel(), DwPreferenceModelUtil.getPreferenceModelFileExtensionForXmi());
			}

			//
//			if(modelFileExists(ContextInformationUtil.getContextValueModelFileExtensionForXmi())){
//				// TODO type check? other models, too?
//				contextValueModel = EcoreIOUtil.loadAccompanyingModel(modelWrapped.getModel(), ContextInformationUtil.getContextValueModelFileExtensionForXmi());
//			}

			saveConfigurationIntoFeatureModelFolder();

			// allow to change the server uri
			HyVarRecUriAndCredentials hyVarRecUriAndCredentials = getHyVarRecUriAndCredentials();
			
			if(hyVarRecUriAndCredentials == null || hyVarRecUriAndCredentials.getUri() == null) {
				return;
			}

			String uri = hyVarRecUriAndCredentials.getUri();
			String username = hyVarRecUriAndCredentials.getUsername();
			String password = hyVarRecUriAndCredentials.getPassword();

			DwAnalysesClient client = new DwAnalysesClient();

			
			
			
			try {
				if (e.getSource() == validateContextButton) {
					DwVoidFeatureModelAnomaly anomaly = client.validateFeatureModelWithContext(uri, username, password, contextModel,
							validityModel, modelWrapped.getModel(), constraintModel, selectedConfiguration, profile,
							contextValueModel, modelWrapped.getSelectedDate());
					
					DwInvalidContextInfoDialog contextInfoDialog = new DwInvalidContextInfoDialog(
							getEditorSite().getShell(), anomaly);
					contextInfoDialog.open();
				} else if (e.getSource() == simulateButton) {
					HyConfiguration configuration;
					configuration = client.reconfigure(uri, username, password, contextModel, validityModel, modelWrapped.getModel(),
							constraintModel, selectedConfiguration, profile, contextValueModel,
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

//				} else if (e.getSource() == explainButton) {
//					List<String> explainingConstraints = client.explainAnomaly(uri, username, password, contextModel, validityModel, modelWrapped.getModel(),
//							constraintModel, contextValueModel,
//							modelWrapped.getSelectedDate(), null);
//					
//					DwAnomalyExplanationDialog anomalyExplanationDialog = new DwAnomalyExplanationDialog(getEditorSite().getShell(), explainingConstraints);
//					anomalyExplanationDialog.open();
//					
				} else if (e.getSource() == validateWithEvolutionButton) {
					// Show date
					
					DwVoidFeatureModelAnomaly voidFeatureModelAnomaly = client.validateFeatureModelWithContext(uri, username, password,
							contextModel, validityModel, modelWrapped.getModel(), constraintModel,
							selectedConfiguration, profile, contextValueModel, null);
					
					DwInvalidContextInfoDialog contextInfoDialog = new DwInvalidContextInfoDialog(
							getEditorSite().getShell(), voidFeatureModelAnomaly);
					
					contextInfoDialog.open();
				}
//				else if(e.getSource() == explainWithEvolutionButton) {
//					
//					//TODO set context value for evolutoin to current selected date
//					
//					
//					List<String> explainingConstraints = client.explainAnomaly(uri, username, password, contextModel, validityModel, modelWrapped.getModel(),
//							constraintModel, selectedConfiguration, profile, contextValueModel,
//							null, modelWrapped.getSelectedDate());
//					
//					DwAnomalyExplanationDialog anomalyExplanationDialog = new DwAnomalyExplanationDialog(getEditorSite().getShell(), explainingConstraints);
//					anomalyExplanationDialog.open();
//				}
				else if(e.getSource() == detectFeatureAnomaliesButton) {
					List<DwAnomaly> anomalies = client.checkFeatures(uri, username, password, contextModel, validityModel, modelWrapped.getModel(), constraintModel, null, null);
					
					// TODO show anomalies in an extra view and allow their explanation

					DwEvolutionOperationAnalyzer evolutionOperationAnalyzer = new DwEvolutionOperationAnalyzer(client.getExporter());
					evolutionOperationAnalyzer.setFeatureAnomalies(anomalies);
					
					for (DwAnomaly anomaly : anomalies) {
						Set<AnomalyConstraintExplanation> explanation = client.explainAnomaly(uri, username, password, contextModel, validityModel, modelWrapped.getModel(), constraintModel, anomaly, evolutionOperationAnalyzer);
						DwAnomalyExplanationDialog anomalyExplanationDialog = new DwAnomalyExplanationDialog(getEditorSite().getShell(), anomaly, explanation);
						anomalyExplanationDialog.open();	
					}
				}
				
			} catch (UnresolvedAddressException | TimeoutException | InterruptedException | ExecutionException e1) {
				MessageDialog dialog = new MessageDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Unresolvable Server Adress", null,
						"The adress '"+uri.toString()+"' could not be resolved or had a timeout. No configuration was generated.", MessageDialog.ERROR, new String[] { "Ok" }, 0);
				dialog.open();
			} catch (HyVarRecNoSolutionException e1) {
				MessageDialog dialog = new MessageDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "No Solution", null,
						e1.getMessage(), MessageDialog.ERROR, new String[] { "Ok" }, 0);
				dialog.open();
			}
		}
	}
}