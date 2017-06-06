package de.darwinspl.feature.graphical.configurator.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import eu.hyvar.feature.HyFeatureAttribute;

public abstract class DwAbstractConfiguratorWidget extends Composite implements DwConfiguratorWidget {

	private Button checkbox;
	private Label label;
	private Button upButton;
	private Button downButton;
	private String attributeName;
	private HyFeatureAttribute attribute;

	public DwAbstractConfiguratorWidget(HyFeatureAttribute attribute, Composite parent, int style) {
		this(attribute.getFeature().getNames().get(0).getName() + ": " + attribute.getNames().get(0).getName(), parent, style);
		this.attribute = attribute;
	}
	
	public DwAbstractConfiguratorWidget(String attributename, Composite parent, int style) {
		this(parent, style);
		label.setText(attributename);
		this.attributeName = attributename;
	}
	
	public DwAbstractConfiguratorWidget(Composite parent, int style) {
		super(parent, style);
		this.setLayout( new RowLayout(SWT.HORIZONTAL));

		upButton = new Button(this, SWT.NONE);
		downButton = new Button(this, SWT.NONE);
		checkbox = new Button(this, SWT.CHECK);
		label = new Label(this, SWT.NONE);
		

		upButton.setText("Up");
		downButton.setText("Down");

		upButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (parent instanceof DwConfiguratorRowComposite) {
					DwConfiguratorRowComposite composite = (DwConfiguratorRowComposite) parent;
					composite.moveUp(DwAbstractConfiguratorWidget.this);
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
		
		downButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (parent instanceof DwConfiguratorRowComposite) {
					DwConfiguratorRowComposite composite = (DwConfiguratorRowComposite) parent;
					composite.moveDown(DwAbstractConfiguratorWidget.this);
				}				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

	}

	@Override
	public void setLabelText(String text) {
		label.setText(text);
	}

	@Override
	public boolean isChecked() {
		return checkbox.getSelection();
	}

	@Override
	public HyFeatureAttribute getAttribute() {
		return attribute;
	}

	@Override
	public String getAttributeName() {
		// TODO Auto-generated method stub
		return attributeName;
	}
	
	

}
