package de.darwinspl.feature.graphical.base;

import de.darwinspl.common.eclipse.ui.dialogs.DwDateDialog;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import eu.hyvar.evolution.util.HyEvolutionUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Scale;

/**
 * This is a custom {@link Composite} to display a Slider Control for multiple
 * model editors. It will fetch the supplied model's contained dates and show
 * them on a dynamic {@link Scale}. It also implements functionality to add user
 * picked dates to a model (if applicable). Use the supplied getters to access
 * the current selected Date for editor display purposes.
 * 
 * @author Daniel Roehrs
 *
 */
public class DwGraphicalModelDateScale extends Composite {

	private Button currentDateButton;
	private Button addDate;
	// private Button resetDates;
	private Scale scale;
	private List<Date> dates;

	private EObject model;
	private Date currentSelectedDate;

	@Deprecated
	public DwGraphicalModelDateScale(Composite parent, int style) {
		super(parent, style);
		// TODO Auto-generated constructor stub
	}

	public DwGraphicalModelDateScale(Composite parent, int style, EObject model) {
		super(parent, style);

		this.model = model;
		this.dates = new ArrayList<Date>();

		// initializes the date list content.
		refreshDatesList(model);

		// the layout for this composite
		RowLayout rowLayout = new RowLayout(SWT.HORIZONTAL);
		rowLayout.pack = true;
		this.setLayout(rowLayout);

		// the Button displaying the current scale Date selection.
		currentDateButton = new Button(this, SWT.PUSH);

		// the scale
		scale = new Scale(this, SWT.FILL);
		scale.setLayoutData(new RowData(300, SWT.DEFAULT));

		setCurrentSelectedDateToClosestActualDate(new Date());

		// the add date Button
		if (model instanceof DwFeatureModelWrapped) {
			addDate = new Button(this, SWT.PUSH);
		}

		registerControlListeners();
		updateScale();

	}

	/**
	 * Sets the current scale Date to this Date. Updates the button texts and scale, if possible.
	 * 
	 * @param date
	 */
	private void setCurrentSelectedDate(Date date) {
		checkWidget();
		this.currentSelectedDate = date;

		if (currentSelectedDate.getTime() == Long.MIN_VALUE) {
			if (dates.size() > 1)
				currentDateButton.setText("before " + dates.get(1).toString());

		} else if (currentSelectedDate.getTime() == Long.MAX_VALUE) {
			currentDateButton.setText("after " + dates.get(dates.size() - 2).toString());
		} else {
			currentDateButton.setText(currentSelectedDate.toString());
		}
		if (scale != null)
			scale.setSelection(dates.indexOf(currentSelectedDate));
	}

	/**
	 * Takes the model as parameter and extracts all Date Objects into this
	 * Composites Date list.
	 * 
	 * @param model
	 */
	private void refreshDatesList(EObject model) {
		checkWidget();
		this.dates = HyEvolutionUtil.collectDates(model);
	}

	/**
	 * Updates the scale bounds.
	 */
	private void updateScale() {

		if (scale != null) {
			int size = dates.size();
			scale.setMaximum(size - 1);
			scale.setEnabled(size > 1);
			scale.getParent().pack();
		}
	}

	/**
	 * registers listeners for the scale and the buttons
	 */
	private void registerControlListeners() {
		checkWidget();
		// Left button to select an individual date
		currentDateButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {

				// date picker option:
				// Object[] datePick = dates.toArray();
				// Object value = JOptionPane.showInputDialog(null, "Choose a date", "Date",
				// JOptionPane.QUESTION_MESSAGE,
				// null, datePick, datePick[0]);
				// int index = dates.indexOf(value);
				// setCurrentSelectedDateToClosestActualDate(dates.get(index));

				DwDateDialog dialog = new DwDateDialog(null, getCurrentSelectedDate());
				dialog.open();
				if (dialog.getReturnCode() == 0) {
					Date newDate = dialog.getValue();
					setCurrentSelectedDateToClosestActualDate(newDate);
				}

				int size = dates.size();
				scale.setMaximum(size - 1);
				scale.setEnabled(size > 1);

				if (dates.size() > 0)
					currentDateButton.setText(dates.get(0).toString());
				else {
					currentDateButton.setText((new Date()).toString());
				}
			}
		});

		// Slider to select a given date
		scale.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				currentSelectedDate = dates.get(scale.getSelection());
				setCurrentSelectedDate(currentSelectedDate);

			}
		});

		if (model instanceof DwFeatureModelWrapped) {
			// Button that adds a new date to the model
			addDate.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					Date date = new Date();
					Calendar cal = new GregorianCalendar();
					cal.setTime(date);
					cal.set(Calendar.HOUR_OF_DAY, 0);
					cal.set(Calendar.MINUTE, 0);
					cal.set(Calendar.SECOND, 0);
					cal.set(Calendar.MILLISECOND, 0);
					date = cal.getTime();
					DwDateDialog dialog = new DwDateDialog(null, date);
					dialog.open();
					Date value = dialog.getValue();

					if (value != null) {
						((DwFeatureModelWrapped) model).addDate(value);

						int size = ((DwFeatureModelWrapped) model).getDates().size();
						scale.setMaximum(size - 1);
						scale.setEnabled(size > 1);
					}
				}
			});

			// TODO: What does reset dates even do???

			// resetDates.addListener(SWT.Selection, new Listener() {
			//
			// @Override
			// public void handleEvent(Event event) {
			// List<Date> dates =
			// DwFeatureModelLayoutFileUtil.loadDatesFromLayoutFile(modelWrapped);
			// dates.add(0, new Date(Long.MIN_VALUE));
			//
			// ((DwFeatureModelWrapped) model).setDates(dates);
			//
			// int size = ((DwFeatureModelWrapped) model).getDates().size();
			// scale.setMaximum(size - 1);
			// scale.setEnabled(size > 1);
			//
			// // scale.update();
			//
			// setCurrentSelectedDateToMostActualDate();
			// setCurrentSelectedDate(currentSelectedDate);
			// }
			//
			// });
		}
	}

	/**
	 * Changes the date to the most actual existing date from the selected date.
	 * Does not cause a rerendering of the model.
	 */
	private void setCurrentSelectedDateToClosestActualDate(Date currentSelectedDate) {
		checkWidget();
		Date closestDate = new Date(Long.MIN_VALUE);
		for (Date date : dates) {
			if (date.before(currentSelectedDate)) {
				closestDate = date;
			} else {
				break;
			}
		}
		setCurrentSelectedDate(closestDate);
	}

	/**
	 * Returns the underlying model EObject.
	 * 
	 * @return EObject
	 */
	public EObject getModel() {
		return this.model;
	}

	/**
	 * Returns the date this scale is currently set to.
	 * @return Date
	 */
	public Date getCurrentSelectedDate() {
		return this.currentSelectedDate;
	}

}
