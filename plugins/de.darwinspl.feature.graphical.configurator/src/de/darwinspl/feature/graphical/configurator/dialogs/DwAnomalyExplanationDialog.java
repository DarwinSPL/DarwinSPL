package de.darwinspl.feature.graphical.configurator.dialogs;

import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class DwAnomalyExplanationDialog extends TitleAreaDialog {

	private List<String> anomalyCausingConstraints;
	private static final String TITLE_NO_ANOMALY = "No anomaly detected. Model is valid.";
	private String TITLE_ANOMALY_EXPLANATION = "Explanation for anomaly";
	
	private static final String MESSAGE_NO_ANOMALY = "HyVarRec could not find any anomaly. Thus, there is no explanation.";
	private static final String MESSAGE_ANOMALY_EXPLANATION = "HyVarRec found an anomaly. The explanation is given as the list of anomaly causing constraints below.";
	
	public DwAnomalyExplanationDialog(Shell parentShell, List<String> anomalyCausingConstraints) {
		super(parentShell);
		
		this.anomalyCausingConstraints = anomalyCausingConstraints;
	}
	
	
	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	public void create() {
		super.create();

		String title;
		String message;
		int type;

		if (anomalyCausingConstraints == null) {
			title = getTitleNoAnomaly();
			message = getMessageNoAnomaly();
			type = IMessageProvider.INFORMATION;
		} else {
			title = getTitleAnomalyExplanation();
			message = getMessageAnomalyExplanation();
			type = IMessageProvider.ERROR;
		}

		setTitle(title);

		setMessage(message, type);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
//		GridLayout layout = new GridLayout(1, false);
		Layout layout = new FillLayout();
		container.setLayout(layout);


		if (anomalyCausingConstraints == null) {
			return container;
		}
		
		Label whitespaceLabel = new Label(parent, SWT.VERTICAL);
		whitespaceLabel.setText("Anomaly Causing Constraints:");
		
//		TableViewer viewer = new TableViewer(parent, SWT.H_SCROLL
//	            | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
//		
//		TableViewerColumn colConstraint = new TableViewerColumn(viewer, SWT.NONE);
//		colConstraint.getColumn().setWidth(360);
//		colConstraint.getColumn().setText("Constraint");
//		colConstraint.setLabelProvider(new ColumnLabelProvider() {
//		    @Override
//		    public String getText(Object element) {
//		        return (String) element;
//		    }
//		});
//		
//		colConstraint.getColumn().setResizable(true);
		
		Table table = new Table(parent, SWT.SINGLE | SWT.FULL_SELECTION | SWT.BORDER);
		table.setLayoutData(GridDataFactory.swtDefaults().hint(360, 100).create());

		
		TableColumn tc1 = new TableColumn(table, SWT.LEFT);
		tc1.setText("Constraint");
		tc1.setWidth(360);
		table.setHeaderVisible(true);

		for (String constraintString : anomalyCausingConstraints) {
			TableItem tableItem = new TableItem(table, SWT.NONE);			
		    tableItem.setText(new String[] { constraintString});
//			viewer.add(constraintString);
		}

		tc1.pack();
		
		
		return container;
	}
	

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, "Ok", true);
	}

	@Override
	protected Point getInitialSize() {
		return new Point(480, 340);
	}
	
	public List<String> getAnomalyCausingConstraints() {
		return anomalyCausingConstraints;
	}


	public String getTitleNoAnomaly() {
		return TITLE_NO_ANOMALY;
	}


	public String getTitleAnomalyExplanation() {
		return TITLE_ANOMALY_EXPLANATION;
	}


	public String getTITLE_ANOMALY_EXPLANATION() {
		return TITLE_ANOMALY_EXPLANATION;
	}


	public static String getMessageNoAnomaly() {
		return MESSAGE_NO_ANOMALY;
	}


	public static String getMessageAnomalyExplanation() {
		return MESSAGE_ANOMALY_EXPLANATION;
	}

	

	
	
}
