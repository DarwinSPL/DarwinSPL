package de.darwinspl.feature.stage.configurator.configurator;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;

import de.christophseidl.util.ecore.EcoreIOUtil;
import de.darwinspl.feature.graphical.configurator.editor.DwFeatureModelConfiguratorEditor;
import de.darwinspl.feature.graphical.configurator.factory.DwConfiguratorEditorEditPartFactory;
import de.darwinspl.feature.stage.Role;
import de.darwinspl.feature.stage.RoleAssignment;
import de.darwinspl.feature.stage.RoleInclusion;
import de.darwinspl.feature.stage.Stage;
import de.darwinspl.feature.stage.StageModel;
import de.darwinspl.feature.stage.StageOrder;
import de.darwinspl.feature.stage.base.model.StageModelWrapped;
import de.darwinspl.feature.stage.configurator.factory.SmConfiguratorEditPartFactory;
import eu.hyvar.evolution.HyName;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.util.HyFeatureUtil;

public class SmStageModelConfigurator extends DwFeatureModelConfiguratorEditor {
	// GUI
	protected Group stageGroup;	
	protected Combo stageCombo;
	protected Combo roleCombo;
	
	protected Composite comboGroup;
	protected Composite currentStageGroup;
	protected Composite currentRoleGroup;
	
	protected Composite bottomBar;
	
	protected Label currentStageLabel;
	protected Label currentRoleLabel;
	
	// Internals
	protected StageModelWrapped stageModelWrapped;
	protected Stage selectedStage;
	protected Role selectedRole;
	
	
	/**
	 * Getter for current selected Stage
	 * @return current selected stage
	 */
	public Stage getCurrentSelectedStage(){
		return selectedStage;
	}
	
	/**
	 * Getter for current selected Role
	 * @return current selected role
	 */
	public Role getCurrentSelectedRole(){
		return selectedRole;
	}
	
	/**
	 * Load the stage Model from a given URI
	 * @param file
	 */
	protected void loadStageModelFromURI (IFile modelURI){	
		stageModelWrapped = new StageModelWrapped((StageModel)EcoreIOUtil.loadModel(modelURI, modelWrapped.getModel().eResource().getResourceSet()));
	}
	
	
	/**
	 * Creation of part Control 
	 */
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
		
		
		// Bottom bar with Date slider and Stage Model selections
		parent.setLayout(new GridLayout(1, false));
		
		GridLayout bottomBarLayout = new GridLayout(2, false);	
		bottomBar = new Composite(parent, SWT.NONE);
		bottomBar.setLayout(bottomBarLayout);
		super.createSliderControl(bottomBar);
		
		// Stage Group
		createStageGroup(bottomBar);

		// Listeners
		registerListeners();
		registerStageListeners();
		
		//refresh
		updateStageComboBox();
		updateRoleComboBox();
	}
	
	/**
	 *  Init function that extends Feature Model Loading with Stage Loading for the Stage Model Configurator
	 */
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		
		// Loading the stage model in addition to the Feature Model
		if(input instanceof IFileEditorInput) {
			IFileEditorInput fileInput = (IFileEditorInput) input;
			String fileExtension  = fileInput.getFile().getFileExtension() ;
			if(fileExtension.equals(HyFeatureUtil.getFeatureModelFileExtensionForXmi())){
				// URI to load the Model
				URI featureModelURI = modelWrapped.getModel().eResource().getURI();
				URI stageModelURI = featureModelURI.trimFileExtension().appendFileExtension("staged");				
				// File to check if Model exists
				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				IWorkspaceRoot workspaceRoot = workspace.getRoot();				
				IFile file = workspaceRoot.getFile(getPathToEditorRelatedFileWithFileExtension("staged"));
				if(file.exists()){
					loadStageModelFromURI(file);	
				}
				
			}

		}
		
	}
	
	/**
	 * Override the standard edit part Factory with the Factory for evolution and stages
	 */
	@Override
	public void configureGraphicalViewer() {
		super.configureGraphicalViewer();

		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setEditPartFactory(new SmConfiguratorEditPartFactory(viewer, this, this));
	}
	
	
	
	/**
	 * Copied Path function of the Editor
	 */
	public IPath getPathFromEditorRelatedFile(){
		return ((IPath)getFile().getFullPath().clone());
	}
	/**
	 * Copied Path function of the Editor
	 */
	public IPath getPathToEditorRelatedFileWithFileExtension(String fileExtension){
		return getPathFromEditorRelatedFile().removeFileExtension().addFileExtension(fileExtension);
	}
	
	/**
	 * Creates the GUI components for Stage selection
	 */
	protected void createStageGroup(Composite parent){
		// Group Around the Components of the Stage Extension
				GridData gridData = new GridData();
				stageGroup = new Group(parent, SWT.NONE);
			    stageGroup.setLayout(new GridLayout( 1, false ));
			    stageGroup.setLayoutData(gridData);
			    stageGroup.setText("Stage Model");
			    
			    comboGroup = new Composite(stageGroup, SWT.NONE);
				RowLayout columnLayout = new RowLayout(SWT.HORIZONTAL);	
				columnLayout.justify = true;
				comboGroup.setLayout(columnLayout);
				
					
				RowLayout stageComboLayout = new RowLayout(SWT.VERTICAL);
				stageComboLayout.center = true;	
				RowLayout roleComboLayout = new RowLayout(SWT.VERTICAL);
				roleComboLayout.center = true;	
				
				//Role box
				currentRoleGroup = new Composite(comboGroup, SWT.NONE);
				currentRoleGroup.setLayout(roleComboLayout);
				
				// Active Role Label
				
				currentRoleLabel = new Label(currentRoleGroup, SWT.NONE);
				currentRoleLabel.setText("Active Role:");
				
				// Combo box for role selection
				roleCombo = new Combo(currentRoleGroup, SWT.NONE);
				
				
				//Stage Box
				currentStageGroup = new Composite(comboGroup, SWT.NONE);
				currentStageGroup.setLayout(stageComboLayout);
				
				// Current Stage Label	
				currentStageLabel = new Label(currentStageGroup, SWT.NONE);
				currentStageLabel.setText("Selected Stage:");
				
				
				// Combo box for stage Selection				
				stageCombo = new Combo(currentStageGroup, SWT.NONE);
				
	}
	
	/**
	 * Creation of Listeners for the Stage and Role Combo boxes
	 */
	protected void registerStageListeners(){
		registerStageComboListener();
		registerRoleComboListener();
	}
	
	
	/**
	 * Listener for the combo box to get the currently selected stage
	 */
	public void registerStageComboListener(){
		stageCombo.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetSelected(SelectionEvent e) {
				int selectedItemIndex = stageCombo.getSelectionIndex();
				StageOrder currentStageOrder = HyEvolutionUtil.getValidTemporalElement(stageModelWrapped.getModel().getStageOrder(), currentSelectedDate);
				if(currentStageOrder != null){
					for(Stage currentStage: currentStageOrder.getStages()){
						HyName currentName = HyEvolutionUtil.getValidTemporalElement(currentStage.getNames(), currentSelectedDate);
						if(currentName.getName().equals(stageCombo.getItem(selectedItemIndex))){
							selectedStage = currentStage;
						}						
					}
					
				}
				refreshView();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
			
		});
		
	}
	
	/**
	 * Listener for the role combo box to get the currently selected role
	 */
	public void registerRoleComboListener(){
		roleCombo.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetSelected(SelectionEvent e) {
				int selectedItemIndex = roleCombo.getSelectionIndex();
				selectedRole = stageModelWrapped.getModel().getRoles().get(selectedItemIndex);
				updateStageComboBox();
				selectedStage = null;
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
			
		});
	}
	
	/**
	 * Update Function for the Stage Combo Box, dependent on selected Role
	 */
	public void updateStageComboBox(){
		if(stageModelWrapped != null){
			
			stageCombo.removeAll();
			// Get all stages the role is assigned to the current Role
			StageOrder currentStageOrder = HyEvolutionUtil.getValidTemporalElement(stageModelWrapped.getModel().getStageOrder(), currentSelectedDate);
			if(currentStageOrder != null && currentStageOrder.getStages() != null) {
				for (Stage currentStage : currentStageOrder.getStages()) {
					HyName currentName;
					RoleAssignment roleAssignment;
					roleAssignment = HyEvolutionUtil.getValidTemporalElement(currentStage.getRoleAssignment(), currentSelectedDate);
					
					if(roleAssignment.getRoles().contains(selectedRole)){
						currentName = HyEvolutionUtil.getValidTemporalElement(currentStage.getNames(), currentSelectedDate);
						String currentStageName = currentName.getName();
						stageCombo.add(currentStageName);
					}
					
					// Get all stages that are assigned to included roles
					if( selectedRole != null){
						RoleInclusion currentInclusion = HyEvolutionUtil.getValidTemporalElement(selectedRole.getInclusions(), currentSelectedDate);
						if(currentInclusion != null){						
							for(Role includedRole: currentInclusion.getIncludes()){
								
								RoleAssignment includedAssignment;
								includedAssignment = HyEvolutionUtil.getValidTemporalElement(includedRole.getAssignments(), currentSelectedDate);
								if(currentStage != null && includedAssignment != null){
									if(includedAssignment.getStage() != null && includedAssignment.getStage().equals(currentStage)){
										currentName = HyEvolutionUtil.getValidTemporalElement(currentStage.getNames(), currentSelectedDate);
										String currentStageName = currentName.getName();
										stageCombo.add(currentStageName);
									}
								}
								
							}	
						}
					}
				}		
				stageCombo.pack();
				stageGroup.pack();
				stageCombo.redraw();
			}
		}
	}
	
	/**
	 * Update Function for the Stage Combo Box, dependent on selected Role
	 */
	public void updateRoleComboBox(){
		if(stageModelWrapped != null){
			
			roleCombo.removeAll();
			
			for (Role currentRole : stageModelWrapped.getModel().getRoles()) {	
				HyName currentName = HyEvolutionUtil.getValidTemporalElement(currentRole.getNames(), currentSelectedDate);
				if(currentName != null){
					String currentRoleName = currentName.getName();
					roleCombo.add(currentRoleName);
					roleCombo.pack();
					stageGroup.pack();
					roleCombo.redraw();
				}
				
				
	      }	   
		}
	}
	
	
	/**
	 *  Function that updates the available roles when date is selected
	 */
	public void handleEvent(Event event) {
		super.handleEvent(event);
		updateRoleComboBox();
		updateStageComboBox();
	}


}
