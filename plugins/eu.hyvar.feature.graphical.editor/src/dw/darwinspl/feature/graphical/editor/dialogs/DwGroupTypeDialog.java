package dw.darwinspl.feature.graphical.editor.dialogs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;

import dw.darwinspl.feature.graphical.base.model.DwGroupWrapped;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;

public class DwGroupTypeDialog extends DwTypeDialog {
	public DwGroupTypeDialog(Shell parentShell) {
		super(parentShell);
		
		Type and = new Type();
		and.type = HyGroupTypeEnum.AND_VALUE;
		and.description = "And";	
		
		Type or = new Type();
		or.type = HyGroupTypeEnum.OR_VALUE;
		or.description = "Or";		

		Type alternative = new Type();
		alternative.type = HyGroupTypeEnum.ALTERNATIVE_VALUE;
		alternative.description = "Alternative";			
		
		
		types.add(and);
		types.add(or);
		types.add(alternative);
	}
	
	@Override
	protected String[] getDefaultItemTexts(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String text = dateFormat.format(cal.getTime());

		return new String[]{"And", text, text};
	}	
	
	@Override
	protected void addItem(EObject object){
		HyGroupType type = (HyGroupType)object;
		Date sinceDate = type.getValidSince();
		Date untilDate = type.getValidUntil();
		
		// if no date exists, create one
		Date tempDate = null;
		if(sinceDate != null){
			tempDate = sinceDate;
		}
		if(sinceDate == null && untilDate == null){
			 tempDate = new Date();
		}
		if(sinceDate == null && untilDate != null){
			Calendar cal = Calendar.getInstance();
			cal.setTime(untilDate);
			cal.add(Calendar.SECOND, -1);
			tempDate = cal.getTime();
		}
		
		
		
		HyGroup group = ((DwGroupWrapped)this.getElement()).getWrappedModelElement();
		String cardinality = "";
		
		
		if(group.isAlternative(tempDate)){
			cardinality = "Alternative";
		}
		if(group.isAnd(tempDate)){
			cardinality = "And";
		}
		if(group.isOr(tempDate)){
			cardinality = "Or";
		}
		
		if(cardinality.equals("")){
			cardinality = "Invalid Cardinality";
		}
		
		String since = (sinceDate == null) ? "" : getDateFormatted(sinceDate, DATE_FORMATTING);
		String until = (untilDate == null) ? "" : getDateFormatted(untilDate, DATE_FORMATTING);

		TableItem item = new TableItem(table, SWT.NONE);
		String[] text = { cardinality, since, until };
		item.setText(text);	
	}
}