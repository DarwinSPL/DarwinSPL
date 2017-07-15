package de.darwinspl.feature.stage.editor.wizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import de.christophseidl.util.eclipse.ResourceUtil;
import eu.hyvar.feature.util.HyFeatureUtil;

public class StageModelWizardCreationPage extends WizardPage {
	
	private Composite container;
	

	public StageModelWizardCreationPage(String pageName) {
		super(pageName);
		
		setTitle("Stage Model Creation");
		setDescription("By Clicking Finish, a Stage Model will be cerated for the available Feature Model");
	}

	@Override
	public void createControl(Composite parent) {
		// TODO Auto-generated method stub
		container = new Composite(parent, SWT.NONE);
//		GridLayout layout = new GridLayout();
//		container.setLayout(layout);
//		layout.numColumns = 2;
//		Label label1 = new Label(container, SWT.NONE);
//		
		container.setSize(250,0);
		setControl(container);
		setPageComplete(true);
	}

}
