package de.darwinspl.solver.exception;

import java.util.Date;

import eu.hyvar.evolution.util.HyEvolutionUtil;
import eu.hyvar.feature.HyFeature;

public class DwAttributeValueOfSelectedFeatureNotSetException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6166804026845685454L;
	
	private static final String DEFAULT_MESSAGE = "There exists a selected feature in the configuration with attributes not having a value assigned."; 

	public DwAttributeValueOfSelectedFeatureNotSetException() {
		super(DEFAULT_MESSAGE);
	}
	
	public DwAttributeValueOfSelectedFeatureNotSetException(HyFeature feature, Date date) {
		super("Feature "+HyEvolutionUtil.getValidTemporalElement(feature.getNames(), date).getName()+" is selected in a configuration with attributes not having a value assigned.");
	}
}
