package eu.hyvar.feature.graphical.editor.commands;

import java.util.Date;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureChild;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.graphical.base.editor.GraphicalFeatureModelEditor;
import eu.hyvar.feature.graphical.base.model.HyFeatureModelEvolutionWrapped;
import eu.hyvar.feature.graphical.base.model.HyFeatureWrapped;
import eu.hyvar.feature.graphical.base.model.HyGroupWrapped;
import eu.hyvar.feature.graphical.base.model.HyParentChildConnection;

public class HyParentChildConnectionEvolutionReconnectCommand extends HyParentChildConnectionReconnectCommand{
	private GraphicalFeatureModelEditor editor;
	public HyParentChildConnectionEvolutionReconnectCommand(GraphicalFeatureModelEditor editor){
		this.editor = editor;
	}

	private HyGroupComposition splitComposition(HyGroupComposition composition, HyFeatureWrapped feature){
		HyFeatureModelEvolutionWrapped featureModel = (HyFeatureModelEvolutionWrapped)this.featureModel;

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

		return newComposition;

	}
	@Override
	public void execute(){
		HyFeatureWrapped oldTarget = connection.getTarget();

		HyFeatureModelEvolutionWrapped featureModel = (HyFeatureModelEvolutionWrapped)this.featureModel;
		Date date = featureModel.getSelectedDate();
		
		if(target instanceof HyFeatureWrapped){

			HyGroupComposition composition = HyEvolutionUtil.getValidTemporalElement(oldTarget.getWrappedModelElement().getGroupMembership(), date);
			splitComposition(composition, oldTarget);


			HyFeatureWrapped newTarget = (HyFeatureWrapped)target;
			HyFeatureChild child = HyEvolutionUtil.getValidTemporalElement(newTarget.getWrappedModelElement().getParentOf(), date);
			HyGroup group = null;
			HyGroupComposition newComposition = null;
			boolean hasComposition = false;


			// new target doesn't have a child, we have to add one
			if(child == null){
				child = HyFeatureFactory.eINSTANCE.createHyFeatureChild();
				group = HyFeatureFactory.eINSTANCE.createHyGroup();
				group.setValidSince(date);

				HyGroupType type = HyFeatureFactory.eINSTANCE.createHyGroupType();
				group.getTypes().add(type);
				child.setParent(newTarget.getWrappedModelElement());
				child.setChildGroup(group);

				HyGroupWrapped groupWrapped = new HyGroupWrapped(group);
				featureModel.addGroup(groupWrapped);

				//featureModel.getModel().getGroups().add(group);
			}else{
				// check if there is a valid composition at selected date
				newComposition = HyEvolutionUtil.getValidTemporalElement(child.getChildGroup().getParentOf(), date);

				if(newComposition != null){ 
					newComposition = splitComposition(newComposition, null);
					hasComposition = true;
				}
			}

			// create a new composition in case there isn't one at selected date
			if(!hasComposition){
				newComposition = HyFeatureFactory.eINSTANCE.createHyGroupComposition();
				newComposition.setValidSince(date);
				newComposition.setCompositionOf(group);
				group.getParentOf().add(newComposition);
			}

			newComposition.getFeatures().add(oldTarget.getWrappedModelElement());


			// Create the connection for editing in editor
			HyParentChildConnection newConnection = connection.clone();
			newConnection.setSource(newTarget);
			newConnection.setTarget(oldTarget);

			newTarget.addParentToChildConnection(newConnection);
			oldTarget.addChildToParentConnection(newConnection);

			oldTarget.getWrappedModelElement().getGroupMembership().add(newComposition);

			editor.getModelWrapped().rearrangeFeatures();
			editor.refreshView();
			editor.setDirty(true);
		}
		else if(target instanceof HyParentChildConnection){
		}
	}
}