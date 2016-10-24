package eu.hyvar.feature.graphical.base.model;

import java.util.Date;
import java.util.HashSet;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;

public class HyGroupWrapped extends HyEditorChangeableElement {
	/*
	 * Group related properties
	 */
	public final static String PROPERTY_CHILD_FEATURES = "PropertyChildFeatures";

	private HyFeatureWrapped parentFeature;
	
	private HashSet<HyFeatureWrapped> features;

	public boolean isAnd(Date date){
		HyGroupType type = HyEvolutionUtil.getValidTemporalElement(getWrappedModelElement().getTypes(), date);
		
		return type.getType() == HyGroupTypeEnum.AND;		
	}

	public boolean isOr(Date date){
		HyGroupType type = HyEvolutionUtil.getValidTemporalElement(getWrappedModelElement().getTypes(), date);
		
		return type.getType() == HyGroupTypeEnum.OR;			
	}

	public boolean isAlternative(Date date){
		HyGroupType type = HyEvolutionUtil.getValidTemporalElement(getWrappedModelElement().getTypes(), date);
		
		return type.getType() == HyGroupTypeEnum.ALTERNATIVE;			
	}

	@Override 
	public HyGroup getWrappedModelElement(){
		return (HyGroup)wrappedModelElement;
	}

	public HyFeatureWrapped getParentFeature() {
		return parentFeature;
	}
	public void setParentFeature(HyFeatureWrapped parentFeature) {
		this.parentFeature = parentFeature;
	}
	public void setFeatures(HashSet<HyFeatureWrapped> features) {
		this.features = features;
	}

	public HyGroupWrapped(EObject wrappedModelElement) {
		super(wrappedModelElement);

		features = new HashSet<HyFeatureWrapped>();
	}

	public EList<HyFeature> getFeatures(Date date){
		if(date == null){
			return this.getWrappedModelElement().getParentOf().get(0).getFeatures();
		}
		
		HyGroupComposition composition = HyEvolutionUtil.getValidTemporalElement(this.getWrappedModelElement().getParentOf(), date);
		return composition.getFeatures();
	}
	public HashSet<HyFeatureWrapped> getFeatures() {
		return features;
	}	

	/**
	 * This function is only needed to display the relation between a group and its features. 
	 * Be aware that the feature will not be added to the model with this function.
	 * @param childFeature
	 */
	public void addChildFeature(HyFeatureWrapped childFeature){
		HyGroupWrapped old = clone();
		HyGroupComposition composition = getWrappedModelElement().getParentOf().get(0);

		childFeature.getWrappedModelElement().getGroupMembership().add(composition);
		childFeature.setParent(this);

		if(features.add(childFeature)){
			listeners.firePropertyChange(PROPERTY_CHILD_FEATURES, old, this);
		}else{
		}
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public HyGroupWrapped clone(){
		HyGroupWrapped deepCopy = new HyGroupWrapped(EcoreUtil.copy(this.getWrappedModelElement()));
		deepCopy.setFeatures(getFeatures());
		deepCopy.setParentFeature(parentFeature);

		return deepCopy;
	}

	public void removeChildFeature(HyFeatureWrapped childFeature, Date date){
		HyGroupWrapped old = clone();

		// delete the feature in the wrapped model and inform the feature model instance about the change
		// this may trigger a group delete and a rerendering if the deleted element was the last one in this group
		if(features.remove(childFeature)){
			HyGroupComposition composition = HyEvolutionUtil.getValidTemporalElement(getWrappedModelElement().getParentOf(), date);
			if(composition != null){
				composition.getFeatures().remove(childFeature.getWrappedModelElement());

				listeners.firePropertyChange(PROPERTY_CHILD_FEATURES, old, this);
			}
		}
	}

	public HyGroup getGroup() {
		if(features.iterator().next().getWrappedModelElement().getGroupMembership().size() == 0){
			System.out.println("HyGroupWrapped.getGruop() :(");
			return null;
		}

		return features.iterator().next().getWrappedModelElement().getGroupMembership().get(0).getCompositionOf();
	}

	/**
	 * Transfers a feature from this group to another. Use this function only to update the internal relationship
	 * from the model. Be aware that this function does not cause a rerender and because of that you won't be able
	 * to see a change in the editor. If you want to update the editor view use instead the function @addChildFeature.
	 * @param wrappedFeature
	 * @param anotherGroup
	 */
	public void transferFeatureToAnotherGroup(HyFeatureWrapped wrappedFeature, HyGroupWrapped anotherGroup){
		anotherGroup.addChildFeature(wrappedFeature);

		HyFeature feature = wrappedFeature.getWrappedModelElement();
		feature.getGroupMembership().clear();

		HyGroup group = anotherGroup.getWrappedModelElement();
		group.getParentOf().get(0).getFeatures().add(feature);

		getWrappedModelElement().getParentOf().get(0).getFeatures().remove(feature);
	}
}
