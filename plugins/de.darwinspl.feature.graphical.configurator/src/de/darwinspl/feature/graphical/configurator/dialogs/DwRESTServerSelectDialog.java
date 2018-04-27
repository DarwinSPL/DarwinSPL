package de.darwinspl.feature.graphical.configurator.dialogs;


import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

public class DwRESTServerSelectDialog extends TitleAreaDialog{
	
	
	private Text uriText;
	
	private Boolean httpAuthentificationEnabled;
	public Boolean getHttpAuthentificationEnabled() {
		return httpAuthentificationEnabled;
	}




	public void setHttpAuthentificationEnabled(Boolean httpAuthentificationEnabled) {
		this.httpAuthentificationEnabled = httpAuthentificationEnabled;
	}

	private Text userNameText;
	private Text passwordText;
	
	
	private String uri = null;
	private String userName = null;
	private String password = null;
	
	public String getUri() {
		return uri;
	}
	
	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public DwRESTServerSelectDialog(Shell parentShell) {
		super(parentShell);
		
		loadPluginSettings();
		
//		this.uri = uri;
//		if(username != null){
//			this.userName = username;
//		}
//		if(password != null){
//			this.password = password;
//		} 
//		if(isHttpAuthEnabled != null){
//			this.httpAuthentificationEnabled = isHttpAuthEnabled;
//		}	
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
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);

		Label uriLabel = new Label(container, SWT.NONE);
		uriLabel.setText("Server Adress:");

		GridData dataURI = new GridData();
		dataURI.grabExcessHorizontalSpace = true;
		dataURI.horizontalAlignment = GridData.FILL;


		uriText = new Text(container, SWT.BORDER);
		uriText.setLayoutData(dataURI);
		uriText.setText(uri.toString());

		
		GridData horizontalFillGridData = new GridData(SWT.FILL, SWT.TOP, true, false, 2, 1);
     
		
	
		Button enableAuthCheckBox = new Button(container, SWT.CHECK);
		enableAuthCheckBox.setText("Enable HTTP Authentification");
		enableAuthCheckBox.setTextDirection(SWT.LEFT);
		enableAuthCheckBox.setLayoutData(horizontalFillGridData);
		
		
		Label usernameLabel = new Label(container, SWT.NONE);
		usernameLabel.setText("Username:");
		
		userNameText = new Text(container, SWT.BORDER);
		userNameText.setLayoutData(dataURI);
		
		if(userName != null){
			userNameText.setText(userName);
		} else{
			userNameText.setText("");
		}
		

		
		
		Label passwordLabel = new Label(container, SWT.NONE);
		passwordLabel.setText("Password:");
		
		passwordText = new Text(container, SWT.BORDER);
		passwordText.setLayoutData(dataURI);
		passwordText.setEchoChar('*');
		if(password != null){
			passwordText.setText(password);
		}else{
		passwordText.setText("");
		}
		
		if(httpAuthentificationEnabled!=null){
			enableAuthCheckBox.setSelection(httpAuthentificationEnabled);
			passwordText.setEnabled(httpAuthentificationEnabled);
			userNameText.setEnabled(httpAuthentificationEnabled);
		} else{
			enableAuthCheckBox.setSelection(false);
			passwordText.setEnabled(false);
			userNameText.setEnabled(false);
		
		}
		
		enableAuthCheckBox.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
		
				Button source = (Button) e.getSource();
				Boolean isSelected = source.getSelection();
				userNameText.setEnabled(isSelected);
				passwordText.setEnabled(isSelected);
				httpAuthentificationEnabled = isSelected;
				
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		
		
		Button showPassword = new Button(container, SWT.CHECK);
		showPassword.setText("Show Password");
		showPassword.setTextDirection(SWT.LEFT);
		showPassword.setLayoutData(horizontalFillGridData);
		
		showPassword.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button source = (Button) e.getSource();
				Boolean isSelected = source.getSelection();
				if(isSelected){
				passwordText.setEchoChar('\0');
				passwordText.redraw();
				}else{
					passwordText.setEchoChar('*');
					passwordText.redraw();
				}
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
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
		return new Point(480, 400);
	}
	
	@Override
	protected void okPressed() {
		savePluginSettings();
		super.okPressed();
	}
	
	private void savePluginSettings() {
		Preferences preferences = InstanceScope.INSTANCE.getNode("de.darwinspl.feature.graphical.configurator.editor");
		Preferences cred = preferences.node("credentials");
		Preferences pref = preferences.node("preferences");
		
		cred.put("id", userName);
		cred.put("pw", password);
		
		pref.put("uri", uri);
		pref.putBoolean("httpAuth", httpAuthentificationEnabled);
		
		try {
			preferences.flush();
		}catch (BackingStoreException e) {
			e.printStackTrace();
		}
	}
	
	private void loadPluginSettings() {
		Preferences preferences = InstanceScope.INSTANCE.getNode("de.darwinspl.feature.graphical.configurator.editor");
		Preferences cred = preferences.node("credentials");
		Preferences pref = preferences.node("preferences");
		
		this.userName = cred.get("id", "");
		this.password = cred.get("pw", "");
		
		this.httpAuthentificationEnabled = pref.getBoolean("httpAuth", false);
		this.uri = pref.get("uri", "default");
	}
}
