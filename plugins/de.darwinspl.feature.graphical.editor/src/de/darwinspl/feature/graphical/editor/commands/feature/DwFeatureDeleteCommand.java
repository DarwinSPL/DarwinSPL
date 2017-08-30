package de.darwinspl.feature.graphical.editor.commands.feature;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.EditPart;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwFeatureEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwRootFeatureEditPart;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.base.model.DwParentChildConnection;
import de.darwinspl.feature.graphical.editor.util.DwEcoreUtil;
import eu.hyvar.evolution.HyTemporalElement;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;

public class DwFeatureDeleteCommand extends DwAbstractFeatureDeleteCommand{

	DwParentChildConnection backupConnection;
	DwParentChildConnection connection;
	public DwFeatureDeleteCommand(DwGraphicalFeatureModelViewer viewer, EditPart host) {
		super(viewer);

		this.host = host;
	}


	public void setFeature(DwFeatureWrapped feature) {
		this.feature = feature;
	}

	private void restrictHyLinearTemporalElementsToParentValidUntil(EList<HyTemporalElement> elements){
		Date date = viewer.getCurrentSelectedDate();
		for(HyTemporalElement element : elements){
			if(element.getValidUntil() == null || element.getValidUntil().after(date)){
				element.setValidUntil(date);
			}
		}			
	}
	private void undoRestrictHyLinearTemporalElementsToParentValidUntil(EList<HyTemporalElement> elements, EList<HyTemporalElement> oldElements){
		for(HyTemporalElement element : elements){
			for(HyTemporalElement oldElement : oldElements){
				if(element.getId().equals(oldElement.getId())){
					element.setValidUntil(oldElement.getValidUntil());
				}
			}

		}
	}

	@Override
	public boolean canExecute() {
		if(!viewer.isLastDateSelected())
			return false;
		
		if(host instanceof DwRootFeatureEditPart)
			return false;
		if(host instanceof DwFeatureEditPart) {
			return feature.getChildrenConnections(viewer.getCurrentSelectedDate()).isEmpty();
		}
			

		return false;
	}


	@SuppressWarnings("unchecked")
	public void redo(){

		HyFeature feature = this.feature.getWrappedModelElement();
		executionDate = viewer.getCurrentSelectedDate();



		backupFeature = DwEcoreUtil.copy(feature);
		oldParent = this.feature.getParentFeature(executionDate);

		feature.setValidUntil(executionDate);

		// restrict feature parameters to the date
		restrictHyLinearTemporalElementsToParentValidUntil((EList<HyTemporalElement>)(EList<?>)feature.getNames());
		restrictHyLinearTemporalElementsToParentValidUntil((EList<HyTemporalElement>)(EList<?>)feature.getAttributes());
		restrictHyLinearTemporalElementsToParentValidUntil((EList<HyTemporalElement>)(EList<?>)feature.getVersions());


		// backup connection 
		connection = this.feature.getParentConnections(executionDate).get(0);
		backupConnection = DwEcoreUtil.copy(connection);		
		connection.setValidUntil(executionDate);

		viewer.getModelWrapped().removeFeature(this.feature, executionDate);

		// delete the selection from the element
		host.setSelected(0);

		viewer.getModelWrapped().rearrangeFeatures();
		viewer.refreshView();

	}

	@SuppressWarnings("unchecked")
	public void undo(){
		HyFeature realFeature = getRealModelFeature(backupFeature);
		realFeature.setValidSince(backupFeature.getValidSince());
		realFeature.setValidUntil(backupFeature.getValidUntil());
		
		// undo restrictions of children
		undoRestrictHyLinearTemporalElementsToParentValidUntil((EList<HyTemporalElement>)(EList<?>)realFeature.getNames(), 
				(EList<HyTemporalElement>)(EList<?>)backupFeature.getNames());
		undoRestrictHyLinearTemporalElementsToParentValidUntil((EList<HyTemporalElement>)(EList<?>)realFeature.getAttributes(), 
				(EList<HyTemporalElement>)(EList<?>)backupFeature.getAttributes());
		undoRestrictHyLinearTemporalElementsToParentValidUntil((EList<HyTemporalElement>)(EList<?>)realFeature.getVersions(), 
				(EList<HyTemporalElement>)(EList<?>)backupFeature.getVersions());
		
		List<HyGroupComposition> compositionToBeDeleted = new ArrayList<>();
		for(HyGroupComposition composition : realFeature.getGroupMembership()) {
			boolean exist = false;
			for(HyGroupComposition backupComposition : backupFeature.getGroupMembership()) {
				
				if(composition.getId().equals(backupComposition.getId())){
					exist = true;
					
					HyGroup group = composition.getCompositionOf();
					HyGroup backupGroup = backupComposition.getCompositionOf();
					
					if(group.getId().equals(backupGroup.getId())){
						List<HyGroupType> groupTypesToBeDeleted = new ArrayList<>();
						for(HyGroupType groupType : group.getTypes()) {
							boolean groupTypeExist = false;
							
							for(HyGroupType backupGroupType : backupGroup.getTypes()) {
								if(groupType.getId().equals(backupGroupType.getId())) {
									groupTypeExist = true;
									groupType.setType(backupGroupType.getType());
									groupType.setValidSince(backupGroupType.getValidSince());
									groupType.setValidUntil(backupGroupType.getValidUntil());
									groupType.setSupersedingElement(backupGroupType.getSupersedingElement());
									groupType.setSupersededElement(backupGroupType.getSupersededElement());
								}
							}
							
							if(!groupTypeExist)
								groupTypesToBeDeleted.add(groupType);
						}
						
						group.getTypes().removeAll(groupTypesToBeDeleted);
						
						List<HyGroupComposition> compositionToBeDeletedFromGroup = new ArrayList<>();
						for(HyGroupComposition groupComposition : composition.getCompositionOf().getParentOf()) {
							boolean groupCompositionExist = false;
							
							for(HyGroupComposition backupGroupComposition : backupComposition.getCompositionOf().getParentOf()) {
								if(groupComposition.getId().equals(backupGroupComposition.getId())) {
									groupCompositionExist = true;		
								}
														
							}
							
							if(!groupCompositionExist) {
								compositionToBeDeletedFromGroup.add(groupComposition);
								groupComposition.getFeatures().clear();
							}
						}
						composition.getCompositionOf().getParentOf().removeAll(compositionToBeDeletedFromGroup);
					}
					
					composition.setValidSince(backupComposition.getValidSince());
					composition.setValidUntil(backupComposition.getValidUntil());
					composition.setSupersedingElement(backupComposition.getSupersedingElement());
					
					List<HyFeatureChild> childToBeDeleted = new ArrayList<>();					
					for(HyFeatureChild child : composition.getCompositionOf().getChildOf()) {
						boolean childExist = false;
						for(HyFeatureChild backupChild : backupComposition.getCompositionOf().getChildOf()) {
							if(child.getId().equals(backupChild.getId())) {
								childExist = true;
								
								child.setValidSince(backupChild.getValidSince());
								child.setValidUntil(backupChild.getValidUntil());
							}
						}	
						
						if(!childExist) {
							childToBeDeleted.add(child);
						}
					}

					composition.getCompositionOf().getChildOf().removeAll(childToBeDeleted);
				}
			}
			
			if(!exist) {
				compositionToBeDeleted.add(composition);
			}
		}
		
		realFeature.getGroupMembership().removeAll(compositionToBeDeleted);
		
		connection.setValidUntil(backupConnection.getValidUntil());
		
		viewer.refreshView();	
	}

	@Override
	public void execute(){
		redo();
	}
	
	
}
