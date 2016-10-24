package eu.hyvar.feature.mapping.factory;

import eu.hyvar.feature.mapping.HyMapping;
import eu.hyvar.feature.mapping.impl.MappingFactoryImpl;

public class MappingFactoryWithIds extends MappingFactoryImpl {

	@Override
	public HyMapping createHyMapping() {
		HyMapping hyMapping = super.createHyMapping();
		hyMapping.createId();
		return hyMapping;
	}
	
}
