package de.darwinspl.feature.graphical.configurator.dialogs;

import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import eu.hyvar.context.information.contextValue.HyContextValue;
import eu.hyvar.dataValues.HyBooleanValue;
import eu.hyvar.dataValues.HyEnumValue;
import eu.hyvar.dataValues.HyNumberValue;
import eu.hyvar.dataValues.HyValue;

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
		container.setLayoutData(new GridData(SWT.CENTER, SWT.BEGINNING, true, true));
		
		GridLayout layout = new GridLayout(1, false);
		container.setLayout(layout);


		if (invalidContextValues == null) {
			return container;
		}
		
		Label whitespaceLabel = new Label(parent, SWT.VERTICAL);
		whitespaceLabel.setText("Context values:");

		Table table = new Table(parent, SWT.SINGLE | SWT.FULL_SELECTION | SWT.BORDER);
		table.setLayoutData(GridDataFactory.swtDefaults().hint(360, 100).create());

		TableColumn tc1 = new TableColumn(table, SWT.LEFT);
		TableColumn tc2 = new TableColumn(table, SWT.LEFT);
		tc1.setText("Contextual Information");
		tc2.setText("Value");
		tc1.setWidth(150);
		tc2.setWidth(200);
		table.setHeaderVisible(true);

		for (HyContextValue contextValue : invalidContextValues.getValues()) {
			TableItem tableItem = new TableItem(table, SWT.NONE);
			String valueString = "";
			
			HyValue value = contextValue.getValue();
			
			if(value instanceof HyNumberValue) {
				valueString = ""+((HyNumberValue) value).getValue();
			}
			else if(value instanceof HyBooleanValue) {
				if(((HyBooleanValue)value).isValue()) {
					valueString = "true";
				}
				else {
					valueString = "false";
				}
			}
			else if(value instanceof HyEnumValue) {
				HyEnumValue enumValue = (HyEnumValue) value;
				valueString = enumValue.getEnum().getName();
				valueString = valueString + ".";
				valueString = valueString + enumValue.getEnumLiteral().getName();
			}
			
		    tableItem.setText(new String[] { contextValue.getContext().getName(), valueString});
		}

		
		if(invalidDate != null) {
			new Label(parent, SWT.VERTICAL);
			
			Label whitespaceLabel2 = new Label(parent, SWT.VERTICAL);
			whitespaceLabel2.setText("At date:");
			
			Text dateText = new Text(parent, SWT.CENTER);
			dateText.setText(invalidDate.toString());
		}

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
