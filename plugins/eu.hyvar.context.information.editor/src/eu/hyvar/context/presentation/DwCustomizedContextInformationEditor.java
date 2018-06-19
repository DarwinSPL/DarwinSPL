package eu.hyvar.context.presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.EventObject;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;

import eu.hyvar.context.util.HyContextInformationAdapterFactory;
import eu.hyvar.evolution.util.HyEvolutionUtil;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecp.ui.view.ECPRendererException;
import org.eclipse.emf.ecp.ui.view.swt.ECPSWTView;
import org.eclipse.emf.ecp.ui.view.swt.ECPSWTViewRenderer;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;

public class DwCustomizedContextInformationEditor extends EditorPart implements Listener {

	protected AdapterFactoryEditingDomain editingDomain;
	protected ComposedAdapterFactory adapterFactory;
	private Resource contextResource;

	List<Date> dates;
	Date currentSelectedDate;
	boolean lastDateSelected;

	// UI Elements
	Composite buttonGroup;
	Button currentDateButton;
	Scale scale;
	private ECPSWTView renderedComposite;

	public DwCustomizedContextInformationEditor() {
		super();
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		try {
			contextResource.save(null);
			((BasicCommandStack) editingDomain.getCommandStack()).saveIsDone();
			firePropertyChange(IEditorPart.PROP_DIRTY);
			
			//this forces a new date list to be fetched
			refreshDatesList();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doSaveAs() {
		SaveAsDialog saveAsDialog = new SaveAsDialog(getSite().getShell());
		saveAsDialog.open();
		IPath path = saveAsDialog.getResult();
		if (path != null) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if (file != null) {
				doSaveAs(URI.createPlatformResourceURI(file.getFullPath().toString(), true), new FileEditorInput(file));
			}
		}

	}

	protected void doSaveAs(URI uri, IEditorInput editorInput) {
		(editingDomain.getResourceSet().getResources().get(0)).setURI(uri);
		setInputWithNotify(editorInput);
		setPartName(editorInput.getName());
		IProgressMonitor progressMonitor = getActionBars().getStatusLineManager() != null
				? getActionBars().getStatusLineManager().getProgressMonitor()
				: new NullProgressMonitor();
		doSave(progressMonitor);
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		setSite(site);
		setInput(input);
		setPartName(input.getName());
		// initialize the date list
		dates = new ArrayList<Date>();
		if (input instanceof IFileEditorInput) {
			IFileEditorInput fileInput = (IFileEditorInput) input;
			IFile file = fileInput.getFile();
			try {
				loadContent(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		editingDomain.getCommandStack().addCommandStackListener(new CommandStackListener() {
			public void commandStackChanged(final EventObject event) {
				getSite().getShell().getDisplay().asyncExec(new Runnable() {
					public void run() {
						firePropertyChange(IEditorPart.PROP_DIRTY);
					}
				});
			}
		});
	}

	@Override
	public boolean isDirty() {
		return ((BasicCommandStack) editingDomain.getCommandStack()).isSaveNeeded();
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public void createPartControl(Composite parent) {
		try {
			final Composite content = new Composite(parent, SWT.NONE);
			content.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_WHITE));
			content.setLayout(GridLayoutFactory.fillDefaults().margins(10, 10).create());
			content.setLayoutData(GridDataFactory.fillDefaults().create());
			EObject contextObject = contextResource.getContents().get(0);
			renderedComposite = ECPSWTViewRenderer.INSTANCE.render(content, contextObject);

			createSliderControl(content);
			registerControlListeners();

		} catch (ECPRendererException e) {
			e.printStackTrace();
		}
		parent.layout();

	}

	private void createSliderControl(Composite parent) {
		refreshDatesList();

		int size = dates.size();

		buttonGroup = new Composite(parent, SWT.NONE);
		RowLayout rowLayout = new RowLayout(SWT.HORIZONTAL);
		rowLayout.justify = true;
		rowLayout.pack = true;
		buttonGroup.setLayout(rowLayout);

		currentDateButton = new Button(buttonGroup, SWT.PUSH);

		scale = new Scale(buttonGroup, SWT.FILL);
		scale.setMinimum(0);
		scale.setMaximum(size - 1);
		scale.setLayoutData(new RowData(300, SWT.DEFAULT));
		scale.setEnabled(size > 1);
		scale.setSelection(dates.indexOf(currentSelectedDate));

		setCurrentSelectedDate(currentSelectedDate);
		buttonGroup.pack();

		/**
		 * register control listener for visualization bug if a side editor was added
		 */
		parent.addControlListener(new ControlListener() {

			@Override
			public void controlMoved(ControlEvent e) {
			}

			@Override
			public void controlResized(ControlEvent e) {
				parent.update();
			}

		});

	}

	private void setCurrentSelectedDate(Date date) {
		// is the date in the list?
		if (dates.contains(date)) {
			this.currentSelectedDate = date;

			// is it since forever?
			if (currentSelectedDate.getTime() == Long.MIN_VALUE) {
				if (dates.size() > 1)
					currentDateButton.setText("before " + dates.get(1).toString());
				// is it until forever?
			} else if (currentSelectedDate.getTime() == Long.MAX_VALUE) {
				currentDateButton.setText("after " + dates.get(dates.size() - 2).toString());
			} else {
				currentDateButton.setText(currentSelectedDate.toString());
			}
			scale.setSelection(dates.indexOf(currentSelectedDate));
		}
	}

	protected void loadContent(IFile file) throws IOException {
		// initiate editing domain with new command stack
		editingDomain = new AdapterFactoryEditingDomain(new HyContextInformationAdapterFactory(),
				new BasicCommandStack());
		// load the file into the resource
		contextResource = editingDomain.createResource(file.getFullPath().toString());
		contextResource.load(null);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	public IActionBars getActionBars() {
		return getActionBarContributor().getActionBars();
	}

	public EditingDomainActionBarContributor getActionBarContributor() {
		return (EditingDomainActionBarContributor) getEditorSite().getActionBarContributor();
	}

	public void registerControlListeners() {
		// Left button to select an individual date
		currentDateButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				Object[] datePick = dates.toArray();
				Object value = JOptionPane.showInputDialog(null, "Choose a date", "Date", JOptionPane.QUESTION_MESSAGE,
						null, datePick, datePick[0]);
				int index = dates.indexOf(value);
				setCurrentSelectedDate(dates.get(index));

				int size = dates.size();
				scale.setMaximum(size - 1);
				scale.setEnabled(size > 1);
			}
		});

		// Slider to select a given date
		scale.addListener(SWT.Selection, this);
	}

	@Override
	public void handleEvent(Event event) {
		if (event.widget.equals(scale)) {
			int index = scale.getSelection();
			currentSelectedDate = dates.get(scale.getSelection());
			setCurrentSelectedDate(currentSelectedDate);

			if (index == dates.size() - 1)
				lastDateSelected = true;
		}
	}

	private void refreshDatesList() {
		EList<EObject> contents = contextResource.getContents();
		dates = HyEvolutionUtil.collectDates(contents.get(0));

		if (dates.isEmpty()) {
			dates.add(new Date(0));
			dates.add(new Date());
			dates.add(new Date(Long.MAX_VALUE));
		} else if (dates.get(0).getTime() != Long.MIN_VALUE) {
			dates.add(0, new Date(0));
		} else if (dates.get(dates.size() - 1).getTime() != Long.MAX_VALUE) {
			dates.add(new Date(Long.MAX_VALUE));
		}

		if (scale != null) {
			int size = dates.size();
			scale.setMaximum(size - 1);
			scale.setEnabled(size > 1);
			scale.getParent().pack();
		}
	}

}
