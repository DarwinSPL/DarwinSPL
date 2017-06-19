package de.darwinspl.feature.graphical.configurator.dialogs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import de.darwinspl.feature.graphical.configurator.widgets.DwAttributeTreeItem;
import eu.hyvar.dataValues.HyEnum;
import eu.hyvar.feature.HyBooleanAttribute;
import eu.hyvar.feature.HyEnumAttribute;
import eu.hyvar.feature.HyFeatureAttribute;
import eu.hyvar.feature.HyNumberAttribute;
import eu.hyvar.feature.util.HyFeatureEvolutionUtil;

public class DwConfiguratorSelectionDialog extends Dialog {

	protected enum AttributeType {
		NUMBERED, BOOLEAN, ENUM
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

	private Date date;

	public DwConfiguratorSelectionDialog(Shell parent, List<HyFeatureAttribute> attributes, Date date) {
		super(parent);
		this.attributes = attributes;
		this.date = date;
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	protected void okPressed() {
		for (TreeItem item : treeItemFeatureAttribute.getItems()) {

			if (item.getChecked() && item instanceof DwAttributeTreeItem) {
				selectedFeatureAttributes.add(((DwAttributeTreeItem) item).getAttribute());
			}
		}

		for (TreeItem item : treeItemFeatureModelAttribute.getItems()) {
			if (item.getChecked()) {
				if (item instanceof ConfiguratorTreeItem) {
					ConfiguratorTreeItem configuratorTreeItem = (ConfiguratorTreeItem) item;
					if (configuratorTreeItem.getAttributeType() == AttributeType.NUMBERED) {
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

		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;

		composite.setLayoutData(gridData);
		
		tree = new Tree(composite, SWT.CHECK);
		tree.setSize(250, 1000);
		
		tree.setLayoutData(gridData);

		treeItemFeatureAttribute = new TreeItem(tree, SWT.CHECK);
		treeItemFeatureAttribute.setText("Feature Attributes");
		treeItemFeatureModelAttribute = new TreeItem(tree, SWT.CHECK);
		treeItemFeatureModelAttribute.setText("Feature Model Attributes");

		for (HyFeatureAttribute attribute : attributes) {
			new DwAttributeTreeItem(attribute, date, treeItemFeatureAttribute, SWT.CHECK);
		}

		for (HyFeatureAttribute attribute : attributes) {
			String name = HyFeatureEvolutionUtil.getName(attribute.getNames(), date).getName();
			if (attribute instanceof HyNumberAttribute && !numberedAttributeNames.contains(name)) {
				numberedAttributeNames.add(name);

				ConfiguratorTreeItem treeItemAttribute = new ConfiguratorTreeItem(treeItemFeatureModelAttribute,
						SWT.CHECK);
				treeItemAttribute.setAttributeType(AttributeType.NUMBERED);
				treeItemAttribute.setText(name);

			} else if (attribute instanceof HyBooleanAttribute && !booleanAttributeNames.contains(name)) {
				booleanAttributeNames.add(name);

				ConfiguratorTreeItem treeItemAttribute = new ConfiguratorTreeItem(treeItemFeatureModelAttribute,
						SWT.CHECK);
				treeItemAttribute.setAttributeType(AttributeType.BOOLEAN);
				treeItemAttribute.setText(name);

			} else if (attribute instanceof HyEnumAttribute && !enumAttributeNames.contains(name)) {
				enumAttributeNames.add(name);

				ConfiguratorTreeItem treeItemAttribute = new ConfiguratorTreeItem(treeItemFeatureModelAttribute,
						SWT.CHECK);
				treeItemAttribute.setAttributeType(AttributeType.ENUM);
				treeItemAttribute.setHyEnum(((HyEnumAttribute) attribute).getEnumType());
				treeItemAttribute.setText(name);

			}

		}

		return composite;
	}

	@Override
	protected Point getInitialSize() {
		return new Point(640, 480);
	}

}
