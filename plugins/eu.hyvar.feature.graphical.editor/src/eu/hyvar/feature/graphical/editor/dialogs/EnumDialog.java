package eu.hyvar.feature.graphical.editor.dialogs;

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
import eu.hyvar.feature.HyFeatureModel;

public class EnumDialog extends Dialog implements Listener{

	private HyFeatureModel featureModel;
	private HyEnum enumeration;
	private HyEnumLiteral literal;

	public EnumDialog(Shell parentShell, HyFeatureModel featureModel, HyEnum enumeration, HyEnumLiteral literal) {
		super(parentShell);
		
		this.featureModel = featureModel;
		this.enumeration = enumeration;
		this.literal = literal;
	}

	private HyEnumLiteral value;

	public HyEnumLiteral getValue(){
		return value;
	}
	


	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
	    container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    GridLayout layout = new GridLayout(1, false);
	    container.setLayout(layout);
	    
	    
	    GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
	    Combo enumDropdown = new Combo(container, SWT.DROP_DOWN | SWT.BORDER | SWT.READ_ONLY);
	    enumDropdown.setLayoutData(gridData);
	    for(HyEnum enumeration : featureModel.getEnums()){
	    	enumDropdown.add(enumeration.getName());
	    }
	    
	    if(enumeration != null){
	    	enumDropdown.select(featureModel.getEnums().indexOf(enumeration));
	    }
	    
	    gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
	    List literalsList = new List(container, SWT.BORDER | SWT.V_SCROLL);
	    literalsList.setLayoutData(gridData);
	    enumDropdown.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetSelected(SelectionEvent e) {
				int index = enumDropdown.getSelectionIndex();
				
				enumeration = featureModel.getEnums().get(index);
				
				for(HyEnumLiteral literal : featureModel.getEnums().get(index).getLiterals()){
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
				
				value = enumeration.getLiterals().get(index);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {				
			}
	    	
	    });
	    
	    if(literal != null){
	    	literalsList.select(literal.getEnum().getLiterals().indexOf(literal));
	    }

	    
	    container.pack();
		return container;
	}

	  @Override
	  protected void createButtonsForButtonBar(Composite parent) {
	    createButton(parent, IDialogConstants.OK_ID, "Change", true);
	    createButton(parent, IDialogConstants.CANCEL_ID,
	        IDialogConstants.CANCEL_LABEL, false);
	  }	
	
	// overriding this methods allows you to set the
	// title of the custom dialog
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Select Date");
	}

	@Override
	protected Point getInitialSize() {
		return new Point(220, 300);
	}
	
	@Override
	public void handleEvent(Event event) {
		//dateChanged();
	}	
}
