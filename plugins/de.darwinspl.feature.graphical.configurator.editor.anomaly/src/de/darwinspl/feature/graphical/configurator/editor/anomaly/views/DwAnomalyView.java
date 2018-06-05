package de.darwinspl.feature.graphical.configurator.editor.anomaly.views;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.InputStream;
import java.nio.channels.UnresolvedAddressException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ViewPart;

import de.christophseidl.util.ecore.EcoreIOUtil;
import de.darwinspl.anomalies.explanations.AnomalyConstraintExplanation;
import de.darwinspl.anomaly.DwAnomaly;
import de.darwinspl.anomaly.DwDeadFeatureAnomaly;
import de.darwinspl.anomaly.DwFalseOptionalFeatureAnomaly;
import de.darwinspl.anomaly.DwVoidFeatureModelAnomaly;
import de.darwinspl.anomaly.explanation.DwAnomalyExplanation;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.configurator.editor.anomaly.views.tableviews.AnomalyTableView;
import de.darwinspl.feature.graphical.configurator.viewer.DwFeatureModelConfiguratorViewer;
import de.darwinspl.feature.graphical.editor.editor.DwGraphicalFeatureModelEditor;
import de.darwinspl.preferences.DwProfile;
import de.darwinspl.preferences.util.custom.DwPreferenceModelUtil;
import de.darwinspl.reconfigurator.client.hyvarrec.DwAnalysesClient;
import de.darwinspl.reconfigurator.client.hyvarrec.DwEvolutionOperationAnalyzer;
import de.darwinspl.reconfigurator.client.hyvarrec.HyVarRecNoSolutionException;
import eu.hyvar.context.HyContextInformationFactory;
import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.contextValidity.HyValidityModel;
import eu.hyvar.context.contextValidity.util.HyValidityModelUtil;
import eu.hyvar.context.information.contextValue.ContextValueFactory;
import eu.hyvar.context.information.contextValue.HyContextValueModel;
import eu.hyvar.context.information.util.HyContextInformationUtil;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.constraint.util.HyConstraintUtil;

public class DwAnomalyView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "de.darwinspl.feature.graphical.configurator.editor.anomaly.views.AnomalyView";


		
		private AnomalyTableView<DwFalseOptionalFeatureAnomaly> viewerFalseOptionalAnomaly;
		private AnomalyTableView<DwVoidFeatureModelAnomaly> viewerVoidAnomaly;
		
//		public static final Image REFRESH_IMAGE = 
		
		private IEditorPart currentEditor;
		public static final String DEFAULT_SERVER_URI = "https://www.isf.cs.tu-bs.de/hyvarrec/";
		public static String SAVED_SERVER_URI = "https://www.isf.cs.tu-bs.de/hyvarrec/";
		public static String USERNAME = null;
		public static String PASSWORD = null;
		public static Boolean HTTT_AUTHENTICATION_ENABLED = false;
		public static Boolean EVOLUTION_AWARE_ANALYSIS = false;
		public static Date EVOLUTION_AWARE_ANALYSIS_START_DATE = null;
		public static Date EVOLUTION_AWARE_ANALYSIS_END_DATE = null;
		public static TypeOfEvolutionAwareAnalysis EVOLUTION_AWARE_ANALYSIS_TYPE = TypeOfEvolutionAwareAnalysis.COMPLETE_HISTORY;
		
		private DwEvolutionOperationAnalyzer evolutionOperationAnalyzer;
		
		
		public enum TypeOfEvolutionAwareAnalysis{
			COMPLETE_HISTORY, TIME_SPAN
		}
		private static final String NO_FEATURE_MODEL_FOUND = "No Feature Model found. Open Feature Model with Feature Model Editor or Feature Model Configuration Editor";
		
		private IResource currentInput = null;
		
		Label errorMessage = null;
		
		HyContextModel contextModel = null;
		HyContextValueModel contextValueModel = null;
		DwFeatureModelWrapped modelWrapped = null;
		HyConstraintModel constraintModel = null;
		HyValidityModel validityModel = null;
		
		DwVoidFeatureModelAnomaly voidFeatureAnomaly = null;

		private Composite parentComposite = null;
		
	
		public static final String SETTINGS_IMG = "icons/settings.png";


		@Override
		public void createPartControl(Composite parent) {
		
			this.parentComposite = parent;

			getSite().getPage().addPartListener(editorListener);
			setEditor(getSite().getPage().getActiveEditor());
			currentInput = (currentEditor == null) ? null : ResourceUtil.getResource((currentEditor.getEditorInput()));

			 GridLayout layout = new GridLayout(2, false);
		        parent.setLayout(layout);
		
		    errorMessage = new Label(parent, SWT.NONE);
		    errorMessage.setText(NO_FEATURE_MODEL_FOUND);
		    	
		    errorMessage.setForeground(errorMessage.getDisplay().getSystemColor(SWT.COLOR_RED));
		    errorMessage.setVisible(false);
		        
		    if(currentEditor == null){
				  

		    errorMessage.setText(NO_FEATURE_MODEL_FOUND);
		    errorMessage.setVisible(true);
		    	 
			}
			
		     
			createViewerFalseOptionalAnomaly(parent,null);
			
			createViewerVoidAnomaly(parent, null);
		        
			if(currentEditor != null){
		     setInputOfViewers(); 
			}
			
			addButtons();
		}
		
		
		private void createViewerVoidAnomaly(Composite parent, List<DwVoidFeatureModelAnomaly> voidAnomalies) {
	        String[] titles = { "Type of Anomaly", "Context Values", "Date", "Explain", ""};
			viewerVoidAnomaly = new AnomalyTableView<DwVoidFeatureModelAnomaly>(this, parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER, voidAnomalies, titles);

	        // make the selection available to other views
	        getSite().setSelectionProvider(viewerVoidAnomaly);

	    }
		
		private void createViewerFalseOptionalAnomaly(Composite parent, List<DwFalseOptionalFeatureAnomaly> falseOptionalAnomalies) {
			String[] titles = { "Type of Anomaly", "Feature", "Begin", "End", "Explain" };
	        viewerFalseOptionalAnomaly = new AnomalyTableView<DwFalseOptionalFeatureAnomaly>(this, parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER, falseOptionalAnomalies, titles);
	        // make the selection available to other views
	        getSite().setSelectionProvider(viewerFalseOptionalAnomaly);
	    }
		
	    

//		public DwAnomalyExplanation explaingAnomaly(DwAnomaly anomaly){
//			
//			DwAnalysesClient analysesClient = new DwAnalysesClient();
//			DwAnomalyExplanation anomalyExplanation = null;
//			try {
//				anomalyExplanation = analysesClient.explainAnomaly(getURI(), USERNAME, PASSWORD, contextModel, validityModel, modelWrapped.getModel(), constraintModel, anomaly);
//			} catch (UnresolvedAddressException e) {
//				
//				e.printStackTrace();
//			} catch (TimeoutException e) {
//				
//				e.printStackTrace();
//			} catch (InterruptedException e) {
//				
//				e.printStackTrace();
//			} catch (ExecutionException e) {
//				
//				e.printStackTrace();
//			}
//			
//			
//			
//			if(anomalyExplanation != null){
//				ExplainAnomalyDialog explainDialog = new ExplainAnomalyDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), anomalyExplanation);
//				explainDialog.open();
//				return anomalyExplanation;
//			}else {
//				return null;
//			}
//			
//		}

	    
 
	    

	    public TableViewer getViewer() {
	        return viewerFalseOptionalAnomaly;
	}

	private void addButtons() {

		final IToolBarManager toolBarManager = getViewSite().getActionBars().getToolBarManager();

		final Action checkBoxer = new Action() {

			@Override
			public void run() {

				final DwRESTServerSelectExtendedDialog dialog = new DwRESTServerSelectExtendedDialog(
						viewerFalseOptionalAnomaly.getControl().getShell(), getURI(), HTTT_AUTHENTICATION_ENABLED,
						USERNAME, PASSWORD, EVOLUTION_AWARE_ANALYSIS, EVOLUTION_AWARE_ANALYSIS_START_DATE, EVOLUTION_AWARE_ANALYSIS_END_DATE, EVOLUTION_AWARE_ANALYSIS_TYPE);
				int result = dialog.open();
				if (result == Dialog.OK) {
					
						setURI(dialog.getUri());
						String password = dialog.getPassword();
						String username = dialog.getUserName();
						
						if (dialog.getHttpAuthentificationEnabled() == true && password!="" && password != null
								&& username != null && username != "") {
							USERNAME = username;
							PASSWORD = password;
							
							HTTT_AUTHENTICATION_ENABLED = true;
						} else {
							HTTT_AUTHENTICATION_ENABLED = false;
						}
						
						if(dialog.isEvolutionAwareAnalysis()){
							EVOLUTION_AWARE_ANALYSIS = dialog.isEvolutionAwareAnalysis();
							
							EVOLUTION_AWARE_ANALYSIS_TYPE = dialog.getEvolutionAwareAnalysisType();
							
							if(EVOLUTION_AWARE_ANALYSIS_TYPE.equals(TypeOfEvolutionAwareAnalysis.TIME_SPAN)){
								Date startDate = dialog.getStartDate();
								Date endDate = dialog.getEndDate();
								if(startDate != null && endDate != null){
									EVOLUTION_AWARE_ANALYSIS_START_DATE = startDate;
									EVOLUTION_AWARE_ANALYSIS_END_DATE = endDate;
								}
								
							}
							
						}
						
						
						IEditorPart activeEditor = getSite().getPage().getActiveEditor();
						if(!(activeEditor instanceof DwGraphicalFeatureModelEditor) && !(activeEditor instanceof DwFeatureModelConfiguratorViewer)) {
							modelWrapped = null;
						}
						
						setEditor(activeEditor);
						refresh(true);
						
						
					
				}
				
				

			}
			};

			final Action refresher = new Action() {

				@Override
				public void run() {
					
					DwAnomalyView.this.refresh(true);
				}
			};

			toolBarManager.add(refresher);
			Display display = Display.getCurrent();
			
			
			InputStream refreshImageStream=  getClass().getResourceAsStream("/images/refresh.gif");
			Image refreshImage = new Image(display, refreshImageStream);
			refresher.setImageDescriptor(ImageDescriptor.createFromImage(refreshImage));
			refresher.setToolTipText("Refresh");

			toolBarManager.add(checkBoxer);
		
			
			InputStream settingsImageStream=  getClass().getResourceAsStream("/images/settings2.png");
			Image settingsImage = new Image(display, settingsImageStream);
			
			
			
			checkBoxer.setImageDescriptor(ImageDescriptor.createFromImage(settingsImage));
			checkBoxer.setToolTipText("Settings");
		}

		private final IPartListener editorListener = new IPartListener() {

			@Override
			public void partOpened(IWorkbenchPart part) {}

			@Override
			public void partDeactivated(IWorkbenchPart part) {}

			@Override
			public void partClosed(IWorkbenchPart part) {
				if (part == currentEditor) {
					setEditor(null);
				}
			}

			@Override
			public void partBroughtToTop(IWorkbenchPart part) {
				
				if (part instanceof IEditorPart) {
					setEditor((IEditorPart) part);
				}
			}

			@Override
			public void partActivated(IWorkbenchPart part) {
				
				if (part instanceof IEditorPart) {
					ResourceUtil.getResource(((IEditorPart) part).getEditorInput());
					setEditor((IEditorPart) part);
				}
			}
		};

		@Override
		public void setFocus() {
			viewerVoidAnomaly.getControl().setFocus();
//			viewerFalseOptionalAnomaly.getControl().setFocus();
		}

		/**
		 * Listener that refreshes the view every time the model has been edited.
		 */
		private final PropertyChangeListener modelListener = new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if(evt.getNewValue() instanceof DwFeatureModelWrapped) {
				modelWrapped = (DwFeatureModelWrapped) evt.getNewValue();
				refresh(true);
				}
			}
		};
		

		private void setInputOfViewers(){
			
			
			
			if(viewerFalseOptionalAnomaly != null){
				
			errorMessage.setVisible(true);
			errorMessage.setForeground(errorMessage.getDisplay().getSystemColor(SWT.COLOR_DARK_GREEN));
			errorMessage.setText("Analyzation in process..");
			
			List<DwAnomaly> anomalies = getAnomalies();
			
			List<DwAnomaly> falseOptionalAndDeadAnomalies = new ArrayList<DwAnomaly>();
			List<DwVoidFeatureModelAnomaly> voidAnomalies = new ArrayList<DwVoidFeatureModelAnomaly>();
		
			
			voidAnomalies.removeAll(voidAnomalies);
			if(anomalies != null && !anomalies.isEmpty()){
				viewerFalseOptionalAnomaly.getTable().setVisible(true);
				viewerVoidAnomaly.getTable().setVisible(true);
				
				if(errorMessage.getText().equals("No Anomaly found")) {
					errorMessage.setVisible(false);
					errorMessage.setForeground(errorMessage.getDisplay().getSystemColor(SWT.COLOR_RED));
				}
			
			for(DwAnomaly anomaly: anomalies){
				if( anomaly instanceof DwFalseOptionalFeatureAnomaly || anomaly instanceof DwDeadFeatureAnomaly){
					falseOptionalAndDeadAnomalies.add(anomaly);
				} 
				else if ( anomaly instanceof DwVoidFeatureModelAnomaly){
					voidAnomalies.add((DwVoidFeatureModelAnomaly) anomaly);
				}
			}
			}
			
			if(anomalies != null && anomalies.isEmpty()) {
				
				errorMessage.setVisible(true);
				errorMessage.setForeground(errorMessage.getDisplay().getSystemColor(SWT.COLOR_DARK_GREEN));
				errorMessage.setText("No Anomaly found.");
				
				viewerFalseOptionalAnomaly.getTable().setVisible(false);
				viewerVoidAnomaly.getTable().setVisible(false);
			}
			

			
			
			//Needed to dispose old Items from the table viewer including the explain buttons
			TableItem[] voidItems = viewerVoidAnomaly.getTable().getItems();
			for(TableItem i: voidItems) {
				i.dispose();
			}
			
			TableItem[] falseOptionalItems = viewerFalseOptionalAnomaly.getTable().getItems();
			for(TableItem i: falseOptionalItems) {
				i.dispose();
			}
	
			

			if(!falseOptionalAndDeadAnomalies.isEmpty()){
			    viewerFalseOptionalAnomaly.setInput(falseOptionalAndDeadAnomalies);
			}
			if(!voidAnomalies.isEmpty()){
				
				viewerVoidAnomaly.setInput(voidAnomalies);
			}
			}
			
			
			
		}
		

		/**
		 * Refresh the view.
		 */
		private void refresh(final boolean force) {
			
			if(currentEditor == null){
				errorMessage.setText(NO_FEATURE_MODEL_FOUND);
				errorMessage.setVisible(true);
			}
			
			if(viewerFalseOptionalAnomaly != null || viewerVoidAnomaly != null){
				   if (!viewerFalseOptionalAnomaly.getControl().isDisposed() && !viewerVoidAnomaly.getControl().isDisposed()) {
				      setInputOfViewers();
				   }

			}
			
			}
			
			



		/**
		 * Watches changes in the feature model if the selected editor is an instance of @{link FeatureModelEditor}
		 */
		private void setEditor(IEditorPart newEditor) {
			
			if (currentEditor == newEditor) {
				return;
			}
				
			if(currentEditor != newEditor && currentEditor != null && newEditor != null){

				if (currentEditor instanceof DwGraphicalFeatureModelEditor) {
					((DwGraphicalFeatureModelEditor) currentEditor).getModelWrapped().removePropertyChangeListener(modelListener);
				}  
				else if (currentEditor instanceof DwFeatureModelConfiguratorViewer){
					((DwFeatureModelConfiguratorViewer) currentEditor).getModelWrapped().removePropertyChangeListener(modelListener);
			
				}
		   }
			boolean force = true;
			if ((newEditor != null) && (currentEditor != null)) {
				final IEditorInput newInput = newEditor.getEditorInput();
				if (newInput instanceof FileEditorInput) {
					final IEditorInput oldInput = currentEditor.getEditorInput();
					if (oldInput instanceof FileEditorInput) {
						final IProject newProject = ((FileEditorInput) newInput).getFile().getProject();
						final IProject oldProject = ((FileEditorInput) oldInput).getFile().getProject();
						if (newProject.equals(oldProject)) {
							force = false;
						}
					}
				}
			}
			
			if (newEditor instanceof DwGraphicalFeatureModelEditor) {
				currentEditor = newEditor;
				((DwGraphicalFeatureModelEditor) currentEditor).getModelWrapped().addPropertyChangeListener(modelListener);
				modelWrapped = ((DwGraphicalFeatureModelEditor) currentEditor).getModelWrapped();
				
			} else if (newEditor instanceof DwFeatureModelConfiguratorViewer){
				currentEditor = newEditor;
				((DwFeatureModelConfiguratorViewer) currentEditor).getModelWrapped().addPropertyChangeListener(modelListener);
				modelWrapped = ((DwFeatureModelConfiguratorViewer) currentEditor).getModelWrapped();
			} else{
				currentEditor = newEditor;
				return;
			}
			setAccomanyingModels();
			
			//TODO: implement listeners for
			addModelListeners();
			refresh(force);
		}
		
		Adapter contextModelAdapter = new AdapterImpl(){
			public void notifyChanged(Notification msg) {
				
				
			};
			
			
		};
		
		//TODO: Add Model Listeners to other models to implement auto refresh
		private void addModelListeners(){

		}
		
		
		private void setAccomanyingModels(){
			
			if(contextValueModel == null) {
				contextValueModel = ContextValueFactory.eINSTANCE.createHyContextValueModel();
			
			}
			
	
			if(modelFileExists(HyValidityModelUtil.getValidityModelFileExtensionForConcreteSyntax())){
				validityModel = EcoreIOUtil.loadAccompanyingModel(modelWrapped.getModel(), HyValidityModelUtil.getValidityModelFileExtensionForConcreteSyntax());
			}
			else if(modelFileExists(HyValidityModelUtil.getValidityModelFileExtensionForXmi())) {
				validityModel = EcoreIOUtil.loadAccompanyingModel(modelWrapped.getModel(), HyValidityModelUtil.getValidityModelFileExtensionForXmi());
			}

			
			if(modelFileExists(HyConstraintUtil.getConstraintModelFileExtensionForConcreteSyntax())){
				constraintModel = EcoreIOUtil.loadAccompanyingModel(modelWrapped.getModel(), HyConstraintUtil.getConstraintModelFileExtensionForConcreteSyntax());
			}
			else if(modelFileExists(HyConstraintUtil.getConstraintModelFileExtensionForXmi())){
				constraintModel = EcoreIOUtil.loadAccompanyingModel(modelWrapped.getModel(), HyConstraintUtil.getConstraintModelFileExtensionForXmi());
			}
			
			
		}
		public IFile getFile() {
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IWorkspaceRoot workspaceRoot = workspace.getRoot();

			return workspaceRoot.getFile(new Path(modelWrapped.getModel().eResource().getURI().toPlatformString(true)));
		}
		private HyContextModel loadContextInformationModel(){
			return (HyContextModel) EcoreIOUtil.loadAccompanyingModel(modelWrapped.getModel(), HyContextInformationUtil.getContextModelFileExtensionForXmi());
		}
		
		
		
		private void setInfoMessageAndVisibilityOfViewerTables(boolean messageVisibility, boolean tableVisibility, String message, int messsageColor) {
			
			errorMessage.setVisible(messageVisibility);
			errorMessage.setForeground(errorMessage.getDisplay().getSystemColor(messsageColor));
			errorMessage.setText(message);
			
			viewerFalseOptionalAnomaly.getTable().setVisible(tableVisibility);
			viewerVoidAnomaly.getTable().setVisible(tableVisibility);
			
			
			
		}

		
		private boolean modelFileExists(String extension){
			try {
			IPath path = ((IPath)getFile().getFullPath().clone()).removeFileExtension().addFileExtension(extension);

			IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();

			IFile file = workspaceRoot.getFile(path);
			return file.exists();	
			} catch (Exception e) {
				return false;
				
			}
			
				
		}


		private String getURI(){
			return SAVED_SERVER_URI;

		}
		
		private void setURI(String string){
			
			SAVED_SERVER_URI = string;
			
		}
		
		
		private List<DwAnomaly> getAnomalies(){
			
			
			if(modelFileExists(HyContextInformationUtil.getContextModelFileExtensionForXmi())){
				contextModel = loadContextInformationModel();

				// only show the dialog if context information are available
				if(contextModel == null) {
					contextModel = HyContextInformationFactory.eINSTANCE.createHyContextModel();
				}
				
			}
			else {
				contextModel = HyContextInformationFactory.eINSTANCE.createHyContextModel();
//				MessageDialog.openError(getShell(), "No context model", "Reconfiguration not possible as no context information file exists.");
//				return;
			}
			


			if(contextValueModel == null) {
				contextValueModel = ContextValueFactory.eINSTANCE.createHyContextValueModel();;
			}
			
	
			if(modelFileExists(HyValidityModelUtil.getValidityModelFileExtensionForConcreteSyntax())){
				validityModel = EcoreIOUtil.loadAccompanyingModel(modelWrapped.getModel(), HyValidityModelUtil.getValidityModelFileExtensionForConcreteSyntax());
			}
			else if(modelFileExists(HyValidityModelUtil.getValidityModelFileExtensionForXmi())) {
				validityModel = EcoreIOUtil.loadAccompanyingModel(modelWrapped.getModel(), HyValidityModelUtil.getValidityModelFileExtensionForXmi());
			}

			
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

//			saveConfigurationIntoFeatureModelFolder();

			// allow to change the server uri
			String uri = getURI();
			

			DwAnalysesClient client = new DwAnalysesClient();
			
			
			
			

			try {
				String username = null;
				String password = null;
				if(HTTT_AUTHENTICATION_ENABLED){
					username = USERNAME;
					password = PASSWORD;
				}

				if(currentEditor instanceof DwFeatureModelConfiguratorViewer){
					
				
					
					voidFeatureAnomaly = client.validateFeatureModelWithContext(uri, username, password, contextModel,
							validityModel, modelWrapped.getModel(), constraintModel, ((DwFeatureModelConfiguratorViewer)currentEditor).getConfiguration(), profile,
							contextValueModel, modelWrapped.getSelectedDate());
					
				
					}else{
						voidFeatureAnomaly = client.validateFeatureModelWithContext(uri, username, password, contextModel,
								validityModel, modelWrapped.getModel(), constraintModel, null, profile,
								contextValueModel, modelWrapped.getSelectedDate());
						
					}

					List<DwAnomaly> anomalies = client.checkFeatures(uri, username, password, contextModel, validityModel, modelWrapped.getModel(), constraintModel, null, null);
					
					if(voidFeatureAnomaly != null){
						anomalies.add(voidFeatureAnomaly);
					}
					
					errorMessage.setVisible(false);
					
					evolutionOperationAnalyzer = new DwEvolutionOperationAnalyzer(client.getExporter());
					evolutionOperationAnalyzer.setFeatureAnomalies(anomalies);
					
					return anomalies;
					
					
				
			} catch (UnresolvedAddressException |  TimeoutException | InterruptedException | ExecutionException | HyVarRecNoSolutionException | NullPointerException  e1 ) {
				
				
				if(modelWrapped == null) {
					setInfoMessageAndVisibilityOfViewerTables(true, false, "No Feature Model found.", SWT.COLOR_RED);
					
				}else {
					setInfoMessageAndVisibilityOfViewerTables(true, false, "Unresolvable Server Adress. \n" + e1, SWT.COLOR_RED);
				}
			
				errorMessage.setVisible(true);
				errorMessage.setText("Unresolvable Server Adress. \n" + e1);

				
			}

			
			return null; 


			
		}
		
		public List<AnomalyConstraintExplanation> explainAnomaly(DwAnomaly anomaly) {

			DwAnalysesClient analysesClient = new DwAnalysesClient();
			List<AnomalyConstraintExplanation> anomalyExplanation = null;
			try {

				String username = null;
				String password = null;
				if (HTTT_AUTHENTICATION_ENABLED) {
					username = USERNAME;
					password = PASSWORD;
				}

				
				// Moved to the getAnomalies method as this would retrieve all feature model anomalies again!!
//				List<DwAnomaly> anomalies = analysesClient.checkFeatures(getURI(), username, password, contextModel, validityModel, modelWrapped.getModel(), constraintModel, null, null);
//				
//				DwEvolutionOperationAnalyzer evolutionOperationAnalyzer = new DwEvolutionOperationAnalyzer(analysesClient.getExporter());
//				evolutionOperationAnalyzer.setFeatureAnomalies(anomalies);
				
				anomalyExplanation = analysesClient.explainAnomaly(getURI(), username, password, contextModel, validityModel,
						modelWrapped.getModel(), constraintModel, anomaly, evolutionOperationAnalyzer);
			} catch (UnresolvedAddressException e) {

				e.printStackTrace();
			} catch (TimeoutException e) {

				e.printStackTrace();
			} catch (InterruptedException e) {

				e.printStackTrace();
			} catch (ExecutionException e) {

				e.printStackTrace();
			}

			if (anomalyExplanation != null) {
				ExplainDialogResultDialog explainDialog = new ExplainDialogResultDialog(
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), anomaly, anomalyExplanation);
				explainDialog.open();
				return anomalyExplanation;
			} else {
				return null;
			}

		}

}