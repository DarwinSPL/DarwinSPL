package de.darwinspl.feature.graphical.configurator.editor.anomaly.views.tableviews;

import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import de.darwinspl.anomaly.DwAnomaly;
import de.darwinspl.anomaly.DwDeadFeatureAnomaly;
import de.darwinspl.anomaly.DwFalseOptionalFeatureAnomaly;
import de.darwinspl.anomaly.DwVoidFeatureModelAnomaly;
import de.darwinspl.feature.graphical.configurator.editor.anomaly.views.DwAnomalyView;
import eu.hyvar.context.information.contextValue.HyContextValue;
import eu.hyvar.dataValues.HyEnumValue;
import eu.hyvar.dataValues.HyNumberValue;
import eu.hyvar.dataValues.HyStringValue;
import eu.hyvar.feature.HyFeature;

public class AnomalyTableView<T extends DwAnomaly> extends TableViewer {
	
	private final DwAnomalyView anomalyView;
	
    private SelectionListener sortListener = new SelectionListener() {
		
		@Override
		public void widgetSelected(SelectionEvent e) {
			
			//TODO: Need to add own Comparator to viewer for each element
//			TableColumn column = (TableColumn) e.widget;
//			
//			if(getTable().getSortColumn()!= null && getTable().getSortColumn().equals(column)) {
//				
//				if(getTable().getSortDirection()== SWT.DOWN) {
//					getTable().setSortDirection(SWT.UP);
//				}else {
//					getTable().setSortDirection(SWT.DOWN);
//				}
//				
//			}
//			
//			getTable().setSortColumn(column);
//			getTable().setSortDirection(SWT.DOWN);
			
			
			
		}
		
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			// TODO Auto-generated method stub
			
		}
	};


	public AnomalyTableView(DwAnomalyView anomalyView, Composite parent, int style, List<T> falseOptionalAnomalies, String[] titles) {
		super(parent, style);
		
		this.anomalyView = anomalyView;
		

		createColumnsFalseOptionalAnomalies(parent, titles);
        final Table table = this.getTable();
        
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
       
        
  
        
        setContentProvider(new ArrayContentProvider());
        if(falseOptionalAnomalies != null){
      
        setInput(falseOptionalAnomalies);
        }

        // set the sorter for the table

        // define layout for the viewer
        GridData gridData = new GridData();
        gridData.verticalAlignment = GridData.FILL;
        gridData.horizontalSpan = 2;
        gridData.grabExcessHorizontalSpace = true;
        gridData.grabExcessVerticalSpace = true;
        gridData.horizontalAlignment = GridData.FILL;
        getControl().setLayoutData(gridData);

	}
	

	
	// create the columns for the table
    private void createColumnsFalseOptionalAnomalies(final Composite parent, String[] titles) {
        int[] bounds = { 100, 100, 100, 100, 100};

        
        // first column is for the type of the anomaly
        TableViewerColumn typeColumn = createTableViewerColumn(titles[0], bounds[0], 0);
        typeColumn.getColumn().addSelectionListener(sortListener);
        
        typeColumn.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                
                if(element instanceof DwFalseOptionalFeatureAnomaly){
                	return "False-Optional Feature";
                }else if(element instanceof DwVoidFeatureModelAnomaly){
                	return "Void Feature Model";
                } else if (element instanceof DwDeadFeatureAnomaly){
                	return "Dead Feature";
                }
                return "";
                
               
            }
        });

        // second column is for the name of the effected features or the contextual information values
        TableViewerColumn affectedElementsColumn = createTableViewerColumn(titles[1], bounds[1], 1);
        affectedElementsColumn.getColumn().addSelectionListener(sortListener);
        affectedElementsColumn.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
            	if(element instanceof DwFalseOptionalFeatureAnomaly){
            		HyFeature feature = ((DwFalseOptionalFeatureAnomaly) element).getFeature();
            		return feature.getNames().get(0).getName();
            	}else if(element instanceof DwDeadFeatureAnomaly){
            		HyFeature feature= ((DwDeadFeatureAnomaly) element).getFeature();
            		return feature.getNames().get(0).getName();
            	} else if( element instanceof DwVoidFeatureModelAnomaly){
                    DwVoidFeatureModelAnomaly p = (DwVoidFeatureModelAnomaly) element;
	            	
	            	EList<HyContextValue> contextValues = p.getContextValueModel().getValues();
	            	String result = "";
	            	for(HyContextValue contextValue: contextValues){
	            		
	            		
	            		result += contextValue.getContext().getName() + " = ";
	            		
	            		if(contextValue.getValue() instanceof HyNumberValue){
	            			result += Integer.toString(((HyNumberValue) contextValue.getValue()).getValue()) + "\n";
	            		} else if( contextValue.getValue() instanceof HyStringValue){
	            			result += ((HyStringValue) contextValue.getValue()).getValue() + "\n";
	            		} else if ( contextValue.getValue() instanceof HyEnumValue){
	            			result += ((HyEnumValue) contextValue.getValue()).getEnumLiteral().getName() + "\n";
	            		}
	            		
	            	}
	            	
	            	return result;
            		
            		
            	}
            	return "";
            }
            
        });
//
        // the effected date (since)
        TableViewerColumn dateSinceColumn = createTableViewerColumn(titles[2], bounds[2], 2);
        dateSinceColumn.getColumn().addSelectionListener(sortListener);
        dateSinceColumn.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
            	DwAnomaly p = (DwAnomaly) element;
            		Date date = p.getValidSince();
            		if(date == null){
            			return "NULL";
            		}
            		
            		return date.toString();
            	
            }
        });
//
        // the effected date (until)
        TableViewerColumn dateUntilColumn = createTableViewerColumn(titles[3], bounds[3], 3);
        
        dateUntilColumn.getColumn().addSelectionListener(sortListener);
        dateUntilColumn.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
            	
            	DwAnomaly p = (DwAnomaly) element;
            		Date date = ((DwAnomaly) p).getValidUntil();
            		if(date == null){
            			return "NULL";
            		}
            		return date.toString();
            	
            }
            
            
            @Override
        	public void update(ViewerCell cell) {
            	if(cell.getItem().getData() instanceof DwVoidFeatureModelAnomaly){
        		TableItem item = (TableItem) cell.getItem();
        		
        		
                Button button = new Button((Composite) cell.getViewerRow().getControl(), SWT.NONE);
                button.setData(item);
              
                button.setText("Explain");
                TableEditor editor = new TableEditor(item.getParent());
                editor.grabHorizontal  = true;
                editor.grabVertical = true;
                editor.setEditor(button , item, cell.getColumnIndex());
                editor.layout();
                
              
                
                item.addDisposeListener(new DisposeListener() {
					
					@Override
					public void widgetDisposed(DisposeEvent e) {
						
						editor.dispose();
						button.dispose();
						
					}
				});
                
                button.addSelectionListener(new SelectionListener() {
					
					@Override
					public void widgetSelected(SelectionEvent e) {
						TableItem item = (TableItem) button.getData();
						
					
						
						anomalyView.explaingAnomaly((DwAnomaly) item.getData());
						
					}
					
					@Override
					public void widgetDefaultSelected(SelectionEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
                
            	}
            	else{
            		DwAnomaly p = (DwAnomaly) cell.getItem().getData();
            		
            		Date date = p.getValidUntil();
            		if(date == null){
            			cell.setText("Eternity");
            		}else{
            		cell.setText(date.toString());
            		}
            		
            	}
              
                

        	}

           
        });
        
        TableViewerColumn explainColumn = createTableViewerColumn(titles[4], bounds[4], 4);
 	   
        explainColumn.setLabelProvider(new ColumnLabelProvider() {
        	
        	@Override
        	public void update(ViewerCell cell) {
        		if(cell.getItem().getData() instanceof DwDeadFeatureAnomaly || cell.getItem().getData() instanceof DwFalseOptionalFeatureAnomaly){
        		TableItem item = (TableItem) cell.getItem();
                Button button = new Button((Composite) cell.getViewerRow().getControl(), SWT.NONE);
                button.setData(item);
              
                button.setText("Explain");
                TableEditor editor = new TableEditor(item.getParent());
                editor.grabHorizontal  = true;
                editor.grabVertical = true;
                editor.setEditor(button , item, cell.getColumnIndex());
                editor.layout();
                
item.addDisposeListener(new DisposeListener() {
					
					@Override
					public void widgetDisposed(DisposeEvent e) {
						
						editor.dispose();
						button.dispose();
						
					}
				});
                
                button.addSelectionListener(new SelectionListener() {
					
					@Override
					public void widgetSelected(SelectionEvent e) {
						TableItem item = (TableItem) button.getData();
						
					
						
						anomalyView.explaingAnomaly((DwAnomaly) item.getData());
						
						
						
					}
					
					@Override
					public void widgetDefaultSelected(SelectionEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
                
             
              
                

        	}
        	}
        	
        });


        
    }
    
    private TableViewerColumn createTableViewerColumn(String title, int bound, final int colNumber) {
        final TableViewerColumn viewerColumn = new TableViewerColumn(this, SWT.NONE);
        final TableColumn column = viewerColumn.getColumn();
        column.setText(title);
        column.setWidth(bound);
        column.setResizable(true);
        column.setMoveable(true);
        return viewerColumn;
    }
    



}
