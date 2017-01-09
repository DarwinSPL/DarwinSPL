package de.darwinspl.feature.evolution.generator.operations;

import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.HyGroupComposition;

public class ChangeFeatureType implements EvolutionOperation {

	protected HyFeature feature;
	protected Date date;
	protected HyFeatureTypeEnum oldType;

	public ChangeFeatureType(HyFeature feature, Date date) {
		this.feature = feature;
		this.date = date;
		this.oldType = HyEvolutionUtil.getValidTemporalElement(feature.getTypes(), date).getType();
	}

	@Override
	public void applyOperation() throws EvolutionOperationException {
		HyFeatureType newFeatureType = HyFeatureFactory.eINSTANCE.createHyFeatureType();
		newFeatureType.setValidSince(date);

		if (oldType.equals(HyFeatureTypeEnum.MANDATORY)) {
			newFeatureType.setType(HyFeatureTypeEnum.OPTIONAL);
		} else {
			newFeatureType.setType(HyFeatureTypeEnum.MANDATORY);
		}

		HyFeatureType oldFeatureType = HyEvolutionUtil.getValidTemporalElement(feature.getTypes(), date);
		oldFeatureType.setValidUntil(date);

		newFeatureType.setSupersedingElement(oldFeatureType.getSupersedingElement());
		
		// Check if old group composition can be deleted
		if (oldFeatureType.getValidSince().equals(oldFeatureType.getValidUntil())) {
			HyGroupComposition oldSupersededElement = (HyGroupComposition) oldFeatureType.getSupersededElement();
			EcoreUtil.delete(oldFeatureType);
			newFeatureType.setSupersededElement(oldSupersededElement);
		} else {
			newFeatureType.setSupersededElement(oldFeatureType);
		}
	}

}
