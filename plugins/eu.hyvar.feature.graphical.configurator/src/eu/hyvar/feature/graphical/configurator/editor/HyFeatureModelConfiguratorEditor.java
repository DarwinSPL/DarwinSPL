package eu.hyvar.feature.graphical.configurator.editor;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

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
import eu.hyvar.feature.graphical.configurator.composites.HySelectedConfigurationComposite;
import eu.hyvar.feature.graphical.configurator.dialogs.DwRESTServerSelectDialog;
import eu.hyvar.feature.graphical.configurator.dialogs.HyContextInformationDialog;
import eu.hyvar.feature.graphical.configurator.editor.listeners.DwDeriveVariantListener;
import eu.hyvar.feature.graphical.configurator.factory.HyConfiguratorEditorEditPartFactory;
import eu.hyvar.feature.graphical.configurator.reconfigurator.HyReconfiguratorClient;
import eu.hyvar.feature.graphical.configurator.viewer.HyFeatureModelConfiguratorViewer;
import eu.hyvar.preferences.HyPreferenceModel;
import eu.hyvar.preferences.util.HyPreferenceModelUtil;

public class HyFeatureModelConfiguratorEditor extends HyFeatureModelConfiguratorViewer {
	private Button validateButton;
	private Button numberOfPossibleConfigurationsButton;
	private Button simulateButton;
	private HySelectedConfigurationComposite selectedConfigurationComposite;

	HyConfiguration suggestedConfiguration;
	
	private static final String DEFAULT_HYVARREC_URI = "http://hyvarhyvarrec-env.eu-west-1.elasticbeanstalk.com/process";

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);

		// load an existing configuration model
		if(this.modelFileExists(HyConfigurationUtil.getConfigurationModelFileExtensionForXmi()))
			selectedConfiguration = this.loadConfigurationModel();
		else
			selectedConfiguration.setFeatureModel(this.modelWrapped.getModel());
	}

	/**
	 * Hook the evolution factory into the editor logic and override the standard edit part factory
	 */
	@Override
	public void configureGraphicalViewer() {
		super.configureGraphicalViewer();

		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setEditPartFactory(new HyConfiguratorEditorEditPartFactory(viewer, this));
	}

	private boolean modelFileExists(String extension){
		IPath path = ((IPath)file.getFullPath().clone()).removeFileExtension().addFileExtension(extension);

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
		IPath path = ((IPath)file.getFullPath().clone()).removeFileExtension().addFileExtension(HyConfigurationUtil.getConfigurationModelFileExtensionForXmi());
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

	private Composite createConfigurationPanel(Composite parent) {
		Composite configurationPanel = new Composite(parent, SWT.NONE);
		configurationPanel.setLayout(new GridLayout(1, false));

		validateButton = new Button(configurationPanel, SWT.PUSH);
		validateButton.setText("Validate");
		validateButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		simulateButton = new Button(configurationPanel, SWT.PUSH);
		simulateButton.setText("Simulate Reconfiguration with HyVarRec");
		simulateButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));


		numberOfPossibleConfigurationsButton = new Button(configurationPanel, SWT.PUSH);
		numberOfPossibleConfigurationsButton.setText("Number of Possible Configurations");
		numberOfPossibleConfigurationsButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		numberOfPossibleConfigurationsButton.setEnabled(false);


		selectedConfigurationComposite = new HySelectedConfigurationComposite(configurationPanel);
		selectedConfigurationComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));


		return configurationPanel;
	}

	private java.net.URI getURI(){
		java.net.URI defaultURI = java.net.URI.create(DEFAULT_HYVARREC_URI);
		DwRESTServerSelectDialog dialog = new DwRESTServerSelectDialog(getEditorSite().getShell(), defaultURI);
		int result = dialog.open();
		if(result == Dialog.OK){
			return dialog.getUri();
		}

		return defaultURI;
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
				//TODO validateFeatureModel();
			}
		});

		simulateButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				HyContextModel contextModel = null;
				HyContextValueModel contextValueModel = null;
				
				if(modelFileExists(HyContextInformationUtil.getContextModelFileExtensionForConcreteSyntax())){
					contextModel = loadContextInformationModel();

					// only show the dialog if context information are available
					if(contextModel != null){
						HyContextInformationDialog dialog = new HyContextInformationDialog(getEditorSite().getShell(), contextModel, getDate());
						if(dialog.open() == Window.CANCEL){
							return;
						} 
						else {
							contextValueModel = createContextValueModel(dialog);
						}
					}
				}
				else {
					// TODO inform user that no context model exists
					return;
				}

				if(contextValueModel == null) {
					return;
				}
				
				HyValidityModel validityModel = null;
				if(modelFileExists(HyValidityModelUtil.getValidityModelFileExtensionForConcreteSyntax())){
					validityModel = EcoreIOUtil.loadAccompanyingModel(modelWrapped.getModel(), HyValidityModelUtil.getValidityModelFileExtensionForConcreteSyntax());
				}

				HyConstraintModel constraintModel = null;
				if(modelFileExists(HyConstraintUtil.getConstraintModelFileExtensionForConcreteSyntax())){
					constraintModel = EcoreIOUtil.loadAccompanyingModel(modelWrapped.getModel(), HyConstraintUtil.getConstraintModelFileExtensionForConcreteSyntax());
				}

				HyPreferenceModel preferenceModel = null;
				if(modelFileExists(HyPreferenceModelUtil.getPreferenceModelFileExtensionForConcreteSyntax())){
					preferenceModel = EcoreIOUtil.loadAccompanyingModel(modelWrapped.getModel(), HyPreferenceModelUtil.getPreferenceModelFileExtensionForConcreteSyntax());
				}

				//
//				if(modelFileExists(ContextInformationUtil.getContextValueModelFileExtensionForXmi())){
//					// TODO type check? other models, too?
//					contextValueModel = EcoreIOUtil.loadAccompanyingModel(modelWrapped.getModel(), ContextInformationUtil.getContextValueModelFileExtensionForXmi());
//				}

				saveConfigurationIntoFeatureModelFolder();

				// allow to change the server uri
				java.net.URI uri = getURI();


				HyReconfiguratorClient client = new HyReconfiguratorClient();

				HyConfiguration configuration = client.reconfigure(uri, contextModel, validityModel, modelWrapped.getModel(), constraintModel, selectedConfiguration, preferenceModel, contextValueModel, modelWrapped.getSelectedDate());
				if(configuration != null){
					String fileName = file.getFullPath().removeFileExtension().lastSegment();

					String name = file.getFullPath().removeFileExtension().removeLastSegments(1).append(fileName+"_Result").addFileExtension(HyConfigurationUtil.getConfigurationModelFileExtensionForXmi()).toString();

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

		selectedConfigurationComposite.getDeriveVariantButton().addSelectionListener(new DwDeriveVariantListener(this));
	}

	private static HyContextValueModel createContextValueModel(HyContextInformationDialog dialog) {
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
}
