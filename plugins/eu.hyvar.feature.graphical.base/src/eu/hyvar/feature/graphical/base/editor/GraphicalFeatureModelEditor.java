package eu.hyvar.feature.graphical.base.editor;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.deltaecore.feature.graphical.base.util.DEGraphicalEditorTheme;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
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
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.expression.extensionpoints.IFeatureModelEditor;
import eu.hyvar.feature.graphical.base.dialogs.DateDialog;
import eu.hyvar.feature.graphical.base.editparts.HyFeatureModelEditPart;
import eu.hyvar.feature.graphical.base.factory.HyFeatureModelEditPartFactory;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;


public class GraphicalFeatureModelEditor extends GraphicalEditor implements IFeatureModelEditor{
	// UI components
	Spinner currentState;
	Label currentDate;
	Scale scale;
	Spinner minState;
	Spinner maxState;
	Composite buttonGroup;

	Date currentSelectedDate;	

	protected boolean dirty = false;


	

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

			modelWrapped = new HyFeatureModelWrapped((HyFeatureModel)resource.getContents().get(0));
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
	}

	public void createSliderControl(Composite parent){
		List<Date> dates = modelWrapped.getDates();

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
				List<Date> dates = modelWrapped.getDates();
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
					modelWrapped.addDate(value);
					
					int size = modelWrapped.getDates().size();
					System.out.println(size);
					scale.setMaximum(size-1);
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
			modelWrapped.addDate(now);
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
	

	//@Override
	/*
	public void propertyChange(PropertyChangeEvent arg) {
		System.out.println(arg);
		if(arg.getPropertyName() == HyFeatureModelWrapped.PROPERTY_DATES_COUNT){
			List<Date> dates = modelWrapped.getDates();
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


*/



	//@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class type) {
		if(type == ZoomManager.class)
			return getGraphicalViewer().getProperty(ZoomManager.class.toString());
		else
			return super.getAdapter(type);

	}
	

	//@Override
	public EObject getInternalFeatureModel() {
		return modelWrapped.getModel();
	}
}
