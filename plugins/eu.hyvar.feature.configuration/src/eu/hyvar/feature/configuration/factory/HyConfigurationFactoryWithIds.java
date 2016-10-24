package eu.hyvar.feature.configuration.factory;

import eu.hyvar.feature.configuration.HyAttributeValueAssignment;
import eu.hyvar.feature.configuration.HyConfiguration;
import eu.hyvar.feature.configuration.HyFeatureDeselected;
import eu.hyvar.feature.configuration.HyFeatureSelected;
import eu.hyvar.feature.configuration.HyVersionDeselected;
import eu.hyvar.feature.configuration.HyVersionSelected;
import eu.hyvar.feature.configuration.impl.HyAttributeValueAssignmentImpl;
import eu.hyvar.feature.configuration.impl.HyConfigurationFactoryImpl;
import eu.hyvar.feature.configuration.impl.HyConfigurationImpl;
import eu.hyvar.feature.configuration.impl.HyFeatureDeselectedImpl;
import eu.hyvar.feature.configuration.impl.HyFeatureSelectedImpl;
import eu.hyvar.feature.configuration.impl.HyVersionDeselectedImpl;
import eu.hyvar.feature.configuration.impl.HyVersionSelectedImpl;

public class HyConfigurationFactoryWithIds extends HyConfigurationFactoryImpl {

	@Override
	public HyAttributeValueAssignment createHyAttributeValueAssignment() {
		HyAttributeValueAssignment hyAttributeValueAssignment = super.createHyAttributeValueAssignment();
		hyAttributeValueAssignment.createId();
		return hyAttributeValueAssignment;
	}
	
	@Override
	public HyConfiguration createHyConfiguration() {
		HyConfiguration hyConfiguration = super.createHyConfiguration();
		hyConfiguration.createId();
		return hyConfiguration;
	}
	
	@Override
	public HyFeatureDeselected createHyFeatureDeselected() {
		HyFeatureDeselected hyFeatureDeselected = super.createHyFeatureDeselected();
		hyFeatureDeselected.createId();
		return hyFeatureDeselected;
	}
	
	@Override
	public HyFeatureSelected createHyFeatureSelected() {
		HyFeatureSelected hyFeatureSelected = super.createHyFeatureSelected();
		hyFeatureSelected.createId();
		return hyFeatureSelected;
	}
	
	@Override
	public HyVersionDeselected createHyVersionDeselected() {
		HyVersionDeselected hyVersionDeselected = super.createHyVersionDeselected();
		hyVersionDeselected.createId();
		return hyVersionDeselected;
	}
	
	@Override
	public HyVersionSelected createHyVersionSelected() {
		HyVersionSelected hyVersionSelected = super.createHyVersionSelected();
		hyVersionSelected.createId();
		return hyVersionSelected;
	}
}
