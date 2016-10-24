package eu.hyvar.feature.graphical.base.editor;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.EventObject;
import java.util.List;

import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MArea;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainerElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MStackElement;
import org.eclipse.e4.ui.model.application.ui.basic.impl.BasicFactoryImpl;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeaturePackage;
import eu.hyvar.feature.expression.extensionpoints.IFeatureModelEditor;
import eu.hyvar.feature.graphical.base.dialogs.DateDialog;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureModelEditPart;
import eu.hyvar.feature.graphical.base.factory.HyFeatureModelEditPartFactory;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelEvolutionWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;

@SuppressWarnings("restriction")
public class GraphicalFeatureModelEditor extends GraphicalEditor implements IFeatureModelEditor, PropertyChangeListener{
	// UI components
	Spinner currentState;
	Label currentDate;
	Scale scale;
	Spinner minState;
	Spinner maxState;
	Composite buttonGroup;

	Date currentSelectedDate;	

	protected boolean dirty = false;


	private MPartStack secondEditor;

	public Date getCurrentSelectedDate() {
		return currentSelectedDate;
	}



	public boolean isDirty() {
		return dirty;
	}
	public void setDirty(boolean value) {
		dirty = value;

		firePropertyChange(PROP_DIRTY);
	}	

	public void setCurrentSelectedDate(Date currentSelectedDate) {
		this.currentSelectedDate = currentSelectedDate;

		HyFeatureModelEvolutionWrapped model = (HyFeatureModelEvolutionWrapped)modelWrapped;
		if(currentSelectedDate.getTime() == Long.MIN_VALUE){
			currentDate.setText("before "+ model.getDates().get(1).toString());
		}
		else if(currentSelectedDate.getTime() == Long.MAX_VALUE){
			currentDate.setText("after "+ model.getDates().get(model.getDates().size()-2).toString());
		}
		else
		{
			currentDate.setText(currentSelectedDate.toString());
		}


		((HyFeatureModelEvolutionWrapped)modelWrapped).setSelectedDate(currentSelectedDate);

		refreshView();
	}


	public void refreshView(){
		GraphicalViewer viewer = getGraphicalViewer();

		if(viewer != null)
			viewer.getContents().refresh();
	}

	/**
	 * 
	 * @param date
	 */
	public void dateChanged(Date date){
		setCurrentSelectedDate(date);
	}


	public HyFeatureModelWrapped getModelWrapped() {
		return modelWrapped;
	}

	public void executeCommand(Command command) {
		CommandStack commandStack = getCommandStack();
		commandStack.execute(command);
	}

	public void setModelWrapped(HyFeatureModelWrapped modelWrapped) {
		this.modelWrapped = modelWrapped;
	}

	protected Resource resource;

	protected IFile file;
	// Use the theme editor from DeltaEcore for consistency
	private static DEGraphicalEditorTheme theme = new DEGraphicalEditorTheme();

	public static DEGraphicalEditorTheme getTheme() {
		return theme;
	}	

	protected HyFeatureModelWrapped modelWrapped;

	public GraphicalFeatureModelEditor(){
		setEditDomain(new DefaultEditDomain(this));	
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		if(resource == null) return;
		setDirty(false);

		try{
			resource.save(null);
			getCommandStack().markSaveLocation();
		}catch(IOException e){
			e.printStackTrace();
			resource = null;
		}
	}




	@Override
	protected void initializeGraphicalViewer() {
		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setContents(modelWrapped);
	}


	@Override
	public void dispose(){
		IEditorReference[] refs = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences();
		for(IEditorReference ref : refs){
			IEditorPart part = ref.getEditor(false);
			try{
				part.getSite().getPage().closeEditor(part, true);
			}catch(Exception e){			
			}
		}
	}

	public void insertEditor(float ratio, int where, MPart containerEditor, MPart editorToInsert) {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

		EModelService service = window.getService(EModelService.class);

		if(secondEditor == null){
			secondEditor = getPartStack(editorToInsert);

			MArea area = getArea(containerEditor);

			MPartSashContainerElement relToElement = area.getChildren().get(0);
			service.insert(secondEditor, relToElement, where, ratio);
		}else{
			secondEditor.getChildren().add(editorToInsert);
		}
	}

	private MPartStack getPartStack(MPart childPart) {
		MStackElement stackElement = childPart;
		MPartStack newStack = BasicFactoryImpl.eINSTANCE.createPartStack();
		newStack.getChildren().add(stackElement);
		newStack.setSelectedElement(stackElement);
		return newStack;				
	}

	private MArea getArea(MPart containerPart) {
		MUIElement targetParent = containerPart.getParent();
		while (!(targetParent instanceof MArea))
			targetParent = targetParent.getParent();
		MArea area = (MArea) targetParent;
		return area;
	}	


	protected void openEditorForFileExtension(String fileExtension){
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
		IWorkbenchPage workbenchPage = workbenchWindow.getActivePage();
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot workspaceRoot = workspace.getRoot();

		IPath path = ((IPath)file.getFullPath().clone()).removeFileExtension().addFileExtension(fileExtension);

		IFile file = workspaceRoot.getFile(path);
		if(!file.exists()){
			InputStream source = new ByteArrayInputStream("".getBytes());
			try {
				file.create(source, IResource.NONE, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}

		// only open editor if a file exist with the same name as the feature model in same directory
		if(workspaceRoot.exists(path)){
			IFile constraintFile = workspaceRoot.getFile(path);

			IEditorDescriptor desc = PlatformUI.getWorkbench().
					getEditorRegistry().getDefaultEditor(constraintFile.getName());

			if(desc == null){
				System.err.println("No editor for file extension "+fileExtension+" exist");
				return;
			}

			try {
				IEditorPart editor = workbenchPage.openEditor(new FileEditorInput(constraintFile), desc.getId());

				MPart constraintEditorPart = editor.getSite().getService(MPart.class);
				MPart editorPart = this.getSite().getService(MPart.class);

				if (editorPart == null) {
					return;
				}

				insertEditor(0.3f, EModelService.RIGHT_OF, editorPart, constraintEditorPart);
			} catch (PartInitException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Tries to load a feature model from a given file
	 * @param file
	 */
	protected void loadModelFromFile(IFile file){
		// save location to the file
		this.file = file;

		ResourceSet resourceSet = new ResourceSetImpl();
		resource = resourceSet.createResource(URI.createURI(file.getLocationURI().toString()));
		try{
			resource.load(null);

			modelWrapped = new HyFeatureModelEvolutionWrapped((HyFeatureModel)resource.getContents().get(0));
			//modelWrapped.addPropertyChangeListener(this);

			List<Date> dates = HyEvolutionUtil.collectDates(modelWrapped.getModel());
			currentSelectedDate = (dates.size() == 0) ? new Date() : dates.get(0);


			setEditorTabText(file.getName());
			//modelWrapped = new HyFeatureModelWrapped((HyFeatureModel)resource.getContents().get(0));
			//modelWrapped.rearrangeFeatures();
		}catch(IOException e){
			e.printStackTrace();
			resource = null;
		}
	}

	/**
	 * Sets the name of the tab related to the editor which will shown to the user in Eclipse
	 * @param text
	 */
	protected void setEditorTabText(String text){
		this.setPartName(text);
	}


	protected void setInput(IEditorInput input) {
		HyFeaturePackage.eINSTANCE.eClass();

		super.setInput(input);
		loadModelFromFile(((IFileEditorInput) input).getFile());

		setDirty(false);
	}


	/**
	 * Hook the evolution factory into the editor logic and override the standard edit part factory
	 */
	@Override
	public void configureGraphicalViewer() {
		super.configureGraphicalViewer();

		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setEditPartFactory(new HyFeatureModelEditPartFactory(viewer, this));
		viewer.setRootEditPart(new ScalableFreeformRootEditPart());
	}

	@Override
	public void commandStackChanged(EventObject event){
		firePropertyChange(PROP_DIRTY);
		super.commandStackChanged(event);
	}


	public void createSliderControl(Composite parent){
		List<Date> dates = ((HyFeatureModelEvolutionWrapped)modelWrapped).getDates();

		int size = dates.size(); 
		buttonGroup = new Composite(parent, SWT.NONE);
		RowLayout rowLayout = new RowLayout(SWT.HORIZONTAL);
		rowLayout.justify = true;
		buttonGroup.setLayout(rowLayout);





		currentDate = new Label(buttonGroup, SWT.NATIVE);
		if(dates.size() > 0)
			currentDate.setText(dates.get(0).toString());
		else{
			currentDate.setText((new Date()).toString());
		}


		currentState = new Spinner (buttonGroup, SWT.NATIVE);
		currentState.setMinimum(1);
		currentState.setMaximum(size);
		currentState.setSelection(1);
		currentState.setIncrement(1);
		currentState.setLayoutData(new RowData(60, SWT.DEFAULT));
		currentState.setEnabled(size > 0);
		currentState.addModifyListener(new ModifyListener(){
			@Override
			public void modifyText(ModifyEvent e) {
				int index = ((Spinner)e.widget).getSelection()-1;
				if(index >= minState.getSelection())
					scale.setSelection(index);
			}
		});

		Label minStateLabel = new Label(buttonGroup, SWT.CENTER);
		minStateLabel.setText("Date range from ");
		minState = new Spinner (buttonGroup, SWT.NATIVE);
		minState.setMinimum(1);
		minState.setMaximum(size);
		minState.setSelection(currentState.getSelection());
		minState.setIncrement(1);
		minState.setEnabled(size > 2);
		minState.addListener(SWT.Selection, new Listener(){
			public void handleEvent(Event event){
				int index = ((Spinner)event.widget).getSelection()-1;
				scale.setMinimum(index);
			}
		});

		Label maxStateLabel = new Label(buttonGroup, SWT.NATIVE);
		maxStateLabel.setText(" to ");		
		maxState = new Spinner (buttonGroup, SWT.NATIVE);
		maxState.setMinimum(minState.getSelection());
		maxState.setMaximum(size);
		maxState.setSelection(1);
		maxState.setIncrement(1);
		maxState.setEnabled(size > 2);
		maxState.addListener(SWT.Selection, new Listener(){
			public void handleEvent(Event event){
				int index = ((Spinner)event.widget).getSelection()-1;
				scale.setMaximum(index);
			}
		});

		scale = new Scale(buttonGroup, SWT.FILL);
		scale.setMinimum(0);
		scale.setMaximum(size-1);
		scale.setLayoutData(new RowData(300, SWT.DEFAULT));
		scale.setEnabled(size > 2);

		scale.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				List<Date> dates = ((HyFeatureModelEvolutionWrapped)modelWrapped).getDates();
				int index = scale.getSelection();
				currentState.setSelection(index+1);

				dateChanged(dates.get(index));
			}	
		});

		Button addDate = new Button(buttonGroup, SWT.PUSH);
		addDate.setText("Add Date");
		addDate.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				DateDialog dialog = new DateDialog(null, new Date());
				dialog.open();
				Date value = dialog.getValue();

				if(value != null){
					((HyFeatureModelEvolutionWrapped)modelWrapped).addDate(value);
					
					int size = ((HyFeatureModelEvolutionWrapped)modelWrapped).getDates().size()-1;
					scale.setMaximum(size);
					scale.setEnabled(size > 2);
				}				
			}	
		});

		minState.addModifyListener(new ModifyListener(){
			@Override
			public void modifyText(ModifyEvent e) {

				scale.setMinimum(((Spinner)e.widget).getSelection());
			}
		});
		maxState.addModifyListener(new ModifyListener(){

			@Override
			public void modifyText(ModifyEvent e) {
				scale.setMaximum(((Spinner)e.widget).getSelection());
			}
		});	

		if(dates.size() > 0)
			this.setCurrentSelectedDate(dates.get(0));
		else{
			Date now = new Date();
			((HyFeatureModelEvolutionWrapped)modelWrapped).addDate(now);
			this.setCurrentSelectedDate(now);
		}		
	}

	@Override
	/**
	 * Creates the editor and adds a control bar to switch between dates
	 */
	public void createPartControl(Composite parent){
		parent.setLayout(new GridLayout(2, false));

		createEditor(parent);
		createSliderControl(parent);
		((HyFeatureModelEditPart)getGraphicalViewer().getContents()).refresh();
	}

	public void createEditor(Composite parent){
		GraphicalViewer viewer = new ScrollingGraphicalViewer();
		Control control = viewer.createControl(parent);

		if(parent.getLayout() instanceof GridLayout){ 
			GridData gridData = new GridData();
			gridData.horizontalSpan = 2;
			gridData.horizontalAlignment = SWT.FILL;
			gridData.grabExcessHorizontalSpace = true;
			gridData.verticalAlignment = SWT.FILL;
			gridData.grabExcessVerticalSpace = true;
			control.setLayoutData(gridData);
		}

		setGraphicalViewer(viewer);
		configureGraphicalViewer();
		hookGraphicalViewer();
		initializeGraphicalViewer();
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg) {
		if(arg.getPropertyName() == HyFeatureModelEvolutionWrapped.PROPERTY_DATES_COUNT){
			List<Date> dates = ((HyFeatureModelEvolutionWrapped)modelWrapped).getDates();
			int size = dates.size();
			boolean enabled = size > 1;
			scale.setMaximum(size-1);
			scale.setEnabled(enabled);

			currentState.setMaximum(size);
			currentState.setEnabled(enabled);

			maxState.setMaximum(size);
			maxState.setEnabled(enabled);

			minState.setMaximum(size);
			minState.setEnabled(enabled);
		}
	}




	@Override
	public EObject getInternalFeatureModel() {
		return modelWrapped.getModel();
	}

	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class type) {
		if(type == ZoomManager.class)
			return getGraphicalViewer().getProperty(ZoomManager.class.toString());
		else
			return super.getAdapter(type);

	}


}
