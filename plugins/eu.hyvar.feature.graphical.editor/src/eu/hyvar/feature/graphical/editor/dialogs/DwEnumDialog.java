package eu.hyvar.feature.graphical.editor.dialogs;

import java.util.Date;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeatureModel;

/**
 * Shows a dialog that contains all valid enumerations and corresponding literals at a given date.
 * 
 * @author Gil Engel
 *
 */
public class DwEnumDialog extends Dialog implements Listener{

	private HyFeatureModel featureModel;
	private HyEnum enumeration;
	private HyEnumLiteral literal;
	private Date date;

	private HyEnumLiteral value;
	
	public DwEnumDialog(Shell parentShell, Date date, HyFeatureModel featureModel, HyEnum enumeration, HyEnumLiteral literal) {
		super(parentShell);
		
		this.featureModel = featureModel;
		this.enumeration = enumeration;
		this.literal = literal;
		this.date = date;
	}

	
	/**
	 * Returns the selected value as HyEnumLiteral in case the user canceled the operation the function will
	 * return null.
	 * @return
	 */
	public HyEnumLiteral getValue(){
		return value;
	}
	

	/**
	 * Creates the necessary widgets for the dialog and handles user input
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
	    container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    GridLayout layout = new GridLayout(1, false);
	    container.setLayout(layout);
	    
	    
	    GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
	    final Combo enumDropdown = new Combo(container, SWT.DROP_DOWN | SWT.BORDER | SWT.READ_ONLY);
	    enumDropdown.setLayoutData(gridData);
	    for(HyEnum enumeration : HyEvolutionUtil.getValidTemporalElements(featureModel.getEnums(), date)){
	    	enumDropdown.add(enumeration.getName());
	    }
	    
	    if(enumeration != null){
	    	enumDropdown.select(HyEvolutionUtil.getValidTemporalElements(featureModel.getEnums(), date).indexOf(enumeration));
	    }
	    
	    gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
	    final List literalsList = new List(container, SWT.BORDER | SWT.V_SCROLL);
	    literalsList.setLayoutData(gridData);
	    enumDropdown.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetSelected(SelectionEvent e) {
				int index = enumDropdown.getSelectionIndex();
				
				enumeration = HyEvolutionUtil.getValidTemporalElements(featureModel.getEnums(), date).get(index);
				
				literalsList.removeAll();
				for(HyEnumLiteral literal : HyEvolutionUtil.getValidTemporalElements(featureModel.getEnums().get(index).getLiterals(), date)){
					
					literalsList.add(literal.getName());
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
	    	
	    });
	    
	    literalsList.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetSelected(SelectionEvent e) {
				int index = literalsList.getSelectionIndex();
				
				if(index != -1)
					value = HyEvolutionUtil.getValidTemporalElements(enumeration.getLiterals(), date).get(index);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {				
			}
	    	
	    });
	    
	    if(literal != null){
	    	literalsList.select(HyEvolutionUtil.getValidTemporalElements(literal.getEnum().getLiterals(), date).indexOf(literal));
	    }

	    
	    container.pack();
		return container;
	}

	/**
	 * Creates two buttons one labeled with "Change" the other with "Cancel". The "Change" button has the
	 * same behaviour and return type as a normal "OK" button only the label is different.
	 */
	  @Override
	  protected void createButtonsForButtonBar(Composite parent) {
	    createButton(parent, IDialogConstants.OK_ID, "Change", true);
	    createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	  }	
	
	/**
	 * Defines the title of the dialog
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Select Enum");
	}

	/**
	 * Defines the size of the dialog
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(220, 300);
	}
	
	@Override
	public void handleEvent(Event event) {
		//dateChanged();
	}	
}
