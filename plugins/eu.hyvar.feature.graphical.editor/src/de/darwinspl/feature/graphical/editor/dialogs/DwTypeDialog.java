package de.darwinspl.feature.graphical.editor.dialogs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;

import de.darwinspl.feature.graphical.base.dialogs.DwDateDialog;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.base.model.DwGroupWrapped;
import eu.hyvar.evolution.HyLinearTemporalElement;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;

public abstract class DwTypeDialog extends DwTableDialog {
	
	protected class Type{
		public String description;
		public int type;
	}

	protected List<Type> types;
	
	/**
	 * Changed cardinalities will be copied and only changed if dialog gets closed with 'ok'. This hashtable
	 * saves all changes made, key is the index of changed cardinality
	 */
	protected Hashtable<Integer, HyLinearTemporalElement> changedTypes;

	public DwTypeDialog(Shell parentShell) {
		super(parentShell);

		types = new ArrayList<Type>();
		changedTypes = new Hashtable<Integer, HyLinearTemporalElement>();
	}

	public List<Type> getTypes() {
		return types;
	}


	public void setTypes(List<Type> types) {
		this.types = types;
	}


	@Override
	protected void addItem(EObject object){		
		HyLinearTemporalElement temp = (HyLinearTemporalElement)object;
		Date sinceDate = temp.getValidSince();
		Date untilDate = temp.getValidUntil();
		
		int type = -1;
		if(object instanceof HyFeatureType){
			HyFeatureTypeEnum featureType = ((HyFeatureType)object).getType();
			type = featureType.getValue();
		}else if(object instanceof HyGroupType){
			HyGroupTypeEnum groupType = ((HyGroupType)object).getType();
			type = groupType.getValue();
		}



		String cardinality = "";
		for(Type ctype : types){
			if(type == ctype.type)
				cardinality = ctype.description;
		}

		String since = (sinceDate == null) ? "" : getDateFormatted(sinceDate, DATE_FORMATTING);
		String until = (untilDate == null) ? "" : getDateFormatted(untilDate, DATE_FORMATTING);

		TableItem item = new TableItem(table, SWT.NONE);
		String[] text = { cardinality, since, until };
		item.setText(text);	
	}

	@Override
	protected String[] getColumnLabels(){
		return new String[]{"Type", "Since", "Until"};
	}	

	@Override
	protected void createEditorComponent(TableItem item, int index){
		Control oldEditor = editor.getEditor();
		if (oldEditor != null) oldEditor.dispose();

		CCombo newEditor = new CCombo(table, SWT.NONE);
		newEditor.setText(item.getText(0));
		for(int i=0; i<types.size(); i++){
			newEditor.add(types.get(i).description);
		}

		newEditor.addModifyListener(new ModifyListener(){

			@Override
			public void modifyText(ModifyEvent e) {
				CCombo text = (CCombo)editor.getEditor();
				editor.getItem().setText(0, text.getText());

				String value = text.getText();
				int index = table.indexOf(editor.getItem());



				for(int i=0; i<types.size(); i++){
					if(value.equals(types.get(i).description)){
						if(element instanceof DwFeatureWrapped){
							HyFeatureType type = EcoreUtil.copy(((DwFeatureWrapped)element).getWrappedModelElement()).getTypes().get(index);
							type.setType((HyFeatureTypeEnum.get(types.get(i).type)));
							
							changedTypes.put(index, type);
						}else if(element instanceof DwGroupWrapped){
							HyGroupType type = EcoreUtil.copy(((DwGroupWrapped)element).getWrappedModelElement()).getTypes().get(index);
							type.setType((HyGroupTypeEnum.get(types.get(i).type)));
							
							changedTypes.put(index, type);
						}
						
						//cardinality.setMinCardinality(cardinalities.get(i).min);
						//cardinality.setMaxCardinality(cardinalities.get(i).max);
						
						

						// triggers that all listeners will receive the cardinality change
						//changeableElement.setCardinailtyAtIndex(cardinality, index);
					}
				}	


			}

		});

		newEditor.setFocus();
		editor.setEditor(newEditor, item, 0);	
	}	

	@Override
	protected String[] getDefaultItemTexts(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String text = dateFormat.format(cal.getTime());

		return new String[]{"No Modifier", text, text};
	}		

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);

		table.addListener(SWT.MouseDoubleClick, new Listener() {
			public void handleEvent(Event event) {
				Point pt = new Point(event.x, event.y);
				TableItem item = table.getItem(pt);
				if (item == null)
					return;
				for (int i = 0; i < table.getColumnCount(); i++) {
					Rectangle rect = item.getBounds(i);
					int index = table.indexOf(item);

					if (rect.contains(pt)) {
						if(i == 1 || i == 2){
							DwDateDialog dialog = new DwDateDialog(getShell(), convertStringToDate(item.getText(i)));
							dialog.open();
							if(dialog.getReturnCode() == OK){
								Date value = dialog.getValue();
	
								if(value != null){
									HyLinearTemporalElement type = null;
									if(element instanceof DwFeatureWrapped){
										type = EcoreUtil.copy(((DwFeatureWrapped)element).getWrappedModelElement().getTypes().get(index));
									}else if(element instanceof DwGroupWrapped){
										type = EcoreUtil.copy(((DwGroupWrapped)element).getWrappedModelElement()).getTypes().get(index);
									}else{
										System.err.println("Wrong EObject for TypeDialog "+element);
										return;
									}
									
									if(i == 1){
										type.setValidSince(value);
									}else{
										type.setValidUntil(value);
									}

									changedTypes.put(index, type);
	
									item.setText(i, getDateFormatted(value, DATE_FORMATTING));
								}
							}
						}else{
							createEditorComponent(item, i);
						}
					}
				}	
			}
		});

		return container;
	}	

	@Override
	public void widgetSelected(SelectionEvent e) {		
		if(e.widget == addTimestamp){
			if(element instanceof DwFeatureWrapped){
				HyFeatureType type = HyFeatureFactory.eINSTANCE.createHyFeatureType();
				((DwFeatureWrapped)element).getWrappedModelElement().getTypes().add(type);
				
				addItem(type);
			}else if(element instanceof DwGroupWrapped){
				HyGroupType type = HyFeatureFactory.eINSTANCE.createHyGroupType();
				((DwGroupWrapped)element).getWrappedModelElement().getTypes().add(type);
				
				addItem(type);
			}

					
		}else{			
			TableItem[] selection = table.getSelection();
			for(int i=0; i<selection.length; i++){
				table.remove(table.indexOf(selection[i]));
			}
		}
	}	
	
	
	/**
	 * Copy changed cardinalities to selected cardinality based element
	 */
	@Override
	protected void okPressed(){
		Enumeration<Integer> e = changedTypes.keys();
		while(e.hasMoreElements()){
			int index = (Integer)e.nextElement();
			
			if(element instanceof DwFeatureWrapped){
				((DwFeatureWrapped)element).getWrappedModelElement().getTypes().set(index, (HyFeatureType)changedTypes.get(index));
			}else if(element instanceof DwGroupWrapped){
				((DwGroupWrapped)element).getWrappedModelElement().getTypes().set(index, (HyGroupType)changedTypes.get(index));
			}
		}
		
		super.okPressed();
	}
	
}
