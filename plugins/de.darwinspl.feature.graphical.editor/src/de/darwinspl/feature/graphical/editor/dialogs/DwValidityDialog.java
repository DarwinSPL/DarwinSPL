package de.darwinspl.feature.graphical.editor.dialogs;

import java.util.ArrayList;
import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.darwinspl.common.eclipse.ui.dialogs.DwDateDialog;
import de.darwinspl.feature.graphical.editor.commands.DwLinearTemporalElementCommand;
import eu.hyvar.evolution.HyLinearTemporalElement;
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
		if (doCheckValidityPropagation(getParentShell())) {
			HyTemporalElement temporalElement = (HyTemporalElement) element;
			temporalElement.setValidSince(convertStringToDate(validSince.getText()));
			temporalElement.setValidUntil(convertStringToDate(validUntil.getText()));
		} else {
			super.cancelPressed();
		}
		super.okPressed();
	}

	/**
	 * check all validities of this elements HyNames against the new feature
	 * validity. This will open a dialog, if a name validity does not overlap with
	 * the new feature validity.
	 */
	private boolean doCheckValidityPropagation(Shell parentShell) {

		// TODO bug: when a name validity is stretched to fit a new (longer) feature
		// validity, the editor does not create the necessary connections to parent
		// feature.
		Date newSince = convertStringToDate(validSince.getText());
		Date newUntil = convertStringToDate(validUntil.getText());
		EList<EObject> elementList = ((HyTemporalElement) element).eContents();
		
		for (EObject e : elementList) {
			if (e instanceof HyLinearTemporalElement) {
				HyLinearTemporalElement el = (HyLinearTemporalElement) e;
				Date eSince = el.getValidSince(), eUntil = el.getValidUntil();
				// check whether the feature starts later/earlier than this element ends/starts
				// (obsolete) and delete after user approval, if that is the case.

//				System.out.println("newSince: " + newSince);
//				System.out.println("newUntil: " + newUntil);
//				System.out.println("eSince: " + eSince);
//				System.out.println("eUntil: " + eUntil);
//				System.out.println("preceding?: " + (el.getSupersededElement() == null ? "false" : "true"));
//				System.out.println("superceding?: " + (el.getSupersedingElement() == null ? "false" : "true"));

				if ((newSince != null && eUntil != null && eUntil.compareTo(newSince) <= 0)
						|| (newUntil != null && eSince != null && eSince.compareTo(newUntil) >= 0)) {

					DwObsoleteTimeframeDialog dialog = new DwObsoleteTimeframeDialog(parentShell, el);
					dialog.open();
					if (dialog.getReturnCode() == OK) {
						EcoreUtil.delete(e);
						continue;
					} else {
						return false;
					}
				}

				if (newSince != null) {
					if (eSince == null || eSince.compareTo(newSince) <= 0 || (el.getSupersededElement() == null)) {
						el.setValidSince(newSince);
					}
				} else if (newSince == null && el.getSupersededElement() == null) {
					el.setValidSince(null);
				}

				if (newUntil != null) {
					if (eUntil == null || eUntil.compareTo(newUntil) >= 0 || (el.getSupersedingElement() == null)) {
						el.setValidUntil(newUntil);
					}
				} else if (newUntil == null && el.getSupersedingElement() == null) {
					el.setValidUntil(null);
				}
			}

		}
		return true;
	}

	@Override
	protected void cancelPressed() {

		super.cancelPressed();
	}
}
