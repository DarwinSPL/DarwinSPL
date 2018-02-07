package de.darwinspl.feature.graphical.configurator.editor.anomaly.views;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
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
import de.darwinspl.anomaly.DwDeadFeatureAnomaly;
import de.darwinspl.anomaly.DwFalseOptionalFeatureAnomaly;
import de.darwinspl.anomaly.DwVoidFeatureModelAnomaly;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.configurator.viewer.DwFeatureModelConfiguratorViewer;
import de.darwinspl.feature.graphical.editor.editor.DwGraphicalFeatureModelEditor;
import de.darwinspl.preferences.DwProfile;
import de.darwinspl.preferences.util.custom.DwPreferenceModelUtil;
import de.darwinspl.reconfigurator.client.hyvarrec.DwAnalysesClient;
import de.darwinspl.reconfigurator.client.hyvarrec.DwAnalysesClient.DwContextValueEvolutionWrapper;
import de.darwinspl.reconfigurator.client.hyvarrec.HyVarRecNoSolutionException;
import eu.hyvar.context.HyContextInformationFactory;
import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.contextValidity.HyValidityModel;
import eu.hyvar.context.contextValidity.util.HyValidityModelUtil;
import eu.hyvar.context.information.contextValue.ContextValueFactory;
import eu.hyvar.context.information.contextValue.HyContextValueModel;
import eu.hyvar.context.information.util.HyContextInformationUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.constraint.HyConstraintModel;
import eu.hyvar.feature.constraint.util.HyConstraintUtil;

public class DwAnomalyView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "de.darwinspl.feature.graphical.configurator.editor.anomaly.views.AnomalyView";


		
		private TableViewer viewerFalseOptionalAnomaly;
		
		private TableViewer viewerVoidAnomaly;
		

		private IEditorPart currentEditor;
		
		
		
		private IResource currentInput;
		
		private Label label;
		
		HyContextModel contextModel = null;
		HyContextValueModel contextValueModel = null;
		DwFeatureModelWrapped modelWrapped = null;
		
		private DwContextValueEvolutionWrapper contextValueEvolutionWrapper = null;
		
	//
//		public static final Image EXPORT_IMG = FMUIPlugin.getImage("export_wiz.gif");
//		public static final Image REFRESH_IMG = FMUIPlugin.getImage("refresh_tab.gif");

		@Override
		public void createPartControl(Composite parent) {
		
//			viewer = new TableViewer(parent);
//			viewer.setContentProvider(new IContentProvider() {
//				
//				@Override
//				public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
//					// TODO Auto-generated method stub
//					
//				}
//				
//				@Override
//				public void dispose() {
//					// TODO Auto-generated method stub
//					
//				}
//			});
//			contentProvider = new ContentProvider(viewer);
//			viewer.setContentProvider(contentProvider);
//			viewer.setLabelProvider(new TreeLabelProvider());
//			viewer.setInput(viewer);
			
//			viewer.addDoubleClickListener(new TreeClickListener(viewer));
//			ColumnViewerToolTipSupport.enableFor(viewer);

			getSite().getPage().addPartListener(editorListener);
			setEditor(getSite().getPage().getActiveEditor());
			currentInput = (currentEditor == null) ? null : ResourceUtil.getResource((currentEditor.getEditorInput()));

			 GridLayout layout = new GridLayout(2, false);
		        parent.setLayout(layout);
//		        Label searchLabel = new Label(parent, SWT.NONE);
//		        searchLabel.setText("Search: ");
//		        final Text searchText = new Text(parent, SWT.BORDER | SWT.SEARCH);
//		        searchText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		      
			List<DwAnomaly> anomalies = getAnomalies();
			List<DwFalseOptionalFeatureAnomaly> falseOptionalAnomalies = new ArrayList<DwFalseOptionalFeatureAnomaly>();
			List<DwVoidFeatureModelAnomaly> voidAnomalies = new ArrayList<DwVoidFeatureModelAnomaly>();
			
			for(DwAnomaly anomaly: anomalies){
				if( anomaly instanceof DwFalseOptionalFeatureAnomaly){
					falseOptionalAnomalies.add((DwFalseOptionalFeatureAnomaly) anomaly);
				} else if ( anomaly instanceof DwVoidFeatureModelAnomaly){
					voidAnomalies.add((DwVoidFeatureModelAnomaly) anomaly);
				}
			}
			
			
			createViewerFalseOptionalAnomaly(parent, falseOptionalAnomalies);
			
			createViewerVoidAnomaly(parent, voidAnomalies);
		        
		        
			
			addButtons();
		}
		
		
		private void createViewerVoidAnomaly(Composite parent, List<DwVoidFeatureModelAnomaly> voidAnomalies) {
	        viewerVoidAnomaly = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
	        createColumnsVoidAnomalies(viewerVoidAnomaly, parent);
	        final Table table = viewerVoidAnomaly.getTable();
	        table.setHeaderVisible(true);
	        table.setLinesVisible(true);

	        viewerVoidAnomaly.setContentProvider(new ArrayContentProvider());
	        // get the content for the viewer, setInput will call getElements in the
	        // contentProvider
	        
	        
	        viewerVoidAnomaly.setInput(voidAnomalies);
	        
	      
	        // make the selection available to other views
	        getSite().setSelectionProvider(viewerVoidAnomaly);
	        // set the sorter for the table

	        // define layout for the viewer
	        GridData gridData = new GridData();
	        gridData.verticalAlignment = GridData.FILL;
	        gridData.horizontalSpan = 2;
	        gridData.grabExcessHorizontalSpace = true;
	        gridData.grabExcessVerticalSpace = true;
	        gridData.horizontalAlignment = GridData.FILL;
	        viewerVoidAnomaly.getControl().setLayoutData(gridData);
	    }
		
		private void createViewerFalseOptionalAnomaly(Composite parent, List<DwFalseOptionalFeatureAnomaly> falseOptionalAnomalies) {
	        viewerFalseOptionalAnomaly = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
	        createColumnsFalseOptionalAnomalies(viewerFalseOptionalAnomaly, parent);
	        final Table table = viewerFalseOptionalAnomaly.getTable();
	        table.setHeaderVisible(true);
	        table.setLinesVisible(true);

	        viewerFalseOptionalAnomaly.setContentProvider(new ArrayContentProvider());
	        // get the content for the viewer, setInput will call getElements in the
	        // contentProvider
	        
	        viewerFalseOptionalAnomaly.setInput(falseOptionalAnomalies);
	        
	        
	        
	        // make the selection available to other views
	        getSite().setSelectionProvider(viewerFalseOptionalAnomaly);
	        // set the sorter for the table

	        // define layout for the viewer
	        GridData gridData = new GridData();
	        gridData.verticalAlignment = GridData.FILL;
	        gridData.horizontalSpan = 2;
	        gridData.grabExcessHorizontalSpace = true;
	        gridData.grabExcessVerticalSpace = true;
	        gridData.horizontalAlignment = GridData.FILL;
	        viewerFalseOptionalAnomaly.getControl().setLayoutData(gridData);
	    }
		
	    // create the columns for the table
	    private void createColumnsFalseOptionalAnomalies(TableViewer tableViewer, final Composite parent) {
	        String[] titles = { "Type of Anomaly", "feature", "begin", "end", "Explain" };
	        int[] bounds = { 100, 100, 100, 100, 100};

	        // first column is for the first name
	        TableViewerColumn col = createTableViewerColumn(tableViewer, titles[0], bounds[0], 0);
	        col.setLabelProvider(new ColumnLabelProvider() {
	            @Override
	            public String getText(Object element) {
	                DwAnomaly p = (DwAnomaly) element;
	                
	                if(p instanceof DwFalseOptionalFeatureAnomaly){
	                	return "False-Optional";
	                }else if(p instanceof DwVoidFeatureModelAnomaly){
	                	return "Void";
	                } else if (p instanceof DwDeadFeatureAnomaly){
	                	return "Dead";
	                }
	                return "";
	                
	               
	            }
	        });

	        // second column is for the last name
	        col = createTableViewerColumn(tableViewer, titles[1], bounds[1], 1);
	        col.setLabelProvider(new ColumnLabelProvider() {
	            @Override
	            public String getText(Object element) {
	            	DwAnomaly p = (DwAnomaly) element;
	            	if(p instanceof DwFalseOptionalFeatureAnomaly){
	            		HyFeature feature = ((DwFalseOptionalFeatureAnomaly) p).getFeature();
	            		return feature.getNames().get(0).getName();
	            	}
	            	return "";
	            }
	            
	        });
	//
	        // now the gender
	        col = createTableViewerColumn(tableViewer, titles[2], bounds[2], 2);
	        col.setLabelProvider(new ColumnLabelProvider() {
	            @Override
	            public String getText(Object element) {
	            	DwAnomaly p = (DwAnomaly) element;
	            	if(p instanceof DwFalseOptionalFeatureAnomaly){
	            		Date date = ((DwFalseOptionalFeatureAnomaly) p).getValidSince();
	            		if(date == null){
	            			return "NULL";
	            		}
	            		
	            		return date.toString();
	            	}
	            	return "";
	            }
	        });
	//
	        // now the status married
	        col = createTableViewerColumn(tableViewer, titles[3], bounds[3], 3);
	        col.setLabelProvider(new ColumnLabelProvider() {
	            @Override
	            public String getText(Object element) {
	            	DwAnomaly p = (DwAnomaly) element;
	            	if(p instanceof DwFalseOptionalFeatureAnomaly){
	            		Date date = ((DwFalseOptionalFeatureAnomaly) p).getValidUntil();
	            		if(date == null){
	            			return "NULL";
	            		}
	            		return date.toString();
	            	}
	            	return "";
	            }

	           
	        });
	        
	        col = createTableViewerColumn(tableViewer, titles[4], bounds[4], 4);
	 	   
	        col.setLabelProvider(new ColumnLabelProvider() {
	        	
	        	@Override
	        	public void update(ViewerCell cell) {
	        		TableItem item = (TableItem) cell.getItem();
	                Button button = new Button((Composite) cell.getViewerRow().getControl(), SWT.NONE);
	              
	                button.setText("Explain");
	                
//	                button.
	                
//	                TableEditor editor = new TableEditor(item.getParent());
//	                editor.grabHorizontal  = true;
//	                editor.grabVertical = true;
//	                editor.setEditor(button , item, cell.getColumnIndex());
//	                editor.layout();
	        	}
	        	
	        });

	        
//	        col = createTableViewerColumn(titles[4], bounds[4], 4);
//	        col.setLabelProvider(new ColumnLabelProvider() {
//	            @Override
//	            public String getText(Object element) {
//	            	DwAnomaly p = (DwAnomaly) element;
//	            	if(p instanceof DwVoidFeatureModelAnomaly){
//	            		Date date = ((DwVoidFeatureModelAnomaly) p)
//	            		return date.toString();
//	            	}
//	            	return "";
//	            }
	//
//	           
//	        });


	    }
	    
	 // create the columns for the table
	    private void createColumnsVoidAnomalies(final TableViewer tableViewer, final Composite parent) {
	        String[] titles = { "Type of Anomaly", "context values", "Date", "Explain", ""};
	        int[] bounds = { 100, 100, 100, 100, 100 };

	        // first column is for the first name
	        TableViewerColumn col = createTableViewerColumn(tableViewer, titles[0], bounds[0], 0);
	        col.setLabelProvider(new ColumnLabelProvider() {
	            @Override
	            public String getText(Object element) {
	                return "Void";
	               
	                
	               
	            }
	        });

	        // second column is for the last name
	        col = createTableViewerColumn(tableViewer, titles[1], bounds[1], 1);
	        col.setLabelProvider(new ColumnLabelProvider() {
	            @Override
	            public String getText(Object element) {
	            	DwAnomaly p = (DwAnomaly) element;
	            	if(p instanceof DwFalseOptionalFeatureAnomaly){
	            		HyFeature feature = ((DwFalseOptionalFeatureAnomaly) p).getFeature();
	            		return feature.getNames().get(0).getName();
	            	}
	            	return "";
	            }
	            
	        });
	//
	        // now the gender
	        col = createTableViewerColumn(tableViewer, titles[2], bounds[2], 2);
	        col.setLabelProvider(new ColumnLabelProvider() {
	            @Override
	            public String getText(Object element) {
	            	DwAnomaly p = (DwAnomaly) element;
	            	if(p instanceof DwFalseOptionalFeatureAnomaly){
	            		Date date = ((DwFalseOptionalFeatureAnomaly) p).getValidSince();
	            		if(date == null){
	            			return "NULL";
	            		}
	            		
	            		return date.toString();
	            	}
	            	return "";
	            }
	        });
	//
	        // now the status married
	        col = createTableViewerColumn(tableViewer, titles[3], bounds[3], 3);
	        col.setLabelProvider(new ColumnLabelProvider() {
	            @Override
	            public String getText(Object element) {
	            	DwAnomaly p = (DwAnomaly) element;
	            	if(p instanceof DwFalseOptionalFeatureAnomaly){
	            		Date date = ((DwFalseOptionalFeatureAnomaly) p).getValidUntil();
	            		if(date == null){
	            			return "NULL";
	            		}
	            		return date.toString();
	            	}
	            	return "";
	            }

	           
	        });
	        
	        col = createTableViewerColumn(tableViewer, titles[4], bounds[4], 4);
	   
	        col.setLabelProvider(new ColumnLabelProvider() {
	        	
	        	@Override
	        	public void update(ViewerCell cell) {
	        		TableItem item = (TableItem) cell.getItem();
	                Button button = new Button((Composite) cell.getViewerRow().getControl(), SWT.NONE);
	              
	                button.setText("Explain");
	                
//	                TableEditor editor = new TableEditor(item.getParent());
//	                editor.grabHorizontal  = true;
//	                editor.grabVertical = true;
//	                editor.setEditor(button , item, cell.getColumnIndex());
//	                editor.layout();
	        	}
	        	
	        });

	        
	    }
	    
	    private TableViewerColumn createTableViewerColumn(TableViewer parent, String title, int bound, final int colNumber) {
	        final TableViewerColumn viewerColumn = new TableViewerColumn(parent, SWT.NONE);
	        final TableColumn column = viewerColumn.getColumn();
	        column.setText(title);
	        column.setWidth(bound);
	        column.setResizable(true);
	        column.setMoveable(true);
	        return viewerColumn;
	    }
	    
	    

	    public TableViewer getViewer() {
	        return viewerFalseOptionalAnomaly;
	    }

		private void addButtons() {

			final IToolBarManager toolBarManager = getViewSite().getActionBars().getToolBarManager();

			final Action checkBoxer = new Action() {

				@Override
				public void run() {
					System.out.println("RUNRUNRURURURN");
//					final CheckBoxTreeViewDialog dial = new CheckBoxTreeViewDialog(viewer.getControl().getShell(), contentProvider.godfather, viewer);
//					dial.open();
				}
			};

			final Action refresher = new Action() {

				@Override
				public void run() {
					DwAnomalyView.this.refresh(true);
				}
			};

			toolBarManager.add(refresher);
//			refresher.setImageDescriptor(ImageDescriptor.createFromImage(REFRESH_IMG));
//			refresher.setToolTipText(REFRESH_VIEW);

			toolBarManager.add(checkBoxer);
//			checkBoxer.setImageDescriptor(ImageDescriptor.createFromImage(EXPORT_IMG));
			checkBoxer.setToolTipText("Export to *.csv");
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
			viewerFalseOptionalAnomaly.getControl().setFocus();
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

		


		private Job job = null;

		/**
		 * Refresh the view.
		 */
		private void refresh(final boolean force) {
//			if (contentProvider.isCanceled()) {
//				return;
//			}

			/*
			 * This job waits for the calculation job to finish and starts immediately a new one
			 */
//			final Job waiter = new Job(UPDATING_FEATURESTATISTICSVIEW) {
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
//						FMUIPlugin.getDefault().logError(e);
//					}
	//
//					job = new Job(UPDATING_FEATURESTATISTICSVIEW) {
	//
//						@Override
//						protected IStatus run(IProgressMonitor monitor) {
//							if (currentEditor == null) {
//								contentProvider.defaultContent();
//							} else {
//								final IResource anyFile = ResourceUtil.getResource(currentEditor.getEditorInput());
//								// TODO is refresh really necessary? -> true?
	//
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

//		private void cancelJobs() {
//			final JobDoneListener jobListener = JobDoneListener.getInstance();
//			if (jobListener != null) {
//				jobListener.cancelAllRunningTreeJobs();
//			}
//		}



		/**
		 * Watches changes in the feature model if the selected editor is an instance of @{link FeatureModelEditor}
		 */
		private void setEditor(IEditorPart newEditor) {
			if (currentEditor != null) {
				if (currentEditor == newEditor) {
					return;
				}

				if (currentEditor instanceof DwGraphicalFeatureModelEditor) {
					((DwGraphicalFeatureModelEditor) currentEditor).getModelWrapped().removePropertyChangeListener(modelListener);
//					getFeatureModel().removeListener(modelListener);
				}  else if (newEditor instanceof DwFeatureModelConfiguratorViewer){
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
			currentEditor = newEditor;
			if (newEditor instanceof DwGraphicalFeatureModelEditor) {
				((DwGraphicalFeatureModelEditor) currentEditor).getModelWrapped().addPropertyChangeListener(modelListener);
				modelWrapped = ((DwGraphicalFeatureModelEditor) currentEditor).getModelWrapped();
				
			} else if (newEditor instanceof DwFeatureModelConfiguratorViewer){
				((DwFeatureModelConfiguratorViewer) currentEditor).getModelWrapped().addPropertyChangeListener(modelListener);
				modelWrapped = ((DwFeatureModelConfiguratorViewer) currentEditor).getModelWrapped();
			} 
			refresh(force);
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
			
			return "http://hyvartest-hyvarrec.d33pmz246q.eu-west-1.elasticbeanstalk.com/";
//			DwRESTServerSelectDialog dialog = new DwRESTServerSelectDialog(getEditorSite().getShell(), DEFAULT_HYVARREC_URI);
//			int result = dialog.open();
//			if(result == Dialog.OK){
//				return dialog.getUri();
//			}
//			else {
//				return null;
//			}

//			return DEFAULT_HYVARREC_URI;
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

//			saveConfigurationIntoFeatureModelFolder();

			// allow to change the server uri
			String uri = getURI();
			

			DwAnalysesClient client = new DwAnalysesClient();
			
			
			
			

			try {
				
				
				
				
//				if(currentEditor instanceof DwFeatureModelConfiguratorViewer){
//					
//					contextValueEvolutionWrapper = client.validateFeatureModelWithContext(uri, contextModel,
//							validityModel, modelWrapped.getModel(), constraintModel, ((DwFeatureModelConfiguratorViewer) currentEditor).getSelectedConfiguration(), profile,
//							contextValueModel, modelWrapped.getSelectedDate());
//					System.out.println(contextValueEvolutionWrapper);
//
//					}

					List<DwAnomaly> anomalies = client.checkFeatures(uri, contextModel, validityModel, modelWrapped.getModel(), constraintModel, null, null);
					
					return anomalies;
					
					
				
			} catch (UnresolvedAddressException | TimeoutException | InterruptedException | ExecutionException e1) {
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
