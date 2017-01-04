package eu.hyvar.feature.graphical.editor.commands;


import java.util.Date;

import org.eclipse.gef.commands.Command;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;
import eu.hyvar.feature.graphical.base.editor.HyGraphicalFeatureModelViewer;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyGroupWrapped;
import eu.hyvar.feature.graphical.base.model.HyParentChildConnection;
import eu.hyvar.feature.graphical.editor.util.HyElementEditorUtil;

public class HyParentChildConnectionReconnectCommand extends Command{
	private HyFeatureWrapped source;
	private Object target;
	private HyParentChildConnection connection;
	private HyFeatureModelWrapped featureModel;

	private HyGraphicalFeatureModelViewer editor;
	public HyParentChildConnectionReconnectCommand(HyGraphicalFeatureModelViewer editor){
		this.editor = editor;
	}


	public HyFeatureModelWrapped getFeatureModel() {
		return featureModel;
	}

	public void setFeatureModel(HyFeatureModelWrapped featureModel) {
		this.featureModel = featureModel;
	}

	@Override 
	public boolean canExecute(){
		return source != null && target != null && connection != null;
	}

	public void setSource(HyFeatureWrapped source) {
		this.source = source;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public void setConnection(HyParentChildConnection connection) {
		this.connection = connection;
	}	



	private void removeUnlogicalComposition(HyGroupComposition composition){
		if(composition.getValidSince() != null && 
				composition.getValidUntil() != null &&
				composition.getValidSince().equals(composition.getValidUntil())){

			composition.getFeatures().clear();

			composition.getCompositionOf().getParentOf().remove(composition);
		}		
	}

	private HyGroupComposition splitComposition(HyGroupComposition composition, HyFeatureWrapped feature){
		Date date = featureModel.getSelectedDate();


		HyGroup group = composition.getCompositionOf();

		// copy the composition in order to replace the old composition since selected date
		HyGroupComposition newComposition = HyFeatureFactory.eINSTANCE.createHyGroupComposition();
		newComposition.setCompositionOf(composition.getCompositionOf());
		newComposition.setSupersededElement(composition.getSupersededElement());
		newComposition.setSupersedingElement(composition.getSupersedingElement());


		// update validation of old composition (until) and new composition (since) selected date
		composition.setValidUntil(date);
		newComposition.setValidSince(date);

		for(HyFeature f : composition.getFeatures()){
			if(feature != null){
				if(!f.equals(feature.getWrappedModelElement())){
					newComposition.getFeatures().add(f);
					f.getGroupMembership().add(newComposition);
				}
			}else{
				newComposition.getFeatures().add(f);
				f.getGroupMembership().add(newComposition);
			}			
		}

		group.getParentOf().add(newComposition);

		removeUnlogicalComposition(composition);

		return newComposition;

	}

	private void addConnection(HyFeatureWrapped source, HyFeatureWrapped target){
		// Create the connection for editing in editor
		HyParentChildConnection newConnection = connection.clone();
		newConnection.setSource(source);
		newConnection.setTarget(target);

		source.addParentToChildConnection(newConnection);
		target.addChildToParentConnection(newConnection);		
	}

	protected void splitGroupType(HyGroup group){
		Date date = featureModel.getSelectedDate();

		HyGroupType type = HyEvolutionUtil.getValidTemporalElement(group.getTypes(), date);
		HyGroupType newType = HyFeatureFactory.eINSTANCE.createHyGroupType();
		newType.setValidSince(date);
		newType.setType(HyGroupTypeEnum.AND);
		type.setValidUntil(date);

		if(type.getValidSince() != null &&
				type.getValidUntil() != null &&
				type.getValidSince().equals(type.getValidUntil())){
			group.getTypes().remove(type);
		}

		group.getTypes().add(newType);
	}


	@Override
	public void execute(){
		HyFeatureWrapped oldTarget = connection.getTarget();
		Date date = featureModel.getSelectedDate();
		if(date == new Date(Long.MIN_VALUE))
			date = null;


		if(target instanceof HyFeatureWrapped){

			HyGroupComposition composition = HyEvolutionUtil.getValidTemporalElement(oldTarget.getWrappedModelElement().getGroupMembership(), date);

			if(date != null && !date.equals(new Date(Long.MIN_VALUE)))
				composition = splitComposition(composition, oldTarget);
			else{
				composition.getFeatures().remove(oldTarget.getWrappedModelElement());
			}
			
			connection.getSource().removeParentToChildConnection(connection);
			connection.getTarget().removeChildToParentConnection(connection);
			
			

			if(composition.getCompositionOf() != null){
				HyElementEditorUtil.cleanGroupCompositions(composition.getCompositionOf());
			}

			HyFeatureWrapped newTarget = (HyFeatureWrapped)target;
			HyFeatureChild child = HyEvolutionUtil.getValidTemporalElement(newTarget.getWrappedModelElement().getParentOf(), date);
			HyGroup group = null;
			HyGroupComposition newComposition = null;
			boolean hasComposition = false;


			// new target doesn't have a child, we have to add one
			if(child == null){
				child = HyFeatureFactory.eINSTANCE.createHyFeatureChild();
				group = HyFeatureFactory.eINSTANCE.createHyGroup();

				if(!date.equals(new Date(Long.MIN_VALUE)))
					group.setValidSince(date);

				HyGroupType type = HyFeatureFactory.eINSTANCE.createHyGroupType();
				group.getTypes().add(type);
				child.setParent(newTarget.getWrappedModelElement());
				child.setChildGroup(group);

				HyGroupWrapped groupWrapped = new HyGroupWrapped(group);
				featureModel.addGroup(groupWrapped);				
			}else{
				// check if there is a valid composition at selected date
				newComposition = HyEvolutionUtil.getValidTemporalElement(child.getChildGroup().getParentOf(), date);

				if(newComposition != null){ 
					newComposition = splitComposition(newComposition, null);

					if(HyEvolutionUtil.getValidTemporalElements(newComposition.getFeatures(), date).size() == 1 &&
							HyEvolutionUtil.getValidTemporalElement(newComposition.getCompositionOf().getTypes(), date).getType() != HyGroupTypeEnum.AND){
						splitGroupType(newComposition.getCompositionOf());
					}
					hasComposition = true;
				}
			}

			// create a new composition in case there isn't one at selected date
			if(!hasComposition){
				newComposition = HyFeatureFactory.eINSTANCE.createHyGroupComposition();

				if(!date.equals(new Date(Long.MIN_VALUE)))
					newComposition.setValidSince(date);

				newComposition.setCompositionOf(group);
				group.getParentOf().add(newComposition);
			}

			newComposition.getFeatures().add(oldTarget.getWrappedModelElement());


			addConnection(newTarget, oldTarget);

			oldTarget.getWrappedModelElement().getGroupMembership().add(newComposition);



		}
		else if(target instanceof HyParentChildConnection){			
			HyParentChildConnection connection = (HyParentChildConnection)target;

			HyFeatureWrapped tempTargetFeature = connection.getTarget();
			HyGroupComposition composition = HyEvolutionUtil.getValidTemporalElement(tempTargetFeature.getWrappedModelElement().getGroupMembership(), date);

			HyGroupComposition oldComposition = HyEvolutionUtil.getValidTemporalElement(oldTarget.getWrappedModelElement().getGroupMembership(), date);
			oldComposition.getFeatures().remove(oldTarget.getWrappedModelElement());
			oldTarget.getWrappedModelElement().getGroupMembership().remove(oldComposition);

			// old composition is empty and has to be removed
			if(oldComposition.getFeatures().isEmpty()){
				HyGroup oldGroup = oldComposition.getCompositionOf();

				oldGroup.getParentOf().remove(oldComposition);

				// old group has no composition and has to be removed
				if(oldGroup.getParentOf().isEmpty()){
					for(HyFeatureChild oldChild : oldGroup.getChildOf()){
						oldChild.getParent().getParentOf().remove(oldChild);
					}
				}

				// remove the old group from the model
				editor.getModelWrapped().getModel().getGroups().remove(oldGroup);
			}



			addConnection(connection.getSource(), oldTarget);

			HyGroupWrapped wrappedGroup = editor.getModelWrapped().getWrappedGroup(composition.getCompositionOf());
			wrappedGroup.addChildFeature(oldTarget);
			
		}


		editor.getModelWrapped().rearrangeFeatures();
		editor.refreshView();
	}
}
