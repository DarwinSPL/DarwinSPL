package eu.hyvar.feature.graphical.configurator.editor;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.IOWrappedException;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
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
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;

import de.christophseidl.util.ecore.EcoreIOUtil;
import eu.hyvar.context.HyContextModel;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.HyConfigurationFactory;
import eu.hyvar.feature.configuration.util.HyConfigurationUtil;
import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.configurator.composites.HySelectedConfigurationComposite;
import eu.hyvar.feature.graphical.configurator.dialogs.HyContextInformationDialog;
import eu.hyvar.feature.graphical.configurator.factory.HyConfiguratorEditPartFactory;
import eu.hyvar.feature.graphical.configurator.output.IHyConfigurationDerivation;
import eu.hyvar.feature.graphical.configurator.reconfigurator.HyReconfiguratorClient;

public class HyFeatureModelDeltaModuleConfiguratorEditor extends HyGraphicalFeatureModelViewer implements IHyConfigurationDerivation{
	private Button validateButton;
	private Button numberOfPossibleConfigurationsButton;
	private Button setContextInformationsButton;
	private Button simulateButton;
	private HySelectedConfigurationComposite selectedConfigurationComposite;

	private HyContextModel model;

	HyConfiguration selectedConfiguration;
	HyConfiguration suggestedConfiguration;

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

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("hycontextinformation", new XMIResourceFactoryImpl());

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


	private void saveConfigurationIntoFeatureModelFolder(){
		IPath path = ((IPath)file.getFullPath().clone()).removeFileExtension().addFileExtension(HyConfigurationUtil.getConfigurationModelFileExtensionForXmi());
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		
		
		EcoreIOUtil.saveModelAs(selectedConfiguration, workspaceRoot.getFile(path));		

		Path spath = Paths.get( workspaceRoot.getFile(path).getLocationURI().getPath());
		Charset charset = StandardCharsets.UTF_8;

		String content;
		
		String poiseningString = workspaceRoot.getFile(path).getLocationURI().toString().replace(path.lastSegment(), "");
		try {
			content = new String(Files.readAllBytes(spath), charset);
			
			content = content.replaceAll(poiseningString, "");
			Files.write(spath, content.getBytes(charset));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private EObject loadResource(String extension){
		IPath path = ((IPath)file.getFullPath().clone()).removeFileExtension().addFileExtension(extension);

		Resource resource = resourceSet.createResource(URI.createPlatformResourceURI(path.toString(), false));

		try {
			resource.load(null);


		} catch (IOWrappedException e){
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}

		return resource.getContents().get(0);

	}
	private HyContextModel loadContextInformationModel(){		
		return (HyContextModel)loadResource("hycontextinformation");
	}

	private HyConfiguration loadConfigurationModel(){
		return (HyConfiguration)loadResource("hyconfigurationmodel");
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
				if(modelFileExists("hycontextinformation")){
					model = loadContextInformationModel();

					// only show the dialog if context information are available
					if(model != null){
						HyContextInformationDialog dialog = new HyContextInformationDialog(getEditorSite().getShell(), model);
						dialog.open();
					}
				}
			}
		});

		simulateButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				IPath path = ((IPath)file.getFullPath().clone()).removeFileExtension();

				saveConfigurationIntoFeatureModelFolder();


				HyReconfiguratorClient client = new HyReconfiguratorClient();



				if(client.start(java.net.URI.create("http://localhost:8080/fm_for_hyvarrec"), path)){
					suggestedConfiguration = loadConfigurationModel();
					selectedConfiguration = suggestedConfiguration;
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

		selectedConfigurationComposite.getDeriveVariantButton().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
	}
}
