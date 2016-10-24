package eu.hyvar.evolution.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

import eu.hyvar.evolution.HyTemporalElement;

public class HyEvolutionCopier extends Copier {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2768630467062636219L;

	
	@Override
    public EObject copy(EObject eObject) {
		EObject copiedObject = super.copy(eObject);
		
		if(eObject instanceof HyTemporalElement) {
			HyTemporalElement copiedElement = (HyTemporalElement) copiedObject;
			HyTemporalElement element = (HyTemporalElement) eObject;
			copiedElement.setId(element.getId());
		}
		
		return copiedObject;
	}
}
