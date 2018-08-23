package de.darwinspl.temporalconstraints.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.part.ViewPart;

import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;

public class DwInconsistencyView extends ViewPart {

	private Composite parentComposite = null;
	private IEditorPart currentEditor;
	DwFeatureModelWrapped modelWrapped = null;

	// InconsistenciesWrapped inconsistencies = null;

	private Label statusLabel;

	public static final String MESSAGE_NO_INCONSISTENCIES = "The analysis found no inconsistencies in the model.",
			MESSAGE_INIT_ANALYSIS = "Nothing to see here yet. To show inconsistencies, please perform an analysis.",
			MESSAGE_ERROR_ANALYSIS = "An error has occured while performing your request. Are model and constraints defined correctly?";

	public static final String[] titles = { " ", "Inconsistency type", "Violated Constraint", "Affected Model Element",
			"Date of Occurrence" };

	@Override
	public void createPartControl(Composite parent) {

		this.parentComposite = parent;
		getSite().getPage().addPartListener(editorListener);
		RowLayout rowLayout = new RowLayout();
		rowLayout.type = SWT.VERTICAL;
		parentComposite.setLayout(rowLayout);

		// getSite().getPage().addPartListener(editorListener);
		// setEditor(getSite().getPage().getActiveEditor());

		statusLabel = new Label(parentComposite, SWT.BOLD);
		statusLabel.setText(MESSAGE_INIT_ANALYSIS);
		statusLabel.setVisible(false);
		createTable(parentComposite);

	}

	private void setEditor(IEditorPart activeEditor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	};

	private void createTable(Composite parent) {
		Table table = new Table(parentComposite, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		for (int i = 0; i < titles.length; i++) {
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setText(titles[i]);
		}

		int count = 32;
		for (int i = 0; i < count; i++) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(0, "x");
			item.setText(1, "y");
			item.setText(2, "!");
			item.setText(3, "this stuff behaves the way I expect");
			item.setText(4, "almost everywhere");
			item.setText(5, "some.folder");
			item.setText(6, "line " + i + " in nowhere");
		}
		
		for (int i = 0; i < titles.length; i++) {
			table.getColumn(i).pack();
		}
		table.setSize(table.computeSize(SWT.DEFAULT, 200));
	}

	private final IPartListener editorListener = new IPartListener() {

		@Override
		public void partOpened(IWorkbenchPart part) {

		}

		@Override
		public void partDeactivated(IWorkbenchPart part) {

		}

		@Override
		public void partClosed(IWorkbenchPart part) {
			if (part == currentEditor)
				currentEditor = null;
		}

		@Override
		public void partBroughtToTop(IWorkbenchPart part) {

		}

		@Override
		public void partActivated(IWorkbenchPart part) {
			if (part instanceof IEditorPart) {
				ResourceUtil.getResource(((IEditorPart) part).getEditorInput());
				setEditor((IEditorPart) part);
			}
		}
	};
}
