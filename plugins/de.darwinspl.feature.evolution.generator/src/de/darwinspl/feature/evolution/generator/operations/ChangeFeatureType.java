package de.darwinspl.feature.evolution.generator.operations;

import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.hyvar.evolution.HyEvolutionUtil;
import eu.hyvar.evolution.HyLinearTemporalElement;
import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureType;
import eu.hyvar.feature.HyFeatureTypeEnum;
import eu.hyvar.feature.impl.custom.HyFeatureFactoryWithIds;

public class ChangeFeatureType implements EvolutionOperation {

	protected HyFeature feature;
	protected Date date;
	protected HyFeatureTypeEnum oldType;
	protected HyFeatureTypeEnum newType;

	public ChangeFeatureType(HyFeature feature, HyFeatureTypeEnum newType, Date date) {
		this(feature, date);
		this.newType = newType;
	}
	
	public ChangeFeatureType(HyFeature feature, Date date) {
		this.feature = feature;
		this.date = date;
		this.oldType = HyEvolutionUtil.getValidTemporalElement(feature.getTypes(), date).getType();
		
		if (oldType.equals(HyFeatureTypeEnum.MANDATORY)) {
			newType = HyFeatureTypeEnum.OPTIONAL;
		} else {
			newType = HyFeatureTypeEnum.MANDATORY;
		}
	}

	@Override
	public void applyOperation() throws EvolutionOperationException {
		if(newType.equals(oldType)) {
			return;
		}
		
		HyFeatureType newFeatureType = HyFeatureFactoryWithIds.eINSTANCE.createHyFeatureType();
		newFeatureType.setValidSince((Date)date.clone());
		newFeatureType.setType(newType);

		HyFeatureType oldFeatureType = HyEvolutionUtil.getValidTemporalElement(feature.getTypes(), date);
		oldFeatureType.setValidUntil((Date)date.clone());
		feature.getTypes().add(newFeatureType);

//		newFeatureType.setSupersedingElement(oldFeatureType.getSupersedingElement());
		
		// Check if old group composition can be deleted
		if (oldFeatureType.getValidSince() != null && oldFeatureType.getValidSince().equals(oldFeatureType.getValidUntil())) {
			HyLinearTemporalElement oldSupersededElement = oldFeatureType.getSupersededElement();
			EcoreUtil.delete(oldFeatureType);
			newFeatureType.setSupersededElement(oldSupersededElement);
		} else {
			newFeatureType.setSupersededElement(oldFeatureType);
		}
	}

}
