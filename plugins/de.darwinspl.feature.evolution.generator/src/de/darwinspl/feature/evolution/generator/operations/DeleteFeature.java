package de.darwinspl.feature.evolution.generator.operations;

import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.evolution.HyLinearTemporalElement;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyGroupComposition;

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
			throw new EvolutionOperationException();
		}

		feature.setValidUntil((Date) date.clone());
		HyEvolutionUtil.getValidTemporalElement(feature.getNames(), date).setValidUntil((Date) date.clone());
		HyEvolutionUtil.getValidTemporalElement(feature.getTypes(), date).setValidUntil((Date) date.clone());

		// Remove feature from its old group

		HyGroupComposition oldGroupComposition = HyEvolutionUtil.getValidTemporalElement(feature.getGroupMembership(),
				date);
		Date oldValidUntilOfGroup = oldGroupComposition.getValidUntil();
		oldGroupComposition.setValidUntil(date);
		
		// if feature was the only one in the group, group can be invalidated and operation is finished.
		if(oldGroupComposition.getFeatures().size() == 1) {
			oldGroupComposition.getCompositionOf().setValidUntil(date);
			return;
		}
		

		HyGroupComposition newGroupComposition = HyFeatureFactory.eINSTANCE.createHyGroupComposition();
		newGroupComposition.setValidSince(date);
		newGroupComposition.setValidUntil(oldValidUntilOfGroup);

		for (HyFeature groupFeature : oldGroupComposition.getFeatures()) {
			if (groupFeature != feature) {
				newGroupComposition.getFeatures().add(groupFeature);
			}
		}

		newGroupComposition.setCompositionOf(oldGroupComposition.getCompositionOf());

		// Repair superseding relation. I hope this is the right direction.
		if (oldGroupComposition.getValidSince().equals(oldGroupComposition.getValidUntil())) {
			HyLinearTemporalElement oldSupersededElement = oldGroupComposition.getSupersededElement();
			EcoreUtil.delete(oldGroupComposition);
			newGroupComposition.setSupersededElement(oldSupersededElement);
		} else {
			newGroupComposition.setSupersededElement(oldGroupComposition);
		}
	}

}
