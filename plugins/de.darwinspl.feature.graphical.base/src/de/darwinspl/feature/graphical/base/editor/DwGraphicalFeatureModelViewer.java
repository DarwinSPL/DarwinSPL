package de.darwinspl.feature.graphical.base.editor;

import java.util.Date;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;

import de.christophseidl.util.ecore.EcoreIOUtil;
import de.darwinspl.feature.graphical.base.dialogs.DwDateDialog;
import de.darwinspl.feature.graphical.base.factory.DwFeatureModelEditPartFactory;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.base.util.DwFeatureModelLayoutFileUtil;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.expression.extensionpoints.IFeatureModelEditor;


public class DwGraphicalFeatureModelViewer extends DwGraphicalViewerWithZoomSupport implements IFeatureModelEditor, Listener{

	// UI components
	protected Button currentDate;
	protected Button addDate;
	protected Scale scale;
	protected Combo minState;
	protected Combo maxState;
	protected Composite buttonGroup;

	protected Date currentSelectedDate;	

	protected DwFeatureModelWrapped modelWrapped;

	private boolean lastDateSelected;

	public Date getCurrentSelectedDate() {
		return currentSelectedDate;
	}

	public boolean isLastDateSelected() {
		return modelWrapped.getDates().indexOf(modelWrapped.getSelectedDate()) == modelWrapped.getDates().size()-1;
	}

	/**
	 * Adds a command to the command stack and executes it. 
	 * Use this function to hook custom commands into the GEF command queue.
	 * 
	 * @param command the command that should be executed
	 */
	public void executeCommand(Command command) {
		CommandStack commandStack = getCommandStack();
		commandStack.execute(command);
	}

	/**
	 * Changes the selected date from the feature model and force a rerendering of the editor
	 * to show the feature model at this date.
	 * 
	 * @param currentSelectedDate the desired date for displaying the feature model
	 */
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
	}

	/**
	 * Gets the dimension of the editor window. 
	 * Please be aware that this function returns the exact dimension that are visible to the user
	 * rather than the dimension of the editor window content.
	 * @return Size of the current visible editor area
	 */
	public Dimension getEditorGraphicalDimension(){
		FigureCanvas c = ((FigureCanvas) getGraphicalViewer().getControl());

		Rectangle bounds = c.getContents().getBounds();
		return new Dimension(bounds.width, bounds.height);
	}

	/**
	 * Refresh the view and rerender the feature model.
	 */
	public void refreshView(){
		GraphicalViewer viewer = getGraphicalViewer();

		if(viewer != null)
			viewer.getContents().refresh();
	}

	public DwFeatureModelWrapped getModelWrapped() {
		return modelWrapped;
	}

	public void setModelWrapped(DwFeatureModelWrapped modelWrapped) {
		this.modelWrapped = modelWrapped;
	}

	public DwGraphicalFeatureModelViewer(){
		setEditDomain(new DefaultEditDomain(this));	
	}

	public IFile getFile() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot workspaceRoot = workspace.getRoot();

		return workspaceRoot.getFile(new Path(modelWrapped.getModel().eResource().getURI().toPlatformString(true)));
	}


	@Override
	public void doSave(IProgressMonitor monitor) {}




	@Override
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();

		GraphicalViewer viewer = getGraphicalViewer();
		viewer.setContents(modelWrapped);
	}

	/**
	 * Changes the date to the most actual date from now. 
	 * Does not cause a rerendering of the feature model.
	 */
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

		lastDateSelected = true;
		currentSelectedDate = closestDate;	
	}

	/**
	 * Tries to load a feature model from a given file
	 * @param file
	 */
	protected void loadModelFromFile(IFile file){		
		modelWrapped = new DwFeatureModelWrapped((HyFeatureModel)EcoreIOUtil.loadModel(file));

		setCurrentSelectedDateToMostActualDate();

		setEditorTabText(file.getName());

		DwFeatureModelLayoutFileUtil.loadLayoutFile(modelWrapped);
		List<Date> dates = DwFeatureModelLayoutFileUtil.loadDatesFromLayoutFile(modelWrapped);
		for(Date date : dates){
			if(!modelWrapped.getDates().contains(date))
				modelWrapped.addDate(date);
		}

	}

	/**
	 * Sets the name of the tab related to the editor which will shown to the user in Eclipse
	 * @param text
	 */
	protected void setEditorTabText(String text){
		this.setPartName(text);
	}

	/**
	 * Extracts the file which correspond to the current editor instance and
	 * loads the underlying feature model saved in that file. This method is called
	 * during initialising the editor.
	 */
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
		viewer.setEditPartFactory(new DwFeatureModelEditPartFactory(viewer, this));
		viewer.setRootEditPart(new ScalableFreeformRootEditPart());
	}

	/**
	 * Register listeners to react on widget changes from the time line like the date slider
	 * or the add date dialog
	 */
	public void registerControlListeners(){
		// Left button to select an individual date
		currentDate.addListener(SWT.Selection, new Listener(){
			public void handleEvent(Event event){
				DwDateDialog dialog = new DwDateDialog(getEditorSite().getShell(), getCurrentSelectedDate());
				dialog.open();
				if(dialog.getReturnCode()==0){
					Date newDate = dialog.getValue();
					if(modelWrapped.addDate(newDate)){
						int size = modelWrapped.getDates().size();
						scale.setMaximum(size-1);
						scale.setEnabled(size > 1);

						int index = modelWrapped.getDates().indexOf(newDate);
						scale.setSelection(index);
						setCurrentSelectedDate(newDate);

						if(index == modelWrapped.getDates().size()-1)
							lastDateSelected = true;
					}
				}
			}
		});

		// Slider to select a given date
		scale.addListener(SWT.Selection, this);

		// Button that adds a new date to the model
		addDate.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				DwDateDialog dialog = new DwDateDialog(null, new Date());
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

	/**
	 * Creates all widgets (slider and add date button) to the editor to perform date changes.
	 * @param parent
	 */
	public void createSliderControl(final Composite parent){
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

			lastDateSelected = true;
		}		

		/**
		 * register control listener for visualization bug if a side editor was added
		 */
		parent.addControlListener(new ControlListener(){

			@Override
			public void controlMoved(ControlEvent e) {
			}

			@Override
			public void controlResized(ControlEvent e) {
				parent.update();
			}

		});
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
	}

	/**
	 * Overrides the underlying editor widget to add the date slider to it.
	 * @param parent
	 */
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

	/**
	 * Returns the underlying EMF based feature model. 
	 * @see eu.hyvar.feature
	 */
	@Override
	public HyFeatureModel getInternalFeatureModel() {
		return modelWrapped.getModel();
	}

	/**
	 * Handles the date slider change and causes a rerendering of the feature model at the new
	 * date which is selected by using the slider.
	 *
	 * @param event the event which occurred
	 */
	@Override
	public void handleEvent(Event event) {
		if(event.widget.equals(scale)) {
			int index = scale.getSelection();
			currentSelectedDate = modelWrapped.getDates().get(scale.getSelection());
			setCurrentSelectedDate(currentSelectedDate);
			
			if(index == modelWrapped.getDates().size()-1)
				lastDateSelected = true;
		}
	}
}
