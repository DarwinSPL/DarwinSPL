package eu.hyvar.feature.graphical.editor.dialogs;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

import eu.hyvar.evolution.HyName;
import eu.hyvar.evolution.HyTemporalElement;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyRootFeature;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;

public class TreeDialog extends Dialog implements SelectionListener {
	HyFeatureModelWrapped featureModel;
	DateFormat dateFormat; 
	protected TreeDialog(Shell parentShell, HyFeatureModelWrapped featureModel) {
		super(parentShell);

		this.featureModel = featureModel;
		
		dateFormat = DateFormat.getDateInstance();
	}

	private String[] convertTimestampsFromHyTemporalElement(HyTemporalElement element){
		String since = "";
		String until = "";
		
		if(element.getValidSince() != null){
			since = dateFormat.format(element.getValidSince());
		}
		
		if(element.getValidUntil() != null){
			until = dateFormat.format(element.getValidUntil());
		}
		
		return new String[]{ since, until };
	}
	private String[] concatenteNameWithTimestamps(String name, String[] timestamps){
		String[] columns = new String[]{ name };
		Collection<String> values = new ArrayList<String>();
		values.addAll(Arrays.asList(columns));
		values.addAll(Arrays.asList(timestamps));
		
		Object[] v = values.toArray();
		
		return new String[]{ (String)v[0], (String)v[1], (String)v[2] };
	}
	private String[] getTreeColumnsFromHyName(HyName name){
		return concatenteNameWithTimestamps(name.getName(), convertTimestampsFromHyTemporalElement(name));
	}

	protected void addItem(EObject object){}

	private void buildSubGraph(HyFeature parent, TreeItem parentTreeItem){
		for(HyFeatureChild child : parent.getParentOf()){
			TreeItem childGroup = new TreeItem(parentTreeItem, 0);
			
			childGroup.setText(concatenteNameWithTimestamps("Group", convertTimestampsFromHyTemporalElement((HyTemporalElement)child)));

			// TODO get group type
			HyGroup group = child.getChildGroup();

			for(HyGroupComposition composition : group.getParentOf()){
				for(HyFeature feature : composition.getFeatures()){
					TreeItem groupChildren = new TreeItem(childGroup, SWT.NONE);


					if(feature.getNames().size() > 1){
						groupChildren.setText("Multi Name Feature");
						for(HyName name : feature.getNames()){
							TreeItem nameChildren = new TreeItem(groupChildren, SWT.NONE);
							nameChildren.setText(getTreeColumnsFromHyName(name));

							buildSubGraph(feature, nameChildren);	
						}
					}else{
						groupChildren.setText(feature.getNames().get(0).getName());
						buildSubGraph(feature, groupChildren);	
					}
				}
			}
		}
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		FillLayout layout = new FillLayout();
		layout.marginWidth = 8;
		layout.marginHeight = 8;
		container.setLayout(layout);

		Tree tree = new Tree(container, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		tree.setHeaderVisible(true);
		//tree.setLayoutData(new FillLayout());
		
	    TreeColumn column1 = new TreeColumn(tree, SWT.LEFT);
	    column1.setText("Name");
	    int width  = 100;
	    column1.setWidth(width * 2);
	    TreeColumn column2 = new TreeColumn(tree, SWT.CENTER);
	    column2.setText("Valid Since");
	    column2.setWidth(width);
	    TreeColumn column3 = new TreeColumn(tree, SWT.RIGHT);
	    column3.setText("Valid Until");
	    column3.setWidth(width);
	    

		HyFeatureModel model = featureModel.getModel();
		for(HyRootFeature rootFeature : model.getRootFeature()){
			TreeItem rootItem = new TreeItem(tree, SWT.NONE);
			rootItem.setText("Root Item");
			for(HyName name : rootFeature.getFeature().getNames()){
				TreeItem nameChildren = new TreeItem(rootItem, SWT.NONE);
				nameChildren.setText(getTreeColumnsFromHyName(name));

				buildSubGraph(rootFeature.getFeature(), nameChildren);	
			}
		}
		/*
		    for (int loopIndex0 = 0; loopIndex0 < 10; loopIndex0++) {
		      TreeItem treeItem0 = new TreeItem(tree, 0);
		      treeItem0.setText("Level 0 Item " + loopIndex0);
		      for (int loopIndex1 = 0; loopIndex1 < 10; loopIndex1++) {
		        TreeItem treeItem1 = new TreeItem(treeItem0, 0);
		        treeItem1.setText("Level 1 Item " + loopIndex1);
		        for (int loopIndex2 = 0; loopIndex2 < 10; loopIndex2++) {
		          TreeItem treeItem2 = new TreeItem(treeItem1, 0);
		          treeItem2.setText("Level 2 Item " + loopIndex2);
		        }
		      }
		    }
		 */

		tree.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				if (event.detail == SWT.CHECK) {
					//text.setText(event.item + " was checked.");
				} else {
					//text.setText(event.item + " was selected");
				}
			}
		});

		return container;
	}

	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}

	@Override
	protected void okPressed(){

		super.okPressed();
	}

	@Override
	protected void cancelPressed(){

		super.cancelPressed();
	}


	@Override
	public void widgetSelected(SelectionEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub

	}
}
