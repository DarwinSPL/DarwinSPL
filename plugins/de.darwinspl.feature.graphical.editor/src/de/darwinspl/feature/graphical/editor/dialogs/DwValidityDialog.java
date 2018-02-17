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
		}
		super.okPressed();
	}

	/**
	 * check all validities of this elements HyNames against the new feature
	 * validity. This will open a dialog, if a name validity does not overlap with
	 * the new feature validity.
	 */
	private boolean checkValidityPropagation(Shell parentShell) {

		// TODO bug: when a name validity is stretched to fit a new (longer) feature
		// validity, the editor does not create the necessary connections to parent
		// feature.
		Date newSince = convertStringToDate(validSince.getText());
		Date newUntil = convertStringToDate(validUntil.getText());
		EList<HyName> elementList = ((HyNamedElement) element).getNames();

		for (HyName e : elementList) {

			Date eSince = e.getValidSince(), eUntil = e.getValidUntil();

			if ((newSince != null && eUntil.compareTo(newSince) <= 0)
					|| (newSince != null && eSince.compareTo(newUntil) >= 0)) {
				DwObsoleteTimeframeDialog dialog = new DwObsoleteTimeframeDialog(parentShell, e.getName());
				dialog.open();
				if (dialog.getReturnCode() == OK) {
					elementList.remove(e);
					continue;
				} else {
					return false;
				}
			}
			if (eSince == null || eSince.before(newSince)
					|| (e.getSupersededElement() == null && eSince.after(newSince))) {
				e.setValidSince(newSince);
			}
			if (eUntil == null || eUntil.after(newUntil)
					|| (e.getSupersedingElement() == null && eUntil.before(newUntil))) {
				e.setValidUntil(newUntil);
			}
		}
		return true;
	}

	@Override
	protected void cancelPressed() {

		super.cancelPressed();
	}
}
