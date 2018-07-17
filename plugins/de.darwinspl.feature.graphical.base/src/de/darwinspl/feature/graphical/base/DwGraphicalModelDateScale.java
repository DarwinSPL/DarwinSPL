package de.darwinspl.common.eclipse.ui.elements;

import de.darwinspl.common.eclipse.ui.dialogs.DwDateDialog;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.base.util.DwFeatureModelLayoutFileUtil;
import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureModel;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.emf.common.util.EList;
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
	private Button resetDates;
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

		// the layout for this composite
		RowLayout rowLayout = new RowLayout(SWT.HORIZONTAL);
		rowLayout.justify = true;
		rowLayout.pack = true;
		this.setLayout(rowLayout);
		
		refreshDatesList(model);

		// the Button displaying the current scale Date selection.
		currentDateButton = new Button(this, SWT.PUSH);

		if (model instanceof DwFeatureModelWrapped) {
			// the add date Button
			addDate = new Button(this, SWT.PUSH);
		}
		
		// the scale
		scale = new Scale(this, SWT.FILL);
		scale.setLayoutData(new RowData(300, SWT.DEFAULT));
		int size = dates.size();
		scale.setEnabled(size > 1);
		

	}

	/**
	 * Sets the current scale Date to this Date. Updates the scale texts.
	 * 
	 * @param date
	 */
	private void setCurrentSelectedDate(Date date) {
		checkWidget();
		// is the date in the list?
		if (dates.contains(date)) {
			this.currentSelectedDate = date;

			// is it since forever?
			if (currentSelectedDate.getTime() == Long.MIN_VALUE) {
				if (dates.size() > 1)
					currentDateButton.setText("before " + dates.get(1).toString());
				// is it until forever?
			} else if (currentSelectedDate.getTime() == Long.MAX_VALUE) {
				currentDateButton.setText("after " + dates.get(dates.size() - 2).toString());
			} else {
				currentDateButton.setText(currentSelectedDate.toString());
			}
			scale.setSelection(dates.indexOf(currentSelectedDate));
		}
	}

	/**
	 * Takes the model as parameter and extracts all Date Objects into this
	 * Composites Date list.
	 * 
	 * @param model
	 */
	public void refreshDatesList(EObject model) {
		checkWidget();
		EObject contents = model.eContents().get(0);
		if (model instanceof DwFeatureModelWrapped) {
			dates = ((DwFeatureModelWrapped) model).getDates();

		}
		dates = HyEvolutionUtil.collectDates(contents);

		if (dates.isEmpty()) {
			dates.add(new Date(0));
			dates.add(new Date());
			dates.add(new Date(Long.MAX_VALUE));
		} else if (dates.get(0).getTime() != Long.MIN_VALUE) {
			dates.add(0, new Date(0));
		} else if (dates.get(dates.size() - 1).getTime() != Long.MAX_VALUE) {
			dates.add(new Date(Long.MAX_VALUE));
		}

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
	public void registerControlListeners() {
		checkWidget();
		// Left button to select an individual date
		currentDateButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				Object[] datePick = dates.toArray();
				Object value = JOptionPane.showInputDialog(null, "Choose a date", "Date", JOptionPane.QUESTION_MESSAGE,
						null, datePick, datePick[0]);
				int index = dates.indexOf(value);
				setCurrentSelectedDate(dates.get(index));

				int size = dates.size();
				scale.setMaximum(size - 1);
				scale.setEnabled(size > 1);
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
	 * Changes the date to the most actual date from now. Does not cause a
	 * rerendering of the feature model.
	 */
	protected void setCurrentSelectedDateToMostActualDate() {
		checkWidget();
		List<Date> dates = HyEvolutionUtil.collectDates(((DwFeatureModelWrapped) model).getModel());
		Date currentDate = new Date();
		Date closestDate = new Date(Long.MIN_VALUE);
		for (Date date : dates) {
			if (date.before(currentDate)) {
				if (date.after(closestDate))
					closestDate = date;
			}
		}

		currentSelectedDate = closestDate;
	}
	
	public EObject getModel() {
		return this.model;
	}
	
	public Date getCurrentSelectedDate() {
		return this.currentSelectedDate;
	}

}
