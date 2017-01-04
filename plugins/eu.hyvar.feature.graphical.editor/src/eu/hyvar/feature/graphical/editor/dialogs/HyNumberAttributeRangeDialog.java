package eu.hyvar.feature.graphical.editor.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import eu.hyvar.feature.HyNumberAttribute;

public class HyNumberAttributeRangeDialog extends SelectionDialog{

	Text textMinimum;
	Text textMaximum;
	
	int minimum;
	int maximum;
	
	public int getMinimum() {
		return minimum;
	}


	public int getMaximum() {
		return maximum;
	}


	public HyNumberAttributeRangeDialog(Shell parentShell) {
		super(parentShell);
	}	
	
	@Override
	protected Point getInitialSize() {
		return new Point(350, 300);
	}	
	
	protected class NumberVerifyListener implements VerifyListener{
		public void verifyText(VerifyEvent e){
			String string = e.text;
			char [] chars = new char [string.length ()];
			string.getChars (0, chars.length, chars, 0);
			for (int i=0; i<chars.length; i++) {
				if (!('0' <= chars [i] && chars [i] <= '9')) {
					e.doit = false;
					return;
				}
			}			
		}
	}
	
	@Override
	public void setElement(Object element){
		minimum = ((HyNumberAttribute)element).getMin();
		maximum = ((HyNumberAttribute)element).getMax();
		
		this.element = element;
	}

	@Override
	protected void createWidgets(Composite parent) {
		HyNumberAttribute attribute = (HyNumberAttribute)element;
		
		
		RowLayout rowLayout = new RowLayout();
		rowLayout.wrap = false;
		rowLayout.pack = false;
		rowLayout.justify = true;
		rowLayout.type = SWT.VERTICAL;
		rowLayout.marginLeft = 5;
		rowLayout.marginTop = 5;
		rowLayout.marginRight = 5;
		rowLayout.marginBottom = 5;
		rowLayout.spacing = 0;
		
		parent.setLayout(rowLayout);
		
	    Label labelForMimimum = new Label(parent, SWT.NULL);
	    labelForMimimum.setText("Minimum:");

		textMinimum = new Text(parent, SWT.BORDER | SWT.V_SCROLL);
		textMinimum.setText(Integer.toString(attribute.getMin()));
		textMinimum.addVerifyListener(new NumberVerifyListener());	  
		textMinimum.addListener(SWT.CHANGED, new Listener(){

			@Override
			public void handleEvent(Event event) {
				if(!textMinimum.getText().isEmpty())
					minimum = Integer.parseInt(textMinimum.getText());
			}
			
		});
	    
	    Label labelForMaximum = new Label(parent, SWT.NULL);
	    labelForMaximum.setText("Maximum:");
	    
	    textMaximum = new Text(parent, SWT.BORDER | SWT.V_SCROLL);
	    textMaximum.setText(Integer.toString(attribute.getMax()));
	    textMaximum.addVerifyListener(new NumberVerifyListener());
	    textMaximum.addListener(SWT.CHANGED, new Listener(){

			@Override
			public void handleEvent(Event event) {
				if(!textMinimum.getText().isEmpty())
					maximum = Integer.parseInt(textMaximum.getText());
			}
		});
	}
}
