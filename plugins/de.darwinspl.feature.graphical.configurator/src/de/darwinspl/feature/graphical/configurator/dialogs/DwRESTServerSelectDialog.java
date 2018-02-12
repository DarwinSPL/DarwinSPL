package de.darwinspl.feature.graphical.configurator.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class DwRESTServerSelectDialog extends TitleAreaDialog{
	private Text uriText;
	private Text userNameText;
	private Text passwordText;
	private String uri;
	private String userName;
	private String password;
	
	public String getUri() {
		return uri;
	}
	
	


	public String getUserName() {
		return userName;
	}




	public String getPassword() {
		return password;
	}




	public DwRESTServerSelectDialog(Shell parentShell, String uri) {
		super(parentShell);
		
		this.uri = uri;
	}


	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	public void create() {
		super.create();
		setTitle("Change Server Adress");
		setMessage("Change the adress of the rest server for reconfigurating the selected feature model", IMessageProvider.INFORMATION);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(3, false);
		container.setLayout(layout);

		Label uriLabel = new Label(container, SWT.NONE);
		uriLabel.setText("Server Adress:");

		GridData dataURI = new GridData();
		dataURI.grabExcessHorizontalSpace = true;
		dataURI.horizontalAlignment = GridData.FILL;


		uriText = new Text(container, SWT.BORDER);
		uriText.setLayoutData(dataURI);
		uriText.setText(uri.toString());
		
		Label usernameLabel = new Label(container, SWT.NONE);
		usernameLabel.setText("Username:");
		
		userNameText = new Text(container, SWT.BORDER);
		userNameText.setLayoutData(dataURI);
		userNameText.setText("");
		
		Label passwordLabel = new Label(container, SWT.NONE);
		passwordLabel.setText("Password:");
		
		passwordText = new Text(container, SWT.BORDER);
		passwordText.setLayoutData(dataURI);
		passwordText.setText("");
		
		
		final ControlDecoration txtDecorator = new ControlDecoration(uriText, SWT.TOP|SWT.RIGHT|SWT.FILL);
		FieldDecoration fieldDecoration = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry .DEC_ERROR);
		
		Image img = fieldDecoration.getImage();
		txtDecorator.setImage(img);
		txtDecorator.setDescriptionText("Please enter only numeric fields");
		// hiding it initially
		txtDecorator.hide();	
		
		uriText.addModifyListener(new ModifyListener(){

			@Override
			public void modifyText(ModifyEvent e) {
				try{
				uri = uriText.getText();
				txtDecorator.hide();
				}catch(Exception e1){
					txtDecorator.show();
				}
			}
			
		});	
		
		passwordText.addModifyListener(new ModifyListener(){

			@Override
			public void modifyText(ModifyEvent e) {
				try{
				password = passwordText.getText();
				txtDecorator.hide();
				}catch(Exception e1){
					txtDecorator.show();
				}
			}
			
		});	
		
		userNameText.addModifyListener(new ModifyListener(){

			@Override
			public void modifyText(ModifyEvent e) {
				try{
				userName = userNameText.getText();
				txtDecorator.hide();
				}catch(Exception e1){
					txtDecorator.show();
				}
			}
			
		});
		

		return container;
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, "Change Server Adress", true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}	

	@Override
	protected Point getInitialSize() {
		return new Point(480, 340);
	}
}
