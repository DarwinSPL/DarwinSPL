package de.darwinspl.feature.graphical.editor.commands.feature;

import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.EditPart;

import de.darwinspl.feature.graphical.base.editor.DwGraphicalFeatureModelViewer;
import de.darwinspl.feature.graphical.base.editparts.DwFeatureEditPart;
import de.darwinspl.feature.graphical.base.editparts.DwRootFeatureEditPart;
import de.darwinspl.feature.graphical.base.model.DwFeatureModelWrapped;
import de.darwinspl.feature.graphical.base.model.DwFeatureWrapped;
import de.darwinspl.feature.graphical.base.model.DwParentChildConnection;
import de.darwinspl.feature.graphical.editor.util.DwEcoreUtil;
import eu.hyvar.evolution.HyTemporalElement;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyGroupComposition;

public class DwFeatureDeleteCommand extends DwAbstractFeatureDeleteCommand{

	DwParentChildConnection oldConnection;
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
		if(host instanceof DwRootFeatureEditPart)
			return false;
		if(host instanceof DwFeatureEditPart)
			return true;

		return false;
	}


	@SuppressWarnings("unchecked")
	public void redo(){

		HyFeature feature = this.feature.getWrappedModelElement();
		executionDate = viewer.getCurrentSelectedDate();



		oldFeature = DwEcoreUtil.copy(feature);
		oldParent = this.feature.getParentFeature(executionDate);

		feature.setValidUntil(executionDate);

		// restrict feature parameters to the date
		restrictHyLinearTemporalElementsToParentValidUntil((EList<HyTemporalElement>)(EList<?>)feature.getNames());
		restrictHyLinearTemporalElementsToParentValidUntil((EList<HyTemporalElement>)(EList<?>)feature.getAttributes());
		restrictHyLinearTemporalElementsToParentValidUntil((EList<HyTemporalElement>)(EList<?>)feature.getVersions());



		viewer.getModelWrapped().removeFeature(this.feature, executionDate);

		// remove or hide connection 
		DwParentChildConnection connection = this.feature.getParentConnections(executionDate).get(0);
		oldConnection = DwEcoreUtil.copy(connection);
		viewer.getModelWrapped().removeConnection(connection, executionDate);


		// delete the selection from the element
		host.setSelected(0);

		viewer.getModelWrapped().rearrangeFeatures();
		viewer.refreshView();

	}

	public void undo(){
		DwFeatureModelWrapped featureModel = viewer.getModelWrapped();

		HyFeature realFeature = getRealModelFeature(oldFeature);
		realFeature.setValidSince(oldFeature.getValidSince());
		realFeature.setValidUntil(oldFeature.getValidUntil());

		// undo restrictions of children
		undoRestrictHyLinearTemporalElementsToParentValidUntil((EList<HyTemporalElement>)(EList<?>)realFeature.getNames(), 
				(EList<HyTemporalElement>)(EList<?>)oldFeature.getNames());
		undoRestrictHyLinearTemporalElementsToParentValidUntil((EList<HyTemporalElement>)(EList<?>)realFeature.getAttributes(), 
				(EList<HyTemporalElement>)(EList<?>)oldFeature.getAttributes());
		undoRestrictHyLinearTemporalElementsToParentValidUntil((EList<HyTemporalElement>)(EList<?>)realFeature.getVersions(), 
				(EList<HyTemporalElement>)(EList<?>)oldFeature.getVersions());

		// remove the splitted composition from the feature model
		for(HyGroupComposition composition : realFeature.getGroupMembership()){
			// the last composition where the feature is part of
			if(composition.getValidUntil().equals(executionDate)){
				composition.getCompositionOf().getParentOf().remove(composition.getSupersedingElement());

				HyGroupComposition newAddedComposition = (HyGroupComposition)composition.getSupersedingElement();
				newAddedComposition.getFeatures().clear();

				composition.setValidUntil(null);
				composition.getFeatures().add(realFeature);

				composition.setSupersedingElement(null);
			}
		}

		// remove or hide connection 
		for(DwParentChildConnection connection : feature.getParentConnections()) {
			if(connection.getId().equals(oldConnection.getId())) {
				connection.setValidUntil(oldConnection.getValidUntil());
			}
		}

		featureModel.rearrangeFeatures();
		viewer.refreshView();	
	}

	@Override
	public void execute(){
		redo();
	}
}
