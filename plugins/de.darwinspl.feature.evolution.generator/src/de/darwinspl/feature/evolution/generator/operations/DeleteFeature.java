package de.darwinspl.feature.evolution.generator.operations;

import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.evolution.HyLinearTemporalElement;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyGroup;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.impl.custom.HyFeatureFactoryWithIds;

public class DeleteFeature implements EvolutionOperation {

	protected HyFeature feature;
	protected Date date;

	public DeleteFeature(HyFeature feature, Date date) {
		this.feature = feature;
		this.date = date;
	}

	@Override
	public void applyOperation() throws EvolutionOperationException {
		if (!HyEvolutionUtil.isValid(feature, date)) {
			throw new EvolutionOperationException("Feature to delete was not valid");
		}

		feature.setValidUntil((Date) date.clone());
		HyEvolutionUtil.getValidTemporalElement(feature.getNames(), date).setValidUntil((Date) date.clone());
		HyEvolutionUtil.getValidTemporalElement(feature.getTypes(), date).setValidUntil((Date) date.clone());

		// Remove feature from its old group

		HyGroupComposition oldGroupComposition = HyEvolutionUtil.getValidTemporalElement(feature.getGroupMembership(),date);
//		Date oldValidUntilOfGroup = oldGroupComposition.getValidUntil();
		oldGroupComposition.setValidUntil((Date)date.clone());
		
		// if feature was the only one in the group, group can be invalidated and operation is finished.
		HyGroup group = oldGroupComposition.getCompositionOf();
		
		if(oldGroupComposition.getFeatures().size() == 1) {
			group.setValidUntil((Date)date.clone());
			HyEvolutionUtil.getValidTemporalElement(group.getChildOf(), date).setValidUntil((Date)date.clone());
			return;
		}
		

		HyGroupComposition newGroupComposition = HyFeatureFactoryWithIds.eINSTANCE.createHyGroupComposition();
		newGroupComposition.setValidSince((Date)date.clone());
//		newGroupComposition.setValidUntil(oldValidUntilOfGroup);

		newGroupComposition.getFeatures().addAll(oldGroupComposition.getFeatures());
		newGroupComposition.getFeatures().remove(feature);

		newGroupComposition.setCompositionOf(group);

		// Repair superseding relation. I hope this is the right direction.
		if (oldGroupComposition.getValidSince() != null && oldGroupComposition.getValidSince().equals(oldGroupComposition.getValidUntil())) {
			HyLinearTemporalElement oldSupersededElement = oldGroupComposition.getSupersededElement();
			EcoreUtil.delete(oldGroupComposition);
			newGroupComposition.setSupersededElement(oldSupersededElement);
		} else {
			newGroupComposition.setSupersededElement(oldGroupComposition);
		}
	}

}
