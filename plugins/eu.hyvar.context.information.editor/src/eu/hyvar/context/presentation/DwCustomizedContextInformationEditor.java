package eu.hyvar.context.presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.EventObject;
import java.util.List;

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

import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.context.util.HyContextInformationAdapterFactory;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecp.ui.view.ECPRendererException;
import org.eclipse.emf.ecp.ui.view.swt.ECPSWTViewRenderer;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;

public class DwCustomizedContextInformationEditor extends EditorPart {

	protected AdapterFactoryEditingDomain editingDomain;
	protected ComposedAdapterFactory adapterFactory;
	private Resource contextResource;

	List<Date> dates;
	Date currentSelectedDate;

	// UI Elements
	Composite buttonGroup;
	Button currentDate;
	Button addDate;
	Scale scale;

	public DwCustomizedContextInformationEditor() {
		super();
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		try {
			contextResource.save(null);
			((BasicCommandStack) editingDomain.getCommandStack()).saveIsDone();
			firePropertyChange(IEditorPart.PROP_DIRTY);
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
			ECPSWTViewRenderer.INSTANCE.render(content, contextObject);

			createSliderControl(content);

		} catch (ECPRendererException e) {
			e.printStackTrace();
		}
		parent.layout();

	}

	private void createSliderControl(Composite parent) {
		EList<EObject> contents = contextResource.getContents().get(0).eContents();
		dates = new ArrayList<Date>();
		for (EObject obj : contents) {
			if (obj instanceof HyContextualInformation) {
				Date x = ((HyContextualInformation) obj).getValidSince();
				if(!dates.contains(x))
				dates.add(x);
			}
		}

		if (dates.isEmpty())
			dates.add(new Date());
		int size = dates.size();
		if (size == 1 && dates.get(0) == null) {
			dates.clear();
			dates.add(new Date());
		}
		buttonGroup = new Composite(parent, SWT.NONE);
		RowLayout rowLayout = new RowLayout(SWT.HORIZONTAL);
		rowLayout.justify = true;
		buttonGroup.setLayout(rowLayout);

		currentDate = new Button(buttonGroup, SWT.PUSH);

		if (size > 0)
			currentDate.setText(dates.get(0).toString());
		else {
			currentDate.setText((new Date()).toString());
		}

		scale = new Scale(buttonGroup, SWT.FILL);
		scale.setMinimum(0);
		scale.setMaximum(size - 1);
		scale.setLayoutData(new RowData(300, SWT.DEFAULT));
		scale.setEnabled(size > 1);
		scale.setSelection(0);

		addDate = new Button(buttonGroup, SWT.PUSH);
		addDate.setText("Add Date");

		// resetDates = new Button(buttonGroup, SWT.PUSH);
		// resetDates.setText("Reset Dates");

		if (dates.size() > 0)
			setCurrentSelectedDate(currentSelectedDate);
		else {
			Date now = new Date();
			dates.add(now);
			setCurrentSelectedDate(now);
		}

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
		if (dates.contains(date))
			this.currentSelectedDate = date;
	}

	protected void loadContent(IFile file) throws IOException {
		editingDomain = new AdapterFactoryEditingDomain(new HyContextInformationAdapterFactory(),
				new BasicCommandStack());
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

}
