package de.darwinspl.feature.graphical.configurator.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyBooleanAttribute;
import eu.hyvar.feature.HyEnumAttribute;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyNumberAttribute;

public class DwConfiguratorSelectionDialog extends Dialog {

	private List<HyFeatureAttribute> attributes;
	
	private List<String> numberedAttributeNames = new ArrayList<String>();
	private List<String> booleanAttributeNames = new ArrayList<String>();
	private List<String> enumAttributeNames = new ArrayList<String>();
	
	public DwConfiguratorSelectionDialog(Shell parent, List<HyFeatureAttribute> attributes) {
		super(parent);
		this.attributes = attributes;
	}

	@Override
	protected boolean isResizable() {
		return true;
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		
		Tree tree = new Tree(composite, SWT.CHECK);
		tree.setSize(250, 500);
		
		TreeItem treeItemFeatureAttribute = new TreeItem(tree, SWT.NONE);
		treeItemFeatureAttribute.setText("Feature Attributes");
		TreeItem treeItemFeatureModelAttribute = new TreeItem(tree, SWT.NONE);
		treeItemFeatureModelAttribute.setText("Feature Model Attributes");
		
		for (HyFeatureAttribute attribute : attributes) {
			for(HyName name : attribute.getNames()) {
				TreeItem treeItemAttribute = new TreeItem(treeItemFeatureAttribute, SWT.CHECK);
				treeItemAttribute.setText(name.getName());
			}
		}
		
		for (HyFeatureAttribute attribute : attributes) {
			for (HyName hyName : attribute.getNames()) {
				String name = hyName.getName();
				if (attribute instanceof HyNumberAttribute && !numberedAttributeNames.contains(name)) {
					numberedAttributeNames.add(name);
					
					TreeItem treeItemAttribute = new TreeItem(treeItemFeatureModelAttribute, SWT.CHECK);
					treeItemAttribute.setText(name);
					
				} else if (attribute instanceof HyBooleanAttribute && !booleanAttributeNames.contains(name)) {
					booleanAttributeNames.add(name);
					
					TreeItem treeItemAttribute = new TreeItem(treeItemFeatureModelAttribute, SWT.CHECK);
					treeItemAttribute.setText(name);
					
				} else if (attribute instanceof HyEnumAttribute && !enumAttributeNames.contains(name)) {
					enumAttributeNames.add(name);
					
					TreeItem treeItemAttribute = new TreeItem(treeItemFeatureModelAttribute, SWT.CHECK);
					treeItemAttribute.setText(name);
					
				}
			}
		}
		
		return composite;
	}
	
	
	
	

}
