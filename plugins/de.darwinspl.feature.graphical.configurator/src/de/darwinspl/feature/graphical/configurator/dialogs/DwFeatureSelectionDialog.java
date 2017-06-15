package de.darwinspl.feature.graphical.configurator.dialogs;

import java.util.Date;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.util.HyFeatureEvolutionUtil;

public class DwFeatureSelectionDialog extends Dialog {
	
	private HyFeatureModel featureModel;
	private Date date;
	private boolean checkChilds = true;
	
	public DwFeatureSelectionDialog(Shell parent, HyFeatureModel featureModel, Date date) {
		super(parent);
		
		this.featureModel = featureModel;
		this.date = date;
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	protected Control createDialogArea(Composite parent) {

		Composite composite = (Composite) super.createDialogArea(parent);
	
		HyFeature feature = HyFeatureEvolutionUtil.getRootFeature(featureModel, date);
		String rootName = HyFeatureEvolutionUtil.getName(feature.getNames(), date).getName();
		
		Tree tree = new Tree(composite, SWT.CHECK);
		tree.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				if(event.detail == SWT.CHECK && checkChilds) selectChilds((TreeItem)event.item, ((TreeItem)event.item).getChecked());
			}
		});
		
		TreeItem item = new TreeItem(tree, SWT.CHECK);		
		item.setText(rootName);
		addFeatures(item, HyFeatureEvolutionUtil.getChildsOfFeature(feature, date));
	
		Button checkSubTrees = new Button(composite, SWT.CHECK);
		checkSubTrees.setText("include childs");
		checkSubTrees.setSelection(true);
		
		checkSubTrees.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				checkChilds = checkSubTrees.getSelection();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		return composite;
	}
	
	private void addFeatures(TreeItem parent, List<HyGroup> groups) {
		for(HyGroup group : groups) {
			for(HyFeature feature : HyFeatureEvolutionUtil.getFeaturesOfGroup(group, date)) {
				TreeItem item = new TreeItem(parent, SWT.CHECK);
				item.setText(HyFeatureEvolutionUtil.getName(feature.getNames(), date).getName());
				addFeatures(item, HyFeatureEvolutionUtil.getChildsOfFeature(feature, date));
			}
		}
	}
	
	private void selectChilds(TreeItem item, boolean checked) {
		for(TreeItem child : item.getItems()) {
			child.setChecked(checked);
			selectChilds(child, checked);
		}
	}
}
