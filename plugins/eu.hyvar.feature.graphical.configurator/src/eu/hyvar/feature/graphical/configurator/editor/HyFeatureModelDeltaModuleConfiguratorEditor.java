package eu.hyvar.feature.graphical.configurator.editor;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;

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
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
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
import eu.hyvar.context.contextValidity.HyValidityModel;
import eu.hyvar.context.contextValidity.util.HyValidityModelUtil;
import eu.hyvar.context.information.contextValue.HyContextValueModel;
import eu.hyvar.context.information.util.HyContextInformationUtil;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.HyConfigurationFactory;
import eu.hyvar.feature.configuration.util.HyConfigurationUtil;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.constraint.util.HyConstraintUtil;
import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.configurator.composites.HySelectedConfigurationComposite;
import eu.hyvar.feature.graphical.configurator.dialogs.HyContextInformationDialog;
import eu.hyvar.feature.graphical.configurator.editor.listeners.DwDeriveVariantListener;
import eu.hyvar.feature.graphical.configurator.factory.HyConfiguratorEditPartFactory;
import eu.hyvar.feature.graphical.configurator.reconfigurator.HyReconfiguratorClient;
import eu.hyvar.preferences.HyPreferenceModel;
import eu.hyvar.preferences.util.HyPreferenceModelUtil;

public class HyFeatureModelDeltaModuleConfiguratorEditor extends HyGraphicalFeatureModelViewer {
	private Button validateButton;
	private Button numberOfPossibleConfigurationsButton;
	private Button setContextInformationsButton;
	private Button simulateButton;
	private HySelectedConfigurationComposite selectedConfigurationComposite;

	protected HyConfiguration selectedConfiguration;
	HyConfiguration suggestedConfiguration;

	public HyConfiguration getSelectedConfiguration() {
		return selectedConfiguration;
	}

	public HyConfiguration getConfiguration() {
		return getSelectedConfiguration();
	}

	public HyFeatureModel getFeatureModel() {
		if(getModelWrapped() == null) {
			return null;
		}
		return getModelWrapped().getModel();			
	}

	public Date getDate() {
		return getCurrentSelectedDate();
	}

	public HyFeatureModelDeltaModuleConfiguratorEditor() {
		super();

		selectedConfiguration = HyConfigurationFactory.eINSTANCE.createHyConfiguration();		
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);

		// load an existing configuration model
		if(this.modelFileExists("hyconfigurationmodel"))
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
		viewer.setEditPartFactory(new HyConfiguratorEditPartFactory(viewer, this));
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
				System.out.println("SYNC");	

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
		workbench.getDisplay().asyncExec(new Runnable(){

			@Override
			public void run() {
				System.out.println("ASYNC");	

				IEditorDescriptor desc = PlatformUI.getWorkbench().
						getEditorRegistry().getDefaultEditor("a."+HyConfigurationUtil.getConfigurationModelFileExtensionForXmi());



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

		//		Path spath = Paths.get( workspaceRoot.getFile(path).getLocationURI().getPath());
		//		Charset charset = StandardCharsets.UTF_8;

		//		String content;
		//		
		//		String poiseningString = workspaceRoot.getFile(path).getLocationURI().toString().replace(path.lastSegment(), "");
		//		try {
		//			content = new String(Files.readAllBytes(spath), charset);
		//			
		//			content = content.replaceAll(poiseningString, "");
		//			Files.write(spath, content.getBytes(charset));
		//		} catch (IOException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}

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

		setContextInformationsButton = new Button(configurationPanel, SWT.PUSH);
		setContextInformationsButton.setText("Simulate Reconfiguration");
		setContextInformationsButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

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

		setContextInformationsButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

			}
		});

		simulateButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				HyContextModel contextModel = null;
				if(modelFileExists(HyContextInformationUtil.getContextModelFileExtensionForConcreteSyntax())){
					contextModel = loadContextInformationModel();

					// only show the dialog if context information are available
					if(contextModel != null){
						HyContextInformationDialog dialog = new HyContextInformationDialog(getEditorSite().getShell(), contextModel);
						dialog.open();
					}
				}	

				HyValidityModel validityModel = null;
				if(modelFileExists(HyValidityModelUtil.getValidityModelFileExtensionForConcreteSyntax())){
					validityModel = EcoreIOUtil.loadAccompanyingModel(modelWrapped.getModel(), HyValidityModelUtil.getValidityModelFileExtensionForConcreteSyntax());
				}

				HyConstraintModel constraintModel = null;
				if(modelFileExists(HyConstraintUtil.getConstraintModelFileExtensionForXmi())){
					constraintModel = EcoreIOUtil.loadAccompanyingModel(modelWrapped.getModel(), HyConstraintUtil.getConstraintModelFileExtensionForXmi());
				}

				HyPreferenceModel preferenceModel = null;
				if(modelFileExists(HyPreferenceModelUtil.getPreferenceModelFileExtensionForConcreteSyntax())){
					preferenceModel = EcoreIOUtil.loadAccompanyingModel(modelWrapped.getModel(), HyPreferenceModelUtil.getPreferenceModelFileExtensionForConcreteSyntax());
				}

				HyContextValueModel contextValueModel = null;
				if(modelFileExists(HyContextInformationUtil.getContextModelFileExtensionForConcreteSyntax())){
					contextValueModel = EcoreIOUtil.loadAccompanyingModel(modelWrapped.getModel(), HyContextInformationUtil.getContextModelFileExtensionForConcreteSyntax());
				}

				saveConfigurationIntoFeatureModelFolder();


				HyReconfiguratorClient client = new HyReconfiguratorClient();

				HyConfiguration configuration = client.reconfigure(contextModel, validityModel, modelWrapped.getModel(), constraintModel, selectedConfiguration, preferenceModel, contextValueModel, modelWrapped.getSelectedDate());
				String fileName = file.getFullPath().removeFileExtension().lastSegment();
				
				String name = file.getFullPath().removeFileExtension().removeLastSegments(1).append(fileName+"_Result").addFileExtension(HyConfigurationUtil.getConfigurationModelFileExtensionForXmi()).toString();
						
				ResourceSet resSet = new ResourceSetImpl();
				Resource resource = resSet.createResource(URI.createURI(name));
				resource.getContents().add(configuration);

				try {
					resource.save(Collections.EMPTY_MAP);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				//EcoreIOUtil.saveModel(configuration);
				openConfigurationViewer(name);
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

	public Shell getShell() {
		return this.getSite().getWorkbenchWindow().getShell();
	}

	@Override
	protected void setInput(IEditorInput input) {
		super.setInput(input);
		selectedConfiguration.setFeatureModel(getFeatureModel());
	}
}
