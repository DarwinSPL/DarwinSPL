package de.darwinspl.feature.graphical.configurator.dialogs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import de.darwinspl.feature.graphical.configurator.widgets.DwFeatureTreeItem;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.util.HyFeatureEvolutionUtil;

public class DwFeatureSelectionDialog extends Dialog {
	
	private HyFeatureModel featureModel;
	private Date date;
	private boolean checkChilds = true;
	private Tree tree;
	private DwFeatureTreeItem rootItem;
	private List<HyFeature> selectedFeatures = new ArrayList<HyFeature>();
	
	public DwFeatureSelectionDialog(Shell parent,List<HyFeature> selectedFeatures, HyFeatureModel featureModel, Date date) {
		super(parent);
		
		this.selectedFeatures = selectedFeatures;
		this.featureModel = featureModel;
		this.date = date;
	}

	@Override
	protected boolean isResizable() {
		return true;
	}
	
	

	@Override
	protected void okPressed() {
		selectedFeatures = getSelectedFeatures(rootItem);
		super.okPressed();
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
		
		HyFeature feature = HyFeatureEvolutionUtil.getRootFeature(featureModel, date);
		
		tree = new Tree(composite, SWT.CHECK);
		tree.setLayoutData(gridData);
		tree.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				if(event.detail == SWT.CHECK && checkChilds) selectChilds((TreeItem)event.item, ((TreeItem)event.item).getChecked());
			}
		});
		
		rootItem = new DwFeatureTreeItem(feature, date, tree, SWT.CHECK);	
		rootItem.setChecked(selectedFeatures.contains(feature));
		addFeatures(rootItem, HyFeatureEvolutionUtil.getChildsOfFeature(feature, date));
	
		Button checkSubTrees = new Button(composite, SWT.CHECK);
		checkSubTrees.setText("Include Children");
		checkSubTrees.setSelection(true);
		
		checkSubTrees.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				checkChilds = checkSubTrees.getSelection();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});
		
		return composite;
	}
	
	private void addFeatures(DwFeatureTreeItem parent, List<HyGroup> groups) {
		for(HyGroup group : groups) {
			for(HyFeature feature : HyFeatureEvolutionUtil.getFeaturesOfGroup(group, date)) {
				DwFeatureTreeItem item = new DwFeatureTreeItem(feature, date, parent, SWT.CHECK);
				item.setChecked(selectedFeatures.contains(feature));
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
	
	public List<HyFeature> getSelectedFeatureNames() {
		return selectedFeatures;
	}
	
	private List<HyFeature> getSelectedFeatures(DwFeatureTreeItem item) {
		List<HyFeature> features = new ArrayList<HyFeature>();
		
		if(item.getChecked()) {
			features.add(item.getFeature());
		}
		
		for(TreeItem child : item.getItems()) {
			if(child instanceof DwFeatureTreeItem)
			features.addAll(getSelectedFeatures((DwFeatureTreeItem)child));
		}
		return features;
	}
	
	@Override
	protected Point getInitialSize() {
		return new Point(640, 480);
	}
	
}
