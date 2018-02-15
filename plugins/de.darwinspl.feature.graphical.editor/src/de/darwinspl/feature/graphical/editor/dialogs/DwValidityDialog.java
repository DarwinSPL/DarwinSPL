package de.darwinspl.feature.graphical.editor.dialogs;

import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.darwinspl.common.eclipse.ui.dialogs.DwDateDialog;
import eu.hyvar.evolution.HyName;
import eu.hyvar.evolution.HyNamedElement;
import eu.hyvar.evolution.HyTemporalElement;

public class DwValidityDialog extends DwSelectionDialog {
	Text validSince;
	Text validUntil;

	public DwValidityDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected void createWidgets(Composite parent) {
		Composite buttonContainer = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		buttonContainer.setLayout(layout);

		validSince = new Text(buttonContainer, SWT.READ_ONLY);
		validSince.setText("Read Only");

		Button buttonSince = new Button(buttonContainer, SWT.PUSH);
		buttonSince.setText("Change Since");

		// buttonSince.setLayoutData(new RowData(100, 35));
		buttonSince.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (element instanceof HyTemporalElement) {
					DwDateDialog dialog = new DwDateDialog(getShell(), convertStringToDate(validSince.getText()));
					dialog.open();
					if (dialog.getReturnCode() == OK) {
						Date value = dialog.getValue();
						validSince.setText(getDateFormatted(value, DATE_FORMATTING));
						((HyTemporalElement) element).setValidSince(value);
						checkValidityPropagation(getParentShell());
					}
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}

		});

		validUntil = new Text(buttonContainer, SWT.READ_ONLY);
		validUntil.setText("Read Only");

		Button buttonUntil = new Button(buttonContainer, SWT.PUSH);
		buttonUntil.setText("Change Until");
		// buttonUntil.setLayoutData(new RowData(100, 35));
		buttonUntil.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (element instanceof HyTemporalElement) {
					DwDateDialog dialog = new DwDateDialog(getShell(), convertStringToDate(validUntil.getText()));
					dialog.open();
					if (dialog.getReturnCode() == OK) {
						Date value = dialog.getValue();
						validUntil.setText(getDateFormatted(value, DATE_FORMATTING));
					}
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}

		});

		HyTemporalElement temporalElement = (HyTemporalElement) element;
		validSince.setText(getDateFormatted(temporalElement.getValidSince(), DATE_FORMATTING));
		validUntil.setText(getDateFormatted(temporalElement.getValidUntil(), DATE_FORMATTING));
	}

	@Override
	protected void okPressed() {
		if (checkValidityPropagation(getParentShell())) {
			HyTemporalElement temporalElement = (HyTemporalElement) element;
			temporalElement.setValidSince(convertStringToDate(validSince.getText()));
			temporalElement.setValidUntil(convertStringToDate(validUntil.getText()));
			
			super.okPressed();
		}
	}

	/**
	 * check all validities of this elements HyNames against the new feature
	 * validity
	 * 
	 * @param value
	 *            the since date to be checked against
	 */
	private boolean checkValidityPropagation(Shell parentShell) {
		Date since = convertStringToDate(validSince.getText());
		// Date until = convertStringToDate(validUntil.getText());
		// TODO check for ending validity.
		Boolean checkBool = true;
		EList<HyName> namedElements = ((HyNamedElement) element).getNames();
		for (HyName hyName : namedElements) {
			if (hyName.getValidUntil() != null && since.compareTo(hyName.getValidUntil()) >= 0) {
				DwObsoleteTimeframeDialog dialog = new DwObsoleteTimeframeDialog(parentShell, hyName.getName());
				dialog.open();

				if (dialog.getReturnCode() == OK) {
					namedElements.remove(hyName);
					continue;

				} else {
					checkBool = false;
					break;
				}

			} else if (hyName.getValidSince() == null || since.compareTo(hyName.getValidSince()) > 0) {
				hyName.setValidSince(since);
			}
		}
		return checkBool;
	}

	@Override
	protected void cancelPressed() {

		super.cancelPressed();
	}
}
