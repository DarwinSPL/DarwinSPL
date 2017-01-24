package eu.hyvar.feature.graphical.base.editor;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.KeyStroke;
import org.eclipse.gef.MouseWheelHandler;
import org.eclipse.gef.MouseWheelZoomHandler;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.ui.actions.ZoomInAction;
import org.eclipse.gef.ui.actions.ZoomOutAction;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import de.christophseidl.util.ecore.EcoreIOUtil;
import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyFeaturePackage;
import eu.hyvar.feature.expression.extensionpoints.IFeatureModelEditor;
import eu.hyvar.feature.graphical.base.dialogs.DateDialog;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureModelEditPart;
import eu.hyvar.feature.graphical.base.factory.HyFeatureModelEditPartFactory;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;


public class HyGraphicalFeatureModelViewer extends GraphicalEditor implements IFeatureModelEditor, Listener{
	// UI components
	protected Button currentDate;
	protected Button addDate;
	protected Scale scale;
	protected Combo minState;
	protected Combo maxState;
	protected Composite buttonGroup;

	protected Date currentSelectedDate;	

	protected Resource resource;

	protected IFile file;

	protected HyFeatureModelWrapped modelWrapped;

	protected KeyHandler sharedKeyHandler;
	
	public Date getCurrentSelectedDate() {
		return currentSelectedDate;
	}


	public void executeCommand(Command command) {
		CommandStack commandStack = getCommandStack();
		commandStack.execute(command);
	}



	public void setCurrentSelectedDate(Date currentSelectedDate) {
		this.currentSelectedDate = currentSelectedDate;

		if(currentSelectedDate.getTime() == Long.MIN_VALUE){
			if(modelWrapped.getDates().size() > 1)
				currentDate.setText("before "+ modelWrapped.getDates().get(1).toString());
		}
		else if(currentSelectedDate.getTime() == Long.MAX_VALUE){
			currentDate.setText("after "+ modelWrapped.getDates().get(modelWrapped.getDates().size()-2).toString());
		}
		else
		{
			currentDate.setText(currentSelectedDate.toString());
		}


		modelWrapped.setSelectedDate(currentSelectedDate);

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

	public void setModelWrapped(HyFeatureModelWrapped modelWrapped) {
		this.modelWrapped = modelWrapped;
	}

	public HyGraphicalFeatureModelViewer(){
		setEditDomain(new DefaultEditDomain(this));	
		
//		resourceSet = new ResourceSetImpl();
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);

		HyFeaturePackage.eINSTANCE.eClass();
		if(input instanceof IFileEditorInput) {
			IFileEditorInput fileInput = (IFileEditorInput) input;
			loadModelFromFile(fileInput.getFile());
		}
	}


	public IFile getFile() {
		return file;
	}


	@Override
	public void doSave(IProgressMonitor monitor) {}




	@Override
	protected void initializeGraphicalViewer() {
		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setContents(modelWrapped);
		enableZoomWithMouseWheel();
	}


	protected KeyHandler getCommonKeyHandler() {
		ZoomManager manager = (ZoomManager) getGraphicalViewer().getProperty(ZoomManager.class.toString());

		if (sharedKeyHandler == null) {
			sharedKeyHandler = new KeyHandler();
			sharedKeyHandler.put(KeyStroke.getPressed('+', SWT.KEYPAD_ADD, SWT.CONTROL),
					new ZoomInAction(manager));
			sharedKeyHandler.put(KeyStroke.getPressed('-', SWT.KEYPAD_SUBTRACT, SWT.CONTROL),
					new ZoomOutAction(manager));
		}

		return sharedKeyHandler;
	}
	protected void enableZoomWithMouseWheel() {
		// Zoom
		ZoomManager manager = (ZoomManager) getGraphicalViewer().getProperty(
				ZoomManager.class.toString());
		if (manager != null)
			manager.setZoom(1);


		// Scroll-wheel Zoom
		getGraphicalViewer().setProperty(
				MouseWheelHandler.KeyGenerator.getKey(SWT.MOD1),
				MouseWheelZoomHandler.SINGLETON);
	}



	

	protected void setCurrentSelectedDateToMostActualDate(){
		List<Date> dates = HyEvolutionUtil.collectDates(modelWrapped.getModel());
		Date currentDate = new Date();
		Date closestDate = new Date(Long.MIN_VALUE);
		for(Date date : dates){
			if(date.before(currentDate)){
				if(date.after(closestDate))
					closestDate = date;
			}
		}

		currentSelectedDate = closestDate;	
	}




	/**
	 * Tries to load a feature model from a given file
	 * @param file
	 */
	protected void loadModelFromFile(IFile file){		
		// save location to the file
		this.file = file;

		modelWrapped = new HyFeatureModelWrapped((HyFeatureModel)EcoreIOUtil.loadModel(file));
		
		this.resource = modelWrapped.getModel().eResource();
		
		setCurrentSelectedDateToMostActualDate();
		
		setEditorTabText(file.getName());
		
		loadLayout(file);
	}



	/**
	 * Sets the name of the tab related to the editor which will shown to the user in Eclipse
	 * @param text
	 */
	protected void setEditorTabText(String text){
		this.setPartName(text);
	}


	protected void setInput(IEditorInput input) {
		super.setInput(input);
		loadModelFromFile(((IFileEditorInput) input).getFile());
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


		ZoomManager manager = (ZoomManager) getGraphicalViewer().getProperty(ZoomManager.class.toString());

		getActionRegistry().registerAction(new ZoomInAction(manager));
		getActionRegistry().registerAction(new ZoomOutAction(manager));

	}

	public void registerControlListeners(){

		// Left button to select an individual date
		currentDate.addListener(SWT.Selection, new Listener(){
			public void handleEvent(Event event){
				DateDialog dialog = new DateDialog(getEditorSite().getShell(), getCurrentSelectedDate());
				dialog.open();
				if(dialog.getReturnCode()==0){
					Date newDate = dialog.getValue();
					if(modelWrapped.addDate(newDate)){
						int size = modelWrapped.getDates().size();
						scale.setMaximum(size-1);
						scale.setEnabled(size > 1);

						scale.setSelection(modelWrapped.getDates().indexOf(newDate));
						dateChanged(newDate);
					}
				}
			}
		});

		// Mininimum value for range restriction for the slider
//		minState.addListener(SWT.Selection, new Listener(){
//			public void handleEvent(Event event){
//				int index = ((Combo)event.widget).getSelectionIndex();
//				scale.setMinimum(index);
//			}
//		});
//
//		// Maximum value for range restriction for the slider
//		maxState.addListener(SWT.Selection, new Listener(){
//			public void handleEvent(Event event){
//				int index = ((Combo)event.widget).getSelectionIndex();
//				scale.setMaximum(index);
//			}
//		});

		// Slider to select a given date
		scale.addListener(SWT.Selection, this);

		// Button that adds a new date to the model
		addDate.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				DateDialog dialog = new DateDialog(null, new Date());
				dialog.open();
				Date value = dialog.getValue();

				if(value != null){
					modelWrapped.addDate(value);

					int size = modelWrapped.getDates().size();
					scale.setMaximum(size-1);
					scale.setEnabled(size > 1);
				}				
			}	
		});
	}

	public void createSliderControl(Composite parent){
		List<Date> dates = modelWrapped.getDates();

		int size = dates.size(); 
		buttonGroup = new Composite(parent, SWT.NONE);
		RowLayout rowLayout = new RowLayout(SWT.HORIZONTAL);
		rowLayout.justify = true;
		buttonGroup.setLayout(rowLayout);

		currentDate = new Button(buttonGroup, SWT.PUSH);


		if(dates.size() > 0)
			currentDate.setText(dates.get(0).toString());
		else{
			currentDate.setText((new Date()).toString());
		}

//		Label minStateLabel = new Label(buttonGroup, SWT.CENTER);
//		minStateLabel.setText("Date range from ");
//		minState = new Combo (buttonGroup, SWT.READ_ONLY);
//		for(Date date : dates){
//			minState.add(date.toString());
//		}
//		minState.select(0);
//		minState.setEnabled(size > 1);
//
//
//		Label maxStateLabel = new Label(buttonGroup, SWT.NATIVE);
//		maxStateLabel.setText(" to ");		
//		maxState = new Combo (buttonGroup, SWT.NATIVE);
//
//		for(Date date : dates){
//			maxState.add(date.toString());
//		}
//		maxState.select(dates.size()-1);
//		maxState.setEnabled(size > 1);


		scale = new Scale(buttonGroup, SWT.FILL);
		scale.setMinimum(0);
		scale.setMaximum(size-1);
		scale.setLayoutData(new RowData(300, SWT.DEFAULT));
		scale.setEnabled(size > 1);
		scale.setSelection(dates.indexOf(currentSelectedDate));



		addDate = new Button(buttonGroup, SWT.PUSH);
		addDate.setText("Add Date");


		if(dates.size() > 0)
			setCurrentSelectedDate(currentSelectedDate);
		else{
			Date now = new Date();
			modelWrapped.addDate(now);
			setCurrentSelectedDate(now);
		}		
	}



	/**
	 * Creates the editor and adds a control bar to switch between dates
	 */
	@Override
	public void createPartControl(Composite parent){
		parent.setLayout(new GridLayout(2, false));

		createEditor(parent);
		createSliderControl(parent);
		registerControlListeners();
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
	public Object getAdapter(@SuppressWarnings("rawtypes") Class type) {
		if(type == ZoomManager.class)
			return getGraphicalViewer().getProperty(ZoomManager.class.toString());
		else
			return super.getAdapter(type);

	}


	@Override
	public HyFeatureModel getInternalFeatureModel() {
		return modelWrapped.getModel();
	}

	protected void loadLayout(IFile file){

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot workspaceRoot = workspace.getRoot();

		IPath path = ((IPath)file.getFullPath().clone()).removeFileExtension().addFileExtension("hylayout");
		IResource resourceInRuntimeWorkspace = workspaceRoot.findMember(path.toString());

		if(resourceInRuntimeWorkspace != null){
			File cfile = new File(resourceInRuntimeWorkspace.getLocationURI());

			if(cfile.exists()){
				try {
					List<String> lines = Files.readAllLines(Paths.get(cfile.getPath()), Charset.defaultCharset());
					for(String line : lines){
						String[] parts = line.split(",");
						if(parts.length != 3){
							System.err.println("Layout file is corrupt at some point");
							continue;
						}

						String id = parts[0];
						int x = Integer.parseInt(parts[1]);
						int y = Integer.parseInt(parts[2]);

						modelWrapped.setAutoLayoutActive(false);
						for(HyFeatureWrapped featureWrapped : this.getModelWrapped().getFeatures(null)){
							if(id.equals(featureWrapped.getWrappedModelElement().getId())){
								featureWrapped.setPosition(new Point(x, y), false);
							}
						}

						this.refreshView();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		}
	}


	@Override
	public void handleEvent(Event event) {
		if(event.widget.equals(scale)) {
			List<Date> dates = modelWrapped.getDates();
			int index = scale.getSelection();
			//currentState.setSelection(index+1);
			
			dateChanged(dates.get(index));			
		}
	}
}
