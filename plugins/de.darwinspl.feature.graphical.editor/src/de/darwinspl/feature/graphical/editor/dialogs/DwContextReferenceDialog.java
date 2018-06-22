package de.darwinspl.feature.graphical.editor.dialogs;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import de.christophseidl.util.eclipse.ResourceUtil;
import de.christophseidl.util.ecore.EcoreIOUtil;
import de.christophseidl.util.ecore.EcoreResolverUtil;
import eu.hyvar.context.HyContextModel;
import eu.hyvar.context.HyContextualInformation;
import eu.hyvar.context.HyContextualInformationBoolean;
import eu.hyvar.context.HyContextualInformationEnum;
import eu.hyvar.context.HyContextualInformationNumber;
import eu.hyvar.context.information.util.HyContextInformationUtil;
import eu.hyvar.dataValues.HyEnumLiteral;
import eu.hyvar.feature.HyFeatureModel;

public class DwContextReferenceDialog extends Dialog {

	protected List<HyContextModel> selectedContextModels;
	protected HyFeatureModel featureModel;
	
	private TreeViewer treeViewer;
	
	private Button addContextModelButton;
	
	private Button removeContextModelButton;
	
	protected static final int MIN_HEIGHT = 100;
	
	public DwContextReferenceDialog(Shell parentShell, HyFeatureModel featureModel) {
		super(parentShell);
		
		this.featureModel = featureModel;
		this.selectedContextModels = new ArrayList<HyContextModel>();
		selectedContextModels.addAll(featureModel.getContexts());
		
		// Create some kind of table view. Each row is one context model. Represented by it's path. Then add and delete buttons.
		// If model is added, try to load it and verify that it is a valid context model.
	}
	
	public List<HyContextModel> getSelectedContextModels() {
		return selectedContextModels;
	}
	
	@Override
    protected Control createDialogArea(Composite parent) {
        Composite container = (Composite) super.createDialogArea(parent);
        
        treeViewer = new TreeViewer(container, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
        treeViewer.setContentProvider(new ContextViewContentProvider());
        treeViewer.getTree().setHeaderVisible(true);
        
        TreeViewerColumn nameColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
        nameColumn.getColumn().setText("Name");
        nameColumn.getColumn().setWidth(300);
        nameColumn.setLabelProvider(new DelegatingStyledCellLabelProvider(new NameLabelProvider()));

        TreeViewerColumn typeColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
        typeColumn.getColumn().setText("Type");
        typeColumn.getColumn().setWidth(100);
        typeColumn.getColumn().setAlignment(SWT.RIGHT);
        typeColumn.setLabelProvider(new DelegatingStyledCellLabelProvider(new TypeLabelProvider()));

        TreeViewerColumn domainColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
        domainColumn.getColumn().setText("Domain");
        domainColumn.getColumn().setWidth(100);
        domainColumn.getColumn().setAlignment(SWT.RIGHT);
        domainColumn.setLabelProvider(new DelegatingStyledCellLabelProvider(new DomainLabelProvider()));
        
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.widthHint = 500;
        gd.heightHint = 100;
        treeViewer.getControl().setLayoutData(gd);
        
        treeViewer.setInput(selectedContextModels);
        
//        createButton(container, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
//	    createButton(container, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	    
        addContextModelButton = new Button(container, SWT.NONE);
        addContextModelButton.setText("Add Context Model");
        addContextModelButton.addSelectionListener(new AddContextFileButtonListener(getShell()));
	    
        removeContextModelButton = new Button(container, SWT.NONE);
        removeContextModelButton.setText("Remove Context Model");
        removeContextModelButton.addSelectionListener(new RemoveContextButtonListener());
        
        return container;
	}
	
	protected void updateTreeViewAndLayout() {
		treeViewer.refresh();
		
		final Point newSize = getShell().computeSize(SWT.DEFAULT, SWT.DEFAULT, true); 
		
		getShell().setSize(newSize);
	}
	
	// overriding this methods allows you to set the
    // title of the custom dialog
    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText("Set Context Model References");
    }
	
	class RemoveContextButtonListener implements SelectionListener {
		

		@Override
		public void widgetSelected(SelectionEvent e) {
			ISelection selectedTreeItem = treeViewer.getSelection();
			
			if(selectedTreeItem != null && selectedTreeItem instanceof TreeSelection) {				
				@SuppressWarnings("rawtypes")
				Iterator iterator = ((TreeSelection) selectedTreeItem).iterator();
				if(iterator != null) {
					List<HyContextModel> contextModelsToRemove = new ArrayList<HyContextModel>();
					
					while(iterator.hasNext()) {
						Object selectedObject = iterator.next();
						if(selectedObject instanceof HyContextModel) {
							contextModelsToRemove.add((HyContextModel) selectedObject);
						}
					}
					selectedContextModels.removeAll(contextModelsToRemove);
					updateTreeViewAndLayout();					
				}
			}
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class AddContextFileButtonListener implements SelectionListener {

		private Shell parentShell;
		
		private AddContextFileButtonListener(Shell parent) {
			this.parentShell = parent;
		}
		
		@Override
		public void widgetSelected(SelectionEvent e) {
			FileDialog addContextFileDialog = new FileDialog(parentShell);
			addContextFileDialog.setFilterExtensions(new String[]{"*."+HyContextInformationUtil.getContextModelFileExtensionForXmi()});
			addContextFileDialog.setFilterPath(EcoreResolverUtil.resolveContainerFromEObject(featureModel).getLocation().toString());
			if(addContextFileDialog.open() != null) {
				String selectedFilePath = addContextFileDialog.getFilterPath()+File.separator+addContextFileDialog.getFileName();
				File selectedContextModelFile = new File(selectedFilePath);
				if(selectedContextModelFile != null && selectedContextModelFile.exists()) {
					IFile selectedContextModelIFile = ResourceUtil.fileToFile(selectedContextModelFile);
					if(selectedContextModelIFile != null) {
						EObject loadedModel = EcoreIOUtil.loadModel(selectedContextModelIFile);
						if(loadedModel instanceof HyContextModel) {
							selectedContextModels.add((HyContextModel) loadedModel);
							updateTreeViewAndLayout();
						}
					}
				}
			}
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	
	class ContextViewContentProvider implements ITreeContentProvider {

		@Override
		public Object[] getElements(Object inputElement) {
			if(inputElement != null) {
				@SuppressWarnings("unchecked")
				List<HyContextModel> inputElementList = (List<HyContextModel>) inputElement;
				
				HyContextModel[] contextModelInput = new HyContextModel[inputElementList.size()];
				
				for(int i = 0; i<inputElementList.size(); i++) {
					contextModelInput[i] = inputElementList.get(i);
				}
				
				return contextModelInput;
			}
			return null;
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			if(parentElement != null && parentElement instanceof HyContextModel) {
				HyContextModel parentContextModel = (HyContextModel) parentElement;
				
				HyContextualInformation[] contextChildren = new HyContextualInformation[parentContextModel.getContextualInformations().size()];
				
				for(int i=0; i<parentContextModel.getContextualInformations().size(); i++) {
					contextChildren[i] = parentContextModel.getContextualInformations().get(i);
				}
				
				return contextChildren;
			}
			else {
				return null;
			}
		}

		@Override
		public Object getParent(Object element) {
			if(element != null && element instanceof HyContextualInformation) {
				return ((HyContextualInformation) element).eContainer();
			}
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
			if(element != null && element instanceof HyContextModel) {
				return !((HyContextModel) element).getContextualInformations().isEmpty();
			}
			return false;
		}
		
	}
	
	class NameLabelProvider extends LabelProvider implements IStyledLabelProvider {

		@Override
		public StyledString getStyledText(Object element) {
			StyledString styledText = null;
			
			if(element instanceof HyContextModel) {
				styledText = new StyledString(EcoreIOUtil.getFile((HyContextModel)element).toString());
			}
			else if(element instanceof HyContextualInformation) {
				styledText = new StyledString(((HyContextualInformation)element).getName());
			}
			
			return styledText;
		}
		
	}
	

	
	class TypeLabelProvider extends LabelProvider implements IStyledLabelProvider {

		@Override
		public StyledString getStyledText(Object element) {
			StyledString styledText = null;
			
			if(element instanceof HyContextModel) {
				styledText = new StyledString("Context Model");
			}
			else if(element instanceof HyContextualInformationNumber) {
				styledText = new StyledString("Number Context");
			}
			else if(element instanceof HyContextualInformationBoolean) {
				styledText = new StyledString("Boolean Context");
			}
			else if(element instanceof HyContextualInformationEnum) {
				styledText = new StyledString("Enum Context");
			}
			
			
			return styledText;
		}
		
	}
	

	
	class DomainLabelProvider extends LabelProvider implements IStyledLabelProvider {

		@Override
		public StyledString getStyledText(Object element) {
			StyledString styledText = null;
			
			if(element instanceof HyContextualInformationNumber) {
				HyContextualInformationNumber numberContext = (HyContextualInformationNumber) element;
				String domainString = ""+numberContext.getMin()+" - "+numberContext.getMax();
				styledText = new StyledString(domainString);
			}
			else if(element instanceof HyContextualInformationBoolean) {
				styledText = new StyledString("True/False");
			}
			else if(element instanceof HyContextualInformationEnum) {
				HyContextualInformationEnum enumContext = (HyContextualInformationEnum) element;
				
				StringBuilder enumDomainStringBuilder = new StringBuilder("Enum: ");
				
				if(enumContext.getEnumType() != null) {
					enumDomainStringBuilder.append(enumContext.getEnumType().getName());
					enumDomainStringBuilder.append("(");
					boolean first = true;
					for(HyEnumLiteral literal: enumContext.getEnumType().getLiterals()) {
						if(first) {
							first = false;
						}
						else {
							enumDomainStringBuilder.append(", ");							
						}
						enumDomainStringBuilder.append(literal.getName());
					}
					enumDomainStringBuilder.append(")");
				}
				styledText = new StyledString(enumDomainStringBuilder.toString());
			}
			else {
				styledText = new StyledString("");
			}
			
			
			return styledText;
		}
		
	}
}
