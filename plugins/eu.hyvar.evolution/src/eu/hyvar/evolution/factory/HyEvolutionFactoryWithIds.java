package eu.hyvar.evolution.factory;

import eu.hyvar.evolution.HyName;
import eu.hyvar.evolution.impl.HyEvolutionFactoryImpl;

public class HyEvolutionFactoryWithIds extends HyEvolutionFactoryImpl {

	@Override
	public HyName createHyName() {
		HyName newName = super.createHyName();
		newName.createId();
		return newName;
	}
	
}
