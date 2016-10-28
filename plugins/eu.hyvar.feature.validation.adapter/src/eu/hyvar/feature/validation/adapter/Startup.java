package eu.hyvar.feature.validation.adapter;

import org.eclipse.emf.ecore.EValidator;
import org.eclipse.ui.IStartup;

import eu.hyvar.evolution.HyEvolutionPackage;
import eu.hyvar.feature.HyFeaturePackage;


public class Startup implements IStartup {

	@Override
	public void earlyStartup() {
		EValidatorAdapter adapter = new EValidatorAdapter();
		
		EValidator.Registry.INSTANCE.put(
				HyEvolutionPackage.eINSTANCE,
				adapter);
		
		EValidator.Registry.INSTANCE.put(
				HyFeaturePackage.eINSTANCE,
				adapter);
	}

}
