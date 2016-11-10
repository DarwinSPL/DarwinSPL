package eu.hyvar.feature.graphical.editor.dialogs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;

import eu.hyvar.evolution.HyEvolutionFactory;
import eu.hyvar.evolution.HyName;
import eu.hyvar.evolution.HyNamedElement;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.graphical.base.dialogs.DateDialog;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;

public class ParentChangeDialog extends TableDialog{
	private List<HyFeature> features;
	private HyFeatureModelWrapped featureModel;
	
	public HyFeatureModelWrapped getFeatureModel() {
		return featureModel;
	}

	public void setFeatureModel(HyFeatureModelWrapped featureModel) {
		this.featureModel = featureModel;
	}

	public List<HyFeature> getFeatures() {
		return features;
	}

	public void setFeatures(List<HyFeature> features) {
		this.features = features;
	}

	public ParentChangeDialog(Shell parentShell) {
		super(parentShell);

		setShellStyle(getShellStyle() | SWT.RESIZE); 
	}

	@Override
	protected String[] getColumnLabels(){
		return new String[]{"Name", "Since", "Until"};
	}	
	
	@Override
	protected String[] getDefaultItemTexts(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String text = dateFormat.format(cal.getTime());

		return new String[]{"New Name", text, text};
	}	

	@Override
	protected void addItem(EObject object){	
		HyName hyName = (HyName)object;
		Date sinceDate = hyName.getValidSince();
		Date untilDate = hyName.getValidUntil();

		String name = hyName.getName();
		String since = (sinceDate == null) ? "" : getDateFormatted(sinceDate, DATE_FORMATTING);
		String until = (untilDate == null) ? "" : getDateFormatted(untilDate, DATE_FORMATTING);

		TableItem item = new TableItem(table, SWT.NONE);
		String[] text = { name, since, until };
		item.setText(text);	
	}

	private void openTreeDialog(){
		TreeDialog dialog = new TreeDialog(this.getShell(), featureModel);
		dialog.open();
	}
	
	@Override
	protected void createEditorComponent(TableItem item, int index){
		Control oldEditor = editor.getEditor();
		if (oldEditor != null) oldEditor.dispose();

		Button newEditor = new Button(table, SWT.NONE);
		newEditor.setText(item.getText(0));
		

		newEditor.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetSelected(SelectionEvent e) {

				openTreeDialog();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});

		newEditor.setFocus();
		
		editor.setEditor(newEditor, item, 0);	
		
	}	


	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);

		table.addListener(SWT.MouseDoubleClick, new Listener(){
				@Override
				public void handleEvent(Event event) {
					Point pt = new Point(event.x, event.y);
					TableItem item = table.getItem(pt);
					if (item == null)
						return;
					for (int i = 0; i < table.getColumnCount(); i++) {
						Rectangle rect = item.getBounds(i);
						if (rect.contains(pt)) {

							if(i == 1 || i == 2){
								DateDialog dialog = new DateDialog(getShell(), convertStringToDate(item.getText(i)));
								dialog.open();
								Date value = dialog.getValue();

								if(value != null){							
									int index = table.indexOf(item);
									if(i == 1){
										((HyFeatureWrapped)element).getWrappedModelElement().getNames().get(index).setValidSince(dialog.getValue());
									}else{
										((HyFeatureWrapped)element).getWrappedModelElement().getNames().get(index).setValidUntil(dialog.getValue());
									}

									item.setText(i, getDateFormatted(value, DATE_FORMATTING));
								}

							}else{
								createEditorComponent(item, table.indexOf(item));
							}
						}
					}			
				}
		});

		return container;
	}

	// overriding this methods allows you to set the
	// title of the custom dialog
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Name History");
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
	}

	@Override
	public void widgetSelected(SelectionEvent e) {		
		if(e.widget == addTimestamp){
			String newName = "New Name";
			HyName name = HyEvolutionFactory.eINSTANCE.createHyName();
			name.setName(newName);

			if(element instanceof HyFeatureWrapped)
				((HyFeatureWrapped)element).getWrappedModelElement().getNames().add(name);
			else
				((HyNamedElement)element).getNames().add(name);
			

			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(new String[]{ newName, "", ""});			
		}else{			
			TableItem[] selection = table.getSelection();
			for(int i=0; i<selection.length; i++){
				table.remove(table.indexOf(selection[i]));
			}
		}
	}	
}
