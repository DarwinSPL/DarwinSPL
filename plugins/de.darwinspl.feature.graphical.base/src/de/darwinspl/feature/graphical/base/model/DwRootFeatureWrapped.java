package de.darwinspl.feature.graphical.base.model;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyGroupComposition;
import eu.hyvar.feature.HyGroupType;
import eu.hyvar.feature.HyGroupTypeEnum;

public class DwRootFeatureWrapped extends DwFeatureWrapped {

	public DwRootFeatureWrapped(EObject wrappedModelElement, DwFeatureModelWrapped featureModel) {
		super(wrappedModelElement, featureModel);
	}

	/*
	@Override
	public boolean isWithoutModifier(Date date){
		return true;
	}
	*/
	
	public boolean hasModfierAtDate(Date date){
		return false;
	}
}
