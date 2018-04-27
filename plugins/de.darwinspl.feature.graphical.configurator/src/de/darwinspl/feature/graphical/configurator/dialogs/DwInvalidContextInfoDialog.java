package de.darwinspl.feature.graphical.configurator.dialogs;

import java.util.Date;

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

import de.darwinspl.anomaly.DwVoidFeatureModelAnomaly;
import eu.hyvar.context.information.contextValue.HyContextValue;
import eu.hyvar.context.information.contextValue.HyContextValueModel;
import eu.hyvar.dataValues.HyBooleanValue;
import eu.hyvar.dataValues.HyEnumValue;
import eu.hyvar.dataValues.HyNumberValue;
import eu.hyvar.dataValues.HyValue;

public class DwInvalidContextInfoDialog extends TitleAreaDialog {

	protected HyContextValueModel invalidContextValues;
	protected Date invalidDate;

	protected static final String TITLE_INVALID_CONTEXT = "Invalid Context or Evolution Step Found!";
	protected static final String TITLE_NO_INVALID_CONTEXT = "Model is satisfiable!";

	protected static final String MESSAGE_INVALID_CONTEXT = "HyVarRec found an invalid context or evolution step for which the model is not satisfiable. Below a non-satisfiable example is given.";
	protected static final String MESSAGE_NO_INVALID_CONTEXT = "HyVarRec didn't find any invalid context or evolution step for which the model is not satisfiable.";

	public DwInvalidContextInfoDialog(Shell parentShell, HyContextValueModel invalidContextValues) {
		super(parentShell);

		this.invalidContextValues = invalidContextValues;
	}
	
	
	public DwInvalidContextInfoDialog(Shell parentShell, DwVoidFeatureModelAnomaly voidFeatureModelAnomaly) {
		super(parentShell);

		if(voidFeatureModelAnomaly!=null) {
			this.invalidContextValues = voidFeatureModelAnomaly.getContextValueModel();
			this.invalidDate = voidFeatureModelAnomaly.getValidSince();			
		}
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

		if (invalidContextValues == null && invalidDate == null) {
			title = TITLE_NO_INVALID_CONTEXT;
			message = MESSAGE_NO_INVALID_CONTEXT;
			type = IMessageProvider.INFORMATION;
		} else {
			title = TITLE_INVALID_CONTEXT;
			message = MESSAGE_INVALID_CONTEXT;
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
}