package de.darwinspl.feature.graphical.configurator.editor.anomaly.views;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.darwinspl.common.eclipse.ui.dialogs.DwDateDialog;
import de.darwinspl.feature.graphical.configurator.dialogs.DwRESTServerSelectDialog;
import de.darwinspl.feature.graphical.configurator.editor.anomaly.views.DwAnomalyView.TypeOfEvolutionAwareAnalysis;

public class DwRESTServerSelectExtendedDialog extends DwRESTServerSelectDialog{
	
	public boolean isEvolutionAwareAnalysis() {
		return isEvolutionAwareAnalysis;
	}


	public Date getStartDate() {
		return startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public TypeOfEvolutionAwareAnalysis getEvolutionAwareAnalysisType() {
		return evolutionAwareAnalysisType;
	}


	private boolean isEvolutionAwareAnalysis = false;
	private Date startDate = null;
	private Date endDate = null;
	private TypeOfEvolutionAwareAnalysis evolutionAwareAnalysisType = TypeOfEvolutionAwareAnalysis.COMPLETE_HISTORY;
	
	public DwRESTServerSelectExtendedDialog(Shell parentShell, String uri, Boolean isHttpAuthEnabled, String username, String password, Boolean isEvolutionAware, Date startDate, Date endDate, TypeOfEvolutionAwareAnalysis evolutionAwareAnalysisType) {
		super(parentShell, uri, isHttpAuthEnabled, username, password);
		
		this.isEvolutionAwareAnalysis = isEvolutionAware;
		this.startDate = startDate;
		this.endDate = endDate;
		this.evolutionAwareAnalysisType = evolutionAwareAnalysisType;
		
	}
	
	@Override
	public void create() {
		super.create();
		setTitle("Anomaly Analysis Settings");
		setMessage("Change the address of the rest server for reconfiguration the selected feature model. And adjust options concerning evolution.", IMessageProvider.INFORMATION);
	}


	@Override
	protected boolean isResizable() {
		return true;
	}


	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		
		GridData horizontalFillGridData = new GridData(SWT.FILL, SWT.TOP, true, false, 2, 1);
		
		// create new layout data to span the w
        GridData seperatorGridData = new GridData(SWT.FILL, SWT.TOP, true, false);
        seperatorGridData.horizontalSpan = 2;
        
        Label seperatorTypeOfAnomaly = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
        seperatorTypeOfAnomaly.setLayoutData(seperatorGridData);
        
        Button evolutionAwareCheckBox = new Button(container, SWT.CHECK);
		evolutionAwareCheckBox.setText("Evolution-aware Analysis");
		evolutionAwareCheckBox.setTextDirection(SWT.LEFT);
		evolutionAwareCheckBox.setLayoutData(horizontalFillGridData);
		evolutionAwareCheckBox.setSelection(isEvolutionAwareAnalysis);
		

		
		Button b1 = new Button(container, SWT.RADIO);
		b1.setText("Complete Evolution History");
		b1.setEnabled(isEvolutionAwareAnalysis);
	

		
		Button b2 = new Button(container, SWT.RADIO);
		b2.setText("Partial Time-Span");
		b2.setEnabled(isEvolutionAwareAnalysis);
	
		
	   
	    
	    
		
		
		
		Composite buttonContainer = new Composite(container, SWT.NONE);
		
		buttonContainer.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 2, 1));
		GridLayout layout = new GridLayout(4, false);
		buttonContainer.setLayout(layout);

	    
	    
	    Button buttonSince = new Button(buttonContainer, SWT.PUSH);
	    buttonSince.setText("From: ");
	    buttonSince.setEnabled(b2.getSelection());
	    
	    Text validSince = new Text(buttonContainer, SWT.READ_ONLY);
		if(startDate!= null){
			
			validSince.setText(getDateFormatted(startDate, "yyy-MM-dd"));
		}else{
		validSince.setText("Select Date");
		}
	    
	    //buttonSince.setLayoutData(new RowData(100, 35));
	    buttonSince.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetSelected(SelectionEvent e) {
					DwDateDialog dialog = new DwDateDialog(getShell(), convertStringToDate(validSince.getText()));
					dialog.open();
					if(dialog.getReturnCode() == OK){
						Date value = dialog.getValue();
						
						validSince.setText(getDateFormatted(value, "yyy-MM-dd"));
						startDate = value;
					}
				
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
	    	
	    });
	
	    
	    
	    Button buttonUntil = new Button(buttonContainer, SWT.PUSH);
	    buttonUntil.setText("To: ");
	    buttonUntil.setEnabled(b2.getSelection());
	    
	    Text validUntil = new Text(buttonContainer, SWT.READ_ONLY);
	    if(endDate!= null){
			validUntil.setText(getDateFormatted(endDate, "yyy-MM-dd"));
		}else{
		validUntil.setText("Select Date");
		}
	    
	    //buttonUntil.setLayoutData(new RowData(100, 35));
	    buttonUntil.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetSelected(SelectionEvent e) {
			
					DwDateDialog dialog = new DwDateDialog(getShell(), convertStringToDate(validUntil.getText()));
					dialog.open();
					if(dialog.getReturnCode() == OK){
						Date value = dialog.getValue();
						
						validUntil.setText(getDateFormatted(value, "yyy-MM-dd"));
						endDate = value;
					}
				}
		

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
	    	
	    });
	    
	    if(evolutionAwareAnalysisType.equals(TypeOfEvolutionAwareAnalysis.COMPLETE_HISTORY)){
			b1.setSelection(true);
			b2.setSelection(false);
	    	
		}else{
			b1.setSelection(false);
			b2.setSelection(true);
			buttonSince.setEnabled(true);
			buttonUntil.setEnabled(true);
			
		}
	    
evolutionAwareCheckBox.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button source = (Button) e.getSource();
				Boolean selection = source.getSelection();
				b1.setEnabled(selection);
				b2.setEnabled(selection);
				
				if(selection){
					buttonSince.setEnabled(b2.getSelection());
					buttonUntil.setEnabled(b2.getSelection());
					
				}else{
					buttonSince.setEnabled(false);
					buttonUntil.setEnabled(false);
				}
				
				
				
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
				
			}
		});
		
	    
b1.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button source = (Button) e.getSource();
				if(source.getSelection()){
					evolutionAwareAnalysisType = TypeOfEvolutionAwareAnalysis.COMPLETE_HISTORY;
				
					buttonSince.setEnabled(false);
					buttonUntil.setEnabled(false);
				}
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	    
         b2.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button source = (Button) e.getSource();
				if(source.getSelection()){
					evolutionAwareAnalysisType = TypeOfEvolutionAwareAnalysis.TIME_SPAN;
				
					buttonSince.setEnabled(true);
					buttonUntil.setEnabled(true);
				
				}
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

     
		return container;
	
	}

protected Date convertStringToDate(String text) {
	if(text == null || text.isEmpty() || text.equals("Read Only")) return null;
	
    DateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd", Locale.ENGLISH);
    try{
    	return dateFormat.parse(text);
    }catch(ParseException ex){
    	ex.printStackTrace();
    }
    
    return null;
}


public static String getDateFormatted(Date date, String formatting){
	if(date == null) return "";
	
	SimpleDateFormat format = new SimpleDateFormat(formatting);
	return format.format(date);
}


	
}
