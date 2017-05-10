package dw.darwinspl.feature.graphical.editor.commands.feature;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.EditPart;

import dw.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import dw.darwinspl.feature.graphical.base.editparts.DwFeatureEditPart;
import dw.darwinspl.feature.graphical.base.editparts.DwRootFeatureEditPart;
import dw.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import dw.darwinspl.feature.graphical.base.model.DwParentChildConnection;
import dw.darwinspl.feature.graphical.base.util.DwEcoreUtil;
import dw.darwinspl.feature.graphical.editor.commands.DwFeatureModelEditorCommand;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureModel;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;

public class DwFeatureDeletePermanentlyCommand extends DwFeatureModelEditorCommand{
	EditPart host;

	public DwFeatureDeletePermanentlyCommand(DwGraphicalFeatureModelViewer viewer, EditPart host) {
		super(viewer);

		this.host = host;
	}

	private DwFeatureWrapped feature;
	private HyFeature oldFeature;

	private List<HyGroupComposition> groupMemberships = new ArrayList<HyGroupComposition>();
	private List<HyFeatureChild> featureChildren = new ArrayList<HyFeatureChild>();

	private HyGroup group;

	public void setFeature(DwFeatureWrapped feature) {
		this.feature = feature;
	}

	@Override
	public boolean canExecute() {
		if(host instanceof DwRootFeatureEditPart)
			return false;
		if(host instanceof DwFeatureEditPart)
			return true;

		return false;
	}

	private void updateFeatureModel(){
		// delete the selection from the element
		host.setSelected(0);
		
		viewer.getModelWrapped().rearrangeFeatures();
		viewer.refreshView();	
	}
	
	private void redoConnections(){
		for(DwParentChildConnection connection : feature.getParentConnections()){
			connection.getSource().removeParentToChildConnection(connection);
		}
	}
	
	private void undoConnections(){
		for(DwParentChildConnection connection : feature.getParentConnections()){
			connection.getSource().addParentToChildConnection(connection);
		}
	}
		
	
	public void redo(){
		if(!groupMemberships.isEmpty())
			groupMemberships.clear();
		
		group = null;
		
		redoConnections();
		
		HyFeature feature = this.feature.getWrappedModelElement();
		oldFeature = DwEcoreUtil.copy(feature);
		
		HyFeatureModel featureModel = viewer.getInternalFeatureModel();
		featureModel.getFeatures().remove(feature);

		EList<HyGroupComposition> compositions = feature.getGroupMembership();
		for(HyGroupComposition composition : compositions){

			HyGroupComposition backupComposition = DwEcoreUtil.copy(composition);

			EList<HyFeature> features = composition.getFeatures();

			if(features.size() == 1){
				group = DwEcoreUtil.copy(composition.getCompositionOf());
				
				EList<HyFeatureChild> featureChildren = composition.getCompositionOf().getChildOf();
				for(HyFeatureChild featureChild : featureChildren){
					
					HyFeatureChild featureChildBackup = DwEcoreUtil.copy(featureChild);
					this.featureChildren.add(featureChildBackup);

					HyFeature parent = DwEcoreUtil.copy(featureChild.getParent());

					featureChildBackup.setParent(parent);
					featureChildBackup.setChildGroup(this.group);
					this.group.getChildOf().add(featureChildBackup);
					
					featureChild.getParent().getParentOf().remove(featureChild);
				}

				featureModel.getGroups().remove(composition.getCompositionOf());
				

			}else{
				this.group = DwEcoreUtil.copy(composition.getCompositionOf());
			}
			
			// delete all parent elements of the group
			if(this.group != null)
				this.group.getParentOf().clear();
			
			backupComposition.setCompositionOf(this.group);			
			groupMemberships.add(backupComposition);
		}
		
		feature.getGroupMembership().clear();

		for(HyGroupComposition composition : groupMemberships){
			composition.getFeatures().add(oldFeature);
		}
		
		// remove feature and update feature model view
		viewer.getModelWrapped().removeFeature(this.feature);
		
		updateFeatureModel();
	}

	public void undo(){
		HyFeatureModel featureModel = viewer.getInternalFeatureModel();
		
		undoConnections();

		viewer.getModelWrapped().addFeature(feature);
		
		for(HyGroupComposition groupMembership : groupMemberships){			
			HyGroup group = groupMembership.getCompositionOf();

			boolean exist = false;
			// add group if group was also deleted
			for(HyGroup modelGroup : featureModel.getGroups()){
				if(modelGroup.getId().equals(group.getId())){
					exist = true;
					
					for(HyGroupComposition composition : group.getParentOf()){
						for(HyGroupComposition modelComposition : modelGroup.getParentOf()){
							if(modelComposition.getId().equals(composition.getId())){
								modelComposition.getFeatures().addAll(composition.getFeatures());
							}
						}
						//modelGroup.getParentOf().add(composition);
					}
				}
			}
			
			if(!exist)
				featureModel.getGroups().add(group);

			for(HyFeatureChild child : group.getChildOf()){
				
				if(child.getParent() == null){
					System.out.println("Parent === "+child.getParent());
				}
				
				EList<HyFeature> features = featureModel.getFeatures();
				for(HyFeature f : features){
					if(f.getId().equals(child.getParent().getId()))
						features.get(features.indexOf(f)).getParentOf().add(child);
				}
			}
		}

		feature.setWrappedModelElement(oldFeature);
		
		
		
		updateFeatureModel();
	}

	@Override
	public void execute(){
		redo();
	}
}
