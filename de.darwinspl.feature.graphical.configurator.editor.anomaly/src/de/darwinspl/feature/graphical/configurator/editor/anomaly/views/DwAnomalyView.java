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
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
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
import de.darwinspl.anomaly.DwAnomaly;
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
import de.darwinspl.reconfigurator.client.hyvarrec.HyVarRecNoSolutionException;
import eu.hyvar.context.HyContextInformationFactory;
import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.contextValidity.HyValidityModel;
import eu.hyvar.context.contextValidity.util.HyValidityModelUtil;
import eu.hyvar.context.information.contextValue.ContextValueFactory;
import eu.hyvar.context.information.contextValue.HyContextValue;
import eu.hyvar.context.information.contextValue.HyContextValueModel;
import eu.hyvar.context.information.util.HyContextInformationUtil;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsResourceProvider;
import eu.hyvar.feature.constraint.resource.hyconstraints.IHyconstraintsTextResource;
import eu.hyvar.feature.constraint.resource.hyconstraints.ui.HyconstraintsEditor;
import eu.hyvar.feature.constraint.util.HyConstraintUtil;

public class DwAnomalyView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "de.darwinspl.feature.graphical.configurator.editor.anomaly.views.AnomalyView";


		
		private AnomalyTableView<DwFalseOptionalFeatureAnomaly> viewerFalseOptionalAnomaly;
		private AnomalyTableView<DwVoidFeatureModelAnomaly> viewerVoidAnomaly;
		
		private IEditorPart currentEditor;
		public static final String DEFAULT_SERVER_URI = "http://localhost:9002/";
		public String serverUri = null; 
		private IResource currentInput = null;
		
		
		HyContextModel contextModel = null;
		HyContextValueModel contextValueModel = null;
		DwFeatureModelWrapped modelWrapped = null;
		HyConstraintModel constraintModel = null;
		HyValidityModel validityModel = null;
		
		DwVoidFeatureModelAnomaly voidFeatureAnomaly = null;

		private Composite parentComposite = null;
		
	
		public static final String SETTINGS_IMG = "icons/settings.png";
//		public static final Image REFRESH_IMG = FMUIPlugin.getImage("refresh_tab.gif");

		@Override
		public void createPartControl(Composite parent) {
		
			this.parentComposite = parent;

			getSite().getPage().addPartListener(editorListener);
			setEditor(getSite().getPage().getActiveEditor());
			currentInput = (currentEditor == null) ? null : ResourceUtil.getResource((currentEditor.getEditorInput()));

			 GridLayout layout = new GridLayout(2, false);
		        parent.setLayout(layout);
//		        Label searchLabel = new Label(parent, SWT.NONE);
//		        searchLabel.setText("Search: ");
//		        final Text searchText = new Text(parent, SWT.BORDER | SWT.SEARCH);
//		        searchText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		      
//			List<DwAnomaly> anomalies = getAnomalies();
//			List<DwFalseOptionalFeatureAnomaly> falseOptionalAnomalies = new ArrayList<DwFalseOptionalFeatureAnomaly>();
//			List<DwVoidFeatureModelAnomaly> voidAnomalies = new ArrayList<DwVoidFeatureModelAnomaly>();
//			
//			for(DwAnomaly anomaly: anomalies){
//				if( anomaly instanceof DwFalseOptionalFeatureAnomaly){
//					falseOptionalAnomalies.add((DwFalseOptionalFeatureAnomaly) anomaly);
//				} else if ( anomaly instanceof DwVoidFeatureModelAnomaly){
//					voidAnomalies.add((DwVoidFeatureModelAnomaly) anomaly);
//				}
//			}
			
			
		     
			createViewerFalseOptionalAnomaly(parent,null);
			
			createViewerVoidAnomaly(parent, null);
		        
		     setInputOfViewers(); 
			
			addButtons();
		}
		
		
		private void createViewerVoidAnomaly(Composite parent, List<DwVoidFeatureModelAnomaly> voidAnomalies) {
	        String[] titles = { "Type of Anomaly", "context values", "Date", "Explain", ""};
			viewerVoidAnomaly = new AnomalyTableView<DwVoidFeatureModelAnomaly>(this, parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER, voidAnomalies, titles);

	        // make the selection available to other views
	        getSite().setSelectionProvider(viewerVoidAnomaly);

	    }
		
		private void createViewerFalseOptionalAnomaly(Composite parent, List<DwFalseOptionalFeatureAnomaly> falseOptionalAnomalies) {
			String[] titles = { "Type of Anomaly", "feature", "begin", "end", "Explain" };
	        viewerFalseOptionalAnomaly = new AnomalyTableView<DwFalseOptionalFeatureAnomaly>(this, parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER, falseOptionalAnomalies, titles);
	        // make the selection available to other views
	        getSite().setSelectionProvider(viewerFalseOptionalAnomaly);
	    }
		
	    

		public DwAnomalyExplanation explaingAnomaly(DwAnomaly anomaly){
			
			DwAnalysesClient analysesClient = new DwAnalysesClient();
			DwAnomalyExplanation anomalyExplanation = null;
			try {
				anomalyExplanation = analysesClient.explainAnomaly(getURI(), contextModel, validityModel, modelWrapped.getModel(), constraintModel, anomaly);
			} catch (UnresolvedAddressException e) {
				
				e.printStackTrace();
			} catch (TimeoutException e) {
				
				e.printStackTrace();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			} catch (ExecutionException e) {
				
				e.printStackTrace();
			}
			
			if(anomalyExplanation != null){
				
			}
			
			if(anomalyExplanation != null){
				ExplainDialogResultDialog explainDialog = new ExplainDialogResultDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), anomalyExplanation);
				explainDialog.open();
				return anomalyExplanation;
			}else {
				return null;
			}
			
		}

	    
 
	    

	    public TableViewer getViewer() {
	        return viewerFalseOptionalAnomaly;
	    }

		private void addButtons() {

			final IToolBarManager toolBarManager = getViewSite().getActionBars().getToolBarManager();

			final Action checkBoxer = new Action() {

				@Override
				public void run() {
				
					final DwRESTServerSelectDialog dialog = new DwRESTServerSelectDialog(viewerFalseOptionalAnomaly.getControl().getShell(), getURI());
					dialog.open();
					setURI(dialog.getUri());
				}
			};

			final Action refresher = new Action() {

				@Override
				public void run() {
					System.out.println("whuhuhu iam refreshing");
					DwAnomalyView.this.refresh(true);
				}
			};

			toolBarManager.add(refresher);
//			refresher.setImageDescriptor(ImageDescriptor.createFromImage(REFRESH_IMG));
//			refresher.setToolTipText(REFRESH_VIEW);

			toolBarManager.add(checkBoxer);
		
			Display display = Display.getCurrent();
			InputStream imageSettings=  getClass().getResourceAsStream("/images/settings2.png");
			Image image = new Image(display, imageSettings);
			
			ImageDescriptor descriptor = ImageDescriptor.createFromImage(image);
			
		
			
			checkBoxer.setImageDescriptor(ImageDescriptor.createFromImage(image));
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
				modelWrapped = (DwFeatureModelWrapped) evt.getNewValue();
				refresh(true);
				
			}
		};
		

		/**
		 * Listener that refreshes the view every time the model has been edited.
		 */
		private final PropertyChangeListener vfModelListener = new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				
				validityModel = (HyValidityModel) evt.getNewValue();
				refresh(true);
				
			}
		};
		
		

		/**
		 * Listener that refreshes the view every time the model has been edited.
		 */
		private final PropertyChangeListener ctcModelListener = new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				constraintModel = (HyConstraintModel) evt.getNewValue();
				refresh(true);
				
				
			}
		};
		

		/**
		 * Listener that refreshes the view every time the model has been edited.
		 */
		private final PropertyChangeListener contextModelListener = new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				contextModel = (HyContextModel) evt.getNewValue();
				refresh(true);
				
			}
		};



		private void setInputOfViewers(){
			
			
			
			if(viewerFalseOptionalAnomaly != null){
			List<DwAnomaly> anomalies = getAnomalies();
			List<DwFalseOptionalFeatureAnomaly> falseOptionalAnomalies = new ArrayList<DwFalseOptionalFeatureAnomaly>();
			List<DwVoidFeatureModelAnomaly> voidAnomalies = new ArrayList<DwVoidFeatureModelAnomaly>();
		
			voidAnomalies.removeAll(voidAnomalies);
			
			for(DwAnomaly anomaly: anomalies){
				if( anomaly instanceof DwFalseOptionalFeatureAnomaly){
					falseOptionalAnomalies.add((DwFalseOptionalFeatureAnomaly) anomaly);
				} else if ( anomaly instanceof DwVoidFeatureModelAnomaly){
					voidAnomalies.add((DwVoidFeatureModelAnomaly) anomaly);
				}
			}
			
			viewerVoidAnomaly.getTable().clearAll();
//			viewerVoidAnomaly.getTable().removeAll();
			viewerFalseOptionalAnomaly.getTable().clearAll();
//			viewerVoidAnomaly.refresh();
	
//			viewerFalseOptionalAnomaly.refresh();
			viewerFalseOptionalAnomaly.setInput(falseOptionalAnomalies);
			
			if(!voidAnomalies.isEmpty()){
				System.out.println("not empfy");
				viewerVoidAnomaly.setInput(voidAnomalies);
			}else{
				System.out.println("empty");
			}
			
//			viewerVoidAnomaly.refresh();
	

//			viewerVoidAnomaly.setInput(voidAnomalies);

//		viewerVoidAnomaly.refresh();
		
			
			

			}
			
		}
		

		/**
		 * Refresh the view.
		 */
		private void refresh(final boolean force) {
			
			if(viewerFalseOptionalAnomaly != null || viewerVoidAnomaly != null){
				   if (!viewerFalseOptionalAnomaly.getControl().isDisposed() && !viewerVoidAnomaly.getControl().isDisposed()) {
				      setInputOfViewers();
				   }
			}
			
			
//			if (contentProvider.) {
//				return;
//			}
//
//			/*
//			 * This job waits for the calculation job to finish and starts immediately a new one
//			 */
//			final Job waiter = new Job("Update") {h
//	
//				@Override
//				protected IStatus run(IProgressMonitor monitor) {
//					try {
//						if (job != null) {
//							if (contentProvider.isCanceled()) {
//								return Status.OK_STATUS;
//							}
//							contentProvider.setCanceled(true);
//							job.join();
//							contentProvider.setCanceled(false);
//						}
//					} catch (final InterruptedException e) {
//						e.printStackTrace();
//					}
//	//
//					job = new Job("update") {
//	//
//						@Override
//						protected IStatus run(IProgressMonitor monitor) {
//							if (currentEditor == null) {
//								contentProvider.defaultContent();
//							} else {
//								final IResource anyFile = ResourceUtil.getResource(currentEditor.getEditorInput());
//								// TODO is refresh really necessary? -> true?
//	//
//								if (force || (currentInput == null) || !anyFile.getProject().equals(currentInput.getProject())) {
//									contentProvider.calculateContent(anyFile, true);
//									currentInput = anyFile;
//								} else {
//									contentProvider.calculateContent(anyFile, false);
//								}
//							}
//							return Status.OK_STATUS;
//						}
//					};
//					job.setPriority(Job.DECORATE);
//					job.schedule();
//					return Status.OK_STATUS;
//				}
//			};
//			waiter.setPriority(Job.DECORATE);
//			waiter.schedule();
//			cancelJobs();
		}

		private void cancelJobs() {
//			final JobDoneListener jobListener = JobDoneListener.getInstance();
//			if (jobListener != null) {
//				jobListener.cancelAllRunningTreeJobs();
//			}
		}



		/**
		 * Watches changes in the feature model if the selected editor is an instance of @{link FeatureModelEditor}
		 */
		private void setEditor(IEditorPart newEditor) {
			
			if (currentEditor == newEditor) {
				return;
//				if (currentEditor == newEditor) {
//					return;
//				}
//
//				if (currentEditor instanceof DwGraphicalFeatureModelEditor) {
//					((DwGraphicalFeatureModelEditor) currentEditor).getModelWrapped().removePropertyChangeListener(modelListener);
////					getFeatureModel().removeListener(modelListener);
//				}  else if (newEditor instanceof DwFeatureModelConfiguratorViewer){
//					((DwFeatureModelConfiguratorViewer) currentEditor).getModelWrapped().removePropertyChangeListener(modelListener);
//			
//				}
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
			currentEditor = newEditor;
			if (newEditor instanceof DwGraphicalFeatureModelEditor) {
				((DwGraphicalFeatureModelEditor) currentEditor).getModelWrapped().addPropertyChangeListener(modelListener);
				modelWrapped = ((DwGraphicalFeatureModelEditor) currentEditor).getModelWrapped();
				
			} else if (newEditor instanceof DwFeatureModelConfiguratorViewer){
				((DwFeatureModelConfiguratorViewer) currentEditor).getModelWrapped().addPropertyChangeListener(modelListener);
				modelWrapped = ((DwFeatureModelConfiguratorViewer) currentEditor).getModelWrapped();
			} else{
				return;
			}
//			else if (newEditor instanceof HyconstraintsEditor){
//				
//				IHyconstraintsTextResource res = ((HyconstraintsEditor) currentEditor).getResource();
//				List<EObject> contents = res.getContents();
//				HyConstraintModel constraintModel = (HyConstraintModel) contents.get(0);
//				modelWrapped = EcoreIOUtil.loadAccompanyingModel(constraintModel, "hyfeature");
//				System.out.println(contents);
//			}
			setAccomanyingModels();
			addModelListeners();
			refresh(force);
		}
		
		Adapter contextModelAdapter = new AdapterImpl(){
			public void notifyChanged(Notification msg) {
				
				
			};
			
			
		};
		
		private void addModelListeners(){
//			System.out.println("Added listner");
//			constraintModel.eAdapters().add(contextModelAdapter);
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

		
		private boolean modelFileExists(String extension){
			IPath path = ((IPath)getFile().getFullPath().clone()).removeFileExtension().addFileExtension(extension);

			IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();

			IFile file = workspaceRoot.getFile(path);
			
			return file.exists();		
		}


		private String getURI(){
			
			if(serverUri == null){
				return DEFAULT_SERVER_URI;
			}
			
			return serverUri;

		}
		
		private void setURI(String string){
			
			serverUri = string;
			
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
				
				
				
				
//				if(currentEditor instanceof DwFeatureModelConfiguratorViewer){
					
					voidFeatureAnomaly = client.validateFeatureModelWithContext(uri, contextModel,
							validityModel, modelWrapped.getModel(), constraintModel, null, profile,
							contextValueModel, modelWrapped.getSelectedDate());
				
//					}

					List<DwAnomaly> anomalies = client.checkFeatures(uri, contextModel, validityModel, modelWrapped.getModel(), constraintModel, null, null);
					
					if(voidFeatureAnomaly != null){
						anomalies.add(voidFeatureAnomaly);
					}
					
					return anomalies;
					
					
				
			} catch (UnresolvedAddressException | TimeoutException | InterruptedException | ExecutionException | HyVarRecNoSolutionException e1) {
				MessageDialog dialog = new MessageDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Unresolvable Server Adress", null,
						"The adress '"+uri.toString()+"' could not be resolved or had a timeout. No configuration was generated.", MessageDialog.ERROR, new String[] { "Ok" }, 0);
				dialog.open();
			}
//			catch (HyVarRecNoSolutionException e) {
//				
//				e.printStackTrace();
//			}
			return null; 


			
		}
	}
