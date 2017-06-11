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

import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.evolution.HyName;
import eu.hyvar.feature.HyBooleanAttribute;
import eu.hyvar.feature.HyEnumAttribute;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyNumberAttribute;

public class DwConfiguratorSelectionDialog extends Dialog {
	
	protected enum AttributeType {
		NUMBERED,
		BOOLEAN,
		ENUM
	}
	
	protected class ConfiguratorTreeItem extends TreeItem {

		private AttributeType attributeType;
		private HyEnum hyEnum;
		
		public ConfiguratorTreeItem(TreeItem parent, int style) {
			super(parent, style);
		}

		
		
		@Override
		protected void checkSubclass() {
			// dont check :P
		}



		public AttributeType getAttributeType() {
			return attributeType;
		}

		public void setAttributeType(AttributeType attributeType) {
			this.attributeType = attributeType;
		}

		public HyEnum getHyEnum() {
			return hyEnum;
		}

		public void setHyEnum(HyEnum hyEnum) {
			this.hyEnum = hyEnum;
		}
			
	}

	private List<HyFeatureAttribute> attributes;
	
	private List<String> numberedAttributeNames = new ArrayList<String>();
	private List<String> booleanAttributeNames = new ArrayList<String>();
	private List<String> enumAttributeNames = new ArrayList<String>();
	
	private List<String> selectedNumberedAttributeNames = new ArrayList<String>();
	private List<String> selectedBooleanAttributeNames = new ArrayList<String>();
	private List<String> selectedEnumAttributeNames = new ArrayList<String>();
	
	private Tree tree;
	private TreeItem treeItemFeatureAttribute;
	private TreeItem treeItemFeatureModelAttribute;
	
	private List<HyFeatureAttribute> selectedFeatureAttributes = new ArrayList<>();
	
	public DwConfiguratorSelectionDialog(Shell parent, List<HyFeatureAttribute> attributes) {
		super(parent);
		this.attributes = attributes;
	}

	@Override
	protected boolean isResizable() {
		return true;
	}
	
	
	
	@Override
	protected void okPressed() {
		for (int i = 0; i < treeItemFeatureAttribute.getItemCount(); i++) {
			if(treeItemFeatureAttribute.getItem(i).getChecked()) {
				selectedFeatureAttributes.add(attributes.get(i));
			}
		}
		
		for (TreeItem item : treeItemFeatureModelAttribute.getItems()) {
			if(item.getChecked()) {
				if(item instanceof ConfiguratorTreeItem) {
					ConfiguratorTreeItem configuratorTreeItem = (ConfiguratorTreeItem)item;
					if(configuratorTreeItem.getAttributeType() == AttributeType.NUMBERED) {
						selectedNumberedAttributeNames.add(configuratorTreeItem.getText());
					} else if (configuratorTreeItem.getAttributeType() == AttributeType.ENUM) {
						selectedEnumAttributeNames.add(configuratorTreeItem.getText());
					} else if (configuratorTreeItem.getAttributeType() == AttributeType.BOOLEAN) {
						selectedBooleanAttributeNames.add(configuratorTreeItem.getText());
					}
				}
			}
		}
		
		super.okPressed();
	}
		
	protected List<String> getSelectedNumberedAttributeNames() {
		return selectedNumberedAttributeNames;
	}

	protected List<String> getSelectedBooleanAttributeNames() {
		return selectedBooleanAttributeNames;
	}

	protected List<String> getSelectedEnumAttributeNames() {
		return selectedEnumAttributeNames;
	}

	protected List<HyFeatureAttribute> getSelectedFeatureAttributes() {
		return selectedFeatureAttributes;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		
		tree = new Tree(composite, SWT.CHECK);
		tree.setSize(250, 1000);
		
		treeItemFeatureAttribute = new TreeItem(tree, SWT.CHECK);
		treeItemFeatureAttribute.setText("Feature Attributes");
		treeItemFeatureModelAttribute = new TreeItem(tree, SWT.CHECK);
		treeItemFeatureModelAttribute.setText("Feature Model Attributes");
		
		for (HyFeatureAttribute attribute : attributes) {
			for(HyName name : attribute.getNames()) {
				TreeItem treeItemAttribute = new TreeItem(treeItemFeatureAttribute, SWT.CHECK);
				treeItemAttribute.setText(attribute.getNames().get(0).getName() + ": " + name.getName());
			}
		}
		
		for (HyFeatureAttribute attribute : attributes) {
			for (HyName hyName : attribute.getNames()) {
				String name = hyName.getName();
				if (attribute instanceof HyNumberAttribute && !numberedAttributeNames.contains(name)) {
					numberedAttributeNames.add(name);
					
					ConfiguratorTreeItem treeItemAttribute = new ConfiguratorTreeItem(treeItemFeatureModelAttribute, SWT.CHECK);
					treeItemAttribute.setAttributeType(AttributeType.NUMBERED);
					treeItemAttribute.setText(name);
					
				} else if (attribute instanceof HyBooleanAttribute && !booleanAttributeNames.contains(name)) {
					booleanAttributeNames.add(name);
					
					ConfiguratorTreeItem treeItemAttribute = new ConfiguratorTreeItem(treeItemFeatureModelAttribute, SWT.CHECK);
					treeItemAttribute.setAttributeType(AttributeType.BOOLEAN);
					treeItemAttribute.setText(name);
					
				} else if (attribute instanceof HyEnumAttribute && !enumAttributeNames.contains(name)) {
					enumAttributeNames.add(name);
					
					ConfiguratorTreeItem treeItemAttribute = new ConfiguratorTreeItem(treeItemFeatureModelAttribute, SWT.CHECK);
					treeItemAttribute.setAttributeType(AttributeType.ENUM);
					treeItemAttribute.setHyEnum(((HyEnumAttribute)attribute).getEnumType());
					treeItemAttribute.setText(name);
					
				}
			}
		}
		
		return composite;
	}
	
	
	
	

}
