package de.darwinspl.feature.graphical.editor.dialogs;

import java.util.ArrayList;
import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.internal.Workbench;

import de.darwinspl.common.eclipse.ui.dialogs.DwDateDialog;
import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.base.model.DwParentChildConnection;
import de.darwinspl.feature.graphical.editor.commands.DwLinearTemporalElementCommand;
import eu.hyvar.evolution.HyLinearTemporalElement;
import eu.hyvar.evolution.HyTemporalElement;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureConnection;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.impl.HyFeatureChildImpl;
import eu.hyvar.feature.impl.HyFeatureImpl;
import eu.hyvar.feature.impl.custom.HyFeatureImplCustom;

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

		// TODO anomaly: when a name validity is stretched to fit a new (longer) feature
		// validity, the editor does not create the necessary connections to parent
		// feature.
		// TODO bug: when a feature becomes obsolete in a certain time frame, its
		// children lose their validity. Connections have to be checked and validity
		// change disabled. (Thesis material?)
		Date newSince = convertStringToDate(validSince.getText());
		Date newUntil = convertStringToDate(validUntil.getText());
		EList<EObject> elementList = ((HyTemporalElement) element).eContents();

		return propagate(elementList, newSince, newUntil);
	}

	private boolean propagate(EList<EObject> elementList, Date newSince, Date newUntil) {

		
		for (EObject e : elementList) {
			if (e instanceof HyLinearTemporalElement) {
				HyLinearTemporalElement el = (HyLinearTemporalElement) e;
				Date eSince = el.getValidSince(), eUntil = el.getValidUntil();
				// check whether the feature starts later/earlier than this element ends/starts
				// (obsolete) and delete after user approval, if that is the case.

				if ((newSince != null && eUntil != null && eUntil.compareTo(newSince) <= 0)
						|| (newUntil != null && eSince != null && eSince.compareTo(newUntil) >= 0)) {

					DwObsoleteTimeframeDialog dialog = new DwObsoleteTimeframeDialog(getParentShell(), el);
					dialog.open();
					if (dialog.getReturnCode() == OK) {
						if (((HyFeature) element).getParentOf().isEmpty()) {
							EcoreUtil.delete(e);
							continue;
						} else {
							MessageDialog.openError(getShell(), "Error",
									"The changed feature has children. Deleting this parent would orphan its children.");
							return false;
						}
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

	/**
	 * Handles changes to a given elements temporal validity.
	 * 
	 */
	protected void changeValidities(HyLinearTemporalElement el, Date newSince, Date newUntil) {
		el.setValidSince(newSince);
		el.setValidUntil(newUntil);
		if (!((HyFeature) el).getParentOf().isEmpty()) {
			for (HyLinearTemporalElement child : ((HyFeature) el).getParentOf()) {
				changeValidities(child, newSince, newUntil);
			}
		}
	}

	@Override
	protected void cancelPressed() {

		super.cancelPressed();
	}
}
